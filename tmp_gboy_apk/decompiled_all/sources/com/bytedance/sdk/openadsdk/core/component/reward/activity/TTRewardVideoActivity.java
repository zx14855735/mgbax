package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.f.xj.w;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.dk;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.tf;
import com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.component.reward.layout.kd;
import com.bytedance.sdk.openadsdk.core.component.reward.xj.f;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.et;
import com.bytedance.sdk.openadsdk.core.f.u;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.ht.xj.hf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.j;
import com.bytedance.sdk.openadsdk.core.ra.n;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.vm;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.p.xj.xj;
import com.sigmob.windad.WindAds;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private int cy;
    private String gj;
    private w h;
    private String nb;
    private String ss;
    private String xv;
    private final int bl = 10111;
    private final int lw = 10112;
    private final int wa = 10113;
    private final int gh = 10114;
    private final int op = 10115;
    private final int gy = 10116;
    private final AtomicBoolean vl = new AtomicBoolean();

    private int cy() {
        final int i = 0;
        if (aq.u(this.kd)) {
            if (this.qt.get()) {
                i = 10116;
            } else if (!gj()) {
                i = 10111;
            }
        }
        if (pz.hf().js() == 0) {
            return i;
        }
        boolean f = dk.f();
        int xj = dk.xj(this.kd.fa() + "_" + this.kd.lt());
        if (f) {
            i = 10115;
        } else if (xj == dk.hf) {
            i = 10114;
        } else if (xj == dk.w) {
            i = 10113;
        }
        am.xj().hf(new xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.6
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                hf<hf> hf = hf.hf();
                hf.xj("armor_reward");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(MediationConstant.KEY_ERROR_CODE, i);
                hf.hf(jSONObject.toString());
                return hf;
            }
        }, "armor_reward");
        return i;
    }

    private boolean gj() {
        if (TextUtils.isEmpty(this.kd.zf())) {
            return false;
        }
        return this.vl.get();
    }

    private void ss() {
        kd kdVar;
        if (aq.c(this.kd) && this.f10297a.pz() >= aq.tf(this.kd)) {
            if (!this.b.c() || (kdVar = this.z) == null || kdVar.d() != 0) {
                r.xj(this.ws, aq.d(this.kd), 0);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("toast_text", aq.d(this.kd));
                this.z.xj("showToast", jSONObject);
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
    }

    private void xv() {
        this.z.xj("cancelClickLandingRewardTip", (JSONObject) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean ai() {
        return this.qd.xj() || this.dq.u();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean dk() {
        return super.dk() || this.qd.kd();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String en() {
        if (this.qd.xj() && !TextUtils.isEmpty(this.qd.c()) && !TextUtils.isEmpty(this.qd.y())) {
            return this.qd.y();
        }
        return z();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void f(int i) {
        if (!this.u.containsKey(0)) {
            this.hf.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    x.xj(TTRewardVideoActivity.this.ws, "当前不满足条件，下次记得看完视频哦～", 1);
                }
            });
        } else if (vm.xj(this.kd)) {
            this.hf.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    x.xj(TTRewardVideoActivity.this.ws, "非常抱歉，当前不支持再看一个", 1);
                }
            });
        } else {
            this.qd.w(i);
        }
    }

    public void gy() {
        if (j.hf(io(), this.kd, true)) {
            if (this.dq.xj() > this.b.a()) {
                this.dq.xj(false);
            }
            int max = Math.max(this.b.y(true) - this.dq.xj(), 0);
            int y = this.b.y(false) - this.dq.xj();
            if (this.u.containsKey(0)) {
                max = 999;
                y = 999;
            }
            tf(y);
            p(max);
            if (this.u.containsKey(0)) {
                w(0, true);
            }
            op();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean io() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String j() {
        if (this.qd.xj() && !TextUtils.isEmpty(this.qd.c()) && !TextUtils.isEmpty(this.qd.y())) {
            return this.qd.c();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(q());
        return sb.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void jk() {
        super.jk();
        gy();
    }

    public boolean nb() {
        return Math.round(((float) ((((long) this.b.yy()) * 1000) + this.f10297a.z())) / 1000.0f) >= this.b.hl();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.l.l()) {
            return;
        }
        this.b.xj(i, i2, intent);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity, android.app.Activity
    public void onDestroy() {
        w wVar;
        super.onDestroy();
        this.qd.w();
        List<w> xj = com.bytedance.sdk.component.f.hf.xj.xj();
        if (xj == null || xj.size() == 0 || (wVar = this.h) == null) {
            return;
        }
        xj.remove(wVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (aq.e(this.kd)) {
            this.b.w(u.hf);
            u.w = false;
            u.hf = 0;
            u.xj = this.b.r();
            w(0);
        }
        if (aq.v(this.kd) && u.u) {
            xv();
            u(4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public int q() {
        if (this.cy != 0 && !TextUtils.isEmpty(this.gj)) {
            return this.cy;
        }
        if (aq.hf(this.kd) == 0 || TextUtils.isEmpty(aq.xj(this.kd))) {
            return 0;
        }
        return aq.hf(this.kd);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void u() {
        w wVar = new w() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.1
            @Override // com.bytedance.sdk.component.f.xj.w
            public void xj(String str, String str2) {
                if (((BaseThemeActivity) TTRewardVideoActivity.this).kd != null) {
                    String zf = ((BaseThemeActivity) TTRewardVideoActivity.this).kd.zf();
                    if (TextUtils.equals("show", str) && TextUtils.equals(str2, zf)) {
                        TTRewardVideoActivity.this.vl.set(true);
                    }
                }
            }
        };
        this.h = wVar;
        com.bytedance.sdk.component.f.hf.xj.xj(wVar);
        super.u();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void x() {
        if (this.w.getAndSet(true) || this.qd.xj() || j.hf(io(), this.kd, true)) {
            return;
        }
        u("onAdClose");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void yy() {
        super.yy();
        if (aq.e(this.kd) || this.l.q() || v.u(this.kd)) {
            return;
        }
        if (this.f10297a.l()) {
            this.en.xj(false, null, null, true, true);
            return;
        }
        int y = this.b.y(true);
        int y2 = this.b.y(j.hf(io(), this.kd, true));
        String str = "已领取奖励";
        if (nb() || this.b.e()) {
            com.bytedance.sdk.openadsdk.core.component.reward.hf.kd kdVar = this.en;
            if (y2 > 0) {
                str = y2 + "s";
            }
            kdVar.xj(false, str, "跳过", false, true);
        } else {
            com.bytedance.sdk.openadsdk.core.component.reward.hf.kd kdVar2 = this.en;
            if (y2 > 0) {
                str = y2 + "s";
            }
            kdVar2.xj(false, str, null, false, false);
        }
        this.b.hf(y);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String z() {
        return (this.cy == 0 || TextUtils.isEmpty(this.gj)) ? (aq.hf(this.kd) == 0 || TextUtils.isEmpty(aq.xj(this.kd))) ? "" : aq.xj(this.kd) : this.gj;
    }

    private JSONObject hf(int i, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oversea_version_type", 0);
            jSONObject.put(MediationConstant.REWARD_NAME, z());
            jSONObject.put(MediationConstant.REWARD_AMOUNT, q());
            jSONObject.put("network", com.bytedance.sdk.component.utils.am.w(pz.getContext()));
            jSONObject.put(PluginConstants.KEY_SDK_VERSION, ai.u);
            jSONObject.put("user_agent", tf.g());
            jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, this.kd.jb());
            jSONObject.put("media_extra", this.nb);
            jSONObject.put("video_duration", this.f10297a.ai());
            jSONObject.put("play_start_ts", this.vm);
            jSONObject.put("play_end_ts", System.currentTimeMillis() / 1000);
            jSONObject.put(MediationConstant.EXTRA_DURATION, this.f10297a.pz());
            jSONObject.put("user_id", this.ss);
            jSONObject.put(WindAds.TRANS_ID, UUID.randomUUID().toString().replace("-", ""));
            jSONObject.put(WindAds.REWARD_TYPE, i);
            if (aq.u(this.kd)) {
                jSONObject.put("show_result", z ? 1 : 0);
            }
            com.bytedance.sdk.openadsdk.qt.hf.xj(this.ws, jSONObject);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void w(int i) {
        if (i != 0) {
            u(i);
            return;
        }
        if (this.b.a() > 0) {
            return;
        }
        if ((!aq.io(this.kd) || this.c.get()) && this.b.j()) {
            u(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void u(final int i) {
        if (!this.e.getAndSet(true)) {
            this.qd.u();
        }
        if (this.u.containsKey(Integer.valueOf(i))) {
            return;
        }
        this.u.put(Integer.valueOf(i), Boolean.TRUE);
        this.r.w();
        boolean et = aq.et(this.kd);
        final int q = q();
        final String z = z();
        int cy = cy();
        boolean z2 = cy == 0;
        if (z2 && et) {
            w(i, true);
            pz.xj().xj(hf(i, true), new dk.kd() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.2
                @Override // com.bytedance.sdk.openadsdk.core.dk.kd
                public void xj(int i2, String str) {
                    TTRewardVideoActivity.this.w(TTRewardVideoActivity.this.xj(i, false, i2, str, q, z, false));
                }

                @Override // com.bytedance.sdk.openadsdk.core.dk.kd
                public void xj(et.u uVar) {
                    int xj = uVar.w.xj();
                    String hf = uVar.w.hf();
                    TTRewardVideoActivity.this.w(uVar.hf ? TTRewardVideoActivity.this.xj(i, true, 10111, "reward failed", xj, hf, true) : TTRewardVideoActivity.this.xj(i, false, 10112, "server refuse", xj, hf, true));
                }
            });
        } else {
            w(xj(i, z2, cy, "reward failed", q, z, false));
            w(i, z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public String xj() {
        return this.xv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void xj(Intent intent) {
        super.xj(intent);
        if (intent == null) {
            return;
        }
        this.nb = intent.getStringExtra("media_extra");
        this.ss = intent.getStringExtra("user_id");
        this.gj = intent.getStringExtra(MediationConstant.REWARD_NAME);
        this.xv = intent.getStringExtra("userData");
        this.cy = intent.getIntExtra(MediationConstant.REWARD_AMOUNT, 0);
        this.qd.xj(intent.getBooleanExtra("is_play_again", false));
        this.qd.xj(intent.getIntExtra("play_again_count", 0));
        this.qd.hf(intent.getBooleanExtra("custom_play_again", false));
        this.qd.hf(intent.getIntExtra("source_rit_id", 0));
        this.qd.xj(intent.getStringExtra("reward_again_name"));
        this.qd.hf(intent.getStringExtra("reward_again_amount"));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void w(boolean z) {
        int i;
        if (this.dk) {
            if (pz.hf().xw() == 1) {
                i = 2000;
            }
            i = -1;
        } else {
            if (z) {
                i = 0;
            }
            i = -1;
        }
        int i2 = this.qd.xj() ? -1 : i;
        if (i2 < 0 || this.pz.get()) {
            return;
        }
        if (i2 == 0) {
            if (this.pz.getAndSet(true)) {
                return;
            }
            f.xj().xj(String.valueOf(this.tj));
            return;
        }
        this.hf.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTRewardVideoActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (TTRewardVideoActivity.this.pz.getAndSet(true)) {
                    return;
                }
                f.xj().xj(String.valueOf(TTRewardVideoActivity.this.tj));
            }
        }, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Bundle bundle) {
        int i = bundle.getInt("callback_extra_key_reward_type");
        if (i == 0) {
            xj("onRewardVerify", bundle);
        }
        xj("onRewardArrived", bundle);
        this.r.xj(bundle);
        this.b.xj(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean xj(Bundle bundle) {
        com.bytedance.sdk.component.u.hf.w xj = com.bytedance.sdk.openadsdk.core.hf.xj();
        xj.put("is_reward_deep_link_to_live", false);
        xj.put("click_to_live_duration", System.currentTimeMillis());
        return super.xj(bundle);
    }

    private void w(int i, boolean z) {
        if (i == 0) {
            this.z.g();
            this.wo.hf(z);
            ss();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void u(String str) {
        xj(str, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle xj(int i, boolean z, int i2, String str, int i3, String str2, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("callback_extra_key_reward_valid", z);
        bundle.putInt("callback_extra_key_reward_type", i);
        bundle.putInt("callback_extra_key_reward_amount", i3);
        bundle.putString("callback_extra_key_reward_name", str2);
        bundle.putFloat("callback_extra_key_reward_propose", aq.xj(this.kd, i));
        bundle.putBoolean("callback_extra_key_is_server_verify", z2);
        if (!z) {
            bundle.putInt("callback_extra_key_error_code", i2);
            bundle.putString("callback_extra_key_error_msg", str);
        }
        if (i == 0 && aq.c(this.kd) && this.f10297a.pz() >= aq.tf(this.kd)) {
            bundle.putBoolean("callback_extra_key_video_complete_reward", true);
        }
        return bundle;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void hf() {
        if (!this.dq.kd() && this.u.containsKey(0) && this.qd.w(2)) {
            return;
        }
        super.hf();
    }

    private void xj(String str, Bundle bundle) {
        com.bytedance.sdk.openadsdk.core.component.reward.xj.xj(0, this.qd.xj() ? n.xj(this.n) : this.n, str, bundle);
    }
}
