package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT extends ViewPager2.A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f9583A2egSU;

    public ADYaiT(ViewPager2 viewPager2) {
        this.f9583A2egSU = viewPager2;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.A2egSU
    public final void A2egSU(int i) {
        if (i == 0) {
            this.f9583A2egSU.ADYaiT();
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.A2egSU
    public final void A5SV6n(int i) {
        ViewPager2 viewPager2 = this.f9583A2egSU;
        if (viewPager2.f9588AzWtSf != i) {
            viewPager2.f9588AzWtSf = i;
            viewPager2.f9604BniPrB.A2egSU();
        }
    }
}
