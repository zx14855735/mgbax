package com.ss.android.socialbase.downloader.network;

import android.os.Handler;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w {
    private final Handler hf;
    private final Handler w;
    private final com.ss.android.socialbase.downloader.tf.f<String, hf> xj;

    public static class hf {
        long hf;
        List<InetAddress> xj;

        private hf() {
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.network.w$w, reason: collision with other inner class name */
    public static class C0505w {
        private static final w xj = new w();

        static {
            xYEiNV();
        }

        private static /* synthetic */ void xYEiNV() {
            char[] charArray = "\u0018\u0014\u0016U\u001c\u001a\u0016\u001eU\u0019\u0014\u0002U\b\u0013\u001e\u0017\u0017U1\u0015\u00129\t\u0012\u001f\u001c\u001e".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '{');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0018\u0017\u0012\u0015\u0012\u000f".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '{');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public interface xj {
        void xj(String str, List<InetAddress> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:1|2|a|(2:8|(1:(2:11|12)(1:14)))|15|(6:19|20|(3:36|37|38)|(3:28|29|(2:31|32)(1:33))|29|(0)(0))|45|(1:22)|36|37|38|(4:25|28|29|(0)(0))|29|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0088, code lost:
    
        r10 = r2.xj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0075, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0076, code lost:
    
        com.bytedance.sdk.component.utils.pl.xj(r11);
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0091 A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #2 {all -> 0x003b, blocks: (B:2:0x0000, B:3:0x000a, B:8:0x0016, B:11:0x0035, B:15:0x003d, B:17:0x0054, B:22:0x0066, B:25:0x007b, B:28:0x0082, B:29:0x008a, B:31:0x0091, B:35:0x0088, B:36:0x006c, B:41:0x0076, B:44:0x0060, B:49:0x0097, B:38:0x0070, B:5:0x000b, B:6:0x0013, B:20:0x005a), top: B:1:0x0000, inners: #0, #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void hf(final java.lang.String r8, final com.ss.android.socialbase.downloader.network.w.xj r9, long r10) {
        /*
            r7 = this;
            android.net.Uri r0 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r0 = r0.getHost()     // Catch: java.lang.Throwable -> L3b
            com.ss.android.socialbase.downloader.tf.f<java.lang.String, com.ss.android.socialbase.downloader.network.w$hf> r1 = r7.xj     // Catch: java.lang.Throwable -> L3b
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L3b
            com.ss.android.socialbase.downloader.tf.f<java.lang.String, com.ss.android.socialbase.downloader.network.w$hf> r2 = r7.xj     // Catch: java.lang.Throwable -> L95
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Throwable -> L95
            com.ss.android.socialbase.downloader.network.w$hf r2 = (com.ss.android.socialbase.downloader.network.w.hf) r2     // Catch: java.lang.Throwable -> L95
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L95
            if (r2 == 0) goto L3d
            com.ss.android.socialbase.downloader.f.xj r1 = com.ss.android.socialbase.downloader.f.xj.w()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "dns_expire_min"
            r4 = 10
            int r1 = r1.xj(r3, r4)     // Catch: java.lang.Throwable -> L3b
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L3b
            long r5 = r2.hf     // Catch: java.lang.Throwable -> L3b
            long r3 = r3 - r5
            r5 = 60000(0xea60, float:8.4078E-41)
            int r1 = r1 * r5
            long r5 = (long) r1     // Catch: java.lang.Throwable -> L3b
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L3d
            if (r9 == 0) goto L94
            java.util.List<java.net.InetAddress> r10 = r2.xj     // Catch: java.lang.Throwable -> L3b
            r9.xj(r8, r10)     // Catch: java.lang.Throwable -> L3b
            return
        L3b:
            r8 = move-exception
            goto L98
        L3d:
            com.ss.android.socialbase.downloader.network.w$2 r1 = new com.ss.android.socialbase.downloader.network.w$2     // Catch: java.lang.Throwable -> L3b
            r1.<init>()     // Catch: java.lang.Throwable -> L3b
            android.os.Handler r3 = r7.w     // Catch: java.lang.Throwable -> L3b
            r3.postDelayed(r1, r10)     // Catch: java.lang.Throwable -> L3b
            com.ss.android.socialbase.downloader.f.xj r10 = com.ss.android.socialbase.downloader.f.xj.w()     // Catch: java.lang.Throwable -> L3b
            java.lang.String r11 = "use_host_dns"
            r3 = 1
            int r10 = r10.xj(r11, r3)     // Catch: java.lang.Throwable -> L3b
            if (r10 != r3) goto L63
            com.ss.android.socialbase.downloader.network.y r10 = com.ss.android.socialbase.downloader.downloader.w.ht()     // Catch: java.lang.Throwable -> L3b
            if (r10 == 0) goto L63
            java.util.List r10 = r10.xj(r0)     // Catch: java.lang.Throwable -> L5f
            goto L64
        L5f:
            r10 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r10)     // Catch: java.lang.Throwable -> L3b
        L63:
            r10 = 0
        L64:
            if (r10 == 0) goto L6c
            boolean r11 = r10.isEmpty()     // Catch: java.lang.Throwable -> L3b
            if (r11 == 0) goto L79
        L6c:
            com.ss.android.socialbase.downloader.network.y r11 = com.ss.android.socialbase.downloader.downloader.w.ra()     // Catch: java.lang.Throwable -> L3b
            java.util.List r10 = r11.xj(r0)     // Catch: java.lang.Throwable -> L75
            goto L79
        L75:
            r11 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r11)     // Catch: java.lang.Throwable -> L3b
        L79:
            if (r10 == 0) goto L86
            boolean r11 = r10.isEmpty()     // Catch: java.lang.Throwable -> L3b
            if (r11 == 0) goto L82
            goto L86
        L82:
            r7.xj(r0, r10)     // Catch: java.lang.Throwable -> L3b
            goto L8a
        L86:
            if (r2 == 0) goto L8a
            java.util.List<java.net.InetAddress> r10 = r2.xj     // Catch: java.lang.Throwable -> L3b
        L8a:
            android.os.Handler r11 = r7.w     // Catch: java.lang.Throwable -> L3b
            r11.removeCallbacks(r1)     // Catch: java.lang.Throwable -> L3b
            if (r9 == 0) goto L94
            r9.xj(r8, r10)     // Catch: java.lang.Throwable -> L3b
        L94:
            return
        L95:
            r8 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L95
            throw r8     // Catch: java.lang.Throwable -> L3b
        L98:
            com.bytedance.sdk.component.utils.pl.xj(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.network.w.hf(java.lang.String, com.ss.android.socialbase.downloader.network.w$xj, long):void");
    }

    private w() {
        this.xj = new com.ss.android.socialbase.downloader.tf.f<>(4, 16, false);
        this.hf = new Handler(com.ss.android.socialbase.downloader.network.xj.hf.xj());
        this.w = new Handler(com.ss.android.socialbase.downloader.d.kd.xj());
    }

    public static w xj() {
        return C0505w.xj;
    }

    public void xj(final String str, final xj xjVar, final long j) {
        this.hf.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.w.1
            @Override // java.lang.Runnable
            public void run() {
                w.this.hf(str, xjVar, j);
            }
        });
    }

    private void xj(String str, List<InetAddress> list) {
        synchronized (this.xj) {
            try {
                hf hfVar = this.xj.get(str);
                if (hfVar == null) {
                    hfVar = new hf();
                    this.xj.put(str, hfVar);
                }
                hfVar.xj = list;
                hfVar.hf = System.currentTimeMillis();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
