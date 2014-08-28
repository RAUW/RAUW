package com.rauwamsterdam.rauwamsterdam.services;

/**
 * Created by Jona on 3-8-2014.
 */
public interface IWebService
{
    void login(ICallback callback, String userName, String password);
    void register(ICallback callback, String userName, String password);
    void forgetPassword(ICallback callback, String userName);
}
