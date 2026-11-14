package com.bytedance.sdk.openadsdk.core.hf.xj.xj;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.pl.w.kd;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends com.bytedance.sdk.openadsdk.core.hf.xj.xj {
    hf kd = new hf();

    /* renamed from: com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj$xj, reason: collision with other inner class name */
    public interface InterfaceC0169xj {
        void xj(View view, int i);
    }

    public void hf(boolean z) {
        this.kd.u(z);
    }

    public void u(boolean z) {
        this.kd.hf(z);
    }

    public void w(boolean z) {
        this.kd.w(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.xj.xj
    public int xj(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.hf.xj.w wVar) {
        return 0;
    }

    public void hf(int i) {
        if (this.kd.u()) {
            this.kd.xj(i);
        }
    }

    public void u() {
        if (this.kd.u()) {
            com.bytedance.sdk.openadsdk.pz.xj.hf.xj.xj kd = this.kd.kd();
            if (!wo.w(this.xj) || kd == null) {
                return;
            }
            kd.hf();
        }
    }

    public void w() {
        if (this.kd.hf() && this.kd.u()) {
            com.bytedance.sdk.openadsdk.core.pl.hf.w y = this.kd.y();
            if (y instanceof kd) {
                ((kd) y).y(true);
            }
        }
    }

    public void xj(int i) {
        this.kd.hf(i);
    }

    public void xj(Map<String, Object> map) {
        this.kd.xj(map);
    }

    public hf hf() {
        return this.kd;
    }

    public void xj(String str) {
        this.kd.xj(str);
    }

    public void xj(boolean z) {
        this.kd.xj(z);
    }

    public void xj(ws wsVar) {
        this.xj = wsVar;
        this.kd.xj(wsVar);
    }

    public void xj(Context context) {
        this.hf = context;
        this.kd.xj(context);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.pl.hf.w wVar) {
        this.kd.xj(wVar);
    }

    public com.bytedance.sdk.openadsdk.core.pl.hf.w xj() {
        return this.kd.y();
    }

    public void xj(Object obj) {
        this.kd.xj(obj);
    }

    public void xj(com.bytedance.sdk.openadsdk.pz.xj.hf.xj.xj xjVar) {
        this.kd.xj(xjVar);
    }

    public void xj(InterfaceC0169xj interfaceC0169xj) {
        this.kd.xj(interfaceC0169xj);
    }

    public void xj(long j) {
        this.kd.xj(j);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.video.hf.hf hfVar) {
        this.kd.xj(hfVar);
    }
}
