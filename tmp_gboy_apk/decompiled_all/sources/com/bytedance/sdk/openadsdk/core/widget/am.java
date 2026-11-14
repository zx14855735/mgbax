package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class am {
    private int c;
    private float kd;
    private boolean p;
    private float u;
    private final xj xj;
    private int y;
    private boolean hf = false;
    private boolean w = false;
    private boolean f = true;
    private boolean d = false;
    private final View.OnTouchListener tf = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.am.1
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (am.this.xj.qt()) {
                return am.this.hf || !am.this.w;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                am amVar = am.this;
                amVar.p = amVar.xj(motionEvent);
                am.this.u = x;
                am.this.kd = y;
                am.this.y = (int) x;
                am.this.c = (int) y;
                am.this.f = true;
                if (am.this.xj != null && am.this.w && !am.this.hf) {
                    am.this.xj.xj(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x - am.this.y) > 20.0f || Math.abs(y - am.this.c) > 20.0f) {
                    am.this.f = false;
                }
                if (!am.this.hf) {
                    am.this.f = true;
                }
                am.this.d = false;
                am.this.u = 0.0f;
                am.this.kd = 0.0f;
                am.this.y = 0;
                if (am.this.xj != null) {
                    am.this.xj.xj(view, am.this.f);
                }
                am.this.p = false;
            } else if (action != 2) {
                if (action == 3) {
                    am.this.p = false;
                }
            } else if (am.this.hf && !am.this.p) {
                float f = x - am.this.u;
                float f2 = y - am.this.kd;
                float abs = Math.abs(f);
                float abs2 = Math.abs(f2);
                if (!am.this.d) {
                    if (abs <= 20.0f && abs2 <= 20.0f) {
                        return true;
                    }
                    am.this.d = true;
                }
                if (am.this.xj != null) {
                    am.this.xj.am();
                }
                am.this.u = x;
                am.this.kd = y;
            }
            return am.this.hf || !am.this.w;
        }
    };

    public interface xj {
        void am();

        boolean qt();

        void xj(View view, boolean z);
    }

    public am(xj xjVar) {
        this.xj = xjVar;
    }

    public void xj(View view) {
        if (view != null) {
            view.setOnTouchListener(this.tf);
        }
    }

    public void xj(boolean z) {
        this.w = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xj(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int u = r.u(pz.getContext().getApplicationContext());
        int kd = r.kd(pz.getContext().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f = u;
        if (rawX <= f * 0.01f || rawX >= f * 0.99f) {
            return true;
        }
        float f2 = kd;
        return rawY <= 0.01f * f2 || rawY >= f2 * 0.99f;
    }
}
