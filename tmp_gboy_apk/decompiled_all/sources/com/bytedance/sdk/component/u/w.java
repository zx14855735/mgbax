package com.bytedance.sdk.component.u;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.u.xj;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;
import org.json.JSONObject;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w implements xj.hf, Function {
    xj.hf hf;
    Function xj;

    public w(xj.hf hfVar) {
        this.hf = hfVar;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int intValue = ((Integer) sparseArray.get(0)).intValue();
        if (intValue == 1) {
            this.hf.setCryptInitStatus(((Long) sparseArray.get(1)).longValue(), ((Boolean) sparseArray.get(2)).booleanValue());
            return null;
        }
        if (intValue != 2) {
            return null;
        }
        this.hf.reportSoftDecData((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
        return null;
    }

    @Override // com.bytedance.sdk.component.u.xj.hf
    public void reportSoftDecData(String str, JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(2, sparseArray, 0, 1, str);
        sparseArray.put(2, jSONObject);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.xj.hf
    public void setCryptInitStatus(long j, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, Long.valueOf(j));
        sparseArray.put(3, Boolean.valueOf(z));
        this.xj.apply(sparseArray);
    }

    public w(Function function) {
        this.xj = function;
    }
}
