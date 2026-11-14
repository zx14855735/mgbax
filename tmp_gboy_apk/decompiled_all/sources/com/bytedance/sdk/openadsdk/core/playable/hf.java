package com.bytedance.sdk.openadsdk.core.playable;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static volatile hf xj;
    private LruCache<String, com.bytedance.sdk.openadsdk.core.playable.xj.xj> hf;
    private int u;
    private final long w;
    private CopyOnWriteArrayList<String> kd = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<String> y = new CopyOnWriteArrayList<>();
    private ConcurrentHashMap<String, WeakReference<com.bytedance.sdk.openadsdk.core.jk.w>> c = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> f = new ConcurrentHashMap<>();
    private final Object d = new Object();

    private hf() {
        int jf = pz.hf().jf();
        this.u = jf;
        if (jf > 30) {
            this.u = 30;
        } else if (jf < 0) {
            this.u = 5;
        }
        this.w = pz.hf().uh() * 1000;
        this.hf = new LruCache<String, com.bytedance.sdk.openadsdk.core.playable.xj.xj>(this.u) { // from class: com.bytedance.sdk.openadsdk.core.playable.hf.1
            @Override // android.util.LruCache
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public int sizeOf(String str, com.bytedance.sdk.openadsdk.core.playable.xj.xj xjVar) {
                return 1;
            }
        };
    }

    public static /* synthetic */ void xj(hf hfVar, String str) {
    }

    private void u(final ws wsVar) {
        if (TextUtils.isEmpty(wsVar.an())) {
            return;
        }
        final String an = wsVar.an();
        if (this.kd.contains(an) || this.y.contains(an) || this.hf.get(an) != null) {
            return;
        }
        this.kd.add(an);
        this.f.put(an, Long.valueOf(System.currentTimeMillis()));
        c.hf(new d("playable_prefetch") { // from class: com.bytedance.sdk.openadsdk.core.playable.hf.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    hf.this.xj(wsVar, an);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void hf(ws wsVar) {
        if (wsVar != null) {
            try {
                if (TextUtils.isEmpty(wsVar.an())) {
                    return;
                }
                String an = wsVar.an();
                this.y.add(an);
                this.hf.remove(an);
                this.kd.remove(an);
                this.c.remove(an);
                this.f.remove(an);
                this.hf.size();
                this.kd.size();
                this.y.size();
            } catch (Exception unused) {
            }
        }
    }

    public long w(ws wsVar) {
        try {
            if (this.f == null || wsVar == null || TextUtils.isEmpty(wsVar.an())) {
                return 0L;
            }
            return this.f.get(wsVar.an()).longValue();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static hf xj() {
        if (xj == null) {
            synchronized (hf.class) {
                try {
                    if (xj == null) {
                        xj = new hf();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void xj(ws wsVar) {
        if (wsVar != null) {
            try {
                if (wsVar.vr() == 3) {
                    u(wsVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(ws wsVar, final String str) {
        com.bytedance.sdk.openadsdk.core.et.hf.xj(wsVar, wsVar == null ? null : wsVar.pn(), new com.bytedance.sdk.openadsdk.core.jk.w() { // from class: com.bytedance.sdk.openadsdk.core.playable.hf.3
            @Override // com.bytedance.sdk.openadsdk.core.jk.w
            public void xj(boolean z, List<ws> list, boolean z2) {
                try {
                    if (hf.this.y != null && hf.this.y.contains(str)) {
                        hf.xj(hf.this, "prefetchCache-onAdLoaded.. discardTask. key: " + str);
                        return;
                    }
                    hf.xj(hf.this, "prefetchCache-onAdLoaded.. success: ".concat(String.valueOf(z)));
                    synchronized (hf.this.d) {
                        if (z && list != null) {
                            try {
                                if (list.size() > 0) {
                                    com.bytedance.sdk.openadsdk.core.playable.xj.xj xjVar = new com.bytedance.sdk.openadsdk.core.playable.xj.xj();
                                    xjVar.xj = list;
                                    xjVar.hf = z;
                                    xjVar.w = SystemClock.elapsedRealtime();
                                    hf.this.hf.put(str, xjVar);
                                    hf.xj(hf.this, "prefetchCache-onAdLoaded.. 缓存save  key: " + str);
                                }
                            } finally {
                            }
                        }
                        hf.this.kd.remove(str);
                    }
                    WeakReference weakReference = (WeakReference) hf.this.c.get(str);
                    com.bytedance.sdk.openadsdk.core.jk.w wVar = weakReference == null ? null : (com.bytedance.sdk.openadsdk.core.jk.w) weakReference.get();
                    if (wVar != null) {
                        wVar.xj(z, list, true);
                        hf.this.c.remove(str);
                        hf.xj(hf.this, "prefetchCache-onAdLoaded..callback invoke key: " + str);
                    }
                } catch (Exception unused) {
                }
            }
        }, (com.bytedance.sdk.openadsdk.zg.w.w.hf) null);
    }

    public boolean xj(ws wsVar, com.bytedance.sdk.openadsdk.core.jk.w wVar) {
        if (wsVar != null && !TextUtils.isEmpty(wsVar.an())) {
            String an = wsVar.an();
            try {
                synchronized (this.d) {
                    try {
                        if (this.kd.contains(an)) {
                            this.c.put(an, new WeakReference<>(wVar));
                            return true;
                        }
                        com.bytedance.sdk.openadsdk.core.playable.xj.xj xjVar = this.hf.get(an);
                        if (xjVar == null) {
                            return false;
                        }
                        if (xj(xjVar)) {
                            hf(wsVar);
                            return false;
                        }
                        if (wVar != null) {
                            wVar.xj(xjVar.hf, xjVar.xj, true);
                            return true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private boolean xj(com.bytedance.sdk.openadsdk.core.playable.xj.xj xjVar) {
        return this.w > 0 && xjVar != null && SystemClock.elapsedRealtime() - xjVar.w > this.w;
    }
}
