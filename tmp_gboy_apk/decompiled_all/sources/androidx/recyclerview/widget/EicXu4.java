package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EicXu4 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ArrayList f9391A2egSU = new ArrayList();

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f9392A4TApA = Integer.MIN_VALUE;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f9393A5SV6n = Integer.MIN_VALUE;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f9394ADYaiT = 0;
    public final int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f9395ARc23Z;

    public EicXu4(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.f9395ARc23Z = staggeredGridLayoutManager;
        this.AMqCpz = i;
    }

    public final void A2egSU() {
        View view = (View) ADYaiT.CtFAbx.ADYaiT(this.f9391A2egSU, 1);
        EY4UKY ey4uky = (EY4UKY) view.getLayoutParams();
        this.f9393A5SV6n = this.f9395ARc23Z.f9455A5SV6n.A4TApA(view);
        ey4uky.getClass();
    }

    public final void A4TApA() {
        this.f9391A2egSU.clear();
        this.f9392A4TApA = Integer.MIN_VALUE;
        this.f9393A5SV6n = Integer.MIN_VALUE;
        this.f9394ADYaiT = 0;
    }

    public final int A5SV6n() {
        boolean z = this.f9395ARc23Z.f9459AYUAbz;
        ArrayList arrayList = this.f9391A2egSU;
        return z ? AMqCpz(arrayList.size() - 1, -1, false, true) : AMqCpz(0, arrayList.size(), false, true);
    }

    public final int ADYaiT() {
        boolean z = this.f9395ARc23Z.f9459AYUAbz;
        ArrayList arrayList = this.f9391A2egSU;
        return z ? AMqCpz(0, arrayList.size(), false, true) : AMqCpz(arrayList.size() - 1, -1, false, true);
    }

    public final int AMqCpz(int i, int i2, boolean z, boolean z2) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f9395ARc23Z;
        int AaHO0E2 = staggeredGridLayoutManager.f9455A5SV6n.AaHO0E();
        int ASJ6gh2 = staggeredGridLayoutManager.f9455A5SV6n.ASJ6gh();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View view = (View) this.f9391A2egSU.get(i);
            int AMqCpz = staggeredGridLayoutManager.f9455A5SV6n.AMqCpz(view);
            int A4TApA2 = staggeredGridLayoutManager.f9455A5SV6n.A4TApA(view);
            boolean z3 = false;
            boolean z4 = !z2 ? AMqCpz >= ASJ6gh2 : AMqCpz > ASJ6gh2;
            if (!z2 ? A4TApA2 > AaHO0E2 : A4TApA2 >= AaHO0E2) {
                z3 = true;
            }
            if (z4 && z3) {
                if (z) {
                    return staggeredGridLayoutManager.getPosition(view);
                }
                if (AMqCpz < AaHO0E2 || A4TApA2 > ASJ6gh2) {
                    return staggeredGridLayoutManager.getPosition(view);
                }
            }
            i += i3;
        }
        return -1;
    }

    public final int ARc23Z(int i) {
        int i2 = this.f9393A5SV6n;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (this.f9391A2egSU.size() == 0) {
            return i;
        }
        A2egSU();
        return this.f9393A5SV6n;
    }

    public final View ASJ6gh(int i, int i2) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f9395ARc23Z;
        ArrayList arrayList = this.f9391A2egSU;
        View view = null;
        if (i2 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.f9459AYUAbz && staggeredGridLayoutManager.getPosition(view2) >= i) || ((!staggeredGridLayoutManager.f9459AYUAbz && staggeredGridLayoutManager.getPosition(view2) <= i) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
            return view;
        }
        int size2 = arrayList.size();
        int i3 = 0;
        while (i3 < size2) {
            View view3 = (View) arrayList.get(i3);
            if ((staggeredGridLayoutManager.f9459AYUAbz && staggeredGridLayoutManager.getPosition(view3) <= i) || ((!staggeredGridLayoutManager.f9459AYUAbz && staggeredGridLayoutManager.getPosition(view3) >= i) || !view3.hasFocusable())) {
                break;
            }
            i3++;
            view = view3;
        }
        return view;
    }

    public final int AYUAbz(int i) {
        int i2 = this.f9392A4TApA;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (this.f9391A2egSU.size() == 0) {
            return i;
        }
        View view = (View) this.f9391A2egSU.get(0);
        EY4UKY ey4uky = (EY4UKY) view.getLayoutParams();
        this.f9392A4TApA = this.f9395ARc23Z.f9455A5SV6n.AMqCpz(view);
        ey4uky.getClass();
        return this.f9392A4TApA;
    }
}
