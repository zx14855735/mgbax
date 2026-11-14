package com.fl.saas.base.inner;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.fl.saas.common.util.feature.Consumer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface InnerNativeCustomView {
    View getAdView();

    View getCATView();

    Consumer<Bitmap> loadIcon();

    InnerNativeCustomView setCAT(String str);

    InnerNativeCustomView setDes(String str);

    InnerNativeCustomView setMediaView(View view, Drawable drawable);

    InnerNativeCustomView setTitle(String str);
}
