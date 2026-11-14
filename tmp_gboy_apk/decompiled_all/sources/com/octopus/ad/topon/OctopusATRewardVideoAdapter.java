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
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.octopus.ad.ADBidEvent;
import com.octopus.ad.InterstitialAd;
import com.octopus.ad.InterstitialAdListener;
import com.octopus.ad.RewardItem;
import com.octopus.ad.RewardVideoAd;
import com.octopus.ad.RewardVideoAdListener;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.Map;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class OctopusATRewardVideoAdapter extends CustomRewardVideoAdapter {
    private InterstitialAd mInterstitialAd;
    private RewardVideoAd mRewardVideoAd;
    private final String TAG = getClass().getSimpleName();
    private final int TYPE_INTER = 2;
    private final int TYPE_REWARD = 3;
    private String mSlotId = "";
    private int floorPrice = 0;
    private int mType = 3;

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad(Context context, Map<String, Object> map) {
        if (context == null) {
            return;
        }
        this.mRewardVideoAd = new RewardVideoAd(context, this.mSlotId, new RewardVideoAdListener() { // from class: com.octopus.ad.topon.OctopusATRewardVideoAdapter.2
            @Override // com.octopus.ad.RewardVideoAdListener
            public void onRewardVideoAdClicked() {
                String unused = OctopusATRewardVideoAdapter.this.TAG;
                if (OctopusATRewardVideoAdapter.this.mImpressionListener != null) {
                    OctopusATRewardVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
                }
            }

            @Override // com.octopus.ad.RewardVideoAdListener
            public void onRewardVideoAdClosed() {
                String unused = OctopusATRewardVideoAdapter.this.TAG;
                if (OctopusATRewardVideoAdapter.this.mImpressionListener != null) {
                    OctopusATRewardVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
                }
            }

            @Override // com.octopus.ad.RewardVideoAdListener
            public void onRewardVideoAdComplete() {
                String unused = OctopusATRewardVideoAdapter.this.TAG;
                if (OctopusATRewardVideoAdapter.this.mImpressionListener != null) {
                    OctopusATRewardVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayEnd();
                }
            }

            @Override // com.octopus.ad.RewardVideoAdListener
            public void onRewardVideoAdFailedToLoad(int i) {
                String unused = OctopusATRewardVideoAdapter.this.TAG;
                if (OctopusATRewardVideoAdapter.this.mLoadListener != null) {
                    OctopusATRewardVideoAdapter.this.mLoadListener.onAdLoadError(String.valueOf(i), CtFAbx.ARc23Z(i, "onRewardVideoAdFailedToLoad errorCode："));
                }
                if (OctopusATRewardVideoAdapter.this.mBiddingListener != null) {
                    OctopusATRewardVideoAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(String.valueOf(i)), (BaseAd) null);
                }
            }

            @Override // com.octopus.ad.RewardVideoAdListener
            public void onRewardVideoAdLoaded() {
                String unused = OctopusATRewardVideoAdapter.this.TAG;
                if (OctopusATRewardVideoAdapter.this.mLoadListener != null) {
                    OctopusATRewardVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
                if (OctopusATRewardVideoAdapter.this.mBiddingListener != null) {
                    double price = OctopusATRewardVideoAdapter.this.mRewardVideoAd.getPrice();
                    if (price < OctopusATRewardVideoAdapter.this.floorPrice) {
                        String unused2 = OctopusATRewardVideoAdapter.this.TAG;
                        int unused3 = OctopusATRewardVideoAdapter.this.floorPrice;
                        OctopusATRewardVideoAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("floor price"), (BaseAd) null);
                        OctopusATRewardVideoAdapter.this.mRewardVideoAd.sendLossNotice(OctopusATRewardVideoAdapter.this.floorPrice, ADBidEvent.PRICE_LOW_FILTER, ADBidEvent.CSJ);
                        return;
                    }
                    OctopusATRewardVideoAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(price, UUID.randomUUID().toString(), new OctopusBiddingNotice(OctopusATRewardVideoAdapter.this.mRewardVideoAd), ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
                }
            }

            @Override // com.octopus.ad.RewardVideoAdListener
            public void onRewardVideoAdShown() {
                String unused = OctopusATRewardVideoAdapter.this.TAG;
                if (OctopusATRewardVideoAdapter.this.mImpressionListener != null) {
                    OctopusATRewardVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
                }
            }

            @Override // com.octopus.ad.RewardVideoAdListener
            public void onRewardVideoCached(boolean z) {
                String unused = OctopusATRewardVideoAdapter.this.TAG;
            }

            @Override // com.octopus.ad.RewardVideoAdListener
            public void onRewarded(RewardItem rewardItem) {
                String unused = OctopusATRewardVideoAdapter.this.TAG;
                if (OctopusATRewardVideoAdapter.this.mImpressionListener != null) {
                    OctopusATRewardVideoAdapter.this.mImpressionListener.onReward();
                }
            }
        });
        if (map != null && map.containsKey("user_id")) {
            this.mRewardVideoAd.setUserId(String.valueOf(map.get("user_id")));
        }
        if (map != null && map.containsKey("user_custom_data")) {
            this.mRewardVideoAd.setExtraData(String.valueOf(map.get("user_custom_data")));
        }
        this.mRewardVideoAd.openAdInNativeBrowser(true);
        this.mRewardVideoAd.loadAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadInter(Context context) {
        if (context == null) {
            return;
        }
        InterstitialAd interstitialAd = new InterstitialAd(context, this.mSlotId, new InterstitialAdListener() { // from class: com.octopus.ad.topon.OctopusATRewardVideoAdapter.3
            @Override // com.octopus.ad.InterstitialAdListener
            public void onAdCacheLoaded(boolean z) {
                String unused = OctopusATRewardVideoAdapter.this.TAG;
            }

            @Override // com.octopus.ad.InterstitialAdListener
            public void onAdClicked() {
                String unused = OctopusATRewardVideoAdapter.this.TAG;
                if (OctopusATRewardVideoAdapter.this.mImpressionListener != null) {
                    OctopusATRewardVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayClicked();
                }
            }

            @Override // com.octopus.ad.InterstitialAdListener
            public void onAdClosed() {
                String unused = OctopusATRewardVideoAdapter.this.TAG;
                if (OctopusATRewardVideoAdapter.this.mImpressionListener != null) {
                    OctopusATRewardVideoAdapter.this.mImpressionListener.onReward();
                    OctopusATRewardVideoAdapter.this.mImpressionListener.onRewardedVideoAdClosed();
                }
            }

            @Override // com.octopus.ad.InterstitialAdListener
            public void onAdFailedToLoad(int i) {
                String unused = OctopusATRewardVideoAdapter.this.TAG;
                if (OctopusATRewardVideoAdapter.this.mLoadListener != null) {
                    OctopusATRewardVideoAdapter.this.mLoadListener.onAdLoadError(String.valueOf(i), CtFAbx.ARc23Z(i, "onAdFailedToLoad errorCode："));
                }
                if (OctopusATRewardVideoAdapter.this.mBiddingListener != null) {
                    OctopusATRewardVideoAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(String.valueOf(i)), (BaseAd) null);
                }
            }

            @Override // com.octopus.ad.InterstitialAdListener
            public void onAdLoaded() {
                String unused = OctopusATRewardVideoAdapter.this.TAG;
                if (OctopusATRewardVideoAdapter.this.mLoadListener != null) {
                    OctopusATRewardVideoAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
                if (OctopusATRewardVideoAdapter.this.mBiddingListener != null) {
                    double price = OctopusATRewardVideoAdapter.this.mInterstitialAd.getPrice();
                    if (price < OctopusATRewardVideoAdapter.this.floorPrice) {
                        String unused2 = OctopusATRewardVideoAdapter.this.TAG;
                        int unused3 = OctopusATRewardVideoAdapter.this.floorPrice;
                        OctopusATRewardVideoAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("floor price"), (BaseAd) null);
                        OctopusATRewardVideoAdapter.this.mInterstitialAd.sendLossNotice(OctopusATRewardVideoAdapter.this.floorPrice, ADBidEvent.PRICE_LOW_FILTER, ADBidEvent.CSJ);
                        return;
                    }
                    OctopusATRewardVideoAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(price, UUID.randomUUID().toString(), new OctopusBiddingNotice(OctopusATRewardVideoAdapter.this.mInterstitialAd), ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
                }
            }

            @Override // com.octopus.ad.InterstitialAdListener
            public void onAdShown() {
                String unused = OctopusATRewardVideoAdapter.this.TAG;
                if (OctopusATRewardVideoAdapter.this.mImpressionListener != null) {
                    OctopusATRewardVideoAdapter.this.mImpressionListener.onRewardedVideoAdPlayStart();
                }
            }
        });
        this.mInterstitialAd = interstitialAd;
        interstitialAd.openAdInNativeBrowser(true);
        this.mInterstitialAd.loadAd();
    }

    public void destory() {
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.destroy();
            this.mRewardVideoAd = null;
        }
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
        InterstitialAd interstitialAd;
        int i = this.mType;
        if (i != 3) {
            return i == 2 && (interstitialAd = this.mInterstitialAd) != null && interstitialAd.isLoaded();
        }
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        return rewardVideoAd != null && rewardVideoAd.isLoaded();
    }

    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, final Map<String, Object> map2) {
        if (map.containsKey("slot_id")) {
            this.mSlotId = (String) map.get("slot_id");
        }
        try {
            String str = (String) map.get("floor_price");
            if (!TextUtils.isEmpty(str)) {
                this.floorPrice = Integer.parseInt(str);
            }
            String str2 = (String) map.get(PointParamKey.TYPE);
            if (!TextUtils.isEmpty(str2)) {
                this.mType = Integer.parseInt(str2);
            }
        } catch (Exception unused) {
            this.floorPrice = 0;
            this.mType = 3;
        }
        if (!TextUtils.isEmpty(this.mSlotId)) {
            OctopusATInitManager.getInstance().initSDK(context.getApplicationContext(), map, new MediationInitCallback() { // from class: com.octopus.ad.topon.OctopusATRewardVideoAdapter.1
                public void onFail(String str3) {
                    if (OctopusATRewardVideoAdapter.this.mLoadListener != null) {
                        OctopusATRewardVideoAdapter.this.mLoadListener.onAdLoadError("80000", str3);
                    }
                    if (OctopusATRewardVideoAdapter.this.mBiddingListener != null) {
                        OctopusATRewardVideoAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(str3), (BaseAd) null);
                    }
                }

                public void onSuccess() {
                    if (OctopusATRewardVideoAdapter.this.mType == 3) {
                        OctopusATRewardVideoAdapter.this.startLoad(context, map2);
                    } else if (OctopusATRewardVideoAdapter.this.mType == 2) {
                        OctopusATRewardVideoAdapter.this.startLoadInter(context);
                    } else {
                        OctopusATRewardVideoAdapter.this.mLoadListener.onAdLoadError("80000", "type not support");
                    }
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
        RewardVideoAd rewardVideoAd;
        int i = this.mType;
        if (i == 3) {
            if (activity == null || (rewardVideoAd = this.mRewardVideoAd) == null || !rewardVideoAd.isLoaded()) {
                return;
            }
            this.mRewardVideoAd.show(activity);
            return;
        }
        if (i != 2 || activity == null || (interstitialAd = this.mInterstitialAd) == null || !interstitialAd.isLoaded()) {
            return;
        }
        this.mInterstitialAd.show(activity);
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        loadCustomNetworkAd(context.getApplicationContext(), map, map2);
        return true;
    }
}
