package HMGPfW;

import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz implements Closeable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final File f3393AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final File f3394AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final File f3395AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final File f3396AzWtSf;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final long f3398B2KMhB;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public BufferedWriter f3401B7CMnp;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f3403BChYOn;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public long f3400B4ZgIw = 0;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final LinkedHashMap f3402B9tovu = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: BI9f7h, reason: collision with root package name */
    public long f3404BI9f7h = 0;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final ThreadPoolExecutor f3405BIYEnU = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new A4TApA());

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final A2egSU f3406BJ7GGh = new A2egSU(this);

    /* renamed from: B25kr6, reason: collision with root package name */
    public final int f3397B25kr6 = 1;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final int f3399B3GDIM = 1;

    public AMqCpz(File file, long j) {
        this.f3393AcNBzu = file;
        this.f3394AlLFFp = new File(file, "journal");
        this.f3395AmA8tU = new File(file, "journal.tmp");
        this.f3396AzWtSf = new File(file, "journal.bkp");
        this.f3398B2KMhB = j;
    }

    public static void A2egSU(AMqCpz aMqCpz, A5SV6n a5SV6n, boolean z) {
        synchronized (aMqCpz) {
            ADYaiT aDYaiT = (ADYaiT) a5SV6n.f3384AlLFFp;
            if (aDYaiT.f3391ARc23Z != a5SV6n) {
                throw new IllegalStateException();
            }
            if (z && !aDYaiT.AMqCpz) {
                for (int i = 0; i < aMqCpz.f3399B3GDIM; i++) {
                    if (!((boolean[]) a5SV6n.f3385AmA8tU)[i]) {
                        a5SV6n.A2egSU();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!aDYaiT.f3390ADYaiT[i].exists()) {
                        a5SV6n.A2egSU();
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < aMqCpz.f3399B3GDIM; i2++) {
                File file = aDYaiT.f3390ADYaiT[i2];
                if (!z) {
                    A5SV6n(file);
                } else if (file.exists()) {
                    File file2 = aDYaiT.f3389A5SV6n[i2];
                    file.renameTo(file2);
                    long j = aDYaiT.f3388A4TApA[i2];
                    long length = file2.length();
                    aDYaiT.f3388A4TApA[i2] = length;
                    aMqCpz.f3400B4ZgIw = (aMqCpz.f3400B4ZgIw - j) + length;
                }
            }
            aMqCpz.f3403BChYOn++;
            aDYaiT.f3391ARc23Z = null;
            if (aDYaiT.AMqCpz || z) {
                aDYaiT.AMqCpz = true;
                aMqCpz.f3401B7CMnp.append((CharSequence) "CLEAN");
                aMqCpz.f3401B7CMnp.append(' ');
                aMqCpz.f3401B7CMnp.append((CharSequence) aDYaiT.f3387A2egSU);
                aMqCpz.f3401B7CMnp.append((CharSequence) aDYaiT.A2egSU());
                aMqCpz.f3401B7CMnp.append('\n');
                if (z) {
                    aMqCpz.f3404BI9f7h++;
                }
            } else {
                aMqCpz.f3402B9tovu.remove(aDYaiT.f3387A2egSU);
                aMqCpz.f3401B7CMnp.append((CharSequence) "REMOVE");
                aMqCpz.f3401B7CMnp.append(' ');
                aMqCpz.f3401B7CMnp.append((CharSequence) aDYaiT.f3387A2egSU);
                aMqCpz.f3401B7CMnp.append('\n');
            }
            AMqCpz(aMqCpz.f3401B7CMnp);
            if (aMqCpz.f3400B4ZgIw > aMqCpz.f3398B2KMhB || aMqCpz.ASJ6gh()) {
                aMqCpz.f3405BIYEnU.submit(aMqCpz.f3406BJ7GGh);
            }
        }
    }

    public static void A4TApA(BufferedWriter bufferedWriter) {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            bufferedWriter.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void A5SV6n(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void AMqCpz(BufferedWriter bufferedWriter) {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            bufferedWriter.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static AMqCpz AYUAbz(File file, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                AmA8tU(file2, file3, false);
            }
        }
        AMqCpz aMqCpz = new AMqCpz(file, j);
        if (aMqCpz.f3394AlLFFp.exists()) {
            try {
                aMqCpz.AZkASS();
                aMqCpz.AZOQYO();
                return aMqCpz;
            } catch (IOException e) {
                PrintStream printStream = System.out;
                Objects.toString(file);
                e.getMessage();
                printStream.getClass();
                aMqCpz.delete();
            }
        }
        file.mkdirs();
        AMqCpz aMqCpz2 = new AMqCpz(file, j);
        aMqCpz2.AcNBzu();
        return aMqCpz2;
    }

    public static void AmA8tU(File file, File file2, boolean z) {
        if (z) {
            A5SV6n(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final A5SV6n ADYaiT(String str) {
        synchronized (this) {
            try {
                if (this.f3401B7CMnp == null) {
                    throw new IllegalStateException("cache is closed");
                }
                ADYaiT aDYaiT = (ADYaiT) this.f3402B9tovu.get(str);
                if (aDYaiT == null) {
                    aDYaiT = new ADYaiT(this, str);
                    this.f3402B9tovu.put(str, aDYaiT);
                } else if (aDYaiT.f3391ARc23Z != null) {
                    return null;
                }
                A5SV6n a5SV6n = new A5SV6n(this, aDYaiT);
                aDYaiT.f3391ARc23Z = a5SV6n;
                this.f3401B7CMnp.append((CharSequence) "DIRTY");
                this.f3401B7CMnp.append(' ');
                this.f3401B7CMnp.append((CharSequence) str);
                this.f3401B7CMnp.append('\n');
                AMqCpz(this.f3401B7CMnp);
                return a5SV6n;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized KCxDWD.A5SV6n ARc23Z(String str) {
        if (this.f3401B7CMnp == null) {
            throw new IllegalStateException("cache is closed");
        }
        ADYaiT aDYaiT = (ADYaiT) this.f3402B9tovu.get(str);
        if (aDYaiT == null) {
            return null;
        }
        if (!aDYaiT.AMqCpz) {
            return null;
        }
        for (File file : aDYaiT.f3389A5SV6n) {
            if (!file.exists()) {
                return null;
            }
        }
        this.f3403BChYOn++;
        this.f3401B7CMnp.append((CharSequence) "READ");
        this.f3401B7CMnp.append(' ');
        this.f3401B7CMnp.append((CharSequence) str);
        this.f3401B7CMnp.append('\n');
        if (ASJ6gh()) {
            this.f3405BIYEnU.submit(this.f3406BJ7GGh);
        }
        return new KCxDWD.A5SV6n(23, aDYaiT.f3389A5SV6n);
    }

    public final boolean ASJ6gh() {
        int i = this.f3403BChYOn;
        return i >= 2000 && i >= this.f3402B9tovu.size();
    }

    public final void AZOQYO() {
        A5SV6n(this.f3395AmA8tU);
        Iterator it = this.f3402B9tovu.values().iterator();
        while (it.hasNext()) {
            ADYaiT aDYaiT = (ADYaiT) it.next();
            A5SV6n a5SV6n = aDYaiT.f3391ARc23Z;
            int i = this.f3399B3GDIM;
            int i2 = 0;
            if (a5SV6n == null) {
                while (i2 < i) {
                    this.f3400B4ZgIw += aDYaiT.f3388A4TApA[i2];
                    i2++;
                }
            } else {
                aDYaiT.f3391ARc23Z = null;
                while (i2 < i) {
                    A5SV6n(aDYaiT.f3389A5SV6n[i2]);
                    A5SV6n(aDYaiT.f3390ADYaiT[i2]);
                    i2++;
                }
                it.remove();
            }
        }
    }

    public final void AZkASS() {
        File file = this.f3394AlLFFp;
        ASJ6gh aSJ6gh = new ASJ6gh(new FileInputStream(file), AYUAbz.f3413A2egSU);
        try {
            String A2egSU2 = aSJ6gh.A2egSU();
            String A2egSU3 = aSJ6gh.A2egSU();
            String A2egSU4 = aSJ6gh.A2egSU();
            String A2egSU5 = aSJ6gh.A2egSU();
            String A2egSU6 = aSJ6gh.A2egSU();
            if (!"libcore.io.DiskLruCache".equals(A2egSU2) || !"1".equals(A2egSU3) || !Integer.toString(this.f3397B25kr6).equals(A2egSU4) || !Integer.toString(this.f3399B3GDIM).equals(A2egSU5) || !"".equals(A2egSU6)) {
                throw new IOException("unexpected journal header: [" + A2egSU2 + ", " + A2egSU3 + ", " + A2egSU5 + ", " + A2egSU6 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    AaHO0E(aSJ6gh.A2egSU());
                    i++;
                } catch (EOFException unused) {
                    this.f3403BChYOn = i - this.f3402B9tovu.size();
                    if (aSJ6gh.f3412B25kr6 == -1) {
                        AcNBzu();
                    } else {
                        this.f3401B7CMnp = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), AYUAbz.f3413A2egSU));
                    }
                    try {
                        aSJ6gh.close();
                        return;
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                aSJ6gh.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final void AaHO0E(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        LinkedHashMap linkedHashMap = this.f3402B9tovu;
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                linkedHashMap.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        ADYaiT aDYaiT = (ADYaiT) linkedHashMap.get(substring);
        if (aDYaiT == null) {
            aDYaiT = new ADYaiT(this, substring);
            linkedHashMap.put(substring, aDYaiT);
        }
        if (indexOf2 == -1 || indexOf != 5 || !str.startsWith("CLEAN")) {
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                aDYaiT.f3391ARc23Z = new A5SV6n(this, aDYaiT);
                return;
            } else {
                if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String[] split = str.substring(indexOf2 + 1).split(" ");
        aDYaiT.AMqCpz = true;
        aDYaiT.f3391ARc23Z = null;
        if (split.length != aDYaiT.f3392ASJ6gh.f3399B3GDIM) {
            throw new IOException("unexpected journal line: " + Arrays.toString(split));
        }
        for (int i2 = 0; i2 < split.length; i2++) {
            try {
                aDYaiT.f3388A4TApA[i2] = Long.parseLong(split[i2]);
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + Arrays.toString(split));
            }
        }
    }

    public final synchronized void AcNBzu() {
        try {
            BufferedWriter bufferedWriter = this.f3401B7CMnp;
            if (bufferedWriter != null) {
                A4TApA(bufferedWriter);
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3395AmA8tU), AYUAbz.f3413A2egSU));
            try {
                bufferedWriter2.write("libcore.io.DiskLruCache");
                bufferedWriter2.write("\n");
                bufferedWriter2.write("1");
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.f3397B25kr6));
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.f3399B3GDIM));
                bufferedWriter2.write("\n");
                bufferedWriter2.write("\n");
                for (ADYaiT aDYaiT : this.f3402B9tovu.values()) {
                    if (aDYaiT.f3391ARc23Z != null) {
                        bufferedWriter2.write("DIRTY " + aDYaiT.f3387A2egSU + '\n');
                    } else {
                        bufferedWriter2.write("CLEAN " + aDYaiT.f3387A2egSU + aDYaiT.A2egSU() + '\n');
                    }
                }
                A4TApA(bufferedWriter2);
                if (this.f3394AlLFFp.exists()) {
                    AmA8tU(this.f3394AlLFFp, this.f3396AzWtSf, true);
                }
                AmA8tU(this.f3395AmA8tU, this.f3394AlLFFp, false);
                this.f3396AzWtSf.delete();
                this.f3401B7CMnp = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3394AlLFFp, true), AYUAbz.f3413A2egSU));
            } catch (Throwable th) {
                A4TApA(bufferedWriter2);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void AlLFFp(String str) {
        try {
            if (this.f3401B7CMnp == null) {
                throw new IllegalStateException("cache is closed");
            }
            ADYaiT aDYaiT = (ADYaiT) this.f3402B9tovu.get(str);
            if (aDYaiT != null && aDYaiT.f3391ARc23Z == null) {
                for (int i = 0; i < this.f3399B3GDIM; i++) {
                    File file = aDYaiT.f3389A5SV6n[i];
                    if (file.exists() && !file.delete()) {
                        throw new IOException("failed to delete " + file);
                    }
                    long j = this.f3400B4ZgIw;
                    long[] jArr = aDYaiT.f3388A4TApA;
                    this.f3400B4ZgIw = j - jArr[i];
                    jArr[i] = 0;
                }
                this.f3403BChYOn++;
                this.f3401B7CMnp.append((CharSequence) "REMOVE");
                this.f3401B7CMnp.append(' ');
                this.f3401B7CMnp.append((CharSequence) str);
                this.f3401B7CMnp.append('\n');
                this.f3402B9tovu.remove(str);
                if (ASJ6gh()) {
                    this.f3405BIYEnU.submit(this.f3406BJ7GGh);
                }
            }
        } finally {
        }
    }

    public final void AzWtSf() {
        while (this.f3400B4ZgIw > this.f3398B2KMhB) {
            AlLFFp((String) ((Map.Entry) this.f3402B9tovu.entrySet().iterator().next()).getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.f3401B7CMnp == null) {
                return;
            }
            Iterator it = new ArrayList(this.f3402B9tovu.values()).iterator();
            while (it.hasNext()) {
                A5SV6n a5SV6n = ((ADYaiT) it.next()).f3391ARc23Z;
                if (a5SV6n != null) {
                    a5SV6n.A2egSU();
                }
            }
            AzWtSf();
            A4TApA(this.f3401B7CMnp);
            this.f3401B7CMnp = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void delete() {
        close();
        AYUAbz.A2egSU(this.f3393AcNBzu);
    }
}
