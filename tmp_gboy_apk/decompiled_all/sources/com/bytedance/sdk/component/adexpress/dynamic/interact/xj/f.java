package com.bytedance.sdk.component.adexpress.dynamic.interact.xj;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f implements View.OnTouchListener {
    private float c;
    private final boolean hf;
    private float kd;
    private float u;
    private final int w = 10;
    private final com.bytedance.sdk.component.adexpress.dynamic.interact.f xj;
    private float y;

    public f(com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar, boolean z) {
        this.xj = fVar;
        this.hf = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.u = motionEvent.getX();
            this.kd = motionEvent.getY();
            new StringBuilder(", mStartY: ").append(this.kd);
        } else if (action == 1) {
            this.y = motionEvent.getX();
            this.c = motionEvent.getY();
            new StringBuilder(", mEndY: ").append(this.c);
            if (this.hf || (fVar2 = this.xj) == null) {
                float f = this.y - this.u;
                float f2 = this.c - this.kd;
                if (com.bytedance.sdk.component.adexpress.u.f.hf(com.bytedance.sdk.component.adexpress.u.getContext(), Math.abs((float) Math.sqrt((f2 * f2) + (f * f)))) > 10.0f && (fVar = this.xj) != null) {
                    fVar.xj();
                }
            } else {
                fVar2.xj();
            }
        }
        return true;
    }
}
