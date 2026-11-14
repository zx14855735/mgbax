package com.ss.android.socialbase.downloader.d;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u {
    private static ExecutorService xj = new com.bytedance.sdk.component.tf.u.u(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new xj("Download_OP_Thread"));
    private int w = 0;
    private volatile SparseArray<w> hf = new SparseArray<>();

    static {
        yPHc();
    }

    private void hf() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.hf.size(); i++) {
                int keyAt = this.hf.keyAt(i);
                if (!this.hf.get(keyAt).u()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    Integer num = (Integer) arrayList.get(i2);
                    if (num != null) {
                        this.hf.remove(num.intValue());
                    }
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        } catch (Throwable th2) {
            pl.xj(th2);
        }
    }

    public static void xj(Runnable runnable) {
        xj.execute(runnable);
    }

    private static /* synthetic */ void yPHc() {
        char[] charArray = "ïãá¢ëíáé¢îãõ¢ÿäéàà¢ÆâåÎþåèëé".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 140);
        }
        String str = new String(charArray);
        char[] charArray2 = "ïàåâåø".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 140);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void w(int i) {
        synchronized (u.class) {
            try {
                hf();
                w wVar = this.hf.get(i);
                if (wVar != null) {
                    wVar.xj();
                    w(wVar);
                    this.hf.remove(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void xj(w wVar) {
        wVar.y();
        synchronized (u.class) {
            try {
                int i = this.w;
                if (i >= 500) {
                    hf();
                    this.w = 0;
                } else {
                    this.w = i + 1;
                }
                this.hf.put(wVar.kd(), wVar);
            } finally {
            }
        }
        DownloadTask w = wVar.w();
        try {
            ExecutorService zg = com.ss.android.socialbase.downloader.downloader.w.zg();
            if (w != null && w.getDownloadInfo() != null) {
                if ("mime_type_plg".equals(w.getDownloadInfo().getMimeType()) && com.ss.android.socialbase.downloader.f.xj.w().xj("divide_plugin", 1) == 1) {
                    w.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                }
                int executorGroup = w.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    zg = com.ss.android.socialbase.downloader.downloader.w.am();
                } else if (executorGroup == 4) {
                    zg = com.ss.android.socialbase.downloader.downloader.w.qt();
                }
            }
            if (zg == null) {
                com.ss.android.socialbase.downloader.u.xj.xj(w.getMonitorDepend(), w.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), w.getDownloadInfo() != null ? w.getDownloadInfo().getStatus() : 0);
            } else if (com.ss.android.socialbase.downloader.f.xj.xj(wVar.kd()).hf("pause_with_interrupt", false)) {
                wVar.xj(zg.submit(wVar));
            } else {
                zg.execute(wVar);
            }
        } catch (Exception e) {
            if (w != null) {
                com.ss.android.socialbase.downloader.u.xj.xj(w.getMonitorDepend(), w.getDownloadInfo(), new BaseException(1003, com.ss.android.socialbase.downloader.tf.y.hf(e, "DownloadThreadPoolExecute")), w.getDownloadInfo() != null ? w.getDownloadInfo().getStatus() : 0);
            }
            pl.xj(e);
        } catch (OutOfMemoryError e2) {
            if (w != null) {
                com.ss.android.socialbase.downloader.u.xj.xj(w.getMonitorDepend(), w.getDownloadInfo(), new BaseException(1003, "execute OOM"), w.getDownloadInfo() != null ? w.getDownloadInfo().getStatus() : 0);
            }
            pl.xj(e2);
        }
    }

    private void w(w wVar) {
        Future c;
        if (wVar == null) {
            return;
        }
        try {
            ExecutorService zg = com.ss.android.socialbase.downloader.downloader.w.zg();
            DownloadTask w = wVar.w();
            if (w != null && w.getDownloadInfo() != null) {
                int executorGroup = w.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    zg = com.ss.android.socialbase.downloader.downloader.w.am();
                } else if (executorGroup == 4) {
                    zg = com.ss.android.socialbase.downloader.downloader.w.qt();
                }
            }
            if (zg == null || !(zg instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) zg).remove(wVar);
            if (!com.ss.android.socialbase.downloader.f.xj.xj(wVar.kd()).hf("pause_with_interrupt", false) || (c = wVar.c()) == null) {
                return;
            }
            c.cancel(true);
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public void hf(w wVar) {
        if (wVar == null) {
            return;
        }
        synchronized (u.class) {
            try {
                if (com.ss.android.socialbase.downloader.tf.xj.xj(524288)) {
                    int indexOfValue = this.hf.indexOfValue(wVar);
                    if (indexOfValue >= 0) {
                        this.hf.removeAt(indexOfValue);
                    }
                } else {
                    this.hf.remove(wVar.kd());
                }
            } finally {
            }
        }
    }

    public w hf(int i) {
        synchronized (u.class) {
            try {
                hf();
                w wVar = this.hf.get(i);
                if (wVar == null) {
                    return null;
                }
                wVar.hf();
                w(wVar);
                this.hf.remove(i);
                return wVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean xj(int i) {
        synchronized (u.class) {
            try {
                boolean z = false;
                if (this.hf != null && this.hf.size() > 0) {
                    w wVar = this.hf.get(i);
                    if (wVar != null && wVar.u()) {
                        z = true;
                    }
                    return z;
                }
                return false;
            } finally {
            }
        }
    }

    public List<Integer> xj() {
        ArrayList arrayList;
        synchronized (u.class) {
            try {
                hf();
                arrayList = new ArrayList();
                for (int i = 0; i < this.hf.size(); i++) {
                    w wVar = this.hf.get(this.hf.keyAt(i));
                    if (wVar != null) {
                        arrayList.add(Integer.valueOf(wVar.kd()));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public void xj(int i, long j) {
        this.hf.get(i);
    }
}
