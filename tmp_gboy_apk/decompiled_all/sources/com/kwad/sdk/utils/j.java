package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.bykv.vk.component.ttvideo.player.C;
import com.octopus.ad.ADBidEvent;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class j {
    private static String bdJ = Build.BRAND;
    private static String bdK = "OPPO";
    private static String bdL = "vivo";
    private static String bdM = "Xiaomi";
    private static String bdN = "Meizu";
    private static String bdO = ADBidEvent.HUAWEI;
    private static String bdP = "HONOR";

    static {
        gqHVm();
    }

    private static Intent P(Context context, String str) {
        if ("V5".equals(str)) {
            return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName()));
        }
        if ("V6".equals(str) || "V7".equals(str)) {
            Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
            return intent;
        }
        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent2.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent2.putExtra("extra_pkgname", context.getPackageName());
        return intent2;
    }

    public static boolean RA() {
        return bdJ.equalsIgnoreCase(bdP);
    }

    private static boolean RB() {
        return bdJ.equalsIgnoreCase(bdK);
    }

    private static boolean RC() {
        return bdJ.equalsIgnoreCase(bdL);
    }

    private static String RD() {
        return aq("ro.miui.ui.version.name", "");
    }

    private static boolean Rw() {
        String str = "";
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.build.display.id", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str.toLowerCase().contains("flyme");
    }

    private static boolean Rx() {
        String str = Build.MANUFACTURER;
        return "QIKU".equals(str.toUpperCase()) || "360".equals(str.toUpperCase());
    }

    private static boolean Ry() {
        return bdJ.equalsIgnoreCase(bdM);
    }

    public static boolean Rz() {
        return bdJ.equalsIgnoreCase(bdO);
    }

    private static String aq(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static void cJ(Context context) {
        Intent cK;
        if (context == null || (cK = cK(context)) == null) {
            return;
        }
        try {
            context.startActivity(cK);
        } catch (Exception unused) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        }
    }

    private static Intent cK(Context context) {
        if (Ry()) {
            return P(context, RD());
        }
        if (Rz() || RA()) {
            Intent intent = new Intent();
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            return intent;
        }
        if (Rw()) {
            Intent intent2 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent2.addCategory("android.intent.category.DEFAULT");
            intent2.putExtra("packageName", context.getPackageName());
            return intent2;
        }
        if (RB() || RC()) {
            Intent intent3 = new Intent();
            intent3.setFlags(C.ENCODING_PCM_MU_LAW);
            intent3.putExtra("packageName", context.getPackageName());
            intent3.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
            return intent3;
        }
        if (Rx()) {
            Intent intent4 = new Intent("android.intent.action.MAIN");
            intent4.setFlags(C.ENCODING_PCM_MU_LAW);
            intent4.putExtra("packageName", context.getPackageName());
            intent4.setComponent(new ComponentName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity"));
            return intent4;
        }
        Intent intent5 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent5.setData(Uri.parse("package:" + context.getPackageName()));
        return intent5;
    }

    private static /* synthetic */ void gqHVm() {
        char[] charArray = "\u0088\u0084\u0086Å\u008c\u008a\u0086\u008eÅ\u0089\u0084\u0092Å\u0098\u0083\u008e\u0087\u0087Å¡\u0085\u0082©\u0099\u0082\u008f\u008c\u008e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 235);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0088\u0087\u0082\u0085\u0082\u009f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 235);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
