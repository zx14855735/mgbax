package ItGa5w;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final char[] f4092A2egSU = "0123456789abcdef".toCharArray();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final char[] f4093A4TApA = new char[64];

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static volatile Handler f4094A5SV6n;

    static {
        BEuSEd();
    }

    public static boolean A2egSU(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int A4TApA(int i, int i2, Bitmap.Config config) {
        int i3 = i * i2;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i4 = AcNBzu.f4091A2egSU[config.ordinal()];
        int i5 = 1;
        if (i4 != 1) {
            i5 = 2;
            if (i4 != 2 && i4 != 3) {
                i5 = 4;
                if (i4 == 4) {
                    i5 = 8;
                }
            }
        }
        return i3 * i5;
    }

    public static int A5SV6n(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static ArrayList ADYaiT(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object obj : collection) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Handler AMqCpz() {
        if (f4094A5SV6n == null) {
            synchronized (AlLFFp.class) {
                try {
                    if (f4094A5SV6n == null) {
                        f4094A5SV6n = new Handler(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        return f4094A5SV6n;
    }

    public static int ARc23Z(int i, int i2) {
        return (i2 * 31) + i;
    }

    public static int ASJ6gh(int i, Object obj) {
        return ARc23Z(obj == null ? 0 : obj.hashCode(), i);
    }

    public static boolean AYUAbz(int i, int i2) {
        if (i > 0 || i == Integer.MIN_VALUE) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }
        return false;
    }

    private static /* synthetic */ void BEuSEd() {
        char[] charArray = "þòð³úüðø³ÿòä³îõøññ³×óôßïôùúø".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 157);
        }
        String str = new String(charArray);
        char[] charArray2 = "þñôóôé".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 157);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
