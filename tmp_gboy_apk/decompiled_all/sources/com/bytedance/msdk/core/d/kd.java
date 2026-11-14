package com.bytedance.msdk.core.d;

import android.text.TextUtils;
import com.bytedance.msdk.core.kd.hf.c;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.f.j;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd extends xj {
    private static volatile kd kd;
    private final Map<String, double[]> u;
    protected final Map<String, String> w;

    private kd() {
        super("label_v_v_s");
        this.w = new ConcurrentHashMap();
        this.u = new ConcurrentHashMap();
        hf();
    }

    public static String kd() {
        if (!com.bytedance.msdk.core.hf.hf().vm()) {
            return null;
        }
        Set<Map.Entry<String, com.bytedance.msdk.core.tf.w>> entrySet = com.bytedance.msdk.core.hf.hf().n().entrySet();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, com.bytedance.msdk.core.tf.w> entry : entrySet) {
            String key = entry.getKey();
            com.bytedance.msdk.core.tf.w value = entry.getValue();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("label_name", value.xj());
                jSONObject2.putOpt("timestamp", value.hf());
                jSONObject2.putOpt("lower_bound", Double.valueOf(value.y()));
                jSONObject2.putOpt("upper_bound", Double.valueOf(value.kd()));
                jSONObject.putOpt(xj.xj(Integer.parseInt(key)), jSONObject2);
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        return jSONObject.toString();
    }

    public static kd u() {
        if (kd == null) {
            synchronized (kd.class) {
                try {
                    if (kd == null) {
                        kd = new kd();
                    }
                } finally {
                }
            }
        }
        return kd;
    }

    public static String w(int i) {
        com.bytedance.msdk.core.tf.w wVar;
        if (com.bytedance.msdk.core.hf.hf().vm() && (wVar = com.bytedance.msdk.core.hf.hf().n().get(String.valueOf(i))) != null) {
            return wVar.xj();
        }
        return null;
    }

    public Map<String, JSONObject> hf(int i) {
        if (!com.bytedance.msdk.core.hf.hf().vm()) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = null;
        for (Map.Entry<String, double[]> entry : (i == 2 ? this.u : hf(this.w)).entrySet()) {
            String key = entry.getKey();
            double[] value = entry.getValue();
            try {
                if (!TextUtils.isEmpty(key)) {
                    Map<String, JSONObject> xj = xj(key, value);
                    JSONObject jSONObject3 = xj.get("config_req_label_value");
                    JSONObject jSONObject4 = xj.get("event_label_value");
                    if (jSONObject4 != null) {
                        jSONObject.putOpt(key, jSONObject4);
                    }
                    if (jSONObject3 != null) {
                        if (jSONObject2 == null) {
                            jSONObject2 = new JSONObject();
                        }
                        jSONObject2.putOpt(key, jSONObject3);
                    }
                }
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        hashMap.put("event_label_value_root", jSONObject);
        if (jSONObject2 != null) {
            hashMap.put("config_req_label_value_root", jSONObject2);
        }
        u(i);
        return hashMap;
    }

    public void xj(int i, double d) {
        if (com.bytedance.msdk.core.hf.hf().vm()) {
            xj(2, String.valueOf(i), 1, d);
        }
    }

    private Map<String, JSONObject> xj(String str, double[] dArr) {
        JSONObject jSONObject;
        JSONException e;
        HashMap hashMap = new HashMap();
        String xj = xj(dArr);
        JSONObject jSONObject2 = null;
        try {
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        if (!xj.equals("-1")) {
            jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("input", hf(xj));
                jSONObject.putOpt("timestamp", String.valueOf(System.currentTimeMillis()));
            } catch (JSONException e3) {
                e = e3;
                pl.xj(e);
                jSONObject2 = jSONObject;
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.putOpt("ecpm", xj);
                jSONObject4.putOpt("timestamp", String.valueOf(System.currentTimeMillis()));
                jSONObject3.putOpt("ecpm_info", jSONObject4);
                hashMap.put("config_req_label_value", jSONObject2);
                hashMap.put("event_label_value", jSONObject3);
                return hashMap;
            }
            jSONObject2 = jSONObject;
        }
        JSONObject jSONObject32 = new JSONObject();
        JSONObject jSONObject42 = new JSONObject();
        try {
            jSONObject42.putOpt("ecpm", xj);
            jSONObject42.putOpt("timestamp", String.valueOf(System.currentTimeMillis()));
            jSONObject32.putOpt("ecpm_info", jSONObject42);
        } catch (JSONException e4) {
            pl.xj(e4);
        }
        hashMap.put("config_req_label_value", jSONObject2);
        hashMap.put("event_label_value", jSONObject32);
        return hashMap;
    }

    private void u(int i) {
        if (i == 2) {
            this.u.clear();
            return;
        }
        this.w.clear();
        ai aiVar = this.hf;
        if (aiVar != null) {
            aiVar.w();
        }
    }

    public void xj(JSONObject jSONObject, JSONObject jSONObject2) {
        if (com.bytedance.msdk.core.hf.hf().vm() && jSONObject2 != null) {
            try {
                jSONObject.putOpt("label_inputs", jSONObject2);
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
    }

    private Map<String, double[]> hf(Map<String, String> map) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (map != null && map.size() != 0) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    String value = it.next().getValue();
                    if (!TextUtils.isEmpty(value)) {
                        String[] split = value.split("_");
                        String str = split[0];
                        String str2 = split[1];
                        String str3 = split[2];
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                            if (com.bytedance.msdk.core.hf.hf().xj(System.currentTimeMillis() - Long.parseLong(split[2]))) {
                                double[] dArr = (double[]) concurrentHashMap.get(str);
                                if (dArr == null) {
                                    dArr = new double[2];
                                }
                                dArr[0] = dArr[0] + 1.0d;
                                dArr[1] = dArr[1] + Double.parseDouble(str2);
                                concurrentHashMap.put(str, dArr);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return concurrentHashMap;
    }

    public void xj(JSONObject jSONObject) {
        if (com.bytedance.msdk.core.hf.hf().vm()) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, com.bytedance.msdk.core.tf.w> entry : com.bytedance.msdk.core.hf.hf().n().entrySet()) {
                String key = entry.getKey();
                com.bytedance.msdk.core.tf.w value = entry.getValue();
                if (value != null) {
                    try {
                        jSONObject2.putOpt(key, xj(value));
                    } catch (JSONException e) {
                        pl.xj(e);
                    }
                }
            }
            if (jSONObject != null) {
                jSONObject2.length();
            }
            try {
                jSONObject.putOpt("last_label_outputs", jSONObject2);
            } catch (JSONException e2) {
                pl.xj(e2);
            }
        }
    }

    public void xj(boolean z, com.bytedance.msdk.kd.u uVar, JSONObject jSONObject, Map<String, Object> map) {
        uVar.xj(MediationConstant.KEY_REASON, Integer.valueOf(!z ? 1 : 0));
        if (map != null) {
            hf(jSONObject);
            if (jSONObject != null) {
                map.put("label", jSONObject);
            }
        }
    }

    @Override // com.bytedance.msdk.core.d.xj
    public JSONObject xj(com.bytedance.msdk.core.tf.w wVar) {
        if (wVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("label_name", wVar.xj());
            jSONObject.putOpt("label_id", Integer.valueOf(wVar.w()));
            jSONObject.putOpt("label_version", wVar.u());
            jSONObject.putOpt("upper_bound", Double.valueOf(wVar.kd()));
            jSONObject.putOpt("lower_bound", Double.valueOf(wVar.y()));
            jSONObject.putOpt("timestamp", wVar.hf());
            return jSONObject;
        } catch (JSONException e) {
            pl.xj(e);
            return null;
        }
    }

    private void hf(JSONObject jSONObject) {
        Map<String, com.bytedance.msdk.core.tf.w> n = com.bytedance.msdk.core.hf.hf().n();
        if (n.size() > 0 && jSONObject == null) {
            jSONObject = new JSONObject();
        }
        for (Map.Entry<String, com.bytedance.msdk.core.tf.w> entry : n.entrySet()) {
            String key = entry.getKey();
            com.bytedance.msdk.core.tf.w value = entry.getValue();
            if (value != null) {
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject(String.valueOf(key));
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                        jSONObject.put(String.valueOf(key), optJSONObject);
                        optJSONObject.put("ecpm_info", new JSONObject());
                    }
                    optJSONObject.putOpt("label_info", xj(value));
                    optJSONObject.putOpt("ecpm_ttl", Integer.valueOf(com.bytedance.msdk.core.hf.hf().dc()));
                } catch (JSONException e) {
                    pl.xj(e);
                }
            }
        }
    }

    public void xj(Map<String, ConcurrentHashMap<String, List<c>>> map) {
        int i;
        ConcurrentHashMap<String, List<c>> value;
        if (!com.bytedance.msdk.core.hf.hf().vm() || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, ConcurrentHashMap<String, List<c>>> entry : map.entrySet()) {
            String key = entry.getKey();
            ConcurrentHashMap<String, List<c>> value2 = entry.getValue();
            if (value2 != null) {
                Iterator<Map.Entry<String, List<c>>> it = value2.entrySet().iterator();
                while (it.hasNext()) {
                    List<c> value3 = it.next().getValue();
                    if (value3 != null && !value3.isEmpty() && value3.get(0) != null && value3.get(0).xj != null) {
                        i = value3.get(0).xj.ci();
                        break;
                    }
                }
            }
            i = 0;
            com.bytedance.msdk.core.tf.hf xj = com.bytedance.msdk.c.xj.w.xj().xj(key, i, 101);
            if (xj != null && xj.c() == 1 && (value = entry.getValue()) != null) {
                Iterator<Map.Entry<String, List<c>>> it2 = value.entrySet().iterator();
                while (it2.hasNext()) {
                    List<c> value4 = it2.next().getValue();
                    if (value4 != null && !value4.isEmpty() && value4.get(0) != null && value4.get(0).xj != null) {
                        j.xj(value4);
                        c cVar = value4.get(0);
                        hf(cVar.xj.ci(), cVar.xj.da());
                    }
                }
            }
        }
        com.bytedance.msdk.core.am.hf.xj(com.bytedance.msdk.core.hf.hf()).xj(2);
    }

    @Override // com.bytedance.msdk.core.d.xj
    public boolean hf(String str, JSONObject jSONObject, Map<String, Object> map) {
        com.bytedance.msdk.core.tf.w wVar = com.bytedance.msdk.core.hf.hf().n().get(str);
        if (wVar == null) {
            return false;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            jSONObject2.putOpt("label_info", xj(wVar));
            jSONObject2.putOpt("ecpm_ttl", Integer.valueOf(com.bytedance.msdk.core.hf.hf().dc()));
            return true;
        } catch (JSONException e) {
            pl.xj(e);
            return false;
        }
    }

    public void hf(int i, double d) {
        if (com.bytedance.msdk.core.hf.hf().vm()) {
            String valueOf = String.valueOf(i);
            double[] dArr = this.u.get(valueOf);
            if (dArr == null) {
                dArr = new double[2];
            }
            dArr[0] = dArr[0] + 1.0d;
            dArr[1] = dArr[1] + d;
            this.u.put(valueOf, dArr);
        }
    }

    @Override // com.bytedance.msdk.core.d.xj
    public void xj(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("cpm_key_")) {
            return;
        }
        this.w.put(str, str2);
    }

    @Override // com.bytedance.msdk.core.d.xj
    public Map<String, String> xj() {
        return this.w;
    }

    @Override // com.bytedance.msdk.core.d.xj
    public void xj(String str, int i, String str2) {
        if (i == 2) {
            this.w.put(str, str2);
        }
    }
}
