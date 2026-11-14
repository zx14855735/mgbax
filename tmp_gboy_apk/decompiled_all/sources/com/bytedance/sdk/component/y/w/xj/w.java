package com.bytedance.sdk.component.y.w.xj;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w<K, V> {
    private int c;
    private int f;
    private int hf;
    private int kd;
    private int u;
    private int w;
    private final LinkedHashMap<K, SoftReference<V>> xj;
    private int y;

    public w(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.w = i;
        this.xj = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int w(K k, V v) {
        int hf = hf(k, v);
        if (hf >= 0) {
            return hf;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public int hf(K k, V v) {
        return 1;
    }

    public final synchronized String toString() {
        int i;
        int i2;
        try {
            i = this.c;
            i2 = this.f + i;
        } catch (Throwable th) {
            throw th;
        }
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.w), Integer.valueOf(this.c), Integer.valueOf(this.f), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }

    public final V xj(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                SoftReference<V> softReference = this.xj.get(k);
                if (softReference != null) {
                    v = softReference.get();
                    if (v != null) {
                        this.c++;
                        return v;
                    }
                    this.xj.remove(k);
                } else {
                    v = null;
                }
                this.f++;
                V hf = hf(k);
                if (hf == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.kd++;
                        SoftReference<V> put = this.xj.put(k, new SoftReference<>(hf));
                        if (put != null) {
                            v = put.get();
                        }
                        if (v != null) {
                            this.xj.put(k, put);
                        } else {
                            this.hf += w(k, hf);
                        }
                    } finally {
                    }
                }
                if (v != null) {
                    return v;
                }
                xj(this.w);
                return hf;
            } finally {
            }
        }
    }

    public V hf(K k) {
        return null;
    }

    public final V xj(K k, V v) {
        V v2;
        if (k != null && v != null) {
            synchronized (this) {
                try {
                    this.u++;
                    this.hf += w(k, v);
                    SoftReference<V> put = this.xj.put(k, new SoftReference<>(v));
                    if (put != null) {
                        v2 = put.get();
                        if (v2 != null) {
                            this.hf -= w(k, v2);
                        }
                    } else {
                        v2 = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            xj(this.w);
            return v2;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0054, code lost:
    
        com.bytedance.sdk.component.utils.pl.u("LruCache", "oom maybe occured, clear cache. size= " + r3.hf + ", maxSize: " + r4);
        r3.hf = 0;
        r3.xj.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x007a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void xj(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.hf     // Catch: java.lang.Throwable -> L12
            if (r0 < 0) goto L54
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r3.xj     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            int r0 = r3.hf     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            goto L54
        L12:
            r4 = move-exception
            goto L7b
        L14:
            int r0 = r3.hf     // Catch: java.lang.Throwable -> L12
            if (r0 > r4) goto L1a
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L1a:
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r3.xj     // Catch: java.lang.Throwable -> L12
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L12
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L12
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L2e
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L2e:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L12
            java.lang.ref.SoftReference r0 = (java.lang.ref.SoftReference) r0     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r2 = r3.xj     // Catch: java.lang.Throwable -> L12
            r2.remove(r1)     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L4c
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L12
            int r2 = r3.hf     // Catch: java.lang.Throwable -> L12
            int r0 = r3.w(r1, r0)     // Catch: java.lang.Throwable -> L12
            int r2 = r2 - r0
            r3.hf = r2     // Catch: java.lang.Throwable -> L12
        L4c:
            int r0 = r3.y     // Catch: java.lang.Throwable -> L12
            int r0 = r0 + 1
            r3.y = r0     // Catch: java.lang.Throwable -> L12
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            goto L0
        L54:
            java.lang.String r0 = "LruCache"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            java.lang.String r2 = "oom maybe occured, clear cache. size= "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L12
            int r2 = r3.hf     // Catch: java.lang.Throwable -> L12
            r1.append(r2)     // Catch: java.lang.Throwable -> L12
            java.lang.String r2 = ", maxSize: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L12
            r1.append(r4)     // Catch: java.lang.Throwable -> L12
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L12
            com.bytedance.sdk.component.utils.pl.u(r0, r4)     // Catch: java.lang.Throwable -> L12
            r4 = 0
            r3.hf = r4     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r4 = r3.xj     // Catch: java.lang.Throwable -> L12
            r4.clear()     // Catch: java.lang.Throwable -> L12
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L7b:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.y.w.xj.w.xj(int):void");
    }

    public final void xj() {
        xj(-1);
    }
}
