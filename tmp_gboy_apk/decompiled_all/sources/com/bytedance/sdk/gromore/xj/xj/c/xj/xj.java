package com.bytedance.sdk.gromore.xj.xj.c.xj;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.bytedance.msdk.w.u.p;
import com.bytedance.sdk.gromore.xj.xj.u.tf;
import com.bytedance.sdk.openadsdk.mediation.manager.xj.hf.xj.kd;
import com.bytedance.sdk.openadsdk.zg.w.hf.am;
import com.bytedance.sdk.openadsdk.zg.w.hf.c;
import com.bytedance.sdk.openadsdk.zg.w.hf.u;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends am {
    private com.bytedance.sdk.openadsdk.et.xj.hf.xj.w c;
    private com.bytedance.sdk.openadsdk.zg.w.xj.hf f;
    private com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj hf;
    private View kd = null;
    private com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf u;
    private com.bytedance.sdk.openadsdk.et.xj.hf.xj.xj w;
    private final p xj;
    private com.bytedance.sdk.openadsdk.zg.w.xj.w y;

    public xj(p pVar) {
        this.xj = pVar;
        tf();
    }

    private void am() {
        com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar;
        p pVar = this.xj;
        if (pVar == null || (wVar = this.c) == null) {
            return;
        }
        pVar.xj(wVar);
    }

    private void g() {
        com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar;
        p pVar = this.xj;
        if (pVar == null || (hfVar = this.f) == null) {
            return;
        }
        pVar.xj(hfVar);
    }

    private void p() {
        com.bytedance.sdk.openadsdk.zg.w.xj.w wVar;
        p pVar = this.xj;
        if (pVar == null || (wVar = this.y) == null) {
            return;
        }
        pVar.xj(wVar);
    }

    private void tf() {
        p pVar = this.xj;
        if (pVar != null) {
            pVar.xj(new com.bytedance.msdk.api.u.xj.xj.xj() { // from class: com.bytedance.sdk.gromore.xj.xj.c.xj.xj.1
                @Override // com.bytedance.msdk.api.u.xj.xj.xj
                public void f_() {
                    if (xj.this.hf != null) {
                        xj.this.hf.xj(0, "ad closed", true);
                    }
                    if (xj.this.w != null) {
                        xj.this.w.xj();
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.xj.xj
                public void hf(View view) {
                    if (xj.this.u != null) {
                        xj.this.u.hf(view, 0);
                    }
                    if (xj.this.w != null) {
                        xj.this.w.hf(view, 0);
                    }
                }

                @Override // com.bytedance.msdk.api.u.xj.xj.xj
                public void xj(com.bytedance.msdk.api.xj xjVar) {
                }

                @Override // com.bytedance.msdk.api.u.xj.xj.xj
                public void xj(View view) {
                    if (xj.this.u != null) {
                        xj.this.u.xj(view, 0);
                    }
                    if (xj.this.w != null) {
                        xj.this.w.xj(view, 0);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public kd d() {
        return new tf(new hf(this.xj));
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public Map<String, Object> f() {
        p pVar = this.xj;
        if (pVar != null) {
            return pVar.c();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void hf(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void kd() {
        if (this.kd != null) {
            this.kd = null;
        }
        p pVar = this.xj;
        if (pVar != null) {
            pVar.w();
        }
        if (this.y != null) {
            this.y = null;
        }
        if (this.c != null) {
            this.c = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void u() {
        com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf hfVar = this.u;
        if (hfVar != null) {
            hfVar.xj(this.kd, 0.0f, 0.0f);
        }
        com.bytedance.sdk.openadsdk.et.xj.hf.xj.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.xj(this.kd, 0.0f, 0.0f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public u y() {
        p pVar = this.xj;
        if (pVar != null) {
            return pVar.am();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public int w() {
        p pVar = this.xj;
        if (pVar != null) {
            return pVar.g();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public int hf() {
        p pVar = this.xj;
        if (pVar != null) {
            return pVar.y();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(JSONObject jSONObject) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public View xj() {
        p pVar;
        if (this.kd == null && (pVar = this.xj) != null) {
            this.kd = pVar.kd();
        }
        p();
        am();
        g();
        return this.kd;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf hfVar) {
        this.u = hfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.xj xjVar) {
        this.w = xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
        this.y = wVar;
        p();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
        this.hf = xjVar;
        p pVar = this.xj;
        if (pVar != null) {
            pVar.xj(activity, xjVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(Dialog dialog, Integer[] numArr) {
        p pVar = this.xj;
        if (pVar != null) {
            pVar.xj(dialog, numArr);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(String str) {
        p pVar = this.xj;
        if (pVar != null) {
            pVar.xj(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public c xj(Activity activity) {
        p pVar = this.xj;
        if (pVar != null) {
            return pVar.xj(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar) {
        this.c = wVar;
        am();
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
        this.f = hfVar;
        p pVar = this.xj;
        if (pVar != null) {
            pVar.xj(hfVar);
        }
    }
}
