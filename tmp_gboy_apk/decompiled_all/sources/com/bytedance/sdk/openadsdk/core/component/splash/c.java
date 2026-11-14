package com.bytedance.sdk.openadsdk.core.component.splash;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.am;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.qd;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class c {
    public static boolean hf(com.bytedance.sdk.openadsdk.core.ra.xj xjVar) {
        return (xjVar == null || xjVar.hf() == null || xjVar.hf().isEmpty() || xjVar.hf().get(0) == null) ? false : true;
    }

    public static int w(com.bytedance.sdk.openadsdk.core.ra.xj xjVar) {
        if (xjVar != null) {
            return xjVar.xj();
        }
        return 0;
    }

    public static void xj(long j, boolean z, boolean z2, ws wsVar, long j2, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        String str2 = z ? z2 ? "load_video_success" : "load_video_error" : z2 ? "download_video_image_success" : "download_video_image_fail";
        if (z) {
            Map<String, Object> xj = wo.xj(z2, wsVar, elapsedRealtime, j2, str);
            xj.put("splash_show_type", 1);
            com.bytedance.sdk.openadsdk.core.am.u.kd(wsVar, "splash_ad", str2, xj);
        } else {
            Map<String, Object> hf = wo.hf(z2, wsVar, elapsedRealtime, j2, str);
            hf.put("splash_show_type", 2);
            com.bytedance.sdk.openadsdk.core.am.u.u(wsVar, "splash_ad", str2, hf);
        }
    }

    public static boolean hf(ws wsVar) {
        if (wsVar == null || wsVar.ss() == 1 || h.am(wsVar) == null || TextUtils.isEmpty(h.xj(wsVar))) {
            return true;
        }
        wsVar.d(true);
        return false;
    }

    public static void xj(com.bytedance.sdk.openadsdk.core.ra.xj xjVar) {
        com.bykv.vk.openvk.component.video.api.w.u xj;
        if (hf(xjVar)) {
            ws wsVar = xjVar.hf().get(0);
            int d = wo.d(wsVar);
            com.bykv.vk.openvk.component.video.api.w.w am = h.am(wsVar);
            if (am != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                String pl2 = am.pl();
                if (TextUtils.isEmpty(pl2)) {
                    xj(elapsedRealtime, true, false, wsVar, -1L, "preLoadVideo videoUrl is null");
                    return;
                }
                if (TextUtils.isEmpty(am.qt())) {
                    com.bytedance.sdk.component.utils.kd.hf(pl2);
                }
                if (wsVar.qe()) {
                    xj = h.xj(2, wsVar);
                } else {
                    xj = h.xj(3, wsVar);
                }
                xj.xj("material_meta", wsVar);
                if (!pz.hf().f(String.valueOf(d)) || am.u(pz.getContext())) {
                    am.kd(0);
                    com.bykv.vk.openvk.component.video.xj.xj.xj();
                    com.bytedance.sdk.openadsdk.core.video.u.hf.xj(xj, new com.bykv.vk.openvk.component.video.api.kd.hf() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.c.1
                        @Override // com.bykv.vk.openvk.component.video.api.kd.xj.InterfaceC0012xj
                        public void xj(com.bykv.vk.openvk.component.video.api.w.u uVar, int i) {
                        }

                        @Override // com.bykv.vk.openvk.component.video.api.kd.xj.InterfaceC0012xj
                        public void xj(com.bykv.vk.openvk.component.video.api.w.u uVar, int i, String str) {
                        }
                    });
                }
            }
        }
    }

    public static int xj(qd qdVar) {
        if (qdVar == null) {
            return 0;
        }
        int w = w(qdVar.hf());
        return w <= 0 ? xj(qdVar.xj()) : w;
    }

    public static int xj(ws wsVar) {
        if (wsVar != null) {
            return wo.d(wsVar);
        }
        return 0;
    }
}
