package com.bytedance.sdk.openadsdk.core.et;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.dk;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.hl;
import com.bytedance.sdk.openadsdk.core.ra.tj;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.c;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {

    /* renamed from: com.bytedance.sdk.openadsdk.core.et.hf$hf, reason: collision with other inner class name */
    public interface InterfaceC0163hf {
        void xj();

        void xj(JSONObject jSONObject);
    }

    public interface xj {
        void xj(int i, String str);

        void xj(JSONObject jSONObject);
    }

    public static void xj(com.bytedance.sdk.openadsdk.core.ugeno.y.xj xjVar, InterfaceC0163hf interfaceC0163hf) {
        if (xjVar != null) {
            xj(xjVar.w(), xjVar.xj(), xjVar.hf(), interfaceC0163hf);
        } else if (interfaceC0163hf != null) {
            interfaceC0163hf.xj();
        }
    }

    public static void xj(String str, final String str2, final String str3, final InterfaceC0163hf interfaceC0163hf) {
        if (TextUtils.isEmpty(str)) {
            if (interfaceC0163hf != null) {
                interfaceC0163hf.xj();
            }
        } else {
            com.bytedance.sdk.component.d.hf.w w = kd.xj().hf().w();
            w.xj(str);
            w.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.et.hf.1
                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                    if (hfVar == null) {
                        return;
                    }
                    if (!hfVar.f()) {
                        InterfaceC0163hf interfaceC0163hf2 = interfaceC0163hf;
                        if (interfaceC0163hf2 != null) {
                            interfaceC0163hf2.xj();
                            return;
                        }
                        return;
                    }
                    String u = hfVar.u();
                    c.xj().xj(str2, str3, u);
                    if (interfaceC0163hf != null) {
                        try {
                            interfaceC0163hf.xj(new JSONObject(u));
                        } catch (JSONException e) {
                            pl.xj(e);
                            interfaceC0163hf.xj();
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.d.xj.xj
                public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                    InterfaceC0163hf interfaceC0163hf2 = interfaceC0163hf;
                    if (interfaceC0163hf2 != null) {
                        interfaceC0163hf2.xj();
                    }
                }
            });
        }
    }

    public static void xj(ws wsVar, JSONObject jSONObject, final com.bytedance.sdk.openadsdk.core.jk.w wVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        if (wVar == null) {
            return;
        }
        if (wsVar != null) {
            try {
                if (!TextUtils.isEmpty(wsVar.jf())) {
                    int f = wo.f(wsVar);
                    com.bytedance.sdk.openadsdk.zg.w.w.hf gh = wsVar.gh();
                    if (gh != null) {
                        hfVar = gh;
                    }
                    tj tjVar = new tj();
                    tjVar.u = 2;
                    if (hl.y(wsVar) != null) {
                        tjVar.y = 2;
                    }
                    JSONObject pn = wsVar.pn();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        Iterator<String> keys = pn.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject2.put(next, pn.opt(next));
                        }
                    } catch (JSONException e) {
                        pl.xj(e);
                    }
                    if (jSONObject != null) {
                        Iterator<String> keys2 = jSONObject.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            jSONObject2.put(next2, jSONObject.opt(next2));
                        }
                    }
                    tjVar.f10415pl = jSONObject2;
                    pz.xj().xj(hfVar, tjVar, f, new dk.hf() { // from class: com.bytedance.sdk.openadsdk.core.et.hf.2
                        @Override // com.bytedance.sdk.openadsdk.core.dk.hf
                        public void xj(int i, String str, com.bytedance.sdk.openadsdk.core.ra.hf hfVar2) {
                            com.bytedance.sdk.openadsdk.core.jk.w.this.xj(false, null, false);
                            hfVar2.xj(i);
                            com.bytedance.sdk.openadsdk.core.ra.hf.xj(hfVar2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.dk.hf
                        public void xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar, com.bytedance.sdk.openadsdk.core.ra.hf hfVar2) {
                            if (xjVar.hf() != null && !xjVar.hf().isEmpty()) {
                                com.bytedance.sdk.openadsdk.core.jk.w.this.xj(true, xjVar.hf(), false);
                                return;
                            }
                            com.bytedance.sdk.openadsdk.core.jk.w.this.xj(false, null, false);
                            hfVar2.xj(-3);
                            com.bytedance.sdk.openadsdk.core.ra.hf.xj(hfVar2);
                        }
                    });
                    return;
                }
            } catch (Exception e2) {
                pl.w("PageNetUtils", "get ads error", e2);
                return;
            }
        }
        wVar.xj(false, null, false);
    }

    public static void xj(String str, final xj xjVar) {
        com.bytedance.sdk.component.d.hf.w w = kd.xj().hf().w();
        w.xj(str);
        w.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.et.hf.3
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, com.bytedance.sdk.component.d.hf hfVar) {
                if (hfVar == null || !hfVar.f()) {
                    xj xjVar2 = xj.this;
                    if (xjVar2 == null || hfVar == null) {
                        return;
                    }
                    xjVar2.xj(hfVar.xj(), hfVar.hf());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(hfVar.u());
                    xj xjVar3 = xj.this;
                    if (xjVar3 != null) {
                        xjVar3.xj(jSONObject);
                    }
                } catch (JSONException e) {
                    pl.xj(e);
                }
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                xj xjVar2 = xj.this;
                if (xjVar2 != null) {
                    xjVar2.xj(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE, iOException.getMessage());
                }
            }
        });
    }
}
