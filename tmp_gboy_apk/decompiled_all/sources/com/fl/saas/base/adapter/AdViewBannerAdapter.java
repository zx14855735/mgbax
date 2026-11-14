package com.fl.saas.base.adapter;

import android.view.View;
import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.builder.InnerBannerBuilder;
import com.fl.saas.base.interfaces.AdViewBannerListener;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AdViewBannerAdapter extends BuilderLoadAdapter<InnerBannerBuilder<?>, AdViewBannerListener> {
    private int autoSlideInterval;
    private int height;
    private View view;
    private int width;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$0(AdViewBannerListener adViewBannerListener) {
        adViewBannerListener.onReceived(this.view);
    }

    public int getAutoSlideInterval() {
        return this.autoSlideInterval;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public boolean isCheckActivity() {
        return true;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onClickedEvent() {
        super.onClickedEvent();
        handleListenerEvent(new KiXkPs.A2egSU(7));
    }

    public void onClosedEvent() {
        handleListenerEvent(new KiXkPs.A2egSU(6));
    }

    public void onLoadedEvent(View view) {
        this.view = view;
        super.onLoadedEvent();
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onShowEvent() {
        super.onShowEvent();
        reportRequestShow();
        handleListenerEvent(new KiXkPs.A2egSU(5));
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        if (this.view != null) {
            handleListenerEvent(new A2egSU(0, this));
        }
    }

    @Override // com.fl.saas.base.adapter.base.BuilderLoadAdapter
    public BuilderLoadAdapter<InnerBannerBuilder<?>, AdViewBannerListener> setBuilder(InnerBannerBuilder<?> innerBannerBuilder) {
        super.setBuilder((AdViewBannerAdapter) innerBannerBuilder);
        this.width = ((Integer) getBuilderFieldOptional(new COJEAR.AZOQYO(18)).orElse(0)).intValue();
        this.height = ((Integer) getBuilderFieldOptional(new COJEAR.AZOQYO(19)).orElse(0)).intValue();
        this.autoSlideInterval = ((Integer) getBuilderFieldOptional(new COJEAR.AZOQYO(20)).orElse(0)).intValue();
        return this;
    }
}
