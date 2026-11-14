package DRlcZ9;

import android.text.TextUtils;
import androidx.preference.Preference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B9tovu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f2113A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f2114A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final String f2115A5SV6n;

    public B9tovu(Preference preference) {
        this.f2115A5SV6n = preference.getClass().getName();
        this.f2113A2egSU = preference.f9107CikNvS;
        this.f2114A4TApA = preference.f9108CkXcdM;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof B9tovu)) {
            return false;
        }
        B9tovu b9tovu = (B9tovu) obj;
        return this.f2113A2egSU == b9tovu.f2113A2egSU && this.f2114A4TApA == b9tovu.f2114A4TApA && TextUtils.equals(this.f2115A5SV6n, b9tovu.f2115A5SV6n);
    }

    public final int hashCode() {
        return this.f2115A5SV6n.hashCode() + ((((527 + this.f2113A2egSU) * 31) + this.f2114A4TApA) * 31);
    }
}
