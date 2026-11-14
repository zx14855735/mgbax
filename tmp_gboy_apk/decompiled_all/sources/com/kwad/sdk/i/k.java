package com.kwad.sdk.i;

import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class k implements b {
    public JSONObject aYb = new JSONObject();
    public String actionId = UUID.randomUUID().toString();

    public k(String str, String str2, i iVar) {
        JSONObject OO = h.OS().OW().OO();
        Iterator<String> keys = OO.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            c.a(OO, next, OO.opt(next));
        }
        c.putValue(this.aYb, "customKey", str);
        c.putValue(this.aYb, "customValue", str2);
        c.putValue(this.aYb, "timestamp", iVar.aXY);
        c.putValue(this.aYb, "actionId", this.actionId);
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return this.aYb;
    }

    public final String toString() {
        return this.aYb.toString();
    }
}
