package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.ra.d;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd extends com.bytedance.sdk.openadsdk.core.hf.hf {
    protected int am;
    protected int g;
    private boolean p;

    /* renamed from: pl, reason: collision with root package name */
    protected int f10380pl;
    private com.bytedance.sdk.openadsdk.core.ra.ra tf;

    public kd(Context context, ws wsVar, String str, int i) {
        super(context, wsVar, str, i);
        this.f10380pl = 0;
        this.g = -1;
        this.am = -1;
        this.p = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.u
    public void kd(int i) {
        this.f10380pl = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.u
    public void u() {
        this.am = 1;
        this.p = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.u
    public void w() {
        this.g = 1;
        this.p = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.hf, com.bytedance.sdk.openadsdk.core.hf.u
    public void xj(View view, com.bytedance.sdk.openadsdk.core.ra.tf tfVar) {
        com.bytedance.sdk.openadsdk.core.hf.xj.w.xj xjVar = (com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class);
        xjVar.xj(xj(xjVar.w()));
        super.xj(view, tfVar);
    }

    private com.bytedance.sdk.openadsdk.core.ra.d xj(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View c = this.c.c();
        int[] xj = r.xj(c);
        if (xj == null || xj.length != 2) {
            i = 0;
            i2 = 0;
        } else {
            i = xj[0];
            i2 = xj[1];
            if (this.f10380pl == 0 && this.p) {
                this.c.xj((r.w(this.y, r8.am()) + i) - 0.5f);
                this.c.hf((r.w(this.y, r8.qt()) + i2) - 0.5f);
                this.c.w((r.w(this.y, r8.zg()) + i) - 0.5f);
                this.c.u((r.w(this.y, r8.e()) + i2) - 0.5f);
            }
        }
        float y = r.y(this.y);
        int f = r.f(this.y);
        float c2 = r.c(this.y);
        int[] iArr = {-1, -1};
        int[] iArr2 = {-1, -1};
        com.bytedance.sdk.openadsdk.core.ra.ra raVar = this.tf;
        if (raVar == null || !this.p) {
            i3 = 0;
        } else {
            this.c.xj(raVar.kd);
            int i6 = i;
            i3 = 0;
            this.c.hf(this.tf.y);
            if (this.f10380pl == 0) {
                iArr[0] = r.w(this.y, this.tf.c) + i6;
                iArr[1] = r.w(this.y, this.tf.f) + i2;
                i5 = r.w(this.y, this.tf.d);
                i4 = r.w(this.y, this.tf.tf);
            } else {
                com.bytedance.sdk.openadsdk.core.ra.ra raVar2 = this.tf;
                iArr[0] = raVar2.c;
                iArr[1] = raVar2.f;
                int i7 = raVar2.d;
                i4 = raVar2.tf;
                i5 = i7;
            }
            iArr2[0] = i5;
            iArr2[1] = i4;
            View y2 = this.c.y();
            if (i5 == 0 && i4 == 0 && y2 != null) {
                iArr = r.xj(y2);
                iArr2 = r.w(y2);
            }
        }
        this.f10380pl = i3;
        return new d.xj().y(this.c.am()).kd(this.c.qt()).u(this.c.zg()).w(this.c.e()).hf(this.c.pl()).xj(this.c.g()).hf(xj).xj(iArr).w(r.w(c)).u(iArr2).w(this.c.hf()).u(this.c.w()).kd(this.c.u()).hf(com.bytedance.sdk.openadsdk.core.f.zg().w() ? 1 : 2).xj(this.c.tf()).xj(str).xj(y).xj(f).y(this.g).c(this.am).hf(c2).xj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.u
    public void xj(com.bytedance.sdk.openadsdk.core.ra.ra raVar) {
        this.tf = raVar;
    }
}
