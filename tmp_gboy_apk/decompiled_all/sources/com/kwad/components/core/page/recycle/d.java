package com.kwad.components.core.page.recycle;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class d extends RecyclerView.A2egSU {
    private List<Presenter> WP = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        c c = c(viewGroup, i);
        this.WP.add(c.mPresenter);
        return c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i) {
        cVar.mPresenter.o(cVar.UH);
    }

    public abstract c c(ViewGroup viewGroup, int i);

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        sH();
    }

    public final void sH() {
        Iterator<Presenter> it = this.WP.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(c cVar) {
        cVar.mPresenter.nJ();
    }
}
