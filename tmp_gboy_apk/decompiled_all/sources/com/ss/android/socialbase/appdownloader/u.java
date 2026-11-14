package com.ss.android.socialbase.appdownloader;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.utils.pl;
import com.sigmob.sdk.base.n;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity;
import com.ss.android.socialbase.appdownloader.w.am;
import com.ss.android.socialbase.appdownloader.w.p;
import com.ss.android.socialbase.appdownloader.w.zg;
import com.ss.android.socialbase.downloader.depend.en;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.yo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u {
    private static boolean c = false;
    private static boolean f = false;
    private static volatile u hf = null;
    private static final String xj = "u";
    private static boolean y;
    private com.ss.android.socialbase.appdownloader.w.kd am;
    private Future d;
    private am e;
    private com.ss.android.socialbase.appdownloader.w.u g;
    private zg ht;
    private q jk;
    private DownloadReceiver kd = new DownloadReceiver();
    private boolean p = false;

    /* renamed from: pl, reason: collision with root package name */
    private boolean f13836pl = false;
    private en pz;
    private com.ss.android.socialbase.appdownloader.w.d qt;
    private com.ss.android.socialbase.appdownloader.w.w ra;
    private int tf;
    private String u;
    private p v;
    private String w;
    private com.ss.android.socialbase.appdownloader.w.c yo;
    private com.ss.android.socialbase.appdownloader.w.f zg;

    private u() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jk() {
        synchronized (this.kd) {
            if (c) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addDataScheme(n.z);
                com.ss.android.socialbase.downloader.downloader.w.tj().registerReceiver(this.kd, intentFilter);
                com.ss.android.socialbase.downloader.downloader.w.tj().registerReceiver(this.kd, intentFilter2);
                c = true;
            } catch (Exception e) {
                pl.xj(e);
            }
            com.ss.android.socialbase.downloader.w.xj.hf(xj, "registerDownloadReceiver mIsRegistered:" + c);
        }
    }

    public static u p() {
        if (hf == null) {
            synchronized (u.class) {
                try {
                    if (hf == null) {
                        hf = new u();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    private void pz() {
        yo.xj(new yo.hf() { // from class: com.ss.android.socialbase.appdownloader.u.3
            @Override // com.ss.android.socialbase.downloader.impls.yo.hf
            public void xj(DownloadInfo downloadInfo, long j, boolean z, int i) {
                RetryJobSchedulerService.xj(downloadInfo, j, z, i);
            }
        });
    }

    public am am() {
        return this.e;
    }

    public boolean c() {
        return com.ss.android.socialbase.downloader.f.xj.hf().optInt("package_flag_config", 1) == 1;
    }

    public File d() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.w.tj()).getGlobalSaveDir();
    }

    public q e() {
        return this.jk;
    }

    public p f() {
        return this.v;
    }

    public void g() {
        zg zgVar;
        synchronized (this.kd) {
            try {
                if (c) {
                    com.ss.android.socialbase.downloader.downloader.w.tj().unregisterReceiver(this.kd);
                    if (f && (zgVar = this.ht) != null) {
                        zgVar.hf();
                    }
                }
            } catch (Exception e) {
                pl.xj(e);
            }
            c = false;
            f = false;
        }
        com.ss.android.socialbase.downloader.w.xj.hf(xj, "registerDownloadReceiver unRegisterDownloadReceiver");
    }

    public String kd() {
        return this.u;
    }

    public void pl() {
        if (com.ss.android.socialbase.downloader.f.xj.w().xj("enable_app_install_receiver", 1) <= 0) {
            com.ss.android.socialbase.downloader.w.xj.hf(xj, "disable app install receiver");
            return;
        }
        synchronized (this.kd) {
            try {
                if (f) {
                    return;
                }
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                    intentFilter.addDataScheme("package");
                    com.ss.android.socialbase.downloader.downloader.w.tj().registerReceiver(this.kd, intentFilter);
                    f = true;
                    zg zgVar = this.ht;
                    if (zgVar != null) {
                        zgVar.xj();
                    }
                } catch (Throwable th) {
                    pl.xj(th);
                }
                com.ss.android.socialbase.downloader.w.xj.hf(xj, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + c);
            } finally {
                hf(0);
            }
        }
    }

    public com.ss.android.socialbase.appdownloader.w.f qt() {
        return this.zg;
    }

    public String tf() {
        return this.w;
    }

    public com.ss.android.socialbase.appdownloader.w.d u() {
        return this.qt;
    }

    public com.ss.android.socialbase.appdownloader.w.kd w() {
        return this.am;
    }

    public com.ss.android.socialbase.appdownloader.w.c y() {
        return this.yo;
    }

    public en yo() {
        return this.pz;
    }

    public com.ss.android.socialbase.downloader.downloader.yo zg() {
        return Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.w.tj()).getReserveWifiStatusListener();
    }

    private void w(Context context) {
        if (context == null || y) {
            return;
        }
        com.ss.android.socialbase.downloader.constants.kd.xj(AdBaseConstants.MIME_APK);
        com.ss.android.socialbase.downloader.downloader.w.xj(context);
        com.ss.android.socialbase.downloader.downloader.w.xj(new com.ss.android.socialbase.appdownloader.u.hf());
        if (this.f13836pl) {
            com.ss.android.socialbase.downloader.downloader.w.xj(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.u.1
                @Override // java.lang.Runnable
                public void run() {
                    u.this.jk();
                }
            }, 5L, TimeUnit.SECONDS);
        } else {
            jk();
        }
        pz();
        y = true;
    }

    public com.ss.android.socialbase.appdownloader.w.u hf() {
        return this.g;
    }

    public void hf(String str) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.w.tj()).setDefaultSavePath(str);
    }

    public com.ss.android.socialbase.appdownloader.w.w xj() {
        return this.ra;
    }

    private void hf(int i) {
        this.tf = com.ss.android.socialbase.downloader.f.xj.w().xj("app_install_keep_receiver_time_s", 60);
        com.ss.android.socialbase.downloader.w.xj.hf(xj, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.tf);
        if (this.tf <= 0) {
            return;
        }
        if (i > 0) {
            this.tf = i;
        }
        Future future = this.d;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        this.d = com.ss.android.socialbase.downloader.downloader.w.xj(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.u.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.w.xj.hf(u.xj, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
                u.this.g();
                u.this.jk();
            }
        }, this.tf, TimeUnit.SECONDS);
    }

    public void xj(com.ss.android.socialbase.appdownloader.w.w wVar) {
        this.ra = wVar;
    }

    public void xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.u = str;
    }

    public void xj(com.ss.android.socialbase.appdownloader.w.c cVar) {
        this.yo = cVar;
    }

    public void xj(p pVar) {
        this.v = pVar;
    }

    @Deprecated
    public void xj(Context context, String str, com.ss.android.socialbase.appdownloader.w.u uVar, com.ss.android.socialbase.appdownloader.w.kd kdVar, com.ss.android.socialbase.appdownloader.w.d dVar) {
        if (uVar != null) {
            this.g = uVar;
        }
        if (kdVar != null) {
            this.am = kdVar;
        }
        if (dVar != null) {
            this.qt = dVar;
        }
        w(context);
    }

    private DownloadInfo hf(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList == null) {
            return null;
        }
        for (DownloadInfo downloadInfo : downloadInfoList) {
            if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                return downloadInfo;
            }
        }
        return null;
    }

    public static boolean xj(Context context, int i) {
        return w.xj(context, i, true) == 1;
    }

    public void xj(Context context, int i, int i2) {
        try {
            switch (i2) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i);
                    break;
                case -3:
                    w.xj(context, i, true);
                    break;
                case -2:
                    Downloader.getInstance(context).resume(i);
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    Downloader.getInstance(context).pause(i);
                    break;
            }
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public List<DownloadInfo> hf(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public static Pair<Intent, Boolean> hf(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 31 && com.ss.android.socialbase.downloader.f.xj.xj(i).hf("enable_target_34") > 0) {
            return new Pair<>(new Intent(context, (Class<?>) DownloadHandleNotificationActivity.class), Boolean.TRUE);
        }
        return new Pair<>(new Intent(context, (Class<?>) DownloadHandlerService.class), Boolean.FALSE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(30:34|(1:36)|37|(2:41|42)|45|(1:52)|53|(2:59|(1:61)(22:62|63|(1:65)|66|(3:68|(5:71|72|73|74|69)|79)|81|82|83|(1:85)(1:122)|86|87|88|89|90|91|(6:96|(1:100)|101|(1:105)|(1:(1:117)(1:116))|118)|119|(2:98|100)|101|(2:103|105)|(0)|118))|125|63|(0)|66|(0)|81|82|83|(0)(0)|86|87|88|89|90|91|(7:93|96|(0)|101|(0)|(0)|118)|119|(0)|101|(0)|(0)|118) */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0182, code lost:
    
        r16 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0184, code lost:
    
        r18 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0348 A[Catch: all -> 0x016b, TryCatch #4 {all -> 0x016b, blocks: (B:74:0x0162, B:81:0x016e, B:91:0x01a5, B:93:0x01ab, B:98:0x01b7, B:100:0x01c3, B:101:0x01ce, B:103:0x0348, B:105:0x0352, B:108:0x035d, B:110:0x0363, B:112:0x0369, B:114:0x0373, B:116:0x0379, B:117:0x038b), top: B:73:0x0162 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0187 A[Catch: all -> 0x0182, TRY_LEAVE, TryCatch #0 {all -> 0x0182, blocks: (B:83:0x0174, B:85:0x017a, B:122:0x0187), top: B:82:0x0174 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0143 A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:6:0x0011, B:10:0x0024, B:13:0x002d, B:15:0x003b, B:16:0x0049, B:18:0x0051, B:19:0x005a, B:22:0x0064, B:24:0x0070, B:27:0x007c, B:29:0x008a, B:30:0x008e, B:32:0x0095, B:34:0x009f, B:37:0x00aa, B:39:0x00be, B:45:0x00d8, B:48:0x00f1, B:50:0x00f7, B:53:0x0106, B:55:0x010c, B:57:0x0112, B:59:0x0118, B:61:0x011e, B:62:0x0129, B:63:0x013d, B:65:0x0143, B:66:0x0148, B:68:0x0152, B:69:0x0156, B:71:0x015c), top: B:5:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0152 A[Catch: all -> 0x0044, TryCatch #1 {all -> 0x0044, blocks: (B:6:0x0011, B:10:0x0024, B:13:0x002d, B:15:0x003b, B:16:0x0049, B:18:0x0051, B:19:0x005a, B:22:0x0064, B:24:0x0070, B:27:0x007c, B:29:0x008a, B:30:0x008e, B:32:0x0095, B:34:0x009f, B:37:0x00aa, B:39:0x00be, B:45:0x00d8, B:48:0x00f1, B:50:0x00f7, B:53:0x0106, B:55:0x010c, B:57:0x0112, B:59:0x0118, B:61:0x011e, B:62:0x0129, B:63:0x013d, B:65:0x0143, B:66:0x0148, B:68:0x0152, B:69:0x0156, B:71:0x015c), top: B:5:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x017a A[Catch: all -> 0x0182, TryCatch #0 {all -> 0x0182, blocks: (B:83:0x0174, B:85:0x017a, B:122:0x0187), top: B:82:0x0174 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b7 A[Catch: all -> 0x016b, TryCatch #4 {all -> 0x016b, blocks: (B:74:0x0162, B:81:0x016e, B:91:0x01a5, B:93:0x01ab, B:98:0x01b7, B:100:0x01c3, B:101:0x01ce, B:103:0x0348, B:105:0x0352, B:108:0x035d, B:110:0x0363, B:112:0x0369, B:114:0x0373, B:116:0x0379, B:117:0x038b), top: B:73:0x0162 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int xj(com.ss.android.socialbase.appdownloader.y r20) {
        /*
            Method dump skipped, instructions count: 976
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.u.xj(com.ss.android.socialbase.appdownloader.y):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(DownloadTask downloadTask, int i, boolean z) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i);
        }
        if (downloadInfo == null || !z) {
            return;
        }
        downloadInfo.setSavePathRedirected(z);
    }

    private List<com.ss.android.socialbase.downloader.model.w> xj(List<com.ss.android.socialbase.downloader.model.w> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.model.w wVar : list) {
                if (wVar != null && !TextUtils.isEmpty(wVar.xj()) && !TextUtils.isEmpty(wVar.hf())) {
                    if (wVar.xj().equals("User-Agent")) {
                        z = true;
                    }
                    arrayList.add(new com.ss.android.socialbase.downloader.model.w(wVar.xj(), wVar.hf()));
                }
            }
        }
        if (!z) {
            arrayList.add(new com.ss.android.socialbase.downloader.model.w("User-Agent", com.ss.android.socialbase.appdownloader.hf.xj.xj));
        }
        return arrayList;
    }

    public String xj(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || w.w(str2)) ? str2 : AdBaseConstants.MIME_APK;
    }

    private io xj(final com.ss.android.socialbase.appdownloader.w.y yVar) {
        if (yVar == null) {
            return null;
        }
        return new io() { // from class: com.ss.android.socialbase.appdownloader.u.6
            @Override // com.ss.android.socialbase.downloader.depend.io
            public void xj(int i, DownloadInfo downloadInfo, String str, String str2) {
                if (i != 1 && i != 3) {
                    switch (i) {
                        case 8:
                            downloadInfo.getPackageName();
                            break;
                        case 9:
                            com.ss.android.socialbase.downloader.downloader.w.tj();
                            break;
                    }
                    return;
                }
                downloadInfo.getStatus();
                downloadInfo.getDownloadTime();
            }

            @Override // com.ss.android.socialbase.downloader.depend.io
            public boolean xj(boolean z) {
                return yVar.xj(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.io
            public String xj() {
                return yVar.xj();
            }
        };
    }

    public DownloadInfo xj(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo xj2 = xj(context, str, d());
                if (xj2 == null) {
                    xj2 = xj(context, str, com.bytedance.sdk.openadsdk.api.plugin.hf.xj(context, Environment.DIRECTORY_DOWNLOADS));
                }
                if (xj2 == null) {
                    xj2 = xj(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (xj2 == null) {
                    xj2 = xj(context, str, com.bytedance.sdk.openadsdk.api.plugin.hf.xj(context));
                }
                return (xj2 == null && com.ss.android.socialbase.downloader.f.xj.w().xj("get_download_info_by_list")) ? hf(context, str) : xj2;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.w.xj.hf(xj, "getAppDownloadInfo error:" + th.getMessage());
            }
        }
        return null;
    }

    private DownloadInfo xj(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    public List<DownloadInfo> xj(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public void xj(com.ss.android.socialbase.appdownloader.w.f fVar) {
        this.zg = fVar;
    }

    public void xj(com.ss.android.socialbase.downloader.downloader.yo yoVar) {
        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.w.tj()).setReserveWifiStatusListener(yoVar);
    }

    public void xj(q qVar) {
        this.jk = qVar;
    }

    public void xj(en enVar) {
        this.pz = enVar;
    }

    public void xj(int i) {
        if (com.ss.android.socialbase.downloader.f.xj.w().xj("enable_app_install_receiver", 1) <= 0) {
            return;
        }
        pl();
        hf(i);
    }

    public void xj(zg zgVar) {
        this.ht = zgVar;
    }

    public static PendingIntent xj(Context context, Pair<Intent, Boolean> pair, int i) {
        if (((Boolean) pair.second).booleanValue()) {
            return PendingIntent.getActivity(context, i, (Intent) pair.first, 201326592);
        }
        return PendingIntent.getService(context, i, (Intent) pair.first, 201326592);
    }
}
