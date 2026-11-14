package com.qq.e.ads.interstitial2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class UnifiedInterstitialAD extends LiteAbstractAD<UIADI> implements NFBI, IReward {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final AtomicInteger f12809B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final AtomicInteger f12810B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public volatile VideoOption f12811B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public volatile int f12812BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public volatile int f12813BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public volatile LoadAdParams f12814BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final UnifiedInterstitialADListener f12815BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public ServerSideVerificationOptions f12816BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final ADListenerAdapter f12817BPw6Q8;

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, null);
    }

    @Override // com.qq.e.ads.AbstractAD
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public UIADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedInterstitialADDelegate((Activity) context, str, str2, str3, this.f12817BPw6Q8);
    }

    public void close() {
        T t = this.f12733a;
        if (t != 0) {
            ((UIADI) t).close();
        }
    }

    public void destroy() {
        T t = this.f12733a;
        if (t != 0) {
            ((UIADI) t).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t = this.f12733a;
        if (t != 0) {
            return ((UIADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        T t = this.f12733a;
        if (t != 0) {
            return ((UIADI) t).getAdPatternType();
        }
        a("getAdPatternType");
        return 0;
    }

    public int getVideoDuration() {
        T t = this.f12733a;
        if (t != 0) {
            return ((UIADI) t).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f12809B4ZgIw.incrementAndGet();
                return;
            }
            T t = this.f12733a;
            if (t != 0) {
                ((UIADI) t).loadAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void loadFullScreenAD() {
        if (a()) {
            if (!b()) {
                this.f12810B7CMnp.incrementAndGet();
                return;
            }
            T t = this.f12733a;
            if (t != 0) {
                ((UIADI) t).loadFullScreenAD();
            } else {
                a("loadFullScreenAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f12814BIYEnU = loadAdParams;
        T t = this.f12733a;
        if (t != 0) {
            ((UIADI) t).setLoadAdParams(this.f12814BIYEnU);
        }
    }

    public void setMaxVideoDuration(int i) {
        this.f12813BI9f7h = i;
        if (this.f12813BI9f7h > 0 && this.f12812BChYOn > this.f12813BI9f7h) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.f12733a;
        if (t != 0) {
            ((UIADI) t).setMaxVideoDuration(i);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.f12817BPw6Q8.setMediaListener(unifiedInterstitialMediaListener);
    }

    public void setMinVideoDuration(int i) {
        this.f12812BChYOn = i;
        if (this.f12813BI9f7h > 0 && this.f12812BChYOn > this.f12813BI9f7h) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.f12733a;
        if (t != 0) {
            ((UIADI) t).setMinVideoDuration(i);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f12817BPw6Q8.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.f12817BPw6Q8.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f12816BNL6CD = serverSideVerificationOptions;
        T t = this.f12733a;
        if (t != 0) {
            ((UIADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f12811B9tovu = videoOption;
        T t = this.f12733a;
        if (t != 0) {
            ((UIADI) t).setVideoOption(videoOption);
        }
    }

    public void show() {
        T t = this.f12733a;
        if (t != 0) {
            ((UIADI) t).show();
        } else {
            a("show");
        }
    }

    public void showFullScreenAD(Activity activity) {
        T t = this.f12733a;
        if (t != 0) {
            ((UIADI) t).showFullScreenAD(activity);
        } else {
            a("showFullScreenAD");
        }
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.f12809B4ZgIw = new AtomicInteger(0);
        this.f12810B7CMnp = new AtomicInteger(0);
        this.f12815BJ7GGh = unifiedInterstitialADListener;
        this.f12817BPw6Q8 = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(UIADI uiadi) {
        setVideoOption(this.f12811B9tovu);
        setMinVideoDuration(this.f12812BChYOn);
        setMaxVideoDuration(this.f12813BI9f7h);
        setLoadAdParams(this.f12814BIYEnU);
        setServerSideVerificationOptions(this.f12816BNL6CD);
        while (this.f12809B4ZgIw.getAndDecrement() > 0) {
            loadAD();
        }
        while (this.f12810B7CMnp.getAndDecrement() > 0) {
            loadFullScreenAD();
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        UnifiedInterstitialADListener unifiedInterstitialADListener = this.f12815BJ7GGh;
        if (unifiedInterstitialADListener != null) {
            unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public void show(Activity activity) {
        T t = this.f12733a;
        if (t != 0) {
            ((UIADI) t).show(activity);
        } else {
            a("show");
        }
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map, String str2) {
        this.f12809B4ZgIw = new AtomicInteger(0);
        this.f12810B7CMnp = new AtomicInteger(0);
        this.f12815BJ7GGh = unifiedInterstitialADListener;
        this.f12817BPw6Q8 = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str, str2);
    }
}
