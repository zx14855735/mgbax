package com.bytedance.msdk.core.d;

import android.text.TextUtils;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    public static final Map<String, com.bytedance.msdk.core.tf.hf> xj = new ConcurrentHashMap();

    static {
        RFTsMOI();
    }

    private static /* synthetic */ void RFTsMOI() {
        char[] charArray = "´¸ºù°¶º²ùµ¸®ù¤¿²»»ù\u009d¹¾\u0095¥¾³°²".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 215);
        }
        String str = new String(charArray);
        char[] charArray2 = "´»¾¹¾£".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 215);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(int i, String str, int i2, double d) {
        com.bytedance.msdk.core.tf.hf xj2;
        com.bytedance.msdk.core.tf.u kd;
        if (com.bytedance.msdk.core.hf.hf().vm() && (xj2 = com.bytedance.msdk.core.hf.hf().xj(str, i2, 101)) != null) {
            if (xj2.c() == 1 && i == 1) {
                kd.u().xj(i2, d);
                return;
            }
            if (xj2.c() != 2 || (kd = com.bytedance.msdk.core.hf.hf().kd(str)) == null) {
                return;
            }
            if (i == 2 && kd.w() == 2) {
                hf.u().xj(str, 2, d);
            } else {
                if (i != 1 || kd.w() == 2) {
                    return;
                }
                hf.u().xj(str, kd.w(), d);
            }
        }
    }

    public static void xj(com.bytedance.msdk.core.tf.hf hfVar, double d, String str, int i) {
        if (!com.bytedance.msdk.core.hf.hf().vm() || hfVar == null) {
            return;
        }
        if (hfVar.c() == 2) {
            xj(2, str, i, d);
        } else if (hfVar.c() == 3 || hfVar.c() == 4) {
            hf.u().xj(hfVar.ff(), "_last_load_cpm_", hfVar.en(), d);
        }
    }

    public static void xj(String str, String str2, int i, JSONObject jSONObject) {
        com.bytedance.msdk.core.tf.hf xj2;
        if (com.bytedance.msdk.core.hf.hf().vm() && (xj2 = com.bytedance.msdk.c.xj.w.xj().xj(str, i, 101)) != null) {
            if ("mediation_request".equals(str2)) {
                if (xj2.c() == 1) {
                    kd.u().xj(String.valueOf(i), jSONObject, xj2.y());
                    return;
                } else {
                    if (xj2.c() == 2) {
                        hf.u().xj(String.valueOf(i), jSONObject, xj2.y());
                        return;
                    }
                    return;
                }
            }
            if (xj2.c() != 2 || "sdk_init".equals(str2) || "sdk_init_end".equals(str2) || "get_config_start".equals(str2) || "get_config_final".equals(str2)) {
                return;
            }
            hf.u().w(String.valueOf(i), jSONObject, xj2.y());
        }
    }

    public static com.bytedance.msdk.core.tf.hf xj(com.bytedance.msdk.core.tf.hf hfVar, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (hfVar != null && com.bytedance.msdk.core.hf.hf().vm()) {
            if (i == 101) {
                return xj.get(hfVar.ff());
            }
            if (i == 100 && (hfVar.c() == 2 || hfVar.c() == 3 || hfVar.c() == 4)) {
                List<tf> xj2 = w.xj(hfVar, hfVar.ff());
                Object obj = hfVar.y().get("rule_in_use");
                int intValue = obj != null ? ((Integer) obj).intValue() : -1;
                hfVar.y().put("cost_time", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                if (xj2 == null || intValue == 0) {
                    return hfVar;
                }
                com.bytedance.msdk.core.tf.hf clone = hfVar.clone();
                if (clone.pl()) {
                    clone.hf(xj2);
                } else {
                    clone.xj(xj2);
                }
                Object obj2 = clone.y().get("max_ecpm");
                Object obj3 = clone.y().get("min_ecpm");
                if (obj2 != null) {
                    clone.u(((Double) obj2).doubleValue());
                }
                if (obj3 != null) {
                    clone.kd(((Double) obj3).doubleValue());
                }
                xj.put(hfVar.ff(), clone);
                clone.y().put("cost_time", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return clone;
            }
        }
        return null;
    }

    public static int xj(String str, int i, Map<String, Object> map) {
        com.bytedance.msdk.core.tf.u kd;
        int i2;
        if (!TextUtils.isEmpty(str) && i == 1 && (kd = com.bytedance.msdk.core.hf.hf().kd(str)) != null) {
            int w = kd.w();
            String u = kd.u();
            if (w > 0 && !TextUtils.isEmpty(u)) {
                double xj2 = hf.u().xj(3, str, w);
                List<com.bytedance.msdk.core.tf.w> y = com.bytedance.msdk.core.hf.hf().y(String.valueOf(i));
                if (y != null && y.size() > 0) {
                    for (com.bytedance.msdk.core.tf.w wVar : y) {
                        if (xj2 > wVar.y() && xj2 <= wVar.kd()) {
                            i2 = kd.xj(String.valueOf(wVar.w()));
                            map.put("refresh_time", Integer.valueOf(i2));
                            break;
                        }
                    }
                }
                i2 = 0;
                if (i2 >= 10000 && i2 <= 180000) {
                    return i2;
                }
            }
        }
        return 0;
    }

    public static void xj(int i, String str, JSONObject jSONObject) {
        com.bytedance.msdk.core.tf.u kd;
        if (com.bytedance.msdk.core.hf.hf().vm() && i == 2 && (kd = com.bytedance.msdk.core.hf.hf().kd(str)) != null) {
            try {
                jSONObject.putOpt("dynamic_rule_id", kd.u());
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
    }

    public static void xj(List<com.bytedance.msdk.hf.w> list, com.bytedance.msdk.core.tf.hf hfVar) {
        Object obj;
        if (!com.bytedance.msdk.core.hf.hf().vm() || list == null || hfVar == null) {
            return;
        }
        for (com.bytedance.msdk.hf.w wVar : list) {
            if (wVar != null) {
                if (hfVar.c() == 1) {
                    wVar.q().put(MediationConstant.KEY_GM_USB, kd.w(hfVar.a()));
                } else if (hfVar.c() == 2 && (obj = hfVar.y().get("user_label_value")) != null) {
                    wVar.q().put(MediationConstant.KEY_GM_USB, ((com.bytedance.msdk.core.tf.w) obj).xj());
                }
            }
        }
    }

    public static void xj(boolean z, com.bytedance.msdk.kd.u uVar, JSONObject jSONObject, Map<String, Object> map) {
        if (uVar == null || !com.bytedance.msdk.core.hf.hf().vm()) {
            return;
        }
        kd.u().xj(z, uVar, jSONObject, map);
    }

    public static void xj(int i, List<tf> list, Map<String, Object> map) {
        if (list == null || list.size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (tf tfVar : list) {
            if (tfVar != null && tfVar.v() == 0) {
                jSONArray.put(tfVar.yo());
            }
        }
        if (map != null) {
            map.put("rit_ids", jSONArray);
        }
    }
}
