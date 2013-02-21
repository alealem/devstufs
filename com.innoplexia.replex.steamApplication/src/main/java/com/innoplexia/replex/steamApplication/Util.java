package com.innoplexia.replex.steamApplication;

public class Util
{
	public static void sleep(final long millis)
	{
		try
		{
			Thread.sleep(millis);
		}
		catch (final InterruptedException e)
		{
			throw new RuntimeException(e);
		}
	}
}
