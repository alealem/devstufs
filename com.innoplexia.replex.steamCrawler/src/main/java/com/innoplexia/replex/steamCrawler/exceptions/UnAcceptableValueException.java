package com.innoplexia.replex.steamCrawler.exceptions;

import java.util.regex.Pattern;

public class UnAcceptableValueException extends Exception
{

	public UnAcceptableValueException(final Pattern regex, final String html)
	{
		this(regex.toString() + " doesn't match for given html. Html: " + html);
	}

	public UnAcceptableValueException(final String errorText)
	{
		this(errorText, null);
	}

	public UnAcceptableValueException(final String errorText, final Throwable rootCause)
	{
		super(errorText, rootCause);
	}
}