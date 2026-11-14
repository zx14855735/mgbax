package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.uaaaaaaa;

import android.app.Activity;
import android.view.View;
import io.dcloud.api.custom.type.feed.UniAdCustomNativeAd;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaa0;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.module.DCBaseAOL;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaa0 extends DCBaseAOL implements io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaa0, aaaaaaa0.aaaaaaaa {
    private int aaaacaaa;
    private UniAdCustomNativeAd aaacaaaa;

    public aaaaaaa0(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.aaaacaaa = 0;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaa0.aaaaaaaa
    public void aaaaaaa0() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onError();
        }
    }

    public void aaaaaaaa(UniAdCustomNativeAd uniAdCustomNativeAd) {
        this.aaacaaaa = uniAdCustomNativeAd;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaa0.aaaaaaaa
    public void aaaaaaac() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onResume();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaa0.aaaaaaaa
    public void aaaaaaav() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onPause();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean aaaaoaaa() {
        return true;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaa0.aaaaaaaa
    public void aaaeaaaa() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onStart();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        UniAdCustomNativeAd uniAdCustomNativeAd = this.aaacaaaa;
        if (uniAdCustomNativeAd != null) {
            uniAdCustomNativeAd.onBidFail(i, i3);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        UniAdCustomNativeAd uniAdCustomNativeAd = this.aaacaaaa;
        if (uniAdCustomNativeAd != null) {
            uniAdCustomNativeAd.onBidSuccess(i, i2);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
        UniAdCustomNativeAd uniAdCustomNativeAd = this.aaacaaaa;
        if (uniAdCustomNativeAd != null) {
            uniAdCustomNativeAd.destroy();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public View getExpressAdView(Activity activity) {
        UniAdCustomNativeAd uniAdCustomNativeAd = this.aaacaaaa;
        return uniAdCustomNativeAd != null ? uniAdCustomNativeAd.getNativeAd() : super.getExpressAdView(activity);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        return true;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaa0
    public void onAdClicked() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClicked();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaa0
    public void onAdShow() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShow();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaa0
    public void onRenderFail() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderFail();
        }
        this.aaaacaaa = -1;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaa0
    public void onRenderSuccess() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderSuccess();
        }
        this.aaaacaaa = 1;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaa0
    public void onShowError(int i, String str) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShowError();
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaa0.aaaaaaaa
    public void onVideoPlayEnd() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onEnd();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void render() {
        try {
            UniAdCustomNativeAd uniAdCustomNativeAd = this.aaacaaaa;
            if (uniAdCustomNativeAd == null) {
                if (getFeedAdCallback() != null) {
                    getFeedAdCallback().onRenderFail();
                }
                this.aaaacaaa = -1;
                return;
            }
            int i = this.aaaacaaa;
            if (i == 1) {
                if (getFeedAdCallback() != null) {
                    getFeedAdCallback().onRenderSuccess();
                }
            } else if (i != -1) {
                uniAdCustomNativeAd.aaaaaaaa(this);
            } else if (getFeedAdCallback() != null) {
                getFeedAdCallback().onRenderFail();
            }
        } catch (Throwable unused) {
            if (getFeedAdCallback() != null) {
                getFeedAdCallback().onRenderFail();
            }
            this.aaaacaaa = -1;
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaa0
    public void aaaaaaaa(String str) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClosed(str);
        }
    }
}
