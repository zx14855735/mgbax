package com.kwad.sdk.pngencrypt;

import com.sigmob.sdk.downloader.f;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int aYA;
    private boolean aYB;
    private long aYC;
    private byte[] buf;
    private boolean eof;
    private int offset;
    private InputStream stream;

    public a(InputStream inputStream) {
        this(inputStream, f.a.d);
    }

    private void PD() {
        if (this.aYA > 0 || this.eof) {
            return;
        }
        try {
            this.offset = 0;
            int read = this.stream.read(this.buf);
            this.aYA = read;
            if (read == 0) {
                new PngjException("This should not happen: stream.read(buf) returned 0");
            } else if (read < 0) {
                close();
            } else {
                this.aYC += read;
            }
        } catch (IOException e) {
            new PngjException(e);
        }
    }

    public final int a(f fVar) {
        return a(fVar, Integer.MAX_VALUE);
    }

    public final int b(f fVar, int i) {
        int i2 = 36;
        while (i2 > 0) {
            int a2 = a(fVar, i2);
            if (a2 <= 0) {
                return a2;
            }
            i2 -= a2;
        }
        return 36;
    }

    public final void bT(boolean z) {
        this.aYB = z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.eof = true;
        this.buf = null;
        this.aYA = 0;
        this.offset = 0;
        InputStream inputStream = this.stream;
        if (inputStream != null && this.aYB) {
            com.kwad.sdk.pngencrypt.a.a.closeQuietly(inputStream);
        }
        this.stream = null;
    }

    private a(InputStream inputStream, int i) {
        this.eof = false;
        this.aYB = true;
        this.aYC = 0L;
        this.stream = inputStream;
        this.buf = new byte[f.a.d];
    }

    private int a(f fVar, int i) {
        PD();
        if (i <= 0 || i >= this.aYA) {
            i = this.aYA;
        }
        if (i <= 0) {
            if (!this.eof) {
                new PngjException("This should not happen");
            }
            return fVar.isDone() ? -1 : 0;
        }
        int a2 = fVar.a(this.buf, this.offset, i);
        if (a2 > 0) {
            this.offset += a2;
            this.aYA -= a2;
        }
        if (a2 > 0) {
            return a2;
        }
        if (!fVar.isDone()) {
            new PngjException("This should not happen!");
        }
        return -1;
    }
}
