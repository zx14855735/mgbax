package androidx.appcompat.widget;

import ADYaiT.A5SV6n;
import AZOQYO.A4TApA;
import AZkASS.AmA8tU;
import AZkASS.BTvldC;
import AaHO0E.A2egSU;
import AaHO0E.AYUAbz;
import AaHO0E.AzWtSf;
import AaHO0E.HSHyT0;
import COJEAR.DG07BK;
import COJEAR.De4eam;
import NOd7IU.AlLFFp;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ActionBarContextView extends ViewGroup {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A2egSU f8086AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Context f8087AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public ActionMenuView f8088AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public AzWtSf f8089AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f8090B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public De4eam f8091B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f8092B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f8093B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public CharSequence f8094B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public CharSequence f8095B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public View f8096BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public View f8097BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public View f8098BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public LinearLayout f8099BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public TextView f8100BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public TextView f8101BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final int f8102BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final int f8103BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public boolean f8104BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final int f8105BniPrB;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130968607);
        int resourceId;
        A2egSU a2egSU = new A2egSU();
        a2egSU.f595A5SV6n = this;
        a2egSU.f594A4TApA = false;
        this.f8086AcNBzu = a2egSU;
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(2130968580, typedValue, true) || typedValue.resourceId == 0) {
            this.f8087AlLFFp = context;
        } else {
            this.f8087AlLFFp = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f8017ADYaiT, 2130968607, 0);
        setBackground((!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) ? obtainStyledAttributes.getDrawable(0) : AlLFFp.CQhlFr(context, resourceId));
        this.f8102BTvldC = obtainStyledAttributes.getResourceId(5, 0);
        this.f8103BV3sI0 = obtainStyledAttributes.getResourceId(4, 0);
        this.f8090B25kr6 = obtainStyledAttributes.getLayoutDimension(3, 0);
        this.f8105BniPrB = obtainStyledAttributes.getResourceId(2, 2131492871);
        obtainStyledAttributes.recycle();
    }

    public static int ARc23Z(View view, int i, int i2) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, i - view.getMeasuredWidth());
    }

    public static int ASJ6gh(View view, boolean z, int i, int i2, int i3) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public final void A5SV6n(A4TApA a4TApA) {
        View view = this.f8096BChYOn;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f8105BniPrB, (ViewGroup) this, false);
            this.f8096BChYOn = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f8096BChYOn);
        }
        View findViewById = this.f8096BChYOn.findViewById(2131296337);
        this.f8097BI9f7h = findViewById;
        findViewById.setOnClickListener(new A5SV6n(1, a4TApA));
        AmA8tU A5SV6n2 = a4TApA.A5SV6n();
        AzWtSf azWtSf = this.f8089AzWtSf;
        if (azWtSf != null) {
            azWtSf.AcNBzu();
            AYUAbz aYUAbz = azWtSf.BpkvW3;
            if (aYUAbz != null && aYUAbz.A4TApA()) {
                aYUAbz.f568AZOQYO.dismiss();
            }
        }
        AzWtSf azWtSf2 = new AzWtSf(getContext());
        this.f8089AzWtSf = azWtSf2;
        azWtSf2.f614BIYEnU = true;
        azWtSf2.f615BJ7GGh = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        A5SV6n2.A4TApA(this.f8089AzWtSf, this.f8087AlLFFp);
        AzWtSf azWtSf3 = this.f8089AzWtSf;
        BTvldC bTvldC = azWtSf3.f439B4ZgIw;
        if (bTvldC == null) {
            BTvldC bTvldC2 = (BTvldC) azWtSf3.f435AzWtSf.inflate(azWtSf3.f437B2KMhB, (ViewGroup) this, false);
            azWtSf3.f439B4ZgIw = bTvldC2;
            bTvldC2.A5SV6n(azWtSf3.f434AmA8tU);
            azWtSf3.A4TApA(true);
        }
        BTvldC bTvldC3 = azWtSf3.f439B4ZgIw;
        if (bTvldC != bTvldC3) {
            ((ActionMenuView) bTvldC3).setPresenter(azWtSf3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) bTvldC3;
        this.f8088AmA8tU = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.f8088AmA8tU, layoutParams);
    }

    public final void ADYaiT() {
        if (this.f8099BJ7GGh == null) {
            LayoutInflater.from(getContext()).inflate(2131492866, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f8099BJ7GGh = linearLayout;
            this.f8100BNL6CD = (TextView) linearLayout.findViewById(2131296325);
            this.f8101BPw6Q8 = (TextView) this.f8099BJ7GGh.findViewById(2131296324);
            int i = this.f8102BTvldC;
            if (i != 0) {
                this.f8100BNL6CD.setTextAppearance(getContext(), i);
            }
            int i2 = this.f8103BV3sI0;
            if (i2 != 0) {
                this.f8101BPw6Q8.setTextAppearance(getContext(), i2);
            }
        }
        this.f8100BNL6CD.setText(this.f8094B7CMnp);
        this.f8101BPw6Q8.setText(this.f8095B9tovu);
        boolean isEmpty = TextUtils.isEmpty(this.f8094B7CMnp);
        boolean isEmpty2 = TextUtils.isEmpty(this.f8095B9tovu);
        this.f8101BPw6Q8.setVisibility(!isEmpty2 ? 0 : 8);
        this.f8099BJ7GGh.setVisibility((isEmpty && isEmpty2) ? 8 : 0);
        if (this.f8099BJ7GGh.getParent() == null) {
            addView(this.f8099BJ7GGh);
        }
    }

    public final void AMqCpz() {
        removeAllViews();
        this.f8098BIYEnU = null;
        this.f8088AmA8tU = null;
        this.f8089AzWtSf = null;
        View view = this.f8097BI9f7h;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.View
    /* renamed from: AYUAbz, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i) {
        if (i != getVisibility()) {
            De4eam de4eam = this.f8091B2KMhB;
            if (de4eam != null) {
                de4eam.A4TApA();
            }
            super.setVisibility(i);
        }
    }

    public final De4eam AZOQYO(int i, long j) {
        De4eam de4eam = this.f8091B2KMhB;
        if (de4eam != null) {
            de4eam.A4TApA();
        }
        A2egSU a2egSU = this.f8086AcNBzu;
        if (i != 0) {
            De4eam A2egSU2 = DG07BK.A2egSU(this);
            A2egSU2.A2egSU(0.0f);
            A2egSU2.A5SV6n(j);
            ((ActionBarContextView) a2egSU.f595A5SV6n).f8091B2KMhB = A2egSU2;
            a2egSU.f593A2egSU = i;
            A2egSU2.ADYaiT(a2egSU);
            return A2egSU2;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        De4eam A2egSU3 = DG07BK.A2egSU(this);
        A2egSU3.A2egSU(1.0f);
        A2egSU3.A5SV6n(j);
        ((ActionBarContextView) a2egSU.f595A5SV6n).f8091B2KMhB = A2egSU3;
        a2egSU.f593A2egSU = i;
        A2egSU3.ADYaiT(a2egSU);
        return A2egSU3;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return this.f8091B2KMhB != null ? this.f8086AcNBzu.f593A2egSU : getVisibility();
    }

    public int getContentHeight() {
        return this.f8090B25kr6;
    }

    public CharSequence getSubtitle() {
        return this.f8095B9tovu;
    }

    public CharSequence getTitle() {
        return this.f8094B7CMnp;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.f8014A2egSU, 2130968583, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(13, 0));
        obtainStyledAttributes.recycle();
        AzWtSf azWtSf = this.f8089AzWtSf;
        if (azWtSf != null) {
            Configuration configuration2 = azWtSf.f433AlLFFp.getResources().getConfiguration();
            int i = configuration2.screenWidthDp;
            int i2 = configuration2.screenHeightDp;
            azWtSf.f618BTvldC = (configuration2.smallestScreenWidthDp > 600 || i > 600 || (i > 960 && i2 > 720) || (i > 720 && i2 > 960)) ? 5 : (i >= 500 || (i > 640 && i2 > 480) || (i > 480 && i2 > 640)) ? 4 : i >= 360 ? 3 : 2;
            AmA8tU amA8tU = azWtSf.f434AmA8tU;
            if (amA8tU != null) {
                amA8tU.B25kr6(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AzWtSf azWtSf = this.f8089AzWtSf;
        if (azWtSf != null) {
            azWtSf.AcNBzu();
            AYUAbz aYUAbz = this.f8089AzWtSf.BpkvW3;
            if (aYUAbz == null || !aYUAbz.A4TApA()) {
                return;
            }
            aYUAbz.f568AZOQYO.dismiss();
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f8093B4ZgIw = false;
        }
        if (!this.f8093B4ZgIw) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f8093B4ZgIw = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f8093B4ZgIw = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = HSHyT0.f933A2egSU;
        boolean z3 = getLayoutDirection() == 1;
        int paddingRight = z3 ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.f8096BChYOn;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f8096BChYOn.getLayoutParams();
            int i5 = z3 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = z3 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i7 = z3 ? paddingRight - i5 : paddingRight + i5;
            int ASJ6gh2 = ASJ6gh(this.f8096BChYOn, z3, i7, paddingTop, paddingTop2) + i7;
            paddingRight = z3 ? ASJ6gh2 - i6 : ASJ6gh2 + i6;
        }
        LinearLayout linearLayout = this.f8099BJ7GGh;
        if (linearLayout != null && this.f8098BIYEnU == null && linearLayout.getVisibility() != 8) {
            paddingRight += ASJ6gh(this.f8099BJ7GGh, z3, paddingRight, paddingTop, paddingTop2);
        }
        View view2 = this.f8098BIYEnU;
        if (view2 != null) {
            ASJ6gh(view2, z3, paddingRight, paddingTop, paddingTop2);
        }
        int paddingLeft = z3 ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.f8088AmA8tU;
        if (actionMenuView != null) {
            ASJ6gh(actionMenuView, !z3, paddingLeft, paddingTop, paddingTop2);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i);
        int i3 = this.f8090B25kr6;
        if (i3 <= 0) {
            i3 = View.MeasureSpec.getSize(i2);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i4 = i3 - paddingBottom;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        View view = this.f8096BChYOn;
        if (view != null) {
            int ARc23Z2 = ARc23Z(view, paddingLeft, makeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f8096BChYOn.getLayoutParams();
            paddingLeft = ARc23Z2 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f8088AmA8tU;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = ARc23Z(this.f8088AmA8tU, paddingLeft, makeMeasureSpec);
        }
        LinearLayout linearLayout = this.f8099BJ7GGh;
        if (linearLayout != null && this.f8098BIYEnU == null) {
            if (this.f8104BmvVmW) {
                this.f8099BJ7GGh.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.f8099BJ7GGh.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.f8099BJ7GGh.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = ARc23Z(linearLayout, paddingLeft, makeMeasureSpec);
            }
        }
        View view2 = this.f8098BIYEnU;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i5 = layoutParams.width;
            int i6 = i5 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i5 >= 0) {
                paddingLeft = Math.min(i5, paddingLeft);
            }
            int i7 = layoutParams.height;
            int i8 = i7 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i7 >= 0) {
                i4 = Math.min(i7, i4);
            }
            this.f8098BIYEnU.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(i4, i8));
        }
        if (this.f8090B25kr6 > 0) {
            setMeasuredDimension(size, i3);
            return;
        }
        int childCount = getChildCount();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            int measuredHeight = getChildAt(i10).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i9) {
                i9 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i9);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f8092B3GDIM = false;
        }
        if (!this.f8092B3GDIM) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f8092B3GDIM = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f8092B3GDIM = false;
        return true;
    }

    public void setContentHeight(int i) {
        this.f8090B25kr6 = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f8098BIYEnU;
        if (view2 != null) {
            removeView(view2);
        }
        this.f8098BIYEnU = view;
        if (view != null && (linearLayout = this.f8099BJ7GGh) != null) {
            removeView(linearLayout);
            this.f8099BJ7GGh = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f8095B9tovu = charSequence;
        ADYaiT();
    }

    public void setTitle(CharSequence charSequence) {
        this.f8094B7CMnp = charSequence;
        ADYaiT();
        DG07BK.B7CMnp(this, charSequence);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f8104BmvVmW) {
            requestLayout();
        }
        this.f8104BmvVmW = z;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
