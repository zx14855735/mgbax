package com.bytedance.sdk.openadsdk.core.component.reward.hf;

import android.os.Bundle;
import android.view.View;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.am.xj;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.d;
import com.bytedance.sdk.openadsdk.core.ra.jk;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private ws hf;
    private View kd;
    private boolean u = false;
    private String w;
    private final TTBaseVideoActivity xj;

    public static class xj implements com.bytedance.sdk.openadsdk.y.xj.xj {
        private final long hf;
        private final JSONObject w;
        private final int xj;

        public xj(int i, long j, JSONObject jSONObject) {
            this.xj = i;
            this.hf = j;
            this.w = jSONObject;
        }

        @Override // com.bytedance.sdk.openadsdk.y.xj.xj
        public void xj(JSONObject jSONObject) {
            JSONObject jSONObject2 = this.w;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.put("group_pos", this.xj);
            jSONObject2.put(MediationConstant.EXTRA_DURATION, this.hf);
            jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
        }
    }

    public w(TTBaseVideoActivity tTBaseVideoActivity) {
        this.xj = tTBaseVideoActivity;
    }

    private boolean kd() {
        ws wsVar = this.hf;
        return wsVar == null || jk.p(wsVar) != 1;
    }

    public void hf() {
        final JSONObject xj2 = xj(new JSONObject());
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.hf, this.w, "skip_endcard", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.w.2
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.kd.xj.xj(xj2, w.this.hf);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, xj2);
            }
        });
    }

    public JSONObject u() {
        try {
            long am = this.xj.dc().am();
            int qt = this.xj.dc().qt();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MediationConstant.EXTRA_DURATION, am);
                jSONObject.put("percent", qt);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void w() {
        final JSONObject xj2 = xj(new JSONObject());
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.hf, this.w, "reward_arrived_begin", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.w.3
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.kd.xj.xj(xj2, w.this.hf);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, xj2);
            }
        });
    }

    public void xj(ws wsVar, String str, View view) {
        if (this.u) {
            return;
        }
        this.u = true;
        this.hf = wsVar;
        this.w = str;
        this.kd = view;
    }

    private void hf(View view, tf tfVar) {
        if (view == null) {
            return;
        }
        if (view.getId() == 2114387609) {
            xj("click_play_star_level", (JSONObject) null);
        } else if (view.getId() == 2114387630) {
            xj("click_play_star_nums", (JSONObject) null);
        } else if (view.getId() == 2114387875) {
            xj("click_play_source", (JSONObject) null);
        } else if (view.getId() == 2114387793) {
            xj("click_play_logo", (JSONObject) null);
        } else if (view.getId() != 2114387649 && view.getId() != 2114387925 && view.getId() != 2114387964) {
            if (view.getId() == 2114387642) {
                xj("click_video", u());
            } else if (view.getId() == 2114387864) {
                xj("fallback_endcard_click", u());
            }
        } else {
            xj("click_start_play_bar", u());
        }
        w(view, tfVar);
    }

    private void w(View view, tf tfVar) {
        if (kd() || this.hf == null || view == null) {
            return;
        }
        if (view.getId() == 2114387609 || view.getId() == 2114387630 || view.getId() == 2114387875 || view.getId() == 2114387793 || view.getId() == 2114387649 || view.getId() == 2114387925 || view.getId() == 2114387964 || view.getId() == 2114387830 || view.getId() == 2114387642 || view.getId() == 2114387864) {
            int f = r.f(pz.getContext());
            com.bytedance.sdk.openadsdk.core.am.u.xj("click_other", this.hf, new d.xj().y(tfVar.am()).kd(tfVar.qt()).u(tfVar.zg()).w(tfVar.e()).hf(System.currentTimeMillis()).xj(0L).hf(r.xj(this.kd)).xj(r.xj((View) null)).w(r.w(this.kd)).u(r.w((View) null)).w(tfVar.hf()).u(tfVar.w()).kd(tfVar.u()).xj(tfVar.tf()).hf(f.zg().w() ? 1 : 2).xj(f).xj(r.y(pz.getContext())).hf(r.c(pz.getContext())).xj(), this.w, true, this.xj.tj(), -1, false);
        }
    }

    public JSONObject xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            if (this.xj.aq() != null) {
                jSONObject.put("reward_full_scene_type", this.xj.aq().q());
                this.xj.aq().xj(jSONObject);
                return jSONObject;
            }
        } catch (Exception e) {
            pl.xj(e);
        }
        return jSONObject;
    }

    public void xj(Map<String, Object> map) {
        if (map == null || this.xj.aq() == null) {
            return;
        }
        map.put("reward_full_scene_type", Integer.valueOf(this.xj.aq().q()));
        this.xj.aq().xj(map);
    }

    public void xj() {
        final JSONObject xj2 = xj(new JSONObject());
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.hf, this.w, "skip", new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.w.1
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.kd.xj.xj(xj2, w.this.hf);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, xj2);
            }
        });
    }

    public void xj(Bundle bundle) {
        int i = bundle.getInt("callback_extra_key_reward_type");
        boolean z = bundle.getBoolean("callback_extra_key_reward_valid");
        int i2 = bundle.getInt("callback_extra_key_error_code");
        String string = bundle.getString("callback_extra_key_error_msg");
        boolean z2 = bundle.getBoolean("callback_extra_key_is_server_verify");
        String str = z ? "reward_arrived_success" : "reward_arrived_failed";
        final JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("isRewardVerify", z);
            jSONObject2.put("isServerCallback", z2);
            jSONObject2.put(MediationConstant.KEY_REWARD_TYPE, i);
            jSONObject2.put(MediationConstant.KEY_ERROR_CODE, i2);
            jSONObject2.put(MediationConstant.KEY_ERROR_MSG, string);
            jSONObject.put("reward_data_bundle", jSONObject2);
        } catch (Exception e) {
            pl.u("RewardFullEventManager", e.getMessage());
        }
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.hf, this.w, str, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.w.4
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject3) {
                com.bytedance.sdk.openadsdk.kd.xj.xj(jSONObject, w.this.hf);
                jSONObject3.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, w.this.xj(jSONObject));
            }
        });
    }

    public void xj(String str, int i, String str2) {
        final JSONObject xj2 = xj(new JSONObject());
        try {
            xj2.put("dialog_type", i);
            xj2.put("template_url", str2);
        } catch (JSONException e) {
            pl.xj(e);
        }
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.hf, this.w, str, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.w.5
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.kd.xj.xj(xj2, w.this.hf);
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, w.this.xj(xj2));
            }
        });
    }

    public void xj(boolean z, int i, long j) {
        new xj.C0138xj().kd(this.hf.ho()).xj(this.w).hf(z ? "scroll_up" : "scroll_down").u(this.hf.jf()).xj(new xj(i, j, xj(new JSONObject())));
    }

    public void xj(View view, tf tfVar) {
        try {
            hf(view, tfVar);
        } catch (Exception e) {
            pl.u("RewardFullEventManager", "onClickReport error :" + e.getMessage());
        }
    }

    public void xj(String str, JSONObject jSONObject) {
        ws wsVar = this.hf;
        String str2 = this.w;
        if (!this.xj.io()) {
            jSONObject = null;
        }
        com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar, str2, str, jSONObject);
    }
}
