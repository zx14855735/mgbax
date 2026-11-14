package com.bytedance.sdk.openadsdk.core.ugeno.component.hf;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class hf extends RecyclerView.am {
    private xj hf;
    private int w;
    private boolean xj = false;

    public hf(xj xjVar) {
        this.hf = xjVar;
    }

    public abstract void hf(RecyclerView recyclerView, int i);

    public abstract void xj();

    public abstract void xj(int i, int i2);

    public abstract void xj(int i, View view);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.am
    public void xj(RecyclerView recyclerView, int i) {
        super.xj(recyclerView, i);
        com.bytedance.sdk.component.widget.recycler.kd kdVar = (com.bytedance.sdk.component.widget.recycler.kd) recyclerView.getLayoutManager();
        if (i == 0) {
            int p = kdVar.p();
            if (!xj(kdVar.hf(p), 50)) {
                p--;
            }
            int max = Math.max(0, Math.max(p, this.w));
            for (int min = Math.min(this.w, p); min <= max; min++) {
                xj(min, kdVar.hf(min));
            }
            this.w = p;
            int q = kdVar.q();
            this.hf.xj(recyclerView);
            if ((p == q - 1 && this.xj) || q == 1) {
                xj();
            }
        }
        hf(recyclerView, i);
    }

    private int xj(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect) || view.getMeasuredHeight() <= 0) {
            return -1;
        }
        return (rect.height() * 100) / view.getMeasuredHeight();
    }

    private boolean xj(View view, int i) {
        return view != null && view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && xj(view) >= i;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.am
    public void xj(RecyclerView recyclerView, int i, int i2) {
        super.xj(recyclerView, i, i2);
        if (i2 == 0) {
            com.bytedance.sdk.component.widget.recycler.kd kdVar = (com.bytedance.sdk.component.widget.recycler.kd) recyclerView.getLayoutManager();
            this.w = kdVar.tf();
            int p = kdVar.p();
            if (!xj(kdVar.hf(p), 50)) {
                p--;
            }
            int max = Math.max(0, Math.max(p, this.w));
            for (int i3 = this.w; i3 <= max; i3++) {
                xj(i3, kdVar.hf(i3));
            }
        }
        this.xj = i2 > 0;
        this.hf.xj();
        xj(i, i2);
    }
}
