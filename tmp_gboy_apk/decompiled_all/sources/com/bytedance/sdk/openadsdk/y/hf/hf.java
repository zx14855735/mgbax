package com.bytedance.sdk.openadsdk.y.hf;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static Map<String, Map<String, Map<String, Integer>>> xj = new HashMap();

    static {
        RFjxDn();
    }

    private static /* synthetic */ void RFjxDn() {
        char[] charArray = "\u0083\u008f\u008dÎ\u0087\u0081\u008d\u0085Î\u0082\u008f\u0099Î\u0093\u0088\u0085\u008c\u008cÎª\u008e\u0089¢\u0092\u0089\u0084\u0087\u0085".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 224);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0083\u008c\u0089\u008e\u0089\u0094".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 224);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private static void c(String str, String str2) {
        xj(str, str2, "pe_c");
    }

    private static void d(String str, String str2) {
        xj(str, str2, "lvsu_c");
    }

    private static void f(String str, String str2) {
        xj(str, str2, "lvs_c");
    }

    private static void hf(String str, String str2) {
        xj(str, str2, "ps_c");
    }

    private static void kd(String str, String str2) {
        xj(str, str2, "fpu_c");
    }

    private static void p(String str, String str2) {
        xj(str, str2, "lvc_c");
    }

    private static void tf(String str, String str2) {
        xj(str, str2, "lve_c");
    }

    private static void u(String str, String str2) {
        xj(str, str2, "fo_c");
    }

    private static void w(String str, String str2) {
        xj(str, str2, "fpl_c");
    }

    public static void xj(String str, ws wsVar) {
        char c;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.x.w wVar = (com.bytedance.sdk.openadsdk.core.x.w) com.bytedance.sdk.openadsdk.ats.w.xj("pitaya");
        if (wVar == null || wVar.isPitayaEnvAvailable()) {
            try {
                String valueOf = String.valueOf(wo.f(wsVar));
                String xj2 = wo.xj(wsVar, "-1");
                switch (str.hashCode()) {
                    case -2093321865:
                        if (str.equals("load_video_cancel")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1643912491:
                        if (str.equals("feed_over")) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case -1643892427:
                        if (str.equals("feed_play")) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3529469:
                        if (str.equals("show")) {
                            c = '\n';
                            break;
                        }
                        c = 65535;
                        break;
                    case 211925867:
                        if (str.equals("load_video_error")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 224898501:
                        if (str.equals("load_video_start")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 566194974:
                        if (str.equals("feed_break")) {
                            c = 6;
                            break;
                        }
                        c = 65535;
                        break;
                    case 578633749:
                        if (str.equals("feed_pause")) {
                            c = 7;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1409113254:
                        if (str.equals("load_video_success")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1912965437:
                        if (str.equals("play_error")) {
                            c = '\t';
                            break;
                        }
                        c = 65535;
                        break;
                    case 1925938071:
                        if (str.equals("play_start")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        f(valueOf, xj2);
                        break;
                    case 1:
                        p(valueOf, xj2);
                        break;
                    case 2:
                        d(valueOf, xj2);
                        break;
                    case 3:
                        tf(valueOf, xj2);
                        break;
                    case 4:
                        hf(valueOf, xj2);
                        break;
                    case 5:
                        w(valueOf, xj2);
                        break;
                    case 6:
                        y(valueOf, xj2);
                        break;
                    case 7:
                        kd(valueOf, xj2);
                        break;
                    case '\b':
                        u(valueOf, xj2);
                        break;
                    case '\t':
                        c(valueOf, xj2);
                        break;
                    case '\n':
                        xj(valueOf, xj2);
                        break;
                }
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
    }

    private static void y(String str, String str2) {
        xj(str, str2, "fb_c");
    }

    private static void xj(String str, String str2) {
        xj(str, str2, "show_c");
    }

    private static void xj(String str, String str2, String str3) {
        Map<String, Map<String, Integer>> map = xj.get(str);
        if (map == null) {
            map = new HashMap<>();
            xj.put(str, map);
        }
        Map<String, Integer> map2 = map.get(str2);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(str2, map2);
        }
        Integer num = map2.get(str3);
        if (num == null) {
            map2.put(str3, 1);
        } else {
            map2.put(str3, Integer.valueOf(num.intValue() + 1));
        }
    }

    public static JSONObject xj() {
        JSONObject jSONObject = new JSONObject();
        if (!xj.isEmpty()) {
            try {
                for (Map.Entry<String, Map<String, Map<String, Integer>>> entry : xj.entrySet()) {
                    String key = entry.getKey();
                    Map<String, Map<String, Integer>> value = entry.getValue();
                    JSONObject jSONObject2 = new JSONObject();
                    if (value != null) {
                        for (Map.Entry<String, Map<String, Integer>> entry2 : value.entrySet()) {
                            String key2 = entry2.getKey();
                            Map<String, Integer> value2 = entry2.getValue();
                            JSONObject jSONObject3 = new JSONObject();
                            if (value2 != null) {
                                for (Map.Entry<String, Integer> entry3 : value2.entrySet()) {
                                    jSONObject3.put(entry3.getKey(), entry3.getValue());
                                }
                            }
                            jSONObject2.put(key2, jSONObject3);
                        }
                    }
                    jSONObject.put(key, jSONObject2);
                }
            } catch (Exception e) {
                pl.xj(e);
            }
        }
        return jSONObject;
    }
}
