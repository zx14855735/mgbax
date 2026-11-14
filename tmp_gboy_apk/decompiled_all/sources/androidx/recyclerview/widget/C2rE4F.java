package androidx.recyclerview.widget;

import android.view.View;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class C2rE4F {

    /* renamed from: A2egSU, reason: collision with root package name */
    public boolean f9308A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f9309A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f9310A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f9311ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f9312ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f9313ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f9314AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f9315AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f9316AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public List f9317AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f9318AcNBzu;

    public final void A2egSU(View view) {
        int layoutPosition;
        int size = this.f9317AaHO0E.size();
        View view2 = null;
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            View view3 = ((Dphsd2) this.f9317AaHO0E.get(i2)).itemView;
            DG07BK dg07bk = (DG07BK) view3.getLayoutParams();
            if (view3 != view && !dg07bk.f9343A2egSU.isRemoved() && (layoutPosition = (dg07bk.f9343A2egSU.getLayoutPosition() - this.f9311ADYaiT) * this.AMqCpz) >= 0 && layoutPosition < i) {
                view2 = view3;
                if (layoutPosition == 0) {
                    break;
                } else {
                    i = layoutPosition;
                }
            }
        }
        if (view2 == null) {
            this.f9311ADYaiT = -1;
        } else {
            this.f9311ADYaiT = ((DG07BK) view2.getLayoutParams()).f9343A2egSU.getLayoutPosition();
        }
    }

    public final View A4TApA(DXnQ0V dXnQ0V) {
        List list = this.f9317AaHO0E;
        if (list == null) {
            View ADYaiT2 = dXnQ0V.ADYaiT(this.f9311ADYaiT);
            this.f9311ADYaiT += this.AMqCpz;
            return ADYaiT2;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            View view = ((Dphsd2) this.f9317AaHO0E.get(i)).itemView;
            DG07BK dg07bk = (DG07BK) view.getLayoutParams();
            if (!dg07bk.f9343A2egSU.isRemoved() && this.f9311ADYaiT == dg07bk.f9343A2egSU.getLayoutPosition()) {
                A2egSU(view);
                return view;
            }
        }
        return null;
    }
}
