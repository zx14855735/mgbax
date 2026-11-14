package com.ss.android.socialbase.downloader.d;

import com.ss.android.socialbase.downloader.downloader.tf;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf implements Runnable {
    private static final String xj = "hf";
    private final y c;
    private tf d;
    private d f;
    private com.ss.android.socialbase.downloader.model.hf hf;
    private final DownloadTask kd;
    private volatile boolean p;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f13841pl;
    private volatile boolean tf;
    private com.ss.android.socialbase.downloader.downloader.kd u;
    private com.ss.android.socialbase.downloader.model.hf w;
    private DownloadInfo y;

    public hf(com.ss.android.socialbase.downloader.model.hf hfVar, DownloadTask downloadTask, y yVar) {
        this.f13841pl = false;
        this.w = hfVar;
        this.kd = downloadTask;
        if (downloadTask != null) {
            this.y = downloadTask.getDownloadInfo();
        }
        this.c = yVar;
        this.d = com.ss.android.socialbase.downloader.downloader.w.et();
        this.w.xj(this);
    }

    private boolean kd() {
        return this.tf || this.p;
    }

    private void u() {
        d dVar = this.f;
        if (dVar != null) {
            dVar.u();
            this.f = null;
        }
    }

    private String w() {
        return this.y.getConnectionUrl();
    }

    public void hf() {
        this.p = true;
        com.ss.android.socialbase.downloader.downloader.kd kdVar = this.u;
        if (kdVar != null) {
            kdVar.w();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0017, code lost:
    
        r3.hf.xj(false);
     */
    @Override // java.lang.Runnable
    @android.annotation.SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r3 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
            com.ss.android.socialbase.downloader.model.hf r0 = r3.w
            r3.hf = r0
        L9:
            r0 = 0
            com.ss.android.socialbase.downloader.model.hf r1 = r3.hf     // Catch: java.lang.Throwable -> L1d
            r1.xj(r3)     // Catch: java.lang.Throwable -> L1d
            com.ss.android.socialbase.downloader.model.hf r1 = r3.hf     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r3.xj(r1)     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L1f
            com.ss.android.socialbase.downloader.model.hf r1 = r3.hf     // Catch: java.lang.Throwable -> L1d
            r1.xj(r0)     // Catch: java.lang.Throwable -> L1d
            goto L4d
        L1d:
            r1 = move-exception
            goto L5d
        L1f:
            com.ss.android.socialbase.downloader.model.hf r1 = r3.hf     // Catch: java.lang.Throwable -> L1d
            r1.xj(r0)     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r3.kd()     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L4d
            com.ss.android.socialbase.downloader.d.y r1 = r3.c     // Catch: java.lang.Throwable -> L1d
            com.ss.android.socialbase.downloader.model.hf r2 = r3.hf     // Catch: java.lang.Throwable -> L1d
            int r2 = r2.v()     // Catch: java.lang.Throwable -> L1d
            com.ss.android.socialbase.downloader.model.hf r1 = r1.xj(r2)     // Catch: java.lang.Throwable -> L1d
            r3.hf = r1     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r3.kd()     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L4d
            com.ss.android.socialbase.downloader.model.hf r1 = r3.hf     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L4d
            r1 = 50
            java.lang.Thread.sleep(r1)     // Catch: java.lang.Throwable -> L48
            goto L9
        L48:
            r1 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r1)     // Catch: java.lang.Throwable -> L1d
            goto L9
        L4d:
            com.ss.android.socialbase.downloader.model.hf r1 = r3.hf
            if (r1 == 0) goto L54
            r1.xj(r0)
        L54:
            r3.u()
            com.ss.android.socialbase.downloader.d.y r0 = r3.c
            r0.xj(r3)
            return
        L5d:
            com.ss.android.socialbase.downloader.model.hf r2 = r3.hf
            if (r2 == 0) goto L64
            r2.xj(r0)
        L64:
            r3.u()
            com.ss.android.socialbase.downloader.d.y r0 = r3.c
            r0.xj(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.d.hf.run():void");
    }

    public void xj(long j, long j2) {
        com.ss.android.socialbase.downloader.downloader.kd kdVar = this.u;
        if (kdVar == null) {
            return;
        }
        kdVar.xj(j, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0238, code lost:
    
        if (r2 < 0) goto L167;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0261 A[Catch: all -> 0x01d2, TryCatch #6 {all -> 0x01d2, blocks: (B:74:0x01df, B:76:0x01e9, B:129:0x01ef, B:78:0x01f8, B:80:0x0200, B:110:0x0206, B:83:0x0211, B:85:0x0215, B:87:0x021d, B:89:0x022e, B:91:0x0254, B:93:0x025a, B:94:0x0267, B:96:0x026f, B:101:0x0261, B:103:0x023d, B:105:0x0249, B:114:0x027a, B:116:0x0282, B:118:0x028a, B:120:0x0292, B:122:0x029a, B:125:0x02a3, B:141:0x01c2, B:146:0x01cc, B:151:0x01d6), top: B:73:0x01df, inners: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x00ff A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x01a9 A[Catch: all -> 0x017a, BaseException -> 0x017c, TRY_LEAVE, TryCatch #8 {BaseException -> 0x017c, blocks: (B:57:0x014d, B:59:0x0156, B:63:0x0162, B:64:0x0168, B:167:0x018f, B:168:0x019d, B:182:0x01a5, B:184:0x01a9, B:195:0x01be, B:196:0x01c1), top: B:56:0x014d }] */
    /* JADX WARN: Removed duplicated region for block: B:198:? A[Catch: all -> 0x017a, BaseException -> 0x017c, SYNTHETIC, TRY_LEAVE, TryCatch #8 {BaseException -> 0x017c, blocks: (B:57:0x014d, B:59:0x0156, B:63:0x0162, B:64:0x0168, B:167:0x018f, B:168:0x019d, B:182:0x01a5, B:184:0x01a9, B:195:0x01be, B:196:0x01c1), top: B:56:0x014d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0103 A[Catch: all -> 0x00d2, BaseException -> 0x018b, TRY_ENTER, TryCatch #3 {BaseException -> 0x018b, blocks: (B:23:0x004e, B:25:0x0058, B:28:0x0063, B:47:0x00f9, B:49:0x0103, B:51:0x0107, B:54:0x0144, B:202:0x00df), top: B:22:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01e9 A[Catch: all -> 0x01d2, TRY_ENTER, TryCatch #6 {all -> 0x01d2, blocks: (B:74:0x01df, B:76:0x01e9, B:129:0x01ef, B:78:0x01f8, B:80:0x0200, B:110:0x0206, B:83:0x0211, B:85:0x0215, B:87:0x021d, B:89:0x022e, B:91:0x0254, B:93:0x025a, B:94:0x0267, B:96:0x026f, B:101:0x0261, B:103:0x023d, B:105:0x0249, B:114:0x027a, B:116:0x0282, B:118:0x028a, B:120:0x0292, B:122:0x029a, B:125:0x02a3, B:141:0x01c2, B:146:0x01cc, B:151:0x01d6), top: B:73:0x01df, inners: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x025a A[Catch: all -> 0x01d2, TryCatch #6 {all -> 0x01d2, blocks: (B:74:0x01df, B:76:0x01e9, B:129:0x01ef, B:78:0x01f8, B:80:0x0200, B:110:0x0206, B:83:0x0211, B:85:0x0215, B:87:0x021d, B:89:0x022e, B:91:0x0254, B:93:0x025a, B:94:0x0267, B:96:0x026f, B:101:0x0261, B:103:0x023d, B:105:0x0249, B:114:0x027a, B:116:0x0282, B:118:0x028a, B:120:0x0292, B:122:0x029a, B:125:0x02a3, B:141:0x01c2, B:146:0x01cc, B:151:0x01d6), top: B:73:0x01df, inners: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x026f A[Catch: all -> 0x01d2, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x01d2, blocks: (B:74:0x01df, B:76:0x01e9, B:129:0x01ef, B:78:0x01f8, B:80:0x0200, B:110:0x0206, B:83:0x0211, B:85:0x0215, B:87:0x021d, B:89:0x022e, B:91:0x0254, B:93:0x025a, B:94:0x0267, B:96:0x026f, B:101:0x0261, B:103:0x023d, B:105:0x0249, B:114:0x027a, B:116:0x0282, B:118:0x028a, B:120:0x0292, B:122:0x029a, B:125:0x02a3, B:141:0x01c2, B:146:0x01cc, B:151:0x01d6), top: B:73:0x01df, inners: #14 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x026b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean xj(com.ss.android.socialbase.downloader.model.hf r28) {
        /*
            Method dump skipped, instructions count: 688
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.d.hf.xj(com.ss.android.socialbase.downloader.model.hf):boolean");
    }

    public hf(com.ss.android.socialbase.downloader.model.hf hfVar, DownloadTask downloadTask, d dVar, y yVar) {
        this(hfVar, downloadTask, yVar);
        this.f = dVar;
    }

    private void xj(com.ss.android.socialbase.downloader.model.hf hfVar, long j) {
        com.ss.android.socialbase.downloader.model.hf kd = hfVar.u() ? hfVar.kd() : hfVar;
        if (kd != null) {
            if (kd.f()) {
                this.d.xj(kd.p(), kd.hf(), j);
            }
            kd.hf(j);
            this.d.xj(kd.p(), kd.v(), kd.hf(), j);
            return;
        }
        if (hfVar.u()) {
            this.d.xj(hfVar.p(), hfVar.v(), j);
        }
    }

    public void xj() {
        this.tf = true;
        com.ss.android.socialbase.downloader.downloader.kd kdVar = this.u;
        if (kdVar != null) {
            kdVar.hf();
        }
    }
}
