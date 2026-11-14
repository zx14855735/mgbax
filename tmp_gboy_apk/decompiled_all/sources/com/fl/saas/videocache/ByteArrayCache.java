package com.fl.saas.videocache;

import ADYaiT.CtFAbx;
import java.io.ByteArrayInputStream;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ByteArrayCache implements Cache {
    private volatile boolean completed;
    private volatile byte[] data;

    public ByteArrayCache() {
        this(new byte[0]);
    }

    @Override // com.fl.saas.videocache.Cache
    public void append(byte[] bArr, int i) {
        Preconditions.checkNotNull(this.data);
        Preconditions.checkArgument(i >= 0 && i <= bArr.length);
        byte[] copyOf = Arrays.copyOf(this.data, this.data.length + i);
        System.arraycopy(bArr, 0, copyOf, this.data.length, i);
        this.data = copyOf;
    }

    @Override // com.fl.saas.videocache.Cache
    public long available() {
        return this.data.length;
    }

    @Override // com.fl.saas.videocache.Cache
    public void close() {
    }

    @Override // com.fl.saas.videocache.Cache
    public void complete() {
        this.completed = true;
    }

    @Override // com.fl.saas.videocache.Cache
    public boolean isCompleted() {
        return this.completed;
    }

    @Override // com.fl.saas.videocache.Cache
    public int read(byte[] bArr, long j, int i) {
        if (j >= this.data.length) {
            return -1;
        }
        if (j <= 2147483647L) {
            return new ByteArrayInputStream(this.data).read(bArr, (int) j, i);
        }
        throw new IllegalArgumentException(CtFAbx.AaHO0E("Too long offset for memory cache ", j));
    }

    public ByteArrayCache(byte[] bArr) {
        this.data = (byte[]) Preconditions.checkNotNull(bArr);
    }
}
