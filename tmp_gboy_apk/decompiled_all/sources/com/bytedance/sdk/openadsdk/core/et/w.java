package com.bytedance.sdk.openadsdk.core.et;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.ht.am;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements dk<Bitmap> {
    private com.bytedance.sdk.openadsdk.core.ht.xj.hf hf;
    private boolean xj;

    public w(boolean z) {
        this.xj = z;
        if (z) {
            this.hf = com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf();
        }
    }

    public void hf(String str) {
        com.bytedance.sdk.openadsdk.core.ht.xj.hf hfVar;
        if (!this.xj || (hfVar = this.hf) == null) {
            return;
        }
        hfVar.y(str);
    }

    @Override // com.bytedance.sdk.component.y.dk
    public void onFailed(int i, String str, Throwable th) {
        com.bytedance.sdk.openadsdk.core.ht.xj.hf hfVar;
        if (!this.xj || (hfVar = this.hf) == null) {
            return;
        }
        hfVar.hf(201).c(c.xj(201));
        am.xj().xj(this.hf);
    }

    @Override // com.bytedance.sdk.component.y.dk
    public void onSuccess(zg<Bitmap> zgVar) {
        if (!this.xj || this.hf == null) {
            return;
        }
        if (zgVar == null || zgVar.getResult() == null) {
            this.hf.hf(202).c(c.xj(202));
            am.xj().xj(this.hf);
        }
    }

    public void u(String str) {
        com.bytedance.sdk.openadsdk.core.ht.xj.hf hfVar;
        if (!this.xj || (hfVar = this.hf) == null) {
            return;
        }
        hfVar.f(str);
    }

    public void w(String str) {
        com.bytedance.sdk.openadsdk.core.ht.xj.hf hfVar;
        if (!this.xj || (hfVar = this.hf) == null) {
            return;
        }
        hfVar.u(str);
    }

    public void xj(String str) {
        com.bytedance.sdk.openadsdk.core.ht.xj.hf hfVar;
        if (!this.xj || (hfVar = this.hf) == null) {
            return;
        }
        hfVar.w(str);
    }

    public void xj(int i) {
        com.bytedance.sdk.openadsdk.core.ht.xj.hf hfVar;
        if (!this.xj || (hfVar = this.hf) == null) {
            return;
        }
        hfVar.xj(i);
    }
}
