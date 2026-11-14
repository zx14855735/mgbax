package com.kwad.sdk.crash.online.monitor.a;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public double aAi;
    public List<String> aUT = new ArrayList();
    public List<String> aUU = new ArrayList();
    public List<String> aUV = new ArrayList();
    public List<String> aUW = new ArrayList();
    public List<b> aUX = new ArrayList();
    public Map<String, b> aUY = new HashMap();
    public int aUZ;
    public int aVa;
    public int aVb;

    public final boolean NI() {
        return (this.aVb & 4) != 0;
    }

    public final boolean NJ() {
        return (this.aVb & 1) != 0;
    }

    public final boolean NK() {
        return (this.aVb & 2) != 0;
    }

    public final boolean NL() {
        return this.aVb == 0;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        List<b> list = this.aUX;
        if (list != null) {
            for (b bVar : list) {
                this.aUY.put(bVar.appId, bVar);
            }
            this.aUX.clear();
        }
    }

    public final b gd(String str) {
        if (this.aUY != null) {
            r1 = TextUtils.isEmpty(str) ? null : this.aUY.get(str);
            if (r1 == null) {
                return this.aUY.get("000000000");
            }
        }
        return r1;
    }
}
