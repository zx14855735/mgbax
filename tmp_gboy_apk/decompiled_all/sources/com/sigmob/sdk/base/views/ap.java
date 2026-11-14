package com.sigmob.sdk.base.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.logger.SigmobLogger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ap extends v {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13268a = "ap";
    private ao b;
    private e c;
    private boolean d;

    public ap(Context context) {
        super(context);
        this.d = false;
        View fVar = new f(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(fVar, layoutParams);
        this.c = new e(context);
        this.b = new ao(context);
        this.c.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.c);
        addView(this.b);
        c();
    }

    private void c() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.base.views.ap.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ap.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                ap.this.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int width = (int) (getWidth() * 0.25f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, (int) (width * 1.62f));
        layoutParams.setMargins(0, (int) (getHeight() * 0.38f), 0, 0);
        layoutParams.addRule(14);
        this.b.setLayoutParams(layoutParams);
    }

    @Override // com.sigmob.sdk.base.views.v
    public void a() {
        this.d = true;
        ao aoVar = this.b;
        if (aoVar != null) {
            aoVar.a();
        }
    }

    @Override // com.sigmob.sdk.base.views.v
    public void b() {
        this.d = false;
        e eVar = this.c;
        if (eVar != null) {
            eVar.a(0.0f);
        }
        ao aoVar = this.b;
        if (aoVar != null) {
            aoVar.b();
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

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        c();
    }

    public ap(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = false;
        c();
    }

    public void a(float f) {
        e eVar = this.c;
        if (eVar == null || !this.d) {
            return;
        }
        eVar.a(f);
        SigmobLogger.d(f13268a, "updateProcess: process = " + f, new Object[0]);
    }

    public ap(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = false;
        c();
    }
}
