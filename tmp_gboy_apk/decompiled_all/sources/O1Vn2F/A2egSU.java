package O1Vn2F;

import PCV8se.AaHO0E;
import android.animation.ValueAnimator;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f6148A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f6149A4TApA;

    public /* synthetic */ A2egSU(int i, Object obj) {
        this.f6148A2egSU = i;
        this.f6149A4TApA = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f6148A2egSU) {
            case 0:
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AaHO0E aaHO0E = ((BottomSheetBehavior) this.f6149A4TApA).f11397B7CMnp;
                if (aaHO0E != null) {
                    aaHO0E.B4ZgIw(floatValue);
                    break;
                }
                break;
            case 1:
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TextView textView = (TextView) this.f6149A4TApA;
                textView.setScaleX(floatValue2);
                textView.setScaleY(floatValue2);
                break;
            case 2:
                ((TabLayout) this.f6149A4TApA).scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                break;
            default:
                ((TextInputLayout) this.f6149A4TApA).f11974EicXu4.AlLFFp(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
