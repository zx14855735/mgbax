package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final A5SV6n f9170A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f9171A4TApA = 0;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f9172A5SV6n = -1;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f9173ADYaiT = -1;
    public Object AMqCpz = null;

    public ADYaiT(A5SV6n a5SV6n) {
        this.f9170A2egSU = a5SV6n;
    }

    public final void A2egSU() {
        int i = this.f9171A4TApA;
        if (i == 0) {
            return;
        }
        RecyclerView.A2egSU a2egSU = this.f9170A2egSU.f9169A2egSU;
        if (i == 1) {
            a2egSU.notifyItemRangeInserted(this.f9172A5SV6n, this.f9173ADYaiT);
        } else if (i == 2) {
            a2egSU.notifyItemRangeRemoved(this.f9172A5SV6n, this.f9173ADYaiT);
        } else if (i == 3) {
            a2egSU.notifyItemRangeChanged(this.f9172A5SV6n, this.f9173ADYaiT, this.AMqCpz);
        }
        this.AMqCpz = null;
        this.f9171A4TApA = 0;
    }

    public final void A4TApA(int i, int i2, Object obj) {
        int i3;
        int i4;
        int i5;
        if (this.f9171A4TApA == 3 && i <= (i4 = this.f9173ADYaiT + (i3 = this.f9172A5SV6n)) && (i5 = i + i2) >= i3 && this.AMqCpz == obj) {
            this.f9172A5SV6n = Math.min(i, i3);
            this.f9173ADYaiT = Math.max(i4, i5) - this.f9172A5SV6n;
            return;
        }
        A2egSU();
        this.f9172A5SV6n = i;
        this.f9173ADYaiT = i2;
        this.AMqCpz = obj;
        this.f9171A4TApA = 3;
    }

    public final void A5SV6n(int i, int i2) {
        A2egSU();
        this.f9170A2egSU.f9169A2egSU.notifyItemMoved(i, i2);
    }
}
