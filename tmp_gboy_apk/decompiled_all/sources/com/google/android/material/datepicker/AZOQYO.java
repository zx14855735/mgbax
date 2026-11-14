package com.google.android.material.datepicker;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZOQYO extends BJ7GGh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f11592A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AlLFFp f11593A4TApA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AZOQYO(AlLFFp alLFFp, int i, int i2) {
        super(i);
        this.f11593A4TApA = alLFFp;
        this.f11592A2egSU = i2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void calculateExtraLayoutSpace(RecyclerView.AaHO0E aaHO0E, int[] iArr) {
        int i = this.f11592A2egSU;
        AlLFFp alLFFp = this.f11593A4TApA;
        if (i == 0) {
            iArr[0] = alLFFp.f11605B7CMnp.getWidth();
            iArr[1] = alLFFp.f11605B7CMnp.getWidth();
        } else {
            iArr[0] = alLFFp.f11605B7CMnp.getHeight();
            iArr[1] = alLFFp.f11605B7CMnp.getHeight();
        }
    }
}
