package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaa0 {
    private static final String[] aaaaaaaa = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    static {
        oUHO();
    }

    public static boolean aaaaaaa0(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) == 1;
    }

    public static boolean aaaaaaaa(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled") == 1;
    }

    public static boolean aaaaaaao(Context context) {
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        if (property2 == null) {
            property2 = "-1";
        }
        return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
    }

    private static /* synthetic */ void oUHO() {
        char[] charArray = "º¶´÷¾¸´¼÷»¶ ÷ª±¼µµ÷\u0093·°\u009b«°½¾¼".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 217);
        }
        String str = new String(charArray);
        char[] charArray2 = "ºµ°·°\u00ad".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 217);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean aaaaaaaa() {
        boolean z;
        String[] strArr = aaaaaaaa;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            if (A2egSU.BPw6Q8(strArr[i])) {
                z = true;
                break;
            }
            i++;
        }
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || z;
    }
}
