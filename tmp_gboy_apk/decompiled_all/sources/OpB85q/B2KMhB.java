package OpB85q;

import AZkASS.BTvldC;
import AaHO0E.GYpKKt;
import Oay4Bh.C4FrIb;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.R$styleable;
import com.google.android.material.navigationrail.NavigationRailView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class B2KMhB extends FrameLayout {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ASJ6gh f6790AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final AZkASS f6791AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final AcNBzu f6792AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public AZOQYO.AZkASS f6793AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public AzWtSf f6794B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public AmA8tU f6795B2KMhB;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [boolean, int] */
    public B2KMhB(Context context, AttributeSet attributeSet, int i, int i2) {
        super(PXXBzr.A2egSU.A2egSU(context, attributeSet, i, i2), attributeSet, i);
        ?? r8;
        AcNBzu acNBzu = new AcNBzu();
        this.f6792AmA8tU = acNBzu;
        Context context2 = getContext();
        GYpKKt AzWtSf2 = C4FrIb.AzWtSf(context2, attributeSet, R$styleable.f11247CQhlFr, i, i2, 17, 15);
        boolean z = this instanceof NavigationRailView;
        ASJ6gh aSJ6gh = new ASJ6gh(context2, getClass(), getMaxItemCount(), z);
        this.f6790AcNBzu = aSJ6gh;
        AZkASS A2egSU2 = A2egSU(context2);
        this.f6791AlLFFp = A2egSU2;
        A2egSU2.setMinimumHeight(getSuggestedMinimumHeight());
        A2egSU2.setCollapsedMaxItemCount(getCollapsedMaxItemCount());
        acNBzu.f6781AcNBzu = A2egSU2;
        acNBzu.f6783AmA8tU = 1;
        A2egSU2.setPresenter(acNBzu);
        aSJ6gh.A4TApA(acNBzu, aSJ6gh.f493AcNBzu);
        acNBzu.AZkASS(getContext(), aSJ6gh);
        TypedArray typedArray = AzWtSf2.f884A4TApA;
        if (typedArray.hasValue(11)) {
            A2egSU2.setIconTintList(AzWtSf2.A2egSU(11));
        } else {
            A2egSU2.setIconTintList(A2egSU2.A4TApA());
        }
        setItemIconSize(typedArray.getDimensionPixelSize(10, getResources().getDimensionPixelSize(2131166461)));
        if (typedArray.hasValue(17)) {
            setItemTextAppearanceInactive(typedArray.getResourceId(17, 0));
        }
        if (typedArray.hasValue(15)) {
            setItemTextAppearanceActive(typedArray.getResourceId(15, 0));
        }
        if (typedArray.hasValue(4)) {
            setHorizontalItemTextAppearanceInactive(typedArray.getResourceId(4, 0));
        }
        if (typedArray.hasValue(3)) {
            setHorizontalItemTextAppearanceActive(typedArray.getResourceId(3, 0));
        }
        setItemTextAppearanceActiveBoldEnabled(typedArray.getBoolean(16, true));
        if (typedArray.hasValue(18)) {
            setItemTextColor(AzWtSf2.A2egSU(18));
        }
        Drawable background = getBackground();
        ColorStateList C2rE4F2 = JrXYwF.A4TApA.C2rE4F(background);
        if (background == null || C2rE4F2 != null) {
            PCV8se.AaHO0E aaHO0E = new PCV8se.AaHO0E(PCV8se.B2KMhB.A5SV6n(context2, attributeSet, i, i2).A2egSU());
            if (C2rE4F2 != null) {
                aaHO0E.B3GDIM(C2rE4F2);
            }
            aaHO0E.AmA8tU(context2);
            setBackground(aaHO0E);
        }
        if (typedArray.hasValue(13)) {
            setItemPaddingTop(typedArray.getDimensionPixelSize(13, 0));
        }
        if (typedArray.hasValue(12)) {
            setItemPaddingBottom(typedArray.getDimensionPixelSize(12, 0));
        }
        if (typedArray.hasValue(0)) {
            setActiveIndicatorLabelPadding(typedArray.getDimensionPixelSize(0, 0));
        }
        if (typedArray.hasValue(5)) {
            setIconLabelHorizontalSpacing(typedArray.getDimensionPixelSize(5, 0));
        }
        if (typedArray.hasValue(2)) {
            setElevation(typedArray.getDimensionPixelSize(2, 0));
        }
        getBackground().mutate().setTintList(com.bumptech.glide.AMqCpz.BNL6CD(context2, AzWtSf2, 1));
        setLabelVisibilityMode(typedArray.getInteger(21, -1));
        setItemIconGravity(typedArray.getInteger(9, 0));
        setItemGravity(typedArray.getInteger(8, 49));
        int resourceId = typedArray.getResourceId(7, 0);
        if (resourceId != 0) {
            A2egSU2.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(com.bumptech.glide.AMqCpz.BNL6CD(context2, AzWtSf2, 14));
        }
        setMeasureBottomPaddingFromLabelBaseline(typedArray.getBoolean(22, true));
        setLabelFontScalingEnabled(typedArray.getBoolean(19, false));
        setLabelMaxLines(typedArray.getInteger(20, 1));
        int resourceId2 = typedArray.getResourceId(6, 0);
        if (resourceId2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(resourceId2, R$styleable.f11246COJEAR);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            setItemActiveIndicatorWidth(dimensionPixelSize);
            setItemActiveIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(0, 0));
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(10, 0);
            setItemActiveIndicatorMarginHorizontal(dimensionPixelOffset);
            String string = obtainStyledAttributes.getString(9);
            int i3 = -2;
            if (string != null) {
                if (String.valueOf(-1).equals(string)) {
                    i3 = -1;
                } else if (!String.valueOf(-2).equals(string)) {
                    i3 = obtainStyledAttributes.getDimensionPixelSize(9, -2);
                }
            }
            setItemActiveIndicatorExpandedWidth(i3);
            setItemActiveIndicatorExpandedHeight(obtainStyledAttributes.getDimensionPixelSize(7, dimensionPixelSize));
            setItemActiveIndicatorExpandedMarginHorizontal(obtainStyledAttributes.getDimensionPixelOffset(8, dimensionPixelOffset));
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131166096);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(5, dimensionPixelSize2);
            int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(4, dimensionPixelSize2);
            int i4 = getLayoutDirection() == 1 ? dimensionPixelOffset3 : dimensionPixelOffset2;
            int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(6, 0);
            dimensionPixelOffset2 = getLayoutDirection() != 1 ? dimensionPixelOffset3 : dimensionPixelOffset2;
            int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
            Rect rect = A2egSU2.f6778DUi7mC;
            rect.left = i4;
            rect.top = dimensionPixelOffset4;
            rect.right = dimensionPixelOffset2;
            rect.bottom = dimensionPixelOffset5;
            AZOQYO[] azoqyoArr = A2egSU2.f6738B3GDIM;
            if (azoqyoArr != null) {
                for (AZOQYO azoqyo : azoqyoArr) {
                    if (azoqyo instanceof ARc23Z) {
                        ((ARc23Z) azoqyo).setActiveIndicatorExpandedPadding(rect);
                    }
                }
            }
            setItemActiveIndicatorColor(com.bumptech.glide.AMqCpz.BPw6Q8(context2, obtainStyledAttributes, 2));
            r8 = 0;
            setItemActiveIndicatorShapeAppearance(PCV8se.B2KMhB.A2egSU(context2, obtainStyledAttributes.getResourceId(11, 0), 0).A2egSU());
            obtainStyledAttributes.recycle();
        } else {
            r8 = 0;
        }
        if (typedArray.hasValue(23)) {
            int resourceId3 = typedArray.getResourceId(23, r8);
            AcNBzu acNBzu2 = this.f6792AmA8tU;
            acNBzu2.f6782AlLFFp = true;
            getMenuInflater().inflate(resourceId3, this.f6790AcNBzu);
            acNBzu2.f6782AlLFFp = r8;
            acNBzu2.A4TApA(true);
        }
        AzWtSf2.ASJ6gh();
        if (!z) {
            addView(this.f6791AlLFFp);
        }
        this.f6790AcNBzu.f497B25kr6 = new IQ76hF.AmA8tU(24, this);
    }

    private MenuInflater getMenuInflater() {
        if (this.f6793AzWtSf == null) {
            this.f6793AzWtSf = new AZOQYO.AZkASS(getContext());
        }
        return this.f6793AzWtSf;
    }

    private void setMeasureBottomPaddingFromLabelBaseline(boolean z) {
        this.f6791AlLFFp.setMeasurePaddingFromLabelBaseline(z);
    }

    public abstract AZkASS A2egSU(Context context);

    public int getActiveIndicatorLabelPadding() {
        return this.f6791AlLFFp.getActiveIndicatorLabelPadding();
    }

    public int getCollapsedMaxItemCount() {
        return getMaxItemCount();
    }

    public int getHorizontalItemTextAppearanceActive() {
        return this.f6791AlLFFp.getHorizontalItemTextAppearanceActive();
    }

    public int getHorizontalItemTextAppearanceInactive() {
        return this.f6791AlLFFp.getHorizontalItemTextAppearanceInactive();
    }

    public int getIconLabelHorizontalSpacing() {
        return this.f6791AlLFFp.getIconLabelHorizontalSpacing();
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f6791AlLFFp.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorExpandedHeight() {
        return this.f6791AlLFFp.getItemActiveIndicatorExpandedHeight();
    }

    public int getItemActiveIndicatorExpandedMarginHorizontal() {
        return this.f6791AlLFFp.getItemActiveIndicatorExpandedMarginHorizontal();
    }

    public int getItemActiveIndicatorExpandedWidth() {
        return this.f6791AlLFFp.getItemActiveIndicatorExpandedWidth();
    }

    public int getItemActiveIndicatorHeight() {
        return this.f6791AlLFFp.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f6791AlLFFp.getItemActiveIndicatorMarginHorizontal();
    }

    public PCV8se.B2KMhB getItemActiveIndicatorShapeAppearance() {
        return this.f6791AlLFFp.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.f6791AlLFFp.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.f6791AlLFFp.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f6791AlLFFp.getItemBackgroundRes();
    }

    public int getItemGravity() {
        return this.f6791AlLFFp.getItemGravity();
    }

    public int getItemIconGravity() {
        return this.f6791AlLFFp.getItemIconGravity();
    }

    public int getItemIconSize() {
        return this.f6791AlLFFp.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f6791AlLFFp.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.f6791AlLFFp.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.f6791AlLFFp.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.f6791AlLFFp.getItemRippleColor();
    }

    public int getItemTextAppearanceActive() {
        return this.f6791AlLFFp.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f6791AlLFFp.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f6791AlLFFp.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f6791AlLFFp.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.f6790AcNBzu;
    }

    public BTvldC getMenuView() {
        return this.f6791AlLFFp;
    }

    public ViewGroup getMenuViewGroup() {
        return this.f6791AlLFFp;
    }

    public AcNBzu getPresenter() {
        return this.f6792AmA8tU;
    }

    public boolean getScaleLabelTextWithFont() {
        return this.f6791AlLFFp.getScaleLabelTextWithFont();
    }

    public int getSelectedItemId() {
        return this.f6791AlLFFp.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        NOd7IU.AlLFFp.D07BeM(this);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof B25kr6)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        B25kr6 b25kr6 = (B25kr6) parcelable;
        super.onRestoreInstanceState(b25kr6.getSuperState());
        this.f6790AcNBzu.B7CMnp(b25kr6.f6789AcNBzu);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        B25kr6 b25kr6 = new B25kr6(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        b25kr6.f6789AcNBzu = bundle;
        this.f6790AcNBzu.BChYOn(bundle);
        return b25kr6;
    }

    public void setActiveIndicatorLabelPadding(int i) {
        this.f6791AlLFFp.setActiveIndicatorLabelPadding(i);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        NOd7IU.AlLFFp.CtFAbx(this, f);
    }

    public void setHorizontalItemTextAppearanceActive(int i) {
        this.f6791AlLFFp.setHorizontalItemTextAppearanceActive(i);
    }

    public void setHorizontalItemTextAppearanceInactive(int i) {
        this.f6791AlLFFp.setHorizontalItemTextAppearanceInactive(i);
    }

    public void setIconLabelHorizontalSpacing(int i) {
        this.f6791AlLFFp.setIconLabelHorizontalSpacing(i);
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f6791AlLFFp.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.f6791AlLFFp.setItemActiveIndicatorEnabled(z);
    }

    public void setItemActiveIndicatorExpandedHeight(int i) {
        this.f6791AlLFFp.setItemActiveIndicatorExpandedHeight(i);
    }

    public void setItemActiveIndicatorExpandedMarginHorizontal(int i) {
        this.f6791AlLFFp.setItemActiveIndicatorExpandedMarginHorizontal(i);
    }

    public void setItemActiveIndicatorExpandedWidth(int i) {
        this.f6791AlLFFp.setItemActiveIndicatorExpandedWidth(i);
    }

    public void setItemActiveIndicatorHeight(int i) {
        this.f6791AlLFFp.setItemActiveIndicatorHeight(i);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i) {
        this.f6791AlLFFp.setItemActiveIndicatorMarginHorizontal(i);
    }

    public void setItemActiveIndicatorShapeAppearance(PCV8se.B2KMhB b2KMhB) {
        this.f6791AlLFFp.setItemActiveIndicatorShapeAppearance(b2KMhB);
    }

    public void setItemActiveIndicatorWidth(int i) {
        this.f6791AlLFFp.setItemActiveIndicatorWidth(i);
    }

    public void setItemBackground(Drawable drawable) {
        this.f6791AlLFFp.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i) {
        this.f6791AlLFFp.setItemBackgroundRes(i);
    }

    public void setItemGravity(int i) {
        AZkASS aZkASS = this.f6791AlLFFp;
        if (aZkASS.getItemGravity() != i) {
            aZkASS.setItemGravity(i);
            this.f6792AmA8tU.A4TApA(false);
        }
    }

    public void setItemIconGravity(int i) {
        AZkASS aZkASS = this.f6791AlLFFp;
        if (aZkASS.getItemIconGravity() != i) {
            aZkASS.setItemIconGravity(i);
            this.f6792AmA8tU.A4TApA(false);
        }
    }

    public void setItemIconSize(int i) {
        this.f6791AlLFFp.setItemIconSize(i);
    }

    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f6791AlLFFp.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(int i) {
        this.f6791AlLFFp.setItemPaddingBottom(i);
    }

    public void setItemPaddingTop(int i) {
        this.f6791AlLFFp.setItemPaddingTop(i);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f6791AlLFFp.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(int i) {
        this.f6791AlLFFp.setItemTextAppearanceActive(i);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.f6791AlLFFp.setItemTextAppearanceActiveBoldEnabled(z);
    }

    public void setItemTextAppearanceInactive(int i) {
        this.f6791AlLFFp.setItemTextAppearanceInactive(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f6791AlLFFp.setItemTextColor(colorStateList);
    }

    public void setLabelFontScalingEnabled(boolean z) {
        this.f6791AlLFFp.setLabelFontScalingEnabled(z);
    }

    public void setLabelMaxLines(int i) {
        this.f6791AlLFFp.setLabelMaxLines(i);
    }

    public void setLabelVisibilityMode(int i) {
        AZkASS aZkASS = this.f6791AlLFFp;
        if (aZkASS.getLabelVisibilityMode() != i) {
            aZkASS.setLabelVisibilityMode(i);
            this.f6792AmA8tU.A4TApA(false);
        }
    }

    public void setOnItemReselectedListener(AmA8tU amA8tU) {
        this.f6795B2KMhB = amA8tU;
    }

    public void setOnItemSelectedListener(AzWtSf azWtSf) {
        this.f6794B25kr6 = azWtSf;
    }

    public void setSelectedItemId(int i) {
        ASJ6gh aSJ6gh = this.f6790AcNBzu;
        MenuItem findItem = aSJ6gh.findItem(i);
        if (findItem != null) {
            boolean B2KMhB2 = aSJ6gh.B2KMhB(findItem, this.f6792AmA8tU, 0);
            if (findItem.isCheckable()) {
                if (!B2KMhB2 || findItem.isChecked()) {
                    this.f6791AlLFFp.setCheckedItem(findItem);
                }
            }
        }
    }
}
