package Fyurov;

import android.animation.ValueAnimator;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AlLFFp implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f2948A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2949A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ B2KMhB f2950A5SV6n;

    public /* synthetic */ AlLFFp(B2KMhB b2KMhB, ArrayList arrayList, int i) {
        this.f2948A2egSU = i;
        this.f2950A5SV6n = b2KMhB;
        this.f2949A4TApA = arrayList;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2948A2egSU) {
            case 0:
                B2KMhB.ADYaiT(this.f2950A5SV6n, ((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f2949A4TApA, 4);
                break;
            default:
                B2KMhB.ADYaiT(this.f2950A5SV6n, ((Float) valueAnimator.getAnimatedValue()).floatValue(), this.f2949A4TApA, 2);
                break;
        }
    }
}
