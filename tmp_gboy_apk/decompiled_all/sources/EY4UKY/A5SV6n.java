package EY4UKY;

import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final ThreadPoolExecutor f2501A2egSU;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f2501A2egSU = new ThreadPoolExecutor(availableProcessors + 1, (availableProcessors * 2) + 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(r.b.d), new A4TApA());
        tRhc();
    }

    private static /* synthetic */ void tRhc() {
        char[] charArray = "\u008e\u0082\u0080Ã\u008a\u008c\u0080\u0088Ã\u008f\u0082\u0094Ã\u009e\u0085\u0088\u0081\u0081Ã§\u0083\u0084¯\u009f\u0084\u0089\u008a\u0088".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 237);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008e\u0081\u0084\u0083\u0084\u0099".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 237);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
