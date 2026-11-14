package com.qq.e.ads.banner2;

import J3FDQU.A2egSU;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class ADListenerAdapter implements ADListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final UnifiedBannerADListener f12744A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public NegativeFeedbackListener f12745A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public ADRewardListener f12746A5SV6n;

    public ADListenerAdapter(UnifiedBannerADListener unifiedBannerADListener) {
        this.f12744A2egSU = unifiedBannerADListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        String str;
        if (aDEvent == null) {
            return;
        }
        int type = aDEvent.getType();
        UnifiedBannerADListener unifiedBannerADListener = this.f12744A2egSU;
        if (type == 100) {
            if (unifiedBannerADListener != null) {
                unifiedBannerADListener.onADReceive();
                return;
            }
            return;
        }
        if (type == 101) {
            if (unifiedBannerADListener != null) {
                unifiedBannerADListener.onNoAD(AdErrorConvertor.getAdError(aDEvent));
                return;
            }
            return;
        }
        if (type == 303) {
            if (unifiedBannerADListener != null) {
                unifiedBannerADListener.onADLeftApplication();
                return;
            }
            return;
        }
        if (type == 304) {
            NegativeFeedbackListener negativeFeedbackListener = this.f12745A4TApA;
            if (negativeFeedbackListener != null) {
                negativeFeedbackListener.onComplainSuccess();
                return;
            }
            return;
        }
        switch (type) {
            case 103:
                if (unifiedBannerADListener != null) {
                    unifiedBannerADListener.onADExposure();
                    break;
                }
                break;
            case 104:
                if (this.f12746A5SV6n != null && (str = (String) aDEvent.getParam(String.class)) != null) {
                    this.f12746A5SV6n.onReward(A2egSU.BI9f7h("transId", str));
                    break;
                }
                break;
            case 105:
                if (unifiedBannerADListener != null) {
                    unifiedBannerADListener.onADClicked();
                    break;
                }
                break;
            case 106:
                if (unifiedBannerADListener != null) {
                    unifiedBannerADListener.onADClosed();
                    break;
                }
                break;
        }
    }

    public void setAdRewardListener(ADRewardListener aDRewardListener) {
        this.f12746A5SV6n = aDRewardListener;
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f12745A4TApA = negativeFeedbackListener;
    }
}
