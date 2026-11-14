package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.ra.d;
import com.bytedance.sdk.openadsdk.core.ra.ws;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends com.bytedance.sdk.openadsdk.core.hf.xj {
    protected int am;
    protected int g;
    private boolean p;

    /* renamed from: pl, reason: collision with root package name */
    protected int f10384pl;
    private com.bytedance.sdk.openadsdk.core.ra.ra tf;

    public u(Context context, ws wsVar, String str, int i) {
        super(context, wsVar, str, i);
        this.f10384pl = 0;
        this.g = -1;
        this.am = -1;
        this.p = true;
        if (wsVar == null) {
            return;
        }
        com.bytedance.sdk.component.p.kd.xj.xj().xj(wsVar.hashCode() + wsVar.zf()).put("is_express_ad", Boolean.TRUE);
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.u
    public void kd(int i) {
        this.f10384pl = i;
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

    public com.bytedance.sdk.openadsdk.core.ra.d xj(String str) {
        int i;
        int i2;
        String str2;
        String str3;
        String str4;
        String str5;
        int i3;
        int i4;
        View c = this.c.c();
        int[] xj = r.xj(c);
        if (xj == null || xj.length != 2) {
            i = 0;
            i2 = 0;
        } else {
            i = xj[0];
            i2 = xj[1];
            if (this.f10384pl == 0 && this.p) {
                this.c.xj((r.w(this.y, r8.am()) + i) - 0.5f);
                this.c.hf((r.w(this.y, r8.qt()) + i2) - 0.5f);
                this.c.w((r.w(this.y, r8.zg()) + i) - 0.5f);
                this.c.u((r.w(this.y, r8.e()) + i2) - 0.5f);
            }
        }
        int[] iArr = {-1, -1};
        int[] iArr2 = new int[2];
        com.bytedance.sdk.openadsdk.core.ra.ra raVar = this.tf;
        if (raVar != null && this.p) {
            this.c.xj(raVar.kd);
            this.c.hf(this.tf.y);
            if (this.f10384pl == 0) {
                iArr[0] = r.w(this.y, this.tf.c) + i;
                iArr[1] = r.w(this.y, this.tf.f) + i2;
                i4 = r.w(this.y, this.tf.d);
                i3 = r.w(this.y, this.tf.tf);
            } else {
                com.bytedance.sdk.openadsdk.core.ra.ra raVar2 = this.tf;
                iArr[0] = raVar2.c;
                iArr[1] = raVar2.f;
                int i5 = raVar2.d;
                i3 = raVar2.tf;
                i4 = i5;
            }
            str3 = TextUtils.isEmpty(str) ? this.tf.p : str;
            com.bytedance.sdk.openadsdk.core.ra.ra raVar3 = this.tf;
            str2 = raVar3.f10412pl;
            str5 = raVar3.g;
            str4 = raVar3.am;
            iArr2[0] = i4;
            iArr2[1] = i3;
            View y = this.c.y();
            if (i4 == 0 && i3 == 0 && y != null) {
                iArr = r.xj(y);
                iArr2 = r.w(y);
            }
        } else {
            str2 = "";
            str3 = str;
            str4 = "";
            str5 = str4;
        }
        this.f10384pl = 0;
        return new d.xj().y(this.c.am()).kd(this.c.qt()).u(this.c.zg()).w(this.c.e()).hf(this.c.pl()).xj(this.c.g()).hf(xj).xj(iArr).w(r.w(c)).u(iArr2).w(this.c.hf()).u(this.c.w()).kd(this.c.u()).hf(com.bytedance.sdk.openadsdk.core.f.zg().w() ? 1 : 2).xj(this.c.tf()).xj(str3).hf(str5).w(str2).u(str4).xj(r.y(this.y)).xj(r.f(this.y)).y(this.g).c(this.am).hf(r.c(this.y)).kd(this.c.yo()).f(this.c.v()).xj();
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.u
    public void xj(com.bytedance.sdk.openadsdk.core.ra.ra raVar) {
        this.tf = raVar;
    }
}
