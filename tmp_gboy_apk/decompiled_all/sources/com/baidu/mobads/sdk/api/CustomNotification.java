package com.baidu.mobads.sdk.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.BV3sI0;
import androidx.core.app.C2rE4F;
import androidx.core.app.C4FrIb;
import com.baidu.mobads.proxy.R;
import com.baidu.mobads.sdk.internal.bn;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class CustomNotification {
    private static String mChannel = "down";
    private static int mSmallIcon = 17301634;
    private C4FrIb mStyle = new C2rE4F();

    public static void initNotification(int i, String str) {
        mSmallIcon = i;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mChannel = str;
    }

    public static void setNotificationChannel(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mChannel = str;
    }

    public static void setNotificationIcon(int i) {
        mSmallIcon = i;
    }

    private void setRemoteViewText(RemoteViews remoteViews, int i, String str) {
        if (remoteViews != null) {
            if (TextUtils.isEmpty(str)) {
                remoteViews.setViewVisibility(i, 8);
            } else {
                remoteViews.setTextViewText(i, str);
                remoteViews.setViewVisibility(i, 0);
            }
        }
    }

    @TargetApi(16)
    public Notification getCustomNotification(Context context, String str, String str2, Bitmap bitmap, String str3, String str4, String str5, boolean z, int i, int i2, String str6, PendingIntent pendingIntent) {
        BV3sI0 bV3sI0;
        if (bn.a(context).a() < 26) {
            bV3sI0 = new BV3sI0(context, null);
        } else {
            if (TextUtils.isEmpty(str)) {
                str = "down";
            }
            try {
                bV3sI0 = new BV3sI0(context, str);
            } catch (NoSuchMethodError unused) {
                bV3sI0 = new BV3sI0(context, null);
            }
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.mobads_cutom_notification_layout);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R.id.left_icon, bitmap);
        } else {
            remoteViews.setImageViewResource(R.id.left_icon, R.drawable.ic_stat_bd_notif_download);
        }
        setRemoteViewText(remoteViews, R.id.notification_title, str3);
        if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5)) {
            remoteViews.setViewVisibility(R.id.content_layout, 8);
        } else {
            remoteViews.setViewVisibility(R.id.content_layout, 0);
            setRemoteViewText(remoteViews, R.id.content_text, str4);
            setRemoteViewText(remoteViews, R.id.content_status, str5);
        }
        if (i < 0 || i > 100) {
            remoteViews.setViewVisibility(R.id.progress_bar, 8);
        } else {
            remoteViews.setProgressBar(R.id.progress_bar, 100, i, false);
            remoteViews.setViewVisibility(R.id.progress_bar, 0);
        }
        remoteViews.setTextViewText(R.id.btn_action, str6);
        remoteViews.setOnClickPendingIntent(R.id.btn_action, pendingIntent);
        Notification notification = bV3sI0.f8551CikNvS;
        notification.icon = i2;
        bV3sI0.AMqCpz(2, false);
        bV3sI0.f8551CikNvS.tickerText = BV3sI0.A4TApA(str2);
        bV3sI0.AMqCpz(16, z);
        notification.when = System.currentTimeMillis();
        bV3sI0.f8541C2rE4F = remoteViews;
        return bV3sI0.A2egSU();
    }

    @TargetApi(16)
    public Notification getNewNotification(Context context, String str, boolean z, Bitmap bitmap, String str2, String str3, int i, boolean z2, String str4, PendingIntent pendingIntent, String str5, PendingIntent pendingIntent2) {
        BV3sI0 bV3sI0;
        if (bn.a(context).a() < 26) {
            bV3sI0 = new BV3sI0(context, null);
        } else {
            try {
                bV3sI0 = new BV3sI0(context, mChannel);
            } catch (NoSuchMethodError unused) {
                bV3sI0 = new BV3sI0(context, null);
            }
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.baidu_mobads_notification_layout);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R.id.icon, bitmap);
        } else {
            remoteViews.setImageViewResource(R.id.icon, R.drawable.ic_stat_bd_notif_download);
        }
        setRemoteViewText(remoteViews, R.id.title, str2);
        setRemoteViewText(remoteViews, R.id.desc, str3);
        if (i < 0 || i > 100) {
            remoteViews.setViewVisibility(R.id.progress, 8);
        } else {
            remoteViews.setProgressBar(R.id.progress, 100, i, z2);
            remoteViews.setViewVisibility(R.id.progress, 0);
        }
        remoteViews.setTextViewText(R.id.button1, str4);
        remoteViews.setOnClickPendingIntent(R.id.button1, pendingIntent);
        if (TextUtils.isEmpty(str5)) {
            remoteViews.setViewVisibility(R.id.button2, 8);
        } else {
            remoteViews.setViewVisibility(R.id.button2, 0);
            remoteViews.setTextViewText(R.id.button2, str5);
            remoteViews.setOnClickPendingIntent(R.id.button2, pendingIntent2);
        }
        bV3sI0.ASJ6gh(this.mStyle);
        int i2 = mSmallIcon;
        Notification notification = bV3sI0.f8551CikNvS;
        notification.icon = i2;
        bV3sI0.AMqCpz(2, false);
        bV3sI0.f8551CikNvS.tickerText = BV3sI0.A4TApA(str);
        bV3sI0.AMqCpz(16, z);
        notification.when = System.currentTimeMillis();
        bV3sI0.f8541C2rE4F = remoteViews;
        return bV3sI0.A2egSU();
    }
}
