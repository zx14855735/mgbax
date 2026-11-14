package io.dcloud.openapi.poly.adapter.sgm;

import J3FDQU.A2egSU;
import android.app.Activity;
import android.text.TextUtils;
import com.sigmob.windad.OnInitializationListener;
import com.sigmob.windad.WindAdBiddingLossReason;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.rewardVideo.WindRewardAdRequest;
import com.sigmob.windad.rewardVideo.WindRewardInfo;
import com.sigmob.windad.rewardVideo.WindRewardVideoAd;
import com.sigmob.windad.rewardVideo.WindRewardVideoAdListener;
import com.ss.android.download.api.constant.BaseConstants;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.interfaces.AOLLoader;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.Const;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class SGMRewardAOL extends DCBaseAOLLoader implements WindRewardVideoAdListener {

    /* renamed from: a, reason: collision with root package name */
    public WindRewardVideoAd f13999a;
    public volatile boolean b;
    public int c;
    public String d;
    public String e;

    public SGMRewardAOL(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.b = false;
        this.c = 0;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        if (this.f13999a != null) {
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
            this.f13999a.sendLossNotificationWithInfo(hashMap);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        if (this.f13999a != null) {
            this.c = i;
            HashMap hashMap = new HashMap();
            A2egSU.BNL6CD(i, hashMap, WindAds.AUCTION_PRICE, i2, WindAds.HIGHEST_LOSS_PRICE);
            hashMap.put(WindAds.CURRENCY, WindAds.CNY);
            this.f13999a.sendWinNotificationWithInfo(hashMap);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
        WindRewardVideoAd windRewardVideoAd = this.f13999a;
        if (windRewardVideoAd != null) {
            windRewardVideoAd.destroy();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public String getType() {
        return Const.TYPE_SGM;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void init(String str, String str2) {
        this.d = str;
        this.e = str2;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public boolean isValid() {
        WindRewardVideoAd windRewardVideoAd = this.f13999a;
        return windRewardVideoAd != null && windRewardVideoAd.isReady();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void load() {
        this.b = false;
        SGMInit.getInstance().init(getActivity(), this.d, this.e, new OnInitializationListener() { // from class: io.dcloud.openapi.poly.adapter.sgm.SGMRewardAOL.1
            @Override // com.sigmob.windad.OnInitializationListener
            public void onInitializationFail(String str) {
                SGMRewardAOL.this.loadFail(-4001, str);
            }

            @Override // com.sigmob.windad.OnInitializationListener
            public void onInitializationSuccess() {
                HashMap hashMap = new HashMap();
                String userId = !TextUtils.isEmpty(SGMRewardAOL.this.getSlot().getUserId()) ? SGMRewardAOL.this.getSlot().getUserId() : null;
                if (!TextUtils.isEmpty(SGMRewardAOL.this.getSlot().getExtra())) {
                    hashMap.put(BaseConstants.EVENT_LABEL_EXTRA, SGMRewardAOL.this.getSlot().getExtra());
                }
                SGMRewardAOL.this.f13999a = new WindRewardVideoAd(new WindRewardAdRequest(SGMRewardAOL.this.getSlotId(), userId, hashMap));
                SGMRewardAOL.this.f13999a.setWindRewardVideoAdListener(SGMRewardAOL.this);
                SGMRewardAOL.this.f13999a.loadAd();
            }
        });
    }

    @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
    public void onRewardAdClicked(String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
    public void onRewardAdClosed(String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
    public void onRewardAdLoadError(WindAdError windAdError, String str) {
        loadFail(windAdError.getErrorCode(), windAdError.getMessage());
    }

    @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
    public void onRewardAdLoadSuccess(String str) {
        float parseInt;
        if (isSlotSupportBidding()) {
            String ecpm = this.f13999a.getEcpm();
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

    @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
    public void onRewardAdPlayEnd(String str) {
        if (!this.b || getVideoAdCallback() == null) {
            return;
        }
        getVideoAdCallback().onVideoPlayEnd();
    }

    @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
    public void onRewardAdPlayError(WindAdError windAdError, String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, "type:" + getType() + ";code:" + windAdError.getErrorCode() + ";message:" + windAdError.getMessage());
        }
    }

    @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
    public void onRewardAdPlayStart(String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
    public void onRewardAdPreLoadFail(String str) {
    }

    @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
    public void onRewardAdPreLoadSuccess(String str) {
    }

    @Override // com.sigmob.windad.rewardVideo.WindRewardVideoAdListener
    public void onRewardAdRewarded(WindRewardInfo windRewardInfo, String str) {
        this.b = true;
        if (getVideoAdCallback() instanceof AOLLoader.RewVAOLInteractionListener) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("provider", Const.PROVIDER_TYPE_CHINA);
            } catch (JSONException unused) {
            }
            ((AOLLoader.RewVAOLInteractionListener) getVideoAdCallback()).onReward(jSONObject);
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
                this.f13999a.setBidEcpm(this.c);
            }
            if (this.f13999a.show(null) || getVideoAdCallback() == null) {
                return;
            }
            getVideoAdCallback().onShowError(-5100, AOLErrorUtil.getErrorMsg(-5100));
        }
    }
}
