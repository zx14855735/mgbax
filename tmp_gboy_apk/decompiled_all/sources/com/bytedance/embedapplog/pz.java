package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pz {
    private final x xj;
    private long hf = PushUIConfig.dismissTime;
    private long w = 1800000;
    private final Map<String, JSONObject> u = new HashMap();
    private final Map<String, JSONObject> kd = new HashMap();
    private String y = "";
    private final ReentrantLock c = new ReentrantLock();

    public pz(Context context, x xVar) {
        this.xj = xVar;
        hf(no.hf(context).getString("d_data", ""));
    }

    private void hf(String str) {
        if (!this.u.isEmpty() && !this.kd.isEmpty()) {
            v.w("__kite", " map is empty");
            return;
        }
        byte[] clientUnpackedBase64 = TTEncryptUtils.clientUnpackedBase64(str);
        if (clientUnpackedBase64 == null || clientUnpackedBase64.length == 0) {
            v.w("__kite", "parse is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(clientUnpackedBase64));
            if (v.hf()) {
                v.xj("__kite", " data:".concat(String.valueOf(jSONObject)));
            }
            this.y = jSONObject.optString("version", "");
            xj(jSONObject, "fields", this.u);
            int optInt = jSONObject.optInt("delay_sec", 0);
            if (optInt > 0) {
                this.hf = optInt * 1000;
            }
            int optInt2 = jSONObject.optInt("dtrait_mem_ttl_sec", 0);
            if (optInt2 > 0) {
                this.w = optInt2 * 1000;
            }
            xj(jSONObject, "dtrait_fields", this.kd);
            if (v.hf()) {
                v.xj("__kite".concat("parseConfigFields# fields: status_collect delay time:" + this.hf + ", dtraitExpireTime:" + this.w));
            }
        } catch (Exception e) {
            v.hf("__kiteparseConfigFields# error: " + e.getMessage());
        }
    }

    private boolean w(JSONObject jSONObject) {
        if (jSONObject.optString("message", "").equals("ok")) {
            return true;
        }
        v.xj("__kite", "error response");
        return false;
    }

    private void xj(String str) {
        this.xj.hf("d_data", str);
        this.xj.xj("d_data", str);
    }

    private void xj(JSONObject jSONObject, String str, Map<String, JSONObject> map) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i);
            map.put(jSONObject2.optString("name"), jSONObject2);
        }
    }

    public long w() {
        return this.hf;
    }

    public void xj(JSONObject jSONObject) {
        this.c.lock();
        try {
            try {
                if (!w(jSONObject)) {
                    v.w("__kite", "invalid response");
                } else {
                    String optString = jSONObject.optString(PointParamKey.DATA);
                    if (TextUtils.isEmpty(optString)) {
                        v.w("__kite", "response is empty");
                    } else {
                        xj(optString);
                        hf(optString);
                        if (v.hf()) {
                            v.xj("__kiteconfig parse success");
                        }
                    }
                }
            } catch (Exception e) {
                v.hf("__kiteerror" + e.getMessage());
            }
        } finally {
            this.c.unlock();
        }
    }

    public void hf(JSONObject jSONObject) {
        try {
            if (w(jSONObject)) {
                String optString = jSONObject.optString(PointParamKey.DATA);
                if (TextUtils.isEmpty(optString)) {
                    v.xj("__kite", "data is null");
                    return;
                }
                xj(optString);
                hf(optString);
                v.xj("__kitesuccess");
            }
        } catch (Exception e) {
            v.hf("__kiteerror " + e.getMessage());
        }
    }

    public Map<String, JSONObject> xj() {
        return this.u;
    }

    public String hf() {
        return this.y;
    }
}
