package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.ra.dc;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.tj;
import com.bytedance.sdk.openadsdk.core.ra.wa;
import com.bytedance.sdk.openadsdk.core.ra.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static Map<String, Object> c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                hashMap.put(next, jSONObject.opt(next));
            }
        }
        return hashMap;
    }

    public static com.bytedance.sdk.openadsdk.core.ra.kd hf(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.ra.kd kdVar = new com.bytedance.sdk.openadsdk.core.ra.kd();
        kdVar.w(jSONObject.optString("app_name"));
        kdVar.u(jSONObject.optString(n.p));
        kdVar.hf(jSONObject.optString("download_url"));
        kdVar.xj(jSONObject.optInt("score", 4));
        kdVar.hf(jSONObject.optInt("comment_num", 0));
        kdVar.w(jSONObject.optInt("app_size", 0));
        kdVar.xj(jSONObject.optString("quick_app_url", ""));
        return kdVar;
    }

    public static com.bytedance.sdk.openadsdk.core.ra.y kd(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.ra.y yVar = new com.bytedance.sdk.openadsdk.core.ra.y();
        yVar.u(jSONObject.optString("developer_name"));
        yVar.hf(jSONObject.optString(n.r));
        JSONArray optJSONArray = jSONObject.optJSONArray("permissions");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            yVar.hf(optJSONArray);
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    yVar.xj(optJSONObject.optString("permission_name"), optJSONObject.optString("permission_desc"));
                }
            }
        }
        yVar.xj(jSONObject.optString("permissions_url"));
        yVar.xj(jSONObject.optInt("score", 0));
        yVar.xj(jSONObject.optJSONArray("creative_tags"));
        yVar.kd(jSONObject.optString("privacy_policy_url"));
        yVar.y(jSONObject.optString("desc_url"));
        yVar.c(jSONObject.optString("reg_number"));
        yVar.f(jSONObject.optString("reg_url"));
        yVar.tf(jSONObject.optString("app_name"));
        yVar.d(jSONObject.optString(n.p));
        return yVar;
    }

    public static com.bytedance.sdk.openadsdk.core.ra.et u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.ra.et etVar = new com.bytedance.sdk.openadsdk.core.ra.et();
        etVar.u(jSONObject.optString("bg_url"));
        etVar.w(jSONObject.optString("title"));
        etVar.xj(jSONObject.optString("reward_image_url"));
        etVar.hf(jSONObject.optString("reward_title"));
        etVar.kd(jSONObject.optString(MediaFormat.KEY_SUBTITLE));
        return etVar;
    }

    public static com.bytedance.sdk.openadsdk.core.ra.dk w(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.ra.dk dkVar = new com.bytedance.sdk.openadsdk.core.ra.dk();
        dkVar.w(jSONObject.optString("ugen_dialog_md5"));
        dkVar.hf(jSONObject.optString("ugen_dialog_url"));
        dkVar.xj(jSONObject.optString("dialog_style"));
        return dkVar;
    }

    public static Pair<com.bytedance.sdk.openadsdk.core.ra.xj, ArrayList<Integer>> xj(JSONObject jSONObject, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, tj tjVar, long j) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.ra.xj xjVar = new com.bytedance.sdk.openadsdk.core.ra.xj();
            xjVar.xj(jSONObject.optString(PointParamKey.REQUEST_ID));
            xjVar.xj(jSONObject.optInt("ret"));
            xjVar.hf(jSONObject.optString("message"));
            String optString = jSONObject.optString("auction_price");
            com.bytedance.sdk.openadsdk.core.a.p.hf(jSONObject.optString("client_ipv4", ""));
            boolean optBoolean = jSONObject.optBoolean("need_get_materials");
            if (xjVar.xj() != 0) {
                return null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ws xj = xj(optJSONArray.optJSONObject(i), hfVar, tjVar);
                    int xj2 = xj(xj, hfVar != null ? hfVar.jk() : 0);
                    boolean z = xj.z();
                    String en = xj.en();
                    if (xj2 != 200 && ((!optBoolean && !z) || TextUtils.isEmpty(en))) {
                        arrayList.add(Integer.valueOf(xj2));
                    }
                    xj.q(optString);
                    xj.w(j);
                    xj.y(optBoolean);
                    xjVar.xj(xj);
                }
            }
            return new Pair<>(xjVar, arrayList);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            return null;
        }
    }

    private static com.bytedance.sdk.openadsdk.core.ra.pz y(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.ra.pz pzVar = new com.bytedance.sdk.openadsdk.core.ra.pz();
        pzVar.xj(jSONObject.optInt("ah", 1));
        pzVar.hf(jSONObject.optInt("am", 1));
        return pzVar;
    }

    private static int hf(ws wsVar, int i) {
        if (i != 3 && i != 4 && i != 0) {
            if (!wo.xj(wsVar)) {
                return 416;
            }
            if (TextUtils.isEmpty(wo.c(wsVar))) {
                return TTAdConstant.LIVE_FEED_URL_CODE;
            }
        }
        return 200;
    }

    private static int hf(List<com.bytedance.sdk.openadsdk.core.ra.z> list) {
        if (list == null) {
            return TTAdConstant.IMAGE_LIST_CODE;
        }
        if (list.size() <= 0) {
            return TTAdConstant.IMAGE_LIST_SIZE_CODE;
        }
        for (com.bytedance.sdk.openadsdk.core.ra.z zVar : list) {
            if (zVar == null) {
                return TTAdConstant.IMAGE_CODE;
            }
            if (TextUtils.isEmpty(zVar.xj())) {
                return TTAdConstant.IMAGE_URL_CODE;
            }
        }
        return 200;
    }

    public static ws xj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return xj(jSONObject, null, null);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x05e6  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x061a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0696  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0769  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x07ed  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0810  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0861  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x086f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x090c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x054e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.bytedance.sdk.openadsdk.core.ra.ws xj(org.json.JSONObject r17, com.bytedance.sdk.openadsdk.zg.w.w.hf r18, com.bytedance.sdk.openadsdk.core.ra.tj r19) {
        /*
            Method dump skipped, instructions count: 2348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.xj.xj(org.json.JSONObject, com.bytedance.sdk.openadsdk.zg.w.w.hf, com.bytedance.sdk.openadsdk.core.ra.tj):com.bytedance.sdk.openadsdk.core.ra.ws");
    }

    private static com.bytedance.sdk.openadsdk.core.ugeno.y.xj xj(JSONObject jSONObject, ws wsVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.y.xj xjVar = new com.bytedance.sdk.openadsdk.core.ugeno.y.xj();
        xjVar.xj(jSONObject.optString(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a));
        xjVar.hf(jSONObject.optString(TKDownloadReason.KSAD_TK_MD5));
        xjVar.w(jSONObject.optString("url"));
        xjVar.xj(jSONObject.optInt("scene"));
        return xjVar;
    }

    private static void xj(ws wsVar, JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.core.ra.zg yt;
        if (wsVar == null || jSONObject == null) {
            return;
        }
        if ((wo.xj(wsVar) || dc.xj(wsVar)) && (yt = wsVar.yt()) != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("reward_live_deep_link_params");
            com.bytedance.sdk.openadsdk.core.ra.a aVar = new com.bytedance.sdk.openadsdk.core.ra.a();
            if (optJSONObject != null) {
                aVar.xj(optJSONObject.optString("reward_live_deep_link_user_id"));
                aVar.kd(optJSONObject.optString("reward_live_deep_link_request_id"));
                aVar.hf(optJSONObject.optString("reward_live_deep_link_room_id"));
                aVar.w(optJSONObject.optString("reawrd_live_short_touch_params"));
                aVar.u(optJSONObject.optString("reawrd_live_extra_pangle_scheme_params"));
                aVar.xj(optJSONObject.optLong("reward_live_last_time"));
                wsVar.xj(aVar);
            } else {
                Map<String, String> xj = b.xj(yt.hf());
                if (xj == null || xj.size() <= 0) {
                    return;
                }
                aVar.xj(xj.get("user_id"));
                aVar.kd(xj.get(PointParamKey.REQUEST_ID));
                aVar.hf(xj.get("room_id"));
                aVar.w(xj.get("live_short_touch_params"));
                aVar.u(xj.get("extra_pangle_scheme_params"));
                wsVar.xj(aVar);
            }
            wsVar.tf(jSONObject.optBoolean("not_valid_download_url", false));
        }
    }

    private static wa xj(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return null;
        }
        wa waVar = new wa();
        double optDouble = jSONObject.optDouble("splash_clickarea", 1.0d);
        waVar.xj((int) ((optDouble == 1.0d || optDouble == 2.0d) ? optDouble : 1.0d));
        waVar.c(jSONObject.optInt("splash_style_id", 0));
        waVar.xj(jSONObject.optString("splash_clicktext", ""));
        waVar.hf(jSONObject.optInt("area_height", 50));
        waVar.w(jSONObject.optInt("area_width", 236));
        if (i == 2) {
            waVar.u(jSONObject.optInt("area_blank_height", 32));
        } else {
            waVar.u(jSONObject.optInt("area_blank_height", 82));
        }
        waVar.kd(jSONObject.optInt("half_blank_height", 56));
        waVar.hf(jSONObject.optString("btn_background_dest_color", "#008DEA"));
        waVar.w(jSONObject.optString("top_splash_clicktext"));
        waVar.xj(jSONObject.optJSONObject("text_config"));
        waVar.hf(jSONObject.optJSONObject("top_text_config"));
        waVar.f(jSONObject.optInt("sliding_distance", 5));
        waVar.xj(jSONObject.optJSONObject("slide_area"), i);
        waVar.y(jSONObject.optInt("splash_load_time_optimization"));
        JSONObject optJSONObject = jSONObject.optJSONObject("mock_interact");
        if (optJSONObject != null) {
            try {
                waVar.xj((float) optJSONObject.optDouble("enable_ratio", 0.0d));
                waVar.d(optJSONObject.optInt("backup_add", 0));
                waVar.tf(optJSONObject.optInt("slide_direction", 0));
                waVar.p(optJSONObject.optInt("slide_threshold", 55));
                waVar.pl(optJSONObject.optInt("view_height_dynamic", 0));
                waVar.hf((float) optJSONObject.optDouble("view_height_percent", 0.0d));
                waVar.g(optJSONObject.optInt("view_post", 100));
                waVar.am(optJSONObject.optInt("ignore_up", 0));
                waVar.qt(optJSONObject.optInt("long_press_duration", 0));
                waVar.zg(optJSONObject.optInt("long_press_threshold", 10));
                return waVar;
            } catch (Exception unused) {
                com.bytedance.sdk.component.utils.pl.u("SplashControl", "interact parse error");
            }
        }
        return waVar;
    }

    public static int xj(ws wsVar, int i) {
        if (TextUtils.isEmpty(wsVar.ho()) || wsVar.ho().length() <= 1) {
            return 401;
        }
        int xj = xj(wsVar.yt());
        if (xj != 200) {
            return xj;
        }
        int xj2 = xj(wsVar);
        if (xj2 != 200) {
            return xj2;
        }
        int vw = wsVar.vw();
        if (vw == 2 || vw == 3) {
            if (TextUtils.isEmpty(wsVar.ol())) {
                return 405;
            }
        } else if (vw != 4) {
            if (vw == 5 && TextUtils.isEmpty(wsVar.ah())) {
                return TTAdConstant.INTERACTION_TYPE_CODE;
            }
        } else {
            xj2 = xj(wsVar.vh());
            if (xj2 != 200) {
                return xj2;
            }
        }
        int rx = wsVar.rx();
        if (rx != 2 && rx != 3 && rx != 4) {
            if (rx == 5 || rx == 15) {
                return h.d(wsVar);
            }
            if (rx != 16) {
                return rx != 166 ? xj2 : hf(wsVar, i);
            }
        }
        return hf(wsVar.lx());
    }

    private static int xj(ws wsVar) {
        if (wsVar.rx() != 166 || !wo.xj(wsVar) || ai.u()) {
            return 200;
        }
        com.bytedance.sdk.component.utils.pl.w("穿山甲sdk没有集成点播/直播aar，不支持直播物料");
        return 404;
    }

    private static int xj(com.bytedance.sdk.openadsdk.core.ra.zg zgVar) {
        if (zgVar == null) {
            return 200;
        }
        if (!TextUtils.isEmpty(zgVar.hf()) && !TextUtils.isEmpty(zgVar.u())) {
            return (zgVar.kd() == 1 || zgVar.kd() == 2) ? 200 : 403;
        }
        if (TextUtils.isEmpty(zgVar.hf())) {
            return 402;
        }
        return TTAdConstant.DEEPLINK_FALL_BACK_CODE;
    }

    private static int xj(com.bytedance.sdk.openadsdk.core.ra.kd kdVar) {
        if (kdVar == null) {
            return 406;
        }
        return TextUtils.isEmpty(kdVar.hf()) ? 407 : 200;
    }

    public static void xj(List<ws> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        List<ws> subList = list.subList(1, list.size());
        JSONArray jSONArray = new JSONArray();
        Iterator<ws> it = subList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().ac());
        }
        if (jSONArray.length() > 0) {
            list.get(0).wo(jSONArray.toString());
        }
    }
}
