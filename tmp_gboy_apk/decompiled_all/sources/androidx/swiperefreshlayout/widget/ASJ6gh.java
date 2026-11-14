package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh extends Animation {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f9524AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f9525AlLFFp;

    public /* synthetic */ ASJ6gh(SwipeRefreshLayout swipeRefreshLayout, int i) {
        this.f9524AcNBzu = i;
        this.f9525AlLFFp = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f, Transformation transformation) {
        switch (this.f9524AcNBzu) {
            case 0:
                SwipeRefreshLayout swipeRefreshLayout = this.f9525AlLFFp;
                int abs = !swipeRefreshLayout.mUsingCustomStart ? swipeRefreshLayout.mSpinnerOffsetEnd - Math.abs(swipeRefreshLayout.mOriginalOffsetTop) : swipeRefreshLayout.mSpinnerOffsetEnd;
                swipeRefreshLayout.setTargetOffsetTopAndBottom((swipeRefreshLayout.mFrom + ((int) ((abs - r1) * f))) - swipeRefreshLayout.mCircleView.getTop());
                ADYaiT aDYaiT = swipeRefreshLayout.mProgress;
                float f2 = 1.0f - f;
                A5SV6n a5SV6n = aDYaiT.f9513AcNBzu;
                if (f2 != a5SV6n.f9504B25kr6) {
                    a5SV6n.f9504B25kr6 = f2;
                }
                aDYaiT.invalidateSelf();
                break;
            case 1:
                SwipeRefreshLayout swipeRefreshLayout2 = this.f9525AlLFFp;
                float f3 = swipeRefreshLayout2.mStartingScale;
                swipeRefreshLayout2.setAnimationProgress(((-f3) * f) + f3);
                swipeRefreshLayout2.moveToStart(f);
                break;
            case 2:
                this.f9525AlLFFp.setAnimationProgress(f);
                break;
            case 3:
                this.f9525AlLFFp.setAnimationProgress(1.0f - f);
                break;
            default:
                this.f9525AlLFFp.moveToStart(f);
                break;
        }
    }
}
