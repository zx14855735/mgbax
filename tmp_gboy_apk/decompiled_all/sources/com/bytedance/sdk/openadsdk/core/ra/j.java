package com.bytedance.sdk.openadsdk.core.ra;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class j {
    private static int am;
    private static int d;
    private static int e;
    private static int g;
    private static int hf;
    private static int p;

    /* renamed from: pl, reason: collision with root package name */
    private static int f10409pl;
    private static int qt;
    private static int tf;
    private static int u;
    private static int w;
    private static int xj;
    private static int yo;
    private static int zg;
    private final String dk;
    private final int ht;
    private final int jk;
    private final int pz;
    private final int ra;
    private final int v;
    private static final ArrayList<int[]> kd = new ArrayList<>();
    private static final ArrayList<int[]> y = new ArrayList<>();
    private static final ArrayList<int[]> c = new ArrayList<>();
    private static final ArrayList<int[]> f = new ArrayList<>();
    private static String et = "已为您延迟到奖励下发后再播放下一个";

    /* renamed from: io, reason: collision with root package name */
    private static int f10408io = 3;
    private static int x = 0;
    private static int ai = 0;

    static {
        knXiSFn();
    }

    public j(JSONObject jSONObject) {
        this.ra = jSONObject.optInt("carousel_pos", -1);
        this.v = jSONObject.optInt("insert_ad_control", 0);
        this.jk = jSONObject.optInt("refresh_ad_control", 0);
        this.ht = jSONObject.optInt("refresh_ad_imp_max_time", 0);
        this.pz = jSONObject.optInt("force_refresh_ad_control", 0);
        this.dk = jSONObject.optString("carousel_tip_content", "秒后将继续播放下一个");
    }

    public static int am() {
        return ai;
    }

    public static int c() {
        return qt;
    }

    public static int d() {
        return e;
    }

    public static int f() {
        return d;
    }

    public static int g() {
        return x;
    }

    public static boolean hf() {
        return hf == 1;
    }

    public static int kd() {
        return w;
    }

    private static /* synthetic */ void knXiSFn() {
        char[] charArray = ".\" c*, (c/\"4c>%(!!c\u0007#$\u000f?$)*(".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'M');
        }
        String str = new String(charArray);
        char[] charArray2 = ".!$#$9".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'M');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String p() {
        return et;
    }

    public static int pl() {
        return f10408io;
    }

    public static int tf() {
        return yo / 1000;
    }

    public static boolean u() {
        return zg == 1;
    }

    public static boolean w() {
        return am == 1;
    }

    public static void xj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject != null) {
            try {
                int optInt = optJSONObject.optInt("insert_ad_control", 1);
                xj = optInt;
                if (optInt < 0 || optInt > 1) {
                    xj = 1;
                }
                int optInt2 = optJSONObject.optInt("insert_ad_control_fs", 1);
                hf = optInt2;
                if (optInt2 < 0 || optInt2 > 1) {
                    hf = 1;
                }
                w = optJSONObject.optInt("insert_ad_req_num", 3);
                u = optJSONObject.optInt("insert_ad_req_num_fs", 2);
                d = optJSONObject.optInt("insert_ad_toast_max_time", 5);
                tf = optJSONObject.optInt("insert_ad_tip_max_time", 0);
                p = optJSONObject.optInt("insert_ad_tip_max_time_fs", 3);
                f10409pl = optJSONObject.optInt("refresh_ad_tip_max_time", 3);
                g = optJSONObject.optInt("refresh_ad_tip_max_time_fs", 3);
                int optInt3 = optJSONObject.optInt("refresh_ad_control", 1);
                am = optInt3;
                if (optInt3 < 0 || optInt3 > 1) {
                    am = 1;
                }
                qt = optJSONObject.optInt("refresh_ad_req_num", 3);
                int optInt4 = optJSONObject.optInt("force_refresh_ad_control", 1);
                zg = optInt4;
                if (optInt4 < 0 || optInt4 > 1) {
                    zg = 1;
                }
                e = optJSONObject.optInt("force_refresh_ad_pause_over_time", 5000);
                yo = optJSONObject.optInt("refresh_ad_reduce_time", 0);
                JSONArray optJSONArray = optJSONObject.optJSONArray("insert_ad_pt_show_time");
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    kd.add(new int[]{0, 500});
                } else {
                    kd.clear();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                        if (optJSONArray2 != null && optJSONArray2.length() == 2) {
                            kd.add(new int[]{optJSONArray2.optInt(0), optJSONArray2.optInt(1)});
                        }
                    }
                }
                JSONArray optJSONArray3 = optJSONObject.optJSONArray("insert_ad_vd_show_time");
                if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                    y.add(new int[]{0, 500});
                } else {
                    y.clear();
                    for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                        JSONArray optJSONArray4 = optJSONArray3.optJSONArray(i2);
                        if (optJSONArray4 != null && optJSONArray4.length() == 2) {
                            y.add(new int[]{optJSONArray4.optInt(0), optJSONArray4.optInt(1)});
                        }
                    }
                }
                JSONArray optJSONArray5 = optJSONObject.optJSONArray("insert_ad_pt_show_time_fs");
                if (optJSONArray5 == null || optJSONArray5.length() <= 0) {
                    c.add(new int[]{0, 500});
                } else {
                    c.clear();
                    for (int i3 = 0; i3 < optJSONArray5.length(); i3++) {
                        JSONArray optJSONArray6 = optJSONArray5.optJSONArray(i3);
                        if (optJSONArray6 != null && optJSONArray6.length() == 2) {
                            c.add(new int[]{optJSONArray6.optInt(0), optJSONArray6.optInt(1)});
                        }
                    }
                }
                JSONArray optJSONArray7 = optJSONObject.optJSONArray("insert_ad_vd_show_time_fs");
                if (optJSONArray7 == null || optJSONArray7.length() <= 0) {
                    f.add(new int[]{0, 500});
                } else {
                    f.clear();
                    for (int i4 = 0; i4 < optJSONArray7.length(); i4++) {
                        JSONArray optJSONArray8 = optJSONArray7.optJSONArray(i4);
                        if (optJSONArray8 != null && optJSONArray8.length() == 2) {
                            f.add(new int[]{optJSONArray8.optInt(0), optJSONArray8.optInt(1)});
                        }
                    }
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("reward_aggregation_config");
                if (optJSONObject2 != null) {
                    et = optJSONObject2.optString("refresh_ad_clickafter_tip_content", "已为您延迟到奖励下发后再播放下一个");
                    f10408io = optJSONObject2.optInt("refresh_ad_clickafter_tip_content_max_time", 3);
                    x = optJSONObject2.optInt("refresh_ad_ifclick_swtich");
                    ai = optJSONObject2.optInt("refresh_ad_ifclick_swtich_fs");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static int y() {
        return u;
    }

    private static j c(ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return wsVar.n();
    }

    public static int hf(boolean z) {
        return z ? f10409pl : g;
    }

    public static int kd(ws wsVar) {
        j c2 = c(wsVar);
        if (c2 == null) {
            return 0;
        }
        return c2.ht;
    }

    public static int u(ws wsVar) {
        j c2 = c(wsVar);
        if (c2 == null) {
            return -1;
        }
        return c2.ra;
    }

    public static int w(ws wsVar) {
        j c2 = c(wsVar);
        if (c2 == null) {
            return 0;
        }
        return c2.pz;
    }

    public static String y(ws wsVar) {
        j c2 = c(wsVar);
        return c2 == null ? "秒后将继续播放下一个" : c2.dk;
    }

    private static boolean hf(boolean z, int i) {
        if (z) {
            Iterator<int[]> it = f.iterator();
            while (it.hasNext()) {
                int[] next = it.next();
                if (i >= next[0] && i <= next[1]) {
                    return true;
                }
            }
        } else {
            Iterator<int[]> it2 = c.iterator();
            while (it2.hasNext()) {
                int[] next2 = it2.next();
                if (i >= next2[0] && i <= next2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean u(ws wsVar, boolean z) {
        return (!z || hf == 1) && xj(wsVar) == 1 && u(wsVar) > 0;
    }

    private static boolean w(ws wsVar, boolean z) {
        return (!z || xj == 1) && xj(wsVar) == 1 && u(wsVar) > 0;
    }

    public static void hf(com.bytedance.sdk.component.u.hf.w wVar) {
        try {
            wVar.put("insert_ad_control", xj);
            wVar.put("insert_ad_control_fs", hf);
            wVar.put("insert_ad_req_num", w);
            wVar.put("insert_ad_req_num_fs", u);
            wVar.put("insert_ad_toast_max_time", d);
            wVar.put("insert_ad_tip_max_time", tf);
            wVar.put("insert_ad_tip_max_time_fs", p);
            wVar.put("refresh_ad_tip_max_time", f10409pl);
            wVar.put("refresh_ad_tip_max_time_fs", g);
            wVar.put("refresh_ad_control", am);
            wVar.put("refresh_ad_req_num", qt);
            wVar.put("force_refresh_ad_control", zg);
            wVar.put("force_refresh_ad_pause_over_time", e);
            wVar.put("refresh_ad_reduce_time", yo);
            ArrayList<int[]> arrayList = kd;
            if (!arrayList.isEmpty()) {
                HashSet hashSet = new HashSet();
                Iterator<int[]> it = arrayList.iterator();
                while (it.hasNext()) {
                    int[] next = it.next();
                    if (next != null && next.length == 2) {
                        hashSet.add(next[0] + "," + next[1]);
                    }
                }
                wVar.put("insert_ad_pt_show_time", hashSet);
            }
            ArrayList<int[]> arrayList2 = y;
            if (!arrayList2.isEmpty()) {
                HashSet hashSet2 = new HashSet();
                Iterator<int[]> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    int[] next2 = it2.next();
                    if (next2 != null && next2.length == 2) {
                        hashSet2.add(next2[0] + "," + next2[1]);
                    }
                }
                wVar.put("insert_ad_vd_show_time", hashSet2);
            }
            ArrayList<int[]> arrayList3 = c;
            if (!arrayList3.isEmpty()) {
                HashSet hashSet3 = new HashSet();
                Iterator<int[]> it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    int[] next3 = it3.next();
                    if (next3 != null && next3.length == 2) {
                        hashSet3.add(next3[0] + "," + next3[1]);
                    }
                }
                wVar.put("insert_ad_pt_show_time_fs", hashSet3);
            }
            ArrayList<int[]> arrayList4 = f;
            if (!arrayList4.isEmpty()) {
                HashSet hashSet4 = new HashSet();
                Iterator<int[]> it4 = arrayList4.iterator();
                while (it4.hasNext()) {
                    int[] next4 = it4.next();
                    if (next4 != null && next4.length == 2) {
                        hashSet4.add(next4[0] + "," + next4[1]);
                    }
                }
                wVar.put("insert_ad_vd_show_time_fs", hashSet4);
            }
            wVar.put("refresh_ad_ifclick_swtich_fs", ai);
            wVar.put("refresh_ad_ifclick_swtich", x);
            wVar.put("refresh_ad_clickafter_tip_content", et);
            wVar.put("refresh_ad_clickafter_tip_content_max_time", f10408io);
        } catch (Exception unused) {
        }
    }

    public void hf(JSONObject jSONObject) {
        try {
            jSONObject.put("carousel_pos", this.ra);
            jSONObject.put("insert_ad_control", this.v);
            jSONObject.put("refresh_ad_control", this.jk);
            jSONObject.put("refresh_ad_imp_max_time", this.ht);
            jSONObject.put("force_refresh_ad_control", this.pz);
            jSONObject.put("carousel_tip_content", this.dk);
        } catch (JSONException unused) {
        }
    }

    public static int hf(ws wsVar) {
        j c2 = c(wsVar);
        if (c2 == null) {
            return 0;
        }
        return c2.jk;
    }

    public static boolean hf(ws wsVar, boolean z) {
        return (!z || zg == 1) && w(wsVar) == 1 && u(wsVar) > 0;
    }

    public static boolean hf(boolean z, ws wsVar, boolean z2) {
        return xj(z, wsVar, z2) || xj(wsVar, z2) || hf(wsVar, z2);
    }

    public static boolean xj() {
        return xj == 1;
    }

    public static int xj(boolean z) {
        if (z) {
            return tf;
        }
        return p;
    }

    public static boolean xj(boolean z, boolean z2, int i) {
        return z ? xj(z2, i) : hf(z2, i);
    }

    private static boolean xj(boolean z, int i) {
        if (z) {
            Iterator<int[]> it = y.iterator();
            while (it.hasNext()) {
                int[] next = it.next();
                if (i >= next[0] && i <= next[1]) {
                    return true;
                }
            }
        } else {
            Iterator<int[]> it2 = kd.iterator();
            while (it2.hasNext()) {
                int[] next2 = it2.next();
                if (i >= next2[0] && i <= next2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean xj(int i, ws wsVar, boolean z) {
        return kd(wsVar) > 0 && i * 1000 >= kd(wsVar) - (hf(z) * 1000);
    }

    public static boolean xj(int i, ws wsVar) {
        return kd(wsVar) > 0 && i * 1000 >= kd(wsVar);
    }

    public static void xj(com.bytedance.sdk.component.u.hf.w wVar) {
        try {
            xj = wVar.getInt("insert_ad_control", 1);
            hf = wVar.getInt("insert_ad_control_fs", 1);
            w = wVar.getInt("insert_ad_req_num", 3);
            u = wVar.getInt("insert_ad_req_num_fs", 2);
            d = wVar.getInt("insert_ad_toast_max_time", 5);
            tf = wVar.getInt("insert_ad_tip_max_time", 0);
            p = wVar.getInt("insert_ad_tip_max_time_fs", 3);
            f10409pl = wVar.getInt("refresh_ad_tip_max_time", 3);
            g = wVar.getInt("refresh_ad_tip_max_time_fs", 3);
            am = wVar.getInt("refresh_ad_control", 1);
            qt = wVar.getInt("refresh_ad_req_num", 3);
            zg = wVar.getInt("force_refresh_ad_control", 1);
            e = wVar.getInt("force_refresh_ad_pause_over_time", 5000);
            yo = wVar.getInt("refresh_ad_reduce_time", 0);
            Set<String> stringSet = wVar.getStringSet("insert_ad_pt_show_time", null);
            if (stringSet != null && !stringSet.isEmpty()) {
                kd.clear();
                Iterator<String> it = stringSet.iterator();
                while (it.hasNext()) {
                    String[] split = it.next().split(",");
                    if (split.length == 2) {
                        kd.add(new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])});
                    }
                }
            }
            Set<String> stringSet2 = wVar.getStringSet("insert_ad_vd_show_time", null);
            if (stringSet2 != null && !stringSet2.isEmpty()) {
                y.clear();
                Iterator<String> it2 = stringSet2.iterator();
                while (it2.hasNext()) {
                    String[] split2 = it2.next().split(",");
                    if (split2.length == 2) {
                        y.add(new int[]{Integer.parseInt(split2[0]), Integer.parseInt(split2[1])});
                    }
                }
            }
            Set<String> stringSet3 = wVar.getStringSet("insert_ad_pt_show_time_fs", null);
            if (stringSet3 != null && !stringSet3.isEmpty()) {
                c.clear();
                Iterator<String> it3 = stringSet3.iterator();
                while (it3.hasNext()) {
                    String[] split3 = it3.next().split(",");
                    if (split3.length == 2) {
                        c.add(new int[]{Integer.parseInt(split3[0]), Integer.parseInt(split3[1])});
                    }
                }
            }
            Set<String> stringSet4 = wVar.getStringSet("insert_ad_vd_show_time_fs", null);
            if (stringSet4 != null && !stringSet4.isEmpty()) {
                f.clear();
                Iterator<String> it4 = stringSet4.iterator();
                while (it4.hasNext()) {
                    String[] split4 = it4.next().split(",");
                    if (split4.length == 2) {
                        f.add(new int[]{Integer.parseInt(split4[0]), Integer.parseInt(split4[1])});
                    }
                }
            }
            et = wVar.getString("refresh_ad_clickafter_tip_content", "已为您延迟到奖励下发后再播放下一个");
            f10408io = wVar.getInt("refresh_ad_clickafter_tip_content_max_time", 3);
            x = wVar.getInt("refresh_ad_ifclick_swtich", 0);
            ai = wVar.getInt("refresh_ad_ifclick_swtich_fs", 0);
        } catch (Exception unused) {
        }
    }

    public static int xj(ws wsVar) {
        j c2 = c(wsVar);
        if (c2 == null) {
            return 0;
        }
        return c2.v;
    }

    public static boolean xj(boolean z, ws wsVar, boolean z2) {
        return z ? w(wsVar, z2) : u(wsVar, z2);
    }

    public static boolean xj(ws wsVar, boolean z) {
        return (!z || am == 1) && hf(wsVar) == 1 && u(wsVar) > 0;
    }
}
