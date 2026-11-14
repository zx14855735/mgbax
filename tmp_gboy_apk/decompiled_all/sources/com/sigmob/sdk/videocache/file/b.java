package com.sigmob.sdk.videocache.file;

import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.kuaishou.weapon.p0.t;
import com.sigmob.sdk.videocache.q;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class b implements com.sigmob.sdk.videocache.c {
    private static final String b = ".download";

    /* renamed from: a, reason: collision with root package name */
    public File f13721a;
    private final a c;
    private RandomAccessFile d;

    public b(File file) {
        this(file, new i());
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized int a(byte[] bArr, long j, int i) {
        try {
            this.d.seek(j);
        } catch (IOException e) {
            throw new q(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(a()), Integer.valueOf(bArr.length)), e);
        }
        return this.d.read(bArr, 0, i);
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized void b() {
        try {
            this.d.close();
            this.c.a(this.f13721a);
        } catch (IOException e) {
            throw new q("Error closing file " + this.f13721a, e);
        }
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized void c() {
        if (d()) {
            return;
        }
        b();
        File file = new File(this.f13721a.getParentFile(), this.f13721a.getName().substring(0, this.f13721a.getName().length() - 9));
        if (!this.f13721a.renameTo(file)) {
            throw new q("Error renaming file " + this.f13721a + " to " + file + " for completion!");
        }
        this.f13721a = file;
        try {
            this.d = new RandomAccessFile(this.f13721a, t.k);
            this.c.a(this.f13721a);
        } catch (IOException e) {
            throw new q("Error opening " + this.f13721a + " as disc cache", e);
        }
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized boolean d() {
        return !a(this.f13721a);
    }

    public File e() {
        return this.f13721a;
    }

    public b(File file, a aVar) {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.c = aVar;
            d.a(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile(), file.getName() + b);
            }
            this.f13721a = file2;
            this.d = new RandomAccessFile(this.f13721a, exists ? t.k : "rw");
        } catch (IOException e) {
            throw new q(A2egSU.AlLFFp("Error using file ", file, " as disc cache"), e);
        }
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized long a() {
        try {
        } catch (IOException e) {
            throw new q("Error reading length of file " + this.f13721a, e);
        }
        return (int) this.d.length();
    }

    @Override // com.sigmob.sdk.videocache.c
    public synchronized void a(byte[] bArr, int i) {
        try {
            if (d()) {
                throw new q("Error append cache: cache file " + this.f13721a + " is completed!");
            }
            this.d.seek(a());
            this.d.write(bArr, 0, i);
        } catch (IOException e) {
            throw new q(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.d, Integer.valueOf(bArr.length)), e);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(b);
    }
}
