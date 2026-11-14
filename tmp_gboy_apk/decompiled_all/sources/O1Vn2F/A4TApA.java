package O1Vn2F;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends CqNSpT.AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f6150A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout.A2egSU f6151A4TApA;

    public /* synthetic */ A4TApA(CoordinatorLayout.A2egSU a2egSU, int i) {
        this.f6150A2egSU = i;
        this.f6151A4TApA = a2egSU;
    }

    @Override // CqNSpT.AMqCpz
    public final int A2egSU(int i, View view) {
        switch (this.f6150A2egSU) {
            case 0:
                return view.getLeft();
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f6151A4TApA;
                return com.bumptech.glide.AMqCpz.B3GDIM(i, sideSheetBehavior.f11788AcNBzu.BmvVmW(), sideSheetBehavior.f11788AcNBzu.BV3sI0());
        }
    }

    @Override // CqNSpT.AMqCpz
    public final int A4TApA(int i, View view) {
        switch (this.f6150A2egSU) {
            case 0:
                return com.bumptech.glide.AMqCpz.B3GDIM(i, ((BottomSheetBehavior) this.f6151A4TApA).AlLFFp(), ADYaiT());
            default:
                return view.getTop();
        }
    }

    @Override // CqNSpT.AMqCpz
    public int A5SV6n(View view) {
        switch (this.f6150A2egSU) {
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f6151A4TApA;
                return sideSheetBehavior.f11799BI9f7h + sideSheetBehavior.f11802BNL6CD;
            default:
                return super.A5SV6n(view);
        }
    }

    @Override // CqNSpT.AMqCpz
    public int ADYaiT() {
        switch (this.f6150A2egSU) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f6151A4TApA;
                return bottomSheetBehavior.f11422CqNSpT ? bottomSheetBehavior.f11435DUi7mC : bottomSheetBehavior.f11420CkXcdM;
            default:
                return super.ADYaiT();
        }
    }

    @Override // CqNSpT.AMqCpz
    public final void AYUAbz(int i) {
        switch (this.f6150A2egSU) {
            case 0:
                if (i == 1) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f6151A4TApA;
                    if (bottomSheetBehavior.f11424CtFAbx) {
                        bottomSheetBehavior.B2KMhB(1);
                        break;
                    }
                }
                break;
            default:
                if (i == 1) {
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f6151A4TApA;
                    if (sideSheetBehavior.f11794B3GDIM) {
                        sideSheetBehavior.AMqCpz(1);
                        break;
                    }
                }
                break;
        }
    }

    @Override // CqNSpT.AMqCpz
    public final void AZOQYO(View view, int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        switch (this.f6150A2egSU) {
            case 0:
                ((BottomSheetBehavior) this.f6151A4TApA).AZOQYO(i2);
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f6151A4TApA;
                WeakReference weakReference = sideSheetBehavior.f11804BTvldC;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
                    sideSheetBehavior.f11788AcNBzu.De4eam(marginLayoutParams, view.getLeft(), view.getRight());
                    view2.setLayoutParams(marginLayoutParams);
                }
                LinkedHashSet linkedHashSet = sideSheetBehavior.f11808C2rE4F;
                if (!linkedHashSet.isEmpty()) {
                    sideSheetBehavior.f11788AcNBzu.B25kr6(i);
                    Iterator it = linkedHashSet.iterator();
                    while (it.hasNext()) {
                        ((PMC23c.AMqCpz) it.next()).A2egSU();
                    }
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
    
        if (r0.f11788AcNBzu.CcAIMM(r6) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
    
        if (java.lang.Math.abs(r7 - r0.f11788AcNBzu.BIYEnU()) < java.lang.Math.abs(r7 - r0.f11788AcNBzu.BJ7GGh())) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
    
        if (r7 > r2.f11418Cd8JRx) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d0, code lost:
    
        if (java.lang.Math.abs(r6.getTop() - r2.AlLFFp()) < java.lang.Math.abs(r6.getTop() - r2.f11418Cd8JRx)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x011b, code lost:
    
        if (java.lang.Math.abs(r7 - r2.f11417CcAIMM) < java.lang.Math.abs(r7 - r2.f11420CkXcdM)) goto L29;
     */
    @Override // CqNSpT.AMqCpz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AZkASS(android.view.View r6, float r7, float r8) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: O1Vn2F.A4TApA.AZkASS(android.view.View, float, float):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0045, code lost:
    
        if (r6.canScrollVertically(-1) != false) goto L36;
     */
    @Override // CqNSpT.AMqCpz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean AaHO0E(android.view.View r5, int r6) {
        /*
            r4 = this;
            int r0 = r4.f6150A2egSU
            switch(r0) {
                case 0: goto L1c;
                default: goto L5;
            }
        L5:
            androidx.coordinatorlayout.widget.CoordinatorLayout$A2egSU r6 = r4.f6151A4TApA
            com.google.android.material.sidesheet.SideSheetBehavior r6 = (com.google.android.material.sidesheet.SideSheetBehavior) r6
            int r0 = r6.f11795B4ZgIw
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L10
            goto L1b
        L10:
            java.lang.ref.WeakReference r6 = r6.f11803BPw6Q8
            if (r6 == 0) goto L1b
            java.lang.Object r6 = r6.get()
            if (r6 != r5) goto L1b
            r1 = 1
        L1b:
            return r1
        L1c:
            androidx.coordinatorlayout.widget.CoordinatorLayout$A2egSU r0 = r4.f6151A4TApA
            com.google.android.material.bottomsheet.BottomSheetBehavior r0 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r0
            int r1 = r0.f11427D6DOie
            r2 = 1
            if (r1 != r2) goto L26
            goto L56
        L26:
            boolean r3 = r0.f11443Dphsd2
            if (r3 == 0) goto L2b
            goto L56
        L2b:
            r3 = 3
            if (r1 != r3) goto L48
            int r1 = r0.f11441De4eam
            if (r1 != r6) goto L48
            java.lang.ref.WeakReference r6 = r0.f11438DaOi9o
            if (r6 == 0) goto L3d
            java.lang.Object r6 = r6.get()
            android.view.View r6 = (android.view.View) r6
            goto L3e
        L3d:
            r6 = 0
        L3e:
            if (r6 == 0) goto L48
            r1 = -1
            boolean r6 = r6.canScrollVertically(r1)
            if (r6 == 0) goto L48
            goto L56
        L48:
            android.os.SystemClock.uptimeMillis()
            java.lang.ref.WeakReference r6 = r0.f11436DV2E8K
            if (r6 == 0) goto L56
            java.lang.Object r6 = r6.get()
            if (r6 != r5) goto L56
            goto L57
        L56:
            r2 = 0
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: O1Vn2F.A4TApA.AaHO0E(android.view.View, int):boolean");
    }
}
