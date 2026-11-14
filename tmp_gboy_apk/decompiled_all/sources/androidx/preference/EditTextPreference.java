package androidx.preference;

import ADYaiT.BmvVmW;
import BTvldC.A4TApA;
import DRlcZ9.A5SV6n;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class EditTextPreference extends DialogPreference {

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public String f9069DRlcZ9;

    public EditTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f9126ADYaiT, i, 0);
        if (obtainStyledAttributes.getBoolean(0, obtainStyledAttributes.getBoolean(0, false))) {
            if (BmvVmW.f112AlLFFp == null) {
                BmvVmW.f112AlLFFp = new BmvVmW(9);
            }
            this.f9114D07BeM = BmvVmW.f112AlLFFp;
            AZOQYO();
        }
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object B25kr6(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // androidx.preference.Preference
    public final void B2KMhB(Parcelable parcelable) {
        if (!parcelable.getClass().equals(A5SV6n.class)) {
            super.B2KMhB(parcelable);
            return;
        }
        A5SV6n a5SV6n = (A5SV6n) parcelable;
        super.B2KMhB(a5SV6n.getSuperState());
        BmvVmW(a5SV6n.f2072AcNBzu);
    }

    @Override // androidx.preference.Preference
    public final Parcelable B3GDIM() {
        super.B3GDIM();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f9095BmvVmW) {
            return absSavedState;
        }
        A5SV6n a5SV6n = new A5SV6n();
        a5SV6n.f2072AcNBzu = this.f9069DRlcZ9;
        return a5SV6n;
    }

    @Override // androidx.preference.Preference
    public final void B4ZgIw(Object obj) {
        BmvVmW(ARc23Z((String) obj));
    }

    @Override // androidx.preference.Preference
    public final boolean BTvldC() {
        return TextUtils.isEmpty(this.f9069DRlcZ9) || super.BTvldC();
    }

    public final void BmvVmW(String str) {
        boolean BTvldC2 = BTvldC();
        this.f9069DRlcZ9 = str;
        BI9f7h(str);
        boolean BTvldC3 = BTvldC();
        if (BTvldC3 != BTvldC2) {
            AZkASS(BTvldC3);
        }
        AZOQYO();
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, A4TApA.A2egSU(context, 2130969050, R.attr.editTextPreferenceStyle));
    }
}
