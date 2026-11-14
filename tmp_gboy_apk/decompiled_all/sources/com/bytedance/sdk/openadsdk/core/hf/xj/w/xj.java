package com.bytedance.sdk.openadsdk.core.hf.xj.w;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.ra.d;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.x;
import com.bytedance.sdk.openadsdk.core.zg.u;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends hf {
    protected String c;
    protected boolean f;
    protected d kd;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.video.hf.hf f10357pl;
    protected Map<String, Object> y;
    private int d = -1;
    private int tf = -1;
    private boolean g = false;

    public xj() {
    }

    private void y() {
        com.bytedance.sdk.component.u.hf.w xj = com.bytedance.sdk.openadsdk.core.hf.xj();
        long j = xj.get("click_to_live_duration", 0L);
        if (j == 0) {
            Map<String, Object> map = this.y;
            if (map != null) {
                map.remove("click_livead_duration");
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        HashMap hashMap = new HashMap();
        hashMap.put("click_livead_duration", Long.valueOf(currentTimeMillis));
        xj(hashMap);
        xj.get("click_to_live_duration", 0L);
    }

    public void hf(boolean z) {
        this.f = z;
    }

    public Map<String, Object> kd() {
        return this.y;
    }

    public d u() {
        int i = this.d;
        if (i != -1) {
            this.d = -1;
        } else {
            i = -1;
        }
        float y = r.y(this.hf);
        int f = r.f(this.hf);
        float c = r.c(this.hf);
        View c2 = this.w.c();
        View y2 = this.w.y();
        return new d.xj().y(this.w.am()).kd(this.w.qt()).u(this.w.zg()).w(this.w.e()).hf(this.w.pl()).xj(this.w.g()).hf(r.xj(c2)).xj(r.xj(y2)).w(r.w(c2)).u(r.w(y2)).w(this.w.hf()).u(this.w.w()).kd(this.w.u()).xj(this.w.tf()).hf(f.zg().w() ? 1 : 2).xj(this.p).xj(y).xj(f).hf(c).y(i).c(this.tf).f(this.w.v()).kd(this.w.yo()).xj(this.w.xj()).xj();
    }

    public String w() {
        return this.p;
    }

    public void xj(boolean z) {
        this.g = z;
    }

    public void hf() {
        this.tf = 1;
    }

    public void xj(String str) {
        this.c = str;
    }

    public void hf(String str) {
        this.p = str;
    }

    public void xj() {
        this.d = 1;
    }

    public void xj(d dVar) {
        this.kd = dVar;
    }

    public xj(ws wsVar, Context context) {
        this.xj = wsVar;
        this.hf = context;
        this.y = new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.xj.w.hf, com.bytedance.sdk.openadsdk.core.hf.xj.xj
    public int xj(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.hf.xj.w wVar) {
        if (this.g) {
            return 0;
        }
        com.bytedance.sdk.openadsdk.core.video.hf.hf hfVar = this.f10357pl;
        if (hfVar != null && hfVar.p() == 1) {
            return 0;
        }
        if (this.w == null) {
            this.w = new tf();
        }
        if ("splash_ad".equals(this.c) || "cache_splash_ad".equals(this.c) || "splash_ad_landingpage".equals(this.c)) {
            this.d = this.d == 1 ? 1 : 0;
        }
        Object obj = map.get("convert_res");
        boolean booleanValue = obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false;
        if (this.kd == null) {
            this.kd = u();
        }
        Object obj2 = map.get("is_reward_live");
        if (obj2 instanceof Boolean ? ((Boolean) obj2).booleanValue() : false) {
            y();
        }
        if (map.containsKey("reward_browse_banner_from")) {
            this.y.put("refer", "banner");
        }
        if (x.xj(this.xj) && !u.xj(String.valueOf(wo.d(this.xj))) && this.xj.lq() != null) {
            this.y.put("refresh_num", Integer.valueOf(this.xj.lq().w()));
        }
        Object obj3 = map.get("click_saas_action");
        if (obj3 != null && (obj3 instanceof Integer)) {
            this.y.put("click_saas_action", obj3);
        }
        Object obj4 = map.get("click_saas_area");
        if (obj3 != null && (obj3 instanceof Integer)) {
            this.y.put("click_saas_area", obj4);
        }
        xj(true);
        com.bytedance.sdk.openadsdk.core.am.u.xj("click", this.xj, this.kd, this.c, booleanValue, this.y, this.w.kd() ? 1 : 2, this.f);
        return 0;
    }

    public void xj(Map<String, Object> map) {
        Map<String, Object> map2 = this.y;
        if (map2 == null) {
            this.y = map;
        } else {
            map2.putAll(map);
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.core.video.hf.hf hfVar) {
        this.f10357pl = hfVar;
    }
}
