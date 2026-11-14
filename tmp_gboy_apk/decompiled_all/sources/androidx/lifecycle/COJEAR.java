package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class COJEAR {

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final Class[] f9010ARc23Z = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: A2egSU, reason: collision with root package name */
    public final LinkedHashMap f9011A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final LinkedHashMap f9012A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final LinkedHashMap f9013A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final LinkedHashMap f9014ADYaiT;
    public final DV2E8K.A5SV6n AMqCpz;

    static {
        UoVWZt();
    }

    public COJEAR(HashMap hashMap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f9011A2egSU = linkedHashMap;
        this.f9012A4TApA = new LinkedHashMap();
        this.f9013A5SV6n = new LinkedHashMap();
        this.f9014ADYaiT = new LinkedHashMap();
        this.AMqCpz = new androidx.activity.AMqCpz(1, this);
        linkedHashMap.putAll(hashMap);
    }

    public static Bundle A2egSU(COJEAR cojear) {
        Map map;
        String str;
        RXb0Sz.ARc23Z.AMqCpz(cojear, "this$0");
        LinkedHashMap linkedHashMap = cojear.f9012A4TApA;
        RXb0Sz.ARc23Z.AMqCpz(linkedHashMap, "<this>");
        int size = linkedHashMap.size();
        if (size == 0) {
            map = RD2OKB.BChYOn.f7847AcNBzu;
        } else if (size != 1) {
            map = new LinkedHashMap(linkedHashMap);
        } else {
            RXb0Sz.ARc23Z.AMqCpz(linkedHashMap, "<this>");
            Map.Entry entry = (Map.Entry) linkedHashMap.entrySet().iterator().next();
            map = Collections.singletonMap(entry.getKey(), entry.getValue());
            RXb0Sz.ARc23Z.ADYaiT(map, "with(...)");
        }
        Iterator it = map.entrySet().iterator();
        do {
            boolean hasNext = it.hasNext();
            LinkedHashMap linkedHashMap2 = cojear.f9011A2egSU;
            if (!hasNext) {
                Set<String> keySet = linkedHashMap2.keySet();
                ArrayList arrayList = new ArrayList(keySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String str2 : keySet) {
                    arrayList.add(str2);
                    arrayList2.add(linkedHashMap2.get(str2));
                }
                R8Rbcg.A4TApA[] a4TApAArr = {new R8Rbcg.A4TApA("keys", arrayList), new R8Rbcg.A4TApA("values", arrayList2)};
                Bundle bundle = new Bundle(2);
                for (int i = 0; i < 2; i++) {
                    R8Rbcg.A4TApA a4TApA = a4TApAArr[i];
                    String str3 = (String) a4TApA.f7826AcNBzu;
                    Object obj = a4TApA.f7827AlLFFp;
                    if (obj == null) {
                        bundle.putString(str3, null);
                    } else if (obj instanceof Boolean) {
                        bundle.putBoolean(str3, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Byte) {
                        bundle.putByte(str3, ((Number) obj).byteValue());
                    } else if (obj instanceof Character) {
                        bundle.putChar(str3, ((Character) obj).charValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(str3, ((Number) obj).doubleValue());
                    } else if (obj instanceof Float) {
                        bundle.putFloat(str3, ((Number) obj).floatValue());
                    } else if (obj instanceof Integer) {
                        bundle.putInt(str3, ((Number) obj).intValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(str3, ((Number) obj).longValue());
                    } else if (obj instanceof Short) {
                        bundle.putShort(str3, ((Number) obj).shortValue());
                    } else if (obj instanceof Bundle) {
                        bundle.putBundle(str3, (Bundle) obj);
                    } else if (obj instanceof CharSequence) {
                        bundle.putCharSequence(str3, (CharSequence) obj);
                    } else if (obj instanceof Parcelable) {
                        bundle.putParcelable(str3, (Parcelable) obj);
                    } else if (obj instanceof boolean[]) {
                        bundle.putBooleanArray(str3, (boolean[]) obj);
                    } else if (obj instanceof byte[]) {
                        bundle.putByteArray(str3, (byte[]) obj);
                    } else if (obj instanceof char[]) {
                        bundle.putCharArray(str3, (char[]) obj);
                    } else if (obj instanceof double[]) {
                        bundle.putDoubleArray(str3, (double[]) obj);
                    } else if (obj instanceof float[]) {
                        bundle.putFloatArray(str3, (float[]) obj);
                    } else if (obj instanceof int[]) {
                        bundle.putIntArray(str3, (int[]) obj);
                    } else if (obj instanceof long[]) {
                        bundle.putLongArray(str3, (long[]) obj);
                    } else if (obj instanceof short[]) {
                        bundle.putShortArray(str3, (short[]) obj);
                    } else if (obj instanceof Object[]) {
                        Class<?> componentType = obj.getClass().getComponentType();
                        RXb0Sz.ARc23Z.A4TApA(componentType);
                        if (Parcelable.class.isAssignableFrom(componentType)) {
                            bundle.putParcelableArray(str3, (Parcelable[]) obj);
                        } else if (String.class.isAssignableFrom(componentType)) {
                            bundle.putStringArray(str3, (String[]) obj);
                        } else if (CharSequence.class.isAssignableFrom(componentType)) {
                            bundle.putCharSequenceArray(str3, (CharSequence[]) obj);
                        } else {
                            if (!Serializable.class.isAssignableFrom(componentType)) {
                                throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str3 + '\"');
                            }
                            bundle.putSerializable(str3, (Serializable) obj);
                        }
                    } else if (obj instanceof Serializable) {
                        bundle.putSerializable(str3, (Serializable) obj);
                    } else if (obj instanceof IBinder) {
                        bundle.putBinder(str3, (IBinder) obj);
                    } else if (obj instanceof Size) {
                        C2rE4F.A5SV6n.A2egSU(bundle, str3, (Size) obj);
                    } else {
                        if (!(obj instanceof SizeF)) {
                            throw new IllegalArgumentException("Illegal value type " + obj.getClass().getCanonicalName() + " for key \"" + str3 + '\"');
                        }
                        C2rE4F.A5SV6n.A4TApA(bundle, str3, (SizeF) obj);
                    }
                }
                return bundle;
            }
            Map.Entry entry2 = (Map.Entry) it.next();
            str = (String) entry2.getKey();
            Bundle saveState = ((DV2E8K.A5SV6n) entry2.getValue()).saveState();
            RXb0Sz.ARc23Z.AMqCpz(str, "key");
            if (saveState != null) {
                Class[] clsArr = f9010ARc23Z;
                for (int i2 = 0; i2 < 29; i2++) {
                    Class cls = clsArr[i2];
                    RXb0Sz.ARc23Z.A4TApA(cls);
                    if (!cls.isInstance(saveState)) {
                    }
                }
                throw new IllegalArgumentException("Can't put value with type " + saveState.getClass() + " into saved state");
            }
            Object obj2 = cojear.f9013A5SV6n.get(str);
            BTvldC bTvldC = obj2 instanceof BTvldC ? (BTvldC) obj2 : null;
            if (bTvldC != null) {
                bTvldC.AMqCpz(saveState);
            } else {
                linkedHashMap2.put(str, saveState);
            }
        } while (cojear.f9014ADYaiT.get(str) == null);
        throw new ClassCastException();
    }

    private static /* synthetic */ void UoVWZt() {
        char[] charArray = "\u0088\u0084\u0086Å\u008c\u008a\u0086\u008eÅ\u0089\u0084\u0092Å\u0098\u0083\u008e\u0087\u0087Å¡\u0085\u0082©\u0099\u0082\u008f\u008c\u008e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 235);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0088\u0087\u0082\u0085\u0082\u009f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 235);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public COJEAR() {
        this.f9011A2egSU = new LinkedHashMap();
        this.f9012A4TApA = new LinkedHashMap();
        this.f9013A5SV6n = new LinkedHashMap();
        this.f9014ADYaiT = new LinkedHashMap();
        this.AMqCpz = new androidx.activity.AMqCpz(1, this);
    }
}
