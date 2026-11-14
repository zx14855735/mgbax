package com.bykv.vk.component.ttvideo;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.x.y;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class LibraryLoader {
    private static final String TAG = "LibraryLoader";
    private static Loader sLoader;

    public interface Loader {
        void loadLibrary(String str);

        void loadLibraryFromPath(String str);
    }

    public static void loadLibrary(String str) {
        Loader loader = sLoader;
        if (TextUtils.isEmpty(str)) {
            throw new Exception("Invalid library name.");
        }
        if (loader != null) {
            loader.loadLibrary(str);
        } else {
            y.xj(str);
        }
    }

    public static void loadLibraryFromPath(String str) {
        Loader loader = sLoader;
        if (TextUtils.isEmpty(str)) {
            throw new Exception("Invalid library name.");
        }
        File file = new File(str);
        if (!file.exists()) {
            throw new Exception(CtFAbx.BI9f7h("Not found library '", str, "' file."));
        }
        if (loader == null) {
            System.load(file.getAbsolutePath());
        } else {
            file.getAbsolutePath();
            loader.loadLibraryFromPath(file.getAbsolutePath());
        }
    }

    public static void setupLibraryLoader(Loader loader) {
        sLoader = loader;
    }
}
