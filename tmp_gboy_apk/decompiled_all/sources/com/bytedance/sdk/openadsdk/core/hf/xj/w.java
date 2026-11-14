package com.bytedance.sdk.openadsdk.core.hf.xj;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.ra.tf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private final com.bytedance.sdk.openadsdk.core.hf.u c;
    private volatile int kd;
    private View u;
    private tf w;
    private List<xj> xj = new ArrayList();
    private Map<String, Object> hf = new HashMap();
    private volatile int y = 0;

    public w(com.bytedance.sdk.openadsdk.core.hf.u uVar) {
        this.c = uVar;
    }

    private void hf() {
        this.kd = 0;
        this.y = 0;
    }

    public void xj(View view) {
        this.u = view;
    }

    public void xj(xj xjVar) {
        this.xj.add(xjVar);
    }

    public void xj(tf tfVar) {
        this.w = tfVar;
        Iterator<xj> it = this.xj.iterator();
        while (it.hasNext()) {
            it.next().xj(this.w);
        }
    }

    public void xj() {
        ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) this.c.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(false);
        hf();
        xj(0);
    }

    private void xj(int i) {
        int size = this.xj.size();
        while (i < size) {
            int i2 = i + 1;
            this.kd = i2;
            xj xjVar = this.xj.get(i);
            xjVar.xj(this.u);
            this.y = xjVar.xj(this.hf, this);
            if (this.y != 0) {
                if (this.y == 2) {
                    ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) this.c.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).xj(this.hf, this);
                    return;
                }
                return;
            }
            i = i2;
        }
    }

    public <T extends xj> T xj(Class<T> cls) {
        return (T) this.c.xj(cls);
    }
}
