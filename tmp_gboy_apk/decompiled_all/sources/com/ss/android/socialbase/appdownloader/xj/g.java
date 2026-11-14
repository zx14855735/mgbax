package com.ss.android.socialbase.appdownloader.xj;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import io.dcloud.openapi.core.util.Const;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g extends xj {
    public g(Context context, com.ss.android.socialbase.downloader.f.xj xjVar, String str) {
        super(context, xjVar, str);
    }

    public static String xj(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.endsWith("&") ? CtFAbx.AMqCpz(1, 0, stringBuffer2) : stringBuffer2;
    }

    @Override // com.ss.android.socialbase.appdownloader.xj.kd
    public Intent hf() {
        String w = this.hf.w("s");
        String xj = com.ss.android.socialbase.appdownloader.y.w.xj(this.hf.w("bb"), w);
        if (!TextUtils.isEmpty(xj) && xj.split(",").length == 2) {
            String xj2 = com.ss.android.socialbase.appdownloader.y.w.xj(this.hf.w("bc"), w);
            if (!TextUtils.isEmpty(xj2) && xj2.split(",").length == 2) {
                String[] split = xj.split(",");
                String[] split2 = xj2.split(",");
                String xj3 = com.ss.android.socialbase.appdownloader.y.w.xj(this.hf.w(Const.TYPE_BD), w);
                String xj4 = com.ss.android.socialbase.appdownloader.y.w.xj(this.hf.w("be"), w);
                String xj5 = com.ss.android.socialbase.appdownloader.y.w.xj(this.hf.w("bf"), w);
                HashMap hashMap = new HashMap();
                hashMap.put(split[0], split[1]);
                hashMap.put(split2[0], split2[1]);
                hashMap.put(xj3, this.w);
                Intent intent = new Intent();
                intent.setAction(xj5);
                StringBuilder A4TApA2 = AYUAbz.A4TApA(xj4);
                A4TApA2.append(xj(hashMap));
                intent.setData(Uri.parse(A4TApA2.toString()));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
