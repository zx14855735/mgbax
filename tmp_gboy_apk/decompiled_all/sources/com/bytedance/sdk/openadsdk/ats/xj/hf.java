package com.bytedance.sdk.openadsdk.ats.xj;

import com.bytedance.sdk.component.u.p;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements p {
    private Method hf;
    private Method kd;
    private Method u;
    private Method w;
    private Class xj;
    private boolean y;

    public hf() {
        try {
            Class<?> loadClass = getClass().getClassLoader().loadClass("android.os.SystemProperties");
            this.xj = loadClass;
            Method declaredMethod = loadClass.getDeclaredMethod("get", String.class);
            this.hf = declaredMethod;
            declaredMethod.setAccessible(true);
            this.y = true;
        } catch (Exception unused) {
            this.xj = null;
            this.y = false;
        }
    }

    private Method xj(String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = this.xj.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.u.p
    public String get(String str) {
        return (String) xj(this.hf, str);
    }

    @Override // com.bytedance.sdk.component.u.p
    public boolean getBoolean(String str) {
        if (this.kd == null) {
            this.kd = xj("getBoolean", String.class, Boolean.TYPE);
        }
        Boolean bool = (Boolean) xj(this.kd, str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.u.p
    public int getInt(String str) {
        if (this.w == null) {
            this.w = xj("getInt", String.class, Integer.TYPE);
        }
        Integer num = (Integer) xj(this.w, str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.u.p
    public long getLong(String str) {
        if (this.u == null) {
            this.u = xj("getLong", String.class, Long.TYPE);
        }
        Long l = (Long) xj(this.u, str);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.component.u.p
    public void set(String str, String str2) {
    }

    private <T> T xj(Method method, String str) {
        if (method == null) {
            return null;
        }
        try {
            return (T) method.invoke(this.xj, str);
        } catch (Exception e) {
            pl.hf("SystemPropRefect", "invoke failed", e);
            return null;
        }
    }

    public boolean xj() {
        return this.y;
    }
}
