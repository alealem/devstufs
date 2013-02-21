package com.innoplexia.replex.steamCrawler.objects;


public class UserCountry
{

	private String	countryId;
	private String	countryName;
	private String	countryFlag;

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

	public String getCountryFlag()
	{
		return countryFlag;
	}

	public void setCountryFlag(String countryFlag)
	{
		this.countryFlag = countryFlag;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryId == null) ? 0 : countryId.hashCode());
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
		UserCountry other = (UserCountry) obj;
		if (countryId == null)
		{
			if (other.countryId != null)
				return false;
		}
		else if (!countryId.equals(other.countryId))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "UserCountry [countryId=" + countryId + ", countryName=" + countryName + ", countryFlag=" + countryFlag + "]";
	}

}
