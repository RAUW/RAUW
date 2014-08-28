package com.rauwamsterdam.rauwamsterdam.services;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

/**
 * Created by Jonathan on 3-8-2014.
 *
 * Dit is een dummywebservice later kunnen we een variant hierop maken die echt met een backend communiceert.
 * Dit kunnen we makkelijk fixen door een nieuwe class te maken die de IWebService interface implementeerd.
 */
public class DummyWebService implements IWebService
{
	private static String _TAG = "DummyWebService";

	public DummyWebService()
	{
		Log.d(_TAG, "webservice created");
	}

	/**
	 * Nep login method, maar het idee is dat deze dus hetzelfde aan te roepen is vanuit de applicatie.
	 * Hierdoor kunnen we voor nu(tot we een backend hebben) met deze variant werken.
	 * Later vervangen we die in de DataManager. Omdat we dezelfde implementatie aan de buitenkant hebben hoeven we dan
	 * niks aan te passen in de app zelf.
	 * @param callback
	 * @param userName
	 * @param password
	 */
	@Override
	public void login(ICallback callback, String userName, String password)
	{
		//Deze call geeft altijd een true terug en zal de gebruiker dus altijd inloggen.
		doCallBack(callback, createFakeLogin(true), true, "Login success");

		//Deze call geeft een false terug en zal de gebruiker nooit laten inloggen.
		//doCallBack(callback, createFakeLogin(false), true, "Login failed");

		//Deze call geeft alleen true terug als de credentials ook kloppen.
		Boolean validLogin = (userName == "henk" && password == "test");
		String message = validLogin ? "Login success" : "Login failed";
		//doCallBack(callback, createFakeLogin(validLogin), true, message);
	}

	@Override
	public void register(ICallback callback, String userName, String password)
	{

	}

	@Override
	public void forgetPassword(ICallback callback, String userName)
	{

	}

	private void doCallBack(ICallback callback, JSONObject data, Boolean success)
	{
		doCallBack(callback, data, success, null);
	}

	/**
	 * De success die we hier als parameter meegeven is een success die later van de server komt. Dit houdt in of de servercall gelukt is of niet!
	 * Dit heeft dus niks te maken of de login gelukt is of niet. Dat resultaat stoppen we in de JSON.
	 */
	private void doCallBack(ICallback callback, JSONObject data, Boolean success, String message)
	{
		DataResult<JSONObject> result = new DataResult<JSONObject>(success, data, message);

		callback.onResult(result);
	}

	/**
	 * Fake data generation methods
	 */
	private static String[] FIRST_NAMES = {"Piet", "Henk", "Harry", "Larry"};
	private static String[] LAST_NAMES = {"Hendriksen", "van Laren", "Thomasson", "van der Valk"};

	private JSONObject createFakeLogin(Boolean success)
	{
		String jsonString = "{\"success\": "+success+", \"user\":"+generateUser()+"}";
		try
		{
			return new JSONObject(jsonString);
		}
		catch (JSONException error)
		{
			Log.e(error.toString(), _TAG);
			return null;
		}
	}

	private String generateUser()
	{
		String firstName = getRandomStringValue(FIRST_NAMES);
		return "{\"firstname\":"+ firstName +", \"lastname\":"+ getRandomStringValue(LAST_NAMES)+", \"email\": "+generateEmail(firstName)+"}";
	}

	private String getRandomStringValue(String[] data)
	{
		return data[new Random().nextInt(data.length)];
	}

	private String generateEmail(String name)
	{
		return name+"@fakegmail.com";
	}
}