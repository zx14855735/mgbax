package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends RecyclerView.xj<kd> {
    private final List<hf> hf = new ArrayList();
    private final List<kd> kd = new ArrayList();
    private final float u;
    private final float w;
    private final Context xj;

    public xj(Context context, float f, float f2) {
        this.xj = context;
        this.w = f;
        this.u = f2;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.xj
    public long hf(int i) {
        return i;
    }

    public void u() {
        Iterator<kd> it = this.kd.iterator();
        while (it.hasNext()) {
            it.next().ff();
        }
        this.kd.clear();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.xj
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public kd xj(ViewGroup viewGroup, int i) {
        kd kdVar = new kd(com.bytedance.sdk.openadsdk.res.kd.pl(this.xj));
        this.kd.add(kdVar);
        return kdVar;
    }

    public void xj(List<hf> list) {
        this.hf.clear();
        this.hf.addAll(list);
        w();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.xj
    public void xj(kd kdVar) {
        super.xj((xj) kdVar);
        kdVar.ff();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.xj
    public void xj(kd kdVar, int i) {
        List<hf> list = this.hf;
        kdVar.xj(list.get(i % list.size()), (int) this.w, (int) this.u);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.xj
    public int xj() {
        return this.hf.size();
    }
}
