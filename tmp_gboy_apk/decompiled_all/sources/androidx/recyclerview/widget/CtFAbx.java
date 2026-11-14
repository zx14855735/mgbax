package androidx.recyclerview.widget;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CtFAbx {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f9335A2egSU;

    public CtFAbx(RecyclerView recyclerView) {
        this.f9335A2egSU = recyclerView;
    }

    public final void A2egSU(A2egSU a2egSU) {
        int i = a2egSU.f9160A2egSU;
        RecyclerView recyclerView = this.f9335A2egSU;
        if (i == 1) {
            recyclerView.mLayout.onItemsAdded(recyclerView, a2egSU.f9161A4TApA, a2egSU.f9163ADYaiT);
            return;
        }
        if (i == 2) {
            recyclerView.mLayout.onItemsRemoved(recyclerView, a2egSU.f9161A4TApA, a2egSU.f9163ADYaiT);
        } else if (i == 4) {
            recyclerView.mLayout.onItemsUpdated(recyclerView, a2egSU.f9161A4TApA, a2egSU.f9163ADYaiT, a2egSU.f9162A5SV6n);
        } else {
            if (i != 8) {
                return;
            }
            recyclerView.mLayout.onItemsMoved(recyclerView, a2egSU.f9161A4TApA, a2egSU.f9163ADYaiT, 1);
        }
    }
}
