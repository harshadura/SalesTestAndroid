package com.webnatics.salestest.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Map;

import com.webnatics.salestest.R;

/**
 * Created by harshadura
 */
public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.MovieViewHolder> {

    private Map<String, String> dataMap;
    private String[] keyList;
    private int rowLayout;
    private Context context;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView txtMonth;
        TextView txtSales;
        RelativeLayout rootView;

        public MovieViewHolder(View v) {
            super(v);
            rootView = (RelativeLayout) v.findViewById(R.id.rootView);
            txtMonth = (TextView) v.findViewById(R.id.txtMonth);
            txtSales = (TextView) v.findViewById(R.id.txtSales);
        }
    }

    public SalesAdapter(Map<String, String> dataMap, int rowLayout, Context context) {
        this.dataMap = dataMap;
        this.keyList = this.dataMap.keySet().toArray(new String[this.dataMap.size()]);
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public SalesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {

        if(position % 2 == 0)
        {
            holder.rootView.setBackgroundColor(Color.CYAN);
        }
        else
        {
            holder.rootView.setBackgroundColor(Color.WHITE);
        }

        String key = keyList[position];
        String Value = dataMap.get(keyList[position]);

        holder.txtMonth.setText(key);
        holder.txtSales.setText(Value);
    }

    @Override
    public int getItemCount() {
        return dataMap.size();
    }
}