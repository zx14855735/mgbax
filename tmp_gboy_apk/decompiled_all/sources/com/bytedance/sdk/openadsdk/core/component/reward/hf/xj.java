package com.bytedance.sdk.openadsdk.core.component.reward.hf;

import J3FDQU.A2egSU;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.am;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.multipro.hf.xj;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.pl.f;
import com.bytedance.sdk.openadsdk.core.pl.u.w;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private String c;
    private ws kd;
    private TTBaseVideoActivity u;
    com.bytedance.sdk.openadsdk.core.pl.hf.w xj;
    private String y;
    View hf = null;
    final Map<String, com.bytedance.sdk.openadsdk.core.pl.hf.w> w = A2egSU.BIYEnU();
    private long f = 0;
    private long d = 0;
    private long tf = 0;
    private long p = 0;

    /* renamed from: pl, reason: collision with root package name */
    private long f10311pl = 0;
    private long g = 0;
    private boolean qt = true;
    private final w zg = new w();
    private boolean am = false;

    public interface hf {
        void hf(boolean z, long j, long j2, String str, String str2);

        void w(boolean z, long j, long j2, String str, String str2);

        void xj(boolean z);

        void xj(boolean z, long j, long j2, String str, String str2);

        void xj(boolean z, long j, String str, String str2);

        void xj(boolean z, String str, String str2);
    }

    public class w implements DownloadListener {
        private boolean hf = true;

        public w() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            xj(this.hf);
            xj.this.xj(str, true);
            xj.this.u.xj(1);
        }

        public void xj(boolean z) {
            this.hf = z;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.component.reward.hf.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0145xj {
        void xj(View view, tf tfVar);

        void xj(String str, JSONObject jSONObject);
    }

    public xj(TTBaseVideoActivity tTBaseVideoActivity) {
        this.u = tTBaseVideoActivity;
    }

    private void f() {
        ws wsVar = this.kd;
        if (wsVar == null || wsVar.vw() != 4) {
            return;
        }
        this.xj = f.xj((Context) this.u, this.kd, this.y, false);
    }

    public w c() {
        return this.zg;
    }

    public com.bytedance.sdk.openadsdk.core.pl.hf.w hf() {
        return this.xj;
    }

    public void kd() {
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.pl.hf.w> entry : this.w.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue();
            }
        }
    }

    public void u() {
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(this.u);
            this.xj.xj();
        }
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.pl.hf.w> entry : this.w.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().xj();
            }
        }
    }

    public boolean w() {
        return this.xj != null;
    }

    public void xj(ws wsVar, String str, String str2) {
        if (this.am) {
            return;
        }
        this.am = true;
        this.kd = wsVar;
        this.y = str;
        f();
        this.c = str2;
    }

    public void y() {
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.xj;
        if (wVar != null) {
            wVar.hf();
        }
        for (Map.Entry<String, com.bytedance.sdk.openadsdk.core.pl.hf.w> entry : this.w.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().hf();
            }
        }
        try {
            xj(this.c);
        } catch (Throwable th) {
            pl.w("RewardFullDownloadManager", "remove from ITTAppDownloadListener throw Exception : ", th);
        }
    }

    public void xj() {
        ws wsVar;
        if (this.xj == null && (wsVar = this.kd) != null && wsVar.vw() == 4) {
            this.xj = f.xj((Context) this.u, this.kd, this.y, false);
        }
    }

    private void xj(final String str) {
        c.hf(new d("executeMultiProcessAppDownloadCallBack") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.xj.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    xj.this.xj(3).xj(str, "recycleRes", 0L, 0L, "", "");
                } catch (Throwable th) {
                    pl.w("RewardFullDownloadManager", "executeAppDownloadCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    public am xj(int i) {
        return am.xj.xj(com.bytedance.sdk.openadsdk.core.multipro.aidl.xj.xj(pz.getContext()).xj(i));
    }

    public void xj(final hf hfVar) {
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.xj;
        if (wVar == null) {
            return;
        }
        wVar.xj(new com.bytedance.sdk.openadsdk.core.pl.hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.xj.2
            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void hf(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - xj.this.d > NativeExpressView.v) {
                    xj.this.d = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                hf hfVar2 = hfVar;
                if (hfVar2 != null) {
                    hfVar2.hf(z, j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void w(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - xj.this.p > NativeExpressView.v) {
                    xj.this.p = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                hf hfVar2 = hfVar;
                if (hfVar2 != null) {
                    hfVar2.w(z, j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj() {
                boolean z;
                if (System.currentTimeMillis() - xj.this.f > NativeExpressView.v) {
                    xj.this.f = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                hf hfVar2 = hfVar;
                if (hfVar2 != null) {
                    hfVar2.xj(z);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - xj.this.tf > NativeExpressView.v) {
                    xj.this.tf = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                hf hfVar2 = hfVar;
                if (hfVar2 != null) {
                    hfVar2.xj(z, j, j2, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj(long j, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - xj.this.f10311pl > NativeExpressView.v) {
                    xj.this.f10311pl = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                hf hfVar2 = hfVar;
                if (hfVar2 != null) {
                    hfVar2.xj(z, j, str, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj(String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - xj.this.g > NativeExpressView.v) {
                    xj.this.g = System.currentTimeMillis();
                    z = true;
                } else {
                    z = false;
                }
                hf hfVar2 = hfVar;
                if (hfVar2 != null) {
                    hfVar2.xj(z, str, str2);
                }
            }
        });
    }

    public void xj(String str, boolean z) {
        if (this.w.containsKey(str)) {
            com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.w.get(str);
            if (wVar != null) {
                if (z) {
                    wVar.xj(com.bytedance.sdk.openadsdk.core.pl.w.tf.xj(this.kd));
                }
                if (wVar instanceof com.bytedance.sdk.openadsdk.core.pl.w.kd) {
                    ((com.bytedance.sdk.openadsdk.core.pl.w.kd) wVar).f().xj(this.qt);
                } else if (wVar instanceof com.bytedance.sdk.openadsdk.core.pl.w.f) {
                    ((com.bytedance.sdk.openadsdk.core.pl.w.f) wVar).y().xj(this.qt);
                }
                wVar.xj(wo.v(this.kd), false);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.pl.hf.w xj = f.xj(this.u, str, this.kd, this.y);
        if (z) {
            xj.xj(com.bytedance.sdk.openadsdk.core.pl.w.tf.xj(this.kd));
        }
        if (xj instanceof com.bytedance.sdk.openadsdk.core.pl.w.kd) {
            ((com.bytedance.sdk.openadsdk.core.pl.w.kd) xj).f().xj(this.qt);
        } else if (xj instanceof com.bytedance.sdk.openadsdk.core.pl.w.f) {
            ((com.bytedance.sdk.openadsdk.core.pl.w.f) xj).y().xj(this.qt);
        }
        this.w.put(str, xj);
        xj.xj(wo.v(this.kd), false);
    }

    public void xj(final InterfaceC0145xj interfaceC0145xj) {
        this.xj.xj(1, new w.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.hf.xj.3
            @Override // com.bytedance.sdk.openadsdk.core.pl.u.w.xj
            public boolean xj(int i, String str, String str2, String str3, Object obj) {
                if (i == 1 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if ((str2.equals("rewarded_video") || str2.equals("fullscreen_interstitial_ad")) && str3.equals("click_start")) {
                        interfaceC0145xj.xj(xj.this.hf, new tf());
                        xj.this.hf = null;
                        return true;
                    }
                    if (str2.equals("fullscreen_interstitial_ad") || str2.equals("rewarded_video")) {
                        str3.getClass();
                        if (str3.equals("click_continue")) {
                            com.bytedance.sdk.openadsdk.core.am.u.hf(xj.this.kd, str2, "click_play_continue", (Map<String, Object>) null);
                        } else if (str3.equals("click_pause")) {
                            com.bytedance.sdk.openadsdk.core.am.u.hf(xj.this.kd, str2, "click_play_pause", (Map<String, Object>) null);
                            return true;
                        }
                    }
                    return true;
                }
                return true;
            }
        });
    }

    public void xj(View view, InterfaceC0145xj interfaceC0145xj, tf tfVar) {
        if (this.xj != null && view != null) {
            if (view.getId() == 2114387609) {
                interfaceC0145xj.xj("click_play_star_level", (JSONObject) null);
                return;
            }
            if (view.getId() == 2114387630) {
                interfaceC0145xj.xj("click_play_star_nums", (JSONObject) null);
                return;
            } else if (view.getId() == 2114387875) {
                interfaceC0145xj.xj("click_play_source", (JSONObject) null);
                return;
            } else {
                if (view.getId() == 2114387793) {
                    interfaceC0145xj.xj("click_play_logo", (JSONObject) null);
                    return;
                }
                return;
            }
        }
        interfaceC0145xj.xj(view, tfVar);
    }

    public void xj(xj.InterfaceC0173xj interfaceC0173xj) {
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(interfaceC0173xj);
        }
    }
}
