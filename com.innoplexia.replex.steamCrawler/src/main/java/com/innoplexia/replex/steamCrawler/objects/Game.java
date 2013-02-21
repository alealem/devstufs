package com.innoplexia.replex.steamCrawler.objects;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Game
{
	public static String	SHOP_URL	= "http://store.steampowered.com/";

	private String			gameId;
	private String			gameName;
	private Date			releaseDate;
	private Set<GameType>	gameGenres	= new HashSet<GameType>();

	public String getGameId()
	{
		return this.gameId;
	}

	public void setGameId(final String gameId)
	{
		this.gameId = gameId;
	}

	public String getGameName()
	{
		return this.gameName;
	}

	public void setGameName(final String gameName)
	{
		this.gameName = gameName;
	}

	public Date getReleaseDate()
	{
		return this.releaseDate;
	}

	public void setReleaseDate(final Date releaseDate)
	{
		this.releaseDate = releaseDate;
	}

	public Set<GameType> getGameGenres()
	{
		return this.gameGenres;
	}

	public void setGameGenres(final Set<GameType> gameGenres)
	{
		this.gameGenres = gameGenres;
	}

}
