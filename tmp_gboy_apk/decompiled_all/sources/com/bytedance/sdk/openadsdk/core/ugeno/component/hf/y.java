package com.bytedance.sdk.openadsdk.core.ugeno.component.hf;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.hf.xj;
import com.bytedance.adsdk.ugeno.w.d;
import com.bytedance.adsdk.ugeno.y.f;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.ugeno.component.hf.kd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y extends com.bytedance.adsdk.ugeno.hf.xj<RecyclerView> {
    private hf cu;
    private kd.w kc;
    private Map<Integer, d.xj> lm;
    private RecyclerView.d my;
    private kd no;
    private u qi;
    private List<w> vi;

    public interface hf {
        void xj();

        void xj(int i, int i2);

        void xj(int i, View view, w wVar);

        void xj(RecyclerView recyclerView, int i);
    }

    public static class xj extends RecyclerView.f implements kd.xj {
        private int xj;

        public xj(int i) {
            this.xj = i;
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.kd.xj
        public void J_() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.kd.xj
        public void K_() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.kd.xj
        public View w() {
            return null;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.f
        public void xj(Rect rect, View view, RecyclerView recyclerView, RecyclerView.jk jkVar) {
            super.xj(rect, view, recyclerView, jkVar);
            int i = this.xj;
            rect.left = i;
            rect.right = i;
            rect.bottom = i;
            if (recyclerView.y(view) == 0) {
                rect.top = this.xj;
            }
        }
    }

    public y(Context context) {
        super(context);
        this.lm = new HashMap();
    }

    @Override // com.bytedance.adsdk.ugeno.hf.xj
    public xj.C0026xj f() {
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(ViewGroup.LayoutParams layoutParams) {
    }

    @Override // com.bytedance.adsdk.ugeno.hf.xj, com.bytedance.adsdk.ugeno.hf.w
    public void hf() {
        super.hf();
        kd kdVar = new kd(this.hf);
        this.no = kdVar;
        kdVar.xj(this.k);
        this.no.xj(this.da);
        this.no.xj(this.zb);
        this.no.xj(this.qi);
        this.no.xj(this.kc);
        this.no.xj(this.lm);
        this.no.xj(this.vi);
        ((RecyclerView) this.kd).setLayoutManager(this.my);
        ((RecyclerView) this.kd).setAdapter(this.no);
        ((RecyclerView) this.kd).xj((RecyclerView.f) new xj((int) f.xj(this.hf, 10.0f)));
        ((RecyclerView) this.kd).xj((RecyclerView.am) new com.bytedance.sdk.openadsdk.core.ugeno.component.hf.hf(new com.bytedance.sdk.openadsdk.core.ugeno.component.hf.xj()) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.hf
            public void hf(RecyclerView recyclerView, int i) {
                if (y.this.cu != null) {
                    y.this.cu.xj(recyclerView, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.hf
            public void xj(int i, int i2) {
                if (y.this.cu != null) {
                    y.this.cu.xj(i, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.hf
            public void xj(int i, View view) {
                if (y.this.cu == null || i < 0 || y.this.vi == null || i >= y.this.vi.size()) {
                    return;
                }
                y.this.cu.xj(i, view, (w) y.this.vi.get(i));
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.hf
            public void xj() {
                if (y.this.cu != null) {
                    y.this.cu.xj();
                }
            }
        });
    }

    public void xj(u uVar) {
        this.qi = uVar;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public View xj() {
        return new RecyclerView(this.hf);
    }

    public void xj(hf hfVar) {
        this.cu = hfVar;
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(JSONObject jSONObject) {
        super.xj(jSONObject);
    }

    public void xj(List<w> list) {
        this.vi = list;
    }

    public void xj(int i, Object obj) {
        kd kdVar = this.no;
        if (kdVar != null) {
            kdVar.xj(obj);
            this.no.xj(i, obj);
        }
    }

    public void xj(kd.u uVar) {
        this.no.xj(uVar);
    }

    @Override // com.bytedance.adsdk.ugeno.hf.xj
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar) {
        if (wVar == null) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.hf.xj) this).xj.add(wVar);
        if (wVar.j() != null) {
            this.lm.put(Integer.valueOf(wVar.j().hashCode()), wVar.ai());
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void hf(List<w> list) {
        if (this.no == null || list == null || list.isEmpty()) {
            return;
        }
        if (this.vi == null) {
            this.vi = new ArrayList();
        }
        int size = this.vi.size();
        this.vi.addAll(list);
        this.no.xj(list);
        this.no.xj(size, this.vi.size());
    }

    @Override // com.bytedance.adsdk.ugeno.hf.w
    public void xj(String str, String str2) {
        super.xj(str, str2);
        str.getClass();
        if (str.equals("layoutType") && !TextUtils.equals("grid", str2)) {
            this.my = new com.bytedance.sdk.component.widget.recycler.kd(this.hf);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.hf.xj
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, ViewGroup.LayoutParams layoutParams) {
        ((com.bytedance.adsdk.ugeno.hf.xj) this).xj.add(wVar);
        this.lm.put(Integer.valueOf(wVar.j().hashCode()), wVar.ai());
    }
}
