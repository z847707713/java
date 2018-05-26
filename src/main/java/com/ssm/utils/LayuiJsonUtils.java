package com.ssm.utils;

import com.google.gson.Gson;

public class LayuiJsonUtils {
   

	public static StringBuilder paseToJson(int allCount, Object data) {
		Gson gson = new Gson();
		StringBuilder sb =new StringBuilder();
		sb.append("{\"count\":");
        sb.append(allCount);
        sb.append(",\"code\":");
        sb.append(0);
        sb.append(",\"msg\":");
        sb.append("null");
        sb.append(",\"data\":");
        sb.append(gson.toJson(data));
        sb.append("}");
		return sb;
	}
	
}
