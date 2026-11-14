package com.bytedance.sdk.component.w.hf;

import ADYaiT.CtFAbx;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class z implements Closeable {
    private Charset c() {
        pz xj = xj();
        return xj != null ? xj.xj(com.bytedance.sdk.component.w.hf.xj.w.kd) : com.bytedance.sdk.component.w.hf.xj.w.kd;
    }

    public static z xj(pz pzVar, byte[] bArr) {
        return xj(pzVar, bArr.length, new com.bytedance.sdk.component.w.xj.w().w(bArr));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.bytedance.sdk.component.w.hf.xj.w.xj(w());
    }

    public abstract long hf();

    public final byte[] kd() {
        long hf = hf();
        if (hf > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: ".concat(String.valueOf(hf)));
        }
        com.bytedance.sdk.component.w.xj.kd w = w();
        try {
            byte[] e = w.e();
            com.bytedance.sdk.component.w.hf.xj.w.xj(w);
            if (hf == -1 || hf == e.length) {
                return e;
            }
            throw new IOException(CtFAbx.AZkASS(") disagree", e.length, CtFAbx.B2KMhB("Content-Length (", hf, ") and stream length (")));
        } catch (Throwable th) {
            com.bytedance.sdk.component.w.hf.xj.w.xj(w);
            throw th;
        }
    }

    public final InputStream u() {
        return w().y();
    }

    public abstract com.bytedance.sdk.component.w.xj.kd w();

    public abstract pz xj();

    public final String y() {
        com.bytedance.sdk.component.w.xj.kd w = w();
        try {
            String xj = w.xj(com.bytedance.sdk.component.w.hf.xj.w.xj(w, c()));
            com.bytedance.sdk.component.w.hf.xj.w.xj(w);
            return xj;
        } catch (OutOfMemoryError unused) {
            com.bytedance.sdk.component.w.hf.xj.w.xj(w);
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.w.hf.xj.w.xj(w);
            throw th;
        }
    }

    public static z xj(final pz pzVar, final long j, final com.bytedance.sdk.component.w.xj.kd kdVar) {
        if (kdVar != null) {
            return new z() { // from class: com.bytedance.sdk.component.w.hf.z.1
                @Override // com.bytedance.sdk.component.w.hf.z
                public long hf() {
                    return j;
                }

                @Override // com.bytedance.sdk.component.w.hf.z
                public com.bytedance.sdk.component.w.xj.kd w() {
                    return kdVar;
                }

                @Override // com.bytedance.sdk.component.w.hf.z
                public pz xj() {
                    return pz.this;
                }
            };
        }
        throw new NullPointerException("source == null");
    }
}
