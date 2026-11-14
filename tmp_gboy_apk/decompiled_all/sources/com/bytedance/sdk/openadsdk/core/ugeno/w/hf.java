package com.bytedance.sdk.openadsdk.core.ugeno.w;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.kd.y;
import com.bytedance.adsdk.ugeno.w.jk;
import com.bytedance.adsdk.ugeno.w.qt;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.adsdk.ugeno.w.zg;
import com.bytedance.sdk.openadsdk.core.am.y;
import com.bytedance.sdk.openadsdk.core.ugeno.c.c;
import com.bytedance.sdk.openadsdk.core.v;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements jk, yo {
    private int c;
    private y hf;
    private jk kd;
    private xj u;
    private com.bytedance.adsdk.ugeno.hf.w<View> w;
    private Context xj;
    private String y;

    public interface xj {
        void xj(zg zgVar);
    }

    public hf(Context context, y yVar, String str, int i) {
        this.xj = context;
        this.hf = yVar;
        this.y = str;
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(JSONObject jSONObject, JSONObject jSONObject2, c cVar) {
        qt qtVar = new qt(this.xj);
        com.bytedance.adsdk.ugeno.hf.w<View> xj2 = qtVar.xj(jSONObject);
        this.w = xj2;
        if (xj2 == null) {
            y yVar = this.hf;
            if (yVar != null) {
                yVar.xj(-1, "ugeno render fail");
            }
            if (cVar != null) {
                cVar.xj(-1, "");
                return;
            }
            return;
        }
        qtVar.xj((jk) this);
        qtVar.xj((yo) this);
        qtVar.hf(jSONObject2);
        this.hf.xj(0L);
        if (cVar != null) {
            cVar.xj(this.w);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.yo
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
    }

    public void xj(xj xjVar) {
        this.u = xjVar;
    }

    public void xj(jk jkVar) {
        this.kd = jkVar;
    }

    public void xj(final JSONObject jSONObject, final JSONObject jSONObject2, final c cVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hf(jSONObject, jSONObject2, cVar);
        } else {
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.w.hf.1
                @Override // java.lang.Runnable
                public void run() {
                    hf.this.hf(jSONObject, jSONObject2, cVar);
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.w.yo
    public void xj(zg zgVar, yo.hf hfVar, yo.xj xjVar) {
        xj xjVar2;
        if (zgVar == null || zgVar.hf() != 1 || (xjVar2 = this.u) == null) {
            return;
        }
        xjVar2.xj(zgVar);
    }

    @Override // com.bytedance.adsdk.ugeno.w.jk
    public void xj(com.bytedance.adsdk.ugeno.hf.w wVar, MotionEvent motionEvent) {
        jk jkVar = this.kd;
        if (jkVar != null) {
            jkVar.xj(wVar, motionEvent);
        }
    }
}
