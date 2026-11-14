package IJPJ4E;

import HSHyT0.AmA8tU;
import HSHyT0.B2KMhB;
import HXc4pW.BTvldC;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A5SV6n implements B2KMhB {
    @Override // HSHyT0.B2KMhB
    public final int A4TApA(AmA8tU amA8tU) {
        return 1;
    }

    @Override // HSHyT0.A4TApA
    public final boolean ASJ6gh(Object obj, File file, AmA8tU amA8tU) {
        try {
            ItGa5w.A4TApA.A4TApA(((AYUAbz) ((A4TApA) ((BTvldC) obj).get()).f3888AcNBzu.f2321A4TApA).f3905A2egSU.f3441ADYaiT.asReadOnlyBuffer(), file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("GifEncoder", 5);
            return false;
        }
    }
}
