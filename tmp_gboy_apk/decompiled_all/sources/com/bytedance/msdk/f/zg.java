package com.bytedance.msdk.f;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class zg {
    private static final Map<Integer, Map<String, List<List<String>>>> c = new HashMap();
    private static boolean hf = true;
    private static boolean kd = true;
    private static boolean u = true;
    private static boolean w = true;
    private static boolean xj = true;
    private static boolean y;

    static {
        eWiQlLf();
    }

    public static boolean c() {
        if (!u) {
            return false;
        }
        u = false;
        return true;
    }

    private static /* synthetic */ void eWiQlLf() {
        char[] charArray = "|pr1x~rz1}pf1lwzss1Uqv]mv{xz".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 31);
        }
        String str = new String(charArray);
        char[] charArray2 = "|svqvk".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 31);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean f() {
        if (!kd) {
            return false;
        }
        kd = false;
        return true;
    }

    public static boolean hf() {
        StackTraceElement[] stackTraceElementArr;
        Map<String, List<List<String>>> map;
        List<List<String>> list;
        try {
            stackTraceElementArr = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTraceElementArr = null;
        }
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0 || (map = c.get(7)) == null || (list = map.get(MediationConstant.ADN_PANGLE)) == null || list.size() <= 1) {
            return true;
        }
        return xj(stackTraceElementArr, list);
    }

    public static boolean kd() {
        if (!hf) {
            return false;
        }
        hf = false;
        return true;
    }

    public static boolean u() {
        if (!xj) {
            return false;
        }
        xj = false;
        return true;
    }

    public static boolean w() {
        StackTraceElement[] stackTraceElementArr;
        Map<String, List<List<String>>> map;
        List<List<String>> list;
        try {
            stackTraceElementArr = Thread.currentThread().getStackTrace();
        } catch (Throwable unused) {
            stackTraceElementArr = null;
        }
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0 || (map = c.get(8)) == null || (list = map.get(MediationConstant.ADN_PANGLE)) == null || list.size() <= 1) {
            return true;
        }
        return xj(stackTraceElementArr, list);
    }

    public static boolean xj() {
        return y;
    }

    public static boolean y() {
        if (!w) {
            return false;
        }
        w = false;
        return true;
    }

    public static void xj(boolean z) {
        y = z;
    }

    public static void xj(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                                Integer valueOf = Integer.valueOf(jSONObject2.optInt("rit_type"));
                                JSONArray optJSONArray2 = jSONObject2.optJSONArray("adn_features");
                                if (optJSONArray2 != null) {
                                    ArrayList arrayList = new ArrayList();
                                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                        JSONArray jSONArray = optJSONArray2.getJSONArray(i2);
                                        if (jSONArray != null) {
                                            ArrayList arrayList2 = new ArrayList();
                                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                                String string = jSONArray.getString(i3);
                                                if (!TextUtils.isEmpty(string)) {
                                                    arrayList2.add(string);
                                                }
                                            }
                                            arrayList.add(arrayList2);
                                        }
                                    }
                                    if (arrayList.size() > 0) {
                                        HashMap hashMap = new HashMap();
                                        hashMap.put(next, arrayList);
                                        c.put(valueOf, hashMap);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                com.bytedance.msdk.xj.kd.w.xj("TMe", "supervisorFeature error: " + e.toString());
                com.bytedance.sdk.component.utils.pl.xj(e);
                return;
            }
        }
        com.bytedance.msdk.xj.kd.w.xj("TMe", "--==-- adn features:" + c);
    }

    private static boolean xj(Object obj, List<List<String>> list) {
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
        for (List<String> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                for (int i = 0; i < stackTraceElementArr.length; i++) {
                    StackTraceElement stackTraceElement = stackTraceElementArr[i];
                    if (stackTraceElement != null) {
                        String stackTraceElement2 = stackTraceElement.toString();
                        if (!TextUtils.isEmpty(stackTraceElement2) && stackTraceElement2.contains(list2.get(0)) && (list2.size() == 1 || xj(stackTraceElementArr, i, list2))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean xj(Object obj, int i, List<String> list) {
        int i2;
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str = list.get(i3);
            if (TextUtils.isEmpty(str) || (i2 = i + i3) >= stackTraceElementArr.length) {
                return false;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i2];
            if (stackTraceElement != null) {
                String stackTraceElement2 = stackTraceElement.toString();
                if (TextUtils.isEmpty(stackTraceElement2) || !stackTraceElement2.contains(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
