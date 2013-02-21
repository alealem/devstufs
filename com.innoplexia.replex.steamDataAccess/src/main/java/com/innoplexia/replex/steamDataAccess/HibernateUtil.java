package com.innoplexia.replex.steamDataAccess;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtil
{
	private static Logger			logger	= Logger.getLogger(HibernateUtil.class);

	private static Configuration	configuration;
	private static SessionFactory	sessionFactory;

	static
	{
		// Create the initial SessionFactory from the default configuration
		// files
		try
		{
			HibernateUtil.logger.debug("Initializing Hibernate");

			HibernateUtil.configuration = new AnnotationConfiguration();

			// Read hibernate.cfg.xml (has to be present)
			HibernateUtil.configuration.configure();

			// Build and store (either in JNDI or static variable)
			HibernateUtil.rebuildSessionFactory(HibernateUtil.configuration);

			HibernateUtil.logger.debug("Hibernate initialized, call HibernateUtil.getSessionFactory()");
		}
		// We have to catch Throwable, otherwise we will miss
		// NoClassDefFoundError and other subclasses of Error
		catch (final Throwable ex)
		{
			HibernateUtil.logger.error("Building SessionFactory failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Returns the Hibernate configuration that was used to build the
	 * SessionFactory.
	 * 
	 * @return Configuration
	 */
	public static Configuration getConfiguration()
	{
		return HibernateUtil.configuration;
	}

	/**
	 * Returns the global SessionFactory either from a static variable or a JNDI
	 * lookup.
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory()
	{
		final String sfName = HibernateUtil.configuration.getProperty(Environment.SESSION_FACTORY_NAME);
		if (sfName != null)
		{
			HibernateUtil.logger.debug("Looking up SessionFactory in JNDI");
			try
			{
				return (SessionFactory) new InitialContext().lookup(sfName);
			}
			catch (final NamingException ex)
			{
				throw new RuntimeException(ex);
			}
		}
		else if (HibernateUtil.sessionFactory == null)
		{
			HibernateUtil.rebuildSessionFactory();
		}
		return HibernateUtil.sessionFactory;
	}

	/**
	 * Closes the current SessionFactory and releases all resources.
	 * <p>
	 * The only other method that can be called on HibernateUtil after this one
	 * is rebuildSessionFactory(Configuration).
	 */
	public static void shutdown()
	{
		HibernateUtil.logger.debug("Shutting down Hibernate");
		// Close caches and connection pools
		HibernateUtil.getSessionFactory().close();

		// Clear static variables
		HibernateUtil.sessionFactory = null;
	}

	/**
	 * Rebuild the SessionFactory with the static Configuration.
	 * <p>
	 * Note that this method should only be used with static SessionFactory
	 * management, not with JNDI or any other external registry. This method
	 * also closes the old static variable SessionFactory before, if it is still
	 * open.
	 */
	public static void rebuildSessionFactory()
	{
		HibernateUtil.logger.debug("Using current Configuration to rebuild SessionFactory");
		HibernateUtil.rebuildSessionFactory(HibernateUtil.configuration);
	}

	/**
	 * Rebuild the SessionFactory with the given Hibernate Configuration.
	 * <p>
	 * HibernateUtil does not configure() the given Configuration object, it
	 * directly calls buildSessionFactory(). This method also closes the old
	 * static variable SessionFactory before, if it is still open.
	 * 
	 * @param cfg
	 */
	public static void rebuildSessionFactory(final Configuration cfg)
	{
		HibernateUtil.logger.debug("Rebuilding the SessionFactory from given Configuration");
		if (HibernateUtil.sessionFactory != null && !HibernateUtil.sessionFactory.isClosed())
		{
			HibernateUtil.sessionFactory.close();
		}
		if (cfg.getProperty(Environment.SESSION_FACTORY_NAME) != null)
		{
			HibernateUtil.logger.debug("Managing SessionFactory in JNDI");
			cfg.buildSessionFactory();
		}
		else
		{
			HibernateUtil.logger.debug("Holding SessionFactory in static variable");
			HibernateUtil.sessionFactory = cfg.buildSessionFactory();
		}
		HibernateUtil.configuration = cfg;
	}

}
