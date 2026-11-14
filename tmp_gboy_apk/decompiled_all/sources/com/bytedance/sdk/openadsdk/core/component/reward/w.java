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
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoLandscapeActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.u.u;
import com.bytedance.sdk.openadsdk.core.component.reward.xj.f;
import com.bytedance.sdk.openadsdk.core.component.reward.xj.kd;
import com.bytedance.sdk.openadsdk.core.pl.hf.xj;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.n;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationRewardManagerDefault;
import com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.y;
import com.bytedance.sdk.openadsdk.x.c;
import com.bytedance.sdk.openadsdk.zg.w.hf.qt;
import com.czhj.sdk.common.Constants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w extends qt {
    private boolean am;
    private com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj d;
    private com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.w dk;
    private String e;
    private com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj f;
    private int g;
    private final ws hf;
    private String kd;
    private com.bytedance.sdk.openadsdk.core.pl.hf.xj p;

    /* renamed from: pl, reason: collision with root package name */
    private String f10324pl;
    private com.bytedance.sdk.openadsdk.io.xj.hf.xj.hf tf;
    private final com.bytedance.sdk.openadsdk.zg.w.w.hf w;
    private final Context xj;
    private long y;
    private boolean yo;
    private String zg;
    private final AtomicBoolean c = new AtomicBoolean(false);
    private int qt = 1;
    private int v = -1;
    private Double jk = null;
    private boolean pz = false;
    private boolean ht = false;
    private long ra = System.currentTimeMillis();
    private boolean u = false;

    public w(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        this.xj = context;
        this.hf = wsVar;
        this.w = hfVar;
        this.f10324pl = wsVar.hashCode() + wsVar.zf() + hashCode();
    }

    private void d() {
        com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar = this.f;
        if (xjVar != null) {
            xj.xj(this.f10324pl, xjVar);
        }
        if (this.d != null) {
            xj.xj(n.xj(this.f10324pl), this.d);
        }
        if (this.tf != null) {
            hf(true);
            xj.xj(n.hf(this.f10324pl), this.tf);
        }
    }

    public void c() {
        if (this.hf == null || this.w == null || this.am || pz.hf().xw() != 0) {
            return;
        }
        try {
            if (this.u) {
                f.xj().xj(this.w);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public y kd() {
        return new MediationRewardManagerDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public long u() {
        return this.y;
    }

    public void y() {
        if (this.c.get()) {
            return;
        }
        this.u = true;
    }

    public void hf(int i) {
        this.qt = i;
    }

    public void w(int i) {
        this.v = i;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.w wVar) {
        this.dk = wVar;
    }

    public void hf(String str) {
        this.e = str;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
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

    public void xj(int i) {
        this.g = i;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public void hf(com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar) {
        if (this.c.get()) {
            xj.xj(n.xj(this.f10324pl), xjVar);
        } else {
            this.d = xjVar;
        }
    }

    public void xj(String str) {
        this.zg = str;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public void xj(com.bytedance.sdk.openadsdk.io.xj.hf.xj.xj xjVar) {
        if (this.c.get()) {
            xj.xj(this.f10324pl, xjVar);
        } else {
            this.f = xjVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public Map<String, Object> hf() {
        ws wsVar = this.hf;
        if (wsVar == null) {
            return null;
        }
        Map<String, Object> pu = wsVar.pu();
        pu.put("expireTimestamp", Long.valueOf(u()));
        pu.put("adSceneType", Integer.valueOf(u.xj(this.hf)));
        return pu;
    }

    public void w(String str) {
        this.f10324pl = str;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public void xj(com.bytedance.sdk.openadsdk.io.xj.hf.xj.hf hfVar) {
        if (this.c.get()) {
            hf(true);
            xj.xj(n.hf(this.f10324pl), hfVar);
        } else {
            this.tf = hfVar;
        }
    }

    public void hf(boolean z) {
        this.yo = z;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void hf(Double d) {
        this.jk = d;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        this.p = xj.C0177xj.xj(wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public int xj() {
        ws wsVar = this.hf;
        if (wsVar == null) {
            return -1;
        }
        return wsVar.vw();
    }

    public void xj(long j) {
        this.y = j;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public void xj(Activity activity) {
        Intent intent;
        ws wsVar = this.hf;
        String jf = wsVar != null ? wsVar.jf() : "";
        ws wsVar2 = this.hf;
        new xj.C0138xj().kd(wsVar2 != null ? wsVar2.ho() : Constants.FAIL).xj("rewarded_video").hf("show_start").u(jf).xj((com.bytedance.sdk.openadsdk.y.xj.xj) null);
        if (activity != null && activity.isFinishing()) {
            pl.u("TTRewardVideoAdImpl", "showRewardVideoAd error1: activity is finishing");
            activity = null;
        }
        if (this.c.get()) {
            return;
        }
        this.c.set(true);
        ws wsVar3 = this.hf;
        if (wsVar3 == null || h.am(wsVar3) == null) {
            return;
        }
        if (xj() == 4) {
            c.xj(new d("reward_register_download") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.pl.f.xj(w.this.xj, w.this.hf, "rewarded_video", false).xj(w.this.p);
                }
            });
        }
        com.bytedance.sdk.openadsdk.core.hf.xj().put("reward_video_show_time", System.currentTimeMillis());
        Context context = activity == null ? this.xj : activity;
        if (context == null) {
            context = pz.getContext();
        }
        d();
        if (this.hf.rs() == 2) {
            intent = new Intent(context, (Class<?>) TTRewardVideoLandscapeActivity.class);
        } else {
            intent = new Intent(context, (Class<?>) TTRewardVideoActivity.class);
        }
        if (activity == null) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        if (this.am) {
            intent.putExtra("is_play_again", true);
            intent.putExtra("play_again_count", this.qt);
        } else {
            this.g = wo.d(this.hf);
        }
        intent.putExtra("source_rit_id", this.g);
        intent.putExtra("custom_play_again", this.yo);
        com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar = this.w;
        if (hfVar != null) {
            intent.putExtra("media_extra", hfVar.g());
            intent.putExtra("userData", this.w.ht());
            intent.putExtra("user_id", this.w.am());
            intent.putExtra(MediationConstant.REWARD_NAME, this.w.dk());
            intent.putExtra(MediationConstant.REWARD_AMOUNT, this.w.et());
            intent.putExtra("is_adm", !TextUtils.isEmpty(this.w.pz()));
        }
        if (this.am && !TextUtils.isEmpty(this.zg) && !TextUtils.isEmpty(this.e)) {
            intent.putExtra("reward_again_name", this.zg);
            intent.putExtra("reward_again_amount", this.e);
        }
        intent.putExtra("is_preload", this.u);
        intent.putExtra("object_create_ts", this.ra);
        Double d = this.jk;
        intent.putExtra("_client_bidding_aution_price", d != null ? String.valueOf(d) : "");
        if (!TextUtils.isEmpty(this.kd)) {
            intent.putExtra("rit_scene", this.kd);
        }
        int i = this.v;
        if (i != -1) {
            intent.putExtra("key_video_cache_callback", i);
        }
        wo.xj(intent, this.hf);
        intent.putExtra("multi_process_key", this.f10324pl);
        com.bytedance.sdk.openadsdk.core.component.reward.business.insertad.w wVar = this.dk;
        if (wVar != null) {
            intent.putExtra("insert_ad_bundle", wVar.d().toString());
        }
        xj(context, intent);
        com.bytedance.sdk.openadsdk.core.c.u.xj().xj(this.hf).xj(7);
    }

    private void xj(Context context, Intent intent) {
        com.bytedance.sdk.component.utils.hf.xj(context, intent, new hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.w.2
            @Override // com.bytedance.sdk.component.utils.hf.xj
            public void xj() {
            }

            @Override // com.bytedance.sdk.component.utils.hf.xj
            public void xj(Throwable th) {
                pl.w("TTRewardVideoAdImpl", "show reward video error: ", th);
            }
        });
        if (this.w == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.component.reward.xj.xj.xj xj = com.bytedance.sdk.openadsdk.core.component.reward.xj.xj.xj.xj();
        com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar = this.w;
        xj.xj(hfVar, hfVar.u());
        if (n.xj(this.hf)) {
            com.bytedance.sdk.openadsdk.core.component.reward.xj.xj.xj.xj().hf(this.w, n.u(this.hf));
        }
        kd.xj(true, this.am).xj(this.hf);
        c();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.qt
    public void xj(Activity activity, Object obj, String str) {
        if (obj == null) {
            pl.u("TTRewardVideoAdImpl", "The param ritScenes can not be null!");
            return;
        }
        String xj = com.bytedance.sdk.openadsdk.core.wo.xj.kd.xj(obj);
        if ("customize_scenes".equalsIgnoreCase(xj)) {
            this.kd = str;
        } else {
            this.kd = xj;
        }
        xj(activity);
    }

    public void xj(boolean z) {
        this.am = z;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d) {
        if (this.pz) {
            return;
        }
        q.xj(this.hf, d);
        this.pz = true;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d, String str, String str2) {
        if (this.ht) {
            return;
        }
        q.xj(this.hf, d, str, str2);
        this.ht = true;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
        ws wsVar = this.hf;
        if (wsVar != null) {
            com.bytedance.sdk.openadsdk.core.ht.xj(wsVar.ke(), hfVar, com.bytedance.sdk.openadsdk.zg.w.xj.hf.class);
        }
    }
}
