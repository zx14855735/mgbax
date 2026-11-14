package com.bytedance.sdk.component.adexpress.hf;

import com.bytedance.sdk.component.adexpress.hf.tf;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl implements tf.xj {
    private List<tf> hf;
    private AtomicBoolean u = new AtomicBoolean(false);
    private d w;
    qt xj;

    public pl(List<tf> list, d dVar) {
        this.hf = list;
        this.w = dVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.tf.xj
    public boolean hf(tf tfVar) {
        int indexOf = this.hf.indexOf(tfVar);
        return indexOf < this.hf.size() - 1 && indexOf >= 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.tf.xj
    public boolean w() {
        return this.u.get();
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.tf.xj
    public void xj() {
        this.w.y();
        Iterator<tf> it = this.hf.iterator();
        while (it.hasNext() && !it.next().xj(this)) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.tf.xj
    public qt hf() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.tf.xj
    public void xj(tf tfVar) {
        int indexOf = this.hf.indexOf(tfVar);
        if (indexOf < 0) {
            return;
        }
        do {
            indexOf++;
            if (indexOf >= this.hf.size()) {
                return;
            }
        } while (!this.hf.get(indexOf).xj(this));
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.tf.xj
    public void xj(qt qtVar) {
        this.xj = qtVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.tf.xj
    public void xj(boolean z) {
        this.u.getAndSet(z);
    }
}
