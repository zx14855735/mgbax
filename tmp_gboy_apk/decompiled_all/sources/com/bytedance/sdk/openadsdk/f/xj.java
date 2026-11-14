package com.bytedance.sdk.openadsdk.f;

import android.content.Context;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.pl;
import com.bytedance.sdk.component.hf.xj.zg;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.y.hf.u;
import com.bytedance.sdk.component.y.ht;
import com.bytedance.sdk.component.y.v;
import com.bytedance.sdk.component.y.w.kd;
import com.bytedance.sdk.component.y.y;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.x.d;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public static Context getContext() {
        return pz.getContext();
    }

    public static ht xj(Context context, v vVar) {
        return com.bytedance.sdk.component.y.w.hf.xj(context, vVar);
    }

    public static v xj() {
        return new kd.xj().xj(new com.bytedance.sdk.component.y.w.xj.xj(Math.max(Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 10485760), AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE), 0, 41943040L, true, true, new File(d.y()))).xj(c.xj()).xj(new com.bytedance.sdk.component.y.kd() { // from class: com.bytedance.sdk.openadsdk.f.xj.1
            private Map<String, String> xj(y yVar, zg zgVar) {
                HashMap hashMap = new HashMap();
                if (yVar.hf()) {
                    com.bytedance.sdk.component.hf.xj.y c = zgVar.c();
                    int xj = c.xj();
                    for (int i = 0; i < xj; i++) {
                        String xj2 = c.xj(i);
                        String hf = c.hf(i);
                        if (xj2 != null) {
                            hashMap.put(xj2, hf);
                        }
                    }
                }
                return hashMap;
            }

            @Override // com.bytedance.sdk.component.y.kd
            public u call(y yVar) {
                long currentTimeMillis = System.currentTimeMillis();
                pl y = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().y();
                am hf = new am.xj().xj(yVar.xj()).xj().xj("csj_client_source_from", "2").hf();
                zg zgVar = null;
                com.bytedance.sdk.component.y.hf.kd kdVar = yVar.w() ? new com.bytedance.sdk.component.y.hf.kd() : null;
                if (kdVar != null) {
                    kdVar.xj(currentTimeMillis);
                }
                try {
                    zg hf2 = y.xj(hf).hf();
                    if (kdVar != null) {
                        try {
                            kdVar.hf(System.currentTimeMillis());
                        } catch (Throwable th) {
                            th = th;
                            zgVar = hf2;
                            try {
                                return xj(kdVar, th);
                            } finally {
                                com.bytedance.sdk.component.y.w.w.hf.xj(zgVar);
                            }
                        }
                    }
                    if (yVar.u() != null) {
                        yVar.u().onStep(3, null);
                    }
                    Map<String, String> xj = xj(yVar, hf2);
                    byte[] u = hf2.y().u();
                    xj.put("image_size", String.valueOf(u == null ? 0 : u.length));
                    u uVar = new u(hf2.w(), u, "", xj);
                    if (kdVar != null) {
                        kdVar.w(System.currentTimeMillis());
                    }
                    uVar.xj(kdVar);
                    com.bytedance.sdk.component.y.w.w.hf.xj(hf2);
                    return uVar;
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            private u xj(com.bytedance.sdk.component.y.hf.kd kdVar, Throwable th) {
                com.bytedance.sdk.component.utils.pl.hf("ImageConfig", th.getMessage());
                if (kdVar != null) {
                    kdVar.w(System.currentTimeMillis());
                }
                u uVar = new u(0, th, "net failed");
                uVar.xj(kdVar);
                return uVar;
            }
        }).xj();
    }
}
