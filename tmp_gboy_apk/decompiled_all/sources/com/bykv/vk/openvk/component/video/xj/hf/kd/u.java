package com.bykv.vk.openvk.component.video.xj.hf.kd;

import android.text.TextUtils;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.pl;
import com.bytedance.sdk.component.hf.xj.zg;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u implements hf {
    private pl xj;

    public u() {
        this.xj = null;
        this.xj = com.bykv.vk.openvk.component.video.api.w.w();
    }

    @Override // com.bykv.vk.openvk.component.video.xj.hf.kd.hf
    public xj xj(kd kdVar) {
        am.xj xjVar = new am.xj();
        try {
            Map<String, String> map = kdVar.kd;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        String value = entry.getValue();
                        if (value == null) {
                            value = "";
                        }
                        xjVar.hf(key, value);
                    }
                }
            }
            zg hf = this.xj.xj(xjVar.xj(kdVar.hf).xj().hf()).hf();
            com.bykv.vk.openvk.component.video.api.y.w.xj("NetworkSoureVolleyImpl", "response code = ", Integer.valueOf(hf.w()));
            return new y(hf, kdVar);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            return null;
        }
    }
}
