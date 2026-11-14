package com.bytedance.sdk.gromore.xj.xj.c.xj;

import android.content.Context;
import android.view.View;
import com.bytedance.msdk.api.u.xj.xj.u;
import com.bytedance.msdk.w.u.p;
import com.bytedance.sdk.gromore.xj.xj.kd;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements kd {
    private final com.bytedance.sdk.gromore.xj.xj.xj.xj hf;
    private boolean u;
    private p w;
    private final com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xj;

    public w(Context context, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj xjVar, com.bytedance.sdk.gromore.xj.xj.xj.xj xjVar2, boolean z) {
        this.xj = xjVar;
        this.hf = xjVar2;
        this.u = z;
        if (xjVar != null) {
            this.w = new p(context);
        }
    }

    @Override // com.bytedance.sdk.gromore.xj.xj.kd
    public void xj() {
        final com.bytedance.sdk.openadsdk.mediation.ad.xj.hf.xj.hf tf;
        com.bytedance.msdk.api.xj.hf hfVar = new com.bytedance.msdk.api.xj.hf(1, this.xj.z());
        hfVar.xj(this.u);
        com.bytedance.sdk.openadsdk.mediation.hf.hf.hf ai = this.xj.ai();
        if (ai != null && (tf = ai.tf()) != null) {
            this.w.xj(new u() { // from class: com.bytedance.sdk.gromore.xj.xj.c.xj.w.1
                @Override // com.bytedance.msdk.api.u.xj.xj.u
                public View xj(com.bytedance.msdk.api.u.xj.xj.w wVar) {
                    if (wVar != null) {
                        return tf.xj(new com.bytedance.sdk.gromore.xj.xj.xj.u(wVar));
                    }
                    return null;
                }
            });
        }
        this.w.xj(hfVar, new com.bytedance.msdk.api.u.xj.xj.hf() { // from class: com.bytedance.sdk.gromore.xj.xj.c.xj.w.2
            @Override // com.bytedance.msdk.api.u.xj.xj.hf
            public void xj(com.bytedance.msdk.api.xj xjVar) {
                if (w.this.hf != null) {
                    w.this.hf.xj(xjVar.xj, xjVar.hf);
                }
            }

            @Override // com.bytedance.msdk.api.u.xj.xj.hf
            public void xj() {
                if (w.this.hf != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new xj(w.this.w));
                    w.this.hf.xj(arrayList);
                }
            }
        });
    }
}
