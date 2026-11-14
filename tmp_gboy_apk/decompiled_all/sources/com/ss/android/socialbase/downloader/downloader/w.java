package com.ss.android.socialbase.downloader.downloader;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.fl.saas.videocache.ProxyCacheUtils;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.wo;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.pz;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private static volatile pz f13847a;
    private static volatile com.ss.android.socialbase.downloader.u.hf ai;
    private static volatile pl am;
    private static boolean aq;
    private static int b;
    private static volatile qt c;
    private static volatile xj d;
    private static final List<Object> dc;
    private static volatile c dk;
    private static com.ss.android.socialbase.downloader.u.w dq;
    private static volatile ExecutorService e;
    private static volatile DownloadReceiver et;
    private static final int eu;
    private static volatile qt f;
    private static volatile com.ss.android.socialbase.downloader.network.y ff;
    private static volatile com.ss.android.socialbase.downloader.network.f g;
    private static volatile tf hf;
    private static boolean hl;
    private static volatile ExecutorService ht;

    /* renamed from: io, reason: collision with root package name */
    private static volatile v f13848io;
    private static volatile ExecutorService jk;
    private static volatile j kd;
    private static volatile com.ss.android.socialbase.downloader.network.y l;
    private static final int n;
    private static volatile com.ss.android.socialbase.downloader.network.f p;

    /* renamed from: pl, reason: collision with root package name */
    private static volatile IDownloadHttpService f13849pl;
    private static volatile ExecutorService pz;
    private static volatile x q;
    private static volatile boolean qd;
    private static volatile ExecutorService qt;
    private static volatile ScheduledExecutorService ra;
    private static yo s;
    private static volatile IDownloadHttpService tf;
    private static final int tj;
    private static boolean tu;
    private static volatile f u;
    private static volatile ExecutorService v;
    private static final List<com.ss.android.socialbase.downloader.depend.p> vm;
    private static volatile p w;
    private static int wn;
    private static final int ws;
    private static volatile e x;
    private static volatile Context xj;
    private static volatile com.ss.android.socialbase.downloader.impls.xj y;
    private static volatile ExecutorService yo;
    private static int yy;
    private static volatile ExecutorService zg;
    private static volatile List<wo> z = new ArrayList();
    private static volatile boolean j = false;
    private static volatile OkHttpClient en = null;
    private static final List<com.ss.android.socialbase.downloader.depend.g> wo = new ArrayList();
    private static boolean r = false;

    public interface xj {

        /* renamed from: com.ss.android.socialbase.downloader.downloader.w$xj$xj, reason: collision with other inner class name */
        public interface InterfaceC0498xj {
            void xj();
        }

        g hf();

        jk xj(InterfaceC0498xj interfaceC0498xj);

        qt xj();
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        ws = availableProcessors;
        eu = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        tj = availableProcessors;
        n = availableProcessors;
        yy = ProxyCacheUtils.DEFAULT_BUFFER_SIZE;
        vm = new ArrayList();
        dc = new ArrayList();
        aq = true;
        tu = false;
        qd = false;
        XYQCdDZ();
    }

    private w() {
    }

    private static /* synthetic */ void XYQCdDZ() {
        char[] charArray = "w{y:suyq:v{m:g|qxx:^z}Vf}psq".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 20);
        }
        String str = new String(charArray);
        char[] charArray2 = "wx}z}`".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 20);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static synchronized int a() {
        int i;
        synchronized (w.class) {
            i = yy;
        }
        return i;
    }

    public static List<com.ss.android.socialbase.downloader.depend.g> ai() {
        return wo;
    }

    public static ExecutorService am() {
        return yo != null ? yo : zg();
    }

    private static void aq() {
        if (et == null) {
            et = new DownloadReceiver();
        }
        if (r) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            xj.registerReceiver(et, intentFilter);
            r = true;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public static c b() {
        if (dk == null) {
            synchronized (w.class) {
                try {
                    if (dk == null) {
                        dk = new com.ss.android.socialbase.downloader.impls.hf();
                    }
                } finally {
                }
            }
        }
        return dk;
    }

    public static com.ss.android.socialbase.downloader.u.hf c() {
        return ai;
    }

    public static com.ss.android.socialbase.downloader.network.f d() {
        if (g == null) {
            synchronized (w.class) {
                try {
                    if (g == null) {
                        g = new com.ss.android.socialbase.downloader.impls.y();
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public static boolean dc() {
        StringBuilder sb = new StringBuilder("supportMultiProc::=");
        sb.append(d != null);
        com.ss.android.socialbase.downloader.w.xj.xj("wjd", sb.toString());
        return d != null;
    }

    public static synchronized pl dk() {
        pl plVar;
        synchronized (w.class) {
            plVar = am;
        }
        return plVar;
    }

    public static ExecutorService e() {
        if (pz == null) {
            synchronized (w.class) {
                try {
                    if (pz == null) {
                        int i = eu;
                        com.bytedance.sdk.component.tf.u.u uVar = new com.bytedance.sdk.component.tf.u.u(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.d.xj("DownloadThreadPool-chunk-fixed", true));
                        try {
                            uVar.allowCoreThreadTimeOut(true);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.pl.xj(th);
                        }
                        pz = uVar;
                    }
                } finally {
                }
            }
        }
        return pz;
    }

    public static JSONObject en() {
        return (q == null || q.xj() == null) ? com.ss.android.socialbase.downloader.constants.kd.d : q.xj();
    }

    public static tf et() {
        if (hf == null) {
            synchronized (w.class) {
                try {
                    if (hf == null) {
                        hf = new com.ss.android.socialbase.downloader.impls.u();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public static pz eu() {
        if (f13847a == null) {
            synchronized (w.class) {
                try {
                    if (f13847a == null) {
                        f13847a = new pz.xj();
                    }
                } finally {
                }
            }
        }
        return f13847a;
    }

    public static IDownloadHttpService f() {
        if (f13849pl == null) {
            synchronized (w.class) {
                try {
                    if (f13849pl == null) {
                        f13849pl = new com.ss.android.socialbase.downloader.impls.c();
                    }
                } finally {
                }
            }
        }
        return f13849pl;
    }

    public static boolean ff() {
        return aq;
    }

    public static ExecutorService g() {
        return zg != null ? zg : pl();
    }

    public static synchronized void hf(DownloaderBuilder downloaderBuilder) {
        synchronized (w.class) {
            w(downloaderBuilder);
        }
    }

    public static yo hl() {
        return s;
    }

    public static com.ss.android.socialbase.downloader.network.y ht() {
        return l;
    }

    public static qt io() {
        if (c == null) {
            synchronized (w.class) {
                try {
                    if (c == null) {
                        c = new com.ss.android.socialbase.downloader.impls.f();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public static int j() {
        return wn;
    }

    public static ScheduledExecutorService jk() {
        if (ra == null) {
            synchronized (w.class) {
                try {
                    if (ra == null) {
                        ra = new com.bytedance.sdk.component.tf.u.kd(1, new com.ss.android.socialbase.downloader.d.xj("DownloadThreadPool-Schedule", true));
                    }
                } finally {
                }
            }
        }
        return ra;
    }

    public static List<wo> kd() {
        List<wo> list;
        synchronized (z) {
            list = z;
        }
        return list;
    }

    public static void l() {
        if (TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.kd.w)) {
            com.ss.android.socialbase.downloader.constants.kd.w = "oppo";
            com.ss.android.socialbase.downloader.constants.kd.hf = "oppo".toUpperCase();
        }
    }

    public static synchronized boolean n() {
        boolean z2;
        synchronized (w.class) {
            z2 = hl;
        }
        return z2;
    }

    public static synchronized e p() {
        e eVar;
        synchronized (w.class) {
            eVar = x;
        }
        return eVar;
    }

    public static ExecutorService pl() {
        if (qt == null) {
            synchronized (w.class) {
                try {
                    if (qt == null) {
                        int i = ws;
                        com.bytedance.sdk.component.tf.u.u uVar = new com.bytedance.sdk.component.tf.u.u(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.d.xj("DownloadThreadPool-cpu-fixed", true));
                        try {
                            uVar.allowCoreThreadTimeOut(true);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.pl.xj(th);
                        }
                        qt = uVar;
                    }
                } finally {
                }
            }
        }
        return qt;
    }

    public static OkHttpClient.Builder pz() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(30000L, timeUnit).readTimeout(30000L, timeUnit).writeTimeout(30000L, timeUnit).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (ht != null) {
            builder.dispatcher(new Dispatcher(ht));
        }
        return builder;
    }

    public static p q() {
        if (w == null) {
            synchronized (w.class) {
                try {
                    if (w == null) {
                        w = new com.ss.android.socialbase.downloader.impls.d();
                    }
                } finally {
                }
            }
        }
        return w;
    }

    public static ExecutorService qt() {
        return v != null ? v : zg();
    }

    public static j r() {
        return kd;
    }

    public static com.ss.android.socialbase.downloader.network.y ra() {
        if (ff == null) {
            synchronized (w.class) {
                try {
                    if (ff == null) {
                        ff = new com.ss.android.socialbase.downloader.network.y() { // from class: com.ss.android.socialbase.downloader.downloader.w.2
                            @Override // com.ss.android.socialbase.downloader.network.y
                            public List<InetAddress> xj(String str) {
                                return Dns.SYSTEM.lookup(str);
                            }
                        };
                    }
                } finally {
                }
            }
        }
        return ff;
    }

    public static boolean tf() {
        return com.ss.android.socialbase.downloader.f.xj.w().xj("switch_not_auto_boot_service", tu ? 1 : 0) > 0;
    }

    public static synchronized Context tj() {
        Context context;
        synchronized (w.class) {
            context = xj;
        }
        return context;
    }

    public static IDownloadHttpService u() {
        return tf;
    }

    public static OkHttpClient v() {
        if (en == null) {
            synchronized (w.class) {
                try {
                    if (en == null) {
                        en = pz().build();
                    }
                } finally {
                }
            }
        }
        return en;
    }

    public static boolean vm() {
        return qd;
    }

    private static void w(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                xj(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                xj(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                xj(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                xj(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                xj(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                hf(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                xj(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                xj(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                xj(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                w(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                u(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                kd(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                y(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                c(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                f(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                xj(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                hf(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                xj(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                x = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                yy = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                xj(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                j = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                wn = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                xj(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                l = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                pz tTNetHandler = downloaderBuilder.getTTNetHandler();
                f13847a = tTNetHandler;
                if (tTNetHandler.xj()) {
                    xj(f13847a.hf());
                    xj(f13847a.w());
                } else {
                    xj(f());
                    xj(d());
                }
            }
            hf(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                xj(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    public static xj wn() {
        return d;
    }

    public static f wo() {
        if (u == null) {
            synchronized (w.class) {
                try {
                    if (u == null) {
                        u = new com.ss.android.socialbase.downloader.impls.w();
                    }
                } finally {
                }
            }
        }
        return u;
    }

    public static v ws() {
        if (f13848io == null) {
            synchronized (w.class) {
                try {
                    if (f13848io == null) {
                        f13848io = new com.ss.android.socialbase.downloader.impls.tf();
                    }
                } finally {
                }
            }
        }
        return f13848io;
    }

    public static qt x() {
        if (f == null) {
            synchronized (w.class) {
                try {
                    if (f == null) {
                        f = d.xj();
                    }
                } finally {
                }
            }
        }
        return f;
    }

    public static void xj(yo yoVar) {
    }

    public static com.ss.android.socialbase.downloader.network.f y() {
        return p;
    }

    public static ExecutorService yo() {
        if (jk == null) {
            synchronized (w.class) {
                try {
                    if (jk == null) {
                        int i = n;
                        com.bytedance.sdk.component.tf.u.u uVar = new com.bytedance.sdk.component.tf.u.u(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.d.xj("DownloadThreadPool-db-fixed", true));
                        try {
                            uVar.allowCoreThreadTimeOut(true);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.pl.xj(th);
                        }
                        jk = uVar;
                    }
                } finally {
                }
            }
        }
        return jk;
    }

    public static com.ss.android.socialbase.downloader.u.w yy() {
        if (dq == null) {
            dq = new com.ss.android.socialbase.downloader.u.w() { // from class: com.ss.android.socialbase.downloader.downloader.w.3
                @Override // com.ss.android.socialbase.downloader.u.w
                public void hf(int i, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.u.w
                public void xj(int i, String str, JSONObject jSONObject) {
                }
            };
        }
        return dq;
    }

    public static com.ss.android.socialbase.downloader.impls.xj z() {
        if (y == null) {
            synchronized (w.class) {
                try {
                    if (y == null) {
                        y = new com.ss.android.socialbase.downloader.impls.kd();
                    }
                } finally {
                }
            }
        }
        return y;
    }

    public static ExecutorService zg() {
        if (e == null) {
            synchronized (w.class) {
                try {
                    if (e == null) {
                        int i = tj;
                        com.bytedance.sdk.component.tf.u.u uVar = new com.bytedance.sdk.component.tf.u.u(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.d.xj("DownloadThreadPool-mix-fixed", true));
                        try {
                            uVar.allowCoreThreadTimeOut(true);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.pl.xj(th);
                        }
                        e = uVar;
                    }
                } finally {
                }
            }
        }
        return e;
    }

    private static void c(ExecutorService executorService) {
        if (executorService != null) {
            v = executorService;
        }
    }

    private static void u(ExecutorService executorService) {
        if (executorService != null) {
            zg = executorService;
        }
    }

    public static synchronized void xj(DownloaderBuilder downloaderBuilder) {
        synchronized (w.class) {
            if (qd) {
                com.ss.android.socialbase.downloader.w.xj.kd("DownloadComponentManager", "component has init");
                return;
            }
            boolean z2 = j;
            w(downloaderBuilder);
            if (hf == null) {
                hf = new com.ss.android.socialbase.downloader.impls.u();
            }
            if (c == null) {
                c = new com.ss.android.socialbase.downloader.impls.f();
            }
            if (f == null && d != null) {
                f = d.xj();
            }
            if (w == null) {
                w = new com.ss.android.socialbase.downloader.impls.d();
            }
            if (y == null) {
                y = new com.ss.android.socialbase.downloader.impls.kd();
            }
            if (u == null) {
                u = new com.ss.android.socialbase.downloader.impls.w();
            }
            if (dk == null) {
                dk = new com.ss.android.socialbase.downloader.impls.hf();
            }
            if (f13848io == null) {
                f13848io = new com.ss.android.socialbase.downloader.impls.tf();
            }
            int i = b;
            if (i <= 0 || i > ws) {
                b = ws;
            }
            aq();
            if (j && !z2 && !com.ss.android.socialbase.downloader.tf.y.w()) {
                com.ss.android.socialbase.downloader.impls.pl.xj(true).startService();
            } else if (com.ss.android.socialbase.downloader.tf.y.u()) {
                ExecutorService g2 = g();
                if (g2 != null) {
                    g2.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.w.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Context tj2 = w.tj();
                            if (tj2 != null) {
                                com.ss.android.socialbase.downloader.tf.y.u(tj2);
                            }
                        }
                    });
                }
            } else {
                Context tj2 = tj();
                if (tj2 != null) {
                    com.ss.android.socialbase.downloader.tf.y.u(tj2);
                }
            }
            l();
            qd = true;
        }
    }

    private static void y(ExecutorService executorService) {
        if (executorService != null) {
            yo = executorService;
        }
    }

    public static synchronized void hf() {
        synchronized (w.class) {
            if (j) {
                return;
            }
            j = true;
            try {
                Intent intent = new Intent(tj(), (Class<?>) DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
                tj().startService(intent);
                if (!com.ss.android.socialbase.downloader.tf.y.w()) {
                    com.ss.android.socialbase.downloader.impls.pl.xj(true).startService();
                }
            } catch (Throwable th) {
                j = false;
                com.bytedance.sdk.component.utils.pl.xj(th);
            }
        }
    }

    private static void kd(ExecutorService executorService) {
        if (executorService != null) {
            e = executorService;
        }
    }

    private static void f(ExecutorService executorService) {
        if (executorService != null) {
            jk = executorService;
        }
    }

    public static void hf(com.ss.android.socialbase.downloader.depend.p pVar) {
        List<com.ss.android.socialbase.downloader.depend.p> list = vm;
        synchronized (list) {
            if (pVar != null) {
                try {
                    if (list.contains(pVar)) {
                        list.remove(pVar);
                    }
                } finally {
                }
            }
        }
    }

    public static void hf(DownloadTask downloadTask, int i) {
        List<Object> list = dc;
        synchronized (list) {
            try {
                Iterator<Object> it = list.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static com.ss.android.socialbase.downloader.network.c hf(String str, List<com.ss.android.socialbase.downloader.model.w> list, int i, boolean z2, DownloadInfo downloadInfo) {
        Throwable th;
        IOException iOException;
        com.ss.android.socialbase.downloader.network.f y2 = i == 1 ? y() : d();
        if (y2 != null) {
            long j2 = 0;
            try {
                if (z2) {
                    try {
                        j2 = System.currentTimeMillis();
                    } catch (IOException e2) {
                        throw e2;
                    }
                }
                try {
                    com.ss.android.socialbase.downloader.network.c xj2 = y2.xj(str, list);
                    if (z2) {
                        com.ss.android.socialbase.downloader.u.xj.xj(xj2, str, null, System.currentTimeMillis() - j2, "head", i, null, downloadInfo);
                    }
                    return xj2;
                } catch (Throwable th2) {
                    th = th2;
                    iOException = null;
                    if (!z2) {
                        throw th;
                    }
                    com.ss.android.socialbase.downloader.u.xj.xj(null, str, null, System.currentTimeMillis() - j2, "head", i, iOException, downloadInfo);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                iOException = null;
            }
        } else {
            throw new BaseException(1022, new IOException(CtFAbx.ARc23Z(i, "httpService not exist, netLib = ")));
        }
    }

    public static synchronized void xj() {
        synchronized (w.class) {
            try {
                if (r && et != null && xj != null) {
                    xj.unregisterReceiver(et);
                    r = false;
                }
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.pl.xj(e2);
            }
        }
    }

    public static void hf(ExecutorService executorService) {
        if (executorService != null) {
            ht = executorService;
        }
    }

    public static void hf(Runnable runnable) {
        hf(runnable, false);
    }

    public static void hf(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.tf.y.u()) {
            runnable.run();
        } else {
            g().execute(runnable);
        }
    }

    public static void xj(wo woVar) {
        if (woVar == null) {
            return;
        }
        synchronized (z) {
            z.add(woVar);
        }
    }

    private static void hf(int i) {
        if (i > 0) {
            b = i;
        }
    }

    private static void hf(boolean z2) {
        aq = z2;
    }

    public static void xj(com.ss.android.socialbase.downloader.depend.p pVar) {
        List<com.ss.android.socialbase.downloader.depend.p> list = vm;
        synchronized (list) {
            if (pVar != null) {
                try {
                    if (!list.contains(pVar)) {
                        list.add(pVar);
                    }
                } finally {
                }
            }
        }
    }

    public static void xj(com.ss.android.socialbase.downloader.constants.u uVar) {
        List<com.ss.android.socialbase.downloader.depend.p> list = vm;
        synchronized (list) {
            try {
                for (com.ss.android.socialbase.downloader.depend.p pVar : list) {
                    if (pVar != null && uVar != com.ss.android.socialbase.downloader.constants.u.SYNC_START && uVar == com.ss.android.socialbase.downloader.constants.u.SYNC_SUCCESS) {
                        pVar.xj();
                    }
                }
                if (uVar == com.ss.android.socialbase.downloader.constants.u.SYNC_SUCCESS) {
                    vm.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized boolean w() {
        boolean z2;
        synchronized (w.class) {
            z2 = j;
        }
        return z2;
    }

    private static void w(ExecutorService executorService) {
        if (executorService != null) {
            qt = executorService;
        }
    }

    public static void xj(DownloadTask downloadTask, int i) {
        List<Object> list = dc;
        synchronized (list) {
            try {
                Iterator<Object> it = list.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void w(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.tf.y.u()) {
            runnable.run();
        } else {
            yo().execute(runnable);
        }
    }

    public static com.ss.android.socialbase.downloader.network.d xj(boolean z2, int i, String str, List<com.ss.android.socialbase.downloader.model.w> list) {
        return xj(z2, i, str, null, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.d xj(boolean z2, int i, String str, String str2, List<com.ss.android.socialbase.downloader.model.w> list, int i2, boolean z3, DownloadInfo downloadInfo) {
        List<com.ss.android.socialbase.downloader.model.w> list2;
        int i3;
        com.ss.android.socialbase.downloader.network.d xj2;
        if (!TextUtils.isEmpty(str2)) {
            List<com.ss.android.socialbase.downloader.model.w> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new com.ss.android.socialbase.downloader.model.w("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i3 = 1;
        } else if (z2) {
            list2 = list;
            i3 = i2;
        } else {
            i3 = 2;
            list2 = list;
        }
        Exception e2 = null;
        for (int i4 : xj(i3)) {
            try {
                xj2 = xj(i, str, str2, list2, i4, z3, downloadInfo);
            } catch (Exception e3) {
                e2 = e3;
                if (!downloadInfo.isExpiredRedownload()) {
                    continue;
                } else if (!com.ss.android.socialbase.downloader.tf.y.c(e2)) {
                    continue;
                } else if (com.ss.android.socialbase.downloader.tf.y.w(list2)) {
                    com.ss.android.socialbase.downloader.w.xj.xj("dcach::http exception 304, throw excepiton, not retry " + e2);
                    throw e2;
                }
            }
            if (xj2 != null) {
                return xj2;
            }
        }
        if (e2 == null) {
            return null;
        }
        throw e2;
    }

    private static com.ss.android.socialbase.downloader.network.d xj(int i, String str, String str2, List<com.ss.android.socialbase.downloader.model.w> list, int i2, boolean z2, DownloadInfo downloadInfo) {
        Throwable th;
        IOException iOException;
        IDownloadHttpService u2 = i2 == 1 ? u() : f();
        if (u2 != null) {
            long j2 = 0;
            try {
                if (z2) {
                    try {
                        j2 = System.currentTimeMillis();
                    } catch (IOException e2) {
                        throw e2;
                    }
                }
                iOException = null;
                try {
                    com.ss.android.socialbase.downloader.network.d downloadWithConnection = u2.downloadWithConnection(i, str, list);
                    if (z2) {
                        com.ss.android.socialbase.downloader.u.xj.xj(downloadWithConnection, str, str2, System.currentTimeMillis() - j2, "get", i2, null, downloadInfo);
                    }
                    return downloadWithConnection;
                } catch (Throwable th2) {
                    th = th2;
                    if (!z2) {
                        throw th;
                    }
                    com.ss.android.socialbase.downloader.u.xj.xj(null, str, str2, System.currentTimeMillis() - j2, "get", i2, iOException, downloadInfo);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                iOException = null;
            }
        } else {
            throw new BaseException(1022, new IOException(CtFAbx.ARc23Z(i2, "httpService not exist, netLib = ")));
        }
    }

    public static com.ss.android.socialbase.downloader.network.c xj(String str, List<com.ss.android.socialbase.downloader.model.w> list) {
        return xj(str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.c xj(String str, List<com.ss.android.socialbase.downloader.model.w> list, int i, boolean z2, DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.network.c hf2;
        Exception e2 = null;
        for (int i2 : xj(i)) {
            try {
                hf2 = hf(str, list, i2, z2, downloadInfo);
            } catch (Exception e3) {
                e2 = e3;
            }
            if (hf2 != null) {
                return hf2;
            }
        }
        if (e2 == null) {
            return null;
        }
        throw e2;
    }

    private static int[] xj(int i) {
        if (i == 1) {
            return new int[]{0};
        }
        if (i == 2) {
            return new int[]{1};
        }
        if (i != 3) {
            return new int[]{1, 0};
        }
        return new int[]{0, 1};
    }

    public static synchronized void xj(pl plVar) {
        synchronized (w.class) {
            if (plVar != null) {
                am = plVar;
                if (hf instanceof com.ss.android.socialbase.downloader.impls.u) {
                    ((com.ss.android.socialbase.downloader.impls.u) hf).f();
                }
            }
        }
    }

    public static void xj(ExecutorService executorService) {
        if (executorService != null) {
            pz = executorService;
        }
    }

    private static void xj(List<com.ss.android.socialbase.downloader.depend.g> list) {
        List<com.ss.android.socialbase.downloader.depend.g> list2 = wo;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void xj(boolean z2) {
        tu = z2;
    }

    public static void xj(Runnable runnable) {
        xj(runnable, false);
    }

    public static void xj(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.tf.y.u()) {
            runnable.run();
        } else {
            pl().execute(runnable);
        }
    }

    public static Future xj(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return jk().schedule(runnable, j2, timeUnit);
    }

    public static void xj(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            tf = iDownloadHttpService;
        }
        hl = tf != null;
    }

    public static void xj(com.ss.android.socialbase.downloader.network.f fVar) {
        if (fVar != null) {
            p = fVar;
        }
    }

    private static void xj(tf tfVar) {
        if (tfVar != null) {
            hf = tfVar;
        }
    }

    private static void xj(p pVar) {
        if (pVar != null) {
            w = pVar;
        }
    }

    private static void xj(com.ss.android.socialbase.downloader.u.hf hfVar) {
        if (hfVar != null) {
            ai = hfVar;
        }
    }

    public static void xj(x xVar) {
        q = xVar;
        com.ss.android.socialbase.downloader.f.xj.xj();
    }

    private static void xj(f fVar) {
        if (fVar != null) {
            u = fVar;
        }
    }

    public static void xj(j jVar) {
        if (jVar != null) {
            kd = jVar;
        }
    }

    private static void xj(c cVar) {
        if (cVar != null) {
            dk = cVar;
        }
    }

    public static synchronized void xj(Context context) {
        synchronized (w.class) {
            if (context != null) {
                if (xj == null) {
                    xj = context.getApplicationContext();
                    com.ss.android.socialbase.downloader.xj.xj.xj().xj(xj);
                }
            }
        }
    }

    public static int xj(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        String taskKey = downloadInfo.getTaskKey();
        if (TextUtils.isEmpty(taskKey)) {
            taskKey = downloadInfo.getUrl();
        }
        return xj(taskKey, downloadInfo.getSavePath());
    }

    public static int xj(String str, String str2) {
        p q2 = q();
        if (q2 == null) {
            return 0;
        }
        return q2.xj(str, str2);
    }

    public static void xj(com.ss.android.socialbase.downloader.u.w wVar) {
        dq = wVar;
    }

    public static void xj(xj xjVar) {
        com.ss.android.socialbase.downloader.w.xj.xj("wjd", "setIndependentServiceCreator::creator=" + xjVar);
        d = xjVar;
    }
}
