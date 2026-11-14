package com.bytedance.sdk.component.w.xj;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface kd extends v, ReadableByteChannel {
    byte[] c(long j);

    short d();

    byte[] e();

    byte f();

    void f(long j);

    long g();

    String kd(long j);

    boolean kd();

    short p();

    int pl();

    int tf();

    @Deprecated
    w w();

    y w(long j);

    long xj(byte b);

    String xj(Charset charset);

    void xj(long j);

    void xj(byte[] bArr);

    boolean xj(long j, y yVar);

    InputStream y();

    String zg();
}
