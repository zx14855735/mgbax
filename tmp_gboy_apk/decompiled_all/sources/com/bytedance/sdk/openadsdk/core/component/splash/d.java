package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.TypeEvaluator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class d implements TypeEvaluator {
    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        int i = (intValue >> 24) & 255;
        int i2 = (intValue >> 16) & 255;
        int i3 = (intValue >> 8) & 255;
        int i4 = intValue & 255;
        int intValue2 = ((Integer) obj2).intValue();
        return Integer.valueOf(((i + ((int) ((((intValue2 >> 24) & 255) - i) * f))) << 24) | ((i2 + ((int) ((((intValue2 >> 16) & 255) - i2) * f))) << 16) | ((i3 + ((int) ((((intValue2 >> 8) & 255) - i3) * f))) << 8) | (i4 + ((int) (f * ((intValue2 & 255) - i4)))));
    }
}
