package ms.bz.bd.c.Pgl;

import android.content.Context;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class v0 {
    public static boolean A2egSU(Context context, String str, String str2) {
        try {
            String[] list = context.getAssets().list(str);
            if (list.length <= 0) {
                throw null;
            }
            new File(str2).mkdirs();
            for (String str3 : list) {
                A2egSU(context, str + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f7d399", new byte[]{56})) + str3, str2 + ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5e96a0", new byte[]{107})) + str3);
            }
            return true;
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d3691d", new byte[]{118, com.sigmob.sdk.archives.tar.e.H, 67});
            return false;
        }
    }

    public static void A4TApA() {
        boolean z;
        pbly.A2egSU(65537, new o0());
        pbly.A2egSU(65538, new p0());
        pbly.A2egSU(65539, new q0());
        pbly.A2egSU(65540, new r0());
        pbly.A2egSU(65541, new s0());
        pbly.A2egSU(65542, new t0());
        pbly.A2egSU(65543, new u0());
        r1 r1Var = new r1();
        pbly.A2egSU(196609, r1Var);
        pbly.A2egSU(196610, r1Var);
        pbly.A2egSU(196611, r1Var);
        String[] strArr = {(String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b84a93", new byte[]{112, com.sigmob.sdk.archives.tar.e.M, 74, 91, 4, 61, 117, 28, 97, com.sigmob.sdk.archives.tar.e.H, 125, 57, 66, 91, 0, com.sigmob.sdk.archives.tar.e.N, 96, 20, 114, 62, 97, com.sigmob.sdk.archives.tar.e.I, 9, 22, 9, com.sigmob.sdk.archives.tar.e.N, 100, 87, 118, com.sigmob.sdk.archives.tar.e.M, com.sigmob.sdk.archives.tar.e.R, com.sigmob.sdk.archives.tar.e.O, 72, 27, 15, com.sigmob.sdk.archives.tar.e.H, 110, 11, 43, 1, 116, com.sigmob.sdk.archives.tar.e.N, 116, com.sigmob.sdk.archives.tar.e.I, 45, 9, 110, 23, 108, 37, 124, 40, 114, 1, 15, 40, 114})};
        boolean z2 = true;
        for (int i = 0; i < 1; i++) {
            try {
                Class.forName(strArr[i]);
                z = true;
            } catch (Throwable unused) {
                z = false;
            }
            z2 &= z;
            if (!z2) {
                break;
            }
        }
        pblw o1Var = z2 ? new o1() : new pblj();
        synchronized (pblw.class) {
            pblw.f14064A2egSU = o1Var;
        }
        pbly.A2egSU(131073, o1Var);
        pbly.A2egSU(131074, o1Var);
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cf6e7f", new byte[]{119, 114, 64, 31, 28, 93, 111, 64, 74, com.sigmob.sdk.archives.tar.e.L, 124, 101, 66, 20, 26, com.sigmob.sdk.archives.tar.e.I, 99, 75, 102, 38, 97, 36, com.sigmob.sdk.archives.tar.e.P, 2, 72});
    }
}
