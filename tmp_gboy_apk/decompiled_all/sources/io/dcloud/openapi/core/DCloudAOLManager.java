package io.dcloud.openapi.core;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaa0a.aaaaaaaa;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

@Deprecated
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DCloudAOLManager {
    protected static AOLLoader aaaaaaa0 = null;
    private static String aaaaaaaa = "5.5.2.0606";
    protected static AtomicBoolean aaaaaaao = new AtomicBoolean(false);
    private static AtomicBoolean aaaaaaac = new AtomicBoolean(false);

    public static class InitConfig {
        private String aaaaaaa0;
        private String aaaaaaaa;
        private boolean aaaaaaao = false;

        public String getAdId() {
            return this.aaaaaaa0;
        }

        public String getAppId() {
            return this.aaaaaaaa;
        }

        public String getName() {
            return null;
        }

        public String getVersion() {
            return null;
        }

        public boolean isDebug() {
            return this.aaaaaaao;
        }

        public InitConfig setAdId(String str) {
            this.aaaaaaa0 = str;
            return this;
        }

        public InitConfig setAppId(String str) {
            this.aaaaaaaa = str;
            return this;
        }

        public void setDebug(boolean z) {
            this.aaaaaaao = z;
        }

        public InitConfig setName(String str) {
            return this;
        }

        public InitConfig setVersion(String str) {
            return this;
        }
    }

    public static abstract class PrivacyConfig {
        public boolean isAdult() {
            return true;
        }

        public boolean isCanGetAndroidId() {
            return true;
        }

        public boolean isCanGetIP() {
            return true;
        }

        public boolean isCanGetInstallAppList() {
            return true;
        }

        public boolean isCanGetMacAddress() {
            return true;
        }

        public boolean isCanGetOAID() {
            return true;
        }

        public boolean isCanGetRunningApps() {
            return true;
        }

        public boolean isCanUseLocation() {
            return true;
        }

        public boolean isCanUsePhoneState() {
            return true;
        }

        public boolean isCanUseRecordPermission() {
            return true;
        }

        public boolean isCanUseSensor() {
            return true;
        }

        public boolean isCanUseSimOperator() {
            return true;
        }

        public boolean isCanUseStorage() {
            return true;
        }

        public boolean isCanUseWifiState() {
            return true;
        }

        public boolean isGDTAgreeStrategy() {
            return true;
        }
    }

    static {
        UqBrM();
    }

    private static /* synthetic */ void UqBrM() {
        char[] charArray = "´¸ºù°¶º²ùµ¸®ù¤¿²»»ù\u009d¹¾\u0095¥¾³°²".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 215);
        }
        String str = new String(charArray);
        char[] charArray2 = "´»¾¹¾£".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 215);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean getPersonalAd(Context context) {
        AOLLoader aOLLoader = aaaaaaa0;
        if (aOLLoader == null) {
            return false;
        }
        return aOLLoader.getPersonalAOL(context);
    }

    public static String getVersion() {
        return aaaaaaaa;
    }

    public static void init(Context context, InitConfig initConfig) {
        if (context == null || initConfig == null) {
            throw new NullPointerException("context or config is null");
        }
        if (((context instanceof Activity) || (context instanceof Application)) && !aaaaaaao.get()) {
            aaaaaaao.set(true);
            if (aaaaaaa0 == null) {
                aaaaaaaa aaaaaaac2 = aaaaaaaa.aaaaaaac();
                aaaaaaac2.aaaaaaaa(context);
                aaaaaaac2.aaaaaaaa(initConfig);
                aaaaaaa0 = aaaaaaac2;
            }
        }
    }

    public static void initWebViewWithMultiProcess(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                        WebView.setDataDirectorySuffix(runningAppProcessInfo.processName);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public static boolean isInit() {
        return aaaaaaao.get();
    }

    public static void setPersonalAd(Context context, boolean z) {
        AOLLoader aOLLoader = aaaaaaa0;
        if (aOLLoader != null) {
            aOLLoader.setPersonalAOL(context, z);
        }
    }

    public static void setPrivacyConfig(PrivacyConfig privacyConfig) {
        AOLLoader aOLLoader = aaaaaaa0;
        if (aOLLoader == null) {
            throw new RuntimeException("please init first");
        }
        if (privacyConfig == null) {
            throw new RuntimeException("config is null");
        }
        aOLLoader.setPrivacyConfig(privacyConfig);
    }

    public static void updatePrivacyConfig(Context context, JSONObject jSONObject) {
    }
}
