package com.bytedance.msdk.w.w.hf.xj.xj;

import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends hf {
    public w(String str, com.bytedance.msdk.w.xj.hf hfVar) {
        super(str, hfVar);
    }

    public void hf(List<Function<SparseArray<Object>, Object>> list) {
        if (list == null) {
            xj(new com.bytedance.msdk.api.u.xj.hf.xj(49010, "list is null"));
            return;
        }
        if (hf()) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Function<SparseArray<Object>, Object>> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new com.bytedance.msdk.w.xj.xj.u(this, AaHO0E.AYUAbz(it.next())));
        }
        xj(arrayList);
    }

    public boolean u() {
        com.bytedance.msdk.api.u.xj.hf.w.w wVar = ((hf) this).hf;
        return wVar != null && wVar.hf() == 2;
    }

    public boolean w() {
        com.bytedance.msdk.api.u.xj.hf.w.w wVar = ((hf) this).hf;
        return wVar != null && wVar.hf() == 1;
    }

    public void xj(com.bytedance.msdk.api.u.xj.hf.xj xjVar) {
        if (xj()) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "自定义Adapter 加载成功或者失败回调只能调用一次");
        } else {
            xj(new com.bytedance.msdk.api.xj(49010, com.bytedance.msdk.api.xj.xj(49010), xjVar == null ? -1 : xjVar.xj(), xjVar == null ? "" : xjVar.hf()));
        }
    }

    @Override // com.bytedance.msdk.w.w.hf.xj.xj.hf
    public <T> T xj(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8222) {
            boolean w = w();
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom draw loader : isExpressRender: " + w);
            return (T) Boolean.valueOf(w);
        }
        if (i == 8223) {
            boolean u = u();
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom draw loader : isNativeAd: " + u);
            return (T) Boolean.valueOf(u);
        }
        if (i != 8123) {
            if (i != 8107) {
                return null;
            }
            List<Function<SparseArray<Object>, Object>> list = (List) pluginValueSet.objectValue(8303, List.class);
            StringBuilder sb = new StringBuilder("Adn custom draw loader : callLoadSucceed  list size:");
            sb.append(list != null ? list.size() : 0);
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, sb.toString());
            hf(list);
            return null;
        }
        int intValue = pluginValueSet.intValue(8014);
        String stringValue = pluginValueSet.stringValue(8015);
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "Adn custom draw loader : callLoaderFail  code:" + intValue + " msg:" + stringValue);
        xj(intValue, stringValue);
        return null;
    }
}
