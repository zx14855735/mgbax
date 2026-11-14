package com.bytedance.sdk.component.y.w.w;

import android.graphics.BitmapFactory;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static boolean hf(byte[] bArr) {
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public static boolean xj(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        return options.outWidth > 0;
    }
}
