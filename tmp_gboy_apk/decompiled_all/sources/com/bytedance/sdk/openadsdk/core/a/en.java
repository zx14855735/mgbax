package com.bytedance.sdk.openadsdk.core.a;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class en<K, V> extends HashMap<K, V> {
    /* JADX WARN: Multi-variable type inference failed */
    public en<String, Object> xj(K k, V v) {
        put(k, v);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public en<String, Object> xj(Map<? extends K, ? extends V> map) {
        putAll(map);
        return this;
    }
}
