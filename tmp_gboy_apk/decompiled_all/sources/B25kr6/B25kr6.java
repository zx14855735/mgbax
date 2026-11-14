package B25kr6;

import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class B25kr6 implements Cloneable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public /* synthetic */ boolean f1012AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public /* synthetic */ int[] f1013AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public /* synthetic */ Object[] f1014AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public /* synthetic */ int f1015AzWtSf;

    public B25kr6() {
        int i;
        int i2 = 4;
        while (true) {
            i = 40;
            if (i2 >= 32) {
                break;
            }
            int i3 = (1 << i2) - 12;
            if (40 <= i3) {
                i = i3;
                break;
            }
            i2++;
        }
        int i4 = i / 4;
        this.f1013AlLFFp = new int[i4];
        this.f1014AmA8tU = new Object[i4];
    }

    public final void A2egSU(int i, Object obj) {
        int i2 = this.f1015AzWtSf;
        if (i2 != 0 && i <= this.f1013AlLFFp[i2 - 1]) {
            ADYaiT(i, obj);
            return;
        }
        if (this.f1012AcNBzu && i2 >= this.f1013AlLFFp.length) {
            AZOQYO.A2egSU(this);
        }
        int i3 = this.f1015AzWtSf;
        if (i3 >= this.f1013AlLFFp.length) {
            int i4 = (i3 + 1) * 4;
            int i5 = 4;
            while (true) {
                if (i5 >= 32) {
                    break;
                }
                int i6 = (1 << i5) - 12;
                if (i4 <= i6) {
                    i4 = i6;
                    break;
                }
                i5++;
            }
            int i7 = i4 / 4;
            int[] copyOf = Arrays.copyOf(this.f1013AlLFFp, i7);
            RXb0Sz.ARc23Z.ADYaiT(copyOf, "copyOf(...)");
            this.f1013AlLFFp = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f1014AmA8tU, i7);
            RXb0Sz.ARc23Z.ADYaiT(copyOf2, "copyOf(...)");
            this.f1014AmA8tU = copyOf2;
        }
        this.f1013AlLFFp[i3] = i;
        this.f1014AmA8tU[i3] = obj;
        this.f1015AzWtSf = i3 + 1;
    }

    /* renamed from: A4TApA, reason: merged with bridge method [inline-methods] */
    public final B25kr6 clone() {
        Object clone = super.clone();
        RXb0Sz.ARc23Z.A5SV6n(clone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        B25kr6 b25kr6 = (B25kr6) clone;
        b25kr6.f1013AlLFFp = (int[]) this.f1013AlLFFp.clone();
        b25kr6.f1014AmA8tU = (Object[]) this.f1014AmA8tU.clone();
        return b25kr6;
    }

    public final Object A5SV6n(int i) {
        Object obj;
        int A2egSU2 = B2KMhB.A2egSU.A2egSU(this.f1015AzWtSf, i, this.f1013AlLFFp);
        if (A2egSU2 < 0 || (obj = this.f1014AmA8tU[A2egSU2]) == AZOQYO.f993A4TApA) {
            return null;
        }
        return obj;
    }

    public final void ADYaiT(int i, Object obj) {
        int A2egSU2 = B2KMhB.A2egSU.A2egSU(this.f1015AzWtSf, i, this.f1013AlLFFp);
        if (A2egSU2 >= 0) {
            this.f1014AmA8tU[A2egSU2] = obj;
            return;
        }
        int i2 = ~A2egSU2;
        int i3 = this.f1015AzWtSf;
        if (i2 < i3) {
            Object[] objArr = this.f1014AmA8tU;
            if (objArr[i2] == AZOQYO.f993A4TApA) {
                this.f1013AlLFFp[i2] = i;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.f1012AcNBzu && i3 >= this.f1013AlLFFp.length) {
            AZOQYO.A2egSU(this);
            i2 = ~B2KMhB.A2egSU.A2egSU(this.f1015AzWtSf, i, this.f1013AlLFFp);
        }
        int i4 = this.f1015AzWtSf;
        if (i4 >= this.f1013AlLFFp.length) {
            int i5 = (i4 + 1) * 4;
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
            int i8 = i5 / 4;
            int[] copyOf = Arrays.copyOf(this.f1013AlLFFp, i8);
            RXb0Sz.ARc23Z.ADYaiT(copyOf, "copyOf(...)");
            this.f1013AlLFFp = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f1014AmA8tU, i8);
            RXb0Sz.ARc23Z.ADYaiT(copyOf2, "copyOf(...)");
            this.f1014AmA8tU = copyOf2;
        }
        int i9 = this.f1015AzWtSf;
        if (i9 - i2 != 0) {
            int[] iArr = this.f1013AlLFFp;
            int i10 = i2 + 1;
            RD2OKB.AZOQYO.A2egSU(i10, i2, iArr, iArr, i9);
            Object[] objArr2 = this.f1014AmA8tU;
            RD2OKB.AZOQYO.A4TApA(objArr2, objArr2, i10, i2, this.f1015AzWtSf);
        }
        this.f1013AlLFFp[i2] = i;
        this.f1014AmA8tU[i2] = obj;
        this.f1015AzWtSf++;
    }

    public final int AMqCpz() {
        if (this.f1012AcNBzu) {
            AZOQYO.A2egSU(this);
        }
        return this.f1015AzWtSf;
    }

    public final Object ARc23Z(int i) {
        if (this.f1012AcNBzu) {
            AZOQYO.A2egSU(this);
        }
        Object[] objArr = this.f1014AmA8tU;
        if (i < objArr.length) {
            return objArr[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void delete(int i) {
        int A2egSU2 = B2KMhB.A2egSU.A2egSU(this.f1015AzWtSf, i, this.f1013AlLFFp);
        if (A2egSU2 >= 0) {
            Object[] objArr = this.f1014AmA8tU;
            Object obj = objArr[A2egSU2];
            Object obj2 = AZOQYO.f993A4TApA;
            if (obj != obj2) {
                objArr[A2egSU2] = obj2;
                this.f1012AcNBzu = true;
            }
        }
    }

    public final String toString() {
        if (AMqCpz() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1015AzWtSf * 28);
        sb.append('{');
        int i = this.f1015AzWtSf;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            if (this.f1012AcNBzu) {
                AZOQYO.A2egSU(this);
            }
            sb.append(this.f1013AlLFFp[i2]);
            sb.append('=');
            Object ARc23Z2 = ARc23Z(i2);
            if (ARc23Z2 != this) {
                sb.append(ARc23Z2);
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
