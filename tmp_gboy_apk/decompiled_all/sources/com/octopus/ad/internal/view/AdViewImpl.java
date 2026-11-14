package com.octopus.ad.internal.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bykv.vk.component.ttvideo.player.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import com.octopus.ad.AdActivity;
import com.octopus.ad.AdLifeControl;
import com.octopus.ad.FullScreenVideoAdListener;
import com.octopus.ad.IBidding;
import com.octopus.ad.InterstitialAdListener;
import com.octopus.ad.Octopus;
import com.octopus.ad.OnSensorListener;
import com.octopus.ad.R;
import com.octopus.ad.RewardVideoAdListener;
import com.octopus.ad.SplashAdListener;
import com.octopus.ad.internal.a.h;
import com.octopus.ad.internal.activity.EndingPageActivity;
import com.octopus.ad.internal.activity.StopoverDialogActivity;
import com.octopus.ad.internal.k;
import com.octopus.ad.internal.network.ServerResponse;
import com.octopus.ad.internal.network.a;
import com.octopus.ad.internal.o;
import com.octopus.ad.internal.p;
import com.octopus.ad.internal.q;
import com.octopus.ad.internal.t;
import com.octopus.ad.internal.utilities.HTTPGet;
import com.octopus.ad.internal.utilities.HaoboLog;
import com.octopus.ad.internal.utilities.StringUtil;
import com.octopus.ad.internal.utilities.UrlUtil;
import com.octopus.ad.internal.utilities.ViewUtil;
import com.octopus.ad.internal.v;
import com.octopus.ad.internal.video.AdVideoView;
import com.octopus.ad.internal.video.VideoStateListener;
import com.octopus.ad.model.ComplianceInfo;
import com.octopus.ad.model.ShakeValue;
import com.octopus.ad.model.c;
import com.octopus.ad.utils.ThreadUtils;
import com.octopus.ad.utils.b.f;
import com.octopus.ad.utils.i;
import com.octopus.ad.utils.j;
import com.octopus.ad.utils.k;
import com.octopus.ad.utils.l;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class AdViewImpl extends FrameLayout implements ViewTreeObserver.OnGlobalLayoutListener, AdLifeControl, IBidding, com.octopus.ad.internal.a {
    private RewardVideoAdListener A;
    private com.octopus.ad.model.a B;
    private final Handler C;
    private b D;
    private com.octopus.ad.internal.a.b E;
    private h F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private AppCompatTextView M;
    private AppCompatTextView N;
    private ImageView O;
    private com.octopus.ad.a.a P;
    private com.octopus.ad.a.a Q;
    private AppCompatImageView R;
    private AppCompatTextView S;
    private ProgressBar T;
    private FrameLayout U;
    private FrameLayout V;
    private LinearLayout W;

    /* renamed from: a, reason: collision with root package name */
    public ServerResponse f12542a;
    private String aA;
    private String aB;
    private String aC;
    private String aD;
    private Pair<String, Integer> aE;
    private boolean aF;
    private boolean aG;
    private boolean aH;
    private int aI;
    private l aJ;
    private k aK;
    private j aL;
    private OnSensorListener aM;
    private VideoStateListener aN;
    private k.a aO;
    private k.a aP;
    private final c aQ;
    private boolean aR;
    private int aa;
    private String ab;
    private String ac;
    private String ad;
    private int ae;
    private int af;
    private int ag;
    private long ah;
    private long ai;
    private boolean aj;
    private boolean ak;
    private boolean al;
    private boolean am;
    private boolean an;
    private boolean ao;
    private boolean ap;
    private boolean aq;
    private Boolean ar;
    private boolean as;
    private int at;
    private AdVideoView au;
    private com.octopus.ad.internal.view.a av;
    private boolean aw;
    private boolean ax;
    private boolean ay;
    private ViewGroup az;
    protected a b;
    protected com.octopus.ad.internal.view.b c;
    protected com.octopus.ad.internal.d d;
    protected a.C0411a e;
    public com.octopus.ad.internal.c f;
    protected p g;
    protected boolean h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    protected boolean o;
    protected boolean p;
    protected boolean q;
    protected boolean r;
    protected Context s;
    private ViewGroup t;
    private int u;
    private int v;
    private float w;
    private SplashAdListener x;
    private InterstitialAdListener y;
    private FullScreenVideoAdListener z;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public EnumC0417a f12578a = EnumC0417a.UNCHANGE;
        public boolean b = false;

        /* renamed from: com.octopus.ad.internal.view.AdViewImpl$a$a, reason: collision with other inner class name */
        public enum EnumC0417a {
            UNCHANGE,
            STATE_PREPARE_CHANGE,
            STATE_BACKGROUND,
            FINISHCLOSE;

            static {
                uaIoy();
            }

            private static /* synthetic */ void uaIoy() {
                char[] charArray = "l`b!hnbj!m`v!|gjcc!EafM}fkhj".toCharArray();
                int length = charArray.length;
                for (int i = 0; i < length; i++) {
                    charArray[i] = (char) (charArray[i] ^ 15);
                }
                String str = new String(charArray);
                char[] charArray2 = "lcfaf{".toCharArray();
                int length2 = charArray2.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    charArray2[i2] = (char) (charArray2[i2] ^ 15);
                }
                Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[0]);
            }
        }

        public boolean a() {
            return this.b;
        }

        public void b() {
            this.f12578a = EnumC0417a.UNCHANGE;
        }

        public EnumC0417a c() {
            return this.f12578a;
        }

        public void a(boolean z) {
            this.b = z;
        }

        public synchronized void a(EnumC0417a enumC0417a) {
            try {
                EnumC0417a enumC0417a2 = EnumC0417a.STATE_PREPARE_CHANGE;
                if (enumC0417a == enumC0417a2 && this.f12578a == EnumC0417a.UNCHANGE) {
                    this.f12578a = enumC0417a2;
                }
                EnumC0417a enumC0417a3 = EnumC0417a.STATE_BACKGROUND;
                if (enumC0417a == enumC0417a3 && this.f12578a == enumC0417a2) {
                    this.f12578a = enumC0417a3;
                }
                EnumC0417a enumC0417a4 = EnumC0417a.FINISHCLOSE;
                if (enumC0417a == enumC0417a4 && this.f12578a == enumC0417a3 && this.b) {
                    this.f12578a = enumC0417a4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public class b implements com.octopus.ad.internal.b {
        private final Handler b;
        private com.octopus.ad.internal.network.b c;

        public b(Handler handler) {
            this.b = handler;
        }

        @Override // com.octopus.ad.internal.b
        public void b() {
            this.b.post(new Runnable() { // from class: com.octopus.ad.internal.view.AdViewImpl.b.4
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl.this.b.a(a.EnumC0417a.STATE_PREPARE_CHANGE);
                    boolean z = Boolean.TRUE == AdViewImpl.this.ar || !(Boolean.FALSE == AdViewImpl.this.ar || AdViewImpl.this.ao || AdViewImpl.this.as || AdViewImpl.this.al);
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    ServerResponse serverResponse = adViewImpl.f12542a;
                    if (serverResponse != null) {
                        serverResponse.b(adViewImpl.I && z);
                    }
                    if (AdViewImpl.this.I && z) {
                        if (AdViewImpl.this.x != null) {
                            AdViewImpl.this.x.onAdClicked();
                            return;
                        }
                        if (AdViewImpl.this.y != null) {
                            AdViewImpl.this.y.onAdClicked();
                        } else if (AdViewImpl.this.z != null) {
                            AdViewImpl.this.z.onAdClicked();
                        } else if (AdViewImpl.this.A != null) {
                            AdViewImpl.this.A.onRewardVideoAdClicked();
                        }
                    }
                }
            });
        }

        @Override // com.octopus.ad.internal.b
        public void c() {
        }

        @Override // com.octopus.ad.internal.b
        public void d() {
        }

        @Override // com.octopus.ad.internal.b
        public void a(com.octopus.ad.internal.network.b bVar) {
            this.c = bVar;
            if (bVar.a().equals(p.NATIVE) || bVar.a().equals(p.DRAW) || bVar.a().equals(p.BANNER)) {
                a(80103);
                return;
            }
            com.octopus.ad.internal.d dVar = AdViewImpl.this.d;
            if (dVar != null && dVar.l()) {
                AdViewImpl.this.aq = true;
                AdViewImpl.this.y();
                return;
            }
            ServerResponse serverResponse = AdViewImpl.this.f12542a;
            if (serverResponse != null && serverResponse.q() == 1) {
                a(80100);
                AdViewImpl.this.x();
                if (AdViewImpl.this.ap) {
                    return;
                }
                com.octopus.ad.internal.network.a.a(AdViewImpl.this.getContext(), AdViewImpl.this.f12542a.f());
                return;
            }
            AdViewImpl adViewImpl = AdViewImpl.this;
            ServerResponse serverResponse2 = adViewImpl.f12542a;
            if (serverResponse2 == null) {
                a(80100);
                return;
            }
            adViewImpl.p = serverResponse2.N();
            AdViewImpl.this.setPrice(bVar.c());
            AdViewImpl.this.setTagId(bVar.d());
            AdViewImpl.this.setValidTime(bVar.e());
            AdViewImpl.this.l();
            if (AdViewImpl.this.f12542a.l() == p.REWARD) {
                AdViewImpl adViewImpl2 = AdViewImpl.this;
                adViewImpl2.a(adViewImpl2.f12542a.v());
            }
            this.b.post(new Runnable() { // from class: com.octopus.ad.internal.view.AdViewImpl.b.1
                @Override // java.lang.Runnable
                public void run() {
                    View adView = AdViewImpl.this.getAdView();
                    if (adView == null) {
                        return;
                    }
                    adView.getViewTreeObserver().addOnGlobalLayoutListener(AdViewImpl.this);
                }
            });
        }

        @Override // com.octopus.ad.internal.b
        public void a(com.octopus.ad.internal.view.b bVar) {
            AdViewImpl.this.setCreativeWidth(bVar.getCreativeWidth());
            AdViewImpl.this.setCreativeHeight(bVar.getCreativeHeight());
            if (AdViewImpl.this.a(bVar)) {
                f.c("OctopusAd_Time", "Displayable");
                AdViewImpl adViewImpl = AdViewImpl.this;
                adViewImpl.r = true;
                adViewImpl.E();
                AdViewImpl.this.o();
            }
        }

        @Override // com.octopus.ad.internal.b
        public void a(boolean z) {
            AdViewImpl.this.a(z);
            AdViewImpl adViewImpl = AdViewImpl.this;
            ServerResponse serverResponse = adViewImpl.f12542a;
            if (serverResponse != null) {
                AdViewImpl.a(serverResponse, adViewImpl.aQ);
                AdViewImpl adViewImpl2 = AdViewImpl.this;
                adViewImpl2.as = adViewImpl2.f12542a.Q();
                AdViewImpl adViewImpl3 = AdViewImpl.this;
                adViewImpl3.al = adViewImpl3.f12542a.R();
                AdViewImpl adViewImpl4 = AdViewImpl.this;
                adViewImpl4.ar = adViewImpl4.f12542a.P();
            }
        }

        @Override // com.octopus.ad.internal.b
        public void a(final int i) {
            this.b.post(new Runnable() { // from class: com.octopus.ad.internal.view.AdViewImpl.b.2
                @Override // java.lang.Runnable
                public void run() {
                    AdViewImpl.this.b(i);
                }
            });
        }

        @Override // com.octopus.ad.internal.b
        public void a() {
            if (AdViewImpl.this.am) {
                return;
            }
            AdViewImpl.this.am = true;
            AdViewImpl adViewImpl = AdViewImpl.this;
            if (adViewImpl.f12542a != null && !adViewImpl.K) {
                AdViewImpl.this.f12542a.Y();
            }
            this.b.post(new Runnable() { // from class: com.octopus.ad.internal.view.AdViewImpl.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AdViewImpl.this.x != null) {
                        AdViewImpl.this.x.onAdClosed();
                    } else if (AdViewImpl.this.y != null) {
                        AdViewImpl.this.y.onAdClosed();
                    } else if (AdViewImpl.this.z != null) {
                        AdViewImpl.this.z.onAdClosed();
                    } else if (AdViewImpl.this.A != null) {
                        AdViewImpl.this.A.onRewardVideoAdClosed();
                    }
                    AdViewImpl.this.b.b();
                }
            });
        }

        @Override // com.octopus.ad.internal.b
        public void a(final long j) {
            this.b.post(new Runnable() { // from class: com.octopus.ad.internal.view.AdViewImpl.b.5
                @Override // java.lang.Runnable
                public void run() {
                    if (AdViewImpl.this.x == null || b.this.c == null || !b.this.c.a().equals(p.SPLASH)) {
                        return;
                    }
                    AdViewImpl.this.x.onAdTick(j);
                }
            });
        }
    }

    public interface c {
        void a();
    }

    public AdViewImpl(Context context) {
        this(context, null, 0);
    }

    public static /* synthetic */ int L(AdViewImpl adViewImpl) {
        int i = adViewImpl.aI;
        adViewImpl.aI = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getAdView() {
        AdVideoView adVideoView = this.au;
        if (adVideoView != null) {
            return adVideoView;
        }
        com.octopus.ad.internal.view.a aVar = this.av;
        if (aVar != null) {
            return aVar.c;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.octopus.ad.model.d getRandomClickPosition() {
        int screenWidth;
        int screenHeight;
        try {
            if (!this.ap && !this.aq) {
                View adView = getAdView();
                if (adView != null) {
                    screenWidth = adView.getWidth();
                    screenHeight = adView.getHeight();
                } else {
                    screenWidth = 0;
                    screenHeight = 0;
                }
                if (screenWidth == 0 || screenHeight == 0) {
                    screenWidth = ViewUtil.getScreenWidth(getContext());
                    screenHeight = ViewUtil.getScreenWidth(getContext());
                }
                int a2 = i.a(screenWidth);
                int a3 = i.a(screenHeight);
                int a4 = i.a(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS) + 50;
                com.octopus.ad.model.d dVar = new com.octopus.ad.model.d(1);
                float f = a2;
                dVar.a(f);
                float f2 = a3;
                dVar.b(f2);
                dVar.a(String.valueOf(System.currentTimeMillis()));
                dVar.d(String.valueOf(System.currentTimeMillis()));
                dVar.c(String.valueOf(System.currentTimeMillis() / 1000));
                dVar.c(f);
                dVar.d(f2);
                dVar.b(String.valueOf(System.currentTimeMillis() + a4));
                dVar.a(screenWidth);
                dVar.b(screenHeight);
                return dVar;
            }
            screenWidth = ViewUtil.getScreenWidth(getContext());
            screenHeight = ViewUtil.getScreenHeight(getContext());
            int a22 = i.a(screenWidth);
            int a32 = i.a(screenHeight);
            int a42 = i.a(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS) + 50;
            com.octopus.ad.model.d dVar2 = new com.octopus.ad.model.d(1);
            float f3 = a22;
            dVar2.a(f3);
            float f22 = a32;
            dVar2.b(f22);
            dVar2.a(String.valueOf(System.currentTimeMillis()));
            dVar2.d(String.valueOf(System.currentTimeMillis()));
            dVar2.c(String.valueOf(System.currentTimeMillis() / 1000));
            dVar2.c(f3);
            dVar2.d(f22);
            dVar2.b(String.valueOf(System.currentTimeMillis() + a42));
            dVar2.a(screenWidth);
            dVar2.b(screenHeight);
            return dVar2;
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    public void a(Context context) {
    }

    public abstract boolean a(com.octopus.ad.internal.view.b bVar);

    @Override // com.octopus.ad.AdLifeControl
    public void cancel() {
        destroy();
    }

    @Override // com.octopus.ad.AdLifeControl
    public void destroy() {
        HaoboLog.d(HaoboLog.baseLogTag, "called destroy() on AdView");
        G();
        if (this.aO != null) {
            com.octopus.ad.internal.k.a().b(this.aO);
        }
        if (this.aP != null) {
            com.octopus.ad.internal.k.a().b(this.aP);
        }
        ServerResponse serverResponse = this.f12542a;
        if (serverResponse != null) {
            serverResponse.ah();
        }
        com.octopus.ad.internal.c cVar = this.f;
        if (cVar != null) {
            cVar.b();
            this.f.a();
            this.f = null;
        }
        com.octopus.ad.internal.view.b bVar = this.c;
        if (bVar != null) {
            bVar.k();
            this.c = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public com.octopus.ad.internal.b getAdDispatcher() {
        return this.D;
    }

    public com.octopus.ad.internal.d getAdParameters() {
        return this.d;
    }

    public a.C0411a getAdRequest() {
        return this.e;
    }

    public com.octopus.ad.b getAdSize() {
        return new com.octopus.ad.b(this.u, this.v);
    }

    public String getAdSlotId() {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.get_placement_id, this.d.c()));
        com.octopus.ad.internal.d dVar = this.d;
        return dVar == null ? "" : dVar.c();
    }

    public long getExposeTime() {
        com.octopus.ad.internal.d dVar = this.d;
        return dVar != null ? dVar.i() : System.currentTimeMillis();
    }

    public String getExtraData() {
        return this.ac;
    }

    public Map<String, Object> getMediaExtraInfo() {
        ServerResponse serverResponse = this.f12542a;
        return serverResponse != null ? serverResponse.X() : Collections.EMPTY_MAP;
    }

    public boolean getOpensNativeBrowser() {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.get_opens_native_browser, this.d.o()));
        return this.d.o();
    }

    public int getPrice() {
        return this.aa;
    }

    public String getRequestId() {
        com.octopus.ad.internal.d dVar = this.d;
        return (dVar == null || TextUtils.isEmpty(dVar.f())) ? this.aB : this.d.f();
    }

    public ShakeValue getShakeValue() {
        ServerResponse serverResponse = this.f12542a;
        if (serverResponse != null) {
            return serverResponse.W();
        }
        return null;
    }

    public ViewGroup getSplashParent() {
        return this.t;
    }

    public String getTagId() {
        return this.ab;
    }

    public String getUserId() {
        return this.ad;
    }

    public VideoStateListener getVideoStateListener() {
        return this.aN;
    }

    public abstract boolean k();

    @Override // com.octopus.ad.AdLifeControl
    public void onCreateLifeCycle() {
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onDestroyLifeCycle() {
        com.octopus.ad.internal.c cVar = this.f;
        if (cVar != null) {
            cVar.a();
        }
        F();
        I();
        s();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        c.o I;
        View adView = getAdView();
        if (adView == null) {
            return;
        }
        adView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        ServerResponse serverResponse = this.f12542a;
        if (serverResponse == null || (I = serverResponse.I()) == null) {
            return;
        }
        c.m a2 = I.a();
        if (a2 != null) {
            e(a2.a() == 1);
        } else if (b() || d()) {
            e(false);
        }
        c.u c2 = I.c();
        if (c2 != null && c2.a() == 1) {
            a(c2);
        }
        c.s d = I.d();
        if (d != null && d.a() == 1) {
            a(d.b());
        }
        c.r b2 = I.b();
        if (b2 != null && b2.a() == 1) {
            b(b2.b());
        }
        if (this.au == null) {
            m();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onPauseLifeCycle() {
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onRestartLifeCycle() {
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onResumeLifeCycle() {
        a aVar = this.b;
        a.EnumC0417a enumC0417a = a.EnumC0417a.FINISHCLOSE;
        aVar.a(enumC0417a);
        if (this.b.c() == enumC0417a) {
            getAdDispatcher().a();
        }
        if (this.aw && this.an && getMediaType() == p.INTERSTITIAL) {
            C();
        }
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onStartLifeCycle() {
    }

    @Override // com.octopus.ad.AdLifeControl
    public void onStopLifeCycle() {
        this.b.a(a.EnumC0417a.STATE_BACKGROUND);
    }

    public abstract void s();

    @Override // com.octopus.ad.IBidding
    public void sendLossNotice(int i, String str, String str2) {
        try {
            this.f12542a.a(i, str, str2);
            x();
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
        }
    }

    @Override // com.octopus.ad.IBidding
    public void sendWinNotice(int i) {
        try {
            this.f12542a.b(i);
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
        }
    }

    public void setAdSlotId(String str) {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.set_placement_id, str));
        com.octopus.ad.internal.d dVar = this.d;
        if (dVar != null) {
            dVar.a(str);
        }
    }

    public void setAdVideoView(AdVideoView adVideoView) {
        this.au = adVideoView;
    }

    public void setAdWebView(com.octopus.ad.internal.view.a aVar) {
        this.av = aVar;
    }

    public void setChannel(String str) {
        com.octopus.ad.internal.d dVar = this.d;
        if (dVar != null) {
            dVar.b(str);
        }
    }

    public void setClickBackClose(boolean z) {
        this.aw = z;
    }

    public void setCountDownTime(int i) {
        this.ag = i;
    }

    public void setCreativeHeight(int i) {
        this.v = i;
    }

    public void setCreativeWidth(int i) {
        this.u = i;
        if (!c()) {
            this.w = 1.0f;
            return;
        }
        int i2 = this.u;
        float f = i2 > 0 ? i2 / 640.0f : 1.0f;
        this.w = f;
        if (f > 1.0f) {
            this.w = 1.0f;
        }
    }

    public void setExtraData(String str) {
        this.ac = str;
    }

    public void setFullScreenVideoAdListener(FullScreenVideoAdListener fullScreenVideoAdListener) {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.set_full_screen_video_ad_listener));
        this.z = fullScreenVideoAdListener;
    }

    public void setInterstitialAdListener(InterstitialAdListener interstitialAdListener) {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.set_interstitial_ad_listener));
        this.y = interstitialAdListener;
    }

    public void setIsBoost(boolean z) {
        this.d.b(z);
    }

    public void setIsClicked(boolean z) {
        this.an = z;
        G();
    }

    public void setOnSensorListener(OnSensorListener onSensorListener) {
        this.aM = onSensorListener;
    }

    public void setOpensNativeBrowser(boolean z) {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.set_opens_native_browser, z));
        this.d.c(z);
    }

    public void setPrice(int i) {
        this.aa = i;
    }

    public void setRequestId(String str) {
        com.octopus.ad.internal.d dVar = this.d;
        if (dVar != null) {
            dVar.c(str);
        }
    }

    public void setRewardVideoAdListener(RewardVideoAdListener rewardVideoAdListener) {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.set_reward_video_ad_listener));
        this.A = rewardVideoAdListener;
    }

    public void setScrollClick(View.OnTouchListener onTouchListener) {
        View adView = getAdView();
        if (adView == null) {
            return;
        }
        adView.setOnTouchListener(onTouchListener);
    }

    public void setSplashAdListener(SplashAdListener splashAdListener) {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.set_splash_ad_listener));
        this.x = splashAdListener;
    }

    public void setTagId(String str) {
        this.ab = str;
    }

    public void setUserId(String str) {
        this.ad = str;
    }

    public void setValidTime(long j) {
        q.s = j;
        this.ai = j;
    }

    public void setVideoStateListener(VideoStateListener videoStateListener) {
        this.aN = videoStateListener;
    }

    public abstract void t();

    public abstract void u();

    public AdViewImpl(Context context, ViewGroup viewGroup) {
        super(context, null, 0);
        this.b = new a();
        this.C = new Handler(Looper.getMainLooper()) { // from class: com.octopus.ad.internal.view.AdViewImpl.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };
        this.d = null;
        this.e = null;
        this.G = false;
        this.J = false;
        this.h = false;
        this.K = false;
        this.ae = 0;
        this.af = 0;
        this.aj = true;
        this.ak = true;
        this.at = 0;
        this.ax = false;
        this.ay = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.aE = null;
        this.aF = false;
        this.aG = false;
        this.aI = 2;
        this.aQ = new c() { // from class: com.octopus.ad.internal.view.AdViewImpl.29
            @Override // com.octopus.ad.internal.view.AdViewImpl.c
            public void a() {
                if (AdViewImpl.this.am || AdViewImpl.this.an || AdViewImpl.this.ao) {
                    return;
                }
                AdViewImpl.this.z();
            }
        };
        this.aR = false;
        this.t = viewGroup;
        a(context, (AttributeSet) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        if (!this.al || this.an) {
            C();
            return;
        }
        this.at = 2;
        AdVideoView adVideoView = this.au;
        if (adVideoView != null) {
            adVideoView.setOpt(2);
        } else {
            com.octopus.ad.internal.view.a aVar = this.av;
            if (aVar != null) {
                aVar.c(2);
            }
        }
        a(getRandomClickPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        ServerResponse serverResponse = this.f12542a;
        if (serverResponse != null) {
            serverResponse.a(g(), (com.octopus.ad.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        G();
        if (getAdDispatcher() != null) {
            getAdDispatcher().a();
        }
        com.octopus.ad.a.a aVar = this.P;
        if (aVar != null) {
            aVar.d();
        }
        com.octopus.ad.internal.view.a aVar2 = this.av;
        if (aVar2 != null) {
            Activity b2 = b(aVar2.getView());
            if (!k() || b2 == null || b2.isFinishing() || !(b2 instanceof AdActivity)) {
                return;
            }
            b2.finish();
        }
    }

    private void D() {
        c.l i;
        if (this.f12542a == null || !q.a().d() || (i = this.f12542a.i()) == null || TextUtils.isEmpty(i.c())) {
            return;
        }
        q.a().a(this.f12542a.ac());
        if (i.b() == 1) {
            this.B = q.a().g.get(i.c());
        }
        com.octopus.ad.model.a aVar = this.B;
        if (aVar == null || !aVar.j() || this.B.f() < getPrice()) {
            com.octopus.ad.model.a aVar2 = new com.octopus.ad.model.a();
            this.B = aVar2;
            aVar2.a(getPrice());
            this.B.a(this.ah);
            this.B.b(this.ai);
            this.B.a(getRequestId());
            this.B.b(i.a());
            this.B.b(i.c());
            this.B.c(i.d());
            this.B.a(this.f12542a.S());
            this.B.e(this.f12542a.V());
            ServerResponse serverResponse = this.f12542a;
            if (serverResponse != null && serverResponse.a() != null) {
                this.B.d(this.f12542a.T());
                this.B.a(this.f12542a.a().t());
            }
            q.a().g.put(i.c(), this.B);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        AdVideoView adVideoView = this.au;
        if (adVideoView == null) {
            return;
        }
        String videoUrl = adVideoView.getVideoUrl();
        this.aA = videoUrl;
        if (TextUtils.isEmpty(videoUrl)) {
            b(false);
            return;
        }
        ServerResponse serverResponse = this.f12542a;
        if (serverResponse != null && (!serverResponse.y() || "m3u8".equalsIgnoreCase(this.f12542a.h()))) {
            b(true);
            return;
        }
        h b2 = q.a().b();
        this.F = b2;
        if (b2 == null) {
            b(false);
            return;
        }
        if (b2.b(this.aA)) {
            b(true);
            return;
        }
        if (this.f12542a == null) {
            b(false);
            return;
        }
        com.octopus.ad.internal.a.b bVar = new com.octopus.ad.internal.a.b() { // from class: com.octopus.ad.internal.view.AdViewImpl.15
            @Override // com.octopus.ad.internal.a.b
            public void a(File file, String str, int i) {
                if (i == 100) {
                    AdViewImpl.this.b(true);
                }
            }
        };
        this.E = bVar;
        this.F.a(bVar, this.aA);
        n();
    }

    private void F() {
        if (this.F == null || this.E == null || TextUtils.isEmpty(this.aA)) {
            return;
        }
        this.F.b(this.E, this.aA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        com.octopus.ad.a.a aVar = this.Q;
        if (aVar != null) {
            aVar.d();
        }
        LinearLayout linearLayout = this.W;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        ServerResponse serverResponse = this.f12542a;
        if (serverResponse != null && serverResponse.K() && this.aj) {
            Map<String, Object> X = this.f12542a.X();
            if (X != null && !X.isEmpty()) {
                X.put("landingPageUrl", this.f12542a.U());
                Intent intent = new Intent(getContext(), (Class<?>) StopoverDialogActivity.class);
                intent.setFlags(C.ENCODING_PCM_MU_LAW);
                Bundle bundle = new Bundle();
                bundle.putSerializable("mapData", (Serializable) X);
                intent.putExtra("bundleData", bundle);
                getContext().startActivity(intent);
                this.aO = new k.a() { // from class: com.octopus.ad.internal.view.AdViewImpl.27
                    @Override // com.octopus.ad.internal.k.a
                    public void a(String str) {
                        if ("getReward".equals(str)) {
                            if (AdViewImpl.this.O != null) {
                                AdViewImpl.this.O.setVisibility(0);
                            }
                            AdViewImpl.this.q();
                        } else if ("StopoverFinish".equals(str)) {
                            if (AdViewImpl.this.P != null) {
                                AdViewImpl.this.P.c();
                            }
                            com.octopus.ad.internal.k.a().b(AdViewImpl.this.aO);
                            AdViewImpl.this.aO = null;
                        }
                    }
                };
                com.octopus.ad.internal.k.a().a(this.aO);
                com.octopus.ad.a.a aVar = this.P;
                if (aVar != null) {
                    aVar.b();
                }
            }
            this.aj = false;
        }
    }

    private void I() {
        l lVar = this.aJ;
        if (lVar != null) {
            lVar.a();
            this.aJ = null;
        }
        j jVar = this.aL;
        if (jVar != null) {
            jVar.a();
        }
        com.octopus.ad.utils.k kVar = this.aK;
        if (kVar != null) {
            kVar.b();
        }
    }

    private void w() {
        try {
            a(this.f12542a, this.aQ);
            a(0, 30, 0, 0);
            int i = this.ag;
            if (i < 3) {
                i = this.av.h();
            }
            a(i);
            ViewGroup viewGroup = this.t;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                this.t.addView(this, new ViewGroup.LayoutParams(-1, -1));
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        ServerResponse serverResponse;
        c.w J;
        c.p c2;
        if (this.ap || (serverResponse = this.f12542a) == null || (J = serverResponse.J()) == null || (c2 = J.c()) == null || c2.a() != 1) {
            return;
        }
        this.ap = true;
        this.f12542a.c(true);
        new Handler().postDelayed(new Runnable() { // from class: com.octopus.ad.internal.view.AdViewImpl.30
            @Override // java.lang.Runnable
            public void run() {
                AdViewImpl.this.B();
            }
        }, c2.c());
        if (c2.b() == 1) {
            final k.a aVar = new k.a() { // from class: com.octopus.ad.internal.view.AdViewImpl.31
                @Override // com.octopus.ad.internal.k.a
                public void a(String str) {
                    if ("AppBackground".equals(str)) {
                        AdViewImpl.this.L = true;
                    }
                }
            };
            com.octopus.ad.internal.k.a().a(aVar);
            new Handler().postDelayed(new Runnable() { // from class: com.octopus.ad.internal.view.AdViewImpl.32
                @Override // java.lang.Runnable
                public void run() {
                    if (!AdViewImpl.this.L) {
                        AdViewImpl.this.z();
                    }
                    com.octopus.ad.internal.k.a().b(aVar);
                }
            }, c2.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        c.w J;
        c.p c2;
        ServerResponse serverResponse = this.f12542a;
        if (serverResponse == null || (J = serverResponse.J()) == null || (c2 = J.c()) == null || c2.a() != 1) {
            return;
        }
        this.f12542a.d(true);
        new Handler().postDelayed(new Runnable() { // from class: com.octopus.ad.internal.view.AdViewImpl.33
            @Override // java.lang.Runnable
            public void run() {
                AdViewImpl.this.B();
            }
        }, c2.c());
        if (c2.b() == 1) {
            final k.a aVar = new k.a() { // from class: com.octopus.ad.internal.view.AdViewImpl.34
                @Override // com.octopus.ad.internal.k.a
                public void a(String str) {
                    if ("AppBackground".equals(str)) {
                        AdViewImpl.this.L = true;
                    }
                }
            };
            com.octopus.ad.internal.k.a().a(aVar);
            new Handler().postDelayed(new Runnable() { // from class: com.octopus.ad.internal.view.AdViewImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!AdViewImpl.this.L) {
                        AdViewImpl.this.z();
                    }
                    com.octopus.ad.internal.k.a().b(aVar);
                }
            }, c2.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        ServerResponse serverResponse;
        if (this.av == null || (serverResponse = this.f12542a) == null) {
            return;
        }
        if (a(serverResponse)) {
            this.ao = false;
            this.at = 0;
        } else {
            this.ao = true;
            this.at = 9;
        }
        this.av.a(this.at, getRandomClickPosition());
    }

    public void i() {
        ProgressBar progressBar = this.T;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    public boolean j() {
        return this.G;
    }

    public void l() {
        if (this.ax) {
            return;
        }
        this.ax = true;
        this.ah = System.currentTimeMillis();
        SplashAdListener splashAdListener = this.x;
        if (splashAdListener != null) {
            splashAdListener.onAdLoaded();
        } else {
            InterstitialAdListener interstitialAdListener = this.y;
            if (interstitialAdListener != null) {
                interstitialAdListener.onAdLoaded();
            } else {
                FullScreenVideoAdListener fullScreenVideoAdListener = this.z;
                if (fullScreenVideoAdListener != null) {
                    fullScreenVideoAdListener.onAdLoaded();
                } else {
                    RewardVideoAdListener rewardVideoAdListener = this.A;
                    if (rewardVideoAdListener != null) {
                        rewardVideoAdListener.onRewardVideoAdLoaded();
                    }
                }
            }
        }
        D();
    }

    public void m() {
        if (this.aH || this.f12542a == null) {
            return;
        }
        if (d() || e()) {
            this.aH = true;
            c.y j = this.f12542a.j();
            if (j == null || j.a() != 1) {
                return;
            }
            c(j.b());
        }
    }

    public void n() {
        if (TextUtils.isEmpty(this.aA)) {
            return;
        }
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.octopus.ad.internal.view.AdViewImpl.16
            @Override // java.lang.Runnable
            public void run() {
                h b2 = q.a().b();
                if (b2 == null || b2.b(AdViewImpl.this.aA)) {
                    return;
                }
                InputStream inputStream = null;
                try {
                    try {
                        try {
                            inputStream = new URL(b2.a(AdViewImpl.this.aA)).openStream();
                            while (inputStream.read(new byte[1024]) != -1) {
                            }
                            inputStream.close();
                            inputStream.close();
                        } catch (Exception unused) {
                            AdViewImpl.this.b(false);
                            HaoboLog.v(HaoboLog.baseLogTag, "preload fail:" + AdViewImpl.this.aA);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        }
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e) {
                                f.a("OctopusAd", "An Exception Caught", e);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    f.a("OctopusAd", "An Exception Caught", e2);
                }
            }
        });
    }

    public void o() {
        if (this.q) {
            if (this.g == p.SPLASH) {
                a(this.az);
            } else {
                a(this.s);
            }
        }
    }

    public void p() {
        RewardVideoAdListener rewardVideoAdListener;
        if (this.aG || !this.I || (rewardVideoAdListener = this.A) == null) {
            return;
        }
        this.aG = true;
        rewardVideoAdListener.onRewardVideoAdComplete();
    }

    public void q() {
        if (this.aF || this.aE == null) {
            return;
        }
        this.aF = true;
        AppCompatTextView appCompatTextView = this.M;
        if (appCompatTextView != null) {
            appCompatTextView.setText("恭喜获得奖励");
        }
        if (!TextUtils.isEmpty(this.aC)) {
            r();
        } else {
            Pair<String, Integer> pair = this.aE;
            a((String) pair.first, ((Integer) pair.second).intValue());
        }
    }

    public void r() {
        new t(this.aC).a(new HTTPGet.ResponseListener() { // from class: com.octopus.ad.internal.view.AdViewImpl.17
            @Override // com.octopus.ad.internal.utilities.HTTPGet.ResponseListener
            public void getResponse(int i, boolean z, String str) {
                if (z && !TextUtils.isEmpty(str)) {
                    try {
                        if (new JSONObject(str).optBoolean("isValid") && AdViewImpl.this.aE != null) {
                            AdViewImpl adViewImpl = AdViewImpl.this;
                            adViewImpl.a((String) adViewImpl.aE.first, ((Integer) AdViewImpl.this.aE.second).intValue());
                        }
                    } catch (Exception e) {
                        f.a("OctopusAd", "An Exception Caught", e);
                    }
                } else if (AdViewImpl.this.aI > 0) {
                    new Handler().postDelayed(new Runnable() { // from class: com.octopus.ad.internal.view.AdViewImpl.17.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AdViewImpl.this.r();
                            AdViewImpl.L(AdViewImpl.this);
                        }
                    }, 200L);
                }
                if (z || AdViewImpl.this.aI == 0) {
                    AdViewImpl.this.d(z);
                }
            }
        }).execute();
    }

    public void v() {
        ServerResponse serverResponse = this.f12542a;
        if (serverResponse == null || !serverResponse.L() || this.f12542a.A() || !this.ak) {
            return;
        }
        Map<String, Object> X = this.f12542a.X();
        if (X != null && !X.isEmpty()) {
            Intent intent = new Intent(getContext(), (Class<?>) EndingPageActivity.class);
            intent.setFlags(C.ENCODING_PCM_MU_LAW);
            Bundle bundle = new Bundle();
            bundle.putSerializable("mapData", (Serializable) X);
            intent.putExtra("bundleData", bundle);
            getContext().startActivity(intent);
            this.aP = new k.a() { // from class: com.octopus.ad.internal.view.AdViewImpl.28
                @Override // com.octopus.ad.internal.k.a
                public void a(String str) {
                    if ("adClick".equals(str)) {
                        AdViewImpl adViewImpl = AdViewImpl.this;
                        adViewImpl.a(adViewImpl.getRandomClickPosition());
                    } else {
                        if (!"feedBackClick".equals(str) || TextUtils.isEmpty(AdViewImpl.this.aD)) {
                            return;
                        }
                        ViewUtil.openLocalBrowser(AdViewImpl.this.aD, 0);
                    }
                }
            };
            com.octopus.ad.internal.k.a().a(this.aP);
        }
        this.ak = false;
    }

    public boolean b() {
        return p.SPLASH == this.g;
    }

    public boolean c() {
        return p.INTERSTITIAL == this.g;
    }

    public boolean d() {
        return p.REWARD == this.g;
    }

    public boolean e() {
        return p.FULLSCREEN == this.g;
    }

    public boolean f() {
        return this.ax;
    }

    public boolean g() {
        long currentTimeMillis;
        long j;
        com.octopus.ad.internal.d dVar = this.d;
        if (dVar != null && dVar.g() > 0) {
            currentTimeMillis = System.currentTimeMillis();
            j = this.d.g();
        } else {
            currentTimeMillis = System.currentTimeMillis();
            j = this.ah;
        }
        return currentTimeMillis - j <= this.ai;
    }

    public void h() {
        o.a(new com.octopus.ad.internal.l("LOAD", getAdSlotId(), getRequestId()));
    }

    public Activity b(View view) {
        return (Activity) a(view);
    }

    public void c(View view) {
        try {
            ViewUtil.removeChildFromParent(this.U);
            ViewUtil.removeChildFromParent(this.V);
            ViewParent parent = view instanceof FrameLayout ? (FrameLayout) view : view.getParent();
            if (parent instanceof FrameLayout) {
                if (this.U != null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 42, 8388691);
                    layoutParams.setMargins(30, 0, 0, 50);
                    ((FrameLayout) parent).addView(this.U, layoutParams);
                    this.U.setVisibility(0);
                }
                if (this.V != null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, 42, 8388693);
                    layoutParams2.setMargins(0, 0, 30, 50);
                    ((FrameLayout) parent).addView(this.V, layoutParams2);
                    this.V.setVisibility(0);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void d(View view) {
        try {
            ViewUtil.removeChildFromParent(this.N);
            this.l = getMediaType() == p.INTERSTITIAL ? 10 : 30;
            this.k = this.au == null ? 0 : 30;
            this.aD = UrlUtil.replaceFeedBackUrl("https://www.adintl.cn/sdkFeedback.html?slotId=${SLOT_ID}&sdkVersion=${SDK_VERSION}&deviceId=${DEVICE_ID}", getAdSlotId(), Octopus.getOaid(getContext()));
            AppCompatTextView createFeedBackButton = ViewUtil.createFeedBackButton(getContext(), this.aD, this.k, this.l, this.w);
            this.N = createFeedBackButton;
            createFeedBackButton.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.view.AdViewImpl.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    ViewUtil.openLocalBrowser(AdViewImpl.this.aD, 0);
                    ServerResponse serverResponse = AdViewImpl.this.f12542a;
                    if (serverResponse != null) {
                        serverResponse.c();
                    }
                }
            });
            ViewParent parent = view instanceof FrameLayout ? (FrameLayout) view : view.getParent();
            if (parent instanceof FrameLayout) {
                ((FrameLayout) parent).addView(this.N);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void e(View view) {
        int i;
        try {
            AppCompatTextView appCompatTextView = this.S;
            if (appCompatTextView != null) {
                ViewUtil.removeChildFromParent(appCompatTextView);
                ViewParent parent = view instanceof FrameLayout ? (FrameLayout) view : view.getParent();
                if (parent instanceof FrameLayout) {
                    ServerResponse serverResponse = this.f12542a;
                    if (serverResponse != null) {
                        int o = serverResponse.o();
                        if (getMediaType().equals(p.INTERSTITIAL) && o > 0) {
                            i = (int) (o * q.a().o);
                            int screenWidth = ViewUtil.getScreenWidth(getContext());
                            if (i > screenWidth) {
                                i = screenWidth;
                            }
                            ((FrameLayout) parent).addView(this.S, new FrameLayout.LayoutParams(i, -2, 80));
                        }
                    }
                    i = -1;
                    ((FrameLayout) parent).addView(this.S, new FrameLayout.LayoutParams(i, -2, 80));
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.OctopusAlertDialogStyle);
            View inflate = LayoutInflater.from(context).inflate(R.layout.oct_dialog_close_confirm, (ViewGroup) null);
            builder.setView(inflate);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_quit);
            TextView textView3 = (TextView) inflate.findViewById(R.id.tv_wait);
            Locale locale = Locale.US;
            textView.setText("观看满 " + this.ae + " 秒即可获得奖励\n确认离开吗？");
            final AlertDialog create = builder.create();
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.view.AdViewImpl.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    create.dismiss();
                    AdViewImpl.this.A();
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.view.AdViewImpl.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    create.dismiss();
                }
            });
            create.show();
            AdVideoView adVideoView = this.au;
            if (adVideoView != null) {
                adVideoView.m();
            } else {
                com.octopus.ad.a.a aVar = this.P;
                if (aVar != null) {
                    aVar.b();
                }
            }
            create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.octopus.ad.internal.view.AdViewImpl.14
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AdViewImpl.this.au != null) {
                        AdViewImpl.this.au.n();
                    } else if (AdViewImpl.this.P != null) {
                        AdViewImpl.this.P.c();
                    }
                }
            });
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        this.k = i;
        this.l = i2;
        this.m = i3;
        this.n = i4;
    }

    public void a(Context context, AttributeSet attributeSet) {
        f.c("OctopusAd_Time", "AdViewImpl setup 开始 mRequestId : " + this.aB);
        setBackgroundColor(0);
        this.D = new b(this.C);
        String createRequestId = StringUtil.createRequestId();
        this.aB = createRequestId;
        this.d = new com.octopus.ad.internal.d(context, createRequestId);
        try {
            HaoboLog.setErrorContext(getContext().getApplicationContext());
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
        setPadding(0, 0, 0, 0);
        this.f = new com.octopus.ad.internal.c(this);
        this.aJ = new l(getContext());
        this.aK = new com.octopus.ad.utils.k(getContext());
        this.aL = new j(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        o.a(new com.octopus.ad.internal.l("REWARD", getAdSlotId(), getRequestId(), System.currentTimeMillis() - getExposeTime(), z ? 1 : 0, this.aC));
    }

    private void e(boolean z) {
        f.a("OctopusAd", "octopus clickable = " + z);
        if (z) {
            return;
        }
        a(new View.OnTouchListener() { // from class: com.octopus.ad.internal.view.AdViewImpl.20
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    public void c(boolean z) {
        setOpensNativeBrowser(z);
    }

    private void c(int i) {
        try {
            View adView = getAdView();
            if (adView == null) {
                return;
            }
            ViewParent parent = adView instanceof FrameLayout ? (FrameLayout) adView : adView.getParent();
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.oct_countdown_click, (ViewGroup) null);
            this.W = (LinearLayout) inflate.findViewById(R.id.rl_auto);
            final TextView textView = (TextView) inflate.findViewById(R.id.tv_auto);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_stop);
            this.W.setVisibility(0);
            com.octopus.ad.a.a aVar = new com.octopus.ad.a.a(i * 1000, 50L);
            this.Q = aVar;
            aVar.a(new com.octopus.ad.a.b() { // from class: com.octopus.ad.internal.view.AdViewImpl.24
                @Override // com.octopus.ad.a.b
                public void a(long j) {
                    int i2 = (int) ((j / 1000) + 1);
                    TextView textView3 = textView;
                    Locale locale = Locale.US;
                    textView3.setText(i2 + "秒后自动跳转详情页");
                    if (i2 <= 3) {
                        textView.setBackgroundResource(R.drawable.oct_bg_common_orange);
                    }
                }

                @Override // com.octopus.ad.a.b
                public void b() {
                }

                @Override // com.octopus.ad.a.b
                public void a() {
                    AdViewImpl.this.at = 3;
                    AdViewImpl.this.ao = true;
                    if (AdViewImpl.this.av != null) {
                        AdViewImpl.this.av.a(AdViewImpl.this.at, AdViewImpl.this.getRandomClickPosition());
                    }
                    AdViewImpl.this.G();
                }
            });
            this.Q.a();
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.view.AdViewImpl.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdViewImpl.this.G();
                }
            });
            inflate.findViewById(R.id.rl_auto).setVisibility(0);
            q a2 = q.a();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            layoutParams.setMargins(0, 0, 0, (int) TypedValue.applyDimension(1, 50.0f, a2.q()));
            if (parent instanceof FrameLayout) {
                ((FrameLayout) parent).addView(inflate, layoutParams);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void b(int i) {
        if (this.aR) {
            return;
        }
        SplashAdListener splashAdListener = this.x;
        if (splashAdListener != null) {
            splashAdListener.onAdFailedToLoad(i);
        } else {
            InterstitialAdListener interstitialAdListener = this.y;
            if (interstitialAdListener != null) {
                interstitialAdListener.onAdFailedToLoad(i);
            } else {
                FullScreenVideoAdListener fullScreenVideoAdListener = this.z;
                if (fullScreenVideoAdListener != null) {
                    fullScreenVideoAdListener.onAdFailedToLoad(i);
                } else {
                    RewardVideoAdListener rewardVideoAdListener = this.A;
                    if (rewardVideoAdListener != null) {
                        rewardVideoAdListener.onRewardVideoAdFailedToLoad(i);
                    }
                }
            }
        }
        this.aR = true;
    }

    @Override // com.octopus.ad.internal.a
    public boolean a() {
        com.octopus.ad.internal.d dVar = this.d;
        return (dVar == null || !dVar.q() || this.e == null) ? false : true;
    }

    public void a(ViewGroup viewGroup) {
        try {
            if (this.p) {
                if (this.o) {
                }
                this.q = true;
                this.az = viewGroup;
            }
            if (this.r) {
                if (this.ay) {
                    return;
                }
                this.ay = true;
                ViewUtil.removeChildFromParent(this);
                if (viewGroup != null) {
                    this.t = viewGroup;
                }
                ServerResponse serverResponse = this.f12542a;
                if (serverResponse != null) {
                    serverResponse.b();
                    this.as = this.f12542a.Q();
                    this.al = this.f12542a.R();
                    this.ar = this.f12542a.P();
                    this.f12542a.a(g(), new com.octopus.ad.a() { // from class: com.octopus.ad.internal.view.AdViewImpl.12
                        @Override // com.octopus.ad.a
                        public void a(boolean z) {
                            AdViewImpl.this.a(z);
                        }
                    });
                }
                w();
                return;
            }
            this.q = true;
            this.az = viewGroup;
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public AdViewImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdViewImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new a();
        this.C = new Handler(Looper.getMainLooper()) { // from class: com.octopus.ad.internal.view.AdViewImpl.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };
        this.d = null;
        this.e = null;
        this.G = false;
        this.J = false;
        this.h = false;
        this.K = false;
        this.ae = 0;
        this.af = 0;
        this.aj = true;
        this.ak = true;
        this.at = 0;
        this.ax = false;
        this.ay = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.aE = null;
        this.aF = false;
        this.aG = false;
        this.aI = 2;
        this.aQ = new c() { // from class: com.octopus.ad.internal.view.AdViewImpl.29
            @Override // com.octopus.ad.internal.view.AdViewImpl.c
            public void a() {
                if (AdViewImpl.this.am || AdViewImpl.this.an || AdViewImpl.this.ao) {
                    return;
                }
                AdViewImpl.this.z();
            }
        };
        this.aR = false;
        a(context, attributeSet);
    }

    public void b(boolean z) {
        ServerResponse serverResponse;
        if (this.o || (serverResponse = this.f12542a) == null || serverResponse.q() != 0) {
            return;
        }
        this.o = true;
        SplashAdListener splashAdListener = this.x;
        if (splashAdListener != null) {
            splashAdListener.onAdCacheLoaded(z);
            return;
        }
        InterstitialAdListener interstitialAdListener = this.y;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdCacheLoaded(z);
            return;
        }
        FullScreenVideoAdListener fullScreenVideoAdListener = this.z;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onAdCacheLoaded(z);
            return;
        }
        RewardVideoAdListener rewardVideoAdListener = this.A;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onRewardVideoCached(z);
        }
    }

    public void a(boolean z) {
        ServerResponse serverResponse;
        if (this.H) {
            return;
        }
        this.H = true;
        this.I = z;
        if (z && (serverResponse = this.f12542a) != null) {
            this.I = serverResponse.O();
        }
        if (this.I) {
            SplashAdListener splashAdListener = this.x;
            if (splashAdListener != null) {
                splashAdListener.onAdShown();
            } else {
                InterstitialAdListener interstitialAdListener = this.y;
                if (interstitialAdListener != null) {
                    interstitialAdListener.onAdShown();
                } else {
                    FullScreenVideoAdListener fullScreenVideoAdListener = this.z;
                    if (fullScreenVideoAdListener != null) {
                        fullScreenVideoAdListener.onAdShown();
                    } else {
                        RewardVideoAdListener rewardVideoAdListener = this.A;
                        if (rewardVideoAdListener != null) {
                            rewardVideoAdListener.onRewardVideoAdShown();
                        }
                    }
                }
            }
        }
        ServerResponse serverResponse2 = this.f12542a;
        if (serverResponse2 != null) {
            serverResponse2.a(this.B, this.I);
        }
        if (this.B == null || !getRequestId().equals(this.B.a())) {
            return;
        }
        q.a().g.remove(this.B.b());
    }

    private void b(String str) {
        View adView;
        View a2;
        try {
            if (this.aL == null || (adView = getAdView()) == null || (a2 = this.aL.a(ViewUtil.px2dip(getContext(), adView.getWidth()), ViewUtil.px2dip(getContext(), adView.getHeight()), str, true)) == null) {
                return;
            }
            final com.octopus.ad.model.d dVar = new com.octopus.ad.model.d(1);
            a2.setOnTouchListener(new View.OnTouchListener() { // from class: com.octopus.ad.internal.view.AdViewImpl.22
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    AdViewImpl adViewImpl = AdViewImpl.this;
                    adViewImpl.a(motionEvent, adViewImpl.as, dVar);
                    return true;
                }
            });
            ViewParent parent = adView instanceof FrameLayout ? (FrameLayout) adView : adView.getParent();
            if (parent instanceof FrameLayout) {
                ((FrameLayout) parent).addView(a2);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void a(ServerResponse serverResponse, final c cVar) {
        c.w J;
        c.g a2;
        if (serverResponse == null || (J = serverResponse.J()) == null || (a2 = J.a()) == null || a2.a() != 1) {
            return;
        }
        com.octopus.ad.utils.e.a(new Runnable() { // from class: com.octopus.ad.internal.view.AdViewImpl.23
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c cVar2 = c.this;
                    if (cVar2 != null) {
                        cVar2.a();
                    }
                } catch (Throwable th) {
                    f.a("OctopusAd", "A Throwable Caught", th);
                }
            }
        }, a2.b());
    }

    public static boolean a(ServerResponse serverResponse) {
        c.w J;
        c.g a2;
        return (serverResponse == null || (J = serverResponse.J()) == null || (a2 = J.a()) == null || a2.c() != 1) ? false : true;
    }

    public void a(com.octopus.ad.model.d dVar) {
        com.octopus.ad.internal.view.a aVar = this.av;
        if (aVar != null) {
            aVar.a(this.at, dVar);
        }
    }

    public boolean a(a.C0411a c0411a) {
        com.octopus.ad.internal.c cVar;
        this.e = c0411a;
        if (!a()) {
            SplashAdListener splashAdListener = this.x;
            if (splashAdListener != null) {
                splashAdListener.onAdFailedToLoad(MediationConstant.ErrorCode.ADN_INIT_FAIL);
            } else {
                InterstitialAdListener interstitialAdListener = this.y;
                if (interstitialAdListener != null) {
                    interstitialAdListener.onAdFailedToLoad(MediationConstant.ErrorCode.ADN_INIT_FAIL);
                } else {
                    FullScreenVideoAdListener fullScreenVideoAdListener = this.z;
                    if (fullScreenVideoAdListener != null) {
                        fullScreenVideoAdListener.onAdFailedToLoad(MediationConstant.ErrorCode.ADN_INIT_FAIL);
                    } else {
                        RewardVideoAdListener rewardVideoAdListener = this.A;
                        if (rewardVideoAdListener != null) {
                            rewardVideoAdListener.onRewardVideoAdFailedToLoad(MediationConstant.ErrorCode.ADN_INIT_FAIL);
                        }
                    }
                }
            }
            return false;
        }
        if (getWindowVisibility() == 0 && (cVar = this.f) != null) {
            cVar.a();
            this.f.d();
            this.f.c();
            this.G = true;
            this.i = 1;
            this.j = 0;
            return true;
        }
        com.octopus.ad.internal.c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.a();
            this.f.d();
            this.f.c();
            this.G = true;
            this.i = 1;
            this.j = 0;
        }
        return false;
    }

    public Context a(View view) {
        Context context;
        if (view == null) {
            return null;
        }
        if (view.getContext() instanceof MutableContextWrapper) {
            context = ((MutableContextWrapper) view.getContext()).getBaseContext();
        } else {
            context = getContext();
        }
        if (context instanceof Activity) {
            return context;
        }
        return null;
    }

    public void a(ServerResponse.AdLogoInfo adLogoInfo, ServerResponse.AdLogoInfo adLogoInfo2, int i) {
        try {
            ViewUtil.removeChildFromParent(this.U);
            ViewUtil.removeChildFromParent(this.V);
            float f = 1.0f;
            float f2 = i > 0 ? i / 640.0f : 1.0f;
            if (f2 <= 1.0f) {
                f = f2;
            }
            if (!TextUtils.isEmpty(adLogoInfo.getAdurl())) {
                this.U = ViewUtil.createAdImageView(new MutableContextWrapper(getContext()), adLogoInfo, 0, 8388611, f);
            }
            if (TextUtils.isEmpty(adLogoInfo2.getAdurl())) {
                return;
            }
            this.V = ViewUtil.createLogoImageView(new MutableContextWrapper(getContext()), adLogoInfo2, 0, f);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void a(ServerResponse.AdLogoInfo adLogoInfo, int i) {
        try {
            ViewUtil.removeChildFromParent(this.U);
            ViewUtil.removeChildFromParent(this.V);
            float f = 1.0f;
            float f2 = i > 0 ? i / 640.0f : 1.0f;
            if (f2 <= 1.0f) {
                f = f2;
            }
            if (!TextUtils.isEmpty(adLogoInfo.getAdurl())) {
                this.V = ViewUtil.createLogoImageView(new MutableContextWrapper(getContext()), adLogoInfo, 6, f);
            }
            ServerResponse.AdLogoInfo adLogoInfo2 = new ServerResponse.AdLogoInfo();
            adLogoInfo2.setType(ServerResponse.AdLogoInfo.TYPE_TEXT);
            adLogoInfo2.setAdurl("广告");
            if (TextUtils.isEmpty(adLogoInfo2.getAdurl())) {
                return;
            }
            this.U = ViewUtil.createAdImageView(new MutableContextWrapper(getContext()), adLogoInfo2, 3, 8388613, f);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void a(final AdVideoView adVideoView, boolean z) {
        try {
            ViewUtil.removeChildFromParent(this.R);
            AppCompatImageView createMuteButton = ViewUtil.createMuteButton(getContext(), z, this.l, this.w);
            this.R = createMuteButton;
            createMuteButton.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.view.AdViewImpl.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdVideoView adVideoView2;
                    if (AdViewImpl.this.R == null || (adVideoView2 = adVideoView) == null) {
                        return;
                    }
                    AdViewImpl.this.R.setImageResource(adVideoView2.g() ? R.drawable.oct_voice_off : R.drawable.oct_voice_on);
                }
            });
            ViewParent parent = adVideoView.getParent();
            if (parent instanceof FrameLayout) {
                ((FrameLayout) parent).addView(this.R);
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void a(AdVideoView adVideoView) {
        try {
            ProgressBar progressBar = this.T;
            if (progressBar == null) {
                this.T = ViewUtil.createLoadingView(getContext(), this.w);
                ViewParent parent = adVideoView.getParent();
                if (parent instanceof FrameLayout) {
                    ((FrameLayout) parent).addView(this.T);
                    return;
                }
                return;
            }
            progressBar.setVisibility(0);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void a(ComplianceInfo complianceInfo, float f) {
        this.S = ViewUtil.createComplianceView(getContext(), complianceInfo, f, false);
    }

    public void a(int i, int i2, View view) {
        try {
            ViewUtil.removeChildFromParent(this.O);
            ViewUtil.removeChildFromParent(this.M);
            if (this.O == null) {
                ImageView createImageCloseButton = ViewUtil.createImageCloseButton(getContext(), this.l, this.w);
                this.O = createImageCloseButton;
                createImageCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.view.AdViewImpl.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        AdViewImpl.this.A();
                    }
                });
            }
            if (i2 > 0) {
                this.ae = i2;
            } else if (i > 0) {
                this.ae = i;
            }
            if (this.ae > 0) {
                this.O.setVisibility(8);
                this.M = ViewUtil.createInterstitialCountDown(getContext(), this.l, this.w);
                com.octopus.ad.a.a aVar = new com.octopus.ad.a.a(this.ae * 1000, 50L);
                this.P = aVar;
                aVar.a(new com.octopus.ad.a.b() { // from class: com.octopus.ad.internal.view.AdViewImpl.6
                    @Override // com.octopus.ad.a.b
                    public void a(long j) {
                        if (AdViewImpl.this.M == null) {
                            return;
                        }
                        AdViewImpl.this.M.setText(String.valueOf((int) ((j / 1000) + 1)));
                    }

                    @Override // com.octopus.ad.a.b
                    public void b() {
                    }

                    @Override // com.octopus.ad.a.b
                    public void a() {
                        ServerResponse serverResponse = AdViewImpl.this.f12542a;
                        if (serverResponse == null || !serverResponse.A()) {
                            if (AdViewImpl.this.M == null || AdViewImpl.this.O == null) {
                                return;
                            }
                            AdViewImpl.this.M.setVisibility(8);
                            AdViewImpl.this.O.setVisibility(0);
                            return;
                        }
                        if (AdViewImpl.this.M != null) {
                            AdViewImpl.this.M.setText(Constants.FAIL);
                        }
                        AdViewImpl.this.K = true;
                        AdViewImpl.this.C();
                    }
                });
                this.P.a();
            }
            ViewParent parent = view instanceof FrameLayout ? (FrameLayout) view : view.getParent();
            if (parent instanceof FrameLayout) {
                ImageView imageView = this.O;
                if (imageView != null) {
                    ((FrameLayout) parent).addView(imageView);
                }
                AppCompatTextView appCompatTextView = this.M;
                if (appCompatTextView != null) {
                    ((FrameLayout) parent).addView(appCompatTextView);
                }
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void a(int i) {
        try {
            com.octopus.ad.a.a aVar = this.P;
            if (aVar != null) {
                aVar.d();
            }
            if (i <= 0) {
                this.ae = 5;
            } else {
                this.ae = i;
            }
            this.M = ViewUtil.createCountDown(getContext(), this.ae, this.l, this.m, this.w);
            com.octopus.ad.a.a aVar2 = new com.octopus.ad.a.a(this.ae * 1000, 50L);
            this.P = aVar2;
            aVar2.a(new com.octopus.ad.a.b() { // from class: com.octopus.ad.internal.view.AdViewImpl.7
                @Override // com.octopus.ad.a.b
                public void a(long j) {
                    try {
                        if (AdViewImpl.this.M == null) {
                            return;
                        }
                        AdViewImpl.this.getAdDispatcher().a(j);
                        int i2 = (int) ((j / 1000) + 1);
                        AppCompatTextView appCompatTextView = AdViewImpl.this.M;
                        Locale locale = Locale.US;
                        appCompatTextView.setText("跳过 " + i2);
                    } catch (Exception unused) {
                    }
                }

                @Override // com.octopus.ad.a.b
                public void b() {
                }

                @Override // com.octopus.ad.a.b
                public void a() {
                    try {
                        if (AdViewImpl.this.M != null) {
                            AdViewImpl.this.M.setText("跳过 0");
                        }
                        a aVar3 = AdViewImpl.this.b;
                        if (aVar3 != null) {
                            aVar3.a(true);
                            if (AdViewImpl.this.b.a()) {
                                if (AdViewImpl.this.b.c() == a.EnumC0417a.UNCHANGE || AdViewImpl.this.b.c() == a.EnumC0417a.STATE_PREPARE_CHANGE) {
                                    AdViewImpl.this.K = true;
                                    if (AdViewImpl.this.getAdDispatcher() != null) {
                                        AdViewImpl.this.getAdDispatcher().a();
                                    }
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            });
            this.P.a();
            ServerResponse serverResponse = this.f12542a;
            if (serverResponse != null) {
                this.al = serverResponse.R();
                this.f12542a.a(this.P);
            }
            this.M.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.view.AdViewImpl.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdViewImpl.this.A();
                }
            });
            AppCompatTextView appCompatTextView = this.M;
            if (appCompatTextView != null) {
                ViewUtil.removeChildFromParent(appCompatTextView);
                addView(this.M);
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void a(int i, int i2, int i3) {
        try {
            ViewUtil.removeChildFromParent(this.O);
            ViewUtil.removeChildFromParent(this.M);
            com.octopus.ad.a.a aVar = this.P;
            if (aVar != null) {
                aVar.d();
            }
            if (this.O == null) {
                ImageView createImageCloseButton = ViewUtil.createImageCloseButton(getContext(), this.l, 1.0f);
                this.O = createImageCloseButton;
                createImageCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.octopus.ad.internal.view.AdViewImpl.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (AdViewImpl.this.aF) {
                            AdViewImpl.this.A();
                            return;
                        }
                        View adView = AdViewImpl.this.getAdView();
                        if (adView == null) {
                            return;
                        }
                        AdViewImpl.this.b(adView.getContext());
                    }
                });
            }
            if (i != -1 && this.M == null) {
                this.m = 30;
                this.ae = Math.min(i, i3);
                this.M = ViewUtil.createCountDown(getContext(), this.ae, this.l, this.m, this.w);
                if (i2 > 0) {
                    this.O.setVisibility(8);
                    int i4 = this.ae;
                    if (i4 > i2) {
                        this.af = i4 - i2;
                    }
                }
                com.octopus.ad.a.a aVar2 = new com.octopus.ad.a.a(this.ae * 1000, 50L);
                this.P = aVar2;
                aVar2.a(new com.octopus.ad.a.b() { // from class: com.octopus.ad.internal.view.AdViewImpl.10
                    @Override // com.octopus.ad.a.b
                    public void a(long j) {
                        if (AdViewImpl.this.M == null || AdViewImpl.this.O == null || AdViewImpl.this.aF) {
                            return;
                        }
                        int i5 = (int) ((j / 1000) + 1);
                        AppCompatTextView appCompatTextView = AdViewImpl.this.M;
                        Locale locale = Locale.US;
                        appCompatTextView.setText("奖励将于 " + i5 + " 秒后发放");
                        if (i5 <= AdViewImpl.this.af && AdViewImpl.this.O.getVisibility() == 8) {
                            AdViewImpl.this.O.setVisibility(0);
                        }
                        if (AdViewImpl.this.ae - i5 == 2 && AdViewImpl.this.aj) {
                            AdViewImpl.this.H();
                        }
                    }

                    @Override // com.octopus.ad.a.b
                    public void b() {
                    }

                    @Override // com.octopus.ad.a.b
                    public void a() {
                        if (AdViewImpl.this.O != null) {
                            AdViewImpl.this.O.setVisibility(0);
                        }
                        AdViewImpl.this.q();
                        AdViewImpl.this.p();
                        ServerResponse serverResponse = AdViewImpl.this.f12542a;
                        if (serverResponse == null || !serverResponse.A()) {
                            if (AdViewImpl.this.au == null) {
                                AdViewImpl.this.v();
                            }
                        } else {
                            AdViewImpl.this.K = true;
                            AdViewImpl.this.C();
                        }
                    }
                });
                this.P.a();
                AdVideoView adVideoView = this.au;
                if (adVideoView != null) {
                    adVideoView.setCountDownTimer(this.P);
                }
            }
            View adView = getAdView();
            if (adView == null) {
                return;
            }
            ViewParent parent = adView instanceof FrameLayout ? (FrameLayout) adView : adView.getParent();
            if (parent instanceof FrameLayout) {
                ImageView imageView = this.O;
                if (imageView != null) {
                    ((FrameLayout) parent).addView(imageView);
                }
                AppCompatTextView appCompatTextView = this.M;
                if (appCompatTextView != null) {
                    ((FrameLayout) parent).addView(appCompatTextView);
                }
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void a(HashMap hashMap) {
        if (!hashMap.isEmpty() && hashMap.containsKey("REWARD_ITEM")) {
            String str = (String) hashMap.get("REWARD_ITEM");
            try {
                if (str == null) {
                    this.aE = Pair.create("", 0);
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                this.aC = jSONObject.optString("callback_url");
                this.aE = Pair.create(jSONObject.optString("name"), Integer.valueOf(jSONObject.optInt("amount")));
                if (TextUtils.isEmpty(this.aC) || getAdParameters() == null) {
                    return;
                }
                String extraData = getExtraData();
                if (!TextUtils.isEmpty(extraData)) {
                    this.aC += "&extra=" + extraData;
                }
                String userId = getUserId();
                if (TextUtils.isEmpty(userId)) {
                    return;
                }
                this.aC += "&userId=" + userId;
            } catch (JSONException unused) {
                HaoboLog.e(HaoboLog.jsonLogTag, "Error parse reward item: " + str);
                this.aE = Pair.create("", 0);
            }
        }
    }

    public void a(String str, int i) {
        RewardVideoAdListener rewardVideoAdListener;
        if (!this.I || (rewardVideoAdListener = this.A) == null) {
            return;
        }
        rewardVideoAdListener.onRewarded(new v(str, i));
    }

    private void a(c.u uVar) {
        View adView;
        try {
            if (this.aJ != null && uVar != null && (adView = getAdView()) != null) {
                this.aJ.a(uVar);
                this.aJ.a(adView);
                View a2 = this.aJ.a(adView, adView, 10.0f, uVar.e(), getMediaType(), false);
                if (a2 != null) {
                    if (uVar.b() == 1) {
                        this.at = 7;
                    }
                    this.aJ.a(new l.a() { // from class: com.octopus.ad.internal.view.AdViewImpl.18
                        @Override // com.octopus.ad.utils.l.a
                        public void a(com.octopus.ad.model.d dVar) {
                            AdViewImpl.this.a(dVar);
                            if (AdViewImpl.this.aM != null) {
                                AdViewImpl.this.aM.onShakeTrigger(1, dVar.o(), dVar.p());
                            }
                        }
                    });
                    final com.octopus.ad.model.d dVar = new com.octopus.ad.model.d(1);
                    if (uVar.i() == 1) {
                        a2.setOnTouchListener(new View.OnTouchListener() { // from class: com.octopus.ad.internal.view.AdViewImpl.19
                            @Override // android.view.View.OnTouchListener
                            @SuppressLint({"ClickableViewAccessibility"})
                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                AdViewImpl adViewImpl = AdViewImpl.this;
                                adViewImpl.a(motionEvent, adViewImpl.as, dVar);
                                return true;
                            }
                        });
                    } else {
                        a2.setOnClickListener(null);
                    }
                    ViewParent parent = adView instanceof FrameLayout ? (FrameLayout) adView : adView.getParent();
                    if ((parent instanceof FrameLayout) && uVar.g() == 1) {
                        ((FrameLayout) parent).addView(a2);
                    }
                }
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MotionEvent motionEvent, boolean z, com.octopus.ad.model.d dVar) {
        try {
            if (motionEvent.getAction() == 0) {
                dVar.a(motionEvent.getRawX());
                dVar.b(motionEvent.getRawY());
                dVar.a(String.valueOf(System.currentTimeMillis()));
                dVar.d(String.valueOf(System.currentTimeMillis()));
                dVar.c(String.valueOf(System.currentTimeMillis() / 1000));
                if (!z || this.J) {
                    return;
                }
                int a2 = i.a(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS) + 50;
                dVar.c(motionEvent.getRawX());
                dVar.d(motionEvent.getRawY());
                dVar.b(String.valueOf(System.currentTimeMillis() + a2));
                View adView = getAdView();
                if (adView != null) {
                    dVar.a(adView.getWidth());
                    dVar.b(adView.getHeight());
                }
                a(dVar);
                this.J = true;
                return;
            }
            if (motionEvent.getAction() == 1) {
                dVar.c(motionEvent.getRawX());
                dVar.d(motionEvent.getRawY());
                dVar.b(String.valueOf(System.currentTimeMillis()));
                View adView2 = getAdView();
                if (adView2 != null) {
                    dVar.a(adView2.getWidth());
                    dVar.b(adView2.getHeight());
                }
                a(dVar);
            }
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    private void a(String str) {
        View a2;
        try {
            com.octopus.ad.utils.k kVar = this.aK;
            if (kVar != null) {
                kVar.a();
                View adView = getAdView();
                if (adView == null || (a2 = this.aK.a(ViewUtil.px2dip(getContext(), adView.getWidth()), ViewUtil.px2dip(getContext(), adView.getHeight()), str)) == null) {
                    return;
                }
                a("up", 100, new k.a() { // from class: com.octopus.ad.internal.view.AdViewImpl.21
                    @Override // com.octopus.ad.utils.k.a
                    public void a(com.octopus.ad.model.d dVar) {
                        AdViewImpl.this.a(dVar);
                    }
                });
                ViewParent parent = adView instanceof FrameLayout ? (FrameLayout) adView : adView.getParent();
                if (parent instanceof FrameLayout) {
                    ((FrameLayout) parent).addView(a2);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void a(final String str, int i, final k.a aVar) {
        if (aVar != null) {
            this.aK.a(aVar);
        }
        final int dip2px = ViewUtil.dip2px(getContext(), i);
        final com.octopus.ad.model.d dVar = new com.octopus.ad.model.d(3);
        View adView = getAdView();
        if (adView == null) {
            return;
        }
        dVar.a(adView.getWidth());
        dVar.b(adView.getHeight());
        setScrollClick(new View.OnTouchListener() { // from class: com.octopus.ad.internal.view.AdViewImpl.26

            /* renamed from: a, reason: collision with root package name */
            float f12562a;
            float b;
            float c;
            float d;
            float e;
            float f;

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                k.a aVar2;
                k.a aVar3;
                k.a aVar4;
                k.a aVar5;
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f12562a = motionEvent.getX();
                    this.b = motionEvent.getY();
                    this.c = motionEvent.getX();
                    this.d = motionEvent.getY();
                    this.e = motionEvent.getRawX();
                    this.f = motionEvent.getRawY();
                    dVar.a(motionEvent.getRawX());
                    dVar.b(motionEvent.getRawY());
                    dVar.a(String.valueOf(System.currentTimeMillis()));
                    dVar.d(String.valueOf(System.currentTimeMillis()));
                    dVar.c(String.valueOf(System.currentTimeMillis() / 1000));
                } else if (action == 1) {
                    dVar.c(motionEvent.getRawX());
                    dVar.d(motionEvent.getRawY());
                    dVar.b(String.valueOf(System.currentTimeMillis()));
                    float f = this.d;
                    float f2 = this.b;
                    if (f - f2 <= 0.0f || Math.abs(f - f2) <= dip2px) {
                        float f3 = this.d;
                        float f4 = this.b;
                        if (f3 - f4 >= 0.0f || Math.abs(f3 - f4) <= dip2px) {
                            float f5 = this.c;
                            float f6 = this.f12562a;
                            if (f5 - f6 >= 0.0f || Math.abs(f5 - f6) <= dip2px) {
                                float f7 = this.c;
                                float f8 = this.f12562a;
                                if (f7 - f8 < 0.0f && Math.abs(f7 - f8) > dip2px && "right".equalsIgnoreCase(str) && (aVar2 = aVar) != null) {
                                    aVar2.a(dVar);
                                }
                            } else if ("left".equalsIgnoreCase(str) && (aVar3 = aVar) != null) {
                                aVar3.a(dVar);
                            }
                        } else if ("up".equalsIgnoreCase(str) && (aVar4 = aVar) != null) {
                            aVar4.a(dVar);
                        }
                    } else if ("down".equalsIgnoreCase(str) && (aVar5 = aVar) != null) {
                        aVar5.a(dVar);
                    }
                } else if (action == 2) {
                    this.c = motionEvent.getX();
                    this.d = motionEvent.getY();
                }
                return true;
            }
        });
    }

    public void a(View.OnTouchListener onTouchListener) {
        View adView = getAdView();
        if (adView == null) {
            return;
        }
        adView.setOnTouchListener(onTouchListener);
    }
}
