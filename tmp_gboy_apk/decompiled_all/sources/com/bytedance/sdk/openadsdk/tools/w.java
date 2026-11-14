package com.bytedance.sdk.openadsdk.tools;

import IzHBwY.ASJ6gh;
import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import P8ccfD.AaHO0E;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.pz;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements Function<SparseArray<Object>, Object> {
    private static volatile w xj;

    private w() {
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        ASJ6gh ADYaiT2 = A2egSU.ADYaiT(sparseArray);
        int intValue = ADYaiT2.intValue(-99999987, 0);
        if (intValue == 10001) {
            f.zg().d(ADYaiT2.booleanValue(1, false));
            return null;
        }
        if (intValue == 10002) {
            return Boolean.valueOf(f.zg().wa());
        }
        if (intValue == 10003) {
            pz.xj().xj(AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z())));
            return null;
        }
        if (intValue == 10004) {
            Function<SparseArray<Object>, Object> AYUAbz2 = AaHO0E.AYUAbz(ADYaiT2.objectValue(0, AaHO0E.ARc23Z()));
            String str = (String) ADYaiT2.objectValue(1, String.class);
            String str2 = (String) ADYaiT2.objectValue(2, String.class);
            String str3 = (String) ADYaiT2.objectValue(3, String.class);
            String str4 = (String) ADYaiT2.objectValue(4, String.class);
            HashMap hashMap = new HashMap();
            hashMap.put("adtype", str2);
            hashMap.put("rit", str);
            hashMap.put("image_mode", str3);
            hashMap.put("preview_extra", str4);
            pz.xj().xj(hashMap, AYUAbz2);
            return null;
        }
        if (intValue == 10005) {
            AYUAbz A4TApA2 = AYUAbz.A4TApA();
            A4TApA2.ASJ6gh(0, f.zg().op());
            A4TApA2.ASJ6gh(1, f.zg().gy());
            return A4TApA2.A2egSU().sparseArray();
        }
        if (intValue != 10006) {
            if (intValue == 10007) {
                f.zg().xj((f.u) null);
            }
            return null;
        }
        pz.xj().xj((Map<String, Object>) ADYaiT2.objectValue(0, Map.class), AaHO0E.AYUAbz(ADYaiT2.objectValue(1, AaHO0E.ARc23Z())));
        return null;
    }

    public static w xj() {
        if (xj == null) {
            xj = new w();
        }
        return xj;
    }
}
