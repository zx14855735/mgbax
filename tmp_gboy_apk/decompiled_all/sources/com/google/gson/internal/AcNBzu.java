package com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AcNBzu extends AbstractMap implements Serializable {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final B4ZgIw.ARc23Z f12052B4ZgIw = new B4ZgIw.ARc23Z(17);

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Comparator f12053AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public AaHO0E f12054AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f12055AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f12056AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final AaHO0E f12057B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public AZkASS f12058B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public AZkASS f12059B3GDIM;

    static {
        nabyUR();
    }

    public AcNBzu() {
        B4ZgIw.ARc23Z aRc23Z = f12052B4ZgIw;
        this.f12055AmA8tU = 0;
        this.f12056AzWtSf = 0;
        this.f12057B25kr6 = new AaHO0E();
        this.f12053AcNBzu = aRc23Z;
    }

    private static /* synthetic */ void nabyUR() {
        char[] charArray = "\u0082\u008e\u008cÏ\u0086\u0080\u008c\u0084Ï\u0083\u008e\u0098Ï\u0092\u0089\u0084\u008d\u008dÏ«\u008f\u0088£\u0093\u0088\u0085\u0086\u0084".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 225);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0082\u008d\u0088\u008f\u0088\u0095".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 225);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final AaHO0E A2egSU(Object obj, boolean z) {
        int i;
        AaHO0E aaHO0E;
        AaHO0E aaHO0E2 = this.f12054AlLFFp;
        B4ZgIw.ARc23Z aRc23Z = f12052B4ZgIw;
        Comparator comparator = this.f12053AcNBzu;
        if (aaHO0E2 != null) {
            Comparable comparable = comparator == aRc23Z ? (Comparable) obj : null;
            while (true) {
                Object obj2 = aaHO0E2.f12049B2KMhB;
                i = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (i == 0) {
                    return aaHO0E2;
                }
                AaHO0E aaHO0E3 = i < 0 ? aaHO0E2.f12045AlLFFp : aaHO0E2.f12046AmA8tU;
                if (aaHO0E3 == null) {
                    break;
                }
                aaHO0E2 = aaHO0E3;
            }
        } else {
            i = 0;
        }
        if (!z) {
            return null;
        }
        AaHO0E aaHO0E4 = this.f12057B25kr6;
        if (aaHO0E2 != null) {
            aaHO0E = new AaHO0E(aaHO0E2, obj, aaHO0E4, aaHO0E4.f12048B25kr6);
            if (i < 0) {
                aaHO0E2.f12045AlLFFp = aaHO0E;
            } else {
                aaHO0E2.f12046AmA8tU = aaHO0E;
            }
            A4TApA(aaHO0E2, true);
        } else {
            if (comparator == aRc23Z && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            aaHO0E = new AaHO0E(aaHO0E2, obj, aaHO0E4, aaHO0E4.f12048B25kr6);
            this.f12054AlLFFp = aaHO0E;
        }
        this.f12055AmA8tU++;
        this.f12056AzWtSf++;
        return aaHO0E;
    }

    public final void A4TApA(AaHO0E aaHO0E, boolean z) {
        while (aaHO0E != null) {
            AaHO0E aaHO0E2 = aaHO0E.f12045AlLFFp;
            AaHO0E aaHO0E3 = aaHO0E.f12046AmA8tU;
            int i = aaHO0E2 != null ? aaHO0E2.f12051B4ZgIw : 0;
            int i2 = aaHO0E3 != null ? aaHO0E3.f12051B4ZgIw : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                AaHO0E aaHO0E4 = aaHO0E3.f12045AlLFFp;
                AaHO0E aaHO0E5 = aaHO0E3.f12046AmA8tU;
                int i4 = (aaHO0E4 != null ? aaHO0E4.f12051B4ZgIw : 0) - (aaHO0E5 != null ? aaHO0E5.f12051B4ZgIw : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    AMqCpz(aaHO0E);
                } else {
                    ARc23Z(aaHO0E3);
                    AMqCpz(aaHO0E);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                AaHO0E aaHO0E6 = aaHO0E2.f12045AlLFFp;
                AaHO0E aaHO0E7 = aaHO0E2.f12046AmA8tU;
                int i5 = (aaHO0E6 != null ? aaHO0E6.f12051B4ZgIw : 0) - (aaHO0E7 != null ? aaHO0E7.f12051B4ZgIw : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    ARc23Z(aaHO0E);
                } else {
                    AMqCpz(aaHO0E2);
                    ARc23Z(aaHO0E);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                aaHO0E.f12051B4ZgIw = i + 1;
                if (z) {
                    return;
                }
            } else {
                aaHO0E.f12051B4ZgIw = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            aaHO0E = aaHO0E.f12044AcNBzu;
        }
    }

    public final void A5SV6n(AaHO0E aaHO0E, boolean z) {
        AaHO0E aaHO0E2;
        AaHO0E aaHO0E3;
        int i;
        if (z) {
            AaHO0E aaHO0E4 = aaHO0E.f12048B25kr6;
            aaHO0E4.f12047AzWtSf = aaHO0E.f12047AzWtSf;
            aaHO0E.f12047AzWtSf.f12048B25kr6 = aaHO0E4;
        }
        AaHO0E aaHO0E5 = aaHO0E.f12045AlLFFp;
        AaHO0E aaHO0E6 = aaHO0E.f12046AmA8tU;
        AaHO0E aaHO0E7 = aaHO0E.f12044AcNBzu;
        int i2 = 0;
        if (aaHO0E5 == null || aaHO0E6 == null) {
            if (aaHO0E5 != null) {
                ADYaiT(aaHO0E, aaHO0E5);
                aaHO0E.f12045AlLFFp = null;
            } else if (aaHO0E6 != null) {
                ADYaiT(aaHO0E, aaHO0E6);
                aaHO0E.f12046AmA8tU = null;
            } else {
                ADYaiT(aaHO0E, null);
            }
            A4TApA(aaHO0E7, false);
            this.f12055AmA8tU--;
            this.f12056AzWtSf++;
            return;
        }
        if (aaHO0E5.f12051B4ZgIw > aaHO0E6.f12051B4ZgIw) {
            AaHO0E aaHO0E8 = aaHO0E5.f12046AmA8tU;
            while (true) {
                AaHO0E aaHO0E9 = aaHO0E8;
                aaHO0E3 = aaHO0E5;
                aaHO0E5 = aaHO0E9;
                if (aaHO0E5 == null) {
                    break;
                } else {
                    aaHO0E8 = aaHO0E5.f12046AmA8tU;
                }
            }
        } else {
            AaHO0E aaHO0E10 = aaHO0E6.f12045AlLFFp;
            while (true) {
                aaHO0E2 = aaHO0E6;
                aaHO0E6 = aaHO0E10;
                if (aaHO0E6 == null) {
                    break;
                } else {
                    aaHO0E10 = aaHO0E6.f12045AlLFFp;
                }
            }
            aaHO0E3 = aaHO0E2;
        }
        A5SV6n(aaHO0E3, false);
        AaHO0E aaHO0E11 = aaHO0E.f12045AlLFFp;
        if (aaHO0E11 != null) {
            i = aaHO0E11.f12051B4ZgIw;
            aaHO0E3.f12045AlLFFp = aaHO0E11;
            aaHO0E11.f12044AcNBzu = aaHO0E3;
            aaHO0E.f12045AlLFFp = null;
        } else {
            i = 0;
        }
        AaHO0E aaHO0E12 = aaHO0E.f12046AmA8tU;
        if (aaHO0E12 != null) {
            i2 = aaHO0E12.f12051B4ZgIw;
            aaHO0E3.f12046AmA8tU = aaHO0E12;
            aaHO0E12.f12044AcNBzu = aaHO0E3;
            aaHO0E.f12046AmA8tU = null;
        }
        aaHO0E3.f12051B4ZgIw = Math.max(i, i2) + 1;
        ADYaiT(aaHO0E, aaHO0E3);
    }

    public final void ADYaiT(AaHO0E aaHO0E, AaHO0E aaHO0E2) {
        AaHO0E aaHO0E3 = aaHO0E.f12044AcNBzu;
        aaHO0E.f12044AcNBzu = null;
        if (aaHO0E2 != null) {
            aaHO0E2.f12044AcNBzu = aaHO0E3;
        }
        if (aaHO0E3 == null) {
            this.f12054AlLFFp = aaHO0E2;
        } else if (aaHO0E3.f12045AlLFFp == aaHO0E) {
            aaHO0E3.f12045AlLFFp = aaHO0E2;
        } else {
            aaHO0E3.f12046AmA8tU = aaHO0E2;
        }
    }

    public final void AMqCpz(AaHO0E aaHO0E) {
        AaHO0E aaHO0E2 = aaHO0E.f12045AlLFFp;
        AaHO0E aaHO0E3 = aaHO0E.f12046AmA8tU;
        AaHO0E aaHO0E4 = aaHO0E3.f12045AlLFFp;
        AaHO0E aaHO0E5 = aaHO0E3.f12046AmA8tU;
        aaHO0E.f12046AmA8tU = aaHO0E4;
        if (aaHO0E4 != null) {
            aaHO0E4.f12044AcNBzu = aaHO0E;
        }
        ADYaiT(aaHO0E, aaHO0E3);
        aaHO0E3.f12045AlLFFp = aaHO0E;
        aaHO0E.f12044AcNBzu = aaHO0E3;
        int max = Math.max(aaHO0E2 != null ? aaHO0E2.f12051B4ZgIw : 0, aaHO0E4 != null ? aaHO0E4.f12051B4ZgIw : 0) + 1;
        aaHO0E.f12051B4ZgIw = max;
        aaHO0E3.f12051B4ZgIw = Math.max(max, aaHO0E5 != null ? aaHO0E5.f12051B4ZgIw : 0) + 1;
    }

    public final void ARc23Z(AaHO0E aaHO0E) {
        AaHO0E aaHO0E2 = aaHO0E.f12045AlLFFp;
        AaHO0E aaHO0E3 = aaHO0E.f12046AmA8tU;
        AaHO0E aaHO0E4 = aaHO0E2.f12045AlLFFp;
        AaHO0E aaHO0E5 = aaHO0E2.f12046AmA8tU;
        aaHO0E.f12045AlLFFp = aaHO0E5;
        if (aaHO0E5 != null) {
            aaHO0E5.f12044AcNBzu = aaHO0E;
        }
        ADYaiT(aaHO0E, aaHO0E2);
        aaHO0E2.f12046AmA8tU = aaHO0E;
        aaHO0E.f12044AcNBzu = aaHO0E2;
        int max = Math.max(aaHO0E3 != null ? aaHO0E3.f12051B4ZgIw : 0, aaHO0E5 != null ? aaHO0E5.f12051B4ZgIw : 0) + 1;
        aaHO0E.f12051B4ZgIw = max;
        aaHO0E2.f12051B4ZgIw = Math.max(max, aaHO0E4 != null ? aaHO0E4.f12051B4ZgIw : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f12054AlLFFp = null;
        this.f12055AmA8tU = 0;
        this.f12056AzWtSf++;
        AaHO0E aaHO0E = this.f12057B25kr6;
        aaHO0E.f12048B25kr6 = aaHO0E;
        aaHO0E.f12047AzWtSf = aaHO0E;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        AaHO0E aaHO0E = null;
        if (obj != null) {
            try {
                aaHO0E = A2egSU(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return aaHO0E != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        AZkASS aZkASS = this.f12058B2KMhB;
        if (aZkASS != null) {
            return aZkASS;
        }
        AZkASS aZkASS2 = new AZkASS(this, 0);
        this.f12058B2KMhB = aZkASS2;
        return aZkASS2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000d  */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto La
            r1 = 0
            com.google.gson.internal.AaHO0E r3 = r2.A2egSU(r3, r1)     // Catch: java.lang.ClassCastException -> L9
            goto Lb
        L9:
        La:
            r3 = r0
        Lb:
            if (r3 == 0) goto L10
            java.lang.Object r3 = r3.f12050B3GDIM
            return r3
        L10:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.AcNBzu.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        AZkASS aZkASS = this.f12059B3GDIM;
        if (aZkASS != null) {
            return aZkASS;
        }
        AZkASS aZkASS2 = new AZkASS(this, 1);
        this.f12059B3GDIM = aZkASS2;
        return aZkASS2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        AaHO0E A2egSU2 = A2egSU(obj, true);
        Object obj3 = A2egSU2.f12050B3GDIM;
        A2egSU2.f12050B3GDIM = obj2;
        return obj3;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0016 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object remove(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto La
            r1 = 0
            com.google.gson.internal.AaHO0E r3 = r2.A2egSU(r3, r1)     // Catch: java.lang.ClassCastException -> L9
            goto Lb
        L9:
        La:
            r3 = r0
        Lb:
            if (r3 == 0) goto L11
            r1 = 1
            r2.A5SV6n(r3, r1)
        L11:
            if (r3 == 0) goto L16
            java.lang.Object r3 = r3.f12050B3GDIM
            return r3
        L16:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.AcNBzu.remove(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f12055AmA8tU;
    }
}
