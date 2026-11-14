package AaHO0E;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class HHLj6Q implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: BChYOn, reason: collision with root package name */
    public static HHLj6Q f914BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static HHLj6Q f915BI9f7h;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final View f916AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final CharSequence f917AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f918AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final HH6JFw f919AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final HH6JFw f920B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f921B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f922B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public HHoABE f923B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f924B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f925B9tovu;

    /* JADX WARN: Type inference failed for: r0v0, types: [AaHO0E.HH6JFw] */
    /* JADX WARN: Type inference failed for: r0v1, types: [AaHO0E.HH6JFw] */
    public HHLj6Q(View view, CharSequence charSequence) {
        final int i = 0;
        this.f919AzWtSf = new Runnable(this) { // from class: AaHO0E.HH6JFw

            /* renamed from: AlLFFp, reason: collision with root package name */
            public final /* synthetic */ HHLj6Q f913AlLFFp;

            {
                this.f913AlLFFp = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        this.f913AlLFFp.A5SV6n(false);
                        break;
                    default:
                        this.f913AlLFFp.A2egSU();
                        break;
                }
            }
        };
        final int i2 = 1;
        this.f920B25kr6 = new Runnable(this) { // from class: AaHO0E.HH6JFw

            /* renamed from: AlLFFp, reason: collision with root package name */
            public final /* synthetic */ HHLj6Q f913AlLFFp;

            {
                this.f913AlLFFp = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        this.f913AlLFFp.A5SV6n(false);
                        break;
                    default:
                        this.f913AlLFFp.A2egSU();
                        break;
                }
            }
        };
        this.f916AcNBzu = view;
        this.f917AlLFFp = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = COJEAR.DXnQ0V.f1686A2egSU;
        this.f918AmA8tU = Build.VERSION.SDK_INT >= 28 ? COJEAR.DUi7mC.A2egSU(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
        this.f925B9tovu = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void A4TApA(HHLj6Q hHLj6Q) {
        HHLj6Q hHLj6Q2 = f914BChYOn;
        if (hHLj6Q2 != null) {
            hHLj6Q2.f916AcNBzu.removeCallbacks(hHLj6Q2.f919AzWtSf);
        }
        f914BChYOn = hHLj6Q;
        if (hHLj6Q != null) {
            hHLj6Q.f916AcNBzu.postDelayed(hHLj6Q.f919AzWtSf, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void A2egSU() {
        HHLj6Q hHLj6Q = f915BI9f7h;
        View view = this.f916AcNBzu;
        if (hHLj6Q == this) {
            f915BI9f7h = null;
            HHoABE hHoABE = this.f923B4ZgIw;
            if (hHoABE != null) {
                View view2 = (View) hHoABE.f927A4TApA;
                if (view2.getParent() != null) {
                    ((WindowManager) ((Context) hHoABE.f926A2egSU).getSystemService("window")).removeView(view2);
                }
                this.f923B4ZgIw = null;
                this.f925B9tovu = true;
                view.removeOnAttachStateChangeListener(this);
            }
        }
        if (f914BChYOn == this) {
            A4TApA(null);
        }
        view.removeCallbacks(this.f920B25kr6);
    }

    public final void A5SV6n(boolean z) {
        int height;
        int i;
        int i2;
        int i3;
        int i4;
        char c;
        long longPressTimeout;
        long j;
        long j2;
        View view = this.f916AcNBzu;
        if (view.isAttachedToWindow()) {
            A4TApA(null);
            HHLj6Q hHLj6Q = f915BI9f7h;
            if (hHLj6Q != null) {
                hHLj6Q.A2egSU();
            }
            f915BI9f7h = this;
            this.f924B7CMnp = z;
            HHoABE hHoABE = new HHoABE(view.getContext());
            this.f923B4ZgIw = hHoABE;
            int i5 = this.f921B2KMhB;
            int i6 = this.f922B3GDIM;
            boolean z2 = this.f924B7CMnp;
            View view2 = (View) hHoABE.f927A4TApA;
            ViewParent parent = view2.getParent();
            Context context = (Context) hHoABE.f926A2egSU;
            if (parent != null && view2.getParent() != null) {
                ((WindowManager) context.getSystemService("window")).removeView(view2);
            }
            ((TextView) hHoABE.f928A5SV6n).setText(this.f917AlLFFp);
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) hHoABE.f929ADYaiT;
            layoutParams.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(2131166576);
            if (view.getWidth() < dimensionPixelOffset) {
                i5 = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(2131166575);
                height = i6 + dimensionPixelOffset2;
                i = i6 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(z2 ? 2131166579 : 2131166578);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
                Context context2 = view.getContext();
                while (true) {
                    if (!(context2 instanceof ContextWrapper)) {
                        break;
                    }
                    if (context2 instanceof Activity) {
                        rootView = ((Activity) context2).getWindow().getDecorView();
                        break;
                    }
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
            if (rootView != null) {
                Rect rect = (Rect) hHoABE.AMqCpz;
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    i2 = i5;
                    i3 = i;
                    i4 = 0;
                    c = 1;
                } else {
                    Resources resources = context.getResources();
                    c = 1;
                    i2 = i5;
                    i3 = i;
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i4 = 0;
                    rect.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                int[] iArr = (int[]) hHoABE.f931ASJ6gh;
                rootView.getLocationOnScreen(iArr);
                int[] iArr2 = (int[]) hHoABE.f930ARc23Z;
                view.getLocationOnScreen(iArr2);
                int i7 = iArr2[i4] - iArr[i4];
                iArr2[i4] = i7;
                iArr2[c] = iArr2[c] - iArr[c];
                layoutParams.x = (i7 + i2) - (rootView.getWidth() / 2);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, i4);
                view2.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i8 = iArr2[c];
                int i9 = ((i8 + i3) - dimensionPixelOffset3) - measuredHeight;
                int i10 = i8 + height + dimensionPixelOffset3;
                if (z2) {
                    if (i9 >= 0) {
                        layoutParams.y = i9;
                    } else {
                        layoutParams.y = i10;
                    }
                } else if (measuredHeight + i10 <= rect.height()) {
                    layoutParams.y = i10;
                } else {
                    layoutParams.y = i9;
                }
            }
            ((WindowManager) context.getSystemService("window")).addView(view2, layoutParams);
            view.addOnAttachStateChangeListener(this);
            if (this.f924B7CMnp) {
                j2 = 2500;
            } else {
                WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
                if ((view.getWindowSystemUiVisibility() & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 15000;
                }
                j2 = j - longPressTimeout;
            }
            HH6JFw hH6JFw = this.f920B25kr6;
            view.removeCallbacks(hH6JFw);
            view.postDelayed(hH6JFw, j2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        if (java.lang.Math.abs(r5 - r3.f922B3GDIM) <= r2) goto L30;
     */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onHover(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            AaHO0E.HHoABE r4 = r3.f923B4ZgIw
            r0 = 0
            if (r4 == 0) goto La
            boolean r4 = r3.f924B7CMnp
            if (r4 == 0) goto La
            goto L6f
        La:
            android.view.View r4 = r3.f916AcNBzu
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "accessibility"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.accessibility.AccessibilityManager r1 = (android.view.accessibility.AccessibilityManager) r1
            boolean r2 = r1.isEnabled()
            if (r2 == 0) goto L25
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 == 0) goto L25
            goto L6f
        L25:
            int r1 = r5.getAction()
            r2 = 7
            if (r1 == r2) goto L38
            r4 = 10
            if (r1 == r4) goto L31
            goto L6f
        L31:
            r4 = 1
            r3.f925B9tovu = r4
            r3.A2egSU()
            return r0
        L38:
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L6f
            AaHO0E.HHoABE r4 = r3.f923B4ZgIw
            if (r4 != 0) goto L6f
            float r4 = r5.getX()
            int r4 = (int) r4
            float r5 = r5.getY()
            int r5 = (int) r5
            boolean r1 = r3.f925B9tovu
            if (r1 != 0) goto L66
            int r1 = r3.f921B2KMhB
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.f918AmA8tU
            if (r1 > r2) goto L66
            int r1 = r3.f922B3GDIM
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r1 <= r2) goto L6f
        L66:
            r3.f921B2KMhB = r4
            r3.f922B3GDIM = r5
            r3.f925B9tovu = r0
            A4TApA(r3)
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: AaHO0E.HHLj6Q.onHover(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f921B2KMhB = view.getWidth() / 2;
        this.f922B3GDIM = view.getHeight() / 2;
        A5SV6n(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        A2egSU();
    }
}
