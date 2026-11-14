package com.google.android.material.datepicker;

import android.R;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DG07BK;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B9tovu extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A4TApA f11653AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ARc23Z f11654AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final AZkASS f11655AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int f11656AzWtSf;

    public B9tovu(ContextThemeWrapper contextThemeWrapper, A4TApA a4TApA, ARc23Z aRc23Z, AZkASS aZkASS) {
        B2KMhB b2KMhB = a4TApA.f11575AcNBzu;
        B2KMhB b2KMhB2 = a4TApA.f11578AzWtSf;
        if (b2KMhB.f11638AcNBzu.compareTo(b2KMhB2.f11638AcNBzu) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (b2KMhB2.f11638AcNBzu.compareTo(a4TApA.f11576AlLFFp.f11638AcNBzu) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f11656AzWtSf = (contextThemeWrapper.getResources().getDimensionPixelSize(2131166386) * B3GDIM.f11645ADYaiT) + (AmA8tU.AmA8tU(contextThemeWrapper, R.attr.windowFullscreen) ? contextThemeWrapper.getResources().getDimensionPixelSize(2131166386) : 0);
        this.f11653AcNBzu = a4TApA;
        this.f11654AlLFFp = aRc23Z;
        this.f11655AmA8tU = aZkASS;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f11653AcNBzu.f11581B3GDIM;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final long getItemId(int i) {
        Calendar A2egSU2 = BTvldC.A2egSU(this.f11653AcNBzu.f11575AcNBzu.f11638AcNBzu);
        A2egSU2.add(2, i);
        A2egSU2.set(5, 1);
        Calendar A2egSU3 = BTvldC.A2egSU(A2egSU2);
        A2egSU3.get(2);
        A2egSU3.get(1);
        A2egSU3.getMaximum(7);
        A2egSU3.getActualMaximum(5);
        A2egSU3.getTimeInMillis();
        return A2egSU3.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        B7CMnp b7CMnp = (B7CMnp) dphsd2;
        A4TApA a4TApA = this.f11653AcNBzu;
        Calendar A2egSU2 = BTvldC.A2egSU(a4TApA.f11575AcNBzu.f11638AcNBzu);
        A2egSU2.add(2, i);
        B2KMhB b2KMhB = new B2KMhB(A2egSU2);
        b7CMnp.f11651AcNBzu.setText(b2KMhB.A5SV6n());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) b7CMnp.f11652AlLFFp.findViewById(2131297652);
        if (materialCalendarGridView.A2egSU() == null || !b2KMhB.equals(materialCalendarGridView.A2egSU().f11646A2egSU)) {
            new B3GDIM(b2KMhB, a4TApA, this.f11654AlLFFp);
            throw null;
        }
        materialCalendarGridView.invalidate();
        materialCalendarGridView.A2egSU().getClass();
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2131493241, viewGroup, false);
        if (!AmA8tU.AmA8tU(viewGroup.getContext(), R.attr.windowFullscreen)) {
            return new B7CMnp(linearLayout, false);
        }
        linearLayout.setLayoutParams(new DG07BK(-1, this.f11656AzWtSf));
        return new B7CMnp(linearLayout, true);
    }
}
