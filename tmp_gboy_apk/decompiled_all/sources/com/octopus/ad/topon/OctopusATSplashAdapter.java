package com.octopus.ad.topon;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import com.octopus.ad.ADBidEvent;
import com.octopus.ad.SplashAd;
import com.octopus.ad.SplashAdListener;
import java.util.Map;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class OctopusATSplashAdapter extends CustomSplashAdapter {
    private SplashAd mSplashAd;
    private final String TAG = getClass().getSimpleName();
    private String mSlotId = "";
    private int floorPrice = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad(Context context) {
        if (context == null) {
            return;
        }
        SplashAd splashAd = new SplashAd(context, this.mSlotId, new SplashAdListener() { // from class: com.octopus.ad.topon.OctopusATSplashAdapter.2
            @Override // com.octopus.ad.SplashAdListener
            public void onAdCacheLoaded(boolean z) {
                String unused = OctopusATSplashAdapter.this.TAG;
            }

            @Override // com.octopus.ad.SplashAdListener
            public void onAdClicked() {
                String unused = OctopusATSplashAdapter.this.TAG;
                if (OctopusATSplashAdapter.this.mImpressionListener != null) {
                    OctopusATSplashAdapter.this.mImpressionListener.onSplashAdClicked();
                }
            }

            @Override // com.octopus.ad.SplashAdListener
            public void onAdClosed() {
                String unused = OctopusATSplashAdapter.this.TAG;
                OctopusATSplashAdapter.this.mDismissType = 0;
                if (OctopusATSplashAdapter.this.mImpressionListener != null) {
                    OctopusATSplashAdapter.this.mImpressionListener.onSplashAdDismiss();
                }
            }

            @Override // com.octopus.ad.SplashAdListener
            public void onAdFailedToLoad(int i) {
                String unused = OctopusATSplashAdapter.this.TAG;
                if (OctopusATSplashAdapter.this.mLoadListener != null) {
                    OctopusATSplashAdapter.this.mLoadListener.onAdLoadError(String.valueOf(i), CtFAbx.ARc23Z(i, "onAdFailedToLoad errorCode："));
                }
                if (OctopusATSplashAdapter.this.mBiddingListener != null) {
                    OctopusATSplashAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(String.valueOf(i)), (BaseAd) null);
                }
            }

            @Override // com.octopus.ad.SplashAdListener
            public void onAdLoaded() {
                String unused = OctopusATSplashAdapter.this.TAG;
                if (OctopusATSplashAdapter.this.mLoadListener != null) {
                    OctopusATSplashAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
                if (OctopusATSplashAdapter.this.mBiddingListener != null) {
                    double price = OctopusATSplashAdapter.this.mSplashAd.getPrice();
                    if (price < OctopusATSplashAdapter.this.floorPrice) {
                        String unused2 = OctopusATSplashAdapter.this.TAG;
                        int unused3 = OctopusATSplashAdapter.this.floorPrice;
                        OctopusATSplashAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("floor price"), (BaseAd) null);
                        OctopusATSplashAdapter.this.mSplashAd.sendLossNotice(OctopusATSplashAdapter.this.floorPrice, ADBidEvent.PRICE_LOW_FILTER, ADBidEvent.CSJ);
                        return;
                    }
                    OctopusATSplashAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(price, UUID.randomUUID().toString(), new OctopusBiddingNotice(OctopusATSplashAdapter.this.mSplashAd), ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
                }
            }

            @Override // com.octopus.ad.SplashAdListener
            public void onAdShown() {
                String unused = OctopusATSplashAdapter.this.TAG;
                if (OctopusATSplashAdapter.this.mImpressionListener != null) {
                    OctopusATSplashAdapter.this.mImpressionListener.onSplashAdShow();
                }
            }

            @Override // com.octopus.ad.SplashAdListener
            public void onAdTick(long j) {
            }
        });
        this.mSplashAd = splashAd;
        splashAd.openAdInNativeBrowser(true);
    }

    public void destory() {
        SplashAd splashAd = this.mSplashAd;
        if (splashAd != null) {
            splashAd.destroy();
            this.mSplashAd = null;
        }
    }

    public String getNetworkName() {
        return OctopusATInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.mSlotId;
    }

    public String getNetworkSDKVersion() {
        return OctopusATInitManager.getInstance().getNetworkVersion();
    }

    public boolean isAdReady() {
        SplashAd splashAd = this.mSplashAd;
        return splashAd != null && splashAd.isLoaded();
    }

    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("slot_id")) {
            this.mSlotId = (String) map.get("slot_id");
        }
        try {
            String str = (String) map.get("floor_price");
            if (!TextUtils.isEmpty(str)) {
                this.floorPrice = Integer.parseInt(str);
            }
        } catch (NumberFormatException unused) {
            this.floorPrice = 0;
        }
        if (!TextUtils.isEmpty(this.mSlotId)) {
            OctopusATInitManager.getInstance().initSDK(context.getApplicationContext(), map, new MediationInitCallback() { // from class: com.octopus.ad.topon.OctopusATSplashAdapter.1
                public void onFail(String str2) {
                    if (OctopusATSplashAdapter.this.mLoadListener != null) {
                        OctopusATSplashAdapter.this.mLoadListener.onAdLoadError("80000", str2);
                    }
                    if (OctopusATSplashAdapter.this.mBiddingListener != null) {
                        OctopusATSplashAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(str2), (BaseAd) null);
                    }
                }

                public void onSuccess() {
                    OctopusATSplashAdapter.this.startLoad(context);
                }
            });
            return;
        }
        if (this.mLoadListener != null) {
            this.mLoadListener.onAdLoadError("80000", "SlotId is empty!");
        }
        if (this.mBiddingListener != null) {
            this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("SlotId is empty!"), (BaseAd) null);
        }
    }

    public void show(Activity activity, ViewGroup viewGroup) {
        SplashAd splashAd = this.mSplashAd;
        if (splashAd == null || !splashAd.isLoaded() || viewGroup == null) {
            return;
        }
        this.mSplashAd.showAd(viewGroup);
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        loadCustomNetworkAd(context.getApplicationContext(), map, map2);
        return true;
    }
}
