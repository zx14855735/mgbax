package RbGtwA;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class ADYaiT {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final A5SV6n f7894AcNBzu = new A5SV6n();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static final A2egSU f7895AlLFFp;

    static {
        RQQwc8.A4TApA.f7878A2egSU.getClass();
        Integer num = RUJyoh.A2egSU.f7879A2egSU;
        f7895AlLFFp = (num == null || num.intValue() >= 34) ? new RfAOdh.A2egSU() : new A4TApA();
        jnXY();
    }

    private static /* synthetic */ void jnXY() {
        char[] charArray = "?31r;=19r>3%r/4900r\u001625\u001e.58;9".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\\');
        }
        String str = new String(charArray);
        char[] charArray2 = "?0525(".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\\');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
