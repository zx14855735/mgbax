package com.fl.saas.videocache;

import java.io.ByteArrayInputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ByteArraySource implements Source {
    private ByteArrayInputStream arrayInputStream;
    private final byte[] data;

    public ByteArraySource(byte[] bArr) {
        this.data = bArr;
    }

    @Override // com.fl.saas.videocache.Source
    public void close() {
    }

    @Override // com.fl.saas.videocache.Source
    public long length() {
        return this.data.length;
    }

    @Override // com.fl.saas.videocache.Source
    public void open(long j) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.data);
        this.arrayInputStream = byteArrayInputStream;
        byteArrayInputStream.skip(j);
    }

    @Override // com.fl.saas.videocache.Source
    public int read(byte[] bArr) {
        return this.arrayInputStream.read(bArr, 0, bArr.length);
    }
}
