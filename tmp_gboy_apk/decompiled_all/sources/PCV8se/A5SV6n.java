package PCV8se;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n implements ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final float f7018A2egSU;

    public A5SV6n(float f) {
        this.f7018A2egSU = f;
    }

    @Override // PCV8se.ADYaiT
    public final float A2egSU(RectF rectF) {
        return com.bumptech.glide.AMqCpz.B2KMhB(this.f7018A2egSU, 0.0f, Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof A5SV6n) && this.f7018A2egSU == ((A5SV6n) obj).f7018A2egSU;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f7018A2egSU)});
    }
}
