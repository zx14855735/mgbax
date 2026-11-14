package com.google.android.material.appbar;

import B4ZgIw.ARc23Z;
import NOd7IU.AlLFFp;
import Oay4Bh.C4FrIb;
import PCV8se.AaHO0E;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R$styleable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MaterialToolbar extends Toolbar {

    /* renamed from: DaOi9o, reason: collision with root package name */
    public static final ImageView.ScaleType[] f11313DaOi9o = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public Integer f11314DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public boolean f11315DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public boolean f11316DV2E8K;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public ImageView.ScaleType f11317DXnQ0V;
    public Boolean DXuj49;

    static {
        TrdWfdJ();
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(PXXBzr.A2egSU.A2egSU(context, attributeSet, 2130970128, 2131952930), attributeSet, 2130970128);
        Context context2 = getContext();
        TypedArray AmA8tU2 = C4FrIb.AmA8tU(context2, attributeSet, R$styleable.f11245CNPG0E, 2130970128, 2131952930, new int[0]);
        if (AmA8tU2.hasValue(2)) {
            setNavigationIconTint(AmA8tU2.getColor(2, -1));
        }
        this.f11315DUi7mC = AmA8tU2.getBoolean(4, false);
        this.f11316DV2E8K = AmA8tU2.getBoolean(3, false);
        int i = AmA8tU2.getInt(1, -1);
        if (i >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f11313DaOi9o;
            if (i < scaleTypeArr.length) {
                this.f11317DXnQ0V = scaleTypeArr[i];
            }
        }
        if (AmA8tU2.hasValue(0)) {
            this.DXuj49 = Boolean.valueOf(AmA8tU2.getBoolean(0, false));
        }
        AmA8tU2.recycle();
        Drawable background = getBackground();
        ColorStateList valueOf = background == null ? ColorStateList.valueOf(0) : JrXYwF.A4TApA.C2rE4F(background);
        if (valueOf != null) {
            AaHO0E aaHO0E = new AaHO0E();
            aaHO0E.B3GDIM(valueOf);
            aaHO0E.AmA8tU(context2);
            aaHO0E.B2KMhB(getElevation());
            setBackground(aaHO0E);
        }
    }

    private static /* synthetic */ void TrdWfdJ() {
        char[] charArray = ")%'d-+'/d(%3d9\"/&&d\u0000$#\b8#.-/".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'J');
        }
        String str = new String(charArray);
        char[] charArray2 = ")&#$#>".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'J');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void BIYEnU(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i2 = measuredWidth2 + i;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i, 0), Math.max(i2 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i += max;
            i2 -= max;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i2 - i, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i, textView.getTop(), i2, textView.getBottom());
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f11317DXnQ0V;
    }

    public Integer getNavigationIconTint() {
        return this.f11314DRlcZ9;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AlLFFp.D07BeM(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        ImageView imageView2 = null;
        if (this.f11315DUi7mC || this.f11316DV2E8K) {
            ArrayList AcNBzu2 = C4FrIb.AcNBzu(this, getTitle());
            boolean isEmpty = AcNBzu2.isEmpty();
            ARc23Z aRc23Z = C4FrIb.f6607A5SV6n;
            TextView textView = isEmpty ? null : (TextView) Collections.min(AcNBzu2, aRc23Z);
            ArrayList AcNBzu3 = C4FrIb.AcNBzu(this, getSubtitle());
            TextView textView2 = AcNBzu3.isEmpty() ? null : (TextView) Collections.max(AcNBzu3, aRc23Z);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i6 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i7 = 0; i7 < getChildCount(); i7++) {
                    View childAt = getChildAt(i7);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i6 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i6 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.f11315DUi7mC && textView != null) {
                    BIYEnU(textView, pair);
                }
                if (this.f11316DV2E8K && textView2 != null) {
                    BIYEnU(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i5 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i5);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i5++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.DXuj49;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f11317DXnQ0V;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        AlLFFp.CtFAbx(this, f);
    }

    public void setLogoAdjustViewBounds(boolean z) {
        Boolean bool = this.DXuj49;
        if (bool == null || bool.booleanValue() != z) {
            this.DXuj49 = Boolean.valueOf(z);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f11317DXnQ0V != scaleType) {
            this.f11317DXnQ0V = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.f11314DRlcZ9 != null) {
            drawable = com.bumptech.glide.A5SV6n.DvK7DB(drawable.mutate());
            drawable.setTint(this.f11314DRlcZ9.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i) {
        this.f11314DRlcZ9 = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if (this.f11316DV2E8K != z) {
            this.f11316DV2E8K = z;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if (this.f11315DUi7mC != z) {
            this.f11315DUi7mC = z;
            requestLayout();
        }
    }
}
