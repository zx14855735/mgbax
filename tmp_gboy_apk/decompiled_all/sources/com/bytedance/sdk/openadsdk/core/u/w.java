package com.bytedance.sdk.openadsdk.core.u;

import com.bytedance.sdk.component.adexpress.kd.kd;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.dk;
import com.bytedance.sdk.openadsdk.core.a.p;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    /* JADX INFO: Access modifiers changed from: private */
    public static void unregisterReceiver() {
        p.kd();
        p.g();
    }

    public static void xj() {
        com.bytedance.sdk.component.u.xj hf;
        f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.w.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    pl.xj("lqmt", "isReuseService key: ILoaderCenter, value: " + com.bytedance.sdk.openadsdk.core.f.zg().d("img_service"));
                    if (!com.bytedance.sdk.openadsdk.core.f.zg().d("img_service")) {
                        com.bytedance.sdk.openadsdk.f.hf.xj().clearMemoryCache(0.0d);
                    }
                    w.unregisterReceiver();
                    kd.xj().hf();
                } catch (Throwable unused) {
                }
            }
        }, 20000L);
        pl.xj("lqmt", "isReuseService key: IArmorService, value: " + com.bytedance.sdk.openadsdk.core.f.zg().d("armor_service"));
        pl.xj("lqmt", "isReuseService key: IDeviceInfo, value: " + com.bytedance.sdk.openadsdk.core.f.zg().d("device_info"));
        if (com.bytedance.sdk.openadsdk.core.f.zg().d("device_info") || (hf = dk.hf()) == null) {
            return;
        }
        hf.pglArmorCallApiCancelListener();
    }
}
