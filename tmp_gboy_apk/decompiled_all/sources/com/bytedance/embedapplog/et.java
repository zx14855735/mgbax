package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class et extends io {
    private final Map<String, q> kd;
    private final List<String> y;

    public et(Context context, pz pzVar, x xVar) {
        super(context, pzVar, xVar);
        this.kd = new HashMap();
        this.y = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        for (Map.Entry<String, q> entry : this.kd.entrySet()) {
            if (TextUtils.equals(entry.getKey(), "d_i0")) {
                JSONObject hf = entry.getValue().hf();
                c c = no.c();
                if (c != null && hf != null) {
                    JSONObject optJSONObject = hf.optJSONObject(PointParamKey.DATA);
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        arrayList.add(keys.next());
                    }
                    String[] strArr = (String[]) arrayList.toArray(new String[0]);
                    int[] iArr = new int[strArr.length];
                    for (int i = 0; i < strArr.length; i++) {
                        iArr[i] = optJSONObject.optInt(strArr[i]);
                    }
                    c.xj(strArr, iArr, false);
                    return;
                }
            }
        }
    }

    public void hf() {
        if (this.xj.size() <= 0) {
            v.xj("__kite", "return");
            return;
        }
        for (int i = 0; i < this.xj.size(); i++) {
            try {
                q qVar = this.xj.get(i).get();
                this.kd.put(qVar.xj(), qVar);
                if (v.hf()) {
                    v.xj("__kite", "result: ".concat(String.valueOf(qVar)));
                }
            } catch (Exception e) {
                v.u("__kite", "error " + e.getMessage());
            }
        }
    }

    @Override // com.bytedance.embedapplog.io
    public List<String> xj() {
        this.y.add("d_i0");
        this.y.add("d_a0");
        return this.y;
    }

    public void xj(final JSONObject jSONObject, final String str) {
        v.xj("__kite", "doReport");
        j.xj().postDelayed(new Runnable() { // from class: com.bytedance.embedapplog.et.1
            @Override // java.lang.Runnable
            public void run() {
                v.xj("__kite", "run()");
                JSONObject jSONObject2 = new JSONObject();
                try {
                    JSONObject xj = no.xj(jSONObject, str);
                    String xj2 = et.this.w.xj("d_data");
                    if (TextUtils.isEmpty(xj2)) {
                        JSONObject jSONObject3 = new JSONObject();
                        String hf = no.hf(xj);
                        jSONObject3.putOpt("header", hf);
                        if (v.hf()) {
                            v.xj("__kite", "config 请求header进行sword加密：加密内容：".concat(String.valueOf(xj)));
                            v.xj("__kite", "config 请求header进行sword加密：加密结果：".concat(String.valueOf(hf)));
                        }
                        jSONObject3.putOpt("fetch_config", Boolean.TRUE);
                        jSONObject3.putOpt("client_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        jSONObject2 = z.xj(et.this.hf, jSONObject3, et.this.xj(xj));
                        v.xj("__kite", "config from server.");
                    } else {
                        jSONObject2.putOpt("message", "ok");
                        jSONObject2.putOpt(PointParamKey.DATA, xj2);
                        v.xj("__kite", "config from cache");
                    }
                    if (v.hf()) {
                        v.xj("__kite", "config: ".concat(String.valueOf(jSONObject2)));
                    }
                    et.this.u.xj(jSONObject2);
                    et.this.xj(5L);
                    et.this.hf();
                    et.this.w();
                    et.this.hf(xj);
                } catch (Exception e) {
                    v.u("__kite", "error " + e.getMessage());
                }
            }
        }, this.u.w());
    }

    public void xj(long j) {
        Map<String, JSONObject> xj = this.u.xj();
        if (xj.isEmpty()) {
            v.xj("__kite", "map is empty");
        } else {
            xj(xj, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(final JSONObject jSONObject) {
        if (this.kd.size() <= 0) {
            return;
        }
        final JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, q> entry : this.kd.entrySet()) {
            try {
                JSONObject hf = entry.getValue().hf();
                jSONObject2.putOpt(entry.getKey(), no.hf(hf));
                if (v.hf()) {
                    v.xj("__kite", "report 请求data中的字段进行sword加密：加密内容：".concat(String.valueOf(hf)));
                }
            } catch (JSONException e) {
                v.u("__kite", "error " + e.getMessage());
            }
        }
        j.xj(new Runnable() { // from class: com.bytedance.embedapplog.et.2
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject.putOpt("device_type", Build.MODEL);
                    jSONObject.putOpt("device_platform", "android");
                    jSONObject3.putOpt("header", no.hf(jSONObject));
                    if (v.hf()) {
                        v.xj("__kite", "report 请求header进行sword加密：加密内容：" + jSONObject);
                    }
                    jSONObject3.putOpt("client_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    jSONObject3.putOpt(PointParamKey.DATA, jSONObject2);
                    jSONObject3.putOpt("version", Integer.valueOf(et.this.u.hf()));
                } catch (Exception e2) {
                    v.xj("__kite", "error: " + e2.getMessage());
                }
                JSONObject xj = z.xj(et.this.hf, jSONObject3, et.this.xj(jSONObject));
                if (v.hf()) {
                    v.w("__kite", "response:".concat(String.valueOf(xj)));
                }
                et.this.u.hf(xj);
            }
        });
    }
}
