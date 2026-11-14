package com.fl.saas.base.adapter;

import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.builder.InnerNativeBuilder;
import com.fl.saas.base.interfaces.AdGetWinInfo;
import com.fl.saas.base.interfaces.AdViewNativeListener;
import com.fl.saas.base.widget.WinAdInfo;
import com.fl.saas.common.pojo.NativeADAppMiitInfo;
import com.fl.saas.common.pojo.YdNativePojo;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AdViewNativeAdapter extends BuilderLoadAdapter<InnerNativeBuilder<?>, AdViewNativeListener> implements AdGetWinInfo {
    private final String TAG = CommConstant.getObjTag(this);
    private int adCount;
    private int height;
    private boolean isManualReport;
    private boolean isSoundEnable;
    private boolean isTTStreamAd;
    private List<YdNativePojo> pojoList;
    private boolean showLogo;
    private int width;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$0(AdViewNativeListener adViewNativeListener) {
        adViewNativeListener.onAdDisplay(this.pojoList);
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

    @Override // com.fl.saas.base.interfaces.AdGetWinInfo
    public WinAdInfo getWinAdInfo() {
        List<YdNativePojo> list = this.pojoList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        WinAdInfo winAdInfo = new WinAdInfo();
        NativeADAppMiitInfo appInfo = this.pojoList.get(0).getAppInfo();
        if (appInfo != null) {
            winAdInfo.setAdUserName(appInfo.getAppName());
        }
        winAdInfo.setTitle(this.pojoList.get(0).getTitle());
        winAdInfo.setPosId(getAdSource().tagid);
        return winAdInfo;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public boolean isCheckActivity() {
        return true;
    }

    public boolean isManualReport() {
        return this.isManualReport;
    }

    public boolean isShowLogo() {
        return this.showLogo;
    }

    public boolean isSoundEnable() {
        return this.isSoundEnable;
    }

    public boolean isTTStreamAd() {
        return this.isTTStreamAd;
    }

    public List<YdNativePojo> loadBottomNativeAd() {
        LogcatUtil.d(this.TAG, "loadBottomNativeAd");
        return this.pojoList;
    }

    public void onClickedEvent(int i) {
        super.onClickedEvent();
        handleListenerEvent(new A4TApA(i, 2));
    }

    public void onLoadedEvent(List<YdNativePojo> list) {
        LogcatUtil.d(this.TAG, "onLoadedEvent:" + list);
        this.pojoList = list;
        super.onLoadedEvent();
    }

    public void onShowEvent(int i) {
        super.onShowEvent();
        reportRequestShow();
        handleListenerEvent(new A4TApA(i, 3));
    }

    public void pauseVideo() {
    }

    public void resume() {
    }

    public void resumeVideo() {
    }

    @Override // com.fl.saas.base.adapter.base.BuilderLoadAdapter
    public AdViewNativeAdapter setBuilder(InnerNativeBuilder<?> innerNativeBuilder) {
        super.setBuilder((AdViewNativeAdapter) innerNativeBuilder);
        this.width = ((Integer) getBuilderFieldOptional(new COJEAR.AZOQYO(28)).orElse(0)).intValue();
        this.height = ((Integer) getBuilderFieldOptional(new COJEAR.AZOQYO(29)).orElse(0)).intValue();
        this.adCount = ((Integer) getBuilderFieldOptional(new AZOQYO(0)).orElse(1)).intValue();
        Optional<U> builderFieldOptional = getBuilderFieldOptional(new AZOQYO(1));
        Boolean bool = Boolean.FALSE;
        this.isManualReport = ((Boolean) builderFieldOptional.orElse(bool)).booleanValue();
        this.isSoundEnable = ((Boolean) getBuilderFieldOptional(new AZOQYO(2)).orElse(bool)).booleanValue();
        this.isTTStreamAd = ((Boolean) getBuilderFieldOptional(new AZOQYO(3)).orElse(bool)).booleanValue();
        this.showLogo = ((Boolean) getBuilderFieldOptional(new AZOQYO(4)).orElse(bool)).booleanValue();
        return this;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        if (this.pojoList == null) {
            return;
        }
        handleListenerEvent(new A2egSU(3, this));
    }

    public void soundControl(boolean z) {
    }

    public void startVideo() {
    }

    public void stopVideo() {
    }
}
