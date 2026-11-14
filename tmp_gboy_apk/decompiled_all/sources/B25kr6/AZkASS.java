package B25kr6;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AZkASS {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f994A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final B2KMhB.A5SV6n f995A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final B2KMhB.A4TApA f996A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f997ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f998ARc23Z;

    public AZkASS(int i) {
        this.f994A2egSU = i;
        if (i <= 0) {
            B2KMhB.A2egSU.A5SV6n("maxSize <= 0");
            throw null;
        }
        this.f995A4TApA = new B2KMhB.A5SV6n(0);
        this.f996A5SV6n = new B2KMhB.A4TApA();
    }

    public final Object A2egSU(Object obj) {
        RXb0Sz.ARc23Z.AMqCpz(obj, "key");
        synchronized (this.f996A5SV6n) {
            B2KMhB.A5SV6n a5SV6n = this.f995A4TApA;
            a5SV6n.getClass();
            Object obj2 = a5SV6n.f1018A2egSU.get(obj);
            if (obj2 != null) {
                this.AMqCpz++;
                return obj2;
            }
            this.f998ARc23Z++;
            return null;
        }
    }

    public final Object A4TApA(Object obj, Object obj2) {
        Object put;
        RXb0Sz.ARc23Z.AMqCpz(obj, "key");
        RXb0Sz.ARc23Z.AMqCpz(obj2, "value");
        synchronized (this.f996A5SV6n) {
            this.f997ADYaiT++;
            B2KMhB.A5SV6n a5SV6n = this.f995A4TApA;
            a5SV6n.getClass();
            put = a5SV6n.f1018A2egSU.put(obj, obj2);
            if (put != null) {
                this.f997ADYaiT--;
            }
        }
        A5SV6n(this.f994A2egSU);
        return put;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020 A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0013, B:13:0x0020, B:15:0x0024, B:17:0x002f, B:19:0x0041, B:22:0x005e, B:24:0x0064, B:30:0x004a, B:31:0x004f, B:34:0x005a, B:41:0x008a, B:42:0x0091), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A5SV6n(int r7) {
        /*
            r6 = this;
        L0:
            B2KMhB.A4TApA r0 = r6.f996A5SV6n
            monitor-enter(r0)
            int r1 = r6.f997ADYaiT     // Catch: java.lang.Throwable -> L18
            r2 = 0
            r3 = 1
            if (r1 < 0) goto L1d
            B2KMhB.A5SV6n r1 = r6.f995A4TApA     // Catch: java.lang.Throwable -> L18
            java.util.LinkedHashMap r1 = r1.f1018A2egSU     // Catch: java.lang.Throwable -> L18
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L18
            if (r1 == 0) goto L1b
            int r1 = r6.f997ADYaiT     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L1d
            goto L1b
        L18:
            r7 = move-exception
            goto L92
        L1b:
            r1 = 1
            goto L1e
        L1d:
            r1 = 0
        L1e:
            if (r1 == 0) goto L8a
            int r1 = r6.f997ADYaiT     // Catch: java.lang.Throwable -> L18
            if (r1 <= r7) goto L88
            B2KMhB.A5SV6n r1 = r6.f995A4TApA     // Catch: java.lang.Throwable -> L18
            java.util.LinkedHashMap r1 = r1.f1018A2egSU     // Catch: java.lang.Throwable -> L18
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L18
            if (r1 == 0) goto L2f
            goto L88
        L2f:
            B2KMhB.A5SV6n r1 = r6.f995A4TApA     // Catch: java.lang.Throwable -> L18
            java.util.LinkedHashMap r1 = r1.f1018A2egSU     // Catch: java.lang.Throwable -> L18
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = "<get-entries>(...)"
            RXb0Sz.ARc23Z.ADYaiT(r1, r4)     // Catch: java.lang.Throwable -> L18
            boolean r4 = r1 instanceof java.util.List     // Catch: java.lang.Throwable -> L18
            r5 = 0
            if (r4 == 0) goto L4f
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L18
            boolean r4 = r1.isEmpty()     // Catch: java.lang.Throwable -> L18
            if (r4 == 0) goto L4a
            goto L5e
        L4a:
            java.lang.Object r5 = r1.get(r2)     // Catch: java.lang.Throwable -> L18
            goto L5e
        L4f:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L18
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L18
            if (r2 != 0) goto L5a
            goto L5e
        L5a:
            java.lang.Object r5 = r1.next()     // Catch: java.lang.Throwable -> L18
        L5e:
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Throwable -> L18
            if (r5 != 0) goto L64
            monitor-exit(r0)
            return
        L64:
            java.lang.Object r1 = r5.getKey()     // Catch: java.lang.Throwable -> L18
            java.lang.Object r2 = r5.getValue()     // Catch: java.lang.Throwable -> L18
            B2KMhB.A5SV6n r4 = r6.f995A4TApA     // Catch: java.lang.Throwable -> L18
            r4.getClass()     // Catch: java.lang.Throwable -> L18
            java.lang.String r5 = "key"
            RXb0Sz.ARc23Z.AMqCpz(r1, r5)     // Catch: java.lang.Throwable -> L18
            java.util.LinkedHashMap r4 = r4.f1018A2egSU     // Catch: java.lang.Throwable -> L18
            r4.remove(r1)     // Catch: java.lang.Throwable -> L18
            int r1 = r6.f997ADYaiT     // Catch: java.lang.Throwable -> L18
            java.lang.String r4 = "value"
            RXb0Sz.ARc23Z.AMqCpz(r2, r4)     // Catch: java.lang.Throwable -> L18
            int r1 = r1 - r3
            r6.f997ADYaiT = r1     // Catch: java.lang.Throwable -> L18
            monitor-exit(r0)
            goto L0
        L88:
            monitor-exit(r0)
            return
        L8a:
            java.lang.String r7 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L18
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L18
            throw r1     // Catch: java.lang.Throwable -> L18
        L92:
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: B25kr6.AZkASS.A5SV6n(int):void");
    }

    public final String toString() {
        String str;
        synchronized (this.f996A5SV6n) {
            try {
                int i = this.AMqCpz;
                int i2 = this.f998ARc23Z + i;
                str = "LruCache[maxSize=" + this.f994A2egSU + ",hits=" + this.AMqCpz + ",misses=" + this.f998ARc23Z + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
