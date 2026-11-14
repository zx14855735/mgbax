package Ogw3zR;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z extends A2egSU {

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final float f6645ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final float f6646AYUAbz;

    public ARc23Z(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f6645ASJ6gh = resources.getDimension(2131165627);
        this.f6646AYUAbz = resources.getDimension(2131165628);
    }

    public final AnimatorSet A2egSU() {
        AnimatorSet animatorSet = new AnimatorSet();
        View view = this.f6638A4TApA;
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 1.0f));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new D8cQ8b.A4TApA());
        return animatorSet;
    }

    public final void A4TApA(float f) {
        float interpolation = this.f6637A2egSU.getInterpolation(f);
        View view = this.f6638A4TApA;
        float width = view.getWidth();
        float height = view.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float f2 = this.f6645ASJ6gh / width;
        float f3 = this.f6646AYUAbz / height;
        float A2egSU2 = 1.0f - NdEzCJ.A2egSU.A2egSU(0.0f, f2, interpolation);
        float A2egSU3 = 1.0f - NdEzCJ.A2egSU.A2egSU(0.0f, f3, interpolation);
        if (Float.isNaN(A2egSU2) || Float.isNaN(A2egSU3)) {
            return;
        }
        view.setScaleX(A2egSU2);
        view.setPivotY(height);
        view.setScaleY(A2egSU3);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                childAt.setPivotY(-childAt.getTop());
                childAt.setScaleY(A2egSU3 != 0.0f ? A2egSU2 / A2egSU3 : 1.0f);
            }
        }
    }
}
