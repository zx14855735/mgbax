package O1nrJm;

import COJEAR.Ddcejp;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import com.google.android.material.button.MaterialButton;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU extends com.bumptech.glide.AMqCpz {

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final /* synthetic */ int f6159ARc23Z;

    public /* synthetic */ A2egSU(int i) {
        this.f6159ARc23Z = i;
    }

    @Override // com.bumptech.glide.AMqCpz
    public final float BniPrB(Object obj) {
        float displayedWidthIncrease;
        switch (this.f6159ARc23Z) {
            case 0:
                displayedWidthIncrease = ((MaterialButton) obj).getDisplayedWidthIncrease();
                return displayedWidthIncrease;
            case 1:
                return ((OdANhw.A2egSU) obj).f6620A5SV6n;
            default:
                return ((OvgpEe.AMqCpz) obj).f6841BTvldC.f6864A4TApA * 10000.0f;
        }
    }

    @Override // com.bumptech.glide.AMqCpz
    public final void Cd8JRx(Object obj, float f) {
        switch (this.f6159ARc23Z) {
            case 0:
                ((MaterialButton) obj).setDisplayedWidthIncrease(f);
                break;
            case 1:
                ((OdANhw.A2egSU) obj).A2egSU(f);
                break;
            default:
                OvgpEe.AMqCpz aMqCpz = (OvgpEe.AMqCpz) obj;
                aMqCpz.f6841BTvldC.f6864A4TApA = f / 10000.0f;
                aMqCpz.invalidateSelf();
                int i = (int) f;
                if (aMqCpz.f6852AlLFFp.A5SV6n(true)) {
                    float f2 = 0.0f;
                    if (aMqCpz.BpkvW3 == null) {
                        LinearInterpolator linearInterpolator = NdEzCJ.A2egSU.f6036A2egSU;
                        Context context = aMqCpz.f6851AcNBzu;
                        aMqCpz.f6846C4FrIb = com.bumptech.glide.A5SV6n.D6DOie(context, 2130969639, linearInterpolator);
                        aMqCpz.f6847CASmeH = com.bumptech.glide.A5SV6n.D6DOie(context, 2130969631, linearInterpolator);
                        ValueAnimator valueAnimator = new ValueAnimator();
                        aMqCpz.BpkvW3 = valueAnimator;
                        valueAnimator.setDuration(500L);
                        aMqCpz.BpkvW3.setFloatValues(0.0f, 1.0f);
                        aMqCpz.BpkvW3.setInterpolator(null);
                        aMqCpz.BpkvW3.addUpdateListener(new Ddcejp(5, aMqCpz));
                    }
                    float f3 = i;
                    if (f3 >= 1000.0f && f3 <= 9000.0f) {
                        f2 = 1.0f;
                    }
                    if (f2 == aMqCpz.f6842BV3sI0) {
                        if (!aMqCpz.BpkvW3.isRunning()) {
                            aMqCpz.f6841BTvldC.AMqCpz = f2;
                            aMqCpz.invalidateSelf();
                            break;
                        }
                    } else {
                        if (aMqCpz.BpkvW3.isRunning()) {
                            aMqCpz.BpkvW3.cancel();
                        }
                        aMqCpz.f6842BV3sI0 = f2;
                        if (f2 != 1.0f) {
                            aMqCpz.f6845C2rE4F = aMqCpz.f6847CASmeH;
                            aMqCpz.BpkvW3.reverse();
                            break;
                        } else {
                            aMqCpz.f6845C2rE4F = aMqCpz.f6846C4FrIb;
                            aMqCpz.BpkvW3.start();
                            break;
                        }
                    }
                }
                break;
        }
    }
}
