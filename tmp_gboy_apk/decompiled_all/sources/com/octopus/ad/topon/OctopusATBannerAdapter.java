package com.octopus.ad.topon;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.octopus.ad.ADBidEvent;
import com.octopus.ad.BannerAd;
import com.octopus.ad.BannerAdListener;
import com.octopus.ad.NativeAdResponse;
import com.octopus.ad.internal.nativead.NativeAdEventListener;
import com.octopus.ad.internal.utilities.ViewUtil;
import java.util.Map;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class OctopusATBannerAdapter extends CustomBannerAdapter {
    private BannerAd mBannerAd;
    private View mBannerView;
    private final String TAG = getClass().getSimpleName();
    private String mSlotId = "";
    private int floorPrice = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadBanner(final Context context) {
        if (context == null) {
            return;
        }
        BannerAd bannerAd = new BannerAd(context, this.mSlotId, new BannerAdListener() { // from class: com.octopus.ad.topon.OctopusATBannerAdapter.2
            @Override // com.octopus.ad.NativeAdListener
            public void onAdFailed(int i) {
                String unused = OctopusATBannerAdapter.this.TAG;
                if (OctopusATBannerAdapter.this.mLoadListener != null) {
                    OctopusATBannerAdapter.this.mLoadListener.onAdLoadError(String.valueOf(i), CtFAbx.ARc23Z(i, "onAdFailedToLoad errorCode："));
                }
                if (OctopusATBannerAdapter.this.mBiddingListener != null) {
                    OctopusATBannerAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(String.valueOf(i)), (BaseAd) null);
                }
            }

            @Override // com.octopus.ad.NativeAdListener
            public void onAdLoaded(NativeAdResponse nativeAdResponse) {
                String unused = OctopusATBannerAdapter.this.TAG;
                if (OctopusATBannerAdapter.this.mLoadListener != null) {
                    OctopusATBannerAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
                if (OctopusATBannerAdapter.this.mBiddingListener != null) {
                    double price = OctopusATBannerAdapter.this.mBannerAd.getPrice();
                    if (price < OctopusATBannerAdapter.this.floorPrice) {
                        String unused2 = OctopusATBannerAdapter.this.TAG;
                        int unused3 = OctopusATBannerAdapter.this.floorPrice;
                        OctopusATBannerAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("floor price"), (BaseAd) null);
                        OctopusATBannerAdapter.this.mBannerAd.sendLossNotice(OctopusATBannerAdapter.this.floorPrice, ADBidEvent.PRICE_LOW_FILTER, ADBidEvent.CSJ);
                        return;
                    }
                    OctopusATBannerAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(price, UUID.randomUUID().toString(), new OctopusBiddingNotice(OctopusATBannerAdapter.this.mBannerAd), ATAdConst.CURRENCY.RMB_CENT), (BaseAd) null);
                }
                if (OctopusATBannerAdapter.this.mBannerAd == null || !OctopusATBannerAdapter.this.mBannerAd.isValid()) {
                    return;
                }
                nativeAdResponse.setAdWidth(ViewUtil.getScreenWidth(context));
                OctopusATBannerAdapter.this.showBannerAd(nativeAdResponse);
            }
        });
        this.mBannerAd = bannerAd;
        bannerAd.openAdInNativeBrowser(true);
        this.mBannerAd.loadAd();
    }

    public void destory() {
        BannerAd bannerAd = this.mBannerAd;
        if (bannerAd != null) {
            bannerAd.destroy();
            this.mBannerAd = null;
        }
    }

    public View getBannerView() {
        return this.mBannerView;
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
        BannerAd bannerAd = this.mBannerAd;
        return bannerAd != null && bannerAd.isLoaded();
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
            OctopusATInitManager.getInstance().initSDK(context.getApplicationContext(), map, new MediationInitCallback() { // from class: com.octopus.ad.topon.OctopusATBannerAdapter.1
                public void onFail(String str2) {
                    if (OctopusATBannerAdapter.this.mLoadListener != null) {
                        OctopusATBannerAdapter.this.mLoadListener.onAdLoadError("80000", str2);
                    }
                    if (OctopusATBannerAdapter.this.mBiddingListener != null) {
                        OctopusATBannerAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(str2), (BaseAd) null);
                    }
                }

                public void onSuccess() {
                    OctopusATBannerAdapter.this.startLoadBanner(context);
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

    public void showBannerAd(NativeAdResponse nativeAdResponse) {
        if (nativeAdResponse == null) {
            return;
        }
        nativeAdResponse.setNativeAdEventListener(new NativeAdEventListener() { // from class: com.octopus.ad.topon.OctopusATBannerAdapter.3
            @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
            public void onADExposed() {
                String unused = OctopusATBannerAdapter.this.TAG;
                if (OctopusATBannerAdapter.this.mImpressionEventListener != null) {
                    OctopusATBannerAdapter.this.mImpressionEventListener.onBannerAdShow();
                }
            }

            @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
            public void onAdClick() {
                String unused = OctopusATBannerAdapter.this.TAG;
                if (OctopusATBannerAdapter.this.mImpressionEventListener != null) {
                    OctopusATBannerAdapter.this.mImpressionEventListener.onBannerAdClicked();
                }
            }

            @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
            public void onAdClose() {
                String unused = OctopusATBannerAdapter.this.TAG;
            }

            @Override // com.octopus.ad.internal.nativead.NativeAdEventListener
            public void onAdRenderFailed(int i) {
                String unused = OctopusATBannerAdapter.this.TAG;
                if (OctopusATBannerAdapter.this.mLoadListener != null) {
                    OctopusATBannerAdapter.this.mLoadListener.onAdLoadError(String.valueOf(i), CtFAbx.ARc23Z(i, "onAdFailedToLoad errorCode："));
                }
                if (OctopusATBannerAdapter.this.mBiddingListener != null) {
                    OctopusATBannerAdapter.this.mBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail(String.valueOf(i)), (BaseAd) null);
                }
            }
        });
        this.mBannerView = nativeAdResponse.getNativeView();
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        loadCustomNetworkAd(context.getApplicationContext(), map, map2);
        return true;
    }
}
