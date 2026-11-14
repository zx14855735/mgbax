package com.ss.android.socialbase.downloader.tf;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.a;
import com.ss.android.socialbase.downloader.depend.am;
import com.ss.android.socialbase.downloader.depend.c;
import com.ss.android.socialbase.downloader.depend.d;
import com.ss.android.socialbase.downloader.depend.dk;
import com.ss.android.socialbase.downloader.depend.e;
import com.ss.android.socialbase.downloader.depend.et;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.ht;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.jk;
import com.ss.android.socialbase.downloader.depend.kd;
import com.ss.android.socialbase.downloader.depend.l;
import com.ss.android.socialbase.downloader.depend.pl;
import com.ss.android.socialbase.downloader.depend.pz;
import com.ss.android.socialbase.downloader.depend.qt;
import com.ss.android.socialbase.downloader.depend.ra;
import com.ss.android.socialbase.downloader.depend.tf;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.wo;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.depend.yo;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.depend.zg;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.xj;
import java.lang.reflect.Method;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {
    private static Handler xj = new Handler(Looper.getMainLooper());

    static {
        RRxOMS();
    }

    private static /* synthetic */ void RRxOMS() {
        char[] charArray = "äèê©àæêâ©åèþ©ôïâëë©ÍéîÅõîãàâ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 135);
        }
        String str = new String(charArray);
        char[] charArray2 = "äëîéîó".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 135);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static com.ss.android.socialbase.downloader.model.xj xj(final DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        return new xj.AbstractBinderC0503xj() { // from class: com.ss.android.socialbase.downloader.tf.c.1
            @Override // com.ss.android.socialbase.downloader.model.xj
            public pz c() {
                return c.xj(DownloadTask.this.getForbiddenHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public zg d() {
                return c.xj(DownloadTask.this.getDiskSpaceHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public l f() {
                return c.xj(DownloadTask.this.getRetryDelayTimeCalculator());
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public com.ss.android.socialbase.downloader.depend.kd hf() {
                return c.xj(DownloadTask.this.getChunkStrategy());
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public com.ss.android.socialbase.downloader.depend.f kd() {
                return c.xj(DownloadTask.this.getInterceptor());
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public com.ss.android.socialbase.downloader.depend.c p() {
                return c.xj(DownloadTask.this.getFileUriProvider());
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public int pl() {
                return DownloadTask.this.getDownloadCompleteHandlers().size();
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public com.ss.android.socialbase.downloader.depend.tf tf() {
                return c.xj(DownloadTask.this.getMonitorDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public z u() {
                return c.xj(DownloadTask.this.getNotificationClickCallback());
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public et w() {
                return c.xj(DownloadTask.this.getNotificationEventListener());
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public DownloadInfo xj() {
                return DownloadTask.this.getDownloadInfo();
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public com.ss.android.socialbase.downloader.depend.y y() {
                return c.xj(DownloadTask.this.getDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public com.ss.android.socialbase.downloader.depend.d hf(int i) {
                return c.xj(DownloadTask.this.getSingleDownloadListener(y.kd(i)), i != com.ss.android.socialbase.downloader.constants.y.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public pl w(int i) {
                return c.xj(DownloadTask.this.getDownloadCompleteHandlerByIndex(i));
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public int xj(int i) {
                return DownloadTask.this.getDownloadListenerSize(y.kd(i));
            }

            @Override // com.ss.android.socialbase.downloader.model.xj
            public com.ss.android.socialbase.downloader.depend.d xj(int i, int i2) {
                return c.xj(DownloadTask.this.getDownloadListenerByIndex(y.kd(i), i2), i != com.ss.android.socialbase.downloader.constants.y.SUB.ordinal());
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.d xj(final IDownloadListener iDownloadListener, final boolean z) {
        if (iDownloadListener == null) {
            return null;
        }
        return new d.xj() { // from class: com.ss.android.socialbase.downloader.tf.c.12
            @Override // com.ss.android.socialbase.downloader.depend.d
            public void c(final DownloadInfo downloadInfo) {
                if (z) {
                    c.xj.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.tf.c.12.11
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onFirstStart(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onFirstStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.d
            public void d(final DownloadInfo downloadInfo) {
                IDownloadListener iDownloadListener2 = IDownloadListener.this;
                if (iDownloadListener2 instanceof v) {
                    if (z) {
                        c.xj.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.tf.c.12.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ((v) IDownloadListener.this).xj(downloadInfo);
                            }
                        });
                    } else {
                        ((v) iDownloadListener2).xj(downloadInfo);
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.d
            public void f(final DownloadInfo downloadInfo) {
                if (z) {
                    c.xj.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.tf.c.12.12
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onFirstSuccess(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onFirstSuccess(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.d
            public void hf(final DownloadInfo downloadInfo) {
                if (z) {
                    c.xj.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.tf.c.12.5
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onStart(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.d
            public void kd(final DownloadInfo downloadInfo) {
                if (z) {
                    c.xj.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.tf.c.12.8
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onSuccessed(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onSuccessed(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.d
            public void u(final DownloadInfo downloadInfo) {
                if (z) {
                    c.xj.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.tf.c.12.7
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onPause(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onPause(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.d
            public void w(final DownloadInfo downloadInfo) {
                if (z) {
                    c.xj.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.tf.c.12.6
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onProgress(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onProgress(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.d
            public int xj() {
                return IDownloadListener.this.hashCode();
            }

            @Override // com.ss.android.socialbase.downloader.depend.d
            public void y(final DownloadInfo downloadInfo) {
                if (z) {
                    c.xj.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.tf.c.12.10
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onCanceled(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onCanceled(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.d
            public void xj(final DownloadInfo downloadInfo) {
                if (z) {
                    c.xj.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.tf.c.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onPrepare(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onPrepare(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.d
            public void hf(final DownloadInfo downloadInfo, final BaseException baseException) {
                if (z) {
                    c.xj.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.tf.c.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onRetry(downloadInfo, baseException);
                        }
                    });
                } else {
                    IDownloadListener.this.onRetry(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.d
            public void w(final DownloadInfo downloadInfo, final BaseException baseException) {
                if (z) {
                    c.xj.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.tf.c.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onRetryDelay(downloadInfo, baseException);
                        }
                    });
                } else {
                    IDownloadListener.this.onRetryDelay(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.d
            public void xj(final DownloadInfo downloadInfo, final BaseException baseException) {
                if (z) {
                    c.xj.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.tf.c.12.9
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onFailed(downloadInfo, baseException);
                        }
                    });
                } else {
                    IDownloadListener.this.onFailed(downloadInfo, baseException);
                }
            }
        };
    }

    public static et xj(final io ioVar) {
        if (ioVar == null) {
            return null;
        }
        return new et.xj() { // from class: com.ss.android.socialbase.downloader.tf.c.23
            @Override // com.ss.android.socialbase.downloader.depend.et
            public void xj(int i, DownloadInfo downloadInfo, String str, String str2) {
                io.this.xj(i, downloadInfo, str, str2);
            }

            @Override // com.ss.android.socialbase.downloader.depend.et
            public boolean xj(boolean z) {
                return io.this.xj(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.et
            public String xj() {
                return io.this.xj();
            }
        };
    }

    public static z xj(final j jVar) {
        if (jVar == null) {
            return null;
        }
        return new z.xj() { // from class: com.ss.android.socialbase.downloader.tf.c.26
            @Override // com.ss.android.socialbase.downloader.depend.z
            public boolean hf(DownloadInfo downloadInfo) {
                return j.this.hf(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public boolean w(DownloadInfo downloadInfo) {
                return j.this.w(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public boolean xj(DownloadInfo downloadInfo) {
                return j.this.xj(downloadInfo);
            }
        };
    }

    public static l xj(final com.ss.android.socialbase.downloader.downloader.v vVar) {
        if (vVar == null) {
            return null;
        }
        return new l.xj() { // from class: com.ss.android.socialbase.downloader.tf.c.27
            @Override // com.ss.android.socialbase.downloader.depend.l
            public long xj(int i, int i2) {
                return com.ss.android.socialbase.downloader.downloader.v.this.xj(i, i2);
            }
        };
    }

    public static pz xj(final ra raVar) {
        if (raVar == null) {
            return null;
        }
        return new pz.xj() { // from class: com.ss.android.socialbase.downloader.tf.c.28
            @Override // com.ss.android.socialbase.downloader.depend.pz
            public boolean xj(jk jkVar) {
                return ra.this.xj(c.xj(jkVar));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.c xj(final IDownloadFileUriProvider iDownloadFileUriProvider) {
        if (iDownloadFileUriProvider == null) {
            return null;
        }
        return new c.xj() { // from class: com.ss.android.socialbase.downloader.tf.c.29
            @Override // com.ss.android.socialbase.downloader.depend.c
            public Uri xj(String str, String str2) {
                return IDownloadFileUriProvider.this.getUriForFile(str, str2);
            }
        };
    }

    public static ht xj(final jk jkVar) {
        if (jkVar == null) {
            return null;
        }
        return new ht() { // from class: com.ss.android.socialbase.downloader.tf.c.30
            @Override // com.ss.android.socialbase.downloader.depend.ht
            public void xj(List<String> list) {
                try {
                    jk.this.xj(list);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ht
            public boolean xj() {
                try {
                    return jk.this.xj();
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return false;
                }
            }
        };
    }

    public static zg xj(final yo yoVar) {
        if (yoVar == null) {
            return null;
        }
        return new zg.xj() { // from class: com.ss.android.socialbase.downloader.tf.c.31
            @Override // com.ss.android.socialbase.downloader.depend.zg
            public boolean xj(long j, long j2, qt qtVar) {
                return yo.this.xj(j, j2, c.xj(qtVar));
            }
        };
    }

    public static e xj(final qt qtVar) {
        if (qtVar == null) {
            return null;
        }
        return new e() { // from class: com.ss.android.socialbase.downloader.tf.c.2
            @Override // com.ss.android.socialbase.downloader.depend.e
            public void xj() {
                try {
                    qt.this.xj();
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.y xj(final am amVar) {
        if (amVar == null) {
            return null;
        }
        return new y.xj() { // from class: com.ss.android.socialbase.downloader.tf.c.3
            @Override // com.ss.android.socialbase.downloader.depend.y
            public void xj(DownloadInfo downloadInfo, BaseException baseException, int i) {
                am.this.xj(downloadInfo, baseException, i);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.tf xj(final dk dkVar) {
        if (dkVar == null) {
            return null;
        }
        return new tf.xj() { // from class: com.ss.android.socialbase.downloader.tf.c.4
            @Override // com.ss.android.socialbase.downloader.depend.tf
            public int[] hf() {
                dk dkVar2 = dk.this;
                if (dkVar2 instanceof com.ss.android.socialbase.downloader.depend.w) {
                    return ((com.ss.android.socialbase.downloader.depend.w) dkVar2).xj();
                }
                return null;
            }

            @Override // com.ss.android.socialbase.downloader.depend.tf
            public void xj(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    dk.this.xj(new JSONObject(str));
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.tf
            public String xj() {
                return dk.this.hf();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.kd xj(final com.ss.android.socialbase.downloader.downloader.f fVar) {
        if (fVar == null) {
            return null;
        }
        return new kd.xj() { // from class: com.ss.android.socialbase.downloader.tf.c.5
            @Override // com.ss.android.socialbase.downloader.depend.kd
            public int xj(long j) {
                return com.ss.android.socialbase.downloader.downloader.f.this.xj(j);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.f xj(final IDownloadInterceptor iDownloadInterceptor) {
        if (iDownloadInterceptor == null) {
            return null;
        }
        return new f.xj() { // from class: com.ss.android.socialbase.downloader.tf.c.6
            @Override // com.ss.android.socialbase.downloader.depend.f
            public boolean xj() {
                return IDownloadInterceptor.this.intercepte();
            }
        };
    }

    public static DownloadTask xj(com.ss.android.socialbase.downloader.model.xj xjVar) {
        if (xjVar == null) {
            return null;
        }
        try {
            DownloadTask downloadTask = new DownloadTask(xjVar.xj());
            downloadTask.chunkStategy(xj(xjVar.hf())).notificationEventListener(xj(xjVar.w())).interceptor(xj(xjVar.kd())).depend(xj(xjVar.y())).monitorDepend(xj(xjVar.tf())).forbiddenHandler(xj(xjVar.c())).diskSpaceHandler(xj(xjVar.d())).fileUriProvider(xj(xjVar.p())).notificationClickCallback(xj(xjVar.u())).retryDelayTimeCalculator(xj(xjVar.f()));
            com.ss.android.socialbase.downloader.constants.y yVar = com.ss.android.socialbase.downloader.constants.y.MAIN;
            com.ss.android.socialbase.downloader.depend.d hf = xjVar.hf(yVar.ordinal());
            if (hf != null) {
                downloadTask.mainThreadListenerWithHashCode(hf.hashCode(), xj(hf));
            }
            com.ss.android.socialbase.downloader.constants.y yVar2 = com.ss.android.socialbase.downloader.constants.y.SUB;
            com.ss.android.socialbase.downloader.depend.d hf2 = xjVar.hf(yVar2.ordinal());
            if (hf2 != null) {
                downloadTask.subThreadListenerWithHashCode(hf2.hashCode(), xj(hf2));
            }
            com.ss.android.socialbase.downloader.constants.y yVar3 = com.ss.android.socialbase.downloader.constants.y.NOTIFICATION;
            com.ss.android.socialbase.downloader.depend.d hf3 = xjVar.hf(yVar3.ordinal());
            if (hf3 != null) {
                downloadTask.notificationListenerWithHashCode(hf3.hashCode(), xj(hf3));
            }
            xj(downloadTask, xjVar, yVar);
            xj(downloadTask, xjVar, yVar2);
            xj(downloadTask, xjVar, yVar3);
            xj(downloadTask, xjVar);
            return downloadTask;
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    private static void xj(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.xj xjVar, com.ss.android.socialbase.downloader.constants.y yVar) {
        SparseArray<IDownloadListener> sparseArray = new SparseArray<>();
        for (int i = 0; i < xjVar.xj(yVar.ordinal()); i++) {
            com.ss.android.socialbase.downloader.depend.d xj2 = xjVar.xj(yVar.ordinal(), i);
            if (xj2 != null) {
                sparseArray.put(xj2.xj(), xj(xj2));
            }
        }
        downloadTask.setDownloadListeners(sparseArray, yVar);
    }

    private static void xj(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.xj xjVar) {
        for (int i = 0; i < xjVar.pl(); i++) {
            pl w = xjVar.w(i);
            if (w != null) {
                downloadTask.addDownloadCompleteHandler(xj(w));
            }
        }
    }

    public static io xj(final et etVar) {
        if (etVar == null) {
            return null;
        }
        return new io() { // from class: com.ss.android.socialbase.downloader.tf.c.7
            @Override // com.ss.android.socialbase.downloader.depend.io
            public void xj(int i, DownloadInfo downloadInfo, String str, String str2) {
                try {
                    et.this.xj(i, downloadInfo, str, str2);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.io
            public boolean xj(boolean z) {
                try {
                    return et.this.xj(z);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.io
            public String xj() {
                try {
                    return et.this.xj();
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return null;
                }
            }
        };
    }

    public static g xj(final pl plVar) {
        if (plVar == null) {
            return null;
        }
        return new g() { // from class: com.ss.android.socialbase.downloader.tf.c.8
            @Override // com.ss.android.socialbase.downloader.depend.g
            public boolean hf(DownloadInfo downloadInfo) {
                try {
                    return pl.this.hf(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public void xj(DownloadInfo downloadInfo) {
                try {
                    pl.this.xj(downloadInfo);
                } catch (RemoteException e) {
                    throw new BaseException(1008, e);
                }
            }
        };
    }

    public static pl xj(final g gVar) {
        if (gVar == null) {
            return null;
        }
        return new pl.xj() { // from class: com.ss.android.socialbase.downloader.tf.c.9
            @Override // com.ss.android.socialbase.downloader.depend.pl
            public boolean hf(DownloadInfo downloadInfo) {
                return g.this.hf(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.pl
            public void xj(DownloadInfo downloadInfo) {
                try {
                    g.this.xj(downloadInfo);
                } catch (BaseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        };
    }

    public static j xj(final z zVar) {
        if (zVar == null) {
            return null;
        }
        return new j() { // from class: com.ss.android.socialbase.downloader.tf.c.10
            @Override // com.ss.android.socialbase.downloader.depend.j
            public boolean hf(DownloadInfo downloadInfo) {
                try {
                    return z.this.hf(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public boolean w(DownloadInfo downloadInfo) {
                try {
                    return z.this.w(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public boolean xj(DownloadInfo downloadInfo) {
                try {
                    return z.this.xj(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return false;
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.f xj(final com.ss.android.socialbase.downloader.depend.kd kdVar) {
        if (kdVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.f() { // from class: com.ss.android.socialbase.downloader.tf.c.11
            @Override // com.ss.android.socialbase.downloader.downloader.f
            public int xj(long j) {
                try {
                    return com.ss.android.socialbase.downloader.depend.kd.this.xj(j);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return 0;
                }
            }
        };
    }

    public static am xj(final com.ss.android.socialbase.downloader.depend.y yVar) {
        if (yVar == null) {
            return null;
        }
        return new am() { // from class: com.ss.android.socialbase.downloader.tf.c.13
            @Override // com.ss.android.socialbase.downloader.depend.am
            public void xj(DownloadInfo downloadInfo, BaseException baseException, int i) {
                if (downloadInfo == null) {
                    return;
                }
                try {
                    com.ss.android.socialbase.downloader.depend.y.this.xj(downloadInfo, baseException, i);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        };
    }

    public static dk xj(final com.ss.android.socialbase.downloader.depend.tf tfVar) {
        if (tfVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.depend.w() { // from class: com.ss.android.socialbase.downloader.tf.c.14
            @Override // com.ss.android.socialbase.downloader.depend.dk
            public String hf() {
                try {
                    return com.ss.android.socialbase.downloader.depend.tf.this.xj();
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return "";
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.dk
            public void xj(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    com.ss.android.socialbase.downloader.depend.tf.this.xj(jSONObject.toString());
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.w
            public int[] xj() {
                try {
                    return com.ss.android.socialbase.downloader.depend.tf.this.hf();
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return null;
                }
            }
        };
    }

    public static ra xj(final pz pzVar) {
        if (pzVar == null) {
            return null;
        }
        return new ra() { // from class: com.ss.android.socialbase.downloader.tf.c.15
            @Override // com.ss.android.socialbase.downloader.depend.ra
            public boolean xj(ht htVar) {
                try {
                    return pz.this.xj(c.xj(htVar));
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return false;
                }
            }
        };
    }

    public static jk xj(final ht htVar) {
        if (htVar == null) {
            return null;
        }
        return new jk.xj() { // from class: com.ss.android.socialbase.downloader.tf.c.16
            @Override // com.ss.android.socialbase.downloader.depend.jk
            public void xj(List<String> list) {
                ht.this.xj(list);
            }

            @Override // com.ss.android.socialbase.downloader.depend.jk
            public boolean xj() {
                return ht.this.xj();
            }
        };
    }

    public static a xj(final wo woVar) {
        if (woVar == null) {
            return null;
        }
        return new a.xj() { // from class: com.ss.android.socialbase.downloader.tf.c.17
            @Override // com.ss.android.socialbase.downloader.depend.a
            public void xj(int i, int i2) {
                wo.this.xj(i, i2);
            }
        };
    }

    public static wo xj(final a aVar) {
        if (aVar == null) {
            return null;
        }
        return new wo() { // from class: com.ss.android.socialbase.downloader.tf.c.18
            @Override // com.ss.android.socialbase.downloader.depend.wo
            public void xj(int i, int i2) {
                try {
                    a.this.xj(i, i2);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        };
    }

    public static yo xj(final zg zgVar) {
        if (zgVar == null) {
            return null;
        }
        return new yo() { // from class: com.ss.android.socialbase.downloader.tf.c.19
            @Override // com.ss.android.socialbase.downloader.depend.yo
            public boolean xj(long j, long j2, e eVar) {
                try {
                    return zg.this.xj(j, j2, c.xj(eVar));
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return false;
                }
            }
        };
    }

    public static qt xj(final e eVar) {
        if (eVar == null) {
            return null;
        }
        return new qt.xj() { // from class: com.ss.android.socialbase.downloader.tf.c.20
            @Override // com.ss.android.socialbase.downloader.depend.qt
            public void xj() {
                e.this.xj();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.v xj(final l lVar) {
        if (lVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.v() { // from class: com.ss.android.socialbase.downloader.tf.c.21
            @Override // com.ss.android.socialbase.downloader.downloader.v
            public long xj(int i, int i2) {
                try {
                    return l.this.xj(i, i2);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return 0L;
                }
            }
        };
    }

    public static IDownloadInterceptor xj(final com.ss.android.socialbase.downloader.depend.f fVar) {
        if (fVar == null) {
            return null;
        }
        return new IDownloadInterceptor() { // from class: com.ss.android.socialbase.downloader.tf.c.22
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
            public boolean intercepte() {
                try {
                    return com.ss.android.socialbase.downloader.depend.f.this.xj();
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return false;
                }
            }
        };
    }

    public static IDownloadFileUriProvider xj(final com.ss.android.socialbase.downloader.depend.c cVar) {
        if (cVar == null) {
            return null;
        }
        return new IDownloadFileUriProvider() { // from class: com.ss.android.socialbase.downloader.tf.c.24
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str, String str2) {
                try {
                    return com.ss.android.socialbase.downloader.depend.c.this.xj(str, str2);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                    return null;
                }
            }
        };
    }

    public static IDownloadListener xj(final com.ss.android.socialbase.downloader.depend.d dVar) {
        if (dVar == null) {
            return null;
        }
        return new v() { // from class: com.ss.android.socialbase.downloader.tf.c.25
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onCanceled(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.d.this.y(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    com.ss.android.socialbase.downloader.depend.d.this.xj(downloadInfo, baseException);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstStart(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.d.this.c(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstSuccess(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.d.this.f(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPause(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.d.this.u(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPrepare(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.d.this.xj(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onProgress(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.d.this.w(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    com.ss.android.socialbase.downloader.depend.d.this.hf(downloadInfo, baseException);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    com.ss.android.socialbase.downloader.depend.d.this.w(downloadInfo, baseException);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onStart(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.d.this.hf(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onSuccessed(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.d.this.kd(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.v
            public void xj(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.d.this.d(downloadInfo);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            }
        };
    }
}
