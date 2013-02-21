package com.innoplexia.replex.steamCrawler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.log4j.Logger;

import com.innoplexia.ixHttpClient.IxHttpClient;
import com.innoplexia.replex.steamCrawler.exceptions.RegExNotMatchedException;

public class SteamDataCollector
{
	private static final Logger	logger					= Logger.getLogger(SteamDataCollector.class);

	public static final Pattern	JESSON_RESPONSE_PATTERN	= Pattern.compile("var rgGames = (\\[.*?\\]);", Pattern.MULTILINE | Pattern.DOTALL);
	public static final Pattern	USER_ID_PATTERN			= Pattern.compile("var profileLink = \"http://steamcommunity.com/(.*?)'\"", Pattern.MULTILINE | Pattern.DOTALL);

	public static final Pattern	PRIVATE_PROFILE_PATTERN	= Pattern.compile("<p class=\"errorPrivate\">This profile is private.</p>");
	public static final Pattern	PROFILE_NOT_SET_PATTERN	= Pattern.compile("<p class=\"errorPrivate\">This user has not yet set up their Steam Community profile.*?</p>");

	public static final Pattern	USER_NOT_FOUND_PATTERN	= Pattern.compile("The specified profile could not be found");

	private final IxHttpClient	httpClient				= new IxHttpClient();

	public List<String> fetchUserDetails(final String userId) throws Exception
	{
		List<String> userTotalGames = new ArrayList<String>();
//		this.httpClient.setConnectionTimeout(5000);
//		this.httpClient.setTimeout(5000);
		final String extractDetailsresponse = this.httpClient.fetchWebpage("http://steamcommunity.com/" + userId);

		final Matcher profileMatcher = SteamDataCollector.PRIVATE_PROFILE_PATTERN.matcher(extractDetailsresponse);
		final Matcher profileNotSetMatcher = SteamDataCollector.PROFILE_NOT_SET_PATTERN.matcher(extractDetailsresponse);

		final Matcher userNotFoundMatcher = SteamDataCollector.USER_NOT_FOUND_PATTERN.matcher(extractDetailsresponse);

		if (!(profileMatcher.find() || userNotFoundMatcher.find() || profileNotSetMatcher.find()))
		{

			final String gameresponse = this.httpClient.fetchWebpage("http://steamcommunity.com/" + userId + "/games?tab=all");
			userTotalGames = extractUserGames(gameresponse, userId);
		}

		return userTotalGames;
	}

	private List<String> extractUserGames(final String gameresponse, final String userId) throws RegExNotMatchedException
	{
		final List<String> games = new ArrayList<String>();

		final Matcher allGamesJessonMatcher = SteamDataCollector.JESSON_RESPONSE_PATTERN.matcher(gameresponse);
		if (allGamesJessonMatcher.find())
		{
			final String jesonResponseString = allGamesJessonMatcher.group(1);
			final JSONArray json = (JSONArray) JSONSerializer.toJSON(jesonResponseString);

			final Iterator<JSONObject> iterator = json.iterator();
			while (iterator.hasNext())
			{

				try
				{
					final JSONObject game = iterator.next();
					game.put("userId", userId);
					final String gameString = game.toString();

					games.add(gameString);
				}
				catch (final Exception e)
				{

				}

			}
		}
		else
		{
			throw new RegExNotMatchedException("JESSON_RESPONSE_PATTERN ",
					SteamDataCollector.JESSON_RESPONSE_PATTERN, null, gameresponse);
		}
		return games;
	}
}
