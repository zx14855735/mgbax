package com.kwad.sdk.core.diskcache.a;

import ADYaiT.CtFAbx;
import com.kwad.sdk.utils.w;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a implements Closeable {
    private final File aHp;
    private final File aHq;
    private final File aHr;
    private final File aHs;
    private final int aHt;
    private int aHu;
    private final int aHv;
    private Writer aHx;
    private int aHz;
    private long maxSize;
    static final Pattern aHo = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream aHD = new OutputStream() { // from class: com.kwad.sdk.core.diskcache.a.a.3
        @Override // java.io.OutputStream
        public final void write(int i) {
        }
    };
    private long size = 0;
    private int aHw = 0;
    private final LinkedHashMap<String, b> aHy = new LinkedHashMap<>(0, 0.75f, true);
    private long aHA = 0;
    final ThreadPoolExecutor aHB = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.diskcache.a.a.1
        private final AtomicInteger poolNumber = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ksad-DiskLruCache-" + this.poolNumber.getAndIncrement());
        }
    });
    private final Callable<Void> aHC = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.a.a.2
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: Iz, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (a.this) {
                try {
                    if (a.this.aHx == null) {
                        return null;
                    }
                    a.this.trimToSize();
                    a.this.IF();
                    if (a.this.IE()) {
                        a.this.IC();
                        a.a(a.this, 0);
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    /* renamed from: com.kwad.sdk.core.diskcache.a.a$a, reason: collision with other inner class name */
    public final class C0356a {
        private final b aHF;
        private final boolean[] aHG;
        private boolean aHH;
        private boolean aHI;

        /* renamed from: com.kwad.sdk.core.diskcache.a.a$a$a, reason: collision with other inner class name */
        public class C0357a extends FilterOutputStream {
            public /* synthetic */ C0357a(C0356a c0356a, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0356a.b(C0356a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0356a.b(C0356a.this, true);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C0356a.b(C0356a.this, true);
                }
            }

            private C0357a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0356a.b(C0356a.this, true);
                }
            }
        }

        public /* synthetic */ C0356a(a aVar, b bVar, byte b) {
            this(bVar);
        }

        public static /* synthetic */ boolean b(C0356a c0356a, boolean z) {
            c0356a.aHH = true;
            return true;
        }

        public final void abort() {
            a.this.a(this, false);
        }

        public final void commit() {
            if (this.aHH) {
                a.this.a(this, false);
                a.this.remove(this.aHF.key);
            } else {
                a.this.a(this, true);
            }
            this.aHI = true;
        }

        public final OutputStream dK(int i) {
            FileOutputStream fileOutputStream;
            C0357a c0357a;
            synchronized (a.this) {
                try {
                    if (this.aHF.aHM != this) {
                        throw new IllegalStateException();
                    }
                    byte b = 0;
                    if (!this.aHF.aHL) {
                        this.aHG[0] = true;
                    }
                    File dM = this.aHF.dM(0);
                    try {
                        fileOutputStream = new FileOutputStream(dM);
                    } catch (FileNotFoundException unused) {
                        a.this.aHp.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(dM);
                        } catch (FileNotFoundException unused2) {
                            return a.aHD;
                        }
                    }
                    c0357a = new C0357a(this, fileOutputStream, b);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return c0357a;
        }

        private C0356a(b bVar) {
            this.aHF = bVar;
            this.aHG = bVar.aHL ? null : new boolean[a.this.aHv];
        }
    }

    public final class b {
        private final long[] aHK;
        private boolean aHL;
        private C0356a aHM;
        private long aHN;
        private final String key;

        public /* synthetic */ b(a aVar, String str, byte b) {
            this(str);
        }

        public final String IH() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.aHK) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public final File dL(int i) {
            return new File(a.this.aHp, this.key + i);
        }

        public final File dM(int i) {
            return new File(a.this.aHp, this.key + i + ".tmp");
        }

        private b(String str) {
            this.key = str;
            this.aHK = new long[a.this.aHv];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) {
            if (strArr.length != a.this.aHv) {
                throw c(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.aHK[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw c(strArr);
                }
            }
        }

        private static IOException c(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public static /* synthetic */ boolean a(b bVar, boolean z) {
            bVar.aHL = true;
            return true;
        }
    }

    public final class c implements Closeable {
        private final long[] aHK;
        private final long aHN;
        private File[] aHO;
        private final InputStream[] aHP;
        private final String key;

        public /* synthetic */ c(a aVar, String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, byte b) {
            this(str, j, fileArr, inputStreamArr, jArr);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (InputStream inputStream : this.aHP) {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }

        public final File dN(int i) {
            return this.aHO[0];
        }

        private c(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.key = str;
            this.aHN = j;
            this.aHO = fileArr;
            this.aHP = inputStreamArr;
            this.aHK = jArr;
        }
    }

    static {
        vYhxv();
    }

    private a(File file, int i, int i2, long j, int i3) {
        this.aHp = file;
        this.aHt = i;
        this.aHq = new File(file, "journal");
        this.aHr = new File(file, "journal.tmp");
        this.aHs = new File(file, "journal.bkp");
        this.aHv = i2;
        this.maxSize = j;
        this.aHu = i3;
    }

    private void IA() {
        com.kwad.sdk.core.diskcache.a.b bVar = new com.kwad.sdk.core.diskcache.a.b(new FileInputStream(this.aHq), com.kwad.sdk.crash.utils.a.US_ASCII);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if (!"libcore.io.DiskLruCache".equals(readLine) || !"1".equals(readLine2) || !Integer.toString(this.aHt).equals(readLine3) || !Integer.toString(this.aHv).equals(readLine4) || !"".equals(readLine5)) {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    dP(bVar.readLine());
                    i++;
                } catch (EOFException unused) {
                    this.aHz = i - this.aHy.size();
                    com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.crash.utils.b.closeQuietly(bVar);
            throw th;
        }
    }

    private void IB() {
        p(this.aHr);
        Iterator<b> it = this.aHy.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.aHM == null) {
                while (i < this.aHv) {
                    this.size += next.aHK[i];
                    this.aHw++;
                    i++;
                }
            } else {
                next.aHM = null;
                while (i < this.aHv) {
                    p(next.dL(i));
                    p(next.dM(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void IC() {
        try {
            Writer writer = this.aHx;
            if (writer != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(writer);
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aHr), com.kwad.sdk.crash.utils.a.US_ASCII));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.aHt));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.aHv));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (b bVar : this.aHy.values()) {
                    if (bVar.aHM != null) {
                        bufferedWriter.write("DIRTY " + bVar.key + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + bVar.key + bVar.IH() + '\n');
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
                if (this.aHq.exists()) {
                    a(this.aHq, this.aHs, true);
                }
                a(this.aHr, this.aHq, false);
                this.aHs.delete();
                this.aHx = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aHq, true), com.kwad.sdk.crash.utils.a.US_ASCII));
            } catch (Throwable th) {
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedWriter);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IE() {
        int i = this.aHz;
        return i >= 2000 && i >= this.aHy.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IF() {
        while (this.aHw > this.aHu) {
            remove(this.aHy.entrySet().iterator().next().getKey());
        }
    }

    public static /* synthetic */ int a(a aVar, int i) {
        aVar.aHz = 0;
        return 0;
    }

    private void checkNotClosed() {
        if (this.aHx == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void dP(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.aHy.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        b bVar = this.aHy.get(substring);
        byte b2 = 0;
        if (bVar == null) {
            bVar = new b(this, substring, b2);
            this.aHy.put(substring, bVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            b.a(bVar, true);
            bVar.aHM = null;
            bVar.b(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            bVar.aHM = new C0356a(this, bVar, b2);
        } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
    }

    private static void dS(String str) {
        if (!aHo.matcher(str).matches()) {
            throw new IllegalArgumentException(CtFAbx.BI9f7h("keys must match regex [a-z0-9_-]{1,64}: \"", str, "\""));
        }
    }

    private static void p(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trimToSize() {
        while (this.size > this.maxSize) {
            remove(this.aHy.entrySet().iterator().next().getKey());
        }
    }

    private static /* synthetic */ void vYhxv() {
        char[] charArray = "¤¨ªé ¦ª¢é¥¨¾é´¯¢««é\u008d©®\u0085µ®£ ¢".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 199);
        }
        String str = new String(charArray);
        char[] charArray2 = "¤«®©®³".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 199);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final synchronized int ID() {
        return this.aHu;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.aHx == null) {
                return;
            }
            Iterator it = new ArrayList(this.aHy.values()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.aHM != null) {
                    bVar.aHM.abort();
                }
            }
            trimToSize();
            IF();
            com.kwad.sdk.crash.utils.b.closeQuietly(this.aHx);
            this.aHx = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized c dQ(String str) {
        Throwable th;
        InputStream inputStream;
        try {
            if (this.aHx == null) {
                return null;
            }
            dS(str);
            b bVar = this.aHy.get(str);
            if (bVar == null) {
                return null;
            }
            if (!bVar.aHL) {
                return null;
            }
            int i = this.aHv;
            File[] fileArr = new File[i];
            InputStream[] inputStreamArr = new InputStream[i];
            for (int i2 = 0; i2 < this.aHv; i2++) {
                try {
                    try {
                        try {
                            File dL = bVar.dL(i2);
                            fileArr[i2] = dL;
                            inputStreamArr[i2] = new FileInputStream(dL);
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    } catch (FileNotFoundException unused) {
                        for (int i3 = 0; i3 < this.aHv && (inputStream = inputStreamArr[i3]) != null; i3++) {
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        }
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            }
            this.aHz++;
            this.aHx.append((CharSequence) ("READ " + str + '\n'));
            if (IE()) {
                this.aHB.submit(this.aHC);
            }
            return new c(this, str, bVar.aHN, fileArr, inputStreamArr, bVar.aHK, (byte) 0);
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final C0356a dR(String str) {
        return e(str, -1L);
    }

    public final void delete() {
        close();
        w.deleteContents(this.aHp);
    }

    public final synchronized void flush() {
        checkNotClosed();
        trimToSize();
        IF();
        this.aHx.flush();
    }

    public final File getDirectory() {
        return this.aHp;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized boolean remove(String str) {
        try {
            checkNotClosed();
            dS(str);
            b bVar = this.aHy.get(str);
            if (bVar != null && bVar.aHM == null) {
                for (int i = 0; i < this.aHv; i++) {
                    File dL = bVar.dL(i);
                    if (dL.exists() && !dL.delete()) {
                        throw new IOException("failed to delete " + dL);
                    }
                    this.size -= bVar.aHK[i];
                    this.aHw--;
                    bVar.aHK[i] = 0;
                }
                this.aHz++;
                this.aHx.append((CharSequence) ("REMOVE " + str + '\n'));
                this.aHy.remove(str);
                if (IE()) {
                    this.aHB.submit(this.aHC);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    private synchronized C0356a e(String str, long j) {
        try {
            checkNotClosed();
            dS(str);
            b bVar = this.aHy.get(str);
            byte b2 = 0;
            if (bVar == null) {
                bVar = new b(this, str, b2);
                this.aHy.put(str, bVar);
            } else if (bVar.aHM != null) {
                return null;
            }
            C0356a c0356a = new C0356a(this, bVar, b2);
            bVar.aHM = c0356a;
            this.aHx.write("DIRTY " + str + '\n');
            this.aHx.flush();
            return c0356a;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static a a(File file, int i, int i2, long j) {
        return a(file, 1, 1, 209715200L, Integer.MAX_VALUE);
    }

    public static a a(File file, int i, int i2, long j, int i3) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i, i2, j, i3);
            if (aVar.aHq.exists()) {
                try {
                    aVar.IA();
                    aVar.IB();
                    aVar.aHx = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.aHq, true), com.kwad.sdk.crash.utils.a.US_ASCII));
                    return aVar;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    Objects.toString(file);
                    e.getMessage();
                    printStream.getClass();
                    aVar.delete();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i, i2, j, i3);
            aVar2.IC();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private static void a(File file, File file2, boolean z) {
        if (z) {
            p(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0356a c0356a, boolean z) {
        b bVar = c0356a.aHF;
        if (bVar.aHM == c0356a) {
            if (z && !bVar.aHL) {
                for (int i = 0; i < this.aHv; i++) {
                    if (c0356a.aHG[i]) {
                        if (!bVar.dM(i).exists()) {
                            c0356a.abort();
                            return;
                        }
                    } else {
                        c0356a.abort();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.aHv; i2++) {
                File dM = bVar.dM(i2);
                if (z) {
                    if (dM.exists()) {
                        File dL = bVar.dL(i2);
                        dM.renameTo(dL);
                        long j = bVar.aHK[i2];
                        long length = dL.length();
                        bVar.aHK[i2] = length;
                        this.size = (this.size - j) + length;
                        this.aHw++;
                    }
                } else {
                    p(dM);
                }
            }
            this.aHz++;
            bVar.aHM = null;
            if (!(bVar.aHL | z)) {
                this.aHy.remove(bVar.key);
                this.aHx.write("REMOVE " + bVar.key + '\n');
            } else {
                b.a(bVar, true);
                this.aHx.write("CLEAN " + bVar.key + bVar.IH() + '\n');
                if (z) {
                    long j2 = this.aHA;
                    this.aHA = 1 + j2;
                    bVar.aHN = j2;
                }
            }
            this.aHx.flush();
            if (this.size > this.maxSize || this.aHw > this.aHu || IE()) {
                this.aHB.submit(this.aHC);
            }
            return;
        }
        throw new IllegalStateException();
    }
}
