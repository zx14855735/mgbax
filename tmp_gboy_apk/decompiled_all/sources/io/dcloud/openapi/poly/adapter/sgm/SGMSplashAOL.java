package io.dcloud.openapi.poly.adapter.sgm;

import J3FDQU.A2egSU;
import android.app.Activity;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.sigmob.sdk.videoplayer.AMqCpz;
import com.sigmob.windad.OnInitializationListener;
import com.sigmob.windad.Splash.WindSplashAD;
import com.sigmob.windad.Splash.WindSplashADListener;
import com.sigmob.windad.Splash.WindSplashAdRequest;
import com.sigmob.windad.WindAdBiddingLossReason;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAds;
import io.dcloud.openapi.core.entry.DCloudAOLSlot;
import io.dcloud.openapi.core.module.DCBaseAOLLoader;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import io.dcloud.openapi.core.util.Const;
import io.dcloud.openapi.core.util.MainHandlerUtil;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class SGMSplashAOL extends DCBaseAOLLoader implements WindSplashADListener {

    /* renamed from: a, reason: collision with root package name */
    public WindSplashAD f14001a;
    public int b;
    public String c;
    public String d;

    public SGMSplashAOL(DCloudAOLSlot dCloudAOLSlot, Activity activity) {
        super(dCloudAOLSlot, activity);
        this.b = 0;
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingFail(int i, int i2, int i3) {
        super.biddingFail(i, i2, i3);
        if (this.f14001a != null) {
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
            this.f14001a.sendLossNotificationWithInfo(hashMap);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void biddingSuccess(int i, int i2) {
        super.biddingSuccess(i, i2);
        if (this.f14001a != null) {
            this.b = i;
            HashMap hashMap = new HashMap();
            A2egSU.BNL6CD(i, hashMap, WindAds.AUCTION_PRICE, i2, WindAds.HIGHEST_LOSS_PRICE);
            hashMap.put(WindAds.CURRENCY, WindAds.CNY);
            this.f14001a.sendWinNotificationWithInfo(hashMap);
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOL
    public void destroy() {
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
        WindSplashAD windSplashAD = this.f14001a;
        return windSplashAD != null && windSplashAD.isReady();
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void load() {
        SGMInit.getInstance().init(getActivity(), this.c, this.d, new OnInitializationListener() { // from class: io.dcloud.openapi.poly.adapter.sgm.SGMSplashAOL.1
            @Override // com.sigmob.windad.OnInitializationListener
            public void onInitializationFail(String str) {
                SGMSplashAOL.this.loadFail(AVMDLDataLoader.AVMDLErrorIsInvalidFileWrite, str);
            }

            @Override // com.sigmob.windad.OnInitializationListener
            public void onInitializationSuccess() {
                WindSplashAdRequest windSplashAdRequest = new WindSplashAdRequest(SGMSplashAOL.this.getSlotId(), null, null);
                windSplashAdRequest.setDisableAutoHideAd(false);
                windSplashAdRequest.setFetchDelay(5);
                SGMSplashAOL.this.f14001a = new WindSplashAD(windSplashAdRequest, SGMSplashAOL.this);
                SGMSplashAOL.this.f14001a.loadAd();
            }
        });
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdClick(String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClick();
        }
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdClose(String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onClose();
        }
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdLoadFail(WindAdError windAdError, String str) {
        loadFail(windAdError.getErrorCode(), windAdError.getMessage());
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdLoadSuccess(String str) {
        float parseInt;
        if (isSlotSupportBidding()) {
            String ecpm = this.f14001a.getEcpm();
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

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdShow(String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShow();
        }
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdShowError(WindAdError windAdError, String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onShowError(-5100, "type:" + getType() + ";code:" + windAdError.getErrorCode() + ";message:" + windAdError.getMessage());
        }
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdSkip(String str) {
        if (getVideoAdCallback() != null) {
            getVideoAdCallback().onSkip();
        }
    }

    @Override // io.dcloud.openapi.core.module.DCBaseAOLLoader
    public void showIn(ViewGroup viewGroup) {
        if (viewGroup == null) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5014, AOLErrorUtil.getErrorMsg(-5014));
            }
        } else if (!isValid()) {
            if (getVideoAdCallback() != null) {
                getVideoAdCallback().onShowError(-5008, AOLErrorUtil.getErrorMsg(-5008));
            }
        } else {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                MainHandlerUtil.getMainHandler().post(new AMqCpz(this, 5, viewGroup));
                return;
            }
            if (isSlotSupportBidding()) {
                this.f14001a.setBidEcpm(this.b);
            }
            this.f14001a.show(viewGroup);
        }
    }

    public final /* synthetic */ void a(ViewGroup viewGroup) {
        this.f14001a.show(viewGroup);
    }
}
