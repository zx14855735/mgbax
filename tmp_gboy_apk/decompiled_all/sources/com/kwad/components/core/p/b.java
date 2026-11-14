package com.kwad.components.core.p;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class b {
    static volatile Set<c> abA = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private static volatile b abw = null;
    private static volatile int abx = 204800;
    static volatile boolean aby = true;
    static volatile boolean abz;

    static {
        FJyLn();
    }

    private static /* synthetic */ void FJyLn() {
        char[] charArray = "\u0083\u008f\u008dÎ\u0087\u0081\u008d\u0085Î\u0082\u008f\u0099Î\u0093\u0088\u0085\u008c\u008cÎª\u008e\u0089¢\u0092\u0089\u0084\u0087\u0085".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 224);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0083\u008c\u0089\u008e\u0089\u0094".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 224);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (abA.contains(cVar)) {
                abA.remove(cVar);
            }
        }
    }

    public static void f(boolean z, int i) {
        if (i > 0) {
            abx = i * 1024;
        }
        aby = z;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initModeImplForInvoker")
    public static void register() {
        try {
            com.kwad.sdk.service.c.a(SpeedLimitApi.class, a.class);
        } catch (Throwable unused) {
        }
    }

    public static b tT() {
        if (abw == null) {
            synchronized (b.class) {
                try {
                    if (abw == null) {
                        abw = new b();
                    }
                } finally {
                }
            }
        }
        return abw;
    }

    public static boolean tU() {
        return aby;
    }

    public static int tV() {
        return abx / 1024;
    }

    private static synchronized InputStream wrap(InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, abx / (abA.size() + 1));
            abA.add(cVar);
        }
        return cVar;
    }

    public static InputStream wrapInputStream(InputStream inputStream) {
        return wrap(inputStream);
    }

    public final synchronized int tW() {
        int i;
        i = 0;
        try {
            Iterator<c> it = abA.iterator();
            while (it.hasNext()) {
                i += (int) it.next().tX();
            }
        } catch (Exception unused) {
        }
        return i;
    }
}
