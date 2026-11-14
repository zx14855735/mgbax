package com.fl.saas.api.mixNative;

import android.graphics.Bitmap;
import android.view.View;
import com.fl.saas.common.util.feature.Size;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface NativeMaterial {
    NativeAdAppInfo getAdAppInfo();

    @Deprecated
    Bitmap getAdLogo();

    Bitmap getAdLogoBitmap();

    String getAdLogoUrl();

    View getAdMediaView();

    int getAdType();

    String getCallToAction();

    String getDescription();

    String getIconUrl();

    List<String> getImageUrlList();

    String getMainImageUrl();

    Size getSize();

    String getTitle();

    double getVideoDuration();

    String getVideoUrl();

    boolean isNativeAppAd();
}
