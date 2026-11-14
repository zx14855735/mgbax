package com.bykv.vk.openvk.component.video.xj.hf;

import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.component.video.xj.hf.d;
import com.bykv.vk.openvk.component.video.xj.hf.hf;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private static volatile u kd;
    private volatile boolean am;
    private volatile com.bykv.vk.openvk.component.video.xj.hf.xj.w c;
    private final HashSet<xj> d;
    private volatile com.bykv.vk.openvk.component.video.xj.hf.xj.hf f;
    private volatile String g;
    private final SparseArray<Map<String, com.bykv.vk.openvk.component.video.xj.hf.hf>> hf;
    private volatile w p;

    /* renamed from: pl, reason: collision with root package name */
    private volatile w f10025pl;
    private final hf.InterfaceC0015hf tf;
    private final ExecutorService u;
    private final hf<Runnable> w;
    private volatile int xj = 163840;
    private volatile com.bykv.vk.openvk.component.video.xj.hf.hf.w y;

    public static final class hf<T> extends LinkedBlockingDeque<T> {
        private ThreadPoolExecutor xj;

        private hf() {
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                try {
                    int poolSize = this.xj.getPoolSize();
                    int activeCount = this.xj.getActiveCount();
                    int maximumPoolSize = this.xj.getMaximumPoolSize();
                    if (activeCount < poolSize || poolSize >= maximumPoolSize) {
                        return offerFirst(t);
                    }
                    if (kd.w) {
                        com.bytedance.sdk.component.utils.pl.xj("TAG_PROXY_TT", "create new preloader thread");
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void xj(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                try {
                    if (this.xj != null) {
                        throw new IllegalStateException("You can only call setExecutor() once!");
                    }
                    if (threadPoolExecutor == null) {
                        throw new NullPointerException("executor argument can't be null!");
                    }
                    this.xj = threadPoolExecutor;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static final class xj {
        final boolean hf;
        final Map<String, String> kd;
        final String u;
        final int w;
        final boolean xj;
        final String[] y;

        public xj(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.xj = z;
            this.hf = z2;
            this.w = i;
            this.u = str;
            this.kd = map;
            this.y = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || xj.class != obj.getClass()) {
                return false;
            }
            xj xjVar = (xj) obj;
            if (this.xj == xjVar.xj && this.hf == xjVar.hf && this.w == xjVar.w) {
                return this.u.equals(xjVar.u);
            }
            return false;
        }

        public int hashCode() {
            return this.u.hashCode() + ((((((this.xj ? 1 : 0) * 31) + (this.hf ? 1 : 0)) * 31) + this.w) * 31);
        }
    }

    private u() {
        SparseArray<Map<String, com.bykv.vk.openvk.component.video.xj.hf.hf>> sparseArray = new SparseArray<>(2);
        this.hf = sparseArray;
        this.d = new HashSet<>();
        this.tf = new hf.InterfaceC0015hf() { // from class: com.bykv.vk.openvk.component.video.xj.hf.u.1
            @Override // com.bykv.vk.openvk.component.video.xj.hf.hf.InterfaceC0015hf
            public void xj(com.bykv.vk.openvk.component.video.xj.hf.hf hfVar) {
                int y = hfVar.y();
                synchronized (u.this.hf) {
                    try {
                        Map map = (Map) u.this.hf.get(y);
                        if (map != null) {
                            map.remove(hfVar.f);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                boolean z = kd.w;
            }
        };
        hf<Runnable> hfVar = new hf<>();
        this.w = hfVar;
        ExecutorService xj2 = xj(hfVar);
        this.u = xj2;
        hfVar.xj((ThreadPoolExecutor) xj2);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    public static u w() {
        if (kd == null) {
            synchronized (u.class) {
                try {
                    if (kd == null) {
                        kd = new u();
                    }
                } finally {
                }
            }
        }
        return kd;
    }

    public void u() {
        com.bykv.vk.openvk.component.video.xj.w.xj.xj(new com.bytedance.sdk.component.tf.d("cancelAll") { // from class: com.bykv.vk.openvk.component.video.xj.hf.u.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                synchronized (u.this.hf) {
                    try {
                        int size = u.this.hf.size();
                        for (int i = 0; i < size; i++) {
                            Map map = (Map) u.this.hf.get(u.this.hf.keyAt(i));
                            if (map != null) {
                                arrayList.addAll(map.values());
                                map.clear();
                            }
                        }
                        u.this.w.clear();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.bykv.vk.openvk.component.video.xj.hf.hf hfVar = (com.bykv.vk.openvk.component.video.xj.hf.hf) it.next();
                    hfVar.xj();
                    if (kd.w) {
                        com.bytedance.sdk.component.utils.pl.hf("TAG_PROXY_Preloader", "PreloadTask: " + hfVar + ", canceled!!!");
                    }
                }
            }
        });
    }

    public w hf() {
        return this.f10025pl;
    }

    public void xj(com.bykv.vk.openvk.component.video.xj.hf.xj.w wVar) {
        this.c = wVar;
    }

    public void xj(com.bykv.vk.openvk.component.video.xj.hf.hf.w wVar) {
        this.y = wVar;
    }

    public void xj(int i) {
        if (i > 0) {
            this.xj = i;
        }
        if (kd.w) {
            com.bytedance.sdk.component.utils.pl.xj("TAG_PROXY_Preloader", "MaxPreloadSize: ".concat(String.valueOf(i)));
        }
    }

    public w xj() {
        return this.p;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:37:0x007c
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public void xj(boolean r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.xj.hf.u.xj(boolean, java.lang.String):void");
    }

    public void xj(boolean z, boolean z2, int i, String str, String... strArr) {
        xj(z, z2, i, str, null, strArr);
    }

    public void xj(boolean z, boolean z2, int i, String str, Map<String, String> map, String... strArr) {
        ArrayList arrayList;
        boolean z3 = kd.w;
        com.bykv.vk.openvk.component.video.xj.hf.xj.xj xjVar = z ? this.f : this.c;
        com.bykv.vk.openvk.component.video.xj.hf.hf.w wVar = this.y;
        if (xjVar != null && wVar != null) {
            if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
                return;
            }
            int i2 = i <= 0 ? this.xj : i;
            String xj2 = z2 ? str : com.bykv.vk.openvk.component.video.api.y.hf.xj(str);
            File u = xjVar.u(xj2);
            if (u != null && u.length() >= i2) {
                if (kd.w) {
                    com.bytedance.sdk.component.utils.pl.xj("TAG_PROXY_Preloader", "no need preload, file size: " + u.length() + ", need preload size: " + i2);
                    return;
                }
                return;
            }
            if (y.xj().xj(com.bykv.vk.openvk.component.video.xj.hf.hf.hf.xj(z), xj2)) {
                if (kd.w) {
                    com.bytedance.sdk.component.utils.pl.hf("TAG_PROXY_Preloader", "has running proxy task, skip preload for key: ".concat(String.valueOf(str)));
                    return;
                }
                return;
            }
            synchronized (this.hf) {
                try {
                    Map<String, com.bykv.vk.openvk.component.video.xj.hf.hf> map2 = this.hf.get(z ? 1 : 0);
                    if (map2.containsKey(xj2)) {
                        return;
                    }
                    xj xjVar2 = new xj(z, z2, i2, str, map, strArr);
                    String str2 = this.g;
                    if (str2 != null) {
                        int i3 = kd.f;
                        if (i3 == 3) {
                            synchronized (this.d) {
                                this.d.add(xjVar2);
                            }
                            if (kd.w) {
                                com.bytedance.sdk.component.utils.pl.hf("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                            }
                            return;
                        }
                        if (i3 == 2) {
                            if (kd.w) {
                                com.bytedance.sdk.component.utils.pl.hf("TAG_PROXY_Preloader", "cancel preload: ".concat(String.valueOf(str)));
                            }
                            return;
                        } else if (i3 == 1 && this.am == z && str2.equals(xj2)) {
                            if (kd.w) {
                                com.bytedance.sdk.component.utils.pl.hf("TAG_PROXY_Preloader", "cancel preload: " + str + ", it is playing");
                            }
                            return;
                        }
                    }
                    List<d.hf> xj3 = com.bykv.vk.openvk.component.video.xj.w.xj.xj(com.bykv.vk.openvk.component.video.xj.w.xj.xj(map));
                    if (xj3 != null) {
                        arrayList = new ArrayList(xj3.size());
                        int size = xj3.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            d.hf hfVar = xj3.get(i4);
                            if (hfVar != null) {
                                arrayList.add(new d.hf(hfVar.xj, hfVar.hf));
                            }
                        }
                    } else {
                        arrayList = null;
                    }
                    com.bykv.vk.openvk.component.video.xj.hf.hf xj4 = new hf.xj().xj(xjVar).xj(wVar).xj(str).hf(xj2).xj(new pl(com.bykv.vk.openvk.component.video.xj.w.xj.xj(strArr))).xj((List<d.hf>) arrayList).xj(i2).xj(this.tf).xj(xjVar2).xj();
                    map2.put(xj2, xj4);
                    this.u.execute(xj4);
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (kd.w) {
            com.bytedance.sdk.component.utils.pl.u("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
        }
    }

    public void xj(String str) {
        xj(false, false, str);
    }

    public void xj(final boolean z, final boolean z2, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bykv.vk.openvk.component.video.xj.w.xj.xj(new com.bytedance.sdk.component.tf.d("cancel b b S") { // from class: com.bykv.vk.openvk.component.video.xj.hf.u.2
            @Override // java.lang.Runnable
            public void run() {
                com.bykv.vk.openvk.component.video.xj.hf.hf hfVar;
                synchronized (u.this.hf) {
                    try {
                        Map map = (Map) u.this.hf.get(com.bykv.vk.openvk.component.video.xj.hf.hf.hf.xj(z));
                        if (map != null) {
                            hfVar = (com.bykv.vk.openvk.component.video.xj.hf.hf) map.remove(z2 ? str : com.bykv.vk.openvk.component.video.api.y.hf.xj(str));
                        } else {
                            hfVar = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (hfVar != null) {
                    hfVar.xj();
                }
            }
        });
    }

    private static ExecutorService xj(final hf<Runnable> hfVar) {
        int xj2 = com.bykv.vk.openvk.component.video.xj.w.xj.xj();
        return new com.bytedance.sdk.component.tf.u.u(0, xj2 <= 0 ? 1 : xj2 > 4 ? 4 : xj2, 60L, TimeUnit.SECONDS, hfVar, new ThreadFactory() { // from class: com.bykv.vk.openvk.component.video.xj.hf.u.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.bytedance.sdk.component.tf.u.w wVar = new com.bytedance.sdk.component.tf.u.w(runnable) { // from class: com.bykv.vk.openvk.component.video.xj.hf.u.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.pl.xj(th);
                        }
                        super.run();
                    }
                };
                wVar.setName("csj_video_preload_" + wVar.getId());
                wVar.setDaemon(true);
                if (kd.w) {
                    com.bytedance.sdk.component.utils.pl.xj("TAG_PROXY_Preloader", "new preload thead: " + wVar.getName());
                }
                return wVar;
            }
        }, new RejectedExecutionHandler() { // from class: com.bykv.vk.openvk.component.video.xj.hf.u.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    hf.this.offerFirst(runnable);
                    if (kd.w) {
                        com.bytedance.sdk.component.utils.pl.xj("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.pl.xj(th);
                }
            }
        });
    }
}
