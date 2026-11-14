package com.fl.saas.base.adapter;

import android.view.View;
import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.builder.InnerTemplateBuilder;
import com.fl.saas.base.interfaces.AdViewTemplateListener;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AdViewTemplateAdapter extends BuilderLoadAdapter<InnerTemplateBuilder<?>, AdViewTemplateListener> {
    private int adCount;
    private int height;
    private List<View> viewList;
    private int width;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$0(AdViewTemplateListener adViewTemplateListener) {
        adViewTemplateListener.onReceived(this.viewList);
    }

    public int getAdCount() {
        return this.adCount;
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

    public void onClickedEvent(int i) {
        super.onClickedEvent();
        handleListenerEvent(new A4TApA(i, 4));
    }

    public void onClosedEvent(View view) {
        handleListenerEvent(new A2egSU(6, view));
    }

    public void onLoadedEvent(List<View> list) {
        this.viewList = list;
        super.onLoadedEvent();
    }

    public void onShowEvent(int i) {
        super.onShowEvent();
        handleListenerEvent(new A4TApA(i, 5));
    }

    @Override // com.fl.saas.base.adapter.base.BuilderLoadAdapter
    public AdViewTemplateAdapter setBuilder(InnerTemplateBuilder<?> innerTemplateBuilder) {
        super.setBuilder((AdViewTemplateAdapter) innerTemplateBuilder);
        this.adCount = ((Integer) getBuilderFieldOptional(new AZOQYO(9)).orElse(1)).intValue();
        this.width = ((Integer) getBuilderFieldOptional(new AZOQYO(10)).orElse(300)).intValue();
        this.height = ((Integer) getBuilderFieldOptional(new AZOQYO(11)).orElse(300)).intValue();
        return this;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        if (this.viewList != null) {
            handleListenerEvent(new A2egSU(5, this));
        }
    }
}
