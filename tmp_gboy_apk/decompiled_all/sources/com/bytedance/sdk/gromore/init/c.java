package com.bytedance.sdk.gromore.init;

import com.bytedance.sdk.openadsdk.core.q;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends com.bytedance.sdk.openadsdk.core.wo.u {
    private f hf;
    private final q xj;

    public c(q qVar) {
        this.xj = qVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00af, code lost:
    
        r5 = r7.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(5).xj(java.lang.Object.class).hf());
     */
    @Override // com.bytedance.sdk.openadsdk.core.wo.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> T applyFunction(int r5, com.bykv.vk.openvk.api.proto.PluginValueSet r6, java.lang.Class<T> r7) {
        /*
            r4 = this;
            r7 = -99999986(0xfffffffffa0a1f0e, float:-1.792917E35)
            r0 = 0
            if (r5 != r7) goto Lf
            com.bytedance.sdk.openadsdk.core.q r5 = r4.xj
            if (r5 == 0) goto Le7
            android.util.SparseArray r5 = r5.xj()
            return r5
        Lf:
            r7 = 6
            if (r5 != r7) goto L79
            if (r6 == 0) goto L1f
            r5 = 10
            java.lang.Class<android.os.Bundle> r7 = android.os.Bundle.class
            java.lang.Object r5 = r6.objectValue(r5, r7)
            android.os.Bundle r5 = (android.os.Bundle) r5
            goto L20
        L1f:
            r5 = r0
        L20:
            if (r6 == 0) goto L2d
            r7 = 9
            java.lang.Class<java.lang.Class> r1 = java.lang.Class.class
            java.lang.Object r7 = r6.objectValue(r7, r1)
            java.lang.Class r7 = (java.lang.Class) r7
            goto L2e
        L2d:
            r7 = r0
        L2e:
            if (r5 == 0) goto L4a
            java.lang.String r1 = "mediation_manager"
            java.lang.String r2 = r5.getString(r1)
            boolean r1 = android.text.TextUtils.equals(r2, r1)
            if (r1 == 0) goto L4a
            com.bytedance.sdk.gromore.init.f r5 = r4.hf
            if (r5 != 0) goto L47
            com.bytedance.sdk.gromore.init.f r5 = new com.bytedance.sdk.gromore.init.f
            r5.<init>()
            r4.hf = r5
        L47:
            com.bytedance.sdk.gromore.init.f r5 = r4.hf
            return r5
        L4a:
            boolean r1 = com.bytedance.sdk.openadsdk.core.wo.xj.u.xj(r7, r5)
            if (r1 == 0) goto L6c
            com.bytedance.sdk.openadsdk.core.q r1 = r4.xj
            if (r1 == 0) goto Le7
            android.util.SparseArray r6 = r6.sparseArray()
            java.lang.Object r6 = r1.apply(r6)
            boolean r1 = r6 instanceof com.bytedance.sdk.openadsdk.core.wo.xj.u.xj
            if (r1 == 0) goto Le7
            com.bytedance.sdk.gromore.init.d r0 = new com.bytedance.sdk.gromore.init.d
            com.bytedance.sdk.openadsdk.core.wo.xj.u$xj r6 = (com.bytedance.sdk.openadsdk.core.wo.xj.u.xj) r6
            r0.<init>(r6)
            java.lang.Object r5 = com.bytedance.sdk.openadsdk.core.wo.xj.u.xj(r0, r7, r5)
            return r5
        L6c:
            com.bytedance.sdk.openadsdk.core.q r5 = r4.xj
            if (r5 == 0) goto Le7
            android.util.SparseArray r6 = r6.sparseArray()
            java.lang.Object r5 = r5.apply(r6)
            return r5
        L79:
            r7 = 4
            if (r5 != r7) goto Lda
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            if (r6 == 0) goto L87
            r7 = 8
            java.lang.Object r7 = r6.objectValue(r7, r5)
            goto L88
        L87:
            r7 = r0
        L88:
            boolean r1 = com.bytedance.sdk.openadsdk.core.ai.c()
            if (r1 == 0) goto Lcd
            boolean r1 = ADYaiT.BpkvW3.BmvVmW(r7)
            if (r1 == 0) goto Lcd
            java.util.function.Function r7 = P8ccfD.AaHO0E.AYUAbz(r7)
            android.util.SparseArray r1 = com.bytedance.sdk.openadsdk.zg.w.xj(r7)
            IzHBwY.AYUAbz r2 = new IzHBwY.AYUAbz
            r2.<init>(r1)
            IzHBwY.ASJ6gh r1 = r2.A2egSU()
            r2 = 0
            r3 = 10000(0x2710, float:1.4013E-41)
            int r1 = r1.intValue(r3, r2)
            r2 = 1
            if (r1 != r2) goto Lcd
            com.bytedance.sdk.openadsdk.zg.u r1 = com.bytedance.sdk.openadsdk.zg.u.xj()
            r2 = 5
            com.bytedance.sdk.openadsdk.zg.u r1 = r1.xj(r2)
            com.bytedance.sdk.openadsdk.zg.u r5 = r1.xj(r5)
            android.util.SparseArray r5 = r5.hf()
            java.lang.Object r5 = P8ccfD.AaHO0E.ASJ6gh(r7, r5)
            if (r5 == 0) goto Lcd
            com.bytedance.msdk.core.xj r7 = com.bytedance.msdk.core.xj.p()
            r7.xj(r5)
        Lcd:
            com.bytedance.sdk.openadsdk.core.q r5 = r4.xj
            if (r5 == 0) goto Le7
            android.util.SparseArray r6 = r6.sparseArray()
            java.lang.Object r5 = r5.apply(r6)
            return r5
        Lda:
            com.bytedance.sdk.openadsdk.core.q r5 = r4.xj
            if (r5 == 0) goto Le7
            android.util.SparseArray r6 = r6.sparseArray()
            java.lang.Object r5 = r5.apply(r6)
            return r5
        Le7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.gromore.init.c.applyFunction(int, com.bykv.vk.openvk.api.proto.PluginValueSet, java.lang.Class):java.lang.Object");
    }
}
