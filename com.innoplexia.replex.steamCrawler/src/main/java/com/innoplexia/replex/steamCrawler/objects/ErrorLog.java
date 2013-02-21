/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.innoplexia.replex.steamCrawler.objects;

import java.io.Serializable;

/**
 * @author Lealem
 */

public class ErrorLog implements Serializable
{
	private static final long	serialVersionUID	= 1L;

	private String				userId;

	private String				gameId;

	private String				faultMessage;

	private String				stackTraceMessage;

	private String				stackTrace;

	public ErrorLog()
	{
	}

	public String getUserId()
	{
		return this.userId;
	}

	public void setUserId(final String userId)
	{
		this.userId = userId;
	}

	public String getGameId()
	{
		return this.gameId;
	}

	public void setGameId(final String gameId)
	{
		this.gameId = gameId;
	}

	public String getFaultMessage()
	{
		return this.faultMessage;
	}

	public void setFaultMessage(final String faultMessage)
	{
		this.faultMessage = faultMessage;
	}

	public String getStackTrace()
	{
		return this.stackTrace;
	}

	public void setStackTrace(final String stackTrace)
	{
		this.stackTrace = stackTrace;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	public String getStackTraceMessage()
	{
		return this.stackTraceMessage;
	}

	public void setStackTraceMessage(final String stackTraceMessage)
	{
		this.stackTraceMessage = stackTraceMessage;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.faultMessage == null ? 0 : this.faultMessage.hashCode());
		result = prime * result + (this.gameId == null ? 0 : this.gameId.hashCode());
		result = prime * result + (this.stackTrace == null ? 0 : this.stackTrace.hashCode());
		result = prime * result + (this.userId == null ? 0 : this.userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ErrorLog other = (ErrorLog) obj;
		if (this.faultMessage == null)
		{
			if (other.faultMessage != null)
				return false;
		}
		else if (!this.faultMessage.equals(other.faultMessage))
			return false;
		if (this.gameId == null)
		{
			if (other.gameId != null)
				return false;
		}
		else if (!this.gameId.equals(other.gameId))
			return false;
		if (this.stackTrace == null)
		{
			if (other.stackTrace != null)
				return false;
		}
		else if (!this.stackTrace.equals(other.stackTrace))
			return false;
		if (this.userId == null)
		{
			if (other.userId != null)
				return false;
		}
		else if (!this.userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "ErrorLog [userId=" + this.userId + ", gameId=" + this.gameId + ", faultMessage=" + this.faultMessage + ", stackTrace=" + this.stackTrace + "]";
	}

}
