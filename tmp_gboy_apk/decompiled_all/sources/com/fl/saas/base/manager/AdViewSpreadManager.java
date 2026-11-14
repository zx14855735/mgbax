package com.fl.saas.base.manager;

import com.fl.saas.base.adapter.AZOQYO;
import com.fl.saas.base.adapter.AdViewSpreadAdapter;
import com.fl.saas.base.base.builder.InnerSpreadBuilder;
import com.fl.saas.base.interfaces.AdViewSpreadListener;
import com.fl.saas.base.interfaces.ISplashEyeAd;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import com.fl.saas.base.manager.manager.BuilderLoadManager;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdViewSpreadManager extends BuilderLoadManager<InnerSpreadBuilder<?>, AdViewSpreadAdapter, AdViewSpreadListener> {

    /* renamed from: com.fl.saas.base.manager.AdViewSpreadManager$1, reason: invalid class name */
    public class AnonymousClass1 implements AdViewSpreadListener {
        final /* synthetic */ InnerSpreadBuilder val$builder;

        public AnonymousClass1(InnerSpreadBuilder innerSpreadBuilder) {
            this.val$builder = innerSpreadBuilder;
        }

        public Optional<AdViewSpreadListener> getSpreadListenerOpt() {
            return Optional.ofNullable(this.val$builder.getEventListener());
        }

        @Override // com.fl.saas.base.base.listener.InnerSpreadListener
        public void onAdClick(String str) {
            LogcatUtil.d("YdSDK-Spread", "adViewAdInterface onAdClick");
            getSpreadListenerOpt().ifPresent(new A4TApA(0, str));
        }

        @Override // com.fl.saas.base.base.listener.InnerSpreadListener
        public void onAdClose() {
            LogcatUtil.d("YdSDK-Spread", "adViewAdInterface onAdClose");
            getSpreadListenerOpt().ifPresent(new KiXkPs.A2egSU(12));
        }

        @Override // com.fl.saas.base.base.listener.InnerSpreadListener
        public void onAdDisplay() {
            LogcatUtil.d("YdSDK-Spread", "adViewAdInterface onAdDisplay");
            getSpreadListenerOpt().ifPresent(new A2egSU(2));
        }

        @Override // com.fl.saas.base.interfaces.AdViewListener
        public void onAdFailed(YdError ydError) {
            LogcatUtil.d("YdSDK-Spread", "adViewAdInterface onAdFailed," + ydError.toString());
            getSpreadListenerOpt().ifPresent(new A4TApA(1, ydError));
        }
    }

    public AdViewSpreadManager() {
        super(AdType.Spread);
    }

    public void getBottomAd() {
        selectBottomAd();
    }

    public SpreadLoadListener.SpreadAd getSplashAd() {
        return (SpreadLoadListener.SpreadAd) getValidAdapter().map(new AZOQYO(27)).orElse(null);
    }

    public ISplashEyeAd getSplashEyeAd() {
        return (ISplashEyeAd) getValidAdapter().map(new AZOQYO(26)).orElse(null);
    }

    public void setSoundEnable(boolean z) {
        getValidAdapter().ifPresent(new KiXkPs.A4TApA(2, z));
    }

    @Override // com.fl.saas.base.manager.manager.BuilderLoadManager
    public AdViewSpreadListener initProxyEventListener(InnerSpreadBuilder<?> innerSpreadBuilder) {
        return new AnonymousClass1(innerSpreadBuilder);
    }
}
