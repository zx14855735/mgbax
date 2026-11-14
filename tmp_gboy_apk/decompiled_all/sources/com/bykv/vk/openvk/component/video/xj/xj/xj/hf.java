package com.bykv.vk.openvk.component.video.xj.xj.xj;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.w.u;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.pl;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.net.SocketTimeoutException;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements w {
    private static final HashMap<String, hf> xj = new HashMap<>();
    private volatile long hf;
    private File kd;
    private final u p;

    /* renamed from: pl, reason: collision with root package name */
    private hf f10031pl;
    private RandomAccessFile tf;
    private File u;
    private long y;
    private final Object w = new Object();
    private volatile long c = -1;
    private volatile boolean f = false;
    private volatile boolean d = false;

    static {
        rYaF();
    }

    public hf(Context context, u uVar) {
        this.hf = -2147483648L;
        this.y = 0L;
        this.tf = null;
        this.p = uVar;
        try {
            this.u = com.bykv.vk.openvk.component.video.xj.kd.w.hf(uVar.kd(), uVar.e());
            this.kd = com.bykv.vk.openvk.component.video.xj.kd.w.w(uVar.kd(), uVar.e());
            if (c()) {
                this.tf = new RandomAccessFile(this.kd, t.k);
            } else {
                this.tf = new RandomAccessFile(this.u, "rw");
            }
            if (c()) {
                return;
            }
            long length = this.u.length();
            this.y = length;
            if (length == uVar.pl() && this.y != 0) {
                boolean xj2 = com.bykv.vk.openvk.component.video.api.y.hf.xj(com.bykv.vk.openvk.component.video.api.y.hf.xj(this.u), uVar.e());
                uVar.e();
                if (xj2) {
                    xj(this.y);
                    this.hf = this.y;
                    return;
                }
            }
            if (!u()) {
                com.bykv.vk.openvk.component.video.api.y.w.hf("CSJ_MediaDLPlay", "no process lock, no download " + kd());
                return;
            }
            synchronized (hf.class) {
                try {
                    if (y()) {
                        f();
                    } else {
                        hf hfVar = this.f10031pl;
                        if (hfVar != null) {
                            this.hf = hfVar.xj();
                        }
                    }
                } finally {
                }
            }
        } catch (Throwable unused) {
            com.bykv.vk.openvk.component.video.api.y.w.hf("CSJ_MediaDLPlay", "Error using file ", uVar.zg(), " as disc cache");
        }
    }

    private static /* synthetic */ void rYaF() {
        char[] charArray = "\u0093\u009f\u009dÞ\u0097\u0091\u009d\u0095Þ\u0092\u009f\u0089Þ\u0083\u0098\u0095\u009c\u009cÞº\u009e\u0099²\u0082\u0099\u0094\u0097\u0095".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 240);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0093\u009c\u0099\u009e\u0099\u0084".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 240);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private boolean c() {
        return this.kd.exists() && this.kd.length() > 0;
    }

    private long d() {
        return c() ? this.kd.length() : this.u.length();
    }

    private void f() {
        pl.xj hf = com.bykv.vk.openvk.component.video.api.w.w() != null ? com.bykv.vk.openvk.component.video.api.w.w().hf() : new pl.xj("v_cache");
        long v = this.p.v();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        hf.xj(v, timeUnit).hf(this.p.jk(), timeUnit).w(this.p.pz(), timeUnit);
        pl xj2 = hf.xj();
        this.p.e();
        xj2.xj(new am.xj().xj("RANGE", "bytes=" + this.y + "-").xj(this.p.zg()).xj().hf()).xj(new com.bytedance.sdk.component.hf.xj.w() { // from class: com.bykv.vk.openvk.component.video.xj.xj.xj.hf.1
            @Override // com.bytedance.sdk.component.hf.xj.w
            public void onFailure(com.bytedance.sdk.component.hf.xj.hf hfVar, IOException iOException) {
                hf.this.d = false;
                hf.this.hf = -1L;
                hf.this.xj(true);
            }

            /* JADX WARN: Code restructure failed: missing block: B:100:0x0185, code lost:
            
                r4 = r18.xj.w;
             */
            /* JADX WARN: Code restructure failed: missing block: B:101:0x018b, code lost:
            
                monitor-enter(r4);
             */
            /* JADX WARN: Code restructure failed: missing block: B:104:0x0192, code lost:
            
                if (r18.xj.f == false) goto L108;
             */
            /* JADX WARN: Code restructure failed: missing block: B:106:0x01ff, code lost:
            
                if (com.bykv.vk.openvk.component.video.xj.kd.w.xj(r18.xj.tf, r0, r7, r11) == false) goto L215;
             */
            /* JADX WARN: Code restructure failed: missing block: B:107:0x0201, code lost:
            
                r7 = r7 + r11;
             */
            /* JADX WARN: Code restructure failed: missing block: B:108:0x0203, code lost:
            
                monitor-exit(r4);
             */
            /* JADX WARN: Code restructure failed: missing block: B:111:0x0208, code lost:
            
                com.bytedance.sdk.component.utils.pl.hf("CSJ_MediaDLPlay", "append error, try again：" + r7 + "  offset = " + r11 + " key= " + r18.xj.p.e() + " fb: " + r10.valid() + " channel " + r9.isOpen());
             */
            /* JADX WARN: Code restructure failed: missing block: B:112:0x024d, code lost:
            
                monitor-exit(r4);
             */
            /* JADX WARN: Code restructure failed: missing block: B:114:0x024e, code lost:
            
                r3.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:115:0x0251, code lost:
            
                if (r6 == null) goto L120;
             */
            /* JADX WARN: Code restructure failed: missing block: B:116:0x0253, code lost:
            
                r6.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:117:0x0259, code lost:
            
                r20.close();
                r2 = r18.xj.u.length();
             */
            /* JADX WARN: Code restructure failed: missing block: B:118:0x026c, code lost:
            
                if (r18.xj.d == false) goto L230;
             */
            /* JADX WARN: Code restructure failed: missing block: B:120:0x0276, code lost:
            
                if (r2 != r18.xj.hf) goto L231;
             */
            /* JADX WARN: Code restructure failed: missing block: B:122:0x027a, code lost:
            
                if (r2 <= r16) goto L232;
             */
            /* JADX WARN: Code restructure failed: missing block: B:123:0x027c, code lost:
            
                r0 = r18.xj;
                r0.xj(r0.hf);
             */
            /* JADX WARN: Code restructure failed: missing block: B:124:0x0285, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:126:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:127:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:128:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:129:0x0257, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:131:0x0286, code lost:
            
                com.bykv.vk.openvk.component.video.api.y.w.hf("CSJ_MediaDLPlay", "close stream error", r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:132:0x028d, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:134:0x0194, code lost:
            
                com.bykv.vk.openvk.component.video.api.y.w.hf("CSJ_MediaDLPlay", "close stream " + r18.xj.p.e());
             */
            /* JADX WARN: Code restructure failed: missing block: B:135:0x01b1, code lost:
            
                monitor-exit(r4);
             */
            /* JADX WARN: Code restructure failed: missing block: B:137:0x01b2, code lost:
            
                r3.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:138:0x01b5, code lost:
            
                if (r6 == null) goto L96;
             */
            /* JADX WARN: Code restructure failed: missing block: B:139:0x01b7, code lost:
            
                r6.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:140:0x01bd, code lost:
            
                r20.close();
                r2 = r18.xj.u.length();
             */
            /* JADX WARN: Code restructure failed: missing block: B:141:0x01d0, code lost:
            
                if (r18.xj.d == false) goto L227;
             */
            /* JADX WARN: Code restructure failed: missing block: B:143:0x01da, code lost:
            
                if (r2 != r18.xj.hf) goto L228;
             */
            /* JADX WARN: Code restructure failed: missing block: B:145:0x01de, code lost:
            
                if (r2 <= r16) goto L229;
             */
            /* JADX WARN: Code restructure failed: missing block: B:146:0x01e0, code lost:
            
                r0 = r18.xj;
                r0.xj(r0.hf);
             */
            /* JADX WARN: Code restructure failed: missing block: B:147:0x01e9, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:149:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:150:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:151:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:152:0x01bb, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:154:0x01ea, code lost:
            
                com.bykv.vk.openvk.component.video.api.y.w.hf("CSJ_MediaDLPlay", "close stream error", r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:155:0x01f1, code lost:
            
                return;
             */
            /* JADX WARN: Removed duplicated region for block: B:164:0x0323 A[Catch: all -> 0x02cc, TRY_ENTER, TryCatch #9 {all -> 0x02cc, blocks: (B:164:0x0323, B:166:0x0328, B:167:0x032b, B:169:0x0340, B:173:0x034e, B:205:0x02c8, B:207:0x02d0, B:208:0x02d3, B:210:0x02e8, B:214:0x02f6), top: B:4:0x0008 }] */
            /* JADX WARN: Removed duplicated region for block: B:166:0x0328 A[Catch: all -> 0x02cc, TryCatch #9 {all -> 0x02cc, blocks: (B:164:0x0323, B:166:0x0328, B:167:0x032b, B:169:0x0340, B:173:0x034e, B:205:0x02c8, B:207:0x02d0, B:208:0x02d3, B:210:0x02e8, B:214:0x02f6), top: B:4:0x0008 }] */
            @Override // com.bytedance.sdk.component.hf.xj.w
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onResponse(com.bytedance.sdk.component.hf.xj.hf r19, com.bytedance.sdk.component.hf.xj.zg r20) {
                /*
                    Method dump skipped, instructions count: 945
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.xj.xj.xj.hf.AnonymousClass1.onResponse(com.bytedance.sdk.component.hf.xj.hf, com.bytedance.sdk.component.hf.xj.zg):void");
            }
        });
    }

    private String kd() {
        u uVar = this.p;
        return uVar == null ? "" : uVar.e();
    }

    private boolean u() {
        RandomAccessFile randomAccessFile = this.tf;
        if (randomAccessFile == null) {
            return false;
        }
        try {
            FileLock tryLock = randomAccessFile.getChannel().tryLock();
            if (tryLock == null) {
                if (tryLock != null) {
                    try {
                        tryLock.close();
                    } catch (IOException unused) {
                    }
                }
                return false;
            }
            try {
                tryLock.close();
                return true;
            } catch (IOException unused2) {
                return true;
            }
        } catch (IOException unused3) {
            return false;
        }
    }

    private boolean y() {
        String kd = kd();
        synchronized (hf.class) {
            try {
                HashMap<String, hf> hashMap = xj;
                hf hfVar = hashMap.get(kd);
                this.f10031pl = hfVar;
                if (hfVar != null) {
                    return false;
                }
                hashMap.put(kd, this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.xj.xj.xj.w
    public long w() {
        if (!c()) {
            synchronized (this.w) {
                int i = 0;
                do {
                    try {
                        if (this.hf == -2147483648L) {
                            try {
                                hf hfVar = this.f10031pl;
                                if (hfVar != null) {
                                    this.hf = hfVar.xj();
                                }
                                i += 15;
                                this.w.wait(5L);
                            } catch (InterruptedException e) {
                                com.bytedance.sdk.component.utils.pl.xj(e);
                                throw new IOException("total length InterruptException");
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } while (i <= 10000);
                return -1L;
            }
        }
        this.hf = this.kd.length();
        com.bykv.vk.openvk.component.video.api.y.w.xj("CSJ_MediaDLPlay", "totalLength= ", Long.valueOf(this.hf));
        return this.hf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(boolean z) {
        String kd = kd();
        synchronized (hf.class) {
            try {
                if (z) {
                    xj.remove(kd);
                } else {
                    HashMap<String, hf> hashMap = xj;
                    if (hashMap.get(kd) == this) {
                        hashMap.remove(kd);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    @Override // com.bykv.vk.openvk.component.video.xj.xj.xj.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void hf() {
        /*
            r4 = this;
            r0 = 0
            boolean r1 = r4.f     // Catch: java.lang.Throwable -> Lb
            if (r1 != 0) goto Ld
            java.io.RandomAccessFile r1 = r4.tf     // Catch: java.lang.Throwable -> Lb
            r1.close()     // Catch: java.lang.Throwable -> Lb
            goto Ld
        Lb:
            r1 = move-exception
            goto L27
        Ld:
            java.io.File r1 = r4.u     // Catch: java.lang.Throwable -> Lb
            if (r1 == 0) goto L18
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lb
            r1.setLastModified(r2)     // Catch: java.lang.Throwable -> Lb
        L18:
            java.io.File r1 = r4.kd     // Catch: java.lang.Throwable -> Lb
            if (r1 == 0) goto L23
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lb
            r1.setLastModified(r2)     // Catch: java.lang.Throwable -> Lb
        L23:
            r4.xj(r0)
            goto L2f
        L27:
            java.lang.String r2 = "CSJ_MediaDLPlay"
            java.lang.String r3 = "close error"
            com.bykv.vk.openvk.component.video.api.y.w.hf(r2, r3, r1)     // Catch: java.lang.Throwable -> L3a
            goto L23
        L2f:
            java.lang.Object r1 = r4.w
            monitor-enter(r1)
            r0 = 1
            r4.f = r0     // Catch: java.lang.Throwable -> L37
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L37
            return
        L37:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L37
            throw r0
        L3a:
            r1 = move-exception
            r4.xj(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.xj.xj.xj.hf.hf():void");
    }

    public long xj() {
        return this.hf;
    }

    @Override // com.bykv.vk.openvk.component.video.xj.xj.xj.w
    public int xj(long j, byte[] bArr, int i, int i2) {
        try {
            if (j == this.hf) {
                return -1;
            }
            int i3 = 0;
            int i4 = 0;
            while (!this.f) {
                synchronized (this.w) {
                    try {
                        if (j < d()) {
                            this.tf.seek(j);
                            i4 = this.tf.read(bArr, i, i2);
                        } else {
                            i3 += 33;
                            this.w.wait(33L);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i4 > 0) {
                    return i4;
                }
                if (i3 >= 10000) {
                    throw new SocketTimeoutException();
                }
            }
            return -1;
        } catch (Throwable th2) {
            if (th2 instanceof IOException) {
                throw th2;
            }
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(long j) {
        synchronized (this.w) {
            if (this.kd.exists() && this.kd.length() >= j) {
                this.p.zg();
                this.p.e();
                return;
            }
            try {
            } finally {
                return;
            }
            if (this.u.renameTo(this.kd)) {
                RandomAccessFile randomAccessFile = this.tf;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (!this.f) {
                    this.tf = new RandomAccessFile(this.kd, "rw");
                }
                this.p.e();
                this.p.zg();
                return;
            }
            throw new IOException("Error renaming file " + this.u + " to " + this.kd + " for completion!");
        }
    }
}
