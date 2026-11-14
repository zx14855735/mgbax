package androidx.profileinstaller;

import ADYaiT.BChYOn;
import DUi7mC.ASJ6gh;
import DXnQ0V.A4TApA;
import android.content.Context;
import android.os.Build;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ProfileInstallerInitializer implements A4TApA {

    public static class A2egSU {
    }

    @Override // DXnQ0V.A4TApA
    public final List A2egSU() {
        return Collections.EMPTY_LIST;
    }

    @Override // DXnQ0V.A4TApA
    public final Object A4TApA(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new A2egSU();
        }
        ASJ6gh.A2egSU(new BChYOn(this, 2, context.getApplicationContext()));
        return new A2egSU();
    }
}
