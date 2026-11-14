package GJee0v;

import java.lang.reflect.Method;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.codec.language.Soundex;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AlLFFp implements ThreadFactory {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final AcNBzu f3048ADYaiT = new AcNBzu();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final String f3050A4TApA;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ThreadGroup f3049A2egSU = Thread.currentThread().getThreadGroup();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final AtomicInteger f3051A5SV6n = new AtomicInteger(0);

    static {
        joyd();
    }

    public AlLFFp(String str) {
        this.f3050A4TApA = str;
    }

    private static /* synthetic */ void joyd() {
        char[] charArray = "\u0096\u009a\u0098Û\u0092\u0094\u0098\u0090Û\u0097\u009a\u008cÛ\u0086\u009d\u0090\u0099\u0099Û¿\u009b\u009c·\u0087\u009c\u0091\u0092\u0090".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 245);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0096\u0099\u009c\u009b\u009c\u0081".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 245);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f3049A2egSU, runnable, this.f3050A4TApA + Soundex.SILENT_MARKER + this.f3051A5SV6n.getAndIncrement());
        thread.setUncaughtExceptionHandler(f3048ADYaiT);
        return thread;
    }
}
