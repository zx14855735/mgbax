package com.google.android.material.tabs;

import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n implements androidx.viewpager.widget.ASJ6gh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final WeakReference f11814A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f11815A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f11816A5SV6n;

    public A5SV6n(TabLayout tabLayout) {
        this.f11814A2egSU = new WeakReference(tabLayout);
    }

    @Override // androidx.viewpager.widget.ASJ6gh
    public final void onPageScrollStateChanged(int i) {
        this.f11815A4TApA = this.f11816A5SV6n;
        this.f11816A5SV6n = i;
        TabLayout tabLayout = (TabLayout) this.f11814A2egSU.get();
        if (tabLayout != null) {
            tabLayout.f11888DUi7mC = this.f11816A5SV6n;
        }
    }

    @Override // androidx.viewpager.widget.ASJ6gh
    public final void onPageScrolled(int i, float f, int i2) {
        TabLayout tabLayout = (TabLayout) this.f11814A2egSU.get();
        if (tabLayout != null) {
            int i3 = this.f11816A5SV6n;
            tabLayout.B2KMhB(i3 != 2 || this.f11815A4TApA == 1, f, i, (i3 == 2 && this.f11815A4TApA == 0) ? false : true, false);
        }
    }

    @Override // androidx.viewpager.widget.ASJ6gh
    public final void onPageSelected(int i) {
        TabLayout tabLayout = (TabLayout) this.f11814A2egSU.get();
        if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
            return;
        }
        int i2 = this.f11816A5SV6n;
        tabLayout.AzWtSf(tabLayout.AZOQYO(i), i2 == 0 || (i2 == 2 && this.f11815A4TApA == 0));
    }
}
