package Nm94Z2;

import ADYaiT.CtFAbx;
import OvgpEe.B25kr6;
import P8ccfD.AzWtSf;
import PCV8se.AaHO0E;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.google.android.material.appbar.AppBarLayout;
import com.sigmob.sdk.base.views.ak;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class A4TApA implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f6051A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f6052A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ Object f6053A5SV6n;

    public /* synthetic */ A4TApA(Object obj, int i, Object obj2) {
        this.f6051A2egSU = i;
        this.f6052A4TApA = obj;
        this.f6053A5SV6n = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Object obj = this.f6053A5SV6n;
        Object obj2 = this.f6052A4TApA;
        switch (this.f6051A2egSU) {
            case 0:
                int i = AppBarLayout.f11280CQhlFr;
                AppBarLayout appBarLayout = (AppBarLayout) obj2;
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ((AaHO0E) obj).B2KMhB(floatValue);
                Drawable drawable = appBarLayout.f11302C4FrIb;
                if (drawable instanceof AaHO0E) {
                    ((AaHO0E) drawable).B2KMhB(floatValue);
                }
                Iterator it = appBarLayout.f11297BTvldC.iterator();
                if (it.hasNext()) {
                    throw CtFAbx.A5SV6n(it);
                }
                Iterator it2 = appBarLayout.f11298BV3sI0.iterator();
                while (it2.hasNext()) {
                    ((AppBarLayout.A5SV6n) it2.next()).A2egSU(floatValue / appBarLayout.f11304CNPG0E);
                }
                return;
            case 1:
                OvgpEe.AMqCpz aMqCpz = (OvgpEe.AMqCpz) obj2;
                aMqCpz.getClass();
                B25kr6 b25kr6 = (B25kr6) obj;
                if (b25kr6.A5SV6n(true) && b25kr6.f6919AlLFFp != 0 && aMqCpz.isVisible()) {
                    aMqCpz.invalidateSelf();
                    return;
                }
                return;
            case 2:
                AzWtSf azWtSf = (AzWtSf) obj2;
                azWtSf.getClass();
                Rect rect = (Rect) obj;
                rect.right = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                azWtSf.f6997AZkASS.setClipBounds(rect);
                return;
            case 3:
                ((ak) obj2).a((PointF) obj, valueAnimator);
                return;
            default:
                ((ak) obj2).a((Paint) obj, valueAnimator);
                return;
        }
    }
}
