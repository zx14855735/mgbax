package com.bytedance.sdk.openadsdk.core.ugeno.w;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.bytedance.adsdk.ugeno.w.jk;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.ht;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.am.u;
import com.bytedance.sdk.openadsdk.core.am.y;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.d;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends xj implements jk {
    private float c;
    private float d;
    private float f;
    private long p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.hf.w f10439pl;
    private float tf;
    private boolean y;

    public w(Activity activity, ViewGroup viewGroup, y yVar, ws wsVar, String str, int i, com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar) {
        super(activity, viewGroup, yVar, wsVar, str, i, xjVar);
    }

    private int kd() {
        return (int) ((this.xj.tq() * ht.kd(this.xj)) / 100.0d);
    }

    private void y() {
        Animation animation;
        com.bytedance.adsdk.ugeno.hf.w wVar = this.f10439pl;
        if (wVar != null) {
            wVar.hf(8);
            View d = this.f10439pl.d();
            if (d == null || (animation = d.getAnimation()) == null) {
                return;
            }
            animation.cancel();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.w.xj
    public void u() {
        super.u();
        y();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.w.xj
    public void xj(JSONObject jSONObject) {
        this.hf.xj((jk) this);
        try {
            jSONObject.put("isPlayable", "true");
            jSONObject.put("remainTime", kd());
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.w.xj
    public void xj(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
        this.f10439pl = wVar.u("fl_count_down");
    }

    private void xj(MotionEvent motionEvent) {
        if (!this.y) {
            int f = r.f(pz.getContext());
            u.xj("click", this.xj, new d.xj().y(this.c).kd(this.f).u(this.d).w(this.tf).hf(this.p).xj(motionEvent.getEventTime()).w(motionEvent.getToolType(0)).u(motionEvent.getDeviceId()).kd(this.kd).hf(f.zg().w() ? 1 : 2).xj(f).xj(r.y(pz.getContext())).hf(r.c(pz.getContext())).xj(), this.u, true, null, -1, false);
        }
        this.y = true;
    }

    @Override // com.bytedance.adsdk.ugeno.w.jk
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, MotionEvent motionEvent) {
        if (motionEvent == null || this.y) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.p = motionEvent.getDownTime();
            this.c = motionEvent.getRawX();
            this.f = motionEvent.getRawY();
            y();
            return;
        }
        if (action != 1) {
            return;
        }
        this.d = motionEvent.getRawX();
        this.tf = motionEvent.getRawY();
        xj(motionEvent);
    }
}
