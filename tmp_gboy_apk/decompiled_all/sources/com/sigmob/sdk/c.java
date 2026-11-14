package com.sigmob.sdk;

import ADYaiT.CtFAbx;
import android.os.Handler;
import android.os.Looper;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.common.z;
import com.sigmob.sdk.base.m;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.sdk.base.utils.c;
import com.sigmob.sdk.base.utils.q;
import com.sigmob.sdk.manager.f;
import com.sigmob.sdk.videoAd.k;
import com.sigmob.sdk.videoAd.l;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class c<T extends f> extends m {

    /* renamed from: a, reason: collision with root package name */
    protected final Handler f13334a;
    protected int b;
    protected T c;
    protected T d;
    protected LoadAdRequest e;
    protected k f;
    protected c<T>.a g;
    private final String m;

    /* renamed from: com.sigmob.sdk.c$1, reason: invalid class name */
    public class AnonymousClass1 implements com.sigmob.sdk.videoAd.m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.sigmob.sdk.videoAd.m f13335a;

        public AnonymousClass1(com.sigmob.sdk.videoAd.m mVar) {
            this.f13335a = mVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(c.a aVar, String str, com.sigmob.sdk.videoAd.m mVar) {
            if (q.b(c.this.c)) {
                HashMap hashMap = new HashMap();
                Integer valueOf = Integer.valueOf(aVar == null ? 0 : aVar.f13215a.intValue());
                Integer valueOf2 = Integer.valueOf(aVar == null ? com.sigmob.sdk.base.utils.c.b : aVar.b.intValue());
                hashMap.put(ClickCommon.CLICK_LOSE_RATE, String.valueOf(valueOf));
                hashMap.put(ClickCommon.CLICK_CB_STATE, String.valueOf(valueOf2));
                c.this.c.a("click_callback", hashMap);
            }
            if (com.sigmob.sdk.base.utils.c.a(aVar)) {
                SigmobLog.i("onAdClicked: placementId = " + str);
                if (q.b(mVar)) {
                    mVar.onAdClicked(str);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(com.sigmob.sdk.videoAd.m mVar, String str) {
            if (q.b(mVar)) {
                mVar.onVideoAdPlayEnd(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(com.sigmob.sdk.videoAd.m mVar, String str) {
            if (q.b(mVar)) {
                mVar.onVideoAdPlayComplete(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(com.sigmob.sdk.videoAd.m mVar, String str) {
            if (q.b(c.this.c)) {
                c.this.c.a("show_callback", null);
            }
            if (q.b(mVar)) {
                mVar.onAdShow(str);
            }
        }

        @Override // com.sigmob.sdk.videoAd.m
        public void onAdClicked(String str) {
            String str2 = c.this.m;
            T t = c.this.c;
            c.this.f13334a.post(new AMqCpz(this, com.sigmob.sdk.base.utils.c.b(str2, t == null ? null : t.i()), str, this.f13335a));
        }

        @Override // com.sigmob.sdk.videoAd.m
        public void onAdClosed(String str) {
            SigmobLog.i("onAdClosed: placementId = " + str);
            ((m) c.this).h = AdStatus.AdStatusClose;
            c.this.f13334a.post(new ARc23Z(this, this.f13335a, str, 1));
        }

        @Override // com.sigmob.sdk.videoAd.m
        public void onAdShow(String str) {
            SigmobLog.i("onAdShow: placementId = " + str);
            ((m) c.this).h = AdStatus.AdStatusPlaying;
            c.this.f13334a.post(new ARc23Z(this, this.f13335a, str, 0));
        }

        @Override // com.sigmob.sdk.videoAd.m
        public void onAdShowError(WindAdError windAdError, String str) {
            SigmobLog.e("onAdShowError: error = " + windAdError.toString() + ", placementId = " + str);
            ((m) c.this).h = AdStatus.AdStatusClose;
            c.this.f13334a.post(new AMqCpz(this, this.f13335a, windAdError, str));
        }

        @Override // com.sigmob.sdk.videoAd.m
        public void onVideoAdPlayComplete(String str) {
            SigmobLog.i("onVideoAdPlayComplete: placementId = " + str);
            c.this.f13334a.post(new ASJ6gh(this.f13335a, str, 0));
        }

        @Override // com.sigmob.sdk.videoAd.m
        public void onVideoAdPlayEnd(String str) {
            SigmobLog.i("onVideoAdPlayEnd: placementId = " + str);
            c.this.f13334a.post(new ASJ6gh(this.f13335a, str, 1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(com.sigmob.sdk.videoAd.m mVar, WindAdError windAdError, String str) {
            if (q.b(mVar)) {
                mVar.onAdShowError(windAdError, str);
            }
            if (q.b(c.this.d)) {
                if (q.b(c.this.c)) {
                    c.this.c.p();
                }
                c cVar = c.this;
                cVar.c = cVar.d;
                ((m) cVar).h = AdStatus.AdStatusReady;
                c.this.d = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(com.sigmob.sdk.videoAd.m mVar, String str) {
            if (q.b(c.this.c)) {
                c.this.c.a("close_callback", null);
            }
            if (q.b(mVar)) {
                mVar.onAdClosed(str);
            }
            if (q.b(c.this.d)) {
                if (q.b(c.this.c)) {
                    c.this.c.p();
                }
                c cVar = c.this;
                cVar.c = cVar.d;
                ((m) cVar).h = AdStatus.AdStatusReady;
                c.this.d = null;
            }
        }
    }

    public class a implements k {
        private k b;

        public a(k kVar) {
            this.b = kVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(WindAdError windAdError, String str) {
            if (q.b(this.b)) {
                this.b.onAdPreLoadFail(windAdError, str);
            }
        }

        public void a() {
            this.b = null;
        }

        @Override // com.sigmob.sdk.videoAd.k
        public void onAdLoadError(WindAdError windAdError, String str) {
            SigmobLog.e("onAdLoadError: error = " + windAdError.toString() + ", placementId = " + str + ", adStatus = " + ((m) c.this).h);
            if (((m) c.this).h != AdStatus.AdStatusPlaying) {
                ((m) c.this).h = AdStatus.AdStatusNone;
            }
            c.this.f13334a.post(new AZOQYO(this, windAdError, str, 1));
        }

        @Override // com.sigmob.sdk.videoAd.k
        public void onAdLoadSuccess(String str) {
            StringBuilder B3GDIM2 = CtFAbx.B3GDIM("onAdLoadSuccess: placementId = ", str, ", adStatus = ");
            B3GDIM2.append(((m) c.this).h);
            SigmobLog.i(B3GDIM2.toString());
            if (((m) c.this).h != AdStatus.AdStatusPlaying) {
                ((m) c.this).h = AdStatus.AdStatusReady;
            }
            c.this.f13334a.post(new AYUAbz(this, str, 0));
        }

        @Override // com.sigmob.sdk.videoAd.k
        public void onAdPreLoadFail(WindAdError windAdError, String str) {
            SigmobLog.e("onAdPreLoadFail: error = " + windAdError.toString() + ", placementId = " + str + ", adStatus = " + ((m) c.this).h);
            if (((m) c.this).h != AdStatus.AdStatusPlaying) {
                ((m) c.this).h = AdStatus.AdStatusNone;
            }
            c.this.f13334a.post(new AZOQYO(this, windAdError, str, 0));
        }

        @Override // com.sigmob.sdk.videoAd.k
        public void onAdPreLoadSuccess(String str) {
            SigmobLog.i("onAdPreLoadSuccess: placementId = " + str);
            c.this.f13334a.post(new AYUAbz(this, str, 1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(WindAdError windAdError, String str) {
            if (q.b(this.b)) {
                this.b.onAdLoadError(windAdError, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            if (q.b(this.b)) {
                this.b.onAdLoadSuccess(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str) {
            if (q.b(this.b)) {
                this.b.onAdPreLoadSuccess(str);
            }
        }
    }

    public c(WindAdRequest windAdRequest, boolean z, int i) {
        super(windAdRequest, z);
        this.m = getClass().getSimpleName();
        this.f13334a = new Handler(Looper.getMainLooper());
        this.b = i;
        h.g().a(d(), windAdRequest.getAdType());
        this.c = createAdManager();
    }

    public abstract T createAdManager();

    public void destroy() {
        this.f13334a.removeCallbacksAndMessages(null);
        if (q.b(this.g)) {
            this.g.a();
            this.g = null;
        }
        this.f = null;
        if (q.b(this.c)) {
            this.c.p();
            this.c = null;
        }
        if (q.b(this.d)) {
            this.d.p();
            this.d = null;
        }
    }

    @Override // com.sigmob.sdk.base.m
    public String getEcpm() {
        T t = this.c;
        if (t == null) {
            return null;
        }
        return t.a();
    }

    public boolean isReady() {
        return f();
    }

    @Override // com.sigmob.sdk.base.m
    public boolean loadAd() {
        super.loadAd();
        return a();
    }

    public void setAdLoadListener(k kVar) {
        this.f = kVar;
    }

    public boolean show(HashMap<String, String> hashMap, com.sigmob.sdk.videoAd.m mVar) {
        return show(hashMap, mVar, null);
    }

    @Override // com.sigmob.sdk.base.m
    public boolean loadAd(String str) {
        super.loadAd(str);
        return a();
    }

    public boolean show(HashMap<String, String> hashMap, com.sigmob.sdk.videoAd.m mVar, l lVar) {
        try {
        } catch (Throwable th) {
            a(WindAdError.ERROR_SIGMOB_REQUEST, th.getMessage());
            com.bykv.vk.component.ttvideo.player.A2egSU.BJ7GGh(th, new StringBuilder("show: error = "));
        }
        if (this.e == null) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_PLACEMENTID_EMPTY;
            a(windAdError, "loadAdRequest is null.");
            if (!q.b(mVar)) {
                return false;
            }
            mVar.onAdShowError(windAdError, d());
            return false;
        }
        if (q.b(hashMap)) {
            if (hashMap.containsKey("scene_id")) {
                this.e.setAd_scene_id(hashMap.get("scene_id"));
            }
            if (hashMap.containsKey("scene_desc")) {
                this.e.setAd_scene_desc(hashMap.get("scene_desc"));
            }
        }
        if (this.b == 1) {
            a(lVar);
        }
        this.c.a(this.e, new AnonymousClass1(mVar));
        return true;
    }

    private void a(T t) {
        String j = com.sigmob.sdk.manager.b.j();
        a((z) null, j);
        t.a(this.e, j);
    }

    @Override // com.sigmob.sdk.base.m
    public Map<String, BiddingResponse> b() {
        T t = this.c;
        if (t == null) {
            return null;
        }
        return t.b();
    }

    @Override // com.sigmob.sdk.base.m
    public com.sigmob.sdk.manager.b c() {
        return this.c;
    }

    public void a(l lVar) {
    }

    @Override // com.sigmob.sdk.base.m
    public void a(WindAdError windAdError) {
        if (this.h != AdStatus.AdStatusLoading) {
            this.h = AdStatus.AdStatusNone;
        }
        if (q.b(this.f)) {
            String d = d();
            this.f.onAdPreLoadFail(windAdError, d);
            this.f.onAdLoadError(windAdError, d);
        }
    }

    public void a(WindAdError windAdError, String str) {
        PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", windAdError.getErrorCode(), str);
        SigmobError.setAdtype(String.valueOf(this.b));
        SigmobError.setPlacement_id(d());
        SigmobError.commit();
    }

    @Override // com.sigmob.sdk.base.m
    public void a(String str, String str2) {
        T t = this.c;
        if (t == null) {
            return;
        }
        t.a(str, str2);
    }

    public boolean a() {
        T t;
        String d = d();
        try {
            if (!g()) {
                return false;
            }
            if (q.b(this.g)) {
                this.g.a();
                this.g = null;
            }
            this.g = new a(this.f);
            T t2 = this.c;
            if (t2 == null) {
                this.c = createAdManager();
            } else if (t2.c() && this.h == AdStatus.AdStatusReady) {
                this.g.onAdPreLoadSuccess(d);
                this.g.onAdLoadSuccess(d);
                return true;
            }
            LoadAdRequest loadAdRequest = new LoadAdRequest(this.l);
            this.e = loadAdRequest;
            loadAdRequest.setBidToken(getBid_token());
            this.e.setBidFloor(getBidFloor());
            this.e.setCurrency(getCurrency());
            this.c.a(this.g);
            if (this.h != AdStatus.AdStatusPlaying) {
                this.h = AdStatus.AdStatusLoading;
                t = this.c;
            } else {
                if (this.d != null) {
                    if (q.b(this.f)) {
                        SigmobLog.i("onVideoAdLoadSuccess: placementId = " + d);
                        this.f.onAdLoadSuccess(d);
                    }
                    return true;
                }
                T createAdManager = createAdManager();
                this.d = createAdManager;
                createAdManager.a(this.g);
                t = this.d;
            }
            a((c<T>) t);
            return true;
        } catch (Throwable th) {
            WindAdError windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            PointEntitySigmobError SigmobError = PointEntitySigmobError.SigmobError("error", windAdError.getErrorCode(), th.getMessage());
            SigmobError.setAdtype(String.valueOf(this.b));
            SigmobError.setPlacement_id(d);
            SigmobError.commit();
            SigmobLog.e("onVideoAdLoadError: error = " + th.getMessage() + ", placementId = " + d + ", adStatus = " + this.h);
            if (q.b(this.f)) {
                this.f.onAdLoadError(windAdError, d);
            }
            return false;
        }
    }
}
