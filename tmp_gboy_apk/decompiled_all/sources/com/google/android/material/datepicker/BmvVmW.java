package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BmvVmW extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AlLFFp f11660AcNBzu;

    public BmvVmW(AlLFFp alLFFp) {
        this.f11660AcNBzu = alLFFp;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f11660AcNBzu.f11599AmA8tU.f11580B2KMhB;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        BV3sI0 bV3sI0 = (BV3sI0) dphsd2;
        AlLFFp alLFFp = this.f11660AcNBzu;
        int i2 = alLFFp.f11599AmA8tU.f11575AcNBzu.f11640AmA8tU + i;
        bV3sI0.f11659AcNBzu.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        TextView textView = bV3sI0.f11659AcNBzu;
        Context context = textView.getContext();
        textView.setContentDescription(BTvldC.A4TApA().get(1) == i2 ? String.format(context.getString(2131886582), Integer.valueOf(i2)) : String.format(context.getString(2131886583), Integer.valueOf(i2)));
        ADYaiT aDYaiT = alLFFp.f11603B3GDIM;
        if (BTvldC.A4TApA().get(1) == i2) {
            A5SV6n a5SV6n = aDYaiT.f11583A4TApA;
        } else {
            A5SV6n a5SV6n2 = aDYaiT.f11582A2egSU;
        }
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new BV3sI0((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(2131493245, viewGroup, false));
    }
}
