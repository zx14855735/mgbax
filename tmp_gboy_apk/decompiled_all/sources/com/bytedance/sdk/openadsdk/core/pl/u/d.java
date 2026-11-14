package com.bytedance.sdk.openadsdk.core.pl.u;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.a.en;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.jk;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d {

    public static class xj extends com.bytedance.sdk.component.tf.d {
        private com.bytedance.sdk.openadsdk.core.pl.w.hf.xj hf;
        private Function<SparseArray<Object>, Object> kd;
        private boolean u;
        private ws w;
        private f xj;

        private xj(f fVar, boolean z) {
            super("LogTask");
            JSONObject u;
            JSONObject kd;
            ws wsVar;
            this.xj = fVar;
            this.u = z;
            this.kd = com.bytedance.sdk.openadsdk.core.f.zg().r();
            f fVar2 = this.xj;
            if (fVar2 == null || fVar2.u() == null || (u = this.xj.u()) == null) {
                return;
            }
            String optString = u.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            try {
                JSONObject optJSONObject = new JSONObject(optString).optJSONObject(com.bytedance.sdk.openadsdk.core.pl.xj.tf.EXTRA_DOWN_INFO_KEY);
                com.bytedance.sdk.openadsdk.core.pl.w.hf.xj xj = com.bytedance.sdk.openadsdk.core.pl.w.hf.xj.xj(optJSONObject);
                this.hf = xj;
                if (xj == null) {
                    return;
                }
                xj.xj(fVar.hf());
                this.hf.hf(this.xj.w());
                this.w = this.hf.xj;
                if (ai.w >= 4400 && (kd = fVar.kd()) != null && (wsVar = this.w) != null && !xj(kd, wsVar.jb())) {
                    this.w.ht(kd.toString());
                    this.w.pz(String.valueOf(kd.optLong("creative_id")));
                    JSONObject ac = this.w.ac();
                    optJSONObject.put("material_meta", ac);
                    com.bytedance.sdk.openadsdk.core.pl.w.hf.xj xj2 = com.bytedance.sdk.openadsdk.core.pl.w.hf.xj.xj(optJSONObject);
                    if (xj2 == null) {
                        return;
                    }
                    this.hf = xj2;
                    xj2.hf(fVar.w());
                    this.xj = f.xj().xj(fVar.hf()).hf(fVar.w()).xj(ac).hf(u);
                    this.w = this.hf.xj;
                }
            } catch (Exception unused) {
            }
        }

        private Context getContext() {
            return pz.getContext();
        }

        public static xj xj(f fVar, boolean z) {
            return new xj(fVar, z);
        }

        @Override // java.lang.Runnable
        public void run() {
            Object apply;
            try {
                f fVar = this.xj;
                if (fVar == null) {
                    return;
                }
                String hf = fVar.hf();
                com.bytedance.sdk.component.utils.pl.xj("pl_LibEventLogger", "label: " + this.xj.w() + " tag: " + hf);
                com.bytedance.sdk.openadsdk.core.pl.w.hf.xj xjVar = this.hf;
                if (xjVar != null && !TextUtils.isEmpty(xjVar.hf)) {
                    hf = this.hf.hf;
                }
                if (this.kd != null) {
                    apply = this.kd.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(2).xj(Boolean.class).xj(0, new en().xj("tagIntercept", hf).xj("label", this.xj.w()).xj("meta", this.w.ac().toString())).hf());
                    if (apply != null && ((Boolean) apply).booleanValue()) {
                        return;
                    }
                }
                if (this.hf != null && this.w != null && !TextUtils.isEmpty(this.xj.hf()) && !TextUtils.isEmpty(this.xj.w())) {
                    JSONObject xj = d.xj(this.xj.u());
                    String str = this.hf.hf;
                    if (xj(this.xj.hf()) && !"click".equals(this.xj.w())) {
                        xj.remove(com.bytedance.sdk.openadsdk.core.pl.xj.tf.EXTRA_DOWN_INFO_KEY);
                        xj.putOpt("obm_convert", jk.w(this.w));
                        com.bytedance.sdk.openadsdk.core.am.u.hf(this.w, str, this.xj.w(), xj);
                    }
                }
            } catch (Throwable unused) {
            }
        }

        private boolean xj(JSONObject jSONObject, JSONObject jSONObject2) {
            if (jSONObject != null && jSONObject2 != null) {
                long optLong = jSONObject.optLong(MediationConstant.EXTRA_ADID);
                long optLong2 = jSONObject2.optLong(MediationConstant.EXTRA_ADID);
                String optString = jSONObject.optString("req_id");
                String optString2 = jSONObject2.optString("req_id");
                long optLong3 = jSONObject.optLong("creative_id");
                long optLong4 = jSONObject2.optLong("creative_id");
                String optString3 = jSONObject.optString("origin_req_id");
                String optString4 = jSONObject2.optString("origin_req_id");
                if (optLong != 0 && optLong == optLong2 && optLong3 != 0 && optLong3 == optLong4) {
                    return (TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4)) ? TextUtils.equals(optString, optString2) : TextUtils.equals(optString3, optString4);
                }
            }
            return false;
        }

        private boolean xj(String str) {
            return this.u || d.w(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "embeded_ad".equals(str) || "draw_ad".equals(str) || "draw_ad_landingpage".equals(str) || "banner_ad".equals(str) || "banner_call".equals(str) || "banner_ad_landingpage".equals(str) || "feed_call".equals(str) || "embeded_ad_landingpage".equals(str) || "interaction".equals(str) || "interaction_call".equals(str) || "interaction_landingpage".equals(str) || "slide_banner_ad".equals(str) || "splash_ad".equals(str) || "fullscreen_interstitial_ad".equals(str) || "splash_ad_landingpage".equals(str) || "rewarded_video".equals(str) || "rewarded_video_landingpage".equals(str) || "openad_sdk_download_complete_tag".equals(str) || "fullscreen_interstitial_ad_landingpage".equals(str) || "stream".equals(str);
    }

    public static JSONObject xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        try {
            return new JSONObject(optString);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    public static boolean xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(com.bytedance.sdk.openadsdk.core.pl.xj.tf.EXTRA_DOWN_INFO_KEY);
    }
}
