package com.sigmob.sdk.base.services;

import com.czhj.sdk.common.ClientMetadata;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13211a = "LocationService";
    public static final String b = "AppInstallService";
    public static final String c = "WifiScanService";
    public static final String d = "DownloadService";
    private static a e;
    private static a f;
    private static a g;
    private static a h;

    public interface a {
        boolean e();

        g f();

        void g();

        Error h();
    }

    public static a a() {
        return f;
    }

    public static a b() {
        return g;
    }

    public static a c() {
        return h;
    }

    public static a d() {
        return e;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0061 A[Catch: all -> 0x0023, TRY_ENTER, TryCatch #0 {all -> 0x0023, blocks: (B:4:0x0003, B:18:0x0043, B:20:0x0047, B:25:0x0052, B:27:0x0056, B:32:0x0061, B:34:0x0065, B:39:0x0019, B:42:0x0025, B:45:0x002f), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized com.sigmob.sdk.base.services.f.a a(java.lang.String r5) {
        /*
            java.lang.Class<com.sigmob.sdk.base.services.f> r0 = com.sigmob.sdk.base.services.f.class
            monitor-enter(r0)
            int r1 = r5.hashCode()     // Catch: java.lang.Throwable -> L23
            r2 = 353926395(0x15187cfb, float:3.0794748E-26)
            r3 = 1
            r4 = 2
            if (r1 == r2) goto L2f
            r2 = 854806816(0x32f35120, float:2.8325815E-8)
            if (r1 == r2) goto L25
            r2 = 1382229229(0x526324ed, float:2.43894272E11)
            if (r1 == r2) goto L19
            goto L39
        L19:
            java.lang.String r1 = "DownloadService"
            boolean r5 = r5.equals(r1)     // Catch: java.lang.Throwable -> L23
            if (r5 == 0) goto L39
            r5 = 2
            goto L3a
        L23:
            r5 = move-exception
            goto L70
        L25:
            java.lang.String r1 = "LocationService"
            boolean r5 = r5.equals(r1)     // Catch: java.lang.Throwable -> L23
            if (r5 == 0) goto L39
            r5 = 0
            goto L3a
        L2f:
            java.lang.String r1 = "AppInstallService"
            boolean r5 = r5.equals(r1)     // Catch: java.lang.Throwable -> L23
            if (r5 == 0) goto L39
            r5 = 1
            goto L3a
        L39:
            r5 = -1
        L3a:
            if (r5 == 0) goto L61
            if (r5 == r3) goto L52
            if (r5 == r4) goto L43
            monitor-exit(r0)
            r5 = 0
            return r5
        L43:
            com.sigmob.sdk.base.services.f$a r5 = com.sigmob.sdk.base.services.f.h     // Catch: java.lang.Throwable -> L23
            if (r5 != 0) goto L50
            com.sigmob.sdk.base.services.d r5 = new com.sigmob.sdk.base.services.d     // Catch: java.lang.Throwable -> L23
            r5.<init>()     // Catch: java.lang.Throwable -> L23
            com.sigmob.sdk.base.services.f.h = r5     // Catch: java.lang.Throwable -> L23
            monitor-exit(r0)
            return r5
        L50:
            monitor-exit(r0)
            return r5
        L52:
            com.sigmob.sdk.base.services.f$a r5 = com.sigmob.sdk.base.services.f.f     // Catch: java.lang.Throwable -> L23
            if (r5 != 0) goto L5f
            com.sigmob.sdk.base.services.b r5 = new com.sigmob.sdk.base.services.b     // Catch: java.lang.Throwable -> L23
            r5.<init>()     // Catch: java.lang.Throwable -> L23
            com.sigmob.sdk.base.services.f.f = r5     // Catch: java.lang.Throwable -> L23
            monitor-exit(r0)
            return r5
        L5f:
            monitor-exit(r0)
            return r5
        L61:
            com.sigmob.sdk.base.services.f$a r5 = com.sigmob.sdk.base.services.f.e     // Catch: java.lang.Throwable -> L23
            if (r5 != 0) goto L6e
            com.sigmob.sdk.base.services.e r5 = new com.sigmob.sdk.base.services.e     // Catch: java.lang.Throwable -> L23
            r5.<init>()     // Catch: java.lang.Throwable -> L23
            com.sigmob.sdk.base.services.f.e = r5     // Catch: java.lang.Throwable -> L23
            monitor-exit(r0)
            return r5
        L6e:
            monitor-exit(r0)
            return r5
        L70:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L23
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.services.f.a(java.lang.String):com.sigmob.sdk.base.services.f$a");
    }

    public static void a(String str, boolean z) {
        a a2 = a(str);
        if (a2 == null) {
            return;
        }
        str.getClass();
        switch (str) {
            case "WifiScanService":
                if (!z) {
                    a aVar = g;
                    if (aVar != null) {
                        aVar.g();
                        break;
                    }
                } else {
                    a2.e();
                    break;
                }
                break;
            case "AppInstallService":
                if (!z) {
                    a aVar2 = f;
                    if (aVar2 != null) {
                        aVar2.g();
                        break;
                    }
                } else {
                    a2.e();
                    break;
                }
                break;
            case "LocationService":
                if (z) {
                    a2.e();
                } else {
                    a aVar3 = e;
                    if (aVar3 != null) {
                        aVar3.g();
                    }
                }
                ClientMetadata.getInstance().setEnableLocation(z);
                break;
            case "DownloadService":
                if (!z) {
                    a aVar4 = h;
                    if (aVar4 != null) {
                        aVar4.g();
                        break;
                    }
                } else {
                    a2.e();
                    break;
                }
                break;
        }
    }
}
