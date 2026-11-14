package com.ss.android.socialbase.downloader.y;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class e {
    private boolean c;
    private String d;
    private int f;
    final String hf;
    private final List<g> kd;
    private final AtomicLong tf;
    final boolean u;
    final String w;
    final String xj;
    private int y;

    public e(String str, boolean z) {
        this.kd = new ArrayList();
        this.tf = new AtomicLong();
        this.xj = str;
        this.u = z;
        this.hf = null;
        this.w = null;
    }

    private String kd() {
        if (this.d == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.xj);
            sb.append("_");
            String str = this.hf;
            if (str == null) {
                str = "";
            }
            sb.append(str);
            sb.append("_");
            sb.append(this.u);
            this.d = sb.toString();
        }
        return this.d;
    }

    private String xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
                return null;
            }
            return str.substring(0, lastIndexOf);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return kd().equals(((e) obj).kd());
        }
        return false;
    }

    public int hashCode() {
        if (this.f == 0) {
            this.f = kd().hashCode();
        }
        return this.f;
    }

    public synchronized void hf(g gVar) {
        try {
            this.kd.remove(gVar);
        } catch (Throwable unused) {
        }
    }

    public String toString() {
        return "UrlRecord{url='" + this.xj + "', ip='" + this.hf + "', ipFamily='" + this.w + "', isMainUrl=" + this.u + ", failedTimes=" + this.y + ", isCurrentFailed=" + this.c + '}';
    }

    public synchronized boolean u() {
        return this.c;
    }

    public synchronized void w() {
        this.c = false;
    }

    public synchronized void hf() {
        this.y++;
        this.c = true;
    }

    public synchronized void xj(g gVar) {
        this.kd.add(gVar);
    }

    public e(String str, String str2) {
        this.kd = new ArrayList();
        this.tf = new AtomicLong();
        this.xj = str;
        this.u = false;
        this.hf = str2;
        this.w = xj(str2);
    }

    public synchronized int xj() {
        return this.kd.size();
    }

    public void xj(long j) {
        this.tf.addAndGet(j);
    }
}
