package com.bytedance.sdk.openadsdk.core.component.reward.xj;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.ht;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.am.xj;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.kd.hf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.n;
import com.bytedance.sdk.openadsdk.core.ra.tj;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.vm;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.xv;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.bytedance.sdk.openadsdk.core.ugeno.tf;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class y<T> extends com.bytedance.sdk.openadsdk.core.kd.hf<T> {
    public y(com.bytedance.sdk.openadsdk.core.kd.kd.hf hfVar) {
        super(hfVar);
    }

    public abstract void hf(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list, T t);

    @Override // com.bytedance.sdk.openadsdk.core.kd.hf, com.bytedance.sdk.openadsdk.core.kd.xj.xj
    public void xj(int i, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, ws wsVar) {
    }

    public abstract void xj(T t);

    public abstract boolean xj();

    public abstract boolean xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar);

    private void hf(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final ws wsVar, final com.bytedance.sdk.openadsdk.core.kd.kd.w wVar) {
        if (h.am(wsVar) == null) {
            return;
        }
        com.bykv.vk.openvk.component.video.api.w.u xj = h.xj(1, wsVar);
        xj.xj("material_meta", wsVar);
        xj.xj("ad_slot", hfVar);
        com.bytedance.sdk.openadsdk.core.video.u.hf.xj(xj, new com.bykv.vk.openvk.component.video.api.kd.hf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xj.y.3
            @Override // com.bykv.vk.openvk.component.video.api.kd.xj.InterfaceC0012xj
            public void xj(com.bykv.vk.openvk.component.video.api.w.u uVar, int i) {
                pl.xj("RewardSceneCacheStrategy", "RewardFullLog: Cached ad onVideoPreloadSuccess");
                com.bytedance.sdk.openadsdk.core.kd.kd.w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.hf();
                }
            }

            @Override // com.bykv.vk.openvk.component.video.api.kd.xj.InterfaceC0012xj
            public void xj(com.bykv.vk.openvk.component.video.api.w.u uVar, int i, String str) {
                pl.xj("RewardSceneCacheStrategy", "RewardFullLog: Cached ad onVideoPreloadFail");
                if (!h.pl(wsVar)) {
                    pl.xj("RewardSceneCacheStrategy", "RewardFullLog: Cached ad onVideoPreloadFail and block onCached");
                    return;
                }
                com.bytedance.sdk.openadsdk.core.kd.kd.w wVar2 = wVar;
                if (wVar2 != null) {
                    wVar2.hf();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.hf, com.bytedance.sdk.openadsdk.core.kd.xj.xj
    public boolean xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list) {
        ws wsVar = list.get(0);
        if (!com.bytedance.sdk.openadsdk.core.kd.u.xj(hfVar, wsVar, xj())) {
            return false;
        }
        new xj.C0138xj().kd(wsVar.ho()).xj(xj() ? "rewarded_video" : "fullscreen_interstitial_ad").u(wsVar.jf()).hf("get_preload_ad").xj(new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xj.y.1
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                if (hfVar.ra() != null) {
                    int xj = com.bytedance.sdk.openadsdk.core.wo.xj.y.xj(hfVar.ra());
                    if (xj == 1) {
                        jSONObject2.put("req_type", 1);
                    } else if (xj != 3) {
                        jSONObject2.put("req_type", -1);
                    } else {
                        jSONObject2.put("req_type", 3);
                    }
                }
                jSONObject2.put("preload_ad_type", 2);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.hf, com.bytedance.sdk.openadsdk.core.kd.xj.xj
    public void xj(int i, final List<ws> list, final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, final com.bytedance.sdk.openadsdk.core.kd.kd.kd<T> kdVar, Bundle bundle, final com.bytedance.sdk.openadsdk.core.kd.kd.c cVar) {
        final boolean z = bundle.getBoolean(PointParamKey.IS_CACHE, false);
        final boolean z2 = bundle.getBoolean("is_playAgain", false);
        final long j = bundle.getLong("start_time");
        final ws wsVar = list.get(0);
        xj(hfVar, list, (hf.xj) new hf.xj<T>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xj.y.2
            @Override // com.bytedance.sdk.openadsdk.core.kd.hf.xj
            public void xj(final T t) {
                for (ws wsVar2 : list) {
                    wsVar2.rz().hf();
                    wsVar2.f(z);
                    wsVar2.r(z ? 101 : 102);
                }
                y.this.hf(hfVar, list, (List<ws>) t);
                com.bytedance.sdk.openadsdk.core.kd.kd.w wVar = new com.bytedance.sdk.openadsdk.core.kd.kd.w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xj.y.2.1
                    private final AtomicBoolean w = new AtomicBoolean(false);

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.w
                    public void hf() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        if (j != 0) {
                            com.bytedance.sdk.openadsdk.core.am.u.hf(wsVar, wo.hf(y.this.xj() ? 7 : 8), j);
                        }
                        y.this.xj((y) t);
                        com.bytedance.sdk.openadsdk.core.kd.kd.kd kdVar2 = kdVar;
                        if (kdVar2 != 0) {
                            kdVar2.hf(t);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.w
                    public void w() {
                        if (this.w.compareAndSet(false, true)) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            y.this.xj(z, hfVar, (List<ws>) list);
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.bytedance.sdk.openadsdk.core.kd.kd.w
                    public void xj() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        y.this.xj(hfVar, (List<ws>) list, (List) t);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("is_play_again", z2);
                            jSONObject.put("is_from_cache", z);
                            jSONObject.put("is_adm", !TextUtils.isEmpty(hfVar.pz()));
                            jSONObject.put("cache_strategy", kd.xj(y.this.xj()));
                            jSONObject.put("src_req_id", wsVar.az());
                            jSONObject.put("is_map", wsVar.fc());
                            jSONObject.put("load_duration", System.currentTimeMillis() - j);
                        } catch (JSONException unused) {
                        }
                        am.xj().xj(wsVar, "stats_reward_full_ad_loaded", jSONObject);
                        com.bytedance.sdk.openadsdk.core.kd.kd.kd kdVar2 = kdVar;
                        if (kdVar2 != 0) {
                            kdVar2.xj(t);
                        }
                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                        y.this.xj(hfVar, wsVar, this);
                    }
                };
                com.bytedance.sdk.openadsdk.core.kd.kd.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.xj(wVar);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.hf, com.bytedance.sdk.openadsdk.core.kd.xj.xj
    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, int i, String str, com.bytedance.sdk.openadsdk.core.ra.hf hfVar2) {
        if (hfVar != null) {
            xj(hfVar.u(), i, str, hfVar2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.hf, com.bytedance.sdk.openadsdk.core.kd.xj.xj
    public void xj(int i, com.bytedance.sdk.openadsdk.core.ra.xj xjVar, com.bytedance.sdk.openadsdk.core.ra.hf hfVar, tj tjVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar2, com.bytedance.sdk.openadsdk.core.kd.kd.kd kdVar, com.bytedance.sdk.openadsdk.core.kd.kd.c cVar) {
        if (xjVar.hf() == null || xjVar.hf().isEmpty()) {
            if (cVar != null) {
                cVar.xj(-3);
                return;
            }
            return;
        }
        Bundle bundle = tjVar == null ? null : tjVar.qt;
        boolean z = bundle != null && bundle.getBoolean("is_preload", false);
        boolean z2 = bundle != null && bundle.getBoolean("is_playAgain", false);
        long j = bundle != null ? bundle.getLong("start_time", 0L) : 0L;
        xjVar.hf().size();
        ws wsVar = xjVar.hf().get(0);
        if (xj(hfVar2.u(), wsVar)) {
            return;
        }
        if (!wsVar.ap() || xj(xjVar)) {
            if (cVar != null) {
                cVar.xj(-4);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (xjVar.hf().size() > 1) {
            if (com.bytedance.sdk.openadsdk.core.ra.f.xj(i).xj("mix_ad", hfVar2, xjVar.hf().get(0))) {
                com.bytedance.sdk.openadsdk.core.xj.xj(xjVar.hf());
                arrayList.add(xjVar.hf().get(0));
            } else {
                arrayList.addAll(xjVar.hf());
            }
        } else {
            arrayList.addAll(xjVar.hf());
        }
        if (z) {
            com.bytedance.sdk.openadsdk.core.kd.kd.hf hfVar3 = this.xj;
            if (hfVar3 != null) {
                hfVar3.xj().xj(hfVar2, wsVar);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cache_strategy", kd.xj(xj()));
                jSONObject.put("src_req_id", wsVar.az());
                jSONObject.put("is_map", wsVar.fc());
            } catch (Exception unused) {
            }
            am.xj().xj(wsVar, "stats_reward_full_preload", jSONObject);
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("start_time", j);
        bundle2.putBoolean("is_playAgain", z2);
        bundle2.putBoolean(PointParamKey.IS_CACHE, false);
        xj(i, arrayList, hfVar2, kdVar, bundle2, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, int i, String str2, com.bytedance.sdk.openadsdk.core.ra.hf hfVar) {
        hfVar.xj(i);
        hfVar.hf(str2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cache_strategy", kd.xj(xj()));
            jSONObject.put(PluginConstants.KEY_APP_ID, com.bytedance.sdk.openadsdk.core.f.zg().pz());
            jSONObject.put("rit", str);
        } catch (Exception unused) {
        }
        hfVar.xj(jSONObject);
        com.bytedance.sdk.openadsdk.core.ra.hf.xj(hfVar);
    }

    public void xj(ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        hfVar.u();
        try {
            z uf = wsVar.uf();
            if (uf != null && !TextUtils.isEmpty(uf.xj())) {
                com.bytedance.sdk.openadsdk.core.et.w wVar = new com.bytedance.sdk.openadsdk.core.et.w(true);
                wVar.xj(hfVar.u());
                wVar.xj(8);
                wVar.w(wsVar.ho());
                wVar.u(wsVar.jf());
                wVar.hf(wo.g(wsVar));
                com.bytedance.sdk.openadsdk.f.hf.xj(uf).to(wVar);
            }
        } catch (Throwable unused) {
        }
        if (hl.tf(wsVar) && hl.y(wsVar) != null) {
            tf.xj(hl.y(wsVar).d(), hl.y(wsVar).tf(), (com.bytedance.sdk.openadsdk.core.ugeno.w) null);
        }
        if (xj()) {
            Iterator<xv> it = aq.jk(wsVar).iterator();
            while (it.hasNext()) {
                xv next = it.next();
                tf.xj(next.u(), next.kd(), (com.bytedance.sdk.openadsdk.core.ugeno.w) null);
            }
            Iterator<xv> it2 = n.kd(wsVar).iterator();
            while (it2.hasNext()) {
                xv next2 = it2.next();
                tf.xj(next2.u(), next2.kd(), (com.bytedance.sdk.openadsdk.core.ugeno.w) null);
            }
        }
        if (TextUtils.isEmpty(vm.p(wsVar))) {
            return;
        }
        tf.xj(vm.p(wsVar), vm.pl(wsVar), (com.bytedance.sdk.openadsdk.core.ugeno.w) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.hf
    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, List<ws> list, T t) {
        ws wsVar = list.get(0);
        com.bytedance.sdk.openadsdk.core.kd.kd.hf hfVar2 = this.xj;
        if (hfVar2 != null) {
            hfVar2.xj().xj(hfVar, wsVar, t, wsVar.ha());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.xj.xj
    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, ws wsVar, com.bytedance.sdk.openadsdk.core.kd.kd.w wVar) {
        xj(wsVar, hfVar);
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar)) {
            com.bytedance.sdk.openadsdk.core.video.w.xj.hf(wsVar);
            wVar.hf();
        } else {
            if (ht.w(wsVar)) {
                if (v.xj(wsVar) && com.bytedance.sdk.openadsdk.x.tf.xj(wsVar)) {
                    hf(hfVar, wsVar, wVar);
                }
                wVar.hf();
                return;
            }
            hf(hfVar, wsVar, wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xj(String str, ws wsVar) {
        if (!pz.hf().hf(str) || wsVar == null) {
            return false;
        }
        int i = xj() ? 7 : 8;
        ws hf = com.bytedance.sdk.openadsdk.core.component.reward.xj.xj.xj.xj().hf(xj(), str);
        if (hf == null) {
            return false;
        }
        if (hf.a() + hf.ra() < System.currentTimeMillis()) {
            com.bytedance.sdk.openadsdk.core.kd.u.kd.xj(i).xj(str);
            return true;
        }
        if (!TextUtils.equals(hf.en(), wsVar.en())) {
            if (com.bytedance.sdk.openadsdk.core.xj.xj(wsVar, xj() ? 7 : 8) != 200) {
                return true;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(wsVar.j());
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.get(next);
                hf.jb().put(next, jSONObject.get(next));
            }
            hf.ht(hf.jb().toString());
        } catch (Exception e) {
            pl.xj(e);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kd.xj.xj
    public void xj(final com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        if (pz.hf().hf(hfVar.u())) {
            tj tjVar = new tj();
            tjVar.xj = 2;
            if (pz.hf().tf(hfVar.u()) || hfVar.f() > 0.0f) {
                tjVar.y = 2;
            }
            pz.xj().hf(hfVar, tjVar, xj() ? 7 : 8, new dk.hf() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.xj.y.4
                @Override // com.bytedance.sdk.openadsdk.core.dk.hf
                public void xj(int i, String str, com.bytedance.sdk.openadsdk.core.ra.hf hfVar2) {
                    hfVar2.xj(i);
                    hfVar2.hf(str);
                    com.bytedance.sdk.openadsdk.core.ra.hf.xj(hfVar2);
                }

                @Override // com.bytedance.sdk.openadsdk.core.dk.hf
                public void xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar, com.bytedance.sdk.openadsdk.core.ra.hf hfVar2) {
                    if (xjVar.hf() == null || xjVar.hf().isEmpty()) {
                        y.this.xj(hfVar.u(), -3, com.bytedance.sdk.openadsdk.core.c.xj(-3), hfVar2);
                        return;
                    }
                    ws wsVar = xjVar.hf().get(0);
                    if (y.this.xj(hfVar.u(), wsVar)) {
                        return;
                    }
                    if (!wsVar.ap() || y.this.xj(xjVar)) {
                        y.this.xj(hfVar.u(), -4, com.bytedance.sdk.openadsdk.core.c.xj(-4), hfVar2);
                        return;
                    }
                    if (xjVar.hf().size() > 1) {
                        if (com.bytedance.sdk.openadsdk.core.ra.f.xj(y.this.xj() ? 7 : 8).xj("mix_ad", hfVar, wsVar)) {
                            com.bytedance.sdk.openadsdk.core.xj.xj(xjVar.hf());
                        }
                    }
                    if (((com.bytedance.sdk.openadsdk.core.kd.hf) y.this).xj != null) {
                        ((com.bytedance.sdk.openadsdk.core.kd.hf) y.this).xj.xj().xj(hfVar, wsVar);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("cache_strategy", kd.xj(y.this.xj()));
                        jSONObject.put("src_req_id", wsVar.az());
                        jSONObject.put("is_map", wsVar.fc());
                    } catch (Exception unused) {
                    }
                    am.xj().xj(wsVar, "stats_reward_full_preload", jSONObject);
                }
            });
        }
    }
}
