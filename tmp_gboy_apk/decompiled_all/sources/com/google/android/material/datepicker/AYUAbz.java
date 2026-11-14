package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AYUAbz implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f11589AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ B9tovu f11590AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ AlLFFp f11591AmA8tU;

    public /* synthetic */ AYUAbz(AlLFFp alLFFp, B9tovu b9tovu, int i) {
        this.f11589AcNBzu = i;
        this.f11591AmA8tU = alLFFp;
        this.f11590AlLFFp = b9tovu;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f11589AcNBzu) {
            case 0:
                AlLFFp alLFFp = this.f11591AmA8tU;
                int findLastVisibleItemPosition = ((LinearLayoutManager) alLFFp.f11605B7CMnp.getLayoutManager()).findLastVisibleItemPosition() - 1;
                Calendar A2egSU2 = BTvldC.A2egSU(this.f11590AlLFFp.f11653AcNBzu.f11575AcNBzu.f11638AcNBzu);
                A2egSU2.add(2, findLastVisibleItemPosition);
                alLFFp.AZkASS(new B2KMhB(A2egSU2));
                break;
            default:
                AlLFFp alLFFp2 = this.f11591AmA8tU;
                int findFirstVisibleItemPosition = ((LinearLayoutManager) alLFFp2.f11605B7CMnp.getLayoutManager()).findFirstVisibleItemPosition() + 1;
                Calendar A2egSU3 = BTvldC.A2egSU(this.f11590AlLFFp.f11653AcNBzu.f11575AcNBzu.f11638AcNBzu);
                A2egSU3.add(2, findFirstVisibleItemPosition);
                alLFFp2.AZkASS(new B2KMhB(A2egSU3));
                break;
        }
    }
}
