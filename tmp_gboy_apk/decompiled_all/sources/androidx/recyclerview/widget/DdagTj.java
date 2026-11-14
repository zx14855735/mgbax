package androidx.recyclerview.widget;

import android.view.animation.Interpolator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DdagTj {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f9361A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f9362A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f9363A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f9364ADYaiT;
    public Interpolator AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f9365ARc23Z;

    public final void A2egSU(RecyclerView recyclerView) {
        int i = this.f9364ADYaiT;
        if (i >= 0) {
            this.f9364ADYaiT = -1;
            recyclerView.jumpToPositionForSmoothScroller(i);
            this.f9365ARc23Z = false;
        } else if (this.f9365ARc23Z) {
            Interpolator interpolator = this.AMqCpz;
            if (interpolator != null && this.f9363A5SV6n < 1) {
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            }
            int i2 = this.f9363A5SV6n;
            if (i2 < 1) {
                throw new IllegalStateException("Scroll duration must be a positive number");
            }
            recyclerView.mViewFlinger.A5SV6n(this.f9361A2egSU, this.f9362A4TApA, i2, interpolator);
            this.f9365ARc23Z = false;
        }
    }

    public void update(int i, int i2, int i3, Interpolator interpolator) {
        this.f9361A2egSU = i;
        this.f9362A4TApA = i2;
        this.f9363A5SV6n = i3;
        this.AMqCpz = interpolator;
        this.f9365ARc23Z = true;
    }
}
