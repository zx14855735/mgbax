package com.bytedance.msdk.core.xj.xj.hf;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.core.xj.xj.xj.hf;
import com.bytedance.msdk.hf.w;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj implements com.bytedance.msdk.core.xj.xj.xj.xj {
    public tf hf;
    private hf u;
    public Function<SparseArray<Object>, Object> w;
    public com.bytedance.msdk.api.xj.hf xj;

    public String hf() {
        tf tfVar = this.hf;
        return (tfVar == null || !tfVar.z() || this.hf.ai() == null) ? "" : this.hf.ai().tf();
    }

    public boolean w() {
        return ((com.bytedance.msdk.c.xj.xj.xj().u() == 1) && this.hf.j()) || ((com.bytedance.msdk.c.xj.xj.xj().kd() == 1) && (this.hf.v() == 0));
    }

    public abstract void xj(Context context);

    @Override // com.bytedance.msdk.core.xj.xj.xj.xj
    public final void xj(Context context, Function<SparseArray<Object>, Object> function, com.bytedance.msdk.api.xj.hf hfVar, tf tfVar, hf hfVar2) {
        if (function == null || hfVar == null || tfVar == null || hfVar2 == null) {
            return;
        }
        this.u = hfVar2;
        this.hf = tfVar;
        this.xj = hfVar;
        this.w = function;
        xj(context);
    }

    public final void xj(int i, String str) {
        hf hfVar = this.u;
        if (hfVar != null) {
            hfVar.xj(i, str);
        }
    }

    public void xj(List<w> list) {
        hf hfVar = this.u;
        if (hfVar != null) {
            hfVar.xj(list);
        }
    }

    public void xj(w wVar, com.bytedance.msdk.api.xj xjVar) {
        hf hfVar = this.u;
        if (hfVar != null) {
            hfVar.xj(wVar, xjVar);
        }
    }

    public boolean xj() {
        tf tfVar = this.hf;
        if (tfVar == null) {
            return false;
        }
        int tf = tfVar.tf();
        return tf == 1 || tf == 3;
    }
}
