package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZkASS extends AbstractSet {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f12042AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Map f12043AlLFFp;

    public /* synthetic */ AZkASS(Map map, int i) {
        this.f12042AcNBzu = i;
        this.f12043AlLFFp = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        switch (this.f12042AcNBzu) {
            case 0:
                ((AcNBzu) this.f12043AlLFFp).clear();
                break;
            case 1:
                ((AcNBzu) this.f12043AlLFFp).clear();
                break;
            default:
                super.clear();
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean contains(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r4.f12042AcNBzu
            switch(r0) {
                case 0: goto L13;
                case 1: goto La;
                default: goto L5;
            }
        L5:
            boolean r5 = super.contains(r5)
            return r5
        La:
            java.util.Map r0 = r4.f12043AlLFFp
            com.google.gson.internal.AcNBzu r0 = (com.google.gson.internal.AcNBzu) r0
            boolean r5 = r0.containsKey(r5)
            return r5
        L13:
            boolean r0 = r5 instanceof java.util.Map.Entry
            r1 = 0
            if (r0 == 0) goto L42
            java.util.Map r0 = r4.f12043AlLFFp
            com.google.gson.internal.AcNBzu r0 = (com.google.gson.internal.AcNBzu) r0
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r2 = r5.getKey()
            r3 = 0
            if (r2 == 0) goto L2b
            com.google.gson.internal.AaHO0E r0 = r0.A2egSU(r2, r1)     // Catch: java.lang.ClassCastException -> L2a
            goto L2c
        L2a:
        L2b:
            r0 = r3
        L2c:
            if (r0 == 0) goto L3f
            java.lang.Object r2 = r0.f12050B3GDIM
            java.lang.Object r5 = r5.getValue()
            if (r2 == r5) goto L3e
            if (r2 == 0) goto L3f
            boolean r5 = r2.equals(r5)
            if (r5 == 0) goto L3f
        L3e:
            r3 = r0
        L3f:
            if (r3 == 0) goto L42
            r1 = 1
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.AZkASS.contains(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f12042AcNBzu) {
            case 0:
                return new AZOQYO((AcNBzu) this.f12043AlLFFp, 0);
            case 1:
                return new AZOQYO((AcNBzu) this.f12043AlLFFp, 1);
            default:
                return new B25kr6.A4TApA((B25kr6.ADYaiT) this.f12043AlLFFp);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean remove(java.lang.Object r6) {
        /*
            r5 = this;
            int r0 = r5.f12042AcNBzu
            switch(r0) {
                case 0: goto L22;
                case 1: goto La;
                default: goto L5;
            }
        L5:
            boolean r6 = super.remove(r6)
            return r6
        La:
            java.util.Map r0 = r5.f12043AlLFFp
            com.google.gson.internal.AcNBzu r0 = (com.google.gson.internal.AcNBzu) r0
            r1 = 0
            r2 = 0
            if (r6 == 0) goto L18
            com.google.gson.internal.AaHO0E r2 = r0.A2egSU(r6, r1)     // Catch: java.lang.ClassCastException -> L17
            goto L18
        L17:
        L18:
            r6 = 1
            if (r2 == 0) goto L1e
            r0.A5SV6n(r2, r6)
        L1e:
            if (r2 == 0) goto L21
            r1 = 1
        L21:
            return r1
        L22:
            boolean r0 = r6 instanceof java.util.Map.Entry
            r1 = 0
            if (r0 != 0) goto L28
            goto L56
        L28:
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.util.Map r0 = r5.f12043AlLFFp
            com.google.gson.internal.AcNBzu r0 = (com.google.gson.internal.AcNBzu) r0
            java.lang.Object r2 = r6.getKey()
            r3 = 0
            if (r2 == 0) goto L3b
            com.google.gson.internal.AaHO0E r2 = r0.A2egSU(r2, r1)     // Catch: java.lang.ClassCastException -> L3a
            goto L3c
        L3a:
        L3b:
            r2 = r3
        L3c:
            if (r2 == 0) goto L4f
            java.lang.Object r4 = r2.f12050B3GDIM
            java.lang.Object r6 = r6.getValue()
            if (r4 == r6) goto L4e
            if (r4 == 0) goto L4f
            boolean r6 = r4.equals(r6)
            if (r6 == 0) goto L4f
        L4e:
            r3 = r2
        L4f:
            if (r3 != 0) goto L52
            goto L56
        L52:
            r1 = 1
            r0.A5SV6n(r3, r1)
        L56:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.AZkASS.remove(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f12042AcNBzu) {
            case 0:
                return ((AcNBzu) this.f12043AlLFFp).f12055AmA8tU;
            case 1:
                return ((AcNBzu) this.f12043AlLFFp).f12055AmA8tU;
            default:
                return ((B25kr6.ADYaiT) this.f12043AlLFFp).f1011AmA8tU;
        }
    }
}
