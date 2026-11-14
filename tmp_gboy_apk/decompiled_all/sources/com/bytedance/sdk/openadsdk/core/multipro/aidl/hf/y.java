package com.bytedance.sdk.openadsdk.core.multipro.aidl.hf;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.e;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y extends e.xj {
    private Handler hf = new Handler(Looper.getMainLooper());
    private volatile com.bytedance.sdk.openadsdk.core.pl.hf.xj xj;

    public y(com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar) {
        this.xj = xjVar;
    }

    private Handler u() {
        Handler handler = this.hf;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.hf = handler2;
        return handler2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xj(com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar) {
        return xjVar != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.e
    public void hf(final long j, final long j2, final String str, final String str2) {
        if (this.xj != null) {
            u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.y.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar = y.this.xj;
                    if (y.this.xj(xjVar)) {
                        xjVar.hf(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.e
    public void w(final long j, final long j2, final String str, final String str2) {
        if (this.xj != null) {
            u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.y.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar = y.this.xj;
                    if (y.this.xj(xjVar)) {
                        xjVar.w(j, j2, str, str2);
                    }
                }
            });
        }
    }

    public void w() {
        this.xj = null;
        this.hf = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.e
    public void xj() {
        if (this.xj != null) {
            u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.y.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar = y.this.xj;
                    if (y.this.xj(xjVar)) {
                        xjVar.xj();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.e
    public void xj(final long j, final long j2, final String str, final String str2) {
        if (this.xj != null) {
            u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.y.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar = y.this.xj;
                    if (y.this.xj(xjVar)) {
                        xjVar.xj(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.e
    public void xj(final long j, final String str, final String str2) {
        if (this.xj != null) {
            u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.y.5
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar = y.this.xj;
                    if (y.this.xj(xjVar)) {
                        xjVar.xj(j, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.e
    public void xj(final String str, final String str2) {
        if (this.xj != null) {
            u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.hf.y.6
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar = y.this.xj;
                    if (y.this.xj(xjVar)) {
                        String str3 = str;
                        if (str3 == null) {
                            str3 = "";
                        }
                        String str4 = str2;
                        xjVar.xj(str3, str4 != null ? str4 : "");
                    }
                }
            });
        }
    }
}
