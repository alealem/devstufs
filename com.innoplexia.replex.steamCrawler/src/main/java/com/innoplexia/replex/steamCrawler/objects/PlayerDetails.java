/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innoplexia.replex.steamCrawler.objects;

/**
 * 
 * @author Lealem
 */
public class PlayerDetails
{
	public static final String	DETAIL_UNAVILABLE	= "Type unavailable";
	private int					playerRank;
	private String				playerName;
	private String				playerId;
	private int					hoursPlayed;

	public PlayerDetails()
	{
	}

	public String getPlayerId()
	{
		return this.playerId;
	}

	public void setPlayerId(final String playerId)
	{
		this.playerId = playerId;
	}

	public String getPlayerName()
	{
		return this.playerName;
	}

	public void setPlayerName(final String playerName)
	{
		this.playerName = playerName;
	}

	public int getHoursPlayed()
	{
		return this.hoursPlayed;
	}

	public void setHoursPlayed(final int hoursPlayed)
	{
		this.hoursPlayed = hoursPlayed;
	}

	public int getPlayerRank()
	{
		return this.playerRank;
	}

	public void setPlayerRank(final int playerRank)
	{
		this.playerRank = playerRank;
	}

	@Override
	public String toString()
	{
		return "PlayerDetails [playerRank=" + this.playerRank + ", playerName=" + this.playerName + ", playerId=" + this.playerId + ", hoursPlayed=" + this.hoursPlayed + "]";
	}

}
