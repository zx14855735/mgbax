package com.bytedance.sdk.openadsdk.core.x;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.ats.ATSKeep;
import java.util.function.Function;
import org.json.JSONObject;

@ATSKeep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u implements w {
    Function xj;

    public u(Function function) {
        this.xj = function;
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.w
    public void init(Context context, Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        sparseArray.put(2, function);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.w
    public boolean isPitayaEnvAvailable() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.w
    public boolean isPitayaInitSuccess() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.w
    public void queryPackage(String str, Function function) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(6, sparseArray, 0, 1, str);
        sparseArray.put(2, function);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.core.x.w
    public void runTask(String str, JSONObject jSONObject, Function function) {
        SparseArray sparseArray = new SparseArray();
        A2egSU.B3GDIM(4, sparseArray, 0, 1, str);
        sparseArray.put(2, jSONObject);
        sparseArray.put(3, function);
        this.xj.apply(sparseArray);
    }
}
