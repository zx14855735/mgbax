package IzHBwY;

import ADYaiT.BpkvW3;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT implements ValueSet {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final SparseArray f4108A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f4109A4TApA = -1;

    public ADYaiT(SparseArray sparseArray) {
        this.f4108A2egSU = sparseArray;
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final Object[] arrayValue(int i, Class cls) {
        Object obj = this.f4108A2egSU.get(i);
        if (obj == null) {
            return null;
        }
        Class<?> cls2 = obj.getClass();
        if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
            return (Object[]) obj;
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final boolean booleanValue(int i) {
        return booleanValue(i, false);
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final boolean containsKey(int i) {
        return this.f4108A2egSU.indexOfKey(i) >= 0;
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final double doubleValue(int i) {
        Object obj = this.f4108A2egSU.get(i);
        if (BpkvW3.BNL6CD(obj)) {
            obj = BpkvW3.B2KMhB(obj).get();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        return 0.0d;
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final float floatValue(int i) {
        return floatValue(i, 0.0f);
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final int intValue(int i) {
        return intValue(i, 0);
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final boolean isEmpty() {
        return size() <= 0;
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final Set keys() {
        SparseArray sparseArray = this.f4108A2egSU;
        int size = sparseArray.size();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < size; i++) {
            hashSet.add(Integer.valueOf(sparseArray.keyAt(i)));
        }
        this.f4109A4TApA = hashSet.size();
        return hashSet;
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final long longValue(int i) {
        return longValue(i, 0L);
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final Object objectValue(int i, Class cls) {
        Object obj = this.f4108A2egSU.get(i);
        if (obj == null) {
            return null;
        }
        if (BpkvW3.BNL6CD(obj)) {
            obj = BpkvW3.B2KMhB(obj).get();
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final void remove(int i) {
        this.f4108A2egSU.remove(i);
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final int size() {
        if (this.f4109A4TApA < 0) {
            keys();
        }
        return this.f4109A4TApA;
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final SparseArray sparseArray() {
        SparseArray sparseArray = new SparseArray();
        SparseArray sparseArray2 = this.f4108A2egSU;
        if (sparseArray2 != null && sparseArray2.size() > 0) {
            for (int i = 0; i < sparseArray2.size(); i++) {
                sparseArray.put(sparseArray2.keyAt(i), sparseArray2.valueAt(i));
            }
        }
        return sparseArray;
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final String stringValue(int i) {
        return stringValue(i, null);
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final boolean booleanValue(int i, boolean z) {
        Object obj = this.f4108A2egSU.get(i);
        if (BpkvW3.BNL6CD(obj)) {
            obj = BpkvW3.B2KMhB(obj).get();
        }
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final float floatValue(int i, float f) {
        Object obj = this.f4108A2egSU.get(i);
        if (BpkvW3.BNL6CD(obj)) {
            obj = BpkvW3.B2KMhB(obj).get();
        }
        return obj instanceof Float ? ((Float) obj).floatValue() : f;
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final int intValue(int i, int i2) {
        Object obj = this.f4108A2egSU.get(i);
        if (BpkvW3.BNL6CD(obj)) {
            obj = BpkvW3.B2KMhB(obj).get();
        }
        return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final long longValue(int i, long j) {
        Object obj = this.f4108A2egSU.get(i);
        if (BpkvW3.BNL6CD(obj)) {
            obj = BpkvW3.B2KMhB(obj).get();
        }
        return obj instanceof Long ? ((Long) obj).longValue() : j;
    }

    @Override // com.bykv.vk.openvk.api.proto.ValueSet
    public final String stringValue(int i, String str) {
        Object obj = this.f4108A2egSU.get(i);
        if (BpkvW3.BNL6CD(obj)) {
            obj = BpkvW3.B2KMhB(obj).get();
        }
        return obj instanceof String ? obj.toString() : str;
    }
}
