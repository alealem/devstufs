package com.innoplexia.replex.steamDataAccess;

public class HibernateDAOFactory
{

	private final UserDAO	userDAO	= new UserDAO();

	public UserDAO getUserDAO()
	{
		return this.userDAO;
	}

}
