package ARc23Z;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n extends com.bumptech.glide.A5SV6n {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final ObjectAnimator f278B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final boolean f279B7CMnp;

    public A5SV6n(AnimationDrawable animationDrawable, boolean z, boolean z2) {
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        int i = z ? numberOfFrames - 1 : 0;
        int i2 = z ? 0 : numberOfFrames - 1;
        ADYaiT aDYaiT = new ADYaiT();
        int numberOfFrames2 = animationDrawable.getNumberOfFrames();
        aDYaiT.f281A4TApA = numberOfFrames2;
        int[] iArr = aDYaiT.f280A2egSU;
        if (iArr == null || iArr.length < numberOfFrames2) {
            aDYaiT.f280A2egSU = new int[numberOfFrames2];
        }
        int[] iArr2 = aDYaiT.f280A2egSU;
        int i3 = 0;
        for (int i4 = 0; i4 < numberOfFrames2; i4++) {
            int duration = animationDrawable.getDuration(z ? (numberOfFrames2 - i4) - 1 : i4);
            iArr2[i4] = duration;
            i3 += duration;
        }
        aDYaiT.f282A5SV6n = i3;
        ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
        ofInt.setAutoCancel(true);
        ofInt.setDuration(aDYaiT.f282A5SV6n);
        ofInt.setInterpolator(aDYaiT);
        this.f279B7CMnp = z2;
        this.f278B4ZgIw = ofInt;
    }

    @Override // com.bumptech.glide.A5SV6n
    public final boolean B2KMhB() {
        return this.f279B7CMnp;
    }

    @Override // com.bumptech.glide.A5SV6n
    public final void D6yqiO() {
        this.f278B4ZgIw.reverse();
    }

    @Override // com.bumptech.glide.A5SV6n
    public final void DV2E8K() {
        this.f278B4ZgIw.start();
    }

    @Override // com.bumptech.glide.A5SV6n
    public final void DXnQ0V() {
        this.f278B4ZgIw.cancel();
    }
}
