package com.octopus.ad.utils.a;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.octopus.ad.Octopus;
import com.octopus.ad.utils.a.b.k;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f12664a = true;
    private static String b = "";
    private Application c;
    private String d;
    private String e;

    /* renamed from: com.octopus.ad.utils.a.a$a, reason: collision with other inner class name */
    public static class C0425a {

        /* renamed from: a, reason: collision with root package name */
        static final a f12665a = new a();

        static {
            KnaMja();
        }

        private static /* synthetic */ void KnaMja() {
            char[] charArray = "xtv5|zv~5ytb5hs~ww5QurYir\u007f|~".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 27);
            }
            String str = new String(charArray);
            char[] charArray2 = "xwruro".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 27);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static void a(Application application) {
        if (application == null) {
            return;
        }
        a aVar = C0425a.f12665a;
        aVar.c = application;
        a(application, aVar);
    }

    @SuppressLint({"HardwareIds"})
    public static String b(Context context) {
        if (f12664a) {
            f12664a = false;
            if (Octopus.getCustomController() == null || Octopus.getCustomController().isCanUsePhoneState()) {
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                b = string;
                if (string == null) {
                    b = "";
                }
            }
        }
        return b;
    }

    public static String c() {
        StringBuilder sb = new StringBuilder();
        A2egSU.B4ZgIw(Build.BOARD, 10, sb);
        A2egSU.B4ZgIw(Arrays.deepToString(Build.SUPPORTED_ABIS), 10, sb);
        A2egSU.B4ZgIw(Build.DEVICE, 10, sb);
        A2egSU.B4ZgIw(Build.DISPLAY, 10, sb);
        A2egSU.B4ZgIw(Build.HOST, 10, sb);
        A2egSU.B4ZgIw(Build.ID, 10, sb);
        A2egSU.B4ZgIw(Build.MANUFACTURER, 10, sb);
        A2egSU.B4ZgIw(Build.BRAND, 10, sb);
        A2egSU.B4ZgIw(Build.MODEL, 10, sb);
        A2egSU.B4ZgIw(Build.PRODUCT, 10, sb);
        A2egSU.B4ZgIw(Build.BOOTLOADER, 10, sb);
        A2egSU.B4ZgIw(Build.HARDWARE, 10, sb);
        A2egSU.B4ZgIw(Build.TAGS, 10, sb);
        A2egSU.B4ZgIw(Build.TYPE, 10, sb);
        sb.append(Build.USER.length() % 10);
        return sb.toString();
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static String d(Context context) {
        return "";
    }

    private static String e(Context context) {
        if (context == null) {
            return "";
        }
        String string = Settings.System.getString(context.getContentResolver(), "GUID_uuid");
        f.a("Get uuid from system settings: " + string);
        return string;
    }

    private static String f(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        File g = g(context);
        if (g != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(g));
                try {
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                } finally {
                }
            } catch (Exception e) {
                f.a(e);
            }
        }
        f.a("Get uuid from external storage: " + str);
        return str;
    }

    private static File g(Context context) {
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

    private static String h(Context context) {
        if (context == null) {
            return "";
        }
        String string = context.getSharedPreferences("GUID", 0).getString("uuid", "");
        f.a("Get uuid from shared preferences: " + string);
        return string;
    }

    private a() {
    }

    public static String a() {
        String str = C0425a.f12665a.e;
        return str == null ? "" : str;
    }

    public static void a(Context context, c cVar) {
        try {
            k.a(context).a(cVar);
        } catch (Throwable th) {
            f.a(th);
        }
    }

    public static String b() {
        try {
            byte[] propertyByteArray = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId");
            if (propertyByteArray == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (byte b2 : propertyByteArray) {
                sb.append(String.format("%02x", Byte.valueOf(b2)));
            }
            return sb.toString();
        } catch (Error e) {
            f.a(e);
            return "";
        } catch (Exception e2) {
            f.a(e2);
            return "";
        }
    }

    public static String a(Context context) {
        int checkSelfPermission;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            f.a("IMEI/MEID not allowed on Android 10+");
            return "";
        }
        if (context == null) {
            return "";
        }
        if (i >= 23) {
            checkSelfPermission = context.checkSelfPermission(com.kuaishou.weapon.p0.g.c);
            if (checkSelfPermission != 0) {
                f.a("android.permission.READ_PHONE_STATE not granted");
                return "";
            }
        }
        return d(context);
    }

    private static void a(Context context, String str) {
        boolean canWrite;
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            canWrite = Settings.System.canWrite(context);
            if (!canWrite) {
                f.a("android.permission.WRITE_SETTINGS not granted");
                return;
            }
        }
        try {
            Settings.System.putString(context.getContentResolver(), "GUID_uuid", str);
            f.a("Save uuid to system settings: " + str);
        } catch (Exception e) {
            f.a(e);
        }
    }

    private static void b(Context context, String str) {
        if (context == null) {
            return;
        }
        File g = g(context);
        if (g == null) {
            f.a("UUID file in external storage is null");
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(g));
            try {
                if (!g.exists()) {
                    g.createNewFile();
                }
                bufferedWriter.write(str);
                bufferedWriter.flush();
                f.a("Save uuid to external storage: " + str);
                bufferedWriter.close();
            } finally {
            }
        } catch (Exception e) {
            f.a(e);
        }
    }

    @Override // com.octopus.ad.utils.a.c
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            a(new e("OAID is empty"));
            return;
        }
        this.d = str;
        this.e = str;
        f.a("Client id is OAID: " + this.d);
    }

    @Override // com.octopus.ad.utils.a.c
    public void a(Exception exc) {
        f.a("onOAIDGetError: " + exc.getMessage());
        String b2 = b(this.c);
        if (!TextUtils.isEmpty(b2)) {
            this.d = b2;
            f.a("Client id is AndroidID: " + this.d);
            return;
        }
        String a2 = a((Context) this.c);
        if (!TextUtils.isEmpty(a2)) {
            this.d = a2;
            f.a("Client id is IMEI/MEID: " + this.d);
            return;
        }
        String b3 = b();
        if (!TextUtils.isEmpty(b3)) {
            this.d = b3;
            f.a("Client id is WidevineID: " + this.d);
            return;
        }
        String c = c();
        if (!TextUtils.isEmpty(c)) {
            this.d = c;
            f.a("Client id is PseudoID: " + this.d);
            return;
        }
        this.d = c(this.c);
        f.a("Client id is GUID: " + this.d);
    }

    public static String c(Context context) {
        String e = e(context);
        if (TextUtils.isEmpty(e)) {
            e = f(context);
        }
        if (TextUtils.isEmpty(e)) {
            e = h(context);
        }
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        String uuid = UUID.randomUUID().toString();
        f.a("Generate uuid by random: " + uuid);
        c(context, uuid);
        a(context, uuid);
        b(context, uuid);
        return uuid;
    }

    private static void c(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("GUID", 0).edit().putString("uuid", str).apply();
        f.a("Save uuid to shared preferences: " + str);
    }
}
