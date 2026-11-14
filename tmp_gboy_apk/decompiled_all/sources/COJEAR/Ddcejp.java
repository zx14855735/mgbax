package COJEAR;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageButton;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.sigmob.sdk.base.utils.n;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class Ddcejp implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f1694A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f1695A4TApA;

    public /* synthetic */ Ddcejp(int i, Object obj) {
        this.f1694A2egSU = i;
        this.f1695A4TApA = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f1694A2egSU) {
            case 0:
                ((View) ((ADYaiT.DXuj49) ((KCxDWD.A5SV6n) this.f1695A4TApA).f4241AlLFFp).f254ADYaiT.getParent()).invalidate();
                break;
            case 1:
                O616TD.A5SV6n a5SV6n = (O616TD.A5SV6n) this.f1695A4TApA;
                a5SV6n.getClass();
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a5SV6n.f6204AZkASS.setAlpha((int) (255.0f * floatValue));
                a5SV6n.f6218BIYEnU = floatValue;
                break;
            case 2:
                float[] fArr = (float[]) valueAnimator.getAnimatedValue();
                ((ClippableRoundedCornerLayout) this.f1695A4TApA).A2egSU(r0.getLeft(), r0.getTop(), r0.getRight(), r0.getBottom(), fArr);
                break;
            case 3:
                ((DrawerLayout) this.f1695A4TApA).setScrimColor(BV3sI0.A2egSU.AMqCpz(n.f13223a, NdEzCJ.A2egSU.A5SV6n(valueAnimator.getAnimatedFraction(), OpB85q.A4TApA.f6659A2egSU, 0)));
                break;
            case 4:
                ((View) this.f1695A4TApA).setTranslationX((1.0f - valueAnimator.getAnimatedFraction()) * (-30.0f));
                break;
            case 5:
                OvgpEe.AMqCpz aMqCpz = (OvgpEe.AMqCpz) this.f1695A4TApA;
                aMqCpz.f6841BTvldC.AMqCpz = aMqCpz.f6845C2rE4F.getInterpolation(aMqCpz.BpkvW3.getAnimatedFraction());
                break;
            case 6:
                ((ImageButton) this.f1695A4TApA).setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 7:
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ARc23Z.AZkASS aZkASS = (ARc23Z.AZkASS) this.f1695A4TApA;
                if (aZkASS.f312AZOQYO != floatValue2) {
                    aZkASS.f312AZOQYO = floatValue2;
                    aZkASS.invalidateSelf();
                    break;
                }
                break;
            case 8:
                ((Oay4Bh.ARc23Z) this.f1695A4TApA).A2egSU(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 9:
                P8ccfD.AzWtSf azWtSf = (P8ccfD.AzWtSf) this.f1695A4TApA;
                azWtSf.getClass();
                azWtSf.f6997AZkASS.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                azWtSf.f7003B25kr6.getTextView().setAlpha(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 10:
                PSeUZ5.ADYaiT aDYaiT = (PSeUZ5.ADYaiT) this.f1695A4TApA;
                aDYaiT.getClass();
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                Iterator it = aDYaiT.f7192BI9f7h.iterator();
                while (it.hasNext()) {
                    PcHFaG.A4TApA a4TApA = (PcHFaG.A4TApA) it.next();
                    a4TApA.f7422DRlcZ9 = floatValue3;
                    a4TApA.f7423DUi7mC = floatValue3;
                    a4TApA.DXuj49 = NdEzCJ.A2egSU.A4TApA(0.0f, 1.0f, 0.19f, 1.0f, floatValue3);
                    a4TApA.invalidateSelf();
                }
                aDYaiT.postInvalidateOnAnimation();
                break;
            default:
                PWr3nF.AZkASS aZkASS2 = (PWr3nF.AZkASS) this.f1695A4TApA;
                aZkASS2.getClass();
                aZkASS2.f7352ADYaiT.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }

    public /* synthetic */ Ddcejp(KCxDWD.A5SV6n a5SV6n, View view) {
        this.f1694A2egSU = 0;
        this.f1695A4TApA = a5SV6n;
    }
}
