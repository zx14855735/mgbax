package IsbtnO;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A2egSU implements A4TApA {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final A2egSU f4063AcNBzu = new A2egSU();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final C0002A2egSU f4064AlLFFp = new C0002A2egSU();

    /* renamed from: IsbtnO.A2egSU$A2egSU, reason: collision with other inner class name */
    public static class C0002A2egSU implements A5SV6n {
        @Override // IsbtnO.A5SV6n
        public final A4TApA AlLFFp(int i) {
            return A2egSU.f4063AcNBzu;
        }
    }

    static {
        qkGWcnC();
    }

    private static /* synthetic */ void qkGWcnC() {
        char[] charArray = "ÉÅÇ\u0084ÍËÇÏ\u0084ÈÅÓ\u0084ÙÂÏÆÆ\u0084àÄÃèØÃÎÍÏ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 170);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÉÆÃÄÃÞ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 170);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // IsbtnO.A4TApA
    public final boolean AMqCpz(Object obj, IlwJBd.A4TApA a4TApA) {
        return false;
    }
}
