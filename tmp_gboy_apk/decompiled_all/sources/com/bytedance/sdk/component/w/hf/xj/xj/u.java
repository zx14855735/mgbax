package com.bytedance.sdk.component.w.hf.xj.xj;

import ADYaiT.CtFAbx;
import com.bytedance.sdk.component.w.xj.pl;
import com.bytedance.sdk.component.w.xj.v;
import com.bytedance.sdk.component.w.xj.yo;
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

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class u implements Closeable, Flushable {
    static final /* synthetic */ boolean g = true;
    static final Pattern xj = Pattern.compile("[a-z0-9_-]{1,120}");
    private final File am;
    int c;
    boolean d;
    private final int e;
    boolean f;
    final com.bytedance.sdk.component.w.hf.xj.y.xj hf;
    private final Runnable ht;
    private long jk;
    com.bytedance.sdk.component.w.xj.u kd;
    boolean p;

    /* renamed from: pl, reason: collision with root package name */
    boolean f10242pl;
    private final Executor pz;
    private final File qt;
    boolean tf;
    final int u;
    private long v;
    final File w;
    final LinkedHashMap<String, hf> y;
    private long yo;
    private final File zg;

    public final class w implements Closeable {
        private final String hf;
        private final v[] u;
        private final long w;
        final /* synthetic */ u xj;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (v vVar : this.u) {
                com.bytedance.sdk.component.w.hf.xj.w.xj(vVar);
            }
        }

        public xj xj() {
            return this.xj.xj(this.hf, this.w);
        }
    }

    static {
        HZAXUA();
    }

    private static /* synthetic */ void HZAXUA() {
        char[] charArray = "¸´¶õ¼º¶¾õ¹´¢õ¨³¾··õ\u0091µ²\u0099©²¿¼¾".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 219);
        }
        String str = new String(charArray);
        char[] charArray2 = "¸·²µ²¯".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 219);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private com.bytedance.sdk.component.w.xj.u c() {
        return pl.xj(new kd(this.hf.w(this.am)) { // from class: com.bytedance.sdk.component.w.hf.xj.xj.u.1
            static final /* synthetic */ boolean xj = true;

            @Override // com.bytedance.sdk.component.w.hf.xj.xj.kd
            public void xj(IOException iOException) {
                if (!xj && !Thread.holdsLock(u.this)) {
                    throw new AssertionError();
                }
                u.this.f = true;
            }
        });
    }

    private synchronized void d() {
        if (u()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void f() {
        this.hf.delete(this.qt);
        Iterator<hf> it = this.y.values().iterator();
        while (it.hasNext()) {
            hf next = it.next();
            int i = 0;
            if (next.y == null) {
                while (i < this.u) {
                    this.v += next.hf[i];
                    i++;
                }
            } else {
                next.y = null;
                while (i < this.u) {
                    this.hf.delete(next.w[i]);
                    this.hf.delete(next.u[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    private void y() {
        com.bytedance.sdk.component.w.xj.kd xj2 = pl.xj(this.hf.xj(this.am));
        try {
            String zg = xj2.zg();
            String zg2 = xj2.zg();
            String zg3 = xj2.zg();
            String zg4 = xj2.zg();
            String zg5 = xj2.zg();
            if (!"libcore.io.DiskLruCache".equals(zg) || !"1".equals(zg2) || !Integer.toString(this.e).equals(zg3) || !Integer.toString(this.u).equals(zg4) || !"".equals(zg5)) {
                throw new IOException("unexpected journal header: [" + zg + ", " + zg2 + ", " + zg4 + ", " + zg5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    xj(xj2.zg());
                    i++;
                } catch (EOFException unused) {
                    this.c = i - this.y.size();
                    if (xj2.kd()) {
                        this.kd = c();
                    } else {
                        hf();
                    }
                    com.bytedance.sdk.component.w.hf.xj.w.xj(xj2);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.w.hf.xj.w.xj(xj2);
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.d && !this.tf) {
                for (hf hfVar : (hf[]) this.y.values().toArray(new hf[this.y.size()])) {
                    xj xjVar = hfVar.y;
                    if (xjVar != null) {
                        xjVar.w();
                    }
                }
                kd();
                this.kd.close();
                this.kd = null;
                this.tf = true;
                return;
            }
            this.tf = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void delete() {
        close();
        this.hf.y(this.w);
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        if (this.d) {
            d();
            kd();
            this.kd.flush();
        }
    }

    public synchronized void hf() {
        try {
            com.bytedance.sdk.component.w.xj.u uVar = this.kd;
            if (uVar != null) {
                uVar.close();
            }
            com.bytedance.sdk.component.w.xj.u xj2 = pl.xj(this.hf.hf(this.qt));
            try {
                xj2.hf("libcore.io.DiskLruCache").d(10);
                xj2.hf("1").d(10);
                xj2.pl(this.e).d(10);
                xj2.pl(this.u).d(10);
                xj2.d(10);
                for (hf hfVar : this.y.values()) {
                    if (hfVar.y != null) {
                        xj2.hf("DIRTY").d(32);
                        xj2.hf(hfVar.xj);
                        xj2.d(10);
                    } else {
                        xj2.hf("CLEAN").d(32);
                        xj2.hf(hfVar.xj);
                        hfVar.xj(xj2);
                        xj2.d(10);
                    }
                }
                xj2.close();
                if (this.hf.u(this.am)) {
                    this.hf.xj(this.am, this.zg);
                }
                this.hf.xj(this.qt, this.am);
                this.hf.delete(this.zg);
                this.kd = c();
                this.f = false;
                this.f10242pl = false;
            } catch (Throwable th) {
                xj2.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void kd() {
        while (this.v > this.yo) {
            xj(this.y.values().iterator().next());
        }
        this.p = false;
    }

    public synchronized boolean u() {
        return this.tf;
    }

    public boolean w() {
        int i = this.c;
        return i >= 2000 && i >= this.y.size();
    }

    public synchronized void xj() {
        try {
            if (!g && !Thread.holdsLock(this)) {
                throw new AssertionError();
            }
            if (this.d) {
                return;
            }
            if (this.hf.u(this.zg)) {
                if (this.hf.u(this.am)) {
                    this.hf.delete(this.zg);
                } else {
                    this.hf.xj(this.zg, this.am);
                }
            }
            if (this.hf.u(this.am)) {
                try {
                    y();
                    f();
                    this.d = true;
                    return;
                } catch (IOException e) {
                    com.bytedance.sdk.component.w.hf.xj.c.kd.hf().xj(5, "DiskLruCache " + this.w + " is corrupt: " + e.getMessage() + ", removing", e);
                    try {
                        delete();
                        this.tf = false;
                    } catch (Throwable th) {
                        this.tf = false;
                        throw th;
                    }
                }
            }
            hf();
            this.d = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final class xj {
        final boolean[] hf;
        private boolean u;
        final hf xj;

        public xj(hf hfVar) {
            this.xj = hfVar;
            this.hf = hfVar.kd ? null : new boolean[u.this.u];
        }

        public void hf() {
            synchronized (u.this) {
                try {
                    if (this.u) {
                        throw new IllegalStateException();
                    }
                    if (this.xj.y == this) {
                        u.this.xj(this, true);
                    }
                    this.u = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void w() {
            synchronized (u.this) {
                try {
                    if (this.u) {
                        throw new IllegalStateException();
                    }
                    if (this.xj.y == this) {
                        u.this.xj(this, false);
                    }
                    this.u = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void xj() {
            if (this.xj.y != this) {
                return;
            }
            int i = 0;
            while (true) {
                u uVar = u.this;
                if (i >= uVar.u) {
                    this.xj.y = null;
                    return;
                } else {
                    try {
                        uVar.hf.delete(this.xj.u[i]);
                    } catch (IOException unused) {
                    }
                    i++;
                }
            }
        }

        public yo xj(int i) {
            synchronized (u.this) {
                try {
                    if (!this.u) {
                        hf hfVar = this.xj;
                        if (hfVar.y != this) {
                            return pl.xj();
                        }
                        if (!hfVar.kd) {
                            this.hf[i] = true;
                        }
                        try {
                            return new kd(u.this.hf.hf(hfVar.u[i])) { // from class: com.bytedance.sdk.component.w.hf.xj.xj.u.xj.1
                                @Override // com.bytedance.sdk.component.w.hf.xj.xj.kd
                                public void xj(IOException iOException) {
                                    synchronized (u.this) {
                                        xj.this.xj();
                                    }
                                }
                            };
                        } catch (FileNotFoundException unused) {
                            return pl.xj();
                        }
                    }
                    throw new IllegalStateException();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final class hf {
        long c;
        final long[] hf;
        boolean kd;
        final File[] u;
        final File[] w;
        final String xj;
        xj y;

        public hf(String str) {
            this.xj = str;
            int i = u.this.u;
            this.hf = new long[i];
            this.w = new File[i];
            this.u = new File[i];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < u.this.u; i2++) {
                sb.append(i2);
                this.w[i2] = new File(u.this.w, sb.toString());
                sb.append(".tmp");
                this.u[i2] = new File(u.this.w, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException hf(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public void xj(String[] strArr) {
            if (strArr.length != u.this.u) {
                throw hf(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.hf[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw hf(strArr);
                }
            }
        }

        public void xj(com.bytedance.sdk.component.w.xj.u uVar) {
            for (long j : this.hf) {
                uVar.d(32).pl(j);
            }
        }
    }

    private void xj(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                substring = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.y.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i, indexOf2);
            }
            hf hfVar = this.y.get(substring);
            if (hfVar == null) {
                hfVar = new hf(substring);
                this.y.put(substring, hfVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                hfVar.kd = true;
                hfVar.y = null;
                hfVar.xj(split);
                return;
            }
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                hfVar.y = new xj(hfVar);
                return;
            } else {
                if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        throw new IOException("unexpected journal line: ".concat(str));
    }

    private void hf(String str) {
        if (!xj.matcher(str).matches()) {
            throw new IllegalArgumentException(CtFAbx.BI9f7h("keys must match regex [a-z0-9_-]{1,120}: \"", str, "\""));
        }
    }

    public synchronized xj xj(String str, long j) {
        xj();
        d();
        hf(str);
        hf hfVar = this.y.get(str);
        if (j != -1 && (hfVar == null || hfVar.c != j)) {
            return null;
        }
        if (hfVar != null && hfVar.y != null) {
            return null;
        }
        if (!this.p && !this.f10242pl) {
            this.kd.hf("DIRTY").d(32).hf(str).d(10);
            this.kd.flush();
            if (this.f) {
                return null;
            }
            if (hfVar == null) {
                hfVar = new hf(str);
                this.y.put(str, hfVar);
            }
            xj xjVar = new xj(hfVar);
            hfVar.y = xjVar;
            return xjVar;
        }
        this.pz.execute(this.ht);
        return null;
    }

    public synchronized void xj(xj xjVar, boolean z) {
        hf hfVar = xjVar.xj;
        if (hfVar.y == xjVar) {
            if (z && !hfVar.kd) {
                for (int i = 0; i < this.u; i++) {
                    if (xjVar.hf[i]) {
                        if (!this.hf.u(hfVar.u[i])) {
                            xjVar.w();
                            return;
                        }
                    } else {
                        xjVar.w();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i)));
                    }
                }
            }
            for (int i2 = 0; i2 < this.u; i2++) {
                File file = hfVar.u[i2];
                if (z) {
                    if (this.hf.u(file)) {
                        File file2 = hfVar.w[i2];
                        this.hf.xj(file, file2);
                        long j = hfVar.hf[i2];
                        long kd = this.hf.kd(file2);
                        hfVar.hf[i2] = kd;
                        this.v = (this.v - j) + kd;
                    }
                } else {
                    this.hf.delete(file);
                }
            }
            this.c++;
            hfVar.y = null;
            if (hfVar.kd | z) {
                hfVar.kd = true;
                this.kd.hf("CLEAN").d(32);
                this.kd.hf(hfVar.xj);
                hfVar.xj(this.kd);
                this.kd.d(10);
                if (z) {
                    long j2 = this.jk;
                    this.jk = 1 + j2;
                    hfVar.c = j2;
                }
            } else {
                this.y.remove(hfVar.xj);
                this.kd.hf("REMOVE").d(32);
                this.kd.hf(hfVar.xj);
                this.kd.d(10);
            }
            this.kd.flush();
            if (this.v > this.yo || w()) {
                this.pz.execute(this.ht);
            }
            return;
        }
        throw new IllegalStateException();
    }

    public boolean xj(hf hfVar) {
        xj xjVar = hfVar.y;
        if (xjVar != null) {
            xjVar.xj();
        }
        for (int i = 0; i < this.u; i++) {
            this.hf.delete(hfVar.w[i]);
            long j = this.v;
            long[] jArr = hfVar.hf;
            this.v = j - jArr[i];
            jArr[i] = 0;
        }
        this.c++;
        this.kd.hf("REMOVE").d(32).hf(hfVar.xj).d(10);
        this.y.remove(hfVar.xj);
        if (w()) {
            this.pz.execute(this.ht);
        }
        return true;
    }
}
