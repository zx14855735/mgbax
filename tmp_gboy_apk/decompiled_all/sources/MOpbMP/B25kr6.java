package MOpbMP;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B25kr6 extends androidx.viewpager2.adapter.AYUAbz {

    /* renamed from: B9tovu, reason: collision with root package name */
    public final /* synthetic */ B2KMhB f5030B9tovu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B25kr6(B2KMhB b2KMhB, B2KMhB b2KMhB2) {
        super(b2KMhB2);
        this.f5030B9tovu = b2KMhB;
    }

    @Override // androidx.viewpager2.adapter.AYUAbz
    public final boolean A4TApA(long j) {
        return j == 0 || j == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final long getItemId(int i) {
        return i;
    }
}
