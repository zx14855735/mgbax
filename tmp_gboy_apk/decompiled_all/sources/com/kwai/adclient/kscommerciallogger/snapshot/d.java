package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d {
    private final String bkg;
    private final LinkedHashMap<String, String> bkh = new LinkedHashMap<>();
    private final long time = System.nanoTime();

    public d(String str) {
        this.bkg = str;
    }

    public synchronized JSONObject Vi() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : this.bkh.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("time", this.time);
                jSONObject.put("span_name", this.bkg);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }
}
