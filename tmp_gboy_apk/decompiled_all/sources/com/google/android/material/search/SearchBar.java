package com.google.android.material.search;

import NOd7IU.AlLFFp;
import OLy1FW.AYUAbz;
import OLy1FW.AzWtSf;
import Oay4Bh.C4FrIb;
import P8ccfD.A4TApA;
import P8ccfD.A5SV6n;
import PCV8se.AaHO0E;
import PCV8se.B2KMhB;
import PXXBzr.A2egSU;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bumptech.glide.AMqCpz;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import java.util.LinkedHashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SearchBar extends Toolbar {

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public final TextView f11737DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public final TextView f11738DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public final FrameLayout f11739DV2E8K;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public final int f11740DXnQ0V;
    public boolean DXuj49;

    /* renamed from: DaOi9o, reason: collision with root package name */
    public final ColorStateList f11741DaOi9o;

    /* renamed from: DcUJf1, reason: collision with root package name */
    public final boolean f11742DcUJf1;

    /* renamed from: DdagTj, reason: collision with root package name */
    public final boolean f11743DdagTj;
    public final AzWtSf Ddcejp;

    /* renamed from: De4eam, reason: collision with root package name */
    public final Drawable f11744De4eam;

    /* renamed from: DjONCG, reason: collision with root package name */
    public final boolean f11745DjONCG;

    /* renamed from: Dphsd2, reason: collision with root package name */
    public final boolean f11746Dphsd2;

    /* renamed from: DuwtYk, reason: collision with root package name */
    public View f11747DuwtYk;

    /* renamed from: DvK7DB, reason: collision with root package name */
    public final Integer f11748DvK7DB;

    /* renamed from: DyaChj, reason: collision with root package name */
    public Drawable f11749DyaChj;

    /* renamed from: ECyGFg, reason: collision with root package name */
    public int f11750ECyGFg;

    /* renamed from: EGM26s, reason: collision with root package name */
    public boolean f11751EGM26s;

    /* renamed from: EH1KK8, reason: collision with root package name */
    public final AaHO0E f11752EH1KK8;

    /* renamed from: EPdU4G, reason: collision with root package name */
    public boolean f11753EPdU4G;

    /* renamed from: EQurEW, reason: collision with root package name */
    public int f11754EQurEW;

    /* renamed from: EUIRHA, reason: collision with root package name */
    public ActionMenuView f11755EUIRHA;

    /* renamed from: EY4UKY, reason: collision with root package name */
    public ImageButton f11756EY4UKY;
    public final A4TApA EdQ5bb;

    public SearchBar(Context context, AttributeSet attributeSet) {
        super(A2egSU.A2egSU(context, attributeSet, 2130969567, 2131952770), attributeSet, 2130969567);
        this.f11750ECyGFg = -1;
        this.EdQ5bb = new A4TApA(this);
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "title") != null) {
                throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", MediaFormat.KEY_SUBTITLE) != null) {
                throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
            }
        }
        Drawable CQhlFr2 = AlLFFp.CQhlFr(context2, getDefaultNavigationIconResource());
        this.f11744De4eam = CQhlFr2;
        AzWtSf azWtSf = new AzWtSf(4, (byte) 0);
        new LinkedHashSet();
        new LinkedHashSet();
        new LinkedHashSet();
        this.Ddcejp = azWtSf;
        TypedArray AmA8tU2 = C4FrIb.AmA8tU(context2, attributeSet, R$styleable.f11253CkXcdM, 2130969567, 2131952770, new int[0]);
        B2KMhB A2egSU2 = B2KMhB.A5SV6n(context2, attributeSet, 2130969567, 2131952770).A2egSU();
        int color = AmA8tU2.getColor(4, 0);
        this.f11740DXnQ0V = color;
        this.f11741DaOi9o = AMqCpz.BPw6Q8(context2, AmA8tU2, 11);
        float dimension = AmA8tU2.getDimension(7, 0.0f);
        this.f11743DdagTj = AmA8tU2.getBoolean(5, true);
        this.f11751EGM26s = AmA8tU2.getBoolean(6, true);
        boolean z = AmA8tU2.getBoolean(9, false);
        this.f11746Dphsd2 = AmA8tU2.getBoolean(8, false);
        this.f11745DjONCG = AmA8tU2.getBoolean(16, true);
        if (AmA8tU2.hasValue(12)) {
            this.f11748DvK7DB = Integer.valueOf(AmA8tU2.getColor(12, -1));
        }
        int resourceId = AmA8tU2.getResourceId(0, -1);
        String string = AmA8tU2.getString(2);
        String string2 = AmA8tU2.getString(3);
        float dimension2 = AmA8tU2.getDimension(14, -1.0f);
        int color2 = AmA8tU2.getColor(13, 0);
        this.f11753EPdU4G = AmA8tU2.getBoolean(15, false);
        this.DXuj49 = AmA8tU2.getBoolean(10, false);
        this.f11754EQurEW = AmA8tU2.getDimensionPixelSize(1, -1);
        AmA8tU2.recycle();
        if (!z) {
            setNavigationIcon(getNavigationIcon() != null ? getNavigationIcon() : CQhlFr2);
            setNavigationIconDecorative(true);
        }
        setClickable(true);
        setFocusable(true);
        LayoutInflater.from(context2).inflate(2131493259, this);
        this.f11742DcUJf1 = true;
        TextView textView = (TextView) findViewById(2131297725);
        this.f11737DRlcZ9 = textView;
        TextView textView2 = (TextView) findViewById(2131297724);
        this.f11738DUi7mC = textView2;
        this.f11739DV2E8K = (FrameLayout) findViewById(2131297726);
        setElevation(dimension);
        if (resourceId != -1) {
            JrXYwF.A4TApA.DRlcZ9(textView, resourceId);
            JrXYwF.A4TApA.DRlcZ9(textView2, resourceId);
        }
        setText(string);
        setHint(string2);
        setTextCentered(this.f11753EPdU4G);
        AaHO0E aaHO0E = new AaHO0E(A2egSU2);
        this.f11752EH1KK8 = aaHO0E;
        aaHO0E.AmA8tU(getContext());
        this.f11752EH1KK8.B2KMhB(dimension);
        if (dimension2 >= 0.0f) {
            AaHO0E aaHO0E2 = this.f11752EH1KK8;
            aaHO0E2.BJ7GGh(dimension2);
            aaHO0E2.BIYEnU(ColorStateList.valueOf(color2));
        }
        int ASJ6gh2 = AYUAbz.ASJ6gh(2130968853, this);
        this.f11752EH1KK8.B3GDIM(ColorStateList.valueOf(color));
        ColorStateList valueOf = ColorStateList.valueOf(ASJ6gh2);
        AaHO0E aaHO0E3 = this.f11752EH1KK8;
        setBackground(new RippleDrawable(valueOf, aaHO0E3, aaHO0E3));
    }

    private AppBarLayout getAppBarLayoutParentIfExists() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof AppBarLayout) {
                return (AppBarLayout) parent;
            }
        }
        return null;
    }

    private void setNavigationIconDecorative(boolean z) {
        ImageButton AaHO0E2 = C4FrIb.AaHO0E(this);
        if (AaHO0E2 == null) {
            return;
        }
        AaHO0E2.setClickable(!z);
        AaHO0E2.setFocusable(!z);
        Drawable background = AaHO0E2.getBackground();
        if (background != null) {
            this.f11749DyaChj = background;
        }
        AaHO0E2.setBackgroundDrawable(z ? null : this.f11749DyaChj);
        BIYEnU();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void AlLFFp(int i) {
        super.AlLFFp(i);
        this.f11750ECyGFg = i;
    }

    public final void BIYEnU() {
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        boolean z = getLayoutDirection() == 1;
        ImageButton AaHO0E2 = C4FrIb.AaHO0E(this);
        int width = (AaHO0E2 == null || !AaHO0E2.isClickable()) ? 0 : z ? getWidth() - AaHO0E2.getLeft() : AaHO0E2.getRight();
        ActionMenuView AZOQYO2 = C4FrIb.AZOQYO(this);
        int right = AZOQYO2 != null ? z ? AZOQYO2.getRight() : getWidth() - AZOQYO2.getLeft() : 0;
        float f = -(z ? right : width);
        if (!z) {
            width = right;
        }
        setHandwritingBoundsOffsets(f, 0.0f, -width, 0.0f);
    }

    public final void BJ7GGh() {
        if (getLayoutParams() instanceof com.google.android.material.appbar.AMqCpz) {
            com.google.android.material.appbar.AMqCpz aMqCpz = (com.google.android.material.appbar.AMqCpz) getLayoutParams();
            if (this.f11751EGM26s) {
                if (aMqCpz.f11277A2egSU == 0) {
                    aMqCpz.f11277A2egSU = 53;
                }
            } else if (aMqCpz.f11277A2egSU == 53) {
                aMqCpz.f11277A2egSU = 0;
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.f11742DcUJf1 && this.f11747DuwtYk == null && !(view instanceof ActionMenuView)) {
            this.f11747DuwtYk = view;
            view.setAlpha(0.0f);
        }
        super.addView(view, i, layoutParams);
    }

    public View getCenterView() {
        return this.f11747DuwtYk;
    }

    public float getCompatElevation() {
        AaHO0E aaHO0E = this.f11752EH1KK8;
        return aaHO0E != null ? aaHO0E.f7042AlLFFp.f7033AmA8tU : getElevation();
    }

    public float getCornerSize() {
        return this.f11752EH1KK8.AcNBzu();
    }

    public int getDefaultMarginVerticalResource() {
        return 2131166134;
    }

    public int getDefaultNavigationIconResource() {
        return 2131231055;
    }

    public CharSequence getHint() {
        return this.f11737DRlcZ9.getHint();
    }

    public int getMaxWidth() {
        return this.f11754EQurEW;
    }

    public int getMenuResId() {
        return this.f11750ECyGFg;
    }

    public TextView getPlaceholderTextView() {
        return this.f11738DUi7mC;
    }

    public int getStrokeColor() {
        return this.f11752EH1KK8.f7042AlLFFp.AMqCpz.getDefaultColor();
    }

    public float getStrokeWidth() {
        return this.f11752EH1KK8.f7042AlLFFp.f7030AaHO0E;
    }

    public CharSequence getText() {
        return this.f11737DRlcZ9.getText();
    }

    public boolean getTextCentered() {
        return this.f11753EPdU4G;
    }

    public TextView getTextView() {
        return this.f11737DRlcZ9;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        AppBarLayout appBarLayoutParentIfExists;
        super.onAttachedToWindow();
        AlLFFp.CtxOCS(this, this.f11752EH1KK8);
        if (this.f11743DdagTj && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(2131166133);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            int i = marginLayoutParams.leftMargin;
            if (i == 0) {
                i = dimensionPixelSize;
            }
            marginLayoutParams.leftMargin = i;
            int i2 = marginLayoutParams.topMargin;
            if (i2 == 0) {
                i2 = dimensionPixelSize2;
            }
            marginLayoutParams.topMargin = i2;
            int i3 = marginLayoutParams.rightMargin;
            if (i3 != 0) {
                dimensionPixelSize = i3;
            }
            marginLayoutParams.rightMargin = dimensionPixelSize;
            int i4 = marginLayoutParams.bottomMargin;
            if (i4 != 0) {
                dimensionPixelSize2 = i4;
            }
            marginLayoutParams.bottomMargin = dimensionPixelSize2;
        }
        BJ7GGh();
        if (!this.DXuj49 || (appBarLayoutParentIfExists = getAppBarLayoutParentIfExists()) == null || this.f11741DaOi9o == null) {
            return;
        }
        appBarLayoutParentIfExists.f11298BV3sI0.add(this.EdQ5bb);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AppBarLayout appBarLayoutParentIfExists = getAppBarLayoutParentIfExists();
        if (appBarLayoutParentIfExists != null) {
            appBarLayoutParentIfExists.f11298BV3sI0.remove(this.EdQ5bb);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        accessibilityNodeInfo.setEditable(isEnabled());
        CharSequence text = getText();
        boolean isEmpty = TextUtils.isEmpty(text);
        if (Build.VERSION.SDK_INT >= 26) {
            accessibilityNodeInfo.setHintText(getHint());
            accessibilityNodeInfo.setShowingHintText(isEmpty);
        }
        if (isEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f11747DuwtYk;
        if (view != null && view != null) {
            int measuredWidth = view.getMeasuredWidth();
            int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
            int i5 = measuredWidth + measuredWidth2;
            int measuredHeight = view.getMeasuredHeight();
            int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
            int i6 = measuredHeight + measuredHeight2;
            if (getLayoutDirection() == 1) {
                view.layout(getMeasuredWidth() - i5, measuredHeight2, getMeasuredWidth() - measuredWidth2, i6);
            } else {
                view.layout(measuredWidth2, measuredHeight2, i5, i6);
            }
        }
        BIYEnU();
        TextView textView = this.f11737DRlcZ9;
        if (textView == null || !this.f11753EPdU4G) {
            return;
        }
        int measuredWidth3 = getMeasuredWidth() / 2;
        FrameLayout frameLayout = this.f11739DV2E8K;
        int measuredWidth4 = measuredWidth3 - (frameLayout.getMeasuredWidth() / 2);
        int measuredWidth5 = frameLayout.getMeasuredWidth() + measuredWidth4;
        int measuredHeight3 = (getMeasuredHeight() / 2) - (frameLayout.getMeasuredHeight() / 2);
        int measuredHeight4 = frameLayout.getMeasuredHeight() + measuredHeight3;
        boolean z2 = getLayoutDirection() == 1;
        if (this.f11755EUIRHA == null) {
            this.f11755EUIRHA = C4FrIb.AZOQYO(this);
        }
        View view2 = this.f11755EUIRHA;
        if (this.f11756EY4UKY == null) {
            this.f11756EY4UKY = C4FrIb.AaHO0E(this);
        }
        View view3 = this.f11756EY4UKY;
        int measuredWidth6 = (frameLayout.getMeasuredWidth() / 2) - (textView.getMeasuredWidth() / 2);
        int measuredWidth7 = textView.getMeasuredWidth() + measuredWidth6;
        int i7 = measuredWidth6 + measuredWidth4;
        int i8 = measuredWidth7 + measuredWidth4;
        View view4 = z2 ? view2 : view3;
        if (z2) {
            view2 = view3;
        }
        int max = view4 != null ? Math.max(view4.getRight() - i7, 0) : 0;
        int i9 = i7 + max;
        int i10 = i8 + max;
        int max2 = view2 != null ? Math.max(i10 - view2.getLeft(), 0) : 0;
        int i11 = i9 - max2;
        int i12 = i10 - max2;
        int max3 = ((max - max2) + Math.max(Math.max(getPaddingLeft() - i11, getContentInsetLeft() - i11), 0)) - Math.max(Math.max(i12 - (getMeasuredWidth() - getPaddingRight()), i12 - (getMeasuredWidth() - getContentInsetRight())), 0);
        frameLayout.layout(measuredWidth4 + max3, measuredHeight3, measuredWidth5 + max3, measuredHeight4);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3 = this.f11754EQurEW;
        if (i3 >= 0 && i3 < View.MeasureSpec.getSize(i)) {
            i = View.MeasureSpec.makeMeasureSpec(this.f11754EQurEW, View.MeasureSpec.getMode(i));
        }
        super.onMeasure(i, i2);
        View view = this.f11747DuwtYk;
        if (view != null) {
            view.measure(i, i2);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof A5SV6n)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        A5SV6n a5SV6n = (A5SV6n) parcelable;
        super.onRestoreInstanceState(a5SV6n.getSuperState());
        setText(a5SV6n.f6962AcNBzu);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final Parcelable onSaveInstanceState() {
        A5SV6n a5SV6n = new A5SV6n(super.onSaveInstanceState());
        CharSequence text = getText();
        a5SV6n.f6962AcNBzu = text == null ? null : text.toString();
        return a5SV6n;
    }

    public void setCenterView(View view) {
        View view2 = this.f11747DuwtYk;
        if (view2 != null) {
            removeView(view2);
            this.f11747DuwtYk = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z) {
        this.f11751EGM26s = z;
        BJ7GGh();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        AaHO0E aaHO0E = this.f11752EH1KK8;
        if (aaHO0E != null) {
            aaHO0E.B2KMhB(f);
        }
    }

    public void setHint(CharSequence charSequence) {
        this.f11737DRlcZ9.setHint(charSequence);
    }

    public void setLiftOnScroll(boolean z) {
        this.DXuj49 = z;
        A4TApA a4TApA = this.EdQ5bb;
        if (!z) {
            AppBarLayout appBarLayoutParentIfExists = getAppBarLayoutParentIfExists();
            if (appBarLayoutParentIfExists != null) {
                appBarLayoutParentIfExists.f11298BV3sI0.remove(a4TApA);
                return;
            }
            return;
        }
        AppBarLayout appBarLayoutParentIfExists2 = getAppBarLayoutParentIfExists();
        if (appBarLayoutParentIfExists2 == null || this.f11741DaOi9o == null) {
            return;
        }
        appBarLayoutParentIfExists2.f11298BV3sI0.add(a4TApA);
    }

    public void setMaxWidth(int i) {
        if (this.f11754EQurEW != i) {
            this.f11754EQurEW = i;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        int ASJ6gh2;
        if (this.f11745DjONCG && drawable != null) {
            Integer num = this.f11748DvK7DB;
            if (num != null) {
                ASJ6gh2 = num.intValue();
            } else {
                ASJ6gh2 = AYUAbz.ASJ6gh(drawable == this.f11744De4eam ? 2130968874 : 2130968872, this);
            }
            drawable = com.bumptech.glide.A5SV6n.DvK7DB(drawable.mutate());
            drawable.setTint(ASJ6gh2);
        }
        super.setNavigationIcon(drawable);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        if (this.f11746Dphsd2) {
            return;
        }
        super.setNavigationOnClickListener(onClickListener);
        setNavigationIconDecorative(onClickListener == null);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z) {
        this.Ddcejp.getClass();
    }

    public void setPlaceholderText(String str) {
        this.f11738DUi7mC.setText(str);
    }

    public void setStrokeColor(int i) {
        if (getStrokeColor() != i) {
            this.f11752EH1KK8.BIYEnU(ColorStateList.valueOf(i));
        }
    }

    public void setStrokeWidth(float f) {
        if (getStrokeWidth() != f) {
            this.f11752EH1KK8.BJ7GGh(f);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    public void setText(CharSequence charSequence) {
        this.f11737DRlcZ9.setText(charSequence);
        this.f11738DUi7mC.setText(charSequence);
    }

    public void setTextCentered(boolean z) {
        this.f11753EPdU4G = z;
        TextView textView = this.f11737DRlcZ9;
        if (textView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
        if (z) {
            layoutParams.gravity = 1;
            textView.setGravity(1);
        } else {
            layoutParams.gravity = 0;
            textView.setGravity(0);
        }
        textView.setLayoutParams(layoutParams);
        this.f11738DUi7mC.setLayoutParams(layoutParams);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

        /* renamed from: B3GDIM, reason: collision with root package name */
        public boolean f11757B3GDIM;

        public ScrollingViewBehavior() {
            this.f11757B3GDIM = false;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
        public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            super.onDependentViewChanged(coordinatorLayout, view, view2);
            if (!this.f11757B3GDIM && (view2 instanceof AppBarLayout)) {
                this.f11757B3GDIM = true;
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                appBarLayout.setBackgroundColor(0);
                if (Build.VERSION.SDK_INT == 21) {
                    appBarLayout.setOutlineProvider(null);
                    return false;
                }
                appBarLayout.setTargetElevation(0.0f);
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f11757B3GDIM = false;
        }
    }

    public void setHint(int i) {
        this.f11737DRlcZ9.setHint(i);
    }

    public void setText(int i) {
        this.f11737DRlcZ9.setText(i);
        this.f11738DUi7mC.setText(i);
    }
}
