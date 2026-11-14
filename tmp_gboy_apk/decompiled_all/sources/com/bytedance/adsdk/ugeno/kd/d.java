package com.bytedance.adsdk.ugeno.kd;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.kd.hf.xj;
import com.bytedance.adsdk.ugeno.kd.w.hf;
import com.bytedance.adsdk.ugeno.kd.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class d implements p {
    private boolean c;
    private boolean f;
    private Map<String, List<com.bytedance.adsdk.ugeno.kd.w.hf>> hf;
    private com.bytedance.adsdk.ugeno.w.hf.xj kd;
    private com.bytedance.adsdk.ugeno.w.y u;
    private com.bytedance.adsdk.ugeno.hf.w w;
    private xj xj;
    private boolean y;

    public static class xj {
        public Map<String, com.bytedance.adsdk.ugeno.kd.w.hf> hf;
        public Map<String, List<com.bytedance.adsdk.ugeno.kd.w.hf>> xj;

        public xj(Map<String, List<com.bytedance.adsdk.ugeno.kd.w.hf>> map, Map<String, com.bytedance.adsdk.ugeno.kd.w.hf> map2) {
            this.xj = map;
            this.hf = map2;
        }
    }

    public d(com.bytedance.adsdk.ugeno.hf.w wVar, xj xjVar) {
        this.w = wVar;
        this.xj = xjVar;
        if (xjVar != null) {
            this.hf = xjVar.xj;
        }
        if (wVar != null && wVar.aq() && this.kd == null) {
            this.kd = new com.bytedance.adsdk.ugeno.w.hf.xj();
        }
    }

    public void hf() {
        List<com.bytedance.adsdk.ugeno.kd.w.hf> xj2 = xj("twist");
        if (xj2 == null || xj2.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.kd.w.hf hfVar : xj2) {
            if (hfVar != null) {
                hfVar.xj(this);
                hfVar.xj(new Object[0]);
            }
        }
    }

    public void kd() {
        List<com.bytedance.adsdk.ugeno.kd.w.hf> xj2 = xj("timer");
        if (xj2 == null || xj2.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.kd.w.hf hfVar : xj2) {
            if (hfVar != null) {
                hfVar.xj(this);
                hfVar.xj(new Object[0]);
            }
        }
    }

    public void u() {
        List<com.bytedance.adsdk.ugeno.kd.w.hf> xj2 = xj("animateState");
        if (xj2 == null || xj2.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.kd.w.hf hfVar : xj2) {
            if (hfVar != null) {
                hfVar.xj(this);
                hfVar.xj(new Object[0]);
            }
        }
    }

    public void w() {
        List<com.bytedance.adsdk.ugeno.kd.w.hf> value;
        xj xjVar = this.xj;
        if (xjVar == null) {
            return;
        }
        for (Map.Entry<String, List<com.bytedance.adsdk.ugeno.kd.w.hf>> entry : xjVar.xj.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !value.isEmpty()) {
                for (com.bytedance.adsdk.ugeno.kd.w.hf hfVar : value) {
                    if (hfVar instanceof com.bytedance.adsdk.ugeno.kd.w.w) {
                        hfVar.xj(this);
                        hfVar.xj(new Object[0]);
                    }
                }
            }
        }
    }

    public void xj(com.bytedance.adsdk.ugeno.w.y yVar) {
        this.u = yVar;
    }

    public void xj() {
        List<com.bytedance.adsdk.ugeno.kd.w.hf> xj2 = xj("shake");
        if (xj2 == null || xj2.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.kd.w.hf hfVar : xj2) {
            if (hfVar != null) {
                hfVar.xj(this);
                hfVar.xj(new Object[0]);
            }
        }
    }

    public boolean xj(MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.w.hf.xj xjVar;
        List<com.bytedance.adsdk.ugeno.kd.w.hf> xj2 = xj("touchStart");
        if (xj2 != null && !xj2.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.kd.w.hf hfVar : xj2) {
                if (hfVar instanceof com.bytedance.adsdk.ugeno.kd.w.f) {
                    hfVar.xj(this);
                    hfVar.xj(motionEvent);
                }
            }
        }
        List<com.bytedance.adsdk.ugeno.kd.w.hf> xj3 = xj("touchEnd");
        List<com.bytedance.adsdk.ugeno.kd.w.hf> xj4 = xj("tap");
        List<com.bytedance.adsdk.ugeno.kd.w.hf> xj5 = xj("slide");
        if (xj2 != null && !xj2.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.kd.w.hf hfVar2 : xj3) {
                if (hfVar2 instanceof com.bytedance.adsdk.ugeno.kd.w.c) {
                    hfVar2.xj(this);
                    this.f = hfVar2.xj(motionEvent);
                }
            }
        }
        if ((xj4 != null && !xj4.isEmpty()) || (xj5 != null && !xj5.isEmpty())) {
            if (this.f && motionEvent.getAction() == 1) {
                return true;
            }
            com.bytedance.adsdk.ugeno.w.hf.xj xjVar2 = this.kd;
            if (xjVar2 != null) {
                if (xjVar2.xj(motionEvent)) {
                    return false;
                }
                this.kd.xj(this.w, motionEvent);
            }
            if (xj4 != null && !xj4.isEmpty()) {
                for (com.bytedance.adsdk.ugeno.kd.w.hf hfVar3 : xj4) {
                    if (hfVar3 instanceof com.bytedance.adsdk.ugeno.kd.w.kd) {
                        hfVar3.xj(this);
                        this.y = hfVar3.xj(motionEvent);
                    }
                }
            }
            int action = motionEvent.getAction();
            if ((action == 1 || action == 3) && this.y) {
                return true;
            }
            if (xj5 != null && !xj5.isEmpty()) {
                for (com.bytedance.adsdk.ugeno.kd.w.hf hfVar4 : xj5) {
                    if (hfVar4 instanceof com.bytedance.adsdk.ugeno.kd.w.u) {
                        hfVar4.xj(this);
                        this.c = hfVar4.xj(motionEvent);
                    }
                }
            }
            if ((action == 1 || action == 3) && !this.y && !this.c && (xjVar = this.kd) != null) {
                xjVar.xj(this.w);
            }
            return this.y || this.c;
        }
        return this.f;
    }

    private void xj(String str, List<y.xj> list) {
        com.bytedance.adsdk.ugeno.kd.hf.xj xj2;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (y.xj xjVar : list) {
            if (xjVar != null && (xj2 = xj.C0027xj.xj(this.w, str, xjVar)) != null) {
                xj2.xj();
                xj2.hf();
            }
        }
    }

    public List<com.bytedance.adsdk.ugeno.kd.w.hf> xj(String str) {
        Map<String, List<com.bytedance.adsdk.ugeno.kd.w.hf>> map = this.hf;
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.hf.get(str);
    }

    @Override // com.bytedance.adsdk.ugeno.kd.p
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, List<y.xj> list) {
        xj(str, list);
    }

    public static d xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str) {
        com.bytedance.adsdk.ugeno.kd.w.hf xj2;
        if (wVar != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    return null;
                }
                xj xjVar = new xj(new HashMap(), new HashMap());
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null && (xj2 = hf.xj.xj(wVar.d().getContext(), wVar, optJSONObject, wVar.tf())) != null) {
                        if (xjVar.xj.containsKey(xj2.c())) {
                            List<com.bytedance.adsdk.ugeno.kd.w.hf> list = xjVar.xj.get(xj2.c());
                            if (list == null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(xj2);
                                xjVar.xj.put(xj2.c(), arrayList);
                            } else {
                                list.add(xj2);
                            }
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(xj2);
                            xjVar.xj.put(xj2.c(), arrayList2);
                        }
                        xjVar.hf.put(xj2.f(), xj2);
                    }
                }
                return new d(wVar, xjVar);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
            }
        }
        return null;
    }
}
