package COJEAR;

import android.view.DisplayCutout;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AcNBzu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final DisplayCutout f1633A2egSU;

    public AcNBzu(DisplayCutout displayCutout) {
        this.f1633A2egSU = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AcNBzu.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f1633A2egSU, ((AcNBzu) obj).f1633A2egSU);
    }

    public final int hashCode() {
        int hashCode;
        hashCode = this.f1633A2egSU.hashCode();
        return hashCode;
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f1633A2egSU + "}";
    }
}
