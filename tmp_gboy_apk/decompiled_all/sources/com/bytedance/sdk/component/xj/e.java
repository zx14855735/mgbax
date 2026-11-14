package com.bytedance.sdk.component.xj;

import com.bytedance.component.sdk.annotation.AnyThread;
import com.bytedance.component.sdk.annotation.UiThread;
import com.bytedance.sdk.component.xj.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class e {
    static ht xj;
    private final xj hf;
    private final List<am> kd;
    private final tf u;
    private final com.bytedance.sdk.component.g.w w;
    private volatile boolean y;

    public e(tf tfVar) {
        ht htVar;
        ArrayList arrayList = new ArrayList();
        this.kd = arrayList;
        this.y = false;
        this.u = tfVar;
        pz xj2 = (!tfVar.f || (htVar = xj) == null) ? null : htVar.xj(tfVar.p);
        if (tfVar.xj != null) {
            xj xjVar = tfVar.hf;
            if (xjVar == null) {
                this.hf = new et();
            } else {
                this.hf = xjVar;
            }
        } else {
            this.hf = tfVar.hf;
        }
        this.hf.xj(tfVar, xj2);
        this.w = tfVar.xj;
        arrayList.add(tfVar.tf);
        d.xj(tfVar.y);
        dk.xj(tfVar.c);
    }

    private void hf() {
        if (this.y) {
            d.xj(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }

    public static tf xj(com.bytedance.sdk.component.g.w wVar) {
        return new tf(wVar);
    }

    @AnyThread
    public <T> void xj(String str, T t) {
        hf();
        this.hf.xj(str, (String) t);
    }

    public e xj(String str, kd<?, ?> kdVar) {
        return xj(str, (String) null, kdVar);
    }

    @UiThread
    public e xj(String str, String str2, kd<?, ?> kdVar) {
        hf();
        this.hf.c.xj(str, kdVar);
        return this;
    }

    public e xj(String str, u.hf hfVar) {
        return xj(str, (String) null, hfVar);
    }

    @UiThread
    public e xj(String str, String str2, u.hf hfVar) {
        hf();
        this.hf.c.xj(str, hfVar);
        return this;
    }

    public void xj() {
        if (this.y) {
            return;
        }
        this.hf.hf();
        this.y = true;
        Iterator<am> it = this.kd.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
