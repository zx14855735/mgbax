package com.bytedance.pangle.wrapper;

import android.app.NotificationChannel;
import android.media.AudioFocusRequest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract /* synthetic */ class A2egSU {
    public static /* synthetic */ NotificationChannel A5SV6n(String str) {
        return new NotificationChannel(str, "应用下载", 2);
    }

    public static /* synthetic */ AudioFocusRequest.Builder ADYaiT() {
        return new AudioFocusRequest.Builder(2);
    }
}
