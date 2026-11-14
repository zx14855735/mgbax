package com.sigmob.windad.Splash;

import ADYaiT.BChYOn;
import CtFAbx.A2egSU;
import QFcQI0.A4TApA;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.AdStatus;
import com.czhj.sdk.common.utils.AdLifecycleManager;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.z;
import com.sigmob.sdk.base.j;
import com.sigmob.sdk.base.m;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.utils.q;
import com.sigmob.sdk.base.utils.r;
import com.sigmob.sdk.manager.b;
import com.sigmob.sdk.splash.f;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class WindSplashAD extends m implements AdLifecycleManager.LifecycleListener, WindSplashADListener {

    /* renamed from: a, reason: collision with root package name */
    private WindSplashADListener f13779a;
    private ViewGroup b;
    private final int c;
    private RelativeLayout d;
    private final boolean e;
    private boolean f;
    private boolean g;
    private final f m;
    private final Handler n;

    public WindSplashAD(WindSplashAdRequest windSplashAdRequest, WindSplashADListener windSplashADListener) {
        super(windSplashAdRequest, false);
        this.f = false;
        this.n = new Handler(Looper.getMainLooper());
        this.f13779a = windSplashADListener;
        this.m = new f(windSplashAdRequest, this);
        this.c = windSplashAdRequest.getFetchDelay();
        this.e = windSplashAdRequest.isDisableAutoHideAd();
    }

    private void a() {
        if (this.b == null) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.b.getContext());
        this.d = relativeLayout;
        relativeLayout.setVisibility(4);
        this.d.setId(ClientMetadata.generateViewId());
        this.b.addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(WindAdError windAdError, String str) {
        WindSplashADListener windSplashADListener = this.f13779a;
        if (windSplashADListener == null) {
            return;
        }
        this.f = true;
        windSplashADListener.onSplashAdLoadFail(windAdError, str);
    }

    private void h() {
        if (this.m == null) {
            a(WindAdError.ERROR_SIGMOB_SPLASH_NOT_READY, d());
            return;
        }
        a();
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        this.n.post(new A2egSU(13, this));
        this.h = AdStatus.AdStatusPlaying;
    }

    private boolean i() {
        if (this.m.c() && this.h == AdStatus.AdStatusReady) {
            SigmobLog.i("load: ready");
            return true;
        }
        if (!g()) {
            return false;
        }
        AdLifecycleManager.getInstance().addLifecycleListener(this);
        this.h = AdStatus.AdStatusLoading;
        String j = b.j();
        a((z) null, j);
        this.m.a(getBid_token(), getBidFloor(), getCurrency(), this.c, false, j.NormalRequest, j);
        return true;
    }

    private void j() {
        Activity c;
        ViewGroup viewGroup = this.b;
        if (viewGroup == null || (c = r.c(viewGroup)) == null) {
            return;
        }
        Window window = c.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.systemUiVisibility = 2050;
        window.setAttributes(attributes);
        window.addFlags(1024);
    }

    private void k() {
        if (this.e) {
            return;
        }
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
            this.d.removeAllViews();
            this.d = null;
        }
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        this.m.a((ViewGroup) this.d);
    }

    @Override // com.sigmob.sdk.base.m
    public Map<String, BiddingResponse> b() {
        f fVar = this.m;
        if (fVar == null) {
            return null;
        }
        return fVar.r();
    }

    @Override // com.sigmob.sdk.base.m
    public b c() {
        return this.m;
    }

    public void destroy() {
        WindAdRequest windAdRequest = this.l;
        SigmobLog.i("splash ad " + (windAdRequest != null ? windAdRequest.getPlacementId() : "null") + " is Destroy");
        f fVar = this.m;
        if (fVar != null) {
            fVar.n();
            this.n.removeCallbacksAndMessages(null);
            this.f13779a = null;
            this.b = null;
        }
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null && !this.e) {
            relativeLayout.setVisibility(8);
            this.d.removeAllViews();
        }
        this.d = null;
    }

    @Override // com.sigmob.sdk.base.m
    public String getEcpm() {
        f fVar = this.m;
        if (fVar == null) {
            return null;
        }
        return fVar.q();
    }

    public boolean isReady() {
        return f();
    }

    @Override // com.sigmob.sdk.base.m
    public boolean loadAd() {
        this.g = false;
        super.loadAd();
        return i();
    }

    public void loadAndShow(ViewGroup viewGroup) {
        if (viewGroup == null) {
            a(WindAdError.ERROR_SIGMOB_ADCONTAINER_IS_NULL);
            return;
        }
        super.loadAd();
        this.b = viewGroup;
        this.g = true;
        i();
    }

    @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
    public void onCreate(Activity activity) {
    }

    @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
    public void onDestroy(Activity activity) {
    }

    @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
    public void onPause(Activity activity) {
        f fVar = this.m;
        if (fVar == null) {
            return;
        }
        fVar.a(activity);
    }

    @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
    public void onResume(Activity activity) {
        f fVar = this.m;
        if (fVar == null) {
            return;
        }
        fVar.b(activity);
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdClick(String str) {
        WindSplashADListener windSplashADListener = this.f13779a;
        if (windSplashADListener == null) {
            return;
        }
        windSplashADListener.onSplashAdClick(str);
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdClose(String str) {
        this.h = AdStatus.AdStatusClose;
        this.n.post(new A4TApA(this, str, 0));
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdLoadFail(WindAdError windAdError, String str) {
        this.h = AdStatus.AdStatusNone;
        this.n.post(new QFcQI0.A2egSU(this, windAdError, str, 1));
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdLoadSuccess(String str) {
        this.h = AdStatus.AdStatusReady;
        this.n.post(new A4TApA(this, str, 1));
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdShow(String str) {
        WindSplashADListener windSplashADListener = this.f13779a;
        if (windSplashADListener == null) {
            return;
        }
        windSplashADListener.onSplashAdShow(str);
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdShowError(WindAdError windAdError, String str) {
        this.h = AdStatus.AdStatusNone;
        b bVar = this.m;
        bVar.b(bVar);
        this.n.post(new QFcQI0.A2egSU(this, windAdError, str, 0));
    }

    @Override // com.sigmob.windad.Splash.WindSplashADListener
    public void onSplashAdSkip(String str) {
        this.n.post(new A4TApA(this, str, 2));
    }

    @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
    public void onStart(Activity activity) {
    }

    @Override // com.czhj.sdk.common.utils.AdLifecycleManager.LifecycleListener
    public void onStop(Activity activity) {
    }

    public void show(ViewGroup viewGroup) {
        f fVar;
        if (this.g || (fVar = this.m) == null) {
            if (q.b(this.m)) {
                b bVar = this.m;
                bVar.b(bVar);
            }
            a(WindAdError.ERROR_SIGMOB_SPLASH_NOT_READY, d());
            return;
        }
        if (fVar.d()) {
            onSplashAdShowError(WindAdError.ERROR_SIGMOB_EXPIRED, d());
            return;
        }
        if (!isReady()) {
            b bVar2 = this.m;
            bVar2.b(bVar2);
            a(WindAdError.ERROR_SIGMOB_SPLASH_NOT_READY, d());
        } else if (viewGroup == null) {
            onSplashAdShowError(WindAdError.ERROR_SIGMOB_ADCONTAINER_IS_NULL, d());
        } else {
            this.b = viewGroup;
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(WindAdError windAdError) {
        WindSplashADListener windSplashADListener = this.f13779a;
        if (windSplashADListener == null) {
            return;
        }
        windSplashADListener.onSplashAdLoadFail(windAdError, d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(WindAdError windAdError, String str) {
        WindSplashADListener windSplashADListener = this.f13779a;
        if (windSplashADListener == null) {
            return;
        }
        windSplashADListener.onSplashAdLoadFail(windAdError, str);
    }

    @Override // com.sigmob.sdk.base.m
    public void a(WindAdError windAdError) {
        this.h = AdStatus.AdStatusNone;
        this.n.post(new BChYOn(this, 14, windAdError));
    }

    @Override // com.sigmob.sdk.base.m
    public boolean loadAd(String str) {
        super.loadAd(str);
        return i();
    }

    public void loadAndShow(String str, ViewGroup viewGroup) {
        if (viewGroup == null) {
            a(WindAdError.ERROR_SIGMOB_ADCONTAINER_IS_NULL);
            return;
        }
        super.loadAd(str);
        this.b = viewGroup;
        this.g = true;
        i();
    }

    private void a(WindAdError windAdError, String str) {
        SigmobLog.e("onSplashError: error = " + windAdError + ", placementId = " + str);
        if (this.f) {
            return;
        }
        this.n.removeMessages(1);
        this.n.post(new QFcQI0.A2egSU(this, windAdError, str, 2));
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(WindAdError windAdError, String str) {
        WindSplashADListener windSplashADListener = this.f13779a;
        if (windSplashADListener == null) {
            return;
        }
        windSplashADListener.onSplashAdShowError(windAdError, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        WindSplashADListener windSplashADListener = this.f13779a;
        if (windSplashADListener != null) {
            windSplashADListener.onSplashAdLoadSuccess(str);
        }
        if (this.g) {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        WindSplashADListener windSplashADListener = this.f13779a;
        if (windSplashADListener == null) {
            return;
        }
        windSplashADListener.onSplashAdSkip(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        WindSplashADListener windSplashADListener = this.f13779a;
        if (windSplashADListener == null) {
            return;
        }
        windSplashADListener.onSplashAdClose(str);
        k();
    }

    @Override // com.sigmob.sdk.base.m
    public void a(String str, String str2) {
        f fVar = this.m;
        if (fVar == null) {
            return;
        }
        fVar.a(str, str2);
    }
}
