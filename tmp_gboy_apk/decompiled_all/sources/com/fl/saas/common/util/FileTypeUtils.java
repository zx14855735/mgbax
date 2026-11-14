package com.fl.saas.common.util;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class FileTypeUtils {
    public static final String FILE_TYPE_BMP = "bmp";
    public static final String FILE_TYPE_GIF = "gif";
    public static final String FILE_TYPE_JPEG = "jpg";
    public static final String FILE_TYPE_MP3 = "mp3";
    public static final String FILE_TYPE_PNG = "png";
    public static final String FILE_TYPE_WAV = "wav";

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase();
    }

    public static String getFileType(File file) {
        String str = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                str = getFileType(fileInputStream);
                fileInputStream.close();
                return str;
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getFileType(InputStream inputStream) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[10];
                bufferedInputStream.read(bArr, 0, 10);
                String fileType = getFileType(bArr);
                bufferedInputStream.close();
                return fileType;
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getFileType(byte[] bArr) {
        String bytesToHexString = bytesToHexString(bArr);
        return !TextUtils.isEmpty(bytesToHexString) ? bytesToHexString.startsWith("FFD8FF") ? FILE_TYPE_JPEG : bytesToHexString.startsWith("89504E47") ? FILE_TYPE_PNG : (bytesToHexString.startsWith("47494638") || bytesToHexString.startsWith("47494639")) ? "gif" : bytesToHexString.startsWith("424D") ? FILE_TYPE_BMP : (bytesToHexString.startsWith("494433") || bytesToHexString.startsWith("FFFB") || bytesToHexString.startsWith("FFF3") || bytesToHexString.startsWith("FFF2")) ? FILE_TYPE_MP3 : bytesToHexString.startsWith("52494646") ? FILE_TYPE_WAV : "" : "";
    }
}
