package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HashMap f8968A2egSU = new HashMap();

    /* renamed from: A4TApA, reason: collision with root package name */
    public final HashMap f8969A4TApA;

    public A4TApA(HashMap hashMap) {
        this.f8969A4TApA = hashMap;
        for (Map.Entry entry : hashMap.entrySet()) {
            AlLFFp alLFFp = (AlLFFp) entry.getValue();
            List list = (List) this.f8968A2egSU.get(alLFFp);
            if (list == null) {
                list = new ArrayList();
                this.f8968A2egSU.put(alLFFp, list);
            }
            list.add((A5SV6n) entry.getKey());
        }
    }

    public static void A2egSU(List list, B9tovu b9tovu, AlLFFp alLFFp, B7CMnp b7CMnp) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                A5SV6n a5SV6n = (A5SV6n) list.get(size);
                a5SV6n.getClass();
                try {
                    int i = a5SV6n.f8970A2egSU;
                    Method method = a5SV6n.f8971A4TApA;
                    if (i == 0) {
                        method.invoke(b7CMnp, new Object[0]);
                    } else if (i == 1) {
                        method.invoke(b7CMnp, b9tovu);
                    } else if (i == 2) {
                        method.invoke(b7CMnp, b9tovu, alLFFp);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException("Failed to call observer method", e2.getCause());
                }
            }
        }
    }
}
