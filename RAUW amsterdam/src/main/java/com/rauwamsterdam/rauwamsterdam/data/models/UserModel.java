package com.rauwamsterdam.rauwamsterdam.data.models;

import com.rauwamsterdam.rauwamsterdam.data.vo.UserData;

import org.json.JSONObject;

/**
 * Created by Jona on 10-8-2014.
 * Deze class handelt alle logica af voor je User data.
 * Voorlopig houdt hij alleen bij welke user is ingelogd en kan je de User weer ophalen.
 *
 * Later zou je dit nog kunnen uitbreiden om profiel data te wijzigen, opslaan etc.
 */
public class UserModel
{
	private UserData _user;

	public UserModel()
	{

	}

	public void addUser(JSONObject data)
	{
		if(_user == null)
		{
			_user = new UserData();
		}

		_user.parse(data);
	}

	public void removeUser()
	{
		_user = null;
	}

	public UserData get_user()
	{
		return _user;
	}
}
