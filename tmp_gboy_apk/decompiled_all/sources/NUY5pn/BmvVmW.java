package NUY5pn;

import android.content.ComponentName;
import android.os.IBinder;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BmvVmW {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final BniPrB f6020A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final BV3sI0 f6021A4TApA = new BV3sI0(this);

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final HashSet f6022A5SV6n = new HashSet();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f6023ADYaiT = 2;
    public boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public IBinder f6024ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final BTvldC f6025ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public ComponentName f6026AYUAbz;

    public BmvVmW(BniPrB bniPrB, BTvldC bTvldC) {
        this.f6020A2egSU = bniPrB;
        this.f6025ASJ6gh = bTvldC;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004e, code lost:
    
        if ((NGepWW.B4ZgIw.A2egSU(r4).f2550AlLFFp.getPackageManager().getApplicationInfo(r1, 0).flags & 2097152) != 0) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A2egSU() {
        /*
            r7 = this;
            r0 = 3
            r7.f6023ADYaiT = r0
            NUY5pn.BniPrB r0 = r7.f6020A2egSU
            NRGvz2.A2egSU r1 = r0.f6030B2KMhB
            NUY5pn.BTvldC r2 = r7.f6025ASJ6gh
            java.lang.String r3 = r2.f6017A2egSU
            if (r3 == 0) goto L19
            android.content.Intent r4 = new android.content.Intent
            r4.<init>(r3)
            java.lang.String r2 = r2.f6018A4TApA
            android.content.Intent r2 = r4.setPackage(r2)
            goto L23
        L19:
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            r3 = 0
            android.content.Intent r2 = r2.setComponent(r3)
        L23:
            r1.getClass()
            android.content.ComponentName r1 = r2.getComponent()
            NUY5pn.BV3sI0 r3 = r7.f6021A4TApA
            android.content.Context r4 = r0.f6028AzWtSf
            if (r1 != 0) goto L31
            goto L51
        L31:
            java.lang.String r1 = r1.getPackageName()
            java.lang.String r5 = "com.google.android.gms"
            r5.equals(r1)
            EsrwYR.A4TApA r5 = NGepWW.B4ZgIw.A2egSU(r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L51
            android.content.Context r5 = r5.f2550AlLFFp     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L51
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L51
            r6 = 0
            android.content.pm.ApplicationInfo r1 = r5.getApplicationInfo(r1, r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L51
            int r1 = r1.flags     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L51
            r5 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r5
            if (r1 == 0) goto L51
            goto L57
        L51:
            r1 = 129(0x81, float:1.81E-43)
            boolean r6 = r4.bindService(r2, r3, r1)
        L57:
            r7.AMqCpz = r6
            if (r6 != 0) goto L66
            r1 = 2
            r7.f6023ADYaiT = r1
            NRGvz2.A2egSU r0 = r0.f6030B2KMhB     // Catch: java.lang.IllegalArgumentException -> L66
            r0.getClass()     // Catch: java.lang.IllegalArgumentException -> L66
            r4.unbindService(r3)     // Catch: java.lang.IllegalArgumentException -> L66
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: NUY5pn.BmvVmW.A2egSU():void");
    }
}
