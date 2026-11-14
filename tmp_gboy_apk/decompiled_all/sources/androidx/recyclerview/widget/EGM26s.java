package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EGM26s extends RecyclerView.AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public boolean f9376A2egSU = false;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ EPdU4G f9377A4TApA;

    public EGM26s(EPdU4G ePdU4G) {
        this.f9377A4TApA = ePdU4G;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AYUAbz
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0 && this.f9376A2egSU) {
            this.f9376A2egSU = false;
            this.f9377A4TApA.snapToTargetExistingView();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AYUAbz
    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        this.f9376A2egSU = true;
    }
}
