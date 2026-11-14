package com.bytedance.sdk.component.tf;

import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.kuaishou.weapon.p0.t;
import java.lang.reflect.Method;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p {
    private volatile boolean d;
    private com.bytedance.sdk.component.tf.xj.hf dk;
    private com.bytedance.sdk.component.tf.xj.kd e;
    private boolean et;
    private int ht;

    /* renamed from: io, reason: collision with root package name */
    private volatile boolean f10218io;
    private volatile ScheduledExecutorService jk;
    private volatile ThreadPoolExecutor v;
    private volatile boolean x;
    private volatile ThreadPoolExecutor yo;
    public static final int xj = c.xj;
    public static final p hf = new p();
    public volatile boolean w = true;
    private long y = PushUIConfig.dismissTime;
    private long c = 20000;
    private volatile boolean f = true;
    private boolean tf = true;
    private long p = 100;

    /* renamed from: pl, reason: collision with root package name */
    private long f10219pl = 50;
    private long g = 1000;
    private long am = 3000;
    private boolean qt = false;
    private volatile boolean zg = true;
    private boolean pz = true;
    private boolean ra = true;
    private volatile boolean ai = true;
    private volatile boolean q = true;
    private int u = Math.min(xj, 4);
    private int kd = 50;

    static {
        ytGovyY();
    }

    private p() {
    }

    private static /* synthetic */ void ytGovyY() {
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

    public boolean am() {
        return this.f10218io;
    }

    public com.bytedance.sdk.component.tf.xj.kd c() {
        if (this.e == null) {
            this.e = new com.bytedance.sdk.component.tf.xj.kd();
        }
        return this.e;
    }

    public ThreadPoolExecutor d() {
        if (this.yo == null) {
            synchronized (this) {
                try {
                    if (this.yo == null) {
                        this.yo = new com.bytedance.sdk.component.tf.w.u(this.u, this.kd, this.c, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new tf(10, t.f) { // from class: com.bytedance.sdk.component.tf.p.1
                            @Override // com.bytedance.sdk.component.tf.tf
                            public Thread xj(ThreadGroup threadGroup, Runnable runnable, String str) {
                                return new Thread(threadGroup, runnable, str);
                            }
                        });
                    }
                } finally {
                }
            }
        }
        return this.yo;
    }

    public long e() {
        return this.f10219pl;
    }

    public int f() {
        return this.u;
    }

    public ThreadPoolExecutor g() {
        return this.d ? tf() : d();
    }

    public boolean hf(int i) {
        return (this.ht & i) == i;
    }

    public boolean jk() {
        return this.qt;
    }

    public boolean kd() {
        return this.w;
    }

    public int p() {
        return this.kd;
    }

    public ScheduledExecutorService pl() {
        if (this.jk == null) {
            synchronized (this) {
                try {
                    if (this.jk == null) {
                        this.jk = new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.bytedance.sdk.component.tf.p.3
                            @Override // java.util.concurrent.ThreadFactory
                            public Thread newThread(Runnable runnable) {
                                return new Thread(runnable, p.this.et ? "csj-p-wp" : "csj-wp");
                            }
                        }, com.bytedance.sdk.component.tf.u.xj.xj);
                    }
                } finally {
                }
            }
        }
        return this.jk;
    }

    public boolean qt() {
        return this.x;
    }

    public ThreadPoolExecutor tf() {
        if (this.v == null) {
            synchronized (this) {
                if (this.v == null) {
                    this.v = new com.bytedance.sdk.component.tf.w.hf(this.u, this.kd, this.y, TimeUnit.MILLISECONDS, new tf(10, t.l) { // from class: com.bytedance.sdk.component.tf.p.2
                        @Override // com.bytedance.sdk.component.tf.tf
                        public Thread xj(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                    if (this.q) {
                        try {
                            this.v.allowCoreThreadTimeOut(true);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
        return this.v;
    }

    public long u() {
        return this.p;
    }

    public long v() {
        return this.am;
    }

    public com.bytedance.sdk.component.tf.xj.hf w() {
        return this.dk;
    }

    public boolean y() {
        return this.et;
    }

    public long yo() {
        return this.g;
    }

    public boolean zg() {
        return this.ai && c.kd();
    }

    public void f(boolean z) {
        if (this.f10218io) {
            return;
        }
        if (this.v != null) {
            this.v.allowCoreThreadTimeOut(z);
        }
        this.q = z;
    }

    public boolean hf() {
        return this.pz;
    }

    public void kd(boolean z) {
        this.d = z;
    }

    public void u(boolean z) {
        this.et = z;
    }

    public void w(boolean z) {
        this.w = z;
    }

    public void xj(int i) {
        this.ht = i;
    }

    public void y(boolean z) {
        this.f = z;
    }

    public void hf(boolean z) {
        this.pz = z;
    }

    public void u(int i) {
        this.kd = i;
        d().setMaximumPoolSize(i);
        tf().setMaximumPoolSize(i);
    }

    public void w(int i) {
        this.u = i;
        d().setCorePoolSize(i);
        tf().setCorePoolSize(i);
    }

    public boolean xj() {
        return this.tf;
    }

    public void c(boolean z) {
        if (z) {
            f(false);
            c.xj(false);
        }
        this.f10218io = z;
    }

    public void hf(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor == null) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.yo;
        this.yo = threadPoolExecutor;
        if (threadPoolExecutor2 == null || threadPoolExecutor2 == threadPoolExecutor) {
            return;
        }
        ((com.bytedance.sdk.component.tf.w.u) threadPoolExecutor2).w();
        kd.xj(threadPoolExecutor, threadPoolExecutor2);
    }

    public void xj(boolean z) {
        this.tf = z;
    }

    public void xj(com.bytedance.sdk.component.tf.xj.hf hfVar) {
        this.dk = hfVar;
    }

    public void u(long j) {
        this.am = j;
    }

    public void w(long j) {
        this.g = j;
    }

    public void xj(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor == null) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.v;
        this.v = threadPoolExecutor;
        if (threadPoolExecutor2 == null || threadPoolExecutor2 == threadPoolExecutor) {
            return;
        }
        kd.xj(threadPoolExecutor, threadPoolExecutor2);
    }

    public void d(boolean z) {
        this.qt = z;
    }

    public void hf(long j) {
        this.f10219pl = j;
    }

    public void xj(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService == null) {
            return;
        }
        final ScheduledExecutorService scheduledExecutorService2 = this.jk;
        this.jk = scheduledExecutorService;
        if (scheduledExecutorService2 == null || scheduledExecutorService2 == scheduledExecutorService) {
            return;
        }
        this.jk.schedule(new Runnable() { // from class: com.bytedance.sdk.component.tf.p.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    scheduledExecutorService2.shutdown();
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.pl.w("ThreadCenter", e);
                }
            }
        }, PushUIConfig.dismissTime, TimeUnit.MILLISECONDS);
    }

    public void xj(long j) {
        this.y = j;
        tf().setKeepAliveTime(j, TimeUnit.MILLISECONDS);
    }
}
