package com.bytedance.msdk.w.f;

import android.text.TextUtils;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.sdk.component.utils.pl;
import com.kwad.components.core.s.t;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private static final Map<String, xj> xj = new ConcurrentHashMap();

    public static class xj {
        public int hf;
        public int kd;
        public Set<String> u;
        public Set<String> w;
        public String xj;
    }

    static {
        wsEwCgn();
    }

    private static String hf(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str.getClass();
        switch (str) {
            case "pangle":
                return "376434";
            case "sigmob":
                return "476747";
            case "ks":
                return "575683";
            case "gdt":
                return "384735";
            case "admob":
                return "547957";
            case "baidu":
                return "476385";
            case "unity":
                return "846469";
            case "mintegral":
                return "765380";
            default:
                return str;
        }
    }

    private static /* synthetic */ void wsEwCgn() {
        char[] charArray = "ØÔÖ\u0095ÜÚÖÞ\u0095ÙÔÂ\u0095ÈÓÞ××\u0095ñÕÒùÉÒßÜÞ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 187);
        }
        String str = new String(charArray);
        char[] charArray2 = "Ø×ÒÕÒÏ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 187);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(JSONArray jSONArray) {
        int optInt;
        if (jSONArray == null || jSONArray.length() <= 0) {
            xj.clear();
            return;
        }
        xj.clear();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString(f.f13353a);
                if (!TextUtils.isEmpty(optString)) {
                    xj xjVar = new xj();
                    int optInt2 = optJSONObject.optInt(t.TAG);
                    xjVar.xj = optString;
                    xjVar.hf = optInt2;
                    if (optInt2 == 1) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray(com.kuaishou.weapon.p0.t.f);
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            xjVar.u = new HashSet();
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                xjVar.u.add(optJSONArray.optString(i2));
                            }
                            xj.put(optString, xjVar);
                        }
                    } else if (optInt2 == 2) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray(com.kuaishou.weapon.p0.t.k);
                        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                            xjVar.w = new HashSet();
                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                xjVar.w.add(optJSONArray2.optString(i3));
                            }
                            xj.put(optString, xjVar);
                        }
                    } else if ((optInt2 == 3 || optInt2 == 4) && (optInt = optJSONObject.optInt("c", -1)) != -1) {
                        xjVar.kd = optInt;
                        xj.put(optString, xjVar);
                    }
                }
            }
        }
    }

    public static xj xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return xj.get(str);
    }

    private static boolean xj(xj xjVar, double d, String str, String str2) {
        if (!xj.isEmpty() && xjVar != null) {
            int i = xjVar.hf;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4 && d > 0.0d && d <= xjVar.kd) {
                            return true;
                        }
                    } else if (d > 0.0d && d >= xjVar.kd) {
                        return true;
                    }
                } else if (xjVar.w.contains(str2)) {
                    return true;
                }
            } else if (xjVar.u.contains(hf(str))) {
                return true;
            }
        }
        return false;
    }

    public static xj xj(com.bytedance.msdk.api.xj.hf hfVar, tf tfVar) {
        if (xj.isEmpty()) {
            return null;
        }
        Map<String, Object> r = hfVar.r();
        Object obj = r.get("on_shield");
        Object obj2 = r.get("id_list");
        if ((obj instanceof Integer) && (obj2 instanceof List) && tfVar != null && ((Integer) obj).intValue() == 1) {
            ArrayList arrayList = new ArrayList();
            try {
                Iterator it = ((List) obj2).iterator();
                boolean z = false;
                boolean z2 = false;
                while (it.hasNext()) {
                    xj xj2 = xj((String) it.next());
                    if (xj2 != null) {
                        int i = xj2.hf;
                        if (i == 3) {
                            if (!z) {
                                arrayList.add(xj2);
                                z = true;
                            }
                        } else if (i != 4) {
                            arrayList.add(xj2);
                        } else if (!z2) {
                            arrayList.add(xj2);
                            z2 = true;
                        }
                    }
                }
                Collections.sort(arrayList, new Comparator<xj>() { // from class: com.bytedance.msdk.w.f.kd.1
                    @Override // java.util.Comparator
                    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
                    public int compare(xj xjVar, xj xjVar2) {
                        return xjVar.hf - xjVar2.hf;
                    }
                });
            } catch (Throwable th) {
                pl.xj(th);
            }
            if (!arrayList.isEmpty()) {
                xj(arrayList);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    xj xjVar = (xj) it2.next();
                    if (xj(xjVar, tfVar.ra(), tfVar.e(), tfVar.yo())) {
                        return xjVar;
                    }
                }
            }
        }
        return null;
    }

    private static void xj(List<xj> list) {
        if (list.size() >= 2) {
            int size = list.size();
            int i = size - 1;
            if (list.get(i).hf != 4) {
                return;
            }
            int i2 = size - 2;
            if (list.get(i2).hf == 3 && list.get(i2).kd <= list.get(i).kd) {
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
