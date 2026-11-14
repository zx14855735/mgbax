package BPw6Q8;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A2egSU {
    public static File A2egSU(Context context) {
        return context.getCodeCacheDir();
    }

    public static Drawable A4TApA(Context context, int i) {
        return context.getDrawable(i);
    }

    public static File A5SV6n(Context context) {
        return context.getNoBackupFilesDir();
    }
}
