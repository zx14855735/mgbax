package io.dcloud.openapi.poly.adapter.gdt;

import android.app.Activity;
import android.os.Build;
import com.qq.e.comm.managers.status.SDKStatus;
import io.dcloud.openapi.core.DCloudAOLManager;
import io.dcloud.openapi.core.adapter.IAdAdapter;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class GDTADAdapter implements IAdAdapter {
    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public DCBaseAOLLoader getAd(Activity activity, DCloudAOLSlot dCloudAOLSlot) {
        int type = dCloudAOLSlot.getType();
        if (type == 1) {
            return new GDTSplashAOL(dCloudAOLSlot, activity);
        }
        if (type == 7 || type == 15) {
            return new GDTFullScreenAOL(dCloudAOLSlot, activity);
        }
        if (type == 4 || type == 5) {
            return new GDTFeedAOLLoader(dCloudAOLSlot, activity);
        }
        if (type == 9) {
            return new GDTRewardAOL(dCloudAOLSlot, activity);
        }
        if (type != 10) {
            return null;
        }
        return new GDTDrawAOLLoader(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public String getAdapterSDKVersion() {
        return "5.5.2";
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public String getSDKVersion() {
        return SDKStatus.getSDKVersion();
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public boolean isSupport() {
        return !Build.CPU_ABI.equalsIgnoreCase("x86");
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public void setPersonalAd(boolean z) {
        GDTInit.getInstance().setPersonalAd(z);
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public void updatePrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig) {
        GDTInit.getInstance().setCustomPermission(privacyConfig);
    }
}
