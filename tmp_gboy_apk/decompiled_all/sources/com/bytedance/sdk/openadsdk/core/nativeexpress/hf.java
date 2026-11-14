package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.yo.xj;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class hf extends com.bytedance.sdk.openadsdk.zg.w.hf.am {
    protected Dialog d;
    protected xj f;
    private Integer[] xj;

    public static class xj implements com.bytedance.sdk.openadsdk.core.pl.hf.xj {
        private String hf;
        private WeakReference<com.bytedance.sdk.openadsdk.core.pl.hf.xj> xj;

        public xj(com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar, String str) {
            this.hf = "";
            this.xj = new WeakReference<>(xjVar);
            this.hf = str;
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void hf(long j, long j2, String str, String str2) {
            long j3;
            long j4;
            WeakReference<com.bytedance.sdk.openadsdk.core.pl.hf.xj> weakReference = this.xj;
            if (weakReference == null || weakReference.get() == null) {
                j3 = j;
                j4 = j2;
            } else {
                j3 = j;
                j4 = j2;
                this.xj.get().hf(j3, j4, str, str2);
            }
            if (j3 > 0) {
                xj.C0198xj.xj(this.hf, 2, (int) ((j4 * 100) / j3));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void w(long j, long j2, String str, String str2) {
            long j3;
            long j4;
            WeakReference<com.bytedance.sdk.openadsdk.core.pl.hf.xj> weakReference = this.xj;
            if (weakReference == null || weakReference.get() == null) {
                j3 = j;
                j4 = j2;
            } else {
                j3 = j;
                j4 = j2;
                this.xj.get().w(j3, j4, str, str2);
            }
            if (j3 > 0) {
                xj.C0198xj.xj(this.hf, 4, (int) ((j4 * 100) / j3));
            }
        }

        public void xj(com.bytedance.sdk.openadsdk.core.pl.hf.xj xjVar) {
            this.xj = new WeakReference<>(xjVar);
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void xj() {
            WeakReference<com.bytedance.sdk.openadsdk.core.pl.hf.xj> weakReference = this.xj;
            if (weakReference != null && weakReference.get() != null) {
                this.xj.get().xj();
            }
            xj.C0198xj.xj(this.hf, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void xj(long j, long j2, String str, String str2) {
            long j3;
            long j4;
            WeakReference<com.bytedance.sdk.openadsdk.core.pl.hf.xj> weakReference = this.xj;
            if (weakReference == null || weakReference.get() == null) {
                j3 = j;
                j4 = j2;
            } else {
                j3 = j;
                j4 = j2;
                this.xj.get().xj(j3, j4, str, str2);
            }
            if (j3 > 0) {
                xj.C0198xj.xj(this.hf, 3, (int) ((j4 * 100) / j3));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void xj(long j, String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.pl.hf.xj> weakReference = this.xj;
            if (weakReference != null && weakReference.get() != null) {
                this.xj.get().xj(j, str, str2);
            }
            xj.C0198xj.xj(this.hf, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
        public void xj(String str, String str2) {
            WeakReference<com.bytedance.sdk.openadsdk.core.pl.hf.xj> weakReference = this.xj;
            if (weakReference != null && weakReference.get() != null) {
                this.xj.get().xj(str, str2);
            }
            xj.C0198xj.xj(this.hf, 6, 100);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public Map<String, Object> f() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public int hf() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void kd() {
        if (tf() != null) {
            com.bytedance.sdk.openadsdk.core.ht.xj(tf().ke());
        }
    }

    public com.bytedance.sdk.openadsdk.core.multipro.hf.xj p() {
        return null;
    }

    public abstract ws tf();

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void u() {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public int w() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public View xj() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public com.bytedance.sdk.openadsdk.zg.w.hf.u y() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void hf(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public com.bytedance.sdk.openadsdk.zg.w.hf.c xj(Activity activity) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(Activity activity, com.bytedance.sdk.openadsdk.v.xj.hf.xj.xj xjVar) {
    }

    public void xj(Dialog dialog) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.hf hfVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.et.xj.hf.xj.xj xjVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.w wVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(Double d, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(Dialog dialog, Integer[] numArr) {
        this.d = dialog;
        this.xj = numArr;
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.hf.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (hf.this.tf() != null) {
                        hf hfVar = hf.this;
                        hfVar.xj(hfVar.tf().xl());
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
        } catch (Throwable unused) {
        }
        xj(this.d);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.dislike.w.hf hfVar) {
        Dialog dialog;
        if (hfVar == null || (dialog = this.d) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.xj.hf.xj(hfVar, dialog, this.xj);
    }

    @Override // com.bytedance.sdk.openadsdk.zg.w.hf.f
    public void xj(com.bytedance.sdk.openadsdk.zg.w.xj.hf hfVar) {
        if (tf() != null) {
            com.bytedance.sdk.openadsdk.core.ht.xj(tf().ke(), hfVar, com.bytedance.sdk.openadsdk.zg.w.xj.hf.class);
        }
    }
}
