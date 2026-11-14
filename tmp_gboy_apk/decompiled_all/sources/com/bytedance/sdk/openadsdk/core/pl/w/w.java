package com.bytedance.sdk.openadsdk.core.pl.w;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.ff;
import com.bytedance.sdk.openadsdk.core.multipro.hf.xj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class w implements com.bytedance.sdk.openadsdk.core.pl.hf.w {
    protected WeakReference<xj.InterfaceC0173xj> hf;
    protected boolean xj = true;

    private String y() {
        xj.InterfaceC0173xj interfaceC0173xj;
        com.bytedance.sdk.openadsdk.core.multipro.hf.xj j;
        WeakReference<xj.InterfaceC0173xj> weakReference = this.hf;
        if (weakReference == null || (interfaceC0173xj = weakReference.get()) == null || (j = interfaceC0173xj.j()) == null) {
            return null;
        }
        return j.xj().toString();
    }

    public int c() {
        return hashCode();
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void hf(boolean z) {
        this.xj = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.hf.w
    public void xj(xj.InterfaceC0173xj interfaceC0173xj) {
        this.hf = new WeakReference<>(interfaceC0173xj);
    }

    public boolean xj(Context context, ws wsVar, String str) {
        if (!this.xj || !com.bytedance.sdk.openadsdk.core.a.y.xj(wsVar) || !ff.xj(context, wsVar, wo.hf(str), str, y())) {
            return false;
        }
        TTNativePageActivity.xj(this);
        return true;
    }
}
