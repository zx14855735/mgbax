package com.bytedance.pangle.y;

import B4ZgIw.AYUAbz;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.d;
import java.io.File;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public static int hf = 2;
    public static int xj = 1;

    public static String hf(String str) {
        String substring = str.substring(str.lastIndexOf("."));
        String str2 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        return ".dex".equals(substring) ? substring : (".zip".equals(substring) || ".apk".equals(substring)) ? str2 : str.concat(str2);
    }

    public static SharedPreferences xj(Context context) {
        return com.bytedance.sdk.openadsdk.ats.u.xj(context.getApplicationContext(), "plugin_oat_info", 0);
    }

    public static String[] xj(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("dex2oat");
        if (Build.VERSION.SDK_INT >= 24) {
            arrayList.add("--runtime-arg");
            arrayList.add("-classpath");
            arrayList.add("--runtime-arg");
            arrayList.add("&");
        }
        arrayList.add("--instruction-set=" + xj());
        if (i == xj) {
            if (d.am()) {
                arrayList.add("--compiler-filter=quicken");
            } else {
                arrayList.add("--compiler-filter=interpret-only");
            }
        } else if (i == hf) {
            arrayList.add("--compiler-filter=speed");
        }
        arrayList.add("--dex-file=".concat(String.valueOf(str)));
        arrayList.add("--oat-file=".concat(String.valueOf(str2)));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String xj() {
        try {
            return (String) MethodUtils.invokeStaticMethod(Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
        } catch (Exception e) {
            com.bytedance.sdk.openadsdk.api.y.xj(e);
            return null;
        }
    }

    public static String xj(String str) {
        String substring = str.substring(str.lastIndexOf("/") + 1);
        String substring2 = substring.substring(substring.lastIndexOf("."));
        String str2 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        if (".dex".equals(substring2)) {
            return substring;
        }
        if (!".zip".equals(substring2) && !".apk".equals(substring2)) {
            return substring.concat(str2);
        }
        return substring.replace(substring2, str2);
    }

    public static boolean xj(String str, String str2) {
        return xj.xj(xj(str, str2, xj));
    }

    public static boolean xj(String... strArr) {
        for (String str : strArr) {
            File file = new File(str);
            if (!file.exists() || !f.xj(file)) {
                return false;
            }
        }
        return true;
    }

    public static boolean xj(String str, String... strArr) {
        for (String str2 : strArr) {
            StringBuilder A4TApA2 = AYUAbz.A4TApA(str);
            A4TApA2.append(File.separator);
            A4TApA2.append(xj(str2));
            if (!A2egSU.BPw6Q8(A4TApA2.toString())) {
                return false;
            }
        }
        return true;
    }
}
