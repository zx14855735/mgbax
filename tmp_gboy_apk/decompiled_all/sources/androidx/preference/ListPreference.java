package androidx.preference;

import ADYaiT.BmvVmW;
import BTvldC.A4TApA;
import DRlcZ9.ARc23Z;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ListPreference extends DialogPreference {

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public final CharSequence[] f9070DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public final CharSequence[] f9071DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public String f9072DV2E8K;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public String f9073DXnQ0V;
    public boolean DXuj49;

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AMqCpz, i, 0);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(2);
        this.f9070DRlcZ9 = textArray == null ? obtainStyledAttributes.getTextArray(0) : textArray;
        CharSequence[] textArray2 = obtainStyledAttributes.getTextArray(3);
        this.f9071DUi7mC = textArray2 == null ? obtainStyledAttributes.getTextArray(1) : textArray2;
        if (obtainStyledAttributes.getBoolean(4, obtainStyledAttributes.getBoolean(4, false))) {
            if (BmvVmW.f113AmA8tU == null) {
                BmvVmW.f113AmA8tU = new BmvVmW(10);
            }
            this.f9114D07BeM = BmvVmW.f113AmA8tU;
            AZOQYO();
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.f9128ASJ6gh, i, 0);
        String string = obtainStyledAttributes2.getString(33);
        this.f9073DXnQ0V = string == null ? obtainStyledAttributes2.getString(7) : string;
        obtainStyledAttributes2.recycle();
    }

    @Override // androidx.preference.Preference
    public final CharSequence ASJ6gh() {
        BmvVmW bmvVmW = this.f9114D07BeM;
        if (bmvVmW != null) {
            return bmvVmW.AYUAbz(this);
        }
        CharSequence BniPrB2 = BniPrB();
        CharSequence ASJ6gh2 = super.ASJ6gh();
        String str = this.f9073DXnQ0V;
        if (str != null) {
            if (BniPrB2 == null) {
                BniPrB2 = "";
            }
            String format = String.format(str, BniPrB2);
            if (!TextUtils.equals(format, ASJ6gh2)) {
                return format;
            }
        }
        return ASJ6gh2;
    }

    @Override // androidx.preference.Preference
    public final Object B25kr6(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // androidx.preference.Preference
    public final void B2KMhB(Parcelable parcelable) {
        if (!parcelable.getClass().equals(ARc23Z.class)) {
            super.B2KMhB(parcelable);
            return;
        }
        ARc23Z aRc23Z = (ARc23Z) parcelable;
        super.B2KMhB(aRc23Z.getSuperState());
        BpkvW3(aRc23Z.f2078AcNBzu);
    }

    @Override // androidx.preference.Preference
    public final Parcelable B3GDIM() {
        super.B3GDIM();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f9095BmvVmW) {
            return absSavedState;
        }
        ARc23Z aRc23Z = new ARc23Z();
        aRc23Z.f2078AcNBzu = this.f9072DV2E8K;
        return aRc23Z;
    }

    @Override // androidx.preference.Preference
    public final void B4ZgIw(Object obj) {
        BpkvW3(ARc23Z((String) obj));
    }

    @Override // androidx.preference.Preference
    public final void BNL6CD(CharSequence charSequence) {
        super.BNL6CD(charSequence);
        if (charSequence == null) {
            this.f9073DXnQ0V = null;
        } else {
            this.f9073DXnQ0V = charSequence.toString();
        }
    }

    public final int BmvVmW(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f9071DUi7mC) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(charSequenceArr[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public final CharSequence BniPrB() {
        CharSequence[] charSequenceArr;
        int BmvVmW2 = BmvVmW(this.f9072DV2E8K);
        if (BmvVmW2 < 0 || (charSequenceArr = this.f9070DRlcZ9) == null) {
            return null;
        }
        return charSequenceArr[BmvVmW2];
    }

    public final void BpkvW3(String str) {
        boolean equals = TextUtils.equals(this.f9072DV2E8K, str);
        if (equals && this.DXuj49) {
            return;
        }
        this.f9072DV2E8K = str;
        this.DXuj49 = true;
        BI9f7h(str);
        if (equals) {
            return;
        }
        AZOQYO();
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, A4TApA.A2egSU(context, 2130969010, R.attr.dialogPreferenceStyle));
    }
}
