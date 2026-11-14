package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends ViewPager2.A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ArrayList f9569A2egSU = new ArrayList(3);

    @Override // androidx.viewpager2.widget.ViewPager2.A2egSU
    public final void A2egSU(int i) {
        try {
            Iterator it = this.f9569A2egSU.iterator();
            while (it.hasNext()) {
                ((ViewPager2.A2egSU) it.next()).A2egSU(i);
            }
        } catch (ConcurrentModificationException e) {
            throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.A2egSU
    public final void A4TApA(int i, float f, int i2) {
        try {
            Iterator it = this.f9569A2egSU.iterator();
            while (it.hasNext()) {
                ((ViewPager2.A2egSU) it.next()).A4TApA(i, f, i2);
            }
        } catch (ConcurrentModificationException e) {
            throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.A2egSU
    public final void A5SV6n(int i) {
        try {
            Iterator it = this.f9569A2egSU.iterator();
            while (it.hasNext()) {
                ((ViewPager2.A2egSU) it.next()).A5SV6n(i);
            }
        } catch (ConcurrentModificationException e) {
            throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e);
        }
    }
}
