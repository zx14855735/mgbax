package com.google.gson.internal;

import ADYaiT.DUi7mC;
import com.google.gson.InstanceCreator;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Map f12034A2egSU;

    public ARc23Z(Map map) {
        this.f12034A2egSU = map;
    }

    public final AlLFFp A2egSU(TypeToken typeToken) {
        NGepWW.A2egSU a2egSU;
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        Map map = this.f12034A2egSU;
        InstanceCreator instanceCreator = (InstanceCreator) map.get(type);
        if (instanceCreator != null) {
            return new AMqCpz(instanceCreator, type, 0);
        }
        InstanceCreator instanceCreator2 = (InstanceCreator) map.get(rawType);
        if (instanceCreator2 != null) {
            return new AMqCpz(instanceCreator2, type, 1);
        }
        AlLFFp alLFFp = null;
        try {
            Constructor declaredConstructor = rawType.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            a2egSU = new NGepWW.A2egSU(17, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            a2egSU = null;
        }
        if (a2egSU != null) {
            return a2egSU;
        }
        if (Collection.class.isAssignableFrom(rawType)) {
            alLFFp = SortedSet.class.isAssignableFrom(rawType) ? new OLy1FW.AzWtSf(25, (byte) 0) : EnumSet.class.isAssignableFrom(rawType) ? new com.game.boy.activity.A2egSU(type) : Set.class.isAssignableFrom(rawType) ? new OLy1FW.AzWtSf(26, (byte) 0) : Queue.class.isAssignableFrom(rawType) ? new OLy1FW.AzWtSf(27, (byte) 0) : new OLy1FW.AzWtSf(28, (byte) 0);
        } else if (Map.class.isAssignableFrom(rawType)) {
            alLFFp = ConcurrentNavigableMap.class.isAssignableFrom(rawType) ? new OLy1FW.AzWtSf(29, (byte) 0) : ConcurrentMap.class.isAssignableFrom(rawType) ? new OLy1FW.AzWtSf(21, (byte) 0) : SortedMap.class.isAssignableFrom(rawType) ? new OLy1FW.AzWtSf(22, (byte) 0) : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new OLy1FW.AzWtSf(24, (byte) 0) : new OLy1FW.AzWtSf(23, (byte) 0);
        }
        return alLFFp != null ? alLFFp : new DUi7mC(rawType, type);
    }

    public final String toString() {
        return this.f12034A2egSU.toString();
    }
}
