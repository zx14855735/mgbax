package com.bytedance.sdk.component.hf.xj.xj.xj;

import com.bytedance.sdk.component.hf.xj.e;
import com.bytedance.sdk.component.w.hf.pz;
import com.bytedance.sdk.component.w.hf.z;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf extends e {
    z xj;

    public tf(z zVar) {
        this.xj = zVar;
    }

    @Override // com.bytedance.sdk.component.hf.xj.e, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        z zVar = this.xj;
        if (zVar != null) {
            zVar.close();
        }
    }

    @Override // com.bytedance.sdk.component.hf.xj.e
    public String hf() {
        try {
            return this.xj.y();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.hf.xj.e
    public com.bytedance.sdk.component.hf.xj.tf kd() {
        pz xj;
        z zVar = this.xj;
        if (zVar == null || (xj = zVar.xj()) == null) {
            return null;
        }
        return new com.bytedance.sdk.component.hf.xj.tf(xj.toString(), xj.xj(), xj.hf(), xj.w() != null ? xj.w().name() : null);
    }

    @Override // com.bytedance.sdk.component.hf.xj.e
    public byte[] u() {
        try {
            return this.xj.kd();
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // com.bytedance.sdk.component.hf.xj.e
    public InputStream w() {
        z zVar = this.xj;
        if (zVar != null) {
            return zVar.u();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.hf.xj.e
    public long xj() {
        z zVar = this.xj;
        if (zVar != null) {
            return zVar.hf();
        }
        return -1L;
    }
}
