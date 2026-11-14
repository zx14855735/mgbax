package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class kd extends xj {
    private static com.ss.android.socialbase.downloader.d.u hf;

    public kd() {
        hf = new com.ss.android.socialbase.downloader.d.u();
    }

    public static Runnable kd(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService e = com.ss.android.socialbase.downloader.downloader.w.e();
                if ((e instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) e).getQueue()) != null && !queue.isEmpty()) {
                    Iterator<Future> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            runnable = null;
                            break;
                        }
                        Future next = it.next();
                        if ((next instanceof Runnable) && queue.remove(next)) {
                            runnable = (Runnable) next;
                            break;
                        }
                    }
                    if (runnable != null) {
                        list.remove(runnable);
                        return runnable;
                    }
                }
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.w.xj.u("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    public static List<Future> u(List<Runnable> list) {
        ExecutorService e = com.ss.android.socialbase.downloader.downloader.w.e();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(e.submit(it.next()));
        }
        return arrayList;
    }

    public static void w(List<Callable<Object>> list) {
        ExecutorService e = com.ss.android.socialbase.downloader.downloader.w.e();
        if (e != null) {
            e.invokeAll(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.xj
    public void hf(int i) {
        com.ss.android.socialbase.downloader.d.u uVar = hf;
        if (uVar == null) {
            return;
        }
        uVar.w(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.xj
    public boolean xj(int i) {
        DownloadInfo u;
        com.ss.android.socialbase.downloader.d.u uVar = hf;
        if (uVar == null || !uVar.xj(i) || (u = u(i)) == null) {
            return false;
        }
        if (DownloadStatus.isDownloading(u.getStatus())) {
            return true;
        }
        hf(i);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.xj
    public com.ss.android.socialbase.downloader.d.w w(int i) {
        com.ss.android.socialbase.downloader.d.u uVar = hf;
        if (uVar == null) {
            return null;
        }
        return uVar.hf(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.xj
    public void xj(com.ss.android.socialbase.downloader.d.w wVar) {
        com.ss.android.socialbase.downloader.d.u uVar = hf;
        if (uVar == null) {
            return;
        }
        uVar.hf(wVar);
    }

    @Override // com.ss.android.socialbase.downloader.impls.xj
    public void xj(int i, DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.w.xj.hf("DownloadTask", "start doDownload for task : ".concat(String.valueOf(i)));
        hf.xj(new com.ss.android.socialbase.downloader.d.w(downloadTask, this.xj));
    }

    @Override // com.ss.android.socialbase.downloader.impls.xj
    public List<Integer> xj() {
        return hf.xj();
    }

    @Override // com.ss.android.socialbase.downloader.impls.xj
    public void xj(int i, long j) {
        com.ss.android.socialbase.downloader.d.u uVar = hf;
        if (uVar == null) {
            return;
        }
        uVar.xj(i, j);
    }
}
