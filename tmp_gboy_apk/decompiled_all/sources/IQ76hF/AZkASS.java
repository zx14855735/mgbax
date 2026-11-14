package IQ76hF;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AZkASS extends Fragment {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A2egSU f3940AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final AZkASS.ARc23Z f3941AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final HashSet f3942AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public com.bumptech.glide.AzWtSf f3943AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public AZkASS f3944B25kr6;

    public AZkASS() {
        A2egSU a2egSU = new A2egSU();
        this.f3941AlLFFp = new AZkASS.ARc23Z(19, this);
        this.f3942AmA8tU = new HashSet();
        this.f3940AcNBzu = a2egSU;
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            AZkASS aZkASS = this.f3944B25kr6;
            if (aZkASS != null) {
                aZkASS.f3942AmA8tU.remove(this);
                this.f3944B25kr6 = null;
            }
            AaHO0E aaHO0E = com.bumptech.glide.A4TApA.A4TApA(activity).f9880B2KMhB;
            aaHO0E.getClass();
            AZkASS AMqCpz = aaHO0E.AMqCpz(activity.getFragmentManager());
            this.f3944B25kr6 = AMqCpz;
            if (equals(AMqCpz)) {
                return;
            }
            this.f3944B25kr6.f3942AmA8tU.add(this);
        } catch (IllegalStateException unused) {
            Log.isLoggable("RMFragment", 5);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        A2egSU a2egSU = this.f3940AcNBzu;
        a2egSU.f3934AmA8tU = true;
        Iterator it = ItGa5w.AlLFFp.ADYaiT(a2egSU.f3932AcNBzu).iterator();
        while (it.hasNext()) {
            ((AYUAbz) it.next()).onDestroy();
        }
        AZkASS aZkASS = this.f3944B25kr6;
        if (aZkASS != null) {
            aZkASS.f3942AmA8tU.remove(this);
            this.f3944B25kr6 = null;
        }
    }

    @Override // android.app.Fragment
    public final void onDetach() {
        super.onDetach();
        AZkASS aZkASS = this.f3944B25kr6;
        if (aZkASS != null) {
            aZkASS.f3942AmA8tU.remove(this);
            this.f3944B25kr6 = null;
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        A2egSU a2egSU = this.f3940AcNBzu;
        a2egSU.f3933AlLFFp = true;
        Iterator it = ItGa5w.AlLFFp.ADYaiT(a2egSU.f3932AcNBzu).iterator();
        while (it.hasNext()) {
            ((AYUAbz) it.next()).onStart();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        A2egSU a2egSU = this.f3940AcNBzu;
        a2egSU.f3933AlLFFp = false;
        Iterator it = ItGa5w.AlLFFp.ADYaiT(a2egSU.f3932AcNBzu).iterator();
        while (it.hasNext()) {
            ((AYUAbz) it.next()).onStop();
        }
    }

    @Override // android.app.Fragment
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = null;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }
}
