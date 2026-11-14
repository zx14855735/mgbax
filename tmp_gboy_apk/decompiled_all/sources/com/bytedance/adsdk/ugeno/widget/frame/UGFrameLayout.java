package com.bytedance.adsdk.ugeno.widget.frame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.w;
import com.bytedance.adsdk.ugeno.w.zg;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class UGFrameLayout extends FrameLayout {
    private Map<Integer, zg> hf;
    private w xj;

    public UGFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        w wVar = this.xj;
        if (wVar != null) {
            wVar.kd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w wVar = this.xj;
        if (wVar != null) {
            wVar.y();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Map<Integer, zg> map = this.hf;
        if (map == null || !map.containsKey(4)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        w wVar = this.xj;
        if (wVar != null) {
            wVar.u();
        }
        super.onLayout(z, i, i2, i3, i4);
        w wVar2 = this.xj;
        if (wVar2 != null) {
            wVar2.xj(i, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        w wVar = this.xj;
        if (wVar != null) {
            int[] xj = wVar.xj(i, i2);
            super.onMeasure(xj[0], xj[1]);
        } else {
            super.onMeasure(i, i2);
        }
        w wVar2 = this.xj;
        if (wVar2 != null) {
            wVar2.w();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        w wVar = this.xj;
        if (wVar != null) {
            wVar.hf(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(z);
        }
    }

    public void setEventMap(Map<Integer, zg> map) {
        this.hf = map;
    }

    public void xj(w wVar) {
        this.xj = wVar;
    }
}
