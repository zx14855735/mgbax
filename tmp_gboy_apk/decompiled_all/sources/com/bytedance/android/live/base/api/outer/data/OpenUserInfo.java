package com.bytedance.android.live.base.api.outer.data;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class OpenUserInfo {
    public String avatar;
    private String nickName;

    public OpenUserInfo() {
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNickName() {
        return this.nickName;
    }

    public OpenUserInfo(String str, String str2) {
        this.nickName = str;
        this.avatar = str2;
    }
}
