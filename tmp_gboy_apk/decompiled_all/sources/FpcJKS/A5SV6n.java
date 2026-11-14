package FpcJKS;

import H0qugq.ADYaiT;
import androidx.fragment.app.Fragment;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A5SV6n extends Fragment {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public A2egSU f2880AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public FG7pZc.A2egSU f2881AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f2882AmA8tU = 2;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f2883AzWtSf = false;

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        FG7pZc.A2egSU a2egSU = this.f2881AlLFFp;
        if (a2egSU != null) {
            a2egSU.A4TApA();
            this.f2881AlLFFp = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        FG7pZc.A2egSU a2egSU = this.f2881AlLFFp;
        if (a2egSU != null) {
            Iterator it = a2egSU.A2egSU(GTPRn3.A2egSU.f3058AmA8tU).iterator();
            while (it.hasNext()) {
                ((ADYaiT) it.next()).A2egSU();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (!this.f2883AzWtSf) {
            if (this.f2882AmA8tU == 4) {
                this.f2883AzWtSf = true;
                return;
            }
            this.f2883AzWtSf = true;
        }
        FG7pZc.A2egSU a2egSU = this.f2881AlLFFp;
        if (a2egSU != null) {
            Iterator it = a2egSU.A2egSU(GTPRn3.A2egSU.f3057AlLFFp).iterator();
            while (it.hasNext()) {
                ((ADYaiT) it.next()).A2egSU();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        if (!this.f2883AzWtSf) {
            int i = this.f2882AmA8tU;
            if (i == 4) {
                return;
            }
            if (i == 3) {
                this.f2883AzWtSf = true;
                return;
            }
            this.f2883AzWtSf = true;
        }
        FG7pZc.A2egSU a2egSU = this.f2881AlLFFp;
        if (a2egSU != null) {
            Iterator it = a2egSU.A2egSU(GTPRn3.A2egSU.f3056AcNBzu).iterator();
            while (it.hasNext()) {
                ((ADYaiT) it.next()).A2egSU();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        FG7pZc.A2egSU a2egSU = this.f2881AlLFFp;
        if (a2egSU != null) {
            Iterator it = a2egSU.A2egSU(GTPRn3.A2egSU.f3059AzWtSf).iterator();
            while (it.hasNext()) {
                ((ADYaiT) it.next()).A2egSU();
            }
        }
    }
}
