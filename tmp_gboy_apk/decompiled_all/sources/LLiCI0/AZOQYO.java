package LLiCI0;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZOQYO extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ArrayList f4690AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public IQ76hF.AmA8tU f4691AlLFFp;

    public final void A2egSU(L2suez.A4TApA a4TApA) {
        this.f4690AcNBzu.add(a4TApA);
        notifyItemInserted(r0.size() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f4690AcNBzu.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemViewType(int i) {
        return ((L2suez.A4TApA) this.f4690AcNBzu.get(i)).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        L2suez.A4TApA a4TApA = (L2suez.A4TApA) this.f4690AcNBzu.get(i);
        if (dphsd2 instanceof AYUAbz) {
            AYUAbz aYUAbz = (AYUAbz) dphsd2;
            aYUAbz.getClass();
            aYUAbz.f4687AcNBzu.setText(a4TApA.f4360A2egSU);
            aYUAbz.f4688AlLFFp.setText(a4TApA.f4361A4TApA);
            return;
        }
        if (dphsd2 instanceof ASJ6gh) {
            ASJ6gh aSJ6gh = (ASJ6gh) dphsd2;
            aSJ6gh.getClass();
            aSJ6gh.f4684AcNBzu.setText(a4TApA.f4360A2egSU);
            aSJ6gh.f4685AlLFFp.setText(a4TApA.f4361A4TApA);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        return i == 0 ? new AYUAbz(this, from.inflate(2131492913, viewGroup, false)) : new ASJ6gh(this, from.inflate(2131492913, viewGroup, false));
    }
}
