package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class qt {
    private float d;
    private float f;
    private float hf;
    private float p;
    private float tf;
    private float w;
    private View xj;
    private float u = 0.0f;
    private float kd = 0.0f;
    private float y = 0.0f;
    private float c = 0.0f;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10383pl = false;
    private boolean g = false;
    private boolean am = false;
    private boolean qt = false;

    public qt(View view) {
        this.xj = view;
    }

    public boolean hf(MotionEvent motionEvent) {
        this.hf = ((ViewGroup) this.xj.getParent()).getWidth();
        this.w = ((ViewGroup) this.xj.getParent()).getHeight();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.g = false;
                this.am = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f = x - this.u;
                float f2 = y - this.kd;
                this.f = this.xj.getLeft() + f;
                this.d = this.xj.getTop() + f2;
                this.tf = this.xj.getRight() + f;
                this.p = this.xj.getBottom() + f2;
                if (this.f < 0.0f) {
                    this.am = true;
                    this.f = 0.0f;
                    this.tf = this.xj.getWidth() + 0.0f;
                }
                float f3 = this.tf;
                float f4 = this.hf;
                if (f3 > f4) {
                    this.g = true;
                    this.tf = f4;
                    this.f = f4 - this.xj.getWidth();
                }
                if (this.d < 0.0f) {
                    this.d = 0.0f;
                    this.p = 0.0f + this.xj.getHeight();
                }
                float f5 = this.p;
                float f6 = this.w;
                if (f5 > f6) {
                    this.p = f6;
                    this.d = f6 - this.xj.getHeight();
                }
                this.xj.offsetLeftAndRight((int) f);
                this.xj.offsetTopAndBottom((int) f2);
                if (this.am) {
                    View view = this.xj;
                    view.offsetLeftAndRight(-view.getLeft());
                }
                if (this.g) {
                    this.xj.offsetLeftAndRight((int) (this.hf - r7.getRight()));
                }
            }
        } else {
            if (!this.qt) {
                return false;
            }
            if (((int) motionEvent.getRawX()) > this.hf / 2.0f) {
                this.f10383pl = false;
                this.xj.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(this.hf - this.xj.getWidth()).start();
                this.xj.offsetLeftAndRight((int) (this.hf - r7.getRight()));
            } else {
                this.f10383pl = true;
                this.xj.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(0.0f).start();
                View view2 = this.xj;
                view2.offsetLeftAndRight(-view2.getLeft());
            }
            this.xj.invalidate();
        }
        return true;
    }

    public boolean xj(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.u = motionEvent.getX();
            this.kd = motionEvent.getY();
            return false;
        }
        if (action != 2) {
            return false;
        }
        this.y = motionEvent.getX();
        this.c = motionEvent.getY();
        if (Math.abs(this.y - this.u) < 5.0f || Math.abs(this.c - this.kd) < 5.0f) {
            this.qt = false;
            return false;
        }
        this.qt = true;
        return true;
    }
}
