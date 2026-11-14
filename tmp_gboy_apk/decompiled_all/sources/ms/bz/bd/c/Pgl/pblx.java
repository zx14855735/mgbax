package ms.bz.bd.c.Pgl;

import android.os.Process;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class pblx extends pbly.pgla {
    public static void ADYaiT(BufferedInputStream bufferedInputStream) {
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b250a5", new byte[]{126, com.sigmob.sdk.archives.tar.e.K, 121, 71, 87});
            }
        }
    }

    public static void AMqCpz(DataOutputStream dataOutputStream) {
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "983f9c", new byte[]{37, 57, Byte.MAX_VALUE, 17, 9});
            }
        }
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A2egSU(int i, long j, String str, Object obj) {
        try {
            if (pblv.f14062A4TApA.f14063A2egSU.checkPermission(new String[]{(String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "939559", new byte[]{41, 63, 78, com.sigmob.sdk.archives.tar.e.Q, 5, 39, 62, 92, com.sigmob.sdk.archives.tar.e.R, 96, 58, 60, 67, 82, 25, 39, com.sigmob.sdk.archives.tar.e.M, 28, 38, com.sigmob.sdk.archives.tar.e.P, 6, 5, 111, 115, 36, 11, 14})}[0], Process.myPid(), Process.myUid()) != 0) {
                return null;
            }
            switch (i) {
                case 196609:
                    Object[] objArr = (Object[]) obj;
                    return ASJ6gh(str, (String) objArr[1], (String) objArr[2], (byte[]) objArr[0]);
                case 196610:
                    Object[] objArr2 = (Object[]) obj;
                    return ARc23Z(str, (String) objArr2[0], (String) objArr2[1]);
                case 196611:
                    Object[] objArr3 = (Object[]) obj;
                    return A5SV6n(str, (String) objArr3[0], (String) objArr3[1]);
                default:
                    return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public abstract Object[] A5SV6n(String str, String str2, String str3);

    public abstract Object[] ARc23Z(String str, String str2, String str3);

    public abstract Object[] ASJ6gh(String str, String str2, String str3, byte[] bArr);
}
