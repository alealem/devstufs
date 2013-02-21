package com.innoplexia.replex.steamCrawler.objects;

import java.util.Date;

public class GameListItemWeb
{
	public static final String	DETAIL_UNAVILABLE	= "Type unavailable";
	private String				gameId;
	private String				gameName;
	private Date				releaseDate;

	private String				gameGenre;
	private boolean				detailPageAvailable;
	private String				developer;
	private String				publisher;
	private Integer				score;
	private double				playingTimeCurrent;
	private double				playingTimeOnRecord;

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

	public void setDeveloper(final String developer)
	{
		this.developer = developer;
	}

	public String getDeveloper()
	{
		return this.developer;
	}

	public String getPublisher()
	{
		return this.publisher;
	}

	public void setPublisher(final String publisher)
	{
		this.publisher = publisher;
	}

	public Integer getScore()
	{
		return this.score;
	}

	public void setScore(final Integer score)
	{
		this.score = score;
	}

	public double getPlayingTimeCurrent()
	{
		return this.playingTimeCurrent;
	}

	public void setPlayingTimeCurrent(final double playingTimeCurrent)
	{
		this.playingTimeCurrent = playingTimeCurrent;
	}

	public double getPlayingTimeOnRecord()
	{
		return this.playingTimeOnRecord;
	}

	public void setPlayingTimeOnRecord(final double playingTimeOnRecord)
	{
		this.playingTimeOnRecord = playingTimeOnRecord;
	}

	public boolean isDetailPageAvailable()
	{
		return this.detailPageAvailable;
	}

	public void setDetailPageAvailable(final boolean detailPageAvailable)
	{
		this.detailPageAvailable = detailPageAvailable;
	}

	public String getGameGenre()
	{
		return this.gameGenre;
	}

	public void setGameGenre(final String gameGenre)
	{
		this.gameGenre = gameGenre;
	}

}
