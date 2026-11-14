package com.ss.android.socialbase.appdownloader.u;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ss.android.socialbase.appdownloader.u;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.pl;
import com.ss.android.socialbase.downloader.downloader.w;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.tf.y;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf implements pl {
    private BroadcastReceiver hf;
    private List<Integer> xj;

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(List<DownloadInfo> list, int i) {
        if (list == null || list.isEmpty()) {
            return;
        }
        u.p();
        Context tj = w.tj();
        if (tj == null) {
            return;
        }
        boolean hf = y.hf(tj);
        Iterator<DownloadInfo> it = list.iterator();
        while (it.hasNext()) {
            xj(tj, it.next(), hf, i);
        }
        List<Integer> list2 = this.xj;
        if (list2 == null || list2.isEmpty() || this.hf != null) {
            return;
        }
        this.hf = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.u.hf.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (y.hf(applicationContext)) {
                    com.ss.android.socialbase.downloader.w.xj.hf("LaunchResume", "onReceive : wifi connected !!!");
                    w.pl().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.u.hf.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (hf.this.xj != null && !hf.this.xj.isEmpty()) {
                                    int size = hf.this.xj.size();
                                    Integer[] numArr = new Integer[size];
                                    hf.this.xj.toArray(numArr);
                                    hf.this.xj.clear();
                                    for (int i2 = 0; i2 < size; i2++) {
                                        DownloadInfo downloadInfo = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i2].intValue());
                                        if (downloadInfo != null) {
                                            if (downloadInfo.getRealStatus() != -5) {
                                                if (downloadInfo.getRealStatus() == -2 && downloadInfo.isPauseReserveOnWifi()) {
                                                }
                                            }
                                            hf.this.xj(applicationContext, downloadInfo, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                com.bytedance.sdk.component.utils.pl.xj(e);
                            }
                        }
                    });
                    try {
                        applicationContext.unregisterReceiver(hf.this.hf);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.pl.xj(th);
                    }
                    hf.this.hf = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            tj.registerReceiver(this.hf, intentFilter);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            this.hf = null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pl
    public List<String> xj() {
        return com.ss.android.socialbase.appdownloader.w.w();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pl
    public void xj(final List<DownloadInfo> list, final int i) {
        if (y.u()) {
            w.pl().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.u.hf.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        hf.this.hf(list, i);
                    } catch (Exception e) {
                        com.bytedance.sdk.component.utils.pl.xj(e);
                    }
                }
            });
        } else {
            hf(list, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(android.content.Context r22, com.ss.android.socialbase.downloader.model.DownloadInfo r23, boolean r24, int r25) {
        /*
            Method dump skipped, instructions count: 612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.u.hf.xj(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, boolean, int):void");
    }

    private void xj(DownloadInfo downloadInfo, Context context) {
        com.ss.android.socialbase.downloader.f.xj xj = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId());
        int xj2 = xj.xj("paused_resume_max_count", 0);
        double xj3 = xj.xj("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount >= xj2 || System.currentTimeMillis() - downloadInfo.getLastDownloadTime() >= xj3 * 3600000.0d) {
            return;
        }
        com.ss.android.socialbase.downloader.notification.xj kd = com.ss.android.socialbase.downloader.notification.hf.xj().kd(downloadInfo.getId());
        if (kd == null) {
            com.ss.android.socialbase.appdownloader.kd.xj xjVar = new com.ss.android.socialbase.appdownloader.kd.xj(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
            com.ss.android.socialbase.downloader.notification.hf.xj().xj(xjVar);
            kd = xjVar;
        } else {
            kd.xj(downloadInfo);
        }
        kd.hf(downloadInfo.getTotalBytes());
        kd.xj(downloadInfo.getCurBytes());
        kd.xj(downloadInfo.getStatus(), null, false, false);
        downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
        downloadInfo.updateSpData();
    }

    private boolean xj(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).hf("uninstall_can_not_resume_for_force_task", false)) {
            return y.xj(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
