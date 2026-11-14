package Oay4Bh;

import android.animation.ValueAnimator;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AaHO0E implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f6532A2egSU = 0;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final Object f6533A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Object f6534A5SV6n;

    public AaHO0E(COJEAR.AZOQYO azoqyo, View[] viewArr) {
        this.f6533A4TApA = azoqyo;
        this.f6534A5SV6n = viewArr;
    }

    public static AaHO0E A2egSU(View... viewArr) {
        return new AaHO0E(new COJEAR.AZOQYO(14), viewArr);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f6532A2egSU) {
            case 0:
                for (View view : (View[]) this.f6534A5SV6n) {
                    switch (((COJEAR.AZOQYO) this.f6533A4TApA).f1625AcNBzu) {
                        case 13:
                            view.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            break;
                        case 14:
                            view.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            break;
                        case 15:
                            Float f = (Float) valueAnimator.getAnimatedValue();
                            view.setScaleX(f.floatValue());
                            view.setScaleY(f.floatValue());
                            break;
                        default:
                            view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            break;
                    }
                }
                break;
            default:
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                androidx.swiperefreshlayout.widget.ADYaiT aDYaiT = (androidx.swiperefreshlayout.widget.ADYaiT) this.f6534A5SV6n;
                aDYaiT.getClass();
                androidx.swiperefreshlayout.widget.A5SV6n a5SV6n = (androidx.swiperefreshlayout.widget.A5SV6n) this.f6533A4TApA;
                androidx.swiperefreshlayout.widget.ADYaiT.ADYaiT(floatValue, a5SV6n);
                aDYaiT.A2egSU(floatValue, a5SV6n, false);
                aDYaiT.invalidateSelf();
                break;
        }
    }

    public AaHO0E(androidx.swiperefreshlayout.widget.ADYaiT aDYaiT, androidx.swiperefreshlayout.widget.A5SV6n a5SV6n) {
        this.f6534A5SV6n = aDYaiT;
        this.f6533A4TApA = a5SV6n;
    }
}
