package com.kwad.components.core.innerEc.b;

import com.kwad.sdk.core.network.d;
import com.sigmob.sdk.base.e;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class a extends d {
    private Map<String, String> Sd;

    public a(Map<String, String> map) {
        this.Sd = map;
        rb();
    }

    private static String d(Map<String, String> map) {
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : entrySet) {
            arrayList.add(entry.getKey() + "=" + entry.getValue());
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append((String) arrayList.get(i));
            if (i != size - 1) {
                sb.append("; ");
            }
        }
        return sb.toString();
    }

    private void rb() {
        addHeader(e.f13172a, d(this.Sd));
    }
}
