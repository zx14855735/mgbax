package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f12281a = {Constants.FAIL, "1", "2", "3", "4", "5", "6", "7", GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, "9", t.f, t.l, "c", t.t, "e", "f"};

    static {
        uxZHXi();
    }

    private static String a(byte b) {
        int i = b;
        if (b < 0) {
            i = b + 256;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = f12281a;
        sb.append(strArr[i / 16]);
        sb.append(strArr[i % 16]);
        return sb.toString();
    }

    public static String b(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                return a(MessageDigest.getInstance("MD5").digest(bArr));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String c(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            cArr2[i2] = cArr[(b >>> 4) & 15];
            cArr2[i2 + 1] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    public static byte[] d(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                return MessageDigest.getInstance("MD5").digest(bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static /* synthetic */ void uxZHXi() {
        char[] charArray = "\b\u0004\u0006E\f\n\u0006\u000eE\t\u0004\u0012E\u0018\u0003\u000e\u0007\u0007E!\u0005\u0002)\u0019\u0002\u000f\f\u000e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'k');
        }
        String str = new String(charArray);
        char[] charArray2 = "\b\u0007\u0002\u0005\u0002\u001f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'k');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(a(b));
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = new String(str);
            try {
                return a(MessageDigest.getInstance("MD5").digest(str2.getBytes()));
            } catch (Throwable unused) {
                return str2;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        if (file != null && file.exists()) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
            } catch (Throwable unused) {
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[ProxyCacheUtils.DEFAULT_BUFFER_SIZE];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String c = c(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (Throwable unused2) {
                }
                return c;
            } catch (Throwable unused3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable unused4) {
                    }
                }
                return null;
            }
        }
        return null;
    }
}
