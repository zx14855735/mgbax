package com.kwad.sdk;

import android.content.Context;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.framework.filedownloader.r;
import com.kwad.framework.filedownloader.services.c;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.k;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class c {
    private com.kwad.sdk.a avZ;
    private d awb;
    private Context mContext;
    private final Map<Integer, DownloadTask> AC = new ConcurrentHashMap();
    private final Map<String, Integer> avY = new ConcurrentHashMap();
    private boolean awa = false;

    public static final class a {
        private static final c awe = new c();

        static {
            gnwT();
        }

        private static /* synthetic */ void gnwT() {
            char[] charArray = "\u0086\u008a\u0088Ë\u0082\u0084\u0088\u0080Ë\u0087\u008a\u009cË\u0096\u008d\u0080\u0089\u0089Ë¯\u008b\u008c§\u0097\u008c\u0081\u0082\u0080".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 229);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0086\u0089\u008c\u008b\u008c\u0091".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 229);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static c Ce() {
        return a.awe;
    }

    public static boolean Ch() {
        try {
            Class.forName("com.kwad.sdk.api.proxy.app.BaseFragmentActivity.RequestInstallPermissionActivity");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void Ci() {
        k.a aVar;
        try {
            aVar = new k.a(true);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwad.framework.filedownloader.download.b.zG().b(new c.b().cs(Integer.MAX_VALUE).a(aVar));
            this.awa = true;
        }
    }

    private static void Cj() {
        k.a aVar;
        try {
            aVar = new k.a(false);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwad.framework.filedownloader.download.b.zG().b(new c.b().cs(Integer.MAX_VALUE).a(aVar));
        }
    }

    private void cE(int i) {
        DownloadTask downloadTask = this.AC.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.clearListener();
        }
    }

    public static void co(String str) {
        if (str == null) {
            return;
        }
        w.delete(com.kwad.framework.filedownloader.f.f.bP(str));
        w.delete(str);
    }

    private void h(DownloadTask downloadTask) {
        this.AC.remove(Integer.valueOf(downloadTask.getId()));
        this.avY.remove(downloadTask.getUrl());
    }

    public final File Cf() {
        return be.dR(this.mContext);
    }

    public final d Cg() {
        if (this.awb == null) {
            this.awb = new com.kwad.sdk.core.download.b.a();
        }
        return this.awb;
    }

    public final boolean Ck() {
        Iterator<Map.Entry<Integer, DownloadTask>> it = this.AC.entrySet().iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                DownloadTask value = it.next().getValue();
                if (value != null) {
                    int status = value.getStatus();
                    if (status != -2 && status != 1 && status != 2 && status != 3 && status != 5 && status != 6 && status != 10 && status != 11 && Math.abs(value.getStatusUpdateTime() - System.currentTimeMillis()) > 120000) {
                        z = true;
                    }
                }
            }
            return z;
        }
    }

    public final int a(DownloadTask.DownloadRequest downloadRequest, com.kwad.sdk.a aVar) {
        DownloadTask downloadTask = new DownloadTask(downloadRequest);
        if (downloadRequest.getDownloadUrl().contains("downali.game.uc.cn")) {
            Ci();
        } else if (this.awa) {
            Cj();
        }
        if (this.AC.get(Integer.valueOf(downloadTask.getId())) != null) {
            a(downloadTask.getId(), downloadRequest);
            cE(downloadTask.getId());
        } else {
            this.AC.put(Integer.valueOf(downloadTask.getId()), downloadTask);
            this.avY.put(downloadTask.getUrl(), Integer.valueOf(downloadTask.getId()));
            downloadTask.submit();
        }
        a(downloadTask.getId(), null, this.avZ);
        return downloadTask.getId();
    }

    public final DownloadTask cD(int i) {
        return this.AC.get(Integer.valueOf(i));
    }

    public final void cF(int i) {
        DownloadTask cD = cD(i);
        if (cD == null) {
            return;
        }
        if (!cD.isUserPause()) {
            pause(i);
        } else {
            cD.downloadType = 2;
            resume(i);
        }
    }

    public final void cancel(int i) {
        DownloadTask downloadTask = this.AC.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.cancel();
            h(downloadTask);
        }
    }

    public final void g(DownloadTask downloadTask) {
        final String md5 = al.md5(downloadTask.getUrl());
        as.a(downloadTask.getTargetFilePath(), new as.a() { // from class: com.kwad.sdk.c.2
            @Override // com.kwad.sdk.utils.as.a
            public final void d(Throwable th) {
                com.kwad.sdk.core.download.b.IL().g(md5, th);
            }

            @Override // com.kwad.sdk.utils.as.a
            public final void qh() {
                com.kwad.sdk.core.download.b.IL().eg(md5);
            }
        });
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final void init(Context context) {
        this.mContext = context;
        r.a(context, new c.b().cs(Integer.MAX_VALUE).a(new c.a() { // from class: com.kwad.sdk.c.1
            @Override // com.kwad.framework.filedownloader.services.c.a
            public final c.b zM() {
                try {
                    k.a aVar = new k.a(false);
                    aVar.bA("");
                    return aVar;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }));
    }

    public final void pause(int i) {
        DownloadTask downloadTask = this.AC.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.userPause();
        }
    }

    public final void resume(int i) {
        a(i, (DownloadTask.DownloadRequest) null);
    }

    private void a(int i, com.kwad.sdk.a... aVarArr) {
        DownloadTask downloadTask = this.AC.get(Integer.valueOf(i));
        if (downloadTask != null) {
            for (int i2 = 0; i2 < 2; i2++) {
                com.kwad.sdk.a aVar = aVarArr[i2];
                if (aVar != null) {
                    aVar.setId(i);
                    downloadTask.addListener(aVar);
                }
            }
        }
    }

    public final void a(com.kwad.sdk.a aVar) {
        this.avZ = aVar;
    }

    private void a(int i, DownloadTask.DownloadRequest downloadRequest) {
        DownloadTask downloadTask = this.AC.get(Integer.valueOf(i));
        if (downloadTask != null) {
            downloadTask.resume(downloadRequest);
        }
    }
}
