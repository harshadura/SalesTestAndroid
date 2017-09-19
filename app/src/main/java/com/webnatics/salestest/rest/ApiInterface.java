package com.webnatics.salestest.rest;

import com.webnatics.salestest.model.HourlyActivityCount;
import com.webnatics.salestest.model.MonthlySales;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by harshadura
 */
public interface ApiInterface {

    @Headers("Accept: application/json")
    @POST("android-exam/list-data")
    Call<MonthlySales> getMonthlySales(@Query("data_type") String dataType, @Query("year") String year);

    @Headers("Accept: application/json")
    @POST("android-exam/list-data")
    Call<HourlyActivityCount> getHourlyActivityCount(@Query("data_type") String dataType, @Query("date") String date);

}
