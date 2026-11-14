package com.bytedance.sdk.component.f.hf.hf;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.f.hf.hf.w.w;
import com.bytedance.sdk.component.f.xj.d;
import com.bytedance.sdk.component.f.xj.kd;
import com.bytedance.sdk.component.f.xj.u;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.concurrent.Executor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements d {
    private kd c;
    private volatile w kd;
    private volatile Handler y;
    public static final com.bytedance.sdk.component.f.hf.hf.xj.xj xj = new com.bytedance.sdk.component.f.hf.hf.xj.xj();
    public static final long w = System.currentTimeMillis();
    public static long u = 0;
    public volatile int hf = 0;
    private final Comparator<com.bytedance.sdk.component.f.xj.hf> f = new Comparator<com.bytedance.sdk.component.f.xj.hf>() { // from class: com.bytedance.sdk.component.f.hf.hf.hf.1
        @Override // java.util.Comparator
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public int compare(com.bytedance.sdk.component.f.xj.hf hfVar, com.bytedance.sdk.component.f.xj.hf hfVar2) {
            return hf.this.xj(hfVar, hfVar2);
        }
    };

    static {
        anUVg();
    }

    public hf(kd kdVar) {
        this.c = kdVar;
    }

    private static /* synthetic */ void anUVg() {
        char[] charArray = "uy{8qw{s8tyo8e~szz8\\x\u007fTd\u007frqs".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 22);
        }
        String str = new String(charArray);
        char[] charArray2 = "uz\u007fx\u007fb".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 22);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.sdk.component.f.xj.d
    public void hf() {
        kd kdVar = this.c;
        if (kdVar == null || kdVar.u() == null) {
            com.bytedance.sdk.component.f.hf.w.w.hf("discard flush config is null", kdVar);
            return;
        }
        com.bytedance.sdk.component.f.hf.w.w.hf("flushMemoryAndDB", kdVar);
        u u2 = kdVar.u();
        final w wVar = this.kd;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (wVar != null) {
                wVar.xj(72, "start_child2");
                return;
            }
            return;
        }
        Executor f = u2.f();
        if (f == null) {
            f = u2.d();
        }
        if (f == null) {
            com.bytedance.sdk.component.f.hf.w.w.hf("discard flush executor is null", kdVar);
        } else {
            f.execute(new com.bytedance.sdk.component.f.hf.kd.hf("flush") { // from class: com.bytedance.sdk.component.f.hf.hf.hf.3
                @Override // java.lang.Runnable
                public void run() {
                    w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.xj(72, "start_child1");
                    }
                }
            });
        }
    }

    public w kd() {
        return this.kd;
    }

    public boolean u() {
        return this.hf == 2;
    }

    public boolean w() {
        return this.hf == 1;
    }

    public void xj(int i) {
        this.hf = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xj(com.bytedance.sdk.component.f.xj.hf hfVar, com.bytedance.sdk.component.f.xj.hf hfVar2) {
        long j;
        long j2;
        long j3;
        long j4;
        if (hfVar == null) {
            return hfVar2 == null ? 0 : -1;
        }
        if (hfVar2 == null) {
            return 1;
        }
        if (hfVar.kd() == hfVar2.kd()) {
            if (hfVar.xj() != null) {
                j = hfVar.xj().xj();
                j2 = hfVar.xj().hf();
            } else {
                j = 0;
                j2 = 0;
            }
            if (hfVar2.xj() != null) {
                j4 = hfVar2.xj().xj();
                j3 = hfVar2.xj().hf();
            } else {
                j3 = 0;
                j4 = 0;
            }
            if (j == 0 || j4 == 0) {
                return 0;
            }
            long j5 = j - j4;
            if (Math.abs(j5) > 2147483647L) {
                return 0;
            }
            if (j5 != 0) {
                return (int) j5;
            }
            if (j2 == 0 || j3 == 0) {
                return 0;
            }
            return (int) (j2 - j3);
        }
        return hfVar.kd() - hfVar2.kd();
    }

    @Override // com.bytedance.sdk.component.f.xj.d
    public void xj() {
        kd kdVar = this.c;
        if (kdVar == null) {
            return;
        }
        xj(kdVar.kd());
        hf();
    }

    public void xj(Handler handler) {
        this.y = handler;
    }

    public boolean xj(String str) {
        try {
            if (this.kd != null || com.bytedance.sdk.component.f.hf.xj.xj(str) || this.c == null) {
                return false;
            }
            synchronized (this) {
                try {
                    if (this.kd != null) {
                        return false;
                    }
                    this.kd = new w(this.c, this);
                    this.kd.y();
                    return true;
                } finally {
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.f.hf.w.w.w(th.getMessage(), this.c);
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.f.xj.d
    public void xj(com.bytedance.sdk.component.f.xj.hf hfVar) {
        kd kdVar;
        if (hfVar != null && (kdVar = this.c) != null) {
            String kd = kdVar.kd();
            hfVar.xj(System.currentTimeMillis());
            xj(kd);
            u u2 = this.c.u();
            w wVar = this.kd;
            if (wVar != null) {
                xj(u2, hfVar);
                wVar.xj(hfVar, hfVar.kd() == 4);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.f.hf.w.w.u("error : log config is null", this.c);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027 A[Catch: Exception -> 0x001a, TRY_LEAVE, TryCatch #0 {Exception -> 0x001a, blocks: (B:38:0x000a, B:40:0x0010, B:13:0x0027, B:21:0x0053), top: B:37:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043 A[Catch: Exception -> 0x0069, TryCatch #1 {Exception -> 0x0069, blocks: (B:6:0x0002, B:14:0x002d, B:16:0x0043, B:19:0x004d, B:28:0x0059), top: B:5:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(final com.bytedance.sdk.component.f.xj.u r9, com.bytedance.sdk.component.f.xj.hf r10) {
        /*
            r8 = this;
            if (r9 == 0) goto L6c
            boolean r0 = r9.w()     // Catch: java.lang.Exception -> L69
            if (r0 == 0) goto L6c
            if (r10 == 0) goto L1e
            com.bytedance.sdk.component.f.hf.u.xj.hf r0 = r10.xj()     // Catch: java.lang.Exception -> L1a
            if (r0 == 0) goto L1e
            com.bytedance.sdk.component.f.hf.u.xj.hf r10 = r10.xj()     // Catch: java.lang.Exception -> L1a
            long r0 = r10.hf()     // Catch: java.lang.Exception -> L1a
        L18:
            r6 = r0
            goto L21
        L1a:
            r0 = move-exception
            r9 = r0
            r3 = r8
            goto L74
        L1e:
            r0 = 0
            goto L18
        L21:
            r0 = 1
            int r10 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r10 != 0) goto L2d
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L1a
            com.bytedance.sdk.component.f.hf.hf.hf.u = r0     // Catch: java.lang.Exception -> L1a
        L2d:
            com.bytedance.sdk.component.f.hf.hf.xj.xj r10 = com.bytedance.sdk.component.f.hf.hf.hf.xj     // Catch: java.lang.Exception -> L69
            java.util.concurrent.atomic.AtomicLong r10 = r10.e()     // Catch: java.lang.Exception -> L69
            com.bytedance.sdk.component.f.xj.kd r0 = r8.c     // Catch: java.lang.Exception -> L69
            r1 = 1
            com.bytedance.sdk.component.f.hf.w.hf.xj(r10, r1, r0)     // Catch: java.lang.Exception -> L69
            long r0 = r10.get()     // Catch: java.lang.Exception -> L69
            r2 = 200(0xc8, double:9.9E-322)
            int r10 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r10 != 0) goto L6c
            android.os.Looper r10 = android.os.Looper.getMainLooper()     // Catch: java.lang.Exception -> L69
            android.os.Looper r0 = android.os.Looper.myLooper()     // Catch: java.lang.Exception -> L69
            if (r10 != r0) goto L6e
            java.util.concurrent.Executor r10 = r9.f()     // Catch: java.lang.Exception -> L69
            if (r10 != 0) goto L57
            java.util.concurrent.Executor r10 = r9.d()     // Catch: java.lang.Exception -> L1a
        L57:
            if (r10 == 0) goto L6c
            com.bytedance.sdk.component.f.hf.hf.hf$2 r2 = new com.bytedance.sdk.component.f.hf.hf.hf$2     // Catch: java.lang.Exception -> L69
            java.lang.String r4 = "report"
            r3 = r8
            r5 = r9
            r2.<init>(r4)     // Catch: java.lang.Exception -> L66
            r10.execute(r2)     // Catch: java.lang.Exception -> L66
            return
        L66:
            r0 = move-exception
        L67:
            r9 = r0
            goto L74
        L69:
            r0 = move-exception
            r3 = r8
            goto L67
        L6c:
            r3 = r8
            goto L77
        L6e:
            r3 = r8
            r5 = r9
            r8.xj(r5, r6)     // Catch: java.lang.Exception -> L66
            return
        L74:
            com.bytedance.sdk.component.utils.pl.xj(r9)
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.f.hf.hf.hf.xj(com.bytedance.sdk.component.f.xj.u, com.bytedance.sdk.component.f.xj.hf):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(u uVar, long j) {
        w wVar = this.kd;
        if (uVar == null || wVar == null) {
            return;
        }
        com.bytedance.sdk.component.f.hf.hf.xj.xj xjVar = xj;
        wVar.xj(uVar.xj(xjVar.xj(j, this.c)), true);
        xjVar.y();
    }
}
