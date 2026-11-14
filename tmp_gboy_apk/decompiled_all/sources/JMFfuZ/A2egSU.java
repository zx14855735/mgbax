package JMFfuZ;

import android.app.NotificationChannel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract /* synthetic */ class A2egSU {
    public static /* synthetic */ NotificationChannel ADYaiT() {
        return new NotificationChannel("download_channel", "下载通知", 2);
    }

    public static /* synthetic */ NotificationChannel AMqCpz(String str) {
        return new NotificationChannel(str, "csj_install", 4);
    }

    public static /* synthetic */ void AaHO0E() {
    }

    public static /* synthetic */ NotificationChannel BIYEnU() {
        return new NotificationChannel("EmulatorServiceChannel", "游戏运行中", 2);
    }

    public static /* synthetic */ NotificationChannel BNL6CD() {
        return new NotificationChannel("file_server_channel", "文件服务", 2);
    }
}
