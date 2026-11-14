package com.sigmob.sdk.base.views;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.sigmob.sdk.base.models.BaseAdUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ae {

    /* renamed from: a, reason: collision with root package name */
    private final int f13251a = -1;
    private final Context b;
    private final BaseAdUnit c;
    private final a d;

    public interface a {
        void onApkDownloadProcess();
    }

    public ae(Context context, BaseAdUnit baseAdUnit, a aVar) {
        this.b = context;
        this.c = baseAdUnit;
        this.d = aVar;
    }

    private int a() {
        BaseAdUnit baseAdUnit = this.c;
        if (baseAdUnit == null) {
            return -1;
        }
        return baseAdUnit.getApkDownloadType();
    }

    @JavascriptInterface
    public int cancelDownloadTask() {
        int a2 = a();
        if (a2 == -1 || a2 == 0) {
            return -1;
        }
        return com.sigmob.sdk.base.common.o.c(this.b, this.c);
    }

    @JavascriptInterface
    public int getApKDownloadProcess() {
        if (com.sigmob.sdk.base.utils.q.b(this.d)) {
            this.d.onApkDownloadProcess();
        }
        if (this.b == null || this.c == null) {
            return -1;
        }
        long[] a2 = a() == 0 ? com.sigmob.sdk.base.common.q.a(this.b, this.c.getDownloadId()) : com.sigmob.sdk.base.common.o.d(this.b, this.c);
        int i = (int) a2[2];
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    return i != 8 ? -1 : 100;
                }
                return -2;
            }
            long j = a2[0];
            long j2 = a2[1];
            if (j2 != 0 && j != 0) {
                return (int) ((j * 100) / j2);
            }
        }
        return 0;
    }

    @JavascriptInterface
    public int getApKDownloadType() {
        return a();
    }

    @JavascriptInterface
    public int pauseDownload() {
        int a2 = a();
        if (a2 == -1 || a2 == 0) {
            return -1;
        }
        return com.sigmob.sdk.base.common.o.a(this.b, this.c);
    }

    @JavascriptInterface
    public int resumeDownload() {
        int a2 = a();
        if (a2 == -1 || a2 == 0) {
            return -1;
        }
        return com.sigmob.sdk.base.common.o.b(this.b, this.c);
    }
}
