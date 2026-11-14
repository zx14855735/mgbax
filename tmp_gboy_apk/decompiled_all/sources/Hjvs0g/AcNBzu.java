package Hjvs0g;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AcNBzu implements HSHyT0.AZkASS {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final B25kr6 f3719A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final URL f3720A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final String f3721ADYaiT;
    public String AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public URL f3722ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public volatile byte[] f3723ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f3724AYUAbz;

    public AcNBzu(URL url) {
        B25kr6 b25kr6 = AlLFFp.f3725A2egSU;
        ItGa5w.ARc23Z.A5SV6n(url, "Argument must not be null");
        this.f3720A5SV6n = url;
        this.f3721ADYaiT = null;
        ItGa5w.ARc23Z.A5SV6n(b25kr6, "Argument must not be null");
        this.f3719A4TApA = b25kr6;
    }

    @Override // HSHyT0.AZkASS
    public final void A2egSU(MessageDigest messageDigest) {
        if (this.f3723ASJ6gh == null) {
            this.f3723ASJ6gh = A5SV6n().getBytes(HSHyT0.AZkASS.f3465A2egSU);
        }
        messageDigest.update(this.f3723ASJ6gh);
    }

    public final String A5SV6n() {
        String str = this.f3721ADYaiT;
        if (str != null) {
            return str;
        }
        URL url = this.f3720A5SV6n;
        ItGa5w.ARc23Z.A5SV6n(url, "Argument must not be null");
        return url.toString();
    }

    public final URL ADYaiT() {
        if (this.f3722ARc23Z == null) {
            if (TextUtils.isEmpty(this.AMqCpz)) {
                String str = this.f3721ADYaiT;
                if (TextUtils.isEmpty(str)) {
                    URL url = this.f3720A5SV6n;
                    ItGa5w.ARc23Z.A5SV6n(url, "Argument must not be null");
                    str = url.toString();
                }
                this.AMqCpz = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
            }
            this.f3722ARc23Z = new URL(this.AMqCpz);
        }
        return this.f3722ARc23Z;
    }

    @Override // HSHyT0.AZkASS
    public final boolean equals(Object obj) {
        if (!(obj instanceof AcNBzu)) {
            return false;
        }
        AcNBzu acNBzu = (AcNBzu) obj;
        return A5SV6n().equals(acNBzu.A5SV6n()) && this.f3719A4TApA.equals(acNBzu.f3719A4TApA);
    }

    @Override // HSHyT0.AZkASS
    public final int hashCode() {
        if (this.f3724AYUAbz == 0) {
            int hashCode = A5SV6n().hashCode();
            this.f3724AYUAbz = hashCode;
            this.f3724AYUAbz = this.f3719A4TApA.f3731A4TApA.hashCode() + (hashCode * 31);
        }
        return this.f3724AYUAbz;
    }

    public final String toString() {
        return A5SV6n();
    }

    public AcNBzu(String str, B25kr6 b25kr6) {
        this.f3720A5SV6n = null;
        if (!TextUtils.isEmpty(str)) {
            this.f3721ADYaiT = str;
            ItGa5w.ARc23Z.A5SV6n(b25kr6, "Argument must not be null");
            this.f3719A4TApA = b25kr6;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
}
