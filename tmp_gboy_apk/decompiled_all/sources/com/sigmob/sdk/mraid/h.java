package com.sigmob.sdk.mraid;

import ADYaiT.BChYOn;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.mta.DeviceContext;
import com.czhj.sdk.common.utils.IntentUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.CurrentAppOrientation;
import com.sigmob.sdk.base.models.ExposureChange;
import com.sigmob.sdk.base.models.ExtensionEvent;
import com.sigmob.sdk.base.models.MraidEnv;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.models.SensorEntity;
import com.sigmob.sdk.base.models.VideoItem;
import com.sigmob.sdk.base.models.ViewState;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.mraid.b;
import com.sigmob.sdk.nativead.APKStatusBroadcastReceiver;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAds;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class h {
    private boolean A;
    private com.sigmob.sdk.base.common.g B;
    private WindowInsets C;

    /* renamed from: a, reason: collision with root package name */
    private final PlacementType f13465a;
    private final BaseAdUnit b;
    private final FrameLayout c;
    private final d d;
    private final q e;
    private final com.sigmob.sdk.mraid.c f;
    private final m g;
    private boolean h;
    private Integer i;
    private String j;
    private ViewGroup k;
    private ViewState l;
    private a m;
    private e n;
    private x o;
    private f p;
    private v q;
    private c r;
    private Integer s;
    private boolean t;
    private p u;
    private boolean v;
    private final HashMap<String, n> w;
    private final com.sigmob.sdk.mraid.e x;
    private final com.sigmob.sdk.mraid.d y;
    private APKStatusBroadcastReceiver z;

    public interface a {
        void a();

        void a(float f);

        void a(int i, int i2, int i3, int i4, b.a aVar, boolean z);

        void a(View view);

        void a(WindAdError windAdError);

        void a(String str);

        void a(URI uri, int i, String str);

        void a(boolean z);

        void b();

        void b(float f);

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();
    }

    public interface b {
        void onReady(v vVar, com.sigmob.sdk.base.common.u uVar);
    }

    public class c extends BroadcastReceiver {
        private Context b;
        private int c = -1;

        public c() {
        }

        public void a() {
            Context context = this.b;
            if (context == null) {
                return;
            }
            context.unregisterReceiver(this);
            this.b = null;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int x;
            if (this.b == null || h.this.v || !"android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) || (x = h.this.x()) == this.c) {
                return;
            }
            this.c = x;
            h.this.a(x);
        }

        public void a(Context context) {
            Preconditions.checkNotNull(context);
            Context applicationContext = context.getApplicationContext();
            this.b = applicationContext;
            if (applicationContext == null) {
                return;
            }
            IntentUtil.registerReceiver(applicationContext, this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f13473a = new Handler();
        private a b;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            int f13474a;
            private final View[] b;
            private final Handler c;
            private Runnable d;
            private final Runnable e;

            private a(Handler handler, View[] viewArr) {
                this.e = new Runnable() { // from class: com.sigmob.sdk.mraid.h.d.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (final View view : a.this.b) {
                            if (view.getHeight() > 0 || view.getWidth() > 0) {
                                a.this.b();
                            } else {
                                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.sigmob.sdk.mraid.h.d.a.1.1
                                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                                    public boolean onPreDraw() {
                                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                                        a.this.b();
                                        return true;
                                    }
                                });
                            }
                        }
                    }
                };
                this.c = handler;
                this.b = viewArr;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void b() {
                Runnable runnable;
                int i = this.f13474a - 1;
                this.f13474a = i;
                if (i != 0 || (runnable = this.d) == null) {
                    return;
                }
                runnable.run();
                this.d = null;
            }

            public void a() {
                this.c.removeCallbacks(this.e);
                this.d = null;
            }

            public void a(Runnable runnable) {
                this.d = runnable;
                this.f13474a = this.b.length;
                this.c.post(this.e);
            }
        }

        public a a(View... viewArr) {
            a aVar = new a(this.f13473a, viewArr);
            this.b = aVar;
            return aVar;
        }

        public void a() {
            a aVar = this.b;
            if (aVar == null) {
                return;
            }
            aVar.a();
            this.b = null;
        }
    }

    public interface e {
        void useCustomCloseChanged(boolean z);
    }

    public interface f {
        void a();

        void a(Integer num);

        void a(Map<String, String> map);

        void b();

        void b(Map<String, String> map);

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();
    }

    public h(Context context, BaseAdUnit baseAdUnit, PlacementType placementType) {
        this(context, baseAdUnit, placementType, new com.sigmob.sdk.mraid.c(baseAdUnit, placementType), null, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A() {
        e eVar = this.n;
        if (eVar == null) {
            return;
        }
        eVar.useCustomCloseChanged(this.h);
    }

    private float a(String str, float f2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Float.parseFloat(str);
            } catch (Throwable unused) {
            }
        }
        return f2;
    }

    private Context w() {
        FrameLayout frameLayout = this.c;
        if (frameLayout == null) {
            return null;
        }
        return frameLayout.getContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x() {
        return ClientMetadata.getInstance().getScreenOrientation(w());
    }

    private void y() {
        this.f.b();
        this.q = null;
    }

    private ViewGroup z() {
        ViewGroup viewGroup = this.k;
        if (viewGroup != null) {
            return viewGroup;
        }
        View a2 = com.sigmob.sdk.base.utils.r.a(w(), this.c);
        ViewGroup viewGroup2 = a2 instanceof ViewGroup ? (ViewGroup) a2 : this.c;
        this.k = viewGroup2;
        return viewGroup2;
    }

    public v g() {
        return this.q;
    }

    public void i() {
        Context w = w();
        if (w == null) {
            return;
        }
        String str = ClientMetadata.getInstance().getOrientationInt().intValue() == 1 ? "portrait" : "landscape";
        DisplayMetrics displayMetrics = w.getResources().getDisplayMetrics();
        com.sigmob.sdk.base.common.g gVar = this.B;
        if (gVar == null) {
            this.e.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            this.e.a(gVar.a(), this.B.b());
        }
        ViewGroup z = z();
        int measuredWidth = z.getMeasuredWidth();
        int measuredHeight = z.getMeasuredHeight();
        this.e.a(0, 0, measuredWidth, measuredHeight);
        this.e.c(0, 0, measuredWidth, measuredHeight);
        this.e.b(0, 0, measuredWidth, measuredHeight);
        this.f.a(new CurrentAppOrientation(str, true));
        this.f.a(this.e);
    }

    @SuppressLint({"JavascriptInterface"})
    public void j() {
        Context w = w();
        if (w == null) {
            return;
        }
        WindAds.sharedAds().getHandler().post(new BChYOn(this, 28, w));
    }

    @SuppressLint({"JavascriptInterface"})
    public void k() {
        try {
            this.A = true;
            i();
            b(ViewState.DEFAULT);
            d();
            this.f.e();
            this.f.a(true);
            try {
                this.f.j();
                o();
                DeviceContext b2 = com.sigmob.sdk.b.b();
                this.f.a(b2 != null ? b2.getLocation() : ClientMetadata.getInstance().getLocation());
            } catch (Throwable unused) {
                SigmobLog.e("Failed to apply orientation.");
            }
        } catch (Throwable th) {
            SigmobLog.e("handlePageLoad error", th);
        }
    }

    public void l() {
        this.v = false;
        v vVar = this.q;
        if (vVar != null) {
            vVar.onResume();
        }
    }

    public void m() {
        this.d.a();
        this.n = null;
        this.m = null;
        Iterator<n> it = this.w.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.w.clear();
        try {
            this.r.a();
        } catch (Throwable unused) {
        }
        try {
            APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = this.z;
            if (aPKStatusBroadcastReceiver != null) {
                aPKStatusBroadcastReceiver.b(aPKStatusBroadcastReceiver);
            }
        } catch (Throwable unused2) {
        }
        if (!this.v) {
            d(true);
        }
        y();
        p();
    }

    public void n() {
        ViewState viewState;
        ViewState viewState2;
        if (this.q == null || (viewState = this.l) == ViewState.LOADING || viewState == (viewState2 = ViewState.HIDDEN)) {
            return;
        }
        ViewState viewState3 = ViewState.EXPANDED;
        if (viewState == viewState3 || this.f13465a == PlacementType.INTERSTITIAL) {
            p();
        }
        ViewState viewState4 = this.l;
        if (viewState4 == ViewState.RESIZED || viewState4 == viewState3) {
            this.c.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
            this.c.setVisibility(0);
            b(ViewState.DEFAULT);
        } else if (viewState4 == ViewState.DEFAULT) {
            this.c.setVisibility(4);
            b(viewState2);
        }
    }

    public void o() {
        int a2;
        p pVar = this.u;
        if (pVar != p.NONE) {
            a2 = pVar.a();
        } else {
            if (this.t) {
                p();
                return;
            }
            Activity c2 = com.sigmob.sdk.base.utils.r.c(this.c);
            if (c2 == null) {
                throw new com.sigmob.sdk.mraid.f("Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
            }
            a2 = ClientMetadata.getInstance().getScreenOrientation(c2);
        }
        b(a2);
    }

    public void p() {
        Integer num;
        try {
            Activity c2 = com.sigmob.sdk.base.utils.r.c(this.c);
            if (c2 != null && (num = this.s) != null) {
                c2.setRequestedOrientation(num.intValue());
            }
            this.s = null;
        } catch (Exception e2) {
            SigmobLog.e("unApplyOrientation: " + e2.getMessage());
        }
    }

    public FrameLayout q() {
        return this.c;
    }

    @Deprecated
    public ViewState r() {
        return this.l;
    }

    @Deprecated
    public Integer s() {
        return this.s;
    }

    @Deprecated
    public boolean t() {
        return this.t;
    }

    @Deprecated
    public p u() {
        return this.u;
    }

    @Deprecated
    public v v() {
        return this.q;
    }

    public h(Context context, BaseAdUnit baseAdUnit, PlacementType placementType, com.sigmob.sdk.mraid.c cVar, com.sigmob.sdk.mraid.c cVar2, d dVar) {
        this.h = false;
        ViewState viewState = ViewState.LOADING;
        this.l = viewState;
        this.r = new c();
        this.t = true;
        this.u = p.NONE;
        this.v = false;
        this.w = new HashMap<>();
        com.sigmob.sdk.mraid.e eVar = new com.sigmob.sdk.mraid.e() { // from class: com.sigmob.sdk.mraid.h.1
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.sigmob.sdk.mraid.e
            public void a(String str, JSONObject jSONObject) {
                char c2;
                SigmobLog.d("handleVpaidEvent event:" + str);
                SigmobLog.d("postMessage args:" + jSONObject);
                String optString = jSONObject.optString("uniqueId");
                if (TextUtils.isEmpty(optString) || h.this.q == null) {
                    SigmobLog.e("handleVpaidEvent uniqueId is null:" + jSONObject);
                    return;
                }
                n nVar = (n) h.this.w.get(optString);
                t tVar = (com.sigmob.sdk.base.utils.q.b(nVar) && (nVar instanceof t)) ? (t) nVar : null;
                str.getClass();
                switch (str.hashCode()) {
                    case -934524953:
                        if (str.equals("replay")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -373213089:
                        if (str.equals("assetURL")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3237136:
                        if (str.equals("init")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3443508:
                        if (str.equals(PointCategory.PLAY)) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3526264:
                        if (str.equals("seek")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3540994:
                        if (str.equals("stop")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 97692013:
                        if (str.equals("frame")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 104264043:
                        if (str.equals("muted")) {
                            c2 = 7;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 106440182:
                        if (str.equals(com.sigmob.sdk.base.common.a.j)) {
                            c2 = '\b';
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        if (tVar != null) {
                            tVar.c(jSONObject);
                            break;
                        }
                        break;
                    case 1:
                        if (tVar != null) {
                            tVar.a(jSONObject);
                            break;
                        }
                        break;
                    case 2:
                        t tVar2 = new t(optString);
                        tVar2.a(new u() { // from class: com.sigmob.sdk.mraid.h.1.1
                            @Override // com.sigmob.sdk.mraid.u
                            public void a(String str2, int i) {
                                if (h.this.f == null) {
                                    return;
                                }
                                h.this.f.c(str2, i);
                            }

                            @Override // com.sigmob.sdk.mraid.u
                            public void b(String str2, int i) {
                                if (h.this.f == null) {
                                    return;
                                }
                                h.this.f.b(str2, i);
                            }

                            @Override // com.sigmob.sdk.mraid.u
                            public void a(String str2, int i, String str3) {
                                ae.a("video", i, str3, h.this.b);
                                if (h.this.f == null) {
                                    return;
                                }
                                h.this.f.b(str2, "code:" + i + ", msg:" + str3);
                            }

                            @Override // com.sigmob.sdk.mraid.u
                            public void a(String str2, long j) {
                                if (h.this.f == null) {
                                    return;
                                }
                                h.this.f.a(str2, (int) j);
                            }

                            @Override // com.sigmob.sdk.mraid.u
                            public void a(String str2, long j, int i, int i2) {
                                if (h.this.f == null) {
                                    return;
                                }
                                h.this.f.a(str2, (int) j, i, i2);
                            }

                            @Override // com.sigmob.sdk.mraid.u
                            public void a(String str2, long j, long j2) {
                                if (h.this.f == null) {
                                    return;
                                }
                                h.this.f.a(str2, (int) j, (int) j2);
                            }
                        });
                        h.this.w.put(optString, tVar2);
                        tVar2.a(h.this.q.getContext(), jSONObject);
                        View a2 = tVar2.a();
                        if (a2 != null) {
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(1, 1);
                            layoutParams.topMargin = -1;
                            layoutParams.rightMargin = -1;
                            h.this.c.addView(a2, layoutParams);
                            break;
                        }
                        break;
                    case 3:
                        if (tVar != null) {
                            tVar.b(jSONObject);
                            break;
                        }
                        break;
                    case 4:
                        if (tVar != null) {
                            tVar.g(jSONObject);
                            break;
                        }
                        break;
                    case 5:
                        if (tVar != null) {
                            tVar.e(jSONObject);
                            tVar.b();
                            h.this.w.remove(optString);
                            break;
                        }
                        break;
                    case 6:
                        if (tVar != null) {
                            tVar.h(jSONObject);
                            break;
                        }
                        break;
                    case 7:
                        if (tVar != null) {
                            tVar.f(jSONObject);
                            break;
                        }
                        break;
                    case '\b':
                        if (tVar != null) {
                            tVar.d(jSONObject);
                            break;
                        }
                        break;
                }
            }

            @Override // com.sigmob.sdk.mraid.e
            public void b(String str, JSONObject jSONObject) {
                n nVar;
                String optString = jSONObject.optString("uniqueId");
                if (TextUtils.isEmpty(optString) || (nVar = (n) h.this.w.get(optString)) == null || nVar.a() == null) {
                    return;
                }
                h.this.c.bringChildToFront(h.this.q);
            }

            @Override // com.sigmob.sdk.mraid.e
            public void c(String str, JSONObject jSONObject) {
                n nVar;
                View a2;
                String optString = jSONObject.optString("uniqueId");
                if (TextUtils.isEmpty(optString) || (nVar = (n) h.this.w.get(optString)) == null || (a2 = nVar.a()) == null) {
                    return;
                }
                com.sigmob.sdk.base.utils.r.a(a2);
                h.this.c.addView(a2);
            }

            @Override // com.sigmob.sdk.mraid.e
            public void d(String str, JSONObject jSONObject) {
                com.sigmob.sdk.mraid2.h hVar;
                SigmobLog.d("postMessage subEvent data:" + jSONObject);
                String optString = jSONObject.optString("uniqueId");
                if (TextUtils.isEmpty(optString)) {
                    SigmobLog.e("onMotionViewEvent uniqueId is null:" + jSONObject);
                }
                n nVar = (n) h.this.w.get(optString);
                hVar = nVar instanceof com.sigmob.sdk.mraid2.h ? (com.sigmob.sdk.mraid2.h) nVar : null;
                str.getClass();
                switch (str) {
                    case "init_sensitivity_raw":
                        String optString2 = jSONObject.optString(PointParamKey.TYPE, "");
                        int optInt = jSONObject.optInt(g.c, 0);
                        com.sigmob.sdk.mraid2.h hVar2 = new com.sigmob.sdk.mraid2.h(optString, optString2);
                        hVar2.a(new com.sigmob.sdk.mraid2.k() { // from class: com.sigmob.sdk.mraid.h.1.3
                            @Override // com.sigmob.sdk.mraid2.k
                            public void a(String str2, String str3, String str4, HashMap<String, Object> hashMap) {
                                if (h.this.f == null) {
                                    return;
                                }
                                h.this.f.a(str2, str3, str4, hashMap);
                            }
                        });
                        hVar2.b(optInt);
                        hVar2.d();
                        h.this.w.put(optString, hVar2);
                        break;
                    case "init":
                        String optString3 = jSONObject.optString(PointParamKey.TYPE, "");
                        int optInt2 = jSONObject.optInt(g.b, 0);
                        int optInt3 = jSONObject.optInt(g.e, 0);
                        int optInt4 = jSONObject.optInt(g.f, 0);
                        int optInt5 = jSONObject.optInt(g.g, 0);
                        com.sigmob.sdk.mraid2.h hVar3 = new com.sigmob.sdk.mraid2.h(optString, optString3);
                        hVar3.a(new com.sigmob.sdk.mraid2.k() { // from class: com.sigmob.sdk.mraid.h.1.2
                            @Override // com.sigmob.sdk.mraid2.k
                            public void a(String str2, String str3, String str4, HashMap<String, Object> hashMap) {
                                if (h.this.f == null) {
                                    return;
                                }
                                h.this.f.a(str2, str3, str4, hashMap);
                            }
                        });
                        hVar3.a(new SensorEntity(optInt2, optInt3, optInt4, optInt5));
                        hVar3.d();
                        h.this.w.put(optString, hVar3);
                        break;
                    case "destroy":
                        if (hVar != null) {
                            hVar.b();
                        }
                        h.this.w.remove(optString);
                        break;
                }
            }

            @Override // com.sigmob.sdk.mraid.e
            public void e(String str, JSONObject jSONObject) {
                l lVar;
                SigmobLog.d("onMotionViewEvent event:" + str);
                SigmobLog.d("postMessage args:" + jSONObject);
                String optString = jSONObject.optString("uniqueId");
                if (TextUtils.isEmpty(optString)) {
                    SigmobLog.e("onMotionViewEvent uniqueId is null:" + jSONObject);
                }
                n nVar = (n) h.this.w.get(optString);
                lVar = (com.sigmob.sdk.base.utils.q.b(nVar) && (nVar instanceof l)) ? (l) nVar : null;
                str.getClass();
                switch (str) {
                    case "shakeTimeThreshold":
                        if (lVar != null) {
                            lVar.e(jSONObject.optInt(str));
                            break;
                        }
                        break;
                    case "widgetIntervalTime":
                        if (lVar != null) {
                            lVar.d(jSONObject.optInt(str));
                            break;
                        }
                        break;
                    case "hidden":
                        if (lVar != null) {
                            lVar.a(jSONObject.optBoolean("hidden"));
                            break;
                        }
                        break;
                    case "init":
                        l lVar2 = new l(com.sigmob.sdk.b.e(), optString, jSONObject.optInt(PointParamKey.TYPE), h.this.b);
                        lVar2.a(new com.sigmob.sdk.mraid2.k() { // from class: com.sigmob.sdk.mraid.h.1.4
                            @Override // com.sigmob.sdk.mraid2.k
                            public void a(String str2, String str3, String str4, HashMap<String, Object> hashMap) {
                                if (h.this.f == null) {
                                    return;
                                }
                                h.this.f.a(str2, str3, str4, hashMap);
                            }
                        });
                        h.this.w.put(optString, lVar2);
                        break;
                    case "frame":
                        if (lVar != null) {
                            lVar.a(jSONObject);
                            break;
                        }
                        break;
                    case "start":
                        if (lVar != null) {
                            lVar.d();
                            break;
                        }
                        break;
                    case "sensitivity":
                        if (lVar != null) {
                            lVar.a(jSONObject.optInt(str));
                            break;
                        }
                        break;
                    case "destroy":
                        if (lVar != null) {
                            lVar.b();
                        }
                        h.this.w.remove(optString);
                        break;
                    case "sensitivity_raw":
                        if (lVar != null) {
                            lVar.b(jSONObject.optInt(str));
                            break;
                        }
                        break;
                    case "shakeTriggerType":
                        if (lVar != null) {
                            lVar.c(jSONObject.optInt(str));
                            break;
                        }
                        break;
                }
            }
        };
        this.x = eVar;
        com.sigmob.sdk.mraid.d dVar2 = new com.sigmob.sdk.mraid.d() { // from class: com.sigmob.sdk.mraid.h.2
            @Override // com.sigmob.sdk.mraid.d
            public void a() {
                h.this.k();
                if (h.this.m != null) {
                    h.this.m.a(h.this.c);
                }
            }

            @Override // com.sigmob.sdk.mraid.d
            public void b() {
                h.this.j();
            }

            @Override // com.sigmob.sdk.mraid.d
            public void c() {
                if (h.this.m != null) {
                    h.this.m.e();
                }
            }

            @Override // com.sigmob.sdk.mraid.d
            public void d() {
                h.this.n();
                h.this.m.h();
            }

            @Override // com.sigmob.sdk.mraid.d
            public void e() {
                if (h.this.m != null) {
                    h.this.m.f();
                }
            }

            @Override // com.sigmob.sdk.mraid.d
            public void f() {
                if (h.this.m != null) {
                    h.this.m.g();
                }
            }

            @Override // com.sigmob.sdk.mraid.d
            public void g() {
                if (h.this.m != null) {
                    h.this.m.c();
                }
            }

            @Override // com.sigmob.sdk.mraid.d
            public void a(int i, int i2, int i3, int i4, b.a aVar, boolean z) {
                if (h.this.m != null) {
                    h.this.m.a(i, i2, i3, i4, aVar, z);
                }
            }

            @Override // com.sigmob.sdk.mraid.d
            public void b(String str, Map<String, String> map) {
                h.this.a(str, map);
            }

            @Override // com.sigmob.sdk.mraid.d
            public void a(WindAdError windAdError) {
                h.this.a(windAdError);
            }

            @Override // com.sigmob.sdk.mraid.d
            public void b(boolean z) {
                h.this.e(z);
            }

            @Override // com.sigmob.sdk.mraid.d
            public void a(String str, Map<String, String> map) {
                h.this.b(str, map);
            }

            @Override // com.sigmob.sdk.mraid.d
            public void a(URI uri) {
                h.this.a(uri.toString());
            }

            @Override // com.sigmob.sdk.mraid.d
            public void a(URI uri, int i, String str) {
                h.this.a(uri, i, str);
            }

            @Override // com.sigmob.sdk.mraid.d
            public void a(URI uri, boolean z) {
                h.this.a(uri, z);
            }

            @Override // com.sigmob.sdk.mraid.d
            public void a(boolean z) {
                h.this.f.a(z);
            }

            @Override // com.sigmob.sdk.mraid.d
            public void a(boolean z, p pVar) {
                h.this.a(z, pVar);
            }

            @Override // com.sigmob.sdk.mraid.d
            public boolean a(ConsoleMessage consoleMessage) {
                return h.this.a(consoleMessage);
            }

            @Override // com.sigmob.sdk.mraid.d
            public boolean a(String str, JsResult jsResult) {
                return h.this.a(str, jsResult);
            }
        };
        this.y = dVar2;
        Preconditions.checkNotNull(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.c = frameLayout;
        this.b = baseAdUnit;
        this.f13465a = placementType;
        this.f = cVar;
        this.d = dVar;
        this.l = viewState;
        this.e = new q(context, context.getResources().getDisplayMetrics().density);
        frameLayout.setBackgroundColor(0);
        new View(context).setOnTouchListener(new HFjH17.AMqCpz(2));
        this.r.a(context);
        cVar.a(dVar2);
        cVar.a(eVar);
        this.g = new m();
    }

    public int a(int i, int i2, int i3) {
        return Math.max(i, Math.min(i2, i3));
    }

    public void b() {
        this.v = true;
        this.f.a(false);
    }

    public void c() {
        v vVar = this.q;
        if (vVar != null) {
            vVar.resumeTimers();
        }
        if (this.v) {
            this.f.a(true);
        }
        this.v = false;
    }

    public void d() {
        this.f.a(new ExposureChange(100.0f, new Rect(0, 0, z().getWidth(), z().getHeight()), null));
    }

    public com.sigmob.sdk.mraid.c e() {
        return this.f;
    }

    public Integer f() {
        Integer num = this.i;
        if (num != null) {
            return num;
        }
        this.f.b(new AMqCpz(1, this));
        return 0;
    }

    public boolean h() {
        Activity c2 = com.sigmob.sdk.base.utils.r.c(this.c);
        if (c2 == null || g() == null) {
            return false;
        }
        if (this.f13465a != PlacementType.INLINE) {
            return true;
        }
        return this.g.a(c2, g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        Float valueOf;
        try {
            if (str.equalsIgnoreCase("null") || str.equalsIgnoreCase("undefined") || (valueOf = Float.valueOf(str)) == null || valueOf.floatValue() <= 1.0E-5d) {
                return;
            }
            Integer valueOf2 = Integer.valueOf((int) (valueOf.floatValue() * 1000.0f));
            this.i = valueOf2;
            f fVar = this.p;
            if (fVar != null) {
                fVar.a(valueOf2);
            }
        } catch (Throwable unused) {
        }
    }

    public void b(int i) {
        Activity c2 = com.sigmob.sdk.base.utils.r.c(this.c);
        if (c2 == null || !a(this.u)) {
            throw new com.sigmob.sdk.mraid.f("Attempted to lock orientation to unsupported value: " + this.u.name());
        }
        if (this.s == null) {
            this.s = Integer.valueOf(c2.getRequestedOrientation());
        }
        try {
            c2.setRequestedOrientation(i);
        } catch (Exception e2) {
            SigmobLog.e("lockOrientation: " + e2.getMessage());
        }
    }

    public void d(boolean z) {
        this.v = true;
        v vVar = this.q;
        if (vVar != null) {
            vVar.b(z);
        }
    }

    public void e(boolean z) {
        this.h = z;
        e eVar = this.n;
        if (eVar == null) {
            return;
        }
        eVar.useCustomCloseChanged(z);
    }

    private void b(ViewState viewState) {
        SigmobLog.d("MRAID state set to " + viewState);
        ViewState viewState2 = this.l;
        this.l = viewState;
        this.f.a(viewState);
        a aVar = this.m;
        if (aVar != null) {
            a(aVar, viewState2, viewState);
        }
        SigmobLog.d("setViewState state set to " + viewState);
        a((Runnable) null);
    }

    public String a() {
        return this.f.a();
    }

    public void c(boolean z) {
        if (z) {
            this.f.i();
        }
    }

    public void a(int i) {
        SigmobLog.i("handleOrientationChange " + i);
        a((Runnable) null);
    }

    @Deprecated
    public void a(int i, int i2) {
        this.e.a(0, 0, i, i2);
    }

    public void b(String str) {
        this.f.c(str);
    }

    public void a(int i, int i2, int i3, int i4, b.a aVar, boolean z) {
    }

    public void b(String str, b bVar) {
        v vVar = new v(w());
        this.q = vVar;
        vVar.a(true);
        this.q.setBackgroundColor(0);
        if (bVar != null) {
            bVar.onReady(this.q, (com.sigmob.sdk.base.common.u) this.b.getSessionManager());
        }
        this.f.a(this.q);
        this.c.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        this.f.b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, Map<String, String> map) {
        if (this.p == null) {
            return;
        }
        str.getClass();
        switch (str) {
            case "AdPaused":
                this.p.b();
                break;
            case "AdImpression":
                this.p.a();
                break;
            case "AdVideoThirdQuartile":
                this.p.f();
                break;
            case "AdVideoMidpoint":
                this.p.g();
                break;
            case "AdVideoComplete":
                this.p.d();
                break;
            case "AdVideoFirstQuartile":
                this.p.e();
                break;
            case "AdError":
                this.p.b(map);
                break;
            case "AdVideoStart":
                this.p.h();
                break;
            case "AdClickThru":
                this.p.a(map);
                break;
            case "AdPlaying":
                this.p.c();
                break;
        }
    }

    public void a(Activity activity) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.sigmob.sdk.mraid.A2egSU
            @Override // java.lang.Runnable
            public final void run() {
                h.this.A();
            }
        }, 5000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context) {
        try {
            this.f.a(new MraidEnv());
            this.f.a(this.g.b(context), this.g.a(context), m.d(context), m.c(context), h(), true, true);
            this.f.a(this.f13465a);
            this.f.a(this.b.getRvAdSetting());
            WindowInsets windowInsets = this.C;
            if (windowInsets != null) {
                com.sigmob.sdk.base.utils.j a2 = com.sigmob.sdk.videoplayer.c.a(windowInsets);
                this.f.a(a2.a(), a2.b(), a2.c(), a2.d());
            }
            if (!TextUtils.isEmpty(this.b.getVideo_url())) {
                String proxyVideoUrl = this.b.getProxyVideoUrl();
                this.f.a(this.b.getMaterial().video_size != null ? new VideoItem(proxyVideoUrl, this.b.getMaterial().video_size.width.intValue(), this.b.getMaterial().video_size.height.intValue()) : new VideoItem(proxyVideoUrl, 0, 0));
                f();
            }
            MaterialMeta.Builder newBuilder = this.b.getMaterial().newBuilder();
            if (!this.b.getMaterial().has_companion_endcard.booleanValue()) {
                newBuilder.companion(null);
            }
            this.f.a(newBuilder.html_snippet(null).html_url(null).deeplink_url(null).landing_page(null).web_event_handle(null).endcard_url(null).build());
            this.f.a(this.b.getAd().newBuilder().materials(new LinkedList()).ad_tracking(new LinkedList()).build(), this.b.getSlotAdSetting());
        } catch (Throwable th) {
            SigmobLog.e("handleMraidLoad", th);
        }
        if (this.A) {
            k();
        }
    }

    public void b(boolean z) {
        if (z) {
            this.f.h();
        } else {
            this.f.g();
        }
    }

    public void a(WindowInsets windowInsets) {
        this.C = windowInsets;
        SigmobLog.d("updateWindowInsets " + windowInsets);
        if (this.A) {
            com.sigmob.sdk.base.utils.j a2 = com.sigmob.sdk.videoplayer.c.a(windowInsets);
            com.sigmob.sdk.mraid.c cVar = this.f;
            if (cVar == null) {
                return;
            }
            cVar.a(a2.a(), a2.b(), a2.c(), a2.d());
        }
    }

    public void a(ValueCallback valueCallback) {
        this.f.a(valueCallback);
    }

    public void a(com.sigmob.sdk.base.common.g gVar) {
        this.B = gVar;
    }

    @Deprecated
    public void a(ViewState viewState) {
        this.l = viewState;
    }

    public void a(a aVar) {
        this.m = aVar;
    }

    public static void a(a aVar, ViewState viewState, ViewState viewState2) {
        Preconditions.checkNotNull(aVar);
        Preconditions.checkNotNull(viewState);
        Preconditions.checkNotNull(viewState2);
    }

    @Deprecated
    public void a(c cVar) {
        this.r = cVar;
    }

    public void a(e eVar) {
        this.n = eVar;
    }

    public void a(f fVar) {
        this.p = fVar;
    }

    public void a(x xVar) {
        this.o = xVar;
    }

    public void a(WindAdError windAdError) {
        a aVar = this.m;
        if (aVar == null) {
            return;
        }
        aVar.a(windAdError);
    }

    private void a(Runnable runnable) {
        this.d.a();
        Context w = w();
        v g = g();
        if (w == null || g == null || this.v) {
            return;
        }
        DisplayMetrics displayMetrics = w.getResources().getDisplayMetrics();
        com.sigmob.sdk.base.common.g gVar = this.B;
        if (gVar == null) {
            this.e.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            this.e.a(gVar.a(), this.B.b());
        }
        int[] iArr = new int[2];
        ViewGroup z = z();
        z.getLocationOnScreen(iArr);
        this.e.a(iArr[0], iArr[1], z.getWidth(), z.getHeight());
        this.e.c(iArr[0], iArr[1], z.getWidth(), z.getHeight());
        g.getLocationOnScreen(iArr);
        this.e.b(iArr[0], iArr[1], g.getWidth(), g.getHeight());
        this.f.a(new CurrentAppOrientation(ClientMetadata.getInstance().getOrientationInt().intValue() == 1 ? "portrait" : "landscape", true));
        this.f.a(this.e);
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a(String str) {
    }

    public void a(String str, b bVar) {
        v vVar = new v(w());
        this.q = vVar;
        vVar.a(true);
        this.q.setBackgroundColor(0);
        if (bVar != null) {
            bVar.onReady(this.q, (com.sigmob.sdk.base.common.u) this.b.getSessionManager());
        }
        this.f.a(this.q);
        this.c.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        this.f.a(w(), str);
    }

    public void a(String str, String str2) {
        this.f.a(str, str2);
    }

    public void a(String str, String str2, String str3, HashMap<String, Object> hashMap) {
        this.f.a(str, str2, str3, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Map<String, String> map) {
        char c2;
        if (this.m == null) {
            return;
        }
        try {
            String a2 = com.sigmob.sdk.mraid.c.a(map.get(com.sigmob.sdk.base.n.m));
            String a3 = com.sigmob.sdk.mraid.c.a(map.get("ctime"));
            String a4 = com.sigmob.sdk.mraid.c.a(map.get("state"));
            switch (str.hashCode()) {
                case -1610203128:
                    if (str.equals(ExtensionEvent.AD_ENDCARD_SHOW)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1102513700:
                    if (str.equals(ExtensionEvent.AD_COMPANION_CLICK)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -934326481:
                    if (str.equals("reward")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -900560382:
                    if (str.equals(ExtensionEvent.AD_SKIP)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 112386354:
                    if (str.equals(ExtensionEvent.AD_MUTE)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1293469449:
                    if (str.equals(ExtensionEvent.AD_SHOE_SKIP_TIME)) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                this.m.b(a(a3, 0.0f));
                return;
            }
            if (c2 == 1) {
                this.m.a(a(a3, 0.0f));
                return;
            }
            if (c2 == 2) {
                if (com.sigmob.sdk.base.utils.q.b(a4)) {
                    this.m.a(a4.equalsIgnoreCase("true") || a4.equalsIgnoreCase("1"));
                }
            } else if (c2 == 3) {
                this.m.a();
            } else if (c2 == 4) {
                this.m.a(a2);
            } else {
                if (c2 != 5) {
                    return;
                }
                this.m.b();
            }
        } catch (Throwable unused) {
        }
    }

    public void a(URI uri, int i, String str) {
        a aVar = this.m;
        if (aVar == null) {
            return;
        }
        aVar.a(uri, i, str);
    }

    public void a(URI uri, boolean z) {
    }

    public void a(boolean z) {
        if (z) {
            this.f.f();
        } else {
            this.f.g();
        }
    }

    public void a(boolean z, p pVar) {
        if (!a(pVar)) {
            throw new com.sigmob.sdk.mraid.f("Unable to force orientation to " + pVar);
        }
        this.t = z;
        this.u = pVar;
        if (this.l == ViewState.EXPANDED || (this.f13465a == PlacementType.INTERSTITIAL && !this.v)) {
            o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    public boolean a(ConsoleMessage consoleMessage) {
        x xVar = this.o;
        if (xVar == null) {
            return true;
        }
        return xVar.a(consoleMessage);
    }

    public boolean a(p pVar) {
        if (pVar == p.NONE) {
            return true;
        }
        Activity c2 = com.sigmob.sdk.base.utils.r.c(this.c);
        if (c2 == null) {
            return false;
        }
        try {
            int i = c2.getPackageManager().getActivityInfo(new ComponentName(c2, c2.getClass()), 0).screenOrientation;
            return i == -1 || i == pVar.a();
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public boolean a(String str, JsResult jsResult) {
        x xVar = this.o;
        if (xVar != null) {
            return xVar.a(str, jsResult);
        }
        jsResult.confirm();
        return true;
    }
}
