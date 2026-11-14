package com.bytedance.sdk.openadsdk.core.video.u;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cb;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.component.video.api.kd.xj;
import com.bykv.vk.openvk.component.video.api.w.u;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.en;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.x.am;
import com.bytedance.sdk.openadsdk.core.x.d;
import com.bytedance.sdk.openadsdk.core.x.f;
import com.bytedance.sdk.openadsdk.core.x.p;
import com.bytedance.sdk.openadsdk.core.x.w;
import com.bytedance.sdk.openadsdk.x.c;
import com.bytedance.sdk.openadsdk.y.w.g;
import com.bytedance.sdk.openadsdk.y.w.tf;
import com.qq.e.comm.constants.ErrorCode;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private static volatile com.bykv.vk.openvk.component.video.api.kd.xj hf;
    private static volatile com.bykv.vk.openvk.component.video.api.kd.xj xj;

    private static boolean hf(int i) {
        return i == 8 || i == 7;
    }

    private static void u(final u uVar, final xj.InterfaceC0012xj interfaceC0012xj, final ws wsVar) {
        uVar.y(ErrorCode.UNKNOWN_ERROR);
        uVar.c(ErrorCode.UNKNOWN_ERROR);
        uVar.f(ErrorCode.UNKNOWN_ERROR);
        if (wsVar != null) {
            if (com.bytedance.sdk.openadsdk.core.video.w.xj.xj(wsVar)) {
                return;
            }
            if (uVar.w() == 400) {
                w(uVar, wsVar);
                return;
            }
            hf(uVar, wsVar);
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        xj.InterfaceC0012xj interfaceC0012xj2 = new xj.InterfaceC0012xj() { // from class: com.bytedance.sdk.openadsdk.core.video.u.hf.3
            @Override // com.bykv.vk.openvk.component.video.api.kd.xj.InterfaceC0012xj
            public void hf(u uVar2, int i) {
                xj.InterfaceC0012xj interfaceC0012xj3 = xj.InterfaceC0012xj.this;
                if (interfaceC0012xj3 != null) {
                    interfaceC0012xj3.xj(uVar2, i);
                }
                ws wsVar2 = wsVar;
                if (wsVar2 != null) {
                    hf.w(uVar, wsVar2);
                }
                pl.xj("VideoPreloadUtils", "pit cancel: ", uVar.e());
            }

            @Override // com.bykv.vk.openvk.component.video.api.kd.xj.InterfaceC0012xj
            public void xj(u uVar2, int i) {
                xj.InterfaceC0012xj interfaceC0012xj3 = xj.InterfaceC0012xj.this;
                if (interfaceC0012xj3 != null) {
                    interfaceC0012xj3.xj(uVar2, i);
                }
                if (wsVar != null) {
                    hf.xj(uVar, wsVar, SystemClock.elapsedRealtime() - elapsedRealtime);
                }
                pl.xj("VideoPreloadUtils", "pit onVideoPreloadSuccess: ", uVar.e());
            }

            @Override // com.bykv.vk.openvk.component.video.api.kd.xj.InterfaceC0012xj
            public void xj(u uVar2, int i, String str) {
                xj.InterfaceC0012xj interfaceC0012xj3 = xj.InterfaceC0012xj.this;
                if (interfaceC0012xj3 != null) {
                    interfaceC0012xj3.xj(uVar2, i, str);
                }
                if (wsVar != null) {
                    hf.hf(uVar, wsVar, SystemClock.elapsedRealtime() - elapsedRealtime, i, str);
                }
                pl.xj("VideoPreloadUtils", "pit onVideoPreloadFail: ", uVar.e());
            }
        };
        try {
            if (uVar.yo() != 0 || Build.VERSION.SDK_INT >= 23) {
                hf(uVar).xj(pz.getContext(), uVar, interfaceC0012xj2);
            } else {
                com.bykv.vk.openvk.component.video.xj.hf.y.xj.xj().xj(uVar);
            }
        } catch (Exception e) {
            if (interfaceC0012xj != null) {
                pl.xj("VideoPreloadUtils", "pit exception onVideoPreloadFail: ", uVar.e());
                interfaceC0012xj.xj(uVar, -1, e.getMessage());
            }
            if (wsVar != null) {
                hf(uVar, wsVar, SystemClock.elapsedRealtime() - elapsedRealtime, -1, e.getMessage());
            }
            pl.xj(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(final u uVar, final xj.InterfaceC0012xj interfaceC0012xj, final ws wsVar) {
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            int f = wsVar != null ? wo.f(wsVar) : 0;
            boolean xj2 = p.xj();
            if (!hf(f) || !xj2) {
                xj(uVar, interfaceC0012xj, wsVar, currentTimeMillis, xj2);
                return;
            }
            if (pz.xj(AVMDLDataLoader.KeyIsStoRingBufferSizeKB) == null) {
                xj(uVar, interfaceC0012xj, wsVar, currentTimeMillis, xj2);
                return;
            }
            w wVar = (w) com.bytedance.sdk.openadsdk.ats.w.xj("pitaya");
            if (wVar == null || !wVar.isPitayaInitSuccess()) {
                xj(uVar, -1000, -8, "not init", (JSONObject) null, System.currentTimeMillis() - currentTimeMillis);
                u(uVar, interfaceC0012xj, wsVar);
            } else {
                final JSONObject xj3 = new am().xj(uVar);
                wVar.runTask("video_cache", xj3, new f() { // from class: com.bytedance.sdk.openadsdk.core.video.u.hf.2
                    @Override // com.bytedance.sdk.openadsdk.core.x.f
                    public PluginValueSet xj(int i, d dVar) {
                        com.bytedance.sdk.openadsdk.core.ht.am.xj();
                        com.bytedance.sdk.openadsdk.core.ht.am.xj(dVar == null ? null : dVar.u(), xj3);
                        return hf.hf(i, dVar, uVar, interfaceC0012xj, currentTimeMillis, wsVar);
                    }
                });
            }
        } catch (Exception e) {
            pl.w("pit predict error:" + e.getMessage());
        }
    }

    private static boolean xj(int i) {
        return i == 3 || i == 4;
    }

    private static com.bykv.vk.openvk.component.video.api.kd.xj hf(u uVar) {
        if (uVar.yo() == 1) {
            if (hf == null) {
                synchronized (hf.class) {
                    try {
                        if (hf == null) {
                            hf = new com.bytedance.sdk.component.pl.hf.hf.xj();
                        }
                    } finally {
                    }
                }
            }
            return hf;
        }
        if (xj == null) {
            synchronized (hf.class) {
                try {
                    if (xj == null) {
                        xj = new com.bykv.vk.openvk.component.video.xj.xj.hf.xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public static void xj(final u uVar, final xj.InterfaceC0012xj interfaceC0012xj) {
        if (uVar == null) {
            hf(null, interfaceC0012xj, null);
            return;
        }
        uVar.zg();
        uVar.y();
        uVar.y();
        uVar.g();
        final ws xj2 = xj(uVar);
        if (uVar.y() <= 0 && !uVar.g()) {
            hf(uVar, interfaceC0012xj, xj2);
        } else if (c.xj()) {
            c.xj(new com.bytedance.sdk.component.tf.d("csj_vPreload") { // from class: com.bytedance.sdk.openadsdk.core.video.u.hf.1
                @Override // java.lang.Runnable
                public void run() {
                    hf.w(uVar, interfaceC0012xj, xj2);
                }
            });
        } else {
            w(uVar, interfaceC0012xj, xj2);
        }
    }

    private static void hf(u uVar, xj.InterfaceC0012xj interfaceC0012xj, ws wsVar) {
        if (interfaceC0012xj != null) {
            interfaceC0012xj.xj(uVar, -100);
        }
        if (wsVar != null) {
            if (hf(wo.f(wsVar)) || xj(wo.f(wsVar))) {
                xj(uVar, wsVar, 0L);
            }
        }
    }

    private static void xj(u uVar, xj.InterfaceC0012xj interfaceC0012xj, ws wsVar, long j, boolean z) {
        xj(uVar, -1000, z ? -6 : -9, "bridge is null", (JSONObject) null, System.currentTimeMillis() - j);
        u(uVar, interfaceC0012xj, wsVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PluginValueSet hf(int i, d dVar, u uVar, xj.InterfaceC0012xj interfaceC0012xj, long j, ws wsVar) {
        int i2;
        int i3;
        String str;
        try {
        } catch (Exception e) {
            e.getMessage();
        }
        if (dVar == null) {
            xj(uVar, -1000, -2, "resultModel is null", (JSONObject) null, System.currentTimeMillis() - j);
            u(uVar, interfaceC0012xj, wsVar);
            return null;
        }
        com.bytedance.sdk.openadsdk.zg.xj w = dVar.w();
        if (w == null) {
            xj(uVar, -1000, -3, "result is null", (JSONObject) null, System.currentTimeMillis() - j);
            u(uVar, interfaceC0012xj, wsVar);
            return null;
        }
        PluginValueSet u = w.u();
        if (u == null) {
            xj(uVar, -1000, -4, "value is null", (JSONObject) null, System.currentTimeMillis() - j);
            u(uVar, interfaceC0012xj, wsVar);
            return null;
        }
        JSONObject jSONObject = (JSONObject) u.objectValue(2, JSONObject.class);
        u.stringValue(5);
        JSONObject jSONObject2 = (JSONObject) u.objectValue(3, JSONObject.class);
        JSONObject jSONObject3 = (JSONObject) u.objectValue(4, JSONObject.class);
        if (!w.xj() || jSONObject == null) {
            i2 = -1000;
            i3 = -5;
            str = null;
        } else {
            i2 = jSONObject.optInt("pitaya_cache_size", -1);
            i3 = jSONObject.optInt("pitaya_code", 200);
            str = cb.o;
            am.xj(uVar, jSONObject, i2, i3);
        }
        if (!w.xj() && jSONObject3 != null) {
            str = jSONObject3.toString();
        }
        xj(uVar, i2, i3, str, jSONObject2, System.currentTimeMillis() - j);
        u(uVar, interfaceC0012xj, wsVar);
        return null;
    }

    private static boolean w(u uVar) {
        return Build.VERSION.SDK_INT >= 23 || uVar.yo() != 0;
    }

    private static void xj(u uVar, int i, int i2, String str, JSONObject jSONObject, long j) {
        JSONObject xj2 = uVar.xj();
        try {
            xj2.put("pitaya_cache_size", i);
            xj2.put("pitaya_code", i2);
            xj2.put("pitaya_msg", str);
            xj2.put("ext_plugin_code", en.hf());
            xj2.put("package", jSONObject);
            xj2.put("run_task_mills", j);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(u uVar, ws wsVar) {
        if (w(uVar)) {
            String hf2 = wo.hf(wsVar);
            JSONObject xj2 = com.bytedance.sdk.openadsdk.y.hf.u.xj(uVar, null, -1, uVar.yo(), wsVar, -1L);
            tf tfVar = new tf(uVar.zg(), uVar.y());
            tfVar.xj(uVar);
            com.bytedance.sdk.openadsdk.y.hf.u.u((com.bytedance.sdk.openadsdk.y.w.hf<tf>) new com.bytedance.sdk.openadsdk.y.w.hf(wsVar, hf2, xj2, tfVar));
        }
    }

    public static ws xj(u uVar) {
        if (uVar == null) {
            return null;
        }
        Object kd = uVar.kd("material_meta");
        if (kd instanceof ws) {
            return (ws) kd;
        }
        return null;
    }

    public static void xj(u uVar, ws wsVar, long j) {
        if (w(uVar)) {
            String hf2 = wo.hf(wsVar);
            JSONObject xj2 = com.bytedance.sdk.openadsdk.y.hf.u.xj(uVar, null, -1, uVar.yo(), wsVar, -1L);
            g gVar = new g();
            gVar.xj(uVar.zg());
            gVar.xj(uVar.y());
            gVar.hf(j);
            gVar.xj(uVar);
            if (uVar.ht() == 1) {
                gVar.w(1L);
            } else {
                gVar.w(0L);
            }
            com.bytedance.sdk.openadsdk.y.hf.u.hf((com.bytedance.sdk.openadsdk.y.w.hf<g>) new com.bytedance.sdk.openadsdk.y.w.hf(wsVar, hf2, xj2, gVar));
        }
    }

    private static void hf(u uVar, ws wsVar) {
        if (w(uVar)) {
            long pl2 = uVar.g() ? uVar.pl() : uVar.y();
            String hf2 = wo.hf(wsVar);
            JSONObject xj2 = com.bytedance.sdk.openadsdk.y.hf.u.xj(uVar, null, -1, uVar.yo(), wsVar, -1L);
            com.bytedance.sdk.openadsdk.y.w.pl plVar = new com.bytedance.sdk.openadsdk.y.w.pl(uVar.zg(), pl2);
            plVar.xj(uVar);
            com.bytedance.sdk.openadsdk.y.hf.u.xj((com.bytedance.sdk.openadsdk.y.w.hf<com.bytedance.sdk.openadsdk.y.w.pl>) new com.bytedance.sdk.openadsdk.y.w.hf(wsVar, hf2, xj2, plVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(u uVar, ws wsVar, long j, int i, String str) {
        if (w(uVar)) {
            String hf2 = wo.hf(wsVar);
            JSONObject xj2 = com.bytedance.sdk.openadsdk.y.hf.u.xj(uVar, null, -1, uVar.yo(), wsVar, -1L);
            com.bytedance.sdk.openadsdk.y.w.p pVar = new com.bytedance.sdk.openadsdk.y.w.p();
            pVar.xj(uVar.zg());
            pVar.xj(uVar.y());
            pVar.hf(j);
            pVar.xj(i);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            pVar.hf(str);
            pVar.w("");
            pVar.xj(uVar);
            com.bytedance.sdk.openadsdk.y.hf.u.w((com.bytedance.sdk.openadsdk.y.w.hf<com.bytedance.sdk.openadsdk.y.w.p>) new com.bytedance.sdk.openadsdk.y.w.hf(wsVar, hf2, xj2, pVar));
        }
    }
}
