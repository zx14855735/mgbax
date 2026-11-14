package KLMZzS;

import com.bytedance.sdk.component.tf.u.u;
import com.bytedance.sdk.component.tf.w;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static volatile ADYaiT f4251A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static volatile u f4252A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static volatile u f4253A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static volatile ScheduledExecutorService f4254ADYaiT;

    static {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        sGJwYAy();
    }

    public ADYaiT() {
        int i = A2egSU.f4243A2egSU;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        PriorityBlockingQueue priorityBlockingQueue = A2egSU.f4245A5SV6n;
        A4TApA a4TApA = new A4TApA(2, "tt-api-thread-");
        int i2 = A2egSU.f4243A2egSU;
        f4252A4TApA = new u(i2, i2, 1L, timeUnit, priorityBlockingQueue, a4TApA);
        PriorityBlockingQueue priorityBlockingQueue2 = A2egSU.f4246ADYaiT;
        A4TApA a4TApA2 = new A4TApA(2, "tt-default-thread-");
        int i3 = A2egSU.f4244A4TApA;
        f4253A5SV6n = new u(i3, i3, 1L, timeUnit, priorityBlockingQueue2, a4TApA2);
        f4254ADYaiT = w.w(new A4TApA(1, "tt-delay-thread-"));
    }

    private static /* synthetic */ void sGJwYAy() {
        char[] charArray = "éåç¤íëçï¤èåó¤ùâïææ¤ÀäãÈøãîíï".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 138);
        }
        String str = new String(charArray);
        char[] charArray2 = "éæãäãþ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 138);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
