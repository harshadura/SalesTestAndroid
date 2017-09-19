package com.webnatics.salestest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by harshadura
 */
public class MonthlySales {

    @SerializedName("data")
    @Expose
    @Getter
    @Setter
    private Map<String, String> data;

}
