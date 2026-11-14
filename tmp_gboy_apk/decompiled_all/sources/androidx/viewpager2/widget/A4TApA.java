package androidx.viewpager2.widget;

import De4eam.AZOQYO;
import De4eam.AaHO0E;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends ViewPager2.A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AZOQYO f9570A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public AaHO0E f9571A4TApA;

    public A4TApA(AZOQYO azoqyo) {
        this.f9570A2egSU = azoqyo;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.A2egSU
    public final void A2egSU(int i) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.A2egSU
    public final void A4TApA(int i, float f, int i2) {
        if (this.f9571A4TApA == null) {
            return;
        }
        float f2 = -f;
        int i3 = 0;
        while (true) {
            AZOQYO azoqyo = this.f9570A2egSU;
            if (i3 >= azoqyo.getChildCount()) {
                return;
            }
            View childAt = azoqyo.getChildAt(i3);
            if (childAt == null) {
                Locale locale = Locale.US;
                throw new IllegalStateException("LayoutManager returned a null child at pos " + i3 + "/" + azoqyo.getChildCount() + " while transforming pages");
            }
            this.f9571A4TApA.transformPage(childAt, (azoqyo.getPosition(childAt) - i) + f2);
            i3++;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.A2egSU
    public final void A5SV6n(int i) {
    }
}
