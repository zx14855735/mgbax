package androidx.lifecycle;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CkXcdM {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final CkXcdM f9033A2egSU = new CkXcdM();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final CkXcdM f9034A4TApA = new CkXcdM();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Hcrv() {
        char[] charArray = "âîì¯æàìä¯ãîø¯òéäíí¯ËïèÃóèåæä".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 129);
        }
        String str = new String(charArray);
        char[] charArray2 = "âíèïèõ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 129);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
