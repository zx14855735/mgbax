package com.fl.saas.ydsdk.manager;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.czhj.sdk.common.A2egSU;
import com.fl.saas.base.adapter.AdapterManager;
import com.fl.saas.base.bean.CustomLocation;
import com.fl.saas.base.cache.PreloadHelper;
import com.fl.saas.base.manager.AdPersonalizedManager;
import com.fl.saas.config.http.ResponseCall;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.OaidUtils;
import com.fl.saas.config.utils.SPUtil;
import com.fl.saas.ydsdk.manager.YdParamConfig;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class YdConfig {
    private static boolean isInit;
    private int[] disableAppListAccessAdvs;

    public static final class Holder {
        private static final YdConfig INSTANCE = new YdConfig();

        static {
            GDRJYY();
        }

        private Holder() {
        }

        private static /* synthetic */ void GDRJYY() {
            char[] charArray = "[WU\u0016_YU]\u0016ZWA\u0016KP]TT\u0016rVQzJQ\\_]".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '8');
            }
            String str = new String(charArray);
            char[] charArray2 = "[TQVQL".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '8');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private YdConfig() {
    }

    private YdParamConfig defaultConfig() {
        return new YdParamConfig.Builder().build();
    }

    public static YdConfig getInstance() {
        return Holder.INSTANCE;
    }

    private void initConfig(Context context, String str, String str2, String str3, YdParamConfig ydParamConfig, boolean z) {
        DeviceUtil.channelId = !TextUtils.isEmpty(str2) ? str2 : "";
        if (TextUtils.isEmpty(str3)) {
            str2 = "";
        }
        DeviceUtil.subChannel = str2;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        DeviceUtil.appId = str;
        if (ydParamConfig != null) {
            DeviceUtil.isCanUseBootID = ydParamConfig.getBuilder().isCanUseBootID();
            DeviceUtil.isCanUseSSID = ydParamConfig.getBuilder().isCanUseSSID();
            DeviceUtil.isCanUseAndroid = ydParamConfig.getBuilder().isCanUseAndroid();
            DeviceUtil.isCanUseIMEI = ydParamConfig.getBuilder().isCanUseIMEI();
            DeviceUtil.isCanUseMac = ydParamConfig.getBuilder().isCanUseMac();
            DeviceUtil.isCanUseIMSI = ydParamConfig.getBuilder().isCanUseIMSI();
            DeviceUtil.isCanUseLocation = ydParamConfig.getBuilder().isCanUseLocation();
            DeviceUtil.isInitializeGDT = ydParamConfig.getBuilder().isInitializeGDT();
            DeviceUtil.isInitializeKS = ydParamConfig.getBuilder().isInitializeKS();
            DeviceUtil.isInitializeBD = ydParamConfig.getBuilder().isInitializeBD();
            DeviceUtil.isInitializeCSJ = ydParamConfig.getBuilder().isInitializeCSJ();
            DeviceUtil.isInitializeQTT = ydParamConfig.getBuilder().isInitializeQTT();
            if (!TextUtils.isEmpty(ydParamConfig.getBuilder().getCustomIMEI())) {
                DeviceUtil.deviceImei = ydParamConfig.getBuilder().getCustomIMEI();
                DeviceUtil.isGetImei = true;
            }
            if (!TextUtils.isEmpty(ydParamConfig.getBuilder().getCustomAndroidId())) {
                DeviceUtil.deviceAndroidID = ydParamConfig.getBuilder().getCustomAndroidId();
                DeviceUtil.isGetAndroidID = true;
            }
            if (!TextUtils.isEmpty(ydParamConfig.getBuilder().getCustomMac())) {
                DeviceUtil.deviceMac = ydParamConfig.getBuilder().getCustomMac();
                DeviceUtil.isGetMac = true;
            }
            if (!TextUtils.isEmpty(ydParamConfig.getBuilder().getCustomUserAgent())) {
                DeviceUtil.userAgent = ydParamConfig.getBuilder().getCustomUserAgent();
            }
            DeviceUtil.customLocation = ydParamConfig.getBuilder().getCustomLocation();
            LogcatUtil.isDebug = z;
            boolean isCanUseSensor = ydParamConfig.getBuilder().isCanUseSensor();
            DeviceUtil.isCanUseSensor = isCanUseSensor;
            if (!isCanUseSensor) {
                DeviceUtil.deviceHasAccelerometerSensor = false;
            }
            if (!ydParamConfig.getBuilder().isCanUseOaid()) {
                OaidUtils.setIsCanUseOAID(false);
                String customOAID = ydParamConfig.getBuilder().getCustomOAID();
                OaidUtils.setOaid(customOAID != null ? customOAID : "");
            }
        }
        DeviceUtil.setContext(context.getApplicationContext());
        ResponseCall.setContext(context.getApplicationContext());
        SPUtil.getInstance().init(context.getApplicationContext());
        DeviceUtil.initUserAgent();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            DeviceUtil.postUI(new A2egSU(3));
        } else {
            AdapterManager.preInitAdapter();
        }
    }

    public static boolean isInit() {
        return isInit;
    }

    public void disableAppListAccess(int... iArr) {
        this.disableAppListAccessAdvs = iArr;
    }

    public boolean hasDisableAppListAccess() {
        int[] iArr = this.disableAppListAccessAdvs;
        return iArr != null && iArr.length > 0;
    }

    public void init(Context context, String str) {
        init(context, str, "", "", defaultConfig(), false);
    }

    public boolean isAppListAccessEnabled(int i) {
        int[] iArr = this.disableAppListAccessAdvs;
        if (iArr == null) {
            return true;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return false;
            }
        }
        return true;
    }

    public void setActivityAndPreloadAd(Activity activity) {
        if (activity != null) {
            PreloadHelper.getInstance().setPreLoadContext(activity);
            PreloadHelper.getInstance().requestPreloadAd();
        }
    }

    public void setCustomLocation(CustomLocation customLocation) {
        DeviceUtil.customLocation = customLocation;
    }

    public void setCustomMap(Map<String, Object> map) {
        if (map != null) {
            DeviceUtil.customMap.clear();
            DeviceUtil.customMap.putAll(map);
        }
    }

    public void setEnableCollectAppInstallStatus(boolean z) {
        DeviceUtil.enableCollectAppInstallStatus = z;
    }

    public void setPersonalizedState(boolean z) {
        AdPersonalizedManager.updateAdPersonalizedConfig(z);
    }

    public void setUserExt(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        DeviceUtil.userExt = str;
    }

    public void init(Context context, String str, YdParamConfig ydParamConfig) {
        if (ydParamConfig != null) {
            init(context, str, "", "", ydParamConfig, false);
        } else {
            init(context, str, "", "", defaultConfig(), false);
        }
    }

    public void init(Context context, String str, String str2) {
        init(context, str, str2, "", defaultConfig(), false);
    }

    public void init(Context context, String str, String str2, YdParamConfig ydParamConfig, boolean z) {
        if (ydParamConfig != null) {
            init(context, str, str2, "", ydParamConfig, z);
        } else {
            init(context, str, str2, "", defaultConfig(), z);
        }
    }

    public void init(Context context, String str, String str2, String str3) {
        init(context, str, str2, str3, defaultConfig(), false);
    }

    public void init(Context context, String str, String str2, String str3, YdParamConfig ydParamConfig, boolean z) {
        if (isInit || context == null) {
            return;
        }
        try {
            initConfig(context, str, str2, str3, ydParamConfig, z);
            isInit = true;
        } catch (Exception unused) {
        }
    }

    public void init(Context context, String str, String str2, String str3, boolean z) {
        init(context, str, str2, str3, defaultConfig(), z);
    }

    public void init(Context context, String str, String str2, boolean z) {
        init(context, str, str2, "", defaultConfig(), z);
    }
}
