package com.bytedance.sdk.openadsdk.core.ugeno.c;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.kd.y;
import com.bytedance.adsdk.ugeno.w.am;
import com.bytedance.adsdk.ugeno.w.qt;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.adsdk.ugeno.w.zg;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y;
import com.bytedance.sdk.openadsdk.core.v;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y implements yo {
    private com.bytedance.adsdk.ugeno.hf.w c;
    private f d;
    private hf f;
    private int g;
    private com.bytedance.sdk.openadsdk.core.am.y hf;
    private w kd;
    private j p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10428pl;
    private tf tf;
    private u u;
    private com.bytedance.adsdk.ugeno.hf.w<View> w;
    private Context xj;
    private ws y;

    public y(Context context, com.bytedance.sdk.openadsdk.core.am.y yVar, ws wsVar, String str, int i) {
        this.xj = context;
        this.hf = yVar;
        this.y = wsVar;
        this.f10428pl = str;
        this.g = i;
    }

    @Override // com.bytedance.adsdk.ugeno.w.yo
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(JSONObject jSONObject, List<com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w> list, c cVar) {
        qt qtVar = new qt(this.xj);
        am amVar = new am();
        amVar.xj(this.xj);
        HashMap hashMap = new HashMap();
        hashMap.put("key_material", this.y);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size() && i <= 2; i++) {
            arrayList.add(list.get(i).xj());
        }
        j jVar = new j(this.xj);
        this.p = jVar;
        jVar.xj(this.tf);
        this.p.xj(this.f);
        this.p.xj(this.f10428pl);
        this.p.w(this.g);
        hashMap.put("key_data_list", arrayList);
        hashMap.put("key_js_object", this.p);
        amVar.xj(hashMap);
        qtVar.xj("aggPage", amVar);
        com.bytedance.adsdk.ugeno.hf.w<View> xj = qtVar.xj(jSONObject);
        this.w = xj;
        if (xj == null || list.size() <= 0) {
            com.bytedance.sdk.openadsdk.core.am.y yVar = this.hf;
            if (yVar != null) {
                yVar.xj(-1, "ugeno render fail");
            }
            if (cVar != null) {
                cVar.xj(-1, "");
                return;
            }
            return;
        }
        com.bytedance.adsdk.ugeno.hf.w<View> u = this.w.u("recycler_layout");
        this.c = u;
        if (u instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y) u).xj(list);
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y) this.c).xj(new y.hf() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.y.2
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y.hf
                public void xj() {
                    if (y.this.u != null) {
                        y.this.u.u(y.this.c);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y.hf
                public void xj(int i2, int i3) {
                    if (y.this.u != null) {
                        y.this.u.xj(i2, i3);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y.hf
                public void xj(RecyclerView recyclerView, int i2) {
                    if (y.this.u != null) {
                        y.this.u.xj(recyclerView, i2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y.hf
                public void xj(int i2, View view, com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w wVar) {
                    if (y.this.u != null) {
                        y.this.u.xj(y.this.c, i2, view, wVar);
                    }
                }
            });
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y) this.c).xj(new com.bytedance.sdk.openadsdk.core.ugeno.component.hf.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.y.3
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.u
                public void hf(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
                    if (y.this.u != null) {
                        y.this.u.y(wVar);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.hf.u
                public void xj(com.bytedance.adsdk.ugeno.hf.w<View> wVar) {
                    if (y.this.u != null) {
                        y.this.u.kd(wVar);
                    }
                }
            });
        }
        qtVar.xj(new com.bytedance.adsdk.ugeno.w.tf() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.y.4
            @Override // com.bytedance.adsdk.ugeno.w.tf
            public void xj(com.bytedance.adsdk.ugeno.hf.w wVar) {
                if (y.this.kd != null) {
                    y.this.kd.w(wVar);
                }
            }
        });
        qtVar.xj(this);
        JSONObject ac = this.y.ac();
        if (list.size() > 0) {
            try {
                ac.put("ugen_sub_meta", list.get(0).xj());
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
        qtVar.hf(ac);
        this.hf.xj(0L);
        if (cVar != null) {
            cVar.xj(this.w);
        }
    }

    public void xj(u uVar) {
        this.u = uVar;
    }

    public void xj(f fVar) {
        this.d = fVar;
    }

    public void xj(w wVar) {
        this.kd = wVar;
    }

    public void xj(final JSONObject jSONObject, final List<com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w> list, final c cVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hf(jSONObject, list, cVar);
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.y.1
                @Override // java.lang.Runnable
                public void run() {
                    y.this.hf(jSONObject, (List<com.bytedance.sdk.openadsdk.core.ugeno.component.hf.w>) list, cVar);
                }
            });
        }
    }

    public void xj(tf tfVar) {
        this.tf = tfVar;
    }

    public void xj(hf hfVar) {
        this.f = hfVar;
    }

    public com.bytedance.adsdk.ugeno.hf.w xj() {
        return this.c;
    }

    @Override // com.bytedance.adsdk.ugeno.w.yo
    public void xj(zg zgVar, yo.hf hfVar, yo.xj xjVar) {
        f fVar;
        if (zgVar == null) {
            return;
        }
        if (zgVar.hf() == 1) {
            hf(zgVar, (yo.hf) null, (yo.xj) null);
            return;
        }
        if (zgVar.hf() != 10 || (fVar = this.d) == null) {
            return;
        }
        fVar.hf(zgVar.xj());
        j jVar = this.p;
        if (jVar != null) {
            jVar.xj("webviewVisible", (JSONObject) null);
        }
    }

    private void hf(zg zgVar, yo.hf hfVar, yo.xj xjVar) {
        if (zgVar == null || zgVar.xj() == null) {
            return;
        }
        JSONObject w = zgVar.w();
        String optString = w.optString(PointParamKey.TYPE);
        String optString2 = w.optString("nodeId");
        optString.getClass();
        if (optString.equals("onDismiss")) {
            com.bytedance.adsdk.ugeno.hf.w<View> u = this.w.u(optString2);
            if (u != null) {
                u.hf(8);
            }
        } else if (!optString.equals("onShow")) {
            w wVar = this.kd;
            if (wVar != null) {
                wVar.w(zgVar.xj());
            }
        } else {
            com.bytedance.adsdk.ugeno.hf.w<View> u2 = this.w.u(optString2);
            if (u2 != null) {
                u2.hf(0);
            }
        }
        final String optString3 = w.optString("reportType");
        if (!TextUtils.isEmpty(optString3)) {
            com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.c.y.5
                @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt(PointParamKey.TYPE, optString3);
                    return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("agg_click").hf(jSONObject.toString());
                }
            }, "agg_click");
        }
        if (hfVar == null || zgVar.u() == null) {
            return;
        }
        hfVar.xj(zgVar.u());
    }
}
