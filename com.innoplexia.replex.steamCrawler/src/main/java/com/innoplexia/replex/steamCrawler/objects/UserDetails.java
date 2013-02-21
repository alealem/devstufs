package com.innoplexia.replex.steamCrawler.objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDetails
{
	public static final String	UNAVILABLE			= "Unavailable";
	private Set<GameItem>		playedGames			= new HashSet<GameItem>();
	private List<ErrorLog>		errorLogs			= new ArrayList<ErrorLog>();
	// TODO This value should be injected into the userDetailsCrawler
	public String				userId;
	public double				LAST_ONLINE			= 384;
	private double				steamRating			= 0.0;
	private double				totalPlayingTime	= 0.0;
	private double				lastOnline			= 0.0;
	private Date				memeberSince;
	private boolean				bannedAccount;

	private CountryItem			country;

	public List<ErrorLog> getErrorLogs()
	{
		return this.errorLogs;
	}

	public void setErrorLogs(final List<ErrorLog> errorLogs)
	{
		this.errorLogs = errorLogs;
	}

	public String getUserId()
	{
		return this.userId;
	}

	public void setUserId(final String userId)
	{
		this.userId = userId;
	}

	public Set<GameItem> getPlayedGames()
	{
		return this.playedGames;
	}

	public void setPlayedGames(final Set<GameItem> playedGames)
	{
		this.playedGames = playedGames;
	}

	public double getSteamRating()
	{
		return this.steamRating;
	}

	public void setSteamRating(final double steamRating)
	{
		this.steamRating = steamRating;
	}

	public double getTotalPlayingTime()
	{
		return this.totalPlayingTime;
	}

	public void setTotalPlayingTime(final double totalPlayingTime)
	{
		this.totalPlayingTime = totalPlayingTime;
	}

	public boolean isBannedAccount()
	{
		return this.bannedAccount;
	}

	public void setBannedAccount(final boolean bannedAccount)
	{
		this.bannedAccount = bannedAccount;
	}

	public double getLastOnline()
	{
		return this.lastOnline;
	}

	public void setLastOnline(final double lastOnline)
	{
		this.lastOnline = lastOnline;
	}

	public Date getMemeberSince()
	{
		return this.memeberSince;
	}

	public void setMemeberSince(final Date memeberSince)
	{
		this.memeberSince = memeberSince;
	}

	public CountryItem getCountry()
	{
		return this.country;
	}

	public void setCountry(final CountryItem country)
	{
		this.country = country;
	}

	@Override
	public String toString()
	{
		return "UserDetails [playedGames="
				+ this.playedGames + ", LAST_ONLINE=" + this.LAST_ONLINE + ", steamRating=" + this.steamRating + ", totalPlayingTime=" + this.totalPlayingTime + ", lastOnline=" + this.lastOnline + ", memeberSince=" + this.memeberSince
				+ ", bannedAccount=" + this.bannedAccount + ", country=" + this.country + "]";
	}

}
