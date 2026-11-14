package io.dcloud.openapi.poly.adapter.ks;

import android.app.Activity;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class KSFeedAOLLoader extends DCBaseAOLLoader implements KsLoadManager.FeedAdListener, KsLoadManager.NativeAdListener {
    public KSFeedAOLLoader(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
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
        long j;
        try {
            j = Long.parseLong(getSlotId());
        } catch (Exception unused) {
            j = 0;
        }
        if (j <= 0) {
            loadFail(-9999, "");
            return;
        }
        KsScene.Builder builder = new KsScene.Builder(j);
        if (getSlot().getWidth() > 0) {
            builder.width(getSlot().getWidth());
        }
        if (getSlot().getHeight() > 0) {
            builder.height(getSlot().getHeight());
        }
        builder.adNum(getSlot().getCount());
        if (KSInit.getInstance().getPrivacyConfig() != null && !KSInit.getInstance().getPrivacyConfig().isCanUseSensor()) {
            builder.setSensorType(-1);
        }
        startLoadTime();
        try {
            if (isExpressAd()) {
                KsAdSDK.getLoadManager().loadConfigFeedAd(builder.build(), this);
            } else {
                KsAdSDK.getLoadManager().loadNativeAd(builder.build(), this);
            }
        } catch (Exception unused2) {
            loadFail(-9999, "");
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener, com.kwad.sdk.api.KsLoadManager.NativeAdListener
    public void onError(int i, String str) {
        loadFail(i, str);
    }

    @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
    public void onFeedAdLoad(List<KsFeedAd> list) {
        if (list == null || list.size() == 0) {
            loadFail(-40003, AOLErrorUtil.getErrorMsg(-200000));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (KsFeedAd ksFeedAd : list) {
            KSFeedAOLEntry kSFeedAOLEntry = new KSFeedAOLEntry(getSlot(), getActivity());
            kSFeedAOLEntry.setAdEntry(ksFeedAd);
            kSFeedAOLEntry.setExpressAd(true);
            if (isSlotSupportBidding()) {
                kSFeedAOLEntry.setBiddingECPM(ksFeedAd.getECPM());
            }
            arrayList.add(kSFeedAOLEntry);
        }
        loadSuccess(arrayList);
    }

    @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
    public void onNativeAdLoad(List<KsNativeAd> list) {
        if (list == null || list.size() == 0) {
            loadFail(-40003, AOLErrorUtil.getErrorMsg(-200000));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (KsNativeAd ksNativeAd : list) {
            KSFeedAOLEntry kSFeedAOLEntry = new KSFeedAOLEntry(getSlot(), getActivity());
            kSFeedAOLEntry.setAdEntry(ksNativeAd);
            kSFeedAOLEntry.setExpressAd(false);
            if (isSlotSupportBidding()) {
                kSFeedAOLEntry.setBiddingECPM(ksNativeAd.getECPM());
            }
            arrayList.add(kSFeedAOLEntry);
        }
        loadSuccess(arrayList);
    }
}
