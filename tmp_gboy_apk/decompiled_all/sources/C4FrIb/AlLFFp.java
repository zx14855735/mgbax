package C4FrIb;

import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AlLFFp {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final B25kr6.AZkASS f1570A2egSU = new B25kr6.AZkASS(16);

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final ThreadPoolExecutor f1571A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final Object f1572A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final B25kr6.AzWtSf f1573ADYaiT;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new B3GDIM(0));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f1571A4TApA = threadPoolExecutor;
        f1572A5SV6n = new Object();
        f1573ADYaiT = new B25kr6.AzWtSf();
        zAGrWl();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static C4FrIb.AcNBzu A2egSU(java.lang.String r6, android.content.Context r7, C4FrIb.AYUAbz r8, int r9) {
        /*
            B25kr6.AZkASS r0 = C4FrIb.AlLFFp.f1570A2egSU
            java.lang.Object r1 = r0.A2egSU(r6)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L10
            C4FrIb.AcNBzu r6 = new C4FrIb.AcNBzu
            r6.<init>(r1)
            return r6
        L10:
            C4FrIb.AmA8tU r8 = C4FrIb.ASJ6gh.A2egSU(r7, r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5c
            r1 = 1
            r2 = -3
            java.lang.Object r3 = r8.f1575AlLFFp
            C4FrIb.AzWtSf[] r3 = (C4FrIb.AzWtSf[]) r3
            int r8 = r8.f1574AcNBzu
            if (r8 == 0) goto L24
            if (r8 == r1) goto L22
        L20:
            r1 = -3
            goto L3d
        L22:
            r1 = -2
            goto L3d
        L24:
            if (r3 == 0) goto L3d
            int r8 = r3.length
            if (r8 != 0) goto L2a
            goto L3d
        L2a:
            int r8 = r3.length
            r1 = 0
            r4 = 0
        L2d:
            if (r4 >= r8) goto L3d
            r5 = r3[r4]
            int r5 = r5.AMqCpz
            if (r5 == 0) goto L3a
            if (r5 >= 0) goto L38
            goto L20
        L38:
            r1 = r5
            goto L3d
        L3a:
            int r4 = r4 + 1
            goto L2d
        L3d:
            if (r1 == 0) goto L45
            C4FrIb.AcNBzu r6 = new C4FrIb.AcNBzu
            r6.<init>(r1)
            return r6
        L45:
            JrXYwF.A4TApA r8 = BV3sI0.AYUAbz.f1490A2egSU
            android.graphics.Typeface r7 = r8.BIYEnU(r7, r3, r9)
            if (r7 == 0) goto L56
            r0.A4TApA(r6, r7)
            C4FrIb.AcNBzu r6 = new C4FrIb.AcNBzu
            r6.<init>(r7)
            return r6
        L56:
            C4FrIb.AcNBzu r6 = new C4FrIb.AcNBzu
            r6.<init>(r2)
            return r6
        L5c:
            C4FrIb.AcNBzu r6 = new C4FrIb.AcNBzu
            r7 = -1
            r6.<init>(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: C4FrIb.AlLFFp.A2egSU(java.lang.String, android.content.Context, C4FrIb.AYUAbz, int):C4FrIb.AcNBzu");
    }

    private static /* synthetic */ void zAGrWl() {
        char[] charArray = "ìàâ¡èîâê¡íàö¡üçêãã¡ÅáæÍýæëèê".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 143);
        }
        String str = new String(charArray);
        char[] charArray2 = "ìãæáæû".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 143);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
