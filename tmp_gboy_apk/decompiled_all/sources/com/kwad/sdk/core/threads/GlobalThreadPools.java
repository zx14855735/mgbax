package com.kwad.sdk.core.threads;

import android.util.Log;
import com.sigmob.sdk.base.mta.PointCategory;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class GlobalThreadPools {
    private static String TAG;
    private static final int aOg;
    private static final int aOh;
    private static final int aOi;
    private static Map<String, WeakReference<ExecutorService>> aOj;
    private static Map<String, Integer> aOk;
    private static boolean aOl;

    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] aOm;

        static {
            int[] iArr = new int[ParamType.values().length];
            aOm = iArr;
            try {
                iArr[ParamType.CORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aOm[ParamType.MAX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aOm[ParamType.KEEP_ALIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum ParamType {
        CORE,
        MAX,
        KEEP_ALIVE;

        static {
            ZsPtV();
        }

        private static /* synthetic */ void ZsPtV() {
            char[] charArray = "\u009c\u0090\u0092Ñ\u0098\u009e\u0092\u009aÑ\u009d\u0090\u0086Ñ\u008c\u0097\u009a\u0093\u0093Ñµ\u0091\u0096½\u008d\u0096\u009b\u0098\u009a".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 255);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u009c\u0093\u0096\u0091\u0096\u008b".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 255);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public interface a {
        ExecutorService Lw();
    }

    public static class b implements a {
        private b() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService Lw() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("httpIO", ParamType.CORE, GlobalThreadPools.aOh), GlobalThreadPools.a("httpIO", ParamType.MAX, GlobalThreadPools.aOi), GlobalThreadPools.a("httpIO", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(5, "diskAndHttp"));
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public static class c implements a {
        private c() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService Lw() {
            int i = 5;
            f fVar = new f(5, "ForCore");
            try {
                int a2 = GlobalThreadPools.a("httpIOForCoreV1", ParamType.CORE, 5);
                int a3 = GlobalThreadPools.a("httpIOForCoreV1", ParamType.MAX, 5);
                if (a2 < 0) {
                    a2 = 5;
                }
                if (a3 < 0) {
                    a3 = 5;
                }
                if (a3 < a2) {
                    a3 = 5;
                } else {
                    i = a2;
                }
                com.kwad.sdk.core.d.c.d(GlobalThreadPools.TAG, "HttpIOCreatorForCore create, coreSize:" + i + ", maxSize:" + a3);
                return new com.kwad.sdk.core.threads.a.b(i, a3, GlobalThreadPools.a("httpIOForCoreV1", r1, GlobalThreadPools.a("httpIOForCoreV1", ParamType.KEEP_ALIVE, 60) >= 0 ? r5 : 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), fVar);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.e(GlobalThreadPools.TAG, Log.getStackTraceString(e));
                return new com.kwad.sdk.core.threads.a.b(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), fVar);
            }
        }

        public /* synthetic */ c(byte b) {
            this();
        }
    }

    public static class d implements a {
        private d() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService Lw() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("httpIOForCoreExtraV1", ParamType.CORE, 0), GlobalThreadPools.a("httpIOForCoreExtraV1", ParamType.MAX, 3), GlobalThreadPools.a("httpIOForCoreExtraV1", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new SynchronousQueue(), new f(5, "ForCoreExtra"), new ThreadPoolExecutor.DiscardPolicy());
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }

    public static class e implements a {
        private e() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService Lw() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("imageLoaderDistributor", ParamType.CORE, 0), GlobalThreadPools.a("imageLoaderDistributor", ParamType.MAX, 10), GlobalThreadPools.a("imageLoaderDistributor", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new SynchronousQueue(), new f(5, "uil-pool-d-"), new ThreadPoolExecutor.DiscardPolicy());
        }

        public /* synthetic */ e(byte b) {
            this();
        }
    }

    public static class f implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final String namePrefix;
        private final int threadPriority;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        static {
            sKuM();
        }

        public f(int i, String str) {
            this.threadPriority = i;
            this.namePrefix = "ksad-" + str + poolNumber.getAndIncrement() + "-thread-";
        }

        private static /* synthetic */ void sKuM() {
            char[] charArray = "\u0003\u000f\rN\u0007\u0001\r\u0005N\u0002\u000f\u0019N\u0013\b\u0005\f\fN*\u000e\t\"\u0012\t\u0004\u0007\u0005".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '`');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0003\f\t\u000e\t\u0014".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '`');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.threadPriority);
            return thread;
        }
    }

    public static class g implements a {
        private g() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService Lw() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("ksImageLoaderTask", ParamType.CORE, 3), GlobalThreadPools.a("ksImageLoaderTask", ParamType.MAX, 3), GlobalThreadPools.a("ksImageLoaderTask", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(5, "uil-pool-"));
        }

        public /* synthetic */ g(byte b) {
            this();
        }
    }

    public static class h implements a {
        private h() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService Lw() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("lruDiskCache", ParamType.CORE, 0), GlobalThreadPools.a("lruDiskCache", ParamType.MAX, 1), GlobalThreadPools.a("lruDiskCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(5, "lruDiskCache"));
        }

        public /* synthetic */ h(byte b) {
            this();
        }
    }

    public static class i implements a {
        private i() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService Lw() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a(PointCategory.REPORT, ParamType.CORE, 1), GlobalThreadPools.a(PointCategory.REPORT, ParamType.MAX, 1), GlobalThreadPools.a(PointCategory.REPORT, ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(3, "report-"));
        }

        public /* synthetic */ i(byte b) {
            this();
        }
    }

    public static class j implements a {
        private j() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService Lw() {
            return new com.kwad.sdk.core.threads.a.b(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(5, "backSingle"));
        }

        public /* synthetic */ j(byte b) {
            this();
        }
    }

    public static class k implements a {
        private k() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService Lw() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("videoCache", ParamType.CORE, 3), GlobalThreadPools.a("videoCache", ParamType.MAX, 3), GlobalThreadPools.a("videoCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(5, "videoCache"));
        }

        public /* synthetic */ k(byte b) {
            this();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        aOg = availableProcessors;
        if (availableProcessors <= 0) {
            availableProcessors = 9;
        }
        aOh = availableProcessors;
        aOi = availableProcessors;
        TAG = "GlobalThreadPools";
        aOj = new ConcurrentHashMap();
        aOk = new ConcurrentHashMap();
        aOl = true;
        HiiXukS();
    }

    private static /* synthetic */ void HiiXukS() {
        char[] charArray = "-!#`)/#+`,!7`=&+\"\"`\u0004 '\f<'*)+".toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length; i2++) {
            charArray[i2] = (char) (charArray[i2] ^ 'N');
        }
        String str = new String(charArray);
        char[] charArray2 = "-\"' ':".toCharArray();
        int length2 = charArray2.length;
        for (int i3 = 0; i3 < length2; i3++) {
            charArray2[i3] = (char) (charArray2[i3] ^ 'N');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void Lb() {
    }

    public static boolean Lc() {
        return aOl;
    }

    public static void Ld() {
        for (String str : aOj.keySet()) {
            if (aOj.get(str).get() instanceof ThreadPoolExecutor) {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) aOj.get(str).get();
                int corePoolSize = threadPoolExecutor.getCorePoolSize();
                int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                int keepAliveTime = (int) threadPoolExecutor.getKeepAliveTime(timeUnit);
                int a2 = a(str, ParamType.CORE, corePoolSize);
                int a3 = a(str, ParamType.MAX, maximumPoolSize);
                try {
                    threadPoolExecutor.setKeepAliveTime(a(str, ParamType.KEEP_ALIVE, keepAliveTime), timeUnit);
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                }
                if (corePoolSize != a2 || maximumPoolSize != a3) {
                    if (corePoolSize <= a3) {
                        threadPoolExecutor.setMaximumPoolSize(a3);
                        threadPoolExecutor.setCorePoolSize(a2);
                    } else if (a2 <= maximumPoolSize) {
                        threadPoolExecutor.setCorePoolSize(a2);
                        threadPoolExecutor.setMaximumPoolSize(a3);
                    }
                }
            }
        }
    }

    public static ExecutorService Le() {
        return Lc() ? Lq() : a("lruDiskCache", new h((byte) 0));
    }

    public static ExecutorService Lf() {
        return a("backSingle", new j((byte) 0));
    }

    public static synchronized ExecutorService Lg() {
        ExecutorService a2;
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.d.c.d(TAG, "forKsImageLoaderTask");
            a2 = a("ksImageLoaderTask", new g((byte) 0));
        }
        return a2;
    }

    public static synchronized ExecutorService Lh() {
        ExecutorService a2;
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.d.c.d(TAG, "forKsImageLoaderCachedImages");
            a2 = a("ksImageLoaderTask", new g((byte) 0));
        }
        return a2;
    }

    public static ExecutorService Li() {
        com.kwad.sdk.core.d.c.d(TAG, "forKsImageLoaderTaskDistributor");
        return a("imageLoaderDistributor", new e((byte) 0));
    }

    public static synchronized ExecutorService Lj() {
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.d.c.d(TAG, "forBaseBatchReporter");
            if (Lc()) {
                return Lq();
            }
            return a(PointCategory.REPORT, new i((byte) 0));
        }
    }

    public static synchronized ExecutorService Lk() {
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.d.c.d(TAG, "forAdReportManager");
            if (Lc()) {
                return Lq();
            }
            return a(PointCategory.REPORT, new i((byte) 0));
        }
    }

    public static ExecutorService Ll() {
        com.kwad.sdk.core.d.c.d(TAG, "forBaseNetwork");
        return Lc() ? Lq() : a("httpIO", new b((byte) 0));
    }

    public static ExecutorService Lm() {
        com.kwad.sdk.core.d.c.d(TAG, "forCoreNetwork");
        return Lc() ? Ln() : Ll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ExecutorService Ln() {
        com.kwad.sdk.core.d.c.d(TAG, "getCoreExecutor");
        ExecutorService a2 = a("httpIOForCoreV1", new c(0 == true ? 1 : 0));
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) a2;
        int poolSize = threadPoolExecutor.getPoolSize();
        int a3 = a("httpIOForCoreV1", ParamType.CORE, 5);
        int a4 = a("httpIOForCoreExtraV1", ParamType.MAX, 3);
        ExecutorService a5 = a("httpIOForCoreExtraV1", new d(0 == true ? 1 : 0));
        ThreadPoolExecutor threadPoolExecutor2 = (ThreadPoolExecutor) a5;
        int poolSize2 = threadPoolExecutor2.getPoolSize();
        int activeCount = threadPoolExecutor.getActiveCount();
        int activeCount2 = threadPoolExecutor2.getActiveCount();
        com.kwad.sdk.core.d.c.d(TAG, "getCoreExecutor currentPoolSize:" + poolSize + " configSize:" + a3);
        com.kwad.sdk.core.d.c.d(TAG, "getCoreExecutor extraPoolSize:" + poolSize2 + " extraConfigSize:" + a4);
        int size = threadPoolExecutor.getQueue() == null ? 0 : threadPoolExecutor.getQueue().size();
        int size2 = threadPoolExecutor2.getQueue() != null ? threadPoolExecutor2.getQueue().size() : 0;
        com.kwad.sdk.core.d.c.e(TAG, "getCoreExecutor queueSize:" + size + " extraQueueSize:" + size2);
        if (poolSize < a3) {
            com.kwad.sdk.core.d.c.d(TAG, "getCoreExecutor currentPoolSize < configSize");
            return a2;
        }
        if (activeCount < a3) {
            com.kwad.sdk.core.d.c.e(TAG, "activeCount < configSize");
            return a2;
        }
        if (activeCount2 == a4) {
            com.kwad.sdk.core.d.c.e(TAG, "extraActiveCount == extraConfigSize");
            return a2;
        }
        com.kwad.sdk.core.d.c.e(TAG, "use extra");
        return a5;
    }

    public static ExecutorService Lo() {
        com.kwad.sdk.core.d.c.d(TAG, "forHttpCacheServer");
        return Lc() ? Lq() : a("videoCache", new k((byte) 0));
    }

    public static ExecutorService Lp() {
        com.kwad.sdk.core.d.c.d(TAG, "forAppStatusHelper");
        return Lc() ? Lq() : new com.kwad.sdk.core.threads.a.b(a("lruDiskCache", ParamType.CORE, 1), a("lruDiskCache", ParamType.MAX, 1), a("lruDiskCache", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "ksad-ashelper");
                thread.setPriority(3);
                return thread;
            }
        });
    }

    public static ExecutorService Lq() {
        com.kwad.sdk.core.d.c.d(TAG, "forAsync");
        return a("async", new a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.2
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
            public final ExecutorService Lw() {
                f fVar = new f(5, "async");
                int i2 = GlobalThreadPools.Lc() ? 5 : 3;
                return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("async", ParamType.CORE, i2), GlobalThreadPools.a("async", ParamType.MAX, i2), GlobalThreadPools.a("async", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), fVar);
            }
        });
    }

    public static ScheduledExecutorService Lr() {
        com.kwad.sdk.core.d.c.d(TAG, "forAsyncSchedule");
        ExecutorService a2 = a("async-schedule", new a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.3
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
            public final ExecutorService Lw() {
                return new com.kwad.sdk.core.threads.a.a(1, new f(5, "async-schedule"));
            }
        });
        return a2 instanceof ScheduledExecutorService ? (ScheduledExecutorService) a2 : new com.kwad.sdk.core.threads.a.a(1, new f(5, "async-schedule"));
    }

    public static Set<String> Ls() {
        return aOj.keySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:0|1|(2:3|(3:5|(1:7)|18)(1:19))(1:20)|8|9|(2:13|14)|18) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.String r1, com.kwad.sdk.core.threads.GlobalThreadPools.ParamType r2, int r3) {
        /*
            int[] r0 = com.kwad.sdk.core.threads.GlobalThreadPools.AnonymousClass4.aOm
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            if (r2 == r0) goto L20
            r0 = 2
            if (r2 == r0) goto L19
            r0 = 3
            if (r2 == r0) goto L12
            goto L43
        L12:
            java.lang.String r2 = "_keep_alive"
            java.lang.String r1 = ADYaiT.CtFAbx.AcNBzu(r1, r2)
            goto L26
        L19:
            java.lang.String r2 = "_max"
            java.lang.String r1 = ADYaiT.CtFAbx.AcNBzu(r1, r2)
            goto L26
        L20:
            java.lang.String r2 = "_core"
            java.lang.String r1 = ADYaiT.CtFAbx.AcNBzu(r1, r2)
        L26:
            java.util.Map<java.lang.String, java.lang.Integer> r2 = com.kwad.sdk.core.threads.GlobalThreadPools.aOk     // Catch: java.lang.Exception -> L43
            boolean r2 = r2.containsKey(r1)     // Catch: java.lang.Exception -> L43
            if (r2 == 0) goto L43
            java.util.Map<java.lang.String, java.lang.Integer> r2 = com.kwad.sdk.core.threads.GlobalThreadPools.aOk     // Catch: java.lang.Exception -> L43
            java.lang.Object r2 = r2.get(r1)     // Catch: java.lang.Exception -> L43
            if (r2 == 0) goto L43
            java.util.Map<java.lang.String, java.lang.Integer> r2 = com.kwad.sdk.core.threads.GlobalThreadPools.aOk     // Catch: java.lang.Exception -> L43
            java.lang.Object r1 = r2.get(r1)     // Catch: java.lang.Exception -> L43
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Exception -> L43
            int r1 = r1.intValue()     // Catch: java.lang.Exception -> L43
            return r1
        L43:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.threads.GlobalThreadPools.a(java.lang.String, com.kwad.sdk.core.threads.GlobalThreadPools$ParamType, int):int");
    }

    public static ExecutorService eS(String str) {
        if (!aOj.containsKey(str) || aOj.get(str) == null) {
            return null;
        }
        return aOj.get(str).get();
    }

    public static void r(String str, int i2) {
        aOk.put(str, Integer.valueOf(i2));
    }

    private static ExecutorService a(String str, a aVar) {
        WeakReference<ExecutorService> weakReference = aOj.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        ExecutorService Lw = aVar.Lw();
        aOj.put(str, new WeakReference<>(Lw));
        return Lw;
    }
}
