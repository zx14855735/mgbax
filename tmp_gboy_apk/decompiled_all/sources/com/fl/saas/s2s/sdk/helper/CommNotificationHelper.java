package com.fl.saas.s2s.sdk.helper;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.BV3sI0;
import com.fl.saas.s2s.R;
import com.fl.saas.s2s.sdk.helper.download.DownloadActionReceiver;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CommNotificationHelper extends ContextWrapper {
    private static String CHANNEL_ID = "yd_download_notification";
    public static String NOTIFICATION_CANCEL_DOWNLOAD = "com.fl.saas.s2s.sdk.helper.download.action.cancel";
    private static final int NOTIFICATION_ID = 0;
    public static String NOTIFICATION_PAUSE_DOWNLOAD = "com.fl.saas.s2s.sdk.helper.download.action.pause";
    public static String NOTIFICATION_START_DOWNLOAD = "com.fl.saas.s2s.sdk.helper.download.action.start";
    private String appName;
    private BV3sI0 builder;
    private String downLoadUrl;
    private NotificationManager manager;
    private RemoteViews remoteViews;

    public CommNotificationHelper(Context context, String str, String str2) {
        super(context);
        this.downLoadUrl = str;
        this.appName = str2;
        str2 = TextUtils.isEmpty(str2) ? "正在下载应用" : str2;
        RemoteViews remoteViews = new RemoteViews(context.getApplicationContext().getPackageName(), R.layout.s2s_download_notification);
        this.remoteViews = remoteViews;
        remoteViews.setImageViewBitmap(R.id.iv_logo, getLargeIcon());
        this.remoteViews.setTextViewText(R.id.tv_name, str2);
        Intent intent = new Intent(this, (Class<?>) DownloadActionReceiver.class);
        intent.setAction(NOTIFICATION_PAUSE_DOWNLOAD);
        intent.putExtra("downLoadUrl", str);
        int i = Build.VERSION.SDK_INT;
        this.remoteViews.setOnClickPendingIntent(R.id.tv_action, PendingIntent.getBroadcast(this, 0, intent, i >= 31 ? 33554432 : 134217728));
        Intent intent2 = new Intent(this, (Class<?>) DownloadActionReceiver.class);
        intent2.setAction(NOTIFICATION_CANCEL_DOWNLOAD);
        intent2.putExtra("downLoadUrl", str);
        this.remoteViews.setOnClickPendingIntent(R.id.tv_cancel, PendingIntent.getBroadcast(this, 0, intent2, i >= 31 ? 33554432 : 134217728));
        if (i >= 26) {
            JMFfuZ.A2egSU.AaHO0E();
            NotificationChannel A5SV6n2 = com.bytedance.pangle.wrapper.A2egSU.A5SV6n(CHANNEL_ID);
            A5SV6n2.setSound(null, null);
            A5SV6n2.enableLights(true);
            A5SV6n2.setLightColor(-65536);
            A5SV6n2.setShowBadge(true);
            getManager().createNotificationChannel(A5SV6n2);
        }
        this.builder = getNotification();
        getManager().notify(0, this.builder.A2egSU());
    }

    private Bitmap getLargeIcon() {
        int identifier = getResources().getIdentifier("s2s_ic_download", "drawable", getPackageName());
        if (identifier != 0) {
            return BitmapFactory.decodeResource(getResources(), identifier);
        }
        return null;
    }

    private NotificationManager getManager() {
        if (this.manager == null) {
            this.manager = (NotificationManager) getSystemService("notification");
        }
        return this.manager;
    }

    private BV3sI0 getNotification() {
        BV3sI0 bV3sI0 = new BV3sI0(this, CHANNEL_ID);
        bV3sI0.f8551CikNvS.icon = getSmallIcon();
        bV3sI0.ARc23Z(getLargeIcon());
        RemoteViews remoteViews = this.remoteViews;
        bV3sI0.f8541C2rE4F = remoteViews;
        bV3sI0.f8543CASmeH = remoteViews;
        bV3sI0.f8542C4FrIb = remoteViews;
        bV3sI0.f8551CikNvS.contentView = remoteViews;
        bV3sI0.AMqCpz(16, true);
        bV3sI0.f8522AlLFFp = -1;
        bV3sI0.ADYaiT(-1);
        return bV3sI0;
    }

    private int getSmallIcon() {
        int identifier = getResources().getIdentifier("s2s_ic_download", "drawable", getPackageName());
        return identifier == 0 ? getApplicationInfo().icon : identifier;
    }

    public void cancel() {
        getManager().cancel(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
    
        r0 = 33554432;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 31) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 31) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0048, code lost:
    
        r0 = 134217728;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void changeActionText(boolean r6) {
        /*
            r5 = this;
            androidx.core.app.BV3sI0 r0 = r5.builder
            if (r0 == 0) goto L6f
            android.widget.RemoteViews r0 = r5.remoteViews
            if (r0 == 0) goto L6f
            r1 = 31
            java.lang.String r2 = "downLoadUrl"
            java.lang.Class<com.fl.saas.s2s.sdk.helper.download.DownloadActionReceiver> r3 = com.fl.saas.s2s.sdk.helper.download.DownloadActionReceiver.class
            if (r6 == 0) goto L2b
            int r6 = com.fl.saas.s2s.R.id.tv_action
            java.lang.String r4 = "暂停"
            r0.setTextViewText(r6, r4)
            android.content.Intent r6 = new android.content.Intent
            r6.<init>(r5, r3)
            java.lang.String r0 = com.fl.saas.s2s.sdk.helper.CommNotificationHelper.NOTIFICATION_PAUSE_DOWNLOAD
            r6.setAction(r0)
            java.lang.String r0 = r5.downLoadUrl
            r6.putExtra(r2, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r1) goto L48
            goto L45
        L2b:
            int r6 = com.fl.saas.s2s.R.id.tv_action
            java.lang.String r4 = "继续"
            r0.setTextViewText(r6, r4)
            android.content.Intent r6 = new android.content.Intent
            r6.<init>(r5, r3)
            java.lang.String r0 = com.fl.saas.s2s.sdk.helper.CommNotificationHelper.NOTIFICATION_START_DOWNLOAD
            r6.setAction(r0)
            java.lang.String r0 = r5.downLoadUrl
            r6.putExtra(r2, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r1) goto L48
        L45:
            r0 = 33554432(0x2000000, float:9.403955E-38)
            goto L4a
        L48:
            r0 = 134217728(0x8000000, float:3.85186E-34)
        L4a:
            r1 = 0
            android.app.PendingIntent r6 = android.app.PendingIntent.getBroadcast(r5, r1, r6, r0)
            android.widget.RemoteViews r0 = r5.remoteViews
            int r2 = com.fl.saas.s2s.R.id.tv_action
            r0.setOnClickPendingIntent(r2, r6)
            android.app.NotificationManager r6 = r5.getManager()
            androidx.core.app.BV3sI0 r0 = r5.builder
            android.widget.RemoteViews r2 = r5.remoteViews
            r0.f8541C2rE4F = r2
            r0.f8543CASmeH = r2
            r0.f8542C4FrIb = r2
            android.app.Notification r3 = r0.f8551CikNvS
            r3.contentView = r2
            android.app.Notification r0 = r0.A2egSU()
            r6.notify(r1, r0)
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fl.saas.s2s.sdk.helper.CommNotificationHelper.changeActionText(boolean):void");
    }

    public void updateProgress(int i, String str) {
        RemoteViews remoteViews;
        String str2 = i + "%";
        if (this.builder == null || (remoteViews = this.remoteViews) == null) {
            return;
        }
        remoteViews.setTextViewText(R.id.tv_down_tips, str);
        this.remoteViews.setTextViewText(R.id.tv_progress, str2);
        this.remoteViews.setProgressBar(R.id.pb_progress, 100, i, false);
        NotificationManager manager = getManager();
        BV3sI0 bV3sI0 = this.builder;
        RemoteViews remoteViews2 = this.remoteViews;
        bV3sI0.f8541C2rE4F = remoteViews2;
        bV3sI0.f8543CASmeH = remoteViews2;
        bV3sI0.f8542C4FrIb = remoteViews2;
        bV3sI0.f8551CikNvS.contentView = remoteViews2;
        manager.notify(0, bV3sI0.A2egSU());
    }
}
