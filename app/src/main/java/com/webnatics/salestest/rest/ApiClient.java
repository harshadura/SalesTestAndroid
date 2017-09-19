package com.webnatics.salestest.rest;

import android.content.Context;

import com.webnatics.salestest.util.WebServicesURLProvider;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by harshadura
 */
public class ApiClient {

    public static String BASE_URL;
    private static Retrofit retrofit = null;

    public static Retrofit getClient(Context mContext) {

        BASE_URL = WebServicesURLProvider.getBaseURL(mContext);

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
