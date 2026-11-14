package DUi7mC;

import ADYaiT.BmvVmW;
import ADYaiT.CtFAbx;
import android.content.pm.PackageInfo;
import com.sigmob.sdk.archives.tar.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final BmvVmW f2171A2egSU = new BmvVmW(11);

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final byte[] f2172A4TApA = {112, 114, 111, 0};

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final byte[] f2173A5SV6n = {112, 114, 109, 0};

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final byte[] f2174ADYaiT = {e.H, e.I, e.M, 0};
    public static final byte[] AMqCpz = {e.H, e.I, e.H, 0};

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final byte[] f2175ARc23Z = {e.H, e.H, 57, 0};

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final byte[] f2176ASJ6gh = {e.H, e.H, e.M, 0};

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static final byte[] f2177AYUAbz = {e.H, e.H, e.I, 0};

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static final byte[] f2178AZOQYO = {e.H, e.H, e.I, 0};

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final byte[] f2179AZkASS = {e.H, e.H, e.J, 0};

    public static byte[] A2egSU(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    public static byte[] A4TApA(A5SV6n[] a5SV6nArr, byte[] bArr) {
        int i = 0;
        for (A5SV6n a5SV6n : a5SV6nArr) {
            i += ((((a5SV6n.f2168ASJ6gh * 2) + 7) & (-8)) / 8) + (a5SV6n.AMqCpz * 2) + ADYaiT(a5SV6n.f2163A2egSU, a5SV6n.f2164A4TApA, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + a5SV6n.f2167ARc23Z;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
        if (Arrays.equals(bArr, f2175ARc23Z)) {
            for (A5SV6n a5SV6n2 : a5SV6nArr) {
                B25kr6(byteArrayOutputStream, a5SV6n2, ADYaiT(a5SV6n2.f2163A2egSU, a5SV6n2.f2164A4TApA, bArr));
                B3GDIM(byteArrayOutputStream, a5SV6n2);
                int[] iArr = a5SV6n2.f2169AYUAbz;
                int length = iArr.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = iArr[i2];
                    B9tovu(byteArrayOutputStream, i4 - i3);
                    i2++;
                    i3 = i4;
                }
                B2KMhB(byteArrayOutputStream, a5SV6n2);
            }
        } else {
            for (A5SV6n a5SV6n3 : a5SV6nArr) {
                B25kr6(byteArrayOutputStream, a5SV6n3, ADYaiT(a5SV6n3.f2163A2egSU, a5SV6n3.f2164A4TApA, bArr));
            }
            for (A5SV6n a5SV6n4 : a5SV6nArr) {
                B3GDIM(byteArrayOutputStream, a5SV6n4);
                int[] iArr2 = a5SV6n4.f2169AYUAbz;
                int length2 = iArr2.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < length2) {
                    int i7 = iArr2[i5];
                    B9tovu(byteArrayOutputStream, i7 - i6);
                    i5++;
                    i6 = i7;
                }
                B2KMhB(byteArrayOutputStream, a5SV6n4);
            }
        }
        if (byteArrayOutputStream.size() == i) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i);
    }

    public static boolean A5SV6n(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file2 : listFiles) {
            z = A5SV6n(file2) && z;
        }
        return z;
    }

    public static String ADYaiT(String str, String str2, byte[] bArr) {
        byte[] bArr2 = f2177AYUAbz;
        boolean equals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = f2176ASJ6gh;
        String str3 = (equals || Arrays.equals(bArr, bArr3)) ? ":" : "!";
        if (str.length() <= 0) {
            if ("!".equals(str3)) {
                return str2.replace(":", "!");
            }
            if (":".equals(str3)) {
                return str2.replace("!", ":");
            }
        } else {
            if (str2.equals("classes.dex")) {
                return str;
            }
            if (str2.contains("!") || str2.contains(":")) {
                if ("!".equals(str3)) {
                    return str2.replace(":", "!");
                }
                if (":".equals(str3)) {
                    return str2.replace("!", ":");
                }
            } else if (!str2.endsWith(".apk")) {
                return CtFAbx.B25kr6(B4ZgIw.AYUAbz.A4TApA(str), (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) ? ":" : "!", str2);
            }
        }
        return str2;
    }

    public static void AMqCpz(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    public static byte[] ARc23Z(InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read < 0) {
                throw new IllegalStateException(CtFAbx.ARc23Z(i, "Not enough bytes to read: "));
            }
            i2 += read;
        }
        return bArr;
    }

    public static int[] ASJ6gh(ByteArrayInputStream byteArrayInputStream, int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += (int) AlLFFp(byteArrayInputStream, 2);
            iArr[i3] = i2;
        }
        return iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        if (r0.finished() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
    
        throw new java.lang.IllegalStateException("Inflater did not finish");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] AYUAbz(java.io.FileInputStream r8, int r9, int r10) {
        /*
            java.util.zip.Inflater r0 = new java.util.zip.Inflater
            r0.<init>()
            byte[] r1 = new byte[r10]     // Catch: java.lang.Throwable -> L2e
            r2 = 2048(0x800, float:2.87E-42)
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L2e
            r3 = 0
            r4 = 0
            r5 = 0
        Le:
            boolean r6 = r0.finished()     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto L57
            boolean r6 = r0.needsDictionary()     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto L57
            if (r4 >= r9) goto L57
            int r6 = r8.read(r2)     // Catch: java.lang.Throwable -> L2e
            if (r6 < 0) goto L3b
            r0.setInput(r2, r3, r6)     // Catch: java.lang.Throwable -> L2e
            int r7 = r10 - r5
            int r7 = r0.inflate(r1, r5, r7)     // Catch: java.lang.Throwable -> L2e java.util.zip.DataFormatException -> L30
            int r5 = r5 + r7
            int r4 = r4 + r6
            goto Le
        L2e:
            r8 = move-exception
            goto L8a
        L30:
            r8 = move-exception
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L2e
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L3b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r8.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r10 = "Invalid zip data. Stream ended after $totalBytesRead bytes. Expected "
            r8.append(r10)     // Catch: java.lang.Throwable -> L2e
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r9 = " bytes"
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L2e
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L57:
            if (r4 != r9) goto L6b
            boolean r8 = r0.finished()     // Catch: java.lang.Throwable -> L2e
            if (r8 == 0) goto L63
            r0.end()
            return r1
        L63:
            java.lang.String r8 = "Inflater did not finish"
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L6b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r8.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r10 = "Didn't read enough bytes during decompression. expected="
            r8.append(r10)     // Catch: java.lang.Throwable -> L2e
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r9 = " actual="
            r8.append(r9)     // Catch: java.lang.Throwable -> L2e
            r8.append(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L2e
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2e
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2e
            throw r9     // Catch: java.lang.Throwable -> L2e
        L8a:
            r0.end()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: DUi7mC.ARc23Z.AYUAbz(java.io.FileInputStream, int, int):byte[]");
    }

    public static A5SV6n[] AZOQYO(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, A5SV6n[] a5SV6nArr) {
        byte[] bArr3 = f2178AZOQYO;
        if (!Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(bArr, f2179AZkASS)) {
                throw new IllegalStateException("Unsupported meta version");
            }
            int AlLFFp2 = (int) AlLFFp(fileInputStream, 2);
            byte[] AYUAbz2 = AYUAbz(fileInputStream, (int) AlLFFp(fileInputStream, 4), (int) AlLFFp(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                throw new IllegalStateException("Content found after the end of file");
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(AYUAbz2);
            try {
                A5SV6n[] AaHO0E2 = AaHO0E(byteArrayInputStream, bArr2, AlLFFp2, a5SV6nArr);
                byteArrayInputStream.close();
                return AaHO0E2;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (Arrays.equals(f2174ADYaiT, bArr2)) {
            throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (!Arrays.equals(bArr, bArr3)) {
            throw new IllegalStateException("Unsupported meta version");
        }
        int AlLFFp3 = (int) AlLFFp(fileInputStream, 1);
        byte[] AYUAbz3 = AYUAbz(fileInputStream, (int) AlLFFp(fileInputStream, 4), (int) AlLFFp(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(AYUAbz3);
        try {
            A5SV6n[] AZkASS2 = AZkASS(byteArrayInputStream2, AlLFFp3, a5SV6nArr);
            byteArrayInputStream2.close();
            return AZkASS2;
        } catch (Throwable th3) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static A5SV6n[] AZkASS(ByteArrayInputStream byteArrayInputStream, int i, A5SV6n[] a5SV6nArr) {
        if (byteArrayInputStream.available() == 0) {
            return new A5SV6n[0];
        }
        if (i != a5SV6nArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i];
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int AlLFFp2 = (int) AlLFFp(byteArrayInputStream, 2);
            iArr[i2] = (int) AlLFFp(byteArrayInputStream, 2);
            strArr[i2] = new String(ARc23Z(byteArrayInputStream, AlLFFp2), StandardCharsets.UTF_8);
        }
        for (int i3 = 0; i3 < i; i3++) {
            A5SV6n a5SV6n = a5SV6nArr[i3];
            if (!a5SV6n.f2164A4TApA.equals(strArr[i3])) {
                throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
            }
            int i4 = iArr[i3];
            a5SV6n.AMqCpz = i4;
            a5SV6n.f2169AYUAbz = ASJ6gh(byteArrayInputStream, i4);
        }
        return a5SV6nArr;
    }

    public static A5SV6n[] AaHO0E(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i, A5SV6n[] a5SV6nArr) {
        if (byteArrayInputStream.available() == 0) {
            return new A5SV6n[0];
        }
        if (i != a5SV6nArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        for (int i2 = 0; i2 < i; i2++) {
            AlLFFp(byteArrayInputStream, 2);
            String str = new String(ARc23Z(byteArrayInputStream, (int) AlLFFp(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
            long AlLFFp2 = AlLFFp(byteArrayInputStream, 4);
            int AlLFFp3 = (int) AlLFFp(byteArrayInputStream, 2);
            A5SV6n a5SV6n = null;
            if (a5SV6nArr.length > 0) {
                int indexOf = str.indexOf("!");
                if (indexOf < 0) {
                    indexOf = str.indexOf(":");
                }
                String substring = indexOf > 0 ? str.substring(indexOf + 1) : str;
                int i3 = 0;
                while (true) {
                    if (i3 >= a5SV6nArr.length) {
                        break;
                    }
                    if (a5SV6nArr[i3].f2164A4TApA.equals(substring)) {
                        a5SV6n = a5SV6nArr[i3];
                        break;
                    }
                    i3++;
                }
            }
            if (a5SV6n == null) {
                throw new IllegalStateException("Missing profile key: ".concat(str));
            }
            a5SV6n.f2166ADYaiT = AlLFFp2;
            int[] ASJ6gh2 = ASJ6gh(byteArrayInputStream, AlLFFp3);
            if (Arrays.equals(bArr, f2177AYUAbz)) {
                a5SV6n.AMqCpz = AlLFFp3;
                a5SV6n.f2169AYUAbz = ASJ6gh2;
            }
        }
        return a5SV6nArr;
    }

    public static A5SV6n[] AcNBzu(FileInputStream fileInputStream, byte[] bArr, String str) {
        if (!Arrays.equals(bArr, AMqCpz)) {
            throw new IllegalStateException("Unsupported version");
        }
        int AlLFFp2 = (int) AlLFFp(fileInputStream, 1);
        byte[] AYUAbz2 = AYUAbz(fileInputStream, (int) AlLFFp(fileInputStream, 4), (int) AlLFFp(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(AYUAbz2);
        try {
            A5SV6n[] AmA8tU2 = AmA8tU(byteArrayInputStream, str, AlLFFp2);
            byteArrayInputStream.close();
            return AmA8tU2;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static long AlLFFp(InputStream inputStream, int i) {
        byte[] ARc23Z2 = ARc23Z(inputStream, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += (ARc23Z2[i2] & 255) << (i2 * 8);
        }
        return j;
    }

    public static A5SV6n[] AmA8tU(ByteArrayInputStream byteArrayInputStream, String str, int i) {
        TreeMap treeMap;
        if (byteArrayInputStream.available() == 0) {
            return new A5SV6n[0];
        }
        A5SV6n[] a5SV6nArr = new A5SV6n[i];
        for (int i2 = 0; i2 < i; i2++) {
            int AlLFFp2 = (int) AlLFFp(byteArrayInputStream, 2);
            int AlLFFp3 = (int) AlLFFp(byteArrayInputStream, 2);
            a5SV6nArr[i2] = new A5SV6n(str, new String(ARc23Z(byteArrayInputStream, AlLFFp2), StandardCharsets.UTF_8), AlLFFp(byteArrayInputStream, 4), AlLFFp3, (int) AlLFFp(byteArrayInputStream, 4), (int) AlLFFp(byteArrayInputStream, 4), new int[AlLFFp3], new TreeMap());
        }
        for (int i3 = 0; i3 < i; i3++) {
            A5SV6n a5SV6n = a5SV6nArr[i3];
            int available = byteArrayInputStream.available() - a5SV6n.f2167ARc23Z;
            int i4 = 0;
            while (true) {
                int available2 = byteArrayInputStream.available();
                treeMap = a5SV6n.f2170AZOQYO;
                if (available2 <= available) {
                    break;
                }
                i4 += (int) AlLFFp(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(i4), 1);
                for (int AlLFFp4 = (int) AlLFFp(byteArrayInputStream, 2); AlLFFp4 > 0; AlLFFp4--) {
                    AlLFFp(byteArrayInputStream, 2);
                    int AlLFFp5 = (int) AlLFFp(byteArrayInputStream, 1);
                    if (AlLFFp5 != 6 && AlLFFp5 != 7) {
                        while (AlLFFp5 > 0) {
                            AlLFFp(byteArrayInputStream, 1);
                            for (int AlLFFp6 = (int) AlLFFp(byteArrayInputStream, 1); AlLFFp6 > 0; AlLFFp6--) {
                                AlLFFp(byteArrayInputStream, 2);
                            }
                            AlLFFp5--;
                        }
                    }
                }
            }
            if (byteArrayInputStream.available() != available) {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
            a5SV6n.f2169AYUAbz = ASJ6gh(byteArrayInputStream, a5SV6n.AMqCpz);
            int i5 = a5SV6n.f2168ASJ6gh;
            BitSet valueOf = BitSet.valueOf(ARc23Z(byteArrayInputStream, (((i5 * 2) + 7) & (-8)) / 8));
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = valueOf.get(i6) ? 2 : 0;
                if (valueOf.get(i6 + i5)) {
                    i7 |= 4;
                }
                if (i7 != 0) {
                    Integer num = (Integer) treeMap.get(Integer.valueOf(i6));
                    if (num == null) {
                        num = 0;
                    }
                    treeMap.put(Integer.valueOf(i6), Integer.valueOf(i7 | num.intValue()));
                }
            }
        }
        return a5SV6nArr;
    }

    /* JADX WARN: Finally extract failed */
    public static boolean AzWtSf(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, A5SV6n[] a5SV6nArr) {
        long j;
        ArrayList arrayList;
        int length;
        byte[] bArr2 = f2174ADYaiT;
        if (!Arrays.equals(bArr, bArr2)) {
            byte[] bArr3 = AMqCpz;
            if (Arrays.equals(bArr, bArr3)) {
                byte[] A4TApA2 = A4TApA(a5SV6nArr, bArr3);
                B7CMnp(byteArrayOutputStream, a5SV6nArr.length, 1);
                B7CMnp(byteArrayOutputStream, A4TApA2.length, 4);
                byte[] A2egSU2 = A2egSU(A4TApA2);
                B7CMnp(byteArrayOutputStream, A2egSU2.length, 4);
                byteArrayOutputStream.write(A2egSU2);
                return true;
            }
            byte[] bArr4 = f2176ASJ6gh;
            if (Arrays.equals(bArr, bArr4)) {
                B7CMnp(byteArrayOutputStream, a5SV6nArr.length, 1);
                for (A5SV6n a5SV6n : a5SV6nArr) {
                    int size = a5SV6n.f2170AZOQYO.size() * 4;
                    String ADYaiT2 = ADYaiT(a5SV6n.f2163A2egSU, a5SV6n.f2164A4TApA, bArr4);
                    Charset charset = StandardCharsets.UTF_8;
                    B9tovu(byteArrayOutputStream, ADYaiT2.getBytes(charset).length);
                    B9tovu(byteArrayOutputStream, a5SV6n.f2169AYUAbz.length);
                    B7CMnp(byteArrayOutputStream, size, 4);
                    B7CMnp(byteArrayOutputStream, a5SV6n.f2165A5SV6n, 4);
                    byteArrayOutputStream.write(ADYaiT2.getBytes(charset));
                    Iterator it = a5SV6n.f2170AZOQYO.keySet().iterator();
                    while (it.hasNext()) {
                        B9tovu(byteArrayOutputStream, ((Integer) it.next()).intValue());
                        B9tovu(byteArrayOutputStream, 0);
                    }
                    for (int i : a5SV6n.f2169AYUAbz) {
                        B9tovu(byteArrayOutputStream, i);
                    }
                }
                return true;
            }
            byte[] bArr5 = f2175ARc23Z;
            if (Arrays.equals(bArr, bArr5)) {
                byte[] A4TApA3 = A4TApA(a5SV6nArr, bArr5);
                B7CMnp(byteArrayOutputStream, a5SV6nArr.length, 1);
                B7CMnp(byteArrayOutputStream, A4TApA3.length, 4);
                byte[] A2egSU3 = A2egSU(A4TApA3);
                B7CMnp(byteArrayOutputStream, A2egSU3.length, 4);
                byteArrayOutputStream.write(A2egSU3);
                return true;
            }
            byte[] bArr6 = f2177AYUAbz;
            if (!Arrays.equals(bArr, bArr6)) {
                return false;
            }
            B9tovu(byteArrayOutputStream, a5SV6nArr.length);
            for (A5SV6n a5SV6n2 : a5SV6nArr) {
                String ADYaiT3 = ADYaiT(a5SV6n2.f2163A2egSU, a5SV6n2.f2164A4TApA, bArr6);
                Charset charset2 = StandardCharsets.UTF_8;
                B9tovu(byteArrayOutputStream, ADYaiT3.getBytes(charset2).length);
                TreeMap treeMap = a5SV6n2.f2170AZOQYO;
                B9tovu(byteArrayOutputStream, treeMap.size());
                B9tovu(byteArrayOutputStream, a5SV6n2.f2169AYUAbz.length);
                B7CMnp(byteArrayOutputStream, a5SV6n2.f2165A5SV6n, 4);
                byteArrayOutputStream.write(ADYaiT3.getBytes(charset2));
                Iterator it2 = treeMap.keySet().iterator();
                while (it2.hasNext()) {
                    B9tovu(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                }
                for (int i2 : a5SV6n2.f2169AYUAbz) {
                    B9tovu(byteArrayOutputStream, i2);
                }
            }
            return true;
        }
        ArrayList arrayList2 = new ArrayList(3);
        ArrayList arrayList3 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            B9tovu(byteArrayOutputStream2, a5SV6nArr.length);
            int i3 = 2;
            for (A5SV6n a5SV6n3 : a5SV6nArr) {
                B7CMnp(byteArrayOutputStream2, a5SV6n3.f2165A5SV6n, 4);
                B7CMnp(byteArrayOutputStream2, a5SV6n3.f2166ADYaiT, 4);
                B7CMnp(byteArrayOutputStream2, a5SV6n3.f2168ASJ6gh, 4);
                String ADYaiT4 = ADYaiT(a5SV6n3.f2163A2egSU, a5SV6n3.f2164A4TApA, bArr2);
                Charset charset3 = StandardCharsets.UTF_8;
                int length2 = ADYaiT4.getBytes(charset3).length;
                B9tovu(byteArrayOutputStream2, length2);
                i3 = i3 + 14 + length2;
                byteArrayOutputStream2.write(ADYaiT4.getBytes(charset3));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (i3 != byteArray.length) {
                throw new IllegalStateException("Expected size " + i3 + ", does not match actual size " + byteArray.length);
            }
            AcNBzu acNBzu = new AcNBzu(1, byteArray, false);
            byteArrayOutputStream2.close();
            arrayList2.add(acNBzu);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i4 = 0;
            for (int i5 = 0; i5 < a5SV6nArr.length; i5++) {
                try {
                    A5SV6n a5SV6n4 = a5SV6nArr[i5];
                    B9tovu(byteArrayOutputStream3, i5);
                    B9tovu(byteArrayOutputStream3, a5SV6n4.AMqCpz);
                    i4 = i4 + 4 + (a5SV6n4.AMqCpz * 2);
                    int[] iArr = a5SV6n4.f2169AYUAbz;
                    int length3 = iArr.length;
                    int i6 = 0;
                    int i7 = 0;
                    while (i6 < length3) {
                        int i8 = iArr[i6];
                        B9tovu(byteArrayOutputStream3, i8 - i7);
                        i6++;
                        i7 = i8;
                    }
                } catch (Throwable th) {
                }
            }
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i4 != byteArray2.length) {
                throw new IllegalStateException("Expected size " + i4 + ", does not match actual size " + byteArray2.length);
            }
            AcNBzu acNBzu2 = new AcNBzu(3, byteArray2, true);
            byteArrayOutputStream3.close();
            arrayList2.add(acNBzu2);
            byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i9 = 0;
            int i10 = 0;
            while (i9 < a5SV6nArr.length) {
                try {
                    A5SV6n a5SV6n5 = a5SV6nArr[i9];
                    Iterator it3 = a5SV6n5.f2170AZOQYO.entrySet().iterator();
                    int i11 = 0;
                    while (it3.hasNext()) {
                        i11 |= ((Integer) ((Map.Entry) it3.next()).getValue()).intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                    try {
                        B2KMhB(byteArrayOutputStream4, a5SV6n5);
                        byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                        byteArrayOutputStream4.close();
                        byteArrayOutputStream4 = new ByteArrayOutputStream();
                        try {
                            B3GDIM(byteArrayOutputStream4, a5SV6n5);
                            byte[] byteArray4 = byteArrayOutputStream4.toByteArray();
                            byteArrayOutputStream4.close();
                            B9tovu(byteArrayOutputStream3, i9);
                            int length4 = byteArray3.length + 2 + byteArray4.length;
                            int i12 = i10 + 6;
                            ArrayList arrayList4 = arrayList3;
                            B7CMnp(byteArrayOutputStream3, length4, 4);
                            B9tovu(byteArrayOutputStream3, i11);
                            byteArrayOutputStream3.write(byteArray3);
                            byteArrayOutputStream3.write(byteArray4);
                            i10 = i12 + length4;
                            i9++;
                            arrayList3 = arrayList4;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                    try {
                        byteArrayOutputStream3.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
            }
            ArrayList arrayList5 = arrayList3;
            byte[] byteArray5 = byteArrayOutputStream3.toByteArray();
            if (i10 != byteArray5.length) {
                throw new IllegalStateException("Expected size " + i10 + ", does not match actual size " + byteArray5.length);
            }
            AcNBzu acNBzu3 = new AcNBzu(4, byteArray5, true);
            byteArrayOutputStream3.close();
            arrayList2.add(acNBzu3);
            long j2 = 4;
            long size2 = j2 + j2 + 4 + (arrayList2.size() * 16);
            B7CMnp(byteArrayOutputStream, arrayList2.size(), 4);
            int i13 = 0;
            while (i13 < arrayList2.size()) {
                AcNBzu acNBzu4 = (AcNBzu) arrayList2.get(i13);
                int i14 = acNBzu4.f2187A2egSU;
                if (i14 == 1) {
                    j = 0;
                } else if (i14 == 2) {
                    j = 1;
                } else if (i14 == 3) {
                    j = 2;
                } else if (i14 == 4) {
                    j = 3;
                } else {
                    if (i14 != 5) {
                        throw null;
                    }
                    j = 4;
                }
                B7CMnp(byteArrayOutputStream, j, 4);
                B7CMnp(byteArrayOutputStream, size2, 4);
                byte[] bArr7 = acNBzu4.f2188A4TApA;
                if (acNBzu4.f2189A5SV6n) {
                    long length5 = bArr7.length;
                    byte[] A2egSU4 = A2egSU(bArr7);
                    arrayList = arrayList5;
                    arrayList.add(A2egSU4);
                    B7CMnp(byteArrayOutputStream, A2egSU4.length, 4);
                    B7CMnp(byteArrayOutputStream, length5, 4);
                    length = A2egSU4.length;
                } else {
                    arrayList = arrayList5;
                    arrayList.add(bArr7);
                    B7CMnp(byteArrayOutputStream, bArr7.length, 4);
                    B7CMnp(byteArrayOutputStream, 0L, 4);
                    length = bArr7.length;
                }
                size2 += length;
                i13++;
                arrayList5 = arrayList;
            }
            ArrayList arrayList6 = arrayList5;
            for (int i15 = 0; i15 < arrayList6.size(); i15++) {
                byteArrayOutputStream.write((byte[]) arrayList6.get(i15));
            }
            return true;
        } catch (Throwable th3) {
            try {
                byteArrayOutputStream2.close();
                throw th3;
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
                throw th3;
            }
        }
    }

    public static void B25kr6(ByteArrayOutputStream byteArrayOutputStream, A5SV6n a5SV6n, String str) {
        Charset charset = StandardCharsets.UTF_8;
        B9tovu(byteArrayOutputStream, str.getBytes(charset).length);
        B9tovu(byteArrayOutputStream, a5SV6n.AMqCpz);
        B7CMnp(byteArrayOutputStream, a5SV6n.f2167ARc23Z, 4);
        B7CMnp(byteArrayOutputStream, a5SV6n.f2165A5SV6n, 4);
        B7CMnp(byteArrayOutputStream, a5SV6n.f2168ASJ6gh, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void B2KMhB(ByteArrayOutputStream byteArrayOutputStream, A5SV6n a5SV6n) {
        byte[] bArr = new byte[(((a5SV6n.f2168ASJ6gh * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : a5SV6n.f2170AZOQYO.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                int i = intValue / 8;
                bArr[i] = (byte) (bArr[i] | (1 << (intValue % 8)));
            }
            if ((intValue2 & 4) != 0) {
                int i2 = intValue + a5SV6n.f2168ASJ6gh;
                int i3 = i2 / 8;
                bArr[i3] = (byte) ((1 << (i2 % 8)) | bArr[i3]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void B3GDIM(ByteArrayOutputStream byteArrayOutputStream, A5SV6n a5SV6n) {
        int i = 0;
        for (Map.Entry entry : a5SV6n.f2170AZOQYO.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                B9tovu(byteArrayOutputStream, intValue - i);
                B9tovu(byteArrayOutputStream, 0);
                i = intValue;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:(3:53|54|55)|57|(3:202|203|(4:205|206|207|208)(2:212|213))|59|(4:(1:68)|69|70|(3:77|78|(4:80|81|82|(1:76))(2:83|84))(3:(1:73)|74|(0)))|101|(2:105|(5:109|110|111|112|(2:114|115)(3:116|117|118))(2:107|108))|133|(1:135)(3:139|140|(8:144|145|146|147|148|149|150|(2:151|(1:153)(7:154|155|156|157|158|159|160)))(2:142|143))|(1:137)|138|(1:45)(1:42)|43|44) */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x010a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x010b, code lost:
    
        r20.A5SV6n(7, r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0271 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void B4ZgIw(android.content.Context r18, java.util.concurrent.Executor r19, DUi7mC.AMqCpz r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: DUi7mC.ARc23Z.B4ZgIw(android.content.Context, java.util.concurrent.Executor, DUi7mC.AMqCpz, boolean):void");
    }

    public static void B7CMnp(ByteArrayOutputStream byteArrayOutputStream, long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((j >> (i2 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void B9tovu(ByteArrayOutputStream byteArrayOutputStream, int i) {
        B7CMnp(byteArrayOutputStream, i, 2);
    }
}
