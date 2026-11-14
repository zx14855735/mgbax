package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa;

import BPw6Q8.ASJ6gh;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.fl.saas.base.cache.DatabaseHelper;
import com.kuaishou.weapon.p0.g;
import io.dcloud.openapi.poly.base.utils.PrivacyManager;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class aaaaaaac {
    private static String[] aaaaaaa0;
    private static boolean aaaaaaaa;
    private static String aaaaaaac;
    private static boolean aaaaaaae;
    private static String aaaaaaan;
    private static boolean aaaaaaao;
    private static boolean aaaaaaau;
    private static String aaaaaaav;

    private static String aaaaaaa0(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String aaaaaaaa(Context context) {
        if (!PrivacyManager.getInstance().aaaaaaac()) {
            return aaaaaaan;
        }
        if (!io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaaa().aaaaaaaa(context)) {
            return aaaaaaan;
        }
        if (PrivacyManager.getInstance().aaaaaaau()) {
            String aaaaaaao2 = PrivacyManager.getInstance().aaaaaaao();
            aaaaaaan = aaaaaaao2;
            return aaaaaaao2;
        }
        if (!aaaaaaau) {
            aaaaaaan = Settings.System.getString(context.getContentResolver(), "android_id");
            aaaaaaau = true;
        }
        return aaaaaaan;
    }

    public static String aaaaaaac(Context context) {
        if (ASJ6gh.A2egSU(context, g.d) != 0) {
            return aaaaaaav;
        }
        if (!PrivacyManager.getInstance().aaaaaaac()) {
            return aaaaaaav;
        }
        if (!io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaaa().aaaaaaaa(context)) {
            return aaaaaaav;
        }
        if (aaaaaaae) {
            return aaaaaaav;
        }
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        String macAddress = connectionInfo == null ? null : connectionInfo.getMacAddress();
        aaaaaaav = macAddress;
        aaaaaaae = true;
        return macAddress;
    }

    public static String aaaaaaao(Context context) {
        String str;
        String str2;
        if (context == null) {
            return "";
        }
        try {
        } catch (Exception unused) {
            str = null;
        }
        if (ASJ6gh.A2egSU(context, g.c) != 0) {
            return aaaaaaac;
        }
        if (!PrivacyManager.getInstance().aaaaaaac()) {
            return aaaaaaac;
        }
        if (!io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaaa().aaaaaaaa(context)) {
            return aaaaaaac;
        }
        if (PrivacyManager.getInstance().aaaaaaau()) {
            String aaaaaaa02 = PrivacyManager.getInstance().aaaaaaa0();
            aaaaaaac = aaaaaaa02;
            return aaaaaaa02;
        }
        if (aaaaaaao) {
            return aaaaaaac;
        }
        int aaaaaaa03 = aaaaaaa0(0, context);
        int aaaaaaa04 = aaaaaaa0(1, context);
        if (aaaaaaa03 == -1 && aaaaaaa04 == -1) {
            str2 = aaaaaaa0(context);
        } else {
            str = (String) aaaaaaaa(aaaaaaa03, context);
            String str3 = (String) aaaaaaaa(aaaaaaa04, context);
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (!TextUtils.isEmpty(str3) && !str.equals(str3)) {
                        str2 = str + "," + str3;
                    }
                } catch (Exception unused2) {
                }
                aaaaaaao = true;
                aaaaaaac = str;
                return str;
            }
            if (!TextUtils.isEmpty(str3)) {
                str = str3;
                aaaaaaao = true;
                aaaaaaac = str;
                return str;
            }
            str2 = aaaaaaa0(context);
        }
        str = str2;
        aaaaaaao = true;
        aaaaaaac = str;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
    
        if (aaaaaaaa(r3) == false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String[] aaaaaaau(android.content.Context r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = "android.permission.READ_PHONE_STATE"
            int r1 = BPw6Q8.ASJ6gh.A2egSU(r3, r1)
            if (r1 == 0) goto Lf
            java.lang.String[] r3 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaac.aaaaaaa0
            return r3
        Lf:
            io.dcloud.openapi.poly.base.utils.PrivacyManager r1 = io.dcloud.openapi.poly.base.utils.PrivacyManager.getInstance()
            boolean r1 = r1.aaaaaaac()
            if (r1 != 0) goto L1c
            java.lang.String[] r3 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaac.aaaaaaa0
            return r3
        L1c:
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa r1 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaanaaa.aaaaaaaa.aaaaaaaa()
            boolean r1 = r1.aaaaaaaa(r3)
            if (r1 != 0) goto L29
            java.lang.String[] r3 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaac.aaaaaaa0
            return r3
        L29:
            io.dcloud.openapi.poly.base.utils.PrivacyManager r1 = io.dcloud.openapi.poly.base.utils.PrivacyManager.getInstance()
            boolean r1 = r1.aaaaaaau()
            if (r1 == 0) goto L3e
            io.dcloud.openapi.poly.base.utils.PrivacyManager r3 = io.dcloud.openapi.poly.base.utils.PrivacyManager.getInstance()
            java.lang.String[] r3 = r3.aaaaaaaa()
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaac.aaaaaaa0 = r3
            return r3
        L3e:
            boolean r1 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaac.aaaaaaaa
            if (r1 == 0) goto L45
            java.lang.String[] r3 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaac.aaaaaaa0
            return r3
        L45:
            java.lang.String r1 = "phone"
            java.lang.Object r3 = r3.getSystemService(r1)
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3
            java.lang.String r1 = r3.getDeviceId()     // Catch: java.lang.Exception -> L68
            java.lang.String r3 = OQbmgg.A2egSU.AZkASS(r3)     // Catch: java.lang.Exception -> L68
            boolean r2 = aaaaaaaa(r1)     // Catch: java.lang.Exception -> L68
            if (r2 != 0) goto L5c
            goto L5d
        L5c:
            r1 = r0
        L5d:
            boolean r2 = aaaaaaaa(r3)     // Catch: java.lang.Exception -> L66
            if (r2 != 0) goto L64
            goto L6b
        L64:
            r3 = r0
            goto L6b
        L66:
            goto L64
        L68:
            r1 = r0
            goto L64
        L6b:
            boolean r2 = aaaaaaaa(r1)
            if (r2 != 0) goto L7e
            boolean r2 = aaaaaaaa(r3)
            if (r2 != 0) goto L7e
            java.lang.String[] r3 = new java.lang.String[]{r1, r3}
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaac.aaaaaaa0 = r3
            goto L9a
        L7e:
            boolean r2 = aaaaaaaa(r1)
            if (r2 != 0) goto L8b
            java.lang.String[] r3 = new java.lang.String[]{r1}
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaac.aaaaaaa0 = r3
            goto L9a
        L8b:
            boolean r1 = aaaaaaaa(r3)
            if (r1 != 0) goto L98
            java.lang.String[] r3 = new java.lang.String[]{r3}
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaac.aaaaaaa0 = r3
            goto L9a
        L98:
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaac.aaaaaaa0 = r0
        L9a:
            r3 = 1
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaac.aaaaaaaa = r3
            java.lang.String[] r3 = io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaac.aaaaaaa0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaoaa.aaaaaaac.aaaaaaau(android.content.Context):java.lang.String[]");
    }

    private static int aaaaaaa0(int i, Context context) {
        Uri parse = Uri.parse("content://telephony/siminfo");
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        try {
            cursor = contentResolver.query(parse, new String[]{DatabaseHelper.COLUMN_ID, "sim_id"}, "sim_id = ?", new String[]{String.valueOf(i)}, null);
        } catch (Exception unused) {
            if (cursor == null) {
                return -1;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
                throw th;
            }
            throw th;
        }
        if (cursor != null && cursor.moveToFirst()) {
            int i2 = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
            cursor.close();
            return i2;
        }
        if (cursor == null) {
            return -1;
        }
        cursor.close();
        return -1;
    }

    private static Object aaaaaaaa(int i, Context context) {
        try {
            Object systemService = context.getSystemService("phone");
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 21) {
                return aaaaaaaa(systemService.getClass().getName(), "getSubscriberId", systemService, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
            }
            if (i2 == 21) {
                return aaaaaaaa(systemService.getClass().getName(), "getSubscriberId", systemService, new Class[]{Long.TYPE}, new Object[]{Integer.valueOf(i)});
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static Object aaaaaaaa(String str, String str2, Object obj, Class[] clsArr, Object[] objArr) {
        try {
            Method method = Class.forName(str).getMethod(str2, clsArr);
            if (method == null) {
                return null;
            }
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return null;
        }
    }

    private static boolean aaaaaaaa(String str) {
        return TextUtils.isEmpty(str) || str.contains("Unknown") || str.contains("00000000");
    }
}
