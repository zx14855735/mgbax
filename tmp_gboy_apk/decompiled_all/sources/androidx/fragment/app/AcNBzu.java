package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AcNBzu extends AnimatorListenerAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ AmA8tU f8745A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ View f8746A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ boolean f8747A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ DyaChj f8748ADYaiT;
    public final /* synthetic */ AZOQYO AMqCpz;

    public AcNBzu(AmA8tU amA8tU, View view, boolean z, DyaChj dyaChj, AZOQYO azoqyo) {
        this.f8745A2egSU = amA8tU;
        this.f8746A4TApA = view;
        this.f8747A5SV6n = z;
        this.f8748ADYaiT = dyaChj;
        this.AMqCpz = azoqyo;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        RXb0Sz.ARc23Z.AMqCpz(animator, "anim");
        ViewGroup viewGroup = this.f8745A2egSU.f8753A2egSU;
        View view = this.f8746A4TApA;
        viewGroup.endViewTransition(view);
        DyaChj dyaChj = this.f8748ADYaiT;
        if (this.f8747A5SV6n) {
            int i = dyaChj.f8953A2egSU;
            RXb0Sz.ARc23Z.ADYaiT(view, "viewToAnimate");
            J3FDQU.A2egSU.A2egSU(i, view);
        }
        this.AMqCpz.A2egSU();
        if (CtxOCS.C4FrIb(2)) {
            Objects.toString(dyaChj);
        }
    }
}
