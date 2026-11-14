package CtFAbx;

import B25kr6.AzWtSf;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT {

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static final ThreadLocal f1879AZOQYO = new ThreadLocal();
    public final K1Z3yj.A2egSU AMqCpz;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public K1Z3yj.A2egSU f1886AYUAbz;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AzWtSf f1880A2egSU = new AzWtSf();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ArrayList f1881A4TApA = new ArrayList();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final AZkASS.ARc23Z f1882A5SV6n = new AZkASS.ARc23Z(8, this);

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final A2egSU f1883ADYaiT = new A2egSU(0, this);

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f1884ARc23Z = false;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public float f1885ASJ6gh = 1.0f;

    static {
        PcIelXL();
    }

    public ADYaiT(K1Z3yj.A2egSU a2egSU) {
        this.AMqCpz = a2egSU;
    }

    private static /* synthetic */ void PcIelXL() {
        char[] charArray = "ÎÂÀ\u0083ÊÌÀÈ\u0083ÏÂÔ\u0083ÞÅÈÁÁ\u0083çÃÄïßÄÉÊÈ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 173);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÎÁÄÃÄÙ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 173);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
