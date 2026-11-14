package com.game.boy.viewUi;

import M0ztbm.ADYaiT;
import OOnEhG.A4TApA;
import android.R;
import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.ListPreference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MaterialListPreference extends ListPreference {
    public MaterialListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public final void AmA8tU() {
        CharSequence[] charSequenceArr;
        String str = this.f9072DV2E8K;
        int i = 0;
        int i2 = 0;
        while (true) {
            charSequenceArr = this.f9071DUi7mC;
            if (i2 >= charSequenceArr.length) {
                break;
            }
            if (charSequenceArr[i2].toString().equals(str)) {
                i = i2;
                break;
            }
            i2++;
        }
        A4TApA a4TApA = new A4TApA(getContext());
        a4TApA.f81AcNBzu.AMqCpz = this.f9084B4ZgIw;
        a4TApA.AmA8tU(R.string.ok, new ADYaiT(this, 8, charSequenceArr));
        a4TApA.ADYaiT(this.f9070DRlcZ9, i, null);
        a4TApA.AaHO0E(R.string.cancel, null);
        a4TApA.AMqCpz();
    }

    public MaterialListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MaterialListPreference(Context context) {
        super(context, null);
    }
}
