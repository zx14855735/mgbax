package com.fl.saas.base.manager.loader;

import android.content.Context;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.manager.api.ManagerLoader;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.saas.bean.AdSource;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BuilderAdLoader<T extends AdapterAPI> extends BaseLoader<T> {
    private final AdType mAdType;

    public BuilderAdLoader(AdType adType, ManagerLoader<T> managerLoader) {
        super(managerLoader, adType.getPos());
        this.mAdType = adType;
    }

    private void getAdapterAndLoad(AdType adType, AdSource adSource) {
        loadAdapter(((AdapterAPI) adType.getAdapterGenerator().loadAdapter(adSource.adv_id, adSource.customClassName)).setAdSource(adSource));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestAd$0(AdSource adSource, Context context) {
        try {
            AdType adType = this.mAdType;
            if (adType == AdType.RewardVideo) {
                int i = adSource.style_mix_option;
                if (i == 2) {
                    adType = AdType.Interstitial;
                } else if (i == 3) {
                    adType = AdType.Spread;
                }
            }
            getAdapterAndLoad(adType, adSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.fl.saas.base.manager.loader.BaseLoader
    public void handleSDKBidAd(AdSource adSource, Object obj) {
        if (!(obj instanceof AdapterAPI)) {
            requestAd(adSource);
            return;
        }
        AdapterAPI adapterAPI = (AdapterAPI) obj;
        adapterAPI.setAdSource(adSource);
        loadAdapter(adapterAPI);
    }

    @Override // com.fl.saas.base.manager.api.AdapterGenerator
    public void requestAd(AdSource adSource) {
        if (adSource != null) {
            this.mLoader.getContextOpt().ifPresent(new com.fl.saas.base.innterNative.A2egSU(this, 3, adSource));
        }
    }
}
