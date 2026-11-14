package io.dcloud.openapi.poly.adapter.ks;

import android.app.Activity;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class KSDrawAOLLoader extends DCBaseAOLLoader implements KsLoadManager.DrawAdListener {
    public KSDrawAOLLoader(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
    }

    public String getErrorMsg() {
        return null;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public String getType() {
        return "ks";
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void init(String str, String str2) {
        KSInit.getInstance().init(getActivity(), str);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        return false;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void load() {
        try {
            KsScene.Builder builder = new KsScene.Builder(Long.parseLong(getSlotId()));
            if (KSInit.getInstance().getPrivacyConfig() != null && !KSInit.getInstance().getPrivacyConfig().isCanUseSensor()) {
                builder.setSensorType(-1);
            }
            KsAdSDK.getLoadManager().loadDrawAd(builder.build(), this);
        } catch (Exception unused) {
            loadFail(-9999, "");
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
    public void onDrawAdLoad(List<KsDrawAd> list) {
        if (list == null || list.size() == 0) {
            loadFail(-40003, AOLErrorUtil.getErrorMsg(200000));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (KsDrawAd ksDrawAd : list) {
            KSDrawAOLEntry kSDrawAOLEntry = new KSDrawAOLEntry(getSlot(), getActivity());
            kSDrawAOLEntry.setAdEntry(ksDrawAd);
            if (isSlotSupportBidding()) {
                kSDrawAOLEntry.setBiddingECPM(ksDrawAd.getECPM());
            }
            arrayList.add(kSDrawAOLEntry);
        }
        loadSuccess(arrayList);
    }

    @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
    public void onError(int i, String str) {
        loadFail(i, str);
    }
}
