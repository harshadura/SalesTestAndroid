package com.webnatics.salestest.main;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.webnatics.salestest.R;
import com.webnatics.salestest.activity.BaseActivity;
import com.webnatics.salestest.monthlysales.MonthlySalesActivity;
import com.webnatics.salestest.hourlycount.HourlyCountActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by harshadura
 */
public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.btnMonthlySales)
    Button btnMonthlySales;

    @BindView(R.id.btnHourlyCount)
    Button btnHourlyCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnMonthlySales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MonthlySalesActivity.class);
                startActivity(intent);
            }
        });

        btnHourlyCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HourlyCountActivity.class);
                startActivity(intent);
            }
        });
    }
}
