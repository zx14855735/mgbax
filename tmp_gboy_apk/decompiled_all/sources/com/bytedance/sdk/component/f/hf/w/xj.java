package com.bytedance.sdk.component.f.hf.w;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.br;
import com.bytedance.sdk.component.f.xj.kd;
import com.bytedance.sdk.component.f.xj.u;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.download.api.constant.BaseConstants;
import io.dcloud.openapi.core.util.Const;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static final LinkedList<String> xj = new LinkedList<>();
    private static final LinkedList<String> hf = new LinkedList<>();
    private static final LinkedList<String> w = new LinkedList<>();
    private static final LinkedList<String> u = new LinkedList<>();
    private static final Map<String, Integer> kd = new HashMap();
    private static String y = "upload_init";
    private static int c = 0;
    private static int f = 0;
    private static AtomicLong d = new AtomicLong();

    static {
        EYJnN();
    }

    private static /* synthetic */ void EYJnN() {
        char[] charArray = "\u0088\u0084\u0086Å\u008c\u008a\u0086\u008eÅ\u0089\u0084\u0092Å\u0098\u0083\u008e\u0087\u0087Å¡\u0085\u0082©\u0099\u0082\u008f\u008c\u008e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 235);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0088\u0087\u0082\u0085\u0082\u009f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 235);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void c(com.bytedance.sdk.component.f.xj.hf hfVar, kd kdVar) {
        try {
            if (hfVar.u() == 0 && kdVar.u() != null && kdVar.u().am()) {
                JSONObject c2 = hfVar.c();
                String xj2 = xj(hfVar, kdVar);
                if (w(xj2)) {
                    return;
                }
                String optString = c2.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("will_send_labels", kd(xj2));
                    jSONObject.put("send_success_valid_labels", hf());
                    c2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(optString);
                if (TextUtils.isEmpty(jSONObject2.optString("will_send_labels"))) {
                    jSONObject2.put("will_send_labels", kd(xj2));
                    jSONObject2.put("send_success_valid_labels", hf());
                }
                c2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public static boolean d(com.bytedance.sdk.component.f.xj.hf hfVar, kd kdVar) {
        return hfVar != null && hfVar.u() == 0 && xj(kdVar);
    }

    public static void f(com.bytedance.sdk.component.f.xj.hf hfVar, kd kdVar) {
        if (kdVar == null || kdVar.u() == null || !kdVar.u().w()) {
            return;
        }
        try {
            com.bytedance.sdk.component.f.hf.hf.hf.xj.xj(System.currentTimeMillis() - hfVar.f());
            hfVar.hf(System.currentTimeMillis());
            if (hfVar.u() == 0 && kdVar.u() != null && kdVar.u().am()) {
                String xj2 = xj(hfVar, kdVar);
                if (w(xj2)) {
                    return;
                }
                JSONObject c2 = hfVar.c();
                String optString = hfVar.c().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("save_success_labels", u(xj2));
                    c2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                } else {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    if (TextUtils.isEmpty(jSONObject2.optString("save_success_labels"))) {
                        jSONObject2.put("save_success_labels", u(xj2));
                    }
                    c2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized String hf(String str) {
        String sb;
        synchronized (xj.class) {
            try {
                LinkedList<String> linkedList = xj;
                if (linkedList.size() >= 10) {
                    linkedList.removeFirst();
                    linkedList.add(str);
                } else {
                    linkedList.add(str);
                }
                StringBuilder sb2 = new StringBuilder();
                Iterator<String> it = linkedList.iterator();
                while (it.hasNext()) {
                    sb2.append(it.next());
                    sb2.append(",");
                }
                sb = sb2.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb;
    }

    private static synchronized String kd(String str) {
        String sb;
        synchronized (xj.class) {
            try {
                LinkedList<String> linkedList = w;
                if (linkedList.size() >= 10) {
                    linkedList.removeFirst();
                    linkedList.add(str);
                } else {
                    linkedList.add(str);
                }
                StringBuilder sb2 = new StringBuilder();
                Iterator<String> it = linkedList.iterator();
                while (it.hasNext()) {
                    sb2.append(it.next());
                    sb2.append(",");
                }
                sb = sb2.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb;
    }

    private static synchronized String u(String str) {
        String sb;
        synchronized (xj.class) {
            try {
                LinkedList<String> linkedList = hf;
                if (linkedList.size() >= 10) {
                    linkedList.removeFirst();
                    linkedList.add(str);
                } else {
                    linkedList.add(str);
                }
                StringBuilder sb2 = new StringBuilder();
                Iterator<String> it = linkedList.iterator();
                while (it.hasNext()) {
                    sb2.append(it.next());
                    sb2.append(",");
                }
                sb = sb2.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb;
    }

    public static boolean w(String str) {
        return false;
    }

    public static boolean xj(int i) {
        return i == 72 || i == 71;
    }

    private static synchronized void y(String str) {
        synchronized (xj.class) {
            LinkedList<String> linkedList = u;
            if (linkedList.size() < 10) {
                linkedList.add(str);
            } else {
                linkedList.removeFirst();
                linkedList.add(str);
            }
        }
    }

    public static String w(com.bytedance.sdk.component.f.xj.hf hfVar, kd kdVar) {
        if (kdVar == null || kdVar.u() == null || !kdVar.u().xj()) {
            return "";
        }
        String xj2 = xj(hfVar, kdVar);
        if (!TextUtils.isEmpty(xj2)) {
            return CtFAbx.BChYOn("label:", xj2);
        }
        if (TextUtils.isEmpty(hf(hfVar, kdVar))) {
            return null;
        }
        return "type:" + hf(hfVar, kdVar);
    }

    public static synchronized int xj(String str) {
        synchronized (xj.class) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            Map<String, Integer> map = kd;
            Integer num = map.get(str);
            if (num == null) {
                map.put(str, 1);
                return 1;
            }
            int intValue = num.intValue() + 1;
            map.put(str, Integer.valueOf(intValue));
            return intValue;
        }
    }

    public static String y(com.bytedance.sdk.component.f.xj.hf hfVar, kd kdVar) {
        if (hfVar != null && hfVar.c() != null && !hf(kdVar) && !u(kdVar)) {
            String optString = hfVar.c().optString("log_extra");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    return new JSONObject(optString).optString("req_id");
                } catch (JSONException e) {
                    pl.xj(e);
                }
            }
        }
        return null;
    }

    private static synchronized String hf() {
        String sb;
        synchronized (xj.class) {
            try {
                StringBuilder sb2 = new StringBuilder();
                Iterator<String> it = u.iterator();
                while (it.hasNext()) {
                    sb2.append(it.next());
                    sb2.append(",");
                }
                sb = sb2.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb;
    }

    public static synchronized int kd(com.bytedance.sdk.component.f.xj.hf hfVar, kd kdVar) {
        synchronized (xj.class) {
            if (hfVar != null) {
                if (hfVar.c() != null) {
                    try {
                        return new JSONObject(hfVar.c().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA)).optInt("sdk_event_self_count");
                    } catch (Exception e) {
                        pl.xj(e);
                        return 0;
                    }
                }
            }
            return 0;
        }
    }

    public static int u(com.bytedance.sdk.component.f.xj.hf hfVar, kd kdVar) {
        if (hfVar != null && hfVar.c() != null && hfVar.u() == 1) {
            try {
                return new JSONObject(hfVar.c().optString("event_extra")).optInt("stats_index");
            } catch (JSONException e) {
                pl.xj(e);
            }
        }
        return -1;
    }

    public static String xj(com.bytedance.sdk.component.f.xj.hf hfVar, kd kdVar) {
        if (hfVar == null || hfVar.c() == null || hf(kdVar) || u(kdVar)) {
            return null;
        }
        if (hfVar.hf() == 3) {
            return hfVar.c().optString("event");
        }
        return hfVar.c().optString("label");
    }

    public static String hf(com.bytedance.sdk.component.f.xj.hf hfVar, kd kdVar) {
        if (hfVar == null || hfVar.c() == null || hf(kdVar) || u(kdVar)) {
            return null;
        }
        return hfVar.c().optString(PointParamKey.TYPE);
    }

    public static boolean y(com.bytedance.sdk.component.f.xj.hf hfVar) {
        return hfVar != null && hfVar.u() == 2 && hfVar.kd() == 3;
    }

    public static boolean u(kd kdVar) {
        return kdVar != null && TextUtils.equals(kdVar.kd(), "pgl_mediation");
    }

    public static boolean u(com.bytedance.sdk.component.f.xj.hf hfVar) {
        return hfVar != null && hfVar.u() == 1 && hfVar.kd() == 2;
    }

    public static boolean w(kd kdVar) {
        return kdVar != null && TextUtils.equals(kdVar.kd(), MediationConstant.ADN_PANGLE);
    }

    public static void xj(List<com.bytedance.sdk.component.f.xj.hf> list, String str, com.bytedance.sdk.component.f.hf.xj.hf hfVar) {
        JSONObject c2;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    com.bytedance.sdk.component.f.xj.hf hfVar2 = list.get(0);
                    if (hfVar2 == null || hfVar2.u() == 0) {
                        long incrementAndGet = d.incrementAndGet();
                        for (com.bytedance.sdk.component.f.xj.hf hfVar3 : list) {
                            if (hfVar3 != null && (c2 = hfVar3.c()) != null) {
                                String optString = c2.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                                if (!TextUtils.isEmpty(optString)) {
                                    JSONObject jSONObject = new JSONObject(optString);
                                    jSONObject.put("upload_count", incrementAndGet);
                                    jSONObject.put("upload_ts", System.currentTimeMillis());
                                    if (hfVar != null) {
                                        String hf2 = hfVar.hf();
                                        boolean xj2 = hfVar.xj();
                                        if (!TextUtils.isEmpty(hf2)) {
                                            jSONObject.put("delete_msg", hf2 + " success:" + xj2);
                                        }
                                    }
                                    c2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
    }

    public static boolean hf(kd kdVar) {
        return kdVar != null && TextUtils.equals(kdVar.kd(), "csj_mediation");
    }

    public static boolean w(com.bytedance.sdk.component.f.xj.hf hfVar) {
        return hfVar != null && hfVar.u() == 0 && hfVar.kd() == 2;
    }

    public static boolean hf(List<com.bytedance.sdk.component.f.xj.hf> list, kd kdVar) {
        com.bytedance.sdk.component.f.xj.hf hfVar;
        return (list == null || list.size() == 0 || (hfVar = list.get(0)) == null || hfVar.u() != 0 || !xj(kdVar)) ? false : true;
    }

    public static boolean kd(kd kdVar) {
        return xj(kdVar) || w(kdVar);
    }

    public static int w(List<com.bytedance.sdk.component.f.xj.hf> list, kd kdVar) {
        JSONObject c2;
        String optString;
        if (list != null && list.size() == 1) {
            try {
                com.bytedance.sdk.component.f.xj.hf hfVar = list.get(0);
                if (hfVar != null && hfVar.kd() == 1 && (c2 = hfVar.c()) != null && hfVar.u() == 0) {
                    JSONObject optJSONObject = c2.optJSONObject("params");
                    if (optJSONObject == null) {
                        optString = c2.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                    } else {
                        optString = optJSONObject.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                    }
                    JSONObject jSONObject = new JSONObject(optString);
                    int optInt = jSONObject.optInt("inner_appid", 0);
                    if (optInt != 0) {
                        jSONObject.remove("inner_appid");
                        if (optJSONObject == null) {
                            c2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                            return optInt;
                        }
                        optJSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                        c2.put("params", optJSONObject);
                        return optInt;
                    }
                }
            } catch (Throwable th) {
                pl.xj(th);
            }
        }
        return 0;
    }

    public static boolean kd(com.bytedance.sdk.component.f.xj.hf hfVar) {
        return hfVar != null && hfVar.u() == 1 && hfVar.kd() == 3;
    }

    public static boolean hf(com.bytedance.sdk.component.f.xj.hf hfVar) {
        return hfVar != null && hfVar.u() == 3 && hfVar.kd() == 2;
    }

    public static String hf(int i) {
        switch (i) {
            case 71:
                return "flush once";
            case 72:
                return "flush memory db";
            case 73:
                return "flush memory";
            case 74:
                return "new event";
            case 75:
            default:
                return "default";
            case 76:
                return "empty message";
            case 77:
                return "net error";
        }
    }

    public static String xj(JSONObject jSONObject, kd kdVar) {
        if (jSONObject != null && !hf(kdVar) && !u(kdVar)) {
            String optString = jSONObject.optString("log_extra");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    return new JSONObject(optString).optString("rit");
                } catch (JSONException e) {
                    pl.xj(e);
                }
            }
        }
        return "";
    }

    public static void xj(List<com.bytedance.sdk.component.f.xj.hf> list, kd kdVar) {
        try {
            if (kdVar.u().w()) {
                for (com.bytedance.sdk.component.f.xj.hf hfVar : list) {
                    if (hfVar != null && hfVar.d() != 0) {
                        long currentTimeMillis = System.currentTimeMillis() - hfVar.d();
                        com.bytedance.sdk.component.f.hf.hf.xj.xj xjVar = com.bytedance.sdk.component.f.hf.hf.hf.xj;
                        xjVar.f().incrementAndGet();
                        xjVar.g().getAndAdd(currentTimeMillis);
                        hfVar.w(System.currentTimeMillis());
                    }
                    if (hfVar != null) {
                        c(hfVar, kdVar);
                    }
                }
                com.bytedance.sdk.component.f.hf.hf.hf.xj.tf().getAndAdd(list.size());
            }
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public static boolean xj(kd kdVar) {
        return kdVar != null && TextUtils.equals(kdVar.kd(), Const.TYPE_CSJ);
    }

    public static void xj(JSONObject jSONObject, com.bytedance.sdk.component.f.hf.u.xj.xj xjVar, kd kdVar, int i) {
        u u2;
        if (kdVar != null && (u2 = kdVar.u()) != null && u2.xj() && kd(kdVar)) {
            jSONObject.optString("label");
        }
    }

    public static void xj(List<com.bytedance.sdk.component.f.xj.hf> list, int i, String str, kd kdVar) {
        u u2;
        if (kdVar == null || (u2 = kdVar.u()) == null || !u2.xj() || list == null || hf(kdVar) || u(kdVar)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (com.bytedance.sdk.component.f.xj.hf hfVar : list) {
            if (hfVar.u() == 0) {
                JSONObject c2 = hfVar.c();
                String xj2 = xj(hfVar, kdVar);
                if (hfVar.hf() == 3) {
                    if (c2 != null) {
                        xj2 = c2.optString("event");
                    }
                    sb.append(" [v3:");
                    sb.append(xj2);
                    sb.append("] ");
                } else {
                    long xj3 = xj(kdVar, hfVar);
                    int kd2 = kd(hfVar, kdVar);
                    sb.append(" [");
                    sb.append(xj3);
                    sb.append("_");
                    sb.append(xj2);
                    if (kd2 == 0) {
                        sb.append("] ");
                    } else {
                        sb.append("_");
                        sb.append(kd2);
                        sb.append("] ");
                    }
                }
                z = true;
            } else if (hfVar.u() == 1) {
                String hf2 = hf(hfVar, kdVar);
                int u3 = u(hfVar, kdVar);
                sb.append(" [");
                sb.append(u3);
                sb.append("_");
                sb.append(hf2);
                sb.append("] ");
            }
        }
        if (z) {
            w.hf("_upload", "ads:" + ((Object) sb) + hf(i) + "," + str + ",total:" + list.size(), kdVar);
            return;
        }
        w.hf("_upload", "stats:" + ((Object) sb) + hf(i) + "," + str + ",total:" + list.size(), kdVar);
    }

    public static boolean xj(com.bytedance.sdk.component.f.xj.hf hfVar) {
        return hfVar != null && hfVar.u() == 0 && hfVar.kd() == 1;
    }

    private static void xj(com.bytedance.sdk.component.f.xj.hf hfVar, String str, u uVar, kd kdVar) {
        String xj2 = xj(hfVar, kdVar);
        if (w(xj2)) {
            return;
        }
        String y2 = y(hfVar, kdVar);
        if (hfVar.u() == 0 && uVar.am()) {
            y(xj2 + "_" + y2 + "_" + str);
        }
    }

    public static long xj(kd kdVar, com.bytedance.sdk.component.f.xj.hf hfVar) {
        if (hfVar != null && hfVar.c() != null) {
            try {
                return new JSONObject(hfVar.c().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA)).optLong("sdk_event_index");
            } catch (Exception e) {
                w.w(e.getMessage(), kdVar);
            }
        }
        return 0L;
    }

    public static void xj(boolean z, int i, String str, String str2, int i2, String str3) {
        c++;
        if (z) {
            f++;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("suc", z);
            jSONObject.put("scnt", f);
            jSONObject.put("acnt", c);
            jSONObject.put(PluginConstants.KEY_ERROR_CODE, i);
            jSONObject.put("reqid", str2);
            jSONObject.put("len:", i2);
            jSONObject.put("rit", str3);
            jSONObject.put(br.c, str);
            u kd2 = com.bytedance.sdk.component.f.hf.xj.w(Const.TYPE_CSJ).kd();
            if (kd2 != null) {
                jSONObject.put("url", kd2.pl().y());
            } else {
                jSONObject.put("url", "emptyurl");
            }
            y = jSONObject.toString();
        } catch (Exception unused) {
            y = "unknown_json";
        }
    }

    public static String xj() {
        return y;
    }

    public static void xj(com.bytedance.sdk.component.f.xj.hf hfVar, kd kdVar, String str) {
        u kd2;
        if (hf(kdVar) || kdVar == null || u(kdVar) || (kd2 = com.bytedance.sdk.component.f.hf.xj.w(kdVar.kd()).kd()) == null || !kd2.xj()) {
            return;
        }
        if (!TextUtils.isEmpty(hf(hfVar, kdVar))) {
            u(hfVar, kdVar);
        }
        if (TextUtils.isEmpty(xj(hfVar, kdVar))) {
            return;
        }
        xj(kdVar, hfVar);
    }

    public static void xj(List<com.bytedance.sdk.component.f.xj.hf> list, kd kdVar, String str) {
        if (kdVar == null) {
            return;
        }
        try {
            u u2 = kdVar.u();
            if (u2 == null || !u2.xj()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (com.bytedance.sdk.component.f.xj.hf hfVar : list) {
                if (hfVar.u() == 1) {
                    sb.append(hf(hfVar, kdVar));
                    sb.append("_");
                    sb.append(u(hfVar, kdVar));
                    sb.append("; ");
                } else if (hfVar.u() == 0) {
                    if (hfVar.hf() == 3) {
                        if (hfVar.c() != null) {
                            sb.append(hfVar.c().optString("event"));
                            long xj2 = xj(kdVar, hfVar);
                            if (xj2 != 0) {
                                sb.append("_");
                                sb.append(xj2);
                            }
                            sb.append("; ");
                        } else {
                            w.hf("_delete", "v3_error", kdVar);
                        }
                    } else {
                        sb.append(xj(hfVar, kdVar));
                        long xj3 = xj(kdVar, hfVar);
                        if (xj3 != 0) {
                            sb.append("_");
                            sb.append(xj3);
                        }
                        sb.append("; ");
                    }
                }
            }
            sb.append("]");
            sb.append(" total:" + list.size());
            sb.append(" table:" + str);
            w.hf("_remove", sb.toString(), kdVar);
        } catch (Exception e) {
            w.w("_delete error", e.getMessage(), kdVar);
        }
    }

    public static void xj(int i, List<com.bytedance.sdk.component.f.xj.hf> list, long j, kd kdVar, com.bytedance.sdk.component.f.hf.hf.w.hf hfVar) {
        com.bytedance.sdk.component.f.xj.hf hfVar2;
        if (kdVar != null) {
            try {
                if (kdVar.u().w()) {
                    long currentTimeMillis = System.currentTimeMillis() - j;
                    if (i == 200) {
                        com.bytedance.sdk.component.f.hf.hf.xj.xj xjVar = com.bytedance.sdk.component.f.hf.hf.hf.xj;
                        xjVar.ra().getAndAdd(currentTimeMillis);
                        xjVar.pz().incrementAndGet();
                        xjVar.yo().getAndAdd(list.size());
                        xjVar.kd().getAndAdd(list.size());
                        return;
                    }
                    w.w("-------AdThread code is " + i + " error  ------------", kdVar);
                    byte b = -1;
                    if (i == -1) {
                        com.bytedance.sdk.component.f.hf.hf.hf.xj.v().getAndAdd(list.size());
                    } else {
                        com.bytedance.sdk.component.f.hf.hf.hf.xj.c().getAndAdd(list.size());
                    }
                    com.bytedance.sdk.component.f.hf.hf.xj.xj xjVar2 = com.bytedance.sdk.component.f.hf.hf.hf.xj;
                    xjVar2.dk().getAndAdd(currentTimeMillis);
                    xjVar2.ht().incrementAndGet();
                    if (!list.isEmpty() && (hfVar2 = list.get(0)) != null) {
                        b = hfVar2.u();
                    }
                    if (hfVar != null) {
                        String str = hfVar.u;
                        int i2 = hfVar.hf;
                        String str2 = hfVar.w;
                        StringBuffer et = xjVar2.et();
                        et.append((int) b);
                        et.append("_");
                        et.append(str);
                        et.append("_");
                        et.append(i2);
                        et.append("_");
                        et.append(str2);
                        et.append(" ");
                        return;
                    }
                    StringBuffer et2 = xjVar2.et();
                    et2.append((int) b);
                    et2.append("_");
                    et2.append(i);
                    et2.append(" ");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void xj(List<com.bytedance.sdk.component.f.xj.hf> list, String str, kd kdVar) {
        try {
            u u2 = kdVar.u();
            if (u2 != null && u2.w() && list != null && u2.am()) {
                for (com.bytedance.sdk.component.f.xj.hf hfVar : list) {
                    if (hfVar != null) {
                        xj(hfVar, str, u2, kdVar);
                    }
                }
            }
        } catch (Exception e) {
            w.w(e.getMessage(), kdVar);
        }
    }
}
