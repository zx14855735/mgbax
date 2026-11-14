package com.bytedance.sdk.openadsdk.core.pl.w;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.component.ttvideo.player.C;
import com.bytedance.sdk.component.utils.ai;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.a.en;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.am;
import com.bytedance.sdk.openadsdk.core.e;
import com.bytedance.sdk.openadsdk.core.ff;
import com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd;
import com.bytedance.sdk.openadsdk.core.hf.xj.hf.w;
import com.bytedance.sdk.openadsdk.core.pl.u.w;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.jk;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.zg;
import com.sigmob.sdk.base.n;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class kd extends w implements ai.xj {
    protected boolean dk;
    protected Function<SparseArray<Object>, Object> ht;

    /* renamed from: io, reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.core.pl.w.w.w f10387io;
    protected volatile Runnable jk;
    protected ws kd;
    protected HashSet<Integer> p;

    /* renamed from: pl, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.pl.hf.kd f10388pl;
    protected final String qt;
    protected volatile boolean ra;
    protected final com.bytedance.sdk.openadsdk.core.ra.kd u;
    protected WeakReference<Context> w;
    protected String y;
    protected am yo;
    protected final AtomicInteger c = new AtomicInteger(1);
    protected final AtomicBoolean f = new AtomicBoolean(false);
    protected boolean d = false;
    protected final AtomicBoolean tf = new AtomicBoolean(false);
    protected final ai g = new ai(Looper.getMainLooper(), this);
    protected boolean am = true;
    protected boolean zg = false;
    protected volatile boolean e = false;
    protected xj v = new xj();
    protected int pz = 0;
    private List<e> x = new CopyOnWriteArrayList();
    protected final com.bytedance.sdk.openadsdk.core.pl.xj.w et = new com.bytedance.sdk.openadsdk.core.pl.xj.w() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.kd.1
        @Override // com.bytedance.sdk.openadsdk.core.pl.xj.w
        public void onDownloadActive(long j, long j2, String str) {
            ws wsVar;
            kd.this.c.set(3);
            kd.this.f.set(false);
            if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
                kd kdVar = kd.this;
                kdVar.xj("onDownloadActive", j, j2, str, kdVar.u.w());
                return;
            }
            kd kdVar2 = kd.this;
            com.bytedance.sdk.openadsdk.core.pl.hf.kd kdVar3 = kdVar2.f10388pl;
            if (kdVar3 != null) {
                kdVar3.xj(j, j2, str, kdVar2.u.w());
            }
            com.bytedance.sdk.openadsdk.core.pl.hf.kd kdVar4 = kd.this.f10388pl;
            if (kdVar4 == null || kdVar4.w() || (wsVar = kd.this.kd) == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.dk.xj.hf(wsVar.ko());
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.xj.w
        public void onDownloadFailed(long j, long j2, String str) {
            kd.this.c.set(5);
            if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
                kd kdVar = kd.this;
                kdVar.xj("onDownloadFailed", j, j2, str, kdVar.u.w());
                return;
            }
            kd kdVar2 = kd.this;
            com.bytedance.sdk.openadsdk.core.pl.hf.kd kdVar3 = kdVar2.f10388pl;
            if (kdVar3 != null) {
                kdVar3.w(j, j2, str, kdVar2.u.w());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.xj.w
        public void onDownloadFinished(long j, long j2, String str) {
            kd.this.c.set(6);
            if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
                kd kdVar = kd.this;
                kdVar.xj("onDownloadFinished", j, j2, str, kdVar.u.w());
                return;
            }
            kd kdVar2 = kd.this;
            com.bytedance.sdk.openadsdk.core.pl.hf.kd kdVar3 = kdVar2.f10388pl;
            if (kdVar3 != null) {
                kdVar3.xj(j, str, kdVar2.u.w());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.xj.w
        public void onDownloadPaused(long j, long j2, String str) {
            kd.this.c.set(4);
            kd.this.f.set(false);
            if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
                kd kdVar = kd.this;
                kdVar.xj("onDownloadPaused", j, j2, str, kdVar.u.w());
                return;
            }
            kd kdVar2 = kd.this;
            com.bytedance.sdk.openadsdk.core.pl.hf.kd kdVar3 = kdVar2.f10388pl;
            if (kdVar3 != null) {
                kdVar3.hf(j, j2, str, kdVar2.u.w());
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.xj.w
        public void onDownloadStart() {
            kd.this.c.set(2);
            if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
                kd.this.xj("onIdle", 0L, 0L, (String) null, (String) null);
                return;
            }
            com.bytedance.sdk.openadsdk.core.pl.hf.kd kdVar = kd.this.f10388pl;
            if (kdVar != null) {
                kdVar.xj();
            }
        }

        @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
        public void onIdle() {
            kd.this.c.set(1);
            if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
                kd.this.xj("onIdle", 0L, 0L, (String) null, (String) null);
                return;
            }
            com.bytedance.sdk.openadsdk.core.pl.hf.kd kdVar = kd.this.f10388pl;
            if (kdVar != null) {
                kdVar.xj();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.xj.w
        public void onInstalled(long j, long j2, String str) {
            kd.this.c.set(7);
            kd.this.f.set(true);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            String str2 = str;
            if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
                kd kdVar = kd.this;
                kdVar.xj("onInstalled", j, j2, str2, kdVar.u.w());
                return;
            }
            kd kdVar2 = kd.this;
            com.bytedance.sdk.openadsdk.core.pl.hf.kd kdVar3 = kdVar2.f10388pl;
            if (kdVar3 != null) {
                kdVar3.xj(str2, kdVar2.u.w());
            }
        }
    };

    public class xj extends com.bytedance.sdk.component.tf.d {
        long hf;
        String kd;
        String u;
        long w;
        String xj;

        public xj() {
            super("DownloadCallbackRunnable");
        }

        public void hf(long j) {
            this.w = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                kd.this.d().xj(kd.this.qt, this.xj, this.hf, this.w, this.u, this.kd);
            } catch (Throwable unused) {
            }
        }

        public void w(String str) {
            this.kd = str;
        }

        public void xj(String str) {
            this.xj = str;
        }

        public void hf(String str) {
            this.u = str;
        }

        public void xj(long j) {
            this.hf = j;
        }

        public xj(String str, long j, long j2, String str2, String str3) {
            super("DownloadCallbackRunnable");
            this.xj = str;
            this.hf = j;
            this.w = j2;
            this.u = str2;
            this.kd = str3;
        }
    }

    public kd(Context context, ws wsVar, String str, boolean z) {
        this.w = new WeakReference<>(context);
        this.kd = wsVar;
        com.bytedance.sdk.openadsdk.core.ra.kd vh = wsVar.vh();
        this.u = vh;
        str = TextUtils.isEmpty(str) ? wo.hf(wsVar) : str;
        this.y = TextUtils.isEmpty(str) ? "embeded_ad" : str;
        this.qt = wsVar.hashCode() + wsVar.zf();
        this.ht = com.bytedance.sdk.openadsdk.core.f.zg().r();
        if (vh == null) {
            return;
        }
        if (pz.getContext() == null) {
            pz.xj(context);
        }
        this.f10388pl = new com.bytedance.sdk.openadsdk.core.pl.hf.kd();
        xj(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final JSONObject jSONObject, final boolean z) {
        int xj2 = com.bytedance.sdk.openadsdk.core.live.hf.xj().xj(this.kd, new com.bytedance.sdk.openadsdk.core.live.xj.w() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.kd.10
            @Override // com.bytedance.sdk.openadsdk.core.live.xj.w
            public void xj(int i) {
                kd.this.f(jSONObject, z);
            }
        }, this.y);
        if (xj2 == 1 || xj2 == 2) {
            return;
        }
        f(jSONObject, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (com.bytedance.sdk.openadsdk.core.multipro.hf.w()) {
            com.bytedance.sdk.component.tf.c.w().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.kd.4
                @Override // java.lang.Runnable
                public void run() {
                    am xj2 = am.xj.xj(com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj(pz.getContext()).xj(3));
                    try {
                        synchronized (kd.this.x) {
                            if (xj2 != null) {
                                try {
                                    if (kd.this.x.size() > 0) {
                                        Iterator it = kd.this.x.iterator();
                                        while (it.hasNext()) {
                                            xj2.hf(kd.this.qt, (e) it.next());
                                        }
                                        kd.this.x.clear();
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    } catch (RemoteException e) {
                        pl.xj(e);
                    }
                }
            });
        }
    }

    private void yo() {
        if (this.zg) {
            return;
        }
        this.zg = true;
        xj(4, new w.xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.kd.9
            @Override // com.bytedance.sdk.openadsdk.core.pl.u.w.xj
            public boolean xj(int i, String str, String str2, String str3, Object obj) {
                if (i != 4) {
                    return true;
                }
                if ("market_click_open".equals(str3) || "applink_click".equals(str3)) {
                    com.bytedance.sdk.openadsdk.core.hf.xj().put("save_jump_success_time", System.currentTimeMillis());
                    com.bytedance.sdk.openadsdk.core.hf.xj().put("save_jump_success_ad_tag", str2);
                    com.bytedance.sdk.openadsdk.core.hf.xj().put("save_dpl_success_materialmeta", str);
                }
                return true;
            }
        });
    }

    public com.bytedance.sdk.openadsdk.core.pl.w.w.xj am() {
        return w() ? new com.bytedance.sdk.openadsdk.core.pl.w.w.kd() : this.e ? new com.bytedance.sdk.openadsdk.core.pl.w.w.u() : new com.bytedance.sdk.openadsdk.core.pl.w.w.hf();
    }

    public am d() {
        if (this.yo == null) {
            this.yo = am.xj.xj(com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj(pz.getContext()).xj(3));
        }
        return this.yo;
    }

    public com.bytedance.sdk.openadsdk.core.pl.w.w.w f() {
        if (this.f10387io == null) {
            synchronized (this) {
                try {
                    if (this.f10387io == null) {
                        this.f10387io = new com.bytedance.sdk.openadsdk.core.pl.w.w.w(getContext(), this.kd);
                    }
                } finally {
                }
            }
        }
        return this.f10387io;
    }

    public abstract void f(boolean z);

    public boolean g() {
        if (this.ht == null || jk.v(this.kd) == 1) {
            return true;
        }
        if (pz.hf().oa()) {
            String str = "已下载%d%%，可在通知栏暂停或取消";
            try {
                str = String.format("已下载%d%%，可在通知栏暂停或取消", Integer.valueOf(this.et.getCurrentPercent()));
            } catch (Exception unused) {
            }
            return xj(str, true);
        }
        if (jk.tf(this.kd)) {
            return true;
        }
        return xj("应用正在下载...", false);
    }

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

    public void kd(boolean z) {
        if (z) {
            com.bytedance.sdk.openadsdk.core.am.u.hf(this.kd, this.y, "quickapp_success");
        } else {
            com.bytedance.sdk.openadsdk.core.am.u.hf(this.kd, this.y, "quickapp_fail");
        }
    }

    public abstract void p();

    public int pl() {
        return this.c.get();
    }

    public boolean qt() {
        ws wsVar = this.kd;
        return (wsVar == null || this.u == null || jk.y(wsVar) != 3 || this.u.xj() == null) ? false : true;
    }

    public void tf() {
        if (this.w == null) {
            return;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null || !com.bytedance.sdk.openadsdk.core.f.zg().xj(activity)) {
            e();
        } else {
            hf(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void u(boolean z) {
        this.dk = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public abstract boolean w();

    public boolean w(JSONObject jSONObject, boolean z) {
        if (this.c.get() == 1) {
            if (com.bytedance.sdk.component.utils.am.w(getContext()) == 0) {
                try {
                    x.xj(getContext(), com.bytedance.sdk.component.utils.jk.xj(getContext(), "tt_no_network"), 0);
                } catch (Exception unused) {
                }
            } else {
                if (wo.hf(getContext())) {
                    wo.xj(this.e, this.kd, this.y);
                }
                u(jSONObject, z);
            }
            return true;
        }
        if (wo.hf(getContext())) {
            wo.xj(this.e, this.kd, this.y);
        }
        xj(jSONObject, z);
        if (this.c.get() == 3 || this.c.get() == 4) {
            this.f.set(false);
            return false;
        }
        if (this.c.get() == 6) {
            this.f.set(true);
        }
        return false;
    }

    public boolean y() {
        if (this.kd.yt() != null) {
            String hf = this.kd.yt().hf();
            if (!TextUtils.isEmpty(hf)) {
                zg.xj((String) null);
                Uri parse = Uri.parse(hf);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                wo.hf(intent);
                if (this.e) {
                    com.bytedance.sdk.openadsdk.core.am.u.hf(this.kd, this.y, "lp_open_dpl", xj(hf));
                }
                if (wo.xj(getContext(), intent)) {
                    try {
                        wo.xj(this.e, this.kd, this.y);
                        if (!xj(this.y, "open_url_app", this.kd)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put(n.l, "DMLibManager");
                            com.bytedance.sdk.openadsdk.core.am.u.f(this.kd, this.y, "open_url_app", hashMap);
                        }
                        com.bytedance.sdk.component.utils.hf.startActivity(getContext(), intent, TextUtils.equals("main", "internal"));
                        com.bytedance.sdk.openadsdk.core.am.c.xj().xj(this.kd, this.y, this.e);
                        if (this.e) {
                            com.bytedance.sdk.openadsdk.core.am.u.xj(this.kd, this.y, "lp_openurl", (Throwable) null);
                            com.bytedance.sdk.openadsdk.core.am.u.xj(this.kd, this.y, "lp_deeplink_success_realtime", (Throwable) null);
                        } else {
                            com.bytedance.sdk.openadsdk.core.am.u.xj(this.kd, this.y, "deeplink_success_realtime", (Throwable) null);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (!TextUtils.isEmpty(this.kd.ol())) {
                            ff.xj(getContext(), this.kd.ol(), this.kd, this.y);
                        }
                        if (this.e) {
                            com.bytedance.sdk.openadsdk.core.am.u.w(this.kd, this.y, "lp_openurl_failed");
                            xj(this.kd, this.y, "lp_deeplink_fail_realtime", th);
                        } else {
                            xj(this.kd, this.y, "deeplink_fail_realtime", th);
                        }
                        return false;
                    }
                }
                if (this.e) {
                    com.bytedance.sdk.openadsdk.core.am.u.w(this.kd, this.y, "lp_openurl_failed");
                    xj(this.kd, this.y, "lp_deeplink_fail_realtime", null);
                } else {
                    xj(this.kd, this.y, "deeplink_fail_realtime", null);
                }
            }
            if (this.c.get() != 4 && this.c.get() != 3 && (!this.d || this.f.get())) {
                this.d = true;
                if (!xj(this.y, "open_fallback_url", this.kd)) {
                    com.bytedance.sdk.openadsdk.core.am.u.f(this.kd, this.y, "open_fallback_url", null);
                }
            }
        }
        return false;
    }

    public abstract void zg();

    public void u(JSONObject jSONObject, boolean z) {
        y(jSONObject, z);
        this.f.set(true);
    }

    private void hf(Activity activity) {
        com.bytedance.sdk.openadsdk.core.a.xj u = com.bytedance.sdk.openadsdk.core.f.zg().u();
        if (u != null && this.jk == null) {
            this.jk = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.kd.3
                @Override // java.lang.Runnable
                public void run() {
                    kd.this.e();
                    kd.this.jk = null;
                }
            };
            u.xj(activity, this.jk);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public Map<String, Object> kd() {
        return new HashMap();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(boolean z) {
        f(z);
        zg();
    }

    public boolean c(boolean z) {
        if (this.u == null || !qt()) {
            return false;
        }
        boolean xj2 = xj(getContext(), this.u.xj(), this.kd, this.y, this.e);
        if (xj2) {
            Message obtain = Message.obtain();
            obtain.what = 9;
            obtain.obj = Boolean.valueOf(z);
            this.g.sendMessageDelayed(obtain, 3000L);
            com.bytedance.sdk.openadsdk.core.hf.xj().put("save_jump_success_time", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.core.hf.xj().put("save_jump_success_ad_tag", this.y);
            com.bytedance.sdk.openadsdk.core.hf.xj().put("save_dpl_success_materialmeta", this.kd.ac().toString());
            return xj2;
        }
        kd(false);
        return xj2;
    }

    public void kd(JSONObject jSONObject, boolean z) {
        if (y()) {
            this.f.set(true);
            return;
        }
        if (!this.e && this.kd.vh() == null && this.kd.ol() != null && !this.kd.dz()) {
            ff.xj(getContext(), this.kd.ol(), this.kd, this.y);
        } else if (c(z)) {
            this.f.set(true);
        } else {
            if (this.kd.dz()) {
                return;
            }
            hf(jSONObject, z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar) {
        xj(xjVar, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar, boolean z) {
        if (xjVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.pl.hf.kd kdVar = this.f10388pl;
        if (kdVar != null) {
            kdVar.xj(xjVar);
        }
        if (z) {
            hf(xjVar);
        }
        zg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final JSONObject jSONObject, final boolean z) {
        com.bytedance.sdk.openadsdk.core.live.hf xj2 = com.bytedance.sdk.openadsdk.core.live.hf.xj();
        HashMap hashMap = new HashMap(1);
        hashMap.put("event_tag", this.y);
        if ((xj2.xj(getContext(), this.kd, hashMap) & 255) == 0) {
            com.bytedance.sdk.openadsdk.core.hf.xj().put("save_jump_success_time", System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.core.hf.xj().put("save_jump_success_ad_tag", this.y);
            com.bytedance.sdk.openadsdk.core.hf.xj().put("save_dpl_success_materialmeta", this.kd.ac().toString());
            return;
        }
        f().xj(am(), this.kd);
        boolean xj3 = com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd.xj();
        if (xj3) {
            com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd.xj(false);
        }
        if (!xj3) {
            if (new com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd(this.kd, getContext()).xj(this.y).xj(wo.hf(this.y)).hf(this.e).xj(new kd.xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.kd.2
                @Override // com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd.xj
                public void hf() {
                    kd.this.kd(jSONObject, z);
                }

                @Override // com.bytedance.sdk.openadsdk.core.hf.xj.hf.kd.xj
                public void xj() {
                    com.bytedance.sdk.openadsdk.core.hf.xj().put("save_jump_success_time", System.currentTimeMillis());
                    com.bytedance.sdk.openadsdk.core.hf.xj().put("save_jump_success_ad_tag", kd.this.y);
                    com.bytedance.sdk.openadsdk.core.hf.xj().put("save_dpl_success_materialmeta", kd.this.kd.ac().toString());
                }
            })) {
                return;
            }
            kd(jSONObject, z);
            return;
        }
        kd(jSONObject, z);
    }

    public void hf(final com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar) {
        if (!com.bytedance.sdk.openadsdk.core.multipro.hf.w() || xjVar == null) {
            return;
        }
        com.bytedance.sdk.component.tf.c.w().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.kd.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.xj xj2 = com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj(pz.getContext());
                com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.y yVar = new com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.y(xjVar);
                am xj3 = am.xj.xj(xj2.xj(3));
                if (xj3 != null) {
                    try {
                        xj3.xj(kd.this.qt, yVar);
                        synchronized (kd.this.x) {
                            kd.this.x.add(yVar);
                        }
                    } catch (RemoteException e) {
                        pl.xj(e);
                    }
                }
            }
        });
    }

    public void hf(JSONObject jSONObject, boolean z) {
        com.bytedance.sdk.openadsdk.core.ra.kd kdVar = this.u;
        if (kdVar == null || kdVar.hf() == null) {
            return;
        }
        w(jSONObject, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.sdk.openadsdk.core.pl.xj.xj] */
    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(int i, w.xj xjVar) {
        if (this.p == null) {
            this.p = new HashSet<>();
        }
        this.p.add(Integer.valueOf(i));
        if (this.ht != null) {
            if (!com.bytedance.sdk.openadsdk.zg.w.u.hf(com.bytedance.sdk.openadsdk.core.ai.w)) {
                xjVar = new com.bytedance.sdk.openadsdk.core.pl.xj.xj(xjVar);
            }
            this.ht.apply(A2egSU.AZOQYO(9, Void.class).xj(0, new en().xj("hid", Integer.valueOf(i)).xj(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, Integer.valueOf(i)).xj("onEventLogHandler", xjVar).xj("hashCode", Integer.valueOf(c()))).hf());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void hf() {
        com.bytedance.sdk.openadsdk.core.pl.hf.kd kdVar = this.f10388pl;
        if (kdVar != null) {
            kdVar.hf();
        }
        p();
        HashSet<Integer> hashSet = this.p;
        if (hashSet != null && hashSet.size() > 0) {
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(this.p);
            this.p.clear();
            final Iterator it = hashSet2.iterator();
            com.bytedance.sdk.openadsdk.x.c.xj(new com.bytedance.sdk.component.tf.d("remove_log_hanlder") { // from class: com.bytedance.sdk.openadsdk.core.pl.w.kd.6
                @Override // java.lang.Runnable
                public void run() {
                    while (it.hasNext()) {
                        Integer num = (Integer) it.next();
                        num.getClass();
                        Function<SparseArray<Object>, Object> function = kd.this.ht;
                        if (function != null) {
                            function.apply(A2egSU.AZOQYO(3, Void.class).xj(0, new en().xj("hid", num).xj("hashCode", Integer.valueOf(kd.this.c()))).hf());
                        }
                        it.remove();
                    }
                }
            });
        }
        WeakReference<Context> weakReference = this.w;
        if (weakReference != null) {
            weakReference.clear();
            this.w = null;
        }
        this.f10387io = null;
    }

    public String xj(String str) {
        Uri parse;
        return (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || TextUtils.isEmpty(parse.getScheme())) ? "" : parse.getScheme().toLowerCase(Locale.US);
    }

    public void xj(ws wsVar, String str, String str2, Throwable th) {
        if (w()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar, str, str2, th);
    }

    public boolean xj(String str, String str2, ws wsVar) {
        Object apply;
        if (this.ht != null) {
            apply = this.ht.apply(A2egSU.AZOQYO(2, Boolean.class).xj(0, new en().xj("tagIntercept", str).xj("label", str2).xj("hashCode", Integer.valueOf(c())).xj("meta", wsVar.ac().toString())).hf());
            if (apply != null && ((Boolean) apply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public void y(boolean z) {
        this.e = z;
    }

    private void y(JSONObject jSONObject, boolean z) {
        xj(jSONObject, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj() {
        if (pz.getContext() == null) {
            pz.xj(getContext());
        }
        zg();
    }

    public void xj(Map<String, Object> map) {
        Function<SparseArray<Object>, Object> function = this.ht;
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(16).xj(Void.class).xj(0, map).hf());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(Activity activity) {
        if (activity == null) {
            return;
        }
        this.w = new WeakReference<>(activity);
        zg();
    }

    public void xj(Message message) {
        if (message.what != 9) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.f.zg() != null && !com.bytedance.sdk.openadsdk.core.f.zg().xj()) {
            kd(false);
            if (this.am) {
                Object obj = message.obj;
                hf(wo.v(this.kd), obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false);
                return;
            }
            return;
        }
        kd(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(int i) {
        this.pz = i;
    }

    public void xj(String str, long j, long j2, String str2, String str3) {
        xj xjVar = this.v;
        if (xjVar == null) {
            this.v = new xj(str, j, j2, str2, str3);
        } else {
            xjVar.xj(str);
            this.v.xj(j);
            this.v.hf(j2);
            this.v.hf(str2);
            this.v.w(str3);
        }
        com.bytedance.sdk.component.tf.c.w().execute(this.v);
    }

    private boolean xj(final String str, final boolean z) {
        Object apply;
        apply = this.ht.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(6).xj(Boolean.class).xj(0, new en().xj("downloadUrl", this.u.hf()).xj("hashCode", Integer.valueOf(c()))).hf());
        if (apply == null || !((Boolean) apply).booleanValue()) {
            return true;
        }
        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.kd.7
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    x.hf(kd.this.getContext(), str, 0, 17, 0, 0);
                } else {
                    x.xj(kd.this.getContext(), str, 0);
                }
            }
        });
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(final ws wsVar, final boolean z) {
        if (getContext() == null) {
            return;
        }
        this.kd = wsVar;
        yo();
        if (com.bytedance.sdk.openadsdk.core.hf.xj.hf.w.xj(this.kd, false) && !com.bytedance.sdk.openadsdk.core.ugeno.tf.kd(this.kd) && !com.bytedance.sdk.openadsdk.core.ugeno.tf.u(this.kd)) {
            new com.bytedance.sdk.openadsdk.core.hf.xj.hf.w(this.kd, getContext()).xj(this.y).xj(new w.xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.w.kd.8
                @Override // com.bytedance.sdk.openadsdk.core.hf.xj.hf.w.xj
                public void xj() {
                    kd.this.c(wo.v(wsVar), z);
                }
            });
        } else {
            c(wo.v(wsVar), z);
        }
    }

    public boolean xj(Context context, String str, ws wsVar, String str2, boolean z) {
        if (context == null) {
            return false;
        }
        try {
            wo.xj(z, wsVar, str2);
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
