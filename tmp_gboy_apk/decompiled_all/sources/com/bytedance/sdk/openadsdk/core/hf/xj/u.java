package com.bytedance.sdk.openadsdk.core.hf.xj;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    private final Map<Class, xj> xj = new HashMap();

    private <T extends xj> T hf(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (Throwable unused) {
            try {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(ws.class, Context.class);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(null, null);
            } catch (Throwable unused2) {
                return null;
            }
        }
    }

    public w xj(ws wsVar, Context context, com.bytedance.sdk.openadsdk.core.hf.u uVar, boolean z) {
        w wVar = new w(uVar);
        com.bytedance.sdk.openadsdk.core.hf.xj.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.hf.xj.hf.xj(wsVar, context);
        this.xj.put(com.bytedance.sdk.openadsdk.core.hf.xj.hf.xj.class, xjVar);
        hf hfVar = new hf(wsVar, context);
        this.xj.put(hf.class, hfVar);
        com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj xj = xj(wsVar, context);
        this.xj.put(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class, xj);
        com.bytedance.sdk.openadsdk.core.hf.xj.w.xj xjVar2 = new com.bytedance.sdk.openadsdk.core.hf.xj.w.xj(wsVar, context);
        this.xj.put(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class, xjVar2);
        com.bytedance.sdk.openadsdk.core.hf.xj.w.w wVar2 = new com.bytedance.sdk.openadsdk.core.hf.xj.w.w(wsVar, context);
        this.xj.put(com.bytedance.sdk.openadsdk.core.hf.xj.w.w.class, wVar2);
        wVar.xj(wVar2);
        wVar.xj(xjVar);
        wVar.xj(hfVar);
        wVar.xj(xj);
        wVar.xj(xjVar2);
        return wVar;
    }

    private com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj xj(ws wsVar, Context context) {
        com.bytedance.sdk.openadsdk.core.hf.xj.xj.w wVar = new com.bytedance.sdk.openadsdk.core.hf.xj.xj.w();
        wVar.xj(wsVar);
        wVar.xj(context);
        return wVar;
    }

    public <T extends xj> T xj(Class<T> cls) {
        T t = (T) this.xj.get(cls);
        return t == null ? (T) hf(cls) : t;
    }
}
