package IQ76hF;

import MOpbMP.B2KMhB;
import android.content.Context;
import android.util.Log;
import androidx.fragment.app.CtxOCS;
import androidx.fragment.app.Fragment;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AzWtSf extends Fragment {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A2egSU f3957AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final AmA8tU f3958AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final HashSet f3959AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public AzWtSf f3960AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public com.bumptech.glide.AzWtSf f3961B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public B2KMhB f3962B2KMhB;

    public AzWtSf() {
        A2egSU a2egSU = new A2egSU();
        this.f3958AlLFFp = new AmA8tU(0, this);
        this.f3959AmA8tU = new HashSet();
        this.f3957AcNBzu = a2egSU;
    }

    public final void AZkASS(Context context, CtxOCS ctxOCS) {
        AzWtSf azWtSf = this.f3960AzWtSf;
        if (azWtSf != null) {
            azWtSf.f3959AmA8tU.remove(this);
            this.f3960AzWtSf = null;
        }
        AzWtSf ARc23Z2 = com.bumptech.glide.A4TApA.A4TApA(context).f9880B2KMhB.ARc23Z(ctxOCS, null);
        this.f3960AzWtSf = ARc23Z2;
        if (equals(ARc23Z2)) {
            return;
        }
        this.f3960AzWtSf.f3959AmA8tU.add(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = this;
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        CtxOCS fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            Log.isLoggable("SupportRMFragment", 5);
            return;
        }
        try {
            AZkASS(getContext(), fragmentManager);
        } catch (IllegalStateException unused) {
            Log.isLoggable("SupportRMFragment", 5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        A2egSU a2egSU = this.f3957AcNBzu;
        a2egSU.f3934AmA8tU = true;
        Iterator it = ItGa5w.AlLFFp.ADYaiT(a2egSU.f3932AcNBzu).iterator();
        while (it.hasNext()) {
            ((AYUAbz) it.next()).onDestroy();
        }
        AzWtSf azWtSf = this.f3960AzWtSf;
        if (azWtSf != null) {
            azWtSf.f3959AmA8tU.remove(this);
            this.f3960AzWtSf = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        this.f3962B2KMhB = null;
        AzWtSf azWtSf = this.f3960AzWtSf;
        if (azWtSf != null) {
            azWtSf.f3959AmA8tU.remove(this);
            this.f3960AzWtSf = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        A2egSU a2egSU = this.f3957AcNBzu;
        a2egSU.f3933AlLFFp = true;
        Iterator it = ItGa5w.AlLFFp.ADYaiT(a2egSU.f3932AcNBzu).iterator();
        while (it.hasNext()) {
            ((AYUAbz) it.next()).onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        A2egSU a2egSU = this.f3957AcNBzu;
        a2egSU.f3933AlLFFp = false;
        Iterator it = ItGa5w.AlLFFp.ADYaiT(a2egSU.f3932AcNBzu).iterator();
        while (it.hasNext()) {
            ((AYUAbz) it.next()).onStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.f3962B2KMhB;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }
}
