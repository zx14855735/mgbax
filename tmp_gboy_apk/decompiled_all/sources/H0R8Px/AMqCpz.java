package H0R8Px;

import ADYaiT.CtFAbx;
import com.fl.saas.videocache.ProxyCacheUtils;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz implements Closeable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final File f3138AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final File f3139AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final File f3140AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final int f3141AzWtSf;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public BufferedWriter f3145B4ZgIw;

    /* renamed from: B9tovu, reason: collision with root package name */
    public int f3147B9tovu;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public long f3144B3GDIM = 0;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final LinkedHashMap f3146B7CMnp = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: BChYOn, reason: collision with root package name */
    public long f3148BChYOn = 0;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final ThreadPoolExecutor f3149BI9f7h = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final A2egSU f3150BIYEnU = new A2egSU(this);

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final int f3143B2KMhB = 1;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final long f3142B25kr6 = 104857600;

    static {
        Charset.forName("UTF-8");
        NMSBV();
    }

    public AMqCpz(File file, int i) {
        this.f3138AcNBzu = file;
        this.f3141AzWtSf = i;
        this.f3139AlLFFp = new File(file, "journal");
        this.f3140AmA8tU = new File(file, "journal.tmp");
    }

    public static AMqCpz A4TApA(File file, int i) {
        AMqCpz aMqCpz = new AMqCpz(file, i);
        File file2 = aMqCpz.f3139AlLFFp;
        if (file2.exists()) {
            try {
                aMqCpz.AlLFFp();
                aMqCpz.AaHO0E();
                aMqCpz.f3145B4ZgIw = new BufferedWriter(new FileWriter(file2, true), ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
                return aMqCpz;
            } catch (IOException unused) {
                aMqCpz.close();
                AMqCpz(aMqCpz.f3138AcNBzu);
            }
        }
        file.mkdirs();
        AMqCpz aMqCpz2 = new AMqCpz(file, i);
        aMqCpz2.AzWtSf();
        return aMqCpz2;
    }

    public static String A5SV6n(BufferedInputStream bufferedInputStream) {
        StringBuilder sb = new StringBuilder(80);
        while (true) {
            int read = bufferedInputStream.read();
            if (read == -1) {
                throw new EOFException();
            }
            if (read == 10) {
                int length = sb.length();
                if (length > 0) {
                    int i = length - 1;
                    if (sb.charAt(i) == '\r') {
                        sb.setLength(i);
                    }
                }
                return sb.toString();
            }
            sb.append((char) read);
        }
    }

    public static void ADYaiT(AMqCpz aMqCpz, G58fqA.A2egSU a2egSU, boolean z) {
        synchronized (aMqCpz) {
            try {
                A5SV6n a5SV6n = (A5SV6n) a2egSU.f2978A4TApA;
                if (a5SV6n.f3136ADYaiT != a2egSU) {
                    throw new IllegalStateException();
                }
                if (z && !a5SV6n.f3135A5SV6n) {
                    for (int i = 0; i < aMqCpz.f3143B2KMhB; i++) {
                        if (!a5SV6n.A5SV6n(i).exists()) {
                            ADYaiT((AMqCpz) a2egSU.f2979A5SV6n, a2egSU, false);
                            throw new IllegalStateException("edit didn't create file " + i);
                        }
                    }
                }
                for (int i2 = 0; i2 < aMqCpz.f3143B2KMhB; i2++) {
                    File A5SV6n2 = a5SV6n.A5SV6n(i2);
                    if (!z) {
                        AYUAbz(A5SV6n2);
                    } else if (A5SV6n2.exists()) {
                        File A2egSU2 = a5SV6n.A2egSU(i2);
                        A5SV6n2.renameTo(A2egSU2);
                        long j = a5SV6n.f3134A4TApA[i2];
                        long length = A2egSU2.length();
                        a5SV6n.f3134A4TApA[i2] = length;
                        aMqCpz.f3144B3GDIM = (aMqCpz.f3144B3GDIM - j) + length;
                    }
                }
                aMqCpz.f3147B9tovu++;
                a5SV6n.f3136ADYaiT = null;
                if (a5SV6n.f3135A5SV6n || z) {
                    a5SV6n.f3135A5SV6n = true;
                    aMqCpz.f3145B4ZgIw.write("CLEAN " + a5SV6n.f3133A2egSU + a5SV6n.A4TApA() + '\n');
                    if (z) {
                        aMqCpz.f3148BChYOn++;
                    }
                } else {
                    aMqCpz.f3146B7CMnp.remove(a5SV6n.f3133A2egSU);
                    aMqCpz.f3145B4ZgIw.write("REMOVE " + a5SV6n.f3133A2egSU + '\n');
                }
                if (aMqCpz.f3144B3GDIM > aMqCpz.f3142B25kr6 || aMqCpz.AZkASS()) {
                    aMqCpz.f3149BI9f7h.submit(aMqCpz.f3150BIYEnU);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void AMqCpz(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IllegalArgumentException(CtFAbx.AYUAbz(file, "not a directory: "));
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                AMqCpz(file2);
            }
            if (!file2.delete()) {
                throw new IOException(CtFAbx.AYUAbz(file2, "failed to delete file: "));
            }
        }
    }

    public static void AYUAbz(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void AmA8tU(String str) {
        if (str.contains(" ") || str.contains("\n") || str.contains("\r")) {
            throw new IllegalArgumentException(CtFAbx.BI9f7h("keys must not contain spaces or newlines: \"", str, "\""));
        }
    }

    private static /* synthetic */ void NMSBV() {
        char[] charArray = "\u0002\u000e\fO\u0006\u0000\f\u0004O\u0003\u000e\u0018O\u0012\t\u0004\r\rO+\u000f\b#\u0013\b\u0005\u0006\u0004".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'a');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0002\r\b\u000f\b\u0015".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'a');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final G58fqA.A2egSU A2egSU(String str) {
        synchronized (this) {
            try {
                if (this.f3145B4ZgIw == null) {
                    throw new IllegalStateException("cache is closed");
                }
                AmA8tU(str);
                A5SV6n a5SV6n = (A5SV6n) this.f3146B7CMnp.get(str);
                if (a5SV6n == null) {
                    a5SV6n = new A5SV6n(this, str);
                    this.f3146B7CMnp.put(str, a5SV6n);
                } else if (a5SV6n.f3136ADYaiT != null) {
                    return null;
                }
                G58fqA.A2egSU a2egSU = new G58fqA.A2egSU(this, a5SV6n);
                a5SV6n.f3136ADYaiT = a2egSU;
                this.f3145B4ZgIw.write("DIRTY " + str + '\n');
                this.f3145B4ZgIw.flush();
                return a2egSU;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized ADYaiT ARc23Z(String str) {
        if (this.f3145B4ZgIw == null) {
            throw new IllegalStateException("cache is closed");
        }
        AmA8tU(str);
        A5SV6n a5SV6n = (A5SV6n) this.f3146B7CMnp.get(str);
        if (a5SV6n == null) {
            return null;
        }
        if (!a5SV6n.f3135A5SV6n) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.f3143B2KMhB];
        for (int i = 0; i < this.f3143B2KMhB; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(a5SV6n.A2egSU(i));
            } catch (FileNotFoundException unused) {
                return null;
            }
        }
        this.f3147B9tovu++;
        this.f3145B4ZgIw.append((CharSequence) ("READ " + str + '\n'));
        if (AZkASS()) {
            this.f3149BI9f7h.submit(this.f3150BIYEnU);
        }
        return new ADYaiT(inputStreamArr);
    }

    public final synchronized void ASJ6gh() {
        if (this.f3145B4ZgIw == null) {
            throw new IllegalStateException("cache is closed");
        }
        B25kr6();
        this.f3145B4ZgIw.flush();
    }

    public final void AZOQYO(String str) {
        String[] split = str.split(" ");
        if (split.length < 2) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        String str2 = split[1];
        boolean equals = split[0].equals("REMOVE");
        LinkedHashMap linkedHashMap = this.f3146B7CMnp;
        if (equals && split.length == 2) {
            linkedHashMap.remove(str2);
            return;
        }
        A5SV6n a5SV6n = (A5SV6n) linkedHashMap.get(str2);
        if (a5SV6n == null) {
            a5SV6n = new A5SV6n(this, str2);
            linkedHashMap.put(str2, a5SV6n);
        }
        if (!split[0].equals("CLEAN") || split.length != this.f3143B2KMhB + 2) {
            if (split[0].equals("DIRTY") && split.length == 2) {
                a5SV6n.f3136ADYaiT = new G58fqA.A2egSU(this, a5SV6n);
                return;
            } else {
                if (!split[0].equals("READ") || split.length != 2) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        a5SV6n.f3135A5SV6n = true;
        a5SV6n.f3136ADYaiT = null;
        int length = split.length;
        int length2 = split.length;
        if (2 > length) {
            throw new IllegalArgumentException();
        }
        if (2 > length2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = length - 2;
        int min = Math.min(i, length2 - 2);
        Object[] objArr = (Object[]) Array.newInstance(split.getClass().getComponentType(), i);
        System.arraycopy(split, 2, objArr, 0, min);
        String[] strArr = (String[]) objArr;
        if (strArr.length != a5SV6n.AMqCpz.f3143B2KMhB) {
            StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("unexpected journal line: ");
            AMqCpz.append(Arrays.toString(strArr));
            throw new IOException(AMqCpz.toString());
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            try {
                a5SV6n.f3134A4TApA[i2] = Long.parseLong(strArr[i2]);
            } catch (NumberFormatException unused) {
                StringBuilder AMqCpz2 = JrXYwF.A4TApA.AMqCpz("unexpected journal line: ");
                AMqCpz2.append(Arrays.toString(strArr));
                throw new IOException(AMqCpz2.toString());
            }
        }
    }

    public final boolean AZkASS() {
        int i = this.f3147B9tovu;
        return i >= 2000 && i >= this.f3146B7CMnp.size();
    }

    public final void AaHO0E() {
        AYUAbz(this.f3140AmA8tU);
        Iterator it = this.f3146B7CMnp.values().iterator();
        while (it.hasNext()) {
            A5SV6n a5SV6n = (A5SV6n) it.next();
            G58fqA.A2egSU a2egSU = a5SV6n.f3136ADYaiT;
            int i = this.f3143B2KMhB;
            int i2 = 0;
            if (a2egSU == null) {
                while (i2 < i) {
                    this.f3144B3GDIM += a5SV6n.f3134A4TApA[i2];
                    i2++;
                }
            } else {
                a5SV6n.f3136ADYaiT = null;
                while (i2 < i) {
                    AYUAbz(a5SV6n.A2egSU(i2));
                    AYUAbz(a5SV6n.A5SV6n(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    public final synchronized void AcNBzu(String str) {
        try {
            if (this.f3145B4ZgIw == null) {
                throw new IllegalStateException("cache is closed");
            }
            AmA8tU(str);
            A5SV6n a5SV6n = (A5SV6n) this.f3146B7CMnp.get(str);
            if (a5SV6n != null && a5SV6n.f3136ADYaiT == null) {
                for (int i = 0; i < this.f3143B2KMhB; i++) {
                    File A2egSU2 = a5SV6n.A2egSU(i);
                    if (!A2egSU2.delete()) {
                        throw new IOException("failed to delete " + A2egSU2);
                    }
                    long j = this.f3144B3GDIM;
                    long[] jArr = a5SV6n.f3134A4TApA;
                    this.f3144B3GDIM = j - jArr[i];
                    jArr[i] = 0;
                }
                this.f3147B9tovu++;
                this.f3145B4ZgIw.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f3146B7CMnp.remove(str);
                if (AZkASS()) {
                    this.f3149BI9f7h.submit(this.f3150BIYEnU);
                }
            }
        } finally {
        }
    }

    public final void AlLFFp() {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.f3139AlLFFp), ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
        try {
            String A5SV6n2 = A5SV6n(bufferedInputStream);
            String A5SV6n3 = A5SV6n(bufferedInputStream);
            String A5SV6n4 = A5SV6n(bufferedInputStream);
            String A5SV6n5 = A5SV6n(bufferedInputStream);
            String A5SV6n6 = A5SV6n(bufferedInputStream);
            if (!"libcore.io.DiskLruCache".equals(A5SV6n2) || !"1".equals(A5SV6n3) || !Integer.toString(this.f3141AzWtSf).equals(A5SV6n4) || !Integer.toString(this.f3143B2KMhB).equals(A5SV6n5) || !"".equals(A5SV6n6)) {
                throw new IOException("unexpected journal header: [" + A5SV6n2 + ", " + A5SV6n3 + ", " + A5SV6n5 + ", " + A5SV6n6 + "]");
            }
            while (true) {
                try {
                    try {
                        AZOQYO(A5SV6n(bufferedInputStream));
                    } catch (EOFException unused) {
                        bufferedInputStream.close();
                        return;
                    }
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused2) {
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final synchronized void AzWtSf() {
        try {
            BufferedWriter bufferedWriter = this.f3145B4ZgIw;
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(this.f3140AmA8tU), ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
            bufferedWriter2.write("libcore.io.DiskLruCache");
            bufferedWriter2.write("\n");
            bufferedWriter2.write("1");
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.f3141AzWtSf));
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.f3143B2KMhB));
            bufferedWriter2.write("\n");
            bufferedWriter2.write("\n");
            for (A5SV6n a5SV6n : this.f3146B7CMnp.values()) {
                if (a5SV6n.f3136ADYaiT != null) {
                    StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("DIRTY ");
                    AMqCpz.append(a5SV6n.f3133A2egSU);
                    AMqCpz.append('\n');
                    bufferedWriter2.write(AMqCpz.toString());
                } else {
                    StringBuilder AMqCpz2 = JrXYwF.A4TApA.AMqCpz("CLEAN ");
                    AMqCpz2.append(a5SV6n.f3133A2egSU);
                    AMqCpz2.append(a5SV6n.A4TApA());
                    AMqCpz2.append('\n');
                    bufferedWriter2.write(AMqCpz2.toString());
                }
            }
            bufferedWriter2.close();
            this.f3140AmA8tU.renameTo(this.f3139AlLFFp);
            this.f3145B4ZgIw = new BufferedWriter(new FileWriter(this.f3139AlLFFp, true), ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void B25kr6() {
        while (this.f3144B3GDIM > this.f3142B25kr6) {
            AcNBzu((String) ((Map.Entry) this.f3146B7CMnp.entrySet().iterator().next()).getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.f3145B4ZgIw == null) {
                return;
            }
            Iterator it = new ArrayList(this.f3146B7CMnp.values()).iterator();
            while (it.hasNext()) {
                G58fqA.A2egSU a2egSU = ((A5SV6n) it.next()).f3136ADYaiT;
                if (a2egSU != null) {
                    ADYaiT((AMqCpz) a2egSU.f2979A5SV6n, a2egSU, false);
                }
            }
            B25kr6();
            this.f3145B4ZgIw.close();
            this.f3145B4ZgIw = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
