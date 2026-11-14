package com.fl.saas.videocache;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface Cache {
    void append(byte[] bArr, int i);

    long available();

    void close();

    void complete();

    boolean isCompleted();

    int read(byte[] bArr, long j, int i);
}
