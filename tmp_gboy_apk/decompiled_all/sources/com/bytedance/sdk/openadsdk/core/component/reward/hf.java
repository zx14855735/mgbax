package com.bytedance.sdk.openadsdk.core.component.reward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.hf;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.ht;
import com.bytedance.sdk.openadsdk.core.a.q;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.am.xj;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoLandscapeActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.xj.kd;
import com.bytedance.sdk.openadsdk.core.pl.f;
import com.bytedance.sdk.openadsdk.core.pl.hf.xj;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationFullScreenManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.u;
import com.bytedance.sdk.openadsdk.x.c;
import com.bytedance.sdk.openadsdk.zg.w.hf.p;
import com.czhj.sdk.common.Constants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends p {
    private com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj am;
    private final String c;
    private com.bytedance.sdk.openadsdk.zg.w.w.hf g;
    private final ws hf;
    private long kd;
    private com.bytedance.sdk.openadsdk.core.pl.hf.xj qt;
    private String u;
    private final Context xj;
    private com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.w zg;
    private final AtomicBoolean y = new AtomicBoolean(false);
    private int f = -1;
    private Double d = null;
    private boolean tf = false;
    private boolean p = false;

    /* renamed from: pl, reason: collision with root package name */
    private long f10309pl = System.currentTimeMillis();
    private boolean w = false;

    public hf(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        this.xj = context;
        this.hf = wsVar;
        this.g = hfVar;
        this.c = wsVar.hashCode() + wsVar.zf() + hashCode();
    }

    private void d() {
        com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj xjVar = this.am;
        if (xjVar != null) {
            xj.xj(this.c, xjVar);
        }
    }

    public void c() {
        if (this.hf == null || this.g == null || pz.hf().xw() != 0) {
            return;
        }
        try {
            boolean z = this.w;
            if (this.g == null || !z) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.component.reward.xj.hf.xj().xj(this.g);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public u kd() {
        return new MediationFullScreenManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public long u() {
        return this.kd;
    }

    public void y() {
        if (this.y.get()) {
            return;
        }
        this.w = true;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public Map<String, Object> hf() {
        ws wsVar = this.hf;
        if (wsVar == null) {
            return null;
        }
        Map<String, Object> pu = wsVar.pu();
        pu.put("expireTimestamp", Long.valueOf(u()));
        pu.put("adSceneType", Integer.valueOf(com.bytedance.sdk.openadsdk.core.component.reward.u.u.xj(this.hf)));
        return pu;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public int w() {
        ws wsVar = this.hf;
        if (wsVar == null) {
            return -1;
        }
        if (ht.w(wsVar)) {
            return 2;
        }
        if (ht.u(this.hf)) {
            return 1;
        }
        return com.bytedance.sdk.openadsdk.core.video.w.xj.xj(this.hf) ? 3 : 0;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.w wVar) {
        this.zg = wVar;
    }

    public void xj(int i) {
        this.f = i;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public void xj(com.bytedance.sdk.openadsdk.ra.xj.hf.xj.xj xjVar) {
        if (this.y.get()) {
            xj.xj(this.c, xjVar);
        }
        this.am = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void hf(Double d) {
        this.d = d;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        this.qt = xj.C0177xj.xj(wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public int xj() {
        ws wsVar = this.hf;
        if (wsVar == null) {
            return -1;
        }
        return wsVar.vw();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public void xj(Activity activity) {
        Intent intent;
        ws wsVar = this.hf;
        String jf = wsVar != null ? wsVar.jf() : "";
        ws wsVar2 = this.hf;
        new xj.C0138xj().kd(wsVar2 != null ? wsVar2.ho() : Constants.FAIL).xj("fullscreen_interstitial_ad").hf("show_start").u(jf).xj((com.bytedance.sdk.openadsdk.y.xj.xj) null);
        if (activity != null && activity.isFinishing()) {
            pl.u("TTFullScreenVideoAdImpl", "showFullScreenVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.y.get()) {
            return;
        }
        this.y.set(true);
        ws wsVar3 = this.hf;
        if (wsVar3 != null) {
            if (h.am(wsVar3) == null && this.hf.lx() == null) {
                return;
            }
            if (xj() == 4) {
                c.xj(new d("full_register_download") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.1
                    @Override // java.lang.Runnable
                    public void run() {
                        f.xj(hf.this.xj, hf.this.hf, "fullscreen_interstitial_ad", false).xj(hf.this.qt);
                    }
                });
            }
            com.bytedance.sdk.openadsdk.core.hf.xj().get("full_video_show_time", System.currentTimeMillis());
            Context context = activity == null ? this.xj : activity;
            if (context == null) {
                context = pz.getContext();
            }
            d();
            if (this.hf.rs() == 2) {
                intent = new Intent(context, (Class<?>) TTFullScreenVideoLandscapeActivity.class);
            } else {
                intent = new Intent(context, (Class<?>) TTFullScreenVideoActivity.class);
            }
            if (activity == null) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            if (this.g != null) {
                intent.putExtra("is_adm", !TextUtils.isEmpty(r7.pz()));
            }
            intent.putExtra("is_preload", this.w);
            intent.putExtra("object_create_ts", this.f10309pl);
            Double d = this.d;
            intent.putExtra("_client_bidding_aution_price", d != null ? String.valueOf(d) : "");
            if (!TextUtils.isEmpty(this.u)) {
                intent.putExtra("rit_scene", this.u);
            }
            int i = this.f;
            if (i != -1) {
                intent.putExtra("key_video_cache_callback", i);
            }
            wo.xj(intent, this.hf);
            intent.putExtra("multi_process_key", this.c);
            com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.w wVar = this.zg;
            if (wVar != null) {
                intent.putExtra("insert_ad_bundle", wVar.d().toString());
            }
            xj(context, intent);
            com.bytedance.sdk.openadsdk.core.c.u.xj().xj(this.hf).xj(8);
        }
    }

    private void xj(Context context, Intent intent) {
        com.bytedance.sdk.component.utils.hf.xj(context, intent, new hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.2
            @Override // com.bytedance.sdk.component.utils.hf.xj
            public void xj() {
            }

            @Override // com.bytedance.sdk.component.utils.hf.xj
            public void xj(Throwable th) {
                pl.w("TTFullScreenVideoAdImpl", "show full screen video error: ", th);
            }
        });
        if (this.g == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.xj.xj.xj xj = com.bytedance.sdk.openadsdk.core.component.reward.xj.xj.xj.xj();
        com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar = this.g;
        xj.xj(hfVar, hfVar.u());
        kd.xj(false, false).xj(this.hf);
        c();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.p
    public void xj(Activity activity, Object obj, String str) {
        if (obj == null) {
            pl.u("TTFullScreenVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        String xj = com.bytedance.sdk.openadsdk.core.wo.xj.kd.xj(obj);
        if ("customize_scenes".equalsIgnoreCase(xj)) {
            this.u = str;
        } else {
            this.u = xj;
        }
        xj(activity);
    }

    public void xj(long j) {
        this.kd = j;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d) {
        if (this.tf) {
            return;
        }
        q.xj(this.hf, d);
        this.tf = true;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d, String str, String str2) {
        if (this.p) {
            return;
        }
        q.xj(this.hf, d, str, str2);
        this.p = true;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
        ws wsVar = this.hf;
        if (wsVar != null) {
            com.bytedance.sdk.openadsdk.core.ht.xj(wsVar.ke(), hfVar, com.bytedance.sdk.openadsdk.zg.w.xj.hf.class);
        }
    }
}
