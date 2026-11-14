package com.bytedance.sdk.openadsdk.core.ht;

import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements com.bytedance.sdk.component.u.c, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int intValue = ((Integer) sparseArray.get(0)).intValue();
        if (intValue == 1) {
            onExceptionEvent((String) sparseArray.get(1), (JSONObject) sparseArray.get(2), (Throwable) sparseArray.get(3));
            return null;
        }
        if (intValue != 2) {
            return null;
        }
        onStatsEvent((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
        return null;
    }

    @Override // com.bytedance.sdk.component.u.c
    public void onExceptionEvent(String str, JSONObject jSONObject, Throwable th) {
        if (kd.xj(str, 1.0d)) {
            am.xj().xj(str, jSONObject, th);
        }
    }

    @Override // com.bytedance.sdk.component.u.c
    public void onStatsEvent(String str, JSONObject jSONObject) {
        am.xj().xj(str, jSONObject);
    }
}
