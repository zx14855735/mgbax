package io.dcloud.openapi.poly.adapter.csj;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class CSJDrawAOLEntry extends CSJFeedAOLEntry implements TTNativeExpressAd.ExpressVideoAdListener, TTFeedAd.VideoAdListener {
    public CSJDrawAOLEntry(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onClickRetry() {
    }

    @Override // io.dcloud.openapi.poly.adapter.csj.CSJFeedAOLEntry, com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener, com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onProgressUpdate(long j, long j2) {
    }

    @Override // io.dcloud.openapi.poly.adapter.csj.CSJFeedAOLEntry, com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdComplete(TTFeedAd tTFeedAd) {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onEnd();
        }
    }

    @Override // io.dcloud.openapi.poly.adapter.csj.CSJFeedAOLEntry, com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onResume();
        }
    }

    @Override // io.dcloud.openapi.poly.adapter.csj.CSJFeedAOLEntry, com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdPaused(TTFeedAd tTFeedAd) {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onPause();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdStartPlay() {
    }

    @Override // io.dcloud.openapi.poly.adapter.csj.CSJFeedAOLEntry, com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener, com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoError(int i, int i2) {
    }

    @Override // io.dcloud.openapi.poly.adapter.csj.CSJFeedAOLEntry, com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoLoad(TTFeedAd tTFeedAd) {
    }

    @Override // io.dcloud.openapi.poly.adapter.csj.CSJFeedAOLEntry, com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onStart();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoLoad() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onStart();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdComplete() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onEnd();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdContinuePlay() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onResume();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdPaused() {
        if (getFeedAdCallback() instanceof AOLLoader.DrawAOLInteractionListener) {
            ((AOLLoader.DrawAOLInteractionListener) getFeedAdCallback()).onPause();
        }
    }
}
