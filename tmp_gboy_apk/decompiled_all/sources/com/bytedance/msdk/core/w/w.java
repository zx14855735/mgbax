package com.bytedance.msdk.core.w;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.bytedance.msdk.core.tf.tf;
import com.kuaishou.weapon.p0.bi;
import com.ss.android.download.api.constant.BaseConstants;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static boolean hf(int i) {
        return i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 8 || i == 9;
    }

    public static void w(String str, String str2, String str3) {
        if (com.bytedance.msdk.core.hf.hf().ws() != null) {
            com.bytedance.msdk.f.xj.w.xj().insert(str, str2, str3, "fill");
        }
    }

    private static boolean xj(int i) {
        return i == 0 || i == 1 || i == 2;
    }

    public static void hf(String str, String str2, String str3) {
        if (com.bytedance.msdk.core.hf.hf().ws() != null) {
            com.bytedance.msdk.f.xj.w.xj().insert(str, str2, str3, "send");
        }
    }

    public static void xj(String str, String str2, String str3) {
        if (com.bytedance.msdk.core.hf.hf().ws() != null) {
            com.bytedance.msdk.f.xj.w.xj().insert(str, str2, str3, "show");
        }
    }

    public static void xj(String str, int i) {
        if (com.bytedance.msdk.core.hf.hf().ws() == null || TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - (i * BaseConstants.Time.HOUR);
        StringBuilder B3GDIM2 = CtFAbx.B3GDIM("---预缓存优化删除存储的过期数据 primeRit = ", str, " startTime = ");
        B3GDIM2.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(currentTimeMillis)));
        com.bytedance.msdk.xj.kd.w.hf("TMe", B3GDIM2.toString());
        com.bytedance.msdk.f.xj.w.xj().xj(str, currentTimeMillis);
    }

    public static com.bytedance.msdk.core.tf.hf xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.core.tf.hf hfVar2) {
        hf hfVar3;
        com.bytedance.msdk.core.tf.hf hfVar4;
        com.bytedance.msdk.core.tf.hf hfVar5;
        List<tf> list;
        hf hfVar6;
        com.bytedance.msdk.core.tf.hf hfVar7 = hfVar2;
        hf ws = com.bytedance.msdk.core.hf.hf().ws();
        com.bytedance.msdk.xj.kd.w.hf("TMe", "----预缓存优化判断是否可以发起预缓存开始");
        HashMap hashMap = null;
        if (hfVar == null) {
            return null;
        }
        com.bytedance.msdk.xj.kd.w.hf("TMe", "待检测的 behaviorState = " + hfVar.d());
        int xj = xj(hfVar7, ws, hfVar.d());
        HashSet hashSet = new HashSet();
        if (xj == 200) {
            List<tf> yy = hfVar7.yy();
            HashSet hashSet2 = new HashSet();
            for (tf tfVar : yy) {
                com.bytedance.msdk.xj.kd.w.hf("TMe", "adnName = " + tfVar.e() + " adnrit = " + tfVar.yo());
                hashSet2.add(tfVar.e());
            }
            LinkedList<tf> linkedList = new LinkedList();
            HashMap hashMap2 = new HashMap();
            for (tf tfVar2 : yy) {
                if (tfVar2 != null) {
                    xj xjVar = (xj) hashMap2.get(tfVar2.e());
                    if (xjVar == null) {
                        String e = tfVar2.e();
                        String ff = hfVar7.ff();
                        int wn = hfVar7.wn();
                        double xj2 = ws.xj(e, ff);
                        double hf = ws.hf(e, ff);
                        list = yy;
                        if (xj2 == 0.0d && hf == 0.0d) {
                            com.bytedance.msdk.xj.kd.w.hf("TMe", "没有配置规则，直接添加到adn list中 adnName = " + tfVar2.e() + " adnRit " + tfVar2.yo());
                            linkedList.add(tfVar2);
                            yy = list;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            hfVar6 = ws;
                            List<com.bytedance.msdk.f.xj.hf> query = com.bytedance.msdk.f.xj.w.xj().query(e, ff, currentTimeMillis - (wn * BaseConstants.Time.HOUR), currentTimeMillis);
                            if (query != null && query.size() != 0) {
                                int i = 0;
                                int i2 = 0;
                                int i3 = 0;
                                for (com.bytedance.msdk.f.xj.hf hfVar8 : query) {
                                    if (TextUtils.equals(hfVar8.xj(), "send")) {
                                        i3++;
                                    } else if (TextUtils.equals(hfVar8.xj(), "fill")) {
                                        i++;
                                    } else if (TextUtils.equals(hfVar8.xj(), "show")) {
                                        i2++;
                                    }
                                }
                                xj xjVar2 = new xj(i != 0 ? i2 / i : 0.0d, i3 != 0 ? i / i3 : 0.0d, xj2, hf, hfVar6.xj(), hfVar6.y());
                                xjVar2.hf(i);
                                xjVar2.xj(i3);
                                xjVar2.w(i2);
                                hashMap2.put(tfVar2.e(), xjVar2);
                                xjVar = xjVar2;
                            } else {
                                com.bytedance.msdk.xj.kd.w.hf("TMe", "数据库里没有查询到数据，直接添加到adn list中 adnName = " + tfVar2.e() + " adnRit " + tfVar2.yo());
                                linkedList.add(tfVar2);
                            }
                        }
                    } else {
                        list = yy;
                        hfVar6 = ws;
                    }
                    if (xjVar != null) {
                        xjVar.xj(tfVar2.e());
                        xjVar.hf(tfVar2.yo());
                        com.bytedance.msdk.xj.kd.w.hf("TMe", "compareData ".concat(String.valueOf(xjVar)));
                    }
                    if (xjVar != null && xjVar.xj()) {
                        linkedList.add(tfVar2);
                    }
                } else {
                    list = yy;
                    hfVar6 = ws;
                }
                hfVar7 = hfVar2;
                yy = list;
                ws = hfVar6;
            }
            List<tf> list2 = yy;
            hfVar3 = ws;
            com.bytedance.msdk.xj.kd.w.hf("TMe", "筛选掉代码位 后留下的代码位 ------- ");
            HashSet hashSet3 = new HashSet();
            for (tf tfVar3 : linkedList) {
                com.bytedance.msdk.xj.kd.w.hf("TMe", "adnName = " + tfVar3.e() + " adnrit = " + tfVar3.yo());
                hashSet3.add(tfVar3.e());
            }
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!hashSet3.contains(str)) {
                    hashSet.add(str);
                }
            }
            xj = list2.size() == linkedList.size() ? 11 : 10;
            com.bytedance.msdk.core.tf.hf clone = hfVar2.clone();
            clone.xj(linkedList);
            if (clone.pl()) {
                clone.hf(linkedList);
            } else {
                clone.xj(linkedList);
            }
            hfVar4 = clone;
            hashMap = hashMap2;
        } else {
            hfVar3 = ws;
            hfVar4 = null;
        }
        int i4 = xj;
        if (hfVar4 == null) {
            xj(hfVar, hfVar2, hfVar3, i4, hashSet, hashMap);
            hfVar5 = hfVar4;
        } else {
            hfVar5 = hfVar4;
            xj(hfVar, hfVar5, hfVar3, i4, hashSet, hashMap);
        }
        if (hfVar2 != null) {
            xj(hfVar.ra(), hfVar2.wn());
        }
        return hfVar5;
    }

    private static int xj(com.bytedance.msdk.core.tf.hf hfVar, hf hfVar2, int i) {
        if (!com.bytedance.msdk.core.hf.hf().r()) {
            return 0;
        }
        if (hfVar2 == null || hfVar2.kd() == null) {
            return 1;
        }
        if (!hfVar2.xj(i)) {
            return 2;
        }
        if (hfVar2.hf() == 0) {
            return 3;
        }
        if (hfVar2.xj() == 0) {
            return 4;
        }
        if (!hfVar2.c()) {
            return 5;
        }
        if (hfVar == null || !hfVar2.xj(hfVar.ff())) {
            return 6;
        }
        if (hfVar.wn() == 0) {
            return 7;
        }
        if (xj(hfVar, hfVar2)) {
            return xj(hfVar) ? 9 : 200;
        }
        return 8;
    }

    private static boolean xj(com.bytedance.msdk.core.tf.hf hfVar, hf hfVar2) {
        if (hfVar == null || hfVar.yy() == null || hfVar2 == null) {
            return false;
        }
        for (tf tfVar : hfVar.yy()) {
            double xj = hfVar2.xj(tfVar.e(), hfVar.ff());
            double hf = hfVar2.hf(tfVar.e(), hfVar.ff());
            if (xj != 0.0d || hf != 0.0d) {
                return true;
            }
        }
        return false;
    }

    private static boolean xj(com.bytedance.msdk.core.tf.hf hfVar) {
        if (hfVar == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<com.bytedance.msdk.f.xj.hf> query = com.bytedance.msdk.f.xj.w.xj().query("", hfVar.ff(), currentTimeMillis - (hfVar.wn() * bi.s), currentTimeMillis);
        return query == null || query.isEmpty();
    }

    private static void xj(com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.core.tf.hf hfVar2, hf hfVar3, int i, Set<String> set, Map<String, xj> map) {
        if (hfVar.tf() != null) {
            com.bytedance.msdk.xj.kd.w.hf("TMe", "预缓存优化存在埋点数据 无需重新存储");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i);
            if (xj(i)) {
                hfVar.xj(jSONObject);
                return;
            }
            jSONObject.put("perform", xj(i, hfVar3, map));
            if (hf(i)) {
                hfVar.xj(jSONObject);
                return;
            }
            jSONObject.put("behavior_state", xj(hfVar3));
            jSONObject.put("condition", hfVar3.hf());
            if (hfVar2 != null) {
                try {
                    jSONObject.put("behavior_ttl", hfVar2.wn());
                } catch (JSONException unused) {
                }
            }
            if (set != null && set.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("filtered_adn", jSONArray);
            }
            hfVar.xj(jSONObject);
        } catch (JSONException unused2) {
        }
    }

    private static JSONArray xj(hf hfVar) {
        List<Integer> list;
        JSONArray jSONArray = new JSONArray();
        if (hfVar != null && (list = hfVar.xj) != null) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
        }
        return jSONArray;
    }

    private static JSONObject xj(int i, hf hfVar, Map<String, xj> map) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("rule_id", hfVar.w());
        jSONObject.put("rule_timestamp", hfVar.u());
        if (!hf(i)) {
            jSONObject.put("condition", hfVar.xj());
            jSONObject.put("rule_inuse", (i == 10 || i == 11) ? 1 : 0);
            if (map != null) {
                try {
                    DecimalFormat decimalFormat = new DecimalFormat("#0.000");
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    for (Map.Entry<String, xj> entry : map.entrySet()) {
                        xj value = entry.getValue();
                        if (value != null) {
                            jSONObject3.put(entry.getKey(), decimalFormat.format(value.hf()));
                            jSONObject4.put(entry.getKey(), decimalFormat.format(value.w()));
                        }
                    }
                    jSONObject2.put("ssr", jSONObject3);
                    jSONObject2.put("srr", jSONObject4);
                    jSONObject.put("res", jSONObject2);
                } catch (JSONException unused) {
                }
            }
        }
        return jSONObject;
    }
}
