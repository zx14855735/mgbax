package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.ra.qt;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class EasyPlayableContainer extends FrameLayout {
    private final qt hf;
    private final ws w;
    private final c xj;

    public EasyPlayableContainer(Context context, c cVar, qt qtVar, ws wsVar) {
        super(context);
        this.xj = cVar;
        this.hf = qtVar;
        this.w = wsVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.xj;
        if (cVar != null) {
            cVar.hf();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.xj;
        if (cVar != null) {
            cVar.w();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.hf == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        float u = r.u(getContext(), motionEvent.getX());
        float u2 = r.u(getContext(), motionEvent.getY());
        if (this.hf.xj(u, u2)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            com.bytedance.sdk.openadsdk.core.dk.hf.xj(this.w, u, u2, 1);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.hf == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.hf.xj(r.u(getContext(), motionEvent.getX()), r.u(getContext(), motionEvent.getY()))) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
