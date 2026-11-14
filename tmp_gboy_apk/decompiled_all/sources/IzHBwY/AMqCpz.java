package IzHBwY;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz implements Bridge {
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (cls == Boolean.class || cls == Boolean.TYPE) {
            return (T) Boolean.FALSE;
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return (T) 0;
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return (T) 0L;
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return (T) Double.valueOf(0.0d);
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return (T) Float.valueOf(0.0f);
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public final ValueSet values() {
        return ARc23Z.f4110A4TApA;
    }
}
