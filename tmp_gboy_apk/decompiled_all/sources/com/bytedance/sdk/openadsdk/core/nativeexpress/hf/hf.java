package com.bytedance.sdk.openadsdk.core.nativeexpress.hf;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.aq;
import com.bytedance.sdk.openadsdk.core.ra.dc;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.jk;
import com.bytedance.sdk.openadsdk.core.ra.ss;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.z;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    public static JSONObject hf(ws wsVar) {
        int[] kd;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", wsVar.bh());
            if (wsVar.uf() != null) {
                jSONObject.put("icon", wsVar.uf().xj());
            }
            JSONArray jSONArray = new JSONArray();
            if (wsVar.lx() != null) {
                for (int i = 0; i < wsVar.lx().size(); i++) {
                    z zVar = wsVar.lx().get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(MediaFormat.KEY_HEIGHT, zVar.w());
                    jSONObject2.put(MediaFormat.KEY_WIDTH, zVar.hf());
                    jSONObject2.put("url", zVar.xj());
                    jSONObject2.put("image_key", zVar.c());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", wsVar.rx());
            jSONObject.put("interaction_type", wsVar.vw());
            jSONObject.put("is_compliance_template", w(wsVar));
            jSONObject.put("title", wsVar.kr());
            jSONObject.put("description", wsVar.uj());
            jSONObject.put(n.l, wsVar.ci());
            if (wsVar.vh() != null) {
                jSONObject.put("comment_num", wsVar.vh().y());
                jSONObject.put("score", wsVar.vh().kd());
                jSONObject.put("app_size", wsVar.vh().c());
                jSONObject.put(PointCategory.APP, wsVar.vh().f());
            }
            if (h.am(wsVar) != null) {
                JSONObject v = h.g(wsVar).v();
                if (wsVar.mq() > 0 && h.y(wsVar) > wsVar.mq()) {
                    v.put("video_duration", wsVar.mq());
                }
                if (com.bytedance.sdk.openadsdk.kd.xj.xj(wsVar) && (kd = h.kd(wsVar)) != null && kd.length >= 2 && !com.bytedance.sdk.openadsdk.kd.xj.c(wsVar)) {
                    v.put("cover_width", kd[0]);
                    v.put("cover_height", kd[1]);
                }
                jSONObject.put("video", v);
            }
            if (aq.e(wsVar)) {
                jSONObject.put("reward_full_play_time", aq.qt(wsVar));
                jSONObject.put("reward_full_time_type", 1);
            }
            jSONObject.put("reward_need_click", aq.io(wsVar));
            if (hl.y(wsVar) != null) {
                jSONObject.put("dynamic_creative", hl.y(wsVar).c());
            }
            jSONObject.put("live_ad", y(wsVar));
            xj(wsVar, jSONObject);
            if (com.bytedance.sdk.openadsdk.core.live.hf.xj().hf(wsVar)) {
                jSONObject.put("live_interaction_type", 2);
            } else {
                jSONObject.put("live_interaction_type", 1);
            }
            jSONObject.put("adx_name", wsVar.nn());
            jSONObject.put("can_show_interactive", wsVar.pq());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Map<String, String> kd(ws wsVar) {
        HashMap hashMap = null;
        if (wsVar == null) {
            return null;
        }
        List<z> lx = wsVar.lx();
        if (lx != null && lx.size() > 0) {
            hashMap = new HashMap();
            for (z zVar : lx) {
                if (zVar != null) {
                    hashMap.put(zVar.xj(), zVar.c());
                }
            }
        }
        return hashMap;
    }

    public static String u(ws wsVar) {
        if (hl.y(wsVar) == null) {
            return null;
        }
        return hl.y(wsVar).hf();
    }

    public static boolean w(ws wsVar) {
        return wsVar != null && jk.pl(wsVar) == 2;
    }

    public static JSONObject xj(float f, float f2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MediaFormat.KEY_WIDTH, f);
            jSONObject.put(MediaFormat.KEY_HEIGHT, f2);
            if (z) {
                jSONObject.put("isLandscape", true);
            }
            return jSONObject;
        } catch (Exception e) {
            pl.xj(e);
            return null;
        }
    }

    private static JSONObject y(ws wsVar) {
        JSONObject jSONObject = new JSONObject();
        if (wsVar != null && com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar)) {
            try {
                jSONObject.put("live_show_time", wo.hf(wsVar));
                jSONObject.put("live_author_nickname", wo.w(wsVar));
                if (wo.u(wsVar) > 0) {
                    jSONObject.put("live_author_follower_count", wo.u(wsVar));
                }
                if (wo.kd(wsVar) > 0) {
                    jSONObject.put("live_watch_count", wo.kd(wsVar));
                }
                jSONObject.put("live_description", wo.y(wsVar));
                jSONObject.put("live_feed_url", wo.c(wsVar));
                jSONObject.put("live_cover_image_url", wo.f(wsVar));
                jSONObject.put("live_avatar_url", wo.d(wsVar));
                jSONObject.put("live_cover_image_width", wo.pl(wsVar));
                jSONObject.put("live_cover_image_height", wo.g(wsVar));
                jSONObject.put("live_avatar_width", wo.tf(wsVar));
                jSONObject.put("live_avatar_height", wo.p(wsVar));
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static JSONObject xj(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return null;
        }
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            Context context = pz.getContext();
            jSONObject.put(MediaFormat.KEY_WIDTH, r.u(context, width) * 1.0f);
            jSONObject.put(MediaFormat.KEY_HEIGHT, r.u(context, height) * 1.0f);
            return jSONObject;
        } catch (Exception e) {
            pl.xj(e);
            return null;
        }
    }

    public static JSONObject xj(ws wsVar) {
        ss c = hl.c(wsVar);
        if (c == null) {
            return null;
        }
        String u = c.u();
        try {
            if (!TextUtils.isEmpty(u)) {
                return new JSONObject(u);
            }
            String xj = com.bytedance.sdk.openadsdk.core.nativeexpress.xj.hf.xj().xj(ClickCommon.CLICK_SCENE_AD, c.xj(), c.hf());
            if (!TextUtils.isEmpty(xj)) {
                return new JSONObject(xj);
            }
            pl.u("TemplateUtils", "template is null");
            return null;
        } catch (Exception e) {
            pl.xj(e);
            return null;
        }
    }

    public static JSONObject xj(ws wsVar, JSONObject jSONObject, JSONObject jSONObject2, boolean z, String str) {
        JSONObject ac = wsVar.ac();
        try {
            ac.put("xSetting", j.xj(wsVar, (AtomicBoolean) null));
            ac.put("xAdInfo", xj(wsVar, str));
            JSONObject jSONObject3 = new JSONObject();
            j.w(jSONObject3);
            jSONObject3.put("platform", "android");
            ac.put("xAppInfo", jSONObject3);
            ac.put("xCreative", hf(wsVar));
            if (jSONObject2 != null) {
                ac.put("xTemplate", jSONObject2);
            }
            if (jSONObject != null) {
                ac.put("xSize", jSONObject);
            }
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            Context context = pz.getContext();
            jSONObject5.put(MediaFormat.KEY_WIDTH, r.u(context, r.u(context)));
            jSONObject5.put(MediaFormat.KEY_HEIGHT, r.u(context, r.kd(context)));
            jSONObject4.put("screen_size", jSONObject5);
            jSONObject4.put("content_size", jSONObject);
            jSONObject4.put("platform", "android");
            ac.put("xEnvInfo", jSONObject4);
            ac.put("gesture_through_enable", z && pz.hf().zd());
            return ac;
        } catch (Exception e) {
            pl.xj(e);
            return ac;
        }
    }

    public static JSONObject xj(ws wsVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String ho = wsVar.ho();
            if (!TextUtils.isEmpty(ho)) {
                jSONObject.put("cid", ho);
            }
            String jf = wsVar.jf();
            if (!TextUtils.isEmpty(jf)) {
                jSONObject.put("log_extra", jf);
            }
            String zg = com.bytedance.sdk.openadsdk.core.a.wo.zg(wsVar);
            if (!TextUtils.isEmpty(zg)) {
                jSONObject.put("download_url", zg);
            }
            jSONObject.put("isDirectDownload", wsVar.qt());
            jSONObject.put("dynamic_configs", wsVar.jv());
            if (!TextUtils.isEmpty(str) && str.contains("advance_reward")) {
                jSONObject.put("userData", str);
            }
            if (v.p(wsVar)) {
                jSONObject.put("voice_btn_position", v.qt(wsVar));
                return jSONObject;
            }
        } catch (JSONException e) {
            pl.xj(e);
        }
        return jSONObject;
    }

    public static String hf(ws wsVar, String str) {
        List<z> lx;
        if (wsVar != null && (lx = wsVar.lx()) != null && lx.size() > 0) {
            for (z zVar : lx) {
                if (zVar != null && TextUtils.equals(str, zVar.xj())) {
                    return zVar.c();
                }
            }
        }
        return null;
    }

    public static JSONObject xj(float f, float f2, boolean z, ws wsVar) {
        String str;
        String str2;
        com.bytedance.sdk.component.adexpress.xj.w.hf xj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
            JSONObject jSONObject2 = new JSONObject();
            if (pz.hf().fa()) {
                float f3 = pz.getContext().getResources().getDisplayMetrics().density;
                float f4 = Resources.getSystem().getDisplayMetrics().density;
                jSONObject2.put(MediaFormat.KEY_WIDTH, r.hf(f4, r.xj(f3, f)));
                jSONObject2.put(MediaFormat.KEY_HEIGHT, r.hf(f4, r.xj(f3, f2)));
            } else {
                jSONObject2.put(MediaFormat.KEY_WIDTH, f);
                jSONObject2.put(MediaFormat.KEY_HEIGHT, f2);
            }
            if (z) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", hf(wsVar));
            if (hl.y(wsVar) != null) {
                str = hl.y(wsVar).kd();
                str2 = hl.y(wsVar).y();
            } else {
                str = null;
                str2 = null;
            }
            if (TextUtils.isEmpty(str)) {
                str = (hl.y(wsVar) == null || (xj = com.bytedance.sdk.component.adexpress.xj.hf.hf.xj(hl.y(wsVar).hf())) == null) ? null : xj.kd();
            }
            jSONObject.put("template_Plugin", str);
            jSONObject.put("diff_template_Plugin", str2);
            jSONObject.put("dynamic_configs", wsVar.jv());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject xj(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            return jSONObject;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject == null) {
            return jSONObject3;
        }
        try {
            JSONArray optJSONArray = jSONObject2.optJSONArray("keys");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (jSONObject.has(optString)) {
                        jSONObject3.put(optString, jSONObject.opt(optString));
                    }
                }
                jSONObject3.put("xSetting", jSONObject.opt("xSetting"));
                jSONObject3.put("xAdInfo", jSONObject.opt("xAdInfo"));
                jSONObject3.put("xAppInfo", jSONObject.opt("xAppInfo"));
                jSONObject3.put("xSize", jSONObject.opt("xSize"));
                jSONObject3.put("xTemplate", jSONObject.opt("xTemplate"));
                return jSONObject3;
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void xj(ws wsVar, JSONObject jSONObject) {
        if (com.bytedance.sdk.openadsdk.core.a.wo.f(wsVar) == 7 && dc.xj(wsVar)) {
            wsVar.ob().xj(jSONObject);
        }
    }
}
