package com.fl.saas.base.manager;

import android.app.Activity;
import com.fl.saas.base.adapter.AZOQYO;
import com.fl.saas.base.adapter.AdViewInterstitialAdapter;
import com.fl.saas.base.base.builder.InnerInterstitialBuilder;
import com.fl.saas.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.base.manager.manager.BuilderLoadManager;
import com.fl.saas.base.type.AdType;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.YdAppBackgroundUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdViewInterstitialManager extends BuilderLoadManager<InnerInterstitialBuilder<?>, AdViewInterstitialAdapter, AdViewInterstitialListener> {
    public AdViewInterstitialManager() {
        super(AdType.Interstitial);
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager
    public AdViewInterstitialListener initProxyEventListener(InnerInterstitialBuilder<?> innerInterstitialBuilder) {
        final AdViewInterstitialListener eventListener = innerInterstitialBuilder.getEventListener();
        return new AdViewInterstitialListener() { // from class: com.fl.saas.base.manager.AdViewInterstitialManager.1
            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdClick(String str) {
                AdViewInterstitialListener adViewInterstitialListener = eventListener;
                if (adViewInterstitialListener == null) {
                    return;
                }
                adViewInterstitialListener.onAdClick(str);
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdClosed() {
                AdViewInterstitialListener adViewInterstitialListener = eventListener;
                if (adViewInterstitialListener == null) {
                    return;
                }
                adViewInterstitialListener.onAdClosed();
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdDisplay() {
                AdViewInterstitialListener adViewInterstitialListener = eventListener;
                if (adViewInterstitialListener == null) {
                    return;
                }
                adViewInterstitialListener.onAdDisplay();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                AdViewInterstitialListener adViewInterstitialListener = eventListener;
                if (adViewInterstitialListener == null) {
                    return;
                }
                adViewInterstitialListener.onAdFailed(ydError);
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdReady() {
                AdViewInterstitialListener adViewInterstitialListener = eventListener;
                if (adViewInterstitialListener == null) {
                    return;
                }
                adViewInterstitialListener.onAdReady();
            }
        };
    }

    public boolean isReady() {
        return ((Boolean) getValidAdapter().map(new AZOQYO(24)).orElse(Boolean.FALSE)).booleanValue();
    }

    public void show(Activity activity) {
        try {
            if (getBuilder() != null && YdAppBackgroundUtil.getInstance().checkPlaceId(getBuilder().getKey()) && activity != null) {
                YdAppBackgroundUtil.getInstance().setShowName(activity.getComponentName().getClassName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        getValidAdapter().ifPresent(new A4TApA(2, activity));
    }
}
