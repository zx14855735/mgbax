package com.bytedance.msdk.f;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class am {
    private static String hf(com.bytedance.msdk.api.xj.hf hfVar) {
        if (hfVar == null) {
            return null;
        }
        switch (hfVar.ht()) {
        }
        return null;
    }

    public static com.bytedance.msdk.api.w xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.hf.w wVar, boolean z) {
        if (wVar == null || hfVar == null) {
            return null;
        }
        com.bytedance.msdk.api.w wVar2 = new com.bytedance.msdk.api.w();
        wVar2.xj(wVar.gj());
        wVar2.f(wVar.lw());
        wVar2.d(wVar.wa());
        wVar2.tf(wVar.cy());
        wVar2.pl(wVar.aq());
        if (z) {
            if (xj() || !(wVar.si() || wVar.lm() || wVar.vi())) {
                wVar2.p(wVar.i());
            } else {
                wVar2.p("-3");
            }
        } else if (hf() || !wVar.si()) {
            wVar2.p(wVar.ua());
        } else {
            wVar2.p("-3");
        }
        wVar2.am(wVar.ir());
        wVar2.hf(wVar.qi());
        wVar2.g(wVar.wn());
        wVar2.xj(hf(hfVar));
        wVar2.hf(xj(wVar));
        wVar2.c(hfVar.dk());
        wVar2.y(xj(hfVar));
        StringBuilder sb = new StringBuilder();
        sb.append(hfVar.aq());
        wVar2.w(sb.toString());
        com.bytedance.msdk.api.u.y ht = com.bytedance.msdk.core.xj.p().ht();
        wVar2.u(ht != null ? ht.w() : null);
        wVar2.kd(ht != null ? ht.u() : null);
        Map<String, Object> r = hfVar.r();
        if (r != null && !r.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Object> entry : r.entrySet()) {
                Object value = entry.getValue();
                hashMap.put(entry.getKey(), value == null ? null : value.toString());
            }
            wVar2.xj(hashMap);
        }
        return wVar2;
    }

    private static boolean hf() {
        return com.bytedance.msdk.core.hf.hf().et();
    }

    private static String xj(com.bytedance.msdk.api.xj.hf hfVar) {
        com.bytedance.msdk.core.tf.hf xj;
        if (hfVar == null || com.bytedance.msdk.c.xj.xj.xj().tf() != 1 || (xj = com.bytedance.msdk.c.xj.w.xj().xj(hfVar.ra(), hfVar.ht(), 102)) == null || xj.xj() == 1) {
            return null;
        }
        String wn = hfVar.wn();
        if (TextUtils.isEmpty(wn)) {
            return null;
        }
        try {
            return new JSONObject(wn).optString("experiment_detail_id");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
            return null;
        }
    }

    private static String xj(com.bytedance.msdk.hf.w wVar) {
        if (wVar == null) {
            return null;
        }
        switch (wVar.tj()) {
            case 1:
                break;
            case 2:
            case 7:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                int ci = wVar.ci();
                if (ci != 1) {
                    if (ci != 5) {
                        if (ci != 7) {
                        }
                    }
                }
                break;
        }
        return null;
    }

    private static boolean xj() {
        return com.bytedance.msdk.core.hf.hf().ra();
    }

    public static boolean xj(List<com.bytedance.msdk.hf.w> list, List<com.bytedance.msdk.hf.w> list2, List<com.bytedance.msdk.hf.w> list3, com.bytedance.msdk.api.xj.hf hfVar, boolean z, String str, int i, List<com.bytedance.msdk.core.tf.tf> list4) {
        int hf = com.bytedance.msdk.w.u.hf.hf(str);
        com.bytedance.msdk.kd.y.xj(list, list2, list3, hfVar, hf);
        if (z || hf != 0) {
            return false;
        }
        if (list.size() > 0) {
            for (com.bytedance.msdk.hf.w wVar : list) {
                if (wVar != null) {
                    com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.hf(str, wVar.cy()) + "isReady-》广告类型：" + com.bytedance.msdk.hf.xj.xj(wVar.gj()) + ",是否已准备好？isReady()：" + wVar.ff(str));
                    if (wVar.ff(str) && !wVar.tu()) {
                        return true;
                    }
                }
            }
        }
        if (list3 != null && list3.size() > 0) {
            for (com.bytedance.msdk.hf.w wVar2 : list3) {
                if (wVar2 != null) {
                    com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.hf(str, wVar2.cy()) + "isReady-》广告类型：" + com.bytedance.msdk.hf.xj.xj(wVar2.gj()) + ",是否已准备好？isReady()：" + wVar2.ff(str));
                    if (wVar2.ff(str) && !wVar2.tu()) {
                        return true;
                    }
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (com.bytedance.msdk.hf.w wVar3 : list2) {
                if (wVar3 != null) {
                    com.bytedance.msdk.xj.kd.w.xj(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.hf(str, wVar3.cy()) + "isReady--->biding-->广告类型：" + com.bytedance.msdk.hf.xj.xj(wVar3.gj()) + ",是否已准备好？isReady()：" + wVar3.ff(str));
                    if (wVar3.ff(str) && !wVar3.tu()) {
                        return true;
                    }
                }
            }
        }
        if (list4 != null && list4.size() > 0) {
            for (com.bytedance.msdk.core.tf.tf tfVar : list4) {
                String yo = tfVar.yo();
                if (tfVar.jk() && com.bytedance.msdk.core.kd.xj.xj.xj().u(str, yo, i) && com.bytedance.msdk.core.kd.xj.xj.xj().xj(yo, hfVar, false) == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean xj(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("show_adn_load_error_detail");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static com.bytedance.msdk.api.xj xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.api.xj xjVar, List<com.bytedance.msdk.api.hf> list) {
        if (xjVar != null && hfVar != null && list != null && list.size() != 0 && xj(hfVar.r())) {
            JSONArray jSONArray = new JSONArray();
            for (com.bytedance.msdk.api.hf hfVar2 : list) {
                if (hfVar2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(MediationConstant.EXTRA_ADN_NAME, TextUtils.isEmpty(hfVar2.w()) ? hfVar2.u() : hfVar2.w());
                        jSONObject.put("mediation_rit", hfVar2.hf());
                        jSONObject.put("ad_type", hfVar2.xj());
                        jSONObject.put("error_code", hfVar2.kd());
                        jSONObject.put("error_msg", hfVar2.y());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            xjVar.hf = jSONArray.toString();
        }
        return xjVar;
    }
}
