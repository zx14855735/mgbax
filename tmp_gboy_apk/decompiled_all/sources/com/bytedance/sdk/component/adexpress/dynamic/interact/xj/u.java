package com.bytedance.sdk.component.adexpress.dynamic.interact.xj;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements View.OnTouchListener {
    private float c;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.f d;
    private boolean f;
    private float hf;
    private boolean kd = true;
    private boolean p;
    private int tf;
    private float u;
    private float w;
    private float xj;
    private float y;

    public u(com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar, int i, boolean z) {
        this.d = fVar;
        this.tf = i;
        this.p = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar2;
        com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar3;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.xj = motionEvent.getX();
            this.hf = motionEvent.getY();
            this.y = motionEvent.getY();
            this.kd = true;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.c = y;
                if (Math.abs(y - this.y) > 10.0f) {
                    this.f = true;
                }
                this.u = motionEvent.getX();
                this.w = motionEvent.getY();
                if (Math.abs(this.u - this.xj) > 8.0f || Math.abs(this.w - this.hf) > 8.0f) {
                    this.kd = false;
                }
            }
        } else {
            if (!this.f && !this.kd) {
                return false;
            }
            if (this.p || (fVar3 = this.d) == null) {
                int hf = com.bytedance.sdk.component.adexpress.u.f.hf(com.bytedance.sdk.component.adexpress.u.getContext(), Math.abs(this.c - this.y));
                if (this.c - this.y < 0.0f && hf > this.tf && (fVar2 = this.d) != null) {
                    fVar2.xj();
                } else if (this.kd && (fVar = this.d) != null) {
                    fVar.xj();
                }
            } else {
                fVar3.xj();
            }
        }
        return true;
    }
}
