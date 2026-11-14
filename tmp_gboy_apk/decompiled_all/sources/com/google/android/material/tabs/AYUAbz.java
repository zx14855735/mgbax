package com.google.android.material.tabs;

import MOpbMP.AzWtSf;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final TabLayout f11834A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ViewPager2 f11835A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public RecyclerView.A2egSU f11836A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f11837ADYaiT;

    public AYUAbz(TabLayout tabLayout, ViewPager2 viewPager2, AzWtSf azWtSf) {
        this.f11834A2egSU = tabLayout;
        this.f11835A4TApA = viewPager2;
    }

    public final void A2egSU() {
        TabLayout tabLayout = this.f11834A2egSU;
        tabLayout.AcNBzu();
        RecyclerView.A2egSU a2egSU = this.f11836A5SV6n;
        if (a2egSU != null) {
            int itemCount = a2egSU.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                TabLayout.A2egSU AZkASS2 = tabLayout.AZkASS();
                if (i == 0) {
                    AZkASS2.A2egSU("游戏详情");
                } else if (i == 1) {
                    AZkASS2.A2egSU("存档分享");
                }
                tabLayout.A5SV6n(AZkASS2, tabLayout.f11843AlLFFp.size(), false);
            }
            if (itemCount > 0) {
                int min = Math.min(this.f11835A4TApA.getCurrentItem(), tabLayout.getTabCount() - 1);
                if (min != tabLayout.getSelectedTabPosition()) {
                    tabLayout.AzWtSf(tabLayout.AZOQYO(min), true);
                }
            }
        }
    }
}
