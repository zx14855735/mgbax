package com.bytedance.adsdk.ugeno.xj;

import android.text.TextUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.adsdk.ugeno.xj.w;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Interpolator hf(String str) {
        char c;
        switch (str.hashCode()) {
            case -1965072618:
                if (str.equals("ease_in")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -787702915:
                if (str.equals("ease_out")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1065009829:
                if (str.equals("ease_in_out")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        return c != 0 ? c != 1 ? c != 2 ? new LinearInterpolator() : new DecelerateInterpolator() : new AccelerateDecelerateInterpolator() : new AccelerateInterpolator();
    }

    public static w.xj u(String str) {
        JSONArray xj;
        if (TextUtils.isEmpty(str) || (xj = com.bytedance.adsdk.ugeno.y.hf.xj(str, (JSONArray) null)) == null || xj.length() != 2) {
            return null;
        }
        w.xj xjVar = new w.xj();
        xjVar.xj = xj.optString(0);
        xjVar.hf = xj.optString(1);
        return xjVar;
    }

    public static float[] w(String str) {
        float[] fArr = {0.0f, 0.0f};
        JSONArray xj = com.bytedance.adsdk.ugeno.y.hf.xj(str, (JSONArray) null);
        if (xj != null && xj.length() == 2) {
            fArr[0] = (float) xj.optDouble(0);
            fArr[1] = (float) xj.optDouble(1);
        }
        return fArr;
    }

    public static int xj(int i) {
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return 1;
        }
        return i - 1;
    }

    public static List<w> xj(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return null;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(xj(optJSONObject, jSONObject));
                }
            }
            return arrayList;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static w xj(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        w wVar = new w();
        wVar.hf(com.bytedance.adsdk.ugeno.y.w.xj(com.bytedance.adsdk.ugeno.u.hf.xj(jSONObject.optString("delay"), jSONObject2), 0L));
        wVar.w(com.bytedance.adsdk.ugeno.u.hf.xj(jSONObject.optString("name"), jSONObject2));
        wVar.hf(com.bytedance.adsdk.ugeno.y.w.xj(com.bytedance.adsdk.ugeno.u.hf.xj(jSONObject.optString("playState"), jSONObject2), 1));
        wVar.xj(com.bytedance.adsdk.ugeno.y.w.xj(com.bytedance.adsdk.ugeno.u.hf.xj(jSONObject.optString(MediationConstant.EXTRA_DURATION), jSONObject2), 0L));
        wVar.xj(com.bytedance.adsdk.ugeno.y.w.xj(com.bytedance.adsdk.ugeno.u.hf.xj(jSONObject.optString("playCount"), jSONObject2), 1));
        wVar.xj(com.bytedance.adsdk.ugeno.u.hf.xj(jSONObject.optString("playDirection"), jSONObject2));
        wVar.xj(u(jSONObject.optString("transformOrigin")));
        wVar.hf(com.bytedance.adsdk.ugeno.u.hf.xj(jSONObject.optString("timingFunction", "linear"), jSONObject2));
        wVar.xj(jSONObject.optJSONObject("effect"));
        wVar.xj(xj(jSONObject.optJSONArray("keyframes"), jSONObject2));
        return wVar;
    }

    public static Map<String, TreeMap<Float, String>> xj(JSONArray jSONArray, JSONObject jSONObject) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                float optDouble = (float) optJSONObject.optDouble("offset");
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    TreeMap treeMap = (TreeMap) hashMap.get(next);
                    if (!TextUtils.equals(next, "offset")) {
                        if (hashMap.containsKey(next) && treeMap != null) {
                            treeMap.put(Float.valueOf(optDouble), com.bytedance.adsdk.ugeno.u.hf.xj(optJSONObject.optString(next), jSONObject));
                        } else {
                            TreeMap treeMap2 = new TreeMap();
                            treeMap2.put(Float.valueOf(optDouble), com.bytedance.adsdk.ugeno.u.hf.xj(optJSONObject.optString(next), jSONObject));
                            hashMap.put(next, treeMap2);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public static int xj(String str) {
        int hashCode = str.hashCode();
        if (hashCode == -1408024454) {
            return str.equals("alternate") ? 2 : 1;
        }
        if (hashCode != -1039745817) {
            return 1;
        }
        str.equals(PrerollVideoResponse.NORMAL);
        return 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0036, code lost:
    
        if (r6.equals("top") == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int xj(java.lang.String r6, int r7) {
        /*
            r0 = 1
            r1 = 0
            r2 = 2
            int r3 = r7 / 2
            boolean r4 = android.text.TextUtils.isEmpty(r6)
            if (r4 == 0) goto Ld
            goto L74
        Ld:
            r6.getClass()
            r4 = -1
            int r5 = r6.hashCode()
            switch(r5) {
                case -1383228885: goto L44;
                case -1364013995: goto L39;
                case 115029: goto L30;
                case 3317767: goto L25;
                case 108511772: goto L1a;
                default: goto L18;
            }
        L18:
            r2 = -1
            goto L4e
        L1a:
            java.lang.String r2 = "right"
            boolean r2 = r6.equals(r2)
            if (r2 != 0) goto L23
            goto L18
        L23:
            r2 = 4
            goto L4e
        L25:
            java.lang.String r2 = "left"
            boolean r2 = r6.equals(r2)
            if (r2 != 0) goto L2e
            goto L18
        L2e:
            r2 = 3
            goto L4e
        L30:
            java.lang.String r5 = "top"
            boolean r5 = r6.equals(r5)
            if (r5 != 0) goto L4e
            goto L18
        L39:
            java.lang.String r2 = "center"
            boolean r2 = r6.equals(r2)
            if (r2 != 0) goto L42
            goto L18
        L42:
            r2 = 1
            goto L4e
        L44:
            java.lang.String r2 = "bottom"
            boolean r2 = r6.equals(r2)
            if (r2 != 0) goto L4d
            goto L18
        L4d:
            r2 = 0
        L4e:
            switch(r2) {
                case 0: goto L75;
                case 1: goto L74;
                case 2: goto L73;
                case 3: goto L73;
                case 4: goto L75;
                default: goto L51;
            }
        L51:
            java.lang.String r2 = "%"
            boolean r2 = r6.endsWith(r2)
            if (r2 == 0) goto L6e
            int r2 = r6.length()     // Catch: java.lang.NumberFormatException -> L74
            int r2 = r2 - r0
            java.lang.String r6 = r6.substring(r1, r2)     // Catch: java.lang.NumberFormatException -> L74
            float r6 = java.lang.Float.parseFloat(r6)     // Catch: java.lang.NumberFormatException -> L74
            float r7 = (float) r7     // Catch: java.lang.NumberFormatException -> L74
            float r7 = r7 * r6
            r6 = 1120403456(0x42c80000, float:100.0)
            float r7 = r7 / r6
            int r6 = (int) r7     // Catch: java.lang.NumberFormatException -> L74
            return r6
        L6e:
            int r6 = java.lang.Integer.parseInt(r6)     // Catch: java.lang.NumberFormatException -> L74
            return r6
        L73:
            return r1
        L74:
            return r3
        L75:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.xj.u.xj(java.lang.String, int):int");
    }
}
