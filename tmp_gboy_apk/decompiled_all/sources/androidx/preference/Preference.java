package androidx.preference;

import ADYaiT.A5SV6n;
import ADYaiT.BmvVmW;
import ADYaiT.CtFAbx;
import BTvldC.A4TApA;
import DRlcZ9.AlLFFp;
import DRlcZ9.AmA8tU;
import DRlcZ9.AzWtSf;
import DRlcZ9.B4ZgIw;
import DRlcZ9.BChYOn;
import DRlcZ9.BNL6CD;
import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class Preference implements Comparable<Preference> {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Context f9077AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public BNL6CD f9078AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public long f9079AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f9080AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public AlLFFp f9081B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public AmA8tU f9082B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f9083B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public CharSequence f9084B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public CharSequence f9085B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public int f9086B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public Drawable f9087BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public String f9088BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public Intent f9089BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final String f9090BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public Bundle f9091BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public boolean f9092BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final boolean f9093BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f9094BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final boolean f9095BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final String f9096BniPrB;
    public Object BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public boolean f9097C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public boolean f9098C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public final boolean f9099CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public final boolean f9100CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public final boolean f9101COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public final boolean f9102CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public final boolean f9103CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public final boolean f9104CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public final boolean f9105CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public final boolean f9106Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public int f9107CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public final int f9108CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public BChYOn f9109CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public ArrayList f9110CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public PreferenceGroup f9111CrfGsy;

    /* renamed from: CtFAbx, reason: collision with root package name */
    public boolean f9112CtFAbx;

    /* renamed from: CtxOCS, reason: collision with root package name */
    public AzWtSf f9113CtxOCS;

    /* renamed from: D07BeM, reason: collision with root package name */
    public BmvVmW f9114D07BeM;

    /* renamed from: D6DOie, reason: collision with root package name */
    public final A5SV6n f9115D6DOie;

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this.f9083B3GDIM = Integer.MAX_VALUE;
        this.f9092BPw6Q8 = true;
        this.f9093BTvldC = true;
        this.f9095BmvVmW = true;
        this.f9097C2rE4F = true;
        this.f9098C4FrIb = true;
        this.f9099CASmeH = true;
        this.f9100CNPG0E = true;
        this.f9101COJEAR = true;
        this.f9103CSDoyG = true;
        this.f9106Cd8JRx = true;
        this.f9107CikNvS = 2131493285;
        this.f9115D6DOie = new A5SV6n(3, this);
        this.f9077AcNBzu = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f9128ASJ6gh, i, 0);
        this.f9086B9tovu = obtainStyledAttributes.getResourceId(23, obtainStyledAttributes.getResourceId(0, 0));
        String string = obtainStyledAttributes.getString(26);
        this.f9088BI9f7h = string == null ? obtainStyledAttributes.getString(6) : string;
        CharSequence text = obtainStyledAttributes.getText(34);
        this.f9084B4ZgIw = text == null ? obtainStyledAttributes.getText(4) : text;
        CharSequence text2 = obtainStyledAttributes.getText(33);
        this.f9085B7CMnp = text2 == null ? obtainStyledAttributes.getText(7) : text2;
        this.f9083B3GDIM = obtainStyledAttributes.getInt(28, obtainStyledAttributes.getInt(8, Integer.MAX_VALUE));
        String string2 = obtainStyledAttributes.getString(22);
        this.f9090BJ7GGh = string2 == null ? obtainStyledAttributes.getString(13) : string2;
        this.f9107CikNvS = obtainStyledAttributes.getResourceId(27, obtainStyledAttributes.getResourceId(3, 2131493285));
        this.f9108CkXcdM = obtainStyledAttributes.getResourceId(35, obtainStyledAttributes.getResourceId(9, 0));
        this.f9092BPw6Q8 = obtainStyledAttributes.getBoolean(21, obtainStyledAttributes.getBoolean(2, true));
        boolean z = obtainStyledAttributes.getBoolean(30, obtainStyledAttributes.getBoolean(5, true));
        this.f9093BTvldC = z;
        this.f9095BmvVmW = obtainStyledAttributes.getBoolean(29, obtainStyledAttributes.getBoolean(1, true));
        String string3 = obtainStyledAttributes.getString(19);
        this.f9096BniPrB = string3 == null ? obtainStyledAttributes.getString(10) : string3;
        this.f9100CNPG0E = obtainStyledAttributes.getBoolean(16, obtainStyledAttributes.getBoolean(16, z));
        this.f9101COJEAR = obtainStyledAttributes.getBoolean(17, obtainStyledAttributes.getBoolean(17, z));
        if (obtainStyledAttributes.hasValue(18)) {
            this.BpkvW3 = B25kr6(obtainStyledAttributes, 18);
        } else if (obtainStyledAttributes.hasValue(11)) {
            this.BpkvW3 = B25kr6(obtainStyledAttributes, 11);
        }
        this.f9106Cd8JRx = obtainStyledAttributes.getBoolean(31, obtainStyledAttributes.getBoolean(12, true));
        boolean hasValue = obtainStyledAttributes.hasValue(32);
        this.f9102CQhlFr = hasValue;
        if (hasValue) {
            this.f9103CSDoyG = obtainStyledAttributes.getBoolean(32, obtainStyledAttributes.getBoolean(14, true));
        }
        this.f9104CTkVKb = obtainStyledAttributes.getBoolean(24, obtainStyledAttributes.getBoolean(15, false));
        this.f9099CASmeH = obtainStyledAttributes.getBoolean(25, obtainStyledAttributes.getBoolean(25, true));
        this.f9105CcAIMM = obtainStyledAttributes.getBoolean(20, obtainStyledAttributes.getBoolean(20, false));
        obtainStyledAttributes.recycle();
    }

    public static void BJ7GGh(View view, boolean z) {
        view.setEnabled(z);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                BJ7GGh(viewGroup.getChildAt(childCount), z);
            }
        }
    }

    public final boolean A2egSU(Serializable serializable) {
        AlLFFp alLFFp = this.f9081B25kr6;
        return alLFFp == null || alLFFp.A2egSU(this, serializable);
    }

    public void A4TApA(Bundle bundle) {
        Parcelable parcelable;
        if (TextUtils.isEmpty(this.f9088BI9f7h) || (parcelable = bundle.getParcelable(this.f9088BI9f7h)) == null) {
            return;
        }
        this.f9112CtFAbx = false;
        B2KMhB(parcelable);
        if (!this.f9112CtFAbx) {
            throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
    }

    public void A5SV6n(Bundle bundle) {
        if (TextUtils.isEmpty(this.f9088BI9f7h)) {
            return;
        }
        this.f9112CtFAbx = false;
        Parcelable B3GDIM2 = B3GDIM();
        if (!this.f9112CtFAbx) {
            throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
        }
        if (B3GDIM2 != null) {
            bundle.putParcelable(this.f9088BI9f7h, B3GDIM2);
        }
    }

    public long ADYaiT() {
        return this.f9079AmA8tU;
    }

    public final int AMqCpz(int i) {
        return !BV3sI0() ? i : this.f9078AlLFFp.ADYaiT().getInt(this.f9088BI9f7h, i);
    }

    public final String ARc23Z(String str) {
        return !BV3sI0() ? str : this.f9078AlLFFp.ADYaiT().getString(this.f9088BI9f7h, str);
    }

    public CharSequence ASJ6gh() {
        BmvVmW bmvVmW = this.f9114D07BeM;
        return bmvVmW != null ? bmvVmW.AYUAbz(this) : this.f9085B7CMnp;
    }

    public boolean AYUAbz() {
        return this.f9092BPw6Q8 && this.f9097C2rE4F && this.f9098C4FrIb;
    }

    public void AZOQYO() {
        int indexOf;
        BChYOn bChYOn = this.f9109CmUvjW;
        if (bChYOn == null || (indexOf = bChYOn.f2118AmA8tU.indexOf(this)) == -1) {
            return;
        }
        bChYOn.notifyItemChanged(indexOf, this);
    }

    public void AZkASS(boolean z) {
        ArrayList arrayList = this.f9110CqNSpT;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Preference preference = (Preference) arrayList.get(i);
            if (preference.f9097C2rE4F == z) {
                preference.f9097C2rE4F = !z;
                preference.AZkASS(preference.BTvldC());
                preference.AZOQYO();
            }
        }
    }

    public void AaHO0E() {
        PreferenceScreen preferenceScreen;
        String str = this.f9096BniPrB;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        BNL6CD bnl6cd = this.f9078AlLFFp;
        Preference preference = null;
        if (bnl6cd != null && (preferenceScreen = bnl6cd.f2132ASJ6gh) != null) {
            preference = preferenceScreen.BniPrB(str);
        }
        if (preference == null) {
            StringBuilder B3GDIM2 = CtFAbx.B3GDIM("Dependency \"", str, "\" not found for preference \"");
            B3GDIM2.append(this.f9088BI9f7h);
            B3GDIM2.append("\" (title: \"");
            B3GDIM2.append((Object) this.f9084B4ZgIw);
            B3GDIM2.append("\"");
            throw new IllegalStateException(B3GDIM2.toString());
        }
        if (preference.f9110CqNSpT == null) {
            preference.f9110CqNSpT = new ArrayList();
        }
        preference.f9110CqNSpT.add(this);
        boolean BTvldC2 = preference.BTvldC();
        if (this.f9097C2rE4F == BTvldC2) {
            this.f9097C2rE4F = !BTvldC2;
            AZkASS(BTvldC());
            AZOQYO();
        }
    }

    public final void AcNBzu(BNL6CD bnl6cd) {
        this.f9078AlLFFp = bnl6cd;
        if (!this.f9080AzWtSf) {
            this.f9079AmA8tU = bnl6cd.A5SV6n();
        }
        if (BV3sI0()) {
            BNL6CD bnl6cd2 = this.f9078AlLFFp;
            if ((bnl6cd2 != null ? bnl6cd2.ADYaiT() : null).contains(this.f9088BI9f7h)) {
                B7CMnp(null, true);
                return;
            }
        }
        Object obj = this.BpkvW3;
        if (obj != null) {
            B7CMnp(obj, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void AlLFFp(DRlcZ9.BV3sI0 r11) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.Preference.AlLFFp(DRlcZ9.BV3sI0):void");
    }

    public void AmA8tU() {
    }

    public void AzWtSf() {
        ArrayList arrayList;
        PreferenceScreen preferenceScreen;
        String str = this.f9096BniPrB;
        if (str != null) {
            BNL6CD bnl6cd = this.f9078AlLFFp;
            Preference preference = null;
            if (bnl6cd != null && (preferenceScreen = bnl6cd.f2132ASJ6gh) != null) {
                preference = preferenceScreen.BniPrB(str);
            }
            if (preference == null || (arrayList = preference.f9110CqNSpT) == null) {
                return;
            }
            arrayList.remove(this);
        }
    }

    public Object B25kr6(TypedArray typedArray, int i) {
        return null;
    }

    public void B2KMhB(Parcelable parcelable) {
        this.f9112CtFAbx = true;
        if (parcelable != AbsSavedState.EMPTY_STATE && parcelable != null) {
            throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
        }
    }

    public Parcelable B3GDIM() {
        this.f9112CtFAbx = true;
        return AbsSavedState.EMPTY_STATE;
    }

    public void B4ZgIw(Object obj) {
    }

    public void B7CMnp(Object obj, boolean z) {
        B4ZgIw(obj);
    }

    public void B9tovu(View view) {
        B4ZgIw b4ZgIw;
        if (AYUAbz() && this.f9093BTvldC) {
            AmA8tU();
            AmA8tU amA8tU = this.f9082B2KMhB;
            if (amA8tU == null || !amA8tU.AaHO0E(this)) {
                BNL6CD bnl6cd = this.f9078AlLFFp;
                if ((bnl6cd == null || (b4ZgIw = bnl6cd.f2133AYUAbz) == null || !b4ZgIw.A5SV6n(this)) && this.f9089BIYEnU != null) {
                    getContext().startActivity(this.f9089BIYEnU);
                }
            }
        }
    }

    public final void BChYOn(int i) {
        if (BV3sI0() && i != AMqCpz(~i)) {
            SharedPreferences.Editor A4TApA2 = this.f9078AlLFFp.A4TApA();
            A4TApA2.putInt(this.f9088BI9f7h, i);
            if (this.f9078AlLFFp.AMqCpz) {
                return;
            }
            A4TApA2.apply();
        }
    }

    public final void BI9f7h(String str) {
        if (BV3sI0() && !TextUtils.equals(str, ARc23Z(null))) {
            SharedPreferences.Editor A4TApA2 = this.f9078AlLFFp.A4TApA();
            A4TApA2.putString(this.f9088BI9f7h, str);
            if (this.f9078AlLFFp.AMqCpz) {
                return;
            }
            A4TApA2.apply();
        }
    }

    public final void BIYEnU(boolean z) {
        if (this.f9092BPw6Q8 != z) {
            this.f9092BPw6Q8 = z;
            AZkASS(BTvldC());
            AZOQYO();
        }
    }

    public void BNL6CD(CharSequence charSequence) {
        if (this.f9114D07BeM != null) {
            throw new IllegalStateException("Preference already has a SummaryProvider set.");
        }
        if (TextUtils.equals(this.f9085B7CMnp, charSequence)) {
            return;
        }
        this.f9085B7CMnp = charSequence;
        AZOQYO();
    }

    public final void BPw6Q8(int i) {
        String string = this.f9077AcNBzu.getString(i);
        if (TextUtils.equals(string, this.f9084B4ZgIw)) {
            return;
        }
        this.f9084B4ZgIw = string;
        AZOQYO();
    }

    public boolean BTvldC() {
        return !AYUAbz();
    }

    public final boolean BV3sI0() {
        return (this.f9078AlLFFp == null || !this.f9095BmvVmW || TextUtils.isEmpty(this.f9088BI9f7h)) ? false : true;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Preference preference) {
        Preference preference2 = preference;
        int i = this.f9083B3GDIM;
        int i2 = preference2.f9083B3GDIM;
        if (i != i2) {
            return i - i2;
        }
        CharSequence charSequence = this.f9084B4ZgIw;
        CharSequence charSequence2 = preference2.f9084B4ZgIw;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference2.f9084B4ZgIw.toString());
    }

    public Context getContext() {
        return this.f9077AcNBzu;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = this.f9084B4ZgIw;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence ASJ6gh2 = ASJ6gh();
        if (!TextUtils.isEmpty(ASJ6gh2)) {
            sb.append(ASJ6gh2);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, A4TApA.A2egSU(context, 2130969758, R.attr.preferenceStyle));
    }
}
