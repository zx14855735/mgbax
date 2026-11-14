package HZUvgL;

import android.graphics.Bitmap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract /* synthetic */ class AmA8tU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final /* synthetic */ int[] f3673A2egSU;

    static {
        int[] iArr = new int[Bitmap.Config.values().length];
        f3673A2egSU = iArr;
        try {
            iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f3673A2egSU[Bitmap.Config.RGB_565.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f3673A2egSU[Bitmap.Config.ARGB_4444.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f3673A2egSU[Bitmap.Config.ALPHA_8.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
