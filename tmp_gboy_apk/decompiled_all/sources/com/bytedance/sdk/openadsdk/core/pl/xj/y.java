package com.bytedance.sdk.openadsdk.core.pl.xj;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.en;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.jk;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    private static final String TAG = "pl_LibEventLogger";

    public static class xj extends com.bytedance.sdk.component.tf.d {
        private Function<SparseArray<Object>, Object> mBridge;
        private boolean mCheckTag;
        private com.bytedance.sdk.openadsdk.core.pl.w.hf.xj mEventExtra;
        private TTDownloadEventModel mEventModel;
        private ws mMeta;

        private xj(TTDownloadEventModel tTDownloadEventModel, boolean z) {
            super("LogTask");
            JSONObject extJson;
            JSONObject materialMeta;
            ws wsVar;
            this.mEventModel = tTDownloadEventModel;
            this.mCheckTag = z;
            this.mBridge = com.bytedance.sdk.openadsdk.core.f.zg().r();
            TTDownloadEventModel tTDownloadEventModel2 = this.mEventModel;
            if (tTDownloadEventModel2 == null || tTDownloadEventModel2.getExtJson() == null || (extJson = this.mEventModel.getExtJson()) == null) {
                return;
            }
            String optString = extJson.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            try {
                JSONObject optJSONObject = new JSONObject(optString).optJSONObject(tf.EXTRA_DOWN_INFO_KEY);
                com.bytedance.sdk.openadsdk.core.pl.w.hf.xj xj = com.bytedance.sdk.openadsdk.core.pl.w.hf.xj.xj(optJSONObject);
                this.mEventExtra = xj;
                if (xj == null) {
                    return;
                }
                xj.xj(tTDownloadEventModel.getTag());
                this.mEventExtra.hf(this.mEventModel.getLabel());
                this.mMeta = this.mEventExtra.xj;
                if (ai.w >= 4400 && (materialMeta = tTDownloadEventModel.getMaterialMeta()) != null && (wsVar = this.mMeta) != null && !equalExt(materialMeta, wsVar.jb())) {
                    this.mMeta.ht(materialMeta.toString());
                    this.mMeta.pz(String.valueOf(materialMeta.optLong("creative_id")));
                    JSONObject ac = this.mMeta.ac();
                    optJSONObject.put("material_meta", ac);
                    com.bytedance.sdk.openadsdk.core.pl.w.hf.xj xj2 = com.bytedance.sdk.openadsdk.core.pl.w.hf.xj.xj(optJSONObject);
                    if (xj2 == null) {
                        return;
                    }
                    this.mEventExtra = xj2;
                    xj2.hf(tTDownloadEventModel.getLabel());
                    this.mEventModel = TTDownloadEventModel.builder().setTag(tTDownloadEventModel.getTag()).setLabel(tTDownloadEventModel.getLabel()).setMaterialMeta(ac).setExtJson(extJson);
                    this.mMeta = this.mEventExtra.xj;
                }
            } catch (Exception unused) {
            }
        }

        public static xj build(TTDownloadEventModel tTDownloadEventModel, boolean z) {
            return new xj(tTDownloadEventModel, z);
        }

        private boolean checkTag(String str) {
            return this.mCheckTag || y.checkTag(str);
        }

        private boolean equalExt(JSONObject jSONObject, JSONObject jSONObject2) {
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

        private Context getContext() {
            return pz.getContext();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object apply;
            try {
                TTDownloadEventModel tTDownloadEventModel = this.mEventModel;
                if (tTDownloadEventModel == null) {
                    return;
                }
                String tag = tTDownloadEventModel.getTag();
                pl.xj(y.TAG, "label: " + this.mEventModel.getLabel() + " tag: " + tag);
                com.bytedance.sdk.openadsdk.core.pl.w.hf.xj xjVar = this.mEventExtra;
                if (xjVar != null && !TextUtils.isEmpty(xjVar.hf)) {
                    tag = this.mEventExtra.hf;
                }
                if (this.mBridge != null) {
                    apply = this.mBridge.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(2).xj(Boolean.class).xj(0, new en().xj("tagIntercept", tag).xj("label", this.mEventModel.getLabel()).xj("meta", this.mMeta.ac().toString())).hf());
                    if (apply != null && ((Boolean) apply).booleanValue()) {
                        return;
                    }
                }
                if (this.mEventExtra != null && this.mMeta != null && !TextUtils.isEmpty(this.mEventModel.getTag()) && !TextUtils.isEmpty(this.mEventModel.getLabel())) {
                    JSONObject libAdExtraData = y.getLibAdExtraData(this.mEventModel.getExtJson());
                    String str = this.mEventExtra.hf;
                    if (checkTag(this.mEventModel.getTag()) && !"click".equals(this.mEventModel.getLabel())) {
                        libAdExtraData.remove(tf.EXTRA_DOWN_INFO_KEY);
                        libAdExtraData.putOpt("obm_convert", jk.w(this.mMeta));
                        com.bytedance.sdk.openadsdk.core.am.u.hf(this.mMeta, str, this.mEventModel.getLabel(), libAdExtraData);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean checkTag(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "embeded_ad".equals(str) || "draw_ad".equals(str) || "draw_ad_landingpage".equals(str) || "banner_ad".equals(str) || "banner_call".equals(str) || "banner_ad_landingpage".equals(str) || "feed_call".equals(str) || "embeded_ad_landingpage".equals(str) || "interaction".equals(str) || "interaction_call".equals(str) || "interaction_landingpage".equals(str) || "slide_banner_ad".equals(str) || "splash_ad".equals(str) || "fullscreen_interstitial_ad".equals(str) || "splash_ad_landingpage".equals(str) || "rewarded_video".equals(str) || "rewarded_video_landingpage".equals(str) || "openad_sdk_download_complete_tag".equals(str) || "fullscreen_interstitial_ad_landingpage".equals(str) || "stream".equals(str);
    }

    public static JSONObject getLibAdExtraData(JSONObject jSONObject) {
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
            pl.xj(e);
            return null;
        }
    }

    public static boolean isOpenSdkEvent(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(tf.EXTRA_DOWN_INFO_KEY);
    }
}
