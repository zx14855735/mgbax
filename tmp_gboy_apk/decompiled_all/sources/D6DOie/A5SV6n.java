package D6DOie;

import ADYaiT.CtFAbx;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f1949A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f1950A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final byte[] f1951A5SV6n;

    public A5SV6n(int i, int i2, byte[] bArr, int i3) {
        this.f1949A2egSU = i;
        this.f1950A4TApA = i2;
        this.f1951A5SV6n = bArr;
    }

    public static A5SV6n A2egSU(long j, ByteOrder byteOrder) {
        long[] jArr = {j};
        ByteBuffer wrap = ByteBuffer.wrap(new byte[ARc23Z.f1975BmvVmW[4]]);
        wrap.order(byteOrder);
        wrap.putInt((int) jArr[0]);
        return new A5SV6n(4, 1, wrap.array(), 0);
    }

    public static A5SV6n A4TApA(AMqCpz aMqCpz, ByteOrder byteOrder) {
        AMqCpz[] aMqCpzArr = {aMqCpz};
        ByteBuffer wrap = ByteBuffer.wrap(new byte[ARc23Z.f1975BmvVmW[5]]);
        wrap.order(byteOrder);
        AMqCpz aMqCpz2 = aMqCpzArr[0];
        wrap.putInt((int) aMqCpz2.f1956A2egSU);
        wrap.putInt((int) aMqCpz2.f1957A4TApA);
        return new A5SV6n(5, 1, wrap.array(), 0);
    }

    public static A5SV6n A5SV6n(int i, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[ARc23Z.f1975BmvVmW[3]]);
        wrap.order(byteOrder);
        wrap.putShort((short) new int[]{i}[0]);
        return new A5SV6n(3, 1, wrap.array(), 0);
    }

    public final double ADYaiT(ByteOrder byteOrder) {
        Object ASJ6gh2 = ASJ6gh(byteOrder);
        if (ASJ6gh2 == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
        if (ASJ6gh2 instanceof String) {
            return Double.parseDouble((String) ASJ6gh2);
        }
        if (ASJ6gh2 instanceof long[]) {
            if (((long[]) ASJ6gh2).length == 1) {
                return r5[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (ASJ6gh2 instanceof int[]) {
            if (((int[]) ASJ6gh2).length == 1) {
                return r5[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (ASJ6gh2 instanceof double[]) {
            double[] dArr = (double[]) ASJ6gh2;
            if (dArr.length == 1) {
                return dArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(ASJ6gh2 instanceof AMqCpz[])) {
            throw new NumberFormatException("Couldn't find a double value");
        }
        AMqCpz[] aMqCpzArr = (AMqCpz[]) ASJ6gh2;
        if (aMqCpzArr.length != 1) {
            throw new NumberFormatException("There are more than one component");
        }
        AMqCpz aMqCpz = aMqCpzArr[0];
        return aMqCpz.f1956A2egSU / aMqCpz.f1957A4TApA;
    }

    public final int AMqCpz(ByteOrder byteOrder) {
        Object ASJ6gh2 = ASJ6gh(byteOrder);
        if (ASJ6gh2 == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }
        if (ASJ6gh2 instanceof String) {
            return Integer.parseInt((String) ASJ6gh2);
        }
        if (ASJ6gh2 instanceof long[]) {
            long[] jArr = (long[]) ASJ6gh2;
            if (jArr.length == 1) {
                return (int) jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(ASJ6gh2 instanceof int[])) {
            throw new NumberFormatException("Couldn't find a integer value");
        }
        int[] iArr = (int[]) ASJ6gh2;
        if (iArr.length == 1) {
            return iArr[0];
        }
        throw new NumberFormatException("There are more than one component");
    }

    public final String ARc23Z(ByteOrder byteOrder) {
        Object ASJ6gh2 = ASJ6gh(byteOrder);
        if (ASJ6gh2 == null) {
            return null;
        }
        if (ASJ6gh2 instanceof String) {
            return (String) ASJ6gh2;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (ASJ6gh2 instanceof long[]) {
            long[] jArr = (long[]) ASJ6gh2;
            while (i < jArr.length) {
                sb.append(jArr[i]);
                i++;
                if (i != jArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (ASJ6gh2 instanceof int[]) {
            int[] iArr = (int[]) ASJ6gh2;
            while (i < iArr.length) {
                sb.append(iArr[i]);
                i++;
                if (i != iArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (ASJ6gh2 instanceof double[]) {
            double[] dArr = (double[]) ASJ6gh2;
            while (i < dArr.length) {
                sb.append(dArr[i]);
                i++;
                if (i != dArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (!(ASJ6gh2 instanceof AMqCpz[])) {
            return null;
        }
        AMqCpz[] aMqCpzArr = (AMqCpz[]) ASJ6gh2;
        while (i < aMqCpzArr.length) {
            sb.append(aMqCpzArr[i].f1956A2egSU);
            sb.append('/');
            sb.append(aMqCpzArr[i].f1957A4TApA);
            i++;
            if (i != aMqCpzArr.length) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:83|(2:85|(2:86|(2:88|(2:91|92)(1:90))(2:93|94)))|95|(2:97|(6:106|107|108|109|110|111)(3:99|(2:101|102)(2:104|105)|103))|114|108|109|110|111) */
    /* JADX WARN: Type inference failed for: r13v17, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r13v18, types: [java.io.Serializable, long[]] */
    /* JADX WARN: Type inference failed for: r13v19, types: [D6DOie.AMqCpz[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r13v20, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r13v21, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r13v22, types: [D6DOie.AMqCpz[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r13v23, types: [double[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r13v24, types: [double[], java.io.Serializable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable ASJ6gh(java.nio.ByteOrder r13) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D6DOie.A5SV6n.ASJ6gh(java.nio.ByteOrder):java.io.Serializable");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(ARc23Z.f1974BV3sI0[this.f1949A2egSU]);
        sb.append(", data length:");
        return CtFAbx.AZkASS(")", this.f1951A5SV6n.length, sb);
    }
}
