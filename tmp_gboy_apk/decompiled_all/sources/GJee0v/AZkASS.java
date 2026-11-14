package GJee0v;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AZkASS {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final AZkASS f3040ADYaiT = new AZkASS();

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ExecutorService f3041A2egSU = Executors.newFixedThreadPool(16, new AlLFFp("nm-pool-thread"));

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ScheduledExecutorService f3042A4TApA = Executors.newScheduledThreadPool(2, new AlLFFp("nm-scheduler-thread"));

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Handler f3043A5SV6n = new Handler(Looper.getMainLooper());

    static {
        YTnZTQ();
    }

    private static /* synthetic */ void YTnZTQ() {
        char[] charArray = "úöô·þøôü·ûöà·êñüõõ·Ó÷ðÛëðýþü".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 153);
        }
        String str = new String(charArray);
        char[] charArray2 = "úõð÷ðí".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 153);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
