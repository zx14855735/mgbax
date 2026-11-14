package androidx.appcompat.widget;

import ADYaiT.BmvVmW;
import ADYaiT.D9tr6l;
import AZkASS.AcNBzu;
import AZkASS.AlLFFp;
import AZkASS.AmA8tU;
import AZkASS.B25kr6;
import AZkASS.BJ7GGh;
import AZkASS.BTvldC;
import AaHO0E.AYUAbz;
import AaHO0E.AzWtSf;
import AaHO0E.B2KMhB;
import AaHO0E.B3GDIM;
import AaHO0E.EmJGcg;
import AaHO0E.ErKPGd;
import AaHO0E.HSHyT0;
import KCxDWD.A5SV6n;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ActionMenuView extends ErKPGd implements AlLFFp, BTvldC {

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public AmA8tU f8136BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public Context f8137BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f8138BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public boolean f8139BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public AzWtSf f8140BniPrB;
    public D9tr6l BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public AcNBzu f8141C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public boolean f8142C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public int f8143CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public final int f8144CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public final int f8145COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public B3GDIM f8146CQhlFr;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f8144CNPG0E = (int) (56.0f * f);
        this.f8145COJEAR = (int) (f * 4.0f);
        this.f8137BTvldC = context;
        this.f8138BV3sI0 = 0;
    }

    public static B2KMhB AZkASS() {
        B2KMhB b2KMhB = new B2KMhB(-2, -2);
        b2KMhB.f626A2egSU = false;
        ((LinearLayout.LayoutParams) b2KMhB).gravity = 16;
        return b2KMhB;
    }

    public static B2KMhB AaHO0E(ViewGroup.LayoutParams layoutParams) {
        B2KMhB b2KMhB;
        if (layoutParams == null) {
            return AZkASS();
        }
        if (layoutParams instanceof B2KMhB) {
            B2KMhB b2KMhB2 = (B2KMhB) layoutParams;
            b2KMhB = new B2KMhB(b2KMhB2);
            b2KMhB.f626A2egSU = b2KMhB2.f626A2egSU;
        } else {
            b2KMhB = new B2KMhB(layoutParams);
        }
        if (((LinearLayout.LayoutParams) b2KMhB).gravity <= 0) {
            ((LinearLayout.LayoutParams) b2KMhB).gravity = 16;
        }
        return b2KMhB;
    }

    @Override // AZkASS.AlLFFp
    public final boolean A4TApA(B25kr6 b25kr6) {
        return this.f8136BPw6Q8.B2KMhB(b25kr6, null, 0);
    }

    @Override // AZkASS.BTvldC
    public final void A5SV6n(AmA8tU amA8tU) {
        this.f8136BPw6Q8 = amA8tU;
    }

    @Override // AaHO0E.ErKPGd
    /* renamed from: ARc23Z */
    public final /* bridge */ /* synthetic */ EmJGcg generateDefaultLayoutParams() {
        return AZkASS();
    }

    @Override // AaHO0E.ErKPGd
    /* renamed from: ASJ6gh */
    public final EmJGcg generateLayoutParams(AttributeSet attributeSet) {
        return new B2KMhB(getContext(), attributeSet);
    }

    @Override // AaHO0E.ErKPGd
    /* renamed from: AYUAbz */
    public final /* bridge */ /* synthetic */ EmJGcg generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return AaHO0E(layoutParams);
    }

    public final boolean AcNBzu(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof AaHO0E.B25kr6)) {
            z = ((AaHO0E.B25kr6) childAt).A4TApA();
        }
        return (i <= 0 || !(childAt2 instanceof AaHO0E.B25kr6)) ? z : ((AaHO0E.B25kr6) childAt2).A5SV6n() | z;
    }

    @Override // AaHO0E.ErKPGd, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof B2KMhB;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // AaHO0E.ErKPGd, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return AZkASS();
    }

    @Override // AaHO0E.ErKPGd, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return AaHO0E(layoutParams);
    }

    public Menu getMenu() {
        if (this.f8136BPw6Q8 == null) {
            Context context = getContext();
            AmA8tU amA8tU = new AmA8tU(context);
            this.f8136BPw6Q8 = amA8tU;
            amA8tU.f497B25kr6 = new A5SV6n(4, this);
            AzWtSf azWtSf = new AzWtSf(context);
            this.f8140BniPrB = azWtSf;
            azWtSf.f614BIYEnU = true;
            azWtSf.f615BJ7GGh = true;
            BJ7GGh bJ7GGh = this.BpkvW3;
            if (bJ7GGh == null) {
                bJ7GGh = new BmvVmW(1);
            }
            azWtSf.f436B25kr6 = bJ7GGh;
            this.f8136BPw6Q8.A4TApA(azWtSf, this.f8137BTvldC);
            AzWtSf azWtSf2 = this.f8140BniPrB;
            azWtSf2.f439B4ZgIw = this;
            this.f8136BPw6Q8 = azWtSf2.f434AmA8tU;
        }
        return this.f8136BPw6Q8;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        AzWtSf azWtSf = this.f8140BniPrB;
        AaHO0E.AcNBzu acNBzu = azWtSf.f611B9tovu;
        if (acNBzu != null) {
            return acNBzu.getDrawable();
        }
        if (azWtSf.f613BI9f7h) {
            return azWtSf.f612BChYOn;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f8138BV3sI0;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AzWtSf azWtSf = this.f8140BniPrB;
        if (azWtSf != null) {
            azWtSf.A4TApA(false);
            if (this.f8140BniPrB.AlLFFp()) {
                this.f8140BniPrB.AcNBzu();
                this.f8140BniPrB.AmA8tU();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AzWtSf azWtSf = this.f8140BniPrB;
        if (azWtSf != null) {
            azWtSf.AcNBzu();
            AYUAbz aYUAbz = azWtSf.BpkvW3;
            if (aYUAbz == null || !aYUAbz.A4TApA()) {
                return;
            }
            aYUAbz.f568AZOQYO.dismiss();
        }
    }

    @Override // AaHO0E.ErKPGd, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int i5;
        if (!this.f8142C4FrIb) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i6 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i7 = i3 - i;
        int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
        boolean z2 = HSHyT0.f933A2egSU;
        boolean z3 = getLayoutDirection() == 1;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                B2KMhB b2KMhB = (B2KMhB) childAt.getLayoutParams();
                if (b2KMhB.f626A2egSU) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (AcNBzu(i10)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (z3) {
                        i5 = getPaddingLeft() + ((LinearLayout.LayoutParams) b2KMhB).leftMargin;
                        width = i5 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) b2KMhB).rightMargin;
                        i5 = width - measuredWidth;
                    }
                    int i11 = i6 - (measuredHeight / 2);
                    childAt.layout(i5, i11, width, measuredHeight + i11);
                    paddingRight -= measuredWidth;
                    i8 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) b2KMhB).leftMargin) + ((LinearLayout.LayoutParams) b2KMhB).rightMargin;
                    AcNBzu(i10);
                    i9++;
                }
            }
        }
        if (childCount == 1 && i8 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i12 = (i7 / 2) - (measuredWidth2 / 2);
            int i13 = i6 - (measuredHeight2 / 2);
            childAt2.layout(i12, i13, measuredWidth2 + i12, measuredHeight2 + i13);
            return;
        }
        int i14 = i9 - (i8 ^ 1);
        int max = Math.max(0, i14 > 0 ? paddingRight / i14 : 0);
        if (z3) {
            int width2 = getWidth() - getPaddingRight();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt3 = getChildAt(i15);
                B2KMhB b2KMhB2 = (B2KMhB) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !b2KMhB2.f626A2egSU) {
                    int i16 = width2 - ((LinearLayout.LayoutParams) b2KMhB2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i6 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth3, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth3 + ((LinearLayout.LayoutParams) b2KMhB2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt4 = getChildAt(i18);
            B2KMhB b2KMhB3 = (B2KMhB) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !b2KMhB3.f626A2egSU) {
                int i19 = paddingLeft + ((LinearLayout.LayoutParams) b2KMhB3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i20 = i6 - (measuredHeight4 / 2);
                childAt4.layout(i19, i20, i19 + measuredWidth4, measuredHeight4 + i20);
                paddingLeft = measuredWidth4 + ((LinearLayout.LayoutParams) b2KMhB3).rightMargin + max + i19;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v41 */
    @Override // AaHO0E.ErKPGd, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        ?? r11;
        int i5;
        int i6;
        AmA8tU amA8tU;
        boolean z = this.f8142C4FrIb;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.f8142C4FrIb = z2;
        if (z != z2) {
            this.f8143CASmeH = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.f8142C4FrIb && (amA8tU = this.f8136BPw6Q8) != null && size != this.f8143CASmeH) {
            this.f8143CASmeH = size;
            amA8tU.B25kr6(true);
        }
        int childCount = getChildCount();
        if (!this.f8142C4FrIb || childCount <= 0) {
            for (int i7 = 0; i7 < childCount; i7++) {
                B2KMhB b2KMhB = (B2KMhB) getChildAt(i7).getLayoutParams();
                ((LinearLayout.LayoutParams) b2KMhB).rightMargin = 0;
                ((LinearLayout.LayoutParams) b2KMhB).leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int size3 = View.MeasureSpec.getSize(i2);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingBottom, -2);
        int i8 = size2 - paddingRight;
        int i9 = this.f8144CNPG0E;
        int i10 = i8 / i9;
        int i11 = i8 % i9;
        if (i10 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i12 = (i11 / i10) + i9;
        int childCount2 = getChildCount();
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        boolean z3 = false;
        int i17 = 0;
        long j = 0;
        while (true) {
            i3 = this.f8145COJEAR;
            if (i16 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i16);
            int i18 = size3;
            int i19 = paddingBottom;
            if (childAt.getVisibility() == 8) {
                i5 = i12;
            } else {
                boolean z4 = childAt instanceof ActionMenuItemView;
                i14++;
                if (z4) {
                    childAt.setPadding(i3, 0, i3, 0);
                }
                B2KMhB b2KMhB2 = (B2KMhB) childAt.getLayoutParams();
                b2KMhB2.f630ARc23Z = false;
                b2KMhB2.f628A5SV6n = 0;
                b2KMhB2.f627A4TApA = 0;
                b2KMhB2.f629ADYaiT = false;
                ((LinearLayout.LayoutParams) b2KMhB2).leftMargin = 0;
                ((LinearLayout.LayoutParams) b2KMhB2).rightMargin = 0;
                b2KMhB2.AMqCpz = z4 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i20 = b2KMhB2.f626A2egSU ? 1 : i10;
                B2KMhB b2KMhB3 = (B2KMhB) childAt.getLayoutParams();
                int i21 = i10;
                i5 = i12;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i19, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z4 ? (ActionMenuItemView) childAt : null;
                boolean z5 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                boolean z6 = z5;
                if (i20 <= 0 || (z5 && i20 < 2)) {
                    i6 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i5 * i20, Integer.MIN_VALUE), makeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i6 = measuredWidth / i5;
                    if (measuredWidth % i5 != 0) {
                        i6++;
                    }
                    if (z6 && i6 < 2) {
                        i6 = 2;
                    }
                }
                b2KMhB3.f629ADYaiT = !b2KMhB3.f626A2egSU && z6;
                b2KMhB3.f627A4TApA = i6;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i6 * i5, 1073741824), makeMeasureSpec);
                i15 = Math.max(i15, i6);
                if (b2KMhB2.f629ADYaiT) {
                    i17++;
                }
                if (b2KMhB2.f626A2egSU) {
                    z3 = true;
                }
                i10 = i21 - i6;
                i13 = Math.max(i13, childAt.getMeasuredHeight());
                if (i6 == 1) {
                    j |= 1 << i16;
                }
            }
            i16++;
            size3 = i18;
            paddingBottom = i19;
            i12 = i5;
        }
        int i22 = size3;
        int i23 = i10;
        int i24 = i12;
        boolean z7 = z3 && i14 == 2;
        int i25 = i23;
        boolean z8 = false;
        while (i17 > 0 && i25 > 0) {
            int i26 = Integer.MAX_VALUE;
            long j2 = 0;
            int i27 = 0;
            int i28 = 0;
            while (i28 < childCount2) {
                boolean z9 = z7;
                B2KMhB b2KMhB4 = (B2KMhB) getChildAt(i28).getLayoutParams();
                int i29 = i13;
                if (b2KMhB4.f629ADYaiT) {
                    int i30 = b2KMhB4.f627A4TApA;
                    if (i30 < i26) {
                        j2 = 1 << i28;
                        i26 = i30;
                        i27 = 1;
                    } else if (i30 == i26) {
                        j2 |= 1 << i28;
                        i27++;
                    }
                }
                i28++;
                i13 = i29;
                z7 = z9;
            }
            boolean z10 = z7;
            i4 = i13;
            j |= j2;
            if (i27 > i25) {
                break;
            }
            int i31 = i26 + 1;
            int i32 = 0;
            while (i32 < childCount2) {
                View childAt2 = getChildAt(i32);
                B2KMhB b2KMhB5 = (B2KMhB) childAt2.getLayoutParams();
                boolean z11 = z3;
                long j3 = 1 << i32;
                if ((j2 & j3) != 0) {
                    if (z10 && b2KMhB5.AMqCpz) {
                        r11 = 1;
                        r11 = 1;
                        if (i25 == 1) {
                            childAt2.setPadding(i3 + i24, 0, i3, 0);
                        }
                    } else {
                        r11 = 1;
                    }
                    b2KMhB5.f627A4TApA += r11;
                    b2KMhB5.f630ARc23Z = r11;
                    i25--;
                } else if (b2KMhB5.f627A4TApA == i31) {
                    j |= j3;
                }
                i32++;
                z3 = z11;
            }
            i13 = i4;
            z7 = z10;
            z8 = true;
        }
        i4 = i13;
        boolean z12 = !z3 && i14 == 1;
        if (i25 > 0 && j != 0 && (i25 < i14 - 1 || z12 || i15 > 1)) {
            float bitCount = Long.bitCount(j);
            if (!z12) {
                if ((j & 1) != 0 && !((B2KMhB) getChildAt(0).getLayoutParams()).AMqCpz) {
                    bitCount -= 0.5f;
                }
                int i33 = childCount2 - 1;
                if ((j & (1 << i33)) != 0 && !((B2KMhB) getChildAt(i33).getLayoutParams()).AMqCpz) {
                    bitCount -= 0.5f;
                }
            }
            int i34 = bitCount > 0.0f ? (int) ((i25 * i24) / bitCount) : 0;
            boolean z13 = z8;
            for (int i35 = 0; i35 < childCount2; i35++) {
                if ((j & (1 << i35)) != 0) {
                    View childAt3 = getChildAt(i35);
                    B2KMhB b2KMhB6 = (B2KMhB) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        b2KMhB6.f628A5SV6n = i34;
                        b2KMhB6.f630ARc23Z = true;
                        if (i35 == 0 && !b2KMhB6.AMqCpz) {
                            ((LinearLayout.LayoutParams) b2KMhB6).leftMargin = (-i34) / 2;
                        }
                        z13 = true;
                    } else if (b2KMhB6.f626A2egSU) {
                        b2KMhB6.f628A5SV6n = i34;
                        b2KMhB6.f630ARc23Z = true;
                        ((LinearLayout.LayoutParams) b2KMhB6).rightMargin = (-i34) / 2;
                        z13 = true;
                    } else {
                        if (i35 != 0) {
                            ((LinearLayout.LayoutParams) b2KMhB6).leftMargin = i34 / 2;
                        }
                        if (i35 != childCount2 - 1) {
                            ((LinearLayout.LayoutParams) b2KMhB6).rightMargin = i34 / 2;
                        }
                    }
                }
            }
            z8 = z13;
        }
        if (z8) {
            for (int i36 = 0; i36 < childCount2; i36++) {
                View childAt4 = getChildAt(i36);
                B2KMhB b2KMhB7 = (B2KMhB) childAt4.getLayoutParams();
                if (b2KMhB7.f630ARc23Z) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((b2KMhB7.f627A4TApA * i24) + b2KMhB7.f628A5SV6n, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i8, mode != 1073741824 ? i4 : i22);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f8140BniPrB.f619BV3sI0 = z;
    }

    public void setOnMenuItemClickListener(B3GDIM b3gdim) {
        this.f8146CQhlFr = b3gdim;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        AzWtSf azWtSf = this.f8140BniPrB;
        AaHO0E.AcNBzu acNBzu = azWtSf.f611B9tovu;
        if (acNBzu != null) {
            acNBzu.setImageDrawable(drawable);
        } else {
            azWtSf.f613BI9f7h = true;
            azWtSf.f612BChYOn = drawable;
        }
    }

    public void setOverflowReserved(boolean z) {
        this.f8139BmvVmW = z;
    }

    public void setPopupTheme(int i) {
        if (this.f8138BV3sI0 != i) {
            this.f8138BV3sI0 = i;
            if (i == 0) {
                this.f8137BTvldC = getContext();
            } else {
                this.f8137BTvldC = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(AzWtSf azWtSf) {
        this.f8140BniPrB = azWtSf;
        azWtSf.f439B4ZgIw = this;
        this.f8136BPw6Q8 = azWtSf.f434AmA8tU;
    }

    @Override // AaHO0E.ErKPGd, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new B2KMhB(getContext(), attributeSet);
    }
}
