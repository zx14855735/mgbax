package com.google.android.material.datepicker;

import COJEAR.CcAIMM;
import COJEAR.DG07BK;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.Dphsd2;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B7CMnp extends Dphsd2 {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final TextView f11651AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final MaterialCalendarGridView f11652AlLFFp;

    public B7CMnp(LinearLayout linearLayout, boolean z) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(2131297657);
        this.f11651AcNBzu = textView;
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        new CcAIMM(2131298058, Boolean.class, 0, 28, 3).A2egSU(textView, Boolean.TRUE);
        this.f11652AlLFFp = (MaterialCalendarGridView) linearLayout.findViewById(2131297652);
        if (z) {
            return;
        }
        textView.setVisibility(8);
    }
}
