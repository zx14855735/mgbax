package OdANhw;

import D8MqeW.AzWtSf;
import D8MqeW.B4ZgIw;
import LqstKO.AMqCpz;
import PCV8se.AlLFFp;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final B4ZgIw[] f6633ADYaiT = {AlLFFp.ADYaiT(AlLFFp.f7078ASJ6gh, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), AlLFFp.ADYaiT(AlLFFp.f7077ARc23Z, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), AlLFFp.ADYaiT(AlLFFp.f7075A5SV6n, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), AlLFFp.ADYaiT(AlLFFp.f7074A4TApA, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), AlLFFp.ADYaiT(AlLFFp.f7076ADYaiT, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), AlLFFp.ADYaiT(AlLFFp.AMqCpz, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), AlLFFp.ADYaiT(AlLFFp.f7073A2egSU, new RectF(-1.0f, -1.0f, 1.0f, 1.0f))};
    public static final AzWtSf[] AMqCpz = new AzWtSf[7];

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AMqCpz f6634A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Path f6635A4TApA = new Path();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Matrix f6636A5SV6n = new Matrix();

    /* JADX WARN: Code restructure failed: missing block: B:140:0x05cb, code lost:
    
        throw new java.lang.IllegalArgumentException("Cutting point is expected to be between 0 and 1");
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x018c A[SYNTHETIC] */
    static {
        /*
            Method dump skipped, instructions count: 1488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: OdANhw.A5SV6n.<clinit>():void");
    }

    public A5SV6n(AMqCpz aMqCpz) {
        this.f6634A2egSU = aMqCpz;
    }

    private static /* synthetic */ void oPAB() {
        char[] charArray = "\u0084\u0088\u008aÉ\u0080\u0086\u008a\u0082É\u0085\u0088\u009eÉ\u0094\u008f\u0082\u008b\u008bÉ\u00ad\u0089\u008e¥\u0095\u008e\u0083\u0080\u0082".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 231);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0084\u008b\u008e\u0089\u008e\u0093".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 231);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
