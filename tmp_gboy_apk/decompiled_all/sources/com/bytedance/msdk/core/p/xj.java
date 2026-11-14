package com.bytedance.msdk.core.p;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.f;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static volatile xj xj;
    private hf u;
    private Function<SparseArray<Object>, Object> y;
    private boolean hf = false;
    private boolean w = false;
    private boolean kd = false;

    private xj() {
    }

    public static xj xj() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public Function<SparseArray<Object>, Object> c() {
        return this.y;
    }

    public void hf() {
        this.hf = true;
    }

    public void kd() {
        hf hfVar = this.u;
        if (hfVar != null) {
            hfVar.xj();
        }
    }

    public boolean u() {
        return this.w;
    }

    public boolean w() {
        return this.hf;
    }

    public void y() {
        this.kd = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0011  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String hf(java.lang.String r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto La
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L9
            r1.<init>(r3)     // Catch: org.json.JSONException -> L9
            goto Lb
        L9:
        La:
            r1 = r0
        Lb:
            org.json.JSONObject r3 = r2.xj(r1)
            if (r3 == 0) goto L16
            java.lang.String r3 = r3.toString()
            return r3
        L16:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.p.xj.hf(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0011  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String w(java.lang.String r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto La
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L9
            r1.<init>(r3)     // Catch: org.json.JSONException -> L9
            goto Lb
        L9:
        La:
            r1 = r0
        Lb:
            org.json.JSONObject r3 = r2.hf(r1)
            if (r3 == 0) goto L16
            java.lang.String r3 = r3.toString()
            return r3
        L16:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.p.xj.w(java.lang.String):java.lang.String");
    }

    public JSONObject hf(JSONObject jSONObject) {
        String bl = f.zg().bl();
        if (TextUtils.isEmpty(bl)) {
            return jSONObject;
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("waterfall_ab_version", bl);
                return jSONObject2;
            } catch (JSONException unused) {
                return null;
            }
        }
        if (jSONObject.has("waterfall_ab_version")) {
            String optString = jSONObject.optString("waterfall_ab_version");
            if (TextUtils.isEmpty(optString)) {
                jSONObject.put("waterfall_ab_version", bl);
                return jSONObject;
            }
            jSONObject.put("waterfall_ab_version", optString + "," + bl);
            return jSONObject;
        }
        jSONObject.put("waterfall_ab_version", bl);
        return jSONObject;
    }

    public void xj(boolean z) {
        this.w = z;
    }

    public boolean xj(String str, int i, boolean z) {
        return z || xj(str) || com.bytedance.msdk.core.hf.hf().xj(str, i, 101) != null;
    }

    public boolean xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("200000000".equals(str)) {
            return true;
        }
        return str.matches("^1[0-9]{8}$");
    }

    public void xj(hf hfVar) {
        this.u = hfVar;
    }

    public void xj(int i, String str) {
        hf hfVar = this.u;
        if (hfVar != null) {
            hfVar.xj(i, str);
        }
    }

    public void xj(Function<SparseArray<Object>, Object> function) {
        this.y = function;
    }

    public JSONObject xj(JSONObject jSONObject) {
        String bl = f.zg().bl();
        if (TextUtils.isEmpty(bl)) {
            return jSONObject;
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("app_ab_version", bl);
                return jSONObject2;
            } catch (JSONException unused) {
                return null;
            }
        }
        if (jSONObject.has("app_ab_version")) {
            String optString = jSONObject.optString("app_ab_version");
            if (TextUtils.isEmpty(optString)) {
                jSONObject.put("app_ab_version", bl);
                return jSONObject;
            }
            jSONObject.put("app_ab_version", optString + "," + bl);
            return jSONObject;
        }
        jSONObject.put("app_ab_version", bl);
        return jSONObject;
    }
}
