package com.bytedance.sdk.openadsdk.c;

import J3FDQU.A2egSU;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj implements hf {
    private Object hf;
    private SparseArray<Method> xj = new SparseArray<>();

    @Override // com.bytedance.sdk.openadsdk.c.hf
    public <T> T call(int i, Object... objArr) {
        Object obj;
        Method method = this.xj.get(i);
        if (method == null || (obj = this.hf) == null) {
            pl.hf(xj(), "call method " + i + " failed for null ");
            return null;
        }
        try {
            return obj instanceof Class ? (T) method.invoke(null, objArr) : (T) method.invoke(obj, objArr);
        } catch (Throwable th) {
            String xj = xj();
            StringBuilder B9tovu2 = A2egSU.B9tovu(i, "call method ", " failed: ");
            B9tovu2.append(th.getMessage());
            pl.hf(xj, B9tovu2.toString());
            return null;
        }
    }

    public abstract String xj();

    @Override // com.bytedance.sdk.openadsdk.c.hf
    public void xj(int i, Method method) {
        this.xj.put(i, method);
    }

    @Override // com.bytedance.sdk.openadsdk.c.hf
    public void xj(Object obj) {
        this.hf = obj;
    }
}
