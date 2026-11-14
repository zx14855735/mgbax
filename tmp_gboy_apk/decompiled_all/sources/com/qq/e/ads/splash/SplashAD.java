package com.qq.e.ads.splash;

import J3FDQU.A2egSU;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.adevent.AdEventType;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class SplashAD extends LiteAbstractAD<NSPVI> implements IReward {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public volatile ViewGroup f12878B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public volatile SplashADListener f12879B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public volatile ADRewardListener f12880B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public volatile LoadAdParams f12881BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public volatile boolean f12882BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public volatile boolean f12883BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public volatile boolean f12884BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public volatile int f12885BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public volatile byte[] f12886BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public volatile ServerSideVerificationOptions f12887BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final int f12888BV3sI0;

    public class ADListenerAdapter implements ADListener {
        public ADListenerAdapter() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            if (SplashAD.this.f12879B7CMnp == null) {
                return;
            }
            int type = aDEvent.getType();
            switch (type) {
                case 100:
                    Long l = (Long) aDEvent.getParam(Long.class);
                    if (l != null) {
                        SplashAD.this.f12879B7CMnp.onADLoaded(l.longValue());
                        break;
                    }
                    break;
                case 101:
                    SplashAD.this.f12879B7CMnp.onNoAD(AdErrorConvertor.getAdError(aDEvent));
                    break;
                case 102:
                    SplashAD.this.f12879B7CMnp.onADPresent();
                    break;
                case 103:
                    SplashAD.this.f12879B7CMnp.onADExposure();
                    break;
                case 104:
                    if (SplashAD.this.f12880B9tovu != null && (str = (String) aDEvent.getParam(String.class)) != null) {
                        SplashAD.this.f12880B9tovu.onReward(A2egSU.BI9f7h("transId", str));
                        break;
                    }
                    break;
                case 105:
                    SplashAD.this.f12879B7CMnp.onADClicked();
                    break;
                case 106:
                    SplashAD.this.f12879B7CMnp.onADDismissed();
                    break;
                default:
                    switch (type) {
                        case AdEventType.AD_TICK /* 112 */:
                            Long l2 = (Long) aDEvent.getParam(Long.class);
                            if (l2 != null) {
                                SplashAD.this.f12879B7CMnp.onADTick(l2.longValue());
                                break;
                            }
                            break;
                        case AdEventType.AD_ZOOM_OUT /* 113 */:
                            if (SplashAD.this.f12879B7CMnp instanceof SplashADZoomOutListener) {
                                ((SplashADZoomOutListener) SplashAD.this.f12879B7CMnp).onZoomOut();
                                break;
                            }
                            break;
                        case AdEventType.AD_ZOOM_OUT_PLAY_FINISH /* 114 */:
                            if (SplashAD.this.f12879B7CMnp instanceof SplashADZoomOutListener) {
                                ((SplashADZoomOutListener) SplashAD.this.f12879B7CMnp).onZoomOutPlayFinish();
                                break;
                            }
                            break;
                    }
            }
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public final void A4TApA(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数有误：传入container参数为空");
            a(4001);
            return;
        }
        T t = this.f12733a;
        if (t == 0) {
            this.f12884BJ7GGh = z;
            this.f12878B4ZgIw = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.fetchFullScreenAndShowIn(viewGroup);
        } else {
            nspvi.fetchAndShowIn(viewGroup);
        }
    }

    public final void A5SV6n(boolean z) {
        if (a()) {
            if (!b()) {
                this.f12884BJ7GGh = z;
                this.f12883BIYEnU = true;
                return;
            }
            T t = this.f12733a;
            if (t == 0) {
                a("fetchAdInner");
                return;
            }
            NSPVI nspvi = (NSPVI) t;
            if (z) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
        }
    }

    public final void ADYaiT(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数错误，container参数为空");
            a(4001);
            return;
        }
        T t = this.f12733a;
        if (t == 0) {
            this.f12878B4ZgIw = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.showFullScreenAd(viewGroup);
        } else {
            nspvi.showAd(viewGroup);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NSPVI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    public void fetchAdOnly() {
        A5SV6n(false);
    }

    public void fetchFullScreenAdOnly() {
        A5SV6n(true);
    }

    public String getAdNetWorkName() {
        T t = this.f12733a;
        if (t != 0) {
            return ((NSPVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public Bitmap getZoomOutBitmap() {
        T t = this.f12733a;
        if (t != 0) {
            return ((NSPVI) t).getZoomOutBitmap();
        }
        a("getZoomOutBitmap");
        return null;
    }

    public void preLoad() {
        if (a()) {
            if (!b()) {
                this.f12882BI9f7h = true;
                return;
            }
            T t = this.f12733a;
            if (t != 0) {
                ((NSPVI) t).preload();
            } else {
                a("preLoad");
            }
        }
    }

    @Deprecated
    public void setAdLogoMargin(int i, int i2) {
    }

    public void setDeveloperLogo(int i) {
        T t = this.f12733a;
        if (t == 0) {
            this.f12885BNL6CD = i;
        } else {
            ((NSPVI) t).setDeveloperLogo(i);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        T t = this.f12733a;
        if (t != 0) {
            ((NSPVI) t).setLoadAdParams(loadAdParams);
        } else {
            this.f12881BChYOn = loadAdParams;
        }
    }

    @Deprecated
    public void setPreloadView(View view) {
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f12880B9tovu = aDRewardListener;
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f12887BTvldC = serverSideVerificationOptions;
        T t = this.f12733a;
        if (t != 0) {
            ((NSPVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAd(ViewGroup viewGroup) {
        ADYaiT(viewGroup, false);
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        ADYaiT(viewGroup, true);
    }

    public void zoomOutAnimationFinish() {
        T t = this.f12733a;
        if (t != 0) {
            ((NSPVI) t).zoomOutAnimationFinish();
        } else {
            a("zoomOutAnimationFinish");
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i) {
        this.f12882BI9f7h = false;
        this.f12879B7CMnp = splashADListener;
        this.f12888BV3sI0 = i;
        a(context, str);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(NSPVI nspvi) {
        if (this.f12881BChYOn != null) {
            nspvi.setLoadAdParams(this.f12881BChYOn);
        }
        if (this.f12885BNL6CD != 0) {
            nspvi.setDeveloperLogo(this.f12885BNL6CD);
        }
        if (this.f12886BPw6Q8 != null) {
            nspvi.setDeveloperLogo(this.f12886BPw6Q8);
        }
        nspvi.setFetchDelay(this.f12888BV3sI0);
        nspvi.setAdListener(new ADListenerAdapter());
        nspvi.setServerSideVerificationOptions(this.f12887BTvldC);
        if ((this.f12879B7CMnp instanceof SplashADZoomOutListener) && ((SplashADZoomOutListener) this.f12879B7CMnp).isSupportZoomOut()) {
            nspvi.setSupportZoomOut(true);
        }
        if (this.f12878B4ZgIw != null) {
            if (this.f12884BJ7GGh) {
                A4TApA(this.f12878B4ZgIw, true);
            } else {
                A4TApA(this.f12878B4ZgIw, false);
            }
        }
        if (this.f12882BI9f7h) {
            nspvi.preload();
            this.f12882BI9f7h = false;
        }
        if (this.f12883BIYEnU) {
            if (this.f12884BJ7GGh) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.f12883BIYEnU = false;
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        if (this.f12879B7CMnp != null) {
            this.f12879B7CMnp.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        T t = this.f12733a;
        if (t == 0) {
            this.f12886BPw6Q8 = bArr;
        } else {
            ((NSPVI) t).setDeveloperLogo(bArr);
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i, String str2) {
        this.f12882BI9f7h = false;
        this.f12879B7CMnp = splashADListener;
        this.f12888BV3sI0 = i;
        a(context, str, str2);
    }
}
