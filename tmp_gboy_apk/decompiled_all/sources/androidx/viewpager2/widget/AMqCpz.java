package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz extends ViewPager2.A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f9584A2egSU;

    public AMqCpz(ViewPager2 viewPager2) {
        this.f9584A2egSU = viewPager2;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.A2egSU
    public final void A5SV6n(int i) {
        ViewPager2 viewPager2 = this.f9584A2egSU;
        viewPager2.clearFocus();
        if (viewPager2.hasFocus()) {
            viewPager2.f9594B9tovu.requestFocus(2);
        }
    }
}
