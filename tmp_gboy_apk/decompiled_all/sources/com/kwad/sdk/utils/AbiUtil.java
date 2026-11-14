package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AbiUtil {
    private static Abi bdm;

    public enum Abi {
        UNKNOWN,
        ARMEABI_V7A,
        ARM64_V8A;

        static {
            kCsGkbc();
        }

        private static /* synthetic */ void kCsGkbc() {
            char[] charArray = "ÕÙÛ\u0098Ñ×ÛÓ\u0098ÔÙÏ\u0098ÅÞÓÚÚ\u0098üØßôÄßÒÑÓ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 182);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÕÚßØßÂ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 182);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static String cy(Context context) {
        return isArm64(context) ? "arm64-v8a" : "armeabi-v7a";
    }

    private static Abi cz(Context context) {
        boolean is64Bit;
        Abi abi = bdm;
        if (abi != null) {
            return abi;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            is64Bit = Process.is64Bit();
            bdm = is64Bit ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
        } else {
            try {
                bdm = ((Boolean) z.callMethod(z.a("dalvik.system.VMRuntime", "getRuntime", new Object[0]), "is64Bit", new Object[0])).booleanValue() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
            } catch (Throwable th) {
                th.printStackTrace();
                if (context == null) {
                    try {
                        context = ServiceProvider.getContext();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        bdm = Abi.UNKNOWN;
                    }
                }
                if (context.getApplicationInfo().nativeLibraryDir.contains("arm64")) {
                    bdm = Abi.ARM64_V8A;
                } else {
                    bdm = Abi.UNKNOWN;
                }
            }
        }
        return bdm;
    }

    public static boolean isArm64(Context context) {
        return cz(context) == Abi.ARM64_V8A;
    }
}
