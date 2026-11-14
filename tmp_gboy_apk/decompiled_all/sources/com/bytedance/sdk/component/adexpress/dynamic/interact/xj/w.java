package com.bytedance.sdk.component.adexpress.dynamic.interact.xj;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements View.OnTouchListener {
    private int c;
    private boolean d;
    private boolean f;
    private float hf;
    private boolean kd;
    private float u;
    private float w;
    private float xj;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.f y;

    public w(com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar) {
        this(fVar, 5);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar2;
        com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar3;
        if (this.d) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.xj = motionEvent.getX();
            this.hf = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.u = motionEvent.getX();
                this.w = motionEvent.getY();
                if (Math.abs(this.u - this.xj) > 10.0f) {
                    this.kd = true;
                }
                if (Math.abs(this.u - this.xj) > 8.0f || Math.abs(this.w - this.hf) > 8.0f) {
                    this.f = false;
                }
                int hf = com.bytedance.sdk.component.adexpress.u.f.hf(com.bytedance.sdk.component.adexpress.u.getContext(), Math.abs(this.u - this.xj));
                if (this.u > this.xj && hf > this.c && (fVar3 = this.y) != null) {
                    fVar3.xj();
                    this.d = true;
                }
            }
        } else {
            if (!this.kd && !this.f) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int hf2 = com.bytedance.sdk.component.adexpress.u.f.hf(com.bytedance.sdk.component.adexpress.u.getContext(), Math.abs(this.u - this.xj));
            if (this.u > this.xj && hf2 > this.c && (fVar2 = this.y) != null) {
                fVar2.xj();
                this.d = true;
            }
            float abs = Math.abs(x - this.xj);
            float abs2 = Math.abs(y - this.hf);
            if ((abs < 8.0f || abs2 < 8.0f) && (fVar = this.y) != null) {
                fVar.hf();
                this.d = true;
            }
        }
        return true;
    }

    public w(com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar, int i) {
        this.c = 5;
        this.f = true;
        this.y = fVar;
        if (i > 0) {
            this.c = i;
        }
    }
}
