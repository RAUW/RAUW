package com.rauwamsterdam.rauwamsterdam.data;

import com.rauwamsterdam.rauwamsterdam.data.models.UserModel;
import com.rauwamsterdam.rauwamsterdam.services.DummyWebService;
import com.rauwamsterdam.rauwamsterdam.services.IWebService;

/**
 * Created by Jona on 3-8-2014.
 * Dit is een singleton (zie mail).
 * Deze class is toegankelijk vanuit de gehele app.
 * Dit is vet handig om makkelijk bij je data of je services te kunnen.
 */
public class DataManager
{
	private static Boolean _allowInstance;
	private static DataManager _instance;

	public static DataManager getInstance()
	{
		if(_instance == null)
		{
			_allowInstance = true;
			_instance = new DataManager();
			_allowInstance = false;
		}

		return _instance;
	}

	private IWebService _webservice;
	private UserModel _userModel;

    public DataManager()
    {
        if(!_allowInstance)
        {
        	throw new Error("This is a singleton use the getInstance method!");
		}

		_webservice = new DummyWebService();
		_userModel = new UserModel();
    }

	public IWebService getWebservice()
	{
		return _webservice;
	}
	public UserModel getUserModel() { return _userModel; }

}
