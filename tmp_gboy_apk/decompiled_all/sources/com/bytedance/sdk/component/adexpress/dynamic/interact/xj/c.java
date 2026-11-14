package com.bytedance.sdk.component.adexpress.dynamic.interact.xj;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c implements View.OnTouchListener {
    private static int w = 10;
    private float hf;
    private int kd;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.f u;
    private float xj;
    private RectF y = new RectF();
    private long c = 0;
    private final int f = 200;
    private final int d = 3;
    private SoftReference<View> tf = new SoftReference<>(null);

    public c(com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar, int i, final ViewGroup viewGroup) {
        this.kd = w;
        this.u = fVar;
        if (i > 0) {
            this.kd = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.xj.c.1
                @Override // java.lang.Runnable
                public void run() {
                    View findViewById = viewGroup.findViewById(2097610746);
                    c.this.tf = new SoftReference(findViewById);
                }
            });
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.f fVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.y = xj(this.tf.get());
            this.xj = motionEvent.getRawX();
            this.hf = motionEvent.getRawY();
            this.c = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.y;
            if (rectF != null && !rectF.contains(this.xj, this.hf)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float abs = Math.abs(rawX - this.xj);
            float abs2 = Math.abs(rawY - this.hf);
            int hf = com.bytedance.sdk.component.adexpress.u.f.hf(com.bytedance.sdk.component.adexpress.u.getContext(), Math.abs(rawX - this.xj));
            int i = w;
            if (abs < i || abs2 < i) {
                if ((System.currentTimeMillis() - this.c < 200 || (abs < 3.0f && abs2 < 3.0f)) && (fVar = this.u) != null) {
                    fVar.xj();
                }
            } else if (rawX > this.xj && hf > this.kd && (fVar2 = this.u) != null) {
                fVar2.xj();
            }
        }
        return true;
    }

    private RectF xj(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], view.getWidth() + r2, view.getHeight() + iArr[1]);
    }
}
