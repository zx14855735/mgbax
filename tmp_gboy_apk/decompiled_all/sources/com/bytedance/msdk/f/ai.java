package com.bytedance.msdk.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cb;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.c.u;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ai {
    private static final Map<String, ai> xj = new HashMap();
    private com.bytedance.sdk.component.u.hf.w hf;

    static {
        ywSyzJ();
    }

    private ai(String str, Context context) {
        context = context == null ? com.bytedance.msdk.core.hf.getContext() : context;
        if (context != null) {
            this.hf = new u.xj().xj(str).xj(context).xj(1).xj(com.bytedance.msdk.core.xj.p().g()).xj();
        }
    }

    public static JSONObject c(String str) {
        try {
            String hf = xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).hf(str);
            if (TextUtils.isEmpty(hf)) {
                return null;
            }
            xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).y(str);
            return new JSONObject(hf);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static ai xj(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_mediation_sdk_sp";
        }
        Map<String, ai> map = xj;
        ai aiVar = map.get(str);
        if (aiVar != null) {
            return aiVar;
        }
        ai aiVar2 = new ai(str, context);
        map.put(str, aiVar2);
        return aiVar2;
    }

    private static /* synthetic */ void ywSyzJ() {
        char[] charArray = "\u0091\u009d\u009fÜ\u0095\u0093\u009f\u0097Ü\u0090\u009d\u008bÜ\u0081\u009a\u0097\u009e\u009eÜ¸\u009c\u009b°\u0080\u009b\u0096\u0095\u0097".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 242);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0091\u009e\u009b\u009c\u009b\u0086".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 242);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public String hf(String str) {
        try {
            return hf(str, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean kd(String str) {
        return hf(str, false);
    }

    public long u(String str) {
        return hf(str, -1L);
    }

    public int w(String str) {
        return hf(str, -1);
    }

    public void y(String str) {
        try {
            this.hf.remove(str);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject kd() {
        try {
            String hf = xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).hf("init_time");
            if (TextUtils.isEmpty(hf)) {
                return null;
            }
            xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).y("init_time");
            return new JSONObject(hf);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONArray u() {
        try {
            String hf = xj("gm_v3_temp", com.bytedance.msdk.core.hf.getContext()).hf("gm_key_v3_bug");
            if (TextUtils.isEmpty(hf)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(hf);
            xj("gm_v3_temp", com.bytedance.msdk.core.hf.getContext()).y("gm_key_v3_bug");
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String hf(String str, String str2) {
        try {
            return this.hf.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void w() {
        try {
            this.hf.clear();
        } catch (Throwable unused) {
        }
    }

    public static void w(String str, long j) {
        JSONObject jSONObject;
        try {
            String hf = xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).hf("init_time");
            if (TextUtils.isEmpty(hf)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(hf);
            }
            jSONObject.put(str, j);
            xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).xj("init_time", jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public int hf(String str, int i) {
        try {
            return this.hf.get(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public long hf(String str, long j) {
        try {
            return this.hf.get(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public float hf(String str, float f) {
        try {
            return this.hf.get(str, f);
        } catch (Throwable unused) {
            return f;
        }
    }

    public void xj(String str) {
        xj("any_door_id", str);
    }

    public boolean hf(String str, boolean z) {
        try {
            return this.hf.get(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    public String xj() {
        return hf("any_door_id", "");
    }

    public Map<String, ?> hf() {
        try {
            return this.hf.getAll();
        } catch (Throwable unused) {
            return new HashMap();
        }
    }

    public void xj(String str, String str2) {
        try {
            this.hf.put(str, str2);
        } catch (Throwable unused) {
        }
    }

    public void xj(String str, int i) {
        try {
            this.hf.put(str, i);
        } catch (Throwable unused) {
        }
    }

    public static void hf(Map<String, Object> map) {
        try {
            Context context = com.bytedance.msdk.core.hf.getContext();
            SharedPreferences hf = com.bytedance.sdk.openadsdk.api.plugin.hf.hf((Context) com.bytedance.msdk.xj.kd.xj.xj(context), "cb_test", 0);
            String string = hf.getString("ks", "");
            String string2 = hf.getString("gdt", "");
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                hf = com.bytedance.sdk.openadsdk.api.plugin.hf.hf(context, "cb_test", 0);
                string = hf.getString("ks", "");
                string2 = hf.getString("gdt", "");
            }
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put("ks", string);
            }
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put("gdt", string2);
            }
            map.put("cb_stacktrace", jSONObject);
            hf.edit().clear().apply();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
    }

    public void xj(String str, long j) {
        try {
            this.hf.put(str, j);
        } catch (Throwable unused) {
        }
    }

    public void xj(String str, float f) {
        try {
            this.hf.put(str, f);
        } catch (Throwable unused) {
        }
    }

    public void xj(String str, boolean z) {
        try {
            this.hf.put(str, z);
        } catch (Throwable unused) {
        }
    }

    public static void xj(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            String hf = xj("gm_v3_temp", com.bytedance.msdk.core.hf.getContext()).hf("gm_key_v3_bug");
            if (!TextUtils.isEmpty(hf)) {
                jSONArray = new JSONArray(hf);
            } else {
                jSONArray = new JSONArray();
            }
            if (jSONArray.length() >= 100) {
                jSONArray.put(99, jSONObject);
            } else {
                jSONArray.put(jSONObject);
            }
            xj("gm_v3_temp", com.bytedance.msdk.core.hf.getContext()).xj("gm_key_v3_bug", jSONArray.toString());
        } catch (Throwable unused) {
        }
    }

    public static void xj(boolean z, int i, String str, long j, String str2) {
        JSONObject jSONObject;
        try {
            String hf = xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).hf("v3");
            if (TextUtils.isEmpty(hf)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(hf);
            }
            int i2 = 1;
            if (z) {
                JSONObject optJSONObject = jSONObject.optJSONObject(cb.o);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                    jSONObject.put(cb.o, optJSONObject);
                }
                int optInt = optJSONObject.optInt("times", -1);
                int i3 = optInt == -1 ? 1 : optInt + 1;
                optJSONObject.put("times", i3);
                int optInt2 = optJSONObject.optInt("upload_size", -1);
                if (optInt2 != -1) {
                    i += optInt2;
                }
                optJSONObject.put("upload_size", i);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(MediationConstant.KEY_REASON);
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                    optJSONObject.put(MediationConstant.KEY_REASON, optJSONObject2);
                }
                int optInt3 = optJSONObject2.optInt(str, -1);
                if (optInt3 != -1) {
                    i2 = 1 + optInt3;
                }
                optJSONObject2.put(str, i2);
                if (j <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    long optInt4 = optJSONObject.optInt("avg_req_duration", -1);
                    optJSONObject.put("avg_req_duration", optInt4 == -1 ? j : ((optInt4 * (i3 - 1)) + j) / i3);
                }
            } else {
                JSONObject optJSONObject3 = jSONObject.optJSONObject("fail");
                if (optJSONObject3 == null) {
                    optJSONObject3 = new JSONObject();
                    jSONObject.put("fail", optJSONObject3);
                }
                int optInt5 = optJSONObject3.optInt("times", -1);
                optJSONObject3.put("times", optInt5 == -1 ? 1 : optInt5 + 1);
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("error_code");
                if (optJSONObject4 == null) {
                    optJSONObject4 = new JSONObject();
                    optJSONObject3.put("error_code", optJSONObject4);
                }
                int optInt6 = optJSONObject4.optInt(str2, -1);
                if (optInt6 != -1) {
                    i2 = 1 + optInt6;
                }
                optJSONObject4.put(str2, i2);
            }
            xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).xj("v3", jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static void xj(String str, boolean z, long j, String str2) {
        JSONObject jSONObject;
        try {
            String hf = xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).hf(str);
            if (TextUtils.isEmpty(hf)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(hf);
            }
            int i = 1;
            if (z) {
                JSONObject optJSONObject = jSONObject.optJSONObject(cb.o);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                    jSONObject.put(cb.o, optJSONObject);
                }
                int optInt = optJSONObject.optInt("times", -1);
                if (optInt != -1) {
                    i = 1 + optInt;
                }
                optJSONObject.put("times", i);
                if (j <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    long optInt2 = optJSONObject.optInt("avg_req_duration", -1);
                    if (optInt2 != -1) {
                        j = ((optInt2 * (i - 1)) + j) / i;
                    }
                    optJSONObject.put("avg_req_duration", j);
                }
            } else {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("fail");
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                    jSONObject.put("fail", optJSONObject2);
                }
                int optInt3 = optJSONObject2.optInt("times", -1);
                optJSONObject2.put("times", optInt3 == -1 ? 1 : optInt3 + 1);
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("error_code");
                if (optJSONObject3 == null) {
                    optJSONObject3 = new JSONObject();
                    optJSONObject2.put("error_code", optJSONObject3);
                }
                int optInt4 = optJSONObject3.optInt(str2, -1);
                if (optInt4 != -1) {
                    i = 1 + optInt4;
                }
                optJSONObject3.put(str2, i);
            }
            xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).xj(str, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static void xj(int i, int i2) {
        try {
            int hf = xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).hf("low_m_cnt", 0);
            int hf2 = xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).hf("clean_invalid_cnt", 0) + i;
            int hf3 = xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).hf("force_clean_cnt", 0) + i2;
            xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).xj("low_m_cnt", hf + 1);
            xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).xj("clean_invalid_cnt", hf2);
            xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).xj("force_clean_cnt", hf3);
        } catch (Throwable unused) {
        }
    }

    public static void xj(Map<String, Object> map) {
        try {
            int hf = xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).hf("low_m_cnt", 0);
            int hf2 = xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).hf("clean_invalid_cnt", 0);
            int hf3 = xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).hf("force_clean_cnt", 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("low_m_cnt", hf);
            jSONObject.put("invalid_cnt", hf2);
            jSONObject.put("force_cnt", hf3);
            map.put("low_m_clean", jSONObject);
            xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).xj("low_m_cnt", 0);
            xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).xj("clean_invalid_cnt", 0);
            xj("evt_upload_info", com.bytedance.msdk.core.hf.getContext()).xj("force_clean_cnt", 0);
        } catch (Throwable unused) {
        }
    }
}
