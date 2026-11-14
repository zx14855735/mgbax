package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.d;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends com.bytedance.sdk.component.widget.recycler.kd {
    private xj dk;
    private final RecyclerView.p et;
    private boolean ht;
    private int jk;
    private int pz;
    private int ra;
    private final d v;
    public boolean yo;

    public interface xj {
        void xj();

        void xj(boolean z, int i);

        void xj(boolean z, int i, boolean z2);
    }

    public w(Context context, int i, boolean z) {
        super(context, i, z);
        this.ht = false;
        this.yo = true;
        this.et = new RecyclerView.p() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.w.1
            @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.p
            public void hf(View view) {
                if (w.this.dk != null) {
                    w.this.dk.xj(w.this.jk >= 0, w.this.u(view));
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.p
            public void xj(View view) {
                if (w.this.dk == null || w.this.v() != 1) {
                    return;
                }
                w.this.dk.xj();
            }
        };
        this.v = new d();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public void p(int i) {
        boolean z;
        xj xjVar;
        this.pz = i;
        if (i == 0) {
            View xj2 = this.v.xj(this);
            if (xj2 != null) {
                int u = u(xj2);
                z = this.ra == u;
                this.ra = u;
            } else {
                z = true;
            }
            if (this.ht) {
                this.ht = false;
                if (!z && (xjVar = this.dk) != null) {
                    boolean z2 = this.jk >= 0;
                    int i2 = this.ra;
                    xjVar.xj(z2, i2, i2 == q() - 1);
                }
            }
        }
        if (i == 2) {
            this.ht = true;
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public void w(RecyclerView recyclerView) {
        super.w(recyclerView);
        this.v.xj(recyclerView);
        recyclerView.xj(this.et);
    }

    public void hf(boolean z) {
        this.yo = z;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.kd, com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public void xj(RecyclerView recyclerView, RecyclerView.zg zgVar) {
        super.xj(recyclerView, zgVar);
        try {
            kd kdVar = (kd) recyclerView.w(this.ra);
            if (kdVar != null) {
                kdVar.q();
            }
        } catch (Exception e) {
            pl.w("cubic detached exception:" + e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.kd, com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public int hf(int i, RecyclerView.zg zgVar, RecyclerView.jk jkVar) {
        this.jk = i;
        return super.hf(i, zgVar, jkVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.kd, com.bytedance.sdk.component.widget.recycler.RecyclerView.d
    public int xj(int i, RecyclerView.zg zgVar, RecyclerView.jk jkVar) {
        this.jk = i;
        return super.xj(i, zgVar, jkVar);
    }

    public void xj(xj xjVar) {
        this.dk = xjVar;
    }
}
