package com.webnatics.salestest.monthlysales;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.Map;

import com.github.mikephil.charting.data.BarData;
import com.webnatics.salestest.R;
import com.webnatics.salestest.activity.BaseActivity;
import com.webnatics.salestest.adapter.SalesAdapter;
import com.webnatics.salestest.hourlycount.HourlyCountActivity;
import com.webnatics.salestest.hourlycount.HourlyCountContract;
import com.webnatics.salestest.hourlycount.HourlyCountPresenter;
import com.webnatics.salestest.model.MonthlySales;
import com.webnatics.salestest.rest.ApiClient;
import com.webnatics.salestest.rest.ApiInterface;
import com.webnatics.salestest.util.MessageProvider;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.webnatics.salestest.R.id.chart;

/**
 * Created by harshadura
 */
public class MonthlySalesActivity extends BaseActivity implements MonthlySalesContract.View{
    private static final String TAG = MonthlySalesActivity.class.getSimpleName();
    private MonthlySalesContract.UserActionsListener mActionsListener;
    private ProgressDialog mDialog;

    @BindView(R.id.movies_recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_sales);
        mContext = this;
        ButterKnife.bind(this);
        mActionsListener = new MonthlySalesPresenter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mActionsListener.fetchData(mContext);

    }

    @Override
    public void showProgressDialog() {
        mDialog = ProgressDialog.show(mContext, "Sales Test", "Fetching data ..", true);
    }

    @Override
    public void hideProgressDialog() {
        mDialog.hide();
    }

    @Override
    public void showError() {
        MessageProvider.displayAlert(mContext, "Sales Test", "Something went wrong", "OK", null, null, null);
    }

    @Override
    public void showTable(Map<String, String> data){
        recyclerView.setAdapter(new SalesAdapter(data, R.layout.list_item_sale, getApplicationContext()));
    }
}
