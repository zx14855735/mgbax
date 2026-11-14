package com.bytedance.msdk.w.w.hf.xj.hf;

import android.content.Context;
import com.baidu.mobads.sdk.internal.cn;
import com.bytedance.sdk.gromore.init.DispatchAdSdkInitializerHolder;
import com.bytedance.sdk.openadsdk.core.z;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class hf extends com.bytedance.msdk.w.w.hf.xj.hf {
    public hf(com.bytedance.msdk.w.xj.hf hfVar) {
        super(hfVar);
    }

    public z xj(Context context) {
        z csjLoader = DispatchAdSdkInitializerHolder.getCsjLoader(context);
        if (csjLoader == null) {
            xj(new com.bytedance.msdk.api.xj("ClassCastException：load ad fail loader is null"));
        }
        return csjLoader;
    }

    @Override // com.bytedance.msdk.w.xj.xj
    public String xj(String str) {
        try {
            return com.bytedance.sdk.gromore.init.xj.w();
        } catch (Exception unused) {
            return cn.d;
        }
    }
}
