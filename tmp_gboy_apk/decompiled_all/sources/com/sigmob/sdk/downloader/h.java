package com.sigmob.sdk.downloader;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.game.boy.activity.ADYaiT;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class h extends com.sigmob.sdk.downloader.core.listener.c {

    /* renamed from: a, reason: collision with root package name */
    private Notification.Builder f13426a;
    private NotificationManager b;
    private RemoteViews c;
    private Context e;

    public h(Context context) {
        this.e = context.getApplicationContext();
        this.c = new RemoteViews(context.getPackageName(), ResourceUtil.getLayoutId(context, "sig_download_notification_layout"));
    }

    @Override // com.sigmob.sdk.downloader.core.listener.c
    public void c(f fVar) {
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_status"), "下载暂停");
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_button"), "继续");
        this.c.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.b.notify(fVar.c(), this.f13426a.build());
    }

    @Override // com.sigmob.sdk.downloader.core.listener.c
    public void d(f fVar) {
    }

    public void a(PendingIntent pendingIntent) {
        this.c.setOnClickPendingIntent(ResourceUtil.getId(this.e, "sig_download_notification_button"), pendingIntent);
    }

    public void b(PendingIntent pendingIntent) {
        this.f13426a.setContentIntent(pendingIntent);
    }

    @Override // com.sigmob.sdk.downloader.core.listener.c
    public void a(f fVar) {
        if (!fVar.m().renameTo(fVar.n())) {
            SigmobLog.e("download temp file renameTo failed");
        }
        SigmobLog.d("FileDownloaderNotificationListener completed ");
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_speed"), "下载完成,立即安装");
        this.c.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 4);
        this.c.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_status"), 8);
        this.f13426a.setOngoing(false);
        this.f13426a.setAutoCancel(true);
        this.b.notify(fVar.c(), this.f13426a.build());
    }

    @Override // com.sigmob.sdk.downloader.core.listener.c
    public void b(f fVar) {
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_status"), "准备下载");
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_button"), "暂停");
        this.c.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.b.notify(fVar.c(), this.f13426a.build());
    }

    public void a(f fVar, int i, long j, long j2) {
        StringBuilder sb;
        String str;
        RemoteViews remoteViews = this.c;
        int id = ResourceUtil.getId(this.e, "sig_download_notification_speed");
        if (j > BaseConstants.MB_VALUE) {
            sb = new StringBuilder();
            sb.append((j / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            str = "M/";
        } else {
            sb = new StringBuilder();
            sb.append(j / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            str = "KB/";
        }
        sb.append(str);
        sb.append((j2 / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
        sb.append("M");
        remoteViews.setTextViewText(id, sb.toString());
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_status"), "正在下载");
        this.c.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.b.notify(fVar.c(), this.f13426a.build());
    }

    public void a(f fVar, long j, long j2) {
        StringBuilder sb;
        String str;
        RemoteViews remoteViews = this.c;
        int id = ResourceUtil.getId(this.e, "sig_download_notification_speed");
        if (j > BaseConstants.MB_VALUE) {
            sb = new StringBuilder();
            sb.append((j / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            str = "M/";
        } else {
            sb = new StringBuilder();
            sb.append(j / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            str = "KB/";
        }
        sb.append(str);
        sb.append((j2 / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) / ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS);
        sb.append("M");
        remoteViews.setTextViewText(id, sb.toString());
        if (j2 > 0) {
            this.c.setProgressBar(ResourceUtil.getId(this.e, "sig_download_notification_progressBar"), 100, (int) ((j * 100) / j2), false);
        }
        this.c.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.b.notify(fVar.c(), this.f13426a.build());
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0455a
    public void a(f fVar, com.sigmob.sdk.downloader.core.cause.b bVar) {
    }

    @Override // com.sigmob.sdk.downloader.core.listener.c
    public void a(f fVar, Exception exc) {
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_status"), "下载失败");
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_button"), "重试");
        this.c.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.b.notify(fVar.c(), this.f13426a.build());
    }

    public void a(String str, String str2, String str3) {
        this.b = (NotificationManager) this.e.getSystemService("notification");
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.b.createNotificationChannel(ADYaiT.BV3sI0());
        }
        this.f13426a = i >= 26 ? ADYaiT.A5SV6n(this.e) : new Notification.Builder(this.e);
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_title"), str2);
        if (!TextUtils.isEmpty(str)) {
            try {
                com.sigmob.sdk.base.common.h.a().getBitmap(str, new ImageManager.BitmapLoadedListener() { // from class: com.sigmob.sdk.downloader.h.1
                    @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
                    public void onBitmapLoadFailed() {
                    }

                    @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
                    public void onBitmapLoaded(Bitmap bitmap) {
                        h.this.c.setImageViewBitmap(ResourceUtil.getId(h.this.e, "sig_download_notification_icon"), bitmap);
                    }
                });
            } catch (Throwable unused) {
            }
        }
        this.c.setProgressBar(ResourceUtil.getId(this.e, "sig_download_notification_progress"), 100, 0, false);
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_speed"), "0M/0M");
        this.c.setTextViewText(ResourceUtil.getId(this.e, "sig_download_notification_status"), "等待开始");
        this.c.setViewVisibility(ResourceUtil.getId(this.e, "sig_download_notification_button"), 0);
        this.f13426a.setDefaults(4).setOngoing(true).setSmallIcon(this.e.getApplicationInfo().icon).setPriority(0);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f13426a.setCustomContentView(this.c);
        } else {
            this.f13426a.setContent(this.c);
        }
    }
}
