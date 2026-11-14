package com.bytedance.sdk.openadsdk.core.d.xj.xj.xj;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y implements com.bytedance.sdk.openadsdk.core.d.xj.xj.xj {
    private View c;
    private Map<String, Object> f;
    private ws hf;
    private String kd;
    private String u;
    private Context w;
    private com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xj;
    private int y;

    public y(ws wsVar, Context context, String str, String str2) {
        this.hf = wsVar;
        this.w = context;
        this.u = str;
        this.kd = str2;
        hf();
    }

    public static boolean xj(int i) {
        switch (i) {
            case 101:
            case 102:
            case 103:
            case 104:
                return true;
            default:
                return false;
        }
    }

    public void hf(Map<String, Object> map) {
        this.f = map;
    }

    private void hf() {
        ws wsVar = this.hf;
        if (wsVar != null) {
            this.y = wsVar.vu();
        } else {
            this.y = -1;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.d.xj.xj.xj
    public boolean xj(Map<String, Object> map) {
        boolean xj = xj();
        hf();
        if (xj) {
            return true;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("event_tag", this.u);
        if (!TextUtils.isEmpty(this.kd)) {
            hashMap.put("dpa_tag", this.kd);
        }
        if ((com.bytedance.sdk.openadsdk.core.live.hf.xj().xj(this.w, this.hf, hashMap) & 255) == 0) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xjVar = this.xj;
        return xjVar != null && xjVar.xj(map);
    }

    public void hf(int i) {
        this.y = i;
    }

    private boolean xj() {
        if (this.y < 2) {
            return false;
        }
        HashMap hashMap = new HashMap(2);
        if (xj(this.y)) {
            hashMap.put("live_saas_param_interaction_type", Integer.valueOf(this.y));
        }
        hashMap.put("event_tag", this.u);
        String str = this.kd;
        if (str != null) {
            hashMap.put("dpa_tag", str);
        }
        if (this.f == null) {
            this.f = new HashMap();
        }
        com.bytedance.sdk.openadsdk.core.live.hf.xj().xj(this.c, this.hf.bi(), hashMap, this.f);
        int xj = com.bytedance.sdk.openadsdk.core.live.hf.xj().xj(this.w, this.hf, hashMap);
        int i = xj & 255;
        int i2 = (xj & 65280) >> 8;
        if (i2 > 0) {
            this.f.put("click_saas_action", Integer.valueOf(i2));
        }
        return i == 0;
    }

    public void xj(View view) {
        this.c = view;
    }
}
