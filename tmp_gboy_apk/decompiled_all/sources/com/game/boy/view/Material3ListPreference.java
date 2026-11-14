package com.game.boy.view;

import M0ztbm.ADYaiT;
import OOnEhG.A4TApA;
import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.ListPreference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class Material3ListPreference extends ListPreference {

    /* renamed from: DaOi9o, reason: collision with root package name */
    public int f11130DaOi9o;

    public Material3ListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.preference.DialogPreference, androidx.preference.Preference
    public final void AmA8tU() {
        CharSequence[] charSequenceArr;
        CharSequence[] charSequenceArr2 = this.f9070DRlcZ9;
        if (charSequenceArr2 == null || (charSequenceArr = this.f9071DUi7mC) == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        this.f11130DaOi9o = BmvVmW(this.f9072DV2E8K);
        A4TApA a4TApA = new A4TApA(getContext());
        a4TApA.f81AcNBzu.AMqCpz = this.f9060D6yqiO;
        a4TApA.ADYaiT(charSequenceArr2, this.f11130DaOi9o, new ADYaiT(this, 5, charSequenceArr));
        a4TApA.AcNBzu(this.f9064DAk1zC, null);
        a4TApA.AMqCpz();
    }

    public Material3ListPreference(Context context) {
        super(context, null);
    }
}
