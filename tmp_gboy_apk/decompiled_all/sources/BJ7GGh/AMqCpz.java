package BJ7GGh;

import BChYOn.AcNBzu;
import BChYOn.AlLFFp;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ConstraintLayout f1407A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f1408A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f1409A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f1410ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f1411ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f1412ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final /* synthetic */ ConstraintLayout f1413AYUAbz;

    public AMqCpz(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.f1413AYUAbz = constraintLayout;
        this.f1407A2egSU = constraintLayout2;
    }

    public static boolean A2egSU(int i, int i2, int i3) {
        if (i == i2) {
            return true;
        }
        int mode = View.MeasureSpec.getMode(i);
        View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode2 == 1073741824) {
            return (mode == Integer.MIN_VALUE || mode == 0) && i3 == size;
        }
        return false;
    }

    public final void A4TApA(BChYOn.ARc23Z aRc23Z, BI9f7h.A4TApA a4TApA) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int max;
        int i;
        boolean z;
        int measuredWidth;
        int baseline;
        int i2;
        if (aRc23Z == null) {
            return;
        }
        if (aRc23Z.f1188DV2E8K == 8) {
            a4TApA.AMqCpz = 0;
            a4TApA.f1280ARc23Z = 0;
            a4TApA.f1281ASJ6gh = 0;
            return;
        }
        if (aRc23Z.f1175CrfGsy == null) {
            return;
        }
        int i3 = a4TApA.f1276A2egSU;
        int i4 = a4TApA.f1277A4TApA;
        int i5 = a4TApA.f1278A5SV6n;
        int i6 = a4TApA.f1279ADYaiT;
        int i7 = this.f1408A4TApA + this.f1409A5SV6n;
        int i8 = this.f1410ADYaiT;
        View view = aRc23Z.f1187DUi7mC;
        int ADYaiT2 = B4ZgIw.AYUAbz.ADYaiT(i3);
        BChYOn.AMqCpz aMqCpz = aRc23Z.f1166CQhlFr;
        BChYOn.AMqCpz aMqCpz2 = aRc23Z.f1164CNPG0E;
        if (ADYaiT2 == 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        } else if (ADYaiT2 == 1) {
            makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f1411ARc23Z, i8, -2);
        } else if (ADYaiT2 == 2) {
            makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f1411ARc23Z, i8, -2);
            boolean z2 = aRc23Z.f1148B4ZgIw == 1;
            int i9 = a4TApA.f1284AZkASS;
            if (i9 == 1 || i9 == 2) {
                boolean z3 = view.getMeasuredHeight() == aRc23Z.AaHO0E();
                if (a4TApA.f1284AZkASS == 2 || !z2 || ((z2 && z3) || aRc23Z.BPw6Q8())) {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(aRc23Z.B2KMhB(), 1073741824);
                }
            }
        } else if (ADYaiT2 != 3) {
            makeMeasureSpec = 0;
        } else {
            int i10 = this.f1411ARc23Z;
            int i11 = aMqCpz2 != null ? aMqCpz2.f1128ASJ6gh : 0;
            if (aMqCpz != null) {
                i11 += aMqCpz.f1128ASJ6gh;
            }
            makeMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i8 + i11, -1);
        }
        int ADYaiT3 = B4ZgIw.AYUAbz.ADYaiT(i4);
        if (ADYaiT3 == 0) {
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        } else if (ADYaiT3 == 1) {
            makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f1412ASJ6gh, i7, -2);
        } else if (ADYaiT3 == 2) {
            makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f1412ASJ6gh, i7, -2);
            boolean z4 = aRc23Z.f1149B7CMnp == 1;
            int i12 = a4TApA.f1284AZkASS;
            if (i12 == 1 || i12 == 2) {
                boolean z5 = view.getMeasuredWidth() == aRc23Z.B2KMhB();
                if (a4TApA.f1284AZkASS == 2 || !z4 || ((z4 && z5) || aRc23Z.BTvldC())) {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(aRc23Z.AaHO0E(), 1073741824);
                }
            }
        } else if (ADYaiT3 != 3) {
            makeMeasureSpec2 = 0;
        } else {
            int i13 = this.f1412ASJ6gh;
            int i14 = aMqCpz2 != null ? aRc23Z.f1165COJEAR.f1128ASJ6gh : 0;
            if (aMqCpz != null) {
                i14 += aRc23Z.f1167CSDoyG.f1128ASJ6gh;
            }
            makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i13, i7 + i14, -1);
        }
        BChYOn.ASJ6gh aSJ6gh = (BChYOn.ASJ6gh) aRc23Z.f1175CrfGsy;
        ConstraintLayout constraintLayout = this.f1413AYUAbz;
        if (aSJ6gh != null && AcNBzu.A4TApA(constraintLayout.f8407B7CMnp, 256) && view.getMeasuredWidth() == aRc23Z.B2KMhB() && view.getMeasuredWidth() < aSJ6gh.B2KMhB() && view.getMeasuredHeight() == aRc23Z.AaHO0E() && view.getMeasuredHeight() < aSJ6gh.AaHO0E() && view.getBaseline() == aRc23Z.f1182D8cQ8b && !aRc23Z.BNL6CD() && A2egSU(aRc23Z.f1162C4FrIb, makeMeasureSpec, aRc23Z.B2KMhB()) && A2egSU(aRc23Z.f1163CASmeH, makeMeasureSpec2, aRc23Z.AaHO0E())) {
            a4TApA.AMqCpz = aRc23Z.B2KMhB();
            a4TApA.f1280ARc23Z = aRc23Z.AaHO0E();
            a4TApA.f1281ASJ6gh = aRc23Z.f1182D8cQ8b;
            return;
        }
        boolean z6 = i3 == 3;
        boolean z7 = i4 == 3;
        boolean z8 = i4 == 4 || i4 == 1;
        boolean z9 = i3 == 4 || i3 == 1;
        boolean z10 = z6 && aRc23Z.f1178D07BeM > 0.0f;
        boolean z11 = z7 && aRc23Z.f1178D07BeM > 0.0f;
        if (view == null) {
            return;
        }
        ADYaiT aDYaiT = (ADYaiT) view.getLayoutParams();
        int i15 = a4TApA.f1284AZkASS;
        if (i15 != 1 && i15 != 2 && z6 && aRc23Z.f1148B4ZgIw == 0 && z7 && aRc23Z.f1149B7CMnp == 0) {
            z = false;
            measuredWidth = 0;
            baseline = 0;
            i2 = -1;
            max = 0;
        } else {
            if ((view instanceof AaHO0E) && (aRc23Z instanceof AlLFFp)) {
                ((AaHO0E) view).AZkASS((AlLFFp) aRc23Z, makeMeasureSpec, makeMeasureSpec2);
            } else {
                view.measure(makeMeasureSpec, makeMeasureSpec2);
            }
            aRc23Z.f1162C4FrIb = makeMeasureSpec;
            aRc23Z.f1163CASmeH = makeMeasureSpec2;
            aRc23Z.f1136ASJ6gh = false;
            int measuredWidth2 = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int baseline2 = view.getBaseline();
            int i16 = aRc23Z.f1151BChYOn;
            int max2 = i16 > 0 ? Math.max(i16, measuredWidth2) : measuredWidth2;
            int i17 = aRc23Z.f1152BI9f7h;
            if (i17 > 0) {
                max2 = Math.min(i17, max2);
            }
            int i18 = aRc23Z.f1154BJ7GGh;
            max = i18 > 0 ? Math.max(i18, measuredHeight) : measuredHeight;
            boolean z12 = z9;
            int i19 = aRc23Z.f1155BNL6CD;
            if (i19 > 0) {
                max = Math.min(i19, max);
            }
            if (!AcNBzu.A4TApA(constraintLayout.f8407B7CMnp, 1)) {
                if (z10 && z8) {
                    max2 = (int) ((max * aRc23Z.f1178D07BeM) + 0.5f);
                } else if (z11 && z12) {
                    max = (int) ((max2 / aRc23Z.f1178D07BeM) + 0.5f);
                }
            }
            if (measuredWidth2 == max2 && measuredHeight == max) {
                baseline = baseline2;
                measuredWidth = max2;
                z = false;
            } else {
                if (measuredWidth2 != max2) {
                    i = 1073741824;
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max2, 1073741824);
                } else {
                    i = 1073741824;
                }
                if (measuredHeight != max) {
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(max, i);
                }
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                aRc23Z.f1162C4FrIb = makeMeasureSpec;
                aRc23Z.f1163CASmeH = makeMeasureSpec2;
                z = false;
                aRc23Z.f1136ASJ6gh = false;
                measuredWidth = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                max = measuredHeight2;
            }
            i2 = -1;
        }
        boolean z13 = baseline != i2;
        if (measuredWidth != a4TApA.f1278A5SV6n || max != a4TApA.f1279ADYaiT) {
            z = true;
        }
        a4TApA.f1283AZOQYO = z;
        boolean z14 = aDYaiT.f1395D9tr6l ? true : z13;
        if (z14 && baseline != -1 && aRc23Z.f1182D8cQ8b != baseline) {
            a4TApA.f1283AZOQYO = true;
        }
        a4TApA.AMqCpz = measuredWidth;
        a4TApA.f1280ARc23Z = max;
        a4TApA.f1282AYUAbz = z14;
        a4TApA.f1281ASJ6gh = baseline;
    }
}
