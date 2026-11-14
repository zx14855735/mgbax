package com.bytedance.sdk.component.hf.xj.xj.hf;

import java.io.InputStream;
import java.net.HttpURLConnection;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends InputStream {
    HttpURLConnection hf;
    InputStream xj;

    public kd(InputStream inputStream, HttpURLConnection httpURLConnection) {
        this.xj = inputStream;
        this.hf = httpURLConnection;
    }

    @Override // java.io.InputStream
    public int available() {
        InputStream inputStream = this.xj;
        if (inputStream != null) {
            return inputStream.available();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream inputStream = this.xj;
        if (inputStream != null) {
            inputStream.close();
            this.xj = null;
        }
        HttpURLConnection httpURLConnection = this.hf;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.hf = null;
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        InputStream inputStream = this.xj;
        if (inputStream != null) {
            inputStream.mark(i);
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InputStream inputStream = this.xj;
        if (inputStream != null) {
            return inputStream.markSupported();
        }
        return false;
    }

    @Override // java.io.InputStream
    public int read() {
        InputStream inputStream = this.xj;
        if (inputStream != null) {
            return inputStream.read();
        }
        return 0;
    }

    @Override // java.io.InputStream
    public void reset() {
        InputStream inputStream = this.xj;
        if (inputStream != null) {
            inputStream.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        InputStream inputStream = this.xj;
        if (inputStream != null) {
            return inputStream.skip(j);
        }
        return 0L;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        InputStream inputStream = this.xj;
        if (inputStream != null) {
            return inputStream.read(bArr);
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.xj;
        if (inputStream != null) {
            return inputStream.read(bArr, i, i2);
        }
        return 0;
    }
}
