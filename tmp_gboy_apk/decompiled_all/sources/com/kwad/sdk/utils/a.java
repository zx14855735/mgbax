package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.sigmob.sdk.downloader.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    public static String getFileMD5(File file) {
        try {
            byte[] fileMD5Digest = getFileMD5Digest(file);
            if (fileMD5Digest != null && fileMD5Digest.length != 0) {
                return al.toHexString(fileMD5Digest, 0, fileMD5Digest.length);
            }
            return null;
        } catch (IOException e) {
            com.kwad.sdk.core.d.c.e("FileMD5Utils", "cannot calculate md5 of file", e);
            return null;
        }
    }

    public static byte[] getFileMD5Digest(File file) {
        if (file == null) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[f.a.c];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        byte[] digest = messageDigest.digest();
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                        return digest;
                    }
                    messageDigest.update(bArr, 0, read);
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.e("FileMD5Utils", "getting file md5 digest error.", e);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                return null;
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static byte[] hd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getFileMD5Digest(new File(str));
    }
}
