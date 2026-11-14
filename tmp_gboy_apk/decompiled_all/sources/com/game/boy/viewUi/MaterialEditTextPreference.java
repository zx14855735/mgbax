package com.game.boy.viewUi;

import ADYaiT.AZOQYO;
import M0ztbm.ADYaiT;
import OOnEhG.A4TApA;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.preference.EditTextPreference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MaterialEditTextPreference extends EditTextPreference {
    public MaterialEditTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public final void AmA8tU() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setPadding(60, 10, 60, 10);
        EditText editText = new EditText(getContext());
        editText.setText(this.f9069DRlcZ9);
        editText.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(editText);
        A4TApA a4TApA = new A4TApA(getContext());
        CharSequence charSequence = this.f9084B4ZgIw;
        AZOQYO azoqyo = a4TApA.f81AcNBzu;
        azoqyo.AMqCpz = charSequence;
        azoqyo.f41B7CMnp = linearLayout;
        a4TApA.AmA8tU(R.string.ok, new ADYaiT(this, 7, editText));
        a4TApA.AaHO0E(R.string.cancel, null);
        a4TApA.AMqCpz();
    }

    public MaterialEditTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MaterialEditTextPreference(Context context) {
        super(context, null);
    }
}
