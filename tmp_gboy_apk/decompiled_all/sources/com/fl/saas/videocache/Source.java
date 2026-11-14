package com.fl.saas.videocache;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface Source {
    void close();

    long length();

    void open(long j);

    int read(byte[] bArr);
}
