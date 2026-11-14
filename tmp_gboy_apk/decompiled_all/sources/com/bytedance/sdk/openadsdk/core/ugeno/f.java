package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.bytedance.adsdk.ugeno.kd.y;
import com.bytedance.adsdk.ugeno.w.am;
import com.bytedance.adsdk.ugeno.w.qt;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.widget.w;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f implements yo {
    private com.bytedance.adsdk.ugeno.hf.w<View> hf;
    private w.xj w;
    private Context xj;

    public f(Context context) {
        this.xj = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.c.c cVar) {
        qt qtVar = new qt(this.xj);
        am amVar = new am();
        amVar.xj(this.xj);
        qtVar.xj("ugen_download_dialog", amVar);
        com.bytedance.adsdk.ugeno.hf.w<View> xj = qtVar.xj(jSONObject);
        this.hf = xj;
        if (xj != null) {
            qtVar.xj(this);
            qtVar.hf(jSONObject2);
        }
        if (cVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.hf.w<View> wVar = this.hf;
        if (wVar == null) {
            cVar.xj(-1, "UGenWidget is null");
        } else {
            cVar.xj(wVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.yo
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
    }

    public void xj(w.xj xjVar) {
        this.w = xjVar;
    }

    public void xj(final JSONObject jSONObject, final JSONObject jSONObject2, final com.bytedance.sdk.openadsdk.core.ugeno.c.c cVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hf(jSONObject, jSONObject2, cVar);
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.hf(jSONObject, jSONObject2, cVar);
                }
            });
        }
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
            com.bytedance.sdk.openadsdk.core.widget.w$xj r5 = r2.w
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
            com.bytedance.sdk.openadsdk.core.widget.w$xj r3 = r2.w
            r3.u(r5)
            return
        L69:
            com.bytedance.sdk.openadsdk.core.widget.w$xj r3 = r2.w
            r3.xj(r5)
            return
        L6f:
            com.bytedance.sdk.openadsdk.core.widget.w$xj r3 = r2.w
            r3.w(r5)
            return
        L75:
            com.bytedance.sdk.openadsdk.core.widget.w$xj r3 = r2.w
            r3.kd(r5)
            return
        L7b:
            com.bytedance.sdk.openadsdk.core.widget.w$xj r3 = r2.w
            r3.hf(r5)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ugeno.f.xj(com.bytedance.adsdk.ugeno.w.zg, com.bytedance.adsdk.ugeno.w.yo$hf, com.bytedance.adsdk.ugeno.w.yo$xj):void");
    }
}
