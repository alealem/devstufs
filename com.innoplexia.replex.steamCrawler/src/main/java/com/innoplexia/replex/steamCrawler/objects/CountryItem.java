package com.innoplexia.replex.steamCrawler.objects;

public class CountryItem
{

	public static final String	UNAVILABLE	= "Unavailable";
	private String				countryId;
	private String				countryName;

	public String getCountryId()
	{
		return countryId;
	}

	public void setCountryId(String countryId)
	{
		this.countryId = countryId;
	}

	public String getCountryName()
	{
		return countryName;
	}

	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}

	@Override
	public String toString()
	{
		return "CountryItem [countryId=" + countryId + ", countryName=" + countryName + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryId == null) ? 0 : countryId.hashCode());
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryItem other = (CountryItem) obj;
		if (countryId == null)
		{
			if (other.countryId != null)
				return false;
		}
		else if (!countryId.equals(other.countryId))
			return false;
		if (countryName == null)
		{
			if (other.countryName != null)
				return false;
		}
		else if (!countryName.equals(other.countryName))
			return false;
		return true;
	}

}
