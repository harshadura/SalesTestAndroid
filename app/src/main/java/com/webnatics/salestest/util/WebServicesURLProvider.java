package com.webnatics.salestest.util;

import android.content.Context;

import com.webnatics.salestest.R;

public class WebServicesURLProvider {

	public static String getBaseURL(Context context) {
		String url = context.getResources().getString(R.string.main_host_url);
		return url;
	}

}
