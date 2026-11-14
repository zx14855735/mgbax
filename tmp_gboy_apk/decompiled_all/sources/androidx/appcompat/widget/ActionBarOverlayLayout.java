package androidx.appcompat.widget;

import ADYaiT.DXuj49;
import AZOQYO.AcNBzu;
import AZkASS.AmA8tU;
import AaHO0E.A5SV6n;
import AaHO0E.ADYaiT;
import AaHO0E.AMqCpz;
import AaHO0E.ARc23Z;
import AaHO0E.ASJ6gh;
import AaHO0E.AzWtSf;
import AaHO0E.DuwtYk;
import AaHO0E.DvK7DB;
import AaHO0E.GhvxjZ;
import AaHO0E.H6qKiO;
import COJEAR.BI9f7h;
import COJEAR.BIYEnU;
import COJEAR.BJ7GGh;
import COJEAR.CikNvS;
import COJEAR.CmUvjW;
import COJEAR.DG07BK;
import COJEAR.EdQ5bb;
import COJEAR.EmJGcg;
import COJEAR.F32kj0;
import COJEAR.FG7pZc;
import NOd7IU.AlLFFp;
import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

@SuppressLint({"UnknownNullness"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements DuwtYk, BI9f7h, BIYEnU {

    /* renamed from: CTkVKb, reason: collision with root package name */
    public static final int[] f8106CTkVKb = {2130968581, R.attr.windowContentOverlay};

    /* renamed from: CcAIMM, reason: collision with root package name */
    public static final FG7pZc f8107CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public static final Rect f8108Cd8JRx;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f8109AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f8110AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public ContentFrameLayout f8111AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public ActionBarContainer f8112AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public DvK7DB f8113B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public Drawable f8114B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f8115B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f8116B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f8117B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f8118B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f8119BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f8120BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final Rect f8121BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final Rect f8122BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final Rect f8123BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final Rect f8124BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public FG7pZc f8125BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public FG7pZc f8126BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public FG7pZc f8127BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public FG7pZc f8128BniPrB;
    public AMqCpz BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public OverScroller f8129C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public ViewPropertyAnimator f8130C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public final A5SV6n f8131CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public final ADYaiT f8132CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public final ADYaiT f8133COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public final BJ7GGh f8134CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public final ASJ6gh f8135CSDoyG;

    static {
        EdQ5bb edQ5bb = new EdQ5bb();
        BV3sI0.A5SV6n A4TApA2 = BV3sI0.A5SV6n.A4TApA(0, 1, 0, 1);
        EmJGcg emJGcg = edQ5bb.f1721A2egSU;
        emJGcg.ASJ6gh(A4TApA2);
        f8107CcAIMM = emJGcg.A4TApA();
        f8108Cd8JRx = new Rect();
        yxZko();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8110AlLFFp = 0;
        this.f8121BIYEnU = new Rect();
        this.f8122BJ7GGh = new Rect();
        this.f8123BNL6CD = new Rect();
        this.f8124BPw6Q8 = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        FG7pZc fG7pZc = FG7pZc.f1746A4TApA;
        this.f8125BTvldC = fG7pZc;
        this.f8126BV3sI0 = fG7pZc;
        this.f8127BmvVmW = fG7pZc;
        this.f8128BniPrB = fG7pZc;
        this.f8131CASmeH = new A5SV6n(0, this);
        this.f8132CNPG0E = new ADYaiT(this, 0);
        this.f8133COJEAR = new ADYaiT(this, 1);
        A5SV6n(context);
        this.f8134CQhlFr = new BJ7GGh();
        ASJ6gh aSJ6gh = new ASJ6gh(context);
        aSJ6gh.setWillNotDraw(true);
        this.f8135CSDoyG = aSJ6gh;
        addView(aSJ6gh);
    }

    public static boolean A2egSU(View view, Rect rect, boolean z) {
        boolean z2;
        ARc23Z aRc23Z = (ARc23Z) view.getLayoutParams();
        int i = ((ViewGroup.MarginLayoutParams) aRc23Z).leftMargin;
        int i2 = rect.left;
        if (i != i2) {
            ((ViewGroup.MarginLayoutParams) aRc23Z).leftMargin = i2;
            z2 = true;
        } else {
            z2 = false;
        }
        int i3 = ((ViewGroup.MarginLayoutParams) aRc23Z).topMargin;
        int i4 = rect.top;
        if (i3 != i4) {
            ((ViewGroup.MarginLayoutParams) aRc23Z).topMargin = i4;
            z2 = true;
        }
        int i5 = ((ViewGroup.MarginLayoutParams) aRc23Z).rightMargin;
        int i6 = rect.right;
        if (i5 != i6) {
            ((ViewGroup.MarginLayoutParams) aRc23Z).rightMargin = i6;
            z2 = true;
        }
        if (z) {
            int i7 = ((ViewGroup.MarginLayoutParams) aRc23Z).bottomMargin;
            int i8 = rect.bottom;
            if (i7 != i8) {
                ((ViewGroup.MarginLayoutParams) aRc23Z).bottomMargin = i8;
                return true;
            }
        }
        return z2;
    }

    private static /* synthetic */ void yxZko() {
        char[] charArray = "\u0097\u009b\u0099Ú\u0093\u0095\u0099\u0091Ú\u0096\u009b\u008dÚ\u0087\u009c\u0091\u0098\u0098Ú¾\u009a\u009d¶\u0086\u009d\u0090\u0093\u0091".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 244);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0097\u0098\u009d\u009a\u009d\u0080".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 244);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A4TApA() {
        removeCallbacks(this.f8132CNPG0E);
        removeCallbacks(this.f8133COJEAR);
        ViewPropertyAnimator viewPropertyAnimator = this.f8130C4FrIb;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void A5SV6n(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f8106CTkVKb);
        this.f8109AcNBzu = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f8114B2KMhB = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.f8129C2rE4F = new OverScroller(context);
    }

    public final void ADYaiT(int i) {
        AMqCpz();
        if (i == 2) {
            this.f8113B25kr6.getClass();
        } else if (i == 5) {
            this.f8113B25kr6.getClass();
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public final void AMqCpz() {
        DvK7DB wrapper;
        if (this.f8111AmA8tU == null) {
            this.f8111AmA8tU = (ContentFrameLayout) findViewById(2131296320);
            this.f8112AzWtSf = (ActionBarContainer) findViewById(2131296321);
            KeyEvent.Callback findViewById = findViewById(2131296319);
            if (findViewById instanceof DvK7DB) {
                wrapper = (DvK7DB) findViewById;
            } else {
                if (!(findViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) findViewById).getWrapper();
            }
            this.f8113B25kr6 = wrapper;
        }
    }

    public final void ARc23Z(AmA8tU amA8tU, AZkASS.BJ7GGh bJ7GGh) {
        AMqCpz();
        H6qKiO h6qKiO = (H6qKiO) this.f8113B25kr6;
        AzWtSf azWtSf = h6qKiO.f909AlLFFp;
        Toolbar toolbar = h6qKiO.f898A2egSU;
        if (azWtSf == null) {
            AzWtSf azWtSf2 = new AzWtSf(toolbar.getContext());
            h6qKiO.f909AlLFFp = azWtSf2;
            azWtSf2.f440B7CMnp = 2131296334;
        }
        AzWtSf azWtSf3 = h6qKiO.f909AlLFFp;
        azWtSf3.f436B25kr6 = bJ7GGh;
        if (amA8tU == null && toolbar.f8219AcNBzu == null) {
            return;
        }
        toolbar.ARc23Z();
        AmA8tU amA8tU2 = toolbar.f8219AcNBzu.f8136BPw6Q8;
        if (amA8tU2 == amA8tU) {
            return;
        }
        if (amA8tU2 != null) {
            amA8tU2.B3GDIM(toolbar.f8255CtxOCS);
            amA8tU2.B3GDIM(toolbar.f8256D07BeM);
        }
        if (toolbar.f8256D07BeM == null) {
            toolbar.f8256D07BeM = new GhvxjZ(toolbar);
        }
        azWtSf3.f619BV3sI0 = true;
        if (amA8tU != null) {
            amA8tU.A4TApA(azWtSf3, toolbar.f8228B9tovu);
            amA8tU.A4TApA(toolbar.f8256D07BeM, toolbar.f8228B9tovu);
        } else {
            azWtSf3.AZkASS(toolbar.f8228B9tovu, null);
            toolbar.f8256D07BeM.AZkASS(toolbar.f8228B9tovu, null);
            azWtSf3.A4TApA(true);
            toolbar.f8256D07BeM.A4TApA(true);
        }
        toolbar.f8219AcNBzu.setPopupTheme(toolbar.f8229BChYOn);
        toolbar.f8219AcNBzu.setPresenter(azWtSf3);
        toolbar.f8255CtxOCS = azWtSf3;
        toolbar.BI9f7h();
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ARc23Z;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        if (this.f8114B2KMhB != null) {
            if (this.f8112AzWtSf.getVisibility() == 0) {
                i = (int) (this.f8112AzWtSf.getTranslationY() + this.f8112AzWtSf.getBottom() + 0.5f);
            } else {
                i = 0;
            }
            this.f8114B2KMhB.setBounds(0, i, getWidth(), this.f8114B2KMhB.getIntrinsicHeight() + i);
            this.f8114B2KMhB.draw(canvas);
        }
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ARc23Z(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ARc23Z(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f8112AzWtSf;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        BJ7GGh bJ7GGh = this.f8134CQhlFr;
        return bJ7GGh.f1649A4TApA | bJ7GGh.f1648A2egSU;
    }

    public CharSequence getTitle() {
        AMqCpz();
        return ((H6qKiO) this.f8113B25kr6).f898A2egSU.getTitle();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        AMqCpz();
        FG7pZc ASJ6gh2 = FG7pZc.ASJ6gh(this, windowInsets);
        boolean A2egSU2 = A2egSU(this.f8112AzWtSf, new Rect(ASJ6gh2.A4TApA(), ASJ6gh2.ADYaiT(), ASJ6gh2.A5SV6n(), ASJ6gh2.A2egSU()), false);
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        Rect rect = this.f8121BIYEnU;
        CmUvjW.A4TApA(this, ASJ6gh2, rect);
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        F32kj0 f32kj0 = ASJ6gh2.f1747A2egSU;
        FG7pZc AcNBzu2 = f32kj0.AcNBzu(i, i2, i3, i4);
        this.f8125BTvldC = AcNBzu2;
        boolean z = true;
        if (!this.f8126BV3sI0.equals(AcNBzu2)) {
            this.f8126BV3sI0 = this.f8125BTvldC;
            A2egSU2 = true;
        }
        Rect rect2 = this.f8122BJ7GGh;
        if (rect2.equals(rect)) {
            z = A2egSU2;
        } else {
            rect2.set(rect);
        }
        if (z) {
            requestLayout();
        }
        return f32kj0.A2egSU().f1747A2egSU.A5SV6n().f1747A2egSU.A4TApA().ARc23Z();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        A5SV6n(getContext());
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        CikNvS.A5SV6n(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        A4TApA();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                ARc23Z aRc23Z = (ARc23Z) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) aRc23Z).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) aRc23Z).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00e8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r13, int r14) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f8117B7CMnp || !z) {
            return false;
        }
        this.f8129C2rE4F.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f8129C2rE4F.getFinalY() > this.f8112AzWtSf.getHeight()) {
            A4TApA();
            this.f8133COJEAR.run();
        } else {
            A4TApA();
            this.f8132CNPG0E.run();
        }
        this.f8118B9tovu = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // COJEAR.BIYEnU
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        onNestedScroll(view, i, i2, i3, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        DXuj49 dXuj49;
        AcNBzu acNBzu;
        this.f8134CQhlFr.f1648A2egSU = i;
        this.f8119BChYOn = getActionBarHideOffset();
        A4TApA();
        AMqCpz aMqCpz = this.BpkvW3;
        if (aMqCpz == null || (acNBzu = (dXuj49 = (DXuj49) aMqCpz).f268B4ZgIw) == null) {
            return;
        }
        acNBzu.A2egSU();
        dXuj49.f268B4ZgIw = null;
    }

    @Override // COJEAR.BI9f7h
    public final boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // COJEAR.BI9f7h
    public final void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        AMqCpz();
        int i2 = this.f8120BI9f7h ^ i;
        this.f8120BI9f7h = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        AMqCpz aMqCpz = this.BpkvW3;
        if (aMqCpz != null) {
            DXuj49 dXuj49 = (DXuj49) aMqCpz;
            dXuj49.f264AzWtSf = !z2;
            if (z || !z2) {
                if (dXuj49.f265B25kr6) {
                    dXuj49.f265B25kr6 = false;
                    dXuj49.BChYOn(true);
                }
            } else if (!dXuj49.f265B25kr6) {
                dXuj49.f265B25kr6 = true;
                dXuj49.BChYOn(true);
            }
        }
        if ((i2 & 256) == 0 || this.BpkvW3 == null) {
            return;
        }
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        CikNvS.A5SV6n(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f8110AlLFFp = i;
        AMqCpz aMqCpz = this.BpkvW3;
        if (aMqCpz != null) {
            ((DXuj49) aMqCpz).f263AmA8tU = i;
        }
    }

    public void setActionBarHideOffset(int i) {
        A4TApA();
        this.f8112AzWtSf.setTranslationY(-Math.max(0, Math.min(i, this.f8112AzWtSf.getHeight())));
    }

    public void setActionBarVisibilityCallback(AMqCpz aMqCpz) {
        this.BpkvW3 = aMqCpz;
        if (getWindowToken() != null) {
            ((DXuj49) this.BpkvW3).f263AmA8tU = this.f8110AlLFFp;
            int i = this.f8120BI9f7h;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
                CikNvS.A5SV6n(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f8116B4ZgIw = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f8117B7CMnp) {
            this.f8117B7CMnp = z;
            if (z) {
                return;
            }
            A4TApA();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        AMqCpz();
        H6qKiO h6qKiO = (H6qKiO) this.f8113B25kr6;
        h6qKiO.f901ADYaiT = i != 0 ? AlLFFp.CQhlFr(h6qKiO.getContext(), i) : null;
        h6qKiO.A5SV6n();
    }

    public void setLogo(int i) {
        AMqCpz();
        H6qKiO h6qKiO = (H6qKiO) this.f8113B25kr6;
        h6qKiO.AMqCpz = i != 0 ? AlLFFp.CQhlFr(h6qKiO.getContext(), i) : null;
        h6qKiO.A5SV6n();
    }

    public void setOverlayMode(boolean z) {
        this.f8115B3GDIM = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // AaHO0E.DuwtYk
    public void setWindowCallback(Window.Callback callback) {
        AMqCpz();
        ((H6qKiO) this.f8113B25kr6).f907AaHO0E = callback;
    }

    @Override // AaHO0E.DuwtYk
    public void setWindowTitle(CharSequence charSequence) {
        AMqCpz();
        H6qKiO h6qKiO = (H6qKiO) this.f8113B25kr6;
        if (h6qKiO.f903ASJ6gh) {
            return;
        }
        h6qKiO.f904AYUAbz = charSequence;
        if ((h6qKiO.f899A4TApA & 8) != 0) {
            Toolbar toolbar = h6qKiO.f898A2egSU;
            toolbar.setTitle(charSequence);
            if (h6qKiO.f903ASJ6gh) {
                DG07BK.B7CMnp(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // COJEAR.BI9f7h
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
    }

    @Override // COJEAR.BI9f7h
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f8112AzWtSf.getVisibility() != 0) {
            return false;
        }
        return this.f8117B7CMnp;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f8117B7CMnp || this.f8118B9tovu) {
            return;
        }
        if (this.f8119BChYOn <= this.f8112AzWtSf.getHeight()) {
            A4TApA();
            postDelayed(this.f8132CNPG0E, 600L);
        } else {
            A4TApA();
            postDelayed(this.f8133COJEAR, 600L);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ARc23Z(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.f8119BChYOn + i2;
        this.f8119BChYOn = i5;
        setActionBarHideOffset(i5);
    }

    public void setIcon(Drawable drawable) {
        AMqCpz();
        H6qKiO h6qKiO = (H6qKiO) this.f8113B25kr6;
        h6qKiO.f901ADYaiT = drawable;
        h6qKiO.A5SV6n();
    }

    @Override // COJEAR.BI9f7h
    public final void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }
}
