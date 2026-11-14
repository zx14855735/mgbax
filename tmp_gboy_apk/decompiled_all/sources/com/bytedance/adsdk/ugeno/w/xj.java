package com.bytedance.adsdk.ugeno.w;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private float hf;
    private long kd;
    private long u;
    private List<C0029xj> w;
    private String xj;
    private String y;

    /* renamed from: com.bytedance.adsdk.ugeno.w.xj$xj, reason: collision with other inner class name */
    public static class C0029xj {
        private float c;
        private String d;
        private float[] f;
        private float hf;
        private String kd;
        private String tf;
        private long u;
        private String w;
        private long xj;
        private float y;

        public float[] c() {
            return this.f;
        }

        public String d() {
            return this.tf;
        }

        public String f() {
            return this.d;
        }

        public String getType() {
            return this.kd;
        }

        public float hf() {
            return this.hf;
        }

        public float kd() {
            return this.y;
        }

        public long u() {
            return this.u;
        }

        public String w() {
            return this.w;
        }

        public long xj() {
            return this.xj;
        }

        public float y() {
            return this.c;
        }

        public void hf(long j) {
            this.u = j;
        }

        public void u(String str) {
            this.d = str;
        }

        public void w(float f) {
            this.c = f;
        }

        public void xj(long j) {
            this.xj = j;
        }

        public void hf(String str) {
            this.kd = str;
        }

        public void w(String str) {
            this.tf = str;
        }

        public void xj(float f) {
            this.hf = f;
        }

        public void hf(float f) {
            this.y = f;
        }

        public void xj(String str) {
            this.w = str;
        }

        public void xj(float[] fArr) {
            this.f = fArr;
        }

        public static C0029xj xj(JSONObject jSONObject, com.bytedance.adsdk.ugeno.hf.w wVar) {
            if (jSONObject == null) {
                return null;
            }
            C0029xj c0029xj = new C0029xj();
            c0029xj.xj(jSONObject.optLong(MediationConstant.EXTRA_DURATION));
            String optString = jSONObject.optString("loop");
            if (TextUtils.equals("infinite", optString)) {
                c0029xj.xj(-1.0f);
            } else {
                try {
                    c0029xj.xj(Float.parseFloat(optString));
                } catch (NumberFormatException unused) {
                    c0029xj.xj(0.0f);
                }
            }
            c0029xj.xj(jSONObject.optString("loopMode"));
            c0029xj.hf(jSONObject.optString(PointParamKey.TYPE));
            if (TextUtils.equals(c0029xj.getType(), "ripple")) {
                c0029xj.w(jSONObject.optString("rippleColor"));
            }
            View d = wVar.d();
            Context context = d != null ? d.getContext() : null;
            if (TextUtils.equals(c0029xj.getType(), "backgroundColor")) {
                String xj = com.bytedance.adsdk.ugeno.u.hf.xj(jSONObject.optString("valueTo"), wVar.tf());
                int xj2 = com.bytedance.adsdk.ugeno.y.xj.xj(jSONObject.optString("valueFrom"));
                int xj3 = com.bytedance.adsdk.ugeno.y.xj.xj(xj);
                c0029xj.hf(xj2);
                c0029xj.w(xj3);
            } else if ((TextUtils.equals(c0029xj.getType(), "translateX") || TextUtils.equals(c0029xj.getType(), "translateY")) && context != null) {
                try {
                    float xj4 = com.bytedance.adsdk.ugeno.y.f.xj(context, (float) jSONObject.optDouble("valueFrom"));
                    float xj5 = com.bytedance.adsdk.ugeno.y.f.xj(context, (float) jSONObject.optDouble("valueTo"));
                    c0029xj.hf(xj4);
                    c0029xj.w(xj5);
                } catch (Exception unused2) {
                    com.bytedance.sdk.component.utils.pl.u("animation", "animation ");
                }
            } else {
                c0029xj.hf((float) jSONObject.optDouble("valueFrom"));
                c0029xj.w((float) jSONObject.optDouble("valueTo"));
            }
            c0029xj.u(jSONObject.optString("interpolator"));
            c0029xj.hf(com.bytedance.adsdk.ugeno.y.w.xj(com.bytedance.adsdk.ugeno.u.hf.xj(jSONObject.optString("startDelay"), wVar.tf()), 0L));
            JSONArray optJSONArray = jSONObject.optJSONArray("values");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                float[] fArr = new float[optJSONArray.length()];
                int i = 0;
                if ((TextUtils.equals(c0029xj.getType(), "translateX") || TextUtils.equals(c0029xj.getType(), "translateY")) && context != null) {
                    while (i < optJSONArray.length()) {
                        fArr[i] = com.bytedance.adsdk.ugeno.y.f.xj(context, (float) xj.xj(optJSONArray.optString(i), wVar.tf()));
                        i++;
                    }
                } else {
                    while (i < optJSONArray.length()) {
                        fArr[i] = (float) xj.xj(optJSONArray.optString(i), wVar.tf());
                        i++;
                    }
                }
                c0029xj.xj(fArr);
            }
            return c0029xj;
        }
    }

    public float hf() {
        return this.hf;
    }

    public long kd() {
        return this.kd;
    }

    public long u() {
        return this.u;
    }

    public List<C0029xj> w() {
        return this.w;
    }

    public String xj() {
        return this.xj;
    }

    public String y() {
        return this.y;
    }

    public void hf(long j) {
        this.kd = j;
    }

    public void xj(String str) {
        this.xj = str;
    }

    public void hf(String str) {
        this.y = str;
    }

    public void xj(float f) {
        this.hf = f;
    }

    public void xj(List<C0029xj> list) {
        this.w = list;
    }

    public void xj(long j) {
        this.u = j;
    }

    public static xj xj(String str, com.bytedance.adsdk.ugeno.hf.w wVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return xj(new JSONObject(str), wVar);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    public static xj xj(JSONObject jSONObject, com.bytedance.adsdk.ugeno.hf.w wVar) {
        return xj(jSONObject, null, wVar);
    }

    public static xj xj(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.adsdk.ugeno.hf.w wVar) {
        if (jSONObject == null) {
            return null;
        }
        xj xjVar = new xj();
        xjVar.xj(jSONObject.optString("ordering"));
        String optString = jSONObject.optString("loop");
        if (TextUtils.equals("infinite", optString)) {
            xjVar.xj(-1.0f);
        } else {
            try {
                xjVar.xj(Float.parseFloat(optString));
            } catch (NumberFormatException unused) {
                xjVar.xj(0.0f);
            }
        }
        xjVar.xj(jSONObject.optLong(MediationConstant.EXTRA_DURATION, 0L));
        xjVar.hf(com.bytedance.adsdk.ugeno.y.w.xj(com.bytedance.adsdk.ugeno.u.hf.xj(jSONObject.optString("startDelay"), wVar.tf()), 0L));
        xjVar.hf(jSONObject.optString("loopMode"));
        JSONArray optJSONArray = jSONObject.optJSONArray("animators");
        if (optJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (jSONObject2 != null) {
                    com.bytedance.adsdk.ugeno.y.hf.xj(jSONObject2, optJSONObject);
                }
                arrayList.add(C0029xj.xj(optJSONObject, wVar));
            }
            xjVar.xj(arrayList);
        }
        return xjVar;
    }

    public static double xj(Object obj, JSONObject jSONObject) {
        if (obj instanceof String) {
            return com.bytedance.adsdk.ugeno.y.w.xj(com.bytedance.adsdk.ugeno.u.hf.xj((String) obj, jSONObject), 0.0d);
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Long) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Integer) {
            return ((Double) obj).doubleValue();
        }
        return 0.0d;
    }
}
