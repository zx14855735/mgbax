package com.bytedance.sdk.openadsdk.core.multipro.hf;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public long c;
    public boolean f;
    public boolean hf;
    public long kd;
    public boolean u;
    public boolean w;
    public boolean xj;
    public long y;

    /* renamed from: com.bytedance.sdk.openadsdk.core.multipro.hf.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0173xj {
        xj j();

        boolean q();
    }

    public xj hf(boolean z) {
        this.u = z;
        return this;
    }

    public xj kd(boolean z) {
        this.w = z;
        return this;
    }

    public xj u(boolean z) {
        this.hf = z;
        return this;
    }

    public xj w(boolean z) {
        this.xj = z;
        return this;
    }

    public void xj(boolean z) {
        this.f = z;
    }

    public xj hf(long j) {
        this.y = j;
        return this;
    }

    public xj w(long j) {
        this.c = j;
        return this;
    }

    public xj xj(long j) {
        this.kd = j;
        return this;
    }

    public JSONObject xj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.xj);
            jSONObject.put("isFromVideoDetailPage", this.hf);
            jSONObject.put("isFromDetailPage", this.w);
            jSONObject.put(MediationConstant.EXTRA_DURATION, this.kd);
            jSONObject.put("totalPlayDuration", this.y);
            jSONObject.put("currentPlayPosition", this.c);
            jSONObject.put("isAutoPlay", this.u);
            jSONObject.put("isMute", this.f);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static xj xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        xj xjVar = new xj();
        xjVar.w(jSONObject.optBoolean("isCompleted"));
        xjVar.u(jSONObject.optBoolean("isFromVideoDetailPage"));
        xjVar.kd(jSONObject.optBoolean("isFromDetailPage"));
        xjVar.xj(jSONObject.optLong(MediationConstant.EXTRA_DURATION));
        xjVar.hf(jSONObject.optLong("totalPlayDuration"));
        xjVar.w(jSONObject.optLong("currentPlayPosition"));
        xjVar.hf(jSONObject.optBoolean("isAutoPlay"));
        xjVar.xj(jSONObject.optBoolean("isMute"));
        return xjVar;
    }
}
