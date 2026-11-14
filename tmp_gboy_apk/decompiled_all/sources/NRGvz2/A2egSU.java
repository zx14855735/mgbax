package NRGvz2;

import NGepWW.ASJ6gh;
import android.os.Binder;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final Object f5914A2egSU = new Object();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static A2egSU f5915A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static Integer f5916A5SV6n;

    static {
        ZLVb();
    }

    public A2egSU() {
        if (f5916A5SV6n == null) {
            try {
                int i = A5SV6n.f5918A2egSU;
                f5916A5SV6n = 0;
            } catch (SecurityException unused) {
                int i2 = A5SV6n.f5918A2egSU;
                f5916A5SV6n = 0;
            }
        }
        int intValue = f5916A5SV6n.intValue();
        int i3 = A5SV6n.f5918A2egSU;
        if (intValue == 0) {
            List list = Collections.EMPTY_LIST;
            return;
        }
        ASJ6gh aSJ6gh = A4TApA.f5917A2egSU;
        aSJ6gh.getClass();
        try {
            aSJ6gh.A2egSU();
            throw null;
        } catch (SecurityException unused2) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                aSJ6gh.A2egSU();
                throw null;
            } catch (Throwable th) {
                Binder.restoreCallingIdentity(clearCallingIdentity);
                throw th;
            }
        }
    }

    private static /* synthetic */ void ZLVb() {
        char[] charArray = "²¾¼ÿ¶°¼´ÿ³¾¨ÿ¢¹´½½ÿ\u009b¿¸\u0093£¸µ¶´".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 209);
        }
        String str = new String(charArray);
        char[] charArray2 = "²½¸¿¸¥".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 209);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
