package io.dcloud.openapi.poly.adapter.bd;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ExpressResponse;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOL;
import io.dcloud.openapi.core.util.Const;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class BDFeedAOLEntry extends DCBaseAOL implements ExpressResponse.ExpressDislikeListener, ExpressResponse.ExpressInteractionListener {

    /* renamed from: a, reason: collision with root package name */
    public ExpressResponse f13932a;
    public View b;

    public BDFeedAOLEntry(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        ExpressResponse expressResponse = this.f13932a;
        if (expressResponse != null) {
            expressResponse.biddingFail(i3 == 2 ? "203" : i3 == 1 ? "100" : "900");
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        ExpressResponse expressResponse = this.f13932a;
        if (expressResponse != null) {
            expressResponse.biddingSuccess(String.valueOf(i2));
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final void destroy() {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final View getExpressAdView(Activity activity) {
        View view = this.b;
        if (view == null || view.getParent() == null) {
            return this.b;
        }
        if (getFeedAdCallback() == null) {
            return null;
        }
        getFeedAdCallback().onShowError();
        return null;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final String getType() {
        return Const.TYPE_BD;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final boolean isValid() {
        ExpressResponse expressResponse = this.f13932a;
        return expressResponse != null && expressResponse.isAdAvailable();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdClick() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClicked();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdExposed() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShow();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdRenderFail(View view, String str, int i) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderFail();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdRenderSuccess(View view, float f, float f2) {
        this.b = view;
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
    public void onAdUnionClick() {
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
    public void onDislikeItemClick(String str) {
        if (this.b.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClosed(str);
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
    public void onDislikeWindowClose() {
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
    public void onDislikeWindowShow() {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final void render() {
        View view = this.b;
        if (view == null || view.getParent() == null) {
            this.f13932a.setAdDislikeListener(this);
            this.f13932a.setInteractionListener(this);
            this.f13932a.render();
        } else if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderFail();
            getFeedAdCallback().onShowError();
        }
    }

    public final void setAdEntry(ExpressResponse expressResponse) {
        this.f13932a = expressResponse;
    }
}
