package com.innoplexia.replex.steamApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

public class RestClient
{
	private static final Logger	logger	= Logger.getLogger(RestClient.class);

	public void sendPostRequest(final String jsonValue) throws UnsupportedEncodingException
	{
		final DefaultHttpClient client = new DefaultHttpClient();
		final HttpPost post = new HttpPost("http://95.138.169.28:12345/test.access");
		final List<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>(1);

		nameValuePairs.add(new BasicNameValuePair("json", jsonValue));

		post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		HttpResponse response = null;
		try
		{
			response = client.execute(post);
			logger.info("Sending " + jsonValue);
		}
		catch (final ClientProtocolException e)
		{
			e.printStackTrace();
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
		BufferedReader rd = null;
		try
		{
			rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		}
		catch (final IllegalStateException e1)
		{

			e1.printStackTrace();
		}
		catch (final IOException e1)
		{
			e1.printStackTrace();
		}
		String line = "";
		try
		{
			while ((line = rd.readLine()) != null)
			{
				System.out.println(line);
			}
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}
}
