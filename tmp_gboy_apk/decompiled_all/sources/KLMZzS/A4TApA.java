package KLMZzS;

import B4ZgIw.AYUAbz;
import android.text.TextUtils;
import com.bytedance.sdk.component.tf.u.w;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA implements ThreadFactory {
    public static final AtomicInteger AMqCpz = new AtomicInteger(1);

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ThreadGroup f4247A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final AtomicInteger f4248A4TApA = new AtomicInteger(1);

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final String f4249A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final int f4250ADYaiT;

    static {
        RxYMa();
    }

    public A4TApA(int i, String str) {
        this.f4250ADYaiT = i;
        SecurityManager securityManager = System.getSecurityManager();
        this.f4247A2egSU = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        boolean isEmpty = TextUtils.isEmpty(str);
        AtomicInteger atomicInteger = AMqCpz;
        if (isEmpty) {
            this.f4249A5SV6n = "ttdefault-" + atomicInteger.getAndIncrement() + "-thread-";
            return;
        }
        StringBuilder A4TApA2 = AYUAbz.A4TApA(str);
        A4TApA2.append(atomicInteger.getAndIncrement());
        A4TApA2.append("-thread-");
        this.f4249A5SV6n = A4TApA2.toString();
    }

    private static /* synthetic */ void RxYMa() {
        char[] charArray = "yuw4}{w\u007f4xuc4ir\u007fvv4PtsXhs~}\u007f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 26);
        }
        String str = new String(charArray);
        char[] charArray2 = "yvstsn".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 26);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        w wVar = new w(this.f4247A2egSU, runnable, this.f4249A5SV6n + this.f4248A4TApA.getAndIncrement(), 0L);
        if (wVar.isDaemon()) {
            wVar.setDaemon(false);
        }
        int i = this.f4250ADYaiT;
        if (i != 0) {
            char c = 1;
            if (i != 1) {
                c = 2;
                if (i != 2) {
                    c = 3;
                    if (i != 3) {
                        throw null;
                    }
                }
            }
            if (c == 1) {
                wVar.setPriority(1);
                return wVar;
            }
        }
        if (wVar.getPriority() != 5) {
            wVar.setPriority(3);
            return wVar;
        }
        wVar.setPriority(5);
        return wVar;
    }
}
