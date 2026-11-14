package androidx.fragment.app;

import android.view.View;
import android.view.animation.Animation;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AlLFFp implements Animation.AnimationListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ DyaChj f8749A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AmA8tU f8750A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ View f8751A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f8752ADYaiT;

    public AlLFFp(DyaChj dyaChj, AmA8tU amA8tU, View view, AZOQYO azoqyo) {
        this.f8749A2egSU = dyaChj;
        this.f8750A4TApA = amA8tU;
        this.f8751A5SV6n = view;
        this.f8752ADYaiT = azoqyo;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        RXb0Sz.ARc23Z.AMqCpz(animation, "animation");
        AmA8tU amA8tU = this.f8750A4TApA;
        amA8tU.f8753A2egSU.post(new ADYaiT(amA8tU, this.f8751A5SV6n, this.f8752ADYaiT));
        if (CtxOCS.C4FrIb(2)) {
            Objects.toString(this.f8749A2egSU);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        RXb0Sz.ARc23Z.AMqCpz(animation, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        RXb0Sz.ARc23Z.AMqCpz(animation, "animation");
        if (CtxOCS.C4FrIb(2)) {
            Objects.toString(this.f8749A2egSU);
        }
    }
}
