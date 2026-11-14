package com.bytedance.sdk.component.w.hf.xj.kd;

import android.os.SystemClock;
import com.bytedance.sdk.component.w.hf.xj.kd.f;
import com.sigmob.sdk.downloader.f;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class c implements Closeable {
    static final /* synthetic */ boolean v = true;
    static final ExecutorService xj = new com.bytedance.sdk.component.tf.u.u(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.bytedance.sdk.component.w.hf.xj.w.xj("OkHttp Http2Connection", true));
    boolean am;
    int c;
    final g d;
    final w e;
    boolean f;
    final am g;
    final boolean hf;
    private int ht;
    private final ExecutorService jk;
    final String kd;
    long p;
    private Map<Integer, pl> pz;
    final Socket qt;
    final hf w;
    int y;
    final Set<Integer> yo;
    final tf zg;
    final Map<Integer, d> u = new LinkedHashMap();
    long tf = 0;

    /* renamed from: pl, reason: collision with root package name */
    am f10237pl = new am();

    public static abstract class hf {
        public static final hf y = new hf() { // from class: com.bytedance.sdk.component.w.hf.xj.kd.c.hf.1
            @Override // com.bytedance.sdk.component.w.hf.xj.kd.c.hf
            public void xj(d dVar) {
                dVar.xj(com.bytedance.sdk.component.w.hf.xj.kd.hf.REFUSED_STREAM);
            }
        };

        static {
            GxbdZcp();
        }

        private static /* synthetic */ void GxbdZcp() {
            char[] charArray = "\u0099\u0095\u0097Ô\u009d\u009b\u0097\u009fÔ\u0098\u0095\u0083Ô\u0089\u0092\u009f\u0096\u0096Ô°\u0094\u0093¸\u0088\u0093\u009e\u009d\u009f".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 250);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0099\u0096\u0093\u0094\u0093\u008e".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 250);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public void xj(c cVar) {
        }

        public abstract void xj(d dVar);
    }

    static {
        JhVL();
    }

    public c(xj xjVar) {
        am amVar = new am();
        this.g = amVar;
        this.am = false;
        this.yo = new LinkedHashSet();
        this.d = xjVar.y;
        boolean z = xjVar.c;
        this.hf = z;
        this.w = xjVar.kd;
        int i = z ? 1 : 2;
        this.c = i;
        if (z) {
            this.c = i + 2;
        }
        this.ht = z ? 1 : 2;
        if (z) {
            this.f10237pl.xj(7, 16777216);
        }
        String str = xjVar.hf;
        this.kd = str;
        this.jk = new com.bytedance.sdk.component.tf.u.u(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.bytedance.sdk.component.w.hf.xj.w.xj(com.bytedance.sdk.component.w.hf.xj.w.xj("OkHttp %s Push Observer", str), true));
        amVar.xj(7, 65535);
        amVar.xj(5, f.a.d);
        this.p = amVar.u();
        this.qt = xjVar.xj;
        this.zg = new tf(xjVar.u, z);
        this.e = new w(new f(xjVar.w, z));
    }

    private static /* synthetic */ void JhVL() {
        char[] charArray = "¨¤¦å¬ª¦®å©¤²å¸£®§§å\u0081¥¢\u0089¹¢¯¬®".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 203);
        }
        String str = new String(charArray);
        char[] charArray2 = "¨§¢¥¢¿".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 203);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        xj(com.bytedance.sdk.component.w.hf.xj.kd.hf.NO_ERROR, com.bytedance.sdk.component.w.hf.xj.kd.hf.CANCEL);
    }

    public synchronized d hf(int i) {
        d remove;
        remove = this.u.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public boolean u(int i) {
        return i != 0 && (i & 1) == 0;
    }

    public synchronized pl w(int i) {
        Map<Integer, pl> map = this.pz;
        if (map == null) {
            return null;
        }
        return map.remove(Integer.valueOf(i));
    }

    public synchronized d xj(int i) {
        return this.u.get(Integer.valueOf(i));
    }

    public synchronized boolean u() {
        return this.f;
    }

    public void w() {
        xj(true);
    }

    public synchronized int xj() {
        return this.g.w(Integer.MAX_VALUE);
    }

    public void w(final int i, final com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar) {
        this.jk.execute(new com.bytedance.sdk.component.w.hf.xj.hf("OkHttp %s Push Reset[%s]", new Object[]{this.kd, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.w.hf.xj.kd.c.7
            @Override // com.bytedance.sdk.component.w.hf.xj.hf
            public void w() {
                synchronized (c.this) {
                    c.this.yo.remove(Integer.valueOf(i));
                }
            }
        });
    }

    public d xj(List<com.bytedance.sdk.component.w.hf.xj.kd.w> list, boolean z) {
        return hf(0, list, z);
    }

    public static class xj {
        boolean c;
        String hf;
        com.bytedance.sdk.component.w.xj.u u;
        com.bytedance.sdk.component.w.xj.kd w;
        Socket xj;
        hf kd = hf.y;
        g y = g.xj;

        public xj(boolean z) {
            this.c = z;
        }

        public xj xj(Socket socket, String str, com.bytedance.sdk.component.w.xj.kd kdVar, com.bytedance.sdk.component.w.xj.u uVar) {
            this.xj = socket;
            this.hf = str;
            this.w = kdVar;
            this.u = uVar;
            return this;
        }

        public xj xj(hf hfVar) {
            this.kd = hfVar;
            return this;
        }

        public c xj() {
            return new c(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0035 A[Catch: all -> 0x002b, TryCatch #3 {all -> 0x002b, blocks: (B:12:0x0015, B:14:0x001a, B:16:0x0022, B:20:0x002f, B:22:0x0035, B:23:0x003e, B:44:0x006e, B:39:0x0068, B:40:0x006d), top: B:4:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041 A[Catch: all -> 0x0047, TRY_ENTER, TryCatch #2 {all -> 0x0047, blocks: (B:25:0x0041, B:26:0x0053, B:31:0x004a, B:33:0x004e, B:34:0x005c, B:35:0x0063, B:49:0x0073, B:45:0x006f), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004a A[Catch: all -> 0x0047, TryCatch #2 {all -> 0x0047, blocks: (B:25:0x0041, B:26:0x0053, B:31:0x004a, B:33:0x004e, B:34:0x005c, B:35:0x0063, B:49:0x0073, B:45:0x006f), top: B:3:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.bytedance.sdk.component.w.hf.xj.kd.d hf(int r10, java.util.List<com.bytedance.sdk.component.w.hf.xj.kd.w> r11, boolean r12) {
        /*
            r9 = this;
            r3 = r12 ^ 1
            com.bytedance.sdk.component.w.hf.xj.kd.tf r6 = r9.zg
            monitor-enter(r6)
            monitor-enter(r9)     // Catch: java.lang.Throwable -> L70
            boolean r0 = r9.f     // Catch: java.lang.Throwable -> L64
            if (r0 != 0) goto L67
            int r1 = r9.c     // Catch: java.lang.Throwable -> L64
            int r0 = r1 + 2
            r9.c = r0     // Catch: java.lang.Throwable -> L64
            com.bytedance.sdk.component.w.hf.xj.kd.d r0 = new com.bytedance.sdk.component.w.hf.xj.kd.d     // Catch: java.lang.Throwable -> L64
            r4 = 0
            r2 = r9
            r5 = r11
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L2b
            if (r12 == 0) goto L2e
            long r11 = r2.p     // Catch: java.lang.Throwable -> L2b
            r7 = 0
            int r4 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r4 == 0) goto L2e
            long r11 = r0.hf     // Catch: java.lang.Throwable -> L2b
            int r4 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r4 != 0) goto L29
            goto L2e
        L29:
            r11 = 0
            goto L2f
        L2b:
            r0 = move-exception
        L2c:
            r10 = r0
            goto L6e
        L2e:
            r11 = 1
        L2f:
            boolean r12 = r0.hf()     // Catch: java.lang.Throwable -> L2b
            if (r12 == 0) goto L3e
            java.util.Map<java.lang.Integer, com.bytedance.sdk.component.w.hf.xj.kd.d> r12 = r2.u     // Catch: java.lang.Throwable -> L2b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L2b
            r12.put(r4, r0)     // Catch: java.lang.Throwable -> L2b
        L3e:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L2b
            if (r10 != 0) goto L4a
            com.bytedance.sdk.component.w.hf.xj.kd.tf r12 = r2.zg     // Catch: java.lang.Throwable -> L47
            r12.xj(r3, r1, r10, r5)     // Catch: java.lang.Throwable -> L47
            goto L53
        L47:
            r0 = move-exception
        L48:
            r10 = r0
            goto L73
        L4a:
            boolean r12 = r2.hf     // Catch: java.lang.Throwable -> L47
            if (r12 != 0) goto L5c
            com.bytedance.sdk.component.w.hf.xj.kd.tf r12 = r2.zg     // Catch: java.lang.Throwable -> L47
            r12.xj(r10, r1, r5)     // Catch: java.lang.Throwable -> L47
        L53:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L47
            if (r11 == 0) goto L5b
            com.bytedance.sdk.component.w.hf.xj.kd.tf r10 = r2.zg
            r10.hf()
        L5b:
            return r0
        L5c:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L47
            java.lang.String r11 = "client streams shouldn't have associated stream IDs"
            r10.<init>(r11)     // Catch: java.lang.Throwable -> L47
            throw r10     // Catch: java.lang.Throwable -> L47
        L64:
            r0 = move-exception
            r2 = r9
            goto L2c
        L67:
            r2 = r9
            com.bytedance.sdk.component.w.hf.xj.kd.xj r10 = new com.bytedance.sdk.component.w.hf.xj.kd.xj     // Catch: java.lang.Throwable -> L2b
            r10.<init>()     // Catch: java.lang.Throwable -> L2b
            throw r10     // Catch: java.lang.Throwable -> L2b
        L6e:
            monitor-exit(r9)     // Catch: java.lang.Throwable -> L2b
            throw r10     // Catch: java.lang.Throwable -> L47
        L70:
            r0 = move-exception
            r2 = r9
            goto L48
        L73:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L47
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.w.hf.xj.kd.c.hf(int, java.util.List, boolean):com.bytedance.sdk.component.w.hf.xj.kd.d");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.zg.w());
        r6 = r3;
        r8.p -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(int r9, boolean r10, com.bytedance.sdk.component.w.xj.w r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            com.bytedance.sdk.component.w.hf.xj.kd.tf r12 = r8.zg
            r12.xj(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L60
            monitor-enter(r8)
        L12:
            long r3 = r8.p     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L32
            java.util.Map<java.lang.Integer, com.bytedance.sdk.component.w.hf.xj.kd.d> r3 = r8.u     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            if (r3 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            goto L12
        L28:
            r9 = move-exception
            goto L5e
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L58
        L32:
            long r3 = java.lang.Math.min(r12, r3)     // Catch: java.lang.Throwable -> L28
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L28
            com.bytedance.sdk.component.w.hf.xj.kd.tf r3 = r8.zg     // Catch: java.lang.Throwable -> L28
            int r3 = r3.w()     // Catch: java.lang.Throwable -> L28
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.p     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.p = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            com.bytedance.sdk.component.w.hf.xj.kd.tf r4 = r8.zg
            if (r10 == 0) goto L53
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L53
            r5 = 1
            goto L54
        L53:
            r5 = 0
        L54:
            r4.xj(r5, r9, r11, r3)
            goto Ld
        L58:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L5e:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.w.hf.xj.kd.c.xj(int, boolean, com.bytedance.sdk.component.w.xj.w, long):void");
    }

    public class w extends com.bytedance.sdk.component.w.hf.xj.hf implements f.hf {
        final f xj;

        public w(f fVar) {
            super("OkHttp %s", c.this.kd);
            this.xj = fVar;
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.hf
        public void w() {
            com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar;
            c cVar;
            com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar2 = com.bytedance.sdk.component.w.hf.xj.kd.hf.INTERNAL_ERROR;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    this.xj.xj(this);
                    while (this.xj.xj(false, (f.hf) this)) {
                    }
                } catch (Exception unused) {
                }
                try {
                    c.this.xj(com.bytedance.sdk.component.w.hf.xj.kd.hf.NO_ERROR, com.bytedance.sdk.component.w.hf.xj.kd.hf.CANCEL);
                } catch (IOException unused2) {
                    hfVar = com.bytedance.sdk.component.w.hf.xj.kd.hf.PROTOCOL_ERROR;
                    cVar = c.this;
                    cVar.xj(hfVar, hfVar);
                    com.bytedance.sdk.component.w.hf.xj.w.xj(this.xj);
                } catch (NullPointerException unused3) {
                    hfVar = com.bytedance.sdk.component.w.hf.xj.kd.hf.PROTOCOL_ERROR;
                    cVar = c.this;
                    cVar.xj(hfVar, hfVar);
                    com.bytedance.sdk.component.w.hf.xj.w.xj(this.xj);
                }
            } catch (IOException unused4) {
            } catch (NullPointerException unused5) {
            } catch (Throwable th2) {
                th = th2;
                try {
                    c.this.xj(hfVar2, hfVar2);
                } catch (Exception unused6) {
                }
                com.bytedance.sdk.component.w.hf.xj.w.xj(this.xj);
                throw th;
            }
            com.bytedance.sdk.component.w.hf.xj.w.xj(this.xj);
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.kd.f.hf
        public void xj(boolean z, int i, com.bytedance.sdk.component.w.xj.kd kdVar, int i2) {
            if (c.this.u(i)) {
                c.this.xj(i, kdVar, i2, z);
                return;
            }
            d xj = c.this.xj(i);
            if (xj == null) {
                c.this.xj(i, com.bytedance.sdk.component.w.hf.xj.kd.hf.PROTOCOL_ERROR);
                kdVar.f(i2);
            } else {
                xj.xj(kdVar, i2);
                if (z) {
                    xj.d();
                }
            }
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.kd.f.hf
        public void xj(boolean z, int i, int i2, List<com.bytedance.sdk.component.w.hf.xj.kd.w> list) {
            if (c.this.u(i)) {
                c.this.xj(i, list, z);
                return;
            }
            synchronized (c.this) {
                try {
                    d xj = c.this.xj(i);
                    if (xj == null) {
                        c cVar = c.this;
                        if (cVar.f) {
                            return;
                        }
                        if (i <= cVar.y) {
                            return;
                        }
                        if (i % 2 == cVar.c % 2) {
                            return;
                        }
                        final d dVar = new d(i, cVar, false, z, list);
                        c cVar2 = c.this;
                        cVar2.y = i;
                        cVar2.u.put(Integer.valueOf(i), dVar);
                        try {
                            c.xj.execute(new com.bytedance.sdk.component.w.hf.xj.hf("OkHttp %s stream %d", new Object[]{c.this.kd, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.w.hf.xj.kd.c.w.1
                                @Override // com.bytedance.sdk.component.w.hf.xj.hf
                                public void w() {
                                    try {
                                        c.this.w.xj(dVar);
                                    } catch (IOException e) {
                                        com.bytedance.sdk.component.w.hf.xj.c.kd.hf().xj(4, "Http2Connection.Listener failure for " + c.this.kd, e);
                                        try {
                                            dVar.xj(com.bytedance.sdk.component.w.hf.xj.kd.hf.PROTOCOL_ERROR);
                                        } catch (IOException unused) {
                                        }
                                    }
                                }
                            });
                        } catch (Throwable unused) {
                        }
                        return;
                    }
                    xj.xj(list);
                    if (z) {
                        xj.d();
                    }
                } finally {
                }
            }
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.kd.f.hf
        public void xj(int i, com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar) {
            if (c.this.u(i)) {
                c.this.w(i, hfVar);
                return;
            }
            d hf = c.this.hf(i);
            if (hf != null) {
                hf.w(hfVar);
            }
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.kd.f.hf
        public void xj(boolean z, am amVar) {
            d[] dVarArr;
            long j;
            synchronized (c.this) {
                try {
                    int u = c.this.g.u();
                    if (z) {
                        c.this.g.xj();
                    }
                    c.this.g.xj(amVar);
                    xj(amVar);
                    int u2 = c.this.g.u();
                    dVarArr = null;
                    if (u2 == -1 || u2 == u) {
                        j = 0;
                    } else {
                        j = u2 - u;
                        c cVar = c.this;
                        if (!cVar.am) {
                            cVar.xj(j);
                            c.this.am = true;
                        }
                        if (!c.this.u.isEmpty()) {
                            dVarArr = (d[]) c.this.u.values().toArray(new d[c.this.u.size()]);
                        }
                    }
                    try {
                        c.xj.execute(new com.bytedance.sdk.component.w.hf.xj.hf("OkHttp %s settings", c.this.kd) { // from class: com.bytedance.sdk.component.w.hf.xj.kd.c.w.2
                            @Override // com.bytedance.sdk.component.w.hf.xj.hf
                            public void w() {
                                c cVar2 = c.this;
                                cVar2.w.xj(cVar2);
                            }
                        });
                    } catch (Throwable unused) {
                    }
                } finally {
                }
            }
            if (dVarArr == null || j == 0) {
                return;
            }
            for (d dVar : dVarArr) {
                synchronized (dVar) {
                    dVar.xj(j);
                }
            }
        }

        private void xj(final am amVar) {
            try {
                c.xj.execute(new com.bytedance.sdk.component.w.hf.xj.hf("OkHttp %s ACK Settings", new Object[]{c.this.kd}) { // from class: com.bytedance.sdk.component.w.hf.xj.kd.c.w.3
                    @Override // com.bytedance.sdk.component.w.hf.xj.hf
                    public void w() {
                        try {
                            c.this.zg.xj(amVar);
                        } catch (IOException unused) {
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.kd.f.hf
        public void xj(boolean z, int i, int i2) {
            if (z) {
                pl w = c.this.w(i);
                if (w != null) {
                    w.hf();
                    return;
                }
                return;
            }
            c.this.xj(true, i, i2, (pl) null);
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.kd.f.hf
        public void xj(int i, com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar, com.bytedance.sdk.component.w.xj.y yVar) {
            d[] dVarArr;
            synchronized (c.this) {
                dVarArr = (d[]) c.this.u.values().toArray(new d[c.this.u.size()]);
                c.this.f = true;
            }
            for (d dVar : dVarArr) {
                if (dVar.xj() > i && dVar.w()) {
                    dVar.w(com.bytedance.sdk.component.w.hf.xj.kd.hf.REFUSED_STREAM);
                    c.this.hf(dVar.xj());
                }
            }
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.kd.f.hf
        public void xj(int i, long j) {
            if (i == 0) {
                synchronized (c.this) {
                    c cVar = c.this;
                    cVar.p += j;
                    cVar.notifyAll();
                }
                return;
            }
            d xj = c.this.xj(i);
            if (xj != null) {
                synchronized (xj) {
                    xj.xj(j);
                }
            }
        }

        @Override // com.bytedance.sdk.component.w.hf.xj.kd.f.hf
        public void xj(int i, int i2, List<com.bytedance.sdk.component.w.hf.xj.kd.w> list) {
            c.this.xj(i2, list);
        }
    }

    public void xj(long j) {
        this.p += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void xj(final int i, final com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar) {
        try {
            xj.execute(new com.bytedance.sdk.component.w.hf.xj.hf("OkHttp %s stream %d", new Object[]{this.kd, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.w.hf.xj.kd.c.1
                @Override // com.bytedance.sdk.component.w.hf.xj.hf
                public void w() {
                    try {
                        c.this.hf(i, hfVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void xj(final int i, final long j) {
        try {
            xj.execute(new com.bytedance.sdk.component.w.hf.xj.hf("OkHttp Window Update %s stream %d", new Object[]{this.kd, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.w.hf.xj.kd.c.2
                @Override // com.bytedance.sdk.component.w.hf.xj.hf
                public void w() {
                    try {
                        c.this.zg.xj(i, j);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void xj(final boolean z, final int i, final int i2, final pl plVar) {
        try {
            xj.execute(new com.bytedance.sdk.component.w.hf.xj.hf("OkHttp %s ping %08x%08x", new Object[]{this.kd, Integer.valueOf(i), Integer.valueOf(i2)}) { // from class: com.bytedance.sdk.component.w.hf.xj.kd.c.3
                @Override // com.bytedance.sdk.component.w.hf.xj.hf
                public void w() {
                    try {
                        c.this.hf(z, i, i2, plVar);
                    } catch (IOException unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public void hf(int i, com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar) {
        this.zg.xj(i, hfVar);
    }

    public void hf(boolean z, int i, int i2, pl plVar) {
        synchronized (this.zg) {
            if (plVar != null) {
                try {
                    plVar.xj();
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.zg.xj(z, i, i2);
        }
    }

    public void xj(com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar) {
        synchronized (this.zg) {
            synchronized (this) {
                if (this.f) {
                    return;
                }
                this.f = true;
                this.zg.xj(this.y, hfVar, com.bytedance.sdk.component.w.hf.xj.w.xj);
            }
        }
    }

    public void hf() {
        this.zg.hf();
    }

    public void xj(com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar, com.bytedance.sdk.component.w.hf.xj.kd.hf hfVar2) {
        d[] dVarArr;
        if (!v && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        pl[] plVarArr = null;
        try {
            xj(hfVar);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            try {
                if (this.u.isEmpty()) {
                    dVarArr = null;
                } else {
                    dVarArr = (d[]) this.u.values().toArray(new d[this.u.size()]);
                    this.u.clear();
                }
                Map<Integer, pl> map = this.pz;
                if (map != null) {
                    pl[] plVarArr2 = (pl[]) map.values().toArray(new pl[this.pz.size()]);
                    this.pz = null;
                    plVarArr = plVarArr2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (dVarArr != null) {
            for (d dVar : dVarArr) {
                try {
                    dVar.xj(hfVar2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        if (plVarArr != null) {
            for (pl plVar : plVarArr) {
                plVar.w();
            }
        }
        try {
            this.zg.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.qt.close();
        } catch (IOException e4) {
            e = e4;
        }
        if (e != null) {
            throw e;
        }
    }

    public void xj(boolean z) {
        if (z) {
            this.zg.xj();
            this.zg.hf(this.f10237pl);
            if (this.f10237pl.u() != 65535) {
                this.zg.xj(0, r5 - 65535);
            }
        }
        com.bytedance.sdk.component.tf.u.w wVar = new com.bytedance.sdk.component.tf.u.w(this.e, "Http2Connection");
        wVar.setName("csj_http2_connection" + SystemClock.uptimeMillis());
        wVar.start();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:22:0x0047
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public void xj(final int r8, final java.util.List<com.bytedance.sdk.component.w.hf.xj.kd.w> r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.Set<java.lang.Integer> r0 = r7.yo     // Catch: java.lang.Throwable -> L42
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L42
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L18
            com.bytedance.sdk.component.w.hf.xj.kd.hf r9 = com.bytedance.sdk.component.w.hf.xj.kd.hf.PROTOCOL_ERROR     // Catch: java.lang.Throwable -> L14
            r7.xj(r8, r9)     // Catch: java.lang.Throwable -> L14
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L14
            return
        L14:
            r0 = move-exception
            r8 = r0
            r2 = r7
            goto L45
        L18:
            java.util.Set<java.lang.Integer> r0 = r7.yo     // Catch: java.lang.Throwable -> L42
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L42
            r0.add(r1)     // Catch: java.lang.Throwable -> L42
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L42
            java.util.concurrent.ExecutorService r0 = r7.jk
            com.bytedance.sdk.component.w.hf.xj.kd.c$4 r1 = new com.bytedance.sdk.component.w.hf.xj.kd.c$4
            java.lang.String r3 = "OkHttp %s Push Request[%s]"
            java.lang.String r2 = r7.kd
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = 0
            r5[r6] = r2
            r2 = 1
            r5[r2] = r4
            r2 = r7
            r6 = r9
            r4 = r5
            r5 = r8
            r1.<init>(r3, r4)
            r0.execute(r1)
            return
        L42:
            r0 = move-exception
            r2 = r7
        L44:
            r8 = r0
        L45:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L47
            throw r8
        L47:
            r0 = move-exception
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.w.hf.xj.kd.c.xj(int, java.util.List):void");
    }

    public void xj(final int i, final List<com.bytedance.sdk.component.w.hf.xj.kd.w> list, final boolean z) {
        this.jk.execute(new com.bytedance.sdk.component.w.hf.xj.hf("OkHttp %s Push Headers[%s]", new Object[]{this.kd, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.w.hf.xj.kd.c.5
            @Override // com.bytedance.sdk.component.w.hf.xj.hf
            public void w() {
                boolean xj2 = c.this.d.xj(i, list, z);
                if (xj2) {
                    try {
                        c.this.zg.xj(i, com.bytedance.sdk.component.w.hf.xj.kd.hf.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (xj2 || z) {
                    synchronized (c.this) {
                        c.this.yo.remove(Integer.valueOf(i));
                    }
                }
            }
        });
    }

    public void xj(final int i, com.bytedance.sdk.component.w.xj.kd kdVar, final int i2, final boolean z) {
        final com.bytedance.sdk.component.w.xj.w wVar = new com.bytedance.sdk.component.w.xj.w();
        long j = i2;
        kdVar.xj(j);
        kdVar.xj(wVar, j);
        if (wVar.hf() == j) {
            this.jk.execute(new com.bytedance.sdk.component.w.hf.xj.hf("OkHttp %s Push Data[%s]", new Object[]{this.kd, Integer.valueOf(i)}) { // from class: com.bytedance.sdk.component.w.hf.xj.kd.c.6
                @Override // com.bytedance.sdk.component.w.hf.xj.hf
                public void w() {
                    try {
                        boolean xj2 = c.this.d.xj(i, wVar, i2, z);
                        if (xj2) {
                            c.this.zg.xj(i, com.bytedance.sdk.component.w.hf.xj.kd.hf.CANCEL);
                        }
                        if (xj2 || z) {
                            synchronized (c.this) {
                                c.this.yo.remove(Integer.valueOf(i));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(wVar.hf() + " != " + i2);
    }
}
