package com.ss.android.socialbase.downloader.network.xj;

import com.bytedance.sdk.component.utils.pl;
import com.ss.android.socialbase.downloader.network.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u implements d {
    private final List<com.ss.android.socialbase.downloader.model.w> hf;
    private long kd;
    private boolean u;
    private d w;
    protected final Object xj;
    private InputStream y;

    public boolean c() {
        try {
            d dVar = this.w;
            if (dVar != null) {
                if (xj(dVar.hf())) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            pl.xj(e);
            return false;
        }
    }

    public boolean f() {
        return System.currentTimeMillis() - this.kd < hf.xj;
    }

    @Override // com.ss.android.socialbase.downloader.network.c
    public int hf() {
        d dVar = this.w;
        if (dVar != null) {
            return dVar.hf();
        }
        return 0;
    }

    public void kd() {
        synchronized (this.xj) {
            try {
                if (this.u && this.w == null) {
                    this.xj.wait();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.d
    public void u() {
        d dVar = this.w;
        if (dVar != null) {
            dVar.u();
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.c
    public void w() {
        d dVar = this.w;
        if (dVar != null) {
            dVar.w();
        }
    }

    public boolean xj(int i) {
        return i >= 200 && i < 300;
    }

    public List<com.ss.android.socialbase.downloader.model.w> y() {
        return this.hf;
    }

    @Override // com.ss.android.socialbase.downloader.network.d
    public InputStream xj() {
        InputStream inputStream = this.y;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.network.c
    public String xj(String str) {
        d dVar = this.w;
        if (dVar != null) {
            return dVar.xj(str);
        }
        return null;
    }
}
