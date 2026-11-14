package PVQ0dw;

import O1Vn2F.AMqCpz;
import OLy1FW.AYUAbz;
import Oay4Bh.C4FrIb;
import PCV8se.AaHO0E;
import PCV8se.B2KMhB;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bumptech.glide.A5SV6n;
import com.google.android.material.R$styleable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A2egSU extends FrameLayout {

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final AMqCpz f7270B7CMnp = new AMqCpz(1);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final B2KMhB f7271AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f7272AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final float f7273AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final float f7274AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final int f7275B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final int f7276B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public ColorStateList f7277B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public PorterDuff.Mode f7278B4ZgIw;

    static {
        QuNQ();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public A2egSU(Context context, AttributeSet attributeSet) {
        super(PXXBzr.A2egSU.A2egSU(context, attributeSet, 0, 0), attributeSet);
        GradientDrawable gradientDrawable;
        Drawable DvK7DB2;
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.f11259D07BeM);
        if (obtainStyledAttributes.hasValue(6)) {
            setElevation(obtainStyledAttributes.getDimensionPixelSize(6, 0));
        }
        this.f7272AlLFFp = obtainStyledAttributes.getInt(2, 0);
        if (obtainStyledAttributes.hasValue(8) || obtainStyledAttributes.hasValue(9)) {
            this.f7271AcNBzu = B2KMhB.A5SV6n(context2, attributeSet, 0, 0).A2egSU();
        }
        this.f7273AmA8tU = obtainStyledAttributes.getFloat(3, 1.0f);
        setBackgroundTintList(com.bumptech.glide.AMqCpz.BPw6Q8(context2, obtainStyledAttributes, 4));
        setBackgroundTintMode(C4FrIb.B25kr6(obtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.f7274AzWtSf = obtainStyledAttributes.getFloat(1, 1.0f);
        this.f7275B25kr6 = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f7276B2KMhB = obtainStyledAttributes.getDimensionPixelSize(7, -1);
        obtainStyledAttributes.recycle();
        setOnTouchListener(f7270B7CMnp);
        setFocusable(true);
        if (getBackground() == null) {
            int AaHO0E2 = AYUAbz.AaHO0E(getBackgroundOverlayColorAlpha(), AYUAbz.ASJ6gh(2130968895, this), AYUAbz.ASJ6gh(2130968872, this));
            B2KMhB b2KMhB = this.f7271AcNBzu;
            if (b2KMhB != null) {
                int i = A4TApA.f7279A2egSU;
                AaHO0E aaHO0E = new AaHO0E(b2KMhB);
                aaHO0E.B3GDIM(ColorStateList.valueOf(AaHO0E2));
                gradientDrawable = aaHO0E;
            } else {
                Resources resources = getResources();
                int i2 = A4TApA.f7279A2egSU;
                float dimension = resources.getDimension(2131166507);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setCornerRadius(dimension);
                gradientDrawable2.setColor(AaHO0E2);
                gradientDrawable = gradientDrawable2;
            }
            if (this.f7277B3GDIM != null) {
                DvK7DB2 = A5SV6n.DvK7DB(gradientDrawable);
                DvK7DB2.setTintList(this.f7277B3GDIM);
            } else {
                DvK7DB2 = A5SV6n.DvK7DB(gradientDrawable);
            }
            setBackground(DvK7DB2);
        }
    }

    private static /* synthetic */ void QuNQ() {
        char[] charArray = ":64w>84<w;6 w*1<55w\u001370\u001b+0=><".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'Y');
        }
        String str = new String(charArray);
        char[] charArray2 = ":5070-".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'Y');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void setBaseTransientBottomBar(A4TApA a4TApA) {
    }

    public float getActionTextColorAlpha() {
        return this.f7274AzWtSf;
    }

    public int getAnimationMode() {
        return this.f7272AlLFFp;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f7273AmA8tU;
    }

    public int getMaxInlineActionWidth() {
        return this.f7276B2KMhB;
    }

    public int getMaxWidth() {
        return this.f7275B25kr6;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.f7275B25kr6;
        if (i3 <= 0 || getMeasuredWidth() <= i3) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
    }

    public void setAnimationMode(int i) {
        this.f7272AlLFFp = i;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.f7277B3GDIM != null) {
            drawable = A5SV6n.DvK7DB(drawable.mutate());
            drawable.setTintList(this.f7277B3GDIM);
            drawable.setTintMode(this.f7278B4ZgIw);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.f7277B3GDIM = colorStateList;
        if (getBackground() != null) {
            Drawable DvK7DB2 = A5SV6n.DvK7DB(getBackground().mutate());
            DvK7DB2.setTintList(colorStateList);
            DvK7DB2.setTintMode(this.f7278B4ZgIw);
            if (DvK7DB2 != getBackground()) {
                super.setBackgroundDrawable(DvK7DB2);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.f7278B4ZgIw = mode;
        if (getBackground() != null) {
            Drawable DvK7DB2 = A5SV6n.DvK7DB(getBackground().mutate());
            DvK7DB2.setTintMode(mode);
            if (DvK7DB2 != getBackground()) {
                super.setBackgroundDrawable(DvK7DB2);
            }
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f7270B7CMnp);
        super.setOnClickListener(onClickListener);
    }
}
