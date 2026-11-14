package ms.bz.bd.c.Pgl;

import com.sigmob.sdk.downloader.f;
import java.io.BufferedInputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class pblm {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final String f14051A2egSU;

    static {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c20335", new byte[]{73, 108, 2, 25, com.sigmob.sdk.archives.tar.e.I});
        f14051A2egSU = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fdcd86", new byte[]{99, 114, 47, 30, 3});
    }

    public static String A2egSU(BufferedInputStream bufferedInputStream) {
        int read;
        byte[] bArr = new byte[f.a.c];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                }
            } catch (Exception unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "89a04e", new byte[]{44, com.sigmob.sdk.archives.tar.e.J, 17});
            }
        } while (read >= 4096);
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c5, code lost:
    
        if (r3 == null) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String A4TApA(java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblm.A4TApA(java.lang.String):java.lang.String");
    }
}
