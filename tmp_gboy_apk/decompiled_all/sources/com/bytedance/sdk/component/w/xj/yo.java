package com.bytedance.sdk.component.w.xj;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface yo extends Closeable, Flushable {
    void a_(w wVar, long j);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    jk xj();
}
