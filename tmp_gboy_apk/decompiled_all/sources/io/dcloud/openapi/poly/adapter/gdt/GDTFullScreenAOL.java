package io.dcloud.openapi.poly.adapter.gdt;

import android.app.Activity;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.pi.IBidding;
import com.qq.e.comm.util.AdError;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class GDTFullScreenAOL extends DCBaseAOLLoader implements UnifiedInterstitialADListener, UnifiedInterstitialMediaListener {

    /* renamed from: a, reason: collision with root package name */
    public UnifiedInterstitialAD f13970a;
    public int b;

    public GDTFullScreenAOL(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.b = 0;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        if (this.f13970a != null) {
            int i4 = i3 != 2 ? 10001 : 1;
            HashMap hashMap = new HashMap();
            J3FDQU.A2egSU.BNL6CD(i, hashMap, IBidding.WIN_PRICE, i4, IBidding.LOSS_REASON);
            hashMap.put(IBidding.ADN_ID, 2);
            this.f13970a.sendLossNotification(hashMap);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        if (this.f13970a != null) {
            this.b = i;
            HashMap hashMap = new HashMap();
            J3FDQU.A2egSU.BNL6CD(i, hashMap, IBidding.EXPECT_COST_PRICE, i2, IBidding.HIGHEST_LOSS_PRICE);
            this.f13970a.sendWinNotification(hashMap);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public String getType() {
        return "gdt";
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void init(String str, String str2) {
        GDTInit.getInstance().init(getActivity(), str);
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f13970a;
        return unifiedInterstitialAD != null && unifiedInterstitialAD.isValid();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void load() {
        GDTAdSdk.start(new GDTAdSdk.OnStartListener() { // from class: io.dcloud.openapi.poly.adapter.gdt.GDTFullScreenAOL.1
            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartFailed(Exception exc) {
                GDTFullScreenAOL.this.loadFail(-4001, exc.getMessage());
            }

            @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
            public void onStartSuccess() {
                GDTFullScreenAOL.this.f13970a = new UnifiedInterstitialAD(GDTFullScreenAOL.this.getActivity(), GDTFullScreenAOL.this.getSlotId(), GDTFullScreenAOL.this);
                GDTFullScreenAOL.this.f13970a.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(false).setDetailPageMuted(true).build());
                GDTFullScreenAOL gDTFullScreenAOL = GDTFullScreenAOL.this;
                gDTFullScreenAOL.f13970a.setMediaListener(gDTFullScreenAOL);
                if (GDTFullScreenAOL.this.getAdType() != 15) {
                    GDTFullScreenAOL.this.f13970a.loadFullScreenAD();
                } else if (GDTFullScreenAOL.this.getIntersType() == 0) {
                    GDTFullScreenAOL.this.f13970a.loadFullScreenAD();
                } else {
                    GDTFullScreenAOL.this.f13970a.loadAD();
                }
            }
        });
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADClicked() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADClosed() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADExposure() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADLeftApplication() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADOpened() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADReceive() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onNoAD(AdError adError) {
        loadFail(adError.getErrorCode(), adError.getErrorMsg());
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderFail() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, AOLErrorUtil.getErrorMsg(-5100));
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderSuccess() {
        if (this.f13970a != null && isSlotSupportBidding()) {
            setBiddingECPM(this.f13970a.getECPM());
        }
        loadSuccess();
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onVideoCached() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoComplete() {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onVideoPlayEnd();
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoError(AdError adError) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, "type:" + getType() + "code:" + adError.getErrorCode() + ";message:" + adError.getErrorMsg());
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoInit() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoLoading() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPageClose() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPageOpen() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPause() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoReady(long j) {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoStart() {
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void show(Activity activity) {
        if (activity == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5014, AOLErrorUtil.getErrorMsg(-5014));
            }
        } else {
            if (!isValid()) {
                if (getVideoAdCallback() != null) {
                    getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
                    return;
                }
                return;
            }
            if (isSlotSupportBidding()) {
                this.f13970a.setBidECPM(this.b);
            }
            if (getAdType() != 15) {
                this.f13970a.showFullScreenAD(activity);
            } else if (getIntersType() == 0) {
                this.f13970a.showFullScreenAD(activity);
            } else {
                this.f13970a.show();
            }
        }
    }
}
