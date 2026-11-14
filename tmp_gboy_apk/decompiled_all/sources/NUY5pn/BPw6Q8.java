package NUY5pn;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BPw6Q8 {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final Object f6015AcNBzu = new Object();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public static BniPrB f6016AlLFFp;

    static {
        shPY();
    }

    private static /* synthetic */ void shPY() {
        char[] charArray = "ieg$mkgo$hes$yboff$@dcHxcnmo".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\n');
        }
        String str = new String(charArray);
        char[] charArray2 = "ifcdc~".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\n');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
