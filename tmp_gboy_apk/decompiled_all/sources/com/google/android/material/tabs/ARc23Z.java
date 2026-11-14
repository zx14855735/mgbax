package com.google.android.material.tabs;

import androidx.viewpager2.widget.ViewPager2;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z extends ViewPager2.A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final WeakReference f11830A2egSU;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f11832A5SV6n = 0;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f11831A4TApA = 0;

    public ARc23Z(TabLayout tabLayout) {
        this.f11830A2egSU = new WeakReference(tabLayout);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.A2egSU
    public final void A2egSU(int i) {
        this.f11831A4TApA = this.f11832A5SV6n;
        this.f11832A5SV6n = i;
        TabLayout tabLayout = (TabLayout) this.f11830A2egSU.get();
        if (tabLayout != null) {
            tabLayout.f11888DUi7mC = this.f11832A5SV6n;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.A2egSU
    public final void A4TApA(int i, float f, int i2) {
        TabLayout tabLayout = (TabLayout) this.f11830A2egSU.get();
        if (tabLayout != null) {
            int i3 = this.f11832A5SV6n;
            tabLayout.B2KMhB(i3 != 2 || this.f11831A4TApA == 1, f, i, (i3 == 2 && this.f11831A4TApA == 0) ? false : true, false);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.A2egSU
    public final void A5SV6n(int i) {
        TabLayout tabLayout = (TabLayout) this.f11830A2egSU.get();
        if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
            return;
        }
        int i2 = this.f11832A5SV6n;
        tabLayout.AzWtSf(tabLayout.AZOQYO(i), i2 == 0 || (i2 == 2 && this.f11831A4TApA == 0));
    }
}
