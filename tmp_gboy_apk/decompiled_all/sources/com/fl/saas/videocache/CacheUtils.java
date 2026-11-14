package com.fl.saas.videocache;

import ADYaiT.CtFAbx;
import android.content.Context;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CacheUtils {
    private static void cleanDirectory(File file) {
        File[] listFiles;
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                delete(file2);
            }
        }
    }

    public static void cleanVideoCacheDir(Context context) {
        cleanDirectory(getVideoCacheDir(context));
    }

    private static void delete(File file) {
        if (file.isFile() && file.exists()) {
            deleteOrThrow(file);
        } else {
            cleanDirectory(file);
            deleteOrThrow(file);
        }
    }

    private static void deleteOrThrow(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException(CtFAbx.BI9f7h("File ", file.getAbsolutePath(), " can't be deleted"));
        }
    }

    public static File getVideoCacheDir(Context context) {
        return context.getExternalCacheDir();
    }
}
