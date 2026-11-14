package com.bytedance.sdk.openadsdk.pl.xj;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.hf.xj.tf;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.yo;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.n;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj {
    protected String c;
    protected String hf;
    protected String w;
    public com.bytedance.sdk.openadsdk.pl.xj xj;
    protected JSONObject y;
    public AtomicBoolean u = new AtomicBoolean(false);
    public AtomicBoolean kd = new AtomicBoolean(false);

    /* renamed from: com.bytedance.sdk.openadsdk.pl.xj.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0203xj {
        void xj(boolean z, Map<String, Object> map);
    }

    public xj(com.bytedance.sdk.openadsdk.pl.xj xjVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        this.xj = xjVar;
        this.hf = str;
        this.c = str4;
        this.w = str2;
        JSONObject jSONObject2 = new JSONObject();
        this.y = jSONObject2;
        try {
            if (this instanceof hf) {
                jSONObject2.putOpt("log_extra", str3);
                this.y.putOpt("resource_type", "union");
                this.y.putOpt("ts", Long.valueOf(System.currentTimeMillis() / 1000));
            } else if (this instanceof w) {
                jSONObject2.putOpt("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                this.y.putOpt(MediationConstant.EXTRA_ADID, jSONObject.optString(MediationConstant.EXTRA_ADID));
                this.y.putOpt("customer_id", jSONObject.optString("customer_id"));
            }
            this.y.putOpt("cid", str);
            this.y.putOpt("ac", Integer.valueOf(am.w(pz.getContext())));
            this.y.putOpt("app_name", f.zg().ht());
            this.y.putOpt(PluginConstants.KEY_APP_ID, f.zg().pz());
            this.y.putOpt(n.r, com.bytedance.sdk.openadsdk.core.f.xj.u());
            this.y.putOpt(PluginConstants.KEY_SDK_VERSION, ai.u);
            this.y.putOpt(PluginConstants.KEY_PLUGIN_VERSION, "7.1.3.2");
            this.y.putOpt("platform", "Android");
            this.y.putOpt("device_id", yo.w());
            this.y.putOpt("web_url", str4);
        } catch (JSONException e) {
            pl.xj(e);
        }
        xj(str, str2);
    }

    public void hf() {
        xj();
    }

    public abstract void hf(Context context, String str, com.bytedance.sdk.openadsdk.pl.hf hfVar, WebResourceResponse webResourceResponse, tf tfVar, Map<String, Object> map);

    public abstract void w();

    public abstract void xj();

    public abstract void xj(Context context, String str, com.bytedance.sdk.openadsdk.pl.hf hfVar, WebResourceResponse webResourceResponse, tf tfVar, Map<String, Object> map);

    public abstract void xj(com.bytedance.sdk.openadsdk.pl.hf hfVar, WebResourceResponse webResourceResponse, tf tfVar, InterfaceC0203xj interfaceC0203xj);

    public abstract void xj(String str);

    public abstract void xj(String str, String str2);

    public abstract void xj(JSONObject jSONObject, String str, tf tfVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2);

    public abstract boolean xj(WebView webView);

    public abstract boolean xj(tf tfVar);
}
