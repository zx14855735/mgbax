package com.bytedance.sdk.component.widget.recycler;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d extends pl {
    private f hf;
    private f w;

    private f kd(RecyclerView.d dVar) {
        f fVar = this.w;
        if (fVar == null || fVar.xj != dVar) {
            this.w = f.xj(dVar);
        }
        return this.w;
    }

    private f u(RecyclerView.d dVar) {
        f fVar = this.hf;
        if (fVar == null || fVar.xj != dVar) {
            this.hf = f.hf(dVar);
        }
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.pl
    public y hf(RecyclerView.d dVar) {
        if (dVar instanceof RecyclerView.v.hf) {
            return new y(this.xj.getContext()) { // from class: com.bytedance.sdk.component.widget.recycler.d.1
                @Override // com.bytedance.sdk.component.widget.recycler.y
                public int hf(int i) {
                    return Math.min(100, super.hf(i));
                }

                @Override // com.bytedance.sdk.component.widget.recycler.y, com.bytedance.sdk.component.widget.recycler.RecyclerView.v
                public void xj(View view, RecyclerView.jk jkVar, RecyclerView.v.xj xjVar) {
                    d dVar2 = d.this;
                    int[] xj = dVar2.xj(dVar2.xj.getLayoutManager(), view);
                    int i = xj[0];
                    int i2 = xj[1];
                    int xj2 = xj(Math.max(Math.abs(i), Math.abs(i2)));
                    if (xj2 > 0) {
                        xjVar.update(i, i2, xj2, ((y) this).hf);
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

    @Override // com.bytedance.sdk.component.widget.recycler.pl
    public int[] xj(RecyclerView.d dVar, View view) {
        int[] iArr = new int[2];
        if (dVar.w()) {
            iArr[0] = xj(dVar, view, kd(dVar));
        } else {
            iArr[0] = 0;
        }
        if (dVar.u()) {
            iArr[1] = xj(dVar, view, u(dVar));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    private View hf(RecyclerView.d dVar, f fVar) {
        int v = dVar.v();
        View view = null;
        if (v == 0) {
            return null;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < v; i2++) {
            View f = dVar.f(i2);
            int xj = fVar.xj(f);
            if (xj < i) {
                view = f;
                i = xj;
            }
        }
        return view;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.pl
    public View xj(RecyclerView.d dVar) {
        if (dVar.u()) {
            return xj(dVar, u(dVar));
        }
        if (dVar.w()) {
            return xj(dVar, kd(dVar));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.widget.recycler.pl
    public int xj(RecyclerView.d dVar, int i, int i2) {
        View hf;
        int u;
        PointF w;
        int q = dVar.q();
        if (q == 0) {
            return -1;
        }
        if (dVar.u()) {
            hf = hf(dVar, u(dVar));
        } else {
            hf = dVar.w() ? hf(dVar, kd(dVar)) : null;
        }
        if (hf == null || (u = dVar.u(hf)) == -1) {
            return -1;
        }
        boolean z = false;
        if (!dVar.w() ? i2 > 0 : i > 0) {
            z = true;
        }
        return (!(dVar instanceof RecyclerView.v.hf) || (w = ((RecyclerView.v.hf) dVar).w(q - 1)) == null || (w.x >= 0.0f && w.y >= 0.0f)) ? z ? u + 1 : u : z ? u - 1 : u;
    }

    private int xj(RecyclerView.d dVar, View view, f fVar) {
        int kd;
        int kd2 = (fVar.kd(view) / 2) + fVar.xj(view);
        if (dVar.qt()) {
            kd = (fVar.y() / 2) + fVar.w();
        } else {
            kd = fVar.kd() / 2;
        }
        return kd2 - kd;
    }

    private View xj(RecyclerView.d dVar, f fVar) {
        int kd;
        int v = dVar.v();
        View view = null;
        if (v == 0) {
            return null;
        }
        if (dVar.qt()) {
            kd = (fVar.y() / 2) + fVar.w();
        } else {
            kd = fVar.kd() / 2;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < v; i2++) {
            View f = dVar.f(i2);
            int abs = Math.abs(((fVar.kd(f) / 2) + fVar.xj(f)) - kd);
            if (abs < i) {
                view = f;
                i = abs;
            }
        }
        return view;
    }
}
