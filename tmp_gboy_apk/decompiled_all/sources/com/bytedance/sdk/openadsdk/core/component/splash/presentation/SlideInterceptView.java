package com.bytedance.sdk.openadsdk.core.component.splash.presentation;

import android.content.Context;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.wa;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SlideInterceptView extends View implements ai.xj {
    private boolean c;
    private final xj d;
    private final wa f;
    private float hf;
    private float kd;
    private final ai p;
    private final com.bytedance.adsdk.ugeno.w.hf.xj tf;
    private MotionEvent u;
    private long w;
    private float xj;
    private float y;

    public interface xj {
        void xj(View view, tf tfVar);
    }

    public SlideInterceptView(Context context, wa waVar, xj xjVar) {
        super(context);
        this.c = false;
        this.tf = new com.bytedance.adsdk.ugeno.w.hf.xj();
        this.p = new ai(this);
        this.f = waVar;
        this.d = xjVar;
    }

    private boolean xj(float f, float f2, int i, int i2) {
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        boolean z3 = (i & 4) == 4;
        boolean z4 = (i & 8) == 8;
        if (z && (-f2) > i2) {
            return true;
        }
        if (z2 && f2 > i2) {
            return true;
        }
        if (!z3 || (-f) <= i2) {
            return z4 && f > ((float) i2);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x007e, code lost:
    
        if (r11 != 3) goto L12;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.splash.presentation.SlideInterceptView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean xj(float f, float f2, long j, int i, int i2) {
        if (i <= 0 || j < i) {
            return false;
        }
        float f3 = i2;
        return Math.abs(f) <= f3 && Math.abs(f2) <= f3;
    }

    private tf xj(float f, float f2, MotionEvent motionEvent) {
        tf tfVar = new tf();
        tfVar.xj(this.xj);
        tfVar.hf(this.hf);
        tfVar.w(f);
        tfVar.u(f2);
        tfVar.u(motionEvent.getSource());
        tfVar.xj(this.w);
        tfVar.hf(System.currentTimeMillis());
        return tfVar;
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        if (!xj(this.kd - this.xj, this.y - this.hf, System.currentTimeMillis() - this.w, this.f.ra(), r.w(getContext(), this.f.dk())) || this.c) {
            return;
        }
        this.c = true;
        xj xjVar = this.d;
        if (xjVar != null) {
            xjVar.xj(this, xj(this.kd, this.y, this.u));
        }
    }

    public void xj() {
        this.p.removeMessages(1);
    }
}
