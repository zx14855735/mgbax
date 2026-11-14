package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.AlLFFp;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f extends AlLFFp {
    private int biF;
    private boolean biG;

    public f(Context context) {
        super(context);
        this.biG = false;
    }

    @Override // androidx.viewpager.widget.AlLFFp, android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.biG) {
            return super.canScrollHorizontally(i);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.biG) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int x = (int) motionEvent.getX();
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            int i = x - this.biF;
            if (getCurrentItem() == 0 && i > 0) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        this.biF = x;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.AlLFFp, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.biG && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.AlLFFp, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.biG && super.onTouchEvent(motionEvent);
    }

    public void setScrollable(boolean z) {
        this.biG = z;
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.biG = false;
    }
}
