package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ECyGFg extends RecyclerView.ADYaiT {

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final boolean f9375ASJ6gh = true;

    @Override // androidx.recyclerview.widget.RecyclerView.ADYaiT
    public final boolean A2egSU(Dphsd2 dphsd2, RecyclerView.ADYaiT.A2egSU a2egSU, RecyclerView.ADYaiT.A2egSU a2egSU2) {
        int i;
        int i2;
        if (a2egSU != null && ((i = a2egSU.f9431A2egSU) != (i2 = a2egSU2.f9431A2egSU) || a2egSU.f9432A4TApA != a2egSU2.f9432A4TApA)) {
            return AzWtSf(dphsd2, i, a2egSU.f9432A4TApA, i2, a2egSU2.f9432A4TApA);
        }
        AlLFFp(dphsd2);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ADYaiT
    public final boolean A4TApA(Dphsd2 dphsd2, Dphsd2 dphsd22, RecyclerView.ADYaiT.A2egSU a2egSU, RecyclerView.ADYaiT.A2egSU a2egSU2) {
        int i;
        int i2;
        int i3 = a2egSU.f9431A2egSU;
        int i4 = a2egSU.f9432A4TApA;
        if (dphsd22.shouldIgnore()) {
            int i5 = a2egSU.f9431A2egSU;
            i2 = a2egSU.f9432A4TApA;
            i = i5;
        } else {
            i = a2egSU2.f9431A2egSU;
            i2 = a2egSU2.f9432A4TApA;
        }
        return AmA8tU(dphsd2, dphsd22, i3, i4, i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ADYaiT
    public final boolean A5SV6n(Dphsd2 dphsd2, RecyclerView.ADYaiT.A2egSU a2egSU, RecyclerView.ADYaiT.A2egSU a2egSU2) {
        int i = a2egSU.f9431A2egSU;
        int i2 = a2egSU.f9432A4TApA;
        View view = dphsd2.itemView;
        int left = a2egSU2 == null ? view.getLeft() : a2egSU2.f9431A2egSU;
        int top = a2egSU2 == null ? view.getTop() : a2egSU2.f9432A4TApA;
        if (dphsd2.isRemoved() || (i == left && i2 == top)) {
            B25kr6(dphsd2);
            return true;
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return AzWtSf(dphsd2, i, i2, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ADYaiT
    public final boolean ADYaiT(Dphsd2 dphsd2, RecyclerView.ADYaiT.A2egSU a2egSU, RecyclerView.ADYaiT.A2egSU a2egSU2) {
        int i = a2egSU.f9431A2egSU;
        int i2 = a2egSU2.f9431A2egSU;
        if (i != i2 || a2egSU.f9432A4TApA != a2egSU2.f9432A4TApA) {
            return AzWtSf(dphsd2, i, a2egSU.f9432A4TApA, i2, a2egSU2.f9432A4TApA);
        }
        AYUAbz(dphsd2);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ADYaiT
    public final boolean ARc23Z(Dphsd2 dphsd2) {
        return !this.f9375ASJ6gh || dphsd2.isInvalid();
    }

    public abstract void AlLFFp(Dphsd2 dphsd2);

    public abstract boolean AmA8tU(Dphsd2 dphsd2, Dphsd2 dphsd22, int i, int i2, int i3, int i4);

    public abstract boolean AzWtSf(Dphsd2 dphsd2, int i, int i2, int i3, int i4);

    public abstract void B25kr6(Dphsd2 dphsd2);
}
