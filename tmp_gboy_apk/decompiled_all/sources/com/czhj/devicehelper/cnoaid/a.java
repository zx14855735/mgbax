package com.czhj.devicehelper.cnoaid;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.czhj.devicehelper.cnoaid.impl.m;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private Application f10484a;
    private boolean b;
    private String c;
    private String d;

    /* renamed from: com.czhj.devicehelper.cnoaid.a$a, reason: collision with other inner class name */
    public static class C0212a {

        /* renamed from: a, reason: collision with root package name */
        static final a f10486a = new a();

        static {
            UggTHx();
        }

        private C0212a() {
        }

        private static /* synthetic */ void UggTHx() {
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

    private a() {
    }

    public static String a() {
        String str = C0212a.f10486a.c;
        return str == null ? "" : str;
    }

    public static String b() {
        return a(a(), "MD5");
    }

    public static String c() {
        return a(a(), MessageDigestAlgorithms.SHA_1);
    }

    public static String d() {
        String str = C0212a.f10486a.d;
        return str == null ? "" : str;
    }

    @Deprecated
    public static String e() {
        try {
            byte[] propertyByteArray = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId");
            if (propertyByteArray == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (byte b : propertyByteArray) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Throwable th) {
            g.a(th);
            return "";
        }
    }

    public static String f() {
        StringBuilder sb = new StringBuilder();
        com.bykv.vk.component.ttvideo.player.A2egSU.B4ZgIw(Build.BOARD, 10, sb);
        com.bykv.vk.component.ttvideo.player.A2egSU.B4ZgIw(Arrays.deepToString(Build.SUPPORTED_ABIS), 10, sb);
        com.bykv.vk.component.ttvideo.player.A2egSU.B4ZgIw(Build.DEVICE, 10, sb);
        com.bykv.vk.component.ttvideo.player.A2egSU.B4ZgIw(Build.DISPLAY, 10, sb);
        com.bykv.vk.component.ttvideo.player.A2egSU.B4ZgIw(Build.HOST, 10, sb);
        com.bykv.vk.component.ttvideo.player.A2egSU.B4ZgIw(Build.ID, 10, sb);
        com.bykv.vk.component.ttvideo.player.A2egSU.B4ZgIw(Build.MANUFACTURER, 10, sb);
        com.bykv.vk.component.ttvideo.player.A2egSU.B4ZgIw(Build.BRAND, 10, sb);
        com.bykv.vk.component.ttvideo.player.A2egSU.B4ZgIw(Build.MODEL, 10, sb);
        com.bykv.vk.component.ttvideo.player.A2egSU.B4ZgIw(Build.PRODUCT, 10, sb);
        com.bykv.vk.component.ttvideo.player.A2egSU.B4ZgIw(Build.BOOTLOADER, 10, sb);
        com.bykv.vk.component.ttvideo.player.A2egSU.B4ZgIw(Build.HARDWARE, 10, sb);
        com.bykv.vk.component.ttvideo.player.A2egSU.B4ZgIw(Build.TAGS, 10, sb);
        com.bykv.vk.component.ttvideo.player.A2egSU.B4ZgIw(Build.TYPE, 10, sb);
        sb.append(Build.USER.length() % 10);
        return sb.toString();
    }

    private static String g(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        File h = h(context);
        if (h != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(h));
                try {
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                } finally {
                }
            } catch (Exception e) {
                g.a(e);
            }
        }
        g.a("Get uuid from external storage: " + str);
        return str;
    }

    private static File h(Context context) {
        int checkSelfPermission;
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            if (i >= 30 || context == null) {
                return null;
            }
            checkSelfPermission = context.checkSelfPermission(com.kuaishou.weapon.p0.g.j);
            if (checkSelfPermission != 0) {
                return null;
            }
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            return new File(Environment.getExternalStorageDirectory(), "Android/.GUID_uuid");
        }
        return null;
    }

    private static String i(Context context) {
        if (context == null) {
            return "";
        }
        String string = context.getSharedPreferences("GUID", 0).getString("uuid", "");
        g.a("Get uuid from shared preferences: " + string);
        return string;
    }

    public static String b(Context context) {
        int checkSelfPermission;
        String str;
        int i = Build.VERSION.SDK_INT;
        if (i < 29) {
            if (context == null) {
                return "";
            }
            if (i >= 23) {
                checkSelfPermission = context.checkSelfPermission(com.kuaishou.weapon.p0.g.c);
                str = checkSelfPermission != 0 ? "android.permission.READ_PHONE_STATE not granted" : "IMEI/MEID not allowed on Android 10+";
            }
            return e(context);
        }
        g.a(str);
        return "";
    }

    @SuppressLint({"HardwareIds"})
    public static String c(Context context) {
        String string;
        return (context == null || (string = Settings.Secure.getString(context.getContentResolver(), "android_id")) == null || "9774d56d682e549c".equals(string)) ? "" : string;
    }

    public static String d(Context context) {
        String f = f(context);
        if (TextUtils.isEmpty(f)) {
            f = g(context);
        }
        if (TextUtils.isEmpty(f)) {
            f = i(context);
        }
        if (!TextUtils.isEmpty(f)) {
            return f;
        }
        String uuid = UUID.randomUUID().toString();
        g.a("Generate uuid by random: " + uuid);
        c(context, uuid);
        a(context, uuid);
        b(context, uuid);
        return uuid;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static String e(Context context) {
        String imei;
        String meid;
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            imei = telephonyManager.getImei();
            if (!TextUtils.isEmpty(imei)) {
                return imei;
            }
            meid = telephonyManager.getMeid();
            return meid;
        } catch (Error | Exception e) {
            g.a(e);
            return "";
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance(str2).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Exception e) {
            g.a(e);
            return "";
        }
    }

    private static void c(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("GUID", 0).edit().putString("uuid", str).apply();
        g.a("Save uuid to shared preferences: " + str);
    }

    public static void a(Application application) {
        a(application, false, null);
    }

    private static void b(final Application application, final boolean z, final e eVar) {
        a(application, new c() { // from class: com.czhj.devicehelper.cnoaid.a.1
            @Override // com.czhj.devicehelper.cnoaid.c
            public void a(Exception exc) {
                a.b(exc, application, z, eVar);
            }

            @Override // com.czhj.devicehelper.cnoaid.c
            public void a(String str) {
                if (TextUtils.isEmpty(str)) {
                    a(new f("OAID is empty"));
                    return;
                }
                a aVar = C0212a.f10486a;
                aVar.c = str;
                aVar.d = str;
                g.a("Client id is OAID/AAID: " + str);
            }
        });
    }

    public static void a(Application application, e eVar) {
        a(application, false, null);
    }

    private static void b(Context context, String str) {
        if (context == null) {
            return;
        }
        File h = h(context);
        if (h == null) {
            g.a("UUID file in external storage is null");
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(h));
            try {
                if (!h.exists()) {
                    h.createNewFile();
                }
                bufferedWriter.write(str);
                bufferedWriter.flush();
                g.a("Save uuid to external storage: " + str);
                bufferedWriter.close();
            } finally {
            }
        } catch (Exception e) {
            g.a(e);
        }
    }

    public static void a(Application application, boolean z) {
        a(application, z, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Exception exc, Application application, boolean z, e eVar) {
        if (z) {
            String e = e();
            if (!TextUtils.isEmpty(e)) {
                C0212a.f10486a.c = e;
                g.a("Client id is WidevineID: " + e);
                if (eVar != null) {
                    eVar.a(e, exc);
                    return;
                }
                return;
            }
        }
        String c = c(application);
        if (!TextUtils.isEmpty(c)) {
            C0212a.f10486a.c = c;
            g.a("Client id is AndroidID: " + c);
            if (eVar != null) {
                eVar.a(c, exc);
                return;
            }
            return;
        }
        String d = d(application);
        C0212a.f10486a.c = d;
        g.a("Client id is GUID: " + d);
        if (eVar != null) {
            eVar.a(d, exc);
        }
    }

    public static void a(Application application, boolean z, e eVar) {
        if (application == null) {
            if (eVar != null) {
                eVar.a("", new RuntimeException("application is nulll"));
                return;
            }
            return;
        }
        a aVar = C0212a.f10486a;
        aVar.f10484a = application;
        aVar.b = z;
        String b = b(application);
        if (TextUtils.isEmpty(b)) {
            b(application, z, eVar);
            return;
        }
        aVar.c = b;
        g.a("Client id is IMEI/MEID: " + aVar.c);
        if (eVar != null) {
            eVar.a(b, null);
        }
    }

    public static void a(Context context, c cVar) {
        d a2 = m.a(context);
        g.a("OAID implements class: ".concat(a2.getClass().getName()));
        a2.a(cVar);
    }

    private static void a(Context context, String str) {
        boolean canWrite;
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            canWrite = Settings.System.canWrite(context);
            if (!canWrite) {
                g.a("android.permission.WRITE_SETTINGS not granted");
                return;
            }
        }
        try {
            Settings.System.putString(context.getContentResolver(), "GUID_uuid", str);
            g.a("Save uuid to system settings: " + str);
        } catch (Exception e) {
            g.a(e);
        }
    }

    public static boolean a(Context context) {
        return m.a(context).a();
    }

    private static String f(Context context) {
        if (context == null) {
            return "";
        }
        String string = Settings.System.getString(context.getContentResolver(), "GUID_uuid");
        g.a("Get uuid from system settings: " + string);
        return string;
    }
}
