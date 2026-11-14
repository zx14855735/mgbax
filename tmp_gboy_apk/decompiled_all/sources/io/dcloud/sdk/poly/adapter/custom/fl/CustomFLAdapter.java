package io.dcloud.sdk.poly.adapter.custom.fl;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.OaidUtils;
import com.fl.saas.ydsdk.manager.YdConfig;
import com.fl.saas.ydsdk.manager.YdParamConfig;
import io.dcloud.api.custom.UniAdCustomAdapter;
import io.dcloud.api.custom.base.UniAdPrivacyConfig;
import io.dcloud.api.custom.type.UniAdCustomBaseLoader;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CustomFLAdapter extends UniAdCustomAdapter {
    private YdParamConfig config;
    private boolean hasInit = false;

    @Override // io.dcloud.api.custom.UniAdCustomAdapter
    public int getAdapterVersion() {
        return MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER;
    }

    @Override // io.dcloud.api.custom.UniAdCustomAdapter
    public UniAdCustomBaseLoader getAdsByType(int i) {
        if (i == 1) {
            return new CustomFLSplashAd();
        }
        if (i == 4) {
            return new CustomFLNativeAdLoader();
        }
        if (i == 7) {
            return new CustomFLFullScreenAd();
        }
        if (i == 15) {
            return new CustomFLInterstitialAd();
        }
        if (i == 9) {
            return new CustomFLRewardAd();
        }
        if (i != 10) {
            return null;
        }
        return new CustomFLDrawAdLoader();
    }

    @Override // io.dcloud.api.custom.UniAdCustomAdapter, io.dcloud.openapi.core.adapter.IAdAdapter
    public String getSDKVersion() {
        return "2.8.4";
    }

    @Override // io.dcloud.api.custom.UniAdCustomAdapter
    public void init(Context context, JSONObject jSONObject) {
        if (TextUtils.isEmpty(jSONObject.optString("appid"))) {
            onInitFail(310002, "appId无效");
            return;
        }
        if (this.config == null) {
            YdConfig.getInstance().init(context, jSONObject.optString("appid"));
        } else {
            YdConfig.getInstance().init(context, jSONObject.optString("appid"), this.config);
        }
        this.hasInit = true;
        onInitSuccess();
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public void setPersonalAd(boolean z) {
        YdConfig.getInstance().setPersonalizedState(z);
    }

    @Override // io.dcloud.api.custom.UniAdCustomAdapter
    public void setPrivacyConfig(UniAdPrivacyConfig uniAdPrivacyConfig) {
        if (uniAdPrivacyConfig != null) {
            YdConfig.getInstance().setEnableCollectAppInstallStatus(uniAdPrivacyConfig.isCanGetInstallAppList());
            OaidUtils.setIsCanUseOAID(uniAdPrivacyConfig.isCanGetOAID());
            if (!this.hasInit) {
                this.config = new YdParamConfig.Builder().setCanUseIMEI(uniAdPrivacyConfig.isCanUsePhoneState()).setCanUseLocation(uniAdPrivacyConfig.isCanUseLocation()).setCanUseSSID(uniAdPrivacyConfig.isCanUseWifiState()).setCanUseMac(uniAdPrivacyConfig.isCanGetMacAddress()).setCanUseAndroid(uniAdPrivacyConfig.isCanGetAndroidId()).setCanUseSensor(uniAdPrivacyConfig.isCanUseSensor()).setCanUseIMSI(uniAdPrivacyConfig.isCanUseSimOperator()).build();
                return;
            }
            DeviceUtil.isCanUseIMEI = uniAdPrivacyConfig.isCanUsePhoneState();
            DeviceUtil.isCanUseLocation = uniAdPrivacyConfig.isCanUseLocation();
            DeviceUtil.isCanUseSSID = uniAdPrivacyConfig.isCanUseWifiState();
            DeviceUtil.isCanUseMac = uniAdPrivacyConfig.isCanGetMacAddress();
            DeviceUtil.isCanUseAndroid = uniAdPrivacyConfig.isCanGetAndroidId();
            DeviceUtil.isCanUseSensor = uniAdPrivacyConfig.isCanUseSensor();
            DeviceUtil.isCanUseIMSI = uniAdPrivacyConfig.isCanUseSimOperator();
        }
    }
}
