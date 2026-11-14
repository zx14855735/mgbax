package Ogw3zR;

import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZkASS extends A2egSU {

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final float f6656ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final float f6657AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final float f6658AZOQYO;

    public AZkASS(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f6656ASJ6gh = resources.getDimension(2131165632);
        this.f6657AYUAbz = resources.getDimension(2131165631);
        this.f6658AZOQYO = resources.getDimension(2131165633);
    }

    public final void A2egSU() {
        androidx.activity.A4TApA a4TApA = this.f6641ARc23Z;
        this.f6641ARc23Z = null;
        if (a4TApA == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        View view = this.f6638A4TApA;
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 1.0f));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(this.AMqCpz);
        animatorSet.start();
    }

    public final void A4TApA(androidx.activity.A4TApA a4TApA, int i, AnimatorListenerAdapter animatorListenerAdapter, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        int i2;
        boolean z = a4TApA.f7938ADYaiT == 0;
        View view = this.f6638A4TApA;
        boolean z2 = (Gravity.getAbsoluteGravity(i, view.getLayoutDirection()) & 3) == 3;
        float scaleX = view.getScaleX() * view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i2 = z2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
        } else {
            i2 = 0;
        }
        float f = scaleX + i2;
        Property property = View.TRANSLATION_X;
        if (z2) {
            f = -f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, f);
        if (animatorUpdateListener != null) {
            ofFloat.addUpdateListener(animatorUpdateListener);
        }
        ofFloat.setInterpolator(new D8cQ8b.A4TApA());
        ofFloat.setDuration(NdEzCJ.A2egSU.A5SV6n(a4TApA.f7937A5SV6n, this.f6639A5SV6n, this.f6640ADYaiT));
        ofFloat.addListener(new AZOQYO(this, z, i));
        ofFloat.addListener(animatorListenerAdapter);
        ofFloat.start();
    }

    public final void A5SV6n(float f, boolean z, int i) {
        float interpolation = this.f6637A2egSU.getInterpolation(f);
        View view = this.f6638A4TApA;
        boolean z2 = (Gravity.getAbsoluteGravity(i, view.getLayoutDirection()) & 3) == 3;
        boolean z3 = z == z2;
        int width = view.getWidth();
        int height = view.getHeight();
        float f2 = width;
        if (f2 > 0.0f) {
            float f3 = height;
            if (f3 <= 0.0f) {
                return;
            }
            float f4 = this.f6656ASJ6gh / f2;
            float f5 = this.f6657AYUAbz / f2;
            float f6 = this.f6658AZOQYO / f3;
            if (z2) {
                f2 = 0.0f;
            }
            view.setPivotX(f2);
            if (!z3) {
                f5 = -f4;
            }
            float A2egSU2 = NdEzCJ.A2egSU.A2egSU(0.0f, f5, interpolation);
            float f7 = A2egSU2 + 1.0f;
            float A2egSU3 = 1.0f - NdEzCJ.A2egSU.A2egSU(0.0f, f6, interpolation);
            if (Float.isNaN(f7) || Float.isNaN(A2egSU3)) {
                return;
            }
            view.setScaleX(f7);
            view.setScaleY(A2egSU3);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    childAt.setPivotX(z2 ? childAt.getWidth() + (width - childAt.getRight()) : -childAt.getLeft());
                    childAt.setPivotY(-childAt.getTop());
                    float f8 = z3 ? 1.0f - A2egSU2 : 1.0f;
                    float f9 = A2egSU3 != 0.0f ? (f7 / A2egSU3) * f8 : 1.0f;
                    if (!Float.isNaN(f8) && !Float.isNaN(f9)) {
                        childAt.setScaleX(f8);
                        childAt.setScaleY(f9);
                    }
                }
            }
        }
    }
}
