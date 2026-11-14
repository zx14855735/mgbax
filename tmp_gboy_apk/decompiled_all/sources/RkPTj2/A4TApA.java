package RkPTj2;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract /* synthetic */ class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final int f7908A2egSU = Runtime.getRuntime().availableProcessors();

    static {
        ZpCbDf();
    }

    private static /* synthetic */ void ZpCbDf() {
        char[] charArray = "+'%f/)%-f*'1f; -$$f\u0002&!\n:!,/-".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'H');
        }
        String str = new String(charArray);
        char[] charArray2 = "+$!&!<".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'H');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
