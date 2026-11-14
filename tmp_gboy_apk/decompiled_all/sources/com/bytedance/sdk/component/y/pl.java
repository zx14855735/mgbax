package com.bytedance.sdk.component.y;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface pl {
    boolean cancelRequest();

    Bitmap.Config getBitmapConfig();

    int getHeight();

    String getMemoryCacheKey();

    String getRawCacheKey();

    ImageView.ScaleType getScaleType();

    String getUrl();

    int getWidth();
}
