package com.fl.saas.common.util;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class JSONUtil {
    public static <T> List<T> jsonArrayToList(JSONArray jSONArray) {
        return jsonArrayToList(jSONArray, null);
    }

    public static <T> List<T> jsonArrayToList(JSONArray jSONArray, AmA8tU.A2egSU a2egSU) {
        return jsonArrayToList(jSONArray, true, a2egSU);
    }

    public static <T> List<T> jsonArrayToList(JSONArray jSONArray, boolean z, AmA8tU.A2egSU a2egSU) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    Object opt = jSONArray.opt(i);
                    if ((opt != null || !z) && (a2egSU == null || (opt = a2egSU.apply(opt)) != null || !z)) {
                        arrayList.add(opt);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return arrayList;
    }
}
