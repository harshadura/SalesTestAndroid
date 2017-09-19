package com.webnatics.salestest.monthlysales;

import android.content.Context;
import android.util.Log;

import com.webnatics.salestest.R;
import com.webnatics.salestest.adapter.SalesAdapter;
import com.webnatics.salestest.hourlycount.HourlyCountContract;
import com.webnatics.salestest.model.HourlyActivityCount;
import com.webnatics.salestest.model.MonthlySales;
import com.webnatics.salestest.rest.ApiClient;
import com.webnatics.salestest.rest.ApiInterface;
import com.webnatics.salestest.util.MessageProvider;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class MonthlySalesPresenter implements MonthlySalesContract.UserActionsListener {

    private final MonthlySalesContract.View mView;

    public MonthlySalesPresenter(MonthlySalesContract.View hView) {
        mView = hView;
    }

    @Override
    public void fetchData(Context mContext) {

        mView.showProgressDialog();

        ApiInterface apiService =
                ApiClient.getClient(mContext).create(ApiInterface.class);

        Call<MonthlySales> call = apiService.getMonthlySales("monthly_sales", "2017");
        call.enqueue(new Callback<MonthlySales>() {
            @Override
            public void onResponse(Call<MonthlySales> call, Response<MonthlySales> response) {
                mView.hideProgressDialog();
                int statusCode = response.code();
                Map<String, String> data = response.body().getData();
                mView.showTable(data);
            }

            @Override
            public void onFailure(Call<MonthlySales> call, Throwable t) {
                mView.hideProgressDialog();
                mView.showError();
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
