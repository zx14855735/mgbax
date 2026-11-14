package com.octopus.ad.internal.a.a;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kuaishou.weapon.p0.t;
import com.octopus.ad.internal.a.p;
import java.io.File;
import java.io.RandomAccessFile;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b implements com.octopus.ad.internal.a.a {

    /* renamed from: a, reason: collision with root package name */
    public File f12383a;
    private final a b;
    private RandomAccessFile c;

    public b(File file, a aVar) {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.b = aVar;
            d.a(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile(), file.getName() + ".download");
            }
            this.f12383a = file2;
            this.c = new RandomAccessFile(this.f12383a, exists ? t.k : "rw");
        } catch (Exception e) {
            throw new p(A2egSU.AlLFFp("Error using file ", file, " as disc cache"), e);
        }
    }

    @Override // com.octopus.ad.internal.a.a
    public synchronized long a() {
        try {
        } catch (Exception e) {
            throw new p("Error reading length of file " + this.f12383a, e);
        }
        return (int) this.c.length();
    }

    @Override // com.octopus.ad.internal.a.a
    public synchronized void b() {
        try {
            this.c.close();
            this.b.a(this.f12383a);
        } catch (Exception e) {
            throw new p("Error closing file " + this.f12383a, e);
        }
    }

    @Override // com.octopus.ad.internal.a.a
    public synchronized void c() {
        if (d()) {
            return;
        }
        b();
        File file = new File(this.f12383a.getParentFile(), this.f12383a.getName().substring(0, this.f12383a.getName().length() - 9));
        if (!this.f12383a.renameTo(file)) {
            throw new p("Error renaming file " + this.f12383a + " to " + file + " for completion!");
        }
        this.f12383a = file;
        try {
            this.c = new RandomAccessFile(this.f12383a, t.k);
            this.b.a(this.f12383a);
        } catch (Exception e) {
            throw new p("Error opening " + this.f12383a + " as disc cache", e);
        }
    }

    @Override // com.octopus.ad.internal.a.a
    public synchronized boolean d() {
        return !a(this.f12383a);
    }

    @Override // com.octopus.ad.internal.a.a
    public synchronized int a(byte[] bArr, long j, int i) {
        try {
            this.c.seek(j);
        } catch (Exception e) {
            throw new p(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(a()), Integer.valueOf(bArr.length)), e);
        }
        return this.c.read(bArr, 0, i);
    }

    @Override // com.octopus.ad.internal.a.a
    public synchronized void a(byte[] bArr, int i) {
        try {
            if (!d()) {
                this.c.seek(a());
                this.c.write(bArr, 0, i);
            } else {
                throw new p("Error append cache: cache file " + this.f12383a + " is completed!");
            }
        } catch (Exception e) {
            throw new p(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.c, Integer.valueOf(bArr.length)), e);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }
}
