package com.fl.saas.base.inner.interstitial.coustomView;

import android.app.Activity;
import android.view.View;
import com.fl.saas.base.inner.InnerNativeView;
import com.fl.saas.common.saas.bean.CloseButtonPosition;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface NativeInterstitialView extends InnerNativeView {
    void addActionView(View view);

    void click();

    void closeDialog();

    void destroy();

    NativeInterstitialView setAdType(boolean z);

    NativeInterstitialView setAnimalStartTime(int i);

    NativeInterstitialView setAnimalTime(int i);

    NativeInterstitialView setAutoClose(boolean z);

    NativeInterstitialView setClickType(int i);

    NativeInterstitialView setClosePos(CloseButtonPosition closeButtonPosition);

    NativeInterstitialView setCloseViewSize(int i);

    NativeInterstitialView setCountDown(boolean z, int i);

    NativeInterstitialView setRainView(boolean z);

    NativeInterstitialView setShakeType(boolean z);

    NativeInterstitialView setSpeed(int i);

    void setViewType(boolean z, int i);

    boolean showDialog(Activity activity);

    NativeInterstitialView startCountdown();
}
