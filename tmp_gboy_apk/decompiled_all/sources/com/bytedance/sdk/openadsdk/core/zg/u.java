package com.bytedance.sdk.openadsdk.core.zg;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.j;
import com.bytedance.sdk.openadsdk.core.pz;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    public static void hf(String str) {
        w(str);
    }

    private static void w(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.u.hf.w xj = j.xj("fsswiper_freq");
        try {
            String str2 = xj.get(str, "");
            JSONObject jSONObject = TextUtils.isEmpty(str2) ? new JSONObject() : new JSONObject(str2);
            String xj2 = xj();
            int optInt = jSONObject.optInt(xj2, 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(xj2, optInt + 1);
            xj.put(str, jSONObject2.toString());
        } catch (Exception unused) {
        }
    }

    public static boolean xj(String str) {
        String str2;
        int ut;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            str2 = j.xj("fsswiper_freq").get(str, "");
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(str2) && (ut = pz.hf().ut()) > 0) {
            return new JSONObject(str2).optInt(xj(), 0) >= ut;
        }
        return false;
    }

    @SuppressLint({"SimpleDateFormat"})
    private static String xj() {
        try {
            return new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
        } catch (Exception unused) {
            return null;
        }
    }
}
