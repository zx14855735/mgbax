package com.bytedance.sdk.component.widget.recycler;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class pl extends RecyclerView.pl {
    private Scroller hf;
    private final RecyclerView.am w = new RecyclerView.am() { // from class: com.bytedance.sdk.component.widget.recycler.pl.1
        boolean xj = false;

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.am
        public void xj(RecyclerView recyclerView, int i) {
            super.xj(recyclerView, i);
            if (i == 0 && this.xj) {
                this.xj = false;
                pl.this.xj();
            }
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.am
        public void xj(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.xj = true;
        }
    };
    RecyclerView xj;

    private void hf() {
        if (this.xj.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.xj.xj(this.w);
        this.xj.setOnFlingListener(this);
    }

    private void w() {
        this.xj.hf(this.w);
        this.xj.setOnFlingListener(null);
    }

    public abstract int xj(RecyclerView.d dVar, int i, int i2);

    public abstract View xj(RecyclerView.d dVar);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.pl
    public boolean xj(int i, int i2) {
        RecyclerView.d layoutManager = this.xj.getLayoutManager();
        if (layoutManager == null || this.xj.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.xj.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && hf(layoutManager, i, i2);
    }

    public abstract int[] xj(RecyclerView.d dVar, View view);

    public RecyclerView.v w(RecyclerView.d dVar) {
        return hf(dVar);
    }

    private boolean hf(RecyclerView.d dVar, int i, int i2) {
        RecyclerView.v w;
        int xj;
        if (!(dVar instanceof RecyclerView.v.hf) || (w = w(dVar)) == null || (xj = xj(dVar, i, i2)) == -1) {
            return false;
        }
        w.w(xj);
        dVar.xj(w);
        return true;
    }

    public void xj(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.xj;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                w();
            }
            this.xj = recyclerView;
            if (recyclerView != null) {
                hf();
                this.hf = new Scroller(this.xj.getContext(), new DecelerateInterpolator());
                xj();
            }
        }
    }

    @Deprecated
    public y hf(RecyclerView.d dVar) {
        if (dVar instanceof RecyclerView.v.hf) {
            return new y(this.xj.getContext()) { // from class: com.bytedance.sdk.component.widget.recycler.pl.2
                @Override // com.bytedance.sdk.component.widget.recycler.y, com.bytedance.sdk.component.widget.recycler.RecyclerView.v
                public void xj(View view, RecyclerView.jk jkVar, RecyclerView.v.xj xjVar) {
                    pl plVar = pl.this;
                    RecyclerView recyclerView = plVar.xj;
                    if (recyclerView != null) {
                        int[] xj = plVar.xj(recyclerView.getLayoutManager(), view);
                        int i = xj[0];
                        int i2 = xj[1];
                        int xj2 = xj(Math.max(Math.abs(i), Math.abs(i2)));
                        if (xj2 > 0) {
                            xjVar.update(i, i2, xj2, ((y) this).hf);
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.widget.recycler.y
                public float xj(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }

    public void xj() {
        RecyclerView.d layoutManager;
        View xj;
        RecyclerView recyclerView = this.xj;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (xj = xj(layoutManager)) == null) {
            return;
        }
        int[] xj2 = xj(layoutManager, xj);
        int i = xj2[0];
        if (i == 0 && xj2[1] == 0) {
            return;
        }
        this.xj.xj(i, xj2[1]);
    }
}
