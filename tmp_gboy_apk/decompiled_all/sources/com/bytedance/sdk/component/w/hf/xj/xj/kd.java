package com.bytedance.sdk.component.w.hf.xj.xj;

import com.bytedance.sdk.component.w.xj.c;
import com.bytedance.sdk.component.w.xj.yo;
import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class kd extends c {
    private boolean xj;

    public kd(yo yoVar) {
        super(yoVar);
    }

    @Override // com.bytedance.sdk.component.w.xj.c, com.bytedance.sdk.component.w.xj.yo
    public void a_(com.bytedance.sdk.component.w.xj.w wVar, long j) {
        if (this.xj) {
            wVar.f(j);
            return;
        }
        try {
            super.a_(wVar, j);
        } catch (IOException e) {
            this.xj = true;
            xj(e);
        }
    }

    @Override // com.bytedance.sdk.component.w.xj.c, com.bytedance.sdk.component.w.xj.yo, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.xj) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.xj = true;
            xj(e);
        }
    }

    @Override // com.bytedance.sdk.component.w.xj.c, com.bytedance.sdk.component.w.xj.yo, java.io.Flushable
    public void flush() {
        if (this.xj) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.xj = true;
            xj(e);
        }
    }

    public void xj(IOException iOException) {
    }
}
