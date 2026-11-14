package NrhEUx;

import CqNSpT.AMqCpz;
import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f6130A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f6131A4TApA = -1;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f6132A5SV6n;

    public A5SV6n(SwipeDismissBehavior swipeDismissBehavior) {
        this.f6132A5SV6n = swipeDismissBehavior;
    }

    @Override // CqNSpT.AMqCpz
    public final int A2egSU(int i, View view) {
        int width;
        int width2;
        int width3;
        boolean z = view.getLayoutDirection() == 1;
        int i2 = this.f6132A5SV6n.f11345AzWtSf;
        if (i2 == 0) {
            if (z) {
                width = this.f6130A2egSU - view.getWidth();
                width2 = this.f6130A2egSU;
            } else {
                width = this.f6130A2egSU;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i2 != 1) {
            width = this.f6130A2egSU - view.getWidth();
            width2 = view.getWidth() + this.f6130A2egSU;
        } else if (z) {
            width = this.f6130A2egSU;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.f6130A2egSU - view.getWidth();
            width2 = this.f6130A2egSU;
        }
        return Math.min(Math.max(width, i), width2);
    }

    @Override // CqNSpT.AMqCpz
    public final int A4TApA(int i, View view) {
        return view.getTop();
    }

    @Override // CqNSpT.AMqCpz
    public final int A5SV6n(View view) {
        return view.getWidth();
    }

    @Override // CqNSpT.AMqCpz
    public final void ASJ6gh(int i, View view) {
        this.f6131A4TApA = i;
        this.f6130A2egSU = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.f6132A5SV6n;
            swipeDismissBehavior.f11344AmA8tU = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.f11344AmA8tU = false;
        }
    }

    @Override // CqNSpT.AMqCpz
    public final void AYUAbz(int i) {
    }

    @Override // CqNSpT.AMqCpz
    public final void AZOQYO(View view, int i, int i2) {
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.f6132A5SV6n;
        float f = width * swipeDismissBehavior.f11347B2KMhB;
        float width2 = view.getWidth() * swipeDismissBehavior.f11348B3GDIM;
        float abs = Math.abs(i - this.f6130A2egSU);
        if (abs <= f) {
            view.setAlpha(1.0f);
        } else if (abs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((abs - f) / (width2 - f))), 1.0f));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004f, code lost:
    
        if (java.lang.Math.abs(r9.getLeft() - r8.f6130A2egSU) >= java.lang.Math.round(r9.getWidth() * r0.f11346B25kr6)) goto L27;
     */
    @Override // CqNSpT.AMqCpz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AZkASS(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.f6131A4TApA = r11
            int r11 = r9.getWidth()
            com.google.android.material.behavior.SwipeDismissBehavior r0 = r8.f6132A5SV6n
            r1 = 0
            r2 = 1
            r3 = 0
            int r4 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r4 == 0) goto L37
            int r5 = r9.getLayoutDirection()
            if (r5 != r2) goto L18
            r5 = 1
            goto L19
        L18:
            r5 = 0
        L19:
            int r6 = r0.f11345AzWtSf
            r7 = 2
            if (r6 != r7) goto L1f
            goto L51
        L1f:
            if (r6 != 0) goto L2b
            if (r5 == 0) goto L28
            int r4 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r4 >= 0) goto L65
            goto L51
        L28:
            if (r4 <= 0) goto L65
            goto L51
        L2b:
            if (r6 != r2) goto L65
            if (r5 == 0) goto L32
            if (r4 <= 0) goto L65
            goto L51
        L32:
            int r4 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r4 >= 0) goto L65
            goto L51
        L37:
            int r4 = r9.getLeft()
            int r5 = r8.f6130A2egSU
            int r4 = r4 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            float r6 = r0.f11346B25kr6
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r4 = java.lang.Math.abs(r4)
            if (r4 < r5) goto L65
        L51:
            int r10 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r10 < 0) goto L60
            int r10 = r9.getLeft()
            int r1 = r8.f6130A2egSU
            if (r10 >= r1) goto L5e
            goto L60
        L5e:
            int r1 = r1 + r11
            goto L68
        L60:
            int r10 = r8.f6130A2egSU
            int r1 = r10 - r11
            goto L68
        L65:
            int r1 = r8.f6130A2egSU
            r2 = 0
        L68:
            CqNSpT.ARc23Z r10 = r0.f11342AcNBzu
            int r11 = r9.getTop()
            boolean r10 = r10.B25kr6(r1, r11)
            if (r10 == 0) goto L7c
            MOpbMP.A2egSU r10 = new MOpbMP.A2egSU
            r10.<init>(r0, r9, r2)
            r9.postOnAnimation(r10)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: NrhEUx.A5SV6n.AZkASS(android.view.View, float, float):void");
    }

    @Override // CqNSpT.AMqCpz
    public final boolean AaHO0E(View view, int i) {
        int i2 = this.f6131A4TApA;
        return (i2 == -1 || i2 == i) && this.f6132A5SV6n.AMqCpz(view);
    }
}
