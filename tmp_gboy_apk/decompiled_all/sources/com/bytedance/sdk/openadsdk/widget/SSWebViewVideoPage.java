package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ScrollView;
import com.bytedance.sdk.component.widget.SSWebView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SSWebViewVideoPage extends SSWebView {
    private boolean c;
    private ViewParent f;
    private boolean kd;
    private float y;

    public SSWebViewVideoPage(Context context) {
        super(context);
        this.kd = true;
        this.y = -1.0f;
        this.c = false;
    }

    public void c() {
        if (this.c) {
            return;
        }
        this.f.requestDisallowInterceptTouchEvent(false);
        this.c = true;
    }

    @Override // android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0 && z2) {
            this.kd = true;
        } else {
            this.kd = false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f == null) {
            this.f = xj((View) this);
        }
        if (motionEvent.getAction() == 0) {
            this.y = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            float y = motionEvent.getY() - this.y;
            if (y > 0.0f) {
                xj(true);
            } else if (y != 0.0f && y < 0.0f) {
                xj(false);
            }
            this.y = motionEvent.getY();
        } else if (motionEvent.getAction() == 1) {
            y();
            this.c = false;
        } else if (motionEvent.getAction() == 3) {
            y();
            this.c = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void xj(boolean z) {
        if (((ScrollView) this.f).getScrollY() == 0) {
            if (z) {
                y();
                return;
            } else {
                c();
                return;
            }
        }
        if (!this.kd) {
            y();
        } else if (z) {
            c();
        } else {
            y();
        }
    }

    public void y() {
        if (this.c) {
            return;
        }
        this.f.requestDisallowInterceptTouchEvent(true);
        this.c = true;
    }
}
