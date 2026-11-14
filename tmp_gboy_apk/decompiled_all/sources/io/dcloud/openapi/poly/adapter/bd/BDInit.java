package io.dcloud.openapi.poly.adapter.bd;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.BDDialogParams;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import io.dcloud.openapi.core.DCloudAOLManager;
import io.dcloud.openapi.core.util.AdUtil;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class BDInit {
    public static BDInit b;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f13933a = new AtomicBoolean(false);

    public static BDInit getInstance() {
        if (b == null) {
            synchronized (BDInit.class) {
                try {
                    if (b == null) {
                        b = new BDInit();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public final void init(Context context, String str) {
        if (this.f13933a.get() || TextUtils.isEmpty(str)) {
            return;
        }
        new BDAdConfig.Builder().setAppsid(str).setDialogParams(new BDDialogParams.Builder().setDlDialogType(0).setDlDialogAnimStyle(0).build()).putExtraParam("pk_change_rc", "false").putExtraParam("mi_market_rc", "false").build(context).init();
        this.f13933a.set(true);
        setPersonalAd(AdUtil.getPersonalAd(context));
    }

    public final void setCustomPermission(DCloudAOLManager.PrivacyConfig privacyConfig) {
        if (privacyConfig == null) {
            return;
        }
        MobadsPermissionSettings.setPermissionAppList(privacyConfig.isCanGetInstallAppList());
        MobadsPermissionSettings.setPermissionLocation(privacyConfig.isCanUseLocation());
        MobadsPermissionSettings.setPermissionStorage(privacyConfig.isCanUseStorage());
        MobadsPermissionSettings.setPermissionRunningApp(privacyConfig.isCanGetRunningApps());
        MobadsPermissionSettings.setPermissionReadDeviceID(privacyConfig.isCanUsePhoneState());
        MobadsPermissionSettings.setPermissionOAID(privacyConfig.isCanGetOAID());
    }

    public final void setPersonalAd(boolean z) {
        MobadsPermissionSettings.setLimitPersonalAds(!z);
    }
}
