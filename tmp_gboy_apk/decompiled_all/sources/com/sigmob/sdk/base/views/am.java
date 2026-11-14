package com.sigmob.sdk.base.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class am extends v {

    /* renamed from: a, reason: collision with root package name */
    private al f13262a;
    private f b;
    private boolean c;

    public am(Context context) {
        super(context);
        this.c = false;
        c();
    }

    private void c() {
        f fVar = new f(getContext());
        this.b = fVar;
        addView(fVar, new RelativeLayout.LayoutParams(-1, -1));
        this.f13262a = new al(getContext());
        addView(this.f13262a, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.sigmob.sdk.base.views.v
    public void a() {
        this.c = true;
    }

    @Override // com.sigmob.sdk.base.views.v
    public void b() {
        this.c = false;
        al alVar = this.f13262a;
        if (alVar == null) {
            return;
        }
        alVar.a(0.0f);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public am(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = false;
        c();
    }

    public void a(float f) {
        al alVar = this.f13262a;
        if (alVar == null || !this.c) {
            return;
        }
        alVar.a(f);
    }

    public am(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = false;
        c();
    }
}
