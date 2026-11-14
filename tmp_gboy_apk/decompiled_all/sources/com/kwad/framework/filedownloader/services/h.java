package com.kwad.framework.filedownloader.services;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class h {
    private ThreadPoolExecutor atC;
    private int atE;
    private SparseArray<DownloadLaunchRunnable> atB = new SparseArray<>();
    private final String atD = "Network";
    private int atF = 0;

    public h(int i) {
        this.atC = com.kwad.framework.filedownloader.f.b.u(i, "Network");
        this.atE = i;
    }

    private synchronized void AX() {
        try {
            SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
            int size = this.atB.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.atB.keyAt(i);
                DownloadLaunchRunnable downloadLaunchRunnable = this.atB.get(keyAt);
                if (downloadLaunchRunnable.isAlive()) {
                    sparseArray.put(keyAt, downloadLaunchRunnable);
                }
            }
            this.atB = sparseArray;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized int AY() {
        AX();
        return this.atB.size();
    }

    public final synchronized List<Integer> AZ() {
        ArrayList arrayList;
        AX();
        arrayList = new ArrayList();
        for (int i = 0; i < this.atB.size(); i++) {
            SparseArray<DownloadLaunchRunnable> sparseArray = this.atB;
            arrayList.add(Integer.valueOf(sparseArray.get(sparseArray.keyAt(i)).getId()));
        }
        return arrayList;
    }

    public final void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        downloadLaunchRunnable.zQ();
        synchronized (this) {
            this.atB.put(downloadLaunchRunnable.getId(), downloadLaunchRunnable);
        }
        this.atC.execute(downloadLaunchRunnable);
        int i = this.atF;
        if (i < 600) {
            this.atF = i + 1;
        } else {
            AX();
            this.atF = 0;
        }
    }

    public final void cancel(int i) {
        AX();
        synchronized (this) {
            try {
                DownloadLaunchRunnable downloadLaunchRunnable = this.atB.get(i);
                if (downloadLaunchRunnable != null) {
                    downloadLaunchRunnable.pause();
                    boolean remove = this.atC.remove(downloadLaunchRunnable);
                    if (com.kwad.framework.filedownloader.f.d.atL) {
                        com.kwad.framework.filedownloader.f.d.c(this, "successful cancel %d %B", Integer.valueOf(i), Boolean.valueOf(remove));
                    }
                }
                this.atB.remove(i);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized boolean ci(int i) {
        if (AY() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int cw = com.kwad.framework.filedownloader.f.e.cw(i);
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.atE), Integer.valueOf(cw));
        }
        List<Runnable> shutdownNow = this.atC.shutdownNow();
        this.atC = com.kwad.framework.filedownloader.f.b.u(cw, "Network");
        if (shutdownNow.size() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        this.atE = cw;
        return true;
    }

    public final boolean cv(int i) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.atB.get(i);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.isAlive();
    }

    public final int p(String str, int i) {
        if (str == null) {
            return 0;
        }
        int size = this.atB.size();
        for (int i2 = 0; i2 < size; i2++) {
            DownloadLaunchRunnable valueAt = this.atB.valueAt(i2);
            if (valueAt != null && valueAt.isAlive() && valueAt.getId() != i && str.equals(valueAt.zV())) {
                return valueAt.getId();
            }
        }
        return 0;
    }
}
