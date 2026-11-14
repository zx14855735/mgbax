package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.LruHashMap;
import com.kwad.sdk.utils.al;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b {
    public static final WeakHashMap<String, Integer> aHW = new WeakHashMap<>();
    private static final Map<String, Integer> aHX = Collections.synchronizedMap(new LruHashMap(10));
    private static final Map<String, String> aHY = new LruHashMap(10);
    private final WeakHashMap<c, AdTemplate> aBd;
    private final Map<c, AdTemplate> aBe;
    private final com.kwad.sdk.app.a aHZ;
    private volatile boolean mHasInit;

    public static final class a {
        static final b aIh = new b(0);

        static {
            aYgtsv();
        }

        private static /* synthetic */ void aYgtsv() {
            char[] charArray = "}qs0y\u007fs{0|qg0mv{rr0Tpw\\lwzy{".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 30);
            }
            String str = new String(charArray);
            char[] charArray2 = "}rwpwj".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 30);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    static {
        vDLiq();
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b IL() {
        return a.aIh;
    }

    private void U(final String str) {
        final e eVar = new e();
        b(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                String pS = cVar.pS();
                b.aHX.put(pS, 12);
                cVar.b(pS, str, eVar);
            }
        });
    }

    private void V(final String str) {
        final e eVar = new e();
        b(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                String pS = cVar.pS();
                b.aHX.put(pS, 0);
                cVar.f(pS, eVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cH(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        V(str);
    }

    public static int eb(String str) {
        Integer num;
        if (TextUtils.isEmpty(str) || (num = aHX.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ei(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        U(str);
        com.kwad.sdk.d Cg = com.kwad.sdk.c.Ce().Cg();
        if (Cg != null) {
            Cg.cp(str);
        }
    }

    private static /* synthetic */ void vDLiq() {
        char[] charArray = "ZVT\u0017^XT\\\u0017[V@\u0017JQ\\UU\u0017sWP{KP]^\\".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '9');
        }
        String str = new String(charArray);
        char[] charArray2 = "ZUPWPM".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '9');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final List<AdTemplate> CZ() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.aBe) {
            try {
                for (AdTemplate adTemplate : this.aBe.values()) {
                    if (adTemplate != null) {
                        arrayList.add(adTemplate);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final void Q(final String str, final String str2) {
        final e eVar = new e();
        aHX.put(str, 8);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.9
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, str2, eVar);
            }
        });
    }

    public final synchronized void bG(Context context) {
        if (!this.mHasInit || context == null) {
            return;
        }
        try {
            com.kwad.sdk.app.b.Fi().b(this.aHZ);
            this.aBe.clear();
            this.mHasInit = false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public final void c(final String str, int i, final String str2) {
        aHX.put(str, 7);
        final e eVar = new e();
        final int i2 = 0;
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.10
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, i2, str2, eVar);
            }
        });
    }

    public final void ec(final String str) {
        aHX.put(str, 1);
        final e eVar = new e();
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.7
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, eVar);
            }
        });
    }

    public final void ed(final String str) {
        final e eVar = new e();
        aHX.put(str, 4);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.11
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.b(str, eVar);
            }
        });
    }

    public final void ee(final String str) {
        final e eVar = new e();
        aHX.put(str, 1);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.12
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.c(str, eVar);
            }
        });
    }

    public final void ef(final String str) {
        final e eVar = new e();
        aHX.put(str, 5);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.13
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.d(str, eVar);
            }
        });
    }

    public final void eg(final String str) {
        final e eVar = new e();
        aHX.put(str, 9);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.14
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.e(str, eVar);
            }
        });
    }

    public final void eh(final String str) {
        final e eVar = new e();
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.g(str, eVar);
            }
        });
    }

    public final void g(final String str, final Throwable th) {
        final e eVar = new e();
        aHX.put(str, 11);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, th, eVar);
            }
        });
    }

    public final synchronized void init(Context context) {
        if (!this.mHasInit && context != null) {
            com.kwad.sdk.c.Ce().a(new com.kwad.sdk.b() { // from class: com.kwad.sdk.core.download.b.1
                private static String l(DownloadTask downloadTask) {
                    String url = downloadTask.getUrl();
                    String str = (String) b.aHY.get(url);
                    if (!TextUtils.isEmpty(str)) {
                        return str;
                    }
                    String md5 = al.md5(downloadTask.getUrl());
                    b.aHY.put(url, md5);
                    return md5;
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask, int i, int i2) {
                    b.this.a(l(downloadTask), i2 > 0 ? (int) ((i * 100.0f) / i2) : 0, i, i2);
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void b(DownloadTask downloadTask) {
                    if (downloadTask.getSmallFileSoFarBytes() == 0) {
                        if (com.kwad.framework.a.a.oy.booleanValue()) {
                            com.kwad.sdk.core.d.c.d("DownloadStatusManager", "onDownloadStart(), id=" + l(downloadTask));
                        }
                        b.this.ec(l(downloadTask));
                    }
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void c(DownloadTask downloadTask) {
                    b.this.ed(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void d(DownloadTask downloadTask) {
                    b.this.ef(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void e(DownloadTask downloadTask) {
                    String l = l(downloadTask);
                    int i = downloadTask.downloadType;
                    if (i != 0) {
                        b.aHW.put(l, Integer.valueOf(i));
                    }
                    b.this.ee(l);
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void f(DownloadTask downloadTask) {
                    b.this.eh(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask) {
                    b.this.Q(l(downloadTask), downloadTask.getTargetFilePath());
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask, Throwable th) {
                    String str;
                    if (th != null && th.getStackTrace().length > 0) {
                        str = th.getMessage() + " @ " + th.getStackTrace()[0].getFileName() + th.getStackTrace()[0].getClassName() + th.getStackTrace()[0].getLineNumber();
                    } else {
                        str = "";
                    }
                    b.this.c(l(downloadTask), 0, str);
                }
            });
            com.kwad.sdk.app.b.Fi().a(this.aHZ);
            this.mHasInit = true;
        }
    }

    private b() {
        WeakHashMap<c, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.aBd = weakHashMap;
        this.aBe = Collections.synchronizedMap(weakHashMap);
        this.mHasInit = false;
        this.aHZ = new com.kwad.sdk.app.a() { // from class: com.kwad.sdk.core.download.b.6
            @Override // com.kwad.sdk.app.a
            public final void U(String str) {
                b.this.ei(str);
            }

            @Override // com.kwad.sdk.app.a
            public final void V(String str) {
                b.this.cH(str);
            }
        };
    }

    private void b(String str, com.kwad.sdk.g.a<c> aVar) {
        Set<c> keySet = this.aBe.keySet();
        synchronized (this.aBe) {
            for (c cVar : keySet) {
                if (cVar != null && TextUtils.equals(str, cVar.pT())) {
                    try {
                        aVar.accept(cVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
            }
        }
    }

    public final void a(c cVar, AdTemplate adTemplate) {
        this.aBe.put(cVar, adTemplate);
    }

    public final void a(c cVar) {
        this.aBe.remove(cVar);
    }

    public final void a(final String str, final int i, final int i2, final int i3) {
        aHX.put(str, 2);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, i, i2, i3);
            }
        });
    }

    private void a(String str, com.kwad.sdk.g.a<c> aVar) {
        Set<c> keySet = this.aBe.keySet();
        synchronized (this.aBe) {
            for (c cVar : keySet) {
                if (cVar != null && TextUtils.equals(cVar.pS(), str)) {
                    try {
                        aVar.accept(cVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
            }
        }
    }
}
