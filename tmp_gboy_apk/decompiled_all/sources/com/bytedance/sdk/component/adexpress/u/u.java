package com.bytedance.sdk.component.adexpress.u;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    public static Drawable xj(Context context, com.bytedance.sdk.component.adexpress.dynamic.w.c cVar) {
        if (context == null || cVar == null) {
            return null;
        }
        return xj(context, (int) f.xj(context, cVar.e()), cVar.zg(), cVar.ai());
    }

    public static Drawable xj(Context context, int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (context != null) {
            gradientDrawable.setStroke(i, i2);
        }
        gradientDrawable.setColor(i3);
        return gradientDrawable;
    }
}
