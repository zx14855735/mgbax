package com.bykv.vk.openvk.component.video.xj.kd;

import ADYaiT.CtFAbx;
import java.io.File;
import java.io.RandomAccessFile;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    public static File hf(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, CtFAbx.AcNBzu(str2, ".temp"));
    }

    public static File w(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }

    public static long xj(String str, String str2) {
        File w = w(str, str2);
        if (w.exists()) {
            return w.length();
        }
        File hf = hf(str, str2);
        if (hf.exists()) {
            return hf.length();
        }
        return 0L;
    }

    public static boolean xj(RandomAccessFile randomAccessFile, byte[] bArr, long j, int i) {
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, 0, i);
            return true;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.y.w.xj("VideoFilesUtils", "append failed", th);
            return false;
        }
    }
}
