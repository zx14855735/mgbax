package com.yxcorp.kuaishou.addfp.android.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    boolean f13879a;
    int b;
    boolean c;
    String d;

    public c(String str) {
        this.f13879a = true;
        if (TextUtils.isEmpty(str)) {
            this.f13879a = false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = jSONObject.optInt(MediationConstant.KEY_ERROR_CODE, 2);
            this.c = jSONObject.optBoolean("userSet", true);
            this.d = jSONObject.optString("value", "KWE_OTHER");
        } catch (JSONException e) {
            this.f13879a = false;
            e.printStackTrace();
        }
    }

    public String a(boolean z) {
        if (!this.f13879a) {
            return "KWE_OTHER";
        }
        if (z != this.c) {
            return "KWE_NPN";
        }
        int i = this.b;
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "KWE_OTHER" : "KWE_NS" : "KWE_N" : "KWE_PE" : "KWE_PN" : !TextUtils.isEmpty(this.d) ? this.d : "KWE_N";
    }
}
