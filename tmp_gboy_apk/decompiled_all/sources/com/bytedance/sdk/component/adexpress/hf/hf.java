package com.bytedance.sdk.component.adexpress.hf;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.hf.tf;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements tf {
    private com.bytedance.sdk.component.adexpress.dynamic.xj.xj hf;
    private g kd;
    private f u;
    private ThemeStatusBroadcastReceiver w;
    private Context xj;
    private int y;

    public hf(Context context, g gVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.u.f fVar, f fVar2, com.bytedance.sdk.component.adexpress.dynamic.kd.xj xjVar) {
        this(context, gVar, themeStatusBroadcastReceiver, z, fVar, fVar2, xjVar, null);
    }

    public hf(Context context, g gVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.u.f fVar, f fVar2, com.bytedance.sdk.component.adexpress.dynamic.kd.xj xjVar, com.bytedance.sdk.component.adexpress.dynamic.xj.xj xjVar2) {
        this.xj = context;
        this.kd = gVar;
        this.w = themeStatusBroadcastReceiver;
        this.u = fVar2;
        if (xjVar2 != null) {
            this.hf = xjVar2;
        } else {
            this.hf = new com.bytedance.sdk.component.adexpress.dynamic.xj.xj(context, themeStatusBroadcastReceiver, z, fVar, gVar, xjVar);
        }
        this.hf.xj(this.u);
        if (fVar instanceof com.bytedance.sdk.component.adexpress.dynamic.u.c) {
            this.y = 3;
        } else {
            this.y = 2;
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.u hf() {
        com.bytedance.sdk.component.adexpress.dynamic.xj.xj xjVar = this.hf;
        if (xjVar != null) {
            return xjVar.y();
        }
        return null;
    }

    public void xj(boolean z) {
        this.hf.hf(z);
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.tf
    public boolean xj(final tf.xj xjVar) {
        this.kd.c().xj(this.y);
        this.hf.xj(new c() { // from class: com.bytedance.sdk.component.adexpress.hf.hf.1
            @Override // com.bytedance.sdk.component.adexpress.hf.c
            public void xj(View view, am amVar) {
                if (xjVar.w()) {
                    return;
                }
                hf.this.kd.c().kd(hf.this.y);
                hf.this.kd.c().y(hf.this.y);
                hf.this.kd.c().g();
                qt hf = xjVar.hf();
                if (hf == null) {
                    return;
                }
                hf.xj(hf.this.hf, amVar);
                xjVar.xj(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.hf.c
            public void xj(int i, String str) {
                hf.this.kd.c().xj(hf.this.y, i, str, xjVar.hf(hf.this));
                if (xjVar.hf(hf.this)) {
                    xjVar.xj(hf.this);
                    return;
                }
                qt hf = xjVar.hf();
                if (hf == null) {
                    return;
                }
                hf.a_(i);
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.tf
    public void xj() {
        com.bytedance.sdk.component.adexpress.dynamic.xj.xj xjVar = this.hf;
        if (xjVar != null) {
            xjVar.hf();
        }
    }
}
