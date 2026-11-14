package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.utils.pl;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DownloadHandlerService extends Service {
    private static final String xj = "DownloadHandlerService";

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void hf(android.content.Context r9, com.ss.android.socialbase.downloader.model.DownloadInfo r10, com.ss.android.socialbase.appdownloader.w.kd r11, com.ss.android.socialbase.downloader.depend.io r12) {
        /*
            r8 = this;
            int r2 = r10.getId()
            com.ss.android.socialbase.downloader.downloader.u r0 = com.ss.android.socialbase.downloader.downloader.u.xj()
            com.ss.android.socialbase.downloader.depend.j r0 = r0.g(r2)
            if (r0 == 0) goto L17
            boolean r0 = r0.xj(r10)     // Catch: java.lang.Throwable -> L13
            goto L18
        L13:
            r0 = move-exception
            com.bytedance.sdk.component.utils.pl.xj(r0)
        L17:
            r0 = 0
        L18:
            if (r0 != 0) goto L51
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity> r1 = com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.class
            r0.<init>(r9, r1)
            java.lang.String r1 = "extra_click_download_ids"
            r0.putExtra(r1, r2)
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r1)
            r9.startActivity(r0)
            com.ss.android.socialbase.downloader.notification.hf r9 = com.ss.android.socialbase.downloader.notification.hf.xj()
            r9.xj(r2)
            r10.updateDownloadTime()
            if (r11 == 0) goto L49
            int r5 = r10.getStatus()
            long r6 = r10.getDownloadTime()
            r3 = 7
            java.lang.String r4 = ""
            r1 = r11
            r1.xj(r2, r3, r4, r5, r6)
        L49:
            if (r12 == 0) goto L51
            r9 = 7
            java.lang.String r11 = ""
            r12.xj(r9, r10, r11, r11)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.DownloadHandlerService.hf(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.socialbase.appdownloader.w.kd, com.ss.android.socialbase.downloader.depend.io):void");
    }

    private void w(Context context, DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.w.kd kdVar, io ioVar) {
        int id = downloadInfo.getId();
        Intent intent = new Intent(context, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        context.startActivity(intent);
        com.ss.android.socialbase.downloader.notification.hf.xj().xj(id);
        downloadInfo.updateDownloadTime();
        if (kdVar != null) {
            kdVar.xj(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (ioVar != null) {
            ioVar.xj(7, downloadInfo, "", "");
        }
    }

    private boolean xj(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.ss.android.socialbase.appdownloader.w.kd w = u.p().w();
        io downloadNotificationEventListener = Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        if (intent.getBooleanExtra("extra_from_notification", false) && com.ss.android.socialbase.downloader.f.xj.xj(intExtra).hf("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.hf.xj().y(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            hf(context, downloadInfo, w, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            xj(context, downloadInfo, w, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            xj(context, downloadInfo, w, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && com.ss.android.socialbase.downloader.f.xj.xj(intExtra).xj("no_hide_notification", 0) == 0 && (com.ss.android.socialbase.downloader.f.xj.xj(intExtra).hf("enable_notification_ui") < 2 || downloadInfo.getStatus() != -1)) {
                com.ss.android.socialbase.downloader.notification.hf.xj().xj(intExtra);
                com.ss.android.socialbase.downloader.notification.hf.xj().y(intExtra);
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            w(context, downloadInfo, w, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            com.ss.android.socialbase.downloader.notification.hf.xj().xj(intExtra);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            com.ss.android.socialbase.downloader.downloader.w.pl().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(AdBaseConstants.MIME_APK);
                        arrayList.add("mime_type_plg");
                        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.w.tj()).restartAllFailedDownloadTasks(arrayList);
                    } catch (Exception e) {
                        pl.xj(e);
                    }
                }
            });
            return true;
        }
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.ss.android.socialbase.downloader.downloader.w.xj(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (com.ss.android.socialbase.downloader.w.xj.xj()) {
            com.ss.android.socialbase.downloader.w.xj.hf(xj, "onStartCommand");
        }
        xj(com.ss.android.socialbase.downloader.downloader.w.tj(), intent);
        stopSelf();
        return 2;
    }

    private static void xj(Context context, DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.tf.y.hf(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    private static void xj(Context context, final com.ss.android.socialbase.appdownloader.w.kd kdVar, final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        final io downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (kdVar == null && downloadNotificationEventListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.w.pl().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.2
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo xj2;
                try {
                    File file = new File(DownloadInfo.this.getSavePath(), DownloadInfo.this.getName());
                    if (file.exists()) {
                        try {
                            String str = (com.ss.android.socialbase.downloader.downloader.w.tj() == null || (xj2 = w.xj(DownloadInfo.this, file)) == null) ? "" : xj2.packageName;
                            com.ss.android.socialbase.appdownloader.w.kd kdVar2 = kdVar;
                            if (kdVar2 != null) {
                                kdVar2.xj(DownloadInfo.this.getId(), 3, str, -3, DownloadInfo.this.getDownloadTime());
                            }
                            io ioVar = downloadNotificationEventListener;
                            if (ioVar != null) {
                                ioVar.xj(3, DownloadInfo.this, str, "");
                            }
                        } catch (Exception e) {
                            pl.xj(e);
                        }
                    }
                } catch (Exception e2) {
                    pl.xj(e2);
                }
            }
        });
    }

    private static void xj(Context context, int i, boolean z) {
        boolean z2;
        j g;
        DownloadInfo downloadInfo;
        if (z && (g = com.ss.android.socialbase.downloader.downloader.u.xj().g(i)) != null) {
            try {
                downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
            } catch (Throwable th) {
                pl.xj(th);
            }
            if (downloadInfo != null) {
                z2 = g.hf(downloadInfo);
                if (z2 && w.xj(context, i, true) == 0) {
                    Toast.makeText(context, "Open Fail!", 0).show();
                }
                return;
            }
        }
        z2 = false;
        if (z2) {
            return;
        }
        Toast.makeText(context, "Open Fail!", 0).show();
    }

    public static void xj(Context context, DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.w.kd kdVar, io ioVar) {
        com.ss.android.socialbase.downloader.notification.xj kd;
        int id = downloadInfo.getId();
        j g = com.ss.android.socialbase.downloader.downloader.u.xj().g(id);
        if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && g != null && w.xj(context, downloadInfo) && g.w(downloadInfo)) {
            return;
        }
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (com.ss.android.socialbase.downloader.f.xj.xj(id).hf("enable_notification_ui") >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                Downloader.getInstance(context).restart(id);
                break;
            case -3:
                xj(com.ss.android.socialbase.downloader.downloader.w.tj(), id, true);
                xj(context, kdVar, downloadInfo);
                if (com.ss.android.socialbase.downloader.f.xj.xj(id).xj("notification_click_install_auto_cancel", 1) == 0 && (kd = com.ss.android.socialbase.downloader.notification.hf.xj().kd(id)) != null) {
                    kd.c();
                    kd.xj(-3, null, false, true);
                    break;
                } else {
                    com.ss.android.socialbase.downloader.notification.hf.xj().xj(id);
                    break;
                }
                break;
            case -2:
                if (com.ss.android.socialbase.downloader.downloader.u.xj().kd(id)) {
                    Downloader.getInstance(context).resume(id);
                } else {
                    w.xj(downloadInfo, true, false);
                }
                if (kdVar != null) {
                    kdVar.xj(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (ioVar != null) {
                    ioVar.xj(6, downloadInfo, "", "");
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                Downloader.getInstance(context).pause(id);
                xj(context, downloadInfo);
                if (kdVar != null) {
                    kdVar.xj(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (ioVar != null) {
                    ioVar.xj(5, downloadInfo, "", "");
                    break;
                }
                break;
        }
    }
}
