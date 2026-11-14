package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bytedance.adsdk.ugeno.kd.y;
import com.bytedance.adsdk.ugeno.w.am;
import com.bytedance.adsdk.ugeno.w.qt;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.widget.c;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements yo, ai.xj, hf {
    private com.bytedance.sdk.openadsdk.core.ugeno.c.c c;
    private Context hf;
    private ws kd;
    private j u;
    private c.xj w;
    private com.bytedance.adsdk.ugeno.hf.w<View> xj;
    private AtomicBoolean f = new AtomicBoolean(false);
    private final ai y = new ai(Looper.getMainLooper(), this);

    public xj(Context context, ws wsVar) {
        this.hf = context;
        this.kd = wsVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.c.c cVar) {
        this.c = cVar;
        qt qtVar = new qt(this.hf);
        am amVar = new am();
        amVar.xj(this.hf);
        HashMap hashMap = new HashMap();
        j jVar = new j(this.hf);
        this.u = jVar;
        jVar.xj(this.w);
        this.u.xj(this);
        this.u.hf(xj(jSONObject2));
        String hf = wo.hf(this.kd);
        this.u.w(wo.hf(hf));
        this.u.xj(hf);
        hashMap.put("key_js_object", this.u);
        hashMap.put("key_material", this.kd);
        amVar.hf(jSONObject2);
        amVar.xj(hashMap);
        qtVar.xj("easy_dl_dialog", amVar);
        com.bytedance.adsdk.ugeno.hf.w<View> xj = qtVar.xj(jSONObject);
        this.xj = xj;
        if (xj == null) {
            com.bytedance.sdk.openadsdk.core.ugeno.c.c cVar2 = this.c;
            if (cVar2 != null) {
                cVar2.xj(-1, "UGenWidget is null");
                return;
            }
            return;
        }
        qtVar.xj(this);
        qtVar.hf(jSONObject2);
        ai aiVar = this.y;
        if (aiVar != null) {
            aiVar.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.yo
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
    }

    public void xj(c.xj xjVar) {
        this.w = xjVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0052, code lost:
    
        if (r3.equals("openAppFunctionDesc") == false) goto L14;
     */
    @Override // com.bytedance.adsdk.ugeno.w.yo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(com.bytedance.adsdk.ugeno.w.zg r3, com.bytedance.adsdk.ugeno.w.yo.hf r4, com.bytedance.adsdk.ugeno.w.yo.xj r5) {
        /*
            r2 = this;
            r4 = 1
            if (r3 == 0) goto L80
            com.bytedance.sdk.openadsdk.core.widget.c$xj r5 = r2.w
            if (r5 != 0) goto L9
            goto L80
        L9:
            int r5 = r3.hf()
            if (r5 != r4) goto L80
            org.json.JSONObject r3 = r3.w()
            if (r3 != 0) goto L17
            goto L80
        L17:
            java.lang.String r5 = "type"
            java.lang.String r3 = r3.optString(r5)
            r3.getClass()
            r5 = 0
            r0 = -1
            int r1 = r3.hashCode()
            switch(r1) {
                case -1822902106: goto L55;
                case -459025504: goto L4c;
                case -267096736: goto L41;
                case 7917298: goto L36;
                case 1237425033: goto L2b;
                default: goto L29;
            }
        L29:
            r4 = -1
            goto L5f
        L2b:
            java.lang.String r4 = "openAppPolicy"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L34
            goto L29
        L34:
            r4 = 4
            goto L5f
        L36:
            java.lang.String r4 = "downloadEvent"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L3f
            goto L29
        L3f:
            r4 = 3
            goto L5f
        L41:
            java.lang.String r4 = "closeDialog"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L4a
            goto L29
        L4a:
            r4 = 2
            goto L5f
        L4c:
            java.lang.String r1 = "openAppFunctionDesc"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L5f
            goto L29
        L55:
            java.lang.String r4 = "openAppPermission"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L5e
            goto L29
        L5e:
            r4 = 0
        L5f:
            switch(r4) {
                case 0: goto L7b;
                case 1: goto L75;
                case 2: goto L6f;
                case 3: goto L69;
                case 4: goto L63;
                default: goto L62;
            }
        L62:
            goto L80
        L63:
            com.bytedance.sdk.openadsdk.core.widget.c$xj r3 = r2.w
            r3.u(r5)
            return
        L69:
            com.bytedance.sdk.openadsdk.core.widget.c$xj r3 = r2.w
            r3.xj(r5)
            return
        L6f:
            com.bytedance.sdk.openadsdk.core.widget.c$xj r3 = r2.w
            r3.w(r5)
            return
        L75:
            com.bytedance.sdk.openadsdk.core.widget.c$xj r3 = r2.w
            r3.xj()
            return
        L7b:
            com.bytedance.sdk.openadsdk.core.widget.c$xj r3 = r2.w
            r3.hf(r5)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ugeno.xj.xj(com.bytedance.adsdk.ugeno.w.zg, com.bytedance.adsdk.ugeno.w.yo$hf, com.bytedance.adsdk.ugeno.w.yo$xj):void");
    }

    public void xj(final JSONObject jSONObject, final JSONObject jSONObject2, final com.bytedance.sdk.openadsdk.core.ugeno.c.c cVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hf(jSONObject, jSONObject2, cVar);
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.xj.1
                @Override // java.lang.Runnable
                public void run() {
                    xj.this.hf(jSONObject, jSONObject2, cVar);
                }
            });
        }
    }

    private JSONObject xj(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("easy_dl_dialog")) == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("app_name", optJSONObject.opt("app_name"));
            jSONObject2.put(n.r, optJSONObject.opt(n.r));
            jSONObject2.put("developer_name", optJSONObject.opt("developer_name"));
            jSONObject2.put(n.p, optJSONObject.opt(n.p));
            jSONObject2.put("score", optJSONObject.opt("score"));
            jSONObject2.put("icon_url", optJSONObject.opt("icon_url"));
            jSONObject2.put("description", optJSONObject.opt("description"));
            jSONObject2.put("creative_tags", optJSONObject.opt("creative_tags"));
            jSONObject2.put("easy_pl_material", optJSONObject.opt("easy_pl_material"));
            jSONObject3.put("ugen_download_dialog", jSONObject2);
            return jSONObject3;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void hf() {
        ai aiVar = this.y;
        if (aiVar == null) {
            return;
        }
        aiVar.removeMessages(1);
    }

    @Override // com.bytedance.sdk.component.utils.ai.xj
    public void xj(Message message) {
        if (message == null || message.what != 1 || this.f.get()) {
            return;
        }
        if (this.c != null) {
            this.f.set(true);
            this.c.xj(10, "load time out");
        }
        hf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.hf
    public void xj() {
        hf();
        if (this.f.get() || this.c == null) {
            return;
        }
        this.f.set(true);
        this.c.xj(this.xj);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.hf
    public void xj(int i, String str) {
        hf();
        if (this.f.get() || this.c == null) {
            return;
        }
        this.f.set(true);
        this.c.xj(i, str);
    }
}
