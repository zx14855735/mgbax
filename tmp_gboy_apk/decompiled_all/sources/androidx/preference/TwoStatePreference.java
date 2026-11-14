package androidx.preference;

import DRlcZ9.C2rE4F;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class TwoStatePreference extends Preference {

    /* renamed from: D6yqiO, reason: collision with root package name */
    public boolean f9152D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public String f9153D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public String f9154D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public boolean f9155D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public boolean f9156DAk1zC;

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    @Override // androidx.preference.Preference
    public final void AmA8tU() {
        boolean z = !this.f9152D6yqiO;
        if (A2egSU(Boolean.valueOf(z))) {
            BmvVmW(z);
        }
    }

    @Override // androidx.preference.Preference
    public final Object B25kr6(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    @Override // androidx.preference.Preference
    public final void B2KMhB(Parcelable parcelable) {
        if (!parcelable.getClass().equals(C2rE4F.class)) {
            super.B2KMhB(parcelable);
            return;
        }
        C2rE4F c2rE4F = (C2rE4F) parcelable;
        super.B2KMhB(c2rE4F.getSuperState());
        BmvVmW(c2rE4F.f2151AcNBzu);
    }

    @Override // androidx.preference.Preference
    public final Parcelable B3GDIM() {
        super.B3GDIM();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f9095BmvVmW) {
            return absSavedState;
        }
        C2rE4F c2rE4F = new C2rE4F();
        c2rE4F.f2151AcNBzu = this.f9152D6yqiO;
        return c2rE4F;
    }

    @Override // androidx.preference.Preference
    public final void B4ZgIw(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        if (BV3sI0()) {
            booleanValue = this.f9078AlLFFp.ADYaiT().getBoolean(this.f9088BI9f7h, booleanValue);
        }
        BmvVmW(booleanValue);
    }

    @Override // androidx.preference.Preference
    public final boolean BTvldC() {
        return (this.f9156DAk1zC ? this.f9152D6yqiO : !this.f9152D6yqiO) || super.BTvldC();
    }

    public final void BmvVmW(boolean z) {
        boolean z2 = this.f9152D6yqiO != z;
        if (z2 || !this.f9155D9tr6l) {
            this.f9152D6yqiO = z;
            this.f9155D9tr6l = true;
            if (BV3sI0()) {
                boolean z3 = !z;
                if (BV3sI0()) {
                    z3 = this.f9078AlLFFp.ADYaiT().getBoolean(this.f9088BI9f7h, z3);
                }
                if (z != z3) {
                    SharedPreferences.Editor A4TApA2 = this.f9078AlLFFp.A4TApA();
                    A4TApA2.putBoolean(this.f9088BI9f7h, z);
                    if (!this.f9078AlLFFp.AMqCpz) {
                        A4TApA2.apply();
                    }
                }
            }
            if (z2) {
                AZkASS(BTvldC());
                AZOQYO();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void BniPrB(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            goto L4c
        L5:
            android.widget.TextView r5 = (android.widget.TextView) r5
            boolean r0 = r4.f9152D6yqiO
            r1 = 0
            if (r0 == 0) goto L1b
            java.lang.String r0 = r4.f9153D8MqeW
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1b
            java.lang.String r0 = r4.f9153D8MqeW
            r5.setText(r0)
        L19:
            r0 = 0
            goto L2e
        L1b:
            boolean r0 = r4.f9152D6yqiO
            if (r0 != 0) goto L2d
            java.lang.String r0 = r4.f9154D8cQ8b
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2d
            java.lang.String r0 = r4.f9154D8cQ8b
            r5.setText(r0)
            goto L19
        L2d:
            r0 = 1
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r2 = r4.ASJ6gh()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L3e
            r5.setText(r2)
            r0 = 0
        L3e:
            if (r0 != 0) goto L41
            goto L43
        L41:
            r1 = 8
        L43:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L4c
            r5.setVisibility(r1)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.BniPrB(android.view.View):void");
    }
}
