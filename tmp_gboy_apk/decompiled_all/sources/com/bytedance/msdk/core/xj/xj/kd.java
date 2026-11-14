package com.bytedance.msdk.core.xj.xj;

import ADYaiT.BpkvW3;
import P8ccfD.AaHO0E;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.x.p;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private static String xj = "dex";

    public static Function<SparseArray<Object>, Object> hf(String str) {
        Object apply;
        Function<SparseArray<Object>, Object> u = u(str);
        if (u == null) {
            return null;
        }
        try {
            apply = u.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(10000).xj(AaHO0E.ARc23Z()).hf());
            return AaHO0E.AYUAbz(apply);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Function<SparseArray<Object>, Object> u(String str) {
        y xj2 = xj.xj(str);
        if (xj2 == null) {
            com.bytedance.msdk.xj.kd.w.hf(xj, "strategy is null");
            return null;
        }
        if (!xj2.xj()) {
            com.bytedance.msdk.xj.kd.w.hf(xj, "can not use dex load adn ad");
            return null;
        }
        if (!p.c("com.byted.mixed")) {
            com.bytedance.msdk.xj.kd.w.hf(xj, "dex is not installed");
            return null;
        }
        if (p.y("com.byted.mixed")) {
            Function<SparseArray<Object>, Object> y = xj2.y();
            return y != null ? y : xj(xj2);
        }
        com.bytedance.msdk.xj.kd.w.hf(xj, "dex is not loaded");
        return null;
    }

    public static Function<SparseArray<Object>, Object> w(String str) {
        y xj2 = xj.xj(str);
        if (xj2 != null) {
            return xj2.hf();
        }
        return null;
    }

    public static int xj(String str, int i) {
        if (xj(str) && i > 0) {
            if (i == 1) {
                return 20012;
            }
            if (i == 2) {
                return 20013;
            }
            if (i == 3) {
                return 20014;
            }
            if (i == 4) {
                return 20015;
            }
        }
        return 20016;
    }

    public static Integer xj(String str, Function<SparseArray<Object>, Object> function) {
        Object apply;
        Object apply2;
        if (function != null) {
            if (xj(str)) {
                apply2 = function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8271).xj(Integer.class).hf());
                switch (apply2 instanceof Integer ? ((Integer) apply2).intValue() : -1) {
                    case 20009:
                        return 2;
                    case 20010:
                        return 3;
                    case 20011:
                        return 4;
                }
            }
            apply = function.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8121).xj(20068, 1).xj(Object.class).hf());
            Integer xj2 = com.bytedance.sdk.openadsdk.core.wo.xj.xj.xj(apply);
            if (xj2 != null) {
                return xj2;
            }
        }
        return 1;
    }

    private static Function<SparseArray<Object>, Object> hf(String str, int i) {
        Object apply;
        Function<SparseArray<Object>, Object> u = u(str);
        if (u == null) {
            return null;
        }
        try {
            apply = u.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(i).xj(AaHO0E.ARc23Z()).hf());
            return AaHO0E.AYUAbz(apply);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int w(com.bytedance.msdk.api.xj.hf hfVar) {
        if (hfVar == null) {
            return 4;
        }
        if (com.bytedance.msdk.c.xj.xj.xj().c()) {
            return hfVar.p() == 1 ? 1 : 2;
        }
        if (com.bytedance.msdk.c.xj.xj.xj().f() != 1) {
            return 3;
        }
        return hfVar.p();
    }

    public static com.bytedance.msdk.core.xj.xj.xj.xj hf(String str, int i, int i2) {
        if (!TextUtils.equals(str, "gdt")) {
            return null;
        }
        switch (i) {
            case 1:
                return new com.bytedance.msdk.core.xj.xj.hf.xj.xj.xj();
            case 2:
                return new com.bytedance.msdk.core.xj.xj.hf.xj.kd.xj();
            case 3:
                return new com.bytedance.msdk.core.xj.xj.hf.xj.c.xj();
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (i2 == 4) {
                    return new com.bytedance.msdk.core.xj.xj.hf.xj.w.xj();
                }
                if (i2 == 3) {
                    return new com.bytedance.msdk.core.xj.xj.hf.xj.xj.xj();
                }
                if (i2 == 5) {
                    return new com.bytedance.msdk.core.xj.xj.hf.xj.hf.xj();
                }
                return new com.bytedance.msdk.core.xj.xj.hf.xj.w.xj();
            case 7:
                return new com.bytedance.msdk.core.xj.xj.hf.xj.y.xj();
            case 8:
                return new com.bytedance.msdk.core.xj.xj.hf.xj.u.xj();
            case 9:
                return new com.bytedance.msdk.core.xj.xj.hf.xj.hf.xj();
            case 10:
                if (i2 == 1) {
                    return new com.bytedance.msdk.core.xj.xj.hf.xj.kd.xj();
                }
                if (i2 == 2) {
                    return new com.bytedance.msdk.core.xj.xj.hf.xj.u.xj();
                }
                return null;
        }
    }

    public static boolean xj(String str) {
        return (str == null || u(str) == null) ? false : true;
    }

    private static Function<SparseArray<Object>, Object> xj(y yVar) {
        if (yVar == null) {
            com.bytedance.msdk.xj.kd.w.hf(xj, "strategy is null");
            return null;
        }
        if (TextUtils.isEmpty(yVar.f())) {
            com.bytedance.msdk.xj.kd.w.hf(xj, "adn name is empty");
            return null;
        }
        String w = yVar.w();
        if (TextUtils.isEmpty(w)) {
            com.bytedance.msdk.xj.kd.w.hf(xj, "adn classname is empty");
            return null;
        }
        String u = yVar.u();
        if (TextUtils.isEmpty(u)) {
            com.bytedance.msdk.xj.kd.w.hf(xj, "adn versionListKey is empty");
            return null;
        }
        return xj(yVar, u, w);
    }

    public static void hf(com.bytedance.msdk.api.xj.hf hfVar) {
        if (hfVar != null) {
            hfVar.c(3);
        }
    }

    public static int hf() {
        return com.bytedance.msdk.c.xj.xj.xj().f();
    }

    private static Function<SparseArray<Object>, Object> xj(y yVar, String str, String str2) {
        JSONObject optJSONObject;
        try {
            JSONObject kd = p.kd("com.byted.mixed");
            if (kd != null) {
                if (!kd.has("adn_version") || (optJSONObject = kd.optJSONObject("adn_version")) == null || !optJSONObject.has(str)) {
                    return null;
                }
                JSONArray jSONArray = optJSONObject.getJSONArray(str);
                String kd2 = yVar.kd();
                if (TextUtils.isEmpty(kd2) || jSONArray.length() <= 0) {
                    return null;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (TextUtils.equals(jSONArray.getString(i), kd2)) {
                        if (!kd.has(str2)) {
                            return null;
                        }
                        String optString = kd.optString(str2);
                        if (TextUtils.isEmpty(optString)) {
                            return null;
                        }
                        Object newInstance = Class.forName(optString).newInstance();
                        if (!BpkvW3.BmvVmW(newInstance)) {
                            return null;
                        }
                        yVar.xj(AaHO0E.AYUAbz(newInstance));
                        return yVar.y();
                    }
                }
                yVar.xj(kd2);
                return null;
            }
            com.bytedance.msdk.xj.kd.w.hf(xj, "adn config json is null");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void xj(Map<String, Object> map) {
        if (map != null) {
            xj.xj(map);
        }
    }

    public static Function<SparseArray<Object>, Object> xj(String str, int i, int i2) {
        try {
            if (!xj.hf(str)) {
                return null;
            }
            switch (i) {
                case 1:
                    return hf(str, 20001);
                case 2:
                    return hf(str, 20004);
                case 3:
                    return hf(str, 20007);
                case 4:
                case 6:
                default:
                    return null;
                case 5:
                    if (i2 == 4) {
                        return hf(str, 20005);
                    }
                    if (i2 == 3) {
                        return hf(str, 20001);
                    }
                    if (i2 == 5) {
                        return hf(str, 20002);
                    }
                    return hf(str, 20005);
                case 7:
                    return hf(str, 20006);
                case 8:
                    return hf(str, 20003);
                case 9:
                    return hf(str, 20002);
                case 10:
                    if (i2 == 1) {
                        return hf(str, 20004);
                    }
                    if (i2 == 2) {
                        return hf(str, 20003);
                    }
                    return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String xj() {
        if (com.bytedance.msdk.c.xj.xj.xj().c()) {
            return "load_plugin_gdt_adapter_v2";
        }
        return "";
    }

    public static void xj(com.bytedance.msdk.api.xj.hf hfVar) {
        if (hfVar != null) {
            hfVar.c(1);
        }
    }
}
