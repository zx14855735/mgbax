package com.bytedance.sdk.openadsdk.core.component.splash.xj;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.openadsdk.core.a.j;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.component.splash.c;
import com.bytedance.sdk.openadsdk.core.et;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.qd;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.sigmob.sdk.base.n;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends com.bytedance.sdk.openadsdk.core.component.splash.xj.xj {
    private hf c;
    private volatile com.bytedance.sdk.component.u.hf.w f = null;
    private com.bytedance.sdk.component.u.hf.w d = j.xj("tt_materialMeta");

    public class hf extends d {
        private qd hf;

        public hf(qd qdVar) {
            super("WriteCacheTask");
            this.hf = qdVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            xj();
        }

        public void xj(qd qdVar) {
            this.hf = qdVar;
        }

        private void xj() {
            try {
                int xj = c.xj(this.hf);
                if (xj <= 0) {
                    return;
                }
                String str = u.this.d.get("net_ad_already_shown", "");
                if (!TextUtils.isEmpty(str) && str.equals(this.hf.xj().zf())) {
                    com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "该缓存已show-则不再save： rit: " + xj + "   reqId: " + this.hf.xj().zf());
                    return;
                }
                JSONObject w = this.hf.hf().w();
                if (w != null) {
                    u.this.d.put("materialMeta".concat(String.valueOf(xj)), w.toString());
                }
                u.this.d.put("net_ad_save_success".concat(String.valueOf(xj)), this.hf.xj().zf());
                com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "缓存成功： rit: " + xj + "   reqId: " + this.hf.xj().zf());
            } catch (Throwable unused) {
            }
        }
    }

    public static class xj {
        boolean xj = true;
        long hf = 0;
        long w = 0;
        long u = 0;
    }

    private com.bytedance.sdk.component.u.hf.w kd() {
        if (this.f == null) {
            this.f = j.xj("tt_splash");
        }
        return this.f;
    }

    private void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.u.hf.w kd = kd();
        this.d.remove("materialMeta" + str);
        if (kd != null) {
            kd.remove("has_ad_cache" + str);
            kd.remove("expiration" + str);
        }
        com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "清除成功： rit: " + str);
    }

    private boolean w(final String str) {
        final xj hf2 = hf(str);
        if (hf2.xj) {
            am.xj().c(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.xj.u.1
                @Override // com.bytedance.sdk.openadsdk.p.xj.xj
                public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                    xj xjVar = hf2;
                    long j = xjVar.u - xjVar.hf;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("available_type", 0);
                    jSONObject.putOpt("creative_timeout_duration", Long.valueOf(j / 3600));
                    return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj(4).w(str).hf(jSONObject.toString());
                }
            });
        }
        kd kdVar = this.y;
        long j = kdVar == null ? 0L : kdVar.xj;
        if (j <= 0 || hf2.hf * 1000 >= j) {
            return hf2.xj;
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xj.xj
    public void hf() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xj.xj
    public void xj(String str, String str2, boolean z, boolean z2, Object obj) {
    }

    private xj hf(String str) {
        xj xjVar = new xj();
        if (TextUtils.isEmpty(str)) {
            return xjVar;
        }
        com.bytedance.sdk.component.u.hf.w kd = kd();
        long j = kd.get("expiration" + str, 0L);
        long j2 = kd.get(n.q + str, 0L);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        xjVar.xj = currentTimeMillis < j2 || currentTimeMillis >= j;
        xjVar.hf = j2;
        xjVar.w = j;
        xjVar.u = currentTimeMillis;
        return xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xj.xj
    public void xj(qd qdVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, boolean z) {
        int xj2;
        if (qdVar != null && (xj2 = c.xj(qdVar)) > 0) {
            xj(xj2, qdVar.xj().o());
            xj(qdVar);
        }
    }

    private com.bytedance.sdk.openadsdk.core.ra.xj kd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.d.get("materialMeta" + str, (String) null);
        if (!TextUtils.isEmpty(str2)) {
            try {
                et.xj xj2 = et.xj.xj(new JSONObject(str2));
                if (xj2 != null) {
                    com.bytedance.sdk.openadsdk.core.ra.xj xjVar = xj2.f;
                    if (xjVar != null) {
                        return xjVar;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private void xj(qd qdVar) {
        hf hfVar = this.c;
        if (hfVar == null) {
            this.c = new hf(qdVar);
        } else {
            hfVar.xj(qdVar);
        }
        com.bytedance.sdk.component.tf.c.xj(this.c, 10);
    }

    public static void u() {
        pz.hf().wx();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xj.xj
    public void w() {
        try {
            j.xj("tt_materialMeta").clear();
            j.xj("tt_splash").clear();
        } catch (Throwable unused) {
        }
    }

    private void xj(int i, long j) {
        com.bytedance.sdk.component.u.hf.w kd = kd();
        kd.put("expiration" + i, j);
        kd.put(CtFAbx.ARc23Z(i, n.q), System.currentTimeMillis() / 1000);
        kd.put("has_ad_cache" + i, true);
    }

    private boolean xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c cVar, String str) {
        if (xj(str)) {
            return true;
        }
        if (cVar != null) {
            cVar.u(0);
            cVar.hf(1);
            cVar.xj("no cache");
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041 A[Catch: all -> 0x004f, TryCatch #1 {all -> 0x004f, blocks: (B:28:0x0022, B:30:0x0028, B:32:0x0032, B:15:0x0041, B:16:0x0044, B:24:0x0051), top: B:27:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #1 {all -> 0x004f, blocks: (B:28:0x0022, B:30:0x0028, B:32:0x0032, B:15:0x0041, B:16:0x0044, B:24:0x0051), top: B:27:0x0022 }] */
    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xj.xj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c r3, java.lang.String r4, com.bytedance.sdk.openadsdk.core.component.splash.xj.xj.InterfaceC0156xj r5, com.bytedance.sdk.openadsdk.core.component.splash.xj.kd r6) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L64
            if (r5 != 0) goto L9
            goto L64
        L9:
            r2.y = r6
            boolean r3 = r2.xj(r3, r4)
            if (r3 != 0) goto L15
            r5.xj()
            return
        L15:
            r3 = 0
            com.bytedance.sdk.openadsdk.core.ra.xj r6 = r2.kd(r4)     // Catch: java.lang.Throwable -> L54
            com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y r0 = new com.bytedance.sdk.openadsdk.core.component.splash.w.xj.y     // Catch: java.lang.Throwable -> L54
            r1 = 1
            r0.<init>(r6, r1)     // Catch: java.lang.Throwable -> L54
            if (r6 == 0) goto L3e
            java.util.List r1 = r6.hf()     // Catch: java.lang.Throwable -> L4f
            if (r1 == 0) goto L3e
            java.util.List r1 = r6.hf()     // Catch: java.lang.Throwable -> L4f
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L4f
            if (r1 != 0) goto L3e
            java.util.List r6 = r6.hf()     // Catch: java.lang.Throwable -> L4f
            r1 = 0
            java.lang.Object r6 = r6.get(r1)     // Catch: java.lang.Throwable -> L4f
            com.bytedance.sdk.openadsdk.core.ra.ws r6 = (com.bytedance.sdk.openadsdk.core.ra.ws) r6     // Catch: java.lang.Throwable -> L4f
            goto L3f
        L3e:
            r6 = r3
        L3f:
            if (r6 == 0) goto L44
            r0.xj(r6)     // Catch: java.lang.Throwable -> L4f
        L44:
            com.bytedance.sdk.openadsdk.core.live.hf r1 = com.bytedance.sdk.openadsdk.core.live.hf.xj()     // Catch: java.lang.Throwable -> L4f
            int r6 = r1.w(r6)     // Catch: java.lang.Throwable -> L4f
            r1 = 3
            if (r6 == r1) goto L51
        L4f:
            r3 = r0
            goto L54
        L51:
            r0.xj(r3)     // Catch: java.lang.Throwable -> L4f
        L54:
            r5.xj(r3)
            com.bytedance.sdk.openadsdk.core.w.kd r3 = com.bytedance.sdk.openadsdk.core.w.kd.xj()
            boolean r3 = r3.tf()
            if (r3 != 0) goto L64
            r2.u(r4)
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.splash.xj.u.xj(com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c, java.lang.String, com.bytedance.sdk.openadsdk.core.component.splash.xj.xj$xj, com.bytedance.sdk.openadsdk.core.component.splash.xj.kd):void");
    }

    public boolean xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        com.bytedance.sdk.component.u.hf.w kd = kd();
        StringBuilder sb = new StringBuilder("has_ad_cache");
        sb.append(str);
        return kd.get(sb.toString(), false) && !w(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xj.xj
    public void xj(com.bytedance.sdk.openadsdk.core.component.splash.w.w.u<com.bytedance.sdk.openadsdk.core.component.splash.w.xj.d, com.bytedance.sdk.openadsdk.core.component.splash.w.xj.c> uVar, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, boolean z) {
        if (wsVar == null) {
            return;
        }
        if (z) {
            this.d.put("net_ad_already_shown", wsVar.zf());
        }
        if (this.kd.get()) {
            return;
        }
        String str = this.d.get("net_ad_save_success" + wo.d(wsVar), "");
        if (TextUtils.isEmpty(str) || !str.equals(wsVar.zf())) {
            return;
        }
        this.kd.set(true);
        com.bytedance.sdk.openadsdk.core.c.xj.xj("lqmt", "计划清除缓存 reqId:  ".concat(str));
        u(hfVar != null ? hfVar.u() : null);
        if (uVar != null) {
            uVar.xj();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.xj.xj
    public void xj(String str, ws wsVar) {
        u(str);
    }
}
