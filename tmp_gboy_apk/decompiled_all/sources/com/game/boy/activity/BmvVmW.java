package com.game.boy.activity;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BmvVmW extends RecyclerView.AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ FavoriteActivity f10926A2egSU;

    public BmvVmW(FavoriteActivity favoriteActivity) {
        this.f10926A2egSU = favoriteActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AYUAbz
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        LLiCI0.CcAIMM ccAIMM = this.f10926A2egSU.f11039B9tovu;
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
