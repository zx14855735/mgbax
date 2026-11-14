package io.dcloud.openapi.poly.adapter.gdt;

import android.content.Context;
import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import io.dcloud.openapi.core.DCloudAOLManager;
import io.dcloud.openapi.core.util.AdUtil;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class GDTInit {
    public static GDTInit b;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f13972a = new AtomicBoolean(false);

    public static GDTInit getInstance() {
        if (b == null) {
            synchronized (GDTInit.class) {
                try {
                    if (b == null) {
                        b = new GDTInit();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public String init(Context context, String str) {
        if (this.f13972a.get()) {
            return "";
        }
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("hieib", Boolean.FALSE);
            GlobalSetting.setConvOptimizeInfo(hashMap);
            GDTAdSdk.initWithoutStart(context, str);
            this.f13972a.set(true);
        }
        setPersonalAd(AdUtil.getPersonalAd(context));
        return str;
    }

    public void setCustomPermission(DCloudAOLManager.PrivacyConfig privacyConfig) {
        if (privacyConfig == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("mac_address", Boolean.valueOf(privacyConfig.isCanGetMacAddress()));
        hashMap.put("android_id", Boolean.valueOf(privacyConfig.isCanGetAndroidId()));
        hashMap.put("device_id", Boolean.valueOf(privacyConfig.isCanUsePhoneState()));
        hashMap.put("oaid", Boolean.valueOf(privacyConfig.isCanGetOAID()));
        hashMap.put("cell_id", Boolean.valueOf(privacyConfig.isCanUseLocation()));
        hashMap.put("ssid", Boolean.valueOf(privacyConfig.isCanUseWifiState()));
        hashMap.put("bssid", Boolean.valueOf(privacyConfig.isCanUseWifiState()));
        hashMap.put("mipaddr", Boolean.valueOf(privacyConfig.isCanGetIP()));
        if (privacyConfig.isGDTAgreeStrategy()) {
            Boolean bool = Boolean.FALSE;
            hashMap.put("taid", bool);
            hashMap.put("oaid", bool);
        }
        GlobalSetting.setAgreeReadPrivacyInfo(hashMap);
        GlobalSetting.setEnableCollectAppInstallStatus(privacyConfig.isCanGetInstallAppList());
        GlobalSetting.setAgreePrivacyStrategy(privacyConfig.isGDTAgreeStrategy());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("sensor_ts", privacyConfig.isCanUseSensor() ? "1" : Constants.FAIL);
        GlobalSetting.setExtraUserData(hashMap2);
    }

    public void setPersonalAd(boolean z) {
        GlobalSetting.setPersonalizedState(!z ? 1 : 0);
    }
}
