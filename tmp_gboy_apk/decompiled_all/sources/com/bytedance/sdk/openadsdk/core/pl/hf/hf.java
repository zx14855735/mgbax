package com.bytedance.sdk.openadsdk.core.pl.hf;

import android.os.Looper;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends d {
    private com.bytedance.sdk.openadsdk.core.pl.hf.xj hf;
    private String kd;
    private long u;
    private long w;
    private String xj;
    private String y;

    public static class xj {
        private long hf;
        private String kd;
        private String u;
        private long w;
        private String xj;
        private com.bytedance.sdk.openadsdk.core.pl.hf.xj y;

        public xj hf(long j) {
            this.w = j;
            return this;
        }

        public xj w(String str) {
            this.kd = str;
            return this;
        }

        public xj xj(String str) {
            this.xj = str;
            return this;
        }

        public xj hf(String str) {
            this.u = str;
            return this;
        }

        public xj xj(com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar) {
            this.y = xjVar;
            return this;
        }

        public xj xj(long j) {
            this.hf = j;
            return this;
        }

        public void xj() {
            hf hfVar = new hf("tt_csj_download_thread");
            hfVar.y = this.kd;
            hfVar.kd = this.u;
            hfVar.u = this.w;
            hfVar.w = this.hf;
            hfVar.xj = this.xj;
            hfVar.hf = this.y;
            hf.hf(hfVar);
        }
    }

    public hf(String str) {
        super(str);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.hf == null) {
            return;
        }
        String str = this.xj;
        str.getClass();
        switch (str) {
            case "onIdle":
                this.hf.xj();
                break;
            case "onInstalled":
                this.hf.xj(this.kd, this.y);
                break;
            case "onDownloadActive":
                this.hf.xj(this.w, this.u, this.kd, this.y);
                break;
            case "onDownloadFailed":
                this.hf.w(this.w, this.u, this.kd, this.y);
                break;
            case "onDownloadPaused":
                this.hf.hf(this.w, this.u, this.kd, this.y);
                break;
            case "onDownloadFinished":
                this.hf.xj(this.w, this.kd, this.y);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(Runnable runnable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            v.y().post(runnable);
        } else {
            runnable.run();
        }
    }
}
