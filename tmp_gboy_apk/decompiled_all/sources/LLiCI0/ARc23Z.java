package LLiCI0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ARc23Z extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ArrayList f4682AcNBzu = new ArrayList();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public AMqCpz f4683AlLFFp;

    public final void A2egSU(List list) {
        ArrayList arrayList = list == null ? new ArrayList() : new ArrayList(list);
        Collections.sort(arrayList, new A2egSU());
        if (this.f4682AcNBzu.equals(arrayList)) {
            return;
        }
        this.f4682AcNBzu = arrayList;
        notifyDataSetChanged();
        AMqCpz aMqCpz = this.f4683AlLFFp;
        if (aMqCpz != null) {
            ArrayList arrayList2 = this.f4682AcNBzu;
            if (!aMqCpz.f4679AlLFFp) {
                aMqCpz.A2egSU(arrayList2);
                return;
            }
            if (arrayList2 == null || arrayList2.isEmpty()) {
                return;
            }
            AzWtSf azWtSf = new AzWtSf(arrayList2);
            aMqCpz.f4681AzWtSf = azWtSf;
            ViewPager2 viewPager2 = aMqCpz.f4678AcNBzu;
            viewPager2.setAdapter(azWtSf);
            int itemCount = aMqCpz.f4681AzWtSf.getItemCount();
            viewPager2.A4TApA(itemCount > 1 ? itemCount / 2 : 0, false);
            A4TApA a4TApA = aMqCpz.f4680AmA8tU;
            if (a4TApA != null) {
                a4TApA.f4675ADYaiT = false;
                a4TApA.f4673A4TApA.removeCallbacks(a4TApA.f4676ARc23Z);
                aMqCpz.f4680AmA8tU.A2egSU();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return !this.f4682AcNBzu.isEmpty() ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        AMqCpz aMqCpz = (AMqCpz) dphsd2;
        this.f4683AlLFFp = aMqCpz;
        aMqCpz.A2egSU(this.f4682AcNBzu);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131492981, viewGroup, false);
        AMqCpz aMqCpz = new AMqCpz(inflate);
        aMqCpz.f4679AlLFFp = false;
        aMqCpz.f4678AcNBzu = (ViewPager2) inflate.findViewById(2131296403);
        return aMqCpz;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onViewRecycled(Dphsd2 dphsd2) {
        A4TApA a4TApA = ((AMqCpz) dphsd2).f4680AmA8tU;
        if (a4TApA != null) {
            a4TApA.f4675ADYaiT = false;
            a4TApA.f4673A4TApA.removeCallbacks(a4TApA.f4676ARc23Z);
        }
    }
}
