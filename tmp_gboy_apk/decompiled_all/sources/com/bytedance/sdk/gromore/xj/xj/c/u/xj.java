package com.bytedance.sdk.gromore.xj.xj.c.u;

import android.text.TextUtils;
import com.bytedance.msdk.w.u.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends com.bytedance.sdk.openadsdk.mediation.hf.hf.hf.hf {
    private d xj;

    public xj(d dVar) {
        this.xj = dVar;
    }

    public void hf(String str, final com.bytedance.sdk.openadsdk.jk.xj.hf.xj.w wVar) {
        d dVar;
        if (TextUtils.isEmpty(str) || (dVar = this.xj) == null || wVar == null) {
            com.bytedance.msdk.xj.kd.w.u("TMe", "adm 参数错误 或者 nativeAdManager is null");
        } else {
            dVar.xj(str, new com.bytedance.msdk.api.u.xj.c.u() { // from class: com.bytedance.sdk.gromore.xj.xj.c.u.xj.1
                @Override // com.bytedance.msdk.api.u.xj.c.u
                public void xj(List<com.bytedance.msdk.hf.w> list) {
                    if (list == null) {
                        wVar.xj(null);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (com.bytedance.msdk.hf.w wVar2 : list) {
                        if (wVar2 != null) {
                            arrayList.add(new hf(xj.this.xj, wVar2, xj.this.xj.jk()));
                        }
                    }
                    wVar.xj(arrayList);
                }

                @Override // com.bytedance.msdk.api.u.xj.c.u
                public void xj(com.bytedance.msdk.api.xj xjVar) {
                    if (xjVar != null) {
                        wVar.xj(xjVar.xj, xjVar.hf);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.hf.hf.hf.hf
    public void xj(String str, com.bytedance.sdk.openadsdk.jk.xj.hf.xj.w wVar) {
        hf(str, wVar);
    }
}
