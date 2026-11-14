package androidx.viewpager2.adapter;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class A4TApA extends RecyclerView.A4TApA {
    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public abstract void onChanged();

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onItemRangeChanged(int i, int i2) {
        onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onItemRangeInserted(int i, int i2) {
        onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onItemRangeMoved(int i, int i2, int i3) {
        onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onItemRangeRemoved(int i, int i2) {
        onChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A4TApA
    public final void onItemRangeChanged(int i, int i2, Object obj) {
        onChanged();
    }
}
