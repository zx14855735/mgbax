package Hjvs0g;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class COJEAR implements BI9f7h {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final COJEAR f3769A2egSU = new COJEAR();

    public static class A2egSU implements BIYEnU {

        /* renamed from: AcNBzu, reason: collision with root package name */
        public static final A2egSU f3770AcNBzu = new A2egSU();

        static {
            KAObO();
        }

        @Deprecated
        public A2egSU() {
        }

        private static /* synthetic */ void KAObO() {
            char[] charArray = "eik(agkc(di\u007f(uncjj(LhoDtobac".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 6);
            }
            String str = new String(charArray);
            char[] charArray2 = "ejohor".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 6);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        @Override // Hjvs0g.BIYEnU
        public final BI9f7h AYUAbz(BmvVmW bmvVmW) {
            return COJEAR.f3769A2egSU;
        }
    }

    static {
        QExJE();
    }

    @Deprecated
    public COJEAR() {
    }

    private static /* synthetic */ void QExJE() {
        char[] charArray = "ÅÉË\u0088ÁÇËÃ\u0088ÄÉß\u0088ÕÎÃÊÊ\u0088ìÈÏäÔÏÂÁÃ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 166);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÅÊÏÈÏÒ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 166);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // Hjvs0g.BI9f7h
    public final BChYOn A2egSU(Object obj, int i, int i2, HSHyT0.AmA8tU amA8tU) {
        return new BChYOn(new IssTRV.ADYaiT(obj), new ASJ6gh(1, obj));
    }

    @Override // Hjvs0g.BI9f7h
    public final boolean A4TApA(Object obj) {
        return true;
    }
}
