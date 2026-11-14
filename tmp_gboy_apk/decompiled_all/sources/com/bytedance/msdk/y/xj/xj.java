package com.bytedance.msdk.y.xj;

import android.text.TextUtils;
import com.bytedance.msdk.api.u.p;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends hf {
    protected p hf;
    protected com.bytedance.msdk.core.tf.xj xj;

    public xj(com.bytedance.msdk.core.tf.xj xjVar) {
        this.xj = xjVar;
    }

    private String kd() {
        com.bytedance.msdk.core.tf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.hf();
        }
        p pVar = this.hf;
        return pVar != null ? pVar.w() : "";
    }

    private String y() {
        com.bytedance.msdk.core.tf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.w();
        }
        p pVar = this.hf;
        return pVar != null ? pVar.u() : "";
    }

    @Override // com.bytedance.msdk.y.xj.hf
    public String hf() {
        com.bytedance.msdk.core.tf.xj xjVar = this.xj;
        if (xjVar != null) {
            return xjVar.xj();
        }
        p pVar = this.hf;
        return pVar != null ? pVar.kd() : "";
    }

    @Override // com.bytedance.msdk.y.xj.hf
    public String w() {
        return "";
    }

    @Override // com.bytedance.msdk.y.xj.hf
    public Map<String, Object> xj() {
        HashMap hashMap = new HashMap();
        hashMap.put(PluginConstants.KEY_APP_ID, kd());
        hashMap.put("app_key", y());
        hashMap.put("app_name", com.bytedance.msdk.core.xj.p().yo());
        if ("baidu".equals(hf())) {
            hashMap.put("baidu_https", Boolean.valueOf(com.bytedance.msdk.core.xj.p().ai()));
            if (!TextUtils.isEmpty(com.bytedance.msdk.core.xj.p().y())) {
                hashMap.put("baidu_wx_app_id", com.bytedance.msdk.core.xj.p().y());
            }
            Map<String, Object> et = com.bytedance.msdk.core.xj.p().et();
            if (et != null) {
                hashMap.put(MediationConstant.GM_EXTRA_KEY_CLOSE_SHAKE, et.get(MediationConstant.GM_EXTRA_KEY_CLOSE_SHAKE));
            }
        }
        return hashMap;
    }

    public xj(p pVar) {
        this.hf = pVar;
    }
}
