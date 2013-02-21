package com.innoplexia.replex.steamApplication;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class Starter
{
	private static final Logger	logger					= Logger.getLogger(Starter.class);
	public static final long	USER_UPDATE_INTERVAL	= TimeUnit.HOURS.toMillis(24);

	public static void main(final String[] args) throws Exception
	{

		new Starter();
	}

	public Starter() throws Exception
	{
		final Properties props = loadProperties();

		if (props.containsKey("crawlerType") && props.containsKey("numberOfThreads"))
		{
			final int numberOfThreads = Integer.parseInt(props.getProperty("numberOfThreads"));
			startCrawler(props.getProperty("crawlerType"), numberOfThreads);
		}
		else
		{
			showMenuOnColnsole();
		}
	}

	private Properties loadProperties()
	{
		final Properties props = new Properties();

		try
		{
			props.load(Starter.class.getClassLoader().getResourceAsStream("steam.properties"));
		}
		catch (final IOException e)
		{
			Starter.logger.warn("Could not find steam.properties");
		}

		return props;
	}

	private void showMenuOnColnsole() throws Exception
	{
		final Scanner input = new Scanner(System.in);

		System.out.println("=============== Steam Scanner ===============");
		System.out.println("Select one of the following Crawler:");

		System.out.println("UD  - User Details Crawler");
		System.out.println("");
		System.out.print("Input: ");

		final String crawlerType = input.next();

		System.out.println("How many threads?");

		final String numberOfThreads = input.next();
		final int crawlerCount = Integer.parseInt(numberOfThreads);
		startCrawler(crawlerType, crawlerCount);
	}

	public void startCrawler(final String choise, final int crawlerCount) throws Exception
	{

		if (choise.equalsIgnoreCase("UD"))
		{
			for (int i = 0; i < crawlerCount; i++)
			{
				new Thread(new UserDetailsApplication(i + 1)).start();
			}
		}
		else
		{
			System.out.println("Can't read your input.");
		}
	}

}
