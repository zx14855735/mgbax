package com.bytedance.sdk.component.y.u;

import android.text.TextUtils;
import com.bytedance.sdk.component.y.yo;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w extends xj {
    @Override // com.bytedance.sdk.component.y.u.d
    public void xj(com.bytedance.sdk.component.y.w.w wVar) {
        if (TextUtils.isEmpty(wVar.getMemoryCacheKey())) {
            yo kd = wVar.pl().kd();
            wVar.hf(kd.xj(wVar));
            wVar.xj(kd.hf(wVar));
        }
        wVar.xj(new c());
    }

    @Override // com.bytedance.sdk.component.y.u.d
    public String xj() {
        return "generate_key";
    }
}
