package com.ss.android.downloadlib.c;

import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {
    public static long xj(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return xj(file, file.lastModified(), 0);
    }

    private static long xj(File file, long j, int i) {
        File[] listFiles;
        if (file != null && file.exists()) {
            j = Math.max(j, file.lastModified());
            int i2 = i + 1;
            if (i2 < 50 && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    j = Math.max(j, xj(file2, j, i2));
                }
            }
        }
        return j;
    }
}
