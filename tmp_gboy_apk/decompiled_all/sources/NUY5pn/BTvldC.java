package NUY5pn;

import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BTvldC {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f6017A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final String f6018A4TApA;

    public BTvldC(String str) {
        AYUAbz.ADYaiT(str);
        this.f6017A2egSU = str;
        AYUAbz.ADYaiT("com.google.android.gms");
        this.f6018A4TApA = "com.google.android.gms";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BTvldC) && AYUAbz.ARc23Z(this.f6017A2egSU, ((BTvldC) obj).f6017A2egSU) && AYUAbz.ARc23Z(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6017A2egSU, null});
    }

    public final String toString() {
        String str = this.f6017A2egSU;
        str.getClass();
        return str;
    }
}
