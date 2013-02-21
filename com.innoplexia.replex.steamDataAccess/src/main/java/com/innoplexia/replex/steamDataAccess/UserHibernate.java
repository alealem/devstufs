/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innoplexia.replex.steamDataAccess;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Lealem
 */
@Entity
@Table(name = "Users")
public class UserHibernate implements Serializable
{

	private static final long		serialVersionUID		= 1L;

	@Transient
	public static final Timestamp	DEFAULT_DATE			= new Timestamp(new GregorianCalendar(1970, 1, 1).getTime().getTime());
	@Transient
	public static double			LAST_ONLINE				= 384.0;
	@Id
	@Column(length = 45)
	private String					userID;
	private Date					membersince;
	private double					playingTime;
	private Boolean					bannedAccount			= false;
	private double					steamRating;
	private double					lastOnline;
	private Date					previousCrawlingDate	= UserHibernate.DEFAULT_DATE;
	private Date					crawlingDate			= UserHibernate.DEFAULT_DATE;

	public UserHibernate()
	{
	}

	public String getUserID()
	{
		return this.userID;
	}

	public void setUserID(final String userID)
	{
		this.userID = userID;
	}

	public Date getMembersince()
	{
		return this.membersince;
	}

	public void setMembersince(final Date membersince)
	{
		this.membersince = membersince;
	}

	public double getLastOnline()
	{
		return this.lastOnline;
	}

	public void setLastOnline(final double lastOnline)
	{
		this.lastOnline = lastOnline;
	}

	public double getPlayingTime()
	{
		return this.playingTime;
	}

	public Date getCrawlingDate()
	{
		return this.crawlingDate;
	}

	public void setCrawlingDate(final Date date)
	{
		this.crawlingDate = date;
	}

	public Date getPreviousCrawlingDate()
	{
		return this.previousCrawlingDate;
	}

	public void setPreviousCrawlingDate(final Date previousCrawlingDate)
	{
		this.previousCrawlingDate = previousCrawlingDate;
	}

	public void setPlayingTime(final double playingTime)
	{
		this.playingTime = playingTime;
	}

	public double getSteamRating()
	{
		return this.steamRating;
	}

	public void setSteamRating(final double steamRating)
	{
		this.steamRating = steamRating;
	}

	public Boolean isBannedAccount()
	{
		return this.bannedAccount;
	}

	public void setBannedAccount(final Boolean bannedAccount)
	{
		this.bannedAccount = bannedAccount;
	}

	@Override
	public int hashCode()
	{
		int hash = 0;
		hash += this.userID != null ? this.userID.hashCode() : 0;
		return hash;
	}

	@Override
	public boolean equals(final Object object)
	{
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof UserHibernate))
			return false;
		final UserHibernate other = (UserHibernate) object;
		if (this.userID == null && other.userID != null || this.userID != null && !this.userID.equals(other.userID))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "entity.Users[userID=" + this.userID + "]";
	}
}
