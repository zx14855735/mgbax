package com.sigmob.sdk.mraid2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ScrollView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class r extends ScrollView implements o {
    public static final float c = 1000.0f;
    private static final String d = "PageScrollView";
    private static final int e = 1000;

    /* renamed from: a, reason: collision with root package name */
    public final int f13562a;
    public final int b;
    private int f;
    private long g;
    private u h;
    private int i;

    public r(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(int i, int i2) {
        if (i > 0) {
            int i3 = this.i;
            if (this.f13562a + i3 < i2) {
                scrollTo(0, Math.abs(i) + i3);
                return;
            }
            return;
        }
        int i4 = this.i;
        if (i4 > 0) {
            scrollTo(0, i4 - Math.abs(i));
        }
    }

    @Override // com.sigmob.sdk.mraid2.o
    public void a(int i, int i2) {
        this.f = i2;
        this.g = System.currentTimeMillis();
    }

    @Override // com.sigmob.sdk.mraid2.o
    public void b(int i, int i2) {
        post(new AZkASS(this, this.f - i2, getChildAt(0).getHeight(), 1));
    }

    @Override // android.widget.ScrollView
    public void fling(int i) {
        super.fling(0);
    }

    @Override // com.sigmob.sdk.mraid2.o
    public ViewGroup getView() {
        return this;
    }

    @Override // com.sigmob.sdk.mraid2.o
    public void setPageChangedListener(u uVar) {
        this.h = uVar;
    }

    public r(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.sigmob.sdk.mraid2.o
    public void a(i iVar, int i, int i2) {
        int i3 = this.f - i2;
        post(new AZOQYO(this, a(i3), i3, getChildAt(0).getHeight(), iVar, 1));
    }

    public r(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2 = getResources().getDisplayMetrics().heightPixels;
        this.f13562a = i2;
        this.b = i2 / 2;
        this.i = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, int i, int i2, i iVar) {
        int i3;
        if (z) {
            int i4 = this.i;
            if (i > 0) {
                int i5 = i4 + this.f13562a;
                if (i5 < i2) {
                    this.i = i5;
                }
                i3 = 1;
            } else {
                if (i4 > 0) {
                    this.i = i4 - this.f13562a;
                }
                i3 = 2;
            }
            u uVar = this.h;
            if (uVar != null) {
                uVar.onPageChanged(iVar, i3, this.i / this.f13562a);
            }
        }
        smoothScrollTo(0, this.i);
    }

    private boolean a(int i) {
        int i2 = this.f13562a;
        int i3 = i % i2;
        int i4 = i / i2;
        float currentTimeMillis = ((i * 1000) * 1.0f) / (System.currentTimeMillis() - this.g);
        return currentTimeMillis >= 1000.0f || currentTimeMillis <= -1000.0f || i3 >= this.b;
    }
}
