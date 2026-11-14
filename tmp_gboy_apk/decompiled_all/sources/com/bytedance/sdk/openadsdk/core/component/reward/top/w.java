package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.w.tf;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class w implements hf {
    protected int c = 0;
    protected ws hf;
    protected com.bytedance.sdk.openadsdk.core.component.reward.hf.kd kd;
    protected com.bytedance.sdk.openadsdk.core.component.reward.hf.hf u;
    protected ws w;
    protected boolean xj;
    protected TTBaseVideoActivity y;

    public w(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar, com.bytedance.sdk.openadsdk.core.component.reward.hf.hf hfVar, com.bytedance.sdk.openadsdk.core.component.reward.hf.kd kdVar, boolean z) {
        this.y = tTBaseVideoActivity;
        this.hf = wsVar;
        this.u = hfVar;
        this.kd = kdVar;
        this.xj = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void c(View view) {
        xj(7);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void hf(View view) {
        xj(3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void kd(View view) {
        xj(5);
        this.y.f(3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void u(View view) {
        xj(4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void w(View view) {
        xj(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void xj(View view) {
        xj(2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.hf
    public void y(View view) {
        xj(6);
    }

    public boolean xj() {
        if (v.p(this.hf) || aq.hf() <= 0) {
            return false;
        }
        int i = this.c;
        this.c = i + 1;
        if (i < aq.hf()) {
            return false;
        }
        am.xj().xj(this.hf, "stats_reward_full_close_force", this.y.wn().xj(new JSONObject()));
        this.y.finish();
        return true;
    }

    public void xj(int i) {
        this.y.qd();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("topImpl", getClass().getName());
            jSONObject.put("topType", i);
        } catch (Throwable unused) {
        }
        am.xj().xj(this.hf, "stats_reward_full_top_handle", jSONObject);
    }

    public void xj(ws wsVar) {
        this.w = wsVar;
    }

    public boolean xj(tf tfVar) {
        ws wsVar = this.w;
        if (wsVar != null) {
            return this.y.xj(wsVar, tfVar);
        }
        return this.y.xj(this.hf, tfVar);
    }
}
