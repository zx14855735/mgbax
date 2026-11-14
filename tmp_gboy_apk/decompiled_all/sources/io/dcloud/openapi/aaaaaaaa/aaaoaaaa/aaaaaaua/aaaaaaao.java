package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua;

import B4ZgIw.AYUAbz;
import android.content.Context;
import android.text.TextUtils;
import com.sigmob.sdk.base.views.r;
import io.dcloud.openapi.core.DCloudAOLManager;
import java.lang.reflect.Field;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaao {
    public static String aaaaaaa0() {
        try {
            return Locale.forLanguageTag((String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, "persist.sys.locale")).getCountry();
        } catch (Exception unused) {
            return "";
        }
    }

    public static Object aaaaaaaa() {
        try {
            String aaaaaaan = aaaaaaan();
            if (!TextUtils.isEmpty(aaaaaaan)) {
                return aaaaaaan;
            }
            Class<?> cls = Class.forName("io.dcloud.common.util.BaseInfo");
            Field declaredField = cls.getDeclaredField("sBaseVersion");
            declaredField.setAccessible(true);
            return declaredField.get(cls);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return DCloudAOLManager.getVersion();
        }
    }

    public static boolean aaaaaaac() {
        return true;
    }

    public static String aaaaaaan() {
        try {
            Field declaredField = Class.forName("io.dcloud.uniapp.BuildConfig").getDeclaredField("innerVersion");
            declaredField.setAccessible(true);
            return declaredField.get(null).toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean aaaaaaao() {
        try {
            Class.forName("io.dcloud.uts.UTSAndroid");
            Class.forName("io.dcloud.uniapp.BuildConfig").getDeclaredField("logPerformance");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int aaaaaaau() {
        if (aaaaaaao()) {
            return aaaaaaac() ? 0 : 1;
        }
        return 2;
    }

    public static String aaaaaaaa(Context context) {
        String str;
        String packageName = context.getPackageName();
        try {
            str = context.getPackageManager().getApplicationInfo(packageName, r.b.d).metaData.getString("DCLOUD_STREAMAPP_CHANNEL");
        } catch (Exception unused) {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(packageName, "|");
        A5SV6n2.append(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAppId());
        A5SV6n2.append("|");
        A5SV6n2.append(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa.aaaaaaac().aaaaaaa0().getAdId());
        return A5SV6n2.toString();
    }
}
