package com.octopus.ad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.octopus.ad.internal.utilities.HaoboLog;
import com.octopus.ad.internal.view.AdViewImpl;

@SuppressLint({"ViewConstructor"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class BannerAdView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    protected final AdViewImpl f12325a;

    public b getAdSize() {
        return this.f12325a.getAdSize();
    }

    public boolean getResizeAdToFitContainer() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AdViewImpl adViewImpl = this.f12325a;
        if (adViewImpl != null) {
            adViewImpl.s();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        b bVar;
        int i3;
        if (getResizeAdToFitContainer()) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824);
            super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(makeMeasureSpec) / 6, 1073741824));
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            try {
                bVar = getAdSize();
            } catch (NullPointerException e) {
                HaoboLog.e(HaoboLog.baseLogTag, "Unable to retrieve ad size.", e);
                bVar = null;
            }
            if (bVar != null) {
                Context context = getContext();
                int b = bVar.b(context);
                i3 = bVar.a(context);
                i4 = b;
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        int max = Math.max(i4, getSuggestedMinimumWidth());
        int max2 = Math.max(i3, getSuggestedMinimumHeight());
        if (mode == 1073741824) {
            max = View.MeasureSpec.getSize(i);
        }
        if (mode2 == 1073741824) {
            max2 = View.MeasureSpec.getSize(i2);
        }
        setMeasuredDimension(View.resolveSize(max, i), View.resolveSize(max2, i2));
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        if (i == 8) {
            this.f12325a.t();
        } else {
            this.f12325a.u();
        }
    }
}
