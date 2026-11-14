package com.bytedance.sdk.openadsdk.core.q.xj;

import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj {
    public boolean hf(int i) {
        return i == 0 || i == 1;
    }

    public boolean w(int i) {
        return i == 2 || i == 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int xj(int r4) {
        /*
            r3 = this;
            com.bytedance.sdk.openadsdk.core.j.tf r0 = com.bytedance.sdk.openadsdk.core.pz.hf()
            org.json.JSONObject r0 = r0.vl()
            if (r0 == 0) goto L25
            boolean r1 = r3.hf(r4)
            r2 = 0
            if (r1 == 0) goto L18
            java.lang.String r4 = "explicit_interval"
            int r4 = r0.optInt(r4, r2)
            goto L26
        L18:
            boolean r4 = r3.w(r4)
            if (r4 == 0) goto L25
            java.lang.String r4 = "ambiguous_interval"
            int r4 = r0.optInt(r4, r2)
            goto L26
        L25:
            r4 = -1
        L26:
            r0 = 86400000(0x5265c00, float:7.82218E-36)
            if (r4 <= r0) goto L2c
            return r0
        L2c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.q.xj.xj.xj(int):int");
    }

    public void xj(int i, long j, long j2) {
        com.bytedance.sdk.openadsdk.core.q.xj xj = com.bytedance.sdk.openadsdk.core.q.xj.xj();
        xj.xj(i);
        xj.xj(j, j2);
    }

    public int xj(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("delay", 200);
        }
        return 200;
    }
}
