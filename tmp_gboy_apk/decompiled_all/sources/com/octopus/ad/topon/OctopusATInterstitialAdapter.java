package com.octopus.ad.topon;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.octopus.ad.ADBidEvent;
import com.octopus.ad.InterstitialAd;
import com.octopus.ad.InterstitialAdListener;
import java.util.Map;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class OctopusATInterstitialAdapter extends CustomInterstitialAdapter {
    private boolean isClickBackClose;
    private InterstitialAd mInterstitialAd;
    private final String TAG = getClass().getSimpleName();
    private String mSlotId = "";
    private int floorPrice = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad(Context context) {
        if (context == null) {
            return;
        }
        InterstitialAd interstitialAd = new InterstitialAd(context, this.mSlotId, new InterstitialAdListener() { // from class: com.octopus.ad.topon.OctopusATInterstitialAdapter.2
            @Override // com.octopus.ad.InterstitialAdListener
            public void onAdCacheLoaded(boolean z) {
                String unused = OctopusATInterstitialAdapter.this.TAG;
            }

            @Override // com.octopus.ad.InterstitialAdListener
            public void onAdClicked() {
                String unused = OctopusATInterstitialAdapter.this.TAG;
                if (OctopusATInterstitialAdapter.this.mImpressListener != null) {
                    OctopusATInterstitialAdapter.this.mImpressListener.onInterstitialAdClicked();
                }
            }

            @Override // com.octopus.ad.InterstitialAdListener
            public void onAdClosed() {
                String unused = OctopusATInterstitialAdapter.this.TAG;
                if (OctopusATInterstitialAdapter.this.mImpressListener != null) {
                    OctopusATInterstitialAdapter.this.mImpressListener.onInterstitialAdClose();
                }
            }

            @Override // com.octopus.ad.InterstitialAdListener
            public void onAdFailedToLoad(int i) {
                String unused = OctopusATInterstitialAdapter.this.TAG;
                if (OctopusATInterstitialAdapter.this.mLoadListener != null) {
                    OctopusATInterstitialAdapter.this.mLoadListener.onAdLoadError(String.valueOf(i), CtFAbx.ARc23Z(i, "onAdFailedToLoad errorCode："));
                }
                if (OctopusATInterstitialAdapter.this.mBiddingListener != null) {
                    OctopusATInterstitialAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(String.valueOf(i)), (BaseAd) null);
                }
            }

            @Override // com.octopus.ad.InterstitialAdListener
            public void onAdLoaded() {
                String unused = OctopusATInterstitialAdapter.this.TAG;
                if (OctopusATInterstitialAdapter.this.mLoadListener != null) {
                    OctopusATInterstitialAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
                if (OctopusATInterstitialAdapter.this.mBiddingListener != null) {
                    double price = OctopusATInterstitialAdapter.this.mInterstitialAd.getPrice();
                    if (price < OctopusATInterstitialAdapter.this.floorPrice) {
                        String unused2 = OctopusATInterstitialAdapter.this.TAG;
                        int unused3 = OctopusATInterstitialAdapter.this.floorPrice;
                        OctopusATInterstitialAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("floor price"), (BaseAd) null);
                        OctopusATInterstitialAdapter.this.mInterstitialAd.sendLossNotice(OctopusATInterstitialAdapter.this.floorPrice, ADBidEvent.PRICE_LOW_FILTER, ADBidEvent.CSJ);
                        return;
                    }
                    OctopusATInterstitialAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(price, UUID.randomUUID().toString(), new OctopusBiddingNotice(OctopusATInterstitialAdapter.this.mInterstitialAd), ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
                }
            }

            @Override // com.octopus.ad.InterstitialAdListener
            public void onAdShown() {
                String unused = OctopusATInterstitialAdapter.this.TAG;
                if (OctopusATInterstitialAdapter.this.mImpressListener != null) {
                    OctopusATInterstitialAdapter.this.mImpressListener.onInterstitialAdShow();
                }
            }
        });
        this.mInterstitialAd = interstitialAd;
        interstitialAd.openAdInNativeBrowser(true);
        this.mInterstitialAd.setClickBackClose(this.isClickBackClose);
        this.mInterstitialAd.loadAd();
    }

    public void destory() {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.destroy();
            this.mInterstitialAd = null;
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
        InterstitialAd interstitialAd = this.mInterstitialAd;
        return interstitialAd != null && interstitialAd.isLoaded();
    }

    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("slot_id")) {
            this.mSlotId = (String) map.get("slot_id");
        }
        try {
            String str = (String) map.get("floor_price");
            if (str != null && !str.isEmpty()) {
                this.floorPrice = Integer.parseInt(str);
            }
        } catch (Exception unused) {
            this.floorPrice = 0;
        }
        try {
            Object obj = map.get("click_back_close");
            if (obj != null) {
                this.isClickBackClose = ((Boolean) obj).booleanValue();
            }
        } catch (Exception unused2) {
            this.isClickBackClose = false;
        }
        if (!TextUtils.isEmpty(this.mSlotId)) {
            OctopusATInitManager.getInstance().initSDK(context.getApplicationContext(), map, new MediationInitCallback() { // from class: com.octopus.ad.topon.OctopusATInterstitialAdapter.1
                public void onFail(String str2) {
                    if (OctopusATInterstitialAdapter.this.mLoadListener != null) {
                        OctopusATInterstitialAdapter.this.mLoadListener.onAdLoadError("80000", str2);
                    }
                    if (OctopusATInterstitialAdapter.this.mBiddingListener != null) {
                        OctopusATInterstitialAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(str2), (BaseAd) null);
                    }
                }

                public void onSuccess() {
                    OctopusATInterstitialAdapter.this.startLoad(context);
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

    public void show(Activity activity) {
        InterstitialAd interstitialAd;
        if (activity == null || (interstitialAd = this.mInterstitialAd) == null || !interstitialAd.isLoaded()) {
            return;
        }
        this.mInterstitialAd.show(activity);
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        loadCustomNetworkAd(context.getApplicationContext(), map, map2);
        return true;
    }
}
