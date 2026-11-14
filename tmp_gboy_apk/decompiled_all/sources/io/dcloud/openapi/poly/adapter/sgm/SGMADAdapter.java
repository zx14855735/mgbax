package io.dcloud.openapi.poly.adapter.sgm;

import android.app.Activity;
import com.sigmob.windad.WindAds;
import io.dcloud.openapi.core.DCloudAOLManager;
import io.dcloud.openapi.core.adapter.IAdAdapter;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class SGMADAdapter implements IAdAdapter {
    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public DCBaseAOLLoader getAd(Activity activity, DCloudAOLSlot dCloudAOLSlot) {
        int type = dCloudAOLSlot.getType();
        if (type == 1) {
            return new SGMSplashAOL(dCloudAOLSlot, activity);
        }
        if (type != 7) {
            if (type == 9) {
                return new SGMRewardAOL(dCloudAOLSlot, activity);
            }
            if (type != 15) {
                return null;
            }
        }
        return new SGMInterstitialAOL(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public String getAdapterSDKVersion() {
        return "5.5.2.0606";
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public String getSDKVersion() {
        return WindAds.getVersion();
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public boolean isSupport() {
        return true;
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public void setPersonalAd(boolean z) {
        SGMInit.getInstance().setPersonalAd(z);
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public void updatePrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig) {
        SGMInit.getInstance().setCustomPermission(privacyConfig);
    }
}
