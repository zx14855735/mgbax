package B7CMnp;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final String[] f1091A2egSU;

    static {
        new A2egSU();
        f1091A2egSU = new String[]{"standard", "accelerate", "decelerate", "linear"};
        HgjWAv();
    }

    private static /* synthetic */ void HgjWAv() {
        char[] charArray = "Q]_\u001cUS_W\u001cP]K\u001cAZW^^\u001cx\\[p@[VUW".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '2');
        }
        String str = new String(charArray);
        char[] charArray2 = "Q^[\\[F".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '2');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final String toString() {
        return "identity";
    }
}
