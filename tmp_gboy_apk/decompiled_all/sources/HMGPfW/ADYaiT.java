package HMGPfW;

import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f3387A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final long[] f3388A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final File[] f3389A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final File[] f3390ADYaiT;
    public boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public A5SV6n f3391ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final /* synthetic */ AMqCpz f3392ASJ6gh;

    public ADYaiT(AMqCpz aMqCpz, String str) {
        this.f3392ASJ6gh = aMqCpz;
        this.f3387A2egSU = str;
        int i = aMqCpz.f3399B3GDIM;
        this.f3388A4TApA = new long[i];
        this.f3389A5SV6n = new File[i];
        this.f3390ADYaiT = new File[i];
        StringBuilder sb = new StringBuilder(str);
        sb.append('.');
        int length = sb.length();
        for (int i2 = 0; i2 < aMqCpz.f3399B3GDIM; i2++) {
            sb.append(i2);
            File[] fileArr = this.f3389A5SV6n;
            String sb2 = sb.toString();
            File file = aMqCpz.f3393AcNBzu;
            fileArr[i2] = new File(file, sb2);
            sb.append(".tmp");
            this.f3390ADYaiT[i2] = new File(file, sb.toString());
            sb.setLength(length);
        }
    }

    public final String A2egSU() {
        StringBuilder sb = new StringBuilder();
        for (long j : this.f3388A4TApA) {
            sb.append(' ');
            sb.append(j);
        }
        return sb.toString();
    }
}
