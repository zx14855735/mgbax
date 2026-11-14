package com.bykv.vk.component.ttvideo.player;

import java.io.Closeable;

@Keep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface IMediaDataSource extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    @Keep
    void close();

    @Keep
    long getSize();

    @Keep
    int readAt(long j, byte[] bArr, int i, int i2);
}
