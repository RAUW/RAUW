package com.rauwamsterdam.rauwamsterdam.services;

/**
 * Created by Jonathan on 3-8-2014.
 */
public class DataResult<T>
{
    private Boolean _success;
    private T _data;
    private String _message;
    private String _code;

    public DataResult(Boolean success, T data, String message, String code)
    {
        _success = success;
        _data = data;
		_message = message;
		_code = code;
    }

	public DataResult(Boolean success, T data, String message)
	{
		_success = success;
		_data = data;
		_message = message;
	}

	public DataResult(Boolean success, T data)
	{
		_success = success;
		_data = data;
	}
    public Boolean getSucces()
    {
        return _success;
    }

    public T getData()
    {
        return _data;
    }

    public String getMessage()
    {
        return _message;
    }

    public String getCode()
    {
        return _code;
    }


}
