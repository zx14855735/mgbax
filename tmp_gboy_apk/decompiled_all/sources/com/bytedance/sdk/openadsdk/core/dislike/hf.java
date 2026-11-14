package com.bytedance.sdk.openadsdk.core.dislike;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.zg.w.hf.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static com.bytedance.sdk.openadsdk.core.dislike.xj.u hf;
    private static com.bytedance.sdk.openadsdk.core.dislike.xj.w xj;

    public static void xj() {
        if (hf == null) {
            hf = new com.bytedance.sdk.openadsdk.core.dislike.xj.u() { // from class: com.bytedance.sdk.openadsdk.core.dislike.hf.1
                @Override // com.bytedance.sdk.openadsdk.core.dislike.xj.u
                public int xj(Context context, float f) {
                    return r.w(context, f);
                }
            };
        }
        if (xj == null) {
            xj = new com.bytedance.sdk.openadsdk.core.dislike.xj.w() { // from class: com.bytedance.sdk.openadsdk.core.dislike.hf.2
                @Override // com.bytedance.sdk.openadsdk.core.dislike.xj.w
                public void xj(com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar, y yVar) {
                    com.bytedance.sdk.openadsdk.core.am.u.xj(hfVar, yVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.xj.w
                public void xj(Context context, com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar, String str) {
                    com.bytedance.sdk.openadsdk.core.am.u.xj(hfVar.w(), hfVar.u(), hfVar.c(), str);
                }
            };
        }
        com.bytedance.sdk.openadsdk.core.dislike.xj.xj.xj(xj, hf);
    }
}
