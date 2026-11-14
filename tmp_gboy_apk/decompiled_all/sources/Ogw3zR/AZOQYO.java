package Ogw3zR;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZOQYO extends AnimatorListenerAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ boolean f6653A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ int f6654A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ AZkASS f6655A5SV6n;

    public AZOQYO(AZkASS aZkASS, boolean z, int i) {
        this.f6655A5SV6n = aZkASS;
        this.f6653A2egSU = z;
        this.f6654A4TApA = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        AZkASS aZkASS = this.f6655A5SV6n;
        aZkASS.f6638A4TApA.setTranslationX(0.0f);
        aZkASS.A5SV6n(0.0f, this.f6653A2egSU, this.f6654A4TApA);
    }
}
