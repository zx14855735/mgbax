package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class p extends RecyclerView.y {
    boolean f = true;

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.y
    public boolean c(RecyclerView.ra raVar) {
        return !this.f || raVar.am();
    }

    public final void d(RecyclerView.ra raVar) {
        y(raVar);
    }

    public final void f(RecyclerView.ra raVar) {
        y(raVar);
    }

    public abstract boolean hf(RecyclerView.ra raVar);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.y
    public boolean hf(RecyclerView.ra raVar, RecyclerView.y.hf hfVar, RecyclerView.y.hf hfVar2) {
        int i;
        int i2;
        return (hfVar == null || ((i = hfVar.xj) == (i2 = hfVar2.xj) && hfVar.hf == hfVar2.hf)) ? hf(raVar) : xj(raVar, i, hfVar.hf, i2, hfVar2.hf);
    }

    public final void tf(RecyclerView.ra raVar) {
        y(raVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.y
    public boolean w(RecyclerView.ra raVar, RecyclerView.y.hf hfVar, RecyclerView.y.hf hfVar2) {
        int i = hfVar.xj;
        int i2 = hfVar2.xj;
        if (i != i2 || hfVar.hf != hfVar2.hf) {
            return xj(raVar, i, hfVar.hf, i2, hfVar2.hf);
        }
        d(raVar);
        return false;
    }

    public abstract boolean xj(RecyclerView.ra raVar);

    public abstract boolean xj(RecyclerView.ra raVar, int i, int i2, int i3, int i4);

    public abstract boolean xj(RecyclerView.ra raVar, RecyclerView.ra raVar2, int i, int i2, int i3, int i4);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.y
    public boolean xj(RecyclerView.ra raVar, RecyclerView.y.hf hfVar, RecyclerView.y.hf hfVar2) {
        int i = hfVar.xj;
        int i2 = hfVar.hf;
        View view = raVar.xj;
        int left = hfVar2 == null ? view.getLeft() : hfVar2.xj;
        int top = hfVar2 == null ? view.getTop() : hfVar2.hf;
        if (raVar.e() || (i == left && i2 == top)) {
            return xj(raVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return xj(raVar, i, i2, left, top);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.y
    public boolean xj(RecyclerView.ra raVar, RecyclerView.ra raVar2, RecyclerView.y.hf hfVar, RecyclerView.y.hf hfVar2) {
        int i;
        int i2;
        int i3 = hfVar.xj;
        int i4 = hfVar.hf;
        if (raVar2.L_()) {
            int i5 = hfVar.xj;
            i2 = hfVar.hf;
            i = i5;
        } else {
            i = hfVar2.xj;
            i2 = hfVar2.hf;
        }
        return xj(raVar, raVar2, i3, i4, i, i2);
    }

    public final void xj(RecyclerView.ra raVar, boolean z) {
        y(raVar);
    }
}
