package com.google.android.material.card;

import BPw6Q8.ASJ6gh;
import NOd7IU.AlLFFp;
import O616TD.A5SV6n;
import OLy1FW.AYUAbz;
import Oay4Bh.C4FrIb;
import PCV8se.AaHO0E;
import PCV8se.B2KMhB;
import PCV8se.BPw6Q8;
import PXXBzr.A2egSU;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.cardview.widget.CardView;
import com.bumptech.glide.AMqCpz;
import com.google.android.material.R$styleable;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MaterialCardView extends CardView implements Checkable, BPw6Q8 {

    /* renamed from: BI9f7h, reason: collision with root package name */
    public static final int[] f11494BI9f7h = {R.attr.state_checkable};

    /* renamed from: BIYEnU, reason: collision with root package name */
    public static final int[] f11495BIYEnU = {R.attr.state_checked};

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public static final int[] f11496BJ7GGh = {2130969919};

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final A5SV6n f11497B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final boolean f11498B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f11499B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public boolean f11500BChYOn;

    static {
        Nkdt();
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        super(A2egSU.A2egSU(context, attributeSet, 2130969557, 2131952842), attributeSet, 2130969557);
        this.f11499B9tovu = false;
        this.f11500BChYOn = false;
        this.f11498B7CMnp = true;
        TypedArray AmA8tU2 = C4FrIb.AmA8tU(getContext(), attributeSet, R$styleable.f11237BPw6Q8, 2130969557, 2131952842, new int[0]);
        A5SV6n a5SV6n = new A5SV6n(this, attributeSet);
        this.f11497B4ZgIw = a5SV6n;
        ColorStateList cardBackgroundColor = super.getCardBackgroundColor();
        AaHO0E aaHO0E = a5SV6n.f6198A5SV6n;
        aaHO0E.B3GDIM(cardBackgroundColor);
        a5SV6n.f6197A4TApA.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        a5SV6n.AcNBzu();
        MaterialCardView materialCardView = a5SV6n.f6196A2egSU;
        ColorStateList BPw6Q82 = AMqCpz.BPw6Q8(materialCardView.getContext(), AmA8tU2, 11);
        a5SV6n.f6208AmA8tU = BPw6Q82;
        if (BPw6Q82 == null) {
            a5SV6n.f6208AmA8tU = ColorStateList.valueOf(-1);
        }
        a5SV6n.f6202AYUAbz = AmA8tU2.getDimensionPixelSize(12, 0);
        boolean z = AmA8tU2.getBoolean(0, false);
        a5SV6n.f6213B4ZgIw = z;
        materialCardView.setLongClickable(z);
        a5SV6n.f6206AcNBzu = AMqCpz.BPw6Q8(materialCardView.getContext(), AmA8tU2, 6);
        a5SV6n.ASJ6gh(AMqCpz.BV3sI0(materialCardView.getContext(), AmA8tU2, 2));
        a5SV6n.f6200ARc23Z = AmA8tU2.getDimensionPixelSize(5, 0);
        a5SV6n.AMqCpz = AmA8tU2.getDimensionPixelSize(4, 0);
        a5SV6n.f6201ASJ6gh = AmA8tU2.getInteger(3, 8388661);
        ColorStateList BPw6Q83 = AMqCpz.BPw6Q8(materialCardView.getContext(), AmA8tU2, 7);
        a5SV6n.f6205AaHO0E = BPw6Q83;
        if (BPw6Q83 == null) {
            a5SV6n.f6205AaHO0E = ColorStateList.valueOf(AYUAbz.ASJ6gh(2130968853, materialCardView));
        }
        ColorStateList BPw6Q84 = AMqCpz.BPw6Q8(materialCardView.getContext(), AmA8tU2, 1);
        AaHO0E aaHO0E2 = a5SV6n.f6199ADYaiT;
        aaHO0E2.B3GDIM(BPw6Q84 == null ? ColorStateList.valueOf(0) : BPw6Q84);
        RippleDrawable rippleDrawable = a5SV6n.f6209AzWtSf;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(a5SV6n.f6205AaHO0E);
        }
        aaHO0E.B2KMhB(materialCardView.getCardElevation());
        float f = a5SV6n.f6202AYUAbz;
        ColorStateList colorStateList = a5SV6n.f6208AmA8tU;
        aaHO0E2.BJ7GGh(f);
        aaHO0E2.BIYEnU(colorStateList);
        materialCardView.setBackgroundInternal(a5SV6n.ADYaiT(aaHO0E));
        Drawable A5SV6n2 = a5SV6n.AZkASS() ? a5SV6n.A5SV6n() : aaHO0E2;
        a5SV6n.f6203AZOQYO = A5SV6n2;
        materialCardView.setForeground(a5SV6n.ADYaiT(A5SV6n2));
        AmA8tU2.recycle();
    }

    private static /* synthetic */ void Nkdt() {
        char[] charArray = "\u001a\u0016\u0014W\u001e\u0018\u0014\u001cW\u001b\u0016\u0000W\n\u0011\u001c\u0015\u0015W3\u0017\u0010;\u000b\u0010\u001d\u001e\u001c".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'y');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001a\u0015\u0010\u0017\u0010\r".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'y');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f11497B4ZgIw.f6198A5SV6n.getBounds());
        return rectF;
    }

    public final void A4TApA() {
        A5SV6n a5SV6n;
        RippleDrawable rippleDrawable;
        if (Build.VERSION.SDK_INT <= 26 || (rippleDrawable = (a5SV6n = this.f11497B4ZgIw).f6209AzWtSf) == null) {
            return;
        }
        Rect bounds = rippleDrawable.getBounds();
        int i = bounds.bottom;
        a5SV6n.f6209AzWtSf.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
        a5SV6n.f6209AzWtSf.setBounds(bounds.left, bounds.top, bounds.right, i);
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.f11497B4ZgIw.f6198A5SV6n.f7042AlLFFp.f7024ADYaiT;
    }

    public ColorStateList getCardForegroundColor() {
        return this.f11497B4ZgIw.f6199ADYaiT.f7042AlLFFp.f7024ADYaiT;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f11497B4ZgIw.f6204AZkASS;
    }

    public int getCheckedIconGravity() {
        return this.f11497B4ZgIw.f6201ASJ6gh;
    }

    public int getCheckedIconMargin() {
        return this.f11497B4ZgIw.AMqCpz;
    }

    public int getCheckedIconSize() {
        return this.f11497B4ZgIw.f6200ARc23Z;
    }

    public ColorStateList getCheckedIconTint() {
        return this.f11497B4ZgIw.f6206AcNBzu;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f11497B4ZgIw.f6197A4TApA.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f11497B4ZgIw.f6197A4TApA.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f11497B4ZgIw.f6197A4TApA.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f11497B4ZgIw.f6197A4TApA.top;
    }

    public float getProgress() {
        return this.f11497B4ZgIw.f6198A5SV6n.f7042AlLFFp.f7029AZkASS;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f11497B4ZgIw.f6198A5SV6n.AcNBzu();
    }

    public ColorStateList getRippleColor() {
        return this.f11497B4ZgIw.f6205AaHO0E;
    }

    public B2KMhB getShapeAppearanceModel() {
        return this.f11497B4ZgIw.f6207AlLFFp;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.f11497B4ZgIw.f6208AmA8tU;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f11497B4ZgIw.f6208AmA8tU;
    }

    public int getStrokeWidth() {
        return this.f11497B4ZgIw.f6202AYUAbz;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f11499B9tovu;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        A5SV6n a5SV6n = this.f11497B4ZgIw;
        a5SV6n.AaHO0E();
        AlLFFp.CtxOCS(this, a5SV6n.f6198A5SV6n);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 3);
        A5SV6n a5SV6n = this.f11497B4ZgIw;
        if (a5SV6n != null && a5SV6n.f6213B4ZgIw) {
            View.mergeDrawableStates(onCreateDrawableState, f11494BI9f7h);
        }
        if (this.f11499B9tovu) {
            View.mergeDrawableStates(onCreateDrawableState, f11495BIYEnU);
        }
        if (this.f11500BChYOn) {
            View.mergeDrawableStates(onCreateDrawableState, f11496BJ7GGh);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(this.f11499B9tovu);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        A5SV6n a5SV6n = this.f11497B4ZgIw;
        accessibilityNodeInfo.setCheckable(a5SV6n != null && a5SV6n.f6213B4ZgIw);
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(this.f11499B9tovu);
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f11497B4ZgIw.AMqCpz(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f11498B7CMnp) {
            A5SV6n a5SV6n = this.f11497B4ZgIw;
            if (!a5SV6n.f6212B3GDIM) {
                a5SV6n.f6212B3GDIM = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f11497B4ZgIw.f6198A5SV6n.B3GDIM(colorStateList);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        A5SV6n a5SV6n = this.f11497B4ZgIw;
        a5SV6n.f6198A5SV6n.B2KMhB(a5SV6n.f6196A2egSU.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        AaHO0E aaHO0E = this.f11497B4ZgIw.f6199ADYaiT;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        aaHO0E.B3GDIM(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.f11497B4ZgIw.f6213B4ZgIw = z;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f11499B9tovu != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f11497B4ZgIw.ASJ6gh(drawable);
    }

    public void setCheckedIconGravity(int i) {
        A5SV6n a5SV6n = this.f11497B4ZgIw;
        if (a5SV6n.f6201ASJ6gh != i) {
            a5SV6n.f6201ASJ6gh = i;
            MaterialCardView materialCardView = a5SV6n.f6196A2egSU;
            a5SV6n.AMqCpz(materialCardView.getMeasuredWidth(), materialCardView.getMeasuredHeight());
        }
    }

    public void setCheckedIconMargin(int i) {
        this.f11497B4ZgIw.AMqCpz = i;
    }

    public void setCheckedIconMarginResource(int i) {
        if (i != -1) {
            this.f11497B4ZgIw.AMqCpz = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconResource(int i) {
        this.f11497B4ZgIw.ASJ6gh(AlLFFp.CQhlFr(getContext(), i));
    }

    public void setCheckedIconSize(int i) {
        this.f11497B4ZgIw.f6200ARc23Z = i;
    }

    public void setCheckedIconSizeResource(int i) {
        if (i != 0) {
            this.f11497B4ZgIw.f6200ARc23Z = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        A5SV6n a5SV6n = this.f11497B4ZgIw;
        a5SV6n.f6206AcNBzu = colorStateList;
        Drawable drawable = a5SV6n.f6204AZkASS;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        A5SV6n a5SV6n = this.f11497B4ZgIw;
        if (a5SV6n != null) {
            a5SV6n.AaHO0E();
        }
    }

    public void setDragged(boolean z) {
        if (this.f11500BChYOn != z) {
            this.f11500BChYOn = z;
            refreshDrawableState();
            A4TApA();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.f11497B4ZgIw.AlLFFp();
    }

    public void setOnCheckedChangeListener(O616TD.A2egSU a2egSU) {
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        A5SV6n a5SV6n = this.f11497B4ZgIw;
        a5SV6n.AlLFFp();
        a5SV6n.AcNBzu();
    }

    public void setProgress(float f) {
        A5SV6n a5SV6n = this.f11497B4ZgIw;
        a5SV6n.f6198A5SV6n.B4ZgIw(f);
        AaHO0E aaHO0E = a5SV6n.f6199ADYaiT;
        if (aaHO0E != null) {
            aaHO0E.B4ZgIw(f);
        }
        AaHO0E aaHO0E2 = a5SV6n.f6211B2KMhB;
        if (aaHO0E2 != null) {
            aaHO0E2.B4ZgIw(f);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f) {
        super.setRadius(f);
        A5SV6n a5SV6n = this.f11497B4ZgIw;
        B2KMhB.A2egSU ASJ6gh2 = a5SV6n.f6207AlLFFp.ASJ6gh();
        ASJ6gh2.A5SV6n(f);
        a5SV6n.AYUAbz(ASJ6gh2.A2egSU());
        a5SV6n.f6203AZOQYO.invalidateSelf();
        if (a5SV6n.AZOQYO() || (a5SV6n.f6196A2egSU.getPreventCornerOverlap() && !a5SV6n.f6198A5SV6n.AzWtSf())) {
            a5SV6n.AcNBzu();
        }
        if (a5SV6n.AZOQYO()) {
            a5SV6n.AlLFFp();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        A5SV6n a5SV6n = this.f11497B4ZgIw;
        a5SV6n.f6205AaHO0E = colorStateList;
        RippleDrawable rippleDrawable = a5SV6n.f6209AzWtSf;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        ColorStateList A5SV6n2 = ASJ6gh.A5SV6n(getContext(), i);
        A5SV6n a5SV6n = this.f11497B4ZgIw;
        a5SV6n.f6205AaHO0E = A5SV6n2;
        RippleDrawable rippleDrawable = a5SV6n.f6209AzWtSf;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(A5SV6n2);
        }
    }

    @Override // PCV8se.BPw6Q8
    public void setShapeAppearanceModel(B2KMhB b2KMhB) {
        setClipToOutline(b2KMhB.ARc23Z(getBoundsAsRectF()));
        this.f11497B4ZgIw.AYUAbz(b2KMhB);
    }

    public void setStrokeColor(int i) {
        setStrokeColor(ColorStateList.valueOf(i));
    }

    public void setStrokeWidth(int i) {
        A5SV6n a5SV6n = this.f11497B4ZgIw;
        if (i != a5SV6n.f6202AYUAbz) {
            a5SV6n.f6202AYUAbz = i;
            AaHO0E aaHO0E = a5SV6n.f6199ADYaiT;
            ColorStateList colorStateList = a5SV6n.f6208AmA8tU;
            aaHO0E.BJ7GGh(i);
            aaHO0E.BIYEnU(colorStateList);
        }
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        A5SV6n a5SV6n = this.f11497B4ZgIw;
        a5SV6n.AlLFFp();
        a5SV6n.AcNBzu();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        A5SV6n a5SV6n = this.f11497B4ZgIw;
        if (a5SV6n != null && a5SV6n.f6213B4ZgIw && isEnabled()) {
            this.f11499B9tovu = !this.f11499B9tovu;
            refreshDrawableState();
            A4TApA();
            a5SV6n.ARc23Z(this.f11499B9tovu, true);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        A5SV6n a5SV6n = this.f11497B4ZgIw;
        if (a5SV6n.f6208AmA8tU != colorStateList) {
            a5SV6n.f6208AmA8tU = colorStateList;
            AaHO0E aaHO0E = a5SV6n.f6199ADYaiT;
            aaHO0E.BJ7GGh(a5SV6n.f6202AYUAbz);
            aaHO0E.BIYEnU(colorStateList);
        }
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i) {
        this.f11497B4ZgIw.f6198A5SV6n.B3GDIM(ColorStateList.valueOf(i));
    }
}
