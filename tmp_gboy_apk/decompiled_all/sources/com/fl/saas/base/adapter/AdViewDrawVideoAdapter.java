package com.fl.saas.base.adapter;

import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.builder.InnerDrawVideoBuilder;
import com.fl.saas.base.interfaces.AdViewDrawVideoListener;
import com.fl.saas.common.pojo.YdNativePojo;
import com.fl.saas.config.exception.ErrorCodeConstant;
import com.fl.saas.config.exception.YdError;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AdViewDrawVideoAdapter extends BuilderLoadAdapter<InnerDrawVideoBuilder<?>, AdViewDrawVideoListener> {
    private int adCount;
    private boolean isMute = false;
    protected boolean isVideoReady;
    private List<YdNativePojo> pojoList;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$0(AdViewDrawVideoListener adViewDrawVideoListener) {
        adViewDrawVideoListener.onAdViewLoaded(this.pojoList);
    }

    public int getAdCount() {
        return this.adCount;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public boolean isCheckActivity() {
        return true;
    }

    public boolean isMute() {
        return this.isMute;
    }

    public void onClickedEvent(int i) {
        super.onClickedEvent();
        handleListenerEvent(new A4TApA(i, 0));
    }

    public void onLoadedEvent(List<YdNativePojo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.isVideoReady = true;
        this.pojoList = list;
        super.onLoadedEvent();
    }

    public void onShowEvent(int i) {
        this.isVideoReady = false;
        super.onShowEvent();
        reportRequestShow();
        handleListenerEvent(new A4TApA(i, 1));
    }

    @Override // com.fl.saas.base.adapter.base.BuilderLoadAdapter
    public AdViewDrawVideoAdapter setBuilder(InnerDrawVideoBuilder<?> innerDrawVideoBuilder) {
        super.setBuilder((AdViewDrawVideoAdapter) innerDrawVideoBuilder);
        this.adCount = ((Integer) getBuilderFieldOptional(new COJEAR.AZOQYO(21)).orElse(1)).intValue();
        this.isMute = ((Boolean) getBuilderFieldOptional(new COJEAR.AZOQYO(22)).orElse(Boolean.FALSE)).booleanValue();
        return this;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        if (this.pojoList == null) {
            onAdFailed(YdError.create(ErrorCodeConstant.NULL_ERROR, "Exception: DrawVideo showAd, but pojoList is null"));
        } else {
            handleListenerEvent(new A2egSU(1, this));
        }
    }
}
