package PCV8se;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final float f7015A2egSU;

    public A2egSU(float f) {
        this.f7015A2egSU = f;
    }

    @Override // PCV8se.ADYaiT
    public final float A2egSU(RectF rectF) {
        return this.f7015A2egSU;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof A2egSU) && this.f7015A2egSU == ((A2egSU) obj).f7015A2egSU;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f7015A2egSU)});
    }

    public final String toString() {
        return this.f7015A2egSU + "px";
    }
}
