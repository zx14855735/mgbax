package D8MqeW;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final B25kr6.AaHO0E f2015A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final B25kr6.AaHO0E f2016A4TApA;

    static {
        new ADYaiT(new R8Rbcg.A4TApA(Float.valueOf(0.0f), Float.valueOf(0.0f)), new R8Rbcg.A4TApA(Float.valueOf(0.5f), Float.valueOf(0.5f)));
        xjZeW();
    }

    public ADYaiT(R8Rbcg.A4TApA... a4TApAArr) {
        RXb0Sz.ARc23Z.AMqCpz(a4TApAArr, "mappings");
        this.f2015A2egSU = new B25kr6.AaHO0E(a4TApAArr.length);
        this.f2016A4TApA = new B25kr6.AaHO0E(a4TApAArr.length);
        int length = a4TApAArr.length;
        for (int i = 0; i < length; i++) {
            this.f2015A2egSU.A2egSU(((Number) a4TApAArr[i].f7826AcNBzu).floatValue());
            this.f2016A4TApA.A2egSU(((Number) a4TApAArr[i].f7827AlLFFp).floatValue());
        }
        com.bumptech.glide.A5SV6n.DjONCG(this.f2015A2egSU);
        com.bumptech.glide.A5SV6n.DjONCG(this.f2016A4TApA);
    }

    private static /* synthetic */ void xjZeW() {
        char[] charArray = "\u0088\u0084\u0086Å\u008c\u008a\u0086\u008eÅ\u0089\u0084\u0092Å\u0098\u0083\u008e\u0087\u0087Å¡\u0085\u0082©\u0099\u0082\u008f\u008c\u008e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 235);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0088\u0087\u0082\u0085\u0082\u009f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 235);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
