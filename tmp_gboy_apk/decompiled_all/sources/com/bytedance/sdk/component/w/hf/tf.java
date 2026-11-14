package com.bytedance.sdk.component.w.hf;

import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.w.hf.xj.hf.c;
import java.lang.ref.Reference;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class tf {
    private static final Executor u = new com.bytedance.sdk.component.tf.u.u(0, Integer.MAX_VALUE, 20, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.w.hf.xj.w.xj("OkHttp ConnectionPool", true));
    static final /* synthetic */ boolean w = true;
    private List<String> c;
    private final Runnable d;
    private long f;
    boolean hf;
    private int kd;
    private final Deque<com.bytedance.sdk.component.w.hf.xj.hf.w> tf;
    final com.bytedance.sdk.component.w.hf.xj.hf.u xj;
    private long y;

    static {
        ouAlXDw();
    }

    public tf() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    private static /* synthetic */ void ouAlXDw() {
        char[] charArray = "¶º¸û²´¸°û·º¬û¦½°¹¹û\u009f»¼\u0097§¼±²°".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 213);
        }
        String str = new String(charArray);
        char[] charArray2 = "¶¹¼»¼¡".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 213);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private boolean w(com.bytedance.sdk.component.w.hf.xj.hf.w wVar) {
        try {
            List<String> list = this.c;
            if (list != null && !list.isEmpty() && wVar.xj() != null && wVar.xj().xj() != null && wVar.xj().xj().xj() != null && wVar.xj().xj().xj().c() != null) {
                String c = wVar.xj().xj().xj().c();
                if (!TextUtils.isEmpty(c)) {
                    if (this.c.contains(c)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public boolean hf(com.bytedance.sdk.component.w.hf.xj.hf.w wVar) {
        if (!w && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (wVar.xj || this.kd == 0) {
            this.tf.remove(wVar);
            return true;
        }
        notifyAll();
        return false;
    }

    public void xj(Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.containsKey("max_idle_cnt")) {
                    int i = bundle.getInt("max_idle_cnt");
                    if (i <= 5) {
                        i = this.kd;
                    }
                    this.kd = i;
                }
                if (bundle.containsKey("max_idle_time")) {
                    long j = bundle.getLong("max_idle_time");
                    this.y = j > 5 ? TimeUnit.MINUTES.toNanos(j) : this.y;
                }
                if (bundle.containsKey("white_hosts") && bundle.containsKey("white_extra_idle_time")) {
                    this.c = bundle.getStringArrayList("white_hosts");
                    long j2 = bundle.getLong("white_extra_idle_time");
                    this.f = j2 > 0 ? TimeUnit.MINUTES.toNanos(j2) : 0L;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public tf(int i, long j, TimeUnit timeUnit) {
        this.d = new Runnable() { // from class: com.bytedance.sdk.component.w.hf.tf.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long xj = tf.this.xj(System.nanoTime());
                    if (xj == -1) {
                        return;
                    }
                    if (xj > 0) {
                        long j2 = xj / C.MICROS_PER_SECOND;
                        long j3 = xj - (C.MICROS_PER_SECOND * j2);
                        synchronized (tf.this) {
                            try {
                                tf.this.wait(j2, (int) j3);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.tf = new ArrayDeque();
        this.xj = new com.bytedance.sdk.component.w.hf.xj.hf.u();
        this.kd = i;
        this.y = timeUnit.toNanos(j);
        if (j <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: ".concat(String.valueOf(j)));
        }
    }

    public com.bytedance.sdk.component.w.hf.xj.hf.w xj(xj xjVar, com.bytedance.sdk.component.w.hf.xj.hf.c cVar, j jVar) {
        if (!w && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.bytedance.sdk.component.w.hf.xj.hf.w wVar : this.tf) {
            if (wVar.xj(xjVar, jVar)) {
                if (cVar != null) {
                    cVar.xj(wVar, true);
                }
                return wVar;
            }
        }
        return null;
    }

    public Socket xj(xj xjVar, com.bytedance.sdk.component.w.hf.xj.hf.c cVar) {
        if (!w && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        for (com.bytedance.sdk.component.w.hf.xj.hf.w wVar : this.tf) {
            if (wVar.xj(xjVar, null) && wVar.kd() && wVar != cVar.hf()) {
                return cVar.xj(wVar);
            }
        }
        return null;
    }

    public void xj(com.bytedance.sdk.component.w.hf.xj.hf.w wVar) {
        if (!w && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.hf) {
            this.hf = true;
            u.execute(this.d);
        }
        this.tf.add(wVar);
    }

    public long xj(long j) {
        try {
            synchronized (this) {
                try {
                    com.bytedance.sdk.component.w.hf.xj.hf.w wVar = null;
                    long j2 = Long.MIN_VALUE;
                    int i = 0;
                    int i2 = 0;
                    for (com.bytedance.sdk.component.w.hf.xj.hf.w wVar2 : this.tf) {
                        if (xj(wVar2, j) > 0) {
                            i2++;
                        } else {
                            i++;
                            long j3 = j - wVar2.kd;
                            if (this.f > 0 && w(wVar2)) {
                                j3 -= this.f;
                            }
                            if (j3 > j2) {
                                wVar = wVar2;
                                j2 = j3;
                            }
                        }
                    }
                    long j4 = this.y;
                    if (j2 < j4 && i <= this.kd) {
                        if (i > 0) {
                            return j4 - j2;
                        }
                        if (i2 > 0) {
                            return j4;
                        }
                        this.hf = false;
                        com.bytedance.sdk.component.utils.pl.xj("ConnectionPool", "cleanup: ");
                        return -1L;
                    }
                    this.tf.remove(wVar);
                    com.bytedance.sdk.component.w.hf.xj.w.xj(wVar.w());
                    return 0L;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (OutOfMemoryError unused) {
            return this.y;
        }
    }

    private int xj(com.bytedance.sdk.component.w.hf.xj.hf.w wVar, long j) {
        List<Reference<com.bytedance.sdk.component.w.hf.xj.hf.c>> list = wVar.u;
        int i = 0;
        while (i < list.size()) {
            Reference<com.bytedance.sdk.component.w.hf.xj.hf.c> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                com.bytedance.sdk.component.w.hf.xj.c.kd.hf().xj("A connection to " + wVar.xj().xj().xj() + " was leaked. Did you forget to close a response body?", ((c.xj) reference).xj);
                list.remove(i);
                wVar.xj = true;
                if (list.isEmpty()) {
                    wVar.kd = j - this.y;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
