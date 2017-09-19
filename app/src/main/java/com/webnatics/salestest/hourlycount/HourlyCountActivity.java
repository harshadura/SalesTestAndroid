package com.webnatics.salestest.hourlycount;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.webnatics.salestest.R;
import com.webnatics.salestest.activity.BaseActivity;
import com.webnatics.salestest.util.MessageProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by harshadura
 */
public class HourlyCountActivity extends BaseActivity implements HourlyCountContract.View {
    private HourlyCountContract.UserActionsListener mActionsListener;
    private ProgressDialog mDialog;
    private static final String TAG = HourlyCountActivity.class.getSimpleName();

    @BindView(R.id.chart)
    BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_count);
        mContext = this;
        ButterKnife.bind(this);
        mActionsListener = new HourlyCountPresenter(this);
        mActionsListener.fetchData(mContext);
    }

    @Override
    public void showProgressDialog() {
        mDialog = ProgressDialog.show(HourlyCountActivity.this, "Sales Test", "Fetching data ..", true);
    }

    @Override
    public void hideProgressDialog() {
        mDialog.hide();
    }

    @Override
    public void showError() {
        MessageProvider.displayAlert(HourlyCountActivity.this, "Sales Test", "Something went wrong", "OK", null, null, null);
    }

    @Override
    public void drawChart(Map<String, String> dataMap ){

        BarData data = new BarData(getXAxisValues(dataMap), getDataSet(dataMap));
        chart.setData(data);
        chart.setDescription("Hourly Activity");
        chart.animateXY(2000, 2000);
        chart.invalidate();
    }

    private ArrayList<BarDataSet> getDataSet(Map<String, String> dataMap ) {
        ArrayList<BarDataSet> dataSets = null;

        String[] keyList = dataMap.keySet().toArray(new String[dataMap.size()]);

        List<BarEntry> entries = new ArrayList<BarEntry>();

        int i=0;
        for (String key : keyList) {
            String value = dataMap.get(key);
            entries.add(new BarEntry(Float.valueOf(value), i++));
        }

        BarDataSet barDataSet1 = new BarDataSet(entries, "Sales");
        barDataSet1.setColor(Color.rgb(0, 155, 0));

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues(Map<String, String> dataMap) {
        String[] keyList = dataMap.keySet().toArray(new String[dataMap.size()]);
        ArrayList<String> xAxis = new ArrayList<>();

        for (String key : keyList) {
            xAxis.add(key);
        }

        return xAxis;
    }
}