package com.bytedance.sdk.openadsdk.core.pl;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.a.xj;
import com.bytedance.sdk.openadsdk.core.a.y;
import com.bytedance.sdk.openadsdk.core.j.tf;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.jk;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.zg;
import com.bytedance.sdk.openadsdk.core.v;
import com.kuaishou.weapon.p0.bq;
import com.kuaishou.weapon.p0.g;
import java.io.File;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d {
    private static void hf(final ws wsVar, final String str) {
        final com.bytedance.sdk.openadsdk.core.a.xj u;
        if (xj(wsVar) || (u = com.bytedance.sdk.openadsdk.core.f.zg().u()) == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        u.xj(new xj.InterfaceC0134xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.d.1
            @Override // com.bytedance.sdk.openadsdk.core.a.xj.InterfaceC0134xj
            public void xj() {
                if (!r.xj()) {
                    com.bytedance.sdk.openadsdk.core.a.xj xjVar = com.bytedance.sdk.openadsdk.core.a.xj.this;
                    if (xjVar != null) {
                        xjVar.w();
                        return;
                    }
                    return;
                }
                if (!com.bytedance.sdk.openadsdk.qt.hf.xj(str)) {
                    d.hf(wsVar, currentTimeMillis, com.bytedance.sdk.openadsdk.core.a.xj.this, str);
                }
                com.bytedance.sdk.openadsdk.core.a.xj xjVar2 = com.bytedance.sdk.openadsdk.core.a.xj.this;
                if (xjVar2 != null) {
                    xjVar2.w();
                }
            }
        });
    }

    public static void kd() {
        if (com.bytedance.sdk.openadsdk.core.f.zg().r() != null) {
            com.bytedance.sdk.openadsdk.core.f.zg().r().apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(20).xj(Void.class).hf());
        } else {
            pl.u("TTDownload-Util", "下载SDK 初始化失败 ， bridge = null ！！！");
        }
    }

    public static String u() {
        try {
            Function<SparseArray<Object>, Object> r = com.bytedance.sdk.openadsdk.core.f.zg().r();
            if (r != null) {
                r.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(1).xj(String.class).hf());
            }
        } catch (Exception unused) {
        }
        return bq.e;
    }

    public static boolean w() {
        if (Build.VERSION.SDK_INT >= 23) {
            return com.bytedance.sdk.openadsdk.core.io.kd.xj().xj(pz.getContext(), g.j);
        }
        return true;
    }

    private static String y() {
        File xj = com.bytedance.sdk.openadsdk.api.plugin.hf.xj(pz.getContext(), Environment.DIRECTORY_DOWNLOADS);
        if (xj == null) {
            return null;
        }
        if (!xj.exists()) {
            xj.mkdirs();
        }
        if (xj.exists()) {
            return xj.getAbsolutePath();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(ws wsVar, String str) {
        if (wsVar == null) {
            return;
        }
        wo.xj(pz.getContext(), str);
    }

    public static void xj(String str, ws wsVar) {
        boolean c;
        try {
            if (pz.getContext() != null && !TextUtils.isEmpty(str) && (c = jk.c(wsVar))) {
                zg yt = wsVar.yt();
                if (yt != null && !TextUtils.isEmpty(yt.hf())) {
                    pl.u("TTDownload-Util", "含有deepLink");
                    if (jk.u(wsVar) != 0) {
                        pl.u("TTDownload-Util", "deepLink过滤 DownConfig.getDownConfigAutoOpen(materialMeta) " + jk.u(wsVar));
                        return;
                    }
                }
                if (c) {
                    if (com.bytedance.sdk.openadsdk.qt.hf.xj(str)) {
                        pl.u("TTDownload-Util", "该app已被激活 pkgName ".concat(String.valueOf(str)));
                    } else if (!jk.f(wsVar)) {
                        hf(wsVar, str);
                    } else {
                        xj(pz.getContext(), wsVar, str);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static JSONObject hf() {
        tf hf = pz.hf();
        if (hf != null && hf.qd() != null) {
            return hf.qd();
        }
        return new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(final com.bytedance.sdk.openadsdk.core.a.xj xjVar, final ws wsVar, String str, String str2, final String str3) {
        if (xjVar != null && wo.w(pz.getContext(), str3)) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            String ho = wsVar.ho();
            com.bytedance.sdk.openadsdk.core.a.y.xj(pz.getContext(), ho, str, str2, "立即打开", "退出", new y.xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.d.3
                @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
                public void onDialogBtnNo() {
                    com.bytedance.sdk.openadsdk.core.a.xj xjVar2 = xjVar;
                    if (xjVar2 != null) {
                        xjVar2.w();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
                public void onDialogBtnYes() {
                    d.w(ws.this, str3);
                    com.bytedance.sdk.openadsdk.core.a.xj xjVar2 = xjVar;
                    if (xjVar2 != null) {
                        xjVar2.w();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.a.y.xj
                public void onDialogCancel() {
                    com.bytedance.sdk.openadsdk.core.a.xj xjVar2 = xjVar;
                    if (xjVar2 != null) {
                        xjVar2.w();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(ws wsVar, long j, com.bytedance.sdk.openadsdk.core.a.xj xjVar, String str) {
        String str2;
        String str3;
        if (wsVar == null) {
            return;
        }
        if (System.currentTimeMillis() - j >= jk.d(wsVar) * 1000) {
            if (wsVar.vh() != null) {
                str2 = wsVar.vh().w();
            } else {
                str2 = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str3 = "应用安装完成，是否立即打开 ？";
            } else {
                str3 = "安装完成，是否立即打开 ？";
            }
            hf(xjVar, wsVar, str2, str3, str);
            return;
        }
        w(wsVar, str);
    }

    public static String xj() {
        String u = com.bytedance.sdk.openadsdk.qt.hf.u();
        com.bytedance.sdk.openadsdk.zg.w.w.u e = com.bytedance.sdk.openadsdk.core.f.zg().e();
        if (e == null || e.kd()) {
            return u;
        }
        try {
            return y();
        } catch (Throwable unused) {
            return u;
        }
    }

    private static void xj(Context context, final ws wsVar, final String str) {
        String str2;
        String str3;
        if (context == null || wsVar == null || xj(wsVar)) {
            return;
        }
        if (wsVar.vh() != null) {
            str2 = wsVar.vh().w();
        } else {
            str2 = "";
        }
        final String str4 = str2;
        if (TextUtils.isEmpty(str4)) {
            str3 = "应用安装完成，是否立即打开 ？";
        } else {
            str3 = "安装完成，是否立即打开 ？";
        }
        final String str5 = str3;
        final com.bytedance.sdk.openadsdk.core.a.xj u = com.bytedance.sdk.openadsdk.core.f.zg().u();
        if (u == null) {
            return;
        }
        u.xj(new xj.InterfaceC0134xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.d.2
            @Override // com.bytedance.sdk.openadsdk.core.a.xj.InterfaceC0134xj
            public void xj() {
                try {
                    if (!r.xj()) {
                        com.bytedance.sdk.openadsdk.core.a.xj xjVar = com.bytedance.sdk.openadsdk.core.a.xj.this;
                        if (xjVar != null) {
                            xjVar.w();
                            return;
                        }
                        return;
                    }
                    if (!com.bytedance.sdk.openadsdk.qt.hf.xj(str)) {
                        d.hf(com.bytedance.sdk.openadsdk.core.a.xj.this, wsVar, str4, str5, str);
                    }
                    com.bytedance.sdk.openadsdk.core.a.xj xjVar2 = com.bytedance.sdk.openadsdk.core.a.xj.this;
                    if (xjVar2 != null) {
                        xjVar2.w();
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static boolean xj(ws wsVar) {
        if (wsVar == null || !xj(hf())) {
            return false;
        }
        int vw = wsVar.vw();
        String lp = wsVar.lp();
        com.bytedance.sdk.component.u.hf.w xj = com.bytedance.sdk.openadsdk.core.hf.xj();
        if ((TextUtils.isEmpty(lp) || vw != 4) && !xj.get("is_landing_page_open_market", false)) {
            return false;
        }
        xj.put("is_landing_page_open_market", false);
        return true;
    }

    private static boolean xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return jSONObject.optInt("enable_open_app_dialog") == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0065 A[Catch: all -> 0x0069, TRY_LEAVE, TryCatch #0 {all -> 0x0069, blocks: (B:23:0x0003, B:25:0x0009, B:4:0x0021, B:6:0x0027, B:8:0x0033, B:10:0x003f, B:11:0x0043, B:13:0x0049, B:14:0x005f, B:16:0x0065), top: B:22:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0027 A[Catch: all -> 0x0069, TryCatch #0 {all -> 0x0069, blocks: (B:23:0x0003, B:25:0x0009, B:4:0x0021, B:6:0x0027, B:8:0x0033, B:10:0x003f, B:11:0x0043, B:13:0x0049, B:14:0x005f, B:16:0x0065), top: B:22:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String xj(boolean r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L20
            boolean r3 = w()     // Catch: java.lang.Throwable -> L69
            if (r3 != 0) goto L20
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L69
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.pz.getContext()     // Catch: java.lang.Throwable -> L69
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L69
            r3.<init>(r1, r2)     // Catch: java.lang.Throwable -> L69
            r3.mkdirs()     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = r3.getPath()     // Catch: java.lang.Throwable -> L69
            goto L21
        L20:
            r3 = r0
        L21:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L5f
            java.lang.String r1 = com.bytedance.sdk.openadsdk.x.w.xj()     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = "mounted"
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L43
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.pz.getContext()     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L69
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.hf.xj(r1, r2)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L43
            java.lang.String r3 = r1.getPath()     // Catch: java.lang.Throwable -> L69
        L43:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L5f
            android.content.Context r3 = com.bytedance.sdk.openadsdk.core.pz.getContext()     // Catch: java.lang.Throwable -> L69
            java.io.File r3 = com.bytedance.sdk.openadsdk.api.plugin.hf.xj(r3)     // Catch: java.lang.Throwable -> L69
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L69
            r1.<init>(r3, r2)     // Catch: java.lang.Throwable -> L69
            r1.mkdirs()     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = r1.getPath()     // Catch: java.lang.Throwable -> L69
        L5f:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L69
            if (r1 != 0) goto L69
            com.bytedance.sdk.openadsdk.core.a.pl.xj()     // Catch: java.lang.Throwable -> L69
            return r3
        L69:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.pl.d.xj(boolean):java.lang.String");
    }

    public static void xj(Runnable runnable, ws wsVar) {
        if (wsVar == null || runnable == null) {
            return;
        }
        if (jk.e(wsVar)) {
            com.bytedance.sdk.openadsdk.x.c.xj((Runnable) new com.bytedance.sdk.component.tf.d("tt_download_toast") { // from class: com.bytedance.sdk.openadsdk.core.pl.d.4
                @Override // java.lang.Runnable
                public void run() {
                    x.xj(pz.getContext(), "即将跳转到应用商店...", 1);
                }
            });
            v.y().postDelayed(runnable, 500L);
        } else {
            com.bytedance.sdk.openadsdk.x.c.xj(runnable);
        }
    }
}
