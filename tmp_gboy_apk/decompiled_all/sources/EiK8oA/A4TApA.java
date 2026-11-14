package EiK8oA;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A4TApA {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final A4TApA f2543A4TApA = new A4TApA();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final OkHttpClient f2544A2egSU = new OkHttpClient().newBuilder().connectTimeout(3000, TimeUnit.MILLISECONDS).build();

    static {
        avWO();
    }

    private static /* synthetic */ void avWO() {
        char[] charArray = "OCA\u0002KMAI\u0002NCU\u0002_DI@@\u0002fBEn^EHKI".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ',');
        }
        String str = new String(charArray);
        char[] charArray2 = "O@EBEX".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ',');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
