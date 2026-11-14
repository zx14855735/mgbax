package com.fl.saas.base.interfaces;

import android.app.Activity;
import android.view.ViewGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface SpreadLoadListener {

    public interface SpreadAd extends AdMaterial {
        int getEcpm();

        boolean isAdReady();

        void show(Activity activity, ViewGroup viewGroup);

        void show(ViewGroup viewGroup);
    }

    void onADLoaded(SpreadAd spreadAd);
}
