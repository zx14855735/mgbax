package io.dcloud.openapi.poly.adapter.sgm;

import J3FDQU.A2egSU;
import android.app.Activity;
import android.text.TextUtils;
import com.sigmob.windad.OnInitializationListener;
import com.sigmob.windad.WindAdBiddingLossReason;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.newInterstitial.WindNewInterstitialAd;
import com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener;
import com.sigmob.windad.newInterstitial.WindNewInterstitialAdRequest;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.Const;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class SGMInterstitialAOL extends DCBaseAOLLoader implements WindNewInterstitialAdListener {

    /* renamed from: a, reason: collision with root package name */
    public WindNewInterstitialAd f13997a;
    public int b;
    public String c;
    public String d;

    public SGMInterstitialAOL(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.b = 0;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        if (this.f13997a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(WindAds.AUCTION_PRICE, Integer.valueOf(i));
            hashMap.put(WindAds.CURRENCY, WindAds.CNY);
            if (i3 == 1) {
                hashMap.put(WindAds.LOSS_REASON, Integer.valueOf(WindAdBiddingLossReason.LOSS_REASON_RETURN_TIMEOUT.getCode()));
            } else if (i3 == 2) {
                hashMap.put(WindAds.LOSS_REASON, Integer.valueOf(WindAdBiddingLossReason.LOSS_REASON_LOW_PRICE.getCode()));
            } else {
                hashMap.put(WindAds.LOSS_REASON, Integer.valueOf(WindAdBiddingLossReason.LOSS_REASON_RETURN_TIMEOUT.getCode()));
            }
            hashMap.put(WindAds.ADN_ID, "10001");
            this.f13997a.sendLossNotificationWithInfo(hashMap);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        if (this.f13997a != null) {
            this.b = i;
            HashMap hashMap = new HashMap();
            A2egSU.BNL6CD(i, hashMap, WindAds.AUCTION_PRICE, i2, WindAds.HIGHEST_LOSS_PRICE);
            hashMap.put(WindAds.CURRENCY, WindAds.CNY);
            this.f13997a.sendWinNotificationWithInfo(hashMap);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
        WindNewInterstitialAd windNewInterstitialAd = this.f13997a;
        if (windNewInterstitialAd != null) {
            windNewInterstitialAd.destroy();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public String getType() {
        return Const.TYPE_SGM;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void init(String str, String str2) {
        this.c = str;
        this.d = str2;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        WindNewInterstitialAd windNewInterstitialAd = this.f13997a;
        return windNewInterstitialAd != null && windNewInterstitialAd.isReady();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void load() {
        SGMInit.getInstance().init(getActivity(), this.c, this.d, new OnInitializationListener() { // from class: io.dcloud.openapi.poly.adapter.sgm.SGMInterstitialAOL.1
            @Override // com.sigmob.windad.OnInitializationListener
            public void onInitializationFail(String str) {
                SGMInterstitialAOL.this.loadFail(-4001, str);
            }

            @Override // com.sigmob.windad.OnInitializationListener
            public void onInitializationSuccess() {
                WindNewInterstitialAdRequest windNewInterstitialAdRequest = new WindNewInterstitialAdRequest(SGMInterstitialAOL.this.getSlotId(), null, null);
                SGMInterstitialAOL.this.f13997a = new WindNewInterstitialAd(windNewInterstitialAdRequest);
                SGMInterstitialAOL.this.f13997a.setWindNewInterstitialAdListener(SGMInterstitialAOL.this);
                SGMInterstitialAOL.this.f13997a.loadAd();
            }
        });
    }

    @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
    public void onInterstitialAdClicked(String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
    public void onInterstitialAdClosed(String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
    public void onInterstitialAdLoadError(WindAdError windAdError, String str) {
        loadFail(windAdError.getErrorCode(), windAdError.getMessage());
    }

    @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
    public void onInterstitialAdLoadSuccess(String str) {
        float parseInt;
        if (isSlotSupportBidding()) {
            String ecpm = this.f13997a.getEcpm();
            if (!TextUtils.isEmpty(ecpm)) {
                try {
                    try {
                        parseInt = Float.parseFloat(ecpm);
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    parseInt = Integer.parseInt(ecpm);
                }
                setBiddingECPM((int) parseInt);
            }
            parseInt = -1.0f;
            setBiddingECPM((int) parseInt);
        }
        loadSuccess();
    }

    @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
    public void onInterstitialAdPreLoadFail(String str) {
    }

    @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
    public void onInterstitialAdPreLoadSuccess(String str) {
    }

    @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
    public void onInterstitialAdShow(String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
            getVideoAdCallback().onVideoPlayEnd();
        }
    }

    @Override // com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener
    public void onInterstitialAdShowError(WindAdError windAdError, String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, "type:" + getType() + ";code:" + windAdError.getErrorCode() + ";message:" + windAdError.getMessage());
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void show(Activity activity) {
        if (activity == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5014, AOLErrorUtil.getErrorMsg(-5014));
            }
        } else if (!isValid()) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
            }
        } else {
            if (isSlotSupportBidding()) {
                this.f13997a.setBidEcpm(this.b);
            }
            if (this.f13997a.show(null) || getVideoAdCallback() == null) {
                return;
            }
            getVideoAdCallback().onShowError(-5100, AOLErrorUtil.getErrorMsg(-5100));
        }
    }
}
