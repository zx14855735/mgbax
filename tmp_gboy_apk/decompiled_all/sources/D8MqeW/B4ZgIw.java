package D8MqeW;

import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B4ZgIw {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final AbstractList f2041A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final long f2042A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final RFbdkT.A5SV6n f2043A5SV6n;

    static {
        ACLVjR();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public B4ZgIw(AbstractList abstractList, long j) {
        ArrayList arrayList;
        ArrayList arrayList2;
        char c;
        char c2;
        A4TApA a4TApA;
        List list;
        RXb0Sz.ARc23Z.AMqCpz(abstractList, "features");
        this.f2041A2egSU = abstractList;
        this.f2042A4TApA = j;
        RFbdkT.A5SV6n A4TApA2 = RD2OKB.AZkASS.A4TApA();
        A4TApA a4TApA2 = null;
        if (abstractList.size() <= 0 || ((AYUAbz) abstractList.get(0)).f2018A2egSU.size() != 3) {
            arrayList = null;
            arrayList2 = null;
        } else {
            R8Rbcg.A4TApA ADYaiT2 = ((A4TApA) ((AYUAbz) abstractList.get(0)).f2018A2egSU.get(1)).ADYaiT(0.5f);
            A4TApA a4TApA3 = (A4TApA) ADYaiT2.f7826AcNBzu;
            A4TApA a4TApA4 = (A4TApA) ADYaiT2.f7827AlLFFp;
            arrayList2 = RD2OKB.AaHO0E.ARc23Z(((AYUAbz) abstractList.get(0)).f2018A2egSU.get(0), a4TApA3);
            arrayList = RD2OKB.AaHO0E.ARc23Z(a4TApA4, ((AYUAbz) abstractList.get(0)).f2018A2egSU.get(2));
        }
        int size = abstractList.size();
        if (size >= 0) {
            A4TApA a4TApA5 = null;
            int i = 0;
            while (true) {
                if (i == 0 && arrayList != null) {
                    list = arrayList;
                } else if (i != this.f2041A2egSU.size()) {
                    list = ((AYUAbz) this.f2041A2egSU.get(i)).f2018A2egSU;
                } else {
                    if (arrayList2 == null) {
                        a4TApA = a4TApA2;
                        a4TApA2 = a4TApA5;
                        c = 1;
                        c2 = 3;
                        break;
                    }
                    list = arrayList2;
                }
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    A4TApA a4TApA6 = (A4TApA) list.get(i2);
                    float[] fArr = a4TApA6.f2011A2egSU;
                    boolean z = false;
                    if (Math.abs(fArr[0] - a4TApA6.A2egSU()) < 1.0E-4f && Math.abs(fArr[1] - a4TApA6.A4TApA()) < 1.0E-4f) {
                        z = true;
                    }
                    if (!z) {
                        if (a4TApA5 != null) {
                            A4TApA2.add(a4TApA5);
                        }
                        if (a4TApA2 == null) {
                            a4TApA2 = a4TApA6;
                            a4TApA5 = a4TApA2;
                        } else {
                            a4TApA5 = a4TApA6;
                        }
                    } else if (a4TApA5 != null) {
                        float[] fArr2 = a4TApA5.f2011A2egSU;
                        float[] copyOf = Arrays.copyOf(fArr2, fArr2.length);
                        RXb0Sz.ARc23Z.ADYaiT(copyOf, "copyOf(...)");
                        A4TApA a4TApA7 = new A4TApA(copyOf);
                        copyOf[6] = a4TApA6.A2egSU();
                        copyOf[7] = a4TApA6.A4TApA();
                        a4TApA5 = a4TApA7;
                    }
                }
                c = 1;
                c2 = 3;
                if (i == size) {
                    a4TApA = a4TApA2;
                    a4TApA2 = a4TApA5;
                    break;
                }
                i++;
            }
        } else {
            c = 1;
            c2 = 3;
            a4TApA = null;
        }
        if (a4TApA2 == null || a4TApA == null) {
            A4TApA2.add(NOd7IU.AlLFFp.A2egSU(JrXYwF.A4TApA.COJEAR(this.f2042A4TApA), JrXYwF.A4TApA.CQhlFr(this.f2042A4TApA), JrXYwF.A4TApA.COJEAR(this.f2042A4TApA), JrXYwF.A4TApA.CQhlFr(this.f2042A4TApA), JrXYwF.A4TApA.COJEAR(this.f2042A4TApA), JrXYwF.A4TApA.CQhlFr(this.f2042A4TApA), JrXYwF.A4TApA.COJEAR(this.f2042A4TApA), JrXYwF.A4TApA.CQhlFr(this.f2042A4TApA)));
        } else {
            float[] fArr3 = a4TApA2.f2011A2egSU;
            float f = fArr3[0];
            float f2 = fArr3[c];
            float f3 = fArr3[2];
            float f4 = fArr3[c2];
            float f5 = fArr3[4];
            float f6 = fArr3[5];
            float[] fArr4 = a4TApA.f2011A2egSU;
            A4TApA2.add(NOd7IU.AlLFFp.A2egSU(f, f2, f3, f4, f5, f6, fArr4[0], fArr4[c]));
        }
        RFbdkT.A5SV6n A2egSU2 = RD2OKB.AZkASS.A2egSU(A4TApA2);
        this.f2043A5SV6n = A2egSU2;
        Object obj = A2egSU2.get(A2egSU2.A2egSU() - 1);
        int size3 = A2egSU2.size();
        int i3 = 0;
        while (i3 < size3) {
            A4TApA a4TApA8 = (A4TApA) this.f2043A5SV6n.get(i3);
            A4TApA a4TApA9 = (A4TApA) obj;
            if (Math.abs(a4TApA8.f2011A2egSU[0] - a4TApA9.A2egSU()) > 1.0E-4f || Math.abs(a4TApA8.f2011A2egSU[c] - a4TApA9.A4TApA()) > 1.0E-4f) {
                throw new IllegalArgumentException("RoundedPolygon must be contiguous, with the anchor points of all curves matching the anchor points of the preceding and succeeding cubics");
            }
            i3++;
            obj = a4TApA8;
        }
    }

    private static /* synthetic */ void ACLVjR() {
        char[] charArray = ")%'d-+'/d(%3d9\"/&&d\u0000$#\b8#.-/".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'J');
        }
        String str = new String(charArray);
        char[] charArray2 = ")&#$#>".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'J');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B4ZgIw)) {
            return false;
        }
        return RXb0Sz.ARc23Z.A2egSU(this.f2041A2egSU, ((B4ZgIw) obj).f2041A2egSU);
    }

    public final int hashCode() {
        return this.f2041A2egSU.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[RoundedPolygon. Cubics = ");
        sb.append(RD2OKB.B4ZgIw.AaHO0E(this.f2043A5SV6n, null, 63));
        sb.append(" || Features = ");
        sb.append(RD2OKB.B4ZgIw.AaHO0E(this.f2041A2egSU, null, 63));
        sb.append(" || Center = (");
        long j = this.f2042A4TApA;
        sb.append(JrXYwF.A4TApA.COJEAR(j));
        sb.append(", ");
        sb.append(JrXYwF.A4TApA.CQhlFr(j));
        sb.append(")]");
        return sb.toString();
    }
}
