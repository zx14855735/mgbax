package io.dcloud.openapi.core.adapter;

import android.app.Activity;
import io.dcloud.openapi.core.DCloudAOLManager;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface IAdAdapter {
    DCBaseAOLLoader getAd(Activity activity, DCloudAOLSlot dCloudAOLSlot);

    String getAdapterSDKVersion();

    String getSDKVersion();

    boolean isSupport();

    void setPersonalAd(boolean z);

    void updatePrivacyConfig(DCloudAOLManager.PrivacyConfig privacyConfig);
}
