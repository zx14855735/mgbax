package com.bytedance.sdk.openadsdk.zg.hf;

import IzHBwY.ARc23Z;
import IzHBwY.AYUAbz;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj<E> extends SparseArray<E> {
    private final PluginValueSet hf;
    private final ValueSet xj;

    public xj(ValueSet valueSet) {
        this.xj = valueSet == null ? ARc23Z.f4110A4TApA : valueSet;
        this.hf = AYUAbz.f4117A5SV6n;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [E, java.util.ArrayList] */
    private E xj(int i) {
        List list = (E) this.xj.objectValue(i, Object.class);
        if (list == null) {
            list = (E) this.hf.objectValue(i, Object.class);
        }
        if (list != null) {
            if (i == 9) {
                if (list == Bridge.class) {
                    return (E) AaHO0E.ARc23Z();
                }
                if (list == ValueSet.class) {
                    return SparseArray.class;
                }
            } else {
                if (list instanceof Bridge) {
                    return (E) new w((Bridge) list);
                }
                if (list instanceof ValueSet) {
                    return (E) new xj((ValueSet) list);
                }
                if (list instanceof EventListener) {
                    return (E) new u((EventListener) list);
                }
                if (list instanceof Result) {
                    return (E) com.bytedance.sdk.openadsdk.zg.hf.w.xj.xj((Result) list);
                }
                if (list instanceof List) {
                    List list2 = list;
                    if (!list2.isEmpty() && (list2.get(0) instanceof Bridge)) {
                        ?? r0 = (E) new ArrayList();
                        Iterator<E> it = list2.iterator();
                        while (it.hasNext()) {
                            r0.add(new w((Bridge) it.next()));
                        }
                        return r0;
                    }
                } else if (list instanceof Map) {
                    return (E) com.bytedance.sdk.openadsdk.zg.hf.w.xj.u(list);
                }
            }
        }
        return (E) list;
    }

    @Override // android.util.SparseArray
    public boolean contains(int i) {
        return super.contains(i) || this.xj.containsKey(i) || this.hf.containsKey(i);
    }

    @Override // android.util.SparseArray
    public E get(int i, E e) {
        E e2 = (E) super.get(i, null);
        if (e2 != null) {
            return e2;
        }
        E xj = xj(i);
        return xj != null ? xj : e;
    }

    public xj(PluginValueSet pluginValueSet) {
        this.hf = pluginValueSet == null ? AYUAbz.f4117A5SV6n : pluginValueSet;
        this.xj = ARc23Z.f4110A4TApA;
    }
}
