package io.dcloud.openapi.poly.adapter.csj;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.module.DCBaseAOL;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class CSJFeedAOLEntry extends DCBaseAOL implements TTNativeExpressAd.AdInteractionListener, TTAdDislike.DislikeInteractionCallback, MediationExpressRenderListener, TTFeedAd.VideoAdListener, AOLLoader.NativeAOLListener {

    /* renamed from: a, reason: collision with root package name */
    public Object f13947a;
    public View b;
    public AOLLoader.VideoAdListener c;

    public CSJFeedAOLEntry(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final void destroy() {
        Object obj = this.f13947a;
        if (obj instanceof TTNativeExpressAd) {
            ((TTNativeExpressAd) obj).destroy();
        } else if (obj instanceof TTFeedAd) {
            ((TTFeedAd) obj).destroy();
        }
        this.f13947a = null;
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void dislike(Activity activity) {
        Object obj = this.f13947a;
        if (!(obj instanceof TTFeedAd) || ((TTFeedAd) obj).getMediationManager().isExpress()) {
            return;
        }
        TTAdDislike dislikeDialog = ((TTFeedAd) this.f13947a).getDislikeDialog(activity);
        if (dislikeDialog != null) {
            dislikeDialog.setDislikeInteractionCallback(this);
            dislikeDialog.showDislikeDialog();
        } else if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClosed("");
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final View getExpressAdView(Activity activity) {
        View view = this.b;
        if (view != null && view.getParent() != null) {
            if (getFeedAdCallback() != null) {
                getFeedAdCallback().onShowError();
            }
            return null;
        }
        Object obj = this.f13947a;
        if (obj instanceof TTNativeExpressAd) {
            ((TTNativeExpressAd) obj).setDislikeCallback(activity, this);
            View expressAdView = ((TTNativeExpressAd) this.f13947a).getExpressAdView();
            this.b = expressAdView;
            return expressAdView;
        }
        if (!(obj instanceof TTFeedAd)) {
            return null;
        }
        ((TTFeedAd) obj).setDislikeCallback(activity, this);
        View adView = ((TTFeedAd) this.f13947a).getAdView();
        this.b = adView;
        return adView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00b6, code lost:
    
        if (r1 != 5) goto L38;
     */
    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.util.SparseArray<java.lang.Object> getNativeAdInfo() {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.dcloud.openapi.poly.adapter.csj.CSJFeedAOLEntry.getNativeAdInfo():android.util.SparseArray");
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public View getVideoView(Activity activity) {
        Object obj = this.f13947a;
        if (!(obj instanceof TTFeedAd) || obj == null) {
            return null;
        }
        if (((TTFeedAd) obj).getImageMode() == 166 || ((TTFeedAd) this.f13947a).getImageMode() == 5 || ((TTFeedAd) this.f13947a).getImageMode() == 15) {
            return ((TTFeedAd) this.f13947a).getAdView();
        }
        return null;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final boolean isValid() {
        return this.f13947a != null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
    public void onAdClick() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.AdInteractionListener
    public void onAdDismiss() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShow();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
    }

    public void onProgressUpdate(long j, long j2) {
        AOLLoader.VideoAdListener videoAdListener = this.c;
        if (videoAdListener != null) {
            videoAdListener.onProgressUpdate(j, j2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener, com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
    public void onRenderFail(View view, String str, int i) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderFail();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f, float f2) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderSuccess();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i, String str, boolean z) {
        View view = this.b;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onClosed(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onShow() {
    }

    public void onVideoAdComplete(TTFeedAd tTFeedAd) {
        AOLLoader.VideoAdListener videoAdListener = this.c;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdComplete();
        }
    }

    public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
        AOLLoader.VideoAdListener videoAdListener = this.c;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdResume();
        }
    }

    public void onVideoAdPaused(TTFeedAd tTFeedAd) {
        AOLLoader.VideoAdListener videoAdListener = this.c;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdPaused();
        }
    }

    public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
        AOLLoader.VideoAdListener videoAdListener = this.c;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdStartPlay();
        }
    }

    public void onVideoError(int i, int i2) {
        AOLLoader.VideoAdListener videoAdListener = this.c;
        if (videoAdListener != null) {
            videoAdListener.onVideoError(i, i2 + "");
        }
    }

    public void onVideoLoad(TTFeedAd tTFeedAd) {
        AOLLoader.VideoAdListener videoAdListener = this.c;
        if (videoAdListener != null) {
            videoAdListener.onVideoLoad();
        }
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void registerViewForInteraction(Activity activity, FrameLayout frameLayout, List<View> list, List<View> list2, List<ImageView> list3) {
        if (this.f13947a instanceof TTFeedAd) {
            float f = frameLayout.getContext().getResources().getDisplayMetrics().density;
            ImageView imageView = new ImageView(frameLayout.getContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setImageBitmap(((TTFeedAd) this.f13947a).getAdLogo());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) (16.0f * f));
            int i = (int) (f * 4.0f);
            layoutParams.setMargins(0, 0, i, i);
            layoutParams.gravity = 8388693;
            frameLayout.addView(imageView, layoutParams);
            ((TTFeedAd) this.f13947a).registerViewForInteraction(frameLayout, (list3 == null || list3.isEmpty()) ? null : new ArrayList(list3), list, list2, null, new TTNativeAd.AdInteractionListener() { // from class: io.dcloud.openapi.poly.adapter.csj.CSJFeedAOLEntry.3
                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdClicked(View view, TTNativeAd tTNativeAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
                public void onAdShow(TTNativeAd tTNativeAd) {
                }
            });
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public final void render() {
        View view = this.b;
        if (view != null && view.getParent() != null) {
            if (getFeedAdCallback() != null) {
                getFeedAdCallback().onRenderFail();
                getFeedAdCallback().onShowError();
                return;
            }
            return;
        }
        Object obj = this.f13947a;
        if (obj instanceof TTNativeExpressAd) {
            ((TTNativeExpressAd) obj).setExpressInteractionListener((TTNativeExpressAd.AdInteractionListener) this);
            ((TTNativeExpressAd) this.f13947a).render();
        } else if (obj instanceof TTFeedAd) {
            ((TTFeedAd) obj).setExpressRenderListener(this);
            ((TTFeedAd) this.f13947a).render();
        } else if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderFail();
        }
    }

    public final void setAdEntry(Object obj) {
        this.f13947a = obj;
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void setAppDownloadListener(AOLLoader.AppDownloadListener appDownloadListener) {
    }

    @Override // io.dcloud.openapi.core.interfaces.AOLLoader.NativeAOLListener
    public void setVideoAdListener(AOLLoader.VideoAdListener videoAdListener) {
        this.c = videoAdListener;
        Object obj = this.f13947a;
        if (obj instanceof TTFeedAd) {
            ((TTFeedAd) obj).setVideoAdListener(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
    public void onAdShow() {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onShow();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener
    public void onRenderSuccess(View view, float f, float f2, boolean z) {
        if (getFeedAdCallback() != null) {
            getFeedAdCallback().onRenderSuccess();
        }
    }
}
