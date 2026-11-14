package com.bytedance.sdk.component.y.w.xj.xj;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import com.bytedance.sdk.component.utils.pl;
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
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class xj implements Closeable {
    private int am;
    private final File c;
    private long d;
    private final int f;
    final ExecutorService hf;
    private final File kd;

    /* renamed from: pl, reason: collision with root package name */
    private Writer f10260pl;
    private final int tf;
    private final File u;
    private final File y;
    static final Pattern xj = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream w = new OutputStream() { // from class: com.bytedance.sdk.component.y.w.xj.xj.xj.2
        @Override // java.io.OutputStream
        public void write(int i) {
        }
    };
    private long p = 0;
    private final LinkedHashMap<String, hf> g = new LinkedHashMap<>(0, 0.75f, true);
    private long qt = -1;
    private long zg = 0;
    private final Callable<Void> e = new Callable<Void>() { // from class: com.bytedance.sdk.component.y.w.xj.xj.xj.1
        @Override // java.util.concurrent.Callable
        public Void call() {
            synchronized (xj.this) {
                try {
                    if (xj.this.f10260pl == null) {
                        return null;
                    }
                    xj.this.c();
                    if (xj.this.kd()) {
                        xj.this.u();
                        xj.this.am = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    };

    public final class hf {
        private final String hf;
        private C0128xj kd;
        private boolean u;
        private final long[] w;
        private long y;

        private hf(String str) {
            this.hf = str;
            this.w = new long[xj.this.tf];
        }

        private IOException hf(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File hf(int i) {
            return new File(xj.this.u, this.hf + "." + i + ".tmp");
        }

        public String xj() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.w) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xj(String[] strArr) {
            if (strArr.length == xj.this.tf) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.w[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        throw hf(strArr);
                    }
                }
                return;
            }
            throw hf(strArr);
        }

        public File xj(int i) {
            return new File(xj.this.u, this.hf + "." + i);
        }
    }

    public final class w implements Closeable {
        private final String hf;
        private final long[] kd;
        private final InputStream[] u;
        private final long w;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.u) {
                com.bytedance.sdk.component.y.w.w.hf.xj(inputStream);
            }
        }

        public InputStream xj(int i) {
            return this.u[i];
        }

        private w(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.hf = str;
            this.w = j;
            this.u = inputStreamArr;
            this.kd = jArr;
        }
    }

    /* renamed from: com.bytedance.sdk.component.y.w.xj.xj.xj$xj, reason: collision with other inner class name */
    public final class C0128xj {
        private final hf hf;
        private boolean kd;
        private boolean u;
        private final boolean[] w;

        /* renamed from: com.bytedance.sdk.component.y.w.xj.xj.xj$xj$xj, reason: collision with other inner class name */
        public class C0129xj extends FilterOutputStream {
            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    C0128xj.this.u = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    C0128xj.this.u = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    C0128xj.this.u = true;
                }
            }

            private C0129xj(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0128xj.this.u = true;
                }
            }
        }

        private C0128xj(hf hfVar) {
            this.hf = hfVar;
            this.w = hfVar.u ? null : new boolean[xj.this.tf];
        }

        public void hf() {
            xj.this.xj(this, false);
        }

        public OutputStream xj(int i) {
            FileOutputStream fileOutputStream;
            C0129xj c0129xj;
            if (i >= 0 && i < xj.this.tf) {
                synchronized (xj.this) {
                    try {
                        if (this.hf.kd == this) {
                            if (!this.hf.u) {
                                this.w[i] = true;
                            }
                            File hf = this.hf.hf(i);
                            try {
                                fileOutputStream = new FileOutputStream(hf);
                            } catch (FileNotFoundException unused) {
                                xj.this.u.mkdirs();
                                try {
                                    fileOutputStream = new FileOutputStream(hf);
                                } catch (FileNotFoundException unused2) {
                                    return xj.w;
                                }
                            }
                            c0129xj = new C0129xj(fileOutputStream);
                        } else {
                            throw new IllegalStateException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return c0129xj;
            }
            StringBuilder B9tovu2 = A2egSU.B9tovu(i, "Expected index ", " to be greater than 0 and less than the maximum value count of ");
            B9tovu2.append(xj.this.tf);
            throw new IllegalArgumentException(B9tovu2.toString());
        }

        public void xj() {
            if (this.u) {
                xj.this.xj(this, false);
                xj.this.w(this.hf.hf);
            } else {
                xj.this.xj(this, true);
            }
            this.kd = true;
        }
    }

    static {
        RIiBKqA();
    }

    private xj(File file, int i, int i2, long j, ExecutorService executorService) {
        this.u = file;
        this.f = i;
        this.kd = new File(file, "journal");
        this.y = new File(file, "journal.tmp");
        this.c = new File(file, "journal.bkp");
        this.tf = i2;
        this.d = j;
        this.hf = executorService;
    }

    private static /* synthetic */ void RIiBKqA() {
        char[] charArray = "±½¿üµ³¿·ü°½«ü¡º·¾¾ü\u0098¼»\u0090 »¶µ·".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 210);
        }
        String str = new String(charArray);
        char[] charArray2 = "±¾»¼»¦".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 210);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        long j = this.d;
        long j2 = this.qt;
        if (j2 >= 0) {
            j = j2;
        }
        while (this.p > j) {
            w(this.g.entrySet().iterator().next().getKey());
        }
        this.qt = -1L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f10260pl == null) {
                return;
            }
            Iterator it = new ArrayList(this.g.values()).iterator();
            while (it.hasNext()) {
                hf hfVar = (hf) it.next();
                if (hfVar.kd != null) {
                    hfVar.kd.hf();
                }
            }
            c();
            this.f10260pl.close();
            this.f10260pl = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void delete() {
        close();
        u.xj(this.u);
    }

    private void hf() {
        com.bytedance.sdk.component.y.w.xj.xj.w wVar = new com.bytedance.sdk.component.y.w.xj.xj.w(new FileInputStream(this.kd), u.xj);
        try {
            String xj2 = wVar.xj();
            String xj3 = wVar.xj();
            String xj4 = wVar.xj();
            String xj5 = wVar.xj();
            String xj6 = wVar.xj();
            if (!"libcore.io.DiskLruCache".equals(xj2) || !"1".equals(xj3) || !Integer.toString(this.f).equals(xj4) || !Integer.toString(this.tf).equals(xj5) || !"".equals(xj6)) {
                throw new IOException("unexpected journal header: [" + xj2 + ", " + xj3 + ", " + xj5 + ", " + xj6 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    u(wVar.xj());
                    i++;
                } catch (EOFException unused) {
                    this.am = i - this.g.size();
                    if (wVar.hf()) {
                        u();
                    } else {
                        this.f10260pl = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.kd, true), u.xj));
                    }
                    com.bytedance.sdk.component.y.w.w.hf.xj(wVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.y.w.w.hf.xj(wVar);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean kd() {
        int i = this.am;
        return i >= 2000 && i >= this.g.size();
    }

    private void u(String str) {
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
                this.g.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        hf hfVar = this.g.get(substring);
        if (hfVar == null) {
            hfVar = new hf(substring);
            this.g.put(substring, hfVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            hfVar.u = true;
            hfVar.kd = null;
            hfVar.xj(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            hfVar.kd = new C0128xj(hfVar);
        } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
    }

    private void w() {
        xj(this.y);
        Iterator<hf> it = this.g.values().iterator();
        while (it.hasNext()) {
            hf next = it.next();
            int i = 0;
            if (next.kd == null) {
                while (i < this.tf) {
                    this.p += next.w[i];
                    i++;
                }
            } else {
                next.kd = null;
                while (i < this.tf) {
                    xj(next.xj(i));
                    xj(next.hf(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private void y() {
        if (this.f10260pl == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void kd(String str) {
        if (!xj.matcher(str).matches()) {
            throw new IllegalArgumentException(CtFAbx.BI9f7h("keys must match regex [a-z0-9_-]{1,120}: \"", str, "\""));
        }
    }

    public static xj xj(File file, int i, int i2, long j, ExecutorService executorService) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    xj(file2, file3, false);
                }
            }
            xj xjVar = new xj(file, i, i2, j, executorService);
            if (xjVar.kd.exists()) {
                try {
                    xjVar.hf();
                    xjVar.w();
                    return xjVar;
                } catch (IOException e) {
                    pl.hf("DiskLruCache ", file + " is corrupt: " + e.getMessage() + ", removing");
                    xjVar.delete();
                }
            }
            file.mkdirs();
            xj xjVar2 = new xj(file, i, i2, j, executorService);
            xjVar2.u();
            return xjVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    public synchronized boolean w(String str) {
        try {
            y();
            kd(str);
            hf hfVar = this.g.get(str);
            if (hfVar != null && hfVar.kd == null) {
                for (int i = 0; i < this.tf; i++) {
                    File xj2 = hfVar.xj(i);
                    if (xj2.exists() && !xj2.delete()) {
                        throw new IOException("failed to delete ".concat(String.valueOf(xj2)));
                    }
                    this.p -= hfVar.w[i];
                    hfVar.w[i] = 0;
                }
                this.am++;
                this.f10260pl.append((CharSequence) ("REMOVE " + str + '\n'));
                this.g.remove(str);
                if (kd()) {
                    this.hf.submit(this.e);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    public C0128xj hf(String str) {
        return xj(str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u() {
        try {
            Writer writer = this.f10260pl;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.y), u.xj));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.tf));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (hf hfVar : this.g.values()) {
                    if (hfVar.kd != null) {
                        bufferedWriter.write("DIRTY " + hfVar.hf + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + hfVar.hf + hfVar.xj() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.kd.exists()) {
                    xj(this.kd, this.c, true);
                }
                xj(this.y, this.kd, false);
                this.c.delete();
                this.f10260pl = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.kd, true), u.xj));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static void xj(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void xj(File file, File file2, boolean z) {
        if (z) {
            xj(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized w xj(String str) {
        Throwable th;
        InputStream inputStream;
        try {
            y();
            kd(str);
            hf hfVar = this.g.get(str);
            if (hfVar == null) {
                return null;
            }
            if (!hfVar.u) {
                return null;
            }
            InputStream[] inputStreamArr = new InputStream[this.tf];
            for (int i = 0; i < this.tf; i++) {
                try {
                    try {
                        try {
                            inputStreamArr[i] = new FileInputStream(hfVar.xj(i));
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    } catch (FileNotFoundException unused) {
                        for (int i2 = 0; i2 < this.tf && (inputStream = inputStreamArr[i2]) != null; i2++) {
                            com.bytedance.sdk.component.y.w.w.hf.xj(inputStream);
                        }
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            }
            this.am++;
            this.f10260pl.append((CharSequence) ("READ " + str + '\n'));
            if (kd()) {
                this.hf.submit(this.e);
            }
            return new w(str, hfVar.y, inputStreamArr, hfVar.w);
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private synchronized C0128xj xj(String str, long j) {
        y();
        kd(str);
        hf hfVar = this.g.get(str);
        if (j != -1 && (hfVar == null || hfVar.y != j)) {
            return null;
        }
        if (hfVar != null) {
            if (hfVar.kd != null) {
                return null;
            }
        } else {
            hfVar = new hf(str);
            this.g.put(str, hfVar);
        }
        C0128xj c0128xj = new C0128xj(hfVar);
        hfVar.kd = c0128xj;
        this.f10260pl.write("DIRTY " + str + '\n');
        this.f10260pl.flush();
        return c0128xj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void xj(C0128xj c0128xj, boolean z) {
        hf hfVar = c0128xj.hf;
        if (hfVar.kd == c0128xj) {
            if (z && !hfVar.u) {
                for (int i = 0; i < this.tf; i++) {
                    if (c0128xj.w[i]) {
                        if (!hfVar.hf(i).exists()) {
                            c0128xj.hf();
                            return;
                        }
                    } else {
                        c0128xj.hf();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                    }
                }
            }
            for (int i2 = 0; i2 < this.tf; i2++) {
                File hf2 = hfVar.hf(i2);
                if (z) {
                    if (hf2.exists()) {
                        File xj2 = hfVar.xj(i2);
                        hf2.renameTo(xj2);
                        long j = hfVar.w[i2];
                        long length = xj2.length();
                        hfVar.w[i2] = length;
                        this.p = (this.p - j) + length;
                    }
                } else {
                    xj(hf2);
                }
            }
            this.am++;
            hfVar.kd = null;
            if (!(hfVar.u | z)) {
                this.g.remove(hfVar.hf);
                this.f10260pl.write("REMOVE " + hfVar.hf + '\n');
            } else {
                hfVar.u = true;
                this.f10260pl.write("CLEAN " + hfVar.hf + hfVar.xj() + '\n');
                if (z) {
                    long j2 = this.zg;
                    this.zg = 1 + j2;
                    hfVar.y = j2;
                }
            }
            this.f10260pl.flush();
            if (this.p > this.d || kd()) {
                this.hf.submit(this.e);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public synchronized void xj() {
        y();
        c();
        this.f10260pl.flush();
    }

    public void xj(long j) {
        this.qt = j;
        this.hf.submit(this.e);
    }
}
