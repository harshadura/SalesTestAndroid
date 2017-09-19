package com.webnatics.salestest.hourlycount;

import android.content.Context;
import android.util.Log;

import com.webnatics.salestest.model.HourlyActivityCount;
import com.webnatics.salestest.rest.ApiClient;
import com.webnatics.salestest.rest.ApiInterface;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class HourlyCountPresenter implements HourlyCountContract.UserActionsListener {

    private final HourlyCountContract.View mView;

    public HourlyCountPresenter(HourlyCountContract.View hView) {
        mView = hView;
    }

    @Override
    public void fetchData(Context mContext) {
        mView.showProgressDialog();
        ApiInterface apiService =
                ApiClient.getClient(mContext).create(ApiInterface.class);

        Call<HourlyActivityCount> call = apiService.getHourlyActivityCount("hourly_activity_count", "15-09-2017");
        call.enqueue(new Callback<HourlyActivityCount>() {
            @Override
            public void onResponse(Call<HourlyActivityCount> call, Response<HourlyActivityCount> response) {
                mView.hideProgressDialog();
                int statusCode = response.code();
                Map<String, String> data = response.body().getData();
                mView.drawChart(data);

            }

            @Override
            public void onFailure(Call<HourlyActivityCount> call, Throwable t) {
                mView.hideProgressDialog();
                mView.showError();
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
