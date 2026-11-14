package com.octopus.ad.internal;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.octopus.ad.NativeAdResponse;
import com.octopus.ad.R;
import com.octopus.ad.internal.network.ServerResponse;
import com.octopus.ad.internal.network.a;
import com.octopus.ad.internal.utilities.HaoboLog;
import com.octopus.ad.internal.view.AdViewImpl;
import java.lang.ref.SoftReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class f extends s {

    /* renamed from: a, reason: collision with root package name */
    private final SoftReference<AdViewImpl> f12430a;
    private com.octopus.ad.internal.network.a b;

    public f(AdViewImpl adViewImpl) {
        com.octopus.ad.utils.b.f.c("OctopusAd_Time", "AdViewRequestManagerImpl 开始");
        this.f12430a = new SoftReference<>(adViewImpl);
    }

    @Override // com.octopus.ad.internal.e
    public void a() {
        if (d() == null) {
            HaoboLog.e(HaoboLog.baseLogTag, "Before execute request manager, you should set ad request!");
            return;
        }
        this.b = new com.octopus.ad.internal.network.a(d());
        com.octopus.ad.utils.b.f.c("OctopusAd_Time", "new AdRequestImpl");
        e();
        try {
            this.b.a(this);
            this.b.m();
            AdViewImpl adViewImpl = this.f12430a.get();
            if (adViewImpl != null) {
                adViewImpl.getAdDispatcher().c();
            }
        } catch (Exception e) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    @Override // com.octopus.ad.internal.e
    public d b() {
        AdViewImpl adViewImpl = this.f12430a.get();
        if (adViewImpl != null) {
            return adViewImpl.getAdParameters();
        }
        return null;
    }

    @Override // com.octopus.ad.internal.s
    public void c() {
        if (this.b != null) {
            this.b = null;
        }
    }

    public a.C0411a d() {
        if (this.f12430a.get() != null) {
            return this.f12430a.get().getAdRequest();
        }
        return null;
    }

    @Override // com.octopus.ad.internal.e
    public void a(int i) {
        f();
        AdViewImpl adViewImpl = this.f12430a.get();
        if (adViewImpl == null || adViewImpl.getAdDispatcher() == null) {
            return;
        }
        com.octopus.ad.utils.b.f.c("OctopusAd_Time", "send onAdFailedToLoad");
        adViewImpl.getAdDispatcher().a(i);
    }

    @Override // com.octopus.ad.internal.e
    public void a(ServerResponse serverResponse) {
        AdViewImpl adViewImpl = this.f12430a.get();
        if (adViewImpl != null) {
            if (serverResponse != null && serverResponse.t()) {
                com.octopus.ad.utils.b.f.c("OctopusAd_Time", "handleStandardAds");
                a(adViewImpl, serverResponse);
            } else {
                HaoboLog.w(HaoboLog.httpRespLogTag, HaoboLog.getString(R.string.response_no_ads));
                if (adViewImpl.getAdDispatcher() != null) {
                    adViewImpl.getAdDispatcher().a(80100);
                }
            }
        }
    }

    private void a(final AdViewImpl adViewImpl, final ServerResponse serverResponse) {
        try {
            adViewImpl.f12542a = serverResponse;
            adViewImpl.getAdParameters().a(false);
            a(new com.octopus.ad.internal.network.b() { // from class: com.octopus.ad.internal.f.1
                @Override // com.octopus.ad.internal.network.b
                public p a() {
                    return adViewImpl.getMediaType();
                }

                @Override // com.octopus.ad.internal.network.b
                public NativeAdResponse b() {
                    return null;
                }

                @Override // com.octopus.ad.internal.network.b
                public int c() {
                    return serverResponse.p();
                }

                @Override // com.octopus.ad.internal.network.b
                public String d() {
                    return serverResponse.r();
                }

                @Override // com.octopus.ad.internal.network.b
                public long e() {
                    return serverResponse.s();
                }
            });
            com.octopus.ad.internal.view.a aVar = new com.octopus.ad.internal.view.a(adViewImpl);
            aVar.a(serverResponse);
            if (serverResponse.a() != null && serverResponse.a().i() != null) {
                adViewImpl.a(serverResponse.a().i(), serverResponse.o() > 0 ? serverResponse.o() / 640.0f : 1.0f);
                adViewImpl.a(serverResponse.aj(), serverResponse.o());
            } else {
                adViewImpl.a(serverResponse.ai(), serverResponse.aj(), serverResponse.o());
            }
            com.octopus.ad.internal.view.b bVar = aVar;
            if (adViewImpl.getMediaType() != p.INTERSTITIAL) {
                bVar = aVar;
                if (adViewImpl.getMediaType() != p.FULLSCREEN) {
                    bVar = adViewImpl.getMediaType() == p.REWARD ? aVar : aVar.c();
                }
            }
            adViewImpl.getAdDispatcher().a(bVar);
        } catch (Exception e) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
            HaoboLog.e(HaoboLog.baseLogTag, "Exception initializing the view: " + e.getMessage());
            a(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL);
        }
    }

    public void a(com.octopus.ad.internal.network.b bVar) {
        f();
        AdViewImpl adViewImpl = this.f12430a.get();
        if (adViewImpl != null) {
            adViewImpl.getAdDispatcher().a(bVar);
        }
    }
}
