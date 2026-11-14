package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayoutManager f9853a;
    private ViewPager2.PageTransformer b;

    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.f9853a = linearLayoutManager;
    }

    public ViewPager2.PageTransformer a() {
        return this.b;
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i, float f, int i2) {
        if (this.b == null) {
            return;
        }
        float f2 = -f;
        for (int i3 = 0; i3 < this.f9853a.getChildCount(); i3++) {
            View childAt = this.f9853a.getChildAt(i3);
            if (childAt == null) {
                Locale locale = Locale.US;
                throw new IllegalStateException("LayoutManager returned a null child at pos " + i3 + "/" + this.f9853a.getChildCount() + " while transforming pages");
            }
            this.b.transformPage(childAt, (this.f9853a.getPosition(childAt) - i) + f2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
    }

    public void a(ViewPager2.PageTransformer pageTransformer) {
        this.b = pageTransformer;
    }
}
