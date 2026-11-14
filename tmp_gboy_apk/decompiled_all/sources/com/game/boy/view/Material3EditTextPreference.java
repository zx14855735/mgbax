package com.game.boy.view;

import ADYaiT.AZOQYO;
import M0ztbm.ADYaiT;
import OOnEhG.A4TApA;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.preference.EditTextPreference;
import com.google.android.material.textfield.TextInputEditText;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class Material3EditTextPreference extends EditTextPreference {
    public Material3EditTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public final void AmA8tU() {
        A4TApA a4TApA = new A4TApA(getContext());
        CharSequence charSequence = this.f9084B4ZgIw;
        AZOQYO azoqyo = a4TApA.f81AcNBzu;
        azoqyo.AMqCpz = charSequence;
        azoqyo.f26ADYaiT = this.f9062D8cQ8b;
        a4TApA.AaHO0E(R.string.cancel, null);
        View inflate = LayoutInflater.from(getContext()).inflate(2131493225, (ViewGroup) null);
        TextInputEditText textInputEditText = (TextInputEditText) inflate.findViewById(R.id.edit);
        textInputEditText.setText(this.f9069DRlcZ9);
        String str = this.f9061D8MqeW;
        if (str != null) {
            textInputEditText.setHint(str);
        }
        azoqyo.f41B7CMnp = inflate;
        a4TApA.AmA8tU(R.string.ok, new ADYaiT(this, 4, textInputEditText));
        a4TApA.A2egSU().show();
    }
}
