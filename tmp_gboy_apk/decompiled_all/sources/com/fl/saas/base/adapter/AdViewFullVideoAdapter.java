package com.fl.saas.base.adapter;

import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.builder.InnerFullVideoBuilder;
import com.fl.saas.base.interfaces.AdViewFullVideoListener;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AdViewFullVideoAdapter extends BuilderLoadAdapter<InnerFullVideoBuilder<?>, AdViewFullVideoListener> {
    private boolean isMute = false;
    private boolean isVideoReady;

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public boolean isCheckActivity() {
        return true;
    }

    public boolean isMute() {
        return this.isMute;
    }

    public boolean isVideoReady() {
        return this.isVideoReady;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onClickedEvent() {
        super.onClickedEvent();
        handleListenerEvent(new KiXkPs.A2egSU(10));
    }

    public void onClosedEvent() {
        handleListenerEvent(new KiXkPs.A2egSU(9));
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onLoadedEvent() {
        this.isVideoReady = true;
        super.onLoadedEvent();
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onShowEvent() {
        this.isVideoReady = false;
        super.onShowEvent();
        handleListenerEvent(new KiXkPs.A2egSU(8));
    }

    @Override // com.fl.saas.base.adapter.base.BuilderLoadAdapter
    public AdViewFullVideoAdapter setBuilder(InnerFullVideoBuilder<?> innerFullVideoBuilder) {
        super.setBuilder((AdViewFullVideoAdapter) innerFullVideoBuilder);
        this.isMute = ((Boolean) getBuilderFieldOptional(new COJEAR.AZOQYO(23)).orElse(Boolean.FALSE)).booleanValue();
        return this;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        handleListenerEvent(new KiXkPs.A2egSU(11));
    }

    public void showRewardVideo() {
        this.isVideoReady = false;
        reportRequestShow();
    }
}
