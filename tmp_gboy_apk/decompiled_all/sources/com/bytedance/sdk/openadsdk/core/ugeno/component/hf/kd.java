package com.bytedance.sdk.openadsdk.core.ugeno.component.hf;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.hf.xj;
import com.bytedance.adsdk.ugeno.w.d;
import com.bytedance.adsdk.ugeno.w.jk;
import com.bytedance.adsdk.ugeno.w.qt;
import com.bytedance.adsdk.ugeno.w.tf;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends RecyclerView.xj<RecyclerView.ra> {
    private u c;
    private tf d;
    private boolean f = true;
    private Map<Integer, d.xj> hf;
    private w kd;
    private jk p;
    private yo tf;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.hf.u u;
    private Context w;
    private List<com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w> xj;
    private Object y;

    public class hf extends RecyclerView.ra {
        public hf(View view) {
            super(view);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.ugeno.component.hf.kd$kd, reason: collision with other inner class name */
    public class C0185kd extends RecyclerView.ra implements xj {
        com.bytedance.adsdk.ugeno.hf.w e;
        qt yo;

        public C0185kd(View view) {
            super(view);
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.kd.xj
        public void J_() {
            if (kd.this.u != null) {
                kd.this.u.hf(this.e);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.kd.xj
        public void K_() {
            if (kd.this.u != null) {
                kd.this.u.xj(this.e);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.kd.xj
        public View w() {
            return this.e.d();
        }

        public com.bytedance.adsdk.ugeno.hf.w x() {
            return this.e;
        }

        public void xj(com.bytedance.adsdk.ugeno.hf.w wVar) {
            this.e = wVar;
        }

        public void xj(qt qtVar) {
            this.yo = qtVar;
        }
    }

    public interface u {
        void xj(RecyclerView.ra raVar, int i);
    }

    public interface w {
    }

    public interface xj {
        void J_();

        void K_();

        View w();
    }

    public kd(Context context) {
        this.w = context;
    }

    public void xj(Map<Integer, d.xj> map) {
        this.hf = map;
    }

    public void xj(List<com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w> list) {
        if (this.xj == null) {
            this.xj = new ArrayList();
        }
        this.xj.addAll(list);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.ugeno.component.hf.u uVar) {
        this.u = uVar;
    }

    public void xj(tf tfVar) {
        this.d = tfVar;
    }

    public void xj(yo yoVar) {
        this.tf = yoVar;
    }

    public void xj(jk jkVar) {
        this.p = jkVar;
    }

    public void xj(w wVar) {
        this.kd = wVar;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.xj
    public RecyclerView.ra xj(ViewGroup viewGroup, int i) {
        d.xj xjVar = this.hf.get(Integer.valueOf(i));
        qt qtVar = new qt(this.w);
        com.bytedance.adsdk.ugeno.hf.w<View> xj2 = qtVar.xj(xjVar);
        qtVar.xj(xj2);
        if (xj2 != null) {
            xj2.xj(new ViewGroup.LayoutParams(xj2.l(), xj2.ff()));
            C0185kd c0185kd = new C0185kd(xj2.d());
            c0185kd.xj((com.bytedance.adsdk.ugeno.hf.w) xj2);
            c0185kd.xj(qtVar);
            return c0185kd;
        }
        return new hf(new View(this.w));
    }

    public void xj(u uVar) {
        this.c = uVar;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.xj
    public int xj(int i) {
        return this.xj.get(i).hf();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.xj
    public void xj(RecyclerView.ra raVar, int i, List<Object> list) {
        u uVar;
        if (list != null && !list.isEmpty()) {
            for (Object obj : list) {
                if (obj != null && this.y != null && TextUtils.equals(obj.toString(), this.y.toString()) && (uVar = this.c) != null) {
                    uVar.xj(raVar, i);
                }
            }
            return;
        }
        xj(raVar, i);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.xj
    public void xj(RecyclerView.ra raVar, int i) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w wVar;
        com.bytedance.sdk.openadsdk.core.ugeno.component.hf.u uVar;
        if (raVar == null || (wVar = this.xj.get(i)) == null || !(raVar instanceof C0185kd)) {
            return;
        }
        JSONObject xj2 = wVar.xj();
        C0185kd c0185kd = (C0185kd) raVar;
        c0185kd.e.xj(new ViewGroup.LayoutParams(c0185kd.e.l(), c0185kd.e.ff()));
        xj(xj2, c0185kd.x());
        xj(this.w, xj2, c0185kd.x());
        if (i == 0 && (uVar = this.u) != null && this.f) {
            this.f = false;
            uVar.xj(c0185kd.e);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.xj
    public int xj() {
        return this.xj.size();
    }

    public void xj(Object obj) {
        this.y = obj;
    }

    public void xj(JSONObject jSONObject, com.bytedance.adsdk.ugeno.hf.w wVar) {
        if (wVar == null) {
            return;
        }
        if (wVar instanceof com.bytedance.adsdk.ugeno.hf.xj) {
            wVar.xj(jSONObject);
            List<com.bytedance.adsdk.ugeno.hf.w<View>> c = ((com.bytedance.adsdk.ugeno.hf.xj) wVar).c();
            if (c == null || c.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.hf.w<View>> it = c.iterator();
            while (it.hasNext()) {
                xj(jSONObject, it.next());
            }
            return;
        }
        wVar.xj(jSONObject);
    }

    public void xj(Context context, JSONObject jSONObject, com.bytedance.adsdk.ugeno.hf.w wVar) {
        if (wVar == null) {
            return;
        }
        if (wVar instanceof com.bytedance.adsdk.ugeno.hf.xj) {
            wVar.xj(this.d);
            wVar.xj(this.tf);
            wVar.hf(true);
            wVar.hf();
            List<com.bytedance.adsdk.ugeno.hf.w<View>> c = ((com.bytedance.adsdk.ugeno.hf.xj) wVar).c();
            if (c == null || c.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.hf.w<View>> it = c.iterator();
            while (it.hasNext()) {
                xj(context, jSONObject, it.next());
            }
            return;
        }
        JSONObject dk = wVar.dk();
        Iterator<String> keys = dk.keys();
        com.bytedance.adsdk.ugeno.hf.xj z = wVar.z();
        xj.C0026xj f = z != null ? z.f() : null;
        while (keys.hasNext()) {
            String next = keys.next();
            String xj2 = com.bytedance.adsdk.ugeno.u.hf.xj(dk.optString(next), jSONObject);
            wVar.xj(next, xj2);
            wVar.xj(this.d);
            wVar.xj(this.tf);
            if (f != null) {
                f.xj(context, next, xj2);
            }
        }
        wVar.hf(true);
        wVar.hf();
    }
}
