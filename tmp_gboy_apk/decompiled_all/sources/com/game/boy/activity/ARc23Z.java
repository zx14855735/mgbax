package com.game.boy.activity;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z extends RecyclerView.AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ DownLoadActivity f10892A2egSU;

    public ARc23Z(DownLoadActivity downLoadActivity) {
        this.f10892A2egSU = downLoadActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AYUAbz
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        LLiCI0.B3GDIM b3gdim = this.f10892A2egSU.f10975B3GDIM;
        boolean z = true;
        if (i != 1 && i != 2) {
            z = false;
        }
        if (b3gdim.f4718AmA8tU != z) {
            b3gdim.f4718AmA8tU = z;
            if (z) {
                return;
            }
            b3gdim.notifyItemRangeChanged(0, b3gdim.f4716AcNBzu.size(), "MARQUEE_STATE");
        }
    }
}
