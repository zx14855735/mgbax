package H0R8Px;

import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f3133A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final long[] f3134A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f3135A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public G58fqA.A2egSU f3136ADYaiT;
    public final /* synthetic */ AMqCpz AMqCpz;

    public A5SV6n(AMqCpz aMqCpz, String str) {
        this.AMqCpz = aMqCpz;
        this.f3133A2egSU = str;
        this.f3134A4TApA = new long[aMqCpz.f3143B2KMhB];
    }

    public final File A2egSU(int i) {
        return new File(this.AMqCpz.f3138AcNBzu, this.f3133A2egSU + "." + i);
    }

    public final String A4TApA() {
        StringBuilder sb = new StringBuilder();
        for (long j : this.f3134A4TApA) {
            sb.append(' ');
            sb.append(j);
        }
        return sb.toString();
    }

    public final File A5SV6n(int i) {
        return new File(this.AMqCpz.f3138AcNBzu, this.f3133A2egSU + "." + i + ".tmp");
    }
}
