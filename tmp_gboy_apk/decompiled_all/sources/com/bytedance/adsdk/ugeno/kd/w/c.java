package com.bytedance.adsdk.ugeno.kd.w;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.kd.p;
import com.bytedance.adsdk.ugeno.y.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends hf implements d.xj {
    private Handler g;
    private int p;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10072pl;

    public c(Context context) {
        super(context);
        this.p = 500;
        this.g = new d(Looper.getMainLooper(), this);
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
        p pVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.g.sendEmptyMessageDelayed(1102, this.p);
        } else {
            if (action == 1) {
                if (this.f10072pl && (pVar = this.xj) != null) {
                    pVar.xj(this.hf, this.y, this.w.hf());
                    this.f10072pl = false;
                    Handler handler = this.g;
                    if (handler != null) {
                        handler.removeMessages(1102);
                    }
                    return true;
                }
                Handler handler2 = this.g;
                if (handler2 != null) {
                    handler2.removeMessages(1102);
                }
                this.f10072pl = false;
                return false;
            }
            if (action == 3) {
                Handler handler3 = this.g;
                if (handler3 != null) {
                    handler3.removeMessages(1102);
                }
                this.f10072pl = false;
            }
        }
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.y.d.xj
    public void xj(Message message) {
        if (message.what != 1102) {
            return;
        }
        this.f10072pl = true;
        Handler handler = this.g;
        if (handler != null) {
            handler.removeMessages(1102);
        }
    }
}
