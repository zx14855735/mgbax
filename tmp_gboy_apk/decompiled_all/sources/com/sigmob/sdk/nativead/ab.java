package com.sigmob.sdk.nativead;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.sdk.logger.SigmobLogger;
import com.sigmob.sdk.base.common.ah;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.SigImage;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.SigVideo;
import com.sigmob.sdk.base.models.WindAdMetaData;
import com.sigmob.sdk.base.models.rtb.BiddingResponse;
import com.sigmob.sdk.base.views.q;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.natives.NativeADEventListener;
import com.sigmob.windad.natives.WindNativeAdData;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ab implements View.OnClickListener, View.OnTouchListener, a, ac, g, WindNativeAdData.DislikeInteractionCallback {
    private static final Stack<x> M = new Stack<>();

    /* renamed from: a, reason: collision with root package name */
    public static final String f13593a = "ab";
    private static final int e = 1;
    private static final int f = 2;
    private static final int g = 3;
    private static final int h = 4;
    private boolean A;
    private boolean D;
    private boolean E;
    private List<View> F;
    private long G;
    private WindNativeAdData.DislikeInteractionCallback J;
    private boolean K;
    private x L;
    protected WindNativeAdData b;
    protected BaseAdUnit c;
    protected k d;
    private WindAdMetaData i;
    private r j;
    private p k;
    private f n;
    private n o;
    private MotionEvent p;
    private e q;
    private NativeADEventListener r;
    private boolean s;
    private ViewGroup t;
    private ViewGroup.LayoutParams u;
    private Bitmap v;
    private com.sigmob.sdk.base.views.q w;
    private boolean x;
    private v y;
    private boolean z;
    private List<View> l = new ArrayList();
    private final HashSet<View> m = new HashSet<>();
    private boolean B = true;
    private boolean C = false;
    private List<View> H = new ArrayList();
    private final List<View> I = new ArrayList();
    private q.b N = new q.b() { // from class: com.sigmob.sdk.nativead.ab.5
        @Override // com.sigmob.sdk.base.views.q.b
        public void a() {
            if (ab.this.w != null) {
                ab.this.w.dismiss();
                ab.this.w.c();
                ab.this.w = null;
            }
            ab.this.x = false;
            ab.this.c.getClickCommon().click_scene = ClickCommon.CLICK_SCENE_PREVIEW;
            ab.this.j().a(com.sigmob.sdk.base.common.a.g, 0);
        }

        @Override // com.sigmob.sdk.base.views.q.b
        public void b() {
            if (ab.this.j != null) {
                ab.this.r().a();
            }
            ab.this.j().a(com.sigmob.sdk.base.common.a.f, 0);
        }

        @Override // com.sigmob.sdk.base.views.q.b
        public void a(Error error) {
        }

        @Override // com.sigmob.sdk.base.views.q.b
        public void a(String str, String str2) {
            BaseAdUnit baseAdUnit = ab.this.c;
            if (baseAdUnit == null) {
                return;
            }
            baseAdUnit.getClickCommon().sld = Constants.FAIL;
            ab.this.c.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
            ab.this.c.getClickCommon().click_scene = "appinfo";
            ab.this.c.getClickCommon().is_final_click = true;
            if (ab.this.x) {
                ab.this.x().a(com.sigmob.sdk.base.a.PREVIEW, str, str2, true);
            }
        }
    };

    static {
        AbIoY();
    }

    private static /* synthetic */ void AbIoY() {
        char[] charArray = "£¯\u00adî§¡\u00ad¥î¢¯¹î³¨¥¬¬î\u008a®©\u0082²©¤§¥".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 192);
        }
        String str = new String(charArray);
        char[] charArray2 = "£¬©®©´".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 192);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context K() {
        return com.sigmob.sdk.b.e();
    }

    private void L() {
        try {
            Activity d = com.sigmob.sdk.base.utils.r.d(M());
            if (this.w == null && d != null) {
                com.sigmob.sdk.base.views.q qVar = new com.sigmob.sdk.base.views.q(d, this.c);
                this.w = qVar;
                qVar.a(this.N);
            }
            com.sigmob.sdk.base.views.q qVar2 = this.w;
            if (qVar2 == null || !qVar2.a() || this.x) {
                return;
            }
            this.c.getClickCommon().click_area = "appinfo";
            this.w.show();
            this.x = true;
        } catch (Exception e2) {
            SigmobLog.e("openFourElements fail:" + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View M() {
        p pVar = this.k;
        if (pVar == null) {
            return null;
        }
        return (View) pVar.getParent();
    }

    private boolean N() {
        return this.c.isExpiredAd();
    }

    private boolean O() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P() {
        a(4, (MotionEvent) null);
    }

    private r b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof r) {
                return (r) childAt;
            }
        }
        return null;
    }

    private p c(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof p) {
                return (p) childAt;
            }
        }
        return null;
    }

    public String A() {
        return k().getCTAText();
    }

    public Bitmap B() {
        return this.v;
    }

    public void C() {
        r rVar;
        t r;
        if (this.s || !this.D || (rVar = this.j) == null || rVar.getParent() == null || (r = r()) == null) {
            return;
        }
        r.c();
    }

    public void D() {
        t r;
        if (this.s || (r = r()) == null) {
            return;
        }
        this.A = true;
        r.a();
    }

    public void E() {
        r rVar;
        if (this.t != null && (rVar = this.j) != null) {
            ViewParent parent = rVar.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.j);
            }
            this.t.removeAllViews();
            ViewGroup.LayoutParams layoutParams = this.u;
            if (layoutParams != null) {
                this.t.addView(this.j, layoutParams);
            } else {
                this.t.addView(this.j);
            }
            if (!this.m.contains(this.j)) {
                this.m.add(this.j);
            }
        }
        this.t = null;
        this.u = null;
    }

    public void F() {
        r rVar;
        t r;
        if (this.s || !this.D || (rVar = this.j) == null || rVar.getParent() == null || (r = r()) == null) {
            return;
        }
        r.b();
    }

    public void G() {
        t r;
        if (this.s || (r = r()) == null) {
            return;
        }
        r.d();
    }

    public String H() {
        BiddingResponse biddingResponse;
        Integer num;
        BaseAdUnit baseAdUnit = this.c;
        return (baseAdUnit == null || (biddingResponse = baseAdUnit.bidding_response) == null || (num = biddingResponse.ecpm) == null) ? "" : String.valueOf(num);
    }

    public String I() {
        SigVideo nativeVideo = this.c.getNativeVideo();
        if (nativeVideo == null) {
            return null;
        }
        return nativeVideo.getThumbUrl();
    }

    public WindAdMetaData J() {
        if (this.i == null) {
            this.i = WindAdMetaData.create(this.c);
        }
        return this.i;
    }

    @Override // com.sigmob.sdk.nativead.g
    public void g() {
        SigmobLog.d("----------onAdDetailShow----------");
        if (x() != null) {
            x().c(K(), this.c);
        }
        this.s = true;
        NativeADEventListener nativeADEventListener = this.r;
        if (nativeADEventListener != null) {
            nativeADEventListener.onAdDetailShow();
        }
    }

    @Override // com.sigmob.sdk.nativead.g
    public void i() {
        this.s = false;
        NativeADEventListener nativeADEventListener = this.r;
        if (nativeADEventListener != null) {
            nativeADEventListener.onAdDetailDismiss();
        }
        e x = x();
        if (x != null) {
            x.d(K(), this.c);
        }
        E();
        n nVar = this.o;
        if (nVar != null) {
            nVar.setVisibility(0);
        }
        f fVar = this.n;
        if (fVar != null) {
            fVar.b(this.c);
        }
        View M2 = M();
        if (M2 == null || x == null) {
            return;
        }
        x.a(com.sigmob.sdk.base.utils.r.c(M2), this.c, this.N);
    }

    public ah j() {
        BaseAdUnit baseAdUnit = this.c;
        if (baseAdUnit == null) {
            return null;
        }
        ah sessionManager = baseAdUnit.getSessionManager();
        if (sessionManager != null) {
            return sessionManager;
        }
        i iVar = new i();
        iVar.a(this.c);
        return iVar;
    }

    @Override // com.sigmob.sdk.nativead.ac
    public BaseAdUnit k() {
        return this.c;
    }

    @Override // com.sigmob.sdk.nativead.ac
    public WindNativeAdData l() {
        return this.b;
    }

    @Override // com.sigmob.sdk.nativead.ac
    public n m() {
        if (this.K) {
            return this.o;
        }
        if (this.o == null) {
            if (this.c.getadPrivacy() == null) {
                return this.o;
            }
            n nVar = new n(K());
            this.o = nVar;
            nVar.setOnTouchListener(this);
            this.o.a(this.c.getAppVersion(), this.c.getCompanyName());
        }
        return this.o;
    }

    public boolean n() {
        f fVar = this.n;
        if (fVar == null) {
            return false;
        }
        return fVar.a(this.c);
    }

    public f o() {
        if (this.n == null) {
            this.n = new f(this);
        }
        return this.n;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
    public void onCancel() {
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.J;
        if (dislikeInteractionCallback == null) {
            return;
        }
        dislikeInteractionCallback.onCancel();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
    public void onSelected(int i, String str, boolean z) {
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.J;
        if (dislikeInteractionCallback == null) {
            return;
        }
        dislikeInteractionCallback.onSelected(i, str, z);
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData.DislikeInteractionCallback
    public void onShow() {
        WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback = this.J;
        if (dislikeInteractionCallback == null) {
            return;
        }
        dislikeInteractionCallback.onShow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null || ((motionEvent.getAction() == 0 && this.G > 0 && System.currentTimeMillis() - this.G < 500) || this.c == null)) {
            return false;
        }
        try {
        } catch (Throwable th) {
            SigmobLog.e("onTouch error", th);
        }
        if (motionEvent.getAction() != 1) {
            this.G = System.currentTimeMillis();
            this.p = motionEvent;
            return true;
        }
        this.c.getClickCommon().click_scene = ClickCommon.CLICK_SCENE_PREVIEW;
        this.c.getClickCommon().sld = Constants.FAIL;
        if (view == this.o) {
            SigmobLog.d("click mSigAppInfoView");
            a(1, motionEvent);
            return true;
        }
        SigmobLog.d("click " + view);
        List<View> list = this.l;
        int i = 3;
        if (list != null) {
            if ((list.contains(view) ? view : a(this.l, motionEvent)) != null) {
                SigmobLog.d("click ctaClickView");
                this.c.getClickCommon().click_scene = ClickCommon.CLICK_SCENE_PREVIEW;
                this.c.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                a(3, motionEvent);
                return true;
            }
        }
        if (this.m.isEmpty()) {
            return false;
        }
        if (!this.m.contains(view)) {
            view = a(this.m, motionEvent);
        }
        if (view != null) {
            SigmobLog.d("click mCreativeViews");
            r rVar = this.j;
            if (rVar == null || !rVar.a(motionEvent)) {
                i = 2;
            }
            a(i, motionEvent);
            return true;
        }
        return false;
    }

    public int p() {
        int width;
        View M2 = M();
        if (this.j == null || M2 == null || (width = M2.getWidth()) <= 0) {
            return 1280;
        }
        return width;
    }

    public View q() {
        return this.j;
    }

    public t r() {
        r rVar = this.j;
        if (rVar == null) {
            return null;
        }
        return rVar.getSigVideoAdController();
    }

    public double s() {
        if (r() == null) {
            return 0.0d;
        }
        return r0.e();
    }

    public double t() {
        if (r() == null) {
            return 0.0d;
        }
        return r0.f();
    }

    public int u() {
        View q = q();
        View M2 = M();
        if (q == null || M2 == null || M2.getWidth() <= 0) {
            return 720;
        }
        return (int) (M2.getWidth() / this.c.getAdPercent());
    }

    public void v() {
        a(this.m, (View.OnTouchListener) null);
        a(this.l, (View.OnTouchListener) null);
        this.m.clear();
        List<View> list = this.l;
        if (list != null) {
            list.clear();
        }
        List<View> list2 = this.H;
        if (list2 != null) {
            list2.clear();
        }
        this.r = null;
        this.d = null;
    }

    public void w() {
        BaseAdUnit baseAdUnit = this.c;
        SigmobLog.i("native ad data " + (baseAdUnit != null ? baseAdUnit.getVid() : "null") + " is Destroy");
        v();
        List<View> list = this.F;
        if (list != null) {
            list.clear();
        }
        r rVar = this.j;
        if (rVar != null) {
            com.sigmob.sdk.base.utils.r.a(rVar);
            this.j.c();
            this.j = null;
        }
        BaseAdUnit baseAdUnit2 = this.c;
        if (baseAdUnit2 != null && baseAdUnit2.getSessionManager() != null) {
            j().a("ad_hide", 0);
            j().a();
        }
        x xVar = this.L;
        if (xVar != null) {
            xVar.c();
            M.remove(this.L);
            com.sigmob.sdk.base.utils.r.a(this.L);
            this.L = null;
        }
        com.sigmob.sdk.base.common.h.g().e(this.c);
        com.sigmob.sdk.base.common.h.b(this.c);
        com.sigmob.sdk.base.views.q qVar = this.w;
        if (qVar != null) {
            qVar.dismiss();
            this.w.c();
            this.w = null;
        }
        v vVar = this.y;
        if (vVar != null && (vVar instanceof b)) {
            vVar.a(null);
            b bVar = (b) this.y;
            bVar.dismiss();
            bVar.b();
            this.y = null;
        }
        this.J = null;
        this.N = null;
        p pVar = this.k;
        if (pVar != null) {
            pVar.setAdVisibilityStatusChangeListener(null);
            com.sigmob.sdk.base.utils.r.a(this.k);
            this.k = null;
        }
        f fVar = this.n;
        if (fVar != null) {
            fVar.b(this.c);
            this.n = null;
        }
        BaseAdUnit baseAdUnit3 = this.c;
        if (baseAdUnit3 != null) {
            baseAdUnit3.destroy();
        }
    }

    @Override // com.sigmob.sdk.nativead.ac
    public e x() {
        BaseAdUnit baseAdUnit;
        if (this.q == null && (baseAdUnit = this.c) != null) {
            this.q = (e) baseAdUnit.getAdConfig();
        }
        return this.q;
    }

    public void y() {
        Bundle bundle = new Bundle();
        if (this.j != null && x().l()) {
            ae aeVar = new ae();
            int[] iArr = new int[2];
            this.j.getLocationOnScreen(iArr);
            aeVar.a(iArr[0]);
            aeVar.b(iArr[1]);
            aeVar.c(this.j.getMeasuredWidth());
            aeVar.d(this.j.getMeasuredHeight());
            bundle.putParcelable("attr", aeVar);
            this.t = (ViewGroup) this.j.getParent();
            this.u = this.j.getLayoutParams();
            z.a((m) this.j);
            SigMacroCommon macroCommon = this.c.getMacroCommon();
            if (macroCommon != null) {
                macroCommon.addMarcoKey(SigMacroCommon._SCENE_, "3");
            }
            this.s = true;
        }
        n nVar = this.o;
        if (nVar != null) {
            nVar.setVisibility(4);
        }
        o().a(this.c, bundle);
    }

    public int z() {
        int interactionType = this.c.getInteractionType();
        if (interactionType == 2) {
            return 1;
        }
        return interactionType == 0 ? 0 : 2;
    }

    public View a(int i, int i2) {
        if (this.L == null && this.c != null) {
            Context K = K();
            x xVar = new x(K, this.c, Dips.dipsToIntPixels(i, K), Dips.dipsToIntPixels(i2, K));
            if (!xVar.getCreateWidgetViewResult()) {
                return null;
            }
            xVar.setMotionActionListener(new A2egSU(this));
            int dipsToIntPixels = Dips.dipsToIntPixels((i < 100 || i2 < 100) ? 30 : 70, K);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
            layoutParams.gravity = 17;
            xVar.setLayoutParams(layoutParams);
            this.L = xVar;
        }
        return this.L;
    }

    @Override // com.sigmob.sdk.base.common.x
    public void b() {
        e x = x();
        if (x == null) {
            return;
        }
        x.b(K(), this.c);
    }

    @Override // com.sigmob.sdk.nativead.a
    public void c() {
        if (this.D) {
            x xVar = this.L;
            if (xVar != null) {
                xVar.b();
                M.remove(this.L);
            }
            t r = r();
            if (r != null) {
                r.a();
            }
            SigmobLog.d("-----------onAdViewPauseImpression---------");
            this.D = false;
        }
    }

    @Override // com.sigmob.sdk.nativead.a
    public void d() {
        x lastElement;
        x xVar;
        if (this.L != null) {
            Stack<x> stack = M;
            if (!stack.isEmpty() && (lastElement = stack.lastElement()) != null && lastElement == (xVar = this.L)) {
                xVar.a();
            }
        }
        if (this.s || this.D) {
            return;
        }
        this.D = true;
        x xVar2 = this.L;
        if (xVar2 != null) {
            Stack<x> stack2 = M;
            if (!stack2.contains(xVar2)) {
                stack2.push(this.L);
                this.L.a();
            }
        }
        r rVar = this.j;
        if (rVar == null || rVar.getParent() == null) {
            return;
        }
        e x = x();
        if (!this.A && x != null && x.u()) {
            r().c();
        }
        SigmobLog.d("------------onAdViewStartImpression------------");
    }

    @Override // com.sigmob.sdk.nativead.a
    public void e() {
        if (this.s || K() == null || !this.E) {
            return;
        }
        this.m.clear();
        this.E = false;
        x xVar = this.L;
        if (xVar != null) {
            xVar.b();
            M.remove(this.L);
        }
        SigmobLog.d("------------onAdViewRemoved----------" + hashCode());
        t r = r();
        if (r != null) {
            r.a();
        }
        this.D = false;
        p pVar = this.k;
        if (pVar != null && pVar.hasWindowFocus()) {
            this.z = false;
        }
        ah j = j();
        if (j != null) {
            j.a("ad_hide", 0);
        }
        if (this.B || this.C || j == null) {
            return;
        }
        j.a("video_link", 0);
    }

    @Override // com.sigmob.sdk.nativead.a
    public void f() {
        if (this.E || this.s) {
            return;
        }
        this.E = true;
        com.sigmob.sdk.base.utils.i.c(f13593a, "onAdViewShow", new Object[0]);
        this.A = false;
        this.D = false;
        boolean j = com.sigmob.sdk.base.o.a().j();
        View M2 = M();
        if (com.sigmob.sdk.base.utils.q.b(M2)) {
            x().a(com.sigmob.sdk.base.utils.r.c(M2), this.c, this.N);
            if (com.sigmob.sdk.base.utils.q.b(Boolean.valueOf(j))) {
                M2.setOnTouchListener(this);
            }
        }
        r rVar = this.j;
        if (rVar != null && !this.m.contains(rVar)) {
            this.m.add(this.j);
        } else if (this.F != null) {
            if (this.m.isEmpty()) {
                this.m.addAll(this.F);
            } else {
                for (View view : this.F) {
                    if (!this.m.contains(view)) {
                        this.m.add(view);
                    }
                }
            }
        }
        x xVar = this.L;
        if (xVar != null && !this.m.contains(xVar)) {
            this.m.add(this.L);
        }
        this.m.addAll(this.H);
        a(this.l, this);
        if (com.sigmob.sdk.base.utils.q.b(Boolean.valueOf(j))) {
            a(this.m, this);
        }
        ah j2 = j();
        if (j2 == null) {
            return;
        }
        j2.a("start", 0);
    }

    @Override // com.sigmob.sdk.nativead.g
    public void h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(ViewGroup viewGroup) {
        a(a(viewGroup), viewGroup);
    }

    public View a(ViewGroup viewGroup) {
        View a2;
        View view = null;
        if (viewGroup == null) {
            return null;
        }
        int i = 0;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt != null) {
                if (childAt instanceof r) {
                    return childAt;
                }
                if ((childAt instanceof ImageView) && this.I.contains(childAt)) {
                    int measuredWidth = childAt.getMeasuredWidth() * childAt.getMeasuredHeight();
                    if (measuredWidth > i) {
                        view = childAt;
                        i = measuredWidth;
                    }
                }
                if ((childAt instanceof ViewGroup) && (a2 = a((ViewGroup) childAt)) != null) {
                    if (a2 instanceof r) {
                        return a2;
                    }
                    if ((a2 instanceof ImageView) && this.I.contains(a2)) {
                        int measuredWidth2 = a2.getMeasuredWidth() * a2.getMeasuredHeight();
                        if (measuredWidth2 > i) {
                            view = a2;
                            i = measuredWidth2;
                        }
                    }
                }
            }
        }
        return view;
    }

    public void b(ViewGroup viewGroup, final WindNativeAdData.NativeADMediaListener nativeADMediaListener) {
        if (viewGroup == null) {
            return;
        }
        r rVar = (r) com.sigmob.sdk.base.utils.r.a(viewGroup, r.class);
        if (rVar != null) {
            com.sigmob.sdk.base.utils.r.a(rVar);
        }
        r rVar2 = this.j;
        if (rVar2 != null) {
            com.sigmob.sdk.base.utils.r.a(rVar2);
            viewGroup.addView(this.j, new ViewGroup.LayoutParams(-1, -2));
        }
        if (!this.m.contains(this.j)) {
            this.m.add(this.j);
        }
        r rVar3 = this.j;
        if (rVar3 != null && !this.c.equals(rVar3.getAdUnit())) {
            this.j.a(this);
        }
        r rVar4 = this.j;
        final t sigVideoAdController = rVar4 == null ? null : rVar4.getSigVideoAdController();
        if (sigVideoAdController == null) {
            return;
        }
        sigVideoAdController.a(new l() { // from class: com.sigmob.sdk.nativead.ab.2
            @Override // com.sigmob.sdk.nativead.l
            public void a() {
                ab.this.j().a("video_restart", 0);
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
            public void onVideoCompleted() {
                WindNativeAdData.NativeADMediaListener nativeADMediaListener2 = nativeADMediaListener;
                if (nativeADMediaListener2 != null) {
                    nativeADMediaListener2.onVideoCompleted();
                }
                ab.this.c.getVideoCommon().end_time = sigVideoAdController.e();
                ab.this.c.getVideoCommon().is_last = 1;
                ab.this.j().a("complete", sigVideoAdController.j());
                ab.this.j().a("video_link", 0);
                ab.this.C = false;
                ab.this.A = false;
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
            public void onVideoError(WindAdError windAdError) {
                ab.this.A = false;
                ab.this.C = false;
                WindNativeAdData.NativeADMediaListener nativeADMediaListener2 = nativeADMediaListener;
                if (nativeADMediaListener2 == null) {
                    return;
                }
                nativeADMediaListener2.onVideoError(windAdError);
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
            public void onVideoLoad() {
                WindNativeAdData.NativeADMediaListener nativeADMediaListener2 = nativeADMediaListener;
                if (nativeADMediaListener2 == null) {
                    return;
                }
                nativeADMediaListener2.onVideoLoad();
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
            public void onVideoPause() {
                WindNativeAdData.NativeADMediaListener nativeADMediaListener2 = nativeADMediaListener;
                if (nativeADMediaListener2 != null) {
                    nativeADMediaListener2.onVideoPause();
                }
                ab.this.C = true;
                ab.this.j().a("video_pause", 0);
                ab.this.j().a("video_link", 0);
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
            public void onVideoResume() {
                WindNativeAdData.NativeADMediaListener nativeADMediaListener2 = nativeADMediaListener;
                if (nativeADMediaListener2 != null) {
                    nativeADMediaListener2.onVideoResume();
                }
                ab.this.C = false;
                ab.this.c.getVideoCommon().type = 2;
                ab.this.c.getVideoCommon().is_first = 0;
                ab.this.c.getVideoCommon().begin_time = sigVideoAdController.j();
                ab.this.A = false;
                ab.this.j().a("video_start", sigVideoAdController.j());
            }

            @Override // com.sigmob.windad.natives.WindNativeAdData.NativeADMediaListener
            public void onVideoStart() {
                View M2 = ab.this.M();
                if (M2 != null) {
                    ab.this.c.setAdSize(M2.getWidth(), M2.getHeight());
                }
                ab.this.c.getVideoCommon().video_time = sigVideoAdController.e();
                ab.this.c.getVideoCommon().is_first = 1;
                ab.this.c.getVideoCommon().is_last = 0;
                ab.this.c.getVideoCommon().end_time = 0;
                ab.this.c.getVideoCommon().is_auto_play = ab.this.x().u() ? 1 : 2;
                if (ab.this.s) {
                    ab.this.c.getVideoCommon().scene = 3;
                } else {
                    ab.this.c.getVideoCommon().scene = 1;
                }
                if (ab.this.B) {
                    ab.this.c.getVideoCommon().type = 1;
                    ab.this.B = false;
                } else {
                    ab.this.c.getVideoCommon().type = 3;
                }
                WindNativeAdData.NativeADMediaListener nativeADMediaListener2 = nativeADMediaListener;
                if (nativeADMediaListener2 != null) {
                    nativeADMediaListener2.onVideoStart();
                }
                ab.this.A = false;
                ab.this.C = false;
                ab.this.j().a("video_start", 0);
            }

            @Override // com.sigmob.sdk.nativead.l
            public void a(long j, long j2) {
                List<com.sigmob.sdk.videoAd.d> a2;
                ab.this.c.getVideoCommon().end_time = sigVideoAdController.j();
                e x = ab.this.x();
                if (x == null || (a2 = x.a(j, j2)) == null || a2.isEmpty()) {
                    return;
                }
                for (com.sigmob.sdk.videoAd.d dVar : a2) {
                    ab.this.j().a(dVar.getEvent(), sigVideoAdController.j());
                    dVar.setTracked();
                }
            }
        });
    }

    @Override // com.sigmob.sdk.base.common.p
    public void c(BaseAdUnit baseAdUnit) {
    }

    @Override // com.sigmob.sdk.base.common.p
    public void e(BaseAdUnit baseAdUnit) {
    }

    @Override // com.sigmob.sdk.base.common.p
    public void b(BaseAdUnit baseAdUnit) {
        r rVar = this.j;
        if (rVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = ((View) rVar.getParent()).getLayoutParams();
        SigmobLog.d("visibilityStatusChange() called with: isVisible = [" + layoutParams.width + ":" + layoutParams.height + "]");
    }

    @Override // com.sigmob.sdk.base.common.p
    public void d(BaseAdUnit baseAdUnit) {
    }

    private View a(HashSet<View> hashSet, MotionEvent motionEvent) {
        if (hashSet == null) {
            return null;
        }
        Iterator<View> it = hashSet.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (com.sigmob.sdk.base.utils.r.a(next, motionEvent)) {
                return next;
            }
        }
        return null;
    }

    @Override // com.sigmob.sdk.base.common.p
    public void b(BaseAdUnit baseAdUnit, String str) {
    }

    private View a(List<View> list, MotionEvent motionEvent) {
        if (list == null) {
            return null;
        }
        for (View view : list) {
            if (com.sigmob.sdk.base.utils.r.a(view, motionEvent)) {
                return view;
            }
        }
        return null;
    }

    public void b(boolean z) {
        t r;
        if (this.s || (r = r()) == null) {
            return;
        }
        r.a(z);
    }

    @Override // com.sigmob.sdk.base.common.x
    public void a() {
        e x = x();
        if (x == null) {
            return;
        }
        x.a(K(), this.c);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(int r10, android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.nativead.ab.a(int, android.view.MotionEvent):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(View view, int i, int i2) {
        LinearLayout.LayoutParams layoutParams;
        ViewParent parent = view.getParent();
        if (parent == null) {
            return;
        }
        if (parent instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.width = i;
            layoutParams2.height = i2;
            layoutParams2.gravity = 17;
            layoutParams = layoutParams2;
        } else if (parent instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams3.width = i;
            layoutParams3.height = i2;
            layoutParams3.addRule(13);
            layoutParams = layoutParams3;
        } else {
            if (!(parent instanceof LinearLayout)) {
                return;
            }
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams4.width = i;
            layoutParams4.height = i2;
            layoutParams4.gravity = 17;
            layoutParams = layoutParams4;
        }
        view.setLayoutParams(layoutParams);
        view.requestLayout();
    }

    public void a(View view, ViewGroup viewGroup) {
        ViewParent viewParent;
        if (viewGroup == null) {
            return;
        }
        if (view == null) {
            SigmobLogger.d(f13593a, "prepareWidget2Show: container", new Object[0]);
            view = viewGroup;
            viewParent = viewGroup;
        } else if (!(view instanceof r) && !(view instanceof ImageView)) {
            SigmobLogger.d(f13593a, "prepareWidget2Show: no material", new Object[0]);
            return;
        } else {
            SigmobLogger.d(f13593a, "prepareWidget2Show: material", new Object[0]);
            viewParent = view.getParent();
        }
        String simpleName = view.getClass().getSimpleName();
        int measuredHeight = view.getMeasuredHeight();
        int measuredWidth = view.getMeasuredWidth();
        SigmobLogger.d(f13593a, "prepareWidget2Show: simpleName = " + simpleName + ", measuredHeight = " + measuredHeight + ", measuredWidth = " + measuredWidth, new Object[0]);
        a(viewParent, measuredWidth, measuredHeight);
    }

    public void a(View view, List<View> list, List<View> list2, View view2, NativeADEventListener nativeADEventListener) {
        p pVar;
        ViewGroup.LayoutParams layoutParams;
        if (view == null) {
            if (nativeADEventListener != null) {
                nativeADEventListener.onAdError(WindAdError.ERROR_SIGMOB_ADCONTAINER_IS_NULL);
                return;
            }
            return;
        }
        if (!(view instanceof ViewGroup)) {
            if (nativeADEventListener != null) {
                nativeADEventListener.onAdError(WindAdError.ERROR_SIGMOB_ADCONTAINER_NOT_VIEWGROUP);
                return;
            }
            return;
        }
        if (com.sigmob.sdk.b.i() == null) {
            com.sigmob.sdk.b.a(com.sigmob.sdk.base.utils.r.d(view));
        }
        if (view2 != null) {
            if (this.y == null) {
                b bVar = new b(view2.getContext(), this.c);
                this.y = bVar;
                bVar.a(this);
            }
            view2.setOnTouchListener(new View.OnTouchListener() { // from class: com.sigmob.sdk.nativead.ab.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view3, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 1 || ab.this.y == null) {
                        return true;
                    }
                    ab.this.y.a();
                    return true;
                }
            });
        }
        final ViewGroup viewGroup = (ViewGroup) view;
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.sigmob.sdk.nativead.ab.4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                ab abVar = ab.this;
                if (abVar.c == null) {
                    return;
                }
                Context K = abVar.K();
                viewGroup.getLocationOnScreen(new int[2]);
                ClickCommon clickCommon = ab.this.c.getClickCommon();
                clickCommon.adarea_x = String.valueOf(Dips.pixelsToIntDips(r1[0], K));
                clickCommon.adarea_y = String.valueOf(Dips.pixelsToIntDips(r1[1], K));
                clickCommon.adarea_w = String.valueOf(Dips.pixelsToIntDips(viewGroup.getWidth(), K));
                clickCommon.adarea_h = String.valueOf(Dips.pixelsToIntDips(viewGroup.getHeight(), K));
            }
        });
        x xVar = (x) com.sigmob.sdk.base.utils.r.a(viewGroup, x.class);
        if (xVar != null && xVar != this.L) {
            com.sigmob.sdk.base.utils.r.a(xVar);
        }
        viewGroup.post(new ASJ6gh(this, 1, viewGroup));
        x().a(new A2egSU(this));
        if (com.sigmob.sdk.base.utils.e.b(list2)) {
            this.l = list2;
        }
        if (com.sigmob.sdk.base.utils.e.b(this.H)) {
            this.m.removeAll(this.H);
        }
        if (com.sigmob.sdk.base.utils.e.b(list)) {
            this.H = list;
        }
        this.r = nativeADEventListener;
        o().a((Map<String, Object>) null, this.c);
        com.sigmob.sdk.base.common.h.g().a(this.c, (h.b) null);
        p pVar2 = this.k;
        if (pVar2 == null) {
            p c = c(viewGroup);
            this.k = c;
            if (c == null) {
                pVar = new p(K());
                this.k = pVar;
                layoutParams = new ViewGroup.LayoutParams(0, 0);
            }
            this.m.addAll(this.H);
            this.k.setAdVisibilityStatusChangeListener(this);
            this.k.a(x().s(), x().t());
        }
        com.sigmob.sdk.base.utils.r.a(pVar2);
        pVar = this.k;
        layoutParams = new ViewGroup.LayoutParams(0, 0);
        viewGroup.addView(pVar, layoutParams);
        this.m.addAll(this.H);
        this.k.setAdVisibilityStatusChangeListener(this);
        this.k.a(x().s(), x().t());
    }

    public void a(ViewGroup viewGroup, WindNativeAdData.NativeADMediaListener nativeADMediaListener) {
        this.K = true;
        b(viewGroup, nativeADMediaListener);
    }

    private void a(ViewParent viewParent, int i, int i2) {
        BaseAdUnit baseAdUnit;
        int i3;
        Context K = K();
        if (K == null || viewParent == null || (baseAdUnit = this.c) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) viewParent;
        if (baseAdUnit.enableWidgetInteraction()) {
            boolean enableDevToRender = this.c.enableDevToRender(0);
            if (enableDevToRender) {
                i3 = 30;
            } else {
                int min = Math.min(i2, i);
                int pixelsToIntDips = Dips.pixelsToIntDips(min, K);
                int min2 = Math.min(pixelsToIntDips, 100);
                String str = f13593a;
                StringBuilder B7CMnp2 = J3FDQU.A2egSU.B7CMnp(min, pixelsToIntDips, "createWidget2Show: minViewSize = ", ", minViewSizeDp = ", ", widgetSizeDp = ");
                B7CMnp2.append(min2);
                SigmobLogger.d(str, B7CMnp2.toString(), new Object[0]);
                i3 = min2;
            }
            float f2 = enableDevToRender ? 0.0f : 1.0f;
            String str2 = f13593a;
            SigmobLogger.d(str2, CtFAbx.ARc23Z(i3, "createWidget2Show: widgetSizeDp = "), new Object[0]);
            View a2 = a(i3, i3);
            if (a2 == null) {
                return;
            }
            a2.setAlpha(f2);
            com.sigmob.sdk.base.utils.r.a(a2);
            int measuredWidth = viewGroup.getMeasuredWidth();
            int measuredHeight = viewGroup.getMeasuredHeight();
            SigmobLogger.d(str2, com.bykv.vk.component.ttvideo.player.A2egSU.AaHO0E(measuredWidth, measuredHeight, "createWidget2Show: containerW = ", ", containerH = "), new Object[0]);
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(measuredWidth, measuredHeight));
            frameLayout.addView(a2);
            viewGroup.addView(frameLayout);
            this.m.add(a2);
        }
    }

    public void a(BaseAdUnit baseAdUnit, WindNativeAdData windNativeAdData) {
        this.c = baseAdUnit;
        this.b = windNativeAdData;
        if (this.j == null && baseAdUnit.getNativeAd().type.intValue() == 1) {
            this.j = new r(com.sigmob.sdk.b.e());
        }
        com.sigmob.sdk.base.common.h.a().getBitmap(k().getAd_source_logo(), new ImageManager.BitmapLoadedListener() { // from class: com.sigmob.sdk.nativead.ab.1
            @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
            public void onBitmapLoadFailed() {
            }

            @Override // com.czhj.sdk.common.utils.ImageManager.BitmapLoadedListener
            public void onBitmapLoaded(Bitmap bitmap) {
                ab.this.v = bitmap;
            }
        });
    }

    public void a(WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        this.J = dislikeInteractionCallback;
    }

    public void a(HashSet<View> hashSet, View.OnTouchListener onTouchListener) {
        if (hashSet == null) {
            return;
        }
        Iterator<View> it = hashSet.iterator();
        while (it.hasNext()) {
            View next = it.next();
            if (next != null) {
                next.setOnClickListener(null);
                next.setOnTouchListener(null);
                next.setOnTouchListener(onTouchListener);
            }
        }
    }

    public void a(List<ImageView> list, int i) {
        List<SigImage> imageUrlList = k().getImageUrlList();
        if (list == null || imageUrlList == null) {
            return;
        }
        this.I.clear();
        this.I.addAll(list);
        int min = Math.min(list.size(), imageUrlList.size());
        for (int i2 = 0; i2 < min; i2++) {
            SigImage sigImage = imageUrlList.get(i2);
            ImageView imageView = list.get(i2);
            if (!this.m.contains(imageView)) {
                this.m.add(imageView);
            }
            List<View> list2 = this.F;
            if (list2 == null) {
                this.F = new ArrayList();
            } else {
                list2.clear();
            }
            this.F.add(imageView);
            com.sigmob.sdk.base.common.h.a().load(sigImage.getImageUrl()).placeholder(i).error(i).into(imageView);
        }
    }

    public void a(List<View> list, View.OnTouchListener onTouchListener) {
        if (list == null) {
            return;
        }
        for (View view : list) {
            if (view != null) {
                view.setOnClickListener(null);
                view.setOnTouchListener(null);
                view.setOnTouchListener(onTouchListener);
            }
        }
    }

    @Override // com.sigmob.sdk.nativead.a
    public void a(boolean z) {
        if (this.z) {
            return;
        }
        if (!this.s) {
            com.sigmob.sdk.base.common.h.g().e(this.c);
            if (z) {
                NativeADEventListener nativeADEventListener = this.r;
                if (nativeADEventListener != null) {
                    nativeADEventListener.onAdExposed();
                }
                j().a("ad_show", 0);
            }
        }
        this.z = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, com.sigmob.sdk.base.a aVar) {
        ah j;
        NativeADEventListener nativeADEventListener;
        if (com.sigmob.sdk.base.utils.c.a(com.sigmob.sdk.base.utils.c.a(f13593a, this.c)) && (nativeADEventListener = this.r) != null) {
            nativeADEventListener.onAdClicked();
        }
        if (z && (j = j()) != null) {
            j.a("click", 0);
        }
    }

    private boolean a(MotionEvent motionEvent) {
        r rVar = this.j;
        if (rVar == null) {
            return false;
        }
        return rVar.a(motionEvent);
    }
}
