package OvgpEe;

import android.content.ContentResolver;
import android.provider.Settings;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A2egSU {
    public static float A2egSU(ContentResolver contentResolver) {
        return Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
    }
}
