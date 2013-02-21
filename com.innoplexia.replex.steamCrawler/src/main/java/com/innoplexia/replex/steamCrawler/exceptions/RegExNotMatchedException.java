package com.innoplexia.replex.steamCrawler.exceptions;

import java.util.regex.Pattern;

public class RegExNotMatchedException extends Exception
{

	public RegExNotMatchedException(final String regexPattern, final Pattern regex, final String id, final String html)
	{
		this(" Pattern= " + regex.toString() + " for " + regexPattern + " doesn't match for given html on " + id + "\n" + "\n" + html);
	}

	public RegExNotMatchedException(final String regexPattern, final Pattern regex, final String html)
	{
		this(" Pattern= " + regex.toString() + " for " + regexPattern + " doesn't match for given html on " + null + "\n" + "\n" + html);
	}

	public RegExNotMatchedException(final String errorText)
	{
		this(errorText, null);
	}

	public RegExNotMatchedException(final String errorText, final Throwable rootCause)
	{
		super(errorText, rootCause);
	}
}
