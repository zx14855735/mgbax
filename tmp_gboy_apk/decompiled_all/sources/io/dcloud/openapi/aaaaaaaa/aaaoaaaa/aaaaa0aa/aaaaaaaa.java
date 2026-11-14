package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa;

import ADYaiT.CtFAbx;
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
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaaa implements Closeable {
    static final Pattern aeaaaaaa = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream aoaaaaaa = new aaaaaaa0();
    private final File aaaaaaa0;
    private final File aaaaaaaa;
    private final File aaaaaaac;
    private final int aaaaaaae;
    private long aaaaaaan;
    private final File aaaaaaao;
    private final int aaaaaaau;
    private Writer aaaaaaeo;
    private int aaaaeaaa;
    private long aaaaaaav = 0;
    private final LinkedHashMap aaaeaaaa = new LinkedHashMap(0, 0.75f, true);
    private long aaaaaeaa = 0;
    final ThreadPoolExecutor aaaaaaea = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable eaaaaaaa = new CallableC0517aaaaaaaa();

    public class aaaaaaa0 extends OutputStream {
        @Override // java.io.OutputStream
        public void write(int i) {
        }
    }

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public class CallableC0517aaaaaaaa implements Callable {
        public CallableC0517aaaaaaaa() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: aaaaaaaa, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (aaaaaaaa.this) {
                try {
                    if (aaaaaaaa.this.aaaaaaeo == null) {
                        return null;
                    }
                    aaaaaaaa.this.aoaaaaaa();
                    if (aaaaaaaa.this.aaaaaeaa()) {
                        aaaaaaaa.this.aeaaaaaa();
                        aaaaaaaa.this.aaaaeaaa = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final class aaaaaaac {
        private final long[] aaaaaaa0;
        private final String aaaaaaaa;
        private aaaaaaao aaaaaaac;
        private boolean aaaaaaao;
        private long aaaaaaau;

        public /* synthetic */ aaaaaaac(aaaaaaaa aaaaaaaaVar, String str, CallableC0517aaaaaaaa callableC0517aaaaaaaa) {
            this(str);
        }

        private aaaaaaac(String str) {
            this.aaaaaaaa = str;
            this.aaaaaaa0 = new long[aaaaaaaa.this.aaaaaaae];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void aaaaaaa0(String[] strArr) {
            if (strArr.length != aaaaaaaa.this.aaaaaaae) {
                throw aaaaaaaa(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.aaaaaaa0[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw aaaaaaaa(strArr);
                }
            }
        }

        public String aaaaaaaa() {
            StringBuilder sb = new StringBuilder();
            for (long j : this.aaaaaaa0) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File aaaaaaa0(int i) {
            return new File(aaaaaaaa.this.aaaaaaaa, this.aaaaaaaa + "." + i + ".tmp");
        }

        private IOException aaaaaaaa(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File aaaaaaaa(int i) {
            return new File(aaaaaaaa.this.aaaaaaaa, this.aaaaaaaa + "." + i);
        }
    }

    public final class aaaaaaao {
        private final boolean[] aaaaaaa0;
        private final aaaaaaac aaaaaaaa;
        private boolean aaaaaaac;
        private boolean aaaaaaao;

        /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaaa$aaaaaaao$aaaaaaaa, reason: collision with other inner class name */
        public class C0518aaaaaaaa extends FilterOutputStream {
            public /* synthetic */ C0518aaaaaaaa(aaaaaaao aaaaaaaoVar, OutputStream outputStream, CallableC0517aaaaaaaa callableC0517aaaaaaaa) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    aaaaaaao.this.aaaaaaao = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    aaaaaaao.this.aaaaaaao = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    ((FilterOutputStream) this).out.write(i);
                } catch (IOException unused) {
                    aaaaaaao.this.aaaaaaao = true;
                }
            }

            private C0518aaaaaaaa(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i, i2);
                } catch (IOException unused) {
                    aaaaaaao.this.aaaaaaao = true;
                }
            }
        }

        public /* synthetic */ aaaaaaao(aaaaaaaa aaaaaaaaVar, aaaaaaac aaaaaaacVar, CallableC0517aaaaaaaa callableC0517aaaaaaaa) {
            this(aaaaaaacVar);
        }

        private aaaaaaao(aaaaaaac aaaaaaacVar) {
            this.aaaaaaaa = aaaaaaacVar;
            this.aaaaaaa0 = aaaaaaacVar.aaaaaaao ? null : new boolean[aaaaaaaa.this.aaaaaaae];
        }

        public void aaaaaaa0() {
            if (this.aaaaaaao) {
                aaaaaaaa.this.aaaaaaaa(this, false);
                aaaaaaaa.this.aaaaaaau(this.aaaaaaaa.aaaaaaaa);
            } else {
                aaaaaaaa.this.aaaaaaaa(this, true);
            }
            this.aaaaaaac = true;
        }

        public OutputStream aaaaaaaa(int i) {
            FileOutputStream fileOutputStream;
            C0518aaaaaaaa c0518aaaaaaaa;
            synchronized (aaaaaaaa.this) {
                try {
                    if (this.aaaaaaaa.aaaaaaac == this) {
                        if (!this.aaaaaaaa.aaaaaaao) {
                            this.aaaaaaa0[i] = true;
                        }
                        File aaaaaaa0 = this.aaaaaaaa.aaaaaaa0(i);
                        try {
                            fileOutputStream = new FileOutputStream(aaaaaaa0);
                        } catch (FileNotFoundException unused) {
                            aaaaaaaa.this.aaaaaaaa.mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(aaaaaaa0);
                            } catch (FileNotFoundException unused2) {
                                return aaaaaaaa.aoaaaaaa;
                            }
                        }
                        c0518aaaaaaaa = new C0518aaaaaaaa(this, fileOutputStream, null);
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return c0518aaaaaaaa;
        }

        public void aaaaaaaa() {
            aaaaaaaa.this.aaaaaaaa(this, false);
        }
    }

    public final class aaaaaaau implements Closeable {
        private final long aaaaaaa0;
        private final String aaaaaaaa;
        private final long[] aaaaaaac;
        private final InputStream[] aaaaaaao;

        public /* synthetic */ aaaaaaau(aaaaaaaa aaaaaaaaVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, CallableC0517aaaaaaaa callableC0517aaaaaaaa) {
            this(str, j, inputStreamArr, jArr);
        }

        public InputStream aaaaaaaa(int i) {
            return this.aaaaaaao[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.aaaaaaao) {
                io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaao.aaaaaaaa(inputStream);
            }
        }

        public String getString(int i) {
            return aaaaaaaa.aaaaaaa0(aaaaaaaa(i));
        }

        private aaaaaaau(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.aaaaaaaa = str;
            this.aaaaaaa0 = j;
            this.aaaaaaao = inputStreamArr;
            this.aaaaaaac = jArr;
        }
    }

    static {
        LkTCmK();
    }

    private aaaaaaaa(File file, int i, int i2, long j) {
        this.aaaaaaaa = file;
        this.aaaaaaau = i;
        this.aaaaaaa0 = new File(file, "journal");
        this.aaaaaaao = new File(file, "journal.tmp");
        this.aaaaaaac = new File(file, "journal.bkp");
        this.aaaaaaae = i2;
        this.aaaaaaan = j;
    }

    private static /* synthetic */ void LkTCmK() {
        char[] charArray = "3?=~71=5~2?)~#85<<~\u001a>9\u0012\"9475".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'P');
        }
        String str = new String(charArray);
        char[] charArray2 = "3<9>9$".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'P');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void aaaaaaea() {
        aaaaaaaa(this.aaaaaaao);
        Iterator it = this.aaaeaaaa.values().iterator();
        while (it.hasNext()) {
            aaaaaaac aaaaaaacVar = (aaaaaaac) it.next();
            int i = 0;
            if (aaaaaaacVar.aaaaaaac == null) {
                while (i < this.aaaaaaae) {
                    this.aaaaaaav += aaaaaaacVar.aaaaaaa0[i];
                    i++;
                }
            } else {
                aaaaaaacVar.aaaaaaac = null;
                while (i < this.aaaaaaae) {
                    aaaaaaaa(aaaaaaacVar.aaaaaaaa(i));
                    aaaaaaaa(aaaaaaacVar.aaaaaaa0(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aaaaaeaa() {
        int i = this.aaaaeaaa;
        return i >= 2000 && i >= this.aaaeaaaa.size();
    }

    private void aaaeaaaa() {
        if (this.aaaaaaeo == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aeaaaaaa() {
        try {
            Writer writer = this.aaaaaaeo;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aaaaaaao), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaao.aaaaaaaa));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.aaaaaaau));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.aaaaaaae));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (aaaaaaac aaaaaaacVar : this.aaaeaaaa.values()) {
                    if (aaaaaaacVar.aaaaaaac != null) {
                        bufferedWriter.write("DIRTY " + aaaaaaacVar.aaaaaaaa + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + aaaaaaacVar.aaaaaaaa + aaaaaaacVar.aaaaaaaa() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.aaaaaaa0.exists()) {
                    aaaaaaaa(this.aaaaaaa0, this.aaaaaaac, true);
                }
                aaaaaaaa(this.aaaaaaao, this.aaaaaaa0, false);
                this.aaaaaaac.delete();
                this.aaaaaaeo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.aaaaaaa0, true), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaao.aaaaaaaa));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoaaaaaa() {
        while (this.aaaaaaav > this.aaaaaaan) {
            aaaaaaau((String) ((Map.Entry) this.aaaeaaaa.entrySet().iterator().next()).getKey());
        }
    }

    private void eaaaaaaa() {
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaa0 aaaaaaa0Var = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaa0(new FileInputStream(this.aaaaaaa0), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaao.aaaaaaaa);
        try {
            String aaaeaaaa = aaaaaaa0Var.aaaeaaaa();
            String aaaeaaaa2 = aaaaaaa0Var.aaaeaaaa();
            String aaaeaaaa3 = aaaaaaa0Var.aaaeaaaa();
            String aaaeaaaa4 = aaaaaaa0Var.aaaeaaaa();
            String aaaeaaaa5 = aaaaaaa0Var.aaaeaaaa();
            if (!"libcore.io.DiskLruCache".equals(aaaeaaaa) || !"1".equals(aaaeaaaa2) || !Integer.toString(this.aaaaaaau).equals(aaaeaaaa3) || !Integer.toString(this.aaaaaaae).equals(aaaeaaaa4) || !"".equals(aaaeaaaa5)) {
                throw new IOException("unexpected journal header: [" + aaaeaaaa + ", " + aaaeaaaa2 + ", " + aaaeaaaa4 + ", " + aaaeaaaa5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    aaaaaaac(aaaaaaa0Var.aaaeaaaa());
                    i++;
                } catch (EOFException unused) {
                    this.aaaaeaaa = i - this.aaaeaaaa.size();
                    io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaao.aaaaaaaa(aaaaaaa0Var);
                    return;
                }
            }
        } catch (Throwable th) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaao.aaaaaaaa(aaaaaaa0Var);
            throw th;
        }
    }

    public void aaaaeaaa() {
        close();
        io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaao.aaaaaaaa(this.aaaaaaaa);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.aaaaaaeo == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.aaaeaaaa.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                aaaaaaac aaaaaaacVar = (aaaaaaac) obj;
                if (aaaaaaacVar.aaaaaaac != null) {
                    aaaaaaacVar.aaaaaaac.aaaaaaaa();
                }
            }
            aoaaaaaa();
            this.aaaaaaeo.close();
            this.aaaaaaeo = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void flush() {
        aaaeaaaa();
        aoaaaaaa();
        this.aaaaaaeo.flush();
    }

    private void aaaaaaac(String str) {
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
                this.aaaeaaaa.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        aaaaaaac aaaaaaacVar = (aaaaaaac) this.aaaeaaaa.get(substring);
        CallableC0517aaaaaaaa callableC0517aaaaaaaa = null;
        if (aaaaaaacVar == null) {
            aaaaaaacVar = new aaaaaaac(this, substring, callableC0517aaaaaaaa);
            this.aaaeaaaa.put(substring, aaaaaaacVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            aaaaaaacVar.aaaaaaao = true;
            aaaaaaacVar.aaaaaaac = null;
            aaaaaaacVar.aaaaaaa0(split);
            return;
        }
        if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
            aaaaaaacVar.aaaaaaac = new aaaaaaao(this, aaaaaaacVar, callableC0517aaaaaaaa);
        } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
    }

    private void aaaaaaan(String str) {
        if (!aeaaaaaa.matcher(str).matches()) {
            throw new IllegalArgumentException(CtFAbx.BI9f7h("keys must match regex [a-z0-9_-]{1,64}: \"", str, "\""));
        }
    }

    public aaaaaaao aaaaaaa0(String str) {
        return aaaaaaaa(str, -1L);
    }

    public synchronized aaaaaaau aaaaaaao(String str) {
        Throwable th;
        InputStream inputStream;
        try {
            aaaeaaaa();
            aaaaaaan(str);
            aaaaaaac aaaaaaacVar = (aaaaaaac) this.aaaeaaaa.get(str);
            if (aaaaaaacVar == null) {
                return null;
            }
            if (!aaaaaaacVar.aaaaaaao) {
                return null;
            }
            InputStream[] inputStreamArr = new InputStream[this.aaaaaaae];
            for (int i = 0; i < this.aaaaaaae; i++) {
                try {
                    try {
                        try {
                            inputStreamArr[i] = new FileInputStream(aaaaaaacVar.aaaaaaaa(i));
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    } catch (FileNotFoundException unused) {
                        for (int i2 = 0; i2 < this.aaaaaaae && (inputStream = inputStreamArr[i2]) != null; i2++) {
                            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaao.aaaaaaaa(inputStream);
                        }
                        return null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    throw th;
                }
            }
            this.aaaaeaaa++;
            this.aaaaaaeo.append((CharSequence) ("READ " + str + '\n'));
            if (aaaaaeaa()) {
                this.aaaaaaea.submit(this.eaaaaaaa);
            }
            return new aaaaaaau(this, str, aaaaaaacVar.aaaaaaau, inputStreamArr, aaaaaaacVar.aaaaaaa0, null);
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public synchronized boolean aaaaaaau(String str) {
        try {
            aaaeaaaa();
            aaaaaaan(str);
            aaaaaaac aaaaaaacVar = (aaaaaaac) this.aaaeaaaa.get(str);
            if (aaaaaaacVar != null && aaaaaaacVar.aaaaaaac == null) {
                for (int i = 0; i < this.aaaaaaae; i++) {
                    File aaaaaaaa = aaaaaaacVar.aaaaaaaa(i);
                    if (aaaaaaaa.exists() && !aaaaaaaa.delete()) {
                        throw new IOException("failed to delete " + aaaaaaaa);
                    }
                    this.aaaaaaav -= aaaaaaacVar.aaaaaaa0[i];
                    aaaaaaacVar.aaaaaaa0[i] = 0;
                }
                this.aaaaeaaa++;
                this.aaaaaaeo.append((CharSequence) ("REMOVE " + str + '\n'));
                this.aaaeaaaa.remove(str);
                if (aaaaaeaa()) {
                    this.aaaaaaea.submit(this.eaaaaaaa);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String aaaaaaa0(InputStream inputStream) {
        return io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaao.aaaaaaaa((Reader) new InputStreamReader(inputStream, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaao.aaaaaaa0));
    }

    public static aaaaaaaa aaaaaaaa(File file, int i, int i2, long j) {
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
                    aaaaaaaa(file2, file3, false);
                }
            }
            aaaaaaaa aaaaaaaaVar = new aaaaaaaa(file, i, i2, j);
            if (aaaaaaaaVar.aaaaaaa0.exists()) {
                try {
                    aaaaaaaaVar.eaaaaaaa();
                    aaaaaaaaVar.aaaaaaea();
                    aaaaaaaaVar.aaaaaaeo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aaaaaaaaVar.aaaaaaa0, true), io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaa0aa.aaaaaaao.aaaaaaaa));
                    return aaaaaaaaVar;
                } catch (IOException e) {
                    PrintStream printStream = System.out;
                    Objects.toString(file);
                    e.getMessage();
                    printStream.getClass();
                    aaaaaaaaVar.aaaaeaaa();
                }
            }
            file.mkdirs();
            aaaaaaaa aaaaaaaaVar2 = new aaaaaaaa(file, i, i2, j);
            aaaaaaaaVar2.aeaaaaaa();
            return aaaaaaaaVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private static void aaaaaaaa(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void aaaaaaaa(File file, File file2, boolean z) {
        if (z) {
            aaaaaaaa(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private synchronized aaaaaaao aaaaaaaa(String str, long j) {
        aaaeaaaa();
        aaaaaaan(str);
        aaaaaaac aaaaaaacVar = (aaaaaaac) this.aaaeaaaa.get(str);
        CallableC0517aaaaaaaa callableC0517aaaaaaaa = null;
        if (j != -1 && (aaaaaaacVar == null || aaaaaaacVar.aaaaaaau != j)) {
            return null;
        }
        if (aaaaaaacVar != null) {
            if (aaaaaaacVar.aaaaaaac != null) {
                return null;
            }
        } else {
            aaaaaaacVar = new aaaaaaac(this, str, callableC0517aaaaaaaa);
            this.aaaeaaaa.put(str, aaaaaaacVar);
        }
        aaaaaaao aaaaaaaoVar = new aaaaaaao(this, aaaaaaacVar, callableC0517aaaaaaaa);
        aaaaaaacVar.aaaaaaac = aaaaaaaoVar;
        this.aaaaaaeo.write("DIRTY " + str + '\n');
        this.aaaaaaeo.flush();
        return aaaaaaaoVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aaaaaaaa(aaaaaaao aaaaaaaoVar, boolean z) {
        aaaaaaac aaaaaaacVar = aaaaaaaoVar.aaaaaaaa;
        if (aaaaaaacVar.aaaaaaac == aaaaaaaoVar) {
            if (z && !aaaaaaacVar.aaaaaaao) {
                for (int i = 0; i < this.aaaaaaae; i++) {
                    if (aaaaaaaoVar.aaaaaaa0[i]) {
                        if (!aaaaaaacVar.aaaaaaa0(i).exists()) {
                            aaaaaaaoVar.aaaaaaaa();
                            return;
                        }
                    } else {
                        aaaaaaaoVar.aaaaaaaa();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.aaaaaaae; i2++) {
                File aaaaaaa02 = aaaaaaacVar.aaaaaaa0(i2);
                if (z) {
                    if (aaaaaaa02.exists()) {
                        File aaaaaaaa = aaaaaaacVar.aaaaaaaa(i2);
                        aaaaaaa02.renameTo(aaaaaaaa);
                        long j = aaaaaaacVar.aaaaaaa0[i2];
                        long length = aaaaaaaa.length();
                        aaaaaaacVar.aaaaaaa0[i2] = length;
                        this.aaaaaaav = (this.aaaaaaav - j) + length;
                    }
                } else {
                    aaaaaaaa(aaaaaaa02);
                }
            }
            this.aaaaeaaa++;
            aaaaaaacVar.aaaaaaac = null;
            if (!(aaaaaaacVar.aaaaaaao | z)) {
                this.aaaeaaaa.remove(aaaaaaacVar.aaaaaaaa);
                this.aaaaaaeo.write("REMOVE " + aaaaaaacVar.aaaaaaaa + '\n');
            } else {
                aaaaaaacVar.aaaaaaao = true;
                this.aaaaaaeo.write("CLEAN " + aaaaaaacVar.aaaaaaaa + aaaaaaacVar.aaaaaaaa() + '\n');
                if (z) {
                    long j2 = this.aaaaaeaa;
                    this.aaaaaeaa = 1 + j2;
                    aaaaaaacVar.aaaaaaau = j2;
                }
            }
            this.aaaaaaeo.flush();
            if (this.aaaaaaav > this.aaaaaaan || aaaaaeaa()) {
                this.aaaaaaea.submit(this.eaaaaaaa);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }
}
