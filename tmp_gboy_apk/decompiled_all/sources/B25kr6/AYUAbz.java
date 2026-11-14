package B25kr6;

import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AYUAbz implements Cloneable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public /* synthetic */ boolean f988AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public /* synthetic */ long[] f989AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public /* synthetic */ Object[] f990AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public /* synthetic */ int f991AzWtSf;

    public AYUAbz() {
        int i;
        int i2 = 4;
        while (true) {
            i = 80;
            if (i2 >= 32) {
                break;
            }
            int i3 = (1 << i2) - 12;
            if (80 <= i3) {
                i = i3;
                break;
            }
            i2++;
        }
        int i4 = i / 8;
        this.f989AlLFFp = new long[i4];
        this.f990AmA8tU = new Object[i4];
    }

    public final void A2egSU(long j, Long l) {
        int i = this.f991AzWtSf;
        if (i != 0 && j <= this.f989AlLFFp[i - 1]) {
            AYUAbz(j, l);
            return;
        }
        if (this.f988AcNBzu) {
            long[] jArr = this.f989AlLFFp;
            if (i >= jArr.length) {
                Object[] objArr = this.f990AmA8tU;
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    Object obj = objArr[i3];
                    if (obj != AZOQYO.f992A2egSU) {
                        if (i3 != i2) {
                            jArr[i2] = jArr[i3];
                            objArr[i2] = obj;
                            objArr[i3] = null;
                        }
                        i2++;
                    }
                }
                this.f988AcNBzu = false;
                this.f991AzWtSf = i2;
            }
        }
        int i4 = this.f991AzWtSf;
        if (i4 >= this.f989AlLFFp.length) {
            int i5 = (i4 + 1) * 8;
            int i6 = 4;
            while (true) {
                if (i6 >= 32) {
                    break;
                }
                int i7 = (1 << i6) - 12;
                if (i5 <= i7) {
                    i5 = i7;
                    break;
                }
                i6++;
            }
            int i8 = i5 / 8;
            long[] copyOf = Arrays.copyOf(this.f989AlLFFp, i8);
            RXb0Sz.ARc23Z.ADYaiT(copyOf, "copyOf(...)");
            this.f989AlLFFp = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f990AmA8tU, i8);
            RXb0Sz.ARc23Z.ADYaiT(copyOf2, "copyOf(...)");
            this.f990AmA8tU = copyOf2;
        }
        this.f989AlLFFp[i4] = j;
        this.f990AmA8tU[i4] = l;
        this.f991AzWtSf = i4 + 1;
    }

    public final void A4TApA() {
        int i = this.f991AzWtSf;
        Object[] objArr = this.f990AmA8tU;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f991AzWtSf = 0;
        this.f988AcNBzu = false;
    }

    /* renamed from: A5SV6n, reason: merged with bridge method [inline-methods] */
    public final AYUAbz clone() {
        Object clone = super.clone();
        RXb0Sz.ARc23Z.A5SV6n(clone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        AYUAbz aYUAbz = (AYUAbz) clone;
        aYUAbz.f989AlLFFp = (long[]) this.f989AlLFFp.clone();
        aYUAbz.f990AmA8tU = (Object[]) this.f990AmA8tU.clone();
        return aYUAbz;
    }

    public final Object ADYaiT(long j) {
        Object obj;
        int A4TApA2 = B2KMhB.A2egSU.A4TApA(this.f989AlLFFp, this.f991AzWtSf, j);
        if (A4TApA2 < 0 || (obj = this.f990AmA8tU[A4TApA2]) == AZOQYO.f992A2egSU) {
            return null;
        }
        return obj;
    }

    public final Object AMqCpz(long j) {
        Object obj;
        int A4TApA2 = B2KMhB.A2egSU.A4TApA(this.f989AlLFFp, this.f991AzWtSf, j);
        if (A4TApA2 < 0 || (obj = this.f990AmA8tU[A4TApA2]) == AZOQYO.f992A2egSU) {
            return -1L;
        }
        return obj;
    }

    public final int ARc23Z(long j) {
        if (this.f988AcNBzu) {
            int i = this.f991AzWtSf;
            long[] jArr = this.f989AlLFFp;
            Object[] objArr = this.f990AmA8tU;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != AZOQYO.f992A2egSU) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.f988AcNBzu = false;
            this.f991AzWtSf = i2;
        }
        return B2KMhB.A2egSU.A4TApA(this.f989AlLFFp, this.f991AzWtSf, j);
    }

    public final long ASJ6gh(int i) {
        if (!(i >= 0 && i < this.f991AzWtSf)) {
            B2KMhB.A2egSU.A5SV6n("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        if (this.f988AcNBzu) {
            int i2 = this.f991AzWtSf;
            long[] jArr = this.f989AlLFFp;
            Object[] objArr = this.f990AmA8tU;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != AZOQYO.f992A2egSU) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.f988AcNBzu = false;
            this.f991AzWtSf = i3;
        }
        return this.f989AlLFFp[i];
    }

    public final void AYUAbz(long j, Object obj) {
        int A4TApA2 = B2KMhB.A2egSU.A4TApA(this.f989AlLFFp, this.f991AzWtSf, j);
        if (A4TApA2 >= 0) {
            this.f990AmA8tU[A4TApA2] = obj;
            return;
        }
        int i = ~A4TApA2;
        int i2 = this.f991AzWtSf;
        Object obj2 = AZOQYO.f992A2egSU;
        if (i < i2) {
            Object[] objArr = this.f990AmA8tU;
            if (objArr[i] == obj2) {
                this.f989AlLFFp[i] = j;
                objArr[i] = obj;
                return;
            }
        }
        if (this.f988AcNBzu) {
            long[] jArr = this.f989AlLFFp;
            if (i2 >= jArr.length) {
                Object[] objArr2 = this.f990AmA8tU;
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    Object obj3 = objArr2[i4];
                    if (obj3 != obj2) {
                        if (i4 != i3) {
                            jArr[i3] = jArr[i4];
                            objArr2[i3] = obj3;
                            objArr2[i4] = null;
                        }
                        i3++;
                    }
                }
                this.f988AcNBzu = false;
                this.f991AzWtSf = i3;
                i = ~B2KMhB.A2egSU.A4TApA(this.f989AlLFFp, i3, j);
            }
        }
        int i5 = this.f991AzWtSf;
        if (i5 >= this.f989AlLFFp.length) {
            int i6 = (i5 + 1) * 8;
            int i7 = 4;
            while (true) {
                if (i7 >= 32) {
                    break;
                }
                int i8 = (1 << i7) - 12;
                if (i6 <= i8) {
                    i6 = i8;
                    break;
                }
                i7++;
            }
            int i9 = i6 / 8;
            long[] copyOf = Arrays.copyOf(this.f989AlLFFp, i9);
            RXb0Sz.ARc23Z.ADYaiT(copyOf, "copyOf(...)");
            this.f989AlLFFp = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f990AmA8tU, i9);
            RXb0Sz.ARc23Z.ADYaiT(copyOf2, "copyOf(...)");
            this.f990AmA8tU = copyOf2;
        }
        int i10 = this.f991AzWtSf - i;
        if (i10 != 0) {
            long[] jArr2 = this.f989AlLFFp;
            int i11 = i + 1;
            RXb0Sz.ARc23Z.AMqCpz(jArr2, "<this>");
            System.arraycopy(jArr2, i, jArr2, i11, i10);
            Object[] objArr3 = this.f990AmA8tU;
            RD2OKB.AZOQYO.A4TApA(objArr3, objArr3, i11, i, this.f991AzWtSf);
        }
        this.f989AlLFFp[i] = j;
        this.f990AmA8tU[i] = obj;
        this.f991AzWtSf++;
    }

    public final void AZOQYO(long j) {
        int A4TApA2 = B2KMhB.A2egSU.A4TApA(this.f989AlLFFp, this.f991AzWtSf, j);
        if (A4TApA2 >= 0) {
            Object[] objArr = this.f990AmA8tU;
            Object obj = objArr[A4TApA2];
            Object obj2 = AZOQYO.f992A2egSU;
            if (obj != obj2) {
                objArr[A4TApA2] = obj2;
                this.f988AcNBzu = true;
            }
        }
    }

    public final int AZkASS() {
        if (this.f988AcNBzu) {
            int i = this.f991AzWtSf;
            long[] jArr = this.f989AlLFFp;
            Object[] objArr = this.f990AmA8tU;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != AZOQYO.f992A2egSU) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.f988AcNBzu = false;
            this.f991AzWtSf = i2;
        }
        return this.f991AzWtSf;
    }

    public final Object AaHO0E(int i) {
        if (!(i >= 0 && i < this.f991AzWtSf)) {
            B2KMhB.A2egSU.A5SV6n("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        if (this.f988AcNBzu) {
            int i2 = this.f991AzWtSf;
            long[] jArr = this.f989AlLFFp;
            Object[] objArr = this.f990AmA8tU;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != AZOQYO.f992A2egSU) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.f988AcNBzu = false;
            this.f991AzWtSf = i3;
        }
        return this.f990AmA8tU[i];
    }

    public void delete(long j) {
        int A4TApA2 = B2KMhB.A2egSU.A4TApA(this.f989AlLFFp, this.f991AzWtSf, j);
        if (A4TApA2 >= 0) {
            Object[] objArr = this.f990AmA8tU;
            Object obj = objArr[A4TApA2];
            Object obj2 = AZOQYO.f992A2egSU;
            if (obj != obj2) {
                objArr[A4TApA2] = obj2;
                this.f988AcNBzu = true;
            }
        }
    }

    public final String toString() {
        if (AZkASS() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f991AzWtSf * 28);
        sb.append('{');
        int i = this.f991AzWtSf;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(ASJ6gh(i2));
            sb.append('=');
            Object AaHO0E2 = AaHO0E(i2);
            if (AaHO0E2 != sb) {
                sb.append(AaHO0E2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        RXb0Sz.ARc23Z.ADYaiT(sb2, "toString(...)");
        return sb2;
    }
}
