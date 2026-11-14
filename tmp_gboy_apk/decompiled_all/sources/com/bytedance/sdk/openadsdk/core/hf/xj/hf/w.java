package com.bytedance.sdk.openadsdk.core.hf.xj.hf;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.g;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.x.c;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private final Context hf;
    private hf kd;
    private final AtomicBoolean u = new AtomicBoolean(true);
    private String w;
    private final ws xj;

    public interface hf {
        void xj();

        void xj(String str, boolean z);
    }

    public interface xj {
        void xj();
    }

    public w(ws wsVar, Context context) {
        this.xj = wsVar;
        this.hf = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(g gVar) {
        if (this.u.getAndSet(false)) {
            hf(gVar);
        }
    }

    private void hf(final g gVar) {
        if (gVar == null) {
            return;
        }
        try {
            pz.xj().xj(gVar.hf(), new dk.w<com.bytedance.sdk.component.d.hf>() { // from class: com.bytedance.sdk.openadsdk.core.hf.xj.hf.w.3
                @Override // com.bytedance.sdk.openadsdk.core.dk.w
                public void xj(int i, String str) {
                    w.this.xj();
                    w.this.w(gVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.dk.w
                public void xj(com.bytedance.sdk.component.d.hf hfVar) {
                    if (hfVar == null || !hfVar.f() || TextUtils.isEmpty(hfVar.u())) {
                        w.this.xj();
                        w.this.w(gVar);
                    } else {
                        try {
                            w.this.xj(new JSONObject(hfVar.u()));
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public w xj(String str) {
        this.w = str;
        return this;
    }

    private void hf(JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("is_apply_coupon");
        String optString = jSONObject.optString("error_type");
        if (optBoolean && cb.o.equals(optString)) {
            com.bytedance.sdk.openadsdk.core.am.u.hf(this.xj, this.w, 1);
        } else if (optBoolean && "has_applied".equals(optString)) {
            com.bytedance.sdk.openadsdk.core.am.u.hf(this.xj, this.w, 2);
        } else if (!optBoolean) {
            com.bytedance.sdk.openadsdk.core.am.u.hf(this.xj, this.w, 3);
        }
        if (this.kd != null) {
            if (optBoolean && cb.o.equals(optString)) {
                this.kd.xj();
            } else {
                this.kd.xj(optString, optBoolean);
            }
        }
    }

    public void xj(hf hfVar) {
        this.kd = hfVar;
    }

    public static boolean xj(ws wsVar, boolean z) {
        g yl = wsVar != null ? wsVar.yl() : null;
        return yl != null && yl.xj(z);
    }

    public int xj(final xj xjVar) {
        ws wsVar = this.xj;
        g yl = wsVar != null ? wsVar.yl() : null;
        xj(yl);
        hf(yl);
        v.y().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hf.xj.hf.w.1
            @Override // java.lang.Runnable
            public void run() {
                xj xjVar2 = xjVar;
                if (xjVar2 != null) {
                    xjVar2.xj();
                }
            }
        }, 500L);
        return 1;
    }

    private void xj(g gVar) {
        if (gVar == null || TextUtils.isEmpty(gVar.u())) {
            return;
        }
        final String u = gVar.u();
        c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.hf.xj.hf.w.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    x.hf(w.this.hf.getApplicationContext(), u, 0, 17, 0, 0);
                } catch (Throwable th) {
                    pl.xj(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj() {
        com.bytedance.sdk.openadsdk.core.am.u.hf(this.xj, this.w, 4);
        hf hfVar = this.kd;
        if (hfVar != null) {
            hfVar.xj("net_fail", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(JSONObject jSONObject) {
        try {
            if (jSONObject.has("is_apply_coupon")) {
                hf(jSONObject);
            }
        } catch (Throwable unused) {
            xj();
        }
    }
}
