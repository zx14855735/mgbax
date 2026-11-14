package com.ss.android.socialbase.downloader.impls;

import J3FDQU.A2egSU;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.xj.xj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class yo implements Handler.Callback, xj.InterfaceC0510xj {
    private static hf d;
    private static volatile yo xj;
    private ConnectivityManager f;
    private final boolean kd;
    private long y;
    private final Handler w = new Handler(Looper.getMainLooper(), this);
    private final SparseArray<xj> u = new SparseArray<>();
    private int c = 0;
    private final Context hf = com.ss.android.socialbase.downloader.downloader.w.tj();

    public interface hf {
        void xj(DownloadInfo downloadInfo, long j, boolean z, int i);
    }

    public static class xj {
        final int[] c;
        private int d;
        private int f;
        final int hf;
        final int kd;
        private long p;

        /* renamed from: pl, reason: collision with root package name */
        private boolean f13851pl;
        private boolean tf;
        final int u;
        final int w;
        final int xj;
        final boolean y;

        public xj(int i, int i2, int i3, int i4, int i5, boolean z, int[] iArr) {
            i4 = i4 < 3000 ? 3000 : i4;
            i5 = i5 < 5000 ? 5000 : i5;
            this.xj = i;
            this.hf = i2;
            this.w = i3;
            this.u = i4;
            this.kd = i5;
            this.y = z;
            this.c = iArr;
            this.f = i4;
        }

        public int u() {
            return this.f;
        }

        public void w() {
            this.f = this.u;
        }

        public synchronized void hf() {
            this.d++;
        }

        public boolean xj(long j, int i, int i2, boolean z) {
            if (!this.f13851pl) {
                com.ss.android.socialbase.downloader.w.xj.w("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            }
            if (this.hf < i || this.d >= this.w) {
                return false;
            }
            if (!this.tf || i2 == 2) {
                return z || j - this.p >= ((long) this.u);
            }
            return false;
        }

        public synchronized void xj() {
            this.f += this.kd;
        }

        public synchronized void xj(long j) {
            this.p = j;
        }
    }

    private yo() {
        y();
        this.kd = com.ss.android.socialbase.downloader.tf.y.w();
        com.ss.android.socialbase.downloader.xj.xj.xj().xj(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c() {
        try {
            if (this.f == null) {
                this.f = (ConnectivityManager) this.hf.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.f.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private void y() {
        if (com.ss.android.socialbase.downloader.f.xj.w().xj("use_network_callback", 0) != 1) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.w.pl().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.yo.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (yo.this.hf != null) {
                        yo yoVar = yo.this;
                        yoVar.f = (ConnectivityManager) yoVar.hf.getApplicationContext().getSystemService("connectivity");
                        yo.this.f.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.yo.1.1
                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public void onAvailable(Network network) {
                                com.ss.android.socialbase.downloader.w.xj.hf("RetryScheduler", "network onAvailable: ");
                                yo.this.xj(1, true);
                            }
                        });
                    }
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            hf(message.arg1, message.arg2 == 1);
        } else {
            com.ss.android.socialbase.downloader.w.xj.w("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
            xj(message.what);
        }
        return true;
    }

    private void hf(final int i, final boolean z) {
        com.ss.android.socialbase.downloader.downloader.w.pl().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.yo.2
            @Override // java.lang.Runnable
            public void run() {
                int c;
                try {
                    if (yo.this.c > 0 && (c = yo.this.c()) != 0) {
                        com.ss.android.socialbase.downloader.w.xj.w("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + yo.this.c);
                        long currentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        synchronized (yo.this.u) {
                            for (int i2 = 0; i2 < yo.this.u.size(); i2++) {
                                try {
                                    xj xjVar = (xj) yo.this.u.valueAt(i2);
                                    if (xjVar != null && xjVar.xj(currentTimeMillis, i, c, z)) {
                                        if (z) {
                                            xjVar.w();
                                        }
                                        arrayList.add(xjVar);
                                    }
                                } finally {
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                yo.this.xj(((xj) it.next()).xj, c, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    private xj u(int i) {
        int[] iArr;
        int i2;
        int i3;
        boolean z;
        com.ss.android.socialbase.downloader.f.xj xj2 = com.ss.android.socialbase.downloader.f.xj.xj(i);
        boolean z2 = false;
        int xj3 = xj2.xj("retry_schedule", 0);
        JSONObject u = xj2.u("retry_schedule_config");
        int i4 = 60;
        if (u != null) {
            int optInt = u.optInt("max_count", 60);
            int optInt2 = u.optInt("interval_sec", 60);
            int optInt3 = u.optInt("interval_sec_acceleration", 60);
            if (d != null && u.optInt("use_job_scheduler", 0) == 1) {
                z2 = true;
            }
            iArr = xj(u.optString("allow_error_code"));
            i2 = optInt3;
            z = z2;
            i3 = optInt;
            i4 = optInt2;
        } else {
            iArr = null;
            i2 = 60;
            i3 = 60;
            z = false;
        }
        return new xj(i, xj3, i3, i4 * 1000, i2 * 1000, z, iArr);
    }

    private void w(int i) {
        synchronized (this.u) {
            this.u.remove(i);
        }
    }

    public void kd() {
        xj(5, false);
    }

    private xj hf(int i) {
        xj xjVar;
        xj xjVar2 = this.u.get(i);
        if (xjVar2 != null) {
            return xjVar2;
        }
        synchronized (this.u) {
            try {
                xjVar = this.u.get(i);
                if (xjVar == null) {
                    xjVar = u(i);
                }
                this.u.put(i, xjVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        return xjVar;
    }

    public static yo xj() {
        if (xj == null) {
            synchronized (yo.class) {
                try {
                    if (xj == null) {
                        xj = new yo();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    @Override // com.ss.android.socialbase.downloader.xj.xj.InterfaceC0510xj
    public void w() {
        xj(3, false);
    }

    @Override // com.ss.android.socialbase.downloader.xj.xj.InterfaceC0510xj
    public void hf() {
        xj(4, false);
    }

    public static void xj(hf hfVar) {
        d = hfVar;
    }

    public void u() {
        xj(2, true);
    }

    public void xj(DownloadInfo downloadInfo) {
        if (downloadInfo == null || TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.kd.xj) || !com.ss.android.socialbase.downloader.constants.kd.xj.equals(downloadInfo.getMimeType())) {
            return;
        }
        xj(downloadInfo, downloadInfo.isOnlyWifi() || downloadInfo.isPauseReserveOnWifi(), c());
    }

    private void xj(DownloadInfo downloadInfo, boolean z, int i) {
        BaseException failedException = downloadInfo.getFailedException();
        if (failedException == null) {
            return;
        }
        xj hf2 = hf(downloadInfo.getId());
        if (hf2.d > hf2.w) {
            com.ss.android.socialbase.downloader.w.xj.u("RetryScheduler", "tryStartScheduleRetry, id = " + hf2.xj + ", mRetryCount = " + hf2.d + ", maxCount = " + hf2.w);
            return;
        }
        int errorCode = failedException.getErrorCode();
        if (!com.ss.android.socialbase.downloader.tf.y.f(failedException) && !com.ss.android.socialbase.downloader.tf.y.d(failedException) && (!downloadInfo.statusInPause() || !downloadInfo.isPauseReserveOnWifi())) {
            if (!xj(hf2, errorCode)) {
                return;
            }
            com.ss.android.socialbase.downloader.w.xj.w("RetryScheduler", "allow error code, id = " + hf2.xj + ", error code = " + errorCode);
        }
        hf2.tf = z;
        synchronized (this.u) {
            try {
                if (!hf2.f13851pl) {
                    hf2.f13851pl = true;
                    this.c++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int u = hf2.u();
        com.ss.android.socialbase.downloader.w.xj.w("RetryScheduler", "tryStartScheduleRetry: id = " + hf2.xj + ", delayTimeMills = " + u + ", mWaitingRetryTasks = " + this.c);
        if (!hf2.y) {
            if (z) {
                return;
            }
            this.w.removeMessages(downloadInfo.getId());
            this.w.sendEmptyMessageDelayed(downloadInfo.getId(), u);
            return;
        }
        if (i == 0) {
            hf2.w();
        }
        hf hfVar = d;
        if (hfVar != null) {
            hfVar.xj(downloadInfo, u, z, i);
        }
        if (this.kd) {
            hf2.xj(System.currentTimeMillis());
            hf2.hf();
            hf2.xj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, boolean z) {
        if (this.c <= 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z) {
                try {
                    if (currentTimeMillis - this.y < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.y = currentTimeMillis;
            com.ss.android.socialbase.downloader.w.xj.w("RetryScheduler", "scheduleAllTaskRetry, level = [" + i + "], force = [" + z + "]");
            if (z) {
                this.w.removeMessages(0);
            }
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.arg1 = i;
            obtain.arg2 = z ? 1 : 0;
            this.w.sendMessageDelayed(obtain, 2000L);
        }
    }

    public void xj(final int i) {
        com.ss.android.socialbase.downloader.downloader.w.pl().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.yo.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    yo yoVar = yo.this;
                    yoVar.xj(i, yoVar.c(), true);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(int i, int i2, boolean z) {
        com.ss.android.socialbase.downloader.downloader.yo reserveWifiStatusListener;
        boolean z2;
        Context context = this.hf;
        if (context == null) {
            return;
        }
        synchronized (this.u) {
            try {
                xj xjVar = this.u.get(i);
                if (xjVar == null) {
                    return;
                }
                boolean z3 = true;
                if (xjVar.f13851pl) {
                    xjVar.f13851pl = false;
                    int i3 = this.c - 1;
                    this.c = i3;
                    if (i3 < 0) {
                        this.c = 0;
                    }
                }
                StringBuilder B9tovu2 = A2egSU.B9tovu(i, "doSchedulerRetryInSubThread: downloadId = ", ", retryCount = ");
                B9tovu2.append(xjVar.d);
                B9tovu2.append(", mWaitingRetryTasksCount = ");
                B9tovu2.append(this.c);
                com.ss.android.socialbase.downloader.w.xj.w("RetryScheduler", B9tovu2.toString());
                DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
                if (downloadInfo == null) {
                    w(i);
                    return;
                }
                com.ss.android.socialbase.downloader.w.xj.kd("RetryScheduler", "doSchedulerRetryInSubThread，id:".concat(String.valueOf(i)));
                int realStatus = downloadInfo.getRealStatus();
                if (realStatus != -3 && realStatus != -4) {
                    if (realStatus == -5 || (realStatus == -2 && downloadInfo.isPauseReserveOnWifi())) {
                        if (realStatus == -2 && (reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.w.tj()).getReserveWifiStatusListener()) != null) {
                            reserveWifiStatusListener.xj(downloadInfo, 4, 3);
                        }
                        com.ss.android.socialbase.downloader.downloader.pl dk = com.ss.android.socialbase.downloader.downloader.w.dk();
                        if (dk != null) {
                            dk.xj(Collections.singletonList(downloadInfo), 3);
                        }
                        w(i);
                        return;
                    }
                    if (realStatus != -1) {
                        return;
                    }
                    if (i2 != 0) {
                        z2 = true;
                    } else if (!xjVar.y) {
                        return;
                    } else {
                        z2 = false;
                    }
                    BaseException failedException = downloadInfo.getFailedException();
                    if (z2 && com.ss.android.socialbase.downloader.tf.y.f(failedException)) {
                        z2 = xj(downloadInfo, failedException);
                    }
                    xjVar.hf();
                    if (z2) {
                        com.ss.android.socialbase.downloader.w.xj.w("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + xjVar.xj);
                        xjVar.xj(System.currentTimeMillis());
                        if (z) {
                            xjVar.xj();
                        }
                        downloadInfo.setRetryScheduleCount(xjVar.d);
                        if (downloadInfo.getStatus() == -1) {
                            Downloader.getInstance(context).restart(downloadInfo.getId());
                            return;
                        }
                        return;
                    }
                    if (z) {
                        xjVar.xj();
                    }
                    if (!downloadInfo.isOnlyWifi() && !downloadInfo.isPauseReserveOnWifi()) {
                        z3 = false;
                    }
                    xj(downloadInfo, z3, i2);
                    return;
                }
                w(i);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean xj(xj xjVar, int i) {
        int[] iArr = xjVar.c;
        if (iArr != null && iArr.length != 0) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length <= 0) {
                return null;
            }
            int[] iArr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                iArr[i] = Integer.parseInt(split[i]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean xj(DownloadInfo downloadInfo, BaseException baseException) {
        long j;
        long totalBytes;
        try {
            j = com.ss.android.socialbase.downloader.tf.y.u(downloadInfo.getTempPath());
        } catch (BaseException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            j = 0;
        }
        if (baseException instanceof com.ss.android.socialbase.downloader.exception.u) {
            totalBytes = ((com.ss.android.socialbase.downloader.exception.u) baseException).hf();
        } else {
            totalBytes = downloadInfo.getTotalBytes() - downloadInfo.getCurBytes();
        }
        if (j < totalBytes) {
            com.ss.android.socialbase.downloader.f.xj xj2 = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId());
            if (xj2.xj("space_fill_part_download", 0) == 1) {
                if (j > 0) {
                    int xj3 = xj2.xj("space_fill_min_keep_mb", 100);
                    if (xj3 > 0) {
                        long j2 = j - (xj3 * BaseConstants.MB_VALUE);
                        com.ss.android.socialbase.downloader.w.xj.w("RetryScheduler", "retry schedule: available = " + com.ss.android.socialbase.downloader.tf.y.xj(j) + "MB, minKeep = " + xj3 + "MB, canDownload = " + com.ss.android.socialbase.downloader.tf.y.xj(j2) + "MB");
                        if (j2 <= 0) {
                            com.ss.android.socialbase.downloader.w.xj.u("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (xj2.xj("download_when_space_negative", 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }
}
