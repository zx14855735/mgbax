package com.bytedance.sdk.component.adexpress.u;

import I3HV03.ADYaiT;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.utils.pl;
import com.fl.saas.common.util.FileTypeUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    private static final byte[] xj = xj("VP8X");

    static {
        tScCy();
    }

    public static void hf(ImageView imageView, byte[] bArr, int i, int i2) {
        try {
            if (imageView instanceof GifView) {
                ((GifView) imageView).xj(bArr, false);
                return;
            }
            if (TextUtils.equals(FileTypeUtils.FILE_TYPE_PNG, com.bytedance.sdk.component.utils.d.xj(Arrays.copyOfRange(bArr, 0, com.bytedance.sdk.component.utils.d.xj())))) {
                w(imageView, bArr, i, i2);
            } else if (xj(bArr, 0)) {
                xj(imageView, bArr, i, i2);
            } else {
                u(imageView, bArr, i, i2);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    private static /* synthetic */ void tScCy() {
        char[] charArray = "'+)j#%)!j&+=j7,!((j\u000e*-\u00066- #!".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'D');
        }
        String str = new String(charArray);
        char[] charArray2 = "'(-*-0".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'D');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static void u(final ImageView imageView, byte[] bArr, int i, int i2) {
        final Bitmap xj2 = new com.bytedance.sdk.component.y.w.hf.xj(i, i2, imageView.getScaleType(), Bitmap.Config.RGB_565, i, i2).xj(bArr);
        if (xj2 != null) {
            com.bytedance.sdk.component.utils.f.hf().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.u.y.2
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(xj2);
                }
            });
        }
    }

    private static void w(final ImageView imageView, byte[] bArr, int i, int i2) {
        if (!xj(bArr)) {
            u(imageView, bArr, i, i2);
        } else {
            final com.bytedance.adsdk.xj.xj.xj xj2 = com.bytedance.adsdk.xj.xj.xj.xj(ByteBuffer.wrap(bArr));
            com.bytedance.sdk.component.utils.f.hf().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.u.y.1
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageDrawable(xj2);
                }
            });
        }
    }

    private static byte[] xj(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new byte[1];
        }
    }

    public static boolean xj(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        return xj.xj(bArr);
    }

    public static void xj(final ImageView imageView, byte[] bArr, int i, int i2) {
        ImageDecoder.Source createSource;
        final Drawable decodeDrawable;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT >= 28) {
            createSource = ImageDecoder.createSource(wrap);
            try {
                decodeDrawable = ImageDecoder.decodeDrawable(createSource);
                com.bytedance.sdk.component.utils.f.hf().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.u.y.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ADYaiT.BNL6CD(decodeDrawable)) {
                            ADYaiT.AcNBzu(decodeDrawable).start();
                        }
                        imageView.setImageDrawable(decodeDrawable);
                    }
                });
                return;
            } catch (IOException e) {
                pl.xj(e);
                return;
            }
        }
        u(imageView, bArr, i, i2);
    }

    public static boolean xj(byte[] bArr, int i) {
        try {
            boolean xj2 = xj(bArr, i + 12, xj);
            int i2 = i + 20;
            if (bArr.length <= i2) {
                return false;
            }
            return xj2 && ((bArr[i2] & 2) == 2);
        } catch (Throwable th) {
            pl.xj(th);
            return false;
        }
    }

    private static boolean xj(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
