package com.sigmob.sdk.base.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aw extends v {

    /* renamed from: a, reason: collision with root package name */
    private au f13277a;
    private av b;
    private ObjectAnimator c;
    private boolean d;

    public aw(Context context) {
        super(context);
        c();
    }

    private void c() {
        addView(new f(getContext()), new FrameLayout.LayoutParams(-1, -1));
        this.f13277a = new au(getContext());
        this.b = new av(getContext());
        addView(this.f13277a, new ViewGroup.LayoutParams(-1, -1));
        addView(this.b, new ViewGroup.LayoutParams(-1, -1));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, (Property<av, Float>) View.ROTATION_Y, -45.0f, 0.0f, 45.0f);
        this.c = ofFloat;
        ofFloat.setDuration(1000L);
        this.c.setRepeatCount(-1);
        this.c.setRepeatMode(2);
    }

    @Override // com.sigmob.sdk.base.views.v
    public void a() {
        this.d = true;
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.c.start();
        }
    }

    @Override // com.sigmob.sdk.base.views.v
    public void b() {
        this.d = false;
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.d) {
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public aw(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public aw(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }
}
