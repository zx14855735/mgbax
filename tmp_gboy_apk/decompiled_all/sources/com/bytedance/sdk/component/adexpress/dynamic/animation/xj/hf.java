package com.bytedance.sdk.component.adexpress.dynamic.animation.xj;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements com.bytedance.sdk.component.adexpress.dynamic.dynamicview.kd {
    List<u> xj = new ArrayList();

    public hf(View view, List<com.bytedance.sdk.component.adexpress.dynamic.w.xj> list) {
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.w.xj> it = list.iterator();
        while (it.hasNext()) {
            u xj = w.xj().xj(view, it.next());
            if (xj != null) {
                this.xj.add(xj);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.kd
    public void hf() {
        Iterator<u> it = this.xj.iterator();
        while (it.hasNext()) {
            try {
                it.next().hf();
            } catch (Exception unused) {
            }
        }
    }

    public void xj() {
        Iterator<u> it = this.xj.iterator();
        while (it.hasNext()) {
            try {
                it.next().w();
            } catch (Exception unused) {
            }
        }
    }
}
