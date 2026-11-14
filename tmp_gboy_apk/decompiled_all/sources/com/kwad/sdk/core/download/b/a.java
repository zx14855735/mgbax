package com.kwad.sdk.core.download.b;

import ADYaiT.CtFAbx;
import JMFfuZ.A2egSU;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.game.boy.activity.ADYaiT;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a implements d {
    private static c aIk;
    private boolean aIm = false;
    private boolean aIn = false;
    private int aIo = 0;
    private static HashMap<String, WeakReference<Bitmap>> aIj = new HashMap<>();
    private static final Handler aIl = new HandlerC0361a();

    /* renamed from: com.kwad.sdk.core.download.b.a$a, reason: collision with other inner class name */
    public static class HandlerC0361a extends Handler {
        private final SparseArray<Long> aIp;

        public HandlerC0361a() {
            super(Looper.getMainLooper());
            this.aIp = new SparseArray<>();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z = message.arg1 == 1;
            int i = message.arg2;
            boolean z2 = i == 1;
            boolean z3 = i == 2;
            Long l = this.aIp.get(message.what);
            NotificationManager notificationManager = (NotificationManager) com.kwad.sdk.c.Ce().getContext().getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            if (com.kwad.sdk.c.Ce().cD(message.what) == null && !z3) {
                removeMessages(message.what);
                notificationManager.cancel(message.what);
            } else {
                if (!z && l != null && System.currentTimeMillis() - l.longValue() < 110) {
                    sendMessageDelayed(Message.obtain(message), (l.longValue() + 110) - System.currentTimeMillis());
                    return;
                }
                if (z2) {
                    notificationManager.cancel(message.what);
                }
                a.a(message.what, (Notification) message.obj);
                this.aIp.put(message.what, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public static class b {
        private static String aIq = "ksad_notification_default_icon";
        private String aIr;
        private String aIs;
        private String aIu;
        private String alj;
        private String name;
        private int progress;
        private File aIt = null;
        private boolean aIv = false;

        private b() {
        }

        public static String IR() {
            return aIq;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadTask downloadTask, String str, String str2, boolean z, int i) {
            b bVar = new b();
            Object tag = downloadTask.getTag();
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File cr = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).cr(downloadParams.mAppIcon);
                if (cr != null && cr.exists()) {
                    bVar.aIt = cr;
                }
                bVar.name = downloadParams.mAppName;
            }
            bVar.aIv = downloadTask.isPaused();
            bVar.alj = str;
            bVar.aIu = str2;
            bVar.aIs = a.ax(downloadTask.getSmallFileTotalBytes());
            int a2 = t.a(downloadTask.getSmallFileSoFarBytes(), downloadTask.getSmallFileTotalBytes(), z, i);
            bVar.progress = a2;
            bVar.aIr = a.ax((long) (downloadTask.getSmallFileTotalBytes() * ((a2 * 1.0d) / 100.0d))) + " / " + a.ax(downloadTask.getSmallFileTotalBytes());
            return bVar;
        }

        public final String IS() {
            return this.aIr;
        }

        public final String IT() {
            return this.aIs;
        }

        public final String IU() {
            return this.alj;
        }

        public final File IV() {
            return this.aIt;
        }

        public final String IW() {
            return CtFAbx.AZkASS("%", this.progress, new StringBuilder("正在下载 "));
        }

        public final String IX() {
            return this.aIu;
        }

        public final String getName() {
            String str = this.name;
            return str == null ? "" : str;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final boolean isPaused() {
            return this.aIv;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadParams downloadParams, String str, String str2) {
            File cr;
            b bVar = new b();
            bVar.name = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (cr = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).cr(downloadParams.mAppIcon)) != null && cr.exists()) {
                bVar.aIt = cr;
            }
            bVar.alj = str;
            bVar.aIs = a.ax(downloadParams.mAppSize);
            bVar.aIu = str2;
            return bVar;
        }
    }

    public static class c extends BroadcastReceiver {
        private static void e(Intent intent) {
            DownloadTask g = g(intent);
            if (g == null) {
                return;
            }
            com.kwad.sdk.c.Ce().cF(g.getId());
        }

        private static void f(Intent intent) {
            DownloadTask g = g(intent);
            if (g == null) {
                return;
            }
            g.setNotificationRemoved(true);
        }

        private static DownloadTask g(Intent intent) {
            int i = intent.getExtras().getInt("taskId", 0);
            if (i == 0) {
                return null;
            }
            return com.kwad.sdk.c.Ce().cD(i);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN".equals(action)) {
                e(intent);
            } else if ("com.ksad.action.ACTION_NOTIFICATION_REMOVED".equals(action)) {
                f(intent);
            }
        }
    }

    static {
        SSqqOYQ();
    }

    private static Bitmap I(Context context, String str) {
        WeakReference<Bitmap> weakReference = aIj.get(str);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(ba.dz(context), ba.az(context, str));
        aIj.put(str, new WeakReference<>(decodeResource));
        return decodeResource;
    }

    private static void IQ() {
        if (aIk != null) {
            return;
        }
        aIk = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN");
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        if (Build.VERSION.SDK_INT >= 33) {
            ServiceProvider.Re().registerReceiver(aIk, intentFilter, 2);
        } else {
            ServiceProvider.Re().registerReceiver(aIk, intentFilter);
        }
    }

    private static /* synthetic */ void SSqqOYQ() {
        char[] charArray = " ,.m$\".&m!,:m0+&//m\t-*\u00011*'$&".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'C');
        }
        String str = new String(charArray);
        char[] charArray2 = " /*-*7".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'C');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i, Notification notification) {
        IQ();
        NotificationManager notificationManager = (NotificationManager) ServiceProvider.Re().getSystemService("notification");
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                A2egSU.AaHO0E();
                NotificationChannel ADYaiT2 = ADYaiT.ADYaiT();
                ADYaiT2.enableLights(false);
                ADYaiT2.enableVibration(false);
                ADYaiT2.setSound(null, null);
                ADYaiT2.setShowBadge(false);
                notificationManager.createNotificationChannel(ADYaiT2);
            }
            notificationManager.notify(i, notification);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DefaultLocale"})
    public static String ax(long j) {
        return String.format("%.2fMB", Float.valueOf((j / 1000.0f) / 1000.0f));
    }

    private static DownloadParams m(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        Object tag = downloadTask.getTag();
        DownloadParams downloadParams = tag instanceof DownloadParams ? (DownloadParams) tag : new DownloadParams();
        downloadParams.mAppSize = downloadTask.getSmallFileTotalBytes();
        downloadParams.mTaskId = downloadTask.getId();
        downloadParams.filePath = downloadTask.getTargetFilePath();
        return downloadParams;
    }

    private static Bitmap q(File file) {
        String absolutePath = file.getAbsolutePath();
        WeakReference<Bitmap> weakReference = aIj.get(absolutePath);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath);
        aIj.put(absolutePath, new WeakReference<>(decodeFile));
        return decodeFile;
    }

    @Override // com.kwad.sdk.d
    public final void cG(int i) {
        Context Re = ServiceProvider.Re();
        if (Re == null) {
            return;
        }
        ((NotificationManager) Re.getSystemService("notification")).cancel(i);
    }

    @Override // com.kwad.sdk.d
    public final void cp(String str) {
        Context Re = ServiceProvider.Re();
        DownloadParams dv = com.kwad.sdk.core.a.Gb().dv(str);
        com.kwad.sdk.core.a.Gb().dw(str);
        if (Re == null || dv == null) {
            return;
        }
        com.kwad.sdk.core.a.Gb().dw(dv.filePath);
        b a2 = b.a(dv, "安装完成", "立刻打开");
        com.kwad.sdk.core.download.b.b bH = com.kwad.sdk.core.download.b.b.bH(Re);
        if (bH == null) {
            return;
        }
        a(Re, bH, a2);
        a(Re, bH.build(), false, false, at.d(Re, dv.mPkgname, dv.mTaskId), dv.mTaskId, 1, 2);
    }

    @Override // com.kwad.sdk.d
    public final void g(File file) {
        Context Re = ServiceProvider.Re();
        if (Re == null) {
            return;
        }
        DownloadParams dv = com.kwad.sdk.core.a.Gb().dv(file.getAbsolutePath());
        com.kwad.sdk.core.a.Gb().dw(file.getAbsolutePath());
        if (dv == null) {
            return;
        }
        AdTemplate dx = com.kwad.sdk.core.a.Gb().dx(dv.mDownloadid);
        if (dx != null) {
            dx.installFrom = "recall";
        }
        b a2 = b.a(dv, "下载完成", "立即安装");
        com.kwad.sdk.core.download.b.b bH = com.kwad.sdk.core.download.b.b.bH(Re);
        if (bH == null) {
            return;
        }
        a(Re, bH, a2);
        a(Re, bH.build(), false, false, at.a(Re, file, dv.mTaskId, dv.requestInstallPermission), dv.mTaskId, 1, 2);
    }

    @Override // com.kwad.sdk.d
    public final void i(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File cr = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).cr(str);
            if (cr == null || !cr.exists()) {
                ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).a(true, str, "", "");
            }
        }
    }

    @Override // com.kwad.sdk.d
    public final void j(DownloadTask downloadTask) {
        Context Re = ServiceProvider.Re();
        if (Re == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        String str = (downloadTask.getSmallFileSoFarBytes() <= 0 || downloadTask.getSmallFileTotalBytes() <= 0) ? "准备下载" : "正在下载";
        if (!this.aIm) {
            this.aIm = true;
            this.aIn = ((h) ServiceProvider.get(h.class)).DH();
            this.aIo = ((h) ServiceProvider.get(h.class)).DI();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadError");
        b a2 = b.a(downloadTask, str, null, this.aIn, this.aIo);
        com.kwad.sdk.core.download.b.c a3 = com.kwad.sdk.core.download.b.c.a(Re, downloadTask.getId(), downloadTask.downloadEnablePause);
        if (a3 == null) {
            return;
        }
        a(Re, a3, a2);
        a(Re, a3.build(), false, true, null, downloadTask.getId(), 1, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.kwad.sdk.d
    public final void k(DownloadTask downloadTask) {
        DownloadParams m;
        com.kwad.sdk.core.download.b.b bH;
        Context Re = ServiceProvider.Re();
        if (Re == null || (m = m(downloadTask)) == null || (bH = com.kwad.sdk.core.download.b.b.bH(Re)) == null) {
            return;
        }
        if (!this.aIm) {
            this.aIm = true;
            this.aIn = ((h) ServiceProvider.get(h.class)).DH();
            this.aIo = ((h) ServiceProvider.get(h.class)).DI();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadCompleted");
        a(Re, bH, b.a(downloadTask, "下载完成", "立即安装", this.aIn, this.aIo));
        com.kwad.sdk.core.a.Gb().a(downloadTask.getTargetFilePath(), m);
        com.kwad.sdk.core.a.Gb().a(m.mPkgname, m);
        a(Re, bH.build(), false, false, at.a(Re, new File(downloadTask.getTargetFilePath()), m.mTaskId, m.requestInstallPermission), downloadTask.getId(), 1, 1);
    }

    @Override // com.kwad.sdk.d
    public final void a(DownloadTask downloadTask, boolean z) {
        com.kwad.sdk.core.download.b.c a2;
        Context Re = ServiceProvider.Re();
        if (Re == null || downloadTask.isNotificationRemoved() || (a2 = com.kwad.sdk.core.download.b.c.a(Re, downloadTask.getId(), downloadTask.downloadEnablePause)) == null) {
            return;
        }
        if (!this.aIm) {
            this.aIm = true;
            this.aIn = ((h) ServiceProvider.get(h.class)).DH();
            this.aIo = ((h) ServiceProvider.get(h.class)).DI();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadProgress");
        a(Re, a2, b.a(downloadTask, "正在下载", null, this.aIn, this.aIo));
        a(Re, a2.build(), false, true, null, downloadTask.getId(), z ? 1 : 0, downloadTask.isCompleted() ? 1 : 0);
    }

    private boolean a(com.kwad.sdk.core.download.b.c cVar, File file) {
        try {
            cVar.setIcon(q(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.service.d.gatherException(e);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.c cVar, String str) {
        try {
            cVar.setIcon(I(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.service.d.gatherException(e);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.b.b bVar, File file) {
        try {
            bVar.setIcon(q(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.service.d.gatherException(e);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.b bVar, String str) {
        try {
            bVar.setIcon(I(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.service.d.gatherException(e);
            return false;
        }
    }

    private void a(Context context, RemoteViews remoteViews, boolean z, boolean z2, PendingIntent pendingIntent, int i, int i2, int i3) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(ba.getAppIconId(context));
        a(builder, remoteViews);
        if (z2) {
            Intent intent = new Intent("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
            intent.putExtra("taskId", i);
            builder.setDeleteIntent(at.a(context, i, intent));
        }
        Handler handler = aIl;
        handler.removeMessages(i);
        handler.obtainMessage(i, i2, i3, builder.build()).sendToTarget();
    }

    private static void a(KsNotificationCompat.Builder builder, RemoteViews remoteViews) {
        try {
            builder.setDecoratedCustomStyle().setCustomBigContentView(remoteViews).setCustomContentView(remoteViews);
        } catch (Throwable unused) {
            builder.setContent(remoteViews);
        }
    }

    private void a(Context context, com.kwad.sdk.core.download.b.c cVar, b bVar) {
        cVar.setName(bVar.getName());
        File IV = bVar.IV();
        if (!((IV == null || !IV.exists()) ? false : a(cVar, IV))) {
            a(context, cVar, b.IR());
        }
        cVar.setStatus(bVar.IU());
        cVar.setSize(bVar.IS());
        cVar.setPercentNum(bVar.IW());
        cVar.setProgress(100, bVar.getProgress(), false);
        cVar.setControlBtnPaused(bVar.isPaused());
    }

    private void a(Context context, com.kwad.sdk.core.download.b.b bVar, b bVar2) {
        bVar.setName(bVar2.getName());
        File IV = bVar2.IV();
        if (!((IV == null || !IV.exists()) ? false : a(bVar, IV))) {
            a(context, bVar, b.IR());
        }
        bVar.setStatus(bVar2.IU());
        bVar.setSize(bVar2.IT());
        bVar.setInstallText(bVar2.IX());
    }
}
