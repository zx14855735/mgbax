package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.network.c;
import com.ss.android.socialbase.downloader.tf.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u {
    public final c hf;
    private long kd;
    private long u;
    public final int w;
    public final String xj;

    public u(String str, c cVar) {
        this.xj = str;
        this.w = cVar.hf();
        this.hf = cVar;
    }

    public String c() {
        return y.hf(this.hf, "Cache-Control");
    }

    public boolean d() {
        return com.ss.android.socialbase.downloader.tf.xj.xj(8) ? y.w(this.hf) : y.hf(f());
    }

    public long f() {
        if (this.u <= 0) {
            this.u = y.xj(this.hf);
        }
        return this.u;
    }

    public boolean hf() {
        return y.xj(this.w, this.hf.xj(com.sigmob.sdk.downloader.core.c.i));
    }

    public String kd() {
        return y.hf(this.hf, com.sigmob.sdk.downloader.core.c.f);
    }

    public long p() {
        return y.d(c());
    }

    public long tf() {
        if (this.kd <= 0) {
            if (d()) {
                this.kd = -1L;
            } else {
                String kd = kd();
                if (!TextUtils.isEmpty(kd)) {
                    this.kd = y.hf(kd);
                }
            }
        }
        return this.kd;
    }

    public String u() {
        return this.hf.xj("Content-Type");
    }

    public String w() {
        return this.hf.xj(com.sigmob.sdk.downloader.core.c.g);
    }

    public boolean xj() {
        return y.w(this.w);
    }

    public String y() {
        String hf = y.hf(this.hf, "last-modified");
        return TextUtils.isEmpty(hf) ? y.hf(this.hf, "Last-Modified") : hf;
    }
}
