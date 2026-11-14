package com.game.boy.activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PictureInPictureParams;
import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract /* synthetic */ class ADYaiT {
    public static /* synthetic */ Notification.Builder A5SV6n(Context context) {
        return new Notification.Builder(context, "sig_filedownloader_notification");
    }

    public static /* synthetic */ NotificationChannel ADYaiT() {
        return new NotificationChannel("download_channel", "ksad", 3);
    }

    public static /* synthetic */ PictureInPictureParams.Builder AMqCpz() {
        return new PictureInPictureParams.Builder();
    }

    public static /* synthetic */ NotificationChannel BV3sI0() {
        return new NotificationChannel("sig_filedownloader_notification", "sig_filedownloader", 1);
    }

    public static /* synthetic */ NotificationChannel BmvVmW() {
        return new NotificationChannel("111111", "channel_appdownloader", 3);
    }
}
