package io.dcloud.openapi.poly.adapter.bd;

import android.app.Activity;
import com.baidu.mobads.sdk.api.AdSettings;
import io.dcloud.openapi.core.DCloudAOLManager;
import io.dcloud.openapi.core.adapter.IAdAdapter;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class BDAdAdapter implements IAdAdapter {
    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public DCBaseAOLLoader getAd(Activity activity, DCloudAOLSlot dCloudAOLSlot) {
        if (dCloudAOLSlot.getType() == 9) {
            return new BDRewardAOL(dCloudAOLSlot, activity);
        }
        if (dCloudAOLSlot.getType() == 1) {
            return new BDSplashAOL(dCloudAOLSlot, activity);
        }
        if (dCloudAOLSlot.getType() == 4) {
            return new BDFlowAOLLoader(dCloudAOLSlot, activity);
        }
        if (dCloudAOLSlot.getType() == 15) {
            return new BDInterstitialAOL(dCloudAOLSlot, activity);
        }
        return null;
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public String getAdapterSDKVersion() {
        return "5.5.2";
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public String getSDKVersion() {
        return AdSettings.getSDKVersion();
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public boolean isSupport() {
        return true;
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public void setPersonalAd(boolean z) {
        BDInit.getInstance().setPersonalAd(z);
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public void updatePrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig) {
        BDInit.getInstance().setCustomPermission(privacyConfig);
    }
}
