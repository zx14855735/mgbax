package com.kwad.components.core.innerEc.followuser;

import com.kwad.sdk.h;
import com.sigmob.sdk.base.e;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class c extends com.kwad.sdk.core.network.d {
    private Map<String, String> Sd;
    private a Se;

    public c(Map<String, String> map, a aVar) {
        this.Sd = map;
        this.Se = aVar;
        rb();
        rc();
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

    private void rc() {
        putBody("toUserId", this.Se.RZ);
        putBody("fType", this.Se.Sa);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.Cs();
    }
}
