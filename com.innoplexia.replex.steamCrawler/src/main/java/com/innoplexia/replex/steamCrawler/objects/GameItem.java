package com.innoplexia.replex.steamCrawler.objects;

import java.util.Date;

public class GameItem
{
	public static final String	DETAIL_UNAVILABLE	= "Type unavailable";
	public static final String	UNAVILABLE			= "Unavailable";
	private String				gameId;
	private String				gameName;
	private Date				releaseDate;
	private String				developer;
	private String				publisher;
	private Integer				score;
	private boolean				detailPageAvailable	= true;
	private double				playingTimeCurrent;
	private double				playingTimeOnRecord;
	private boolean				recentlyPlayed		= false;
	private Integer				metaScore;
	private String				gameGenre;

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

	public boolean isRecentlyPlayed()
	{
		return this.recentlyPlayed;
	}

	public void setRecentlyPlayed(final boolean recentlyPlayed)
	{
		this.recentlyPlayed = recentlyPlayed;
	}

	public boolean isDetailPageAvailable()
	{
		return this.detailPageAvailable;
	}

	public void setDetailPageAvailable(final boolean detailPageAvailable)
	{
		this.detailPageAvailable = detailPageAvailable;
	}

	public String getDeveloper()
	{
		return this.developer;
	}

	public void setDeveloper(final String Developer)
	{
		this.developer = Developer;
	}

	public Integer getScore()
	{
		return this.score;
	}

	public void setScore(final Integer score)
	{
		this.score = score;
	}

	public String getPublisher()
	{
		return this.publisher;
	}

	public void setPublisher(final String publisher)
	{
		this.publisher = publisher;
	}

	public Date getReleaseDate()
	{
		return this.releaseDate;
	}

	public void setReleaseDate(final Date releaseDate)
	{
		this.releaseDate = releaseDate;
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

	public String getGameGenre()
	{
		return this.gameGenre;
	}

	public void setGameGenre(final String gameGenre)
	{
		this.gameGenre = gameGenre;
	}

	@Override
	public String toString()
	{
		return "GameItem [gameId="
				+ this.gameId + ", gameName=" + this.gameName + ", releaseDate=" + this.releaseDate + ", developer=" + this.developer + ", publisher=" + this.publisher + ", score=" + this.score + ", detailPageAvailable=" + this.detailPageAvailable
				+ ", playingTimeCurrent=" + this.playingTimeCurrent + ", playingTimeOnRecord=" + this.playingTimeOnRecord + ", recentlyPlayed="
				+ this.recentlyPlayed + ", metaScore=" + this.metaScore + "]";
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final GameItem other = (GameItem) obj;

		// System.out.println(this.gameId + " "+other.gameId);

		if (this.gameId == null ? other.gameId != null : !this.gameId.equals(other.gameId))
		{
			return false;
		}
		return true;
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 41 * hash + (this.gameId != null ? this.gameId.hashCode() : 0);
		return hash;
	}

	public void setMetaScore(final Integer metaScore)
	{
		this.metaScore = metaScore;
	}

	public Integer getMetaScore()
	{
		return this.metaScore;
	}

}
