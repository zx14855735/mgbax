package com.ss.android.downloadlib.addownload.hf;

import com.bytedance.sdk.component.utils.pl;
import com.ss.android.downloadlib.c.g;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj {
    public String c;
    public volatile long f;
    public long hf;
    public String kd;
    public String u;
    public long w;
    public long xj;
    public String y;

    public xj() {
    }

    public JSONObject xj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.xj);
            jSONObject.put("mAdId", this.hf);
            jSONObject.put("mExtValue", this.w);
            jSONObject.put("mPackageName", this.u);
            jSONObject.put("mAppName", this.kd);
            jSONObject.put("mLogExtra", this.y);
            jSONObject.put("mFileName", this.c);
            jSONObject.put("mTimeStamp", this.f);
            return jSONObject;
        } catch (JSONException e) {
            pl.xj(e);
            return jSONObject;
        }
    }

    public xj(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        this.xj = j;
        this.hf = j2;
        this.w = j3;
        this.u = str;
        this.kd = str2;
        this.y = str3;
        this.c = str4;
    }

    public static xj xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        xj xjVar = new xj();
        try {
            xjVar.xj = g.xj(jSONObject, "mDownloadId");
            xjVar.hf = g.xj(jSONObject, "mAdId");
            xjVar.w = g.xj(jSONObject, "mExtValue");
            xjVar.u = jSONObject.optString("mPackageName");
            xjVar.kd = jSONObject.optString("mAppName");
            xjVar.y = jSONObject.optString("mLogExtra");
            xjVar.c = jSONObject.optString("mFileName");
            xjVar.f = g.xj(jSONObject, "mTimeStamp");
            return xjVar;
        } catch (Exception e) {
            pl.xj(e);
            return null;
        }
    }
}
