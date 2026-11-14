package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CASmeH extends AnimationSet implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ViewGroup f8805AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final View f8806AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f8807AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f8808AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f8809B25kr6;

    public CASmeH(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f8809B25kr6 = true;
        this.f8805AcNBzu = viewGroup;
        this.f8806AlLFFp = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j, Transformation transformation) {
        this.f8809B25kr6 = true;
        if (this.f8807AmA8tU) {
            return !this.f8808AzWtSf;
        }
        if (!super.getTransformation(j, transformation)) {
            this.f8807AmA8tU = true;
            COJEAR.BV3sI0.A4TApA(this.f8805AcNBzu, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.f8807AmA8tU;
        ViewGroup viewGroup = this.f8805AcNBzu;
        if (z || !this.f8809B25kr6) {
            viewGroup.endViewTransition(this.f8806AlLFFp);
            this.f8808AzWtSf = true;
        } else {
            this.f8809B25kr6 = false;
            viewGroup.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j, Transformation transformation, float f) {
        this.f8809B25kr6 = true;
        if (this.f8807AmA8tU) {
            return !this.f8808AzWtSf;
        }
        if (!super.getTransformation(j, transformation, f)) {
            this.f8807AmA8tU = true;
            COJEAR.BV3sI0.A4TApA(this.f8805AcNBzu, this);
        }
        return true;
    }
}
