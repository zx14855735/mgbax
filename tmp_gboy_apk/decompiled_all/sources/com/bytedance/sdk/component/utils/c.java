package com.bytedance.sdk.component.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends TouchDelegate {
    private Rect hf;
    private int kd;
    private boolean u;
    private Rect w;
    private View xj;

    public c(Rect rect, View view) {
        super(rect, view);
        this.hf = rect;
        this.kd = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.w = rect2;
        int i = this.kd;
        rect2.inset(-i, -i);
        this.xj = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z2 = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                boolean z3 = this.u;
                if (z3) {
                    z = this.w.contains(x, y);
                    z2 = z3;
                } else {
                    z2 = z3;
                }
            } else {
                if (action == 3) {
                    boolean z4 = this.u;
                    this.u = false;
                    z2 = z4;
                }
                z = true;
                z2 = false;
            }
            z = true;
        } else if (this.hf.contains(x, y)) {
            this.u = true;
            z = true;
        } else {
            this.u = false;
            z = true;
            z2 = false;
        }
        if (z2) {
            View view = this.xj;
            if (z) {
                motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
            } else {
                float f = -(this.kd * 2);
                motionEvent.setLocation(f, f);
            }
            if (view.getVisibility() == 0) {
                return view.dispatchTouchEvent(motionEvent);
            }
        }
        return false;
    }
}
