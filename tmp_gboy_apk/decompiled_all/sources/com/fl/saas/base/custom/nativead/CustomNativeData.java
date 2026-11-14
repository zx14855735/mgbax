package com.fl.saas.base.custom.nativead;

import com.fl.saas.common.pojo.YdNativePojo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class CustomNativeData extends YdNativePojo {

    public interface CustomNativeEventListener {
        void onNativeAdClicked(int i);

        void onNativeAdShow(int i);
    }
}
