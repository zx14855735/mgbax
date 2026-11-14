package COJEAR;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class EwN40Z extends EsrwYR {
    public EwN40Z(FG7pZc fG7pZc, WindowInsets windowInsets) {
        super(fG7pZc, windowInsets);
    }

    @Override // COJEAR.F32kj0
    public FG7pZc A2egSU() {
        WindowInsets consumeDisplayCutout;
        consumeDisplayCutout = this.f1735A5SV6n.consumeDisplayCutout();
        return FG7pZc.ASJ6gh(null, consumeDisplayCutout);
    }

    @Override // COJEAR.F32kj0
    public AcNBzu AMqCpz() {
        DisplayCutout displayCutout;
        displayCutout = this.f1735A5SV6n.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new AcNBzu(displayCutout);
    }

    @Override // COJEAR.ErKPGd, COJEAR.F32kj0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EwN40Z)) {
            return false;
        }
        EwN40Z ewN40Z = (EwN40Z) obj;
        return Objects.equals(this.f1735A5SV6n, ewN40Z.f1735A5SV6n) && Objects.equals(this.f1738ASJ6gh, ewN40Z.f1738ASJ6gh);
    }

    @Override // COJEAR.F32kj0
    public int hashCode() {
        return this.f1735A5SV6n.hashCode();
    }
}
