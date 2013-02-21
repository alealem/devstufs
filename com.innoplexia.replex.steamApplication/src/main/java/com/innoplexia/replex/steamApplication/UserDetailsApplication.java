/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innoplexia.replex.steamApplication;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.innoplexia.replex.steamCrawler.SteamDataCollector;
import com.innoplexia.replex.steamCrawler.exceptions.RegExNotMatchedException;
import com.innoplexia.replex.steamDataAccess.DataAccessUtil;
import com.innoplexia.replex.steamDataAccess.HibernateDAOFactory;
import com.innoplexia.replex.steamDataAccess.UserDAO;
import com.innoplexia.replex.steamDataAccess.UserHibernate;
import com.innoplexia.toolkits.ixDataAccess.DAO;

/**
 * @author Lealem
 */
public class UserDetailsApplication implements Runnable
{
	private static final Logger			logger					= Logger.getLogger(UserDetailsApplication.class);
	private static Object				lock					= new Object();

	public static final long			USER_UPDATE_INTERVAL	= TimeUnit.HOURS.toMillis(23);

	private final String				crawlerName;

	private final UserDAO				userDAO;

	private final SteamDataCollector	userDetailsCrawler		= new SteamDataCollector();
	private final RestClient			restClient				= new RestClient();

	/** Creates a new instance of UserDetailsCrawler */
	public UserDetailsApplication(final int crawlerNumber)
	{
		this.crawlerName = UserDetailsApplication.class.getSimpleName() + "-" + crawlerNumber;

		Thread.currentThread().setName(this.crawlerName);

		final HibernateDAOFactory daoFactory = DataAccessUtil.getDAOFactory();
		this.userDAO = daoFactory.getUserDAO();
	}

	private boolean crawl() throws IOException
	{

		final UserHibernate userToScan = loadNextUserToScan();

		if (userToScan == null)
		{
			UserDetailsApplication.logger.info("[" + this.crawlerName + "]" + "Nothing to work, System is Exiting...");
			return false;
		}

		try
		{
			final List<String> gameStrings = this.userDetailsCrawler.fetchUserDetails(userToScan.getUserID());
			for (final String gameJson : gameStrings)
			{
				logger.info(gameJson);
				this.restClient.sendPostRequest(gameJson);
			}
		}
		catch (final RegExNotMatchedException e)
		{
			e.printStackTrace();

			return true;
		}
		catch (final Exception e)
		{
			e.printStackTrace();

			return true;
		}
		DAO.close();

		return true;
	}

	private UserHibernate loadNextUserToScan()
	{
		UserHibernate userToScan;
		synchronized (UserDetailsApplication.lock)
		{
			userToScan = this.userDAO.getNextUser(UserDetailsApplication.USER_UPDATE_INTERVAL);

			if (userToScan != null)
			{
				userToScan.setPreviousCrawlingDate(userToScan.getCrawlingDate());
				userToScan.setCrawlingDate(new Timestamp(System.currentTimeMillis()));
				this.userDAO.merge(userToScan);
			}
		}

		return userToScan;
	}

	@Override
	public void run()
	{
		boolean moreUserToScan = true;

		while (moreUserToScan)
		{
			try
			{
				moreUserToScan = crawl();
			}
			catch (final Exception e)
			{
				DAO.close();
				e.printStackTrace();
				Util.sleep(1000 * 60);
			}
		}
	}
}
