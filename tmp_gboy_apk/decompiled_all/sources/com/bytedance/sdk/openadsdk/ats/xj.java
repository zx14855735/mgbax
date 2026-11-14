package com.bytedance.sdk.openadsdk.ats;

import P8ccfD.AaHO0E;
import android.content.Context;
import com.bytedance.sdk.component.u.p;
import com.bytedance.sdk.component.u.pl;
import com.bytedance.sdk.component.u.tf;
import com.bytedance.sdk.component.y.ht;
import com.bytedance.sdk.component.y.ra;
import com.bytedance.sdk.component.y.v;
import com.bytedance.sdk.openadsdk.core.a.d;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class xj {
    private kd u;
    private List<String> w;
    private final Map<String, Object> xj = new HashMap();
    private final Map<String, Object> hf = new HashMap();

    private <T> T xj(Class<T> cls) {
        if (cls == v.class) {
            return (T) com.bytedance.sdk.openadsdk.f.xj.xj();
        }
        if (cls == Context.class) {
            return (T) com.bytedance.sdk.openadsdk.f.xj.getContext();
        }
        if (cls == ht.class) {
            return (T) com.bytedance.sdk.openadsdk.f.xj.xj(com.bytedance.sdk.openadsdk.f.xj.getContext(), com.bytedance.sdk.openadsdk.f.xj.xj());
        }
        return null;
    }

    public c hf(String str) {
        Class cls;
        Class cls2;
        Class cls3;
        switch (str.hashCode()) {
            case -1543207689:
                cls = d.class;
                cls2 = com.bytedance.sdk.component.u.xj.xj.class;
                cls3 = com.bytedance.sdk.component.u.xj.hf.class;
                break;
            case -1535463234:
                cls = f.class;
                cls2 = p.class;
                cls3 = pl.class;
                break;
            case -1083272647:
                cls = com.bytedance.sdk.component.y.w.hf.class;
                cls2 = ht.class;
                cls3 = ra.class;
                break;
            case -987979858:
                cls = com.bytedance.sdk.openadsdk.core.x.y.class;
                cls2 = com.bytedance.sdk.openadsdk.core.x.w.class;
                cls3 = com.bytedance.sdk.openadsdk.core.x.u.class;
                break;
            case 96891546:
                cls = com.bytedance.sdk.openadsdk.core.ht.w.class;
                cls2 = com.bytedance.sdk.component.u.c.class;
                cls3 = com.bytedance.sdk.component.u.f.class;
                break;
            case 658907061:
                cls = hf.class;
                cls2 = com.bytedance.sdk.component.u.xj.class;
                cls3 = com.bytedance.sdk.component.u.u.class;
                break;
            case 1209788376:
                cls = u.class;
                cls2 = com.bytedance.sdk.component.u.d.class;
                cls3 = tf.class;
                break;
            case 1390272937:
                cls = com.bytedance.sdk.openadsdk.core.ht.u.class;
                cls2 = com.bytedance.sdk.component.u.kd.class;
                cls3 = com.bytedance.sdk.component.u.y.class;
                break;
            default:
                return null;
        }
        return new c(cls2, cls, cls3, true, 0);
    }

    public Map<String, Object> xj() {
        return this.xj;
    }

    public <T> T xj(String str) {
        if (str == null) {
            kd kdVar = this.u;
            if (kdVar != null) {
                kdVar.xj("", (Throwable) new RuntimeException("null key"));
            }
            return null;
        }
        T t = (T) this.xj.get(str);
        if (t == null) {
            t = (T) this.hf.get(str);
        } else {
            kd kdVar2 = this.u;
            if (kdVar2 != null) {
                kdVar2.xj(str, t);
            }
        }
        if (t != null) {
            return t;
        }
        c hf = hf(str);
        if (hf == null) {
            kd kdVar3 = this.u;
            if (kdVar3 != null) {
                kdVar3.xj(str, (Throwable) new RuntimeException("clazz not register"));
            }
            return null;
        }
        return (T) xj(str, hf);
    }

    private Object xj(String str, c cVar) {
        Object obj = null;
        try {
            if (cVar.u) {
                obj = this.xj.get(str);
                if (obj != null) {
                    return obj;
                }
                synchronized (cVar.hf) {
                    try {
                        obj = this.xj.get(str);
                        if (obj == null) {
                            obj = xj((Class<Object>) cVar.hf, (Class<Object>) cVar.xj);
                            this.xj.put(str, obj);
                        }
                    } finally {
                    }
                }
                return obj;
            }
            return xj((Class) cVar.hf, (Class) cVar.xj);
        } catch (Throwable th) {
            kd kdVar = this.u;
            if (kdVar != null) {
                kdVar.xj(str, th);
            }
            return obj;
        }
    }

    public Object xj(String str, Object obj) {
        c hf = hf(str);
        if (hf == null) {
            kd kdVar = this.u;
            if (kdVar != null) {
                kdVar.xj(str, (Throwable) new RuntimeException("reuseservice not register"));
                return null;
            }
        } else {
            try {
                Object newInstance = hf.w.getDeclaredConstructor(AaHO0E.ARc23Z()).newInstance(obj);
                if (!hf.u) {
                    return newInstance;
                }
                this.xj.put(str, newInstance);
                return newInstance;
            } catch (Exception e) {
                kd kdVar2 = this.u;
                if (kdVar2 != null) {
                    kdVar2.xj(hf.xj.getName(), hf.hf.getName(), "reuse failed", e);
                }
            }
        }
        return null;
    }

    private <T> T xj(Class<T> cls, Class<T> cls2) {
        T t = (T) xj(cls2);
        if (t != null) {
            return t;
        }
        T t2 = (T) xj(cls);
        if (t2 != null) {
            return t2;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors.length > 0) {
            Constructor<?> constructor = declaredConstructors[0];
            try {
                constructor.setAccessible(true);
            } catch (Exception unused) {
            }
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length != 0) {
                Object[] objArr = new Object[parameterTypes.length];
                for (int i = 0; i < parameterTypes.length; i++) {
                    Object xj = xj(parameterTypes[i]);
                    if (xj != null) {
                        objArr[i] = xj;
                    } else {
                        throw new RuntimeException("params type " + parameterTypes[i] + "  for " + cls + " not config!");
                    }
                }
                return (T) constructor.newInstance(objArr);
            }
        }
        return cls.newInstance();
    }

    public void xj(String str, Object obj, int i) {
        c hf = hf(str);
        if (hf == null || obj == null || hf.kd > i) {
            return;
        }
        List<String> list = this.w;
        if (list == null || !list.contains(str)) {
            try {
                Object newInstance = hf.w.getDeclaredConstructor(AaHO0E.ARc23Z()).newInstance(obj);
                this.hf.put(str, newInstance);
                kd kdVar = this.u;
                if (kdVar != null) {
                    kdVar.hf(str, newInstance);
                }
            } catch (Exception e) {
                kd kdVar2 = this.u;
                if (kdVar2 != null) {
                    kdVar2.xj(hf.xj.getName(), hf.hf.getName(), "reuse failed", e);
                }
            }
        }
    }
}
