package androidx.fragment.app;

import com.sigmob.sdk.base.views.r;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends DXuj49 implements D6DOie {

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final CtxOCS f8702B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f8703B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f8704B7CMnp;

    public A2egSU(CtxOCS ctxOCS) {
        ctxOCS.BpkvW3();
        CQhlFr cQhlFr = ctxOCS.f8847B7CMnp;
        if (cQhlFr != null) {
            cQhlFr.getContext().getClassLoader();
        }
        this.f8917A2egSU = new ArrayList();
        this.f8923AYUAbz = true;
        this.f8931B25kr6 = false;
        this.f8704B7CMnp = -1;
        this.f8702B3GDIM = ctxOCS;
    }

    @Override // androidx.fragment.app.D6DOie
    public final boolean A2egSU(ArrayList arrayList, ArrayList arrayList2) {
        if (CtxOCS.C4FrIb(2)) {
            toString();
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f8922ASJ6gh) {
            return true;
        }
        CtxOCS ctxOCS = this.f8702B3GDIM;
        if (ctxOCS.f8832ADYaiT == null) {
            ctxOCS.f8832ADYaiT = new ArrayList();
        }
        ctxOCS.f8832ADYaiT.add(this);
        return true;
    }

    @Override // androidx.fragment.app.DXuj49
    public final int A5SV6n() {
        return B2KMhB(false);
    }

    @Override // androidx.fragment.app.DXuj49
    public final int ADYaiT() {
        return B2KMhB(true);
    }

    @Override // androidx.fragment.app.DXuj49
    public final void AMqCpz() {
        AYUAbz();
        this.f8702B3GDIM.BJ7GGh(this, false);
    }

    @Override // androidx.fragment.app.DXuj49
    public final void ARc23Z() {
        AYUAbz();
        this.f8702B3GDIM.BJ7GGh(this, true);
    }

    @Override // androidx.fragment.app.DXuj49
    public final void ASJ6gh(Fragment fragment) {
        CtxOCS ctxOCS = fragment.mFragmentManager;
        if (ctxOCS == null || ctxOCS == this.f8702B3GDIM) {
            super.ASJ6gh(fragment);
            return;
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.DXuj49
    public final void AZOQYO(int i, Fragment fragment, String str, int i2) {
        super.AZOQYO(i, fragment, str, i2);
        fragment.mFragmentManager = this.f8702B3GDIM;
    }

    @Override // androidx.fragment.app.DXuj49
    public final void AZkASS(Fragment fragment) {
        CtxOCS ctxOCS = fragment.mFragmentManager;
        if (ctxOCS == null || ctxOCS == this.f8702B3GDIM) {
            super.AZkASS(fragment);
            return;
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.DXuj49
    public final boolean AaHO0E() {
        return this.f8917A2egSU.isEmpty();
    }

    @Override // androidx.fragment.app.DXuj49
    public final void AcNBzu(Fragment fragment) {
        CtxOCS ctxOCS = fragment.mFragmentManager;
        if (ctxOCS == null || ctxOCS == this.f8702B3GDIM) {
            super.AcNBzu(fragment);
            return;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.DXuj49
    public final void AmA8tU(Fragment fragment) {
        CtxOCS ctxOCS;
        if (fragment == null || (ctxOCS = fragment.mFragmentManager) == null || ctxOCS == this.f8702B3GDIM) {
            super.AmA8tU(fragment);
            return;
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.DXuj49
    public final void AzWtSf(Fragment fragment) {
        CtxOCS ctxOCS = fragment.mFragmentManager;
        if (ctxOCS == null || ctxOCS == this.f8702B3GDIM) {
            super.AzWtSf(fragment);
            return;
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public final void B25kr6(int i) {
        if (this.f8922ASJ6gh) {
            if (CtxOCS.C4FrIb(2)) {
                toString();
            }
            ArrayList arrayList = this.f8917A2egSU;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                DXnQ0V dXnQ0V = (DXnQ0V) arrayList.get(i2);
                Fragment fragment = dXnQ0V.f8910A4TApA;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    if (CtxOCS.C4FrIb(2)) {
                        Objects.toString(dXnQ0V.f8910A4TApA);
                        int i3 = dXnQ0V.f8910A4TApA.mBackStackNesting;
                    }
                }
            }
        }
    }

    public final int B2KMhB(boolean z) {
        if (this.f8703B4ZgIw) {
            throw new IllegalStateException("commit already called");
        }
        if (CtxOCS.C4FrIb(2)) {
            toString();
            PrintWriter printWriter = new PrintWriter(new QkAq4X.AMqCpz(1));
            B3GDIM("  ", printWriter, true);
            printWriter.close();
        }
        this.f8703B4ZgIw = true;
        boolean z2 = this.f8922ASJ6gh;
        CtxOCS ctxOCS = this.f8702B3GDIM;
        if (z2) {
            this.f8704B7CMnp = ctxOCS.f8836AZOQYO.getAndIncrement();
        } else {
            this.f8704B7CMnp = -1;
        }
        ctxOCS.BChYOn(this, z);
        return this.f8704B7CMnp;
    }

    public final void B3GDIM(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f8924AZOQYO);
            printWriter.print(" mIndex=");
            printWriter.print(this.f8704B7CMnp);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f8703B4ZgIw);
            if (this.f8921ARc23Z != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f8921ARc23Z));
            }
            if (this.f8918A4TApA != 0 || this.f8919A5SV6n != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f8918A4TApA));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f8919A5SV6n));
            }
            if (this.f8920ADYaiT != 0 || this.AMqCpz != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f8920ADYaiT));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.AMqCpz));
            }
            if (this.f8925AZkASS != 0 || this.f8926AaHO0E != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f8925AZkASS));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f8926AaHO0E);
            }
            if (this.f8927AcNBzu != 0 || this.f8928AlLFFp != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f8927AcNBzu));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f8928AlLFFp);
            }
        }
        ArrayList arrayList = this.f8917A2egSU;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            DXnQ0V dXnQ0V = (DXnQ0V) arrayList.get(i);
            switch (dXnQ0V.f8909A2egSU) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + dXnQ0V.f8909A2egSU;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(dXnQ0V.f8910A4TApA);
            if (z) {
                if (dXnQ0V.f8912ADYaiT != 0 || dXnQ0V.AMqCpz != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(dXnQ0V.f8912ADYaiT));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(dXnQ0V.AMqCpz));
                }
                if (dXnQ0V.f8913ARc23Z != 0 || dXnQ0V.f8914ASJ6gh != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(dXnQ0V.f8913ARc23Z));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(dXnQ0V.f8914ASJ6gh));
                }
            }
        }
    }

    public final void B4ZgIw(Fragment fragment, androidx.lifecycle.AmA8tU amA8tU) {
        CtxOCS ctxOCS = fragment.mFragmentManager;
        CtxOCS ctxOCS2 = this.f8702B3GDIM;
        if (ctxOCS != ctxOCS2) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + ctxOCS2);
        }
        if (amA8tU == androidx.lifecycle.AmA8tU.f8978AlLFFp && fragment.mState > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + amA8tU + " after the Fragment has been created");
        }
        if (amA8tU == androidx.lifecycle.AmA8tU.f8977AcNBzu) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + amA8tU + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
        DXnQ0V dXnQ0V = new DXnQ0V();
        dXnQ0V.f8909A2egSU = 10;
        dXnQ0V.f8910A4TApA = fragment;
        dXnQ0V.f8911A5SV6n = false;
        dXnQ0V.f8915AYUAbz = fragment.mMaxState;
        dXnQ0V.f8916AZOQYO = amA8tU;
        A4TApA(dXnQ0V);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(r.b.d);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f8704B7CMnp >= 0) {
            sb.append(" #");
            sb.append(this.f8704B7CMnp);
        }
        if (this.f8924AZOQYO != null) {
            sb.append(" ");
            sb.append(this.f8924AZOQYO);
        }
        sb.append("}");
        return sb.toString();
    }
}
