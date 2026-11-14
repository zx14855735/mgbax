package MOpbMP;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BPw6Q8 extends RecyclerView.AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ BpkvW3 f5051A2egSU;

    public BPw6Q8(BpkvW3 bpkvW3) {
        this.f5051A2egSU = bpkvW3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AYUAbz
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        boolean z = i == 1 || i == 2;
        BpkvW3 bpkvW3 = this.f5051A2egSU;
        LLiCI0.BJ7GGh bJ7GGh = bpkvW3.f5066AzWtSf;
        if (bJ7GGh.f4740AzWtSf != z) {
            bJ7GGh.f4740AzWtSf = z;
            if (!z) {
                bJ7GGh.notifyItemRangeChanged(0, bJ7GGh.f4737AcNBzu.size(), "MARQUEE_STATE");
            }
        }
        if (i == 0) {
            bpkvW3.f5070B4ZgIw.setEnabled(!bpkvW3.f5065AmA8tU.canScrollVertically(-1));
        }
        bpkvW3.B7CMnp();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AYUAbz
    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        BpkvW3 bpkvW3 = this.f5051A2egSU;
        bpkvW3.f5070B4ZgIw.setEnabled(!bpkvW3.f5065AmA8tU.canScrollVertically(-1));
        bpkvW3.B7CMnp();
    }
}
