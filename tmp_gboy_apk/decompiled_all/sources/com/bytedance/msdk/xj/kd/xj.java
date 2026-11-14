package com.bytedance.msdk.xj.kd;

import android.content.Context;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    public static Object xj(Context context) {
        if (context != null) {
            try {
                Object obj = context.getClass() == PluginActivityWrapper.class ? ((PluginActivityWrapper) context).mOriginActivity : context.getClass() == PluginApplicationWrapper.class ? ((PluginApplicationWrapper) context).mOriginApplication : null;
                if (obj != null) {
                    return obj;
                }
            } catch (Throwable unused) {
            }
        }
        return context;
    }
}
