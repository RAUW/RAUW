package com.rauwamsterdam.rauwamsterdam.data.vo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Jona on 4-8-2014.
 *
 * Dit is een VO(zie mail)
 *
 */
public class UserData
{
	public String firstName;
	public String lastName;
	public String email;

	public UserData()
	{

	}

	public Boolean parse(JSONObject data)
	{
		try
		{
			firstName = data.getString("firstname");
			lastName = data.getString("lastname");
			email = data.getString("email");
		}
		catch(JSONException error)
		{
			error.printStackTrace();
			return false;
		}

		return true;
	}
}
