package com.qq.e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class UnifiedBannerAD extends LiteAbstractAD<UBVI> implements NFBI, IReward {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final UnifiedBannerADListener f12747B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final AtomicInteger f12748B7CMnp = new AtomicInteger(0);

    /* renamed from: B9tovu, reason: collision with root package name */
    public int f12749B9tovu = 30;

    /* renamed from: BChYOn, reason: collision with root package name */
    public LoadAdParams f12750BChYOn = null;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final UnifiedBannerView f12751BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final ADListenerAdapter f12752BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public volatile ServerSideVerificationOptions f12753BJ7GGh;

    public UnifiedBannerAD(UnifiedBannerView unifiedBannerView, UnifiedBannerADListener unifiedBannerADListener) {
        this.f12747B4ZgIw = unifiedBannerADListener;
        this.f12751BI9f7h = unifiedBannerView;
        this.f12752BIYEnU = new ADListenerAdapter(unifiedBannerADListener);
    }

    public final void A4TApA(int i) {
        this.f12749B9tovu = i;
        T t = this.f12733a;
        if (t != 0) {
            ((UBVI) t).setRefresh(i);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public UBVI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        ADListenerAdapter aDListenerAdapter = this.f12752BIYEnU;
        return pOFactory.getUnifiedBannerViewDelegate(this.f12751BI9f7h, (Activity) context, str, str2, str3, aDListenerAdapter);
    }

    public final void destroy() {
        T t = this.f12733a;
        if (t != 0) {
            ((UBVI) t).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t = this.f12733a;
        if (t != 0) {
            return ((UBVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public final void loadAD() {
        if (a()) {
            if (!b()) {
                this.f12748B7CMnp.incrementAndGet();
                return;
            }
            T t = this.f12733a;
            if (t != 0) {
                ((UBVI) t).fetchAd();
            } else {
                a("loadAD");
            }
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        T t = this.f12733a;
        if (t != 0) {
            ((UBVI) t).onWindowFocusChanged(z);
        }
    }

    public final void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f12750BChYOn = loadAdParams;
        T t = this.f12733a;
        if (t != 0) {
            ((UBVI) t).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f12752BIYEnU.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f12752BIYEnU.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f12753BJ7GGh = serverSideVerificationOptions;
        T t = this.f12733a;
        if (t != 0) {
            ((UBVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(UBVI ubvi) {
        A4TApA(this.f12749B9tovu);
        setLoadAdParams(this.f12750BChYOn);
        ubvi.setServerSideVerificationOptions(this.f12753BJ7GGh);
        while (this.f12748B7CMnp.getAndDecrement() > 0) {
            loadAD();
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        UnifiedBannerADListener unifiedBannerADListener = this.f12747B4ZgIw;
        if (unifiedBannerADListener != null) {
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }
}
