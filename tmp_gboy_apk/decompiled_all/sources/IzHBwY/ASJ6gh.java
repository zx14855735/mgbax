package IzHBwY;

import ADYaiT.BpkvW3;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.zg.hf.xj;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements PluginValueSet {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final SparseArray f4114A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final PluginValueSet f4115A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f4116A5SV6n = -1;

    public ASJ6gh(SparseArray sparseArray, PluginValueSet pluginValueSet) {
        this.f4114A2egSU = sparseArray;
        this.f4115A4TApA = pluginValueSet;
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final Object[] arrayValue(int i, Class cls) {
        Object obj = this.f4114A2egSU.get(i);
        if (obj == null) {
            PluginValueSet pluginValueSet = this.f4115A4TApA;
            if (pluginValueSet != null) {
                return pluginValueSet.arrayValue(i, cls);
            }
            return null;
        }
        Class<?> cls2 = obj.getClass();
        if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
            return (Object[]) obj;
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final boolean booleanValue(int i) {
        return booleanValue(i, false);
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final boolean containsKey(int i) {
        PluginValueSet pluginValueSet;
        int indexOfKey = this.f4114A2egSU.indexOfKey(i);
        return (indexOfKey >= 0 || (pluginValueSet = this.f4115A4TApA) == null) ? indexOfKey >= 0 : pluginValueSet.containsKey(i);
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final double doubleValue(int i) {
        PluginValueSet pluginValueSet;
        Object obj = this.f4114A2egSU.get(i);
        if (obj == null && (pluginValueSet = this.f4115A4TApA) != null) {
            return pluginValueSet.doubleValue(i);
        }
        if (BpkvW3.BNL6CD(obj)) {
            obj = BpkvW3.B2KMhB(obj).get();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        return 0.0d;
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final float floatValue(int i) {
        return floatValue(i, 0.0f);
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final int intValue(int i) {
        return intValue(i, 0);
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final boolean isEmpty() {
        return size() <= 0;
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final Set keys() {
        SparseArray sparseArray = this.f4114A2egSU;
        int size = sparseArray.size();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < size; i++) {
            hashSet.add(Integer.valueOf(sparseArray.keyAt(i)));
        }
        PluginValueSet pluginValueSet = this.f4115A4TApA;
        if (pluginValueSet != null) {
            hashSet.addAll(pluginValueSet.keys());
        }
        this.f4116A5SV6n = hashSet.size();
        return hashSet;
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final long longValue(int i) {
        return longValue(i, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        r0 = ADYaiT.BpkvW3.B2KMhB(r0).get();
     */
    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object objectValue(int r3, java.lang.Class r4) {
        /*
            r2 = this;
            android.util.SparseArray r0 = r2.f4114A2egSU
            java.lang.Object r0 = r0.get(r3)
            if (r0 != 0) goto L11
            com.bykv.vk.openvk.api.proto.PluginValueSet r0 = r2.f4115A4TApA
            if (r0 == 0) goto L51
            java.lang.Object r3 = r0.objectValue(r3, r4)
            return r3
        L11:
            IySJvm.A2egSU r3 = IySJvm.A2egSU.A2egSU()
            int r3 = r3.f4098A2egSU
            r1 = 6803(0x1a93, float:9.533E-42)
            if (r3 < r1) goto L36
            IySJvm.A2egSU r3 = IySJvm.A2egSU.A2egSU()
            int r3 = r3.f4098A2egSU
            r1 = 7000(0x1b58, float:9.809E-42)
            if (r3 >= r1) goto L36
            boolean r3 = ADYaiT.BpkvW3.BNL6CD(r0)
            if (r3 == 0) goto L4a
            boolean r3 = ADYaiT.BpkvW3.BmvVmW(r0)
            if (r3 != 0) goto L4a
            boolean r3 = r0 instanceof com.bykv.vk.openvk.api.proto.ValueSet
            if (r3 != 0) goto L4a
            goto L42
        L36:
            boolean r3 = ADYaiT.BpkvW3.BNL6CD(r0)
            if (r3 == 0) goto L4a
            boolean r3 = ADYaiT.BpkvW3.BmvVmW(r0)
            if (r3 != 0) goto L4a
        L42:
            java.util.function.Supplier r3 = ADYaiT.BpkvW3.B2KMhB(r0)
            java.lang.Object r0 = ADYaiT.BpkvW3.AaHO0E(r3)
        L4a:
            boolean r3 = r4.isInstance(r0)
            if (r3 == 0) goto L51
            return r0
        L51:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: IzHBwY.ASJ6gh.objectValue(int, java.lang.Class):java.lang.Object");
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final void remove(int i) {
        this.f4114A2egSU.remove(i);
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final int size() {
        if (this.f4116A5SV6n < 0) {
            keys();
        }
        return this.f4116A5SV6n;
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final SparseArray sparseArray() {
        SparseArray<Object> sparseArray;
        PluginValueSet pluginValueSet;
        if (IySJvm.A2egSU.A2egSU().f4098A2egSU < 6803) {
            if ((this.f4114A2egSU instanceof xj) || ((pluginValueSet = this.f4115A4TApA) != null && (pluginValueSet.sparseArray() instanceof xj))) {
                return new xj(this);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        PluginValueSet pluginValueSet2 = this.f4115A4TApA;
        if (pluginValueSet2 != null && (sparseArray = pluginValueSet2.sparseArray()) != null && sparseArray.size() > 0) {
            for (int i = 0; i < sparseArray.size(); i++) {
                sparseArray2.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
            }
        }
        SparseArray sparseArray3 = this.f4114A2egSU;
        if (sparseArray3 != null && sparseArray3.size() > 0) {
            for (int i2 = 0; i2 < sparseArray3.size(); i2++) {
                sparseArray2.put(sparseArray3.keyAt(i2), sparseArray3.valueAt(i2));
            }
        }
        return sparseArray2;
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final String stringValue(int i) {
        return stringValue(i, null);
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final boolean booleanValue(int i, boolean z) {
        PluginValueSet pluginValueSet;
        Object obj = this.f4114A2egSU.get(i);
        if (obj == null && (pluginValueSet = this.f4115A4TApA) != null) {
            return pluginValueSet.booleanValue(i, z);
        }
        if (BpkvW3.BNL6CD(obj)) {
            obj = BpkvW3.B2KMhB(obj).get();
        }
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final float floatValue(int i, float f) {
        PluginValueSet pluginValueSet;
        Object obj = this.f4114A2egSU.get(i);
        if (obj == null && (pluginValueSet = this.f4115A4TApA) != null) {
            return pluginValueSet.floatValue(i, f);
        }
        if (BpkvW3.BNL6CD(obj)) {
            obj = BpkvW3.B2KMhB(obj).get();
        }
        return obj instanceof Float ? ((Float) obj).floatValue() : f;
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final int intValue(int i, int i2) {
        PluginValueSet pluginValueSet;
        Object obj = this.f4114A2egSU.get(i);
        if (obj == null && (pluginValueSet = this.f4115A4TApA) != null) {
            return pluginValueSet.intValue(i, i2);
        }
        if (BpkvW3.BNL6CD(obj)) {
            obj = BpkvW3.B2KMhB(obj).get();
        }
        return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final long longValue(int i, long j) {
        PluginValueSet pluginValueSet;
        Object obj = this.f4114A2egSU.get(i);
        if (obj == null && (pluginValueSet = this.f4115A4TApA) != null) {
            return pluginValueSet.longValue(i, j);
        }
        if (BpkvW3.BNL6CD(obj)) {
            obj = BpkvW3.B2KMhB(obj).get();
        }
        return obj instanceof Long ? ((Long) obj).longValue() : j;
    }

    @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
    public final String stringValue(int i, String str) {
        PluginValueSet pluginValueSet;
        Object obj = this.f4114A2egSU.get(i);
        if (obj == null && (pluginValueSet = this.f4115A4TApA) != null) {
            return pluginValueSet.stringValue(i, str);
        }
        if (BpkvW3.BNL6CD(obj)) {
            obj = BpkvW3.B2KMhB(obj).get();
        }
        return obj instanceof String ? obj.toString() : str;
    }
}
