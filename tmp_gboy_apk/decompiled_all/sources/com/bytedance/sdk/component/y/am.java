package com.bytedance.sdk.component.y;

import android.graphics.Bitmap;
import android.widget.ImageView;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface am {
    am cache(hf hfVar);

    am cacheDir(String str);

    am config(Bitmap.Config config);

    am converter(tf tfVar);

    am from(String str);

    am headers(boolean z);

    am height(int i);

    am key(String str);

    am loadSetp(jk jkVar);

    am maxHeight(int i);

    am maxWidth(int i);

    am requestTime(boolean z);

    am runIn(ExecutorService executorService);

    am scaleType(ImageView.ScaleType scaleType);

    am sync(boolean z);

    pl to(ImageView imageView);

    pl to(dk dkVar);

    pl to(dk dkVar, int i);

    am track(q qVar);

    am type(int i);

    am width(int i);
}
