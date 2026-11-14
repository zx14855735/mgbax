package NUY5pn;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final Object f5947A2egSU = new Object();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static boolean f5948A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static int f5949A5SV6n;

    static {
        hGdT();
    }

    public static void A2egSU(Handler handler) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException("Must be called on the handler thread");
        }
    }

    public static void A4TApA(Object obj) {
        if (obj == null) {
            throw new NullPointerException("null reference");
        }
    }

    public static void A5SV6n(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void ADYaiT(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
    }

    public static void AMqCpz(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(str));
        }
    }

    public static boolean ARc23Z(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void ASJ6gh(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(str));
        }
    }

    private static /* synthetic */ void hGdT() {
        char[] charArray = "\u0016\u001a\u0018[\u0012\u0014\u0018\u0010[\u0017\u001a\f[\u0006\u001d\u0010\u0019\u0019[?\u001b\u001c7\u0007\u001c\u0011\u0012\u0010".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'u');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0016\u0019\u001c\u001b\u001c\u0001".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'u');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
