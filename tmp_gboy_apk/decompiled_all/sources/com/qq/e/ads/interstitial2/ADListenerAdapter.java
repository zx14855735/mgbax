package com.qq.e.ads.interstitial2;

import J3FDQU.A2egSU;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.a;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class ADListenerAdapter implements ADListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final UnifiedInterstitialADListener f12805A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public UnifiedInterstitialMediaListener f12806A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public com.qq.e.comm.listeners.ADRewardListener f12807A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public NegativeFeedbackListener f12808ADYaiT;

    public ADListenerAdapter(UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this.f12805A2egSU = unifiedInterstitialADListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        String str;
        if (aDEvent == null) {
            return;
        }
        int type = aDEvent.getType();
        UnifiedInterstitialADListener unifiedInterstitialADListener = this.f12805A2egSU;
        if (type == 109) {
            if (unifiedInterstitialADListener == null || !a.b(unifiedInterstitialADListener)) {
                return;
            }
            unifiedInterstitialADListener.onRenderSuccess();
            return;
        }
        if (type == 110) {
            if (unifiedInterstitialADListener == null || !a.a(unifiedInterstitialADListener)) {
                return;
            }
            unifiedInterstitialADListener.onRenderFail();
            return;
        }
        if (type == 201) {
            if (unifiedInterstitialADListener != null) {
                unifiedInterstitialADListener.onVideoCached();
                return;
            }
            return;
        }
        if (type == 202) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener = this.f12806A4TApA;
            if (unifiedInterstitialMediaListener != null) {
                unifiedInterstitialMediaListener.onVideoStart();
                return;
            }
            return;
        }
        if (type == 204) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener2 = this.f12806A4TApA;
            if (unifiedInterstitialMediaListener2 != null) {
                unifiedInterstitialMediaListener2.onVideoPause();
                return;
            }
            return;
        }
        if (type == 206) {
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener3 = this.f12806A4TApA;
            if (unifiedInterstitialMediaListener3 != null) {
                unifiedInterstitialMediaListener3.onVideoComplete();
                return;
            }
            return;
        }
        if (type == 207) {
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            UnifiedInterstitialMediaListener unifiedInterstitialMediaListener4 = this.f12806A4TApA;
            if (unifiedInterstitialMediaListener4 == null || num == null) {
                return;
            }
            unifiedInterstitialMediaListener4.onVideoError(AdErrorConvertor.formatErrorCode(num.intValue()));
            return;
        }
        switch (type) {
            case 100:
                if (unifiedInterstitialADListener != null) {
                    unifiedInterstitialADListener.onADReceive();
                    break;
                }
                break;
            case 101:
                if (unifiedInterstitialADListener != null) {
                    unifiedInterstitialADListener.onNoAD(AdErrorConvertor.getAdError(aDEvent));
                    break;
                }
                break;
            case 102:
                if (unifiedInterstitialADListener != null) {
                    unifiedInterstitialADListener.onADOpened();
                    break;
                }
                break;
            case 103:
                if (unifiedInterstitialADListener != null) {
                    unifiedInterstitialADListener.onADExposure();
                    break;
                }
                break;
            case 104:
                if (this.f12807A5SV6n != null && (str = (String) aDEvent.getParam(String.class)) != null) {
                    this.f12807A5SV6n.onReward(A2egSU.BI9f7h("transId", str));
                    break;
                }
                break;
            case 105:
                if (unifiedInterstitialADListener != null) {
                    unifiedInterstitialADListener.onADClicked();
                    break;
                }
                break;
            case 106:
                if (unifiedInterstitialADListener != null) {
                    unifiedInterstitialADListener.onADClosed();
                    break;
                }
                break;
            default:
                switch (type) {
                    case 209:
                        UnifiedInterstitialMediaListener unifiedInterstitialMediaListener5 = this.f12806A4TApA;
                        if (unifiedInterstitialMediaListener5 != null) {
                            unifiedInterstitialMediaListener5.onVideoInit();
                            break;
                        }
                        break;
                    case 210:
                        Integer num2 = (Integer) aDEvent.getParam(Integer.class);
                        UnifiedInterstitialMediaListener unifiedInterstitialMediaListener6 = this.f12806A4TApA;
                        if (unifiedInterstitialMediaListener6 != null && num2 != null) {
                            unifiedInterstitialMediaListener6.onVideoReady(num2.intValue());
                            break;
                        }
                        break;
                    case 211:
                        UnifiedInterstitialMediaListener unifiedInterstitialMediaListener7 = this.f12806A4TApA;
                        if (unifiedInterstitialMediaListener7 != null) {
                            unifiedInterstitialMediaListener7.onVideoLoading();
                            break;
                        }
                        break;
                    default:
                        switch (type) {
                            case 301:
                                UnifiedInterstitialMediaListener unifiedInterstitialMediaListener8 = this.f12806A4TApA;
                                if (unifiedInterstitialMediaListener8 != null) {
                                    unifiedInterstitialMediaListener8.onVideoPageOpen();
                                    break;
                                }
                                break;
                            case 302:
                                UnifiedInterstitialMediaListener unifiedInterstitialMediaListener9 = this.f12806A4TApA;
                                if (unifiedInterstitialMediaListener9 != null) {
                                    unifiedInterstitialMediaListener9.onVideoPageClose();
                                    break;
                                }
                                break;
                            case 303:
                                if (unifiedInterstitialADListener != null) {
                                    unifiedInterstitialADListener.onADLeftApplication();
                                    break;
                                }
                                break;
                            case 304:
                                NegativeFeedbackListener negativeFeedbackListener = this.f12808ADYaiT;
                                if (negativeFeedbackListener != null) {
                                    negativeFeedbackListener.onComplainSuccess();
                                    break;
                                }
                                break;
                        }
                }
        }
    }

    public void setAdRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.f12807A5SV6n = aDRewardListener;
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.f12806A4TApA = unifiedInterstitialMediaListener;
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f12808ADYaiT = negativeFeedbackListener;
    }
}
