package COJEAR;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BChYOn {

    /* renamed from: A2egSU, reason: collision with root package name */
    public ViewParent f1644A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ViewParent f1645A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ViewGroup f1646A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f1647ADYaiT;
    public int[] AMqCpz;

    public BChYOn(ViewGroup viewGroup) {
        this.f1646A5SV6n = viewGroup;
    }

    public final boolean A2egSU(float f, float f2, boolean z) {
        ViewParent AMqCpz;
        if (this.f1647ADYaiT && (AMqCpz = AMqCpz(0)) != null) {
            try {
                return DdagTj.A2egSU(AMqCpz, this.f1646A5SV6n, f, f2, z);
            } catch (AbstractMethodError unused) {
                Objects.toString(AMqCpz);
            }
        }
        return false;
    }

    public final boolean A4TApA(float f, float f2) {
        ViewParent AMqCpz;
        if (this.f1647ADYaiT && (AMqCpz = AMqCpz(0)) != null) {
            try {
                return DdagTj.A4TApA(AMqCpz, this.f1646A5SV6n, f, f2);
            } catch (AbstractMethodError unused) {
                Objects.toString(AMqCpz);
            }
        }
        return false;
    }

    public final boolean A5SV6n(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent AMqCpz;
        int i4;
        int i5;
        if (!this.f1647ADYaiT || (AMqCpz = AMqCpz(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        ViewGroup viewGroup = this.f1646A5SV6n;
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.AMqCpz == null) {
                this.AMqCpz = new int[2];
            }
            iArr = this.AMqCpz;
        }
        int[] iArr3 = iArr;
        iArr3[0] = 0;
        iArr3[1] = 0;
        if (AMqCpz instanceof BI9f7h) {
            ((BI9f7h) AMqCpz).onNestedPreScroll(viewGroup, i, i2, iArr3, i3);
        } else if (i3 == 0) {
            try {
                DdagTj.A5SV6n(AMqCpz, viewGroup, i, i2, iArr3);
            } catch (AbstractMethodError unused) {
                Objects.toString(AMqCpz);
            }
        }
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean ADYaiT(int r14, int r15, int r16, int r17, int[] r18, int r19, int[] r20) {
        /*
            r13 = this;
            r0 = r18
            r7 = r19
            boolean r1 = r13.f1647ADYaiT
            r9 = 0
            if (r1 == 0) goto L99
            android.view.ViewParent r2 = r13.AMqCpz(r7)
            if (r2 != 0) goto L11
            goto L99
        L11:
            r10 = 1
            if (r14 != 0) goto L22
            if (r15 != 0) goto L22
            if (r16 != 0) goto L22
            if (r17 == 0) goto L1b
            goto L22
        L1b:
            if (r0 == 0) goto L99
            r0[r9] = r9
            r0[r10] = r9
            return r9
        L22:
            android.view.ViewGroup r3 = r13.f1646A5SV6n
            if (r0 == 0) goto L30
            r3.getLocationInWindow(r0)
            r1 = r0[r9]
            r4 = r0[r10]
            r11 = r1
            r12 = r4
            goto L32
        L30:
            r11 = 0
            r12 = 0
        L32:
            if (r20 != 0) goto L45
            int[] r1 = r13.AMqCpz
            if (r1 != 0) goto L3d
            r1 = 2
            int[] r1 = new int[r1]
            r13.AMqCpz = r1
        L3d:
            int[] r1 = r13.AMqCpz
            r1[r9] = r9
            r1[r10] = r9
            r8 = r1
            goto L47
        L45:
            r8 = r20
        L47:
            boolean r1 = r2 instanceof COJEAR.BIYEnU
            if (r1 == 0) goto L5a
            r1 = r2
            COJEAR.BIYEnU r1 = (COJEAR.BIYEnU) r1
            r4 = r15
            r5 = r16
            r6 = r17
            r2 = r3
            r3 = r14
            r1.onNestedScroll(r2, r3, r4, r5, r6, r7, r8)
        L58:
            r3 = r2
            goto L89
        L5a:
            r1 = r8[r9]
            int r1 = r1 + r16
            r8[r9] = r1
            r1 = r8[r10]
            int r1 = r1 + r17
            r8[r10] = r1
            boolean r1 = r2 instanceof COJEAR.BI9f7h
            if (r1 == 0) goto L7a
            r1 = r2
            COJEAR.BI9f7h r1 = (COJEAR.BI9f7h) r1
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r19
            r2 = r3
            r3 = r14
            r1.onNestedScroll(r2, r3, r4, r5, r6, r7)
            goto L58
        L7a:
            if (r19 != 0) goto L89
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            COJEAR.DdagTj.ADYaiT(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.AbstractMethodError -> L86
            goto L89
        L86:
            java.util.Objects.toString(r2)
        L89:
            if (r0 == 0) goto L98
            r3.getLocationInWindow(r0)
            r14 = r0[r9]
            int r14 = r14 - r11
            r0[r9] = r14
            r14 = r0[r10]
            int r14 = r14 - r12
            r0[r10] = r14
        L98:
            return r10
        L99:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: COJEAR.BChYOn.ADYaiT(int, int, int, int, int[], int, int[]):boolean");
    }

    public final ViewParent AMqCpz(int i) {
        if (i == 0) {
            return this.f1644A2egSU;
        }
        if (i != 1) {
            return null;
        }
        return this.f1645A4TApA;
    }

    public final boolean ARc23Z(int i) {
        return AMqCpz(i) != null;
    }

    public final void ASJ6gh(boolean z) {
        if (this.f1647ADYaiT) {
            WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
            CmUvjW.BNL6CD(this.f1646A5SV6n);
        }
        this.f1647ADYaiT = z;
    }

    public final boolean AYUAbz(int i, int i2) {
        boolean ARc23Z2;
        if (!ARc23Z(i2)) {
            if (this.f1647ADYaiT) {
                ViewGroup viewGroup = this.f1646A5SV6n;
                View view = viewGroup;
                for (ViewParent parent = viewGroup.getParent(); parent != null; parent = parent.getParent()) {
                    boolean z = parent instanceof BI9f7h;
                    if (z) {
                        ARc23Z2 = ((BI9f7h) parent).onStartNestedScroll(view, viewGroup, i, i2);
                    } else {
                        if (i2 == 0) {
                            try {
                                ARc23Z2 = DdagTj.ARc23Z(parent, view, viewGroup, i);
                            } catch (AbstractMethodError unused) {
                                Objects.toString(parent);
                            }
                        }
                        ARc23Z2 = false;
                    }
                    if (ARc23Z2) {
                        if (i2 == 0) {
                            this.f1644A2egSU = parent;
                        } else if (i2 == 1) {
                            this.f1645A4TApA = parent;
                        }
                        if (z) {
                            ((BI9f7h) parent).onNestedScrollAccepted(view, viewGroup, i, i2);
                        } else if (i2 == 0) {
                            try {
                                DdagTj.AMqCpz(parent, view, viewGroup, i);
                            } catch (AbstractMethodError unused2) {
                                Objects.toString(parent);
                            }
                        }
                    } else {
                        if (parent instanceof View) {
                            view = (View) parent;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void AZOQYO(int i) {
        ViewParent AMqCpz = AMqCpz(i);
        if (AMqCpz != null) {
            boolean z = AMqCpz instanceof BI9f7h;
            ViewGroup viewGroup = this.f1646A5SV6n;
            if (z) {
                ((BI9f7h) AMqCpz).onStopNestedScroll(viewGroup, i);
            } else if (i == 0) {
                try {
                    DdagTj.ASJ6gh(AMqCpz, viewGroup);
                } catch (AbstractMethodError unused) {
                    Objects.toString(AMqCpz);
                }
            }
            if (i == 0) {
                this.f1644A2egSU = null;
            } else {
                if (i != 1) {
                    return;
                }
                this.f1645A4TApA = null;
            }
        }
    }
}
