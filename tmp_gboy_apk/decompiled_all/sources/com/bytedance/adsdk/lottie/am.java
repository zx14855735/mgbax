package com.bytedance.adsdk.lottie;

import java.util.LinkedHashMap;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class am<K, V> {
    private int c;
    private int f;
    private int hf;
    private int kd;
    private int u;
    private int w;
    private final LinkedHashMap<K, V> xj;
    private int y;

    public am(int i) {
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
        try {
            int i2 = this.c;
            int i3 = this.f + i2;
            i = i3 != 0 ? (i2 * 100) / i3 : 0;
            Locale locale = Locale.US;
        } catch (Throwable th) {
            throw th;
        }
        return "LruCache[maxSize=" + this.w + ",hits=" + this.c + ",misses=" + this.f + ",hitRate=" + i + "%]";
    }

    public void xj(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.w = i;
        }
        hf(i);
    }

    public V hf(K k) {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x006f, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void hf(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.hf     // Catch: java.lang.Throwable -> L12
            if (r0 < 0) goto L51
            java.util.LinkedHashMap<K, V> r0 = r3.xj     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            int r0 = r3.hf     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L51
            goto L14
        L12:
            r4 = move-exception
            goto L70
        L14:
            int r0 = r3.hf     // Catch: java.lang.Throwable -> L12
            if (r0 <= r4) goto L4f
            java.util.LinkedHashMap<K, V> r0 = r3.xj     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L21
            goto L4f
        L21:
            java.util.LinkedHashMap<K, V> r0 = r3.xj     // Catch: java.lang.Throwable -> L12
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L12
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L12
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L12
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap<K, V> r2 = r3.xj     // Catch: java.lang.Throwable -> L12
            r2.remove(r1)     // Catch: java.lang.Throwable -> L12
            int r2 = r3.hf     // Catch: java.lang.Throwable -> L12
            int r0 = r3.w(r1, r0)     // Catch: java.lang.Throwable -> L12
            int r2 = r2 - r0
            r3.hf = r2     // Catch: java.lang.Throwable -> L12
            int r0 = r3.y     // Catch: java.lang.Throwable -> L12
            int r0 = r0 + 1
            r3.y = r0     // Catch: java.lang.Throwable -> L12
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            goto L0
        L4f:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L51:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L12
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            r0.<init>()     // Catch: java.lang.Throwable -> L12
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L12
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L12
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L12
            throw r4     // Catch: java.lang.Throwable -> L12
        L70:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.am.hf(int):void");
    }

    public final V xj(K k) {
        V put;
        if (k != null) {
            synchronized (this) {
                try {
                    V v = this.xj.get(k);
                    if (v != null) {
                        this.c++;
                        return v;
                    }
                    this.f++;
                    V hf = hf((am<K, V>) k);
                    if (hf == null) {
                        return null;
                    }
                    synchronized (this) {
                        try {
                            this.kd++;
                            put = this.xj.put(k, hf);
                            if (put != null) {
                                this.xj.put(k, put);
                            } else {
                                this.hf += w(k, hf);
                            }
                        } finally {
                        }
                    }
                    if (put != null) {
                        return put;
                    }
                    hf(this.w);
                    return hf;
                } finally {
                }
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V xj(K k, V v) {
        V put;
        if (k != null && v != null) {
            synchronized (this) {
                try {
                    this.u++;
                    this.hf += w(k, v);
                    put = this.xj.put(k, v);
                    if (put != null) {
                        this.hf -= w(k, put);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            hf(this.w);
            return put;
        }
        throw new NullPointerException("key == null || value == null");
    }
}
