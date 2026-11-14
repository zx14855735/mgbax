package androidx.recyclerview.widget;

import android.util.SparseIntArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class F32kj0 implements FG7pZc {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final SparseIntArray f9408A2egSU = new SparseIntArray(1);

    /* renamed from: A4TApA, reason: collision with root package name */
    public final SparseIntArray f9409A4TApA = new SparseIntArray(1);

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final CQhlFr f9410A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ F508T2 f9411ADYaiT;

    public F32kj0(F508T2 f508t2, CQhlFr cQhlFr) {
        this.f9411ADYaiT = f508t2;
        this.f9410A5SV6n = cQhlFr;
    }

    @Override // androidx.recyclerview.widget.FG7pZc
    public final int A2egSU(int i) {
        SparseIntArray sparseIntArray = this.f9409A4TApA;
        int indexOfKey = sparseIntArray.indexOfKey(i);
        if (indexOfKey >= 0) {
            return sparseIntArray.valueAt(indexOfKey);
        }
        StringBuilder B9tovu2 = J3FDQU.A2egSU.B9tovu(i, "requested global type ", " does not belong to the adapter:");
        B9tovu2.append(this.f9410A5SV6n.f9322A5SV6n);
        throw new IllegalStateException(B9tovu2.toString());
    }

    @Override // androidx.recyclerview.widget.FG7pZc
    public final int A4TApA(int i) {
        SparseIntArray sparseIntArray = this.f9408A2egSU;
        int indexOfKey = sparseIntArray.indexOfKey(i);
        if (indexOfKey > -1) {
            return sparseIntArray.valueAt(indexOfKey);
        }
        F508T2 f508t2 = this.f9411ADYaiT;
        int i2 = f508t2.f9413A4TApA;
        f508t2.f9413A4TApA = i2 + 1;
        f508t2.f9412A2egSU.put(i2, this.f9410A5SV6n);
        sparseIntArray.put(i, i2);
        this.f9409A4TApA.put(i2, i);
        return i2;
    }
}
