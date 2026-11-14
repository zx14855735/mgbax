package com.bytedance.sdk.openadsdk.core.component.reward.w;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.w.hf;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.xv;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class g extends xj {
    xj e;

    public g(Activity activity, ws wsVar) {
        super(activity, wsVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.xj, com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public hf.xj hf(tf tfVar) {
        ArrayList<xv> jk = aq.jk(this.c);
        if (jk == null) {
            return new hf.xj(false, 0, "");
        }
        Iterator<xv> it = jk.iterator();
        while (it.hasNext()) {
            xv next = it.next();
            switch (next.w()) {
                case 1:
                    this.e = new pl(this.f, this.c, next);
                    break;
                case 2:
                    this.e = new p(this.f, this.c, next);
                    break;
                case 3:
                    this.e = new y(this.f, this.c, next);
                    break;
                case 4:
                    this.e = new c(this.f, this.c, next);
                    break;
                case 5:
                    this.e = new d(this.f, this.c, next);
                    break;
                case 6:
                    this.e = new u(this.f, this.c, next);
                    break;
            }
            xj xjVar = this.e;
            if (xjVar != null) {
                xjVar.xj(this.w);
                this.e.xj(this.xj);
                this.e.hf(this.hf);
                this.e.hf(this.u);
                this.e.w(this.f10325pl);
                this.e.u(this.p);
                this.e.w(this.y);
                this.e.u(this.kd);
                this.e.xj(this.zg);
                this.e.hf(d());
                hf.xj hf = this.e.hf(tfVar);
                if (hf.w()) {
                    return hf;
                }
            }
        }
        return new hf.xj(false, 0, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public String xj() {
        xj xjVar = this.e;
        if (xjVar == null) {
            return null;
        }
        String xj = xjVar.xj();
        try {
            JSONObject jSONObject = new JSONObject(xj);
            jSONObject.put("is_need_click", this.kd);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return xj;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.w.hf
    public void hf(String str) {
        super.hf(str);
        xj xjVar = this.e;
        if (xjVar == null) {
            return;
        }
        xjVar.hf(str);
    }
}
