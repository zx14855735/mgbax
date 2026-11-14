package com.kwad.sdk.core.imageloader.utils;

import android.graphics.Bitmap;
import com.sigmob.sdk.base.blurkit.d;
import java.lang.reflect.Array;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class BlurUtils {
    public static Bitmap stackBlur(Bitmap bitmap, int i, boolean z) {
        Bitmap copy;
        int i2;
        int i3 = i;
        if (z) {
            copy = bitmap;
        } else {
            Bitmap.Config config = bitmap.getConfig();
            if (config == null) {
                config = Bitmap.Config.ARGB_8888;
            }
            copy = bitmap.copy(config, true);
        }
        if (i3 <= 0) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i4 = width * height;
        int[] iArr = new int[i4];
        copy.getPixels(iArr, 0, width, 0, 0, width, height);
        int i5 = width - 1;
        int i6 = height - 1;
        int i7 = i3 + i3;
        int i8 = i7 + 1;
        int[] iArr2 = new int[i4];
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[Math.max(width, height)];
        int i9 = (i7 + 2) >> 1;
        int i10 = i9 * i9;
        int i11 = i10 * 256;
        int[] iArr6 = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iArr6[i12] = i12 / i10;
        }
        int[][] iArr7 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i8, 3);
        int i13 = i3 + 1;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (i14 < height) {
            int[] iArr8 = iArr6;
            int i17 = -i3;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            while (i17 <= i3) {
                int[] iArr9 = iArr4;
                Bitmap bitmap2 = copy;
                int i27 = iArr[Math.min(i5, Math.max(i17, 0)) + i15];
                int[] iArr10 = iArr7[i17 + i3];
                iArr10[0] = (i27 & 16711680) >> 16;
                iArr10[1] = (i27 & 65280) >> 8;
                iArr10[2] = i27 & 255;
                int abs = i13 - Math.abs(i17);
                int i28 = iArr10[0];
                i26 = (i28 * abs) + i26;
                int i29 = iArr10[1];
                i18 = (i29 * abs) + i18;
                int i30 = iArr10[2];
                i19 = (abs * i30) + i19;
                if (i17 > 0) {
                    i23 += i28;
                    i24 += i29;
                    i25 += i30;
                } else {
                    i20 += i28;
                    i21 += i29;
                    i22 += i30;
                }
                i17++;
                iArr4 = iArr9;
                copy = bitmap2;
            }
            int[] iArr11 = iArr4;
            Bitmap bitmap3 = copy;
            int i31 = i3;
            int i32 = 0;
            while (i32 < width) {
                iArr2[i15] = iArr8[i26];
                iArr3[i15] = iArr8[i18];
                iArr11[i15] = iArr8[i19];
                int i33 = i26 - i20;
                int i34 = i18 - i21;
                int i35 = i19 - i22;
                int[] iArr12 = iArr7[((i31 - i3) + i8) % i8];
                int i36 = i20 - iArr12[0];
                int i37 = i21 - iArr12[1];
                int i38 = i22 - iArr12[2];
                if (i14 == 0) {
                    i2 = i32;
                    iArr5[i2] = Math.min(i32 + i3 + 1, i5);
                } else {
                    i2 = i32;
                }
                int i39 = iArr[i16 + iArr5[i2]];
                int i40 = (i39 & 16711680) >> 16;
                iArr12[0] = i40;
                int i41 = (i39 & 65280) >> 8;
                iArr12[1] = i41;
                int i42 = i39 & 255;
                iArr12[2] = i42;
                int i43 = i23 + i40;
                int i44 = i24 + i41;
                int i45 = i25 + i42;
                i26 = i33 + i43;
                i18 = i34 + i44;
                i19 = i35 + i45;
                i31 = (i31 + 1) % i8;
                int[] iArr13 = iArr7[i31 % i8];
                int i46 = iArr13[0];
                i20 = i36 + i46;
                int i47 = iArr13[1];
                i21 = i37 + i47;
                int i48 = iArr13[2];
                i22 = i38 + i48;
                i23 = i43 - i46;
                i24 = i44 - i47;
                i25 = i45 - i48;
                i15++;
                i32 = i2 + 1;
            }
            i16 += width;
            i14++;
            iArr6 = iArr8;
            iArr4 = iArr11;
            copy = bitmap3;
        }
        int[] iArr14 = iArr6;
        int[] iArr15 = iArr4;
        Bitmap bitmap4 = copy;
        int i49 = 0;
        while (i49 < width) {
            int i50 = -i3;
            int i51 = i49;
            int i52 = i50 * width;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            while (i50 <= i3) {
                int max = Math.max(0, i52) + i51;
                int[] iArr16 = iArr7[i50 + i];
                iArr16[0] = iArr2[max];
                iArr16[1] = iArr3[max];
                iArr16[2] = iArr15[max];
                int abs2 = i13 - Math.abs(i50);
                i61 = (iArr2[max] * abs2) + i61;
                i53 = (iArr3[max] * abs2) + i53;
                i54 = (iArr15[max] * abs2) + i54;
                if (i50 > 0) {
                    i58 += iArr16[0];
                    i59 += iArr16[1];
                    i60 += iArr16[2];
                } else {
                    i55 += iArr16[0];
                    i56 += iArr16[1];
                    i57 += iArr16[2];
                }
                if (i50 < i6) {
                    i52 += width;
                }
                i50++;
                i3 = i;
            }
            int i62 = i61;
            int i63 = i51;
            int i64 = i;
            for (int i65 = 0; i65 < height; i65++) {
                iArr[i63] = (iArr[i63] & d.f13043a) | (iArr14[i62] << 16) | (iArr14[i53] << 8) | iArr14[i54];
                int i66 = i62 - i55;
                int i67 = i53 - i56;
                int i68 = i54 - i57;
                int[] iArr17 = iArr7[((i64 - i) + i8) % i8];
                int i69 = i55 - iArr17[0];
                int i70 = i56 - iArr17[1];
                int i71 = i57 - iArr17[2];
                int i72 = i63;
                if (i51 == 0) {
                    iArr5[i65] = Math.min(i65 + i13, i6) * width;
                }
                int i73 = i51 + iArr5[i65];
                int i74 = iArr2[i73];
                iArr17[0] = i74;
                int i75 = iArr3[i73];
                iArr17[1] = i75;
                int i76 = iArr15[i73];
                iArr17[2] = i76;
                int i77 = i58 + i74;
                int i78 = i59 + i75;
                int i79 = i60 + i76;
                i62 = i66 + i77;
                i53 = i67 + i78;
                i54 = i68 + i79;
                i64 = (i64 + 1) % i8;
                int[] iArr18 = iArr7[i64];
                int i80 = iArr18[0];
                i55 = i69 + i80;
                int i81 = iArr18[1];
                i56 = i70 + i81;
                int i82 = iArr18[2];
                i57 = i71 + i82;
                i58 = i77 - i80;
                i59 = i78 - i81;
                i60 = i79 - i82;
                i63 = i72 + width;
            }
            i49 = i51 + 1;
            i3 = i;
        }
        bitmap4.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap4;
    }
}
