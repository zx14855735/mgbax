package com.fl.saas.base.adapter;

import android.app.Activity;
import android.content.Context;
import com.fl.saas.base.adapter.base.BuilderLoadAdapter;
import com.fl.saas.base.base.builder.InnerVideoBuilder;
import com.fl.saas.base.interfaces.AdViewVideoListener;
import com.fl.saas.common.util.feature.Consumer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AdViewVideoAdapter extends BuilderLoadAdapter<InnerVideoBuilder<?>, AdViewVideoListener> {
    private boolean isVideoReady;

    public boolean isVideoReady() {
        return this.isVideoReady;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onClickedEvent() {
        super.onClickedEvent();
        handleListenerEvent(new KiXkPs.A2egSU(15));
    }

    public void onClosedEvent() {
        handleListenerEvent(new KiXkPs.A2egSU(16));
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onLoadedEvent() {
        this.isVideoReady = true;
        super.onLoadedEvent();
    }

    public void onRewardEvent() {
        final double d = getAdSource().price > 0 ? getAdSource().price : getAdSource().bidfloor;
        handleListenerEvent(new Consumer() { // from class: com.fl.saas.base.adapter.AaHO0E
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((AdViewVideoListener) obj).onVideoReward(d);
            }
        });
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.adapter.base.ReportEventListener
    public void onShowEvent() {
        this.isVideoReady = false;
        super.onShowEvent();
        handleListenerEvent(new KiXkPs.A2egSU(14));
    }

    public void onVideoCompletedEvent() {
        handleListenerEvent(new KiXkPs.A2egSU(17));
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        handleListenerEvent(new KiXkPs.A2egSU(13));
    }

    public abstract void showRewardVideo();

    public void showVideoAd() {
        this.isVideoReady = false;
        reportRequestShow();
        showRewardVideo();
    }

    public void showVideoAd(Activity activity) {
        setContext((Context) activity);
        this.isVideoReady = false;
        reportRequestShow();
        showRewardVideo();
    }
}
