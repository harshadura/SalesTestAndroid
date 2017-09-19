package com.webnatics.salestest.monthlysales;

import android.content.Context;

import java.util.Map;

/**
 * Created by harshadura
 */
public interface MonthlySalesContract {

    interface View {

        void showError();
        void showProgressDialog();
        void hideProgressDialog();
        void showTable(Map<String, String> data);

    }

    interface UserActionsListener {

        void fetchData(Context mContext);
    }
}
