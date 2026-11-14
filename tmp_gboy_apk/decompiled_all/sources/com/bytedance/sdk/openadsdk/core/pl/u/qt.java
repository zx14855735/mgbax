package com.bytedance.sdk.openadsdk.core.pl.u;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.pl.u.am;
import com.bytedance.sdk.openadsdk.core.pl.u.w;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.pz;
import com.ss.android.download.api.config.v;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.hf;
import com.ss.android.downloadlib.addownload.xj.xj;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class qt {
    private static Map<Integer, w.xj> c;
    private static final com.ss.android.download.api.download.xj.xj d;
    private static TTAdInteractionListener f;
    public static com.bytedance.sdk.openadsdk.core.pl.u.u w;
    public static volatile String xj;
    private static Context y;
    private static final AtomicBoolean u = new AtomicBoolean(false);
    private static final AtomicBoolean kd = new AtomicBoolean(false);
    public static boolean hf = true;

    public static class hf implements com.ss.android.download.api.config.c {
        private void w(com.ss.android.download.api.model.w wVar) {
            if (wVar == null) {
                return;
            }
            Object pl2 = wVar.pl();
            f hf = f.xj().xj(wVar.hf()).hf(wVar.f()).xj(pl2 instanceof JSONObject ? (JSONObject) pl2 : null).hf(wVar.w());
            boolean z = "download_notification".equals(wVar.hf()) || "landing_h5_download_ad_button".equals(wVar.hf());
            if (qt.c() != null) {
                qt.c().xj(hf, z);
            }
        }

        @Override // com.ss.android.download.api.config.c
        public void hf(com.ss.android.download.api.model.w wVar) {
            xj(wVar, false);
            w(wVar);
        }

        @Override // com.ss.android.download.api.config.c
        public void xj(com.ss.android.download.api.model.w wVar) {
            xj(wVar, true);
        }

        private void xj(com.ss.android.download.api.model.w wVar, boolean z) {
            c hf;
            if (qt.c() == null || (hf = qt.c().hf()) == null || wVar == null) {
                return;
            }
            if (hf.xj() && qt.c().xj(wVar.toString())) {
                return;
            }
            if (z) {
                qt.hf(wVar);
            } else {
                qt.hf(wVar);
            }
        }
    }

    public static class u implements com.ss.android.download.api.config.d {
        @Override // com.ss.android.download.api.config.d
        public void xj(Activity activity, int i, String[] strArr, int[] iArr) {
        }

        @Override // com.ss.android.download.api.config.d
        public void xj(Activity activity, String[] strArr, final pz pzVar) {
            if (qt.c() != null) {
                qt.c().xj(activity, strArr, new com.bytedance.sdk.openadsdk.core.pl.u.y() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.qt.u.1
                    @Override // com.bytedance.sdk.openadsdk.core.pl.u.y
                    public void xj() {
                        pz pzVar2 = pzVar;
                        if (pzVar2 != null) {
                            pzVar2.xj();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.pl.u.y
                    public void xj(String str) {
                        pz pzVar2 = pzVar;
                        if (pzVar2 != null) {
                            pzVar2.xj(str);
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.d
        public boolean xj(Context context, String str) {
            if (qt.c() != null) {
                return qt.c().xj(context, str);
            }
            return false;
        }
    }

    public static class y implements IDownloadHttpService {
        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
        public com.ss.android.socialbase.downloader.network.d downloadWithConnection(int i, String str, List<com.ss.android.socialbase.downloader.model.w> list) {
            final am.xj xj = am.xj(str, list);
            if (xj != null) {
                return new com.ss.android.socialbase.downloader.network.d() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.qt.y.1
                    @Override // com.ss.android.socialbase.downloader.network.c
                    public int hf() {
                        return xj.w;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.d
                    public void u() {
                        try {
                            xj.u.disconnect();
                        } catch (Exception unused) {
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.network.c
                    public void w() {
                    }

                    @Override // com.ss.android.socialbase.downloader.network.d
                    public InputStream xj() {
                        return xj.xj;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.c
                    public String xj(String str2) {
                        Map<String, String> map = xj.hf;
                        if (map != null) {
                            return map.get(str2);
                        }
                        return null;
                    }
                };
            }
            return null;
        }
    }

    static {
        try {
            xj = com.bytedance.sdk.openadsdk.api.plugin.hf.xj(getContext(), Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
        d = new com.ss.android.download.api.download.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.qt.8
            @Override // com.ss.android.download.api.download.xj.xj
            public void xj(DownloadInfo downloadInfo, String str) {
                qt.w(str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.core.pl.u.u c() {
        if (w == null) {
            w = g.u();
        }
        return w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject d() {
        try {
            com.bytedance.sdk.openadsdk.core.pl.u.u c2 = c();
            if (c2 != null) {
                JSONObject xj2 = c2.xj();
                if (xj2.optInt("enable_app_install_receiver", 1) == 0) {
                    xj2.put("enable_app_install_receiver", 0);
                }
                return xj2;
            }
        } catch (Exception unused) {
        }
        return new JSONObject();
    }

    private static boolean f() {
        return "internal".equals(ai.c);
    }

    private static Context getContext() {
        Context context = y;
        return context == null ? com.bytedance.sdk.openadsdk.core.pz.getContext() : context;
    }

    public static Map<Integer, w.xj> u() {
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(String str) {
        com.ss.android.downloadad.api.xj.hf xj2;
        JSONObject c2;
        if (TextUtils.isEmpty(str) || (xj2 = com.ss.android.downloadlib.addownload.hf.y.xj().xj(str)) == null || (c2 = xj2.c()) == null || c() == null) {
            return;
        }
        c().xj(c2, str);
    }

    public static class xj implements com.ss.android.download.api.config.tf {
        private xj() {
        }

        @Override // com.ss.android.download.api.config.tf
        public boolean hf(DownloadModel downloadModel, DownloadInfo downloadInfo) {
            com.bytedance.sdk.openadsdk.core.pl.u.u c = qt.c();
            if (c != null) {
                return c.hf(downloadModel, downloadInfo);
            }
            return false;
        }

        @Override // com.ss.android.download.api.config.tf
        public boolean xj(DownloadModel downloadModel, DownloadInfo downloadInfo) {
            com.bytedance.sdk.openadsdk.core.pl.u.u c = qt.c();
            if (c != null) {
                return c.xj(downloadModel, downloadInfo);
            }
            return false;
        }

        @Override // com.ss.android.download.api.config.tf
        public boolean xj(DownloadModel downloadModel) {
            com.bytedance.sdk.openadsdk.core.pl.u.u c = qt.c();
            if (c != null) {
                return c.xj(downloadModel);
            }
            return false;
        }
    }

    public static com.ss.android.downloadlib.tf hf() {
        xj(getContext());
        return com.ss.android.downloadlib.tf.xj(getContext());
    }

    public static void xj(TTAdInteractionListener tTAdInteractionListener) {
        f = tTAdInteractionListener;
    }

    public static class kd implements com.ss.android.download.api.config.g {
        private final WeakReference<Context> xj;

        public kd(Context context) {
            this.xj = new WeakReference<>(context);
        }

        private com.bytedance.sdk.openadsdk.core.pl.u.xj w(final com.ss.android.download.api.model.hf hfVar) {
            return com.bytedance.sdk.openadsdk.core.pl.u.xj.xj().xj(hfVar.hf).hf(hfVar.w).u(hfVar.kd).w(hfVar.u).xj(hfVar.c).xj(new com.bytedance.sdk.openadsdk.core.pl.u.hf() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.qt.kd.1
                @Override // com.bytedance.sdk.openadsdk.core.pl.u.hf
                public void hf(DialogInterface dialogInterface) {
                    hf.InterfaceC0464hf interfaceC0464hf = hfVar.f;
                    if (interfaceC0464hf != null) {
                        try {
                            interfaceC0464hf.hf(dialogInterface);
                        } catch (Exception e) {
                            com.bytedance.sdk.component.utils.pl.xj(e);
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.u.hf
                public void w(DialogInterface dialogInterface) {
                    hf.InterfaceC0464hf interfaceC0464hf = hfVar.f;
                    if (interfaceC0464hf != null) {
                        interfaceC0464hf.w(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.pl.u.hf
                public void xj(DialogInterface dialogInterface) {
                    hf.InterfaceC0464hf interfaceC0464hf = hfVar.f;
                    if (interfaceC0464hf != null) {
                        interfaceC0464hf.xj(dialogInterface);
                    }
                }
            });
        }

        @Override // com.ss.android.download.api.config.g
        public void xj(int i, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i2) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.u("LibUIFactory", "showToastWithDuration e " + e.getMessage());
            }
        }

        @Override // com.ss.android.download.api.config.g
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public AlertDialog hf(com.ss.android.download.api.model.hf hfVar) {
            if (hfVar != null && qt.c() != null) {
                Context context = hfVar.xj;
                if (context != null && (context instanceof Activity)) {
                    return qt.c().xj((Activity) hfVar.xj, hfVar.tf == 1, w(hfVar));
                }
                qt.c().xj(this.xj, hfVar.tf == 1, w(hfVar));
            }
            return null;
        }
    }

    public static class w implements com.ss.android.download.api.config.f {
        private w() {
        }

        @Override // com.ss.android.download.api.config.f
        public void xj(String str, String str2, Map<String, Object> map, final v vVar) {
            str.getClass();
            int i = 0;
            if (!str.equals(an.c) && str.equals(an.b)) {
                i = 1;
            }
            if (qt.c() != null) {
                qt.c().xj(i, str2, map, new com.bytedance.sdk.openadsdk.core.pl.u.kd() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.qt.w.1
                    @Override // com.bytedance.sdk.openadsdk.core.pl.u.kd
                    public void xj(String str3) {
                        v vVar2 = vVar;
                        if (vVar2 != null) {
                            vVar2.xj(str3);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.pl.u.kd
                    public void xj(Throwable th) {
                        v vVar2 = vVar;
                        if (vVar2 != null) {
                            vVar2.xj(th);
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.f
        public void xj(String str, byte[] bArr, String str2, int i, final v vVar) {
            if (qt.c() != null) {
                qt.c().xj(str, bArr, str2, new com.bytedance.sdk.openadsdk.core.pl.u.kd() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.qt.w.2
                    @Override // com.bytedance.sdk.openadsdk.core.pl.u.kd
                    public void xj(String str3) {
                        v vVar2 = vVar;
                        if (vVar2 != null) {
                            vVar2.xj(str3);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.pl.u.kd
                    public void xj(Throwable th) {
                        v vVar2 = vVar;
                        if (vVar2 != null) {
                            vVar2.xj(th);
                        }
                    }
                });
            }
        }
    }

    public static TTAdInteractionListener xj() {
        return f;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean hf(final android.content.Context r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            android.content.Context r1 = r6.getApplicationContext()
            java.lang.String r2 = r1.getPackageName()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L14
            java.lang.String r2 = ""
        L14:
            boolean r3 = f()
            if (r3 == 0) goto L25
            com.ss.android.downloadlib.tf r3 = com.ss.android.downloadlib.tf.xj(r1)     // Catch: java.lang.Throwable -> L25
            java.lang.String r4 = "pangolin"
            com.ss.android.download.api.xj r3 = r3.xj(r4)     // Catch: java.lang.Throwable -> L25
            goto L2d
        L25:
            com.ss.android.downloadlib.tf r3 = com.ss.android.downloadlib.tf.xj(r1)
            com.ss.android.download.api.xj r3 = r3.xj()
        L2d:
            if (r3 != 0) goto L30
            return r0
        L30:
            com.ss.android.download.api.model.xj$xj r0 = new com.ss.android.download.api.model.xj$xj
            r0.<init>()
            java.lang.String r4 = "143"
            com.ss.android.download.api.model.xj$xj r0 = r0.hf(r4)
            java.lang.String r4 = "open_news"
            com.ss.android.download.api.model.xj$xj r0 = r0.xj(r4)
            java.lang.String r4 = com.bytedance.sdk.openadsdk.core.ai.u
            com.ss.android.download.api.model.xj$xj r0 = r0.w(r4)
            int r4 = com.bytedance.sdk.openadsdk.core.ai.w
            java.lang.String r4 = java.lang.String.valueOf(r4)
            com.ss.android.download.api.model.xj$xj r0 = r0.u(r4)
            com.ss.android.download.api.model.xj r0 = r0.xj()
            com.bytedance.sdk.openadsdk.core.pl.u.qt$u r4 = new com.bytedance.sdk.openadsdk.core.pl.u.qt$u
            r4.<init>()
            com.ss.android.download.api.xj r3 = r3.xj(r4)
            com.bytedance.sdk.openadsdk.core.pl.u.qt$hf r4 = new com.bytedance.sdk.openadsdk.core.pl.u.qt$hf
            r4.<init>()
            com.ss.android.download.api.xj r3 = r3.xj(r4)
            com.bytedance.sdk.openadsdk.core.pl.u.qt$kd r4 = new com.bytedance.sdk.openadsdk.core.pl.u.qt$kd
            r4.<init>(r1)
            com.ss.android.download.api.xj r3 = r3.xj(r4)
            com.bytedance.sdk.openadsdk.core.pl.u.qt$w r4 = new com.bytedance.sdk.openadsdk.core.pl.u.qt$w
            r5 = 0
            r4.<init>()
            com.ss.android.download.api.xj r3 = r3.xj(r4)
            com.bytedance.sdk.openadsdk.core.pl.u.qt$5 r4 = new com.bytedance.sdk.openadsdk.core.pl.u.qt$5
            r4.<init>()
            com.ss.android.download.api.xj r3 = r3.xj(r4)
            com.bytedance.sdk.openadsdk.core.pl.u.qt$4 r4 = new com.bytedance.sdk.openadsdk.core.pl.u.qt$4
            r4.<init>()
            com.ss.android.download.api.xj r6 = r3.xj(r4)
            com.bytedance.sdk.openadsdk.core.pl.u.qt$3 r3 = new com.bytedance.sdk.openadsdk.core.pl.u.qt$3
            r3.<init>()
            com.ss.android.download.api.xj r6 = r6.xj(r3)
            com.bytedance.sdk.openadsdk.core.pl.u.qt$xj r3 = new com.bytedance.sdk.openadsdk.core.pl.u.qt$xj
            r3.<init>()
            com.ss.android.download.api.xj r6 = r6.xj(r3)
            com.bytedance.sdk.openadsdk.core.pl.u.qt$2 r3 = new com.bytedance.sdk.openadsdk.core.pl.u.qt$2
            r3.<init>()
            com.ss.android.download.api.xj r6 = r6.xj(r3)
            com.ss.android.download.api.xj r6 = r6.xj(r0)
            com.bytedance.sdk.openadsdk.core.pl.u.qt$1 r0 = new com.bytedance.sdk.openadsdk.core.pl.u.qt$1
            r0.<init>()
            com.ss.android.download.api.xj r6 = r6.xj(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r2 = ".TTFileProvider"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.ss.android.download.api.xj r6 = r6.xj(r0)
            org.json.JSONObject r0 = d()
            com.ss.android.socialbase.downloader.downloader.DownloaderBuilder r0 = xj(r1, r0)
            com.ss.android.download.api.xj r6 = r6.xj(r0)
            r6.xj()
            com.ss.android.downloadlib.c.xj.xj()
            java.lang.String r6 = com.bytedance.sdk.openadsdk.core.ai.c
            java.lang.String r0 = "internal"
            boolean r6 = r6.equals(r0)
            r0 = 1
            if (r6 != 0) goto L106
            com.ss.android.downloadlib.tf r6 = com.ss.android.downloadlib.tf.xj(r1)
            com.ss.android.downloadad.api.xj r6 = r6.u()
            r6.xj(r0)
            com.ss.android.downloadlib.tf r6 = com.ss.android.downloadlib.tf.xj(r1)
            com.ss.android.download.api.download.xj.xj r1 = com.bytedance.sdk.openadsdk.core.pl.u.qt.d
            r6.xj(r1)
            com.ss.android.socialbase.appdownloader.u r6 = com.ss.android.socialbase.appdownloader.u.p()
            com.bytedance.sdk.openadsdk.core.pl.u.qt$6 r1 = new com.bytedance.sdk.openadsdk.core.pl.u.qt$6
            r1.<init>()
            r6.xj(r1)
        L106:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.pl.u.qt.hf(android.content.Context):boolean");
    }

    public static void xj(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.pz.getContext();
        }
        if (context == null) {
            return;
        }
        AtomicBoolean atomicBoolean = u;
        if (!atomicBoolean.get()) {
            synchronized (qt.class) {
                try {
                    if (!atomicBoolean.get()) {
                        y = context.getApplicationContext();
                        if (c() != null) {
                            String xj2 = c().xj(hf);
                            if (!TextUtils.isEmpty(xj2)) {
                                xj = xj2;
                            }
                        }
                        atomicBoolean.set(hf(y));
                    }
                } finally {
                }
            }
        }
        if (atomicBoolean.get()) {
            AtomicBoolean atomicBoolean2 = kd;
            if (atomicBoolean2.compareAndSet(false, true)) {
                if ((c() != null ? c().hf() : null) == null) {
                    atomicBoolean2.set(false);
                }
            }
        }
    }

    public static void w() {
        hf().c();
        if (c() != null) {
            c().hf(xj);
        }
    }

    public static void xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        xj = str;
    }

    public static boolean xj(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return hf().kd().xj(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener);
    }

    public static boolean xj(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return hf().kd().xj(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    public static boolean xj(Uri uri) {
        return com.ss.android.downloadlib.hf.tf.xj(uri);
    }

    public static void xj(int i) {
        Map<Integer, w.xj> map = c;
        if (map != null) {
            map.remove(Integer.valueOf(i));
        }
    }

    public static void xj(int i, w.xj xjVar) {
        if (xjVar != null) {
            if (c == null) {
                c = Collections.synchronizedMap(new WeakHashMap());
            }
            c.put(Integer.valueOf(i), xjVar);
        }
    }

    public static boolean xj(String str, String str2, JSONObject jSONObject, Object obj) {
        Map<Integer, w.xj> u2;
        String str3;
        String str4;
        Object obj2;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (u2 = u()) != null) {
            for (Map.Entry<Integer, w.xj> entry : u2.entrySet()) {
                int intValue = entry.getKey().intValue();
                w.xj value = entry.getValue();
                if (value != null) {
                    str3 = str;
                    str4 = str2;
                    obj2 = obj;
                    boolean xj2 = value.xj(intValue, jSONObject.toString(), str3, str4, obj2);
                    if (!z && !xj2) {
                        z = true;
                    }
                } else {
                    str3 = str;
                    str4 = str2;
                    obj2 = obj;
                }
                str = str3;
                str2 = str4;
                obj = obj2;
            }
        }
        return z;
    }

    private static DownloaderBuilder xj(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new x() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.qt.7
            @Override // com.ss.android.socialbase.downloader.depend.x
            public JSONObject xj() {
                return qt.d();
            }
        }).httpService(new y());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject hf(com.ss.android.download.api.model.w wVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PointParamKey.CATEGORY, wVar.xj());
            jSONObject.put("tag", wVar.hf());
            jSONObject.put("label", wVar.w());
            jSONObject.put("isAd", wVar.u());
            jSONObject.put("adId", wVar.kd());
            jSONObject.put("logExtra", wVar.y());
            jSONObject.put("extValue", wVar.c());
            jSONObject.put("extJson", wVar.f());
            jSONObject.put("paramsJson", wVar.d());
            jSONObject.put("eventSource", wVar.p());
            jSONObject.put("extraObject", wVar.pl());
            jSONObject.put("clickTrackUrl", wVar.tf());
            jSONObject.put("isV3", wVar.g());
            jSONObject.put("V3EventName", wVar.am());
            jSONObject.put("V3EventParams", wVar.qt());
            return jSONObject;
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return jSONObject;
        }
    }

    public static boolean xj(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> hf2 = com.ss.android.socialbase.appdownloader.u.p().hf(context);
            if (!hf2.isEmpty()) {
                for (DownloadInfo downloadInfo : hf2) {
                    if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Bundle xj(int i, int i2, String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        try {
            if (i2 == 101) {
                boolean w2 = wo.w(y, str);
                String str5 = w2 ? "open" : "install";
                if (!w2) {
                    bundle.putString(br.c, "install ".concat(String.valueOf(com.ss.android.socialbase.appdownloader.u.xj(y, i))));
                } else {
                    bundle.putString(br.c, "open " + com.ss.android.downloadlib.c.d.xj(str).xj());
                }
                com.bytedance.sdk.openadsdk.core.pl.kd.xj(str2, str3, str4, str5, str, "media_install", (String) null, (String) null);
                bundle.putString(br.c, cb.o);
                return bundle;
            }
            bundle.putString(br.c, "event_type:" + i + " not support");
            return bundle;
        } catch (Exception e) {
            bundle.putString(br.c, e.getMessage());
            return bundle;
        }
    }

    public static boolean xj(Activity activity, final com.bytedance.sdk.openadsdk.zg.w.xj.xj xjVar) {
        return com.ss.android.downloadlib.addownload.xj.xj.xj().xj(activity, false, new xj.InterfaceC0467xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.qt.9
            @Override // com.ss.android.downloadlib.addownload.xj.xj.InterfaceC0467xj
            public void xj() {
                com.bytedance.sdk.openadsdk.zg.w.xj.xj xjVar2 = com.bytedance.sdk.openadsdk.zg.w.xj.xj.this;
                if (xjVar2 != null) {
                    xjVar2.xj();
                }
            }
        });
    }
}
