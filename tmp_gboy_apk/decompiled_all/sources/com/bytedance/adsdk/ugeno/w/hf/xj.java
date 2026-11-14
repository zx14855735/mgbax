package com.bytedance.adsdk.ugeno.w.hf;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public String xj = "GesThrough_";
    private List<MotionEvent> hf = new ArrayList();
    private Set<String> w = Collections.synchronizedSet(new HashSet());

    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, MotionEvent motionEvent) {
        if (wVar == null || motionEvent == null || this.hf == null) {
            return;
        }
        xj(wVar.d(), wVar.j(), motionEvent);
    }

    public void xj(View view, String str, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || this.hf == null) {
            return;
        }
        this.xj = "GesThrough_".concat(String.valueOf(str));
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        if (motionEvent.getAction() == 0) {
            this.hf.clear();
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(i, i2);
        this.hf.add(obtain);
    }

    public boolean xj(MotionEvent motionEvent) {
        if (motionEvent == null || this.w == null) {
            return false;
        }
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        return this.w.contains(motionEvent.getDownTime() + "_" + pointerId);
    }

    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar) {
        if (this.hf.isEmpty() || this.w == null || wVar == null || wVar.d() == null || wVar.d().getRootView() == null) {
            return;
        }
        xj(wVar.d());
    }

    public void xj(View view) {
        if (this.hf.isEmpty() || this.w == null || view == null || view.getRootView() == null) {
            return;
        }
        final View rootView = view.getRootView();
        this.hf.size();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.adsdk.ugeno.w.hf.xj.1
            @Override // java.lang.Runnable
            public void run() {
                for (MotionEvent motionEvent : xj.this.hf) {
                    if (motionEvent != null) {
                        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                        xj.this.w.add(motionEvent.getDownTime() + "_" + pointerId);
                        rootView.dispatchTouchEvent(motionEvent);
                        motionEvent.recycle();
                    }
                }
                xj.this.hf.clear();
            }
        }, 300L);
    }
}
