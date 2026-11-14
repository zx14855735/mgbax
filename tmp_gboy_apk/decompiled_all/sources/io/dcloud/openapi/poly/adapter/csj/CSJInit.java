package io.dcloud.openapi.poly.adapter.csj;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.czhj.sdk.common.Constants;
import io.dcloud.openapi.core.DCloudAOLManager;
import io.dcloud.openapi.core.util.AdUtil;
import io.dcloud.openapi.core.util.Const;
import io.dcloud.openapi.core.util.LoadAppUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class CSJInit {
    public static CSJInit e;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f13954a = new Handler(Looper.getMainLooper());
    public boolean b = false;
    public final TTCustomController c = new TTCustomController() { // from class: io.dcloud.openapi.poly.adapter.csj.CSJInit.2
        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean alist() {
            DCloudAOLManager.PrivacyConfig privacyConfig = CSJInit.this.d;
            return privacyConfig == null ? super.alist() : privacyConfig.isCanGetInstallAppList();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getDevOaid() {
            DCloudAOLManager.PrivacyConfig privacyConfig = CSJInit.this.d;
            return privacyConfig == null ? super.getDevOaid() : privacyConfig.isCanGetOAID() ? super.getDevOaid() : "00000000-0000-0000-0000-000000000000";
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public String getMacAddress() {
            DCloudAOLManager.PrivacyConfig privacyConfig = CSJInit.this.d;
            return privacyConfig == null ? super.getMacAddress() : privacyConfig.isCanGetMacAddress() ? super.getMacAddress() : "02:00:00:00:00:00";
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseAndroidId() {
            DCloudAOLManager.PrivacyConfig privacyConfig = CSJInit.this.d;
            return privacyConfig == null ? super.isCanUseAndroidId() : privacyConfig.isCanGetAndroidId();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseLocation() {
            DCloudAOLManager.PrivacyConfig privacyConfig = CSJInit.this.d;
            return privacyConfig == null ? super.isCanUseLocation() : privacyConfig.isCanUseLocation();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePermissionRecordAudio() {
            DCloudAOLManager.PrivacyConfig privacyConfig = CSJInit.this.d;
            return privacyConfig == null ? super.isCanUsePermissionRecordAudio() : privacyConfig.isCanUseRecordPermission();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUsePhoneState() {
            DCloudAOLManager.PrivacyConfig privacyConfig = CSJInit.this.d;
            return privacyConfig == null ? super.isCanUsePhoneState() : privacyConfig.isCanUsePhoneState();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWifiState() {
            DCloudAOLManager.PrivacyConfig privacyConfig = CSJInit.this.d;
            return privacyConfig == null ? super.isCanUseWifiState() : privacyConfig.isCanUseWifiState();
        }

        @Override // com.bytedance.sdk.openadsdk.TTCustomController
        public boolean isCanUseWriteExternal() {
            DCloudAOLManager.PrivacyConfig privacyConfig = CSJInit.this.d;
            return privacyConfig == null ? super.isCanUseWriteExternal() : privacyConfig.isCanUseStorage();
        }
    };
    public DCloudAOLManager.PrivacyConfig d;

    public static CSJInit getInstance() {
        if (e == null) {
            synchronized (CSJInit.class) {
                try {
                    if (e == null) {
                        e = new CSJInit();
                    }
                } finally {
                }
            }
        }
        return e;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void b(Context context, String str, String str2, final TTAdSdk.InitCallback initCallback) {
        this.b = Const.TYPE_GM.equalsIgnoreCase(str2);
        TTAdSdk.init(context, new TTAdConfig.Builder().appId(str).appName(LoadAppUtils.getAppName(context)).titleBarTheme(1).allowShowNotify(true).debug(false).directDownloadNetworkType(new int[0]).supportMultiProcess(false).useMediation(this.b).data(a(AdUtil.getPersonalAd(context) ? "1" : Constants.FAIL)).customController(this.c).build());
        TTAdSdk.start(new TTAdSdk.Callback() { // from class: io.dcloud.openapi.poly.adapter.csj.CSJInit.1
            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void fail(int i, String str3) {
                TTAdSdk.InitCallback initCallback2 = TTAdSdk.InitCallback.this;
                if (initCallback2 != null) {
                    initCallback2.fail(i, str3);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void success() {
                TTAdSdk.InitCallback initCallback2 = TTAdSdk.InitCallback.this;
                if (initCallback2 != null) {
                    initCallback2.success();
                }
            }
        });
    }

    public void init(final Context context, final String str, final String str2, final TTAdSdk.InitCallback initCallback) {
        if (TTAdSdk.isInitSuccess()) {
            if (initCallback != null) {
                initCallback.success();
            }
        } else if (TextUtils.isEmpty(str)) {
            if (initCallback != null) {
                initCallback.fail(-9999, "");
            }
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            b(context, str, str2, initCallback);
        } else {
            this.f13954a.post(new Runnable() { // from class: io.dcloud.openapi.poly.adapter.csj.A4TApA
                @Override // java.lang.Runnable
                public final void run() {
                    CSJInit.this.b(context, str, str2, initCallback);
                }
            });
        }
    }

    public void setPersonalAd(boolean z) {
        TTAdSdk.updateAdConfig(new TTAdConfig.Builder().data(a(z ? "1" : Constants.FAIL)).build());
    }

    public void updatePrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig) {
        if (privacyConfig == null) {
            return;
        }
        this.d = privacyConfig;
    }

    public static String a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "personal_ads_type");
            jSONObject.put("value", str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
