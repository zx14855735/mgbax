package com.bytedance.sdk.component.w.xj;

import java.nio.channels.WritableByteChannel;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface u extends yo, WritableByteChannel {
    u c(int i);

    u d(int i);

    u f(int i);

    @Override // com.bytedance.sdk.component.w.xj.yo, java.io.Flushable
    void flush();

    u hf(y yVar);

    u hf(String str);

    u p(long j);

    u pl(long j);

    u pz();

    u w(byte[] bArr);

    u w(byte[] bArr, int i, int i2);

    w w();
}
