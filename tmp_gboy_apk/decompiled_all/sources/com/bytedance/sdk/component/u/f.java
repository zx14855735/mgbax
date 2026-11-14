package com.bytedance.sdk.component.u;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;
import org.json.JSONObject;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f implements c {
    Function xj;

    public f(Function function) {
        this.xj = function;
    }

    @Override // com.bytedance.sdk.component.u.c
    public void onExceptionEvent(String str, JSONObject jSONObject, Throwable th) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(1, sparseArray, 0, 1, str);
        sparseArray.put(2, jSONObject);
        sparseArray.put(3, th);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.component.u.c
    public void onStatsEvent(String str, JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(2, sparseArray, 0, 1, str);
        sparseArray.put(2, jSONObject);
        this.xj.apply(sparseArray);
    }
}
