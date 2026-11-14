package com.sigmob.sdk.splash;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.network.e;
import com.sigmob.sdk.base.utils.k;
import com.sigmob.sdk.base.utils.o;
import com.sigmob.sdk.base.utils.q;
import com.sigmob.sdk.base.utils.r;
import com.sigmob.windad.Splash.WindSplashADListener;
import com.sigmob.windad.Splash.WindSplashAdRequest;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import com.sigmob.windad.WindAds;
import java.io.File;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class f extends com.sigmob.sdk.manager.b implements h.b, e.a, e {
    private static final int f = 131073;
    private final LoadAdRequest g;
    private List<BaseAdUnit> i;
    private BaseAdUnit j;
    private BaseAdUnit k;
    private WindSplashADListener m;
    private h n;
    private int p;
    private long r;
    private int o = 0;
    private final Handler q = new Handler(Looper.getMainLooper()) { // from class: com.sigmob.sdk.splash.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == f.f && ((com.sigmob.sdk.manager.b) f.this).b == AdStatus.AdStatusLoading) {
                f.this.q.removeMessages(f.f);
                WindAdError windAdError = WindAdError.ERROR_SIGMOB_AD_TIME_OUT;
                f.this.a(windAdError.getErrorCode(), windAdError.getMessage(), f.this.g);
                f.this.a(windAdError, true);
            }
        }
    };
    private final Runnable h = new Runnable() { // from class: com.sigmob.sdk.splash.f.2
        @Override // java.lang.Runnable
        public void run() {
            f.this.p();
            if (f.this.n == null) {
                return;
            }
            if (f.this.p <= 0) {
                f.this.n.setDuration(0);
                return;
            }
            f.this.n.setDuration(f.this.p);
            f.f(f.this);
            f.this.q.postDelayed(f.this.h, 1000L);
        }
    };
    private final d l = new d(this);

    public f(WindSplashAdRequest windSplashAdRequest, WindSplashADListener windSplashADListener) {
        this.g = new LoadAdRequest(windSplashAdRequest);
        this.m = windSplashADListener;
    }

    public static /* synthetic */ int f(f fVar) {
        int i = fVar.p;
        fVar.p = i - 1;
        return i;
    }

    private Activity s() {
        Activity c = r.c(this.n);
        SigmobLogger.d(this.f13439a, "getActivity: activityFromView = " + c, new Object[0]);
        return c;
    }

    private boolean t() {
        boolean z = c() && q.b(this.l);
        SigmobLog.d("isExistCache: cached = " + z);
        if (z) {
            this.l.a((Map<String, Object>) null, this.k);
            com.sigmob.sdk.base.common.h.g().a(this.k, this);
            SigmobLog.d("isExistCache: ready");
            k(this.k);
        }
        return z;
    }

    private void u() {
        LoadAdRequest loadAdRequest;
        if (this.n == null || (loadAdRequest = this.g) == null || loadAdRequest.isDisableAutoHideAd()) {
            return;
        }
        r.a(this.n);
        this.n = null;
    }

    private void v() {
        if (this.b == AdStatus.AdStatusPlaying) {
            this.b = AdStatus.AdStatusClose;
            WindSplashADListener windSplashADListener = this.m;
            if (windSplashADListener == null) {
                return;
            }
            windSplashADListener.onSplashAdClose(this.g.getPlacementId());
        }
    }

    @Override // com.sigmob.sdk.splash.e
    public void a_() {
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_SPLASH_UNSUPPORT_RESOURCE;
        ae.a(PointCategory.PLAY, windAdError, this.k);
        a(windAdError, false);
        n();
    }

    @Override // com.sigmob.sdk.splash.e
    public void b_() {
        this.n.setDuration(0);
        if (q.b(this.m)) {
            this.m.onSplashAdSkip(this.g.getPlacementId());
        }
    }

    @Override // com.sigmob.sdk.manager.b
    public BaseAdUnit i() {
        return this.j;
    }

    @Override // com.sigmob.sdk.splash.e
    public void k() {
    }

    @Override // com.sigmob.sdk.splash.e
    public void l() {
        p();
    }

    public void m() {
        if (this.k.getSessionManager() == null) {
            new j().a(this.k);
        }
    }

    public void n() {
        if (q.b(this.l)) {
            this.l.b(this.k);
        }
        v();
        u();
        g();
        this.m = null;
        this.j = null;
        p();
        b((com.sigmob.sdk.manager.b) this);
    }

    public void o() {
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_SPLASH_UNSUPPORT_ORIENTATION;
        ae.a(PointCategory.PLAY, windAdError, this.k);
        a(windAdError, false);
        n();
    }

    public void p() {
        this.q.removeCallbacksAndMessages(null);
    }

    public String q() {
        return h(this.k);
    }

    public Map<String, BiddingResponse> r() {
        return i(this.k);
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a() {
    }

    @Override // com.sigmob.sdk.base.common.x
    public void b() {
        BaseBroadcastReceiver.a(com.sigmob.sdk.b.e(), this.k.getUuid(), IntentActions.ACTION_INTERSTITIAL_DISMISS);
    }

    @Override // com.sigmob.sdk.base.common.p
    public void c(BaseAdUnit baseAdUnit) {
        a("click", baseAdUnit);
        if (com.sigmob.sdk.base.utils.c.a(com.sigmob.sdk.base.utils.c.b(this.f13439a, baseAdUnit)) && q.b(this.m)) {
            this.m.onSplashAdClick(this.g.getPlacementId());
        }
    }

    @Override // com.sigmob.sdk.base.common.p
    public void d(BaseAdUnit baseAdUnit) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.r <= 500) {
            SigmobLogger.d(this.f13439a, "onInterstitialDismissed: unavailable callback.", new Object[0]);
            return;
        }
        this.r = currentTimeMillis;
        this.b = AdStatus.AdStatusClose;
        if (q.b(this.m)) {
            this.m.onSplashAdClose(this.g.getPlacementId());
        }
        this.q.post(new ARc23Z(3, this));
        if (o.a((CharSequence) baseAdUnit.getBid_token())) {
            a(null, 0, WindAds.CNY, 45, true, com.sigmob.sdk.base.j.SplashCloseRequest, null);
        }
    }

    @Override // com.sigmob.sdk.manager.b
    public BaseAdUnit e() {
        return (this.k == null && com.sigmob.sdk.base.utils.e.b(this.i)) ? this.i.get(0) : this.k;
    }

    @Override // com.sigmob.sdk.manager.b
    public LoadAdRequest f() {
        return this.g;
    }

    @Override // com.sigmob.sdk.manager.b
    public void g() {
        com.sigmob.sdk.base.common.h.b(this.k);
        this.k = null;
        this.i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, LoadAdRequest loadAdRequest) {
        ae.a(PointCategory.REQUEST, (String) null, i, str, (WindAdRequest) null, loadAdRequest, (BaseAdUnit) null, new com.fl.saas.base.manager.loader.ADYaiT(24));
    }

    public void b(Activity activity) {
        if (this.n == null || activity != s()) {
            return;
        }
        this.n.e();
        this.q.post(this.h);
    }

    @Override // com.sigmob.sdk.manager.b
    public boolean c() {
        try {
            if (this.k == null) {
                String c = k.c(this.g.getPlacementId());
                Object readFromCache = FileUtil.readFromCache(c);
                if ((readFromCache instanceof BaseAdUnit) && ((BaseAdUnit) readFromCache).getAd() != null) {
                    FileUtil.deleteFile(c);
                    BaseAdUnit baseAdUnit = (BaseAdUnit) readFromCache;
                    baseAdUnit.setTraceId(this.g.getTraceId());
                    baseAdUnit.setRequestSceneType(this.g.getRequest_scene_type());
                    this.k = baseAdUnit;
                    SigmobLog.d("isReady(cache): vid = " + this.k.getVid());
                }
            }
            if (this.k == null) {
                return false;
            }
            SigmobLog.d("isReady(used): vid = " + this.k.getVid());
            boolean canRead = new File(this.k.getSplashFilePath()).canRead();
            boolean isExpiredAd = this.k.isExpiredAd();
            boolean a2 = this.l.a(this.k);
            boolean z = canRead && !isExpiredAd && a2;
            SigmobLog.d("isReady: ready = " + z + ", isExist = " + canRead + ", isExpired = " + isExpiredAd + ", isValid = " + a2);
            return z;
        } catch (Exception e) {
            SigmobLog.e("isReady: error = " + e.getMessage());
            return false;
        }
    }

    @Override // com.sigmob.sdk.manager.b
    public boolean d() {
        return f(this.k);
    }

    @Override // com.sigmob.sdk.base.common.p
    public void e(BaseAdUnit baseAdUnit) {
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(int i, String str, String str2, LoadAdRequest loadAdRequest) {
        WindAdError windAdError = WindAdError.getWindAdError(i);
        if (windAdError == null) {
            windAdError = WindAdError.ERROR_SIGMOB_REQUEST;
            windAdError.setErrorMessage(i, str);
        }
        ae.a(PointCategory.RESPOND, Constants.FAIL, loadAdRequest);
        a(i, str, loadAdRequest);
        a(windAdError, true);
    }

    @Override // com.sigmob.sdk.base.common.p
    public void b(BaseAdUnit baseAdUnit) {
        a("start", baseAdUnit);
        this.b = AdStatus.AdStatusPlaying;
        m();
        com.sigmob.sdk.base.common.h.a(baseAdUnit);
        if (this.n.getDuration() > 0 && this.n.getDuration() < this.p) {
            this.p = this.n.getDuration();
        }
        if (q.b(this.n)) {
            this.n.setDuration(this.p);
            this.n.setVisibility(0);
        }
        b((com.sigmob.sdk.manager.b) this);
        if (q.b(this.m)) {
            this.m.onSplashAdShow(this.g.getPlacementId());
        }
        this.o = this.p;
        this.q.post(this.h);
    }

    public void a(Activity activity) {
        if (this.n == null || activity != s()) {
            return;
        }
        this.n.d();
        p();
    }

    @Override // com.sigmob.sdk.base.common.p
    public void b(BaseAdUnit baseAdUnit, String str) {
        com.sigmob.sdk.base.utils.i.f(this.f13439a, CtFAbx.BChYOn("onInterstitialFailed: error = ", str), new Object[0]);
        WindAdError windAdError = WindAdError.ERROR_SIGMOB_FILE_DOWNLOAD;
        windAdError.setMessage(str);
        a(windAdError, true);
        ae.a("load", windAdError, this.k);
    }

    public void a(ViewGroup viewGroup) {
        if (1 != ClientMetadata.getInstance().getOrientationInt().intValue()) {
            o();
            return;
        }
        if (viewGroup != null) {
            if (!a(viewGroup, this.k)) {
                a_();
                return;
            }
            BaseAdUnit baseAdUnit = this.k;
            this.j = baseAdUnit;
            this.l.a(baseAdUnit, (Bundle) null);
            if (q.b(this.l.c)) {
                this.p = this.l.c.l();
            }
            this.n.setDuration(this.p);
            if (this.n.c()) {
                viewGroup.addView(this.n, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
        }
        a_();
    }

    @Override // com.sigmob.sdk.base.common.h.b
    public void a(BaseAdUnit baseAdUnit) {
        SigmobLog.d("loadStart: placementId = " + h());
    }

    @Override // com.sigmob.sdk.base.common.h.b
    public void a(BaseAdUnit baseAdUnit, String str) {
        String h = h();
        if (o.b(str)) {
            StringBuilder B3GDIM2 = CtFAbx.B3GDIM("loadEnd: placementId = ", h, ", adStatus = ");
            B3GDIM2.append(this.b);
            B3GDIM2.append(", error = ");
            B3GDIM2.append(str);
            SigmobLog.e(B3GDIM2.toString());
            b(this.k, str);
            return;
        }
        if (this.b == AdStatus.AdStatusClose) {
            FileUtil.writeToCache(baseAdUnit, k.c(this.g.getPlacementId()));
        }
        int request_scene_type = this.g.getRequest_scene_type();
        SigmobLogger.d(this.f13439a, CtFAbx.ARc23Z(request_scene_type, "loadEnd: sceneType = "), new Object[0]);
        a(baseAdUnit, this.g);
        if (this.b == AdStatus.AdStatusLoading && request_scene_type == com.sigmob.sdk.base.j.NormalRequest.a()) {
            if (1 != ClientMetadata.getInstance().getOrientationInt().intValue()) {
                o();
                return;
            }
            p();
            this.b = AdStatus.AdStatusReady;
            a((com.sigmob.sdk.manager.b) this);
            WindAds.sharedAds().getHandler().post(new A4TApA(this, 1, h));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WindAdError windAdError, boolean z) {
        SigmobLogger.e(this.f13439a, "handleError: error = " + windAdError + ", isLoadError = " + z, new Object[0]);
        this.b = AdStatus.AdStatusNone;
        p();
        if (com.sigmob.sdk.manager.b.c(Integer.valueOf(this.g.getRequest_scene_type())) && q.b(this.m)) {
            String placementId = this.g.getPlacementId();
            if (z) {
                this.m.onSplashAdLoadFail(windAdError, placementId);
            } else {
                this.m.onSplashAdShowError(windAdError, placementId);
            }
        }
        if (q.b(this.l)) {
            this.l.b(this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Object obj) {
        if (obj instanceof PointEntitySigmob) {
            ((PointEntitySigmob) obj).setAdx_id(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        SigmobLog.d("loadEnd: placementId = " + str);
        WindSplashADListener windSplashADListener = this.m;
        if (windSplashADListener == null) {
            return;
        }
        windSplashADListener.onSplashAdLoadSuccess(str);
    }

    public void a(String str, int i, String str2, int i2, boolean z, com.sigmob.sdk.base.j jVar, String str3) {
        boolean a2 = com.sigmob.sdk.manager.b.a(jVar);
        this.g.setOriginVid(a2 ? this.d : "");
        this.g.setOriginPrice(a2 ? this.e : "");
        this.g.setRequest_scene_type(jVar.a());
        this.g.setBidToken(str);
        this.g.setBidFloor(i);
        this.g.setCurrency(str2);
        if (!o.b(str3)) {
            str3 = com.sigmob.sdk.manager.b.j();
        }
        this.g.setTraceId(str3);
        SigmobLog.d("loadAd: preload = " + z + ", sceneType = " + jVar.a());
        if (q.b(Boolean.valueOf(z))) {
            this.b = AdStatus.AdStatusLoading;
            if (t()) {
                return;
            }
        }
        a(this.g);
        com.sigmob.sdk.base.network.e.a(this.g, this);
        this.q.sendEmptyMessageDelayed(f, i2 * 1000);
    }

    public void a(String str, String str2) {
        a(this.k, str, str2);
    }

    @Override // com.sigmob.sdk.manager.b
    public void a(String str, String str2, com.sigmob.sdk.base.j jVar) {
        super.a(str, str2, jVar);
        if (o.b(this.g.getBidToken())) {
            return;
        }
        g();
        a(null, 0, WindAds.CNY, 45, true, jVar, null);
    }

    @Override // com.sigmob.sdk.base.network.e.a
    public void a(List<BaseAdUnit> list, LoadAdRequest loadAdRequest) {
        if (com.sigmob.sdk.base.utils.e.a(list)) {
            return;
        }
        this.i = list;
        BaseAdUnit baseAdUnit = list.get(0);
        SigmobLog.d("onSuccess(real): vid = " + baseAdUnit.getVid());
        a(list, loadAdRequest, baseAdUnit);
        a(loadAdRequest.getRequest_scene_type());
        if (q.b(this.l) && !this.l.a(baseAdUnit)) {
            a(WindAdError.ERROR_SIGMOB_INFORMATION_LOSE, true);
            return;
        }
        this.k = baseAdUnit;
        if (q.b(this.l)) {
            this.l.a((Map<String, Object>) null, baseAdUnit);
        }
        com.sigmob.sdk.base.common.h.g().a(this.k, this);
    }

    private boolean a(ViewGroup viewGroup, BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            return false;
        }
        this.n = new h(viewGroup.getContext().getApplicationContext());
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        if (width <= 0 || height <= 0) {
            ViewGroup.LayoutParams layoutParams = this.n.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
                this.n.setLayoutParams(layoutParams);
            }
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
            if (childMeasureSpec == 0) {
                childMeasureSpec = View.MeasureSpec.makeMeasureSpec(ClientMetadata.getInstance().getDisplayMetrics().widthPixels, 1073741824);
            }
            int i = layoutParams.height;
            this.n.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            width = this.n.getMeasuredWidth();
            height = this.n.getMeasuredHeight();
        }
        if (width > 0 && height > 0) {
            this.n.setAspectRatio((width * 1.0f) / height);
        }
        this.n.b();
        return this.n.a(baseAdUnit, r.d(viewGroup));
    }
}
