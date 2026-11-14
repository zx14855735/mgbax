package com.bytedance.sdk.openadsdk.core.component.reward.u;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.ra.vm;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class p extends xj {
    private int j;
    private final List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.xj> z;

    public p(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar) {
        super(tTBaseVideoActivity, wsVar);
        this.z = new ArrayList();
        this.j = 0;
    }

    private int cy() {
        int kd;
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.xj xjVar;
        ws xj;
        x lq;
        com.bytedance.sdk.openadsdk.core.component.reward.layout.tf tfVar = (com.bytedance.sdk.openadsdk.core.component.reward.layout.tf) this.d;
        if (tfVar == null || (kd = tfVar.kd()) < 0 || kd >= this.z.size() || (xjVar = this.z.get(kd)) == null || (xj = xjVar.xj()) == null || (lq = xj.lq()) == null) {
            return 0;
        }
        return lq.w();
    }

    private com.bytedance.sdk.openadsdk.core.component.reward.layout.tf gj() {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.hf hfVar = this.d;
        if (hfVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.tf) {
            return (com.bytedance.sdk.openadsdk.core.component.reward.layout.tf) hfVar;
        }
        return null;
    }

    public static int hf(ws wsVar) {
        return 11;
    }

    public static boolean xj(ws wsVar) {
        if (wsVar == null || !x.xj(wsVar)) {
            return false;
        }
        if (!com.bytedance.sdk.openadsdk.core.zg.u.xj(String.valueOf(wo.d(wsVar)))) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", wsVar.jq());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        am.xj().xj(wsVar, "refresh_max", jSONObject);
        com.bytedance.sdk.openadsdk.core.am.u.c(wsVar, wo.hf(wsVar), "refresh_max", null);
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void am() {
        super.am();
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.tf) this.d).hf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int b() {
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int c(boolean z) {
        return z ? wo() : vm.c(this.hf) - this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public View d() {
        FrameLayout frameLayout = new FrameLayout(this.xj);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(0);
        return frameLayout;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void dk() {
        super.dk();
        com.bytedance.sdk.openadsdk.core.component.reward.layout.hf hfVar = this.d;
        if (hfVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.tf) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.tf) hfVar).tf();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean dq() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void en() {
        super.en();
        com.bytedance.sdk.openadsdk.core.component.reward.layout.hf hfVar = this.d;
        if (hfVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.tf) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.tf) hfVar).u();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void f() {
        super.f();
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.xj xjVar = new com.bytedance.sdk.openadsdk.core.component.reward.swiper.xj(this.xj, this.hf, this.f10322pl, s(), true);
        xjVar.xj(this.g);
        this.z.add(xjVar);
        if (x.w(this.hf)) {
            try {
                JSONArray jSONArray = new JSONArray(this.hf.mi());
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(com.bytedance.sdk.openadsdk.core.xj.xj(jSONArray.getJSONObject(i)));
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.hf);
                arrayList2.addAll(arrayList);
                if (x.xj(arrayList2)) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        com.bytedance.sdk.openadsdk.core.component.reward.swiper.xj xjVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.swiper.xj(this.xj, (ws) arrayList.get(i2), this.f10322pl, s(), false);
                        xjVar2.xj(this.g);
                        this.z.add(xjVar2);
                    }
                }
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void gh() {
        this.yo.xj(false);
        this.yo.hf(false);
        this.yo.kd(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void ht() {
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.tf) this.d).w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void kd(boolean z) {
        super.kd(z);
    }

    public void nb() {
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.tf) this.d).u();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void pz() {
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.tf) this.d).hf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int q() {
        return hf(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void qt() {
        super.qt();
        this.d.tf();
        List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.xj> list = this.z;
        if (list != null) {
            Iterator<com.bytedance.sdk.openadsdk.core.component.reward.swiper.xj> it = list.iterator();
            while (it.hasNext()) {
                it.next().f();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean s() {
        return true;
    }

    public void ss() {
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.tf) this.d).y();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean tu() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj, com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void w() {
        this.d.w(true);
        if (gj() != null) {
            gj().xj(this.z);
        }
        this.xj.hf(false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int wo() {
        return vm.w(this.hf) - this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public boolean y() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void hf(boolean z) {
        super.hf(z);
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.tf) this.d).w();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void hf(Map<String, Object> map) {
        super.hf(map);
        map.put("refresh_num", Integer.valueOf(cy()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.hf xj(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.tf tfVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.tf(this.xj, this.hf, z);
        tfVar.xj(new float[]{this.kd, this.y});
        this.d = tfVar;
        return tfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public hf.xj xj(ws wsVar, final com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar) {
        this.xj.ws();
        com.bytedance.sdk.openadsdk.core.component.reward.w.kd kdVar = new com.bytedance.sdk.openadsdk.core.component.reward.w.kd(this.xj, wsVar);
        kdVar.xj(r());
        return kdVar.hf(new com.bytedance.sdk.openadsdk.core.component.reward.w.tf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.p.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void hf() {
                com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.hf();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void w() {
                super.w();
                com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.w();
                }
                p.this.xj.eu();
                p.this.xj.wn().xj("reward_retain_dialog_next", 0, "");
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.tf
            public void xj() {
                super.xj();
                com.bytedance.sdk.openadsdk.core.component.reward.w.tf tfVar2 = tfVar;
                if (tfVar2 != null) {
                    tfVar2.xj();
                }
                p.this.xj.eu();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void xj(Map<String, Object> map) {
        super.xj(map);
        map.put("refresh_num", Integer.valueOf(cy()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void xj(JSONObject jSONObject) {
        super.xj(jSONObject);
        try {
            jSONObject.put("refresh_num", cy());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void xj(View view) {
        super.xj(view);
    }
}
