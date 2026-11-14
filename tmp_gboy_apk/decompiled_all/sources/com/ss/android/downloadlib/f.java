package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f {
    private static volatile f xj;
    private long y;
    private final List<com.ss.android.downloadlib.addownload.c> w = new CopyOnWriteArrayList();
    private final Map<String, com.ss.android.downloadlib.addownload.c> u = new ConcurrentHashMap();
    private final CopyOnWriteArrayList<Object> kd = new CopyOnWriteArrayList<>();
    private final Handler hf = new Handler(Looper.getMainLooper());

    private f() {
    }

    private synchronized void hf(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (this.w.size() <= 0) {
            w(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        com.ss.android.downloadlib.addownload.c remove = this.w.remove(0);
        remove.hf(context).hf(i, downloadStatusChangeListener).hf(downloadModel).xj();
        this.u.put(downloadModel.getDownloadUrl(), remove);
    }

    private void u() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.c cVar : this.w) {
            if (!cVar.hf() && currentTimeMillis - cVar.u() > 300000) {
                cVar.f();
                arrayList.add(cVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.w.removeAll(arrayList);
    }

    private void w(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.kd kdVar = new com.ss.android.downloadlib.addownload.kd();
        kdVar.hf(context).hf(i, downloadStatusChangeListener).hf(downloadModel).xj();
        this.u.put(downloadModel.getDownloadUrl(), kdVar);
    }

    public static f xj() {
        if (xj == null) {
            synchronized (f.class) {
                try {
                    if (xj == null) {
                        xj = new f();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    private void w() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.y < 300000) {
            return;
        }
        this.y = currentTimeMillis;
        if (this.w.isEmpty()) {
            return;
        }
        u();
    }

    public void xj(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        com.ss.android.downloadlib.addownload.c cVar;
        Context context2;
        DownloadStatusChangeListener downloadStatusChangeListener2;
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        boolean z = pl.d().optInt("filter_download_url_key", 0) == 1;
        String xj2 = com.ss.android.downloadlib.addownload.y.xj().xj(downloadModel.getDownloadUrl());
        if (z && !TextUtils.isEmpty(xj2)) {
            cVar = this.u.get(xj2);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel.getTaskKey())) {
                    adDownloadModel.setTaskKey(xj2);
                }
            }
        } else {
            cVar = this.u.get(downloadModel.getDownloadUrl());
        }
        if (cVar != null) {
            cVar.hf(context).hf(i, downloadStatusChangeListener).hf(downloadModel).xj();
            return;
        }
        if (!this.w.isEmpty()) {
            if (z) {
                if (!TextUtils.isEmpty(xj2)) {
                    xj(context, i, downloadStatusChangeListener, downloadModel, xj2);
                    return;
                }
                String xj3 = com.ss.android.downloadlib.addownload.y.xj().xj(downloadModel);
                if (TextUtils.isEmpty(xj3)) {
                    hf(context, i, downloadStatusChangeListener, downloadModel);
                    return;
                }
                xj(context, i, downloadStatusChangeListener, downloadModel, xj3);
                if (downloadModel instanceof AdDownloadModel) {
                    AdDownloadModel adDownloadModel2 = (AdDownloadModel) downloadModel;
                    if (TextUtils.isEmpty(adDownloadModel2.getTaskKey())) {
                        adDownloadModel2.setTaskKey(xj3);
                        return;
                    }
                    return;
                }
                return;
            }
            hf(context, i, downloadStatusChangeListener, downloadModel);
            return;
        }
        if (!z) {
            context2 = context;
            downloadStatusChangeListener2 = downloadStatusChangeListener;
        } else {
            if (!TextUtils.isEmpty(xj2)) {
                hf(context, i, downloadStatusChangeListener, downloadModel, xj2);
                return;
            }
            context2 = context;
            downloadStatusChangeListener2 = downloadStatusChangeListener;
            String xj4 = com.ss.android.downloadlib.addownload.y.xj().xj(downloadModel);
            if (!TextUtils.isEmpty(xj4)) {
                hf(context2, i, downloadStatusChangeListener2, downloadModel, xj4);
                if (downloadModel instanceof AdDownloadModel) {
                    AdDownloadModel adDownloadModel3 = (AdDownloadModel) downloadModel;
                    if (TextUtils.isEmpty(adDownloadModel3.getTaskKey())) {
                        adDownloadModel3.setTaskKey(xj4);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        w(context2, i, downloadStatusChangeListener2, downloadModel);
    }

    private void hf(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.kd kdVar = new com.ss.android.downloadlib.addownload.kd();
        kdVar.hf(context).hf(i, downloadStatusChangeListener).hf(downloadModel).xj(str).xj();
        this.u.put(str, kdVar);
        com.ss.android.downloadlib.addownload.y.xj().xj(str, downloadModel.getDownloadUrl());
    }

    public void hf(final DownloadInfo downloadInfo, final String str) {
        this.hf.post(new Runnable() { // from class: com.ss.android.downloadlib.f.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = f.this.kd.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.xj.xj) {
                        ((com.ss.android.download.api.download.xj.xj) next).xj(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.xj.xj) {
                            ((com.ss.android.download.api.download.xj.xj) softReference.get()).xj(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public Handler hf() {
        return this.hf;
    }

    public com.ss.android.downloadlib.addownload.kd xj(String str) {
        com.ss.android.downloadlib.addownload.c cVar;
        Map<String, com.ss.android.downloadlib.addownload.c> map = this.u;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            if (pl.d().optInt("filter_download_url_key", 0) == 1) {
                cVar = this.u.get(com.ss.android.downloadlib.addownload.y.xj().xj(str));
            } else {
                cVar = this.u.get(str);
            }
            if (cVar instanceof com.ss.android.downloadlib.addownload.kd) {
                return (com.ss.android.downloadlib.addownload.kd) cVar;
            }
        }
        return null;
    }

    private synchronized void xj(Context context, int i, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        try {
            try {
                if (this.w.size() <= 0) {
                    hf(context, i, downloadStatusChangeListener, downloadModel, str);
                    return;
                }
                com.ss.android.downloadlib.addownload.c remove = this.w.remove(0);
                remove.hf(context).hf(i, downloadStatusChangeListener).hf(downloadModel).xj(str).xj();
                this.u.put(str, remove);
                com.ss.android.downloadlib.addownload.y.xj().xj(str, downloadModel.getDownloadUrl());
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public void xj(String str, int i) {
        com.ss.android.downloadlib.addownload.c cVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = pl.d().optInt("filter_download_url_key", 0) == 1;
        String xj2 = com.ss.android.downloadlib.addownload.y.xj().xj(str);
        if (z && !TextUtils.isEmpty(xj2)) {
            cVar = this.u.get(xj2);
        } else {
            cVar = this.u.get(str);
        }
        if (cVar != null) {
            if (cVar.xj(i)) {
                this.w.add(cVar);
                if (z && !TextUtils.isEmpty(xj2)) {
                    this.u.remove(xj2);
                    com.ss.android.downloadlib.addownload.y.xj().hf(xj2);
                } else {
                    this.u.remove(str);
                }
            }
            w();
        }
    }

    public void xj(String str, boolean z) {
        com.ss.android.downloadlib.addownload.c cVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = pl.d().optInt("filter_download_url_key", 0) == 1;
        String xj2 = com.ss.android.downloadlib.addownload.y.xj().xj(str);
        if (z2 && !TextUtils.isEmpty(xj2)) {
            cVar = this.u.get(xj2);
        } else {
            cVar = this.u.get(str);
        }
        if (cVar != null) {
            cVar.xj(z);
        }
    }

    public void xj(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        xj(str, j, i, downloadEventConfig, downloadController, null, null);
    }

    public void xj(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        xj(str, j, i, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void xj(String str, long j, int i, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.addownload.c cVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = pl.d().optInt("filter_download_url_key", 0) == 1;
        String xj2 = com.ss.android.downloadlib.addownload.y.xj().xj(str);
        if (z && !TextUtils.isEmpty(xj2)) {
            cVar = this.u.get(xj2);
        } else {
            cVar = this.u.get(str);
        }
        if (cVar != null) {
            cVar.xj(j).hf(downloadEventConfig).hf(downloadController).xj(onItemClickListener).xj(iDownloadButtonClickListener).hf(i);
        }
    }

    public void xj(com.ss.android.download.api.download.xj.xj xjVar) {
        if (xjVar != null) {
            if (com.ss.android.socialbase.downloader.f.xj.w().hf("fix_listener_oom", false)) {
                this.kd.add(new SoftReference(xjVar));
            } else {
                this.kd.add(xjVar);
            }
        }
    }

    public void xj(final DownloadModel downloadModel, final DownloadController downloadController, final DownloadEventConfig downloadEventConfig) {
        this.hf.post(new Runnable() { // from class: com.ss.android.downloadlib.f.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = f.this.kd.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!(next instanceof com.ss.android.download.api.download.xj.xj) && (next instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.xj.xj) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void xj(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.hf.post(new Runnable() { // from class: com.ss.android.downloadlib.f.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = f.this.kd.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!(next instanceof com.ss.android.download.api.download.xj.xj) && (next instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.xj.xj) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void xj(final DownloadInfo downloadInfo, final String str) {
        this.hf.post(new Runnable() { // from class: com.ss.android.downloadlib.f.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = f.this.kd.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!(next instanceof com.ss.android.download.api.download.xj.xj) && (next instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.xj.xj) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }

    public void xj(final DownloadInfo downloadInfo) {
        this.hf.post(new Runnable() { // from class: com.ss.android.downloadlib.f.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = f.this.kd.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!(next instanceof com.ss.android.download.api.download.xj.xj) && (next instanceof SoftReference)) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.xj.xj) {
                            softReference.get();
                        }
                    }
                }
            }
        });
    }
}
