package com.bytedance.sdk.component.u;

import android.util.SparseArray;
import com.bytedance.sdk.component.u.xj;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;
import org.json.JSONObject;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements xj.InterfaceC0120xj, Function {
    xj.InterfaceC0120xj hf;
    Function xj;

    public hf(xj.InterfaceC0120xj interfaceC0120xj) {
        this.hf = interfaceC0120xj;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        this.hf.reportSensorData((JSONObject) sparseArray.get(1));
        return null;
    }

    @Override // com.bytedance.sdk.component.u.xj.InterfaceC0120xj
    public void reportSensorData(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, jSONObject);
        this.xj.apply(sparseArray);
    }

    public hf(Function function) {
        this.xj = function;
    }
}
