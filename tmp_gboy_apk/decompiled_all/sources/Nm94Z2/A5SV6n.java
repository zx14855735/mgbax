package Nm94Z2;

import C4FrIb.B4ZgIw;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A5SV6n extends AMqCpz {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public B4ZgIw f6054AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public OverScroller f6055AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f6056B25kr6;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f6058B3GDIM;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public VelocityTracker f6060B7CMnp;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f6057B2KMhB = -1;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f6059B4ZgIw = -1;

    public boolean AYUAbz(View view) {
        return false;
    }

    public int AZOQYO(View view) {
        return -view.getHeight();
    }

    public int AZkASS(View view) {
        return view.getHeight();
    }

    public void AaHO0E(CoordinatorLayout coordinatorLayout, View view) {
    }

    public int AcNBzu(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        int B3GDIM2;
        int AMqCpz = AMqCpz();
        if (i2 == 0 || AMqCpz < i2 || AMqCpz > i3 || AMqCpz == (B3GDIM2 = com.bumptech.glide.AMqCpz.B3GDIM(i, i2, i3))) {
            return 0;
        }
        ARc23Z aRc23Z = this.f6065AcNBzu;
        if (aRc23Z == null) {
            this.f6066AlLFFp = B3GDIM2;
        } else if (aRc23Z.f6070ADYaiT != B3GDIM2) {
            aRc23Z.f6070ADYaiT = B3GDIM2;
            aRc23Z.A2egSU();
        }
        return AMqCpz - B3GDIM2;
    }

    public final void AlLFFp(CoordinatorLayout coordinatorLayout, View view, int i) {
        AcNBzu(coordinatorLayout, view, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f6059B4ZgIw < 0) {
            this.f6059B4ZgIw = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f6056B25kr6) {
            int i = this.f6057B2KMhB;
            if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                int y = (int) motionEvent.getY(findPointerIndex);
                if (Math.abs(y - this.f6058B3GDIM) > this.f6059B4ZgIw) {
                    this.f6058B3GDIM = y;
                    return true;
                }
            }
            return false;
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f6057B2KMhB = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            boolean z = AYUAbz(view) && coordinatorLayout.AYUAbz(view, x, y2);
            this.f6056B25kr6 = z;
            if (z) {
                this.f6058B3GDIM = y2;
                this.f6057B2KMhB = motionEvent.getPointerId(0);
                if (this.f6060B7CMnp == null) {
                    this.f6060B7CMnp = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.f6055AzWtSf;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f6055AzWtSf.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f6060B7CMnp;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00da A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ca  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r19, android.view.View r20, android.view.MotionEvent r21) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Nm94Z2.A5SV6n.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }
}
