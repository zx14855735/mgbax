package io.dcloud.sdk.poly.adapter.custom.yt;

import ADYaiT.CtFAbx;
import DuwtYk.ARc23Z;
import EY4UKY.A2egSU;
import EY4UKY.ADYaiT;
import JrXYwF.A4TApA;
import android.content.Context;
import android.text.TextUtils;
import com.alliance.ssp.ad.api.SAAllianceAdInitParams;
import com.alliance.ssp.ad.utils.DeviceUtil;
import io.dcloud.api.custom.UniAdCustomAdapter;
import io.dcloud.api.custom.base.UniAdPrivacyConfig;
import io.dcloud.api.custom.type.UniAdCustomBaseLoader;
import io.dcloud.sdk.poly.adapter.custom.yt.utils.ThreadUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CustomYTAdapter extends UniAdCustomAdapter {
    private UniAdPrivacyConfig config;
    private boolean personalAd = false;

    @Override // io.dcloud.api.custom.UniAdCustomAdapter
    public int getAdapterVersion() {
        return 100;
    }

    @Override // io.dcloud.api.custom.UniAdCustomAdapter
    public UniAdCustomBaseLoader getAdsByType(int i) {
        if (i == 1) {
            return new CustomYTSplashAd();
        }
        if (i == 4) {
            return new CustomYTNativeAdLoader();
        }
        if (i == 9) {
            return new CustomYTRewardAd();
        }
        if (i != 15) {
            return null;
        }
        return new CustomYTInterstitialAd();
    }

    @Override // io.dcloud.api.custom.UniAdCustomAdapter, io.dcloud.openapi.core.adapter.IAdAdapter
    public String getSDKVersion() {
        int i = ARc23Z.f2485A2egSU;
        return DeviceUtil.AYUAbz();
    }

    @Override // io.dcloud.api.custom.UniAdCustomAdapter
    public void init(final Context context, final JSONObject jSONObject) {
        if (TextUtils.isEmpty(jSONObject.optString("appid"))) {
            onInitFail(36222411, "appId无效");
        } else {
            ThreadUtils.runOnThreadPool(new Runnable() { // from class: io.dcloud.sdk.poly.adapter.custom.yt.CustomYTAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    SAAllianceAdInitParams.A2egSU a2egSU = new SAAllianceAdInitParams.A2egSU();
                    boolean z = true;
                    a2egSU.f9699A2egSU = true;
                    a2egSU.f9702ADYaiT = CustomYTAdapter.this.config == null || CustomYTAdapter.this.config.isCanUseLocation();
                    a2egSU.f9701A5SV6n = CustomYTAdapter.this.config == null || CustomYTAdapter.this.config.isCanGetOAID();
                    if (CustomYTAdapter.this.config != null) {
                        CustomYTAdapter.this.config.isCanGetAndroidId();
                    }
                    a2egSU.AMqCpz = CustomYTAdapter.this.config == null || CustomYTAdapter.this.config.isCanGetMacAddress();
                    a2egSU.f9705AYUAbz = CustomYTAdapter.this.config == null || CustomYTAdapter.this.config.isCanUseWifiState();
                    a2egSU.f9704ASJ6gh = CustomYTAdapter.this.config == null || CustomYTAdapter.this.config.isCanGetInstallAppList();
                    if (CustomYTAdapter.this.config != null) {
                        CustomYTAdapter.this.config.isCanUseSensor();
                    }
                    if (CustomYTAdapter.this.config != null && !CustomYTAdapter.this.config.isCanUseSimOperator()) {
                        z = false;
                    }
                    a2egSU.f9703ARc23Z = z;
                    a2egSU.f9700A4TApA = CustomYTAdapter.this.personalAd;
                    SAAllianceAdInitParams sAAllianceAdInitParams = new SAAllianceAdInitParams(a2egSU);
                    String optString = jSONObject.optString("appid");
                    Context context2 = context;
                    int i = ARc23Z.f2485A2egSU;
                    try {
                        A2egSU.A5SV6n().A4TApA(optString, context2, sAAllianceAdInitParams);
                    } catch (Exception e) {
                        CtFAbx.B4ZgIw(e, A4TApA.AMqCpz("SAAllianceAdSdk 001: "), new ADYaiT(), "004", e);
                    }
                    CustomYTAdapter.this.onInitSuccess();
                }
            });
        }
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public void setPersonalAd(boolean z) {
        this.personalAd = z;
    }

    @Override // io.dcloud.api.custom.UniAdCustomAdapter
    public void setPrivacyConfig(UniAdPrivacyConfig uniAdPrivacyConfig) {
        if (uniAdPrivacyConfig != null) {
            this.config = uniAdPrivacyConfig;
        }
    }
}
