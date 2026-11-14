package com.kwad.sdk.core.network.idc.a;

import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.aa;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class b implements com.kwad.sdk.core.b {
    private final Map<String, List<String>> aKr = new ConcurrentHashMap();

    private Map<String, List<String>> JF() {
        return this.aKr;
    }

    public static b eu(String str) {
        b bVar = new b();
        if (str != null && !str.isEmpty()) {
            try {
                bVar.parseJson(new JSONObject(str));
                return bVar;
            } catch (JSONException e) {
                c.printStackTraceOnly(e);
            }
        }
        return bVar;
    }

    public final Set<String> JG() {
        return this.aKr.keySet();
    }

    public final void a(b bVar) {
        this.aKr.clear();
        if (bVar != null) {
            this.aKr.putAll(bVar.JF());
        }
    }

    public final List<String> et(String str) {
        Map<String, List<String>> map = this.aKr;
        if (map == null) {
            return Collections.EMPTY_LIST;
        }
        List<String> list = map.get(str);
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public final boolean isEmpty() {
        return this.aKr.isEmpty();
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, aa.h(jSONObject.optJSONArray(next)));
            }
        }
        this.aKr.clear();
        this.aKr.putAll(hashMap);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        Map<String, List<String>> map = this.aKr;
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            aa.putValue(jSONObject, str, aa.S(map.get(str)));
        }
        return jSONObject;
    }
}
