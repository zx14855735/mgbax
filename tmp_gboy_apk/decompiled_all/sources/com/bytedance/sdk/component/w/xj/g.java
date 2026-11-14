package com.bytedance.sdk.component.w.xj;

import java.nio.ByteBuffer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class g implements u {
    public final yo hf;
    boolean w;
    public final w xj = new w();

    public g(yo yoVar) {
        if (yoVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.hf = yoVar;
    }

    @Override // com.bytedance.sdk.component.w.xj.yo
    public void a_(w wVar, long j) {
        if (this.w) {
            throw new IllegalStateException("closed");
        }
        this.xj.a_(wVar, j);
        pz();
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    public u c(int i) {
        if (this.w) {
            throw new IllegalStateException("closed");
        }
        this.xj.c(i);
        return pz();
    }

    @Override // com.bytedance.sdk.component.w.xj.yo, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.w) {
            return;
        }
        try {
            w wVar = this.xj;
            long j = wVar.hf;
            if (j > 0) {
                this.hf.a_(wVar, j);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.hf.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.w = true;
        if (th != null) {
            pz.xj(th);
        }
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    public u d(int i) {
        if (this.w) {
            throw new IllegalStateException("closed");
        }
        this.xj.d(i);
        return pz();
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    public u f(int i) {
        if (this.w) {
            throw new IllegalStateException("closed");
        }
        this.xj.f(i);
        return pz();
    }

    @Override // com.bytedance.sdk.component.w.xj.u, com.bytedance.sdk.component.w.xj.yo, java.io.Flushable
    public void flush() {
        if (this.w) {
            throw new IllegalStateException("closed");
        }
        w wVar = this.xj;
        long j = wVar.hf;
        if (j > 0) {
            this.hf.a_(wVar, j);
        }
        this.hf.flush();
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    public u hf(y yVar) {
        if (this.w) {
            throw new IllegalStateException("closed");
        }
        this.xj.hf(yVar);
        return pz();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.w;
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    public u p(long j) {
        if (this.w) {
            throw new IllegalStateException("closed");
        }
        this.xj.p(j);
        return pz();
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    public u pl(long j) {
        if (this.w) {
            throw new IllegalStateException("closed");
        }
        this.xj.pl(j);
        return pz();
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    public u pz() {
        if (this.w) {
            throw new IllegalStateException("closed");
        }
        long c = this.xj.c();
        if (c > 0) {
            this.hf.a_(this.xj, c);
        }
        return this;
    }

    public String toString() {
        return "buffer(" + this.hf + ")";
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    public w w() {
        return this.xj;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (this.w) {
            throw new IllegalStateException("closed");
        }
        int write = this.xj.write(byteBuffer);
        pz();
        return write;
    }

    @Override // com.bytedance.sdk.component.w.xj.yo
    public jk xj() {
        return this.hf.xj();
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    public u w(byte[] bArr) {
        if (this.w) {
            throw new IllegalStateException("closed");
        }
        this.xj.w(bArr);
        return pz();
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    public u hf(String str) {
        if (!this.w) {
            this.xj.hf(str);
            return pz();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.component.w.xj.u
    public u w(byte[] bArr, int i, int i2) {
        if (!this.w) {
            this.xj.w(bArr, i, i2);
            return pz();
        }
        throw new IllegalStateException("closed");
    }
}
