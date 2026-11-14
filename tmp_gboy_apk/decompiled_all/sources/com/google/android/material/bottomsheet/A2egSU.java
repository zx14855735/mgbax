package com.google.android.material.bottomsheet;

import COJEAR.BNL6CD;
import COJEAR.FG7pZc;
import android.view.View;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements BNL6CD {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ ADYaiT f11371AcNBzu;

    public A2egSU(ADYaiT aDYaiT) {
        this.f11371AcNBzu = aDYaiT;
    }

    @Override // COJEAR.BNL6CD
    public final FG7pZc B3GDIM(View view, FG7pZc fG7pZc) {
        ADYaiT aDYaiT = this.f11371AcNBzu;
        A5SV6n a5SV6n = aDYaiT.f11384BIYEnU;
        if (a5SV6n != null) {
            aDYaiT.f11377B2KMhB.f11439DcUJf1.remove(a5SV6n);
        }
        A5SV6n a5SV6n2 = new A5SV6n(aDYaiT.f11380B7CMnp, fG7pZc);
        aDYaiT.f11384BIYEnU = a5SV6n2;
        a5SV6n2.AMqCpz(aDYaiT.getWindow());
        BottomSheetBehavior bottomSheetBehavior = aDYaiT.f11377B2KMhB;
        A5SV6n a5SV6n3 = aDYaiT.f11384BIYEnU;
        ArrayList arrayList = bottomSheetBehavior.f11439DcUJf1;
        if (!arrayList.contains(a5SV6n3)) {
            arrayList.add(a5SV6n3);
        }
        return fG7pZc;
    }
}
