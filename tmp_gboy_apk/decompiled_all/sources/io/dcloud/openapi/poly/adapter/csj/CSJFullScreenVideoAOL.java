package io.dcloud.openapi.poly.adapter.csj;

import android.app.Activity;
import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.Const;
import io.dcloud.openapi.core.util.MainHandlerUtil;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class CSJFullScreenVideoAOL extends DCBaseAOLLoader implements TTAdNative.FullScreenVideoAdListener, TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {

    /* renamed from: a, reason: collision with root package name */
    public TTFullScreenVideoAd f13952a;
    public String b;

    public CSJFullScreenVideoAOL(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
    }

    public final /* synthetic */ void a(Activity activity) {
        this.f13952a.showFullScreenVideoAd(activity);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void init(String str, String str2) {
        this.b = str;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        if (this.f13952a != null) {
            return !Const.TYPE_CSJ.equals(getType()) || this.f13952a.getExpirationTimestamp() - 1000 > SystemClock.elapsedRealtime();
        }
        return false;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void load() {
        CSJInit.getInstance().init(getActivity(), this.b, getType(), new TTAdSdk.InitCallback() { // from class: io.dcloud.openapi.poly.adapter.csj.CSJFullScreenVideoAOL.1
            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void fail(int i, String str) {
                CSJFullScreenVideoAOL.this.loadFail(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
            public void success() {
                TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(CSJFullScreenVideoAOL.this.getActivity());
                AdSlot build = new AdSlot.Builder().setAdCount(1).setCodeId(CSJFullScreenVideoAOL.this.getSlotId()).setOrientation(CSJFullScreenVideoAOL.this.getSlot().getOrientation() == 1 ? 1 : 2).setExpressViewAcceptedSize(500.0f, 500.0f).setSupportDeepLink(true).build();
                CSJFullScreenVideoAOL.this.startLoadTime();
                createAdNative.loadFullScreenVideoAd(build, CSJFullScreenVideoAOL.this);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public final void onAdClose() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdShow() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public final void onAdVideoBarClick() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onError(int i, String str) {
        loadFail(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public final void onSkippedVideo() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onSkip();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public final void onVideoComplete() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onVideoPlayEnd();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void show(Activity activity) {
        if (this.f13952a != null) {
            MainHandlerUtil.getMainHandler().post(new A2egSU(this, activity, 0));
        } else if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
        if (tTFullScreenVideoAd == null) {
            loadFail(-20001, AOLErrorUtil.getErrorMsg(200000));
            return;
        }
        this.f13952a = tTFullScreenVideoAd;
        tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(this);
        loadSuccess();
    }
}
