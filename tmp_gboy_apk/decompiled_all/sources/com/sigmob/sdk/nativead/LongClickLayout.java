package com.sigmob.sdk.nativead;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class LongClickLayout extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Runnable f13591a;
    private boolean b;

    public LongClickLayout(Context context) {
        super(context);
        this.b = false;
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        this.b = true;
        performLongClick();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.b = false;
            postDelayed(this.f13591a, 2000);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            removeCallbacks(this.f13591a);
            if (this.b) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public LongClickLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        a(context);
    }

    private void a(Context context) {
        this.f13591a = new ARc23Z(5, this);
    }

    public LongClickLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = false;
        a(context);
    }
}
