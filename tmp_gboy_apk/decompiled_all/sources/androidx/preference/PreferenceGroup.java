package androidx.preference;

import ADYaiT.D8MqeW;
import B25kr6.AzWtSf;
import DRlcZ9.B7CMnp;
import DRlcZ9.BChYOn;
import DRlcZ9.BNL6CD;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class PreferenceGroup extends Preference {

    /* renamed from: D6yqiO, reason: collision with root package name */
    public final AzWtSf f9116D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public final ArrayList f9117D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public boolean f9118D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public int f9119D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public boolean f9120DAk1zC;

    /* renamed from: DG07BK, reason: collision with root package name */
    public int f9121DG07BK;

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9116D6yqiO = new AzWtSf();
        new Handler(Looper.getMainLooper());
        this.f9118D8cQ8b = true;
        this.f9119D9tr6l = 0;
        this.f9120DAk1zC = false;
        this.f9121DG07BK = Integer.MAX_VALUE;
        this.f9117D8MqeW = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f9130AZOQYO, i, 0);
        this.f9118D8cQ8b = obtainStyledAttributes.getBoolean(2, obtainStyledAttributes.getBoolean(2, true));
        if (obtainStyledAttributes.hasValue(1)) {
            int i2 = obtainStyledAttributes.getInt(1, obtainStyledAttributes.getInt(1, Integer.MAX_VALUE));
            if (i2 != Integer.MAX_VALUE) {
                TextUtils.isEmpty(this.f9088BI9f7h);
            }
            this.f9121DG07BK = i2;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final void A4TApA(Bundle bundle) {
        super.A4TApA(bundle);
        int size = this.f9117D8MqeW.size();
        for (int i = 0; i < size; i++) {
            BpkvW3(i).A4TApA(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void A5SV6n(Bundle bundle) {
        super.A5SV6n(bundle);
        int size = this.f9117D8MqeW.size();
        for (int i = 0; i < size; i++) {
            BpkvW3(i).A5SV6n(bundle);
        }
    }

    @Override // androidx.preference.Preference
    public final void AZkASS(boolean z) {
        super.AZkASS(z);
        int size = this.f9117D8MqeW.size();
        for (int i = 0; i < size; i++) {
            Preference BpkvW3 = BpkvW3(i);
            if (BpkvW3.f9098C4FrIb == z) {
                BpkvW3.f9098C4FrIb = !z;
                BpkvW3.AZkASS(BpkvW3.BTvldC());
                BpkvW3.AZOQYO();
            }
        }
    }

    @Override // androidx.preference.Preference
    public final void AaHO0E() {
        super.AaHO0E();
        this.f9120DAk1zC = true;
        int size = this.f9117D8MqeW.size();
        for (int i = 0; i < size; i++) {
            BpkvW3(i).AaHO0E();
        }
    }

    @Override // androidx.preference.Preference
    public final void AzWtSf() {
        super.AzWtSf();
        this.f9120DAk1zC = false;
        int size = this.f9117D8MqeW.size();
        for (int i = 0; i < size; i++) {
            BpkvW3(i).AzWtSf();
        }
    }

    @Override // androidx.preference.Preference
    public final void B2KMhB(Parcelable parcelable) {
        if (!parcelable.getClass().equals(B7CMnp.class)) {
            super.B2KMhB(parcelable);
            return;
        }
        B7CMnp b7CMnp = (B7CMnp) parcelable;
        this.f9121DG07BK = b7CMnp.f2112AcNBzu;
        super.B2KMhB(b7CMnp.getSuperState());
    }

    @Override // androidx.preference.Preference
    public final Parcelable B3GDIM() {
        super.B3GDIM();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        return new B7CMnp(this.f9121DG07BK);
    }

    public final void BmvVmW(Preference preference) {
        long A5SV6n2;
        if (this.f9117D8MqeW.contains(preference)) {
            return;
        }
        if (preference.f9088BI9f7h != null) {
            PreferenceGroup preferenceGroup = this;
            while (true) {
                PreferenceGroup preferenceGroup2 = preferenceGroup.f9111CrfGsy;
                if (preferenceGroup2 == null) {
                    break;
                } else {
                    preferenceGroup = preferenceGroup2;
                }
            }
            preferenceGroup.BniPrB(preference.f9088BI9f7h);
        }
        int i = preference.f9083B3GDIM;
        if (i == Integer.MAX_VALUE) {
            if (this.f9118D8cQ8b) {
                int i2 = this.f9119D9tr6l;
                this.f9119D9tr6l = i2 + 1;
                if (i2 != i) {
                    preference.f9083B3GDIM = i2;
                    BChYOn bChYOn = preference.f9109CmUvjW;
                    if (bChYOn != null) {
                        Handler handler = bChYOn.f2120B25kr6;
                        D8MqeW d8MqeW = bChYOn.f2121B2KMhB;
                        handler.removeCallbacks(d8MqeW);
                        handler.post(d8MqeW);
                    }
                }
            }
            if (preference instanceof PreferenceGroup) {
                ((PreferenceGroup) preference).f9118D8cQ8b = this.f9118D8cQ8b;
            }
        }
        int binarySearch = Collections.binarySearch(this.f9117D8MqeW, preference);
        if (binarySearch < 0) {
            binarySearch = (binarySearch * (-1)) - 1;
        }
        boolean BTvldC2 = BTvldC();
        if (preference.f9098C4FrIb == BTvldC2) {
            preference.f9098C4FrIb = !BTvldC2;
            preference.AZkASS(preference.BTvldC());
            preference.AZOQYO();
        }
        synchronized (this) {
            this.f9117D8MqeW.add(binarySearch, preference);
        }
        BNL6CD bnl6cd = this.f9078AlLFFp;
        String str = preference.f9088BI9f7h;
        if (str == null || !this.f9116D6yqiO.containsKey(str)) {
            A5SV6n2 = bnl6cd.A5SV6n();
        } else {
            A5SV6n2 = ((Long) this.f9116D6yqiO.get(str)).longValue();
            this.f9116D6yqiO.remove(str);
        }
        preference.f9079AmA8tU = A5SV6n2;
        preference.f9080AzWtSf = true;
        try {
            preference.AcNBzu(bnl6cd);
            preference.f9080AzWtSf = false;
            if (preference.f9111CrfGsy != null) {
                throw new IllegalStateException("This preference already has a parent. You must remove the existing parent before assigning a new one.");
            }
            preference.f9111CrfGsy = this;
            if (this.f9120DAk1zC) {
                preference.AaHO0E();
            }
            BChYOn bChYOn2 = this.f9109CmUvjW;
            if (bChYOn2 != null) {
                Handler handler2 = bChYOn2.f2120B25kr6;
                D8MqeW d8MqeW2 = bChYOn2.f2121B2KMhB;
                handler2.removeCallbacks(d8MqeW2);
                handler2.post(d8MqeW2);
            }
        } catch (Throwable th) {
            preference.f9080AzWtSf = false;
            throw th;
        }
    }

    public final Preference BniPrB(CharSequence charSequence) {
        Preference BniPrB2;
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (TextUtils.equals(this.f9088BI9f7h, charSequence)) {
            return this;
        }
        int size = this.f9117D8MqeW.size();
        for (int i = 0; i < size; i++) {
            Preference BpkvW3 = BpkvW3(i);
            if (TextUtils.equals(BpkvW3.f9088BI9f7h, charSequence)) {
                return BpkvW3;
            }
            if ((BpkvW3 instanceof PreferenceGroup) && (BniPrB2 = ((PreferenceGroup) BpkvW3).BniPrB(charSequence)) != null) {
                return BniPrB2;
            }
        }
        return null;
    }

    public final Preference BpkvW3(int i) {
        return (Preference) this.f9117D8MqeW.get(i);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
