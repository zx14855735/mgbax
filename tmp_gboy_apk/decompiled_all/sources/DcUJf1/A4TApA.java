package DcUJf1;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends Animatable2.AnimationCallback {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ A5SV6n f2314A2egSU;

    public A4TApA(A5SV6n a5SV6n) {
        this.f2314A2egSU = a5SV6n;
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        this.f2314A2egSU.A2egSU(drawable);
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationStart(Drawable drawable) {
        this.f2314A2egSU.A4TApA(drawable);
    }
}
