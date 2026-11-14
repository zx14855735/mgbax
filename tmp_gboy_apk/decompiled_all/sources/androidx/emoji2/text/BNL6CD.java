package androidx.emoji2.text;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BNL6CD {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final ThreadLocal f8687ADYaiT = new ThreadLocal();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f8688A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AZOQYO.ARc23Z f8689A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public volatile int f8690A5SV6n = 0;

    static {
        KyLDCva();
    }

    public BNL6CD(AZOQYO.ARc23Z aRc23Z, int i) {
        this.f8689A4TApA = aRc23Z;
        this.f8688A2egSU = i;
    }

    private static /* synthetic */ void KyLDCva() {
        char[] charArray = "\u0098\u0094\u0096Õ\u009c\u009a\u0096\u009eÕ\u0099\u0094\u0082Õ\u0088\u0093\u009e\u0097\u0097Õ±\u0095\u0092¹\u0089\u0092\u009f\u009c\u009e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 251);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0098\u0097\u0092\u0095\u0092\u008f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 251);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final int A2egSU(int i) {
        CtxOCS.A2egSU A4TApA2 = A4TApA();
        int A2egSU2 = A4TApA2.A2egSU(16);
        if (A2egSU2 == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = A4TApA2.f1918A4TApA;
        int i2 = A2egSU2 + A4TApA2.f1917A2egSU;
        return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i2) + i2 + 4);
    }

    public final CtxOCS.A2egSU A4TApA() {
        ThreadLocal threadLocal = f8687ADYaiT;
        CtxOCS.A2egSU a2egSU = (CtxOCS.A2egSU) threadLocal.get();
        if (a2egSU == null) {
            a2egSU = new CtxOCS.A2egSU();
            threadLocal.set(a2egSU);
        }
        CtxOCS.A4TApA a4TApA = (CtxOCS.A4TApA) this.f8689A4TApA.f363AcNBzu;
        int A2egSU2 = a4TApA.A2egSU(6);
        if (A2egSU2 != 0) {
            int i = A2egSU2 + a4TApA.f1917A2egSU;
            int i2 = (this.f8688A2egSU * 4) + a4TApA.f1918A4TApA.getInt(i) + i + 4;
            int i3 = a4TApA.f1918A4TApA.getInt(i2) + i2;
            ByteBuffer byteBuffer = a4TApA.f1918A4TApA;
            a2egSU.f1918A4TApA = byteBuffer;
            if (byteBuffer != null) {
                a2egSU.f1917A2egSU = i3;
                int i4 = i3 - byteBuffer.getInt(i3);
                a2egSU.f1919A5SV6n = i4;
                a2egSU.f1920ADYaiT = a2egSU.f1918A4TApA.getShort(i4);
                return a2egSU;
            }
            a2egSU.f1917A2egSU = 0;
            a2egSU.f1919A5SV6n = 0;
            a2egSU.f1920ADYaiT = 0;
        }
        return a2egSU;
    }

    public final String toString() {
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        CtxOCS.A2egSU A4TApA2 = A4TApA();
        int A2egSU2 = A4TApA2.A2egSU(4);
        sb.append(Integer.toHexString(A2egSU2 != 0 ? A4TApA2.f1918A4TApA.getInt(A2egSU2 + A4TApA2.f1917A2egSU) : 0));
        sb.append(", codepoints:");
        CtxOCS.A2egSU A4TApA3 = A4TApA();
        int A2egSU3 = A4TApA3.A2egSU(16);
        if (A2egSU3 != 0) {
            int i2 = A2egSU3 + A4TApA3.f1917A2egSU;
            i = A4TApA3.f1918A4TApA.getInt(A4TApA3.f1918A4TApA.getInt(i2) + i2);
        } else {
            i = 0;
        }
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(Integer.toHexString(A2egSU(i3)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
