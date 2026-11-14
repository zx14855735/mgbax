package com.fl.saas.base.manager;

import com.fl.saas.base.adapter.AZOQYO;
import com.fl.saas.base.adapter.AdViewNativeAdapter;
import com.fl.saas.base.base.builder.InnerNativeBuilder;
import com.fl.saas.base.interfaces.AdViewNativeListener;
import com.fl.saas.base.manager.manager.BuilderLoadManager;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.pojo.YdNativePojo;
import com.fl.saas.config.exception.YdError;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdViewNativeManager extends BuilderLoadManager<InnerNativeBuilder<?>, AdViewNativeAdapter, AdViewNativeListener> {
    public AdViewNativeManager() {
        super(AdType.Native);
    }

    public List<YdNativePojo> getBottomAd() {
        selectBottomAd();
        return (List) getValidAdapter().map(new AZOQYO(25)).orElse(null);
    }

    public void pauseVideo() {
        getValidAdapter().ifPresent(new KiXkPs.A2egSU(27));
    }

    public void resume() {
        getValidAdapter().ifPresent(new A2egSU(0));
    }

    public void resumeVideo() {
        getValidAdapter().ifPresent(new KiXkPs.A2egSU(28));
    }

    public void setSoundEnable(boolean z) {
        getValidAdapter().ifPresent(new KiXkPs.A4TApA(1, z));
    }

    public void startVideo() {
        getValidAdapter().ifPresent(new KiXkPs.A2egSU(29));
    }

    public void stopVideo() {
        getValidAdapter().ifPresent(new A2egSU(1));
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager
    public AdViewNativeListener initProxyEventListener(InnerNativeBuilder<?> innerNativeBuilder) {
        final AdViewNativeListener eventListener = innerNativeBuilder.getEventListener();
        return new AdViewNativeListener() { // from class: com.fl.saas.base.manager.AdViewNativeManager.1
            @Override // com.fl.saas.base.base.listener.InnerNativeListener
            public void onAdClick(int i) {
                AdViewNativeListener adViewNativeListener = eventListener;
                if (adViewNativeListener == null) {
                    return;
                }
                adViewNativeListener.onAdClick(i);
            }

            @Override // com.fl.saas.base.base.listener.InnerNativeLoaded.NativeDisplay
            public void onAdDisplay(List<YdNativePojo> list) {
                AdViewNativeListener adViewNativeListener = eventListener;
                if (adViewNativeListener == null) {
                    return;
                }
                adViewNativeListener.onAdDisplay(list);
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                AdViewNativeListener adViewNativeListener = eventListener;
                if (adViewNativeListener == null) {
                    return;
                }
                adViewNativeListener.onAdFailed(ydError);
            }

            @Override // com.fl.saas.base.base.listener.InnerNativeListener
            public void onAdShow(int i) {
                AdViewNativeListener adViewNativeListener = eventListener;
                if (adViewNativeListener == null) {
                    return;
                }
                adViewNativeListener.onAdShow(i);
            }
        };
    }
}
