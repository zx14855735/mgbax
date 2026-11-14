package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class xj {
    private long c;
    private boolean d;
    private int f;
    private int hf;
    private String kd;
    private long u;
    private long w;
    protected Notification xj;
    private int y = 0;

    public xj(int i, String str) {
        this.hf = i;
        this.kd = str;
    }

    public synchronized void c() {
        this.f++;
    }

    public boolean f() {
        return this.d;
    }

    public long hf() {
        return this.w;
    }

    public int kd() {
        return this.y;
    }

    public String u() {
        return this.kd;
    }

    public long w() {
        return this.u;
    }

    public abstract void xj(BaseException baseException, boolean z);

    public void xj(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.hf = downloadInfo.getId();
        this.kd = downloadInfo.getTitle();
    }

    public long y() {
        if (this.c == 0) {
            this.c = System.currentTimeMillis();
        }
        return this.c;
    }

    public void hf(long j) {
        this.u = j;
    }

    public int xj() {
        return this.hf;
    }

    public void xj(long j) {
        this.w = j;
    }

    public void xj(int i, BaseException baseException, boolean z) {
        xj(i, baseException, z, false);
    }

    public void xj(int i, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.y != i) {
            this.y = i;
            xj(baseException, z);
        }
    }

    public void xj(long j, long j2) {
        this.w = j;
        this.u = j2;
        this.y = 4;
        xj((BaseException) null, false);
    }

    public void xj(Notification notification) {
        if (this.hf == 0 || notification == null) {
            return;
        }
        hf.xj().xj(this.hf, this.y, notification);
    }
}
