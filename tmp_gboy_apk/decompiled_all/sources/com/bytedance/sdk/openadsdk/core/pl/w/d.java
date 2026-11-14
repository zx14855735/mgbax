package com.bytedance.sdk.openadsdk.core.pl.w;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.a.en;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.pl.u.w;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.jk;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.zg;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d extends f {
    private volatile com.bytedance.sdk.openadsdk.core.pl.w.w.w d;
    private final ws kd;
    private volatile boolean tf;
    private String u;
    private WeakReference<Context> w;
    private String y;
    private int f = 0;
    private boolean p = false;
    private Function<SparseArray<Object>, Object> c = com.bytedance.sdk.openadsdk.core.f.zg().r();

    public d(Context context, String str, ws wsVar, String str2, boolean z) {
        this.w = new WeakReference<>(context);
        this.kd = wsVar;
        this.y = str2;
        this.u = str;
        xj(z);
    }

    private boolean am() {
        ws wsVar = this.kd;
        com.bytedance.sdk.openadsdk.core.ra.y ut = wsVar != null ? wsVar.ut() : null;
        String g = ut != null ? ut.g() : "";
        Intent hf = TextUtils.isEmpty(g) ? null : wo.hf(getContext(), g);
        if (hf == null || !wo.w(getContext(), g)) {
            return false;
        }
        try {
            getContext().startActivity(hf);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private synchronized void d() {
        try {
            if (this.c == null) {
                return;
            }
            if (ai.w >= 6400 && !ai.c()) {
                com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj((com.bytedance.sdk.openadsdk.core.pl.xj.u) null, c());
            }
            if (p()) {
                this.c.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(2).xj(Boolean.class).xj(0, new en().xj("hashCode", Integer.valueOf(c()))).hf());
            } else {
                this.c.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(4).xj(Void.class).xj(0, new en().xj("hashCode", Integer.valueOf(c()))).hf());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private boolean e() {
        Object apply;
        if (this.c != null) {
            apply = this.c.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(6).xj(Boolean.class).xj(0, new en().xj("downloadUrl", this.u).xj("hashCode", Integer.valueOf(c()))).hf());
            if (apply != null && ((Boolean) apply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return qt() || am();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        try {
            WeakReference<Context> weakReference = this.w;
            if (weakReference == null) {
                return pz.getContext();
            }
            Context context = weakReference.get();
            return context == null ? pz.getContext() : context;
        } catch (Throwable unused) {
            return pz.getContext();
        }
    }

    private void jk() {
        if (ai.w >= 5400 && w() && !this.tf) {
            com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(false, (com.bytedance.sdk.openadsdk.core.pl.xj.u) null, c());
        }
    }

    private boolean p() {
        ws wsVar = this.kd;
        if (wsVar != null) {
            return jk.xj(wsVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pl() {
        int i = this.f;
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            com.bytedance.sdk.component.tf.c.hf(new com.bytedance.sdk.component.tf.d("tt_download_check") { // from class: com.bytedance.sdk.openadsdk.core.pl.w.d.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.ra.u xj = pz.xj().xj(d.this.kd, d.this.u);
                    if (xj == null || !xj.kd()) {
                        tf.xj(pz.getContext());
                        return;
                    }
                    String y = xj.y();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject = new JSONObject(y);
                    } catch (JSONException unused) {
                    }
                    com.bytedance.sdk.openadsdk.core.ra.y kd = com.bytedance.sdk.openadsdk.core.xj.kd(jSONObject);
                    com.bytedance.sdk.openadsdk.core.ra.y ut = d.this.kd.ut();
                    if (ut == null) {
                        d.this.kd.xj(kd);
                    } else {
                        ut.tf(kd.am());
                        ut.hf(kd.kd());
                        ut.u(kd.c());
                        ut.hf(kd.pl());
                        ut.kd(kd.f());
                        ut.d(kd.g());
                        ut.w(kd.y());
                        ut.y(kd.d());
                        ut.c(kd.tf());
                        ut.f(kd.p());
                        kd = ut;
                    }
                    if (d.this.g()) {
                        return;
                    }
                    d.this.xj(kd.y(), kd.am(), kd.g());
                    d.this.xj(xj);
                }
            });
            return true;
        }
        if (g()) {
            return true;
        }
        tf.xj(pz.getContext());
        return true;
    }

    private boolean qt() {
        ws wsVar = this.kd;
        if (wsVar != null && wsVar.yt() != null) {
            String hf = this.kd.yt().hf();
            if (TextUtils.isEmpty(hf)) {
                return false;
            }
            zg.xj((String) null);
            Uri parse = Uri.parse(hf);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            if (wo.xj(getContext(), intent)) {
                if (!(getContext() instanceof Activity)) {
                    intent.addFlags(C.ENCODING_PCM_MU_LAW);
                }
                try {
                    getContext().startActivity(intent);
                    return true;
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    private synchronized void tf() {
        Object apply;
        if (this.c == null) {
            return;
        }
        if (!p()) {
            this.c.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(5).xj(Void.class).xj(0, new en().xj("hashCode", Integer.valueOf(c()))).hf());
            return;
        }
        en enVar = new en();
        enVar.xj("hashCode", Integer.valueOf(c()));
        apply = this.c.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(19).xj(Boolean.class).xj(0, enVar).hf());
        if (apply != null && ((Boolean) apply).booleanValue()) {
            this.c.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(14).xj(Boolean.class).xj(0, new en().xj("hashCode", Integer.valueOf(c()))).hf());
        }
    }

    private Map<String, Object> v() {
        long longValue = Double.valueOf(this.kd.ho()).longValue();
        return p() ? new en().xj("userAgent", null).xj("isDisableDialog", Boolean.TRUE).xj("downloadStatusChangeListener", null).xj("action_type_button", 2).xj(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, Long.valueOf(longValue)).xj("hashCode", Integer.valueOf(c())) : new en().xj("downloadUrl", this.u).xj("hashCode", Integer.valueOf(c())).xj(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, Long.valueOf(longValue)).xj("action_type_button", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yo() {
        final Map<String, Object> v = v();
        if (!w()) {
            xj(16, v);
        } else {
            com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(v, new com.bytedance.sdk.openadsdk.core.pl.xj.hf() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.d.4
                @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
                public void handleComplianceDialog(boolean z) {
                }

                @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
                public void handleMarketFailedComplianceDialog() {
                    if (v == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(0, d.this.c());
                    d.this.y().xj(d.this.f());
                    v.remove("downloadButtonClickListener");
                    if (d.this.pl()) {
                        return;
                    }
                    d.this.xj((com.bytedance.sdk.openadsdk.core.ra.u) null);
                }
            });
            xj(v);
        }
    }

    private boolean zg() {
        if (this.c == null || jk.v(this.kd) == 1) {
            return true;
        }
        if (pz.hf().oa()) {
            return xj("正在下载，可在通知栏暂停或取消", true);
        }
        if (jk.tf(this.kd)) {
            return true;
        }
        return xj("应用正在下载...", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(int i, w.xj xjVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.pl.w.w.xj f() {
        return w() ? new com.bytedance.sdk.openadsdk.core.pl.w.w.kd() : new com.bytedance.sdk.openadsdk.core.pl.w.w.u();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void hf() {
        d();
        WeakReference<Context> weakReference = this.w;
        if (weakReference != null) {
            weakReference.clear();
            this.w = null;
        }
        this.d = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public Map<String, Object> kd() {
        return new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void u(boolean z) {
        this.p = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public boolean w() {
        Function<SparseArray<Object>, Object> function = this.c;
        return function != null && com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(function, c()) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(Activity activity) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.w.f
    public com.bytedance.sdk.openadsdk.core.pl.w.w.w y() {
        if (this.d == null) {
            synchronized (this) {
                try {
                    if (this.d == null) {
                        this.d = new com.bytedance.sdk.openadsdk.core.pl.w.w.w(getContext(), this.kd);
                    }
                } finally {
                }
            }
        }
        return this.d;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void u() {
        Function<SparseArray<Object>, Object> function = this.c;
        if (function != null) {
            function.apply(A2egSU.AZOQYO(8, Void.class).xj(0, new en().xj("force", Boolean.TRUE).xj("hashCode", Integer.valueOf(c()))).hf());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void w(boolean z) {
        if (ai.w >= 5400 && z) {
            this.tf = z;
            if (w()) {
                com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(true, com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(this.kd, this.p), c());
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(ws wsVar, boolean z) {
    }

    private boolean hf(com.bytedance.sdk.openadsdk.core.ra.u uVar) {
        com.bytedance.sdk.openadsdk.core.pl.w.w.w y = y();
        if (!y.u(false) || e()) {
            return false;
        }
        if (xj(getContext(), this.kd, this.y)) {
            return true;
        }
        y.xj(uVar, this.y, this.u, new com.bytedance.sdk.openadsdk.core.pl.w.xj.hf() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.d.2
            @Override // com.bytedance.sdk.openadsdk.core.pl.w.xj.hf
            public void xj() {
                d.this.yo();
                d.this.w(true);
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(boolean z) {
        com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(this.u, this.y, this.kd, (JSONObject) null, c());
        com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(this.kd, c(), z);
        com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(this.y, c());
        tf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj() {
        tf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(JSONObject jSONObject, boolean z) {
        y().xj(f());
        if (zg()) {
            if (w() || !pl()) {
                xj((com.bytedance.sdk.openadsdk.core.ra.u) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(String str, String str2, String str3) {
        if (this.c == null) {
            return;
        }
        this.c.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(24).xj(Boolean.class).xj(0, new en().xj("appIcon", str).xj("appName", str2).xj("hashCode", Integer.valueOf(c())).xj("packageName", str3)).hf());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.sdk.openadsdk.core.ra.u uVar) {
        jk();
        if (hf(uVar)) {
            return;
        }
        yo();
    }

    private boolean xj(final String str, final boolean z) {
        if (!e()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    x.hf(d.this.getContext(), str, 0, 17, 0, 0);
                } else {
                    x.xj(d.this.getContext(), str, 0);
                }
            }
        });
        return false;
    }

    private void xj(final Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.pl.d.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.xj(17, (Map<String, Object>) map);
            }
        }, this.kd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final int i, final Map<String, Object> map) {
        try {
            if (this.c == null) {
                return;
            }
            if (p()) {
                this.c.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(13).xj(Void.class).xj(0, map).hf());
                this.tf = false;
            } else {
                map.put("itemClickListener", com.bytedance.sdk.openadsdk.zg.w.u.xj(new com.bytedance.sdk.openadsdk.core.pl.xj.kd() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.d.6
                    @Override // com.bytedance.sdk.openadsdk.core.pl.xj.kd
                    public void onItemClick() {
                        com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.hf(1, d.this.c());
                        map.remove("itemClickListener");
                        d.this.c.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(i).xj(Void.class).xj(0, map).hf());
                    }
                }));
                this.c.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(i).xj(Void.class).xj(0, map).hf());
                this.tf = false;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(int i) {
        this.f = i;
    }
}
