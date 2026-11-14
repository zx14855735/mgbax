package com.octopus.ad.topon;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.czhj.sdk.common.Constants;
import com.octopus.ad.ADBidEvent;
import com.octopus.ad.NativeAd;
import com.octopus.ad.NativeAdListener;
import com.octopus.ad.NativeAdResponse;
import java.util.Map;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class OctopusATNativeAdapter extends CustomNativeAdapter {
    private final String TAG = getClass().getSimpleName();
    private int floorPrice = 0;
    private String mIsUnified;
    private NativeAd mNativeAd;
    private OctopusATNativeExpressAd mOctopusATNativeExpressAd;
    private OctopusATNativeUnifiedAd mOctopusATNativeUnifiedAd;
    private String mSlotId;

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad(final Context context) {
        if (context == null) {
            return;
        }
        final boolean equals = TextUtils.equals("1", this.mIsUnified);
        NativeAd nativeAd = new NativeAd(context, this.mSlotId, new NativeAdListener() { // from class: com.octopus.ad.topon.OctopusATNativeAdapter.2
            @Override // com.octopus.ad.NativeAdListener
            public void onAdFailed(int i) {
                String unused = OctopusATNativeAdapter.this.TAG;
                if (OctopusATNativeAdapter.this.mLoadListener != null) {
                    OctopusATNativeAdapter.this.mLoadListener.onAdLoadError(String.valueOf(i), CtFAbx.ARc23Z(i, "onAdFailed errorCode："));
                }
                if (OctopusATNativeAdapter.this.mBiddingListener != null) {
                    OctopusATNativeAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(String.valueOf(i)), (BaseAd) null);
                }
            }

            @Override // com.octopus.ad.NativeAdListener
            public void onAdLoaded(NativeAdResponse nativeAdResponse) {
                String unused = OctopusATNativeAdapter.this.TAG;
                if (OctopusATNativeAdapter.this.mLoadListener != null && nativeAdResponse != null) {
                    if (equals) {
                        OctopusATNativeAdapter.this.mOctopusATNativeUnifiedAd = new OctopusATNativeUnifiedAd(context, OctopusATNativeAdapter.this.mNativeAd, nativeAdResponse);
                        OctopusATNativeAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[]{OctopusATNativeAdapter.this.mOctopusATNativeUnifiedAd});
                    } else {
                        OctopusATNativeAdapter.this.mOctopusATNativeExpressAd = new OctopusATNativeExpressAd(context, OctopusATNativeAdapter.this.mNativeAd, nativeAdResponse);
                        OctopusATNativeAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[]{OctopusATNativeAdapter.this.mOctopusATNativeExpressAd});
                    }
                }
                if (OctopusATNativeAdapter.this.mBiddingListener == null || nativeAdResponse == null) {
                    return;
                }
                double price = OctopusATNativeAdapter.this.mNativeAd.getPrice();
                if (price < OctopusATNativeAdapter.this.floorPrice) {
                    String unused2 = OctopusATNativeAdapter.this.TAG;
                    int unused3 = OctopusATNativeAdapter.this.floorPrice;
                    OctopusATNativeAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("floor price"), (BaseAd) null);
                    OctopusATNativeAdapter.this.mNativeAd.sendLossNotice(OctopusATNativeAdapter.this.floorPrice, ADBidEvent.PRICE_LOW_FILTER, ADBidEvent.CSJ);
                    return;
                }
                ATAdConst.CURRENCY currency = ATAdConst.CURRENCY.RMB_CENT;
                String uuid = UUID.randomUUID().toString();
                OctopusBiddingNotice octopusBiddingNotice = new OctopusBiddingNotice(OctopusATNativeAdapter.this.mNativeAd);
                if (equals) {
                    OctopusATNativeAdapter.this.mOctopusATNativeUnifiedAd = new OctopusATNativeUnifiedAd(context, OctopusATNativeAdapter.this.mNativeAd, nativeAdResponse);
                    OctopusATNativeAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(price, uuid, octopusBiddingNotice, currency), OctopusATNativeAdapter.this.mOctopusATNativeUnifiedAd);
                } else {
                    OctopusATNativeAdapter.this.mOctopusATNativeExpressAd = new OctopusATNativeExpressAd(context, OctopusATNativeAdapter.this.mNativeAd, nativeAdResponse);
                    OctopusATNativeAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(price, uuid, octopusBiddingNotice, currency), OctopusATNativeAdapter.this.mOctopusATNativeExpressAd);
                }
            }
        });
        this.mNativeAd = nativeAd;
        nativeAd.openAdInNativeBrowser(true);
        this.mNativeAd.loadAd();
    }

    public void destory() {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.destroy();
            this.mNativeAd = null;
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
            this.mIsUnified = Constants.FAIL;
            if (map.containsKey("is_unified")) {
                this.mIsUnified = (String) map.get("is_unified");
            }
            OctopusATInitManager.getInstance().initSDK(context.getApplicationContext(), map, new MediationInitCallback() { // from class: com.octopus.ad.topon.OctopusATNativeAdapter.1
                public void onFail(String str2) {
                    if (OctopusATNativeAdapter.this.mLoadListener != null) {
                        OctopusATNativeAdapter.this.mLoadListener.onAdLoadError("80000", str2);
                    }
                    if (OctopusATNativeAdapter.this.mBiddingListener != null) {
                        OctopusATNativeAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(str2), (BaseAd) null);
                    }
                }

                public void onSuccess() {
                    OctopusATNativeAdapter.this.startLoad(context);
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

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        loadCustomNetworkAd(context.getApplicationContext(), map, map2);
        return true;
    }
}
