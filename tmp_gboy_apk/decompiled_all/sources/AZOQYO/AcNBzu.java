package AZOQYO;

import COJEAR.De4eam;
import COJEAR.Dphsd2;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AcNBzu {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Interpolator f413A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public Dphsd2 f414ADYaiT;
    public boolean AMqCpz;

    /* renamed from: A4TApA, reason: collision with root package name */
    public long f412A4TApA = -1;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final AaHO0E f415ARc23Z = new AaHO0E(this);

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ArrayList f411A2egSU = new ArrayList();

    public final void A2egSU() {
        if (this.AMqCpz) {
            Iterator it = this.f411A2egSU.iterator();
            while (it.hasNext()) {
                ((De4eam) it.next()).A4TApA();
            }
            this.AMqCpz = false;
        }
    }

    public final void A4TApA() {
        View view;
        if (this.AMqCpz) {
            return;
        }
        Iterator it = this.f411A2egSU.iterator();
        while (it.hasNext()) {
            De4eam de4eam = (De4eam) it.next();
            long j = this.f412A4TApA;
            if (j >= 0) {
                de4eam.A5SV6n(j);
            }
            Interpolator interpolator = this.f413A5SV6n;
            if (interpolator != null && (view = (View) de4eam.f1696A2egSU.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.f414ADYaiT != null) {
                de4eam.ADYaiT(this.f415ARc23Z);
            }
            View view2 = (View) de4eam.f1696A2egSU.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.AMqCpz = true;
    }
}
