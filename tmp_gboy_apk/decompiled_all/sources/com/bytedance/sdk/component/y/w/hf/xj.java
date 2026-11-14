package com.bytedance.sdk.component.y.w.hf;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private final int c;
    private final ImageView.ScaleType f;
    private int kd;
    private int u;
    private final Bitmap.Config w;
    private final int y;
    public static final ImageView.ScaleType xj = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config hf = Bitmap.Config.ARGB_4444;
    private final int d = 3840;
    private final int tf = 104857600;

    static {
        eoEXrz();
    }

    public xj(int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, int i3, int i4) {
        this.w = config;
        this.u = i;
        this.kd = i2;
        this.f = scaleType;
        this.y = i3;
        this.c = i4;
        xj(i, i2);
    }

    private static /* synthetic */ void eoEXrz() {
        char[] charArray = "!-/l%#/'l -;l1*'..l\b,+\u00000+&%'".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'B');
        }
        String str = new String(charArray);
        char[] charArray2 = "!.+,+6".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'B');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static int xj(int i, int i2, int i3, int i4, int i5, int i6) {
        double min = Math.min(i / i3, i2 / i4);
        if (i5 > 0 && i6 > 0) {
            min = Math.max(min, Math.min(Math.max(i, i2) / Math.max(i5, i6), Math.min(i, i2) / Math.min(i5, i6)));
        }
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > min) {
                return (int) f;
            }
            f = f2;
        }
    }

    private static int xj(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i != 0 || i2 != 0) {
            if (scaleType != ImageView.ScaleType.FIT_XY) {
                if (i == 0) {
                    return (int) (i3 * (i2 / i4));
                }
                if (i2 == 0) {
                    return i;
                }
                double d = i4 / i3;
                if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                    double d2 = i2;
                    return ((double) i) * d < d2 ? (int) (d2 / d) : i;
                }
                double d3 = i2;
                return ((double) i) * d > d3 ? (int) (d3 / d) : i;
            }
            if (i != 0) {
                return i;
            }
        }
        return i3;
    }

    public Bitmap xj(byte[] bArr) {
        Bitmap decodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.u == 0 && this.kd == 0) {
            options.inPreferredConfig = this.w;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int xj2 = xj(this.u, this.kd, i, i2, this.f);
            int xj3 = xj(this.kd, this.u, i2, i, this.f);
            options.inJustDecodeBounds = false;
            options.inSampleSize = xj(i, i2, xj2, xj3, this.y, this.c);
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null && (decodeByteArray.getWidth() > xj2 || decodeByteArray.getHeight() > xj3)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, xj2, xj3, true);
                if (createScaledBitmap != decodeByteArray) {
                    decodeByteArray.recycle();
                }
                decodeByteArray = createScaledBitmap;
            }
        }
        if (decodeByteArray != null && decodeByteArray.getByteCount() > 104857600) {
            int width = decodeByteArray.getWidth() / 2;
            int height = decodeByteArray.getHeight() / 2;
            if (width > 0 && height > 0) {
                Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(decodeByteArray, width, height, true);
                if (createScaledBitmap2 != decodeByteArray) {
                    decodeByteArray.recycle();
                }
                return createScaledBitmap2;
            }
        }
        return decodeByteArray;
    }

    private void xj(int i, int i2) {
        if (i > 3840 && i2 > 3840) {
            if (i > i2) {
                this.u = 3840;
                this.kd = (i2 * 3840) / i;
                return;
            } else {
                this.u = (i * 3840) / i2;
                this.kd = 3840;
                return;
            }
        }
        if (i > 3840) {
            this.u = 3840;
            this.kd = (i2 * 3840) / i;
        } else if (i2 > 3840) {
            this.u = (i * 3840) / i2;
            this.kd = 3840;
        }
    }
}
