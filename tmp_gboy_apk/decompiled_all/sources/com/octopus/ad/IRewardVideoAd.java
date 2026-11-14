package com.octopus.ad;

import android.app.Activity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface IRewardVideoAd {
    void destroy();

    int getPrice();

    String getTagId();

    boolean isLoaded();

    void loadAd();

    void pause();

    void resume();

    void setAdSlotId(String str);

    void show(Activity activity);
}
