package com.ss.android.socialbase.downloader.d;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.kuaishou.weapon.p0.g;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.dk;
import com.ss.android.socialbase.downloader.depend.ra;
import com.ss.android.socialbase.downloader.depend.yo;
import com.ss.android.socialbase.downloader.downloader.tf;
import com.ss.android.socialbase.downloader.downloader.v;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.hf;
import com.ss.android.socialbase.downloader.network.d;
import com.ss.android.socialbase.downloader.y.am;
import com.ss.android.socialbase.downloader.y.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w implements y, Runnable {
    private static final String xj = "w";

    /* renamed from: a, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.f.xj f13842a;
    private volatile com.ss.android.socialbase.downloader.downloader.kd c;
    private boolean d;
    private d dk;
    private com.ss.android.socialbase.downloader.downloader.f e;
    private com.ss.android.socialbase.downloader.network.c et;
    private boolean f;
    private long ff;
    private final AtomicBoolean g;
    private Future hf;
    private final com.ss.android.socialbase.downloader.downloader.y ht;

    /* renamed from: io, reason: collision with root package name */
    private ra f13843io;
    private String j;
    private final com.ss.android.socialbase.downloader.downloader.c jk;
    private AtomicInteger kd;
    private long l;
    private boolean p;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f13844pl;
    private v pz;
    private final tf qt;
    private volatile BaseException ra;
    private boolean tf;
    private com.ss.android.socialbase.downloader.downloader.c v;
    private final DownloadTask w;
    private yo x;
    private final com.ss.android.socialbase.downloader.downloader.f yo;
    private DownloadInfo zg;
    private volatile boolean u = false;
    private final ArrayList<hf> y = new ArrayList<>();
    private volatile com.ss.android.socialbase.downloader.constants.f am = com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_NONE;
    private volatile int ai = 5;
    private boolean q = false;
    private boolean z = false;
    private boolean en = false;
    private int wo = 0;
    private volatile p r = null;

    public w(DownloadTask downloadTask, Handler handler) {
        this.w = downloadTask;
        if (downloadTask != null) {
            this.zg = downloadTask.getDownloadInfo();
            this.e = downloadTask.getChunkStrategy();
            this.v = downloadTask.getChunkAdjustCalculator();
            this.f13843io = downloadTask.getForbiddenHandler();
            this.x = downloadTask.getDiskSpaceHandler();
            this.pz = xj(downloadTask);
            this.f13842a = com.ss.android.socialbase.downloader.f.xj.xj(this.zg.getId());
        } else {
            this.f13842a = com.ss.android.socialbase.downloader.f.xj.w();
        }
        f();
        this.qt = com.ss.android.socialbase.downloader.downloader.w.et();
        this.yo = com.ss.android.socialbase.downloader.downloader.w.wo();
        this.jk = com.ss.android.socialbase.downloader.downloader.w.b();
        this.ht = new com.ss.android.socialbase.downloader.downloader.y(downloadTask, handler);
        this.g = new AtomicBoolean(true);
    }

    private void a() {
        try {
            Iterator it = ((ArrayList) this.y.clone()).iterator();
            while (it.hasNext()) {
                hf hfVar = (hf) it.next();
                if (hfVar != null) {
                    hfVar.hf();
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.w.xj.w(xj, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    private void ai() {
        com.ss.android.socialbase.downloader.impls.xj z;
        int id = this.zg.getId();
        int xj2 = com.ss.android.socialbase.downloader.downloader.w.xj(this.zg);
        if (this.zg.isDownloaded() && !this.zg.isExpiredRedownload() && !this.en) {
            throw new BaseException(1009, "file has downloaded");
        }
        DownloadInfo hf = this.qt.hf(xj2);
        if (hf == null || (z = com.ss.android.socialbase.downloader.downloader.w.z()) == null || hf.getId() == id || !hf.equalsTask(this.zg)) {
            return;
        }
        if (z.xj(hf.getId())) {
            this.qt.y(id);
            throw new BaseException(1025, "another same task is downloading");
        }
        List<com.ss.android.socialbase.downloader.model.hf> w = this.qt.w(xj2);
        com.ss.android.socialbase.downloader.tf.y.xj(this.zg);
        this.qt.y(xj2);
        if (hf.isBreakpointAvailable()) {
            this.zg.copyFromCacheData(hf, false);
            this.qt.xj(this.zg);
            if (w != null) {
                for (com.ss.android.socialbase.downloader.model.hf hfVar : w) {
                    hfVar.hf(id);
                    this.qt.xj(hfVar);
                }
            }
            throw new com.ss.android.socialbase.downloader.exception.d("retry task because id generator changed");
        }
    }

    private boolean am() {
        if (this.zg.isExpiredRedownload() || this.zg.getChunkCount() != 1 || this.zg.getThrottleNetSpeed() > 0) {
            return false;
        }
        JSONObject u = com.ss.android.socialbase.downloader.f.xj.xj(this.zg.getId()).u("segment_config");
        List<com.ss.android.socialbase.downloader.y.d> am = this.qt.am(this.zg.getId());
        if (this.zg.getCurBytes() > 0) {
            if (am == null || am.isEmpty()) {
                return false;
            }
            if (u == null) {
                u = new JSONObject();
            }
        }
        if (u == null) {
            return false;
        }
        this.r = new p(this.zg, am.xj(u), this);
        if (!ht()) {
            return this.r.xj(am);
        }
        com.ss.android.socialbase.downloader.w.xj.w(xj, "downloadSegments: is stopped by user");
        if (this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_CANCELED) {
            this.r.xj();
        } else {
            this.r.hf();
        }
        return true;
    }

    private boolean d() {
        int status = this.zg.getStatus();
        if (status == 1 || this.zg.canSkipStatusHandler()) {
            return true;
        }
        if (status == -2 || status == -4) {
            return false;
        }
        hf(new BaseException(1000, CtFAbx.ARc23Z(status, "The download Task can't start, because its status is not prepare:")));
        return false;
    }

    private boolean dk() {
        if (this.zg.getChunkCount() <= 1) {
            return this.zg.getCurBytes() > 0 && this.zg.getCurBytes() == this.zg.getTotalBytes();
        }
        List<com.ss.android.socialbase.downloader.model.hf> w = this.qt.w(this.zg.getId());
        if (w == null || w.size() <= 1) {
            return false;
        }
        for (com.ss.android.socialbase.downloader.model.hf hfVar : w) {
            if (hfVar == null || !hfVar.d()) {
                return false;
            }
        }
        return true;
    }

    private void e() {
        com.ss.android.socialbase.downloader.network.c cVar = this.et;
        if (cVar != null) {
            cVar.w();
            this.et = null;
        }
    }

    private void en() {
        if (TextUtils.isEmpty(this.zg.getSavePath())) {
            throw new BaseException(1028, "download savePath can not be empty");
        }
        if (TextUtils.isEmpty(this.zg.getName())) {
            throw new BaseException(1029, "download name can not be empty");
        }
        File file = new File(this.zg.getSavePath());
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!com.ss.android.socialbase.downloader.tf.u.hf(this.zg)) {
                throw new BaseException(1031, "download savePath is not a directory:" + this.zg.getSavePath());
            }
            file.delete();
            if (file.mkdirs() || file.exists()) {
                return;
            }
            throw new BaseException(1031, "download savePath is not directory:path=" + this.zg.getSavePath());
        }
        boolean mkdirs = file.mkdirs();
        if (mkdirs || file.exists()) {
            return;
        }
        int i = 0;
        if (com.ss.android.socialbase.downloader.f.xj.xj(this.zg.getId()).xj("opt_mkdir_failed", 0) != 1) {
            throw new BaseException(AVMDLDataLoader.KeyIsPreloadStragetyWhenPlay, "download savePath directory can not created:" + this.zg.getSavePath());
        }
        while (!mkdirs) {
            int i2 = i + 1;
            if (i >= 3) {
                break;
            }
            try {
                Thread.sleep(10L);
                mkdirs = file.mkdirs();
                i = i2;
            } catch (InterruptedException unused) {
            }
        }
        if (mkdirs || file.exists()) {
            return;
        }
        if (com.ss.android.socialbase.downloader.tf.y.u(this.zg.getSavePath()) < 16384) {
            throw new BaseException(PluginConstants.ERROR_PLUGIN_SIGN_VERIFY, "download savePath directory can not created:" + this.zg.getSavePath());
        }
        throw new BaseException(AVMDLDataLoader.KeyIsPreloadStragetyWhenPlay, "download savePath directory can not created:" + this.zg.getSavePath());
    }

    private boolean et() {
        if (this.zg.isChunked()) {
            DownloadInfo downloadInfo = this.zg;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        com.ss.android.socialbase.downloader.w.xj.w(xj, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.zg.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.zg.getTotalBytes());
        if (this.zg.getCurBytes() > 0) {
            if (this.zg.isIgnoreDataVerify()) {
                return true;
            }
            if (this.zg.getTotalBytes() > 0 && this.zg.getCurBytes() == this.zg.getTotalBytes()) {
                return true;
            }
        }
        this.zg.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.hf.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.zg.reset();
        this.qt.xj(this.zg);
        this.qt.u(this.zg.getId());
        this.qt.g(this.zg.getId());
        com.ss.android.socialbase.downloader.tf.y.xj(this.zg);
        return false;
    }

    private void f() {
        DownloadInfo downloadInfo = this.zg;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.zg.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.kd;
        if (atomicInteger == null) {
            this.kd = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    private void ff() {
        com.ss.android.socialbase.downloader.w.xj.u(xj, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.qt.u(this.zg.getId());
            this.qt.g(this.zg.getId());
            com.ss.android.socialbase.downloader.tf.y.xj(this.zg);
            this.d = false;
            this.zg.resetDataForEtagEndure("");
            this.qt.xj(this.zg);
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    private void g() {
        com.ss.android.socialbase.downloader.w.xj.hf(xj, "finishWithFileExist");
        if (com.ss.android.socialbase.downloader.f.xj.w().hf("fix_end_for_file_exist_error", true)) {
            if (this.j.equals(this.zg.getName())) {
                this.am = com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_END_RIGHT_NOW;
                return;
            } else {
                this.am = com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_END_FOR_FILE_EXIST;
                return;
            }
        }
        if (this.j.equals(this.zg.getTargetFilePath())) {
            this.am = com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.am = com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private boolean ht() {
        if (!pz() && this.zg.getStatus() != -2) {
            return false;
        }
        if (pz()) {
            return true;
        }
        if (this.zg.getStatus() == -2) {
            this.am = com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_PAUSE;
            return true;
        }
        if (this.zg.getStatus() != -4) {
            return true;
        }
        this.am = com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_CANCELED;
        return true;
    }

    private void io() {
        this.am = com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_NONE;
    }

    private void j() {
        if (this.zg.isOnlyWifi() && !com.ss.android.socialbase.downloader.tf.y.xj(com.ss.android.socialbase.downloader.downloader.w.tj(), g.b)) {
            throw new com.ss.android.socialbase.downloader.exception.y(1019, "download task need permission:android.permission.ACCESS_NETWORK_STATE");
        }
        if (!this.zg.isDownloadWithWifiValid()) {
            throw new com.ss.android.socialbase.downloader.exception.w();
        }
        if (!this.zg.isPauseReserveWithWifiValid()) {
            throw new com.ss.android.socialbase.downloader.exception.kd();
        }
    }

    private void jk() {
        if (this.c != null) {
            if (this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_CANCELED) {
                this.zg.setStatus(-4);
                this.c.w();
            } else if (this.am != com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_PAUSE) {
                this.c.u();
            } else {
                this.zg.setStatus(-2);
                this.c.hf();
            }
        }
    }

    private void l() {
        long y = com.ss.android.socialbase.downloader.tf.y.y(this.zg);
        long curBytes = this.zg.getCurBytes();
        if (y != curBytes) {
            String str = xj;
            StringBuilder B2KMhB2 = CtFAbx.B2KMhB("checkTaskCanResume: offset = ", y, ", curBytes = ");
            B2KMhB2.append(curBytes);
            com.ss.android.socialbase.downloader.w.xj.u(str, B2KMhB2.toString());
        }
        this.zg.setCurBytes(y);
        boolean z = y > 0;
        this.d = z;
        if (z || this.en) {
            return;
        }
        com.ss.android.socialbase.downloader.w.xj.w(xj, "checkTaskCanResume: deleteAllDownloadFiles");
        this.qt.u(this.zg.getId());
        this.qt.g(this.zg.getId());
        com.ss.android.socialbase.downloader.tf.y.xj(this.zg);
    }

    private void p() {
        Process.setThreadPriority(10);
        try {
            DownloadInfo downloadInfo = this.zg;
            if (downloadInfo != null && this.ff > 0) {
                downloadInfo.increaseDownloadPrepareTime(System.currentTimeMillis() - this.ff);
            }
        } catch (Throwable unused) {
        }
        try {
            IDownloadInterceptor interceptor = this.w.getInterceptor();
            if (interceptor != null) {
                if (interceptor.intercepte()) {
                    this.ht.kd();
                    return;
                }
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
        if (!d()) {
            dk monitorDepend = this.w.getMonitorDepend();
            DownloadInfo downloadInfo2 = this.zg;
            BaseException baseException = new BaseException(1003, "task status is invalid");
            DownloadInfo downloadInfo3 = this.zg;
            com.ss.android.socialbase.downloader.u.xj.xj(monitorDepend, downloadInfo2, baseException, downloadInfo3 != null ? downloadInfo3.getStatus() : 0);
            return;
        }
        while (true) {
            pl();
            if (!this.q) {
                return;
            }
            if (this.ai > 0) {
                this.ai--;
            } else {
                if (this.zg.getCurBytes() != this.zg.getTotalBytes()) {
                    com.ss.android.socialbase.downloader.w.xj.hf(xj, this.zg.getErrorBytesLog());
                    this.ht.xj(new com.ss.android.socialbase.downloader.exception.y(1027, "current bytes is not equals to total bytes, bytes invalid retry status is : " + this.zg.getByteInvalidRetryStatus()));
                    return;
                }
                if (this.zg.getCurBytes() <= 0) {
                    com.ss.android.socialbase.downloader.w.xj.hf(xj, this.zg.getErrorBytesLog());
                    this.ht.xj(new com.ss.android.socialbase.downloader.exception.y(1026, "curBytes is 0, bytes invalid retry status is : " + this.zg.getByteInvalidRetryStatus()));
                    return;
                }
                if (this.zg.getTotalBytes() <= 0) {
                    com.ss.android.socialbase.downloader.w.xj.hf(xj, this.zg.getErrorBytesLog());
                    this.ht.xj(new com.ss.android.socialbase.downloader.exception.y(1044, "TotalBytes is 0, bytes invalid retry status is : " + this.zg.getByteInvalidRetryStatus()));
                    return;
                }
            }
        }
    }

    private void pl() {
        boolean z;
        List<com.ss.android.socialbase.downloader.model.hf> w;
        try {
            this.am = com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_NONE;
            this.zg.updateStartDownloadTime();
            this.zg.resetRealStartDownloadTime();
            long currentTimeMillis = System.currentTimeMillis();
            this.zg.setFirstSpeedTime(-1L);
            int i = 0;
            try {
                tf();
                z = false;
            } catch (com.ss.android.socialbase.downloader.exception.xj e) {
                com.ss.android.socialbase.downloader.w.xj.hf(xj, "file exist " + e.xj());
                this.j = e.xj();
                z = true;
            }
            if (!this.q) {
                this.ht.hf();
            }
            this.q = false;
            if (ht()) {
                zg();
                return;
            }
            if (!TextUtils.isEmpty(this.j) && z) {
                if (this.zg.isExpiredRedownload()) {
                    this.en = com.ss.android.socialbase.downloader.tf.y.u(this.zg);
                }
                if (!this.en) {
                    g();
                    zg();
                    return;
                }
            }
            while (!ht()) {
                try {
                    try {
                        en();
                        ai();
                        j();
                        w = this.qt.w(this.zg.getId());
                        l();
                    } catch (com.ss.android.socialbase.downloader.exception.d e2) {
                        try {
                            com.ss.android.socialbase.downloader.w.xj.u(xj, "downloadInner: retry throwable for " + e2.xj());
                            if (this.am != com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_PAUSE) {
                                AtomicInteger atomicInteger = this.kd;
                                if (atomicInteger != null && atomicInteger.get() > 0) {
                                    this.zg.updateCurRetryTime(this.kd.decrementAndGet());
                                    this.zg.setStatus(5);
                                } else if (this.kd == null) {
                                    hf(new BaseException(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e2.xj()));
                                } else if (this.zg.trySwitchToNextBackupUrl()) {
                                    this.zg.setStatus(5);
                                    this.kd.set(this.zg.getRetryCount());
                                    this.zg.updateCurRetryTime(this.kd.get());
                                } else {
                                    hf(new BaseException(1018, "retry for Throwable, but retry Time " + String.valueOf(this.zg.getRetryCount()) + " all used, last error is " + e2.xj()));
                                }
                                v();
                                i = 0;
                            }
                        } finally {
                            v();
                        }
                    } catch (Throwable th) {
                        com.ss.android.socialbase.downloader.w.xj.u(xj, "downloadInner: throwable =  " + th);
                        if (this.am != com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_PAUSE) {
                            hf(new BaseException(1045, th));
                        }
                    }
                } catch (com.ss.android.socialbase.downloader.exception.xj unused) {
                    g();
                } catch (BaseException e3) {
                    com.ss.android.socialbase.downloader.w.xj.u(xj, "downloadInner: baseException = " + e3);
                    if (this.am != com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_PAUSE) {
                        if (e3.getErrorCode() != 1025 && e3.getErrorCode() != 1009) {
                            if (xj(e3)) {
                                if (com.ss.android.socialbase.downloader.tf.y.xj(e3)) {
                                    ff();
                                }
                                if (xj(e3, 0L) == com.ss.android.socialbase.downloader.exception.f.RETURN) {
                                    v();
                                    zg();
                                    return;
                                }
                                v();
                                i = 0;
                            } else {
                                hf(e3);
                            }
                        }
                        this.am = com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_END_RIGHT_NOW;
                        v();
                        zg();
                        return;
                    }
                }
                if (am()) {
                    com.ss.android.socialbase.downloader.w.xj.w(xj, "downloadSegments return");
                    v();
                    zg();
                    return;
                }
                String connectionUrl = this.zg.getConnectionUrl();
                if (ht()) {
                    v();
                    zg();
                    return;
                }
                long kd = this.d ? com.ss.android.socialbase.downloader.tf.y.kd(this.zg) : 0L;
                com.ss.android.socialbase.downloader.model.hf xj2 = xj(this.zg, kd);
                List<com.ss.android.socialbase.downloader.model.w> xj3 = xj(xj2);
                com.ss.android.socialbase.downloader.tf.y.xj(xj3, this.zg);
                com.ss.android.socialbase.downloader.tf.y.hf(xj3, this.zg);
                this.zg.setPreconnectLevel(i);
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    xj(connectionUrl, xj3, kd);
                    this.zg.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                    if (ht()) {
                        v();
                        zg();
                        return;
                    }
                    long totalBytes = this.zg.getTotalBytes();
                    xj(totalBytes);
                    int xj4 = xj(totalBytes, w);
                    if (ht()) {
                        v();
                        zg();
                        return;
                    }
                    if (xj4 <= 0) {
                        throw new BaseException(1032, "chunkCount is 0");
                    }
                    boolean z2 = xj4 == 1;
                    this.f = z2;
                    if (z2) {
                        if (this.dk == null) {
                            try {
                                currentTimeMillis2 = System.currentTimeMillis();
                                xj(connectionUrl, xj3);
                                this.zg.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                            } finally {
                            }
                        }
                        if (ht()) {
                            v();
                            zg();
                            return;
                        } else {
                            this.zg.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                            qt();
                            xj(xj2, connectionUrl, this.dk);
                        }
                    } else {
                        if (!this.zg.isNeedReuseFirstConnection()) {
                            yo();
                        }
                        if (ht()) {
                            v();
                            zg();
                            return;
                        } else {
                            qt();
                            this.zg.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                            if (this.d) {
                                xj(xj4, w);
                            } else {
                                xj(totalBytes, xj4);
                            }
                        }
                    }
                    zg();
                    return;
                } finally {
                }
            }
            zg();
        } catch (Throwable th2) {
            zg();
            throw th2;
        }
    }

    private boolean pz() {
        return this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_CANCELED || this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_PAUSE;
    }

    private boolean q() {
        DownloadInfo downloadInfo = this.zg;
        return (downloadInfo == null || downloadInfo.isExpiredRedownload() || (this.d && this.zg.getChunkCount() <= 1) || this.zg.isChunkDowngradeRetryUsed() || !this.tf || this.f13844pl) ? false : true;
    }

    private void qt() {
        if (com.ss.android.socialbase.downloader.f.xj.xj(this.zg.getId()).xj("reset_retain_retry_times", 0) != 1 || this.wo >= 3) {
            return;
        }
        this.kd.set(this.zg.isBackUpUrlUsed() ? this.zg.getBackUpUrlRetryCount() : this.zg.getRetryCount());
        this.wo++;
    }

    private boolean r() {
        return false;
    }

    private boolean ra() {
        if (this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_ERROR) {
            this.ht.xj(this.ra);
        } else if (this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_CANCELED) {
            this.ht.w();
        } else if (this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_PAUSE) {
            this.ht.u();
        } else if (this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.ht.c();
            } catch (BaseException e) {
                this.ht.xj(e);
            }
        } else if (this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.ht.xj(this.j);
            } catch (BaseException e2) {
                this.ht.xj(e2);
            }
        } else {
            if (this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
                this.ht.xj(this.ra, false);
                return false;
            }
            if (this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                return true;
            }
            com.ss.android.socialbase.downloader.constants.f fVar = this.am;
            com.ss.android.socialbase.downloader.constants.f fVar2 = com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_RETRY_DELAY;
            if (fVar == fVar2 && !dk()) {
                com.ss.android.socialbase.downloader.w.xj.hf(xj, "doTaskStatusHandle retryDelay");
                io();
                return this.am == fVar2;
            }
            try {
                if (!et()) {
                    return false;
                }
                this.ht.y();
                com.ss.android.socialbase.downloader.impls.yo.xj().u();
            } catch (Throwable th) {
                hf(new BaseException(1008, com.ss.android.socialbase.downloader.tf.y.hf(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00f4: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:91:0x0101 (LINE:245), block:B:90:0x00f4 */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b3 A[Catch: all -> 0x00d4, TryCatch #8 {all -> 0x00d4, blocks: (B:33:0x00af, B:35:0x00b3, B:37:0x00b7, B:71:0x00f1), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void tf() {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.d.w.tf():void");
    }

    private void v() {
        e();
        yo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wo() {
        com.ss.android.socialbase.downloader.impls.xj z;
        if (ht() || (z = com.ss.android.socialbase.downloader.downloader.w.z()) == null) {
            return;
        }
        z.pl(this.zg.getId());
    }

    private long x() {
        return this.pz.xj(this.zg.getCurRetryTimeInTotal(), this.zg.getTotalRetryCount());
    }

    private void yo() {
        d dVar = this.dk;
        if (dVar != null) {
            dVar.u();
            this.dk = null;
        }
    }

    private void z() {
        long j;
        int xj2;
        try {
            j = com.ss.android.socialbase.downloader.tf.y.u(this.zg.getTempPath());
        } catch (BaseException unused) {
            j = 0;
        }
        String str = xj;
        com.ss.android.socialbase.downloader.w.xj.w(str, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.tf.y.xj(j) + "MB");
        if (j > 0) {
            long totalBytes = this.zg.getTotalBytes() - this.zg.getCurBytes();
            if (j < totalBytes && (xj2 = com.ss.android.socialbase.downloader.f.xj.xj(this.zg.getId()).xj("space_fill_min_keep_mb", 100)) > 0) {
                long j2 = j - (xj2 * BaseConstants.MB_VALUE);
                StringBuilder B9tovu2 = A2egSU.B9tovu(xj2, "checkSpaceOverflowInProgress: minKeep  = ", "MB, canDownload = ");
                B9tovu2.append(com.ss.android.socialbase.downloader.tf.y.xj(j2));
                B9tovu2.append("MB");
                com.ss.android.socialbase.downloader.w.xj.w(str, B9tovu2.toString());
                if (j2 > 0) {
                    this.l = j2 + BaseConstants.MB_VALUE + this.zg.getCurBytes();
                    return;
                } else {
                    this.l = 0L;
                    throw new com.ss.android.socialbase.downloader.exception.u(j, totalBytes);
                }
            }
        }
        this.l = 0L;
    }

    private void zg() {
        boolean z;
        boolean z2;
        com.ss.android.socialbase.downloader.w.xj.hf(xj, "endDownloadRunnable::runStatus=" + this.am);
        boolean z3 = (this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_PAUSE || this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_CANCELED) ? false : true;
        try {
            z = ra();
            z2 = false;
        } catch (Exception e) {
            if (e instanceof BaseException) {
                this.ht.xj((BaseException) e);
            } else {
                this.ht.xj(new BaseException(1046, e));
            }
            z = true;
            z2 = true;
        }
        if (!z && !z2) {
            this.q = true;
            com.ss.android.socialbase.downloader.w.xj.hf(xj, "jump to restart");
            return;
        }
        this.g.set(false);
        if (z3) {
            try {
                com.ss.android.socialbase.downloader.impls.xj z4 = com.ss.android.socialbase.downloader.downloader.w.z();
                if (z4 != null) {
                    z4.xj(this);
                }
            } catch (Throwable th) {
                pl.xj(th);
                dk monitorDepend = this.w.getMonitorDepend();
                DownloadInfo downloadInfo = this.zg;
                BaseException baseException = new BaseException(1014, com.ss.android.socialbase.downloader.tf.y.hf(th, "removeDownloadRunnable"));
                DownloadInfo downloadInfo2 = this.zg;
                com.ss.android.socialbase.downloader.u.xj.xj(monitorDepend, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
            }
        }
    }

    public Future c() {
        return this.hf;
    }

    public void hf() {
        com.ss.android.socialbase.downloader.constants.f fVar = com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_CANCELED;
        this.am = fVar;
        if (this.r != null) {
            this.r.xj();
        }
        if (this.c != null) {
            this.c.w();
        }
        if (this.r == null && this.c == null) {
            v();
            this.am = fVar;
            zg();
        }
        a();
    }

    public int kd() {
        DownloadInfo downloadInfo = this.zg;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.downloader.w.xj(this.w, 3);
        try {
            com.ss.android.socialbase.downloader.network.hf.xj().hf();
            p();
            com.ss.android.socialbase.downloader.network.hf.xj().w();
            com.ss.android.socialbase.downloader.downloader.w.hf(this.w, 3);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.network.hf.xj().w();
            throw th;
        }
    }

    public boolean u() {
        return this.g.get();
    }

    public DownloadTask w() {
        return this.w;
    }

    public void y() {
        this.ff = System.currentTimeMillis();
        this.ht.xj();
    }

    private boolean u(BaseException baseException) {
        AtomicInteger atomicInteger = this.kd;
        boolean z = true;
        if (atomicInteger == null) {
            hf(new BaseException(1043, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
            return true;
        }
        if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
            if (this.zg.trySwitchToNextBackupUrl()) {
                this.kd.set(this.zg.getBackUpUrlRetryCount());
                this.zg.updateCurRetryTime(this.kd.get());
            } else {
                if (baseException == null || ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.zg.canReplaceHttpForRetry())) {
                    int errorCode = baseException.getErrorCode();
                    String valueOf = String.valueOf(this.kd);
                    String valueOf2 = String.valueOf(this.zg.getRetryCount());
                    String errorMessage = baseException.getErrorMessage();
                    StringBuilder BChYOn2 = A2egSU.BChYOn("retry for exception, but current retry time : ", valueOf, " , retry Time ", valueOf2, " all used, last error is ");
                    BChYOn2.append(errorMessage);
                    hf(new BaseException(errorCode, BChYOn2.toString()));
                    return true;
                }
                this.kd.set(this.zg.getRetryCount());
                this.zg.updateCurRetryTime(this.kd.get());
                this.zg.setHttpsToHttpRetryUsed(true);
            }
            z = false;
        }
        if (this.am != com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_RETRY_DELAY && z) {
            this.zg.updateCurRetryTime(this.kd.decrementAndGet());
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.d.y
    public void w(BaseException baseException) {
        DownloadInfo downloadInfo = this.zg;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        xj(baseException, false);
    }

    public void xj() {
        com.ss.android.socialbase.downloader.constants.f fVar = com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_PAUSE;
        this.am = fVar;
        if (this.r != null) {
            this.r.hf();
        }
        if (this.c != null) {
            this.c.hf();
        }
        if (this.r == null && this.c == null) {
            v();
            this.am = fVar;
            zg();
        }
        try {
            Iterator it = ((ArrayList) this.y.clone()).iterator();
            while (it.hasNext()) {
                hf hfVar = (hf) it.next();
                if (hfVar != null) {
                    hfVar.xj();
                }
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    private void hf(String str, List<com.ss.android.socialbase.downloader.model.w> list, long j) {
        com.ss.android.socialbase.downloader.network.xj.w xj2;
        boolean z = true;
        if (this.zg.getChunkCount() == 1 && (xj2 = com.ss.android.socialbase.downloader.network.xj.xj.xj().xj(str, list)) != null) {
            this.et = xj2;
            this.zg.setPreconnectLevel(1);
        }
        if (this.et == null && !this.z && this.zg.isHeadConnectionAvailable()) {
            try {
                int hf = this.f13842a.hf("net_lib_strategy");
                if (this.f13842a.xj("monitor_download_connect", 0) <= 0) {
                    z = false;
                }
                this.et = com.ss.android.socialbase.downloader.downloader.w.xj(str, list, hf, z, this.zg);
            } catch (Throwable th) {
                this.zg.setHeadConnectionException(com.ss.android.socialbase.downloader.tf.y.tf(th));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x005e, code lost:
    
        if (r8 <= 0) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int xj(long r6, java.util.List<com.ss.android.socialbase.downloader.model.hf> r8) {
        /*
            r5 = this;
            boolean r0 = r5.q()
            if (r0 == 0) goto L60
            boolean r0 = r5.d
            if (r0 == 0) goto L18
            if (r8 == 0) goto L11
            int r8 = r8.size()
            goto L5e
        L11:
            com.ss.android.socialbase.downloader.model.DownloadInfo r8 = r5.zg
            int r8 = r8.getChunkCount()
            goto L5e
        L18:
            com.ss.android.socialbase.downloader.downloader.f r8 = r5.e
            if (r8 == 0) goto L21
            int r8 = r8.xj(r6)
            goto L27
        L21:
            com.ss.android.socialbase.downloader.downloader.f r8 = r5.yo
            int r8 = r8.xj(r6)
        L27:
            com.ss.android.socialbase.downloader.network.p r0 = com.ss.android.socialbase.downloader.network.p.xj()
            com.ss.android.socialbase.downloader.network.pl r0 = r0.hf()
            java.lang.String r1 = com.ss.android.socialbase.downloader.d.w.xj
            java.lang.String r2 = r0.name()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "NetworkQuality is : "
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.ss.android.socialbase.downloader.w.xj.hf(r1, r2)
            com.ss.android.socialbase.downloader.model.DownloadInfo r1 = r5.zg
            java.lang.String r2 = r0.name()
            r1.setNetworkQuality(r2)
            com.ss.android.socialbase.downloader.downloader.c r1 = r5.v
            if (r1 == 0) goto L58
            int r8 = r1.xj(r8, r0)
            goto L5e
        L58:
            com.ss.android.socialbase.downloader.downloader.c r1 = r5.jk
            int r8 = r1.xj(r8, r0)
        L5e:
            if (r8 > 0) goto L61
        L60:
            r8 = 1
        L61:
            boolean r0 = com.ss.android.socialbase.downloader.w.xj.xj()
            if (r0 == 0) goto L8b
            java.lang.String r0 = com.ss.android.socialbase.downloader.d.w.xj
            java.lang.String r1 = java.lang.String.valueOf(r8)
            com.ss.android.socialbase.downloader.model.DownloadInfo r2 = r5.zg
            java.lang.String r2 = r2.getName()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r7 = "chunk count : "
            java.lang.String r3 = " for "
            java.lang.String r4 = " contentLen:"
            java.lang.StringBuilder r7 = J3FDQU.A2egSU.BChYOn(r7, r1, r3, r2, r4)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.ss.android.socialbase.downloader.w.xj.hf(r0, r6)
        L8b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.d.w.xj(long, java.util.List):int");
    }

    @Override // com.ss.android.socialbase.downloader.d.y
    public boolean hf(long j) {
        if (this.l > 0 && this.zg.getCurBytes() > this.l) {
            z();
        }
        return this.ht.xj(j);
    }

    @Override // com.ss.android.socialbase.downloader.d.y
    public void hf(BaseException baseException) {
        com.ss.android.socialbase.downloader.w.xj.hf(xj, "onError:" + baseException.getMessage());
        this.am = com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_ERROR;
        this.ra = baseException;
        a();
    }

    private void xj(String str, List<com.ss.android.socialbase.downloader.model.w> list, long j) {
        hf(str, list, j);
        com.ss.android.socialbase.downloader.network.c cVar = this.et;
        if (cVar != null) {
            try {
                xj(str, cVar, j);
            } catch (Throwable unused) {
                this.z = true;
            }
        }
        if (this.et == null || this.z) {
            xj(str, list);
            xj(str, this.dk, j);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00f7 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(java.lang.String r11, java.util.List<com.ss.android.socialbase.downloader.model.w> r12) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.d.w.xj(java.lang.String, java.util.List):void");
    }

    public static com.ss.android.socialbase.downloader.model.hf xj(DownloadInfo downloadInfo, long j) {
        return new hf.xj(downloadInfo.getId()).xj(-1).xj(0L).kd(j).hf(j).w(0L).u(downloadInfo.getTotalBytes() - j).xj();
    }

    private List<com.ss.android.socialbase.downloader.model.w> xj(com.ss.android.socialbase.downloader.model.hf hfVar) {
        List<com.ss.android.socialbase.downloader.model.w> xj2 = com.ss.android.socialbase.downloader.tf.y.xj(this.zg.getExtraHeaders(), this.zg.geteTag(), hfVar);
        if (this.zg.isExpiredRedownload() && this.en && this.zg.getLastModified() != null) {
            xj2.add(new com.ss.android.socialbase.downloader.model.w("if-modified-since", this.zg.getLastModified()));
            xj2.add(new com.ss.android.socialbase.downloader.model.w("download-tc21-1-15", "download-tc21-1-15"));
            com.ss.android.socialbase.downloader.w.xj.hf(xj, "dcache::add head IF_MODIFIED_SINCE=" + this.zg.getLastModified());
        }
        return xj2;
    }

    private void xj(int i, List<com.ss.android.socialbase.downloader.model.hf> list) {
        if (list.size() == i) {
            xj(list, this.zg.getTotalBytes());
            return;
        }
        throw new BaseException(1033, new IllegalArgumentException());
    }

    private void xj(long j, int i) {
        long j2 = j / i;
        int id = this.zg.getId();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            com.ss.android.socialbase.downloader.model.hf xj2 = new hf.xj(id).xj(i2).xj(j3).kd(j3).hf(j3).w(i2 == i + (-1) ? 0L : (j3 + j2) - 1).xj();
            arrayList.add(xj2);
            this.qt.xj(xj2);
            j3 += j2;
            i2++;
        }
        this.zg.setChunkCount(i);
        this.qt.xj(id, i);
        xj(arrayList, j);
    }

    private void xj(List<com.ss.android.socialbase.downloader.model.hf> list, long j) {
        long zg;
        for (com.ss.android.socialbase.downloader.model.hf hfVar : list) {
            if (hfVar != null) {
                if (hfVar.zg() == 0) {
                    zg = j - hfVar.am();
                } else {
                    zg = (hfVar.zg() - hfVar.am()) + 1;
                }
                if (zg > 0) {
                    hfVar.xj(zg);
                    if (this.zg.isNeedReuseFirstConnection() && this.dk != null && (!this.zg.isHeadConnectionAvailable() || this.z)) {
                        if (hfVar.v() == 0) {
                            this.y.add(new hf(hfVar, this.w, this.dk, this));
                        } else if (hfVar.v() > 0) {
                            this.y.add(new hf(hfVar, this.w, this));
                        }
                    } else {
                        this.y.add(new hf(hfVar, this.w, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.tf.xj.xj(64)) {
            ArrayList arrayList = new ArrayList(this.y.size());
            Iterator<hf> it = this.y.iterator();
            while (it.hasNext()) {
                hf next = it.next();
                if (this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_CANCELED) {
                    next.hf();
                } else if (this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_PAUSE) {
                    next.xj();
                } else {
                    arrayList.add(next);
                }
            }
            try {
                List<Future> u = com.ss.android.socialbase.downloader.impls.kd.u(arrayList);
                for (Runnable runnable = (Runnable) arrayList.remove(0); runnable != null; runnable = com.ss.android.socialbase.downloader.impls.kd.kd(u)) {
                    if (ht()) {
                        return;
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        pl.xj(th);
                    }
                }
                if (u == null || u.isEmpty()) {
                    return;
                }
                for (Future future : u) {
                    if (future != null && !future.isDone()) {
                        try {
                            future.get();
                        } catch (Throwable unused) {
                        }
                    }
                }
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.y.size());
        Iterator<hf> it2 = this.y.iterator();
        while (it2.hasNext()) {
            hf next2 = it2.next();
            if (this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_CANCELED) {
                next2.hf();
            } else if (this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_PAUSE) {
                next2.xj();
            } else {
                arrayList2.add(Executors.callable(next2));
            }
        }
        if (ht()) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.impls.kd.w(arrayList2);
        } catch (InterruptedException e) {
            throw new BaseException(1020, e);
        }
    }

    private void xj(com.ss.android.socialbase.downloader.model.hf hfVar, String str, d dVar) {
        hfVar.xj(this.zg.getTotalBytes() - hfVar.am());
        this.zg.setChunkCount(1);
        this.qt.xj(this.zg.getId(), 1);
        this.c = new com.ss.android.socialbase.downloader.downloader.kd(this.zg, str, dVar, hfVar, this);
        jk();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:6|7|8|(4:10|(1:12)(1:68)|13|(2:15|(12:17|(2:19|(1:21)(2:22|23))|24|(1:26)|56|28|29|30|31|32|33|34)(2:57|(6:59|30|31|32|33|34)(4:60|(1:62)(1:65)|63|64)))(1:66))(2:69|(4:71|(1:73)(1:76)|74|75)(2:77|(2:79|80)))|67|29|30|31|32|33|34) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0103, code lost:
    
        if (r10 > r26) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x016c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x016d, code lost:
    
        com.ss.android.socialbase.downloader.w.xj.kd(com.ss.android.socialbase.downloader.d.w.xj, "checkSpaceOverflow: setLength1 e = " + r0 + ", mustSetLength = " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x018a, code lost:
    
        if (r10 >= r3) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0194, code lost:
    
        r9.hf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0198, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0199, code lost:
    
        com.ss.android.socialbase.downloader.w.xj.kd(com.ss.android.socialbase.downloader.d.w.xj, "checkSpaceOverflow: setLength2 ex = " + r0 + ", mustSetLength = " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01b2, code lost:
    
        if (r2 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x01ba, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.BaseException(com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader.KeyIsPreloadWaitListType, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01bb, code lost:
    
        if (r2 != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01cd, code lost:
    
        throw new com.ss.android.socialbase.downloader.exception.BaseException(com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader.KeyIsPreloadWaitListType, r0);
     */
    @Override // com.ss.android.socialbase.downloader.d.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(long r26) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.d.w.xj(long):void");
    }

    private boolean xj(int i, String str, String str2) {
        if (i == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.p || this.tf)) {
            return (i == 201 || i == 416) && this.zg.getCurBytes() > 0;
        }
        return true;
    }

    private void xj(String str, String str2) {
        this.qt.u(this.zg.getId());
        this.qt.g(this.zg.getId());
        com.ss.android.socialbase.downloader.tf.y.xj(this.zg);
        this.d = false;
        this.zg.resetDataForEtagEndure(str);
        this.qt.xj(this.zg);
        throw new com.ss.android.socialbase.downloader.exception.d(str2);
    }

    @Override // com.ss.android.socialbase.downloader.d.y
    public void xj(String str, com.ss.android.socialbase.downloader.network.c cVar, long j) {
        String str2;
        long j2;
        long j3;
        if (cVar == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.model.u uVar = new com.ss.android.socialbase.downloader.model.u(str, cVar);
            int i = uVar.w;
            String u = uVar.u();
            if (TextUtils.isEmpty(this.zg.getMimeType()) && !TextUtils.isEmpty(u)) {
                this.zg.setMimeType(u);
            }
            boolean hf = uVar.hf();
            this.tf = hf;
            this.zg.setSupportPartial(hf);
            this.p = uVar.xj();
            String str3 = this.zg.geteTag();
            String w = uVar.w();
            String y = uVar.y();
            String c = uVar.c();
            String str4 = xj;
            StringBuilder sb = new StringBuilder("dcache=responseCode=");
            sb.append(i);
            sb.append(" last_modified=");
            sb.append(y);
            sb.append(" CACHE_CONTROL=");
            sb.append(c);
            sb.append(" max-age=");
            String str5 = w;
            sb.append(uVar.p());
            sb.append(" isDeleteCacheIfCheckFailed=");
            sb.append(this.zg.isDeleteCacheIfCheckFailed());
            com.ss.android.socialbase.downloader.w.xj.hf(str4, sb.toString());
            com.ss.android.socialbase.downloader.w.xj.hf(str4, "dcache=firstOffset=" + j + " cur=" + y + " before=" + this.zg.getLastModified() + " cur=" + uVar.tf() + " before=" + this.zg.getTotalBytes());
            if (!TextUtils.isEmpty(c)) {
                this.zg.setCacheControl(c);
                if (uVar.p() > 0) {
                    this.zg.setCacheExpiredTime((uVar.p() * 1000) + System.currentTimeMillis());
                }
            }
            if (this.zg.isExpiredRedownload() && this.en && !TextUtils.isEmpty(this.j)) {
                if (i == 304 || ((!TextUtils.isEmpty(this.zg.getLastModified()) || !this.zg.isDeleteCacheIfCheckFailed()) && TextUtils.equals(y, this.zg.getLastModified()))) {
                    com.ss.android.socialbase.downloader.w.xj.hf(str4, "dcache=responseCode=" + i + " lastModified not changed, use local file  " + y);
                    throw new com.ss.android.socialbase.downloader.exception.xj(this.j);
                }
                com.ss.android.socialbase.downloader.tf.y.xj(this.zg);
            }
            if (j > 0 && this.zg.isExpiredRedownload() && !TextUtils.equals(y, this.zg.getLastModified())) {
                com.ss.android.socialbase.downloader.w.xj.hf(str4, "dcache cdn file change, so retry");
                xj("", "cdn file changed");
            }
            if (!TextUtils.isEmpty(y)) {
                this.zg.setLastModified(y);
            }
            if (xj(i, str3, str5)) {
                if (cVar instanceof d) {
                    if (!TextUtils.isEmpty(str3) && str3.equals(str5)) {
                        str5 = "";
                    }
                    xj(str5, "eTag of server file changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.hf(1002, i, "");
                }
            }
            if (!this.tf && !this.p) {
                if (i == 403) {
                    throw new BaseException(1047, "response code error : 403");
                }
                throw new com.ss.android.socialbase.downloader.exception.hf(PluginConstants.ERROR_PLUGIN_DOWNLOAD, i, "response code error : " + i);
            }
            if (this.p && j > 0) {
                if (cVar instanceof d) {
                    xj("", "http head request not support");
                } else {
                    throw new BaseException(PluginConstants.ERROR_PLUGIN_DOWNLOAD, "isResponseFromBegin but firstOffset > 0");
                }
            }
            long f = uVar.f();
            if (!(cVar instanceof d) && f < 0 && com.ss.android.socialbase.downloader.tf.u.xj(this.zg)) {
                throw new BaseException(PluginConstants.ERROR_PLUGIN_DOWNLOAD, "");
            }
            if (!TextUtils.isEmpty(this.zg.getName())) {
                str2 = "";
            } else {
                str2 = com.ss.android.socialbase.downloader.tf.y.xj(cVar, this.zg.getUrl());
            }
            boolean d = uVar.d();
            this.f13844pl = d;
            if (!d && f == 0 && !(cVar instanceof d)) {
                throw new BaseException(PluginConstants.ERROR_PLUGIN_DOWNLOAD, "");
            }
            if (d) {
                j2 = 0;
                j3 = -1;
            } else {
                String hf2 = com.ss.android.socialbase.downloader.tf.y.hf(cVar, com.sigmob.sdk.downloader.core.c.f);
                com.ss.android.socialbase.downloader.w.xj.w(str4, "firstConnection: contentRange = " + hf2);
                if (!TextUtils.isEmpty(hf2) && this.f13842a.hf("fix_get_total_bytes", true)) {
                    j3 = com.ss.android.socialbase.downloader.tf.y.hf(hf2);
                    com.ss.android.socialbase.downloader.w.xj.w(str4, "firstConnection: 1 totalLength = " + j3);
                    j2 = 0L;
                } else {
                    j2 = 0;
                    long j4 = j + f;
                    com.ss.android.socialbase.downloader.w.xj.kd(str4, "firstConnection: 2 totalLength = " + j4 + ", contentLength = " + f);
                    j3 = j4;
                }
            }
            if (!TextUtils.isEmpty(this.zg.getTaskKey()) && this.zg.getTotalBytes() > j2 && j3 != this.zg.getTotalBytes()) {
                if (cVar instanceof d) {
                    xj("", "file totalLength changed");
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.hf(1002, i, "");
                }
            }
            if (ht()) {
                return;
            }
            if (this.zg.getExpectFileLength() > j2 && com.ss.android.socialbase.downloader.f.xj.xj(this.zg.getId()).hf("force_check_file_length") == 1 && this.zg.getExpectFileLength() != j3) {
                throw new BaseException(1070, "expectFileLength = " + this.zg.getExpectFileLength() + " , totalLength = " + j3);
            }
            this.ht.xj(j3, str5, str2);
        } catch (BaseException e) {
            throw e;
        } catch (com.ss.android.socialbase.downloader.exception.d e2) {
            throw e2;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.tf.y.xj(th, "HandleFirstConnection");
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.y
    public void xj(hf hfVar) {
        if (this.f) {
            return;
        }
        synchronized (this) {
            this.y.remove(hfVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.y
    public boolean xj(BaseException baseException) {
        if (this.r != null && com.ss.android.socialbase.downloader.tf.y.d(baseException) && this.kd.get() < this.zg.getRetryCount()) {
            return false;
        }
        if (com.ss.android.socialbase.downloader.tf.y.hf(baseException)) {
            if (this.f && !this.u) {
                com.ss.android.socialbase.downloader.tf.y.xj(this.zg);
                this.u = true;
            }
            return true;
        }
        AtomicInteger atomicInteger = this.kd;
        return ((atomicInteger != null && atomicInteger.get() > 0) || this.zg.hasNextBackupUrl() || (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.zg.canReplaceHttpForRetry()))) && !(baseException instanceof com.ss.android.socialbase.downloader.exception.y);
    }

    @Override // com.ss.android.socialbase.downloader.d.y
    public void xj(BaseException baseException, boolean z) {
        com.ss.android.socialbase.downloader.w.xj.hf(xj, "onAllChunkRetryWithReset");
        this.am = com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.ra = baseException;
        a();
        if (z ? u(baseException) : false) {
            return;
        }
        ff();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zg.setForbiddenBackupUrls(list, this.am == com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_WAITING_ASYNC_HANDLER);
        com.ss.android.socialbase.downloader.impls.xj z = com.ss.android.socialbase.downloader.downloader.w.z();
        if (z != null) {
            z.pl(this.zg.getId());
        }
    }

    @Override // com.ss.android.socialbase.downloader.d.y
    public com.ss.android.socialbase.downloader.exception.f xj(com.ss.android.socialbase.downloader.model.hf hfVar, BaseException baseException, long j) {
        if (pz()) {
            return com.ss.android.socialbase.downloader.exception.f.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || com.ss.android.socialbase.downloader.tf.y.f(baseException))) {
            return xj(baseException, j);
        }
        this.ra = baseException;
        this.zg.increaseCurBytes(-j);
        this.qt.xj(this.zg);
        if (u(baseException)) {
            return com.ss.android.socialbase.downloader.exception.f.RETURN;
        }
        com.ss.android.socialbase.downloader.downloader.y yVar = this.ht;
        com.ss.android.socialbase.downloader.constants.f fVar = this.am;
        com.ss.android.socialbase.downloader.constants.f fVar2 = com.ss.android.socialbase.downloader.constants.f.RUN_STATUS_RETRY_DELAY;
        yVar.xj(hfVar, baseException, fVar == fVar2);
        if (this.am != fVar2 && this.zg.isNeedRetryDelay()) {
            long x = x();
            if (x > 0) {
                com.ss.android.socialbase.downloader.w.xj.w(xj, "onSingleChunkRetry with delay time " + x);
                try {
                    Thread.sleep(x);
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.w.xj.u(xj, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.exception.f.CONTINUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00fa  */
    @Override // com.ss.android.socialbase.downloader.d.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.ss.android.socialbase.downloader.exception.f xj(com.ss.android.socialbase.downloader.exception.BaseException r7, long r8) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.d.w.xj(com.ss.android.socialbase.downloader.exception.BaseException, long):com.ss.android.socialbase.downloader.exception.f");
    }

    @Override // com.ss.android.socialbase.downloader.d.y
    public synchronized com.ss.android.socialbase.downloader.model.hf xj(int i) {
        com.ss.android.socialbase.downloader.model.hf xj2;
        if (this.zg.getChunkCount() < 2) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.model.hf> w = this.qt.w(this.zg.getId());
        if (w != null && !w.isEmpty()) {
            for (int i2 = 0; i2 < w.size(); i2++) {
                com.ss.android.socialbase.downloader.model.hf hfVar = w.get(i2);
                if (hfVar != null && (xj2 = xj(hfVar, i)) != null) {
                    return xj2;
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.d.y
    public void xj(com.ss.android.socialbase.downloader.network.c cVar) {
        if (cVar != null) {
            try {
                int hf = cVar.hf();
                this.zg.setHttpStatusCode(hf);
                this.zg.setHttpStatusMessage(com.ss.android.socialbase.downloader.tf.hf.xj(hf));
                return;
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        this.zg.setHttpStatusCode(-1);
        this.zg.setHttpStatusMessage("");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0068, code lost:
    
        if (r9.y() != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.ss.android.socialbase.downloader.model.hf xj(com.ss.android.socialbase.downloader.model.hf r9, int r10) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.d.w.xj(com.ss.android.socialbase.downloader.model.hf, int):com.ss.android.socialbase.downloader.model.hf");
    }

    private v xj(DownloadTask downloadTask) {
        v retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new e(retryDelayTimeArray);
            }
        }
        return com.ss.android.socialbase.downloader.downloader.w.ws();
    }

    public void xj(Future future) {
        this.hf = future;
    }
}
