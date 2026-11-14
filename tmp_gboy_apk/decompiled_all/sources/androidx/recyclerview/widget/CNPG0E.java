package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CNPG0E extends RecyclerView.A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ CQhlFr f9319A2egSU;

    public CNPG0E(CQhlFr cQhlFr) {
        this.f9319A2egSU = cQhlFr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onChanged() {
        CQhlFr cQhlFr = this.f9319A2egSU;
        cQhlFr.AMqCpz = cQhlFr.f9322A5SV6n.getItemCount();
        AYUAbz aYUAbz = (AYUAbz) cQhlFr.f9323ADYaiT;
        aYUAbz.f9181A2egSU.notifyDataSetChanged();
        aYUAbz.A2egSU();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onItemRangeChanged(int i, int i2) {
        CQhlFr cQhlFr = this.f9319A2egSU;
        AYUAbz aYUAbz = (AYUAbz) cQhlFr.f9323ADYaiT;
        aYUAbz.f9181A2egSU.notifyItemRangeChanged(i + aYUAbz.A4TApA(cQhlFr), i2, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onItemRangeInserted(int i, int i2) {
        CQhlFr cQhlFr = this.f9319A2egSU;
        cQhlFr.AMqCpz += i2;
        AYUAbz aYUAbz = (AYUAbz) cQhlFr.f9323ADYaiT;
        aYUAbz.f9181A2egSU.notifyItemRangeInserted(i + aYUAbz.A4TApA(cQhlFr), i2);
        if (cQhlFr.AMqCpz <= 0 || cQhlFr.f9322A5SV6n.getStateRestorationPolicy() != CtxOCS.f9337AlLFFp) {
            return;
        }
        ((AYUAbz) cQhlFr.f9323ADYaiT).A2egSU();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onItemRangeMoved(int i, int i2, int i3) {
        CQhlFr cQhlFr = this.f9319A2egSU;
        AYUAbz aYUAbz = (AYUAbz) cQhlFr.f9323ADYaiT;
        int A4TApA2 = aYUAbz.A4TApA(cQhlFr);
        aYUAbz.f9181A2egSU.notifyItemMoved(i + A4TApA2, i2 + A4TApA2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onItemRangeRemoved(int i, int i2) {
        CQhlFr cQhlFr = this.f9319A2egSU;
        cQhlFr.AMqCpz -= i2;
        AYUAbz aYUAbz = (AYUAbz) cQhlFr.f9323ADYaiT;
        aYUAbz.f9181A2egSU.notifyItemRangeRemoved(i + aYUAbz.A4TApA(cQhlFr), i2);
        if (cQhlFr.AMqCpz >= 1 || cQhlFr.f9322A5SV6n.getStateRestorationPolicy() != CtxOCS.f9337AlLFFp) {
            return;
        }
        ((AYUAbz) cQhlFr.f9323ADYaiT).A2egSU();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onStateRestorationPolicyChanged() {
        ((AYUAbz) this.f9319A2egSU.f9323ADYaiT).A2egSU();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onItemRangeChanged(int i, int i2, Object obj) {
        CQhlFr cQhlFr = this.f9319A2egSU;
        AYUAbz aYUAbz = (AYUAbz) cQhlFr.f9323ADYaiT;
        aYUAbz.f9181A2egSU.notifyItemRangeChanged(i + aYUAbz.A4TApA(cQhlFr), i2, obj);
    }
}
