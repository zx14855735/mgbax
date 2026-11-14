package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BJ7GGh extends LinearLayoutManager {
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.ARc23Z
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.AaHO0E aaHO0E, int i) {
        BIYEnU bIYEnU = new BIYEnU(recyclerView.getContext());
        bIYEnU.setTargetPosition(i);
        startSmoothScroll(bIYEnU);
    }
}
