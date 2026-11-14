package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BI9f7h extends RecyclerView.AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ BJ7GGh f9246A2egSU;

    public BI9f7h(BJ7GGh bJ7GGh) {
        this.f9246A2egSU = bJ7GGh;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AYUAbz
    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        BJ7GGh bJ7GGh = this.f9246A2egSU;
        int computeVerticalScrollRange = bJ7GGh.f9267B4ZgIw.computeVerticalScrollRange();
        int i3 = bJ7GGh.f9266B3GDIM;
        int i4 = computeVerticalScrollRange - i3;
        int i5 = bJ7GGh.f9250A2egSU;
        bJ7GGh.f9268B7CMnp = i4 > 0 && i3 >= i5;
        int computeHorizontalScrollRange = bJ7GGh.f9267B4ZgIw.computeHorizontalScrollRange();
        int i6 = bJ7GGh.f9265B2KMhB;
        boolean z = computeHorizontalScrollRange - i6 > 0 && i6 >= i5;
        bJ7GGh.f9269B9tovu = z;
        boolean z2 = bJ7GGh.f9268B7CMnp;
        if (!z2 && !z) {
            if (bJ7GGh.f9270BChYOn != 0) {
                bJ7GGh.ADYaiT(0);
                return;
            }
            return;
        }
        if (z2) {
            float f = i3;
            bJ7GGh.f9260AcNBzu = (int) ((((f / 2.0f) + computeVerticalScrollOffset) * f) / computeVerticalScrollRange);
            bJ7GGh.f9259AaHO0E = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
        }
        if (bJ7GGh.f9269B9tovu) {
            float f2 = computeHorizontalScrollOffset;
            float f3 = i6;
            bJ7GGh.f9263AzWtSf = (int) ((((f3 / 2.0f) + f2) * f3) / computeHorizontalScrollRange);
            bJ7GGh.f9262AmA8tU = Math.min(i6, (i6 * i6) / computeHorizontalScrollRange);
        }
        int i7 = bJ7GGh.f9270BChYOn;
        if (i7 == 0 || i7 == 1) {
            bJ7GGh.ADYaiT(1);
        }
    }
}
