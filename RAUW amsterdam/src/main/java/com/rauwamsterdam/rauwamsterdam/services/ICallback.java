package com.rauwamsterdam.rauwamsterdam.services;

/**
 * Created by Jona on 3-8-2014.
 */
public interface ICallback<T>
{
    void onResult(DataResult<T> result);
}
