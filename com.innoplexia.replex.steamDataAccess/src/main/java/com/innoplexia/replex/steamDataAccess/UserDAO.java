/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.innoplexia.replex.steamDataAccess;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.innoplexia.toolkits.ixDataAccess.DAO;
import com.innoplexia.toolkits.ixDataAccess.GenericHibernateDAO;

public class UserDAO extends GenericHibernateDAO<UserHibernate, String>
{
	public UserHibernate getNextUser(final long updateInterval)
	{

		final Criteria criteria = DAO.getSession().createCriteria(UserHibernate.class);

		criteria.add(Restrictions.le("crawlingDate", new Date(System.currentTimeMillis() - updateInterval)));
		criteria.addOrder(Order.asc("crawlingDate"));
		criteria.setMaxResults(1);

		return (UserHibernate) criteria.uniqueResult();
	}

	public UserHibernate getNextSelectedUser(final long updateInterval)
	{
		final Criteria criteria = DAO.getSession().createCriteria(UserHibernate.class);

		criteria.add(Restrictions.le("crawlingDate", new Date(System.currentTimeMillis() - updateInterval)));
		criteria.addOrder(Order.asc("crawlingDate"));
		criteria.setMaxResults(1);

		return (UserHibernate) criteria.uniqueResult();
	}
}
