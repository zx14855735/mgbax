package com.bytedance.sdk.openadsdk.core.hf.xj.hf;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.ra.ra;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends hf {
    private com.bytedance.sdk.openadsdk.core.nativeexpress.w kd;
    private int y;

    public xj() {
    }

    public void xj(com.bytedance.sdk.openadsdk.core.nativeexpress.w wVar) {
        this.kd = wVar;
    }

    public xj(ws wsVar, Context context) {
        this.xj = wsVar;
        this.hf = context;
    }

    public void xj(int i) {
        this.y = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.xj.xj
    public void xj(View view) {
        this.u = view;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.xj.xj
    public int xj(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.hf.xj.w wVar) {
        if (this.kd == null) {
            return 0;
        }
        if (this.w == null) {
            this.w = new tf();
        }
        View y = this.w.y();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (y != null) {
            iArr = r.xj(y);
            iArr2 = r.w(y);
        }
        this.kd.xj(this.u, this.y, new ra.xj().u(this.w.am()).w(this.w.qt()).hf(this.w.zg()).xj(this.w.e()).hf(this.w.pl()).xj(this.w.g()).xj(iArr[0]).hf(iArr[1]).w(iArr2[0]).u(iArr2[1]).xj(this.w.kd()).xj(this.w.tf()).xj());
        return 1;
    }
}
