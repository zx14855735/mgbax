package Hjvs0g;

import java.lang.reflect.Method;
import java.util.ArrayDeque;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B7CMnp {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final ArrayDeque f3739A4TApA;

    /* renamed from: A2egSU, reason: collision with root package name */
    public Object f3740A2egSU;

    static {
        char[] cArr = ItGa5w.AlLFFp.f4092A2egSU;
        f3739A4TApA = new ArrayDeque(0);
        phnjJYv();
    }

    public static B7CMnp A2egSU(Object obj) {
        B7CMnp b7CMnp;
        ArrayDeque arrayDeque = f3739A4TApA;
        synchronized (arrayDeque) {
            b7CMnp = (B7CMnp) arrayDeque.poll();
        }
        if (b7CMnp == null) {
            b7CMnp = new B7CMnp();
        }
        b7CMnp.f3740A2egSU = obj;
        return b7CMnp;
    }

    private static /* synthetic */ void phnjJYv() {
        char[] charArray = "($&e,*&.e)$2e8#.''e\u0001%\"\t9\"/,.".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'K');
        }
        String str = new String(charArray);
        char[] charArray2 = "('\"%\"?".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'K');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof B7CMnp)) {
            return false;
        }
        B7CMnp b7CMnp = (B7CMnp) obj;
        b7CMnp.getClass();
        return this.f3740A2egSU.equals(b7CMnp.f3740A2egSU);
    }

    public final int hashCode() {
        return this.f3740A2egSU.hashCode();
    }
}
