package NGepWW;

import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class B4ZgIw {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final B4ZgIw f5693A4TApA = new B4ZgIw();

    /* renamed from: A2egSU, reason: collision with root package name */
    public EsrwYR.A4TApA f5694A2egSU = null;

    static {
        tlDMV();
    }

    public static EsrwYR.A4TApA A2egSU(Context context) {
        EsrwYR.A4TApA a4TApA;
        B4ZgIw b4ZgIw = f5693A4TApA;
        synchronized (b4ZgIw) {
            try {
                if (b4ZgIw.f5694A2egSU == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    b4ZgIw.f5694A2egSU = new EsrwYR.A4TApA(context, 7);
                }
                a4TApA = b4ZgIw.f5694A2egSU;
            } catch (Throwable th) {
                throw th;
            }
        }
        return a4TApA;
    }

    private static /* synthetic */ void tlDMV() {
        char[] charArray = "\u0005\t\u000bH\u0001\u0007\u000b\u0003H\u0004\t\u001fH\u0015\u000e\u0003\n\nH,\b\u000f$\u0014\u000f\u0002\u0001\u0003".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'f');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0005\n\u000f\b\u000f\u0012".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'f');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
