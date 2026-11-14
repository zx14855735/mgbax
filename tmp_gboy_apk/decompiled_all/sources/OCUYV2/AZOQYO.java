package OCUYV2;

import android.view.View;
import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AZOQYO {

    /* renamed from: A2egSU, reason: collision with root package name */
    public float f6238A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public float f6239A4TApA;

    public static int[] A2egSU(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr2[i] = iArr[i] * 2;
        }
        return iArr2;
    }

    public static float A4TApA(float f, float f2, float f3) {
        return 1.0f - ((f - f3) / (f2 - f3));
    }

    public abstract AlLFFp A5SV6n(CarouselLayoutManager carouselLayoutManager, View view);

    public boolean ADYaiT(CarouselLayoutManager carouselLayoutManager, int i) {
        return false;
    }
}
