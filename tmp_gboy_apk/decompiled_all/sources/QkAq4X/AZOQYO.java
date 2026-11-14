package QkAq4X;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class AZOQYO implements Cloneable {

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final Object f7753B25kr6 = new Object();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f7754AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int[] f7755AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Object[] f7756AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f7757AzWtSf;

    static {
        pCsfce();
    }

    public AZOQYO() {
        this(10);
    }

    private static /* synthetic */ void pCsfce() {
        char[] charArray = "?31r;=19r>3%r/4900r\u001625\u001e.58;9".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '\\');
        }
        String str = new String(charArray);
        char[] charArray2 = "?0525(".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '\\');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final Object A2egSU(int i) {
        Object obj;
        int A2egSU2 = ADYaiT.A2egSU(this.f7757AzWtSf, i, this.f7755AlLFFp);
        if (A2egSU2 < 0 || (obj = this.f7756AmA8tU[A2egSU2]) == f7753B25kr6) {
            return null;
        }
        return obj;
    }

    public final int A4TApA() {
        if (this.f7754AcNBzu) {
            ARc23Z();
        }
        return this.f7757AzWtSf;
    }

    public final void A5SV6n(int i, Object obj) {
        int A2egSU2 = ADYaiT.A2egSU(this.f7757AzWtSf, i, this.f7755AlLFFp);
        if (A2egSU2 >= 0) {
            this.f7756AmA8tU[A2egSU2] = obj;
            return;
        }
        int i2 = ~A2egSU2;
        int i3 = this.f7757AzWtSf;
        if (i2 < i3) {
            Object[] objArr = this.f7756AmA8tU;
            if (objArr[i2] == f7753B25kr6) {
                this.f7755AlLFFp[i2] = i;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.f7754AcNBzu && i3 >= this.f7755AlLFFp.length) {
            ARc23Z();
            i2 = ~ADYaiT.A2egSU(this.f7757AzWtSf, i, this.f7755AlLFFp);
        }
        int i4 = this.f7757AzWtSf;
        if (i4 >= this.f7755AlLFFp.length) {
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
            int[] iArr = new int[i8];
            Object[] objArr2 = new Object[i8];
            int[] iArr2 = this.f7755AlLFFp;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f7756AmA8tU;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f7755AlLFFp = iArr;
            this.f7756AmA8tU = objArr2;
        }
        int i9 = this.f7757AzWtSf - i2;
        if (i9 != 0) {
            int[] iArr3 = this.f7755AlLFFp;
            int i10 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i10, i9);
            Object[] objArr4 = this.f7756AmA8tU;
            System.arraycopy(objArr4, i2, objArr4, i10, this.f7757AzWtSf - i2);
        }
        this.f7755AlLFFp[i2] = i;
        this.f7756AmA8tU[i2] = obj;
        this.f7757AzWtSf++;
    }

    public final void ADYaiT(int i) {
        int A2egSU2 = ADYaiT.A2egSU(this.f7757AzWtSf, i, this.f7755AlLFFp);
        if (A2egSU2 >= 0) {
            Object[] objArr = this.f7756AmA8tU;
            Object obj = objArr[A2egSU2];
            Object obj2 = f7753B25kr6;
            if (obj != obj2) {
                objArr[A2egSU2] = obj2;
                this.f7754AcNBzu = true;
            }
        }
    }

    public final int AMqCpz(int i) {
        if (this.f7754AcNBzu) {
            ARc23Z();
        }
        return this.f7755AlLFFp[i];
    }

    public final void ARc23Z() {
        int i = this.f7757AzWtSf;
        int[] iArr = this.f7755AlLFFp;
        Object[] objArr = this.f7756AmA8tU;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f7753B25kr6) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f7754AcNBzu = false;
        this.f7757AzWtSf = i2;
    }

    public final Object ASJ6gh(int i) {
        if (this.f7754AcNBzu) {
            ARc23Z();
        }
        return this.f7756AmA8tU[i];
    }

    public final Object clone() {
        try {
            AZOQYO azoqyo = (AZOQYO) super.clone();
            try {
                azoqyo.f7755AlLFFp = (int[]) this.f7755AlLFFp.clone();
                azoqyo.f7756AmA8tU = (Object[]) this.f7756AmA8tU.clone();
                return azoqyo;
            } catch (CloneNotSupportedException unused) {
                return azoqyo;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    public final String toString() {
        if (A4TApA() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f7757AzWtSf * 28);
        sb.append('{');
        for (int i = 0; i < this.f7757AzWtSf; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(AMqCpz(i));
            sb.append('=');
            Object ASJ6gh2 = ASJ6gh(i);
            if (ASJ6gh2 != this) {
                sb.append(ASJ6gh2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public AZOQYO(int i) {
        this.f7754AcNBzu = false;
        if (i == 0) {
            this.f7755AlLFFp = ADYaiT.f7735A2egSU;
            this.f7756AmA8tU = ADYaiT.f7736A4TApA;
        } else {
            int i2 = i * 4;
            int i3 = 4;
            while (true) {
                if (i3 >= 32) {
                    break;
                }
                int i4 = (1 << i3) - 12;
                if (i2 <= i4) {
                    i2 = i4;
                    break;
                }
                i3++;
            }
            int i5 = i2 / 4;
            this.f7755AlLFFp = new int[i5];
            this.f7756AmA8tU = new Object[i5];
        }
        this.f7757AzWtSf = 0;
    }
}
