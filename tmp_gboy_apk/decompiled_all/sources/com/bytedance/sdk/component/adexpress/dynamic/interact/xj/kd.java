package com.bytedance.sdk.component.adexpress.dynamic.interact.xj;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd implements View.OnTouchListener {
    private float hf;
    private int kd;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.f u;
    private boolean w;
    private float xj;

    public kd(com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar, int i) {
        this.u = fVar;
        this.kd = i;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar;
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
                return false;
            }
            int hf = com.bytedance.sdk.component.adexpress.u.f.hf(com.bytedance.sdk.component.adexpress.u.getContext(), Math.abs(this.hf - this.xj));
            if (this.hf - this.xj < 0.0f && hf > this.kd && (fVar = this.u) != null) {
                fVar.xj();
                this.xj = 0.0f;
                this.hf = 0.0f;
                this.w = false;
            }
        }
        return true;
    }
}
