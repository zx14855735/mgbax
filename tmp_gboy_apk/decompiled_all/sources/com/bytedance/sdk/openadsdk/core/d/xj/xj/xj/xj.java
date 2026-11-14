package com.bytedance.sdk.openadsdk.core.d.xj.xj.xj;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.a.en;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.pl.d;
import com.bytedance.sdk.openadsdk.core.pl.w.tf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.jk;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj implements com.bytedance.sdk.openadsdk.core.d.xj.xj.xj {
    protected DownloadStatusChangeListener f;
    private com.bytedance.sdk.openadsdk.core.d.xj.xj.xj g;
    protected Context hf;
    protected String kd;

    /* renamed from: pl, reason: collision with root package name */
    private volatile boolean f10349pl;
    private jk tf;
    protected com.bytedance.sdk.openadsdk.core.pl.w.w.w u;
    protected String w;
    protected ws xj;
    protected boolean y;
    protected volatile boolean c = false;
    private int p = 0;
    protected Function<SparseArray<Object>, Object> d = com.bytedance.sdk.openadsdk.core.f.zg().r();

    private void c(Map<String, Object> map) {
        if (this.d != null) {
            int w = w(map);
            if (map != null) {
                map.put("hashCode", Integer.valueOf(w));
            }
            this.d.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(16).xj(Void.class).xj(0, map).hf());
        }
    }

    private void kd(Map<String, Object> map) {
        int w = w(map);
        xj(this.f10349pl, w);
        if (this.hf == null || TextUtils.isEmpty(this.kd) || !y(map)) {
            return;
        }
        this.u.xj(hf(w), this.xj);
        en<String, Object> xj = new en().xj("downloadUrl", this.kd);
        xj.put("is_feed_register_direct_download", map.get("is_feed_register_direct_download"));
        xj.put("download_manager_hash_code", map.get("download_manager_hash_code"));
        com.bytedance.sdk.openadsdk.core.pl.xj.hf u = u(xj);
        if (u == null || xj((com.bytedance.sdk.openadsdk.core.ra.u) null, u, xj)) {
            return;
        }
        xj(true, w);
        xj(xj, u);
    }

    public static int w(Map<String, Object> map) {
        if (map == null) {
            return 0;
        }
        Object obj = map.get("download_manager_hash_code");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    private boolean y(Map<String, Object> map) {
        if (this.d == null) {
            return true;
        }
        jk jkVar = this.tf;
        if (jkVar != null && jkVar.kd() == 1) {
            return true;
        }
        if (pz.hf().oa()) {
            String str = "已下载%d%%，可在通知栏暂停或取消";
            try {
                DownloadStatusChangeListener downloadStatusChangeListener = this.f;
                if (downloadStatusChangeListener instanceof com.bytedance.sdk.openadsdk.core.pl.xj.w) {
                    str = String.format("已下载%d%%，可在通知栏暂停或取消", Integer.valueOf(((com.bytedance.sdk.openadsdk.core.pl.xj.w) downloadStatusChangeListener).getCurrentPercent()));
                }
            } catch (Exception unused) {
            }
            return xj(map, str, true);
        }
        jk jkVar2 = this.tf;
        if (jkVar2 == null || !jkVar2.w()) {
            return xj(map, "应用正在下载...", false);
        }
        return true;
    }

    public abstract void hf(boolean z, int i);

    public boolean hf(Map<String, Object> map) {
        if (this.xj.dz() || TextUtils.isEmpty(this.kd)) {
            return false;
        }
        if (am.w(this.hf) != 0) {
            kd(map);
            return true;
        }
        try {
            Context context = this.hf;
            x.xj(context, com.bytedance.sdk.component.utils.jk.xj(context, "tt_no_network"), 0);
        } catch (Exception unused) {
        }
        return true;
    }

    public abstract com.bytedance.sdk.openadsdk.core.pl.xj.hf u(Map<String, Object> map);

    public abstract boolean w(int i);

    public abstract com.bytedance.sdk.openadsdk.core.pl.xj.kd xj(Map<String, Object> map, en<String, Object> enVar);

    @Override // com.bytedance.sdk.openadsdk.core.d.xj.xj.xj
    public boolean xj(Map<String, Object> map) {
        if (xj()) {
            return hf(map);
        }
        return false;
    }

    public boolean xj() {
        return (this.xj == null || this.hf == null || this.d == null || TextUtils.isEmpty(this.kd) || TextUtils.isEmpty(this.w) || this.u == null) ? false : true;
    }

    private void hf(com.bytedance.sdk.openadsdk.core.pl.xj.hf hfVar, Map<String, Object> map) {
        if (this.d == null) {
            return;
        }
        en<String, Object> xj = new en().xj("itemClickListener", null).xj("downloadButtonClickListener", com.bytedance.sdk.openadsdk.zg.w.u.xj(hfVar)).xj("hashCode", Integer.valueOf(w(map))).xj(map);
        xj.put("itemClickListener", com.bytedance.sdk.openadsdk.zg.w.u.xj(xj(map, xj)));
        this.d.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(17).xj(Void.class).xj(0, xj).hf());
    }

    private boolean xj(Map<String, Object> map, final String str, final boolean z) {
        Object apply;
        apply = this.d.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(6).xj(Boolean.class).xj(0, new en().xj("hashCode", Integer.valueOf(w(map))).xj("downloadUrl", this.kd)).hf());
        if (apply == null || !((Boolean) apply).booleanValue()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.xj.1
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    x.hf(xj.this.hf, str, 0, 17, 0, 0);
                } else {
                    x.xj(xj.this.hf, str, 0);
                }
            }
        });
        return false;
    }

    public com.bytedance.sdk.openadsdk.core.pl.w.w.xj hf(int i) {
        if (w(i)) {
            return new com.bytedance.sdk.openadsdk.core.pl.w.w.kd();
        }
        if (this.c) {
            return new com.bytedance.sdk.openadsdk.core.pl.w.w.u();
        }
        return new com.bytedance.sdk.openadsdk.core.pl.w.w.hf();
    }

    public void hf(boolean z) {
        this.y = z;
    }

    private com.bytedance.sdk.openadsdk.core.pl.xj.hf hf(final com.bytedance.sdk.openadsdk.core.ra.u uVar, final Map<String, Object> map) {
        return new com.bytedance.sdk.openadsdk.core.pl.xj.hf() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.xj.5
            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z) {
                if (z && xj.this.xj(uVar, (com.bytedance.sdk.openadsdk.core.pl.xj.hf) null, map)) {
                    return;
                }
                xj.this.xj((com.bytedance.sdk.openadsdk.core.pl.xj.hf) null, map);
            }

            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
            }
        };
    }

    public boolean xj(com.bytedance.sdk.openadsdk.core.ra.u uVar, final com.bytedance.sdk.openadsdk.core.pl.xj.hf hfVar, final Map<String, Object> map) {
        boolean xj = com.bytedance.sdk.openadsdk.core.d.xj.u.xj.xj(map);
        final int w = w(map);
        if (!this.u.u(xj)) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xjVar = this.g;
        if (xjVar != null && xjVar.xj(new HashMap())) {
            return true;
        }
        this.u.xj(uVar, this.w, this.kd, new com.bytedance.sdk.openadsdk.core.pl.w.xj.hf() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.xj.2
            @Override // com.bytedance.sdk.openadsdk.core.pl.w.xj.hf
            public void xj() {
                if (!xj.this.w(w)) {
                    xj.this.xj(hfVar, map);
                } else {
                    xj.this.xj(true, w);
                    xj.this.xj((Map<String, Object>) map, hfVar);
                }
            }
        });
        return true;
    }

    public void xj(boolean z, int i) {
        if (ai.w >= 5400 && w(i)) {
            hf(z, i);
        }
    }

    public void xj(boolean z) {
        this.c = z;
    }

    public void xj(DownloadStatusChangeListener downloadStatusChangeListener) {
        this.f = downloadStatusChangeListener;
    }

    public void xj(jk jkVar) {
        this.tf = jkVar;
    }

    public void xj(int i) {
        this.p = i;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.d.xj.xj.xj xjVar) {
        this.g = xjVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final Map<String, Object> map, final com.bytedance.sdk.openadsdk.core.pl.xj.hf hfVar) {
        d.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.xj.3
            @Override // java.lang.Runnable
            public void run() {
                xj.this.xj(hfVar, map);
            }
        }, this.xj);
        this.f10349pl = false;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.pl.xj.hf hfVar, Map<String, Object> map) {
        try {
            if (hfVar == null) {
                c(map);
                this.f10349pl = false;
            } else {
                hf(hfVar, map);
                this.f10349pl = false;
            }
        } catch (Throwable unused) {
        }
    }

    public void xj(final Map<String, Object> map, final boolean z) {
        int i = this.p;
        if (i == 1) {
            tf.xj(pz.getContext());
            return;
        }
        if (i == 2) {
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.xj.4
                @Override // java.lang.Runnable
                public void run() {
                    dk<com.bytedance.sdk.openadsdk.core.am.xj> xj = pz.xj();
                    xj xjVar = xj.this;
                    com.bytedance.sdk.openadsdk.core.ra.u xj2 = xj.xj(xjVar.xj, xjVar.kd);
                    if (xj2 == null || !xj2.kd()) {
                        tf.xj(pz.getContext());
                    } else if (z) {
                        xj.this.xj(xj2, (Map<String, Object>) map);
                    } else {
                        xj.this.xj((com.bytedance.sdk.openadsdk.core.pl.xj.hf) null, map);
                    }
                }
            });
        } else if (z) {
            xj((com.bytedance.sdk.openadsdk.core.ra.u) null, map);
        } else {
            xj((com.bytedance.sdk.openadsdk.core.pl.xj.hf) null, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.core.ra.u uVar, Map<String, Object> map) {
        xj(hf(uVar, map), map);
    }
}
