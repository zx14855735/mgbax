package com.bytedance.sdk.openadsdk.core.d.xj.xj.hf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.hf;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.multipro.hf.xj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.tf;
import com.bytedance.sdk.openadsdk.zg.w.hf.d;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements com.bytedance.sdk.openadsdk.core.d.xj.xj.xj {
    private String c;
    private int f;
    private Context hf;
    private Map<String, Object> kd;
    private com.bytedance.sdk.openadsdk.core.video.hf.hf p;
    private String tf;
    private Object u;
    private ws w;
    private boolean y;
    private boolean xj = false;
    private boolean d = false;

    public xj(ws wsVar, Context context, String str, int i) {
        this.w = wsVar;
        this.hf = context;
        this.c = str;
        this.f = i;
    }

    public void hf(boolean z) {
        this.y = z;
    }

    public void w(boolean z) {
        this.d = z;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.video.hf.hf hfVar) {
        this.p = hfVar;
    }

    private com.bytedance.sdk.openadsdk.core.multipro.hf.xj w() {
        Object obj;
        if (!ws.hf(this.w) || (obj = this.u) == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.multipro.hf.xj j = obj instanceof xj.InterfaceC0173xj ? ((xj.InterfaceC0173xj) obj).j() : null;
        if (j != null) {
            this.kd.put("multi_process_data", j.xj().toString());
        }
        Object obj2 = this.u;
        if (!(obj2 instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.hf)) {
            return j;
        }
        com.bytedance.sdk.openadsdk.core.multipro.hf.xj p = ((com.bytedance.sdk.openadsdk.core.nativeexpress.hf) obj2).p();
        if (p != null) {
            this.kd.put("multi_process_data", p.xj().toString());
        }
        return p;
    }

    public void hf(Map<String, Object> map) {
        this.kd = map;
    }

    public void xj(boolean z) {
        this.xj = z;
    }

    private boolean hf(String str) {
        if (!am.xj(str)) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str));
            if (!(this.hf instanceof Activity)) {
                intent.addFlags(C.ENCODING_PCM_MU_LAW);
            }
            com.bytedance.sdk.component.utils.hf.xj(this.hf, intent, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public Class<?> xj() {
        boolean z = this.xj;
        this.xj = false;
        if (this.u instanceof d) {
            return tf.y(this.w) ? TTNativePageActivity.class : TTWebPageActivity.class;
        }
        if (!ws.hf(this.w) || z || xj(this.u) || !wo.kd(this.w)) {
            return tf.y(this.w) ? TTNativePageActivity.class : TTWebPageActivity.class;
        }
        if (tf.y(this.w)) {
            return TTNativePageActivity.class;
        }
        ws wsVar = this.w;
        return (wsVar == null || !wsVar.c()) ? hf(TTVideoWebPageActivity.class) : TTWebPageActivity.class;
    }

    private void hf() {
        if (this.d && this.w != null) {
            if (this.kd == null) {
                this.kd = new HashMap();
            }
            if (TextUtils.isEmpty(this.tf)) {
                this.tf = this.w.ol();
            }
            this.kd.put("url", this.tf);
            this.kd.put("gecko_id", this.w.db());
            this.kd.put("web_title", this.w.kr());
            this.kd.put(PluginConstants.KEY_SDK_VERSION, Integer.valueOf(ai.w));
            this.kd.put("adid", this.w.ho());
            this.kd.put("log_extra", this.w.jf());
            this.kd.put("icon_url", this.w.uf() == null ? null : this.w.uf().xj());
            this.kd.put("event_tag", this.c);
            this.kd.put(n.l, Integer.valueOf(this.f));
            this.kd.put("is_outer_click", Boolean.TRUE);
            wo.xj(this.kd, this.w);
        }
    }

    private static boolean xj(Object obj) {
        if (obj == null || !(obj instanceof xj.InterfaceC0173xj)) {
            return false;
        }
        try {
            return ((xj.InterfaceC0173xj) obj).q();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean xj(Class cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(n.m, this.w.jf());
            jSONObject.putOpt("live_interaction_type", Integer.valueOf(this.w.vu()));
            jSONObject.putOpt("req_id", this.w.zf());
            Boolean bool = Boolean.TRUE;
            jSONObject.putOpt("uchain", bool);
            jSONObject.putOpt("uchain_old", bool);
            jSONObject.putOpt("interaction_type", Integer.valueOf(this.w.vw()));
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.core.ht.am.xj().xj("landing_page", "native", 0, jSONObject);
        if (this.w.vw() == 2) {
            return hf(this.w.ol());
        }
        com.bytedance.sdk.openadsdk.core.video.hf.hf hfVar = this.p;
        if (hfVar != null && new hf(hfVar).xj(new HashMap())) {
            return true;
        }
        Intent intent = new Intent(this.hf, (Class<?>) cls);
        if (!(this.hf instanceof Activity)) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        intent.putExtra("is_outer_click", true);
        intent.putExtra("get_phone_num_status", this.w.w());
        hf();
        if (this.kd == null) {
            this.kd = new HashMap();
        }
        for (Map.Entry<String, Object> entry : this.kd.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                intent.putExtra(entry.getKey(), value.toString());
            }
        }
        com.bytedance.sdk.component.utils.hf.xj(this.hf, intent, new hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.xj.hf.xj.1
            @Override // com.bytedance.sdk.component.utils.hf.xj
            public void xj() {
            }

            @Override // com.bytedance.sdk.component.utils.hf.xj
            public void xj(Throwable th) {
            }
        });
        return true;
    }

    private Class hf(Class cls) {
        int i;
        com.bytedance.sdk.openadsdk.core.multipro.hf.xj w = w();
        if (w != null) {
            this.kd.put("video_is_auto_play", Boolean.valueOf(w.u));
        }
        if (TTVideoWebPageActivity.class.equals(cls) && (w != null || this.y)) {
            try {
                if (w != null) {
                    i = (int) ((w.c / w.kd) * 100.0f);
                } else {
                    com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.multipro.hf.xj();
                    xjVar.c = 100L;
                    xjVar.xj = true;
                    xjVar.u = wo.pz(this.w);
                    this.kd.put("multi_process_data", xjVar.xj().toString());
                    i = 100;
                }
                if (this.w.jw() == 0) {
                    return TTVideoScrollWebPageActivity.class;
                }
                if (this.w.jw() > 0 && i > this.w.jw()) {
                    if (wo.pz(this.w)) {
                        return TTVideoScrollWebPageActivity.class;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return cls;
    }

    public void xj(String str) {
        this.tf = str;
    }

    @Override // com.bytedance.sdk.openadsdk.core.d.xj.xj.xj
    public boolean xj(Map<String, Object> map) {
        if (this.w == null) {
            return false;
        }
        return xj((Class) xj());
    }
}
