package com.heimdall.center.console.utils;

import com.alibaba.fastjson.JSONObject;
import com.heimdall.center.console.common.Constants;
import com.heimdall.center.console.common.ErrorEnum;

public class CommonUtil {
    public static JSONObject successJson() {
        return successJson(new JSONObject());
    }

    public static JSONObject successJson(Object returnData) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("returnCode", Constants.SUCCESS_CODE);
        resultJson.put("returnMsg", Constants.SUCCESS_MSG);
        resultJson.put("returnData", returnData);
        return resultJson;
    }

    public static JSONObject errorJson(ErrorEnum errorEnum) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("returnCode", errorEnum.getErrorCode());
        resultJson.put("returnMsg", errorEnum.getErrorMsg());
        resultJson.put("returnData", new JSONObject());
        return resultJson;
    }

    public static JSONObject errorJson(ErrorEnum errorEnum,String msg) {
        JSONObject resultJson = errorJson(errorEnum);
        resultJson.put("returnMsg", errorEnum.getErrorMsg() + " " + msg);
        return resultJson;
    }

    public static void hasAllRequired(JSONObject requestJson, String... requiredFields) {
        for (String field : requiredFields) {
            if (!requestJson.containsKey(field)) {
                throw new RuntimeException("缺少必填参数" + field);
            }
        }
    }
}
