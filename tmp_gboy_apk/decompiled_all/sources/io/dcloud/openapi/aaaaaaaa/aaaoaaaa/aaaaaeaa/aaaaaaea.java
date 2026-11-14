package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa;

import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class aaaaaaea implements aaaaaaac {
    public final aaaoaaaa aaaaaaa0;
    public final aaaaaaao aaaaaaaa = new aaaaaaao();
    boolean aaaaaaao;

    public aaaaaaea(aaaoaaaa aaaoaaaaVar) {
        if (aaaoaaaaVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.aaaaaaa0 = aaaoaaaaVar;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa
    public void aaaaaaa0(aaaaaaao aaaaaaaoVar, long j) {
        if (this.aaaaaaao) {
            throw new IllegalStateException("closed");
        }
        this.aaaaaaaa.aaaaaaa0(aaaaaaaoVar, j);
        aaaaaaeo();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    public aaaaaaao aaaaaaaa() {
        return this.aaaaaaaa;
    }

    public aaaaaaac aaaaaaeo() {
        if (this.aaaaaaao) {
            throw new IllegalStateException("closed");
        }
        long aaaeaaaa = this.aaaaaaaa.aaaeaaaa();
        if (aaaeaaaa > 0) {
            this.aaaaaaa0.aaaaaaa0(this.aaaaaaaa, aaaeaaaa);
        }
        return this;
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.aaaaaaao) {
            return;
        }
        try {
            aaaaaaao aaaaaaaoVar = this.aaaaaaaa;
            long j = aaaaaaaoVar.aaaaaaa0;
            if (j > 0) {
                this.aaaaaaa0.aaaaaaa0(aaaaaaaoVar, j);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.aaaaaaa0.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.aaaaaaao = true;
        if (th != null) {
            aaaaaaoa.aaaaaaaa(th);
        }
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa, java.io.Flushable
    public void flush() {
        if (this.aaaaaaao) {
            throw new IllegalStateException("closed");
        }
        aaaaaaao aaaaaaaoVar = this.aaaaaaaa;
        long j = aaaaaaaoVar.aaaaaaa0;
        if (j > 0) {
            this.aaaaaaa0.aaaaaaa0(aaaaaaaoVar, j);
        }
        this.aaaaaaa0.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.aaaaaaao;
    }

    public String toString() {
        return "buffer(" + this.aaaaaaa0 + ")";
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    public aaaaaaac write(byte[] bArr) {
        if (this.aaaaaaao) {
            throw new IllegalStateException("closed");
        }
        this.aaaaaaaa.write(bArr);
        return aaaaaaeo();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    public aaaaaaac writeByte(int i) {
        if (this.aaaaaaao) {
            throw new IllegalStateException("closed");
        }
        this.aaaaaaaa.writeByte(i);
        return aaaaaaeo();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    public aaaaaaac writeInt(int i) {
        if (this.aaaaaaao) {
            throw new IllegalStateException("closed");
        }
        this.aaaaaaaa.writeInt(i);
        return aaaaaaeo();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    public aaaaaaac writeShort(int i) {
        if (this.aaaaaaao) {
            throw new IllegalStateException("closed");
        }
        this.aaaaaaaa.writeShort(i);
        return aaaaaaeo();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    public aaaaaaac aaaaaaaa(String str) {
        if (this.aaaaaaao) {
            throw new IllegalStateException("closed");
        }
        this.aaaaaaaa.aaaaaaaa(str);
        return aaaaaaeo();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaoaaaa
    public aaaaaoaa aaaaaaa0() {
        return this.aaaaaaa0.aaaaaaa0();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    public aaaaaaac write(byte[] bArr, int i, int i2) {
        if (!this.aaaaaaao) {
            this.aaaaaaaa.write(bArr, i, i2);
            return aaaaaaeo();
        }
        throw new IllegalStateException("closed");
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaaac
    public aaaaaaac aaaaaaaa(long j) {
        if (!this.aaaaaaao) {
            this.aaaaaaaa.aaaaaaaa(j);
            return aaaaaaeo();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (!this.aaaaaaao) {
            int write = this.aaaaaaaa.write(byteBuffer);
            aaaaaaeo();
            return write;
        }
        throw new IllegalStateException("closed");
    }
}
