package BTvldC;

import android.content.res.Resources;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Resources f1463A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Resources.Theme f1464A4TApA;

    public AzWtSf(Resources resources, Resources.Theme theme) {
        this.f1463A2egSU = resources;
        this.f1464A4TApA = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AzWtSf.class == obj.getClass()) {
            AzWtSf azWtSf = (AzWtSf) obj;
            if (this.f1463A2egSU.equals(azWtSf.f1463A2egSU) && Objects.equals(this.f1464A4TApA, azWtSf.f1464A4TApA)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f1463A2egSU, this.f1464A4TApA);
    }
}
