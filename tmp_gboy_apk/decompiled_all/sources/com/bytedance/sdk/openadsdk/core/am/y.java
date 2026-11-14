package com.bytedance.sdk.openadsdk.core.am;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.br;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.tf;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    private final ws hf;
    private volatile boolean xj = false;
    private String w = "landingpage";
    private long u = 0;
    private long kd = 0;
    private long y = 0;
    private long c = 0;
    private long f = 0;
    private long d = 0;
    private AtomicInteger tf = new AtomicInteger(0);
    private boolean p = false;

    /* renamed from: pl, reason: collision with root package name */
    private AtomicBoolean f10294pl = new AtomicBoolean(false);

    public y(ws wsVar) {
        this.hf = wsVar;
    }

    public void u() {
        if (this.f10294pl.get() || !this.xj) {
            return;
        }
        u.xj(this.hf, this.w, "load", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.am.y.1
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "ugen");
                if (y.this.hf != null && tf.f(y.this.hf)) {
                    jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(y.this.hf.yo()));
                }
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject2, y.this.hf);
                jSONObject.putOpt(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                jSONObject.put(MediationConstant.EXTRA_DURATION, Math.min(System.currentTimeMillis() - y.this.d, 600000L));
            }
        });
    }

    public void w() {
        this.y = System.currentTimeMillis();
        this.u = System.currentTimeMillis();
    }

    public void hf() {
        if (this.xj) {
            return;
        }
        this.c = System.currentTimeMillis();
        this.d = System.currentTimeMillis();
        this.xj = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            ws wsVar = this.hf;
            if (wsVar != null && tf.f(wsVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.hf.yo()));
            }
        } catch (Exception unused) {
        }
        xj("load_start", jSONObject);
    }

    public y xj(boolean z) {
        this.p = z;
        return this;
    }

    public void xj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            ws wsVar = this.hf;
            if (wsVar != null && tf.f(wsVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.hf.yo()));
            }
        } catch (JSONException e) {
            pl.xj(e);
        }
        xj("open_url_h5", jSONObject);
    }

    public void xj(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "ugen");
            ws wsVar = this.hf;
            if (wsVar != null && tf.f(wsVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.hf.yo()));
            }
            jSONObject.putOpt(PluginConstants.KEY_ERROR_CODE, Integer.valueOf(i));
            jSONObject.putOpt(br.c, str);
        } catch (JSONException e) {
            pl.xj(e);
        }
        xj("load_fail", jSONObject);
    }

    public void xj(long j) {
        if (this.f10294pl.get()) {
            return;
        }
        this.f10294pl.set(true);
        this.f = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        long j2 = this.f - this.c;
        try {
            jSONObject.putOpt("render_type", "ugen");
            jSONObject.put("net_work_duration", j);
            ws wsVar = this.hf;
            if (wsVar != null && tf.f(wsVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.hf.yo()));
            }
        } catch (JSONException e) {
            pl.xj(e);
        }
        xj("load_finish", jSONObject, Math.min(j2, 600000L));
    }

    public void xj(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        this.kd = currentTimeMillis;
        long max = currentTimeMillis - Math.max(this.u, this.y);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_status", 2);
            jSONObject.put("max_scroll_percent", this.tf.get());
            jSONObject.put("is_slide", i);
            jSONObject.putOpt("render_type", "ugen");
            ws wsVar = this.hf;
            if (wsVar != null && tf.f(wsVar)) {
                jSONObject.putOpt("native_lp_tpl_id", Integer.valueOf(this.hf.yo()));
            }
        } catch (JSONException e) {
            pl.xj(e);
        }
        xj("stay_page", jSONObject, Math.min(max, 600000L));
    }

    private void xj(String str, JSONObject jSONObject) {
        xj(str, jSONObject, -1L);
    }

    private void xj(String str, JSONObject jSONObject, long j) {
        JSONObject jSONObject2;
        if (!this.p || this.hf == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject3 = null;
        if (jSONObject != null) {
            try {
                jSONObject2 = new JSONObject();
            } catch (JSONException e) {
                e = e;
            }
            try {
                jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                if (j > 0) {
                    jSONObject2.put(MediationConstant.EXTRA_DURATION, j);
                }
                jSONObject3 = jSONObject2;
            } catch (JSONException e2) {
                e = e2;
                jSONObject3 = jSONObject2;
                pl.xj(e);
                u.w(this.hf, this.w, str, jSONObject3);
            }
        }
        u.w(this.hf, this.w, str, jSONObject3);
    }
}
