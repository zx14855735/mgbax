package com.bytedance.sdk.gromore.xj.xj.c.hf;

import android.text.TextUtils;
import com.bytedance.msdk.w.u.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends com.bytedance.sdk.openadsdk.mediation.hf.hf.hf.xj {
    private c xj;

    public u(c cVar) {
        this.xj = cVar;
    }

    public void hf(String str, final com.bytedance.sdk.openadsdk.jk.xj.hf.xj.hf hfVar) {
        c cVar;
        if (TextUtils.isEmpty(str) || (cVar = this.xj) == null || hfVar == null) {
            com.bytedance.msdk.xj.kd.w.u("TMe", "adm 参数错误 或者 drawTokenInfo is null");
        } else {
            cVar.xj(str, new com.bytedance.msdk.api.u.xj.w.hf() { // from class: com.bytedance.sdk.gromore.xj.xj.c.hf.u.1
                @Override // com.bytedance.msdk.api.u.xj.w.hf
                public void xj(List<com.bytedance.msdk.hf.w> list) {
                    if (list == null) {
                        hfVar.xj(null);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (com.bytedance.msdk.hf.w wVar : list) {
                        if (wVar != null) {
                            arrayList.add(new xj(u.this.xj, wVar, u.this.xj.jk()));
                        }
                    }
                    hfVar.xj(arrayList);
                }

                @Override // com.bytedance.msdk.api.u.xj.w.hf
                public void xj(com.bytedance.msdk.api.xj xjVar) {
                    if (xjVar != null) {
                        hfVar.xj(xjVar.xj, xjVar.hf);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.hf.hf.hf.xj
    public void xj(String str, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.hf hfVar) {
        hf(str, hfVar);
    }
}
