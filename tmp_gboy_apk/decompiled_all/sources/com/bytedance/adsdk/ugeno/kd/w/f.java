package com.bytedance.adsdk.ugeno.kd.w;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.kd.p;
import com.bytedance.adsdk.ugeno.y.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f extends hf implements d.xj {
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private Handler f10073pl;

    public f(Context context) {
        super(context);
        this.p = 500;
        this.f10073pl = new d(Looper.getMainLooper(), this);
    }

    @Override // com.bytedance.adsdk.ugeno.kd.w.hf
    public boolean xj(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        this.p = com.bytedance.adsdk.ugeno.y.w.xj(this.kd.get("delay"), 500);
        return xj(this.hf, motionEvent);
    }

    private boolean xj(com.bytedance.adsdk.ugeno.hf.w wVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f10073pl.sendEmptyMessageDelayed(1101, this.p);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        this.f10073pl.removeMessages(1101);
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.y.d.xj
    public void xj(Message message) {
        if (message.what != 1101) {
            return;
        }
        p pVar = this.xj;
        if (pVar != null) {
            pVar.xj(this.hf, this.y, this.w.hf());
        }
        Handler handler = this.f10073pl;
        if (handler != null) {
            handler.removeMessages(1101);
        }
    }
}
