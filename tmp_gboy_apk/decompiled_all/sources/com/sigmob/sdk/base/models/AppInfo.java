package com.sigmob.sdk.base.models;

import ADYaiT.CtFAbx;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AppInfo {
    public final String appVersion;
    public final String os;
    public final String sdkVersion;

    public AppInfo(String str, String str2, String str3) {
        this.sdkVersion = str;
        this.appVersion = str2;
        this.os = str3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("appInfo={sdkVersion='");
        sb.append(this.sdkVersion);
        sb.append("', appVersion='");
        sb.append(this.appVersion);
        sb.append("', os='");
        return CtFAbx.B25kr6(sb, this.os, "'}");
    }
}
