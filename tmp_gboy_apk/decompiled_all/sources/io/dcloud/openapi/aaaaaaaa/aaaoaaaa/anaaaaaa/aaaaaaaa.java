package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.anaaaaaa;

import android.app.Activity;
import io.dcloud.openapi.core.DCloudAOLManager;
import io.dcloud.openapi.core.adapter.IAdAdapter;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa implements IAdAdapter {
    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public DCBaseAOLLoader getAd(Activity activity, DCloudAOLSlot dCloudAOLSlot) {
        if (dCloudAOLSlot.getType() == 1) {
            return new aaaaaaa0(dCloudAOLSlot, activity);
        }
        return null;
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public String getAdapterSDKVersion() {
        return "5.5.2";
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public String getSDKVersion() {
        return "";
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public boolean isSupport() {
        return true;
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public void setPersonalAd(boolean z) {
    }

    @Override // io.dcloud.openapi.core.adapter.IAdAdapter
    public void updatePrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig) {
    }
}
