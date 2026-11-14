package ms.bz.bd.c.Pgl;

import android.util.SparseArray;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class pbly {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final SparseArray f14067A2egSU = new SparseArray();

    public static abstract class pgla {
        public Object A2egSU(int i, long j, String str, Object obj) {
            return A4TApA(str, obj);
        }

        public Object A4TApA(String str, Object obj) {
            return null;
        }
    }

    static {
        CVnoIbA();
    }

    public static void A2egSU(int i, pgla pglaVar) {
        SparseArray sparseArray = f14067A2egSU;
        pgla pglaVar2 = (pgla) sparseArray.get(i);
        if (pglaVar2 != null) {
            throw new RuntimeException(String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f3c10f", new byte[]{com.sigmob.sdk.archives.tar.e.J, 34, 80, 77, 14, 117, 37, 16, com.sigmob.sdk.archives.tar.e.O, 100, 121, 113, 2, 64, 8, com.sigmob.sdk.archives.tar.e.R, 118, 6, com.sigmob.sdk.archives.tar.e.O, 115, 57}), pglaVar2.toString()));
        }
        sparseArray.put(i, pglaVar);
    }

    private static /* synthetic */ void CVnoIbA() {
        char[] charArray = "\u001f\u0013\u0011R\u001b\u001d\u0011\u0019R\u001e\u0013\u0005R\u000f\u0014\u0019\u0010\u0010R6\u0012\u0015>\u000e\u0015\u0018\u001b\u0019".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '|');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001f\u0010\u0015\u0012\u0015\b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '|');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
