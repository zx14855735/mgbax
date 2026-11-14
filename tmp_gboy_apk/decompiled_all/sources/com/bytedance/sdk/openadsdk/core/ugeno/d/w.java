package com.bytedance.sdk.openadsdk.core.ugeno.d;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.a.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements View.OnTouchListener {
    private float hf;
    private int kd;
    private xj u;
    private boolean w;
    private float xj;
    private Context y;

    public interface xj {
        void hf();

        void xj();
    }

    public w(Context context, xj xjVar, int i) {
        this.y = context;
        this.kd = i;
        this.u = xjVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.xj = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.hf = y;
                if (Math.abs(y - this.xj) > 10.0f) {
                    this.w = true;
                }
            }
        } else {
            if (!this.w) {
                xj xjVar = this.u;
                if (xjVar != null) {
                    xjVar.hf();
                }
                return true;
            }
            int u = r.u(this.y, Math.abs(this.hf - this.xj));
            if (this.hf - this.xj >= 0.0f || u <= this.kd) {
                xj xjVar2 = this.u;
                if (xjVar2 != null) {
                    xjVar2.hf();
                }
            } else {
                xj xjVar3 = this.u;
                if (xjVar3 != null) {
                    xjVar3.xj();
                }
            }
        }
        return true;
    }
}
