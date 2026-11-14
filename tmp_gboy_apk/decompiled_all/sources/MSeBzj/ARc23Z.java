package MSeBzj;

import L2suez.ASJ6gh;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f5184AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final A2egSU f5185AlLFFp;

    public ARc23Z(ArrayList arrayList, A2egSU a2egSU) {
        this.f5184AcNBzu = arrayList;
        this.f5185AlLFFp = a2egSU;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f5184AcNBzu.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        AMqCpz aMqCpz = (AMqCpz) dphsd2;
        ASJ6gh.A2egSU a2egSU = (ASJ6gh.A2egSU) this.f5184AcNBzu.get(i);
        File file = a2egSU.f4366A2egSU;
        aMqCpz.f5183AcNBzu.setText(file != null ? file.getName() : "");
        aMqCpz.f5183AcNBzu.setOnClickListener(new ADYaiT(this, a2egSU));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AMqCpz(LayoutInflater.from(viewGroup.getContext()).inflate(2131492983, viewGroup, false));
    }
}
