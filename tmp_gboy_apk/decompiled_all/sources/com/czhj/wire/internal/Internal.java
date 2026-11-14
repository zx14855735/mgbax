package com.czhj.wire.internal;

import ADYaiT.CtFAbx;
import com.czhj.wire.ProtoAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Internal {
    private Internal() {
    }

    public static void checkElementsNotNull(List<?> list) {
        if (list == null) {
            throw new NullPointerException("list == null");
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == null) {
                throw new NullPointerException(CtFAbx.ASJ6gh(i, "Element at index ", " is null"));
            }
        }
    }

    public static <T> List<T> copyOf(String str, List<T> list) {
        if (list != null) {
            return (list == Collections.EMPTY_LIST || (list instanceof ImmutableList)) ? new MutableOnWriteList(list) : new ArrayList(list);
        }
        throw new NullPointerException(CtFAbx.AcNBzu(str, " == null"));
    }

    public static int countNonNull(Object obj, Object obj2) {
        return (obj != null ? 1 : 0) + (obj2 != null ? 1 : 0);
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static <T> List<T> immutableCopyOf(String str, List<T> list) {
        if (list == null) {
            throw new NullPointerException(CtFAbx.AcNBzu(str, " == null"));
        }
        if (list instanceof MutableOnWriteList) {
            list = ((MutableOnWriteList) list).f10676a;
        }
        if (list == Collections.EMPTY_LIST || (list instanceof ImmutableList)) {
            return list;
        }
        ImmutableList immutableList = new ImmutableList(list);
        if (immutableList.contains(null)) {
            throw new IllegalArgumentException(CtFAbx.AcNBzu(str, ".contains(null)"));
        }
        return immutableList;
    }

    public static IllegalStateException missingRequiredFields(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        String str = "";
        for (int i = 0; i < length; i += 2) {
            if (objArr[i] == null) {
                if (sb.length() > 0) {
                    str = "s";
                }
                sb.append("\n  ");
                sb.append(objArr[i + 1]);
            }
        }
        throw new IllegalStateException("Required field" + str + " not set:" + ((Object) sb));
    }

    public static <T> List<T> newMutableList() {
        return new MutableOnWriteList(Collections.EMPTY_LIST);
    }

    public static <K, V> Map<K, V> newMutableMap() {
        return new LinkedHashMap();
    }

    public static <T> void redactElements(List<T> list, ProtoAdapter<T> protoAdapter) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.set(i, protoAdapter.redact(list.get(i)));
        }
    }

    public static int countNonNull(Object obj, Object obj2, Object obj3) {
        return (obj != null ? 1 : 0) + (obj2 != null ? 1 : 0) + (obj3 != null ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void redactElements(Map<?, T> map, ProtoAdapter<T> protoAdapter) {
        for (Map.Entry entry : map.entrySet()) {
            entry.setValue(protoAdapter.redact(entry.getValue()));
        }
    }

    public static int countNonNull(Object obj, Object obj2, Object obj3, Object obj4, Object... objArr) {
        int i = obj != null ? 1 : 0;
        if (obj2 != null) {
            i++;
        }
        if (obj3 != null) {
            i++;
        }
        if (obj4 != null) {
            i++;
        }
        for (Object obj5 : objArr) {
            if (obj5 != null) {
                i++;
            }
        }
        return i;
    }

    public static void checkElementsNotNull(Map<?, ?> map) {
        if (map == null) {
            throw new NullPointerException("map == null");
        }
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey() == null) {
                throw new NullPointerException("map.containsKey(null)");
            }
            if (entry.getValue() == null) {
                throw new NullPointerException("Value for key " + entry.getKey() + " is null");
            }
        }
    }

    public static <K, V> Map<K, V> copyOf(String str, Map<K, V> map) {
        if (map != null) {
            return new LinkedHashMap(map);
        }
        throw new NullPointerException(CtFAbx.AcNBzu(str, " == null"));
    }

    public static <K, V> Map<K, V> immutableCopyOf(String str, Map<K, V> map) {
        if (map == null) {
            throw new NullPointerException(CtFAbx.AcNBzu(str, " == null"));
        }
        if (map.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (linkedHashMap.containsKey(null)) {
            throw new IllegalArgumentException(CtFAbx.AcNBzu(str, ".containsKey(null)"));
        }
        if (linkedHashMap.containsValue(null)) {
            throw new IllegalArgumentException(CtFAbx.AcNBzu(str, ".containsValue(null)"));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }
}
