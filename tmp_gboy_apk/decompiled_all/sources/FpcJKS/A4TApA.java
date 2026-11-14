package FpcJKS;

import H0qugq.ADYaiT;
import android.app.Fragment;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A4TApA extends Fragment {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public A2egSU f2876AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public FG7pZc.A2egSU f2877AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f2878AmA8tU = 2;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f2879AzWtSf = false;

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        FG7pZc.A2egSU a2egSU = this.f2877AlLFFp;
        if (a2egSU != null) {
            a2egSU.A4TApA();
        }
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        FG7pZc.A2egSU a2egSU = this.f2877AlLFFp;
        if (a2egSU != null) {
            Iterator it = a2egSU.A2egSU(GTPRn3.A2egSU.f3058AmA8tU).iterator();
            while (it.hasNext()) {
                ((ADYaiT) it.next()).A2egSU();
            }
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        if (!this.f2879AzWtSf) {
            if (this.f2878AmA8tU == 4) {
                this.f2879AzWtSf = true;
                return;
            }
            this.f2879AzWtSf = true;
        }
        FG7pZc.A2egSU a2egSU = this.f2877AlLFFp;
        if (a2egSU != null) {
            Iterator it = a2egSU.A2egSU(GTPRn3.A2egSU.f3057AlLFFp).iterator();
            while (it.hasNext()) {
                ((ADYaiT) it.next()).A2egSU();
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        if (!this.f2879AzWtSf) {
            int i = this.f2878AmA8tU;
            if (i == 4) {
                return;
            }
            if (i == 3) {
                this.f2879AzWtSf = true;
                return;
            }
            this.f2879AzWtSf = true;
        }
        FG7pZc.A2egSU a2egSU = this.f2877AlLFFp;
        if (a2egSU != null) {
            Iterator it = a2egSU.A2egSU(GTPRn3.A2egSU.f3056AcNBzu).iterator();
            while (it.hasNext()) {
                ((ADYaiT) it.next()).A2egSU();
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        FG7pZc.A2egSU a2egSU = this.f2877AlLFFp;
        if (a2egSU != null) {
            Iterator it = a2egSU.A2egSU(GTPRn3.A2egSU.f3059AzWtSf).iterator();
            while (it.hasNext()) {
                ((ADYaiT) it.next()).A2egSU();
            }
        }
    }
}
