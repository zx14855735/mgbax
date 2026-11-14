package Hjvs0g;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ARc23Z implements HSHyT0.A4TApA {
    @Override // HSHyT0.A4TApA
    public final boolean ASJ6gh(Object obj, File file, HSHyT0.AmA8tU amA8tU) {
        try {
            ItGa5w.A4TApA.A4TApA((ByteBuffer) obj, file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("ByteBufferEncoder", 3);
            return false;
        }
    }
}
