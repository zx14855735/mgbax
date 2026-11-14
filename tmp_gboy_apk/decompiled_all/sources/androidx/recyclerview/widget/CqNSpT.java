package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CqNSpT implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f9333AcNBzu;

    public CqNSpT(RecyclerView recyclerView) {
        this.f9333AcNBzu = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView recyclerView = this.f9333AcNBzu;
        RecyclerView.ADYaiT aDYaiT = recyclerView.mItemAnimator;
        if (aDYaiT != null) {
            aDYaiT.AcNBzu();
        }
        recyclerView.mPostedAnimatorRunner = false;
    }
}
