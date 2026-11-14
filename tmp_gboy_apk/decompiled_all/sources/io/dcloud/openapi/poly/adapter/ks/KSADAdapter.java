package io.dcloud.openapi.poly.adapter.ks;

import android.app.Activity;
import android.os.Build;
import com.kwad.sdk.api.KsAdSDK;
import io.dcloud.openapi.core.DCloudAOLManager;
import io.dcloud.openapi.core.adapter.IAdAdapter;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class KSADAdapter implements IAdAdapter {
    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public DCBaseAOLLoader getAd(Activity activity, DCloudAOLSlot dCloudAOLSlot) {
        int type = dCloudAOLSlot.getType();
        if (type == 1) {
            return new KSSplashAOL(dCloudAOLSlot, activity);
        }
        if (type == 7) {
            return new KSFullScreenAOL(dCloudAOLSlot, activity);
        }
        if (type == 4 || type == 5) {
            return new KSFeedAOLLoader(dCloudAOLSlot, activity);
        }
        if (type == 9) {
            return new KSRewardAOL(dCloudAOLSlot, activity);
        }
        if (type == 10) {
            return new KSDrawAOLLoader(dCloudAOLSlot, activity);
        }
        if (type == 14) {
            try {
                return (DCBaseAOLLoader) Class.forName("io.dcloud.openapi.poly.adapter.ks.KSContentPage").getConstructor(DCloudAOLSlot.class, Activity.class).newInstance(dCloudAOLSlot, activity);
            } catch (Exception unused) {
                return null;
            }
        }
        if (type != 15) {
            return null;
        }
        return new KSInterstitialAOL(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public String getAdapterSDKVersion() {
        return "5.5.2";
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public String getSDKVersion() {
        return KsAdSDK.getSDKVersion();
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public boolean isSupport() {
        return !Build.CPU_ABI.equalsIgnoreCase("x86");
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public void setPersonalAd(boolean z) {
        KSInit.getInstance().setPersonalAd(z);
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public void updatePrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig) {
        KSInit.getInstance().setCustomPermission(privacyConfig);
    }
}
