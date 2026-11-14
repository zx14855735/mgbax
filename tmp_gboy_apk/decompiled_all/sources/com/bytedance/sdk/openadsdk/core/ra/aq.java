package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class aq {
    private static int hf = 0;
    private static int w = 0;
    private static long xj = 27000;
    private boolean ai;
    private int am;
    private boolean c;
    private boolean d;
    private boolean dk;
    private double e;
    private ArrayList<xv> et;
    private double f;
    private int g;
    private int ht;

    /* renamed from: io, reason: collision with root package name */
    private tu f10395io;
    private int j;
    private int jk;
    private int kd;
    private String p;

    /* renamed from: pl, reason: collision with root package name */
    private int f10396pl;
    private int pz;
    private int q;
    private int qt;
    private boolean ra;
    private double tf;
    private String u;
    private double v;
    private boolean x;
    private boolean y;
    private boolean yo;
    private boolean z;
    private boolean zg;

    public aq(JSONObject jSONObject) {
        this.ht = 0;
        this.ra = false;
        this.dk = false;
        this.et = new ArrayList<>();
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("reward");
        if (optJSONObject != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("retain_dialog_config");
            if (optJSONArray != null) {
                this.et = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    if (optJSONObject2 != null) {
                        this.et.add(new xv(optJSONObject2));
                    }
                }
            }
            this.f10395io = new tu(optJSONObject);
            this.ai = optJSONObject.optBoolean("endcard_transform_enabled", false);
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("reward_data");
        if (optJSONObject3 != null) {
            this.kd = optJSONObject3.optInt(MediationConstant.REWARD_AMOUNT, 0);
            this.u = optJSONObject3.optString(MediationConstant.REWARD_NAME, "");
            this.y = optJSONObject3.optBoolean("reward_info_show", false);
            this.g = optJSONObject3.optInt("reward_back_type", 0);
            this.am = optJSONObject3.optInt("reward_backup_timing", 0);
            this.qt = optJSONObject3.optInt("reward_backup_duration", Integer.MAX_VALUE);
            this.q = optJSONObject3.optInt("reward_is_callback", 0);
            this.z = optJSONObject3.optBoolean("reward_need_click", false);
            JSONObject optJSONObject4 = optJSONObject3.optJSONObject("reward_advanced_config");
            if (optJSONObject4 != null) {
                JSONObject optJSONObject5 = optJSONObject4.optJSONObject("easy_playable");
                if (optJSONObject5 != null) {
                    this.c = optJSONObject5.optBoolean("enable");
                    double optDouble = optJSONObject5.optDouble("propose_reward", 0.0d);
                    this.f = optDouble;
                    if (optDouble < 0.0d) {
                        this.f = 0.0d;
                    }
                }
                JSONObject optJSONObject6 = optJSONObject4.optJSONObject(com.sigmob.sdk.base.common.a.o);
                if (optJSONObject6 != null) {
                    this.d = optJSONObject6.optBoolean("enable");
                    double optDouble2 = optJSONObject6.optDouble("propose_reward", 0.0d);
                    this.tf = optDouble2;
                    if (optDouble2 < 0.0d) {
                        this.tf = 0.0d;
                    }
                    this.p = optJSONObject6.optString("tip_toast");
                    this.f10396pl = optJSONObject6.optInt("min_duration");
                }
                JSONObject optJSONObject7 = optJSONObject4.optJSONObject("playable_interactive");
                if (optJSONObject7 != null) {
                    this.zg = optJSONObject7.optBoolean("enable");
                    this.e = optJSONObject7.optDouble("propose_reward", 0.0d);
                }
                JSONObject optJSONObject8 = optJSONObject4.optJSONObject("click_landing");
                if (optJSONObject8 != null) {
                    this.yo = optJSONObject8.optBoolean("enable");
                    this.v = optJSONObject8.optDouble("propose_reward", 0.0d);
                    this.jk = optJSONObject8.optInt("landing_view_time", 5);
                }
            }
        }
        this.pz = jSONObject.optInt("reward_full_play_time", 30);
        this.ht = jSONObject.optInt("reward_full_time_type", 0);
        this.x = jSONObject.optBoolean("interstitial_bg_transparent", false);
        this.j = jSONObject.optInt("template_sign", 0);
        this.ra = jSONObject.optBoolean("__is_use_local_time", false);
        this.dk = jSONObject.optBoolean("__is_click_landing_reward", false);
    }

    private static aq ai(ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return wsVar.tj();
    }

    public static int am(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai == null) {
            return 5;
        }
        return Math.max(5, ai.jk);
    }

    public static boolean c(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai == null) {
            return false;
        }
        return ai.d;
    }

    public static String d(ws wsVar) {
        aq ai = ai(wsVar);
        return ai == null ? "" : TextUtils.isEmpty(ai.p) ? "别急着跳过，继续观看完整视频，可获得更多额外奖励～" : ai.p;
    }

    public static boolean dk(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai == null) {
            return false;
        }
        return ai.ai;
    }

    public static boolean e(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai != null && ai.ra) {
            return v.u(wsVar) || zg(wsVar) == 1 || zg(wsVar) == 2;
        }
        return false;
    }

    public static boolean et(ws wsVar) {
        aq ai = ai(wsVar);
        return ai != null && ai.q == 1;
    }

    public static double f(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai == null) {
            return 0.0d;
        }
        return ai.tf;
    }

    public static boolean g(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai == null) {
            return false;
        }
        return ai.yo;
    }

    public static void hf(com.bytedance.sdk.component.u.hf.w wVar) {
        xj = wVar.get("reward_time_limited", 27000L);
        hf = wVar.get("reward_force_close_max_count", 0);
        w = wVar.get("reward_local_countdown_close_style", 0);
    }

    public static tu ht(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai != null) {
            return ai.f10395io;
        }
        return null;
    }

    public static boolean io(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai == null) {
            return false;
        }
        return ai.z;
    }

    public static ArrayList<xv> jk(ws wsVar) {
        aq ai = ai(wsVar);
        return ai != null ? ai.et : new ArrayList<>();
    }

    public static boolean kd(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai == null) {
            return false;
        }
        return ai.c;
    }

    public static boolean p(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai == null) {
            return false;
        }
        return ai.zg;
    }

    public static double pl(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai == null) {
            return 0.0d;
        }
        return ai.e;
    }

    public static boolean pz(ws wsVar) {
        aq ai = ai(wsVar);
        return ai != null && ai.am == 1;
    }

    public static int qt(ws wsVar) {
        int i;
        aq ai = ai(wsVar);
        if (ai != null && (i = ai.pz) >= 10 && i <= 60) {
            return i;
        }
        return 30;
    }

    public static boolean ra(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai != null) {
            return ai.x;
        }
        return false;
    }

    public static int tf(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai == null) {
            return KSImageLoader.InnerImageLoadingListener.MAX_DURATION;
        }
        int max = Math.max(ai.f10396pl, 30);
        return (max <= 60 ? max : 30) * 1000;
    }

    public static boolean u(ws wsVar) {
        aq ai = ai(wsVar);
        return ai != null && ai.g == 1;
    }

    public static boolean v(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai != null && ai.dk) {
            return g(wsVar);
        }
        return false;
    }

    public static boolean w(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai == null) {
            return false;
        }
        return ai.y;
    }

    public static int x(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai == null) {
            return 0;
        }
        return ai.j;
    }

    public static void xj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("app_common_config");
        if (optJSONObject != null) {
            try {
                xj = optJSONObject.optLong("reward_time_limited", 27000L);
                hf = optJSONObject.optInt("reward_force_close_max_count", 0);
                w = optJSONObject.optInt("reward_local_countdown_close_style", 0);
            } catch (Exception unused) {
            }
        }
    }

    public static double y(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai == null) {
            return 0.0d;
        }
        return ai.f;
    }

    public static boolean yo(ws wsVar) {
        aq ai = ai(wsVar);
        return ai != null && ai.ra && zg(wsVar) == 1;
    }

    public static int zg(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai == null) {
            return 0;
        }
        return ai.ht;
    }

    public static boolean w() {
        return w == 1;
    }

    public void hf(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            ArrayList<xv> arrayList = this.et;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<xv> it = this.et.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().xj());
                }
            }
            jSONObject2.put("retain_dialog_config", jSONArray);
            tu tuVar = this.f10395io;
            if (tuVar != null) {
                tuVar.xj(jSONObject2);
            }
            jSONObject2.put("endcard_transform_enabled", this.ai);
            jSONObject.put("reward", jSONObject2);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(MediationConstant.REWARD_NAME, this.u);
            jSONObject3.put(MediationConstant.REWARD_AMOUNT, this.kd);
            jSONObject3.put("reward_info_show", this.y);
            jSONObject3.put("reward_back_type", this.g);
            jSONObject3.put("reward_backup_timing", this.am);
            jSONObject3.put("reward_backup_duration", this.qt);
            jSONObject3.put("reward_is_callback", this.q);
            jSONObject3.put("reward_need_click", this.z);
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("enable", this.c);
            jSONObject5.put("propose_reward", this.f);
            jSONObject4.put("easy_playable", jSONObject5);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("enable", this.d);
            jSONObject6.put("propose_reward", this.tf);
            jSONObject6.put("tip_toast", this.p);
            jSONObject6.put("min_duration", this.f10396pl);
            jSONObject4.put(com.sigmob.sdk.base.common.a.o, jSONObject6);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("enable", this.zg);
            jSONObject7.put("propose_reward", this.e);
            jSONObject4.put("playable_interactive", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("enable", this.yo);
            jSONObject8.put("propose_reward", this.v);
            jSONObject8.put("landing_view_time", this.jk);
            jSONObject4.put("click_landing", jSONObject8);
            jSONObject3.put("reward_advanced_config", jSONObject4);
            jSONObject.put("reward_data", jSONObject3);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.pl.xj(e2);
        }
        try {
            jSONObject.put("reward_full_play_time", this.pz);
            jSONObject.put("reward_full_time_type", this.ht);
            jSONObject.put("interstitial_bg_transparent", this.x);
            jSONObject.put("template_sign", this.j);
            jSONObject.put("__is_use_local_time", this.ra);
            jSONObject.put("__is_click_landing_reward", this.dk);
        } catch (JSONException e3) {
            com.bytedance.sdk.component.utils.pl.xj(e3);
        }
    }

    public static void xj(com.bytedance.sdk.component.u.hf.w wVar) {
        wVar.put("reward_time_limited", xj);
        wVar.put("reward_force_close_max_count", hf);
        wVar.put("reward_local_countdown_close_style", w);
    }

    public static String xj(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai == null) {
            return "";
        }
        return ai.u;
    }

    public static long xj() {
        return xj;
    }

    public static float xj(ws wsVar, int i) {
        double y;
        if (i == 0) {
            return 1.0f;
        }
        if (i == 1) {
            y = y(wsVar);
        } else if (i == 2) {
            y = f(wsVar);
        } else {
            if (i != 3) {
                return 0.0f;
            }
            y = pl(wsVar);
        }
        return (float) y;
    }

    public static void xj(ws wsVar, boolean z) {
        aq ai = ai(wsVar);
        if (ai != null) {
            ai.ra = z;
        }
    }

    public static int hf(ws wsVar) {
        aq ai = ai(wsVar);
        if (ai == null) {
            return 0;
        }
        return ai.kd;
    }

    public static long hf() {
        return hf;
    }

    public static void hf(ws wsVar, boolean z) {
        aq ai = ai(wsVar);
        if (ai != null) {
            ai.dk = z;
        }
    }

    public static int hf(ws wsVar, int i) {
        int i2;
        aq ai = ai(wsVar);
        return (ai != null && (i2 = ai.qt) > 0) ? Math.min(i, i2) : i;
    }
}
