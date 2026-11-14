package com.bytedance.sdk.openadsdk.core.component.reward.u;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.hf;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.et;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.a;
import com.bytedance.sdk.openadsdk.core.ra.dc;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.wn;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.czhj.sdk.common.Constants;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c extends xj {
    private boolean en;
    private com.bytedance.sdk.openadsdk.core.hf.xj ff;
    protected final AtomicBoolean j;
    private com.bytedance.sdk.openadsdk.core.component.reward.view.hf l;
    protected boolean z;

    public c(TTBaseVideoActivity tTBaseVideoActivity, ws wsVar) {
        super(tTBaseVideoActivity, wsVar);
        this.z = false;
        this.j = new AtomicBoolean(false);
    }

    private void cy() {
        if (this.f == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("is_auto_click", Boolean.TRUE);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) this.f.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(hashMap);
        this.f.xj(null, new com.bytedance.sdk.openadsdk.core.ra.tf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showSkip", z);
            com.bytedance.sdk.openadsdk.core.component.reward.layout.kd kdVar = this.tf;
            if (kdVar != null) {
                kdVar.xj("showSkipInLiveScene", jSONObject);
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }

    private void gj() {
        com.bytedance.sdk.openadsdk.core.hf.kd kdVar;
        if (this.z || (kdVar = this.f) == null) {
            return;
        }
        if (((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) kdVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).hf().p()) {
            this.z = true;
            hf(8, 0);
            return;
        }
        if (dc.xj(this.hf)) {
            int kd = dc.kd(this.hf);
            if (this.hf.rs() == 2) {
                hf(0, -1);
            }
            if (kd != 3) {
                return;
            }
            long c = dc.c(this.hf) * 1000;
            if (this.v.z() < c) {
                hf(0, (int) ((c - this.v.z()) / 1000));
                return;
            }
            hf(8, 0);
            cy();
            this.z = true;
        }
    }

    public static int hf(ws wsVar) {
        return 2;
    }

    private JSONObject ss() {
        JSONObject jSONObject = new JSONObject();
        a lv = this.hf.lv();
        if (lv != null) {
            String u = lv.u();
            if (!TextUtils.isEmpty(u)) {
                try {
                    String optString = new JSONObject(u).optString(Constants.TOKEN);
                    jSONObject.put("req_id", lv.y());
                    jSONObject.put(Constants.TOKEN, optString);
                    jSONObject.put("action", "query_box");
                    return jSONObject;
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        }
        return jSONObject;
    }

    private void u(int i) {
        com.bytedance.sdk.openadsdk.core.hf.kd kdVar = this.f;
        if (kdVar != null) {
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) kdVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(i);
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.u uVar = this.ra;
        if (uVar != null) {
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) uVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(i);
        }
        com.bytedance.sdk.openadsdk.core.nativeexpress.kd kdVar2 = this.ht;
        if (kdVar2 != null) {
            ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) kdVar2.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean bl() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public View d() {
        return this.w == 2 ? com.bytedance.sdk.openadsdk.res.kd.qt(this.xj) : com.bytedance.sdk.openadsdk.res.kd.zg(this.xj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean dq() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public boolean e() {
        if (this.en) {
            return true;
        }
        return (com.bytedance.sdk.openadsdk.core.live.hf.xj().hf(this.hf) || dc.w(this.hf)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public void gh() {
        if (y()) {
            this.yo.hf(false);
            this.yo.kd(false);
            this.d.y(8);
            this.d.kd(8);
            this.d.w(8);
            return;
        }
        this.yo.hf(this.hf.oz());
        this.yo.kd(true);
        this.d.y(0);
        this.d.kd(0);
        this.d.w(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void jk() {
        super.jk();
        nb();
        if (!this.tf.y()) {
            if (com.bytedance.sdk.openadsdk.core.live.hf.xj().hf(this.hf)) {
                gj();
                return;
            }
            if (dc.xj(this.hf) && this.l == null && !com.bytedance.sdk.openadsdk.core.hf.xj().get("is_reward_deep_link_to_live", false) && dc.kd(this.hf) != 1 && this.v.z() >= dc.c(this.hf) * 1000) {
                this.j.set(true);
                com.bytedance.sdk.openadsdk.core.component.reward.hf.y yVar = this.v;
                if (yVar != null && yVar.hf()) {
                    this.xj.ws();
                }
                this.l = new com.bytedance.sdk.openadsdk.core.component.reward.view.hf(this.xj, this.hf, new hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.c.2
                    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.hf.xj
                    public void hf(Dialog dialog) {
                        if (c.this.ff != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("is_auto_click", Boolean.TRUE);
                            ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) c.this.ff.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(hashMap);
                            c.this.ff.xj(null, new com.bytedance.sdk.openadsdk.core.ra.tf());
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.hf.xj
                    public void xj(Dialog dialog) {
                        c.this.l.dismiss();
                        c.this.xj.eu();
                        c.this.j.set(false);
                    }
                });
                com.bytedance.sdk.openadsdk.core.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.hf.xj(this.xj, this.hf, this.f10322pl, 7) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.c.3
                    @Override // com.bytedance.sdk.openadsdk.core.hf.hf, com.bytedance.sdk.openadsdk.core.hf.u
                    public void xj(View view, com.bytedance.sdk.openadsdk.core.ra.tf tfVar) {
                        super.xj(view, tfVar);
                        c.this.l.dismiss();
                    }
                };
                this.ff = xjVar;
                this.xj.xj((com.bytedance.sdk.openadsdk.core.hf.xj.w.w) xjVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.w.class));
                this.l.xj(this.ff);
                if (this.xj.isFinishing()) {
                    return;
                }
                this.l.show();
            }
        }
    }

    public void nb() {
        if (dc.xj(this.hf)) {
            a lv = this.hf.lv();
            if (lv != null || com.bytedance.sdk.openadsdk.core.live.hf.xj().hf(this.hf)) {
                int a2 = a();
                if (lv != null) {
                    lv.xj(a2);
                }
                u(a2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public int q() {
        return hf(this.hf);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean s() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.hf
    public boolean tu() {
        return s() && hl.xj(this.hf) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public boolean z() {
        return this.j.get();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void zg() {
        super.zg();
        this.yo.hf(this.hf.oz());
        this.yo.kd(true);
        this.d.y(0);
        this.d.kd(0);
        this.d.w(0);
    }

    public static boolean xj(ws wsVar) {
        return com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void hf(boolean z) {
        super.hf(z);
        if (!com.bytedance.sdk.openadsdk.core.hf.xj().get("is_reward_deep_link_to_live", false) || dc.w(this.hf) || z) {
            return;
        }
        pz.xj().xj(ss(), new dk.u() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.c.1
            @Override // com.bytedance.sdk.openadsdk.core.dk.u
            public void xj(int i, String str) {
                c.this.f(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.dk.u
            public void xj(et.w wVar) {
                wn wnVar = wVar.w;
                if (wnVar == null) {
                    return;
                }
                boolean xj = wnVar.xj();
                c.this.f(xj);
                if (xj) {
                    c.this.xj.u(0);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.hf xj(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.f fVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.f(this.xj, this.hf, z);
        this.d = fVar;
        return fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.u.xj
    public void xj(int i, int i2, Intent intent) {
        super.xj(i, i2, intent);
        if (dc.w(this.hf) || i != 1 || intent == null || intent.getExtras() == null || this.en) {
            return;
        }
        long j = intent.getExtras().getLong("csj.reward_countdown_duration_ms");
        int a2 = (int) (a() - j);
        this.xj.xj(a2, false);
        if (j <= 0) {
            f(true);
            u(0);
            this.en = true;
            return;
        }
        xj(a2);
    }

    private void hf(int i, int i2) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.hf hfVar = this.d;
        if (hfVar != null && (hfVar instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.f)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.f) hfVar).xj(i, i2);
        }
    }

    private void xj(long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showTime", j);
            com.bytedance.sdk.openadsdk.core.component.reward.layout.kd kdVar = this.tf;
            if (kdVar == null || !kdVar.y()) {
                return;
            }
            this.tf.xj("rewardInnerLiveShowTime", jSONObject);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
    }
}
