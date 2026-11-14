package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.j;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.dk;
import com.bytedance.sdk.openadsdk.core.ra.v;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class tf {
    public static boolean c(ws wsVar) {
        return (wsVar == null || wsVar.io() != 1 || v.xj(wsVar)) ? false : true;
    }

    public static boolean d(ws wsVar) {
        return (wsVar == null || wsVar.wf() == null) ? false : true;
    }

    public static boolean f(ws wsVar) {
        return wsVar != null && wsVar.yo() > 0;
    }

    public static boolean hf(ws wsVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.d.xj ai;
        JSONObject w;
        return (wsVar == null || (ai = wsVar.ai()) == null || (w = ai.w()) == null || w.optInt("reward_slide_type", 0) != 1) ? false : true;
    }

    public static boolean kd(ws wsVar) {
        if (wsVar == null) {
            return false;
        }
        int io2 = wsVar.io();
        com.bytedance.sdk.openadsdk.core.ugeno.y.xj x = wsVar.x();
        return x != null && io2 == 1 && x.u() == 2;
    }

    public static boolean u(ws wsVar) {
        if (wsVar == null) {
            return false;
        }
        int io2 = wsVar.io();
        com.bytedance.sdk.openadsdk.core.ugeno.y.xj x = wsVar.x();
        return x != null && io2 == 1 && x.u() == 3;
    }

    public static boolean w(ws wsVar) {
        if (wsVar == null) {
            return false;
        }
        int io2 = wsVar.io();
        com.bytedance.sdk.openadsdk.core.ugeno.y.xj x = wsVar.x();
        return x != null && io2 == 1 && x.u() == 4;
    }

    public static boolean y(ws wsVar) {
        if (wsVar == null) {
            return false;
        }
        return c(wsVar) || f(wsVar);
    }

    public static int xj(ws wsVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.d.xj ai;
        JSONObject w;
        int optInt;
        if (wsVar == null || (ai = wsVar.ai()) == null || (w = ai.w()) == null || (optInt = w.optInt("pre_request_ad_num", 4)) <= 0) {
            return 4;
        }
        return optInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(final boolean z, final String str, final w wVar) {
        if (wVar != null) {
            com.bytedance.sdk.component.utils.f.hf().post(new com.bytedance.sdk.component.tf.d("tt_ugen_tpl") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.tf.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        wVar.xj(str);
                    } else {
                        wVar.xj();
                    }
                }
            });
        }
    }

    private static void hf(String str, final String str2, final w wVar) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            hf(false, (String) null, wVar);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        com.bytedance.sdk.component.d.hf.w w = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().w();
        if (w == null) {
            hf(false, (String) null, wVar);
        } else {
            w.xj(str);
            w.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.tf.2
                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                    if (hfVar != null) {
                        try {
                            if (hfVar.f() && hfVar.u() != null) {
                                com.bytedance.sdk.component.u.hf.w xj = j.xj("ugeno_template_kv");
                                String u = hfVar.u();
                                xj.put(str2, u);
                                tf.hf(true, u, wVar);
                                return;
                            }
                        } catch (Exception unused) {
                            tf.hf(false, (String) null, wVar);
                            return;
                        }
                    }
                    tf.hf(false, (String) null, wVar);
                }

                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                    tf.hf(false, (String) null, wVar);
                }
            });
        }
    }

    public static JSONObject xj(ws wsVar, View view, boolean z) {
        int i;
        JSONObject ac = wsVar.ac();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            com.bytedance.sdk.openadsdk.core.j.xj yo = pz.hf().yo(String.valueOf(wo.d(wsVar)));
            if (com.bytedance.sdk.openadsdk.core.component.reward.u.u.xj(wsVar) == 4) {
                i = yo.w;
            } else {
                i = yo.p;
            }
            if (wo.kd(wsVar)) {
                i = yo.w;
            }
            boolean z2 = false;
            jSONObject.put("voice_control", i == 1);
            Context context = pz.getContext();
            jSONObject3.put(MediaFormat.KEY_WIDTH, r.u(context, r.u(context)));
            jSONObject3.put(MediaFormat.KEY_HEIGHT, r.u(context, r.kd(context)));
            if (view != null) {
                int width = view.getWidth();
                int height = view.getHeight();
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(MediaFormat.KEY_WIDTH, r.u(context, width) * 1.0f);
                jSONObject4.put(MediaFormat.KEY_HEIGHT, r.u(context, height) * 1.0f);
                jSONObject2.put("content_size", jSONObject4);
            }
            jSONObject2.put("screen_size", jSONObject3);
            ac.put("env_info", jSONObject2);
            ac.put("setting", jSONObject);
            ac.put("meta_hashcode", wsVar.kd());
            if (z && pz.hf().zd()) {
                z2 = true;
            }
            ac.put("gesture_through_enable", z2);
            return ac;
        } catch (JSONException e) {
            pl.xj(e);
            return ac;
        }
    }

    public static int hf(Context context, ws wsVar, String str) {
        if (wsVar == null) {
            return -1;
        }
        dk wf = wsVar.wf();
        if (wf == null) {
            return -2;
        }
        if (TextUtils.isEmpty(str)) {
            return -3;
        }
        if (str.length() > 15) {
            return 4;
        }
        if (context != null && context.getResources().getConfiguration().orientation != 1) {
            return 9;
        }
        String hf = wf.hf();
        if (xj(hf, wf.w(), (w) null) == null) {
            return TextUtils.isEmpty(hf) ? 2 : 3;
        }
        return 1;
    }

    public static boolean xj(Context context, ws wsVar, String str) {
        return hf(context, wsVar, str) == 1;
    }

    public static String xj(Context context, String str, ws wsVar, String str2) {
        dk wf = wsVar.wf();
        JSONObject fs = wsVar.fs();
        if (str == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("icon_url", str2);
            }
            String uj = wsVar.uj();
            if (!TextUtils.isEmpty(uj)) {
                jSONObject.put("description", uj);
            }
            if (fs != null) {
                jSONObject.put("easy_pl_material", fs.toString());
            }
            if (wf != null) {
                jSONObject.put("ugen_dialog_url", wf.hf());
                jSONObject.put("ugen_dialog_md5", wf.w());
            }
            if (context != null) {
                if (context.getResources().getConfiguration().orientation == 1) {
                    jSONObject.put("vertical", "true");
                } else {
                    jSONObject.put("vertical", "false");
                }
            }
            return jSONObject.toString();
        } catch (Exception e) {
            pl.xj(e);
            return "";
        }
    }

    public static JSONObject xj(String str, String str2, w wVar) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            if (wVar != null) {
                wVar.xj();
            }
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = str;
        }
        com.bytedance.sdk.component.u.hf.w xj = j.xj("ugeno_template_kv");
        if (xj == null) {
            if (wVar != null) {
                wVar.xj();
            }
            return null;
        }
        try {
            str3 = xj.get(str2, "");
        } catch (Exception unused) {
            if (wVar != null) {
                wVar.xj();
            }
        }
        if (!TextUtils.isEmpty(str3)) {
            if (wVar != null) {
                wVar.xj(str3);
            }
            return new JSONObject(str3);
        }
        if (!TextUtils.isEmpty(str)) {
            hf(str, str2, wVar);
            return null;
        }
        if (wVar != null) {
            wVar.xj();
        }
        return null;
    }
}
