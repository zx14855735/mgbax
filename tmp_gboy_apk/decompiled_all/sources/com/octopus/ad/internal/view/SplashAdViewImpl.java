package com.octopus.ad.internal.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.octopus.ad.R;
import com.octopus.ad.internal.animation.Animator;
import com.octopus.ad.internal.animation.TransitionDirection;
import com.octopus.ad.internal.animation.TransitionType;
import com.octopus.ad.internal.network.a;
import com.octopus.ad.internal.p;
import com.octopus.ad.internal.q;
import com.octopus.ad.internal.utilities.HaoboLog;
import com.octopus.ad.internal.utilities.WebviewUtil;
import com.octopus.ad.internal.video.AdVideoView;
import com.octopus.ad.utils.b.f;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class SplashAdViewImpl extends AdViewImpl {
    private a A;
    protected boolean t;
    private int u;
    private boolean v;
    private boolean w;
    private boolean x;
    private Animator y;
    private com.octopus.ad.internal.view.b z;

    /* renamed from: com.octopus.ad.internal.view.SplashAdViewImpl$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12587a;

        static {
            int[] iArr = new int[a.values().length];
            f12587a = iArr;
            try {
                iArr[a.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12587a[a.TOP_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12587a[a.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12587a[a.CENTER_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12587a[a.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12587a[a.CENTER_RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12587a[a.BOTTOM_LEFT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12587a[a.BOTTOM_CENTER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12587a[a.BOTTOM_RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public enum a {
        TOP_LEFT,
        TOP_CENTER,
        TOP_RIGHT,
        CENTER_LEFT,
        CENTER,
        CENTER_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_CENTER,
        BOTTOM_RIGHT;

        static {
            ZGVsmd();
        }

        private static /* synthetic */ void ZGVsmd() {
            char[] charArray = "æêè«âäèà«çêü«öíàéé«ÏëìÇ÷ìáâà".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 133);
            }
            String str = new String(charArray);
            char[] charArray2 = "æéìëìñ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 133);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public int a() {
            switch (AnonymousClass1.f12587a[ordinal()]) {
                case 1:
                    return 51;
                case 2:
                    return 49;
                case 3:
                    return 8388661;
                case 4:
                    return 8388627;
                case 5:
                default:
                    return 17;
                case 6:
                    return 8388629;
                case 7:
                    return 8388691;
                case 8:
                    return 81;
                case 9:
                    return 8388693;
            }
        }
    }

    public class b implements Animation.AnimationListener {
        private final com.octopus.ad.internal.view.b b;
        private final Animator c;

        public b(com.octopus.ad.internal.view.b bVar, Animator animator) {
            this.b = bVar;
            this.c = animator;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            animation.setAnimationListener(null);
            final com.octopus.ad.internal.view.b bVar = this.b;
            final Animator animator = this.c;
            if (bVar == null || animator == null) {
                return;
            }
            bVar.getView().getHandler().post(new Runnable() { // from class: com.octopus.ad.internal.view.SplashAdViewImpl.b.1
                @Override // java.lang.Runnable
                public void run() {
                    animator.clearAnimation();
                    bVar.k();
                    animator.setAnimation();
                }
            });
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public SplashAdViewImpl(Context context) {
        super(context);
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void a(Context context, AttributeSet attributeSet) {
        f.c("OctopusAd_Time", "SplashAdViewImpl setup 开始");
        this.u = -1;
        this.t = false;
        this.w = false;
        this.x = false;
        if (q.a().f12512a == 0) {
            this.y = new Animator(getContext(), TransitionType.NONE, TransitionDirection.UP, 500L);
        }
        View view = (View) getParent();
        if (view != null) {
            int measuredHeight = view.getMeasuredHeight();
            int measuredHeight2 = view.getMeasuredHeight();
            q a2 = q.a();
            int o = (int) ((measuredHeight / a2.o()) + 0.5f);
            this.d.b((int) ((measuredHeight2 / a2.n()) + 0.5f));
            this.d.c(o);
        }
        super.a(context, attributeSet);
        p pVar = p.SPLASH;
        this.g = pVar;
        this.d.a(pVar);
        this.f.a(this.u);
    }

    public a getAdAlignment() {
        if (this.A == null) {
            this.A = a.CENTER;
        }
        return this.A;
    }

    @Override // com.octopus.ad.internal.a
    public p getMediaType() {
        return p.SPLASH;
    }

    public boolean getResizeAdToFitContainer() {
        return this.w;
    }

    public TransitionType getTransitionType() {
        Animator animator = this.y;
        return animator != null ? animator.getTransitionType() : TransitionType.NONE;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public boolean k() {
        return false;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.x || z) {
            q a2 = q.a();
            int n = (int) (((i3 - i) / a2.n()) + 0.5f);
            int o = (int) (((i4 - i2) / a2.o()) + 0.5f);
            if (n >= this.d.j() && (o >= this.d.k() || n <= 0 || o <= 0)) {
                this.d.b(n);
                this.d.c(o);
                this.x = true;
            } else {
                HaoboLog.e(HaoboLog.baseLogTag, HaoboLog.getString(R.string.adsize_too_big, n, o, this.d.j(), this.d.k()));
                com.octopus.ad.internal.c cVar = this.f;
                if (cVar != null) {
                    cVar.a();
                }
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            if (getChildAt(0) instanceof WebView) {
                WebviewUtil.onResume((WebView) getChildAt(0));
                return;
            }
            return;
        }
        f.c("OctopusAd", "enter onWindowVisibilityChanged before dismantleBroadcast");
        HaoboLog.d(HaoboLog.baseLogTag, HaoboLog.getString(R.string.hidden));
        if (this.f != null && this.v) {
            w();
        }
        if (getChildAt(0) instanceof WebView) {
            WebviewUtil.onPause((WebView) getChildAt(0));
        }
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void s() {
        com.octopus.ad.internal.view.b bVar = this.z;
        if (bVar != null) {
            bVar.o();
            this.z = null;
        }
        f.c("OctopusAd", "enter activityOnDestroy before dismantleBroadcast");
        if (this.f != null) {
            w();
        }
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void t() {
        com.octopus.ad.internal.view.b bVar = this.z;
        if (bVar != null) {
            bVar.m();
        }
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public void u() {
        com.octopus.ad.internal.view.b bVar = this.z;
        if (bVar != null) {
            bVar.n();
        }
    }

    public void w() {
        HaoboLog.d(HaoboLog.publicFunctionsLogTag, HaoboLog.getString(R.string.stop));
        this.f.a();
        this.v = false;
    }

    public SplashAdViewImpl(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public SplashAdViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SplashAdViewImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public boolean a(a.C0411a c0411a) {
        h();
        if (!super.a(c0411a)) {
            return false;
        }
        this.v = true;
        return true;
    }

    @Override // com.octopus.ad.internal.view.AdViewImpl
    public boolean a(com.octopus.ad.internal.view.b bVar) {
        if (bVar != null && !bVar.j() && bVar.getView() != null && bVar.getAdWebView() != null) {
            if (this.c == bVar) {
                b(80102);
                return false;
            }
            this.z = bVar;
            if (getTransitionType() == TransitionType.NONE) {
                removeAllViews();
                com.octopus.ad.internal.view.b bVar2 = this.c;
                if (bVar2 != null) {
                    bVar2.k();
                }
                View view = bVar.getView();
                if (view instanceof AdVideoView) {
                    setBackgroundColor(com.sigmob.sdk.base.blurkit.d.f13043a);
                }
                addView(view, new ViewGroup.LayoutParams(-1, -1));
                if (view.getLayoutParams() != null) {
                    ((FrameLayout.LayoutParams) view.getLayoutParams()).gravity = getAdAlignment().a();
                }
                bVar.l();
            } else if (this.y != null) {
                if (bVar.getView().getLayoutParams() != null) {
                    ((FrameLayout.LayoutParams) bVar.getView().getLayoutParams()).gravity = getAdAlignment().a();
                    this.y.setLayoutParams(bVar.getView().getLayoutParams());
                }
                if (getChildCount() != 0 && indexOfChild(this.y) != -1) {
                    if (bVar.getView() instanceof AdVideoView) {
                        bVar.l();
                    }
                    this.y.addView(bVar.getView());
                    this.y.showNext();
                } else {
                    removeAllViews();
                    if (bVar.getView() instanceof AdVideoView) {
                        bVar.l();
                    }
                    addView(this.y, 0);
                    this.y.addView(bVar.getView());
                }
                com.octopus.ad.internal.view.b bVar3 = this.c;
                if (bVar3 != null) {
                    if (bVar3.getView().getAnimation() != null) {
                        bVar3.getView().getAnimation().setAnimationListener(new b(bVar3, this.y));
                    } else {
                        bVar3.k();
                    }
                }
            }
            this.c = bVar;
            return true;
        }
        b(80102);
        HaoboLog.e(HaoboLog.baseLogTag, "Loaded an ad with an invalid displayable");
        return false;
    }
}
