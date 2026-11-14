package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z extends Animation {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f9521AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f9522AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f9523AmA8tU;

    public ARc23Z(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
        this.f9523AmA8tU = swipeRefreshLayout;
        this.f9521AcNBzu = i;
        this.f9522AlLFFp = i2;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f, Transformation transformation) {
        this.f9523AmA8tU.mProgress.setAlpha((int) (((this.f9522AlLFFp - r0) * f) + this.f9521AcNBzu));
    }
}
