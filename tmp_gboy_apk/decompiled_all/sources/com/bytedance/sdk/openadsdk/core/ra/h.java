package com.bytedance.sdk.openadsdk.core.ra;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class h {
    private com.bykv.vk.openvk.component.video.api.w.w hf;
    private com.bykv.vk.openvk.component.video.api.w.xj w;
    private com.bykv.vk.openvk.component.video.api.w.w xj;

    public h() {
    }

    public static com.bykv.vk.openvk.component.video.api.w.w am(ws wsVar) {
        h yo = yo(wsVar);
        if (yo == null) {
            return null;
        }
        com.bykv.vk.openvk.component.video.api.w.w wVar = yo.xj;
        if (wVar != null) {
            return wVar;
        }
        if (com.bytedance.sdk.openadsdk.x.tf.xj(wsVar) && hl.hf(wsVar) == 3) {
            return wVar;
        }
        if (!com.bytedance.sdk.openadsdk.x.tf.xj(wsVar)) {
            return yo.xj;
        }
        com.bykv.vk.openvk.component.video.api.w.w wVar2 = new com.bykv.vk.openvk.component.video.api.w.w();
        if (com.bytedance.sdk.openadsdk.x.tf.xj(wsVar)) {
            wVar2.w(yo.w.kd());
            wVar2.kd(0);
            wVar2.u(0);
            wVar2.kd(yo.w.hf());
            wVar2.xj(yo.w.w());
            wVar2.xj(yo.w.y() * (yo.w.c() + 1));
        }
        yo.xj = wVar2;
        return wVar2;
    }

    public static String c(ws wsVar) {
        h yo = yo(wsVar);
        return yo == null ? "" : com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar) ? com.bykv.vk.openvk.component.video.api.y.hf.xj(wo.c(wsVar)) : com.bytedance.sdk.openadsdk.x.tf.xj(wsVar) ? zg(wsVar).hf() : yo.xj.qt();
    }

    public static int d(ws wsVar) {
        if (yo(wsVar) == null) {
            return TTAdConstant.VIDEO_INFO_CODE;
        }
        if (TextUtils.isEmpty(xj(wsVar))) {
            return TTAdConstant.VIDEO_URL_CODE;
        }
        if (TextUtils.isEmpty(hf(wsVar))) {
            return TTAdConstant.VIDEO_COVER_URL_CODE;
        }
        return 200;
    }

    public static com.bykv.vk.openvk.component.video.api.w.u e(ws wsVar) {
        h nt;
        com.bykv.vk.openvk.component.video.api.w.u xj = xj(4, wsVar);
        xj.xj(true);
        if (wsVar != null && (nt = wsVar.nt()) != null) {
            com.bykv.vk.openvk.component.video.api.w.w et = xj.et();
            com.bykv.vk.openvk.component.video.api.w.xj xjVar = nt.w;
            if (xjVar != null && et != null) {
                et.w(xjVar.kd());
                et.kd(0);
                et.u(0);
                et.kd(nt.w.hf());
                et.xj(nt.w.w());
                et.hf(nt.w.u());
                et.xj(nt.w.y() * (nt.w.c() + 1));
            }
        }
        return xj;
    }

    public static String f(ws wsVar) {
        com.bykv.vk.openvk.component.video.api.w.w wVar;
        h yo = yo(wsVar);
        return (yo == null || (wVar = yo.xj) == null) ? "" : wVar.g();
    }

    public static com.bykv.vk.openvk.component.video.api.w.w g(ws wsVar) {
        return xj(wsVar, 0);
    }

    public static String hf(ws wsVar) {
        h yo = yo(wsVar);
        if (yo == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar)) {
            return wo.f(wsVar);
        }
        com.bykv.vk.openvk.component.video.api.w.w wVar = yo.xj;
        return wVar == null ? "" : wVar.p();
    }

    public static int[] kd(ws wsVar) {
        com.bykv.vk.openvk.component.video.api.w.w qt;
        if (wsVar == null) {
            return null;
        }
        if (wsVar.rx() == 166 && wo.xj(wsVar)) {
            return new int[]{wo.pl(wsVar), wo.g(wsVar)};
        }
        if (wsVar.ul() == 1 && wsVar.ic() == 1 && (qt = qt(wsVar)) != null) {
            return qt.tf();
        }
        com.bykv.vk.openvk.component.video.api.w.w am = am(wsVar);
        if (am != null) {
            return am.tf();
        }
        return null;
    }

    public static boolean p(ws wsVar) {
        h yo = yo(wsVar);
        return (yo == null || yo.w == null) ? false : true;
    }

    public static boolean pl(ws wsVar) {
        h yo = yo(wsVar);
        if (yo == null) {
            return false;
        }
        return yo.xj.ht();
    }

    public static com.bykv.vk.openvk.component.video.api.w.w qt(ws wsVar) {
        h yo = yo(wsVar);
        if (yo == null) {
            return null;
        }
        return yo.hf;
    }

    public static boolean tf(ws wsVar) {
        com.bykv.vk.openvk.component.video.api.w.w wVar;
        h yo = yo(wsVar);
        return (yo == null || (wVar = yo.xj) == null || wVar.xj() != 1) ? false : true;
    }

    public static int u(ws wsVar) {
        com.bykv.vk.openvk.component.video.api.w.w wVar;
        h yo = yo(wsVar);
        if (yo == null || (wVar = yo.xj) == null) {
            return 0;
        }
        return wVar.w();
    }

    public static int w(ws wsVar) {
        com.bykv.vk.openvk.component.video.api.w.w wVar;
        h yo = yo(wsVar);
        if (yo == null || (wVar = yo.xj) == null) {
            return 0;
        }
        return wVar.hf();
    }

    public static double y(ws wsVar) {
        h yo = yo(wsVar);
        if (yo == null) {
            return 0.0d;
        }
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar)) {
            int hf = wo.hf(wsVar);
            com.bytedance.sdk.openadsdk.zg.w.w.hf gh = wsVar.gh();
            if (gh != null && gh.jk() == 9) {
                hf *= 2;
            }
            return hf;
        }
        if (com.bytedance.sdk.openadsdk.x.tf.xj(wsVar)) {
            return (zg(wsVar).c() + 1) * ((int) zg(wsVar).y());
        }
        com.bykv.vk.openvk.component.video.api.w.w wVar = yo.xj;
        if (wVar == null) {
            return 0.0d;
        }
        return wVar.y();
    }

    private static h yo(ws wsVar) {
        if (wsVar == null) {
            return null;
        }
        return wsVar.nt();
    }

    public static com.bykv.vk.openvk.component.video.api.w.xj zg(ws wsVar) {
        h yo = yo(wsVar);
        if (yo == null) {
            return null;
        }
        return yo.w;
    }

    public void xj(JSONObject jSONObject) {
        try {
            com.bykv.vk.openvk.component.video.api.w.w wVar = this.xj;
            if (wVar != null) {
                jSONObject.put("video", wVar.v());
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.pl.xj(e);
        }
        try {
            com.bykv.vk.openvk.component.video.api.w.w wVar2 = this.hf;
            if (wVar2 != null) {
                jSONObject.put("h265_video", wVar2.v());
            }
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.pl.xj(e2);
        }
        try {
            com.bykv.vk.openvk.component.video.api.w.xj xjVar = this.w;
            if (xjVar != null) {
                jSONObject.put(MediaFormat.KEY_AUDIO, xjVar.xj());
            }
        } catch (JSONException e3) {
            com.bytedance.sdk.component.utils.pl.xj(e3);
        }
    }

    public h(JSONObject jSONObject) {
        h hVar;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        JSONObject optJSONObject = jSONObject.optJSONObject("video");
        if (optJSONObject != null) {
            com.bykv.vk.openvk.component.video.api.w.w wVar = new com.bykv.vk.openvk.component.video.api.w.w();
            wVar.hf(optJSONObject.optInt("cover_height"));
            wVar.w(optJSONObject.optInt("cover_width"));
            wVar.xj(optJSONObject.optString("resolution"));
            str4 = "cover_width";
            wVar.xj(optJSONObject.optLong("size"));
            wVar.xj(optJSONObject.optDouble("video_duration"));
            wVar.hf(optJSONObject.optString("cover_url"));
            wVar.w(optJSONObject.optString("video_url"));
            wVar.u(optJSONObject.optString("endcard"));
            wVar.kd(optJSONObject.optString("file_hash"));
            str = "endcard";
            str2 = "video_url";
            wVar.xj((float) optJSONObject.optDouble("play_speed_ratio", -1.0d));
            wVar.xj(optJSONObject.optInt("fallback_endcard_judge", 0));
            wVar.u(optJSONObject.optInt("video_preload_size", 307200));
            str5 = "reward_video_cached_type";
            wVar.kd(optJSONObject.optInt(str5, 0));
            wVar.y(optJSONObject.optInt("execute_cached_type", 0));
            str3 = "resolution";
            wVar.hf(optJSONObject.optDouble("start", -1.0d));
            hVar = this;
            hVar.xj = wVar;
        } else {
            hVar = this;
            str = "endcard";
            str2 = "video_url";
            str3 = "resolution";
            str4 = "cover_width";
            str5 = "reward_video_cached_type";
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("h265_video");
        if (optJSONObject2 != null) {
            com.bykv.vk.openvk.component.video.api.w.w wVar2 = new com.bykv.vk.openvk.component.video.api.w.w();
            wVar2.hf(optJSONObject2.optInt("cover_height"));
            wVar2.w(optJSONObject2.optInt(str4));
            wVar2.xj(optJSONObject2.optString(str3));
            wVar2.xj(optJSONObject2.optLong("size"));
            wVar2.xj(optJSONObject2.optDouble("video_duration"));
            wVar2.hf(optJSONObject2.optString("cover_url"));
            wVar2.w(optJSONObject2.optString(str2));
            wVar2.u(optJSONObject2.optString(str));
            wVar2.kd(optJSONObject2.optString("file_hash"));
            wVar2.xj((float) optJSONObject2.optDouble("play_speed_ratio", -1.0d));
            wVar2.xj(optJSONObject2.optInt("fallback_endcard_judge", 0));
            wVar2.u(optJSONObject2.optInt("video_preload_size", 307200));
            wVar2.kd(optJSONObject2.optInt(str5, 0));
            wVar2.y(optJSONObject2.optInt("execute_cached_type", 0));
            wVar2.hf(optJSONObject2.optDouble("start", -1.0d));
            hVar.hf = wVar2;
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject(MediaFormat.KEY_AUDIO);
        if (optJSONObject3 != null) {
            com.bykv.vk.openvk.component.video.api.w.xj xjVar = new com.bykv.vk.openvk.component.video.api.w.xj();
            xjVar.hf(optJSONObject3.optString("audio_url"));
            xjVar.xj(optJSONObject3.optInt("reward_audio_cached_type", Integer.MIN_VALUE));
            xjVar.hf(optJSONObject3.optLong("audio_preload_size", -2147483648L));
            xjVar.xj(optJSONObject3.optLong("size", -2147483648L));
            xjVar.xj(optJSONObject3.optString("file_hash"));
            xjVar.hf(optJSONObject3.optDouble("audio_duration", -2.147483648E9d));
            xjVar.xj(optJSONObject3.optDouble("start", -1.0d));
            xjVar.hf(optJSONObject3.optInt("repeat_count", 0));
            hVar.w = xjVar;
        }
    }

    public void xj(com.bykv.vk.openvk.component.video.api.w.w wVar) {
        this.xj = wVar;
    }

    public static String xj(ws wsVar) {
        h yo = yo(wsVar);
        if (yo == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar)) {
            return wo.c(wsVar);
        }
        if (com.bytedance.sdk.openadsdk.x.tf.xj(wsVar)) {
            return zg(wsVar).kd();
        }
        com.bykv.vk.openvk.component.video.api.w.w wVar = yo.xj;
        if (wVar == null) {
            return "";
        }
        return wVar.pl();
    }

    public static com.bykv.vk.openvk.component.video.api.w.w xj(ws wsVar, int i) {
        h yo = yo(wsVar);
        if (yo == null) {
            return null;
        }
        com.bykv.vk.openvk.component.video.api.w.w wVar = new com.bykv.vk.openvk.component.video.api.w.w();
        com.bykv.vk.openvk.component.video.api.w.w wVar2 = yo.xj;
        if (wVar2 != null) {
            wVar.hf(wVar2.hf());
            wVar.w(yo.xj.w());
            wVar.xj(yo.xj.d());
            wVar.xj(yo.xj.kd());
            wVar.xj(yo.xj.y());
            wVar.hf(yo.xj.p());
            wVar.w(yo.xj.pl());
            wVar.u(yo.xj.g());
            wVar.kd(yo.xj.qt());
            wVar.xj(yo.xj.xj());
            wVar.u(yo.xj.zg());
            wVar.kd(yo.xj.e());
            wVar.y(yo.xj.yo());
            wVar.xj(yo.xj.f());
            wVar.hf(yo.xj.c());
        }
        if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar)) {
            wVar.hf(wo.f(wsVar));
            wVar.w(wo.c(wsVar));
            wVar.kd(com.bykv.vk.openvk.component.video.api.y.hf.xj(wo.c(wsVar)));
            wVar.xj(-1L);
            wVar.xj(wo.hf(wsVar));
            wVar.u(0);
            wVar.kd(1);
        }
        if (com.bytedance.sdk.openadsdk.x.tf.xj(wsVar)) {
            wVar.w(yo.w.kd());
            wVar.kd(0);
            wVar.u(0);
            wVar.kd(yo.w.hf());
            wVar.xj(yo.w.w());
            wVar.hf(yo.w.u());
            wVar.xj(yo.w.y() * (yo.w.c() + 1));
        }
        return wVar;
    }

    public static com.bykv.vk.openvk.component.video.api.w.u xj(int i, ws wsVar, int i2) {
        String xj;
        if (wsVar.ul() == 1 && !com.bytedance.sdk.openadsdk.core.ai.u()) {
            wsVar.dc(0);
        }
        if (com.bytedance.sdk.openadsdk.x.tf.xj(wsVar)) {
            wsVar.dc(0);
        }
        if (i == 1) {
            xj = com.bytedance.sdk.openadsdk.x.d.xj(wsVar.ul()).xj();
        } else if (i == 2) {
            xj = com.bytedance.sdk.openadsdk.x.d.xj(wsVar.ul()).hf();
        } else if (i == 3) {
            xj = com.bytedance.sdk.openadsdk.x.d.xj(wsVar.ul()).w();
        } else if (i != 4) {
            xj = "";
        } else {
            xj = com.bytedance.sdk.openadsdk.x.d.xj(wsVar.ul()).u();
        }
        com.bykv.vk.openvk.component.video.api.w.u uVar = new com.bykv.vk.openvk.component.video.api.w.u(xj, xj(wsVar, i2), qt(wsVar), wsVar.ul(), wsVar.ic());
        uVar.xj(wsVar.rh());
        return uVar;
    }

    public static com.bykv.vk.openvk.component.video.api.w.u xj(int i, ws wsVar) {
        return xj(i, wsVar, 0);
    }
}
