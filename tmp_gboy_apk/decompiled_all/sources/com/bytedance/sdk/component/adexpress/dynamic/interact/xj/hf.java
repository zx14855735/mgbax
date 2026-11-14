package com.bytedance.sdk.component.adexpress.dynamic.interact.xj;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements View.OnTouchListener {
    private float hf;
    private InteractViewContainer kd;
    private boolean u;
    private long w;
    private float xj;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.f y;

    public hf(InteractViewContainer interactViewContainer, com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar) {
        this.kd = interactViewContainer;
        this.y = fVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.w = System.currentTimeMillis();
            this.xj = motionEvent.getX();
            this.hf = motionEvent.getY();
            this.kd.kd();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.xj) >= com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), 10.0f) || Math.abs(y - this.hf) >= com.bytedance.sdk.component.adexpress.u.f.xj(com.bytedance.sdk.component.adexpress.u.getContext(), 10.0f)) {
                    this.u = true;
                    this.kd.y();
                }
            }
        } else {
            if (this.u) {
                return false;
            }
            if (System.currentTimeMillis() - this.w >= 1500) {
                com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar = this.y;
                if (fVar != null) {
                    fVar.xj();
                }
            }
            this.kd.y();
        }
        return true;
    }
}
