package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.ra.dq;
import com.bytedance.sdk.openadsdk.core.ra.ra;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SiteGestureView extends View {
    private long c;
    private dq hf;
    private float kd;
    private float u;
    private float w;
    private jk xj;
    private float y;

    public SiteGestureView(Context context, dq dqVar, jk jkVar) {
        super(context);
        this.hf = dqVar;
        this.xj = jkVar;
        setTag(2097610717, "click");
    }

    private void hf(int i, MotionEvent motionEvent) {
        int[] xj = r.xj(this);
        com.bytedance.sdk.openadsdk.core.ra.ra xj2 = new ra.xj().xj("express_gesture_view").u(this.kd).w(this.y).hf(motionEvent.getRawX()).xj(motionEvent.getRawY()).hf(this.c).w(getWidth()).u(getHeight()).xj(xj == null ? 0 : xj[0]).hf(xj != null ? xj[1] : 0).xj(true).xj(System.currentTimeMillis()).xj();
        this.hf.xj(i);
        this.xj.xj(this, 1, xj2, this.hf);
    }

    private boolean xj(int i, MotionEvent motionEvent) {
        if (this.hf.xj() == 1 && this.xj.xj()) {
            com.bytedance.sdk.component.utils.pl.xj("xdy", i + " ad");
            this.xj.xj(motionEvent);
            return false;
        }
        com.bytedance.sdk.component.utils.pl.xj("xdy", i + " site");
        hf(i, motionEvent);
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.w = r.u(getContext(), motionEvent.getX());
            this.u = r.u(getContext(), motionEvent.getY());
            this.kd = motionEvent.getRawX();
            this.y = motionEvent.getRawY();
            this.c = System.currentTimeMillis();
            this.xj.xj(motionEvent);
            if (this.hf.hf() == -1) {
                com.bytedance.sdk.component.utils.pl.xj("xdy", "nt ad");
                return false;
            }
            if (!this.xj.w()) {
                com.bytedance.sdk.component.utils.pl.xj("xdy", "un ad");
                return false;
            }
        } else {
            if (action == 1) {
                this.xj.hf();
                float u = r.u(getContext(), motionEvent.getX());
                float u2 = r.u(getContext(), motionEvent.getY());
                if (this.hf.w() == 0.0d) {
                    com.bytedance.sdk.component.utils.pl.xj("xdy", "nh g");
                    hf(-1, motionEvent);
                    return true;
                }
                float f = u - this.w;
                float f2 = u2 - this.u;
                float abs = Math.abs(f);
                float abs2 = Math.abs(f2);
                if (abs <= 3.0f && abs2 <= 3.0f) {
                    com.bytedance.sdk.component.utils.pl.xj("xdy", "c ad");
                    this.xj.xj(motionEvent);
                    return true;
                }
                double w = this.hf.w();
                int u3 = this.hf.u();
                if (abs > abs2) {
                    if (abs > w) {
                        long j = u3;
                        if (com.bytedance.sdk.openadsdk.core.pz.hf.xj(j, 2L) && f < 0.0f) {
                            return xj(2, motionEvent);
                        }
                        if (com.bytedance.sdk.openadsdk.core.pz.hf.xj(j, 4L) && f > 0.0f) {
                            return xj(4, motionEvent);
                        }
                    }
                } else if (abs2 > w) {
                    long j2 = u3;
                    if (com.bytedance.sdk.openadsdk.core.pz.hf.xj(j2, 8L) && f2 < 0.0f) {
                        return xj(8, motionEvent);
                    }
                    if (com.bytedance.sdk.openadsdk.core.pz.hf.xj(j2, 16L) && f2 > 0.0f) {
                        return xj(16, motionEvent);
                    }
                }
                return false;
            }
            if (action == 3) {
                com.bytedance.sdk.component.utils.pl.xj("xdy", "gesture cancel");
            }
        }
        return true;
    }
}
