package Fyurov;

import Oay4Bh.C4FrIb;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AcNBzu implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f2944A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final View f2945A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Object f2946A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Object f2947ADYaiT;

    public /* synthetic */ AcNBzu(Object obj, View view, Object obj2, int i) {
        this.f2944A2egSU = i;
        this.f2947ADYaiT = obj;
        this.f2945A4TApA = view;
        this.f2946A5SV6n = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2944A2egSU) {
            case 0:
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                B25kr6 b25kr6 = (B25kr6) this.f2945A4TApA;
                b25kr6.f2957AmA8tU = floatValue;
                b25kr6.invalidate();
                B2KMhB.ADYaiT((B2KMhB) this.f2947ADYaiT, floatValue, (ArrayList) this.f2946A5SV6n, 3);
                break;
            case 1:
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float[] fArr = (float[]) this.f2947ADYaiT;
                C4FrIb.A4TApA(floatValue2, fArr);
                ActionMenuView actionMenuView = (ActionMenuView) this.f2945A4TApA;
                if (actionMenuView != null) {
                    actionMenuView.setAlpha(fArr[0]);
                }
                ActionMenuView actionMenuView2 = (ActionMenuView) this.f2946A5SV6n;
                if (actionMenuView2 != null) {
                    actionMenuView2.setAlpha(fArr[1]);
                    break;
                }
                break;
            default:
                ((PWIgQJ.A5SV6n) this.f2947ADYaiT).A5SV6n(this.f2945A4TApA, (View) this.f2946A5SV6n, valueAnimator.getAnimatedFraction());
                break;
        }
    }

    public AcNBzu(ActionMenuView actionMenuView, ActionMenuView actionMenuView2) {
        this.f2944A2egSU = 1;
        this.f2945A4TApA = actionMenuView;
        this.f2946A5SV6n = actionMenuView2;
        this.f2947ADYaiT = new float[2];
    }
}
