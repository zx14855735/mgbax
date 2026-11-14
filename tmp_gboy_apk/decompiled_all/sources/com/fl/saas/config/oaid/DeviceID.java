package com.fl.saas.config.oaid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.fl.saas.config.oaid.impl.OAIDFactory;
import com.kuaishou.weapon.p0.g;
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
public final class DeviceID implements IGetter {
    private Context application;
    private String clientId;
    private String oaid;

    public static class Holder {
        static final DeviceID INSTANCE = new DeviceID();

        static {
            HQadqg();
        }

        private Holder() {
        }

        private static /* synthetic */ void HQadqg() {
            char[] charArray = "\u008b\u0087\u0085Æ\u008f\u0089\u0085\u008dÆ\u008a\u0087\u0091Æ\u009b\u0080\u008d\u0084\u0084Æ¢\u0086\u0081ª\u009a\u0081\u008c\u008f\u008d".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 232);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u008b\u0084\u0081\u0086\u0081\u009c".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 232);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private DeviceID() {
    }

    public static String calculateHash(String str, String str2) {
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
            OAIDLog.print(e);
            return "";
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String getAndroidID(Context context) {
        String string;
        return (context == null || (string = Settings.Secure.getString(context.getContentResolver(), "android_id")) == null || "9774d56d682e549c".equals(string)) ? "" : string;
    }

    public static String getClientId() {
        String str = Holder.INSTANCE.clientId;
        return str == null ? "" : str;
    }

    public static String getClientIdMD5() {
        return calculateHash(getClientId(), "MD5");
    }

    public static String getClientIdSHA1() {
        return calculateHash(getClientId(), MessageDigestAlgorithms.SHA_1);
    }

    public static String getGUID(Context context) {
        String uuidFromSystemSettings = getUuidFromSystemSettings(context);
        if (TextUtils.isEmpty(uuidFromSystemSettings)) {
            uuidFromSystemSettings = getUuidFromExternalStorage(context);
        }
        if (TextUtils.isEmpty(uuidFromSystemSettings)) {
            uuidFromSystemSettings = getUuidFromSharedPreferences(context);
        }
        if (!TextUtils.isEmpty(uuidFromSystemSettings)) {
            return uuidFromSystemSettings;
        }
        String uuid = UUID.randomUUID().toString();
        OAIDLog.print("Generate uuid by random: " + uuid);
        saveUuidToSharedPreferences(context, uuid);
        saveUuidToSystemSettings(context, uuid);
        saveUuidToExternalStorage(context, uuid);
        return uuid;
    }

    private static File getGuidFile(Context context) {
        int checkSelfPermission;
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            if (i > 29 || context == null) {
                return null;
            }
            checkSelfPermission = context.checkSelfPermission(g.j);
            if (checkSelfPermission != 0) {
                return null;
            }
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            return new File(Environment.getExternalStorageDirectory(), "Android/.GUID_uuid");
        }
        return null;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static String getIMEI(Context context) {
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
            OAIDLog.print(e);
            return "";
        }
    }

    public static String getOAID() {
        String str = Holder.INSTANCE.oaid;
        return str == null ? "" : str;
    }

    public static String getPseudoID() {
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

    public static String getUniqueID(Context context) {
        int checkSelfPermission;
        String str;
        int i = Build.VERSION.SDK_INT;
        if (i < 29) {
            if (context == null) {
                return "";
            }
            if (i >= 23) {
                checkSelfPermission = context.checkSelfPermission(g.c);
                str = checkSelfPermission != 0 ? "android.permission.READ_PHONE_STATE not granted" : "IMEI/MEID not allowed on Android 10+";
            }
            return getIMEI(context);
        }
        OAIDLog.print(str);
        return "";
    }

    private static String getUuidFromExternalStorage(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        File guidFile = getGuidFile(context);
        if (guidFile != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(guidFile));
                try {
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                } finally {
                }
            } catch (Exception e) {
                OAIDLog.print(e);
            }
        }
        OAIDLog.print("Get uuid from external storage: " + str);
        return str;
    }

    private static String getUuidFromSharedPreferences(Context context) {
        if (context == null) {
            return "";
        }
        String string = context.getSharedPreferences("GUID", 0).getString("uuid", "");
        OAIDLog.print("Get uuid from shared preferences: " + string);
        return string;
    }

    private static String getUuidFromSystemSettings(Context context) {
        if (context == null) {
            return "";
        }
        String string = Settings.System.getString(context.getContentResolver(), "GUID_uuid");
        OAIDLog.print("Get uuid from system settings: " + string);
        return string;
    }

    public static String getWidevineID() {
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
        } catch (Error e) {
            e = e;
            OAIDLog.print(e);
            return "";
        } catch (Exception e2) {
            e = e2;
            OAIDLog.print(e);
            return "";
        }
    }

    public static void register(Context context) {
        if (context == null) {
            return;
        }
        DeviceID deviceID = Holder.INSTANCE;
        deviceID.application = context;
        String uniqueID = getUniqueID(context);
        if (TextUtils.isEmpty(uniqueID)) {
            getOAID(context, deviceID);
            return;
        }
        deviceID.clientId = uniqueID;
        OAIDLog.print("Client id is IMEI/MEID: " + deviceID.clientId);
    }

    private static void saveUuidToExternalStorage(Context context, String str) {
        if (context == null) {
            return;
        }
        File guidFile = getGuidFile(context);
        if (guidFile == null) {
            OAIDLog.print("UUID file in external storage is null");
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(guidFile));
            try {
                if (!guidFile.exists()) {
                    guidFile.createNewFile();
                }
                bufferedWriter.write(str);
                bufferedWriter.flush();
                OAIDLog.print("Save uuid to external storage: " + str);
                bufferedWriter.close();
            } finally {
            }
        } catch (Exception e) {
            OAIDLog.print(e);
        }
    }

    private static void saveUuidToSharedPreferences(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("GUID", 0).edit().putString("uuid", str).apply();
        OAIDLog.print("Save uuid to shared preferences: " + str);
    }

    private static void saveUuidToSystemSettings(Context context, String str) {
        boolean canWrite;
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            canWrite = Settings.System.canWrite(context);
            if (!canWrite) {
                OAIDLog.print("android.permission.WRITE_SETTINGS not granted");
                return;
            }
        }
        try {
            Settings.System.putString(context.getContentResolver(), "GUID_uuid", str);
            OAIDLog.print("Save uuid to system settings: " + str);
        } catch (Exception e) {
            OAIDLog.print(e);
        }
    }

    public static boolean supportedOAID(Context context) {
        return OAIDFactory.create(context).supported();
    }

    @Override // com.fl.saas.config.oaid.IGetter
    public void onOAIDGetComplete(String str) {
        if (TextUtils.isEmpty(str)) {
            onOAIDGetError(new OAIDException("OAID is empty"));
            return;
        }
        this.clientId = str;
        this.oaid = str;
        OAIDLog.print("Client id is OAID/AAID: " + this.clientId);
    }

    @Override // com.fl.saas.config.oaid.IGetter
    public void onOAIDGetError(Exception exc) {
        StringBuilder sb;
        String widevineID = getWidevineID();
        if (TextUtils.isEmpty(widevineID)) {
            String androidID = getAndroidID(this.application);
            if (TextUtils.isEmpty(androidID)) {
                this.clientId = getGUID(this.application);
                sb = new StringBuilder("Client id is GUID: ");
            } else {
                this.clientId = androidID;
                sb = new StringBuilder("Client id is AndroidID: ");
            }
        } else {
            this.clientId = widevineID;
            sb = new StringBuilder("Client id is WidevineID: ");
        }
        sb.append(this.clientId);
        OAIDLog.print(sb.toString());
    }

    public static void getOAID(Context context, IGetter iGetter) {
        OAIDFactory.create(context).doGet(iGetter);
    }
}
