package com.kwai.library.ipneigh;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class KwaiIpNeigh {
    private static final String TAG = "KwaiIpNeigh";

    static {
        System.loadLibrary("ipneigh-android");
        YrrTG();
    }

    private static /* synthetic */ void YrrTG() {
        char[] charArray = "\u0099\u0095\u0097Ô\u009d\u009b\u0097\u009fÔ\u0098\u0095\u0083Ô\u0089\u0092\u009f\u0096\u0096Ô°\u0094\u0093¸\u0088\u0093\u009e\u009d\u009f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 250);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0099\u0096\u0093\u0094\u0093\u008e".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 250);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static boolean aE(String str, String str2) {
        if (str == null) {
            return false;
        }
        String[] split = str.split("\\s+");
        if (split.length < 2) {
            return false;
        }
        return split[0].equals(str2);
    }

    private static native int getARPTableFromJni(int i);

    private static native int getARPTableFromJni2(int i);

    public static String j(String str, boolean z) {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream;
        int detachFd;
        String readLine;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
            ParcelFileDescriptor parcelFileDescriptor2 = createPipe[1];
            autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            detachFd = parcelFileDescriptor2.detachFd();
        } catch (Throwable th) {
            th.printStackTrace();
            th.getMessage();
        }
        if ((z ? getARPTableFromJni2(detachFd) : getARPTableFromJni(detachFd)) != 0) {
            return "";
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(autoCloseInputStream, StandardCharsets.UTF_8));
        do {
            readLine = bufferedReader.readLine();
            if (readLine == null) {
                return "";
            }
        } while (!aE(readLine, str));
        return readLine;
    }
}
