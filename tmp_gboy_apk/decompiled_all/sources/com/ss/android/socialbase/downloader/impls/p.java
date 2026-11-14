package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class p implements com.ss.android.socialbase.downloader.downloader.tf {
    private final SparseArray<DownloadInfo> xj = new SparseArray<>();
    private final SparseArray<List<com.ss.android.socialbase.downloader.model.hf>> hf = new SparseArray<>();
    private final SparseArray<Map<Long, com.ss.android.socialbase.downloader.y.d>> w = new SparseArray<>();

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized List<com.ss.android.socialbase.downloader.y.d> am(int i) {
        Map<Long, com.ss.android.socialbase.downloader.y.d> map = this.w.get(i);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo c(int i) {
        DownloadInfo hf = hf(i);
        if (hf != null) {
            hf.setStatus(2);
        }
        return hf;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo d(int i) {
        DownloadInfo hf = hf(i);
        if (hf != null) {
            hf.setStatus(1);
        }
        return hf;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo f(int i) {
        DownloadInfo hf = hf(i);
        if (hf != null) {
            hf.setStatus(5);
            hf.setFirstDownload(false);
        }
        return hf;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized void g(int i) {
        this.w.remove(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void hf(int i, List<com.ss.android.socialbase.downloader.model.hf> list) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public boolean kd() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized Map<Long, com.ss.android.socialbase.downloader.y.d> pl(int i) {
        return this.w.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo tf(int i) {
        DownloadInfo hf = hf(i);
        if (hf != null) {
            hf.setStatus(-7);
        }
        return hf;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public boolean u() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized List<DownloadInfo> w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.xj.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.xj.size(); i++) {
            DownloadInfo downloadInfo = this.xj.get(this.xj.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void xj(int i, int i2, int i3, int i4) {
    }

    public SparseArray<List<com.ss.android.socialbase.downloader.model.hf>> y() {
        return this.hf;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void hf(com.ss.android.socialbase.downloader.model.hf hfVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized boolean kd(int i) {
        this.xj.remove(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized List<DownloadInfo> u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.xj.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.xj.size(); i++) {
            DownloadInfo downloadInfo = this.xj.get(this.xj.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    public SparseArray<DownloadInfo> xj() {
        return this.xj;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public boolean y(int i) {
        kd(i);
        u(i);
        g(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized DownloadInfo hf(int i) {
        DownloadInfo downloadInfo;
        try {
            downloadInfo = this.xj.get(i);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            downloadInfo = null;
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized List<DownloadInfo> xj(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.xj.size();
            for (int i = 0; i < size; i++) {
                DownloadInfo valueAt = this.xj.valueAt(i);
                if (str != null && str.equals(valueAt.getUrl())) {
                    arrayList.add(valueAt);
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized List<DownloadInfo> hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.xj.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.xj.size(); i++) {
            DownloadInfo downloadInfo = this.xj.get(this.xj.keyAt(i));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void xj(com.ss.android.socialbase.downloader.model.hf hfVar) {
        int p = hfVar.p();
        List<com.ss.android.socialbase.downloader.model.hf> list = this.hf.get(p);
        if (list == null) {
            list = new ArrayList<>();
            this.hf.put(p, list);
        }
        list.add(hfVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized List<com.ss.android.socialbase.downloader.model.hf> w(int i) {
        return this.hf.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized void u(int i) {
        this.hf.remove(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized void w() {
        this.xj.clear();
        this.hf.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized void xj(int i, int i2, long j) {
        List<com.ss.android.socialbase.downloader.model.hf> w = w(i);
        if (w == null) {
            return;
        }
        for (com.ss.android.socialbase.downloader.model.hf hfVar : w) {
            if (hfVar != null && hfVar.v() == i2) {
                hfVar.hf(j);
                return;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo u(int i, long j) {
        DownloadInfo hf = hf(i);
        if (hf != null) {
            hf.setCurBytes(j, false);
            hf.setStatus(-2);
        }
        return hf;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo w(int i, long j) {
        DownloadInfo hf = hf(i);
        if (hf != null) {
            hf.setCurBytes(j, false);
            hf.setStatus(-3);
            hf.setFirstDownload(false);
            hf.setFirstSuccess(false);
        }
        return hf;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized List<DownloadInfo> hf() {
        if (this.xj.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.xj.size());
        for (int i = 0; i < this.xj.size(); i++) {
            DownloadInfo valueAt = this.xj.valueAt(i);
            if (valueAt != null) {
                arrayList.add(valueAt);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002b, code lost:
    
        if (r0.c() == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        r3 = r0.c().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        if (r3.hasNext() == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003b, code lost:
    
        r5 = r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
    
        if (r5 == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r5.v() != r4) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0049, code lost:
    
        r5.hf(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0051, code lost:
    
        return;
     */
    @Override // com.ss.android.socialbase.downloader.downloader.tf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void xj(int r3, int r4, int r5, long r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.w(r3)     // Catch: java.lang.Throwable -> L4e
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4e
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto L52
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L4e
            com.ss.android.socialbase.downloader.model.hf r0 = (com.ss.android.socialbase.downloader.model.hf) r0     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto Ld
            int r1 = r0.v()     // Catch: java.lang.Throwable -> L4e
            if (r1 != r5) goto Ld
            boolean r1 = r0.y()     // Catch: java.lang.Throwable -> L4e
            if (r1 != 0) goto Ld
            java.util.List r3 = r0.c()     // Catch: java.lang.Throwable -> L4e
            if (r3 == 0) goto L52
            java.util.List r3 = r0.c()     // Catch: java.lang.Throwable -> L4e
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4e
        L35:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L50
            java.lang.Object r5 = r3.next()     // Catch: java.lang.Throwable -> L4e
            com.ss.android.socialbase.downloader.model.hf r5 = (com.ss.android.socialbase.downloader.model.hf) r5     // Catch: java.lang.Throwable -> L4e
            if (r5 == 0) goto L35
            int r0 = r5.v()     // Catch: java.lang.Throwable -> L4e
            if (r0 != r4) goto L35
            r5.hf(r6)     // Catch: java.lang.Throwable -> L4e
            monitor-exit(r2)
            return
        L4e:
            r3 = move-exception
            goto L54
        L50:
            monitor-exit(r2)
            return
        L52:
            monitor-exit(r2)
            return
        L54:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L4e
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.p.xj(int, int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo hf(int i, long j) {
        DownloadInfo hf = hf(i);
        if (hf != null) {
            hf.setCurBytes(j, false);
            hf.setStatus(-1);
            hf.setFirstDownload(false);
        }
        return hf;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public void hf(DownloadInfo downloadInfo) {
        xj(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized DownloadInfo xj(int i, int i2) {
        DownloadInfo hf;
        hf = hf(i);
        if (hf != null) {
            hf.setChunkCount(i2);
        }
        return hf;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized boolean xj(DownloadInfo downloadInfo) {
        boolean z = true;
        if (downloadInfo == null) {
            return true;
        }
        if (this.xj.get(downloadInfo.getId()) == null) {
            z = false;
        }
        this.xj.put(downloadInfo.getId(), downloadInfo);
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo xj(int i, long j, String str, String str2) {
        DownloadInfo hf = hf(i);
        if (hf != null) {
            hf.setTotalBytes(j);
            hf.seteTag(str);
            if (TextUtils.isEmpty(hf.getName()) && !TextUtils.isEmpty(str2)) {
                hf.setName(str2);
            }
            hf.setStatus(3);
        }
        return hf;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public DownloadInfo xj(int i, long j) {
        DownloadInfo hf = hf(i);
        if (hf != null) {
            hf.setCurBytes(j, false);
            if (hf.getStatus() != -3 && hf.getStatus() != -2 && !DownloadStatus.isFailedStatus(hf.getStatus()) && hf.getStatus() != -4) {
                hf.setStatus(4);
            }
        }
        return hf;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized void xj(int i, List<com.ss.android.socialbase.downloader.model.hf> list) {
        if (list == null) {
            return;
        }
        u(i);
        for (com.ss.android.socialbase.downloader.model.hf hfVar : list) {
            if (hfVar != null) {
                xj(hfVar);
                if (hfVar.y()) {
                    Iterator<com.ss.android.socialbase.downloader.model.hf> it = hfVar.c().iterator();
                    while (it.hasNext()) {
                        xj(it.next());
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.tf
    public synchronized boolean xj(int i, Map<Long, com.ss.android.socialbase.downloader.y.d> map) {
        this.w.put(i, map);
        return false;
    }
}
