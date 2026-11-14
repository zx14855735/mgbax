package io.dcloud.openapi.poly.adapter.sgm;

import android.content.Context;
import android.text.TextUtils;
import com.sigmob.windad.OnInitializationListener;
import com.sigmob.windad.OnStartListener;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import io.dcloud.openapi.core.DCloudAOLManager;
import io.dcloud.openapi.core.util.AdUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class SGMInit {
    public static SGMInit c;

    /* renamed from: a, reason: collision with root package name */
    public DCloudAOLManager.PrivacyConfig f13993a;
    public WindCustomController b = new WindCustomController() { // from class: io.dcloud.openapi.poly.adapter.sgm.SGMInit.2
        @Override // com.sigmob.windad.WindCustomController
        public boolean isCanUseAndroidId() {
            return SGMInit.this.f13993a == null ? super.isCanUseAndroidId() : SGMInit.this.f13993a.isCanGetAndroidId();
        }

        @Override // com.sigmob.windad.WindCustomController
        public boolean isCanUseAppList() {
            return SGMInit.this.f13993a == null ? super.isCanUseAppList() : SGMInit.this.f13993a.isCanGetInstallAppList();
        }

        @Override // com.sigmob.windad.WindCustomController
        public boolean isCanUseLocation() {
            return SGMInit.this.f13993a == null ? super.isCanUseLocation() : SGMInit.this.f13993a.isCanUseLocation();
        }

        @Override // com.sigmob.windad.WindCustomController
        public boolean isCanUseOaid() {
            return SGMInit.this.f13993a == null ? super.isCanUseOaid() : SGMInit.this.f13993a.isCanGetOAID();
        }

        @Override // com.sigmob.windad.WindCustomController
        public boolean isCanUsePhoneState() {
            return SGMInit.this.f13993a == null ? super.isCanUsePhoneState() : SGMInit.this.f13993a.isCanUsePhoneState();
        }

        @Override // com.sigmob.windad.WindCustomController
        public boolean isCanUseSimOperator() {
            return SGMInit.this.f13993a == null ? super.isCanUseSimOperator() : SGMInit.this.f13993a.isCanUseSimOperator();
        }
    };

    public static SGMInit getInstance() {
        if (c == null) {
            synchronized (SGMInit.class) {
                try {
                    if (c == null) {
                        c = new SGMInit();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public String init(Context context, String str, String str2, final OnInitializationListener onInitializationListener) {
        if (TextUtils.isEmpty(str) || WindAds.sharedAds().isInit() || TextUtils.isEmpty(str2)) {
            if (onInitializationListener != null) {
                onInitializationListener.onInitializationSuccess();
            }
            return str;
        }
        final WindAds sharedAds = WindAds.sharedAds();
        sharedAds.setPersonalizedAdvertisingOn(AdUtil.getPersonalAd(context));
        WindAdOptions windAdOptions = new WindAdOptions(str, str2);
        setCustomPermission(this.f13993a);
        windAdOptions.setCustomController(this.b);
        sharedAds.init(context, windAdOptions, new OnInitializationListener() { // from class: io.dcloud.openapi.poly.adapter.sgm.SGMInit.1
            @Override // com.sigmob.windad.OnInitializationListener
            public void onInitializationFail(String str3) {
                onInitializationListener.onInitializationFail(str3);
            }

            @Override // com.sigmob.windad.OnInitializationListener
            public void onInitializationSuccess() {
                sharedAds.start(new OnStartListener() { // from class: io.dcloud.openapi.poly.adapter.sgm.SGMInit.1.1
                    @Override // com.sigmob.windad.OnStartListener
                    public void onStartFail(String str3) {
                        onInitializationListener.onInitializationFail(str3);
                    }

                    @Override // com.sigmob.windad.OnStartListener
                    public void onStartSuccess() {
                        onInitializationListener.onInitializationSuccess();
                    }
                });
            }
        });
        return str;
    }

    public void setCustomPermission(DCloudAOLManager.PrivacyConfig privacyConfig) {
        if (privacyConfig == null) {
            return;
        }
        WindAds.sharedAds().setAdult(privacyConfig.isAdult());
        WindAds.sharedAds().setSensorStatus(privacyConfig.isCanUseSensor());
        this.f13993a = privacyConfig;
    }

    public void setPersonalAd(boolean z) {
        WindAds.sharedAds().setPersonalizedAdvertisingOn(z);
    }
}
