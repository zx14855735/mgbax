package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf {
    private String globalDefaultSavePath;
    private String globalDefaultSaveTempPath;

    public static DownloadTask with(Context context) {
        Downloader.getInstance(context);
        return new DownloadTask();
    }

    public void addMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        u.xj().hf(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.y.MAIN, false);
    }

    public void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        u.xj().hf(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.y.NOTIFICATION, false);
    }

    public void addSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        u.xj().hf(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.y.SUB, false);
    }

    public boolean canResume(int i) {
        return u.xj().kd(i);
    }

    public void cancel(int i) {
        cancel(i, true);
    }

    public void clearDownloadData(int i) {
        u.xj().u(i, true);
    }

    public void destoryDownloader() {
        w.xj();
    }

    public void forceDownloadIngoreRecommendSize(int i) {
        u.xj().am(i);
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        return u.xj().kd();
    }

    public long getCurBytes(int i) {
        return u.xj().f(i);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return u.xj().yo(i);
    }

    public int getDownloadId(String str, String str2) {
        return u.xj().xj(str, str2);
    }

    public DownloadInfo getDownloadInfo(int i) {
        return u.xj().p(i);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        return u.xj().xj(str);
    }

    public io getDownloadNotificationEventListener(int i) {
        return u.xj().pl(i);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return u.xj().kd(str);
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return u.xj().hf(str);
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath, true);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath, false);
    }

    public yo getReserveWifiStatusListener() {
        return w.hl();
    }

    public int getStatus(int i) {
        return u.xj().d(i);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return u.xj().w(str);
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return u.xj().u(str);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return u.xj().y();
    }

    public boolean isDownloadServiceForeground(int i) {
        return u.xj().w(i).hf();
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return u.xj().xj(downloadInfo);
    }

    public boolean isDownloading(int i) {
        boolean tf;
        if (!com.ss.android.socialbase.downloader.tf.xj.xj(4194304)) {
            return u.xj().tf(i);
        }
        synchronized (this) {
            tf = u.xj().tf(i);
        }
        return tf;
    }

    public boolean isHttpServiceInit() {
        return u.xj().u();
    }

    public void pause(int i) {
        u.xj().u(i);
    }

    public void pauseAll() {
        u.xj().w();
    }

    public void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.p pVar) {
        u.xj().xj(pVar);
    }

    public void registerDownloaderProcessConnectedListener(ai aiVar) {
        u.xj().xj(aiVar);
    }

    public void removeMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        u.xj().xj(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.y.MAIN, false);
    }

    public void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        u.xj().xj(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.y.NOTIFICATION, false);
    }

    public void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        u.xj().xj(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.y.SUB, false);
    }

    @Deprecated
    public void removeTaskMainListener(int i) {
        u.xj().xj(i, null, com.ss.android.socialbase.downloader.constants.y.MAIN, true);
    }

    @Deprecated
    public void removeTaskNotificationListener(int i) {
        u.xj().xj(i, null, com.ss.android.socialbase.downloader.constants.y.NOTIFICATION, true);
    }

    @Deprecated
    public void removeTaskSubListener(int i) {
        u.xj().xj(i, null, com.ss.android.socialbase.downloader.constants.y.SUB, true);
    }

    public void restart(int i) {
        u.xj().c(i);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        u.xj().xj(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        u.xj().hf(list);
    }

    public void resume(int i) {
        u.xj().y(i);
    }

    public void setDefaultSavePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSavePath = str;
    }

    public void setDefaultSaveTempPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSaveTempPath = str;
    }

    public void setDownloadInMultiProcess() {
        if (!com.ss.android.socialbase.downloader.tf.xj.xj(4194304)) {
            w.hf();
        } else {
            synchronized (this) {
                w.hf();
            }
        }
    }

    public void setDownloadNotificationEventListener(int i, io ioVar) {
        u.xj().xj(i, ioVar);
    }

    public void setLogLevel(int i) {
        u.xj().zg(i);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        u.xj().hf(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.y.MAIN, true);
    }

    @Deprecated
    public void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        u.xj().hf(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.y.NOTIFICATION, true);
    }

    public void setReserveWifiStatusListener(yo yoVar) {
        w.xj(yoVar);
    }

    @Deprecated
    public void setSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        u.xj().hf(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.y.SUB, true);
    }

    public void setThrottleNetSpeed(int i, long j) {
        u.xj().xj(i, j);
    }

    public void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.p pVar) {
        u.xj().hf(pVar);
    }

    public void unRegisterDownloaderProcessConnectedListener(ai aiVar) {
        u.xj().hf(aiVar);
    }

    private File getGlobalSaveDir(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file = new File(str);
            try {
                if (!file.exists()) {
                    file.mkdirs();
                    return file;
                }
                if (file.isDirectory()) {
                    return file;
                }
                if (!z) {
                    return null;
                }
                file.delete();
                file.mkdirs();
                return file;
            } catch (Throwable unused) {
                return file;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void cancel(int i, boolean z) {
        u.xj().w(i, z);
    }

    public void clearDownloadData(int i, boolean z) {
        u.xj().u(i, z);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return u.xj().hf(str, str2);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener == null) {
            return;
        }
        u.xj().xj(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.y.MAIN, true, z);
    }
}
