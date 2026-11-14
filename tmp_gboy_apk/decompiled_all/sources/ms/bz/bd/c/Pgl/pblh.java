package ms.bz.bd.c.Pgl;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class pblh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final String f14041A2egSU = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "d5091b", new byte[]{69, 37, com.sigmob.sdk.archives.tar.e.P, 78, 11, 102, 116, 27, 115});

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final String f14042A4TApA = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "7b0627", new byte[]{14, 97, 81, 70, 26, 33, 38, 70});

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final String f14043A5SV6n = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "7a875a", new byte[]{0, 102, 74, 87, 31, 100, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.Q});

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final String f14044ADYaiT = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "4248f2", new byte[]{com.sigmob.sdk.archives.tar.e.M, com.sigmob.sdk.archives.tar.e.K});
    public static final String AMqCpz = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "b3baeb", new byte[]{123, 38});

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final String f14045ARc23Z = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "da47ac", new byte[]{115, 119});

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final String f14046ASJ6gh = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "136059", new byte[]{45, com.sigmob.sdk.archives.tar.e.H, 93});

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static final String f14047AYUAbz = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "53231e", new byte[]{41, 56, 79});

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static final String f14048AZOQYO = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "9091ce", new byte[]{43, 61, com.sigmob.sdk.archives.tar.e.S, 64});

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final FileFilter f14049AZkASS = new pgla();

    public class pgla implements FileFilter {
        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            return Pattern.matches((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "60064c", new byte[]{36, 34, 86, 121, 91, 57, 108, 44}), file.getName());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
    
        if (r4 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.HashMap A2egSU() {
        /*
            r0 = 0
            r1 = 1
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L6b
            java.lang.String r9 = "97b2d1"
            r5 = 13
            byte[] r10 = new byte[r5]     // Catch: java.lang.Throwable -> L6b
            r10 = {x0078: FILL_ARRAY_DATA , data: [103, 37, 3, 73, 88, 105, 57, 6, 38, 107, 38, 51, 30} // fill-array     // Catch: java.lang.Throwable -> L6b
            r5 = 16777217(0x1000001, float:2.350989E-38)
            r6 = 0
            r7 = 0
            java.lang.Object r5 = com.volcengine.mobsecBiz.matrix.pgla.a(r5, r6, r7, r9, r10)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L6b
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L6b
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L69
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L69
        L27:
            java.lang.String r3 = r5.readLine()     // Catch: java.lang.Throwable -> L66
            if (r3 != 0) goto L34
            r5.close()     // Catch: java.lang.Throwable -> L30
        L30:
            r4.close()     // Catch: java.lang.Throwable -> L77
            goto L77
        L34:
            java.lang.String r10 = "69fbe5"
            byte[] r11 = new byte[r1]     // Catch: java.lang.Throwable -> L66
            r6 = 125(0x7d, float:1.75E-43)
            r11[r0] = r6     // Catch: java.lang.Throwable -> L66
            r6 = 16777217(0x1000001, float:2.350989E-38)
            r7 = 0
            r8 = 0
            java.lang.Object r6 = com.volcengine.mobsecBiz.matrix.pgla.a(r6, r7, r8, r10, r11)     // Catch: java.lang.Throwable -> L66
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L66
            r7 = 2
            java.lang.String[] r3 = r3.split(r6, r7)     // Catch: java.lang.Throwable -> L66
            int r6 = r3.length     // Catch: java.lang.Throwable -> L66
            if (r6 < r7) goto L27
            r6 = r3[r0]     // Catch: java.lang.Throwable -> L66
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> L66
            r3 = r3[r1]     // Catch: java.lang.Throwable -> L66
            java.lang.String r3 = r3.trim()     // Catch: java.lang.Throwable -> L66
            java.lang.Object r7 = r2.get(r6)     // Catch: java.lang.Throwable -> L66
            if (r7 != 0) goto L27
            r2.put(r6, r3)     // Catch: java.lang.Throwable -> L66
            goto L27
        L66:
            r3 = r5
            goto L6d
        L69:
            goto L6d
        L6b:
            r4 = r3
        L6d:
            if (r3 == 0) goto L74
            r3.close()     // Catch: java.lang.Throwable -> L73
            goto L74
        L73:
        L74:
            if (r4 == 0) goto L77
            goto L30
        L77:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblh.A2egSU():java.util.HashMap");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
    
        if (r10 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String A4TApA(java.lang.String r10) {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L23
            r3.<init>(r10)     // Catch: java.lang.Throwable -> L23
            boolean r10 = r3.exists()     // Catch: java.lang.Throwable -> L23
            if (r10 != 0) goto L25
            java.lang.String r8 = "7d202f"
            byte[] r9 = new byte[r1]     // Catch: java.lang.Throwable -> L23
            r10 = 118(0x76, float:1.65E-43)
            r9[r0] = r10     // Catch: java.lang.Throwable -> L23
            r4 = 16777217(0x1000001, float:2.350989E-38)
            r5 = 0
            r6 = 0
            java.lang.Object r10 = com.volcengine.mobsecBiz.matrix.pgla.a(r4, r5, r6, r8, r9)     // Catch: java.lang.Throwable -> L23
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L23
            return r10
        L23:
            goto L41
        L25:
            java.io.FileReader r10 = new java.io.FileReader     // Catch: java.lang.Throwable -> L23
            r10.<init>(r3)     // Catch: java.lang.Throwable -> L23
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3e
            r3.<init>(r10)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L3c
            r3.close()     // Catch: java.lang.Throwable -> L36
        L36:
            r10.close()     // Catch: java.lang.Throwable -> L3a
            goto L4d
        L3a:
            goto L4d
        L3c:
            goto L43
        L3e:
            r3 = r2
            goto L43
        L41:
            r10 = r2
            r3 = r10
        L43:
            if (r3 == 0) goto L4a
            r3.close()     // Catch: java.lang.Throwable -> L49
            goto L4a
        L49:
        L4a:
            if (r10 == 0) goto L4d
            goto L36
        L4d:
            if (r2 != 0) goto L64
            byte[] r8 = new byte[r1]
            r10 = 112(0x70, float:1.57E-43)
            r8[r0] = r10
            r5 = 0
            java.lang.String r7 = "17fbff"
            r3 = 16777217(0x1000001, float:2.350989E-38)
            r4 = 0
            java.lang.Object r10 = com.volcengine.mobsecBiz.matrix.pgla.a(r3, r4, r5, r7, r8)
            java.lang.String r10 = (java.lang.String) r10
            return r10
        L64:
            java.lang.String r10 = r2.trim()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblh.A4TApA(java.lang.String):java.lang.String");
    }
}
