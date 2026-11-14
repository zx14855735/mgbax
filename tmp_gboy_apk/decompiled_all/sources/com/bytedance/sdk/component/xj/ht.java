package com.bytedance.sdk.component.xj;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class ht {
    private final Map<String, pz> hf;
    private final Set<xj> u;
    private final p w;
    private final Collection<String> xj;

    public interface xj {
    }

    public void hf(xj xjVar) {
        this.u.remove(xjVar);
    }

    public pz xj(String str) {
        if (this.xj.contains(str) || TextUtils.equals(str, "host")) {
            return xj(str, null);
        }
        throw new IllegalArgumentException(CtFAbx.BI9f7h("Namespace: ", str, " not registered."));
    }

    public void xj(xj xjVar) {
        this.u.add(xjVar);
    }

    private pz xj(String str, JSONObject jSONObject) {
        pz pzVar = this.hf.get(str);
        if (pzVar == null) {
            pz pzVar2 = new pz(str, this.w.w(), this.w.xj(), this.w.hf(), jSONObject);
            this.hf.put(str, pzVar2);
            return pzVar2;
        }
        if (jSONObject != null) {
            pzVar.update(jSONObject);
        }
        return pzVar;
    }
}
