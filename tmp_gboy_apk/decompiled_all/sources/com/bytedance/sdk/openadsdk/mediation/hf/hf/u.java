package com.bytedance.sdk.openadsdk.mediation.hf.hf;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class u implements Function<SparseArray<Object>, Object> {
    private PluginValueSet xj;

    private PluginValueSet w() {
        return AYUAbz.A4TApA().A2egSU();
    }

    public PluginValueSet hf() {
        PluginValueSet pluginValueSet = this.xj;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet w = w();
        this.xj = w;
        return w;
    }

    public abstract int xj(com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.u uVar);

    public abstract Object xj(int i, PluginValueSet pluginValueSet);

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
            int intValue = ADYaiT2.intValue(-99999987, 0);
            ADYaiT2.objectValue(-99999985, Class.class);
            switch (intValue) {
                case -99999986:
                    return hf().sparseArray();
                case 270024:
                    return xj();
                case 271043:
                    return xj(ADYaiT2.intValue(0, 0), new AYUAbz((SparseArray) ADYaiT2.objectValue(1, SparseArray.class)).A2egSU());
                case 271050:
                    xj((Map<String, Object>) ADYaiT2.objectValue(0, Map.class));
                    return null;
                default:
                    switch (intValue) {
                        case 270013:
                            Activity activity = (Activity) ADYaiT2.objectValue(0, Activity.class);
                            List list = (List) ADYaiT2.objectValue(1, List.class);
                            if (list == null) {
                                list = new ArrayList(0);
                            }
                            ArrayList arrayList = new ArrayList();
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(new kd(AaHO0E.AYUAbz(it.next())));
                            }
                            xj(activity, arrayList, ADYaiT2.intValue(2, 0), ADYaiT2.intValue(3, 0), AaHO0E.AYUAbz(ADYaiT2.objectValue(4, AaHO0E.ARc23Z())));
                            break;
                        case 270014:
                            xj(new com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.w((SparseArray) ADYaiT2.objectValue(0, SparseArray.class)));
                            break;
                        case 270015:
                            xj((String) ADYaiT2.objectValue(0, String.class));
                            break;
                        case 270016:
                            xj(new com.bytedance.sdk.openadsdk.zg.w.w.u((SparseArray) ADYaiT2.objectValue(0, SparseArray.class)));
                            break;
                        case 270017:
                            xj((Context) ADYaiT2.objectValue(0, Context.class));
                            break;
                        case 270018:
                            xj((Context) ADYaiT2.objectValue(0, Context.class), (int[]) ADYaiT2.objectValue(1, int[].class));
                            break;
                        case 270019:
                            xj(ADYaiT2.intValue(0, 0));
                            break;
                        case 270021:
                            Context context = (Context) ADYaiT2.objectValue(0, Context.class);
                            Function<SparseArray<Object>, Object> AYUAbz2 = AaHO0E.AYUAbz(ADYaiT2.objectValue(3, AaHO0E.ARc23Z()));
                            xj(context, new xj((SparseArray) ADYaiT2.objectValue(1, SparseArray.class)), new com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.w(AaHO0E.AYUAbz(ADYaiT2.objectValue(2, AaHO0E.ARc23Z()))), AYUAbz2);
                            break;
                        case 270022:
                            Context context2 = (Context) ADYaiT2.objectValue(0, Context.class);
                            Function<SparseArray<Object>, Object> AYUAbz3 = AaHO0E.AYUAbz(ADYaiT2.objectValue(3, AaHO0E.ARc23Z()));
                            xj(context2, new xj((SparseArray) ADYaiT2.objectValue(1, SparseArray.class)), new com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(2, AaHO0E.ARc23Z()))), AYUAbz3);
                            break;
                    }
            }
        }
        return null;
    }

    public abstract Map<String, Object> xj();

    public abstract void xj(int i);

    public abstract void xj(Activity activity, List<kd> list, int i, int i2, Function<SparseArray<Object>, Object> function);

    public abstract void xj(Context context);

    public abstract void xj(Context context, xj xjVar, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.w wVar, Function<SparseArray<Object>, Object> function);

    public abstract void xj(Context context, xj xjVar, com.bytedance.sdk.openadsdk.mediation.hf.hf.xj.xj xjVar2, Function<SparseArray<Object>, Object> function);

    public abstract void xj(Context context, int[] iArr);

    public abstract void xj(com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.w wVar);

    public abstract void xj(com.bytedance.sdk.openadsdk.zg.w.w.u uVar);

    public abstract void xj(String str);

    public abstract void xj(Map<String, Object> map);
}
