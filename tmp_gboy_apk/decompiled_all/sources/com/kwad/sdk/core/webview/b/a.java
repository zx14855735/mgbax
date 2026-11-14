package com.kwad.sdk.core.webview.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.webview.b.b.a;
import com.kwad.sdk.core.webview.b.c.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile a aSi;
    private long acP;
    private Context mContext;
    private volatile boolean mHasInit = false;
    private final List<com.kwad.sdk.h.a.b> aSj = new CopyOnWriteArrayList();
    private final List<String> aSk = new CopyOnWriteArrayList();
    private final List<String> aSl = new CopyOnWriteArrayList();
    private final NetworkMonitor.a aSm = new NetworkMonitor.a() { // from class: com.kwad.sdk.core.webview.b.a.2
        @Override // com.kwad.sdk.core.NetworkMonitor.a
        public final void a(NetworkMonitor.NetworkState networkState) {
            if (networkState == NetworkMonitor.NetworkState.NETWORK_WIFI || networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE) {
                a.this.MO();
            }
        }
    };

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(List<com.kwad.sdk.h.a.b> list) {
        synchronized (this.aSj) {
            try {
                ce(this.mContext);
                for (com.kwad.sdk.h.a.b bVar : this.aSj) {
                    if (!list.contains(bVar)) {
                        w.ab(new File(bVar.aWo));
                        this.aSj.remove(bVar);
                    } else if (w.hh(com.kwad.sdk.core.webview.b.c.a.M(this.mContext, bVar.aWn))) {
                        list.remove(bVar);
                    }
                }
                cd(this.mContext);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static a MN() {
        if (aSi == null) {
            synchronized (a.class) {
                try {
                    if (aSi == null) {
                        aSi = new a();
                    }
                } finally {
                }
            }
        }
        return aSi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.kwad.sdk.h.a.b> MP() {
        List<com.kwad.sdk.h.a.a> list;
        List<com.kwad.sdk.h.a.b> list2;
        SdkConfigData Hl = e.Hl();
        if (Hl == null || (list = Hl.h5PreloadConfigs) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.kwad.sdk.h.a.a aVar : list) {
            if (aVar != null && (list2 = aVar.aWl) != null) {
                for (com.kwad.sdk.h.a.b bVar : list2) {
                    a(bVar, aVar);
                    if (bVar.isValid()) {
                        arrayList.add(bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private WebResourceResponse ac(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            b.a aVar = new b.a();
            this.aSk.add(str);
            WebResourceResponse a2 = a(str, str2, aVar, false);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (a2 != null) {
                c.d("HybridPackageManager", "load success time:" + currentTimeMillis2 + "--url:" + str2);
                com.kwad.sdk.core.webview.b.c.b.a(str2, str, 1, "", currentTimeMillis2);
                return a2;
            }
            c.d("HybridPackageManager", "load fail errorMsg:" + aVar.msg + "-url:" + str2);
            com.kwad.sdk.core.webview.b.c.b.a(str2, str, 2, aVar.msg, currentTimeMillis2);
            return a2;
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
            com.kwad.sdk.core.webview.b.c.b.a(str2, str, 2, "HybridWebViewClient中 Exception " + Log.getStackTraceString(th), System.currentTimeMillis() - currentTimeMillis);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0046 A[Catch: all -> 0x0022, TryCatch #0 {, blocks: (B:9:0x001e, B:10:0x0035, B:11:0x0040, B:13:0x0046, B:16:0x0050, B:21:0x0058, B:31:0x005a, B:32:0x005d, B:27:0x0032), top: B:4:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void cd(android.content.Context r5) {
        /*
            r4 = this;
            java.util.List<com.kwad.sdk.h.a.b> r0 = r4.aSj
            monitor-enter(r0)
            r1 = 0
            java.io.File r5 = com.kwad.sdk.core.webview.b.c.a.ch(r5)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            java.util.List<com.kwad.sdk.h.a.b> r2 = r4.aSj     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            org.json.JSONArray r2 = com.kwad.sdk.utils.aa.S(r2)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            byte[] r5 = r2.getBytes()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            r3.write(r5)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            com.kwad.sdk.crash.utils.b.closeQuietly(r3)     // Catch: java.lang.Throwable -> L22
            goto L35
        L22:
            r5 = move-exception
            goto L5e
        L24:
            r5 = move-exception
            r1 = r3
            goto L5a
        L27:
            r1 = r3
            goto L2b
        L29:
            r5 = move-exception
            goto L5a
        L2b:
            java.lang.String r5 = "updatePackageIndexFile"
            java.lang.String r2 = "read packageIndex file error"
            com.kwad.sdk.core.d.c.e(r5, r2)     // Catch: java.lang.Throwable -> L29
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L22
        L35:
            java.util.List<java.lang.String> r5 = r4.aSk     // Catch: java.lang.Throwable -> L22
            r5.clear()     // Catch: java.lang.Throwable -> L22
            java.util.List<com.kwad.sdk.h.a.b> r5 = r4.aSj     // Catch: java.lang.Throwable -> L22
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L22
        L40:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L22
            if (r1 == 0) goto L58
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L22
            com.kwad.sdk.h.a.b r1 = (com.kwad.sdk.h.a.b) r1     // Catch: java.lang.Throwable -> L22
            boolean r2 = r1.aWq     // Catch: java.lang.Throwable -> L22
            if (r2 == 0) goto L40
            java.util.List<java.lang.String> r2 = r4.aSk     // Catch: java.lang.Throwable -> L22
            java.lang.String r1 = r1.aWm     // Catch: java.lang.Throwable -> L22
            r2.add(r1)     // Catch: java.lang.Throwable -> L22
            goto L40
        L58:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L22
            return
        L5a:
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L22
            throw r5     // Catch: java.lang.Throwable -> L22
        L5e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L22
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.webview.b.a.cd(android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042 A[Catch: all -> 0x0038, TryCatch #2 {, blocks: (B:11:0x0033, B:14:0x0042, B:15:0x004c, B:16:0x0057, B:18:0x005d, B:20:0x0071, B:21:0x0076, B:24:0x007a, B:29:0x0082, B:39:0x0084, B:40:0x0087, B:35:0x003d), top: B:4:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d A[Catch: all -> 0x0038, TryCatch #2 {, blocks: (B:11:0x0033, B:14:0x0042, B:15:0x004c, B:16:0x0057, B:18:0x005d, B:20:0x0071, B:21:0x0076, B:24:0x007a, B:29:0x0082, B:39:0x0084, B:40:0x0087, B:35:0x003d), top: B:4:0x0004 }] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void ce(android.content.Context r5) {
        /*
            r4 = this;
            java.util.List<com.kwad.sdk.h.a.b> r0 = r4.aSj
            monitor-enter(r0)
            r1 = 0
            java.io.File r5 = com.kwad.sdk.core.webview.b.c.a.ch(r5)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            boolean r2 = com.kwad.sdk.utils.w.O(r5)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            if (r2 == 0) goto L32
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
            java.lang.String r5 = com.kwad.sdk.crash.utils.h.b(r5)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
            com.kwad.sdk.core.webview.b.a$6 r3 = new com.kwad.sdk.core.webview.b.a$6     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
            r3.<init>()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
            java.util.List r1 = a(r5, r3)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2b
            r5 = r1
            r1 = r2
            goto L33
        L28:
            r5 = move-exception
            r1 = r2
            goto L84
        L2b:
            r5 = move-exception
            goto L3a
        L2d:
            r5 = move-exception
            goto L84
        L2f:
            r5 = move-exception
            r2 = r1
            goto L3a
        L32:
            r5 = r1
        L33:
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L38
            r1 = r5
            goto L40
        L38:
            r5 = move-exception
            goto L88
        L3a:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L28
            com.kwad.sdk.crash.utils.b.closeQuietly(r2)     // Catch: java.lang.Throwable -> L38
        L40:
            if (r1 == 0) goto L4c
            java.util.List<com.kwad.sdk.h.a.b> r5 = r4.aSj     // Catch: java.lang.Throwable -> L38
            r5.clear()     // Catch: java.lang.Throwable -> L38
            java.util.List<com.kwad.sdk.h.a.b> r5 = r4.aSj     // Catch: java.lang.Throwable -> L38
            r5.addAll(r1)     // Catch: java.lang.Throwable -> L38
        L4c:
            java.util.List<java.lang.String> r5 = r4.aSk     // Catch: java.lang.Throwable -> L38
            r5.clear()     // Catch: java.lang.Throwable -> L38
            java.util.List<com.kwad.sdk.h.a.b> r5 = r4.aSj     // Catch: java.lang.Throwable -> L38
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L38
        L57:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L38
            if (r1 == 0) goto L82
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L38
            com.kwad.sdk.h.a.b r1 = (com.kwad.sdk.h.a.b) r1     // Catch: java.lang.Throwable -> L38
            android.content.Context r2 = r4.mContext     // Catch: java.lang.Throwable -> L38
            java.lang.String r3 = r1.aWn     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = com.kwad.sdk.core.webview.b.c.a.M(r2, r3)     // Catch: java.lang.Throwable -> L38
            boolean r2 = com.kwad.sdk.utils.w.hh(r2)     // Catch: java.lang.Throwable -> L38
            if (r2 != 0) goto L76
            java.util.List<com.kwad.sdk.h.a.b> r2 = r4.aSj     // Catch: java.lang.Throwable -> L38
            r2.remove(r1)     // Catch: java.lang.Throwable -> L38
        L76:
            boolean r2 = r1.aWq     // Catch: java.lang.Throwable -> L38
            if (r2 == 0) goto L57
            java.util.List<java.lang.String> r2 = r4.aSk     // Catch: java.lang.Throwable -> L38
            java.lang.String r1 = r1.aWm     // Catch: java.lang.Throwable -> L38
            r2.add(r1)     // Catch: java.lang.Throwable -> L38
            goto L57
        L82:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L38
            return
        L84:
            com.kwad.sdk.crash.utils.b.closeQuietly(r1)     // Catch: java.lang.Throwable -> L38
            throw r5     // Catch: java.lang.Throwable -> L38
        L88:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L38
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.webview.b.a.ce(android.content.Context):void");
    }

    private WebResourceResponse fl(String str) {
        try {
            b.a aVar = new b.a();
            synchronized (this.aSj) {
                try {
                    Iterator<String> it = this.aSk.iterator();
                    while (it.hasNext()) {
                        WebResourceResponse a2 = a(it.next(), str, aVar, true);
                        if (a2 != null) {
                            return a2;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    private com.kwad.sdk.h.a.b fm(String str) {
        List<com.kwad.sdk.h.a.b> MP = MP();
        if (MP != null && !MP.isEmpty()) {
            for (com.kwad.sdk.h.a.b bVar : MP) {
                if (bp.isEquals(str, bVar.aWm)) {
                    return bVar;
                }
            }
        }
        return null;
    }

    private com.kwad.sdk.h.a.b fn(String str) {
        synchronized (this.aSj) {
            try {
                if (!TextUtils.isEmpty(str) && this.aSj.size() > 0) {
                    for (com.kwad.sdk.h.a.b bVar : this.aSj) {
                        if (TextUtils.equals(str, bVar.aWm)) {
                            return bVar;
                        }
                    }
                    return null;
                }
                return null;
            } finally {
            }
        }
    }

    public final void MO() {
        if (e.Hu()) {
            h.execute(new bg() { // from class: com.kwad.sdk.core.webview.b.a.3
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    try {
                        List<com.kwad.sdk.h.a.b> MP = a.this.MP();
                        if (MP != null && !MP.isEmpty()) {
                            a.this.G(MP);
                            for (com.kwad.sdk.h.a.b bVar : MP) {
                                if (bVar != null) {
                                    if (bVar.packageType == 1) {
                                        int i = bVar.loadType;
                                        if (i != 1) {
                                            if (i == 2 && ao.isWifiConnected(a.this.mContext)) {
                                            }
                                        }
                                        a.this.a(bVar);
                                    }
                                }
                            }
                        }
                    } catch (Throwable th) {
                        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
                    }
                }
            });
        }
    }

    public final WebResourceResponse ab(String str, String str2) {
        if (!this.mHasInit) {
            return null;
        }
        String fq = com.kwad.sdk.core.webview.b.c.a.fq(str);
        if (TextUtils.isEmpty(fq)) {
            return fl(str);
        }
        com.kwad.sdk.core.webview.b.c.b.c(str2, fq, str);
        WebResourceResponse ac = ac(fq, str);
        com.kwad.sdk.core.webview.b.c.b.d(str2, fq, str);
        return ac;
    }

    public final synchronized void init(final Context context) {
        if (!this.mHasInit && context != null) {
            this.mContext = ServiceProvider.Re();
            this.mHasInit = true;
            h.execute(new bg() { // from class: com.kwad.sdk.core.webview.b.a.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    try {
                        if (e.b(com.kwad.sdk.core.config.c.aEO)) {
                            a.this.acP = System.currentTimeMillis();
                            a.this.ce(context);
                            a.this.MO();
                            NetworkMonitor.getInstance().a(a.this.mContext, a.this.aSm);
                        }
                    } catch (Throwable th) {
                        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
                    }
                }
            });
        }
    }

    public final long uB() {
        return this.acP;
    }

    private void b(final com.kwad.sdk.h.a.b bVar) {
        h.execute(new bg() { // from class: com.kwad.sdk.core.webview.b.a.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.h.a.b bVar2 = bVar;
                if (bVar2 != null) {
                    a.this.a(bVar2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.h.a.b bVar) {
        if (this.aSl.contains(bVar.aWm) || TextUtils.isEmpty(bVar.packageUrl)) {
            return;
        }
        com.kwad.sdk.core.webview.b.b.a.a(bVar, new a.InterfaceC0371a() { // from class: com.kwad.sdk.core.webview.b.a.4
            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0371a
            public final void c(com.kwad.sdk.h.a.b bVar2) {
                a.this.aSl.add(bVar2.aWm);
                c.d("HybridPackageManager", "download onStart: " + bVar2.toString());
            }

            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0371a
            public final void d(com.kwad.sdk.h.a.b bVar2) {
                c.d("HybridPackageManager", "download success: " + bVar2.toString());
                if (com.kwad.sdk.core.webview.b.b.b.a(a.this.mContext, bVar2)) {
                    c.d("HybridPackageManager", "install success: " + bVar2.toString());
                    a.this.aSj.add(bVar2);
                    a aVar = a.this;
                    aVar.cd(aVar.mContext);
                    com.kwad.sdk.core.webview.b.c.b.a(bVar2, 4);
                }
                a.this.aSl.remove(bVar2.aWm);
            }

            @Override // com.kwad.sdk.core.webview.b.b.a.InterfaceC0371a
            public final void e(com.kwad.sdk.h.a.b bVar2) {
                c.d("HybridPackageManager", "download failure: " + bVar2.toString());
                a.this.aSl.remove(bVar2.aWm);
            }
        });
    }

    private WebResourceResponse a(String str, String str2, b.a aVar, boolean z) {
        com.kwad.sdk.h.a.b fn = fn(str);
        if (fn == null) {
            com.kwad.sdk.h.a.b fm = fm(str);
            if (fm == null) {
                aVar.msg = "配置文件没有下发该zip资源";
                return null;
            }
            aVar.msg = "资源未下载:" + fm.loadType;
            b(fm);
            return null;
        }
        return b.a(this.mContext, str2, fn, aVar, z);
    }

    private void a(com.kwad.sdk.h.a.b bVar, com.kwad.sdk.h.a.a aVar) {
        bVar.aWm = aVar.sceneId;
        if (TextUtils.isEmpty(bVar.packageUrl)) {
            return;
        }
        String fr = com.kwad.sdk.core.webview.b.c.a.fr(bVar.packageUrl);
        if (TextUtils.isEmpty(fr)) {
            return;
        }
        bVar.aWn = fr;
        bVar.aWo = com.kwad.sdk.core.webview.b.c.a.K(this.mContext, fr);
    }

    @Deprecated
    private static List<com.kwad.sdk.h.a.b> a(String str, com.kwad.sdk.core.c<com.kwad.sdk.h.a.b> cVar) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    com.kwad.sdk.h.a.b FU = cVar.FU();
                    FU.parseJson(jSONObject);
                    arrayList.add(FU);
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }
}
