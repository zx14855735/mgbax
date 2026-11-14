package com.ss.android.socialbase.downloader.y;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class c {
    private final long am;
    private final w c;
    private long e;
    private BaseException f;
    private final boolean g;
    private final com.ss.android.socialbase.downloader.f.xj kd;
    private final long qt;
    private final DownloadInfo w;
    private final com.ss.android.socialbase.downloader.d.y y;
    private final boolean zg;
    private final List<pl> xj = new LinkedList();
    private final List<pl> hf = new ArrayList();
    private volatile boolean d = false;
    private volatile boolean tf = false;
    private volatile boolean p = false;
    private volatile long yo = 0;
    private volatile long v = 0;
    private final com.ss.android.socialbase.downloader.downloader.tf u = com.ss.android.socialbase.downloader.downloader.w.et();

    /* renamed from: pl, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.xj.xj f13857pl = com.ss.android.socialbase.downloader.xj.xj.xj();

    public c(DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.d.y yVar, w wVar) {
        this.w = downloadInfo;
        this.y = yVar;
        this.c = wVar;
        com.ss.android.socialbase.downloader.f.xj xj = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId());
        this.kd = xj;
        boolean z = xj.xj("sync_strategy", 0) == 1;
        this.g = z;
        if (z) {
            long xj2 = xj.xj("sync_interval_ms_fg", 5000);
            long xj3 = xj.xj("sync_interval_ms_bg", 1000);
            this.am = Math.max(xj2, 500L);
            this.qt = Math.max(xj3, 500L);
        } else {
            this.am = 0L;
            this.qt = 0L;
        }
        this.zg = xj.hf("monitor_rw") == 1;
    }

    private void hf(List<pl> list) {
        Iterator<pl> it = list.iterator();
        while (it.hasNext()) {
            it.next().w();
        }
    }

    private void w() {
        boolean z;
        boolean z2 = this.zg;
        long nanoTime = z2 ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.w;
        com.ss.android.socialbase.downloader.downloader.tf tfVar = this.u;
        List<pl> list = this.xj;
        List<pl> list2 = this.hf;
        Map<Long, d> pl2 = tfVar.pl(downloadInfo.getId());
        if (pl2 == null) {
            pl2 = new HashMap<>(4);
        }
        synchronized (this) {
            try {
                xj(list);
                try {
                    hf(list);
                    z = true;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.xj(th);
                    z = false;
                }
                xj(list, pl2);
                if (list2.size() > 0) {
                    w(list2);
                    list.removeAll(list2);
                    list2.clear();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z) {
            downloadInfo.updateRealDownloadTime(true);
            tfVar.xj(downloadInfo.getId(), pl2);
            tfVar.xj(downloadInfo);
            this.yo = downloadInfo.getCurBytes();
        }
        if (z2) {
            this.e += System.nanoTime() - nanoTime;
        }
    }

    private boolean xj(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    public void xj(pl plVar) {
        synchronized (this) {
            this.xj.add(plVar);
        }
    }

    public void hf() {
        this.tf = true;
        this.d = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:297:0x00c9, code lost:
    
        if (r2 <= 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:300:0x00cc, code lost:
    
        r3.hf(r2);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0347 A[Catch: all -> 0x02be, TryCatch #13 {all -> 0x02be, blocks: (B:226:0x02bb, B:227:0x02bd, B:117:0x033d, B:119:0x0347, B:121:0x034b, B:164:0x03c4, B:166:0x03ca, B:167:0x03cd, B:168:0x03de, B:181:0x023a), top: B:6:0x0024, inners: #43 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0373 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03ca A[Catch: all -> 0x02be, TryCatch #13 {all -> 0x02be, blocks: (B:226:0x02bb, B:227:0x02bd, B:117:0x033d, B:119:0x0347, B:121:0x034b, B:164:0x03c4, B:166:0x03ca, B:167:0x03cd, B:168:0x03de, B:181:0x023a), top: B:6:0x0024, inners: #43 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0213 A[Catch: all -> 0x02b2, TryCatch #5 {all -> 0x02b2, blocks: (B:173:0x020f, B:175:0x0213, B:177:0x021b, B:179:0x022b, B:181:0x023a), top: B:172:0x020f }] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0263 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x02cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x040f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.ss.android.socialbase.downloader.model.DownloadInfo] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(com.ss.android.socialbase.downloader.y.u r31) {
        /*
            Method dump skipped, instructions count: 1118
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.y.c.xj(com.ss.android.socialbase.downloader.y.u):void");
    }

    private void w(List<pl> list) {
        Iterator<pl> it = list.iterator();
        while (it.hasNext()) {
            it.next().u();
        }
    }

    private void xj(long j, boolean z) {
        long j2 = j - this.v;
        if (this.g) {
            if (j2 <= (this.f13857pl.hf() ? this.am : this.qt)) {
                return;
            }
        } else {
            long curBytes = this.w.getCurBytes() - this.yo;
            if (!z && !xj(curBytes, j2)) {
                return;
            }
        }
        w();
        this.v = j;
    }

    private void xj(kd kdVar) {
        synchronized (this) {
            this.hf.add((pl) kdVar);
        }
    }

    private void xj(List<pl> list) {
        Iterator<pl> it = list.iterator();
        while (it.hasNext()) {
            it.next().hf();
        }
    }

    private void xj(List<pl> list, Map<Long, d> map) {
        Iterator<pl> it = list.iterator();
        while (it.hasNext()) {
            d kd = it.next().kd();
            d dVar = map.get(Long.valueOf(kd.w()));
            if (dVar == null) {
                map.put(Long.valueOf(kd.w()), new d(kd));
            } else {
                dVar.xj(kd.u());
                dVar.w(kd.y());
            }
        }
    }

    public void xj() {
        this.p = true;
        this.d = true;
    }
}
