package com.bytedance.sdk.openadsdk.core.hf;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.openadsdk.core.a.dk;
import com.bytedance.sdk.openadsdk.core.j.d;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ra;
import com.bytedance.sdk.openadsdk.core.ra.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class u implements View.OnClickListener, View.OnTouchListener {
    protected static int d = 8;
    private static float hf;
    private static long kd;
    private static float u;
    private static float w;
    private static float xj;
    protected tf c = new tf();
    protected final com.bytedance.sdk.openadsdk.core.hf.xj.u f = new com.bytedance.sdk.openadsdk.core.hf.xj.u();
    protected final Context y;

    public static class xj {
        public double hf;
        public long u;
        public double w;
        public int xj;

        public xj(int i, double d, double d2, long j) {
            this.xj = i;
            this.hf = d;
            this.w = d2;
            this.u = j;
        }
    }

    static {
        try {
            if (ViewConfiguration.get(pz.getContext()) != null) {
                d = ViewConfiguration.get(pz.getContext()).getScaledTouchSlop();
            }
        } catch (Exception unused) {
        }
    }

    public u(Context context) {
        if (context == null) {
            this.y = pz.getContext();
        } else {
            this.y = context;
        }
    }

    public void kd(int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (d.xj()) {
            xj(view, this.c);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(final View view, MotionEvent motionEvent) {
        int i;
        this.c.w(motionEvent.getDeviceId());
        this.c.hf(motionEvent.getToolType(0));
        this.c.u(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.c.kd((int) motionEvent.getRawX());
            this.c.y((int) motionEvent.getRawY());
            this.c.xj(motionEvent.getRawX());
            this.c.hf(motionEvent.getRawY());
            this.c.xj(System.currentTimeMillis());
            this.c.hf(motionEvent.getToolType(0));
            this.c.w(motionEvent.getDeviceId());
            this.c.u(motionEvent.getSource());
            kd = System.currentTimeMillis();
            this.c.xj(true);
            dk.xj(motionEvent);
            i = 0;
        } else if (actionMasked != 1) {
            i = 2;
            if (actionMasked == 2) {
                w = Math.abs(motionEvent.getX() - xj) + w;
                u = Math.abs(motionEvent.getY() - hf) + u;
                xj = motionEvent.getX();
                hf = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis() - kd;
                this.c.w(motionEvent.getRawX());
                this.c.u(motionEvent.getRawY());
                if (Math.abs(this.c.zg() - this.c.f()) >= d || Math.abs(this.c.e() - this.c.d()) >= d) {
                    this.c.xj(false);
                }
                if (currentTimeMillis > 200) {
                    float f = w;
                    int i2 = d;
                    if (f > i2 || hf > i2) {
                        i = 1;
                    }
                }
            } else if (actionMasked != 3) {
                i = -1;
            } else {
                if (com.bytedance.sdk.component.adexpress.dynamic.hf.xj.xj(view) && com.bytedance.sdk.component.adexpress.dynamic.hf.xj.hf(view)) {
                    view.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hf.u.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (view.isShown()) {
                                u uVar = u.this;
                                uVar.xj(view, uVar.c);
                            }
                        }
                    });
                    return true;
                }
                i = 4;
            }
        } else {
            this.c.w(motionEvent.getRawX());
            this.c.u(motionEvent.getRawY());
            if (Math.abs(this.c.zg() - this.c.f()) >= d || Math.abs(this.c.e() - this.c.d()) >= d) {
                this.c.xj(false);
            }
            this.c.hf(System.currentTimeMillis());
            Context context = this.y;
            if (context == null) {
                context = pz.getContext();
            }
            com.bytedance.sdk.openadsdk.core.hf.xj.hf hfVar = (com.bytedance.sdk.openadsdk.core.hf.xj.hf) xj(com.bytedance.sdk.openadsdk.core.hf.xj.hf.class);
            if (hfVar != null) {
                hfVar.xj(this.c);
            }
            if (com.bytedance.sdk.component.adexpress.dynamic.hf.xj.xj(view)) {
                if (com.bytedance.sdk.component.adexpress.dynamic.hf.xj.xj(view, this.c.zg(), this.c.e(), this.c.f(), this.c.d())) {
                    return false;
                }
                if (com.bytedance.sdk.component.adexpress.dynamic.hf.xj.hf(view)) {
                    xj(view, this.c);
                }
                return true;
            }
            if (hfVar != null) {
                Point point = new Point((int) this.c.zg(), (int) this.c.e());
                if (view != null && !hfVar.xj(view, context) && hfVar.xj((View) view.getParent(), point)) {
                    return true;
                }
            }
            i = 3;
        }
        this.c.tf().put(motionEvent.getActionMasked(), new xj(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        return false;
    }

    public void u() {
    }

    public void w() {
    }

    public abstract void xj(View view, tf tfVar);

    public void xj(ra raVar) {
    }

    public <T extends com.bytedance.sdk.openadsdk.core.hf.xj.xj> T xj(Class<T> cls) {
        return (T) this.f.xj(cls);
    }
}
