package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.a.xj;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd implements xj.hf {
    private final Map<Integer, WeakReference<xj.hf>> xj = new HashMap();

    @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
    public void hf() {
        Iterator<Map.Entry<Integer, WeakReference<xj.hf>>> it = this.xj.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<xj.hf> value = it.next().getValue();
            if (value != null) {
                xj.hf hfVar = value.get();
                if (hfVar != null) {
                    hfVar.hf();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    public void xj(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return;
        }
        function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(9).xj(Boolean.class).xj(0, new com.bytedance.sdk.openadsdk.core.wo.xj() { // from class: com.bytedance.sdk.openadsdk.core.kd.1
            @Override // com.bytedance.sdk.openadsdk.core.wo.xj
            public void hf() {
                kd.this.xj();
            }

            @Override // com.bytedance.sdk.openadsdk.core.wo.xj
            public void xj() {
                kd.this.hf();
            }
        }).hf());
    }

    public void xj(xj.hf hfVar) {
        if (hfVar == null) {
            return;
        }
        this.xj.put(Integer.valueOf(hfVar.hashCode()), new WeakReference<>(hfVar));
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.xj.hf
    public void xj() {
        Iterator<Map.Entry<Integer, WeakReference<xj.hf>>> it = this.xj.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<xj.hf> value = it.next().getValue();
            if (value != null) {
                xj.hf hfVar = value.get();
                if (hfVar != null) {
                    hfVar.xj();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }
}
