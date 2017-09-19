package com.webnatics.salestest.hourlycount;

import android.content.Context;

import java.util.Map;

/**
 * Created by harshadura
 */
public interface HourlyCountContract {

    interface View {

        void showError();
        void showProgressDialog();
        void hideProgressDialog();
        void drawChart(Map<String, String> dataMap );

    }

    interface UserActionsListener {

        void fetchData(Context mContext);
    }
}
