package com.bytedance.sdk.openadsdk.zg.hf.w;

import ADYaiT.BpkvW3;
import IzHBwY.A4TApA;
import IzHBwY.ADYaiT;
import IzHBwY.ARc23Z;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.wrapper.A5SV6n;
import com.bytedance.sdk.openadsdk.zg.hf;
import com.bytedance.sdk.openadsdk.zg.hf.kd;
import com.bytedance.sdk.openadsdk.zg.hf.u;
import com.bytedance.sdk.openadsdk.zg.hf.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public static ValueSet hf(SparseArray<Object> sparseArray) {
        SparseArray<Object> xj;
        if (sparseArray == null) {
            return null;
        }
        ARc23Z A4TApA2 = ARc23Z.A4TApA();
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            xj(A4TApA2, keyAt, sparseArray.get(keyAt));
        }
        if ((sparseArray instanceof hf) && (xj = ((hf) sparseArray).xj()) != null && xj.size() > 0) {
            for (int i2 = 0; i2 < xj.size(); i2++) {
                int keyAt2 = xj.keyAt(i2);
                xj(A4TApA2, keyAt2, xj.get(keyAt2));
            }
        }
        return A4TApA2.A2egSU();
    }

    public static Object u(Object obj) {
        final HashMap hashMap = new HashMap();
        ((Map) obj).forEach(new BiConsumer<Object, Object>() { // from class: com.bytedance.sdk.openadsdk.zg.hf.w.xj.3
            @Override // java.util.function.BiConsumer
            public void accept(Object obj2, Object obj3) {
                if (obj3 instanceof Bridge) {
                    hashMap.put(obj2, new w((Bridge) obj3));
                    return;
                }
                if (obj3 instanceof ValueSet) {
                    hashMap.put(obj2, new com.bytedance.sdk.openadsdk.zg.hf.xj((ValueSet) obj3));
                    return;
                }
                if (obj3 instanceof EventListener) {
                    hashMap.put(obj2, new u((EventListener) obj3));
                    return;
                }
                if (obj3 == Bridge.class) {
                    hashMap.put(obj2, AaHO0E.ARc23Z());
                } else if (obj3 == ValueSet.class) {
                    hashMap.put(obj2, SparseArray.class);
                } else {
                    hashMap.put(obj2, obj3);
                }
            }
        });
        return hashMap;
    }

    public static Object w(Object obj) {
        final HashMap hashMap = new HashMap();
        ((Map) obj).forEach(new BiConsumer<Object, Object>() { // from class: com.bytedance.sdk.openadsdk.zg.hf.w.xj.2
            @Override // java.util.function.BiConsumer
            public void accept(Object obj2, Object obj3) {
                long asLong;
                if (BpkvW3.BmvVmW(obj3)) {
                    if (A5SV6n.BPw6Q8(obj3)) {
                        asLong = A5SV6n.B25kr6(obj3).getAsLong();
                        if (asLong == -99999981) {
                            hashMap.put(obj2, new kd(AaHO0E.AYUAbz(obj3)));
                            return;
                        }
                    }
                    hashMap.put(obj2, new com.bytedance.sdk.openadsdk.zg.hf.hf(AaHO0E.AYUAbz(obj3)));
                    return;
                }
                if (obj3 instanceof SparseArray) {
                    hashMap.put(obj2, xj.hf((SparseArray<Object>) obj3));
                    return;
                }
                if (obj3 == AaHO0E.ARc23Z()) {
                    hashMap.put(obj2, Bridge.class);
                } else if (obj3 == SparseArray.class) {
                    hashMap.put(obj2, ValueSet.class);
                } else {
                    hashMap.put(obj2, obj3);
                }
            }
        });
        return hashMap;
    }

    public static Result xj(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray);
        A4TApA ADYaiT2 = A4TApA.ADYaiT();
        ADYaiT2.f4104A4TApA = AMqCpz.intValue(-999900, 0);
        ADYaiT2.f4106ADYaiT = AMqCpz.stringValue(-999901, null);
        ADYaiT2.f4105A5SV6n = AMqCpz.booleanValue(-999903, false);
        ADYaiT2.AMqCpz = hf((SparseArray<Object>) AMqCpz.objectValue(-999902, SparseArray.class));
        return ADYaiT2.A5SV6n();
    }

    public static Object hf(Object obj) {
        if (BpkvW3.BmvVmW(obj)) {
            return new com.bytedance.sdk.openadsdk.zg.hf.hf(AaHO0E.AYUAbz(obj));
        }
        if (obj instanceof SparseArray) {
            return hf((SparseArray<Object>) obj);
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.isEmpty() || !BpkvW3.BmvVmW(list.get(0))) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.bytedance.sdk.openadsdk.zg.hf.hf(AaHO0E.AYUAbz(it.next())));
            }
            return arrayList;
        }
        if (obj instanceof Map) {
            return w(obj);
        }
        if (obj == AaHO0E.ARc23Z()) {
            return Bridge.class;
        }
        return obj == SparseArray.class ? ValueSet.class : obj;
    }

    private static void xj(ARc23Z aRc23Z, int i, final Object obj) {
        long asLong;
        if (BpkvW3.BmvVmW(obj)) {
            if (A5SV6n.BPw6Q8(obj)) {
                asLong = A5SV6n.B25kr6(obj).getAsLong();
                if (asLong == -99999981) {
                    aRc23Z.AMqCpz(i, new kd(AaHO0E.AYUAbz(obj)));
                    return;
                }
            }
            aRc23Z.AMqCpz(i, new com.bytedance.sdk.openadsdk.zg.hf.hf(AaHO0E.AYUAbz(obj)));
            return;
        }
        if (obj instanceof SparseArray) {
            if (i == -99999979) {
                aRc23Z.AMqCpz(i, xj((SparseArray<Object>) obj));
                return;
            } else {
                aRc23Z.AMqCpz(i, hf((SparseArray<Object>) obj));
                return;
            }
        }
        if (BpkvW3.BNL6CD(obj) && !BpkvW3.BmvVmW(obj) && !(obj instanceof ValueSet)) {
            aRc23Z.AMqCpz(i, new Supplier<Object>() { // from class: com.bytedance.sdk.openadsdk.zg.hf.w.xj.1
                @Override // java.util.function.Supplier
                public Object get() {
                    Object obj2;
                    obj2 = BpkvW3.B2KMhB(obj).get();
                    return xj.hf(obj2);
                }
            });
            return;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (!list.isEmpty() && BpkvW3.BmvVmW(list.get(0))) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.bytedance.sdk.openadsdk.zg.hf.hf(AaHO0E.AYUAbz(it.next())));
                }
                aRc23Z.AMqCpz(i, arrayList);
                return;
            }
            aRc23Z.AMqCpz(i, obj);
            return;
        }
        if (obj instanceof Map) {
            aRc23Z.AMqCpz(i, w(obj));
        } else {
            aRc23Z.AMqCpz(i, obj);
        }
    }

    public static SparseArray<Object> xj(Function<SparseArray<Object>, Object> function) {
        Object apply;
        if (function == null) {
            return new SparseArray<>();
        }
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(-99999986, sparseArray, -99999987, -99999985, SparseArray.class);
        apply = function.apply(sparseArray);
        if (apply instanceof SparseArray) {
            return (SparseArray) apply;
        }
        return new SparseArray<>();
    }

    public static Object xj(Object obj) {
        if (obj instanceof Bridge) {
            return new w((Bridge) obj);
        }
        if (obj instanceof ValueSet) {
            return new com.bytedance.sdk.openadsdk.zg.hf.xj((ValueSet) obj);
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.isEmpty() || !(list.get(0) instanceof Bridge)) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new w((Bridge) it.next()));
            }
            return arrayList;
        }
        if (obj instanceof Map) {
            return u(obj);
        }
        if (obj == Bridge.class) {
            return AaHO0E.ARc23Z();
        }
        return obj == ValueSet.class ? SparseArray.class : obj;
    }

    public static SparseArray<Object> xj(Result result) {
        if (result == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-999900, Integer.valueOf(result.code()));
        sparseArray.put(-999901, result.message());
        sparseArray.put(-999903, Boolean.valueOf(result.isSuccess()));
        sparseArray.put(-999902, new com.bytedance.sdk.openadsdk.zg.hf.xj(result.values()));
        return sparseArray;
    }
}
