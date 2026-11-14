package com.bytedance.sdk.component.adexpress.hf;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.hf.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements tf {
    private xj hf;
    private g w;
    private Context xj;

    public y(Context context, g gVar, xj xjVar) {
        this.xj = context;
        this.hf = xjVar;
        this.w = gVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.tf
    public void xj() {
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.tf
    public boolean xj(final tf.xj xjVar) {
        this.w.c().d();
        this.hf.xj(new c() { // from class: com.bytedance.sdk.component.adexpress.hf.y.1
            @Override // com.bytedance.sdk.component.adexpress.hf.c
            public void xj(View view, am amVar) {
                if (xjVar.w()) {
                    return;
                }
                qt hf = xjVar.hf();
                if (hf != null) {
                    hf.xj(y.this.hf, amVar);
                }
                xjVar.xj(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.hf.c
            public void xj(int i, String str) {
                qt hf = xjVar.hf();
                if (hf != null) {
                    hf.a_(i);
                }
            }
        });
        return true;
    }

    public void xj(w wVar) {
        this.hf.xj(wVar);
    }
}
