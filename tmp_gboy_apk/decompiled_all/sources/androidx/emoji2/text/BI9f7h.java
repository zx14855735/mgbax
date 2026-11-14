package androidx.emoji2.text;

import android.util.SparseArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BI9f7h {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final SparseArray f8681A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public BNL6CD f8682A4TApA;

    public BI9f7h(int i) {
        this.f8681A2egSU = new SparseArray(i);
    }

    public final void A2egSU(BNL6CD bnl6cd, int i, int i2) {
        int A2egSU2 = bnl6cd.A2egSU(i);
        SparseArray sparseArray = this.f8681A2egSU;
        BI9f7h bI9f7h = sparseArray == null ? null : (BI9f7h) sparseArray.get(A2egSU2);
        if (bI9f7h == null) {
            bI9f7h = new BI9f7h(1);
            sparseArray.put(bnl6cd.A2egSU(i), bI9f7h);
        }
        if (i2 > i) {
            bI9f7h.A2egSU(bnl6cd, i + 1, i2);
        } else {
            bI9f7h.f8682A4TApA = bnl6cd;
        }
    }
}
