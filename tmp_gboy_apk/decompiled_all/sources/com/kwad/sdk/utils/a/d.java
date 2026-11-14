package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class d {
    static c.d bhG;
    static volatile Executor bhH;
    static ExecutorService bhI = Executors.newSingleThreadExecutor();

    static {
        oKwla();
    }

    private d() {
    }

    public static void a(c.d dVar) {
        bhG = dVar;
    }

    public static Executor getExecutor() {
        if (bhH == null) {
            synchronized (d.class) {
                try {
                    if (bhH == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        bhH = threadPoolExecutor;
                    }
                } finally {
                }
            }
        }
        return bhH;
    }

    private static /* synthetic */ void oKwla() {
        char[] charArray = "\u008c\u0080\u0082Á\u0088\u008e\u0082\u008aÁ\u008d\u0080\u0096Á\u009c\u0087\u008a\u0083\u0083Á¥\u0081\u0086\u00ad\u009d\u0086\u008b\u0088\u008a".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 239);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008c\u0083\u0086\u0081\u0086\u009b".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 239);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void setExecutor(Executor executor) {
        if (executor != null) {
            bhH = executor;
        }
    }
}
