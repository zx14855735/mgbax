package AlLFFp;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ARc23Z implements Iterable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public A5SV6n f953AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public A5SV6n f954AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final WeakHashMap f955AmA8tU = new WeakHashMap();

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f956AzWtSf = 0;

    public static abstract class A2egSU {
        public abstract void A2egSU(A5SV6n a5SV6n);
    }

    public A5SV6n A2egSU(Object obj) {
        A5SV6n a5SV6n = this.f953AcNBzu;
        while (a5SV6n != null && !a5SV6n.f944AcNBzu.equals(obj)) {
            a5SV6n = a5SV6n.f946AmA8tU;
        }
        return a5SV6n;
    }

    public Object A4TApA(Object obj) {
        A5SV6n A2egSU2 = A2egSU(obj);
        if (A2egSU2 == null) {
            return null;
        }
        this.f956AzWtSf--;
        WeakHashMap weakHashMap = this.f955AmA8tU;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((A2egSU) it.next()).A2egSU(A2egSU2);
            }
        }
        A5SV6n a5SV6n = A2egSU2.f947AzWtSf;
        if (a5SV6n != null) {
            a5SV6n.f946AmA8tU = A2egSU2.f946AmA8tU;
        } else {
            this.f953AcNBzu = A2egSU2.f946AmA8tU;
        }
        A5SV6n a5SV6n2 = A2egSU2.f946AmA8tU;
        if (a5SV6n2 != null) {
            a5SV6n2.f947AzWtSf = a5SV6n;
        } else {
            this.f954AlLFFp = a5SV6n;
        }
        A2egSU2.f946AmA8tU = null;
        A2egSU2.f947AzWtSf = null;
        return A2egSU2.f945AlLFFp;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        if (((AlLFFp.AMqCpz) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0053, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof AlLFFp.ARc23Z
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            AlLFFp.ARc23Z r7 = (AlLFFp.ARc23Z) r7
            int r1 = r6.f956AzWtSf
            int r3 = r7.f956AzWtSf
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            AlLFFp.AMqCpz r3 = (AlLFFp.AMqCpz) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            AlLFFp.AMqCpz r4 = (AlLFFp.AMqCpz) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            AlLFFp.AMqCpz r7 = (AlLFFp.AMqCpz) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            return r0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: AlLFFp.ARc23Z.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (true) {
            AMqCpz aMqCpz = (AMqCpz) it;
            if (!aMqCpz.hasNext()) {
                return i;
            }
            i += ((Map.Entry) aMqCpz.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        A4TApA a4TApA = new A4TApA(this.f953AcNBzu, this.f954AlLFFp, 0);
        this.f955AmA8tU.put(a4TApA, Boolean.FALSE);
        return a4TApA;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            AMqCpz aMqCpz = (AMqCpz) it;
            if (!aMqCpz.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) aMqCpz.next()).toString());
            if (aMqCpz.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
