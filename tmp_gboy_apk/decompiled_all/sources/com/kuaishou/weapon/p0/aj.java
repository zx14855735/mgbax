package com.kuaishou.weapon.p0;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.czhj.sdk.common.Constants;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class aj {
    private static final String[] b = {"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/"};

    /* renamed from: a, reason: collision with root package name */
    private Context f12191a;

    static {
        KOHkQUs();
    }

    public aj(Context context) {
        this.f12191a = context;
    }

    private static /* synthetic */ void KOHkQUs() {
        char[] charArray = "¬ ¢á¨®¢ªá\u00ad ¶á¼§ª££á\u0085¡¦\u008d½¦«¨ª".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 207);
        }
        String str = new String(charArray);
        char[] charArray2 = "¬£¦¡¦»".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 207);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean b() {
        String a2;
        try {
            a2 = bh.a("ro.build.display.id");
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if (a2.contains("flyme")) {
            return true;
        }
        return a2.toLowerCase().contains("flyme");
    }

    public int a() {
        try {
            for (String str : a(bi.z)) {
                if (new File(str, bi.y).exists()) {
                    return 1;
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public String c() {
        try {
            if (Build.VERSION.SDK_INT > 29) {
                return null;
            }
            return aa.a().b("su -v").replace("\n", "");
        } catch (Exception unused) {
            return null;
        }
    }

    public int d() {
        String a2 = aa.a().a("ro.secure");
        return (a2 == null || !Constants.FAIL.equals(a2)) ? 1 : 0;
    }

    public int e() {
        String a2 = aa.a().a("ro.debuggable");
        return (a2 == null || !Constants.FAIL.equals(a2)) ? 1 : 0;
    }

    public int f() {
        String a2 = aa.a().a("ro.adb.secure");
        return (a2 == null || !Constants.FAIL.equals(a2)) ? 1 : 0;
    }

    public JSONObject g() {
        try {
            JSONObject jSONObject = new JSONObject();
            String a2 = a(" which su ");
            if (TextUtils.isEmpty(a2) || a2.length() <= 2) {
                jSONObject.put(Constants.FAIL, 0);
            } else {
                jSONObject.put(Constants.FAIL, 1);
                jSONObject.put("0-p", a2);
            }
            String a3 = a(" id ");
            if (!TextUtils.isEmpty(a3)) {
                if (a3.toLowerCase().contains("uid=0")) {
                    jSONObject.put("1", 1);
                } else {
                    jSONObject.put("1", 0);
                }
            }
            String a4 = a(" busybox df ");
            if (!TextUtils.isEmpty(a4) && !a4.contains("not found")) {
                if (a4.length() > 30) {
                    jSONObject.put("2", 1);
                } else {
                    jSONObject.put("2", 0);
                }
            }
            if (jSONObject.length() > 0) {
                return jSONObject;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public int h() {
        return A2egSU.BPw6Q8("/system/app/Superuser.apk") ? 1 : 0;
    }

    public String i() {
        for (String str : b) {
            if (new File(str, "magisk").exists()) {
                return CtFAbx.AcNBzu(str, "magisk");
            }
        }
        return "";
    }

    public String j() {
        for (String str : b) {
            if (new File(str, bi.y).exists()) {
                return CtFAbx.AcNBzu(str, bi.y);
            }
        }
        return "";
    }

    public String k() {
        try {
            throw new Exception("");
        } catch (Exception e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") || stackTraceElement.getMethodName().equals("invoked") || stackTraceElement.getMethodName().equals("main") || stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    return stackTraceElement.getClassName();
                }
            }
            return "";
        }
    }

    private String[] a(String[] strArr) {
        String str;
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        try {
            str = System.getenv("PATH");
        } catch (Exception unused) {
        }
        if (str != null && !"".equals(str)) {
            String[] split = str.split(":");
            int length = split.length;
            for (int i = 0; i < length; i++) {
                String str2 = split[i];
                if (!str2.endsWith("/")) {
                    str2 = str2 + '/';
                }
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String a(String str) {
        try {
            return aa.a().b(str).replace("\n", "");
        } catch (Exception unused) {
            return "";
        }
    }
}
