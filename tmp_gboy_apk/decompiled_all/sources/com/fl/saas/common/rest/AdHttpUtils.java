package com.fl.saas.common.rest;

import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.http.HttpUtils;
import com.fl.saas.config.utils.AesUtils;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.json.Yson;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdHttpUtils extends HttpUtils {
    private static volatile AdHttpUtils instance;

    public static AdHttpUtils getInstance() {
        if (instance == null) {
            synchronized (AdHttpUtils.class) {
                try {
                    if (instance == null) {
                        instance = new AdHttpUtils();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public static String reqObjToStr(Object obj) {
        String encrypt = AesUtils.encrypt(new Yson().toJson(obj));
        LogcatUtil.d("YdSDK_REQ", encrypt);
        return encrypt;
    }

    @Override // com.fl.saas.config.http.HttpUtils
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(CommConstant.SdkVersion.SDK_VERSION_KEY, "2.8.8");
        hashMap.put("apiVersion", CommConstant.API.ApiVersion);
        return hashMap;
    }
}
