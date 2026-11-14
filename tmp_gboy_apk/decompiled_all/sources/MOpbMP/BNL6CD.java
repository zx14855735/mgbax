package MOpbMP;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BNL6CD extends RecyclerView.AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ BpkvW3 f5050A2egSU;

    public BNL6CD(BpkvW3 bpkvW3) {
        this.f5050A2egSU = bpkvW3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AYUAbz
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        LLiCI0.CcAIMM ccAIMM = this.f5050A2egSU.f5071B7CMnp;
        boolean z = true;
        if (i != 1 && i != 2) {
            z = false;
        }
        if (ccAIMM.f4789AzWtSf != z) {
            ccAIMM.f4789AzWtSf = z;
            if (z) {
                return;
            }
            ccAIMM.notifyItemRangeChanged(0, ccAIMM.f4788AmA8tU.size(), "MARQUEE_STATE");
        }
    }
}
