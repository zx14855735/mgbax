package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.bytedance.embedapplog.d;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class j {
    private static final int xj = Runtime.getRuntime().availableProcessors();
    private static final d.xj<Executor> hf = new d.xj<Executor>() { // from class: com.bytedance.embedapplog.j.1
        @Override // com.bytedance.embedapplog.d.xj
        @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public Executor hf(Object... objArr) {
            return new com.bytedance.sdk.component.tf.u.u((int) (j.xj * 0.5d), Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new com.bytedance.sdk.component.tf.tf("edapplog/av$1"));
        }
    };
    private static final d.xj<ExecutorService> w = new d.xj<ExecutorService>() { // from class: com.bytedance.embedapplog.j.2
        @Override // com.bytedance.embedapplog.d.xj
        @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public ExecutorService hf(Object... objArr) {
            return new com.bytedance.sdk.component.tf.u.u((int) (j.xj * 0.5d), Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.bytedance.sdk.component.tf.tf("edapplog/av$2"));
        }
    };
    private static final d.xj<Handler> u = new d.xj<Handler>() { // from class: com.bytedance.embedapplog.j.3
        @Override // com.bytedance.embedapplog.d.xj
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public Handler hf(Object... objArr) {
            return new Handler(no.f());
        }
    };

    static {
        MCbu();
    }

    private static /* synthetic */ void MCbu() {
        char[] charArray = "\u0089\u0085\u0087Ä\u008d\u008b\u0087\u008fÄ\u0088\u0085\u0093Ä\u0099\u0082\u008f\u0086\u0086Ä \u0084\u0083¨\u0098\u0083\u008e\u008d\u008f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 234);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0089\u0086\u0083\u0084\u0083\u009e".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 234);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static ExecutorService u() {
        return w.w(new Object[0]);
    }

    private static Executor w() {
        return hf.w(new Object[0]);
    }

    public static Handler xj() {
        return u.w(new Object[0]);
    }

    public static void xj(Runnable runnable) {
        w().execute(runnable);
    }

    public static <T> Future<T> xj(Callable<T> callable) {
        return u().submit(callable);
    }
}
