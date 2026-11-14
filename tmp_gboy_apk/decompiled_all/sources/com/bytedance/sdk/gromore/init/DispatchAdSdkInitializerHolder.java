package com.bytedance.sdk.gromore.init;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.z;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DispatchAdSdkInitializerHolder {
    private static com.bytedance.sdk.openadsdk.core.w hf;
    private static volatile Object xj;

    public static z getCsjLoader(Context context) {
        if (getCsjManger() != null) {
            return getCsjManger().xj(context);
        }
        return null;
    }

    public static q getCsjManger() {
        com.bytedance.sdk.openadsdk.core.w wVar = hf;
        if (wVar != null) {
            return wVar.hf();
        }
        return null;
    }

    public static Object getInstance(Bundle bundle, com.bytedance.sdk.openadsdk.core.w wVar) {
        hf = wVar;
        if (xj == null) {
            synchronized (DispatchAdSdkInitializerHolder.class) {
                try {
                    if (xj == null) {
                        xj = new p(bundle, wVar);
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public static boolean isInitSuccess() {
        com.bytedance.sdk.openadsdk.core.w wVar = hf;
        return wVar != null && wVar.xj();
    }
}
