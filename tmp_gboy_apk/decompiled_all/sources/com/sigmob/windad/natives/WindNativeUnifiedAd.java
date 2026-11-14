package com.sigmob.windad.natives;

import android.os.Handler;
import android.os.Looper;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.z;
import com.sigmob.sdk.base.m;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.manager.b;
import com.sigmob.sdk.nativead.aa;
import com.sigmob.sdk.nativead.y;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.natives.WindNativeUnifiedAd;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class WindNativeUnifiedAd extends m {

    /* renamed from: a, reason: collision with root package name */
    private WindNativeAdLoadListener f13794a;
    private final Handler b;
    private final y c;

    /* renamed from: com.sigmob.windad.natives.WindNativeUnifiedAd$1, reason: invalid class name */
    public class AnonymousClass1 implements aa {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WindNativeAdRequest f13795a;

        public AnonymousClass1(WindNativeAdRequest windNativeAdRequest) {
            this.f13795a = windNativeAdRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i, String str, WindNativeAdRequest windNativeAdRequest) {
            if (WindNativeUnifiedAd.this.f13794a == null) {
                return;
            }
            WindAdError windAdError = WindAdError.getWindAdError(i);
            if (windAdError == null) {
                windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
                windAdError.setErrorMessage(i, str);
                windAdError.setMessage(str);
            }
            WindNativeUnifiedAd.this.f13794a.onAdError(windAdError, windNativeAdRequest.getPlacementId());
        }

        @Override // com.sigmob.sdk.nativead.aa
        public void onNativeAdLoadFail(final int i, final String str) {
            ((m) WindNativeUnifiedAd.this).h = AdStatus.AdStatusNone;
            Handler handler = WindNativeUnifiedAd.this.b;
            final WindNativeAdRequest windNativeAdRequest = this.f13795a;
            handler.post(new Runnable() { // from class: com.sigmob.windad.natives.A4TApA
                @Override // java.lang.Runnable
                public final void run() {
                    WindNativeUnifiedAd.AnonymousClass1.this.a(i, str, windNativeAdRequest);
                }
            });
        }

        @Override // com.sigmob.sdk.nativead.aa
        public void onNativeAdLoaded(List<WindNativeAdData> list) {
            ((m) WindNativeUnifiedAd.this).h = AdStatus.AdStatusNone;
            WindNativeUnifiedAd.this.b.post(new A2egSU(this, 0, list));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(List list) {
            if (WindNativeUnifiedAd.this.f13794a == null) {
                return;
            }
            WindNativeUnifiedAd.this.f13794a.onAdLoad(list, WindNativeUnifiedAd.this.d());
        }
    }

    public interface WindNativeAdLoadListener {
        void onAdError(WindAdError windAdError, String str);

        void onAdLoad(List<WindNativeAdData> list, String str);
    }

    public WindNativeUnifiedAd(WindNativeAdRequest windNativeAdRequest) {
        super(windNativeAdRequest, false);
        this.b = new Handler(Looper.getMainLooper());
        this.c = new y(windNativeAdRequest, new AnonymousClass1(windNativeAdRequest));
    }

    @Override // com.sigmob.sdk.base.m
    public b c() {
        return null;
    }

    public void destroy() {
        WindAdRequest windAdRequest = this.l;
        SigmobLog.i("native ad " + (windAdRequest != null ? windAdRequest.getPlacementId() : "null") + " is Destroy");
        this.f13794a = null;
    }

    @Override // com.sigmob.sdk.base.m
    public String getEcpm() {
        y yVar = this.c;
        if (yVar == null) {
            return null;
        }
        return yVar.a();
    }

    @Override // com.sigmob.sdk.base.m
    @Deprecated
    public boolean loadAd() {
        try {
            super.loadAd();
            return a(this.l.getAdCount());
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    public void setNativeAdLoadListener(WindNativeAdLoadListener windNativeAdLoadListener) {
        this.f13794a = windNativeAdLoadListener;
    }

    public boolean loadAd(int i) {
        try {
            super.loadAd();
            int max = Math.max(this.l.getAdCount(), i);
            this.l.setAdCount(max);
            return a(max);
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    @Override // com.sigmob.sdk.base.m
    public void a(WindAdError windAdError) {
        this.b.post(new A2egSU(this, 1, windAdError));
    }

    @Override // com.sigmob.sdk.base.m
    public Map<String, BiddingResponse> b() {
        y yVar = this.c;
        if (yVar == null) {
            return null;
        }
        return yVar.b();
    }

    @Override // com.sigmob.sdk.base.m
    public boolean loadAd(String str) {
        try {
            super.loadAd(str);
            return a(this.l.getAdCount() > 0 ? this.l.getAdCount() : 1);
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(WindAdError windAdError) {
        this.h = AdStatus.AdStatusNone;
        if (this.f13794a == null) {
            return;
        }
        SigmobLog.i("onVideoAdLoadFail " + windAdError.toString() + "|" + d());
        this.f13794a.onAdError(windAdError, d());
    }

    @Override // com.sigmob.sdk.base.m
    public void a(String str, String str2) {
        y yVar = this.c;
        if (yVar == null) {
            return;
        }
        yVar.a(str, str2);
    }

    public boolean loadAd(String str, int i) {
        try {
            super.loadAd(str);
            return a(i);
        } catch (Throwable th) {
            a(th);
            return false;
        }
    }

    private void a(Throwable th) {
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
        PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", windAdError.getErrorCode(), th.getMessage());
        SigmobError.setAdtype(String.valueOf(5));
        SigmobError.setPlacement_id(d());
        SigmobError.commit();
        a(windAdError);
    }

    private boolean a(int i) {
        try {
            if (!g()) {
                return false;
            }
            String j = b.j();
            this.h = AdStatus.AdStatusLoading;
            if (this.c.a(i, getBid_token(), getBidFloor(), getCurrency(), j) == 1) {
                a(z.a(d()), j);
            }
            return true;
        } catch (Throwable th) {
            SigmobLog.i(getClass().getSimpleName() + " catch throwable " + th);
            if (this.f13794a == null) {
                return false;
            }
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            windAdError.setMessage(th.getMessage());
            this.f13794a.onAdError(windAdError, d());
            return false;
        }
    }
}
