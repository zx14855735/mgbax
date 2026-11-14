package com.bytedance.sdk.openadsdk.core.ra;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class n {
    private String hf;
    private String kd;
    private String u;
    private String w;
    private int xj;
    private ArrayList<xv> y;

    public n(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.xj = 0;
        this.w = "再看一个获取";
        this.u = "更多奖励";
        this.y = new ArrayList<>();
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("play_again")) == null) {
            return;
        }
        this.xj = optJSONObject.optInt("again_type", 0);
        this.w = optJSONObject.optString("entrance_prefix", "再看一个获取");
        this.u = optJSONObject.optString("entrance_suffix", "更多奖励");
        this.hf = optJSONObject.optString("pre_sessions");
        this.kd = optJSONObject.optString("play_again_rit");
        JSONArray optJSONArray = optJSONObject.optJSONArray("again_dialog_config");
        if (optJSONArray != null) {
            this.y = new ArrayList<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    this.y.add(new xv(optJSONObject2));
                }
            }
        }
    }

    public static boolean hf(ws wsVar) {
        n y = y(wsVar);
        if (y == null) {
            return false;
        }
        int i = y.xj;
        return (i == 1 || i == 3) && xj(wsVar);
    }

    public static ArrayList<xv> kd(ws wsVar) {
        n y = y(wsVar);
        return y != null ? y.y : new ArrayList<>();
    }

    public static String u(ws wsVar) {
        n y = y(wsVar);
        if (y == null) {
            return null;
        }
        return y.kd;
    }

    public static String w(ws wsVar) {
        n y = y(wsVar);
        if (y == null) {
            return null;
        }
        return y.hf;
    }

    private static n y(ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return wsVar.dj();
    }

    public void xj(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("again_type", this.xj);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        try {
            jSONObject2.put("entrance_prefix", this.w);
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.pl.xj(e2);
        }
        try {
            jSONObject2.put("entrance_suffix", this.u);
        } catch (JSONException e3) {
            com.bytedance.sdk.component.utils.pl.xj(e3);
        }
        try {
            jSONObject2.put("pre_sessions", this.hf);
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.pl.xj(e4);
        }
        try {
            jSONObject2.put("play_again_rit", this.kd);
        } catch (JSONException e5) {
            com.bytedance.sdk.component.utils.pl.xj(e5);
        }
        try {
            JSONArray jSONArray = new JSONArray();
            ArrayList<xv> arrayList = this.y;
            if (arrayList != null && arrayList.size() != 0) {
                Iterator<xv> it = this.y.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().xj());
                }
            }
            jSONObject2.put("again_dialog_config", jSONArray);
            try {
                jSONObject.put("play_again", jSONObject2);
            } catch (JSONException e6) {
                com.bytedance.sdk.component.utils.pl.xj(e6);
            }
        } catch (JSONException e7) {
            throw new RuntimeException(e7);
        }
    }

    public static String hf(String str) {
        return CtFAbx.AcNBzu(str, "custom_again");
    }

    public static boolean xj(ws wsVar) {
        n y = y(wsVar);
        if (y == null || vm.xj(wsVar)) {
            return false;
        }
        int i = y.xj;
        return (i == 1 || i == 2 || i == 3) && !TextUtils.isEmpty(y.hf);
    }

    public static String xj(String str) {
        return CtFAbx.AcNBzu(str, "again");
    }

    public static String xj(ws wsVar, String str, String str2) {
        n y = y(wsVar);
        if (y == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return "再看一个获取更多奖励";
            }
            return CtFAbx.BI9f7h("再看一个获取", str2, str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.isEmpty(y.w) ? "再看一个获取" : y.w);
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            sb.append(TextUtils.isEmpty(y.u) ? "更多奖励" : y.u);
        } else {
            sb.append(str2);
            sb.append(str);
        }
        return sb.toString();
    }
}
