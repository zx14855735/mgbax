package com.bytedance.sdk.component.adexpress.dynamic.interact.xj;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements View.OnTouchListener {
    private static int w = 10;
    private float hf;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.f kd;
    private boolean u;
    private float xj;

    public y(com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar) {
        this.kd = fVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.xj = motionEvent.getX();
            this.hf = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.xj) >= w || Math.abs(y - this.hf) >= w) {
                    this.u = true;
                }
            } else if (action == 3) {
                this.u = false;
            }
        } else {
            if (this.u) {
                this.u = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.xj) >= w || Math.abs(y2 - this.hf) >= w) {
                this.u = false;
            } else {
                com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar = this.kd;
                if (fVar != null) {
                    fVar.xj();
                }
            }
        }
        return true;
    }
}
