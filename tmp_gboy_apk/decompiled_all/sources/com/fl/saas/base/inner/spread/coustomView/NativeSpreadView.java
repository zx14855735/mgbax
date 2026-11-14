package com.fl.saas.base.inner.spread.coustomView;

import android.view.View;
import com.fl.saas.base.inner.InnerNativeView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface NativeSpreadView extends InnerNativeView {
    void cancelCountdown();

    void setClickAreaVisibility(boolean z, View view);

    void setRainView(boolean z);

    void setViewType(boolean z, boolean z2, int i);

    void show();

    void startCountdown();
}
