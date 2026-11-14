package MQlCFp;

import IQ76hF.AmA8tU;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.dcloud.ads.core.entry.DCloudAdSlot;
import io.dcloud.ads.core.v2.feed.DCFeedAdLoader;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class A5SV6n extends Fragment {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public View f5140AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public RecyclerView f5141AlLFFp;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public RelativeLayout f5143AzWtSf;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final ArrayList f5142AmA8tU = new ArrayList();

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f5144B25kr6 = true;

    public static void AZkASS(A5SV6n a5SV6n) {
        if (!a5SV6n.isAdded() || a5SV6n.requireActivity() == null || a5SV6n.getActivity() == null) {
            return;
        }
        a5SV6n.f5143AzWtSf.setVisibility(8);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f5140AcNBzu == null) {
            View inflate = layoutInflater.inflate(2131492958, viewGroup, false);
            this.f5140AcNBzu = inflate;
            this.f5143AzWtSf = (RelativeLayout) inflate.findViewById(2131296344);
            this.f5141AlLFFp = (RecyclerView) this.f5140AcNBzu.findViewById(2131297796);
            getActivity();
            this.f5141AlLFFp.setLayoutManager(new LinearLayoutManager(1));
            this.f5141AlLFFp.setAdapter(new A4TApA(this, this.f5142AmA8tU));
        }
        return this.f5140AcNBzu;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f5144B25kr6) {
            if ((!isResumed() || getView() == null || getView().getWindowToken() == null) ? false : getUserVisibleHint()) {
                new DCFeedAdLoader(requireActivity()).load(new DCloudAdSlot.Builder().adpid("1923390914").build(), new AmA8tU(11, this));
                this.f5144B25kr6 = false;
            }
        }
    }
}
