package com.bytedance.sdk.openadsdk.core.pl.w;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.en;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.ff;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y extends kd {
    public y(Context context, ws wsVar, String str, boolean z) {
        super(context, wsVar, str, z);
    }

    private void e() {
        if (ai.w >= 5400 && w() && !this.ra) {
            com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(false, (com.bytedance.sdk.openadsdk.core.pl.xj.u) null, c());
        }
    }

    private void hf(com.bytedance.sdk.openadsdk.core.pl.xj.hf hfVar, Map<String, Object> map) {
        if (this.ht == null) {
            return;
        }
        final en<String, Object> xj = new en().xj("itemClickListener", null).xj("downloadButtonClickListener", com.bytedance.sdk.openadsdk.zg.w.u.xj(hfVar)).xj("hashCode", Integer.valueOf(c())).xj(map);
        xj.put("itemClickListener", com.bytedance.sdk.openadsdk.zg.w.u.xj(new com.bytedance.sdk.openadsdk.core.pl.xj.kd() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.y.3
            @Override // com.bytedance.sdk.openadsdk.core.pl.xj.kd
            public void onItemClick() {
                if (y.this.e || y.this.kd.ta()) {
                    com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.hf(1, y.this.c());
                    xj.remove("itemClickListener");
                    y.this.ht.apply(A2egSU.AZOQYO(17, Void.class).xj(0, xj).hf());
                } else {
                    Context context = y.this.getContext();
                    String ol = y.this.kd.ol();
                    y yVar = y.this;
                    ff.xj(context, ol, yVar.kd, yVar.y);
                }
            }
        }));
        this.ht.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(17).xj(Void.class).xj(0, xj).hf());
    }

    private void y(JSONObject jSONObject, final boolean z) {
        e();
        if (getContext() == null || this.u == null || !g()) {
            return;
        }
        String str = this.y;
        com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(str, str, jSONObject, c());
        final en<String, Object> xj = new en().xj("downloadUrl", this.u.hf()).xj("hashCode", Integer.valueOf(c())).xj("action_type_button", 2);
        ws wsVar = this.kd;
        if (wsVar != null && !TextUtils.isEmpty(wsVar.ho())) {
            xj.xj(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, Long.valueOf(Double.valueOf(this.kd.ho()).longValue()));
        }
        if (!w()) {
            xj(xj, z);
            return;
        }
        com.bytedance.sdk.openadsdk.core.pl.xj.hf hfVar = new com.bytedance.sdk.openadsdk.core.pl.xj.hf() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.y.1
            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z2) {
            }

            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
                if (xj == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(0, y.this.c());
                y.this.f().xj(y.this.am());
                xj.remove("downloadButtonClickListener");
                if (y.this.xj((com.bytedance.sdk.openadsdk.core.ra.u) null, (com.bytedance.sdk.openadsdk.core.pl.xj.hf) null, xj, z)) {
                    return;
                }
                y.this.hf(xj);
            }
        };
        com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(xj, hfVar);
        if (xj((com.bytedance.sdk.openadsdk.core.ra.u) null, hfVar, xj, z)) {
            return;
        }
        w(true);
        xj(xj, hfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd
    public void f(boolean z) {
        com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(this.y, this.kd, (JSONObject) null, c());
        com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(this.kd, c(), z);
        com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(this.y, c());
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd
    public synchronized void p() {
        try {
            if (this.u == null) {
                return;
            }
            if (this.ht != null && ai.w >= 6400 && !ai.c()) {
                com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj((com.bytedance.sdk.openadsdk.core.pl.xj.u) null, c());
            }
            AtomicBoolean atomicBoolean = this.tf;
            if (atomicBoolean != null && atomicBoolean.get()) {
                this.tf.set(false);
                if (this.ht != null) {
                    this.ht.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(4).xj(Void.class).xj(0, new en().xj("hashCode", Integer.valueOf(c()))).hf());
                }
            }
            tf();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void u() {
        if (this.u == null) {
            return;
        }
        this.tf.set(false);
        Function<SparseArray<Object>, Object> function = this.ht;
        if (function != null) {
            function.apply(A2egSU.AZOQYO(8, Void.class).xj(0, new en().xj("force", Boolean.TRUE).xj("hashCode", Integer.valueOf(c()))).hf());
        }
        zg();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd, com.bytedance.sdk.openadsdk.core.pl.hf.w
    public boolean w() {
        Function<SparseArray<Object>, Object> function = this.ht;
        return function != null && com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(function, c()) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.kd
    public synchronized void zg() {
        if (this.u == null) {
            return;
        }
        this.tf.set(true);
        if (this.ht != null) {
            this.ht.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(5).xj(Void.class).xj(0, new en().xj("hashCode", Integer.valueOf(c())).xj("downloadStatusChangeListener", com.bytedance.sdk.openadsdk.zg.w.u.xj(this.et))).hf());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void w(boolean z) {
        if (ai.w >= 5400 && z) {
            this.ra = true;
            if (w()) {
                try {
                    com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(true, com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(this.kd, this.dk), c());
                } catch (Throwable th) {
                    pl.w("xgcdl", "throwable", th);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(JSONObject jSONObject, boolean z) {
        y(jSONObject, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final Map<String, Object> map, final com.bytedance.sdk.openadsdk.core.pl.xj.hf hfVar) {
        com.bytedance.sdk.openadsdk.core.pl.d.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.y.2
            @Override // java.lang.Runnable
            public void run() {
                y.this.xj(hfVar, (Map<String, Object>) map);
            }
        }, this.kd);
        this.ra = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(final Map<String, Object> map) {
        int i = this.pz;
        if (i == 1) {
            return;
        }
        if (i == 2) {
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("tt_market_download_check") { // from class: com.bytedance.sdk.openadsdk.core.pl.w.y.5
                @Override // java.lang.Runnable
                public void run() {
                    dk<com.bytedance.sdk.openadsdk.core.am.xj> xj = pz.xj();
                    y yVar = y.this;
                    com.bytedance.sdk.openadsdk.core.ra.u xj2 = xj.xj(yVar.kd, yVar.u.hf());
                    if (xj2 == null || !xj2.kd()) {
                        return;
                    }
                    v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.y.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            y.this.xj((com.bytedance.sdk.openadsdk.core.pl.xj.hf) null, (Map<String, Object>) map);
                        }
                    });
                }
            });
        } else {
            xj((com.bytedance.sdk.openadsdk.core.pl.xj.hf) null, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.core.pl.xj.hf hfVar, Map<String, Object> map) {
        try {
            if (hfVar == null) {
                xj(map);
                this.ra = false;
            } else {
                hf(hfVar, map);
                this.ra = false;
            }
        } catch (Throwable unused) {
        }
    }

    private void xj(final Map<String, Object> map, final boolean z) {
        int i = this.pz;
        if (i == 1) {
            tf.xj(pz.getContext());
        } else if (i != 2) {
            xj((com.bytedance.sdk.openadsdk.core.ra.u) null, map, z);
        } else {
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.pl.w.y.4
                @Override // java.lang.Runnable
                public void run() {
                    dk<com.bytedance.sdk.openadsdk.core.am.xj> xj = pz.xj();
                    y yVar = y.this;
                    com.bytedance.sdk.openadsdk.core.ra.u xj2 = xj.xj(yVar.kd, yVar.u.hf());
                    if (xj2 == null || !xj2.kd()) {
                        tf.xj(pz.getContext());
                    } else {
                        y.this.xj(xj2, (Map<String, Object>) map, z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final com.bytedance.sdk.openadsdk.core.ra.u uVar, final Map<String, Object> map, final boolean z) {
        xj(new com.bytedance.sdk.openadsdk.core.pl.xj.hf() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.y.6
            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z2) {
                if (z2 && y.this.xj(uVar, (com.bytedance.sdk.openadsdk.core.pl.xj.hf) null, (Map<String, Object>) map, z)) {
                    return;
                }
                y.this.xj((com.bytedance.sdk.openadsdk.core.pl.xj.hf) null, (Map<String, Object>) map);
            }

            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
            }
        }, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xj(com.bytedance.sdk.openadsdk.core.ra.u uVar, final com.bytedance.sdk.openadsdk.core.pl.xj.hf hfVar, final Map<String, Object> map, boolean z) {
        com.bytedance.sdk.openadsdk.core.pl.w.w.w f = f();
        if (!f.u(z)) {
            return false;
        }
        if (xj(getContext(), this.kd, this.y)) {
            return true;
        }
        f.xj(uVar, this.y, this.u.hf(), new com.bytedance.sdk.openadsdk.core.pl.w.xj.hf() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.y.7
            @Override // com.bytedance.sdk.openadsdk.core.pl.w.xj.hf
            public void xj() {
                if (!y.this.w()) {
                    y.this.xj(hfVar, (Map<String, Object>) map);
                } else {
                    y.this.w(true);
                    y.this.xj((Map<String, Object>) map, hfVar);
                }
            }
        });
        return true;
    }
}
