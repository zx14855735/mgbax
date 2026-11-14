package okhttp3.internal.cache;

import ADYaiT.CtFAbx;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AMqCpz implements Closeable, Flushable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long ANY_SEQUENCE_NUMBER = -1;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public static final /* synthetic */ int f14070AcNBzu = 0;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    boolean closed;
    final File directory;
    private final Executor executor;
    final RmWSka.A4TApA fileSystem;
    boolean hasJournalErrors;
    boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    BufferedSink journalWriter;
    private long maxSize;
    boolean mostRecentRebuildFailed;
    boolean mostRecentTrimFailed;
    int redundantOpCount;
    final int valueCount;
    private long size = 0;
    final LinkedHashMap<String, A5SV6n> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long nextSequenceNumber = 0;
    private final Runnable cleanupRunnable = new A2egSU();

    public class A2egSU implements Runnable {
        public A2egSU() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (AMqCpz.this) {
                AMqCpz aMqCpz = AMqCpz.this;
                if ((!aMqCpz.initialized) || aMqCpz.closed) {
                    return;
                }
                try {
                    aMqCpz.B3GDIM();
                } catch (IOException unused) {
                    AMqCpz.this.mostRecentTrimFailed = true;
                }
                try {
                    if (AMqCpz.this.AZOQYO()) {
                        AMqCpz.this.AmA8tU();
                        AMqCpz.this.redundantOpCount = 0;
                    }
                } catch (IOException unused2) {
                    AMqCpz aMqCpz2 = AMqCpz.this;
                    aMqCpz2.mostRecentRebuildFailed = true;
                    aMqCpz2.journalWriter = Okio.buffer(Okio.blackhole());
                }
            }
        }
    }

    public final class A4TApA {
        private boolean done;
        final A5SV6n entry;
        final boolean[] written;

        public A4TApA(A5SV6n a5SV6n) {
            this.entry = a5SV6n;
            this.written = a5SV6n.readable ? null : new boolean[AMqCpz.this.valueCount];
        }

        public final void A2egSU() {
            synchronized (AMqCpz.this) {
                try {
                    if (this.done) {
                        throw new IllegalStateException();
                    }
                    if (this.entry.currentEditor == this) {
                        AMqCpz.this.A4TApA(this, false);
                    }
                    this.done = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void A4TApA() {
            synchronized (AMqCpz.this) {
                try {
                    if (this.done) {
                        throw new IllegalStateException();
                    }
                    if (this.entry.currentEditor == this) {
                        AMqCpz.this.A4TApA(this, true);
                    }
                    this.done = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void A5SV6n() {
            if (this.entry.currentEditor != this) {
                return;
            }
            int i = 0;
            while (true) {
                AMqCpz aMqCpz = AMqCpz.this;
                if (i >= aMqCpz.valueCount) {
                    this.entry.currentEditor = null;
                    return;
                } else {
                    try {
                        aMqCpz.fileSystem.delete(this.entry.dirtyFiles[i]);
                    } catch (IOException unused) {
                    }
                    i++;
                }
            }
        }

        public final Sink ADYaiT(int i) {
            Sink sink;
            synchronized (AMqCpz.this) {
                try {
                    if (this.done) {
                        throw new IllegalStateException();
                    }
                    A5SV6n a5SV6n = this.entry;
                    if (a5SV6n.currentEditor != this) {
                        return Okio.blackhole();
                    }
                    if (!a5SV6n.readable) {
                        this.written[i] = true;
                    }
                    File file = a5SV6n.dirtyFiles[i];
                    try {
                        ((RmWSka.A2egSU) AMqCpz.this.fileSystem).getClass();
                        try {
                            sink = Okio.sink(file);
                        } catch (FileNotFoundException unused) {
                            file.getParentFile().mkdirs();
                            sink = Okio.sink(file);
                        }
                        return new AYUAbz(this, sink);
                    } catch (FileNotFoundException unused2) {
                        return Okio.blackhole();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final class A5SV6n {
        final File[] cleanFiles;
        A4TApA currentEditor;
        final File[] dirtyFiles;
        final String key;
        final long[] lengths;
        boolean readable;
        long sequenceNumber;

        public A5SV6n(String str) {
            this.key = str;
            int i = AMqCpz.this.valueCount;
            this.lengths = new long[i];
            this.cleanFiles = new File[i];
            this.dirtyFiles = new File[i];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < AMqCpz.this.valueCount; i2++) {
                sb.append(i2);
                this.cleanFiles[i2] = new File(AMqCpz.this.directory, sb.toString());
                sb.append(".tmp");
                this.dirtyFiles[i2] = new File(AMqCpz.this.directory, sb.toString());
                sb.setLength(length);
            }
        }

        public final ADYaiT A2egSU() {
            Source source;
            if (!Thread.holdsLock(AMqCpz.this)) {
                throw new AssertionError();
            }
            Source[] sourceArr = new Source[AMqCpz.this.valueCount];
            long[] jArr = (long[]) this.lengths.clone();
            int i = 0;
            int i2 = 0;
            while (true) {
                try {
                    AMqCpz aMqCpz = AMqCpz.this;
                    if (i2 >= aMqCpz.valueCount) {
                        return aMqCpz.new ADYaiT(this.key, this.sequenceNumber, sourceArr, jArr);
                    }
                    RmWSka.A4TApA a4TApA = aMqCpz.fileSystem;
                    File file = this.cleanFiles[i2];
                    ((RmWSka.A2egSU) a4TApA).getClass();
                    sourceArr[i2] = Okio.source(file);
                    i2++;
                } catch (FileNotFoundException unused) {
                    while (true) {
                        AMqCpz aMqCpz2 = AMqCpz.this;
                        if (i >= aMqCpz2.valueCount || (source = sourceArr[i]) == null) {
                            try {
                                aMqCpz2.B25kr6(this);
                                return null;
                            } catch (IOException unused2) {
                                return null;
                            }
                        }
                        okhttp3.internal.A5SV6n.ARc23Z(source);
                        i++;
                    }
                }
            }
        }
    }

    public final class ADYaiT implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final Source[] sources;

        public ADYaiT(String str, long j, Source[] sourceArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.sources = sourceArr;
            this.lengths = jArr;
        }

        public final A4TApA A4TApA() {
            return AMqCpz.this.A5SV6n(this.key, this.sequenceNumber);
        }

        public final Source A5SV6n(int i) {
            return this.sources[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            for (Source source : this.sources) {
                okhttp3.internal.A5SV6n.ARc23Z(source);
            }
        }
    }

    static {
        uxMJsC();
    }

    public AMqCpz(RmWSka.A4TApA a4TApA, File file, int i, int i2, long j, Executor executor) {
        this.fileSystem = a4TApA;
        this.directory = file;
        this.appVersion = i;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i2;
        this.maxSize = j;
        this.executor = executor;
    }

    public static void B4ZgIw(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            throw new IllegalArgumentException(CtFAbx.BI9f7h("keys must match regex [a-z0-9_-]{1,120}: \"", str, "\""));
        }
    }

    private static /* synthetic */ void uxMJsC() {
        char[] charArray = "w{y:suyq:v{m:g|qxx:^z}Vf}psq".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 20);
        }
        String str = new String(charArray);
        char[] charArray2 = "wx}z}`".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 20);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final synchronized void A2egSU() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void A4TApA(A4TApA a4TApA, boolean z) {
        A5SV6n a5SV6n = a4TApA.entry;
        if (a5SV6n.currentEditor != a4TApA) {
            throw new IllegalStateException();
        }
        if (z && !a5SV6n.readable) {
            for (int i = 0; i < this.valueCount; i++) {
                if (!a4TApA.written[i]) {
                    a4TApA.A2egSU();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                RmWSka.A4TApA a4TApA2 = this.fileSystem;
                File file = a5SV6n.dirtyFiles[i];
                ((RmWSka.A2egSU) a4TApA2).getClass();
                if (!file.exists()) {
                    a4TApA.A2egSU();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.valueCount; i2++) {
            File file2 = a5SV6n.dirtyFiles[i2];
            if (z) {
                ((RmWSka.A2egSU) this.fileSystem).getClass();
                if (file2.exists()) {
                    File file3 = a5SV6n.cleanFiles[i2];
                    ((RmWSka.A2egSU) this.fileSystem).A4TApA(file2, file3);
                    long j = a5SV6n.lengths[i2];
                    ((RmWSka.A2egSU) this.fileSystem).getClass();
                    long length = file3.length();
                    a5SV6n.lengths[i2] = length;
                    this.size = (this.size - j) + length;
                }
            } else {
                this.fileSystem.delete(file2);
            }
        }
        this.redundantOpCount++;
        a5SV6n.currentEditor = null;
        if (a5SV6n.readable || z) {
            a5SV6n.readable = true;
            this.journalWriter.writeUtf8(CLEAN).writeByte(32);
            this.journalWriter.writeUtf8(a5SV6n.key);
            BufferedSink bufferedSink = this.journalWriter;
            for (long j2 : a5SV6n.lengths) {
                bufferedSink.writeByte(32).writeDecimalLong(j2);
            }
            this.journalWriter.writeByte(10);
            if (z) {
                long j3 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j3;
                a5SV6n.sequenceNumber = j3;
            }
        } else {
            this.lruEntries.remove(a5SV6n.key);
            this.journalWriter.writeUtf8(REMOVE).writeByte(32);
            this.journalWriter.writeUtf8(a5SV6n.key);
            this.journalWriter.writeByte(10);
        }
        this.journalWriter.flush();
        if (this.size > this.maxSize || AZOQYO()) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public final synchronized A4TApA A5SV6n(String str, long j) {
        AYUAbz();
        A2egSU();
        B4ZgIw(str);
        A5SV6n a5SV6n = this.lruEntries.get(str);
        if (j != -1 && (a5SV6n == null || a5SV6n.sequenceNumber != j)) {
            return null;
        }
        if (a5SV6n != null && a5SV6n.currentEditor != null) {
            return null;
        }
        if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            this.journalWriter.writeUtf8(DIRTY).writeByte(32).writeUtf8(str).writeByte(10);
            this.journalWriter.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (a5SV6n == null) {
                a5SV6n = new A5SV6n(str);
                this.lruEntries.put(str, a5SV6n);
            }
            A4TApA a4TApA = new A4TApA(a5SV6n);
            a5SV6n.currentEditor = a4TApA;
            return a4TApA;
        }
        this.executor.execute(this.cleanupRunnable);
        return null;
    }

    public final synchronized void ADYaiT() {
        try {
            AYUAbz();
            for (A5SV6n a5SV6n : (A5SV6n[]) this.lruEntries.values().toArray(new A5SV6n[this.lruEntries.size()])) {
                B25kr6(a5SV6n);
            }
            this.mostRecentTrimFailed = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized ADYaiT AMqCpz(String str) {
        AYUAbz();
        A2egSU();
        B4ZgIw(str);
        A5SV6n a5SV6n = this.lruEntries.get(str);
        if (a5SV6n != null && a5SV6n.readable) {
            ADYaiT A2egSU2 = a5SV6n.A2egSU();
            if (A2egSU2 == null) {
                return null;
            }
            this.redundantOpCount++;
            this.journalWriter.writeUtf8(READ).writeByte(32).writeUtf8(str).writeByte(10);
            if (AZOQYO()) {
                this.executor.execute(this.cleanupRunnable);
            }
            return A2egSU2;
        }
        return null;
    }

    public final File ARc23Z() {
        return this.directory;
    }

    public final synchronized long ASJ6gh() {
        return this.maxSize;
    }

    public final synchronized void AYUAbz() {
        try {
            if (this.initialized) {
                return;
            }
            RmWSka.A4TApA a4TApA = this.fileSystem;
            File file = this.journalFileBackup;
            ((RmWSka.A2egSU) a4TApA).getClass();
            if (file.exists()) {
                RmWSka.A4TApA a4TApA2 = this.fileSystem;
                File file2 = this.journalFile;
                ((RmWSka.A2egSU) a4TApA2).getClass();
                if (file2.exists()) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    ((RmWSka.A2egSU) this.fileSystem).A4TApA(this.journalFileBackup, this.journalFile);
                }
            }
            RmWSka.A4TApA a4TApA3 = this.fileSystem;
            File file3 = this.journalFile;
            ((RmWSka.A2egSU) a4TApA3).getClass();
            if (file3.exists()) {
                try {
                    AcNBzu();
                    AaHO0E();
                    this.initialized = true;
                    return;
                } catch (IOException e) {
                    okhttp3.internal.platform.ARc23Z.AZOQYO().AmA8tU(5, "DiskLruCache " + this.directory + " is corrupt: " + e.getMessage() + ", removing", e);
                    try {
                        delete();
                        this.closed = false;
                    } catch (Throwable th) {
                        this.closed = false;
                        throw th;
                    }
                }
            }
            AmA8tU();
            this.initialized = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final boolean AZOQYO() {
        int i = this.redundantOpCount;
        return i >= 2000 && i >= this.lruEntries.size();
    }

    public final BufferedSink AZkASS() {
        Sink appendingSink;
        RmWSka.A4TApA a4TApA = this.fileSystem;
        File file = this.journalFile;
        ((RmWSka.A2egSU) a4TApA).getClass();
        try {
            appendingSink = Okio.appendingSink(file);
        } catch (FileNotFoundException unused) {
            file.getParentFile().mkdirs();
            appendingSink = Okio.appendingSink(file);
        }
        return Okio.buffer(new ARc23Z(this, appendingSink));
    }

    public final void AaHO0E() {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<A5SV6n> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            A5SV6n next = it.next();
            int i = 0;
            if (next.currentEditor == null) {
                while (i < this.valueCount) {
                    this.size += next.lengths[i];
                    i++;
                }
            } else {
                next.currentEditor = null;
                while (i < this.valueCount) {
                    this.fileSystem.delete(next.cleanFiles[i]);
                    this.fileSystem.delete(next.dirtyFiles[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    public final void AcNBzu() {
        RmWSka.A4TApA a4TApA = this.fileSystem;
        File file = this.journalFile;
        ((RmWSka.A2egSU) a4TApA).getClass();
        BufferedSource buffer = Okio.buffer(Okio.source(file));
        try {
            String readUtf8LineStrict = buffer.readUtf8LineStrict();
            String readUtf8LineStrict2 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict3 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict4 = buffer.readUtf8LineStrict();
            String readUtf8LineStrict5 = buffer.readUtf8LineStrict();
            if (!MAGIC.equals(readUtf8LineStrict) || !"1".equals(readUtf8LineStrict2) || !Integer.toString(this.appVersion).equals(readUtf8LineStrict3) || !Integer.toString(this.valueCount).equals(readUtf8LineStrict4) || !"".equals(readUtf8LineStrict5)) {
                throw new IOException("unexpected journal header: [" + readUtf8LineStrict + ", " + readUtf8LineStrict2 + ", " + readUtf8LineStrict4 + ", " + readUtf8LineStrict5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    AlLFFp(buffer.readUtf8LineStrict());
                    i++;
                } catch (EOFException unused) {
                    this.redundantOpCount = i - this.lruEntries.size();
                    if (buffer.exhausted()) {
                        this.journalWriter = AZkASS();
                    } else {
                        AmA8tU();
                    }
                    okhttp3.internal.A5SV6n.ARc23Z(buffer);
                    return;
                }
            }
        } catch (Throwable th) {
            okhttp3.internal.A5SV6n.ARc23Z(buffer);
            throw th;
        }
    }

    public final void AlLFFp(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith(REMOVE)) {
                this.lruEntries.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        A5SV6n a5SV6n = this.lruEntries.get(substring);
        if (a5SV6n == null) {
            a5SV6n = new A5SV6n(substring);
            this.lruEntries.put(substring, a5SV6n);
        }
        if (indexOf2 == -1 || indexOf != 5 || !str.startsWith(CLEAN)) {
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DIRTY)) {
                a5SV6n.currentEditor = new A4TApA(a5SV6n);
                return;
            } else {
                if (indexOf2 != -1 || indexOf != 4 || !str.startsWith(READ)) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String[] split = str.substring(indexOf2 + 1).split(" ");
        a5SV6n.readable = true;
        a5SV6n.currentEditor = null;
        if (split.length != AMqCpz.this.valueCount) {
            throw new IOException("unexpected journal line: " + Arrays.toString(split));
        }
        for (int i2 = 0; i2 < split.length; i2++) {
            try {
                a5SV6n.lengths[i2] = Long.parseLong(split[i2]);
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + Arrays.toString(split));
            }
        }
    }

    public final synchronized void AmA8tU() {
        Sink sink;
        try {
            BufferedSink bufferedSink = this.journalWriter;
            if (bufferedSink != null) {
                bufferedSink.close();
            }
            RmWSka.A4TApA a4TApA = this.fileSystem;
            File file = this.journalFileTmp;
            ((RmWSka.A2egSU) a4TApA).getClass();
            try {
                sink = Okio.sink(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                sink = Okio.sink(file);
            }
            BufferedSink buffer = Okio.buffer(sink);
            try {
                buffer.writeUtf8(MAGIC).writeByte(10);
                buffer.writeUtf8("1").writeByte(10);
                buffer.writeDecimalLong(this.appVersion).writeByte(10);
                buffer.writeDecimalLong(this.valueCount).writeByte(10);
                buffer.writeByte(10);
                Iterator<A5SV6n> it = this.lruEntries.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    A5SV6n next = it.next();
                    if (next.currentEditor != null) {
                        buffer.writeUtf8(DIRTY).writeByte(32);
                        buffer.writeUtf8(next.key);
                        buffer.writeByte(10);
                    } else {
                        buffer.writeUtf8(CLEAN).writeByte(32);
                        buffer.writeUtf8(next.key);
                        for (long j : next.lengths) {
                            buffer.writeByte(32).writeDecimalLong(j);
                        }
                        buffer.writeByte(10);
                    }
                }
                buffer.close();
                RmWSka.A4TApA a4TApA2 = this.fileSystem;
                File file2 = this.journalFile;
                ((RmWSka.A2egSU) a4TApA2).getClass();
                if (file2.exists()) {
                    ((RmWSka.A2egSU) this.fileSystem).A4TApA(this.journalFile, this.journalFileBackup);
                }
                ((RmWSka.A2egSU) this.fileSystem).A4TApA(this.journalFileTmp, this.journalFile);
                this.fileSystem.delete(this.journalFileBackup);
                this.journalWriter = AZkASS();
                this.hasJournalErrors = false;
                this.mostRecentRebuildFailed = false;
            } catch (Throwable th) {
                buffer.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void AzWtSf(String str) {
        AYUAbz();
        A2egSU();
        B4ZgIw(str);
        A5SV6n a5SV6n = this.lruEntries.get(str);
        if (a5SV6n == null) {
            return;
        }
        B25kr6(a5SV6n);
        if (this.size <= this.maxSize) {
            this.mostRecentTrimFailed = false;
        }
    }

    public final void B25kr6(A5SV6n a5SV6n) {
        A4TApA a4TApA = a5SV6n.currentEditor;
        if (a4TApA != null) {
            a4TApA.A5SV6n();
        }
        for (int i = 0; i < this.valueCount; i++) {
            this.fileSystem.delete(a5SV6n.cleanFiles[i]);
            long j = this.size;
            long[] jArr = a5SV6n.lengths;
            this.size = j - jArr[i];
            jArr[i] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.writeUtf8(REMOVE).writeByte(32).writeUtf8(a5SV6n.key).writeByte(10);
        this.lruEntries.remove(a5SV6n.key);
        if (AZOQYO()) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public final synchronized long B2KMhB() {
        AYUAbz();
        return this.size;
    }

    public final void B3GDIM() {
        while (this.size > this.maxSize) {
            B25kr6(this.lruEntries.values().iterator().next());
        }
        this.mostRecentTrimFailed = false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.initialized && !this.closed) {
                for (A5SV6n a5SV6n : (A5SV6n[]) this.lruEntries.values().toArray(new A5SV6n[this.lruEntries.size()])) {
                    A4TApA a4TApA = a5SV6n.currentEditor;
                    if (a4TApA != null) {
                        a4TApA.A2egSU();
                    }
                }
                B3GDIM();
                this.journalWriter.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            this.closed = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void delete() {
        close();
        ((RmWSka.A2egSU) this.fileSystem).A2egSU(this.directory);
    }

    @Override // java.io.Flushable
    public final synchronized void flush() {
        if (this.initialized) {
            A2egSU();
            B3GDIM();
            this.journalWriter.flush();
        }
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }
}
