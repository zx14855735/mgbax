package com.bytedance.sdk.openadsdk.core.ugeno.tf;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.adsdk.ugeno.w.qt;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.u;
import com.bytedance.sdk.openadsdk.core.ugeno.component.skip.hf;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements ai.xj {
    private boolean ai;
    private int am;
    private w c;
    private w d;
    private boolean dk;
    private int e;
    private boolean et;
    private w f;
    private int g;
    private qt hf;
    private int ht;

    /* renamed from: io, reason: collision with root package name */
    private int f10437io;
    private int jk;
    private w kd;
    private w p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10438pl;
    private int pz;
    private int qt;
    private boolean ra;
    private w tf;
    private w u;
    private boolean v;
    private w w;
    private int x;
    protected final ai xj = new ai(Looper.getMainLooper(), this);
    private w y;
    private int yo;
    private int zg;

    public xj(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("xCreative");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("xSetting");
            String optString = jSONObject.optString("dynamic_configs", "");
            if (optJSONObject != null) {
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("video");
                if (optJSONObject3 != null) {
                    this.g = optJSONObject3.optInt("video_duration");
                }
                int optInt = optJSONObject.optInt("reward_full_time_type", 0);
                int optInt2 = optJSONObject.optInt("reward_full_play_time", 0);
                if (optInt == 1) {
                    this.am = optInt2;
                    this.v = true;
                }
            }
            if (optJSONObject2 != null) {
                if (optJSONObject2.optInt("ad_slot_type", 0) == 8) {
                    this.f10438pl = optJSONObject2.optInt("iv_skip_time", 0);
                } else {
                    this.f10438pl = optJSONObject2.optInt("rv_skip_time", 0);
                }
            }
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            try {
                if (new JSONObject(optString).optBoolean("is_show_video_duration", false)) {
                    this.v = false;
                }
            } catch (JSONException unused) {
            }
        }
    }

    private boolean u() {
        return (this.u == null && this.y == null && this.kd == null && this.f == null && this.tf == null) ? false : true;
    }

    private void w() {
        int i;
        int i2;
        w wVar;
        boolean z = true;
        if (this.v) {
            i = this.am;
            i2 = this.zg;
        } else {
            i = this.g;
            i2 = this.qt;
        }
        qt qtVar = this.hf;
        if (qtVar != null && (wVar = this.w) != null) {
            qtVar.xj(wVar, "videoProgress", Integer.valueOf(i2));
        }
        int i3 = i2 + this.e;
        int max = Math.max(0, i - i3);
        if (i3 < this.f10438pl && max != 0 && this.yo > 0) {
            z = false;
        }
        w wVar2 = this.u;
        if (wVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xj) {
            wVar2.hf(0);
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xj) this.u).xj(max, i3, this.yo);
        }
        w wVar3 = this.y;
        if (wVar3 instanceof hf) {
            ((hf) wVar3).u(z);
        }
        w wVar4 = this.c;
        if (wVar4 instanceof u) {
            ((u) wVar4).xj(max, i3, this.yo);
        }
        w wVar5 = this.kd;
        if (wVar5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.hf) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.hf) wVar5).xj(i, i3, max, z);
        }
        w wVar6 = this.f;
        if (wVar6 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.skip.xj) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.skip.xj) wVar6).hf(this.jk, this.pz);
        }
        w wVar7 = this.d;
        if (wVar7 != null) {
            wVar7.hf(this.ra ? 0 : 8);
        }
        w wVar8 = this.p;
        if (wVar8 != null) {
            wVar8.hf(this.et ? 0 : 8);
        }
        w wVar9 = this.tf;
        if (wVar9 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.w) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.w) wVar9).xj(this.ht, this.f10437io, this.x, this.dk, this.ai);
        }
    }

    public void hf() {
        this.xj.removeCallbacksAndMessages(null);
    }

    public void xj(qt qtVar, w wVar) {
        this.hf = qtVar;
        this.w = wVar;
        w kd = wVar.kd("RVCountdown");
        this.u = kd;
        if (kd == null) {
            this.u = this.w.kd("FVCountdown");
        }
        w kd2 = this.w.kd("RVSkip");
        this.y = kd2;
        if (kd2 == null) {
            this.y = this.w.kd("FVSkip");
        }
        this.kd = this.w.kd("CycleCountDownView");
        this.c = this.w.kd("RewardClickCountdown");
        this.f = this.w.kd("CycleSkip");
        this.tf = this.w.kd("CsjRefreshTip");
        this.d = this.w.u("CsjRefreshTipContainer");
        this.p = this.w.u("CsjRefreshTipCancel");
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        if (message.what != 100) {
            return;
        }
        this.xj.sendEmptyMessageDelayed(100, 200L);
        w();
    }

    public void xj() {
        if (u()) {
            this.xj.sendEmptyMessage(100);
        }
    }

    public void xj(int i, int i2, int i3, int i4) {
        this.qt = i;
        this.zg = i2;
        this.e = i3;
        this.yo = i4;
    }

    public void xj(int i, int i2) {
        this.jk = i;
        this.pz = i2;
    }

    public void xj(int i, boolean z, int i2, int i3, boolean z2, boolean z3, boolean z4) {
        this.ht = i;
        this.f10437io = i2;
        this.x = i3;
        this.ra = z2;
        this.dk = z3;
        this.et = z4;
        this.ai = z;
    }
}
