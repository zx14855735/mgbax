package androidx.preference;

import DRlcZ9.AZOQYO;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.view.AbsSavedState;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class MultiSelectListPreference extends DialogPreference {

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public final CharSequence[] f9074DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public final CharSequence[] f9075DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public final HashSet f9076DV2E8K;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MultiSelectListPreference(android.content.Context r4, android.util.AttributeSet r5) {
        /*
            r3 = this;
            r0 = 2130969010(0x7f0401b2, float:1.754669E38)
            r1 = 16842897(0x1010091, float:2.3693964E-38)
            int r0 = BTvldC.A4TApA.A2egSU(r4, r0, r1)
            r3.<init>(r4, r5, r0)
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r3.f9076DV2E8K = r1
            int[] r1 = androidx.preference.R$styleable.f9127ARc23Z
            r2 = 0
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r5, r1, r0, r2)
            r5 = 2
            java.lang.CharSequence[] r5 = r4.getTextArray(r5)
            if (r5 != 0) goto L26
            java.lang.CharSequence[] r5 = r4.getTextArray(r2)
        L26:
            r3.f9074DRlcZ9 = r5
            r5 = 3
            java.lang.CharSequence[] r5 = r4.getTextArray(r5)
            if (r5 != 0) goto L34
            r5 = 1
            java.lang.CharSequence[] r5 = r4.getTextArray(r5)
        L34:
            r3.f9075DUi7mC = r5
            r4.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.MultiSelectListPreference.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    @Override // androidx.preference.Preference
    public final Object B25kr6(TypedArray typedArray, int i) {
        CharSequence[] textArray = typedArray.getTextArray(i);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // androidx.preference.Preference
    public final void B2KMhB(Parcelable parcelable) {
        if (!parcelable.getClass().equals(AZOQYO.class)) {
            super.B2KMhB(parcelable);
            return;
        }
        AZOQYO azoqyo = (AZOQYO) parcelable;
        super.B2KMhB(azoqyo.getSuperState());
        BmvVmW(azoqyo.f2084AcNBzu);
    }

    @Override // androidx.preference.Preference
    public final Parcelable B3GDIM() {
        super.B3GDIM();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f9095BmvVmW) {
            return absSavedState;
        }
        AZOQYO azoqyo = new AZOQYO();
        azoqyo.f2084AcNBzu = this.f9076DV2E8K;
        return azoqyo;
    }

    @Override // androidx.preference.Preference
    public final void B4ZgIw(Object obj) {
        Set<String> set = (Set) obj;
        if (BV3sI0()) {
            set = this.f9078AlLFFp.ADYaiT().getStringSet(this.f9088BI9f7h, set);
        }
        BmvVmW(set);
    }

    public final void BmvVmW(Set set) {
        HashSet hashSet = this.f9076DV2E8K;
        hashSet.clear();
        hashSet.addAll(set);
        if (BV3sI0()) {
            if (!set.equals(BV3sI0() ? this.f9078AlLFFp.ADYaiT().getStringSet(this.f9088BI9f7h, null) : null)) {
                SharedPreferences.Editor A4TApA2 = this.f9078AlLFFp.A4TApA();
                A4TApA2.putStringSet(this.f9088BI9f7h, set);
                if (!this.f9078AlLFFp.AMqCpz) {
                    A4TApA2.apply();
                }
            }
        }
        AZOQYO();
    }
}
