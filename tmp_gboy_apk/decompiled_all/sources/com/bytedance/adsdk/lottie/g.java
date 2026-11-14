package com.bytedance.adsdk.lottie;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class g<T> {
    public static Executor xj = com.bytedance.sdk.component.tf.w.hf(new com.bytedance.sdk.component.tf.tf("ie/LottieTask"));
    private final Set<tf<T>> hf;
    private volatile pl<T> kd;
    private final Handler u;
    private final Set<tf<Throwable>> w;

    public class xj extends FutureTask<pl<T>> {
        public xj(Callable<pl<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                g.this.setResult(get());
            } catch (InterruptedException | ExecutionException e) {
                g.this.setResult(new pl(e));
            }
        }
    }

    static {
        dXGioG();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g(Callable<pl<T>> callable) {
        this(callable, false);
    }

    private static /* synthetic */ void dXGioG() {
        char[] charArray = "\u0016\u001a\u0018[\u0012\u0014\u0018\u0010[\u0017\u001a\f[\u0006\u001d\u0010\u0019\u0019[?\u001b\u001c7\u0007\u001c\u0011\u0012\u0010".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'u');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0016\u0019\u001c\u001b\u001c\u0001".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'u');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(pl<T> plVar) {
        if (this.kd != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.kd = plVar;
        xj();
    }

    public synchronized g<T> hf(tf<T> tfVar) {
        this.hf.remove(tfVar);
        return this;
    }

    public synchronized g<T> u(tf<Throwable> tfVar) {
        this.w.remove(tfVar);
        return this;
    }

    public synchronized g<T> w(tf<Throwable> tfVar) {
        try {
            pl<T> plVar = this.kd;
            if (plVar != null && plVar.hf() != null) {
                tfVar.xj(plVar.hf());
            }
            this.w.add(tfVar);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g(Callable<pl<T>> callable, boolean z) {
        this.hf = new LinkedHashSet(1);
        this.w = new LinkedHashSet(1);
        this.u = new Handler(Looper.getMainLooper());
        this.kd = null;
        if (!z) {
            xj.execute(new xj(callable));
            return;
        }
        try {
            setResult(callable.call());
        } catch (Throwable th) {
            setResult(new pl<>(th));
        }
    }

    public synchronized g<T> xj(tf<T> tfVar) {
        try {
            pl<T> plVar = this.kd;
            if (plVar != null && plVar.xj() != null) {
                tfVar.xj(plVar.xj());
            }
            this.hf.add(tfVar);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    private void xj() {
        this.u.post(new Runnable() { // from class: com.bytedance.adsdk.lottie.g.1
            @Override // java.lang.Runnable
            public void run() {
                pl plVar = g.this.kd;
                if (plVar == null) {
                    return;
                }
                if (plVar.xj() != null) {
                    g.this.xj((g) plVar.xj());
                } else {
                    g.this.xj(plVar.hf());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void xj(T t) {
        Iterator it = new ArrayList(this.hf).iterator();
        while (it.hasNext()) {
            ((tf) it.next()).xj(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void xj(Throwable th) {
        ArrayList arrayList = new ArrayList(this.w);
        if (arrayList.isEmpty()) {
            com.bytedance.adsdk.lottie.kd.kd.xj("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((tf) it.next()).xj(th);
        }
    }
}
