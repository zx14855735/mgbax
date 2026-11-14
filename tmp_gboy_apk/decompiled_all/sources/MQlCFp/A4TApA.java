package MQlCFp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f5139AcNBzu;

    public A4TApA(A5SV6n a5SV6n, ArrayList arrayList) {
        this.f5139AcNBzu = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f5139AcNBzu.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        A2egSU a2egSU = (A2egSU) dphsd2;
        if (this.f5139AcNBzu.get(i) != null) {
            throw new ClassCastException();
        }
        a2egSU.f5138AcNBzu.setImageResource(new int[]{2131230987, 2131231009}[i % 2]);
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131492975, viewGroup, false);
        A2egSU a2egSU = new A2egSU(inflate);
        a2egSU.f5138AcNBzu = (ImageView) inflate.findViewById(2131296756);
        return a2egSU;
    }
}
