package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class dc extends n {
    private final Context kd;
    private final wn y;

    public dc(Context context, wn wnVar) {
        super(false, false);
        this.kd = context;
        this.y = wnVar;
    }

    @Override // com.bytedance.embedapplog.n
    public boolean xj(JSONObject jSONObject) {
        jSONObject.put(PluginConstants.KEY_SDK_VERSION, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME);
        jSONObject.put("sdk_version_name", "3.9.1.baseChina-alpha.97");
        jSONObject.put("channel", this.y.p());
        aq.xj(jSONObject, "aid", this.y.tf());
        aq.xj(jSONObject, "release_build", this.y.x());
        aq.xj(jSONObject, "app_region", this.y.am());
        aq.xj(jSONObject, "app_language", this.y.g());
        aq.xj(jSONObject, "user_agent", this.y.ai());
        aq.xj(jSONObject, "ab_sdk_version", this.y.zg());
        aq.xj(jSONObject, "ab_version", this.y.jk());
        aq.xj(jSONObject, "aliyun_uuid", this.y.hf());
        String pl2 = this.y.pl();
        if (TextUtils.isEmpty(pl2)) {
            pl2 = i.xj(this.kd, this.y);
        }
        if (!TextUtils.isEmpty(pl2)) {
            aq.xj(jSONObject, "google_aid", pl2);
        }
        String io2 = this.y.io();
        if (!TextUtils.isEmpty(io2)) {
            try {
                jSONObject.put("app_track", new JSONObject(io2));
            } catch (Throwable th) {
                cu.hf(th);
            }
        }
        String qt = this.y.qt();
        if (qt != null && qt.length() > 0) {
            jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, new JSONObject(qt));
        }
        aq.xj(jSONObject, "user_unique_id", this.y.e());
        return true;
    }
}
