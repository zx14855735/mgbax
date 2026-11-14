package B3GDIM;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final ARc23Z f1029A5SV6n = new ARc23Z();

    /* renamed from: A2egSU, reason: collision with root package name */
    public volatile Thread f1030A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public volatile ARc23Z f1031A4TApA;

    static {
        lSeYry();
    }

    public ARc23Z() {
        ASJ6gh.f1034B2KMhB.CrfGsy(this, Thread.currentThread());
    }

    private static /* synthetic */ void lSeYry() {
        char[] charArray = "¥©«è¡§«£è¤©¿èµ®£ªªè\u008c¨¯\u0084´¯¢¡£".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 198);
        }
        String str = new String(charArray);
        char[] charArray2 = "¥ª¯¨¯²".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 198);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
