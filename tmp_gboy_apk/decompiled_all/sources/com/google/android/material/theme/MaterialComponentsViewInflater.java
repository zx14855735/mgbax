package com.google.android.material.theme;

import ADYaiT.D07BeM;
import AaHO0E.B4ZgIw;
import AaHO0E.B9tovu;
import AaHO0E.BChYOn;
import AaHO0E.CASmeH;
import CikNvS.A4TApA;
import Oay4Bh.C4FrIb;
import P2YZiL.A2egSU;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.AMqCpz;
import com.google.android.material.R$styleable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textview.MaterialTextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MaterialComponentsViewInflater extends D07BeM {
    @Override // ADYaiT.D07BeM
    public final B4ZgIw A2egSU(Context context, AttributeSet attributeSet) {
        return new MaterialAutoCompleteTextView(context, attributeSet);
    }

    @Override // ADYaiT.D07BeM
    public final B9tovu A4TApA(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // ADYaiT.D07BeM
    public final BChYOn A5SV6n(Context context, AttributeSet attributeSet) {
        return new MaterialCheckBox(context, attributeSet);
    }

    @Override // ADYaiT.D07BeM
    public final CASmeH ADYaiT(Context context, AttributeSet attributeSet) {
        A2egSU a2egSU = new A2egSU(PXXBzr.A2egSU.A2egSU(context, attributeSet, 2130969781, 2131952855), attributeSet);
        Context context2 = a2egSU.getContext();
        TypedArray AmA8tU2 = C4FrIb.AmA8tU(context2, attributeSet, R$styleable.f11240BmvVmW, 2130969781, 2131952855, new int[0]);
        if (AmA8tU2.hasValue(0)) {
            A4TApA.A5SV6n(a2egSU, AMqCpz.BPw6Q8(context2, AmA8tU2, 0));
        }
        a2egSU.f6932B2KMhB = AmA8tU2.getBoolean(1, false);
        AmA8tU2.recycle();
        return a2egSU;
    }

    @Override // ADYaiT.D07BeM
    public final AppCompatTextView AMqCpz(Context context, AttributeSet attributeSet) {
        return new MaterialTextView(context, attributeSet);
    }
}
