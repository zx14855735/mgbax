package io.dcloud.openapi.poly.adapter.csj;

import android.app.Activity;
import android.os.Build;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import io.dcloud.openapi.core.DCloudAOLManager;
import io.dcloud.openapi.core.adapter.IAdAdapter;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class BaseAdAdapter implements IAdAdapter {
    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public DCBaseAOLLoader getAd(Activity activity, DCloudAOLSlot dCloudAOLSlot) {
        int type = dCloudAOLSlot.getType();
        if (type == 1) {
            return new CSJSplashAOL2(dCloudAOLSlot, activity);
        }
        if (type != 7) {
            if (type == 4 || type == 5) {
                return new CSJFlowAOLLoader(dCloudAOLSlot, activity);
            }
            if (type == 9) {
                return new CSJRewardAOL(dCloudAOLSlot, activity);
            }
            if (type == 10) {
                return new CSJDrawAOLLoader(dCloudAOLSlot, activity);
            }
            if (type == 14) {
                try {
                    return (DCBaseAOLLoader) Class.forName("io.dcloud.openapi.poly.adapter.csj.CSJContentPage").getConstructor(DCloudAOLSlot.class, Activity.class).newInstance(dCloudAOLSlot, activity);
                } catch (Exception unused) {
                    return null;
                }
            }
            if (type != 15) {
                return null;
            }
        }
        return new CSJFullScreenVideoAOL(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public String getSDKVersion() {
        return TTAdSdk.getAdManager().getSDKVersion();
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public boolean isSupport() {
        return !Build.CPU_ABI.equalsIgnoreCase("x86");
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public void setPersonalAd(boolean z) {
        CSJInit.getInstance().setPersonalAd(z);
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public void updatePrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig) {
        CSJInit.getInstance().updatePrivacyConfig(privacyConfig);
    }
}
