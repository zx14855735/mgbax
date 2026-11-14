package com.bytedance.sdk.openadsdk.core.ht.xj;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.tf;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.ht.xj.hf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import com.ss.android.download.api.constant.BaseConstants;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf<T extends hf> implements xj {
    private String am;
    private String f;
    private String g;
    private String hf;
    private String kd;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10359pl;
    private String qt;
    private String tf;
    private String w;
    private String xj;
    private String u = ai.u;
    private long y = System.currentTimeMillis() / 1000;
    private int c = 0;
    private int d = 0;

    private JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("os", 1);
            com.bytedance.sdk.openadsdk.qt.hf.hf(pz.getContext(), jSONObject);
            jSONObject.put("oaid", tf.w(false));
            jSONObject.put(bn.i, tf.hf());
            jSONObject.put("android_id", tf.xj());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put(n.p, wo.d());
            jSONObject.put("ua", tf.g());
            jSONObject.put("applog_did", tf.e());
            jSONObject.put("ip", tf.am());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static hf<hf> hf() {
        return new hf<>();
    }

    private T yo() {
        return this;
    }

    public String am() {
        return this.p;
    }

    public String c() {
        return this.am;
    }

    public long d() {
        return this.y;
    }

    public String f() {
        return this.kd;
    }

    public String g() {
        return this.tf;
    }

    public String getType() {
        return this.xj;
    }

    public String kd() {
        return this.w;
    }

    public String p() {
        return this.f;
    }

    public int pl() {
        return this.d;
    }

    public String qt() {
        return this.f10359pl;
    }

    public int tf() {
        return this.c;
    }

    public String u() {
        return this.hf;
    }

    public String w() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ht.xj.xj
    public JSONObject xj() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(getType())) {
                jSONObject.put(PointParamKey.TYPE, getType());
            }
            if (!TextUtils.isEmpty(u())) {
                jSONObject.put("rit", u());
            }
            if (!TextUtils.isEmpty(kd())) {
                jSONObject.put("creative_id", kd());
            }
            if (!TextUtils.isEmpty(y())) {
                jSONObject.put("ad_sdk_version", y());
            }
            if (TextUtils.isEmpty(f())) {
                jSONObject.put(n.r, wo.p());
            } else {
                jSONObject.put(n.r, f());
            }
            if (d() > 0) {
                jSONObject.put("timestamp", d());
            }
            if (tf() > 0) {
                jSONObject.put("adtype", tf());
            }
            if (!TextUtils.isEmpty(p())) {
                jSONObject.put("req_id", p());
            }
            jSONObject.put("error_code", pl());
            if (!TextUtils.isEmpty(g())) {
                jSONObject.put("error_msg", g());
            }
            if (!TextUtils.isEmpty(am())) {
                jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, am());
            }
            if (!TextUtils.isEmpty(qt())) {
                jSONObject.put("image_url", qt());
            }
            if (!TextUtils.isEmpty(w())) {
                jSONObject.put("event_extra", w());
            }
            if (!TextUtils.isEmpty(c())) {
                jSONObject.put(MediationConstant.EXTRA_DURATION, c());
            }
            if (!TextUtils.isEmpty(f.zg().pz())) {
                jSONObject.put("appid", f.zg().pz());
            }
            if (!TextUtils.isEmpty(zg())) {
                jSONObject.put("ad_info", zg());
            }
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.3.2");
            jSONObject.put("is_plugin", ai.xj());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("conn_type", am.hf(pz.getContext()));
        } catch (Exception e) {
            pl.xj(e);
        }
        try {
            jSONObject.put("device_info", e());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public String y() {
        return this.u;
    }

    public String zg() {
        return this.qt;
    }

    public T c(String str) {
        this.tf = str;
        return yo();
    }

    public T d(String str) {
        this.qt = str;
        return yo();
    }

    public T f(String str) {
        this.p = str;
        return yo();
    }

    public T hf(String str) {
        this.g = str;
        return yo();
    }

    public T kd(String str) {
        this.am = str;
        return yo();
    }

    public T u(String str) {
        this.w = str;
        return yo();
    }

    public T w(String str) {
        this.hf = str;
        return yo();
    }

    public T y(String str) {
        this.f = str;
        return yo();
    }

    public T hf(int i) {
        this.d = i;
        return yo();
    }

    public T xj(String str) {
        this.xj = str;
        return yo();
    }

    public T xj(long j) {
        this.y = j;
        return yo();
    }

    public T xj(int i) {
        this.c = i;
        return yo();
    }
}
