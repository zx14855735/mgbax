package DUi7mC;

import ADYaiT.BmvVmW;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final B3GDIM.AYUAbz f2184A2egSU = new B3GDIM.AYUAbz();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final Object f2185A4TApA = new Object();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static BmvVmW f2186A5SV6n = null;

    static {
        wixiUh();
    }

    public static long A2egSU(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? AZOQYO.A2egSU(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static BmvVmW A4TApA() {
        BmvVmW bmvVmW = new BmvVmW(13);
        f2186A5SV6n = bmvVmW;
        B3GDIM.AYUAbz aYUAbz = f2184A2egSU;
        aYUAbz.getClass();
        if (B3GDIM.ASJ6gh.f1034B2KMhB.BChYOn(aYUAbz, null, bmvVmW)) {
            B3GDIM.ASJ6gh.A4TApA(aYUAbz);
        }
        return f2186A5SV6n;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:14|(1:81)(1:18)|19|(1:80)(1:23)|24|25|26|(2:65|66)(1:28)|29|(9:36|(1:40)|(1:60)(1:47)|48|(2:56|57)|52|53|54|55)|(1:64)|(1:40)|(1:42)|60|48|(1:50)|56|57|52|53|54|55) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x009e, code lost:
    
        r4 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void A5SV6n(android.content.Context r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: DUi7mC.AaHO0E.A5SV6n(android.content.Context, boolean):void");
    }

    private static /* synthetic */ void wixiUh() {
        char[] charArray = "»·µö¿¹µ½öº·¡ö«°½´´ö\u0092¶±\u009aª±¼¿½".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 216);
        }
        String str = new String(charArray);
        char[] charArray2 = "»´±¶±¬".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 216);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
