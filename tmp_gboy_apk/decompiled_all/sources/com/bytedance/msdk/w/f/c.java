package com.bytedance.msdk.w.f;

import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.f.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {
    public static boolean hf(int i) {
        return i == 0;
    }

    public static boolean w(int i) {
        return i == -100;
    }

    public static boolean xj(int i) {
        return i >= -299 && i < -100;
    }

    public static List<tf> hf(List<tf> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (tf tfVar : list) {
            if (tfVar != null && tfVar.v() == 0) {
                arrayList.add(tfVar);
            }
        }
        return arrayList;
    }

    public static List<tf> w(List<tf> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (tf tfVar : list) {
            if (tfVar != null && (tfVar.v() == 1 || tfVar.v() == 3)) {
                arrayList.add(tfVar);
            }
        }
        return arrayList;
    }

    public static boolean xj(int i, List<Integer> list) {
        if (q.xj(list) || i >= list.size() || list.get(i).intValue() <= 0) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2).intValue() > 0) {
                return false;
            }
        }
        return true;
    }

    public static int xj(com.bytedance.msdk.core.tf.hf hfVar, tf tfVar) {
        if (hfVar == null || tfVar == null) {
            return -999;
        }
        if (hfVar.pl() && tfVar.a()) {
            return tfVar.et();
        }
        return tfVar.dk();
    }

    public static int xj(com.bytedance.msdk.core.tf.hf hfVar, com.bytedance.msdk.hf.w wVar) {
        if (hfVar == null || wVar == null) {
            return -999;
        }
        if (hfVar.pl() && wVar.cu()) {
            return wVar.kc();
        }
        return wVar.zd();
    }

    public static Map<Integer, List<tf>> xj(List<tf> list, boolean z) {
        int dk;
        HashMap hashMap = new HashMap();
        if (!q.xj(list)) {
            for (int i = 0; i < list.size(); i++) {
                tf tfVar = list.get(i);
                if (tfVar != null) {
                    if (z && tfVar.a()) {
                        dk = tfVar.et();
                    } else {
                        dk = tfVar.dk();
                    }
                    List list2 = (List) hashMap.get(Integer.valueOf(dk));
                    if (list2 == null) {
                        list2 = new ArrayList();
                    }
                    list2.add(tfVar);
                    hashMap.put(Integer.valueOf(dk), list2);
                }
            }
        }
        return hashMap;
    }

    public static List<tf> xj(List<tf> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (tf tfVar : list) {
            if (tfVar != null && tfVar.v() == 100) {
                arrayList.add(tfVar);
            }
        }
        return arrayList;
    }
}
