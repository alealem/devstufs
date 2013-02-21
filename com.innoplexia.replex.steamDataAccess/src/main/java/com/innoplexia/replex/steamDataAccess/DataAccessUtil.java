package com.innoplexia.replex.steamDataAccess;

import org.apache.log4j.Logger;

/**
 * This is the initialization point for the Data Access.
 * 
 * @author christian
 */
public class DataAccessUtil
{

	protected static Logger						logger		= Logger.getLogger(DataAccessUtil.class);

	private static final HibernateDAOFactory	daoFactory	= new HibernateDAOFactory();

	public static HibernateDAOFactory getDAOFactory()
	{
		return DataAccessUtil.daoFactory;
	}

}
