package com.bumptech.glide.load.data;

import java.io.FileOutputStream;
import java.io.OutputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n extends OutputStream {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final FileOutputStream f9979AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public byte[] f9980AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final HZUvgL.AaHO0E f9981AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f9982AzWtSf;

    public A5SV6n(FileOutputStream fileOutputStream, HZUvgL.AaHO0E aaHO0E) {
        this.f9979AcNBzu = fileOutputStream;
        this.f9981AmA8tU = aaHO0E;
        this.f9980AlLFFp = (byte[]) aaHO0E.ADYaiT(65536, byte[].class);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        FileOutputStream fileOutputStream = this.f9979AcNBzu;
        try {
            flush();
            fileOutputStream.close();
            byte[] bArr = this.f9980AlLFFp;
            if (bArr != null) {
                this.f9981AmA8tU.AYUAbz(bArr);
                this.f9980AlLFFp = null;
            }
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        int i = this.f9982AzWtSf;
        FileOutputStream fileOutputStream = this.f9979AcNBzu;
        if (i > 0) {
            fileOutputStream.write(this.f9980AlLFFp, 0, i);
            this.f9982AzWtSf = 0;
        }
        fileOutputStream.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        byte[] bArr = this.f9980AlLFFp;
        int i2 = this.f9982AzWtSf;
        int i3 = i2 + 1;
        this.f9982AzWtSf = i3;
        bArr[i2] = (byte) i;
        if (i3 != bArr.length || i3 <= 0) {
            return;
        }
        this.f9979AcNBzu.write(bArr, 0, i3);
        this.f9982AzWtSf = 0;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.f9982AzWtSf;
            FileOutputStream fileOutputStream = this.f9979AcNBzu;
            if (i6 == 0 && i4 >= this.f9980AlLFFp.length) {
                fileOutputStream.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.f9980AlLFFp.length - i6);
            System.arraycopy(bArr, i5, this.f9980AlLFFp, this.f9982AzWtSf, min);
            int i7 = this.f9982AzWtSf + min;
            this.f9982AzWtSf = i7;
            i3 += min;
            byte[] bArr2 = this.f9980AlLFFp;
            if (i7 == bArr2.length && i7 > 0) {
                fileOutputStream.write(bArr2, 0, i7);
                this.f9982AzWtSf = 0;
            }
        } while (i3 < i2);
    }
}
