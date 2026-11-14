package PCV8se;

import ADYaiT.CtFAbx;
import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AzWtSf implements ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final float f7081A2egSU;

    public AzWtSf(float f) {
        this.f7081A2egSU = f;
    }

    @Override // PCV8se.ADYaiT
    public final float A2egSU(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f7081A2egSU;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AzWtSf) && this.f7081A2egSU == ((AzWtSf) obj).f7081A2egSU;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f7081A2egSU)});
    }

    public final String toString() {
        return CtFAbx.AZkASS("%", (int) (this.f7081A2egSU * 100.0f), new StringBuilder());
    }
}
